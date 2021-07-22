package com.example.ui.common

import com.example.ui.R
import com.example.ui.utill.*

class BarBuilder {
    var mCurrentBackground: Int = R.drawable.shape_current
    var mPassedBackground: Int = R.drawable.ic_check_mark
    var mNormalBackground: Int = R.drawable.shape_normal
    var mSpaceBetween = M_SPACE_BETWEEN
    var mNormalWidth = M_NORMAL_WIDTH
    var mCurrentWidth = M_CURRENT_WIDTH
    var mCurrentStep = M_CURRENT_STEP
    var mStepCount = M_STEP_COUNT
    var mLineWidth = M_LINE_WIDTH
    var mLineHeight = M_LINE_HEIGHT
    var isShow: Boolean = true
    var lineColor: Int = R.color.line_progress
    var currentTextColor: Int = R.color.current
    var passTextColor: Int = R.color.background_color
    var normalTextColor: Int = R.color.text_grey
    var textSize: Int = M_TEXT_SIZE
    var contentText = emptyArray<String>()

    /**
     * set count of step
     */
    fun setUp(stepCount: Int, currentStep: Int): StepBar {
        mStepCount = stepCount
        if (currentStep > 0)
            mCurrentStep = currentStep - 1
        return setUp(mStepCount, mCurrentStep)
    }

    /**
     * set width of line
     */
    fun setLineWidth(width: Int, height: Int): StepBar {
        mLineWidth = width
        mLineHeight = height
        return setLineWidth(mLineWidth, mLineHeight)
    }

    /**
     * set size of text
     */
    fun setTextSize(size: Int): StepBar {
        textSize = size
        return setTextSize(textSize)
    }

    /**
     * set background color of circle in different state
     */
    fun setBackground(currentBg: Int, passedBg: Int, normalBg: Int): StepBar {
        mCurrentBackground = currentBg
        mPassedBackground = passedBg
        mNormalBackground = normalBg
        return setBackground(mCurrentBackground, mPassedBackground, mNormalBackground)
    }

    /**
     * set width of circle
     */
    fun setCircleWidth(currentWidth: Int, normalWidth: Int): StepBar {
        mCurrentWidth = currentWidth //длина текущего
        mNormalWidth = normalWidth //длина обычная
        return setCircleWidth(mCurrentWidth, mNormalWidth)
    }

    /**
     * set visible/invisible line
     */
    fun isShowLine(show: Boolean): StepBar {
        isShow = show
        return isShowLine(isShow)
    }

    /**
     * set color of line
     */
    fun setLineColor(color: Int): StepBar {
        lineColor = color
        return setLineColor(lineColor)
    }

    /**
     * set text content for step
     */
    fun setContent(content: Array<String>): StepBar {
        if (content.size != mStepCount)
            return setContent(content)
        else
            contentText = content
        return setContent(contentText)
    }

    /**
     * set the space between circle
     */
    fun setSpace(space: Int): StepBar {
        mSpaceBetween = space
        return setSpace(mSpaceBetween)
    }

    /**
     * set color of text
     */
    fun setTextColor(currentColor: Int, passColor: Int, normalColor: Int): StepBar {
        currentTextColor = currentColor
        passTextColor = passColor
        normalTextColor = normalColor
        return setTextColor(currentTextColor, passTextColor, normalTextColor)
    }
}