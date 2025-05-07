package com.cst.cstacademy2025unibucif.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cst.cstacademy2025unibucif.databinding.ItemUserBinding
import com.cst.cstacademy2025unibucif.models.users.UserModel

class UsersAdapter(
    val users: List<UserModel>
): RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemUserBinding.inflate(inflater, parent, false)

        return UserViewHolder(binding)
    }

    override fun getItemCount() = users.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        users.getOrNull(position)?.let { user ->
            holder.bind(user)
        }
    }

    inner class UserViewHolder(val binding: ItemUserBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(userModel: UserModel) {
            binding.userModel = userModel
        }
    }
}
