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
import com.example.ui.utill.*

/**
 * This custom view - stepBar, which display steps in the different states.
 */
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

    /**
     * Use some constants for show state progress:
     * mCurrentBackground - current circle background color
     * mPassedBackground - passed circle background color
     * mNormalBackground - normal circle background color
     * mSpaceBetween - interval
     * mNormalWidth - normal width circle
     * mCurrentWidth - current width circle
     * mCurrentStep - current step
     * mStepCount - number of steps
     * mLineWidth - width of line
     * mLineHeight - height of line
     * isShow - visible/invisible line
     * currentTextColor - color of text when step is current
     * passTextColor - color of text when step is passed
     * normalTextColor - color of text in normal state step
     * lineColor - color of line
     * textSize - size of text
     * contentText - set the text content
     */
    private var mCurrentBackground: Int = R.drawable.shape_current
    private var mPassedBackground: Int = R.drawable.shape_normal
    private var mNormalBackground: Int = R.drawable.shape_failed
    private var mSpaceBetween = SPACE_BETWEEN
    private var mNormalWidth = NORMAL_WIDTH
    private var mCurrentWidth = CURRENT_WIDTH
    private var mCurrentStep = CURRENT_STEP
    private var mStepCount = STEP_COUNT
    private var mLineWidth = LINE_WIDTH
    private var mLineHeight = LINE_HEIGHT
    private var isShow: Boolean = true
    private var currentTextColor = CURRENT_TEXT_COLOR
    private var passTextColor = PASS_TEXT_COLOR
    private var normalTextColor = NORMAL_TEXT_COLOR
    private var lineColor = LINE_COLOR
    private var textSize = TEXT_SIZE
    private var contentText = emptyArray<String>()

    private var lineView: View? = null
    private var tvCurrentStep: TextView? = null

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    private fun convert(dp: Float): Int {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.displayMetrics)
                .toInt()
    }

    /**
     * init create components
     */
    fun init() {
        orientation = HORIZONTAL
        gravity = Gravity.CENTER_VERTICAL
        for (item in 0 until mStepCount) {
            tvCurrentStep = TextView(context)
            if (item < mStepCount - 1 && isShow) {
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

    /**
     * get data from builder
     */
    fun setData() {
        mCurrentBackground = BarBuilder().mCurrentBackground
        mPassedBackground = BarBuilder().mPassedBackground
        mNormalBackground = BarBuilder().mNormalBackground
        mSpaceBetween = BarBuilder().mSpaceBetween
        mNormalWidth = BarBuilder().mNormalWidth
        mCurrentWidth = BarBuilder().mCurrentWidth
        mCurrentStep = BarBuilder().mCurrentStep
        mStepCount = BarBuilder().mStepCount
        mLineWidth = BarBuilder().mLineWidth
        mLineHeight = BarBuilder().mLineHeight
        isShow = BarBuilder().isShow
        lineColor = BarBuilder().lineColor
        currentTextColor = BarBuilder().currentTextColor
        passTextColor = BarBuilder().passTextColor
        normalTextColor = BarBuilder().normalTextColor
        textSize = BarBuilder().textSize
        contentText = BarBuilder().contentText
    }

    fun build(): StepBar {
        this@StepBar.setData()
        return this@StepBar
    }
}