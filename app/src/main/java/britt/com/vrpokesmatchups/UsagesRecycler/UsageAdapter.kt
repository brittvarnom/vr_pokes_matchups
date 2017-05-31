package britt.com.vrpokesmatchups.TypeRecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import britt.com.vrpokesmatchups.R
import britt.com.vrpokesmatchups.UsagesRecycler.Pokes
import com.squareup.picasso.Picasso

class UsageAdapter(private val pokeList: ArrayList<Pokes>): RecyclerView.Adapter<UsageAdapter.UsageViewHolder>() {
    override fun onBindViewHolder(holder: UsageViewHolder, position: Int) {
        val pokeImage = pokeList[position]
        holder.bind(pokeImage)
    }


    override fun getItemCount(): Int {
        return pokeList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsageViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.pokemon_item_holder, parent, false)
        return UsageViewHolder(view)
    }

    inner class UsageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(pokes : Pokes) {
            val imageView = itemView.findViewById(R.id.pokemon_sprite) as ImageView
            val textView = itemView.findViewById(R.id.pokemon_name) as TextView
            Picasso.with(itemView.context).load(pokes.url).into(imageView)
            textView.text = pokes.name
        }
    }
}