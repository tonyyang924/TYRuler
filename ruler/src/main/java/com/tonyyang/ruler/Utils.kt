package com.tonyyang.ruler

import android.content.res.Resources
import kotlin.math.roundToInt

object Utils {
    fun dpToPx(dp: Int): Int {
        return (Resources.getSystem().displayMetrics.density * dp).roundToInt()
    }
}