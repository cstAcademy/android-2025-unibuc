package com.cst.cstacademy2025unibucif.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import com.cst.cstacademy2025unibucif.models.direction.Direction
import com.cst.cstacademy2025unibucif.models.direction.DirectionType

class DirectionsAdapter(
    val directions : List<Direction>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        "onCreateViewHolder".logErrorMessage()
        return when (viewType) {
            DirectionType.NORTH.id -> {
                val view = inflater.inflate(R.layout.item_direction_north, parent, false)
                DirectionsNorthViewHolder(view)
            }
            DirectionType.SOUTH.id -> {
                val view = inflater.inflate(R.layout.item_direction_south, parent, false)
                DirectionsNorthViewHolder(view)
            }
            DirectionType.EAST.id -> {
                val view = inflater.inflate(R.layout.item_direction_east, parent, false)
                DirectionsNorthViewHolder(view)
            }
            DirectionType.WEST.id -> {
                val view = inflater.inflate(R.layout.item_direction_west, parent, false)
                DirectionsNorthViewHolder(view)
            }
            5 -> {
                val view = inflater.inflate(R.layout.item_direction, parent, false)
                DirectionsViewHolder(view)
            }
            else -> super.createViewHolder(parent, viewType)
        }
    }

    override fun getItemCount(): Int {
        return directions.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val type = directions.getOrNull(position) ?: return

        "onBindViewHolder $position of type ${type.type}".logErrorMessage()
        when (holder) {
            is DirectionsNorthViewHolder -> holder.bind(type)
            is DirectionsSouthViewHolder -> holder.bind(type)
            is DirectionsEastViewHolder -> holder.bind(type)
            is DirectionsWestViewHolder -> holder.bind(type)
            is DirectionsViewHolder -> holder.bind(type)
        }
    }

    override fun getItemViewType(position: Int): Int {
//        return directions.getOrNull(position)?.type?.id ?: DirectionType.NORTH.id
        return 5
    }

    inner class DirectionsViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(type: Direction) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(type.type.directionNameResId)

            view.findViewById<TextView>(R.id.tv_description).text =
                view.context.getString(type.type.directionDescriptionResId)
        }
    }

    inner class DirectionsNorthViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(type: Direction) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(type.type.directionNameResId)

            view.findViewById<TextView>(R.id.tv_description).text =
                view.context.getString(type.type.directionDescriptionResId)
        }
    }

    inner class DirectionsSouthViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(type: Direction) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(type.type.directionNameResId)

            view.findViewById<TextView>(R.id.tv_description).text =
                view.context.getString(type.type.directionDescriptionResId)
        }
    }

    inner class DirectionsEastViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(type: Direction) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(type.type.directionNameResId)

            view.findViewById<TextView>(R.id.tv_description).text =
                view.context.getString(type.type.directionDescriptionResId)
        }
    }

    inner class DirectionsWestViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        fun bind(type: Direction) {
            view.findViewById<TextView>(R.id.tv_name).text =
                view.context.getString(type.type.directionNameResId)

            view.findViewById<TextView>(R.id.tv_description).text =
                view.context.getString(type.type.directionDescriptionResId)
        }
    }
}