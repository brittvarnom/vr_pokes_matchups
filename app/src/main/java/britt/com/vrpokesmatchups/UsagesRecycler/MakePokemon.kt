package britt.com.vrpokesmatchups.UsagesRecycler

import android.content.Context
import android.util.Log
import britt.com.vrpokesmatchups.R
import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader


class MakePokemon {
    fun GetTextFromFile(context: Context): String {
        val inputStream = context.resources.openRawResource(R.raw.type_usages)
        val br = BufferedReader(InputStreamReader(inputStream))

        var currentLine: String
        val sb = StringBuilder()
        currentLine = br.readLine()

        val end = "--END--"

        while (currentLine != end) {
            currentLine += "\n"
            sb.append(currentLine)
            currentLine = br.readLine() ?: end
        }
        return sb.toString()
    }

    fun printResult(context: Context): String {
        try {
            Log.d(">>>-", GetTextFromFile(context))
        } catch (e: IOException) {
            Log.e(">>>-", "failed " + e.message)
        }
        return GetTextFromFile(context)
    }
}

/*
Needs to:
    Read in all contents of AllPokemon and convert to string √
    Split at every new line into an array √
    Further split the contents into an array at each comma
    Set pokemon to textview, set dex number to url for imageview
    Check the type
    If either type matches type passed in, set it to be that one, else keep looking for another type
    If both types are the same, set the second to be NONE
 */