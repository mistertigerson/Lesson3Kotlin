package com.example.lesson3kotlin

import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding> : AppCompatActivity() {

    protected lateinit var viewBinding: VB
    protected abstract fun inflateVB(inflater: LayoutInflater) : VB

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = inflateVB(layoutInflater)
        setContentView(viewBinding.root)

        checkInternet()
        setUI()
        initRecycler()
        clickListener()

    }

    abstract fun initRecycler()

    abstract fun clickListener()

    abstract fun setUI()

    abstract fun checkInternet()

}