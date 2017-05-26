package britt.com.vrpokesmatchups.TypeRecycler

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import britt.com.vrpokesmatchups.R

class TypesAdapter(private val effectList: List<TypeImage>): RecyclerView.Adapter<TypesAdapter.TypesViewHolder>() {

    override fun onBindViewHolder(holder: TypesViewHolder, position: Int) {
        val typeImage = effectList[position]
        holder.bind(typeImage)
    }

    override fun getItemCount(): Int {
        return effectList.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TypesViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.types_item_holder, parent, false)
        return TypesViewHolder(view)
    }

    inner class TypesViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bind(typeImage : TypeImage) {
            val imageView = itemView.findViewById(R.id.s_effect) as ImageView
            imageView.setImageResource(typeImage.typeDrawableRes)
            itemView.setBackgroundResource(typeImage.backgroundDrawableRes)
        }
    }
}