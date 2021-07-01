package com.example.ui.common

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.example.ui.*

class StepBar : LinearLayout {

    companion object {
        const val SPACE_BETWEEN: Int = 25
        const val NORMAL_WIDTH: Int = 14
        const val CURRENT_WIDTH: Int = 18
        const val CURRENT_STEP: Int = 0
        const val STEP_COUNT: Int = 3
        const val LINE_WIDTH: Int = 20
        const val LINE_HEIGHT: Int = 1
        const val CURRENT_TEXT_COLOR: Int = 0
        const val PASS_TEXT_COLOR: Int = 0
        const val NORMAL_TEXT_COLOR: Int = 0
        const val LINE_COLOR: Int = 0
        const val TEXT_SIZE: Int = 13
    }

    //TODO use documentation in view /** **/
    /**
     * для чего используюется - все на английском языке
     *
     * описываешь все константы mCurrentBackground - текущий фон круга ...
     * и удалить остальные
     */
    private var mCurrentBackground: Int = R.drawable.shape_current //текущий фон круга
    private var mPassedBackground: Int = R.drawable.shape_normal //фон пройденного круга
    private var mNormalBackground: Int = R.drawable.shape_failed //фон обычный
    private var mSpaceBetween = SPACE_BETWEEN //интвервал
    private var mNormalWidth = NORMAL_WIDTH //ширина обычная
    private var mCurrentWidth = CURRENT_WIDTH //ширина текущего
    private var mCurrentStep = CURRENT_STEP //по дефолту текущий шаг
    private var mStepCount = STEP_COUNT //по дефолту количеству кругов
    private var mLineWidth = LINE_WIDTH //по дефолту интервал линии (длина)
    private var mLineHeight = LINE_HEIGHT //по дефолту интервал линии (высота)
    private var isShow: Boolean = true //по дефолту показывать разделитель
    private var currentTextColor = CURRENT_TEXT_COLOR //цвет текущего круга
    private var passTextColor = PASS_TEXT_COLOR //цвет пройденного круга
    private var normalTextColor = NORMAL_TEXT_COLOR //цвет в обычном состоянии
    private var lineColor = LINE_COLOR //цвет линии
    private var textSize = TEXT_SIZE //размер текста
    private var contentText = emptyArray<String>() //указать текст

    private var lineView: View? = null
    private var tvCurrentStep: TextView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun convert(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
            .toInt()
    }

    //создание //TODO use documentation
    fun init() {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        for (item in 0 until mStepCount) {
            tvCurrentStep = TextView(context)
            if (item < mStepCount - 1 && isShow) {//интервал
                lineView = View(context)
                lineView!!.setBackgroundResource(lineColor)
                val params = LayoutParams(convert(mLineWidth.toFloat()), convert(mLineHeight.toFloat()))
                params.gravity = Gravity.CENTER
                params.leftMargin = mSpaceBetween
                lineView!!.layoutParams = params
            }
            var background: Int
            var width: Int = mNormalWidth
            when {
                item < mCurrentStep -> {
                    background = mPassedBackground
                    tvCurrentStep!!.setTextColor(GONE)
                }
                item == mCurrentStep -> {
                    background = mCurrentBackground
                    width = mCurrentWidth
                    tvCurrentStep!!.setTextColor(context.resources.getColor(currentTextColor))
                }
                else -> {
                    background = mNormalBackground
                    tvCurrentStep!!.setTextColor(context.resources.getColor(normalTextColor))
                }
            }
            tvCurrentStep!!.gravity = Gravity.CENTER
            if (contentText.isNotEmpty())
                tvCurrentStep!!.text = contentText[item]
            else
                tvCurrentStep!!.text = (item + 1).toString()

            val params = LayoutParams(width, width)
            if (item > 0)
                params.leftMargin = mSpaceBetween
            tvCurrentStep!!.layoutParams = params
            addView(tvCurrentStep)
            if (lineView != null) {
                addView(lineView)
                lineView = null
            }
            if (tvCurrentStep is ViewGroup)
                tvCurrentStep = getChildAt(0) as TextView
            tvCurrentStep!!.setBackgroundResource(background)
        }
    }

    //для вызова в активити/фрагмент  //TODO use documentation
    fun setData(barBuilder: BarBuilder) {
        mCurrentBackground = barBuilder.mCurrentBackground
        mPassedBackground = barBuilder.mPassedBackground
        mNormalBackground = barBuilder.mNormalBackground
        mSpaceBetween = barBuilder.mSpaceBetween
        mNormalWidth = barBuilder.mNormalWidth
        mCurrentWidth = barBuilder.mCurrentWidth
        mCurrentStep = barBuilder.mCurrentStep
        mStepCount = barBuilder.mStepCount
        mLineWidth = barBuilder.mLineWidth
        mLineHeight = barBuilder.mLineHeight
        isShow = barBuilder.isShow
        lineColor = barBuilder.lineColor
        currentTextColor = barBuilder.currentTextColor
        passTextColor = barBuilder.passTextColor
        normalTextColor = barBuilder.normalTextColor
        textSize = barBuilder.textSize
        contentText = barBuilder.contentText
    }

    //для билдера //TODO use documentation
    inner class BarBuilder {
        var mCurrentBackground: Int = R.drawable.shape_current //текущий
        var mPassedBackground: Int = R.drawable.ic_check_mark //пройденное
        var mNormalBackground: Int = R.drawable.shape_normal //обычное состояние
        var mSpaceBetween = M_SPACE_BETWEEN //интвервал
        var mNormalWidth = M_NORMAL_WIDTH //длина обычного
        var mCurrentWidth = M_CURRENT_WIDTH //длина текущего
        var mCurrentStep = M_CURRENT_STEP //текущий
        var mStepCount = M_STEP_COUNT //количество кругов
        var mLineWidth = M_LINE_WIDTH //длина линии
        var mLineHeight = M_LINE_HEIGHT //высота линии
        var isShow: Boolean = true //видимость разделителя
        var lineColor: Int = R.color.line_progress //цвет линии
        var currentTextColor: Int = R.color.current //цвет текста текущего
        var passTextColor: Int = R.color.background_color //цвет текста пройденного
        var normalTextColor: Int = R.color.text_grey //цвет текста обычного
        var textSize: Int = M_TEXT_SIZE //размер текста
        var contentText = emptyArray<String>() //установить текст

        //установка количества шагов //TODO use documentation
        fun setUp(stepCount: Int, currentStep: Int): BarBuilder {
            mStepCount = stepCount
            if (currentStep > 0)
                mCurrentStep = currentStep - 1
            return this
        }

        //установка длины разделителя //TODO use documentation
        fun setLineWidth(width: Int, height: Int): BarBuilder {
            mLineWidth = width
            mLineHeight = height
            return this
        }

        //установка текста //TODO use documentation
        fun setTextSize(size: Int): BarBuilder {
            textSize = size
            return this
        }

        //установка цвета фона кругов //TODO use documentation
        fun setBackground(currentBg: Int, passedBg: Int, normalBg: Int): BarBuilder {
            mCurrentBackground = currentBg
            mPassedBackground = passedBg
            mNormalBackground = normalBg
            return this
        }

        //установка размера кругов //TODO use documentation
        fun setCircleWidth(currentWidth: Int, normalWidth: Int): BarBuilder {
            mCurrentWidth = currentWidth //длина текущего
            mNormalWidth = normalWidth //длина обычная
            return this
        }

        //установка видимости разделителя //TODO use documentation
        fun isShowLine(show: Boolean): BarBuilder {
            isShow = show
            return this
        }

        //установка цвета линии //TODO use documentation
        fun setLineColor(color: Int): BarBuilder {
            lineColor = color
            return this
        }

        //установка текста //TODO use documentation
        fun setContent(content: Array<String>): BarBuilder {
            if (content.size != mStepCount)
                return this
            else
                contentText = content
            return this
        }

        //установка свободного места между кругами //TODO use documentation
        fun setSpace(space: Int): BarBuilder {
            mSpaceBetween = space
            return this
        }

        //установка цвета текста //TODO use documentation
        fun setTextColor(currentColor: Int, passColor: Int, normalColor: Int): BarBuilder {
            currentTextColor = currentColor
            passTextColor = passColor
            normalTextColor = normalColor
            return this
        }

        fun build(): StepBar {
            this@StepBar.setData(this)
            return this@StepBar
        }
    }
}