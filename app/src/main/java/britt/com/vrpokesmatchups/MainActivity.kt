package britt.com.vrpokesmatchups

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.Spinner
import britt.com.vrpokesmatchups.TypeRecycler.StrengthCalculations
import britt.com.vrpokesmatchups.TypeRecycler.TypeImage
import britt.com.vrpokesmatchups.TypeRecycler.TypesAdapter
import britt.com.vrpokesmatchups.UsagesRecycler.MakePokemon
import kotlinx.android.synthetic.main.activity_main.*
import java.io.IOException

var superEffectiveTypes = ArrayList<TypeImage>()
var regularEffectTypes = ArrayList<TypeImage>()
var littleEffectTypes = ArrayList<TypeImage>()
var noEffectTypes = ArrayList<TypeImage>()

val test = MakePokemon()


class MainActivity : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    override fun onNothingSelected(parent: AdapterView<*>?) {
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        updateTypesOnSpinnerChange()
    }

    val setTypes = SetTypes()
    val strengthCalculations = StrengthCalculations()

    var type1: Types = Types.NONE
    var type2: Types = Types.NONE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        type_1.onItemSelectedListener = this
        type_2.onItemSelectedListener = this

        test.printResult(applicationContext)
    }

    fun updateTypesOnSpinnerChange() {
        type1 = setTypes.setTypesFromSpinner(type_1)
        type2 = setTypes.setTypesFromSpinner(type_2)
        val typeWeaknesses: MutableMap<Types, Double> = strengthCalculations.getResults(type1, type2)
        displayTypes(typeWeaknesses)
        setSpinnerBackground(type1, type_1)
        setSpinnerBackground(type2, type_2)
    }

    fun displayTypes(typeWeaknesses: MutableMap<Types, Double>) {
        superEffectiveTypes.clear()
        regularEffectTypes.clear()
        noEffectTypes.clear()
        littleEffectTypes.clear()

        addToArrays(typeWeaknesses, Types.BUG, R.drawable.bug)
        addToArrays(typeWeaknesses, Types.CYBER, R.drawable.cyber)
        addToArrays(typeWeaknesses, Types.DARK, R.drawable.dark)
        addToArrays(typeWeaknesses, Types.DRAGON, R.drawable.dragon)
        addToArrays(typeWeaknesses, Types.ELECTRIC, R.drawable.electric)
        addToArrays(typeWeaknesses, Types.FAIRY, R.drawable.fairy)
        addToArrays(typeWeaknesses, Types.FIGHTING, R.drawable.fighting)
        addToArrays(typeWeaknesses, Types.FIRE, R.drawable.fire)
        addToArrays(typeWeaknesses, Types.FLYING, R.drawable.flying)
        addToArrays(typeWeaknesses, Types.GHOST, R.drawable.ghost)
        addToArrays(typeWeaknesses, Types.GRASS, R.drawable.grass)
        addToArrays(typeWeaknesses, Types.GROUND, R.drawable.ground)
        addToArrays(typeWeaknesses, Types.ICE, R.drawable.ice)
        addToArrays(typeWeaknesses, Types.NORMAL, R.drawable.normal)
        addToArrays(typeWeaknesses, Types.POISON, R.drawable.poison)
        addToArrays(typeWeaknesses, Types.PSYCHIC, R.drawable.psychic)
        addToArrays(typeWeaknesses, Types.ROCK, R.drawable.rock)
        addToArrays(typeWeaknesses, Types.STEEL, R.drawable.steel)
        addToArrays(typeWeaknesses, Types.WATER, R.drawable.water)

        val sETypesAdapter = TypesAdapter(superEffectiveTypes)
        val rEtypesAdapter = TypesAdapter(regularEffectTypes)
        val nVEtypesAdapter = TypesAdapter(littleEffectTypes)
        val nEtypesAdapter = TypesAdapter(noEffectTypes)


        s_eff_recycler.adapter = sETypesAdapter
        s_eff_recycler.layoutManager = LinearLayoutManager(applicationContext)
        r_eff_recycler.adapter = rEtypesAdapter
        r_eff_recycler.layoutManager = LinearLayoutManager(applicationContext)
        n_eff_recycler.adapter = nVEtypesAdapter
        n_eff_recycler.layoutManager = LinearLayoutManager(applicationContext)
        z_eff_recycler.adapter = nEtypesAdapter
        z_eff_recycler.layoutManager = LinearLayoutManager(applicationContext)

    }

    fun addToArrays(typeWeaknesses: MutableMap<Types, Double>, type: Types, resId: Int) {
        if (typeWeaknesses[type]!! == 4.0) {
            superEffectiveTypes.add(TypeImage(resId, R.drawable.quadweak))
        } else if (typeWeaknesses[type]!! == 2.0) {
            superEffectiveTypes.add(TypeImage(resId))
        } else if (typeWeaknesses[type]!! == 1.0) {
            regularEffectTypes.add(TypeImage(resId))
        } else if ((typeWeaknesses[type]!! == 0.0)) {
            noEffectTypes.add(TypeImage(resId))
        } else if ((typeWeaknesses[type]!! == 0.5)) {
            littleEffectTypes.add(TypeImage(resId))
        } else {
            littleEffectTypes.add(TypeImage(resId, R.drawable.quadresist))
        }
    }

    fun setSpinnerBackground(type: Types, type_sp: Spinner) {
        if (type == Types.BUG) {
            type_sp.setBackgroundColor(Color.parseColor("#97B400"))
            type_sp.setBackgroundResource(R.drawable.bg_bug)
        }
        if (type == Types.CYBER) {
            type_sp.setBackgroundColor(Color.parseColor("#13FE00"))
            type_sp.setBackgroundResource(R.drawable.bg_cyber)
        }
        if (type == Types.DARK) {
            type_sp.setBackgroundColor(Color.parseColor("#554233"))
            type_sp.setBackgroundResource(R.drawable.bg_dark)
        }
        if (type == Types.DRAGON) {
            type_sp.setBackgroundColor(Color.parseColor("#5500E3"))
            type_sp.setBackgroundResource(R.drawable.bg_dragon)
        }
        if (type == Types.ELECTRIC) {
            type_sp.setBackgroundColor(Color.parseColor("#F4CF00"))
            type_sp.setBackgroundResource(R.drawable.bg_electric)
        }
        if (type == Types.FAIRY) {
            type_sp.setBackgroundColor(Color.parseColor("#D65177"))
            type_sp.setBackgroundResource(R.drawable.bg_fairy)
        }
        if (type == Types.FIGHTING) {
            type_sp.setBackgroundColor(Color.parseColor("#B01716"))
            type_sp.setBackgroundResource(R.drawable.bg_fighting)
        }
        if (type == Types.FIRE) {
            type_sp.setBackgroundColor(Color.parseColor("#EA6D11"))
            type_sp.setBackgroundResource(R.drawable.bg_fire)
        }
        if (type == Types.FLYING) {
            type_sp.setBackgroundColor(Color.parseColor("#986CF1"))
            type_sp.setBackgroundResource(R.drawable.bg_flying)
        }
        if (type == Types.GHOST) {
            type_sp.setBackgroundColor(Color.parseColor("#55357D"))
            type_sp.setBackgroundResource(R.drawable.bg_ghost)
        }
        if (type == Types.GRASS) {
            type_sp.setBackgroundColor(Color.parseColor("#60BC31"))
            type_sp.setBackgroundResource(R.drawable.bg_grass)
        }
        if (type == Types.GROUND) {
            type_sp.setBackgroundColor(Color.parseColor("#C5AB47"))
            type_sp.setBackgroundResource(R.drawable.bg_ground)
        }
        if (type == Types.ICE) {
            type_sp.setBackgroundColor(Color.parseColor("#88D2D1"))
            type_sp.setBackgroundResource(R.drawable.bg_ice)
        }
        if (type == Types.NORMAL) {
            type_sp.setBackgroundColor(Color.parseColor("#989C61"))
            type_sp.setBackgroundResource(R.drawable.bg_normal)
        }
        if (type == Types.POISON) {
            type_sp.setBackgroundColor(Color.parseColor("#8E1392"))
            type_sp.setBackgroundResource(R.drawable.bg_poison)
        }
        if (type == Types.PSYCHIC) {
            type_sp.setBackgroundColor(Color.parseColor("#F43274"))
            type_sp.setBackgroundResource(R.drawable.bg_psychic)
        }
        if (type == Types.ROCK) {
            type_sp.setBackgroundColor(Color.parseColor("#A18F1A"))
            type_sp.setBackgroundResource(R.drawable.bg_rock)
        }
        if (type == Types.STEEL) {
            type_sp.setBackgroundColor(Color.parseColor("#9F9BB9"))
            type_sp.setBackgroundResource(R.drawable.bg_steel)
        }
        if (type == Types.WATER) {
            type_sp.setBackgroundColor(Color.parseColor("#566AE7"))
            type_sp.setBackgroundResource(R.drawable.bg_water)
        }
        if (type == Types.NONE) {
            type_sp.setBackgroundColor(Color.parseColor("#6aa190"))
            type_sp.setBackgroundResource(R.drawable.bg_blank)
        }
    }
}