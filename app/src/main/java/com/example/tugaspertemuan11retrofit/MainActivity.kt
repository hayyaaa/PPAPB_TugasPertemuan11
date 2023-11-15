package com.example.tugaspertemuan11retrofit

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspertemuan11retrofit.databinding.ActivityMainBinding
import com.example.tugaspertemuan11retrofit.model.Bukuinfo
import com.example.tugaspertemuan11retrofit.model.Info
import com.example.tugaspertemuan11retrofit.model.Item
import com.example.tugaspertemuan11retrofit.retrofit.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private lateinit var recyclerView: RecyclerView
    private lateinit var bookAdapter: BookAdapter
    private lateinit var bookList: List<Info>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        val client = ApiClient.getInstance()
        val response = client.getBook("a")

        response.enqueue(object: Callback<Item> {
            @SuppressLint("NotifyDataSetChanged")
            override fun onResponse(call: Call<Item>, response: Response<Item>) {
                if (response.isSuccessful) {
                    val bookData = response.body()?.items
                    bookData?.let {
                        bookList = it
                        bookAdapter = BookAdapter(bookList)
                        recyclerView.adapter = bookAdapter
                        recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
                    }
                }
            }

            override fun onFailure(call: Call<Item>, t: Throwable) {

            }

        })

        with(binding) {
            recyclerView = rvBook
        }

    }
}

//override fun onResponse(call: Call<Item>, response: Response<Item>) {
//    if (response.isSuccessful) {
//        binding.lsView.text = response.body()?.items.toString()
//    }
//}
//
//override fun onFailure(call: Call<Item>, t: Throwable) {
//
//}

