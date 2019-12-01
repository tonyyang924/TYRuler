package com.tonyyang.ruler

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.view.View


class TyRuler @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private var mWidthMm = 0

    private val mIndicatorColor = Color.YELLOW

    private val mBigIndicatorIntervalMm = 10
    private val mBigIndicatorLengthPx = 10.toPx()
    private val mBigIndicatorTextPositionPx = 15.toPx()
    private val mBigIndicatorPaint = Paint().apply {
        color = mIndicatorColor
        strokeWidth = 5F
    }

    private val mMediumIndicatorIntervalMm = 5
    private val mMediumIndicatorLengthPx = 8.toPx()
    private val mMediumIndicatorPaint = Paint().apply {
        color = mIndicatorColor
        strokeWidth = 4F
    }

    private val mSmallIndicatorLengthPx = 5.toPx()
    private val mSmallIndicatorPaint = Paint().apply {
        color = mIndicatorColor
        strokeWidth = 3F
    }

    private val mLabelTextPaint = Paint().apply {
        color = Color.YELLOW
        textAlign = Paint.Align.CENTER
        textSize = Utils.dpToPx(20).toFloat()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        setBackgroundColor(Color.BLACK)
        mWidthMm = width.toFloat().toMm()
        Log.i(TAG, "width: $width, mWidthMm: $mWidthMm")
        var cm = 0
        for (xMm in 0..mWidthMm) {
            val xPx = xMm.toPx()
            if (xMm == 0 || xMm % mBigIndicatorIntervalMm == 0) {
                canvas.drawLine(
                    xPx, 0F,
                    xPx, mBigIndicatorLengthPx,
                    mBigIndicatorPaint
                )
                canvas.drawText(cm.toString(), xPx, mBigIndicatorTextPositionPx, mLabelTextPaint)
                cm++
            } else if (xMm % mMediumIndicatorIntervalMm == 0) {
                canvas.drawLine(
                    xPx, 0F,
                    xPx, mMediumIndicatorLengthPx,
                    mMediumIndicatorPaint
                )
            } else {
                canvas.drawLine(
                    xPx, 0F,
                    xPx, mSmallIndicatorLengthPx,
                    mSmallIndicatorPaint
                )
            }
        }
    }

    companion object {
        private val TAG = TyRuler::class.java.simpleName
    }
}