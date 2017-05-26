package britt.com.vrpokesmatchups.UsagesRecycler

import android.content.Context
import android.util.Log
import britt.com.vrpokesmatchups.R
import britt.com.vrpokesmatchups.Types
import britt.com.vrpokesmatchups.test
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
            Log.d(">>>-", currentLine)
            currentLine += "\n"
            sb.append(currentLine)
            currentLine = br.readLine() ?: end
        }
        return sb.toString()
    }

    fun printResult(context: Context) {
        try {
            Log.d(">>>-", addPokes(context).toString())
        } catch (e: IOException) {
            Log.e(">>>-", "failed " + e.message)
        }
    }

    fun splitToArray(context: Context): List<String> {
        return GetTextFromFile(context).split("\n")
    }

    fun addPokes(context: Context): ArrayList<Pokes> {
        val allPokesList = splitToArray(context)
        var currentPokeNo = 0
        val pokemon = ArrayList<Pokes>()

        for (i in allPokesList.iterator()) {
            val eachPoke = allPokesList[currentPokeNo].split(',')
            pokemon.add(Pokes("https://github.com/yumanaa/game-thingy/blob/develop/Graphics/Battlers/${eachPoke[0]}.png?raw=true",
                eachPoke[1], eachPoke[2], eachPoke[3]))
        }


        return pokemon
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