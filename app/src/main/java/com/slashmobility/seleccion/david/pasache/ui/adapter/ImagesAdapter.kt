package com.slashmobility.seleccion.david.pasache.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.david.pasache.R
import com.squareup.picasso.Picasso

class ImagesAdapter(private val imageList: ArrayList<String>): RecyclerView.Adapter<ImagesAdapter.ImageVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageVH {
        val layoutInflater = LayoutInflater.from(parent.context)
        val rootView = layoutInflater.inflate(R.layout.item_image, parent, false)
        return ImageVH(rootView)
    }

    override fun onBindViewHolder(holder: ImageVH, position: Int) {
        val item = imageList[position]
        Picasso.get().load(item).into(holder.image)
    }


    class ImageVH(view: View): RecyclerView.ViewHolder(view) {
        val image: ImageView = view.findViewById(R.id.image)
    }

    override fun getItemCount(): Int {
        return imageList.size
    }

}