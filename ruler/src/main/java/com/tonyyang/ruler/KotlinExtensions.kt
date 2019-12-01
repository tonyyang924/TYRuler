package com.tonyyang.ruler

import android.content.res.Resources
import android.util.TypedValue

typealias Mm = Int
typealias Px = Float

fun Mm.toPx(): Px {
    return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, this.toFloat(), Resources.getSystem().displayMetrics)
}

fun Px.toMm(): Mm {
    return (this / TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_MM, 1F, Resources.getSystem().displayMetrics)).toInt()
}