package britt.com.vrpokesmatchups

import android.widget.Spinner

class SetTypes {
    fun setTypesFromSpinner(type_n : Spinner): Types {
        when (type_n.selectedItem) {
            "BUG" -> return Types.BUG
            "CYBER" -> return Types.CYBER
            "DARK" -> return Types.DARK
            "DRAGON" -> return Types.DRAGON
            "ELECTRIC" -> return Types.ELECTRIC
            "FAIRY" -> return Types.FAIRY
            "FIGHTING" -> return Types.FIGHTING
            "FIRE" -> return Types.FIRE
            "FLYING" -> return Types.FLYING
            "GHOST" -> return Types.GHOST
            "GRASS" -> return Types.GRASS
            "GROUND" -> return Types.GROUND
            "ICE" -> return Types.ICE
            "NORMAL" -> return Types.NORMAL
            "POISON" -> return Types.POISON
            "PSYCHIC" -> return Types.PSYCHIC
            "ROCK" -> return Types.ROCK
            "STEEL" -> return Types.STEEL
            "WATER" -> return Types.WATER
        }
        return Types.NONE
    }
}