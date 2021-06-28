package com.example.workwithui

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
// TODO: add to const
class StepBar : LinearLayout {

    private var mCurrentBackground: Int = R.drawable.shape_current //текущий фон круга
    private var mPassedBackground: Int = R.drawable.shape_normal //фон пройденного круга
    private var mNormalBackground: Int = R.drawable.shape_failed //фон обычный
    private var mSpaceBetween: Int = 25 //интвервал
    private var mNormalWidth: Int = 14 //ширина обычная
    private var mCurrentWidth: Int = 18 //ширина текущего
    private var mCurrentStep: Int = 0 //по дефолту текущий шаг
    private var mStepCount: Int = 3 //по дефолту количеству кругов
    private var mLineWidth: Int = 20 //по дефолту интервал линии (длина)
    private var mLineHeight: Int = 1 //по дефолту интервал линии (высота)
    private var isShow: Boolean = true //по дефолту показывать разделитель
    private var currentTextColor: Int = 0 //цвет текущего круга
    private var passTextColor: Int = 0 //цвет пройденного круга
    private var normalTextColor: Int = 0 //цвет в обычном состоянии
    private var lineColor: Int = 0 //цвет линии
    private var textSize: Int = 13 //размер текста
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

    //создание
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

    //для вызова в активити/фрагмент
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

    //для билдера
    inner class BarBuilder {
        var mCurrentBackground: Int = R.drawable.shape_current //текущий
        var mPassedBackground: Int = R.drawable.ic_check_mark //пройденное
        var mNormalBackground: Int = R.drawable.shape_normal //обычное состояние
        var mSpaceBetween: Int = 10 //интвервал
        var mNormalWidth: Int = 70 //длина обычного
        var mCurrentWidth: Int = 70 //длина текущего
        var mCurrentStep: Int = 5 //текущий
        var mStepCount: Int = 7 //количество кругов
        var mLineWidth: Int = 10 //длина линии
        var mLineHeight: Int = 2 //высота линии
        var isShow: Boolean = true //видимость разделителя
        var lineColor: Int = R.color.line_progress //цвет линии
        var currentTextColor: Int = R.color.current //цвет текста текущего
        var passTextColor: Int = R.color.background_color //цвет текста пройденного
        var normalTextColor: Int = R.color.text_grey //цвет текста обычного
        var textSize: Int = 13 //размер текста
        var contentText = emptyArray<String>() //установить текст

        //установка количества шагов
        fun setUp(stepCount: Int, currentStep: Int): BarBuilder {
            mStepCount = stepCount
            if (currentStep > 0)
                mCurrentStep = currentStep - 1
            return this
        }

        //установка длины разделителя
        fun setLineWidth(width: Int, height: Int): BarBuilder {
            mLineWidth = width
            mLineHeight = height
            return this
        }

        //установка текста
        fun setTextSize(size: Int): BarBuilder {
            textSize = size
            return this
        }

        //установка цвета фона кругов
        fun setBackground(currentBg: Int, passedBg: Int, normalBg: Int): BarBuilder {
            mCurrentBackground = currentBg
            mPassedBackground = passedBg
            mNormalBackground = normalBg
            return this
        }

        //установка размера кругов
        fun setCircleWidth(currentWidth: Int, normalWidth: Int): BarBuilder {
            mCurrentWidth = currentWidth //длина текущего
            mNormalWidth = normalWidth //длина обычная
            return this
        }

        //установка видимости разделителя
        fun isShowLine(show: Boolean): BarBuilder {
            isShow = show
            return this
        }

        //установка цвета линии
        fun setLineColor(color: Int): BarBuilder {
            lineColor = color
            return this
        }

        //установка текста
        fun setContent(content: Array<String>): BarBuilder {
            if (content.size != mStepCount)
                return this
            else
                contentText = content
            return this
        }

        //установка свободного места между кругами
        fun setSpace(space: Int): BarBuilder {
            mSpaceBetween = space
            return this
        }

        //установка цвета текста
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
