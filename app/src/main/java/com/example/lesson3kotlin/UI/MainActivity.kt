package com.example.lesson3kotlin.UI

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import android.util.Log
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson3kotlin.BaseActivity
import com.example.lesson3kotlin.adapters.MyAdapter
import com.example.lesson3kotlin.R
import com.example.lesson3kotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity<ActivityMainBinding>() {

    private lateinit var adapter: MyAdapter
    private var list = arrayListOf<Int>()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>
    private var imagesList = arrayListOf<Int>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        createList()
        initRecycler()
        registerForActivity()
        onClickFab()

    }

    private fun onClickFab() {
        viewBinding.fab.setOnClickListener {
            openActivityForResult(imagesList)

        }
    }

    private fun openActivityForResult(imageView: ArrayList<Int>) {
        Intent(this, MainActivity2::class.java).apply {
            putExtra(TEXT, imageView)
            resultLauncher.launch(this)
        }
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK) {
                    Log.e("TAG", "registerForActivity: $result")
                }
            }
    }

    private fun createList() {
            list.add(viewBinding)
            list.add(R.drawable.first)
            list.add(R.drawable.image)
            list.add(R.drawable.scale_1200)

    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(inflater)
    }

    override fun clickListener() {

    }

    override fun setUI() {
    }

    override fun checkInternet() {
    }

    override fun initRecycler() {
        adapter = MyAdapter(object : MyAdapter.OnItemClick {
            override fun onClick(image: Int) {
                imagesList.add(image)

            }

            override fun deleteClick(image: Int) {
                imagesList.remove(image)
            }
        })
        adapter.setList(list)
        viewBinding.myRv.adapter = adapter
    }
}