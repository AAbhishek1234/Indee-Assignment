package com.aabhishek.indeetvassignment.utils

import android.content.Context
import java.io.IOException

fun getJsonFromAssets(
    context: Context,
    fileName: String
): String {
    var jsonString: String
    try {
        val iStream = context.assets.open(fileName)
        val size = iStream.available()
        val buffer = ByteArray(size)
        iStream.read(buffer)
        iStream.close()

        jsonString = String(buffer, Charsets.UTF_8)


    } catch (e: IOException) {
        e.printStackTrace()
        return ""
    }
    return jsonString
}