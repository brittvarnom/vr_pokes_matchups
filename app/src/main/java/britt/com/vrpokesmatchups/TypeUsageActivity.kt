package britt.com.vrpokesmatchups

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import britt.com.vrpokesmatchups.TypeRecycler.UsageAdapter
import britt.com.vrpokesmatchups.UsagesRecycler.MakePokemon
import britt.com.vrpokesmatchups.UsagesRecycler.Pokes
import kotlinx.android.synthetic.main.activity_type_usage.*

class TypeUsageActivity : AppCompatActivity() {

    val makePokemon = MakePokemon()

    var pokeList = arrayListOf<Pokes>()
    val pokemon = makePokemon.printResult(applicationContext)
    val incompletePokeList = pokemon.split(',')

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_type_usage)
    }

    fun setImages() {
        pokelist_recycler.adapter = UsageAdapter(pokeList)

        val currentPokeNo = 0
    }

    fun addToArrayList(currentPokeNo: Int, type1: String, type2: String, name: String) {
        val url = "https://github.com/brittvarnom/vr_pokes_matchups/blob/storage/all_icons/Battlers/${}.png?raw=true"
        pokeList.add(Pokes(url, name, type1, type2))
    }
}
