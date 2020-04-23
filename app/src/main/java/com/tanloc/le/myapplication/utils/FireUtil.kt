package com.tanloc.le.myapplication.utils

import android.content.Context
import java.io.IOException
import java.nio.charset.Charset

object FileUtils {
    // read file
    @Throws(IOException::class)
    fun loadJSONFromAsset(context: Context, jsonFileName: String): String {
        (context.assets).open(jsonFileName).let {
            val buffer = ByteArray(it.available())
            it.read(buffer)
            it.close()
            return String(buffer, Charset.forName("UTF-8"))
        }
    }
}