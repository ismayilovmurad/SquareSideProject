package com.martiandeveloper.squareside

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.view.View
import androidx.constraintlayout.solver.widgets.Rectangle


class MyView : View {
    var mPaint: Paint? = null
    var sideLength = 0F

    constructor(context: Context?) : super(context) {}
    constructor(context: Context?, sideLength: Float) : super(context) {
        this.sideLength = sideLength
        mPaint = Paint()
        mPaint!!.style = Paint.Style.FILL
        mPaint!!.color = Color.BLUE
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        val rect = Rect(0,0,sideLength.toInt(),sideLength.toInt())
        rect.offset((width/2 - sideLength/2).toInt(), (height/2-sideLength/2).toInt())

        canvas.drawRect(
            rect,
            mPaint!!
        )
    }

}
