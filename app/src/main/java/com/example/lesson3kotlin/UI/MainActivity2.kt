package com.example.lesson3kotlin.UI

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.Telephony.Mms.Part.TEXT
import android.view.LayoutInflater
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import com.example.lesson3kotlin.BaseActivity
import com.example.lesson3kotlin.adapters.MyAdapter2
import com.example.lesson3kotlin.databinding.ActivityMain2Binding

class MainActivity2 : BaseActivity<ActivityMain2Binding>() {

    private lateinit var adapter2: MyAdapter2
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
                if (result.resultCode == Activity.RESULT_OK) {
                    result.data?.getIntegerArrayListExtra(TEXT)?.let {
                        list.addAll(it)
                    }
                }
            }
    }

    private fun createList() {
        intent.getIntegerArrayListExtra(TEXT)?.let { list.addAll(it) }
    }

    override fun inflateVB(inflater: LayoutInflater): ActivityMain2Binding {
        return ActivityMain2Binding.inflate(inflater)
    }

    override fun clickListener() {
    }

    override fun setUI() {
    }

    override fun checkInternet() {
    }

    override fun initRecycler() {
        adapter2 = MyAdapter2()
        adapter2.setList(list)
        viewBinding.myRv2.adapter = adapter2
    }
}