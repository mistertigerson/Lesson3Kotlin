package com.example.lesson3kotlin

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson3kotlin.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {

    private lateinit var adapter2: MyAdapter2
    private lateinit var viewBinding: ActivityMain2Binding
    private var list = arrayListOf<Int>()
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        registerForActivity()
        createList()
        initRecycler()
    }

    private fun registerForActivity() {
        resultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                if (result.resultCode == Activity.RESULT_OK){
                    result.data?.getIntegerArrayListExtra(TEXT)?.let { list.addAll(it)
                    }
                }}
    }

    private fun createList() {
        intent.getIntegerArrayListExtra(TEXT)?.let { list.addAll(it) }
    }

    private fun initRecycler() {
        adapter2 = MyAdapter2()
        adapter2.setList(list)
        viewBinding.myRv2.adapter = adapter2
    }
}