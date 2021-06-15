package com.example.display.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.slashmobility.seleccion.david.pasache.R
import com.slashmobility.seleccion.david.pasache.business.model.GroupModel
import com.slashmobility.seleccion.david.pasache.utility.DateUtils
import com.squareup.picasso.Picasso

class GroupsAdapter(var groupList: List<GroupModel>, val onItemClick: (group: GroupModel) -> Unit) : RecyclerView.Adapter<GroupsAdapter.GroupVH>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupVH {
        val inflater = LayoutInflater.from(parent.context)
        val rootView = inflater.inflate(R.layout.item_group, parent, false)
        return GroupVH(rootView)
    }

    override fun onBindViewHolder(holder: GroupVH, position: Int) {
        val group = groupList.get(position)
        Picasso.get().load(group.defaultImageUrl).into(holder.bgImage)
        holder.name.text = group.name
        holder.descShort.text = group.descriptionShort
        holder.date.text = DateUtils.date(group.date.toLong(), "dd/MM/yyyy")
//        holder.view.setOnClickListener { onItemClick(user) }
    }

    class GroupVH(val view: View): RecyclerView.ViewHolder(view) {
        val bgImage: ImageView = view.findViewById(R.id.bg_image)
        val name: TextView = view.findViewById(R.id.name)
        val descShort: TextView = view.findViewById(R.id.desc_short)
        val date: TextView = view.findViewById(R.id.date)
    }

    override fun getItemCount(): Int {
        return groupList.size
    }

}