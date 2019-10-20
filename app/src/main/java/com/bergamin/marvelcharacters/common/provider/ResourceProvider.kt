package com.bergamin.marvelcharacters.common.provider

import androidx.annotation.StringRes

interface ResourceProvider {
    fun getString(@StringRes resId: Int): String
    fun getString(@StringRes resId: Int, vararg formatArgs: Any): String
}
