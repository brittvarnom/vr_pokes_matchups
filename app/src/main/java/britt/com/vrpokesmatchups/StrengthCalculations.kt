package britt.com.vrpokesmatchups


class StrengthCalculations {

    fun getResults(primaryType: Types, secondaryType: Types): MutableMap<Types, Double> {
        val resultsPT : MutableMap<Types, Double> = mutableMapOf()
        val resultsST : MutableMap<Types, Double> = mutableMapOf()
        var resultsBothT : MutableMap<Types, Double> = mutableMapOf()
        putResultsInArray(primaryType, resultsPT)
        putResultsInArray(secondaryType, resultsST)
        if (primaryType == secondaryType) {
            resultsBothT = resultsPT
            return resultsBothT
        } else {
            putInFinalMap(resultsBothT, resultsPT, resultsST)
            return resultsBothT
        }
    }

    fun putInFinalMap(resultsBothT: MutableMap<Types, Double>, resultsPT : MutableMap<Types, Double>,
                      resultsST: MutableMap<Types, Double>) {
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.BUG)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.CYBER)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.DARK)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.DRAGON)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.ELECTRIC)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.FAIRY)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.FIGHTING)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.FIRE)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.FLYING)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.GHOST)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.GRASS)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.GROUND)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.ICE)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.NORMAL)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.POISON)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.PSYCHIC)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.ROCK)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.STEEL)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.WATER)
        putInFinalMap(resultsBothT, resultsPT, resultsST, Types.NONE)
    }

    fun putInFinalMap(resultsBothT: MutableMap<Types, Double>, resultsPT : MutableMap<Types, Double>,
                      resultsST: MutableMap<Types, Double>, testType: Types) {
        resultsBothT.put(testType, ((resultsPT.getValue(testType))) * (resultsST.getValue(testType)))
    }

    fun calculateStrongest(pokeType: Types, testType: Types): Double {
        when (pokeType) {
            Types.BUG -> {
                if ((testType == Types.FLYING) or (testType == Types.ROCK) or (testType == Types.FIRE)) {
                    return 2.0
                } else if ((testType == Types.FIGHTING) or (testType == Types.GROUND) or
                    (testType == Types.GRASS) or (testType == Types.CYBER)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.CYBER -> {
                if ((testType == Types.WATER) or (testType == Types.BUG)) {
                    return 2.0
                } else if ((testType == Types.CYBER) or (testType == Types.STEEL) or
                    (testType == Types.NORMAL) or (testType == Types.POISON)) {
                    return 0.5
                } else if (testType == Types.ELECTRIC) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.DARK -> {
                if ((testType == Types.FIGHTING) or (testType == Types.BUG) or (testType == Types.FAIRY)) {
                    return 2.0
                } else if ((testType == Types.GHOST) or (testType == Types.DARK)) {
                    return 0.5
                } else if (testType == Types.PSYCHIC) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.DRAGON -> {
                if ((testType == Types.ICE) or (testType == Types.DRAGON) or (testType == Types.FAIRY)) {
                    return 2.0
                } else if ((testType == Types.FIRE) or (testType == Types.WATER) or
                    (testType == Types.GRASS) or (testType == Types.ELECTRIC)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.ELECTRIC -> {
                if ((testType == Types.GROUND)) {
                    return 2.0
                } else if ((testType == Types.FLYING) or (testType == Types.STEEL) or
                    (testType == Types.ELECTRIC)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.FAIRY -> {
                if ((testType == Types.POISON) or (testType == Types.STEEL) or (testType == Types.CYBER)) {
                    return 2.0
                } else if ((testType == Types.FIGHTING) or (testType == Types.BUG) or
                    (testType == Types.DARK)) {
                    return 0.5
                } else if (testType == Types.DRAGON) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.FIGHTING -> {
                if ((testType == Types.FLYING) or (testType == Types.PSYCHIC) or (testType == Types.FAIRY)) {
                    return 2.0
                } else if ((testType == Types.ROCK) or (testType == Types.BUG) or (testType == Types.DARK)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.FIRE -> {
                if ((testType == Types.GROUND) or (testType == Types.ROCK) or (testType == Types.WATER)) {
                    return 2.0
                } else if ((testType == Types.BUG) or (testType == Types.STEEL) or
                    (testType == Types.FIRE) or (testType == Types.GRASS) or (testType == Types.ICE)
                    or (testType == Types.FAIRY)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.FLYING -> {
                if ((testType == Types.ROCK) or (testType == Types.ELECTRIC) or (testType == Types.ICE)) {
                    return 2.0
                } else if ((testType == Types.FIGHTING) or (testType == Types.BUG) or (testType == Types.GRASS)) {
                    return 0.5
                } else if (testType == Types.GROUND) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.GHOST -> {
                if ((testType == Types.GHOST) or (testType == Types.DARK)) {
                    return 2.0
                } else if ((testType == Types.POISON) or (testType == Types.BUG)) {
                    return 0.5
                } else if ((testType == Types.NORMAL) or (testType == Types.FIGHTING)) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.GRASS -> {
                if ((testType == Types.FLYING) or (testType == Types.POISON) or
                    (testType == Types.BUG) or (testType == Types.FIRE) or (testType == Types.ICE)) {
                    return 2.0
                } else if ((testType == Types.GROUND) or (testType == Types.WATER) or
                    (testType == Types.GRASS) or (testType == Types.ELECTRIC)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.GROUND -> {
                if ((testType == Types.WATER) or (testType == Types.GRASS) or (testType == Types.ICE)) {
                    return 2.0
                } else if ((testType == Types.POISON) or (testType == Types.ROCK)) {
                    return 0.5
                } else if (testType == Types.ELECTRIC) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.ICE -> {
                if ((testType == Types.FIGHTING) or (testType == Types.ROCK) or
                    (testType == Types.STEEL) or (testType == Types.FIRE)) {
                    return 2.0
                } else if ((testType == Types.ICE)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.NORMAL -> {
                if ((testType == Types.FIGHTING) or (testType == Types.CYBER)) {
                    return 2.0
                } else if (testType == Types.GHOST) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.POISON -> {
                if ((testType == Types.GROUND) or (testType == Types.PSYCHIC)) {
                    return 2.0
                } else if ((testType == Types.FIGHTING) or (testType == Types.POISON) or
                    (testType == Types.BUG) or (testType == Types.GRASS)) {
                    return 0.5
                } else if (testType == Types.GROUND) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.PSYCHIC -> {
                if ((testType == Types.BUG) or (testType == Types.GHOST) or (testType == Types.DARK)) {
                    return 2.0
                } else if ((testType == Types.FIGHTING) or (testType == Types.PSYCHIC)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.ROCK -> {
                if ((testType == Types.FIGHTING) or (testType == Types.GROUND) or
                    (testType == Types.STEEL) or (testType == Types.WATER) or (testType == Types.GRASS)) {
                    return 2.0
                } else if ((testType == Types.NORMAL) or (testType == Types.FLYING) or
                    (testType == Types.POISON) or (testType == Types.FIRE)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.STEEL -> {
                if ((testType == Types.FIGHTING) or (testType == Types.GROUND) or (testType == Types.FIRE)) {
                    return 2.0
                } else if ((testType == Types.NORMAL) or (testType == Types.FLYING) or
                    (testType == Types.ROCK) or (testType == Types.BUG) or (testType == Types.GHOST)
                    or (testType == Types.STEEL) or (testType == Types.GRASS) or (testType == Types.PSYCHIC)
                    or (testType == Types.ICE) or (testType == Types.DRAGON) or (testType == Types.DARK)) {
                    return 0.5
                } else if (testType == Types.POISON) {
                    return 0.0
                } else {
                    return 1.0
                }
            }
            Types.WATER -> {
                if ((testType == Types.GRASS) or (testType == Types.ELECTRIC)) {
                    return 2.0
                } else if ((testType == Types.STEEL) or (testType == Types.FIRE) or
                    (testType == Types.WATER) or (testType == Types.ICE)) {
                    return 0.5
                } else {
                    return 1.0
                }
            }
            Types.NONE -> return 1.0
        }
    }

    fun putResultsInArray(pokeType: Types, resultsT: MutableMap<Types, Double>) {
        resultsT.put(Types.BUG, calculateStrongest(pokeType, Types.BUG))
        resultsT.put(Types.CYBER, calculateStrongest(pokeType, Types.CYBER))
        resultsT.put(Types.DARK, calculateStrongest(pokeType, Types.DARK))
        resultsT.put(Types.DRAGON, calculateStrongest(pokeType, Types.DRAGON))
        resultsT.put(Types.ELECTRIC, calculateStrongest(pokeType, Types.ELECTRIC))
        resultsT.put(Types.FAIRY, calculateStrongest(pokeType, Types.FAIRY))
        resultsT.put(Types.FIGHTING, calculateStrongest(pokeType, Types.FIGHTING))
        resultsT.put(Types.FIRE, calculateStrongest(pokeType, Types.FIRE))
        resultsT.put(Types.FLYING, calculateStrongest(pokeType, Types.FLYING))
        resultsT.put(Types.GHOST, calculateStrongest(pokeType, Types.GHOST))
        resultsT.put(Types.GRASS, calculateStrongest(pokeType, Types.GRASS))
        resultsT.put(Types.GROUND, calculateStrongest(pokeType, Types.GROUND))
        resultsT.put(Types.ICE, calculateStrongest(pokeType, Types.ICE))
        resultsT.put(Types.NORMAL, calculateStrongest(pokeType, Types.NORMAL))
        resultsT.put(Types.POISON, calculateStrongest(pokeType, Types.POISON))
        resultsT.put(Types.PSYCHIC, calculateStrongest(pokeType, Types.PSYCHIC))
        resultsT.put(Types.ROCK, calculateStrongest(pokeType, Types.ROCK))
        resultsT.put(Types.STEEL, calculateStrongest(pokeType, Types.STEEL))
        resultsT.put(Types.WATER, calculateStrongest(pokeType, Types.WATER))
        resultsT.put(Types.NONE, calculateStrongest(pokeType, Types.NONE))
    }
}