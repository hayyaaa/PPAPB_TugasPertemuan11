package com.example.tugaspertemuan11retrofit

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.BitmapTransitionOptions
import com.example.tugaspertemuan11retrofit.databinding.ItemBookBinding
import com.example.tugaspertemuan11retrofit.model.Bukuimage
import com.example.tugaspertemuan11retrofit.model.Bukuinfo
import com.example.tugaspertemuan11retrofit.model.Info
import com.example.tugaspertemuan11retrofit.model.Item

class BookAdapter(private val listBook : List<Info>) :
    RecyclerView.Adapter<BookAdapter.ItemBookViewHolder>() {

    inner class ItemBookViewHolder(private val binding: ItemBookBinding) :
        RecyclerView.ViewHolder(binding.root) {
            fun bind(data : Info) {
                with(binding) {
                    bookTitle.text = data.volumeInfo.title
                    bookDesc.text = data.volumeInfo.description
                    publishedDate.text =  data.volumeInfo.publishedDate

                    Glide.with(binding.root).load(data.volumeInfo.imageLinks.thumbnail)
                        .into(bookImg)
                }
            }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemBookViewHolder {
        val binding = ItemBookBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ItemBookViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listBook.size
    }

    override fun onBindViewHolder(holder: ItemBookViewHolder, position: Int) {
        holder.bind(listBook[position])
    }
}