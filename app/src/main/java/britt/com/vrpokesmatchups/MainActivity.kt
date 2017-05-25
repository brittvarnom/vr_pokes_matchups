package britt.com.vrpokesmatchups

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.Spinner
import kotlinx.android.synthetic.main.activity_main.*

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
    }

    fun updateTypesOnSpinnerChange() {
        type1 = setTypes.setTypesFromSpinner(type_1)
        type2 = setTypes.setTypesFromSpinner(type_2)
        val typeWeaknesses : MutableMap<Types, Double> = strengthCalculations.getResults(type1, type2)
        displayTypes(typeWeaknesses)
        setBackgroundOnSpinners()
    }

    fun displayTypes(typeWeaknesses : MutableMap<Types, Double>) {
        moveImagePerType(typeWeaknesses, Types.BUG, s_eff_1, r_eff_1, n_eff_1, z_eff_1, R.drawable.bug)
        moveImagePerType(typeWeaknesses, Types.CYBER, s_eff_2, r_eff_2, n_eff_2, z_eff_2, R.drawable.cyber)
        moveImagePerType(typeWeaknesses, Types.DARK, s_eff_3, r_eff_3, n_eff_3, z_eff_3, R.drawable.dark)
        moveImagePerType(typeWeaknesses, Types.DRAGON, s_eff_4, r_eff_4, n_eff_4, z_eff_4, R.drawable.dragon)
        moveImagePerType(typeWeaknesses, Types.ELECTRIC, s_eff_5, r_eff_5, n_eff_5, z_eff_5, R.drawable.electric)
        moveImagePerType(typeWeaknesses, Types.FAIRY, s_eff_6, r_eff_6, n_eff_6, z_eff_6, R.drawable.fairy)
        moveImagePerType(typeWeaknesses, Types.FIGHTING, s_eff_7, r_eff_7, n_eff_7, z_eff_7, R.drawable.fighting)
        moveImagePerType(typeWeaknesses, Types.FIRE, s_eff_8, r_eff_8, n_eff_8, z_eff_8, R.drawable.fire)
        moveImagePerType(typeWeaknesses, Types.FLYING, s_eff_9, r_eff_9, n_eff_9, z_eff_9, R.drawable.flying)
        moveImagePerType(typeWeaknesses, Types.GHOST, s_eff_10, r_eff_10, n_eff_10, z_eff_10, R.drawable.ghost)
        moveImagePerType(typeWeaknesses, Types.GRASS, s_eff_11, r_eff_11, n_eff_11, z_eff_11, R.drawable.grass)
        moveImagePerType(typeWeaknesses, Types.GROUND, s_eff_12, r_eff_12, n_eff_12, z_eff_12, R.drawable.ground)
        moveImagePerType(typeWeaknesses, Types.ICE, s_eff_13, r_eff_13, n_eff_13, z_eff_13, R.drawable.ice)
        moveImagePerType(typeWeaknesses, Types.NORMAL, s_eff_14, r_eff_14, n_eff_14, z_eff_14, R.drawable.normal)
        moveImagePerType(typeWeaknesses, Types.POISON, s_eff_15, r_eff_15, n_eff_15, z_eff_15, R.drawable.poison)
        moveImagePerType(typeWeaknesses, Types.PSYCHIC, s_eff_16, r_eff_16, n_eff_16, z_eff_16, R.drawable.psychic)
        moveImagePerType(typeWeaknesses, Types.ROCK, s_eff_17, r_eff_17, n_eff_17, z_eff_17, R.drawable.rock)
        moveImagePerType(typeWeaknesses, Types.STEEL, s_eff_18, r_eff_18, n_eff_18, z_eff_18, R.drawable.steel)
        moveImagePerType(typeWeaknesses, Types.WATER, s_eff_19, r_eff_19, n_eff_19, z_eff_19, R.drawable.water)
    }

    fun moveImagePerType(typeWeaknesses : MutableMap<Types, Double>, type : Types, s_eff_n : ImageView,
                         r_eff_n : ImageView, n_eff_n : ImageView, z_eff_n : ImageView, resId: Int) {
        if (typeWeaknesses[type]!! >= 2) {
            s_eff_n.setImageResource(resId)
            if (typeWeaknesses[type]!! == 4.0) {
                s_eff_n.setBackgroundResource(R.drawable.quadweak)
            } else {
                s_eff_n.setBackgroundResource(0)
            }
            r_eff_n.setImageResource(0)
            n_eff_n.setImageResource(0)
            n_eff_n.setBackgroundResource(0)
            z_eff_n.setImageResource(0)
        } else if (typeWeaknesses[type]!! == 1.0) {
            r_eff_n.setImageResource(resId)
            s_eff_n.setImageResource(0)
            s_eff_n.setBackgroundResource(0)
            n_eff_n.setImageResource(0)
            n_eff_n.setBackgroundResource(0)
            z_eff_n.setImageResource(0)
        } else if ((typeWeaknesses[type]!! == 0.0)){
            r_eff_n.setImageResource(0)
            s_eff_n.setImageResource(0)
            s_eff_n.setBackgroundResource(0)
            n_eff_n.setImageResource(0)
            n_eff_n.setBackgroundResource(0)
            z_eff_n.setImageResource(resId)
        } else if ((typeWeaknesses[type]!! <= 1)){
            r_eff_n.setImageResource(0)
            s_eff_n.setImageResource(0)
            s_eff_n.setBackgroundResource(0)
            n_eff_n.setImageResource(resId)
            if (typeWeaknesses[type]!! == 0.25) {
                n_eff_n.setBackgroundResource(R.drawable.quadresist)
            } else {
                n_eff_n.setBackgroundResource(0)
            }
            z_eff_n.setImageResource(0)
        } else {
            r_eff_n.setImageResource(0)
            s_eff_n.setImageResource(0)
            s_eff_n.setBackgroundResource(0)
            n_eff_n.setImageResource(0)
            n_eff_n.setBackgroundResource(0)
            z_eff_n.setImageResource(0)
        }
    }

    fun setBackgroundOnSpinners() {
        setSpinnerBackground(type1, type_1)
        setSpinnerBackground(type2, type_2)
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