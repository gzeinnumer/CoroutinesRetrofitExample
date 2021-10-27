package com.gzeinnumer.coroutinesretrofitexample

import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.viewbinding.library.activity.viewBinding
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.gzeinnumer.coroutinesretrofitexample.data.model.Todo
import com.gzeinnumer.coroutinesretrofitexample.databinding.ActivityCorouViewModelBinding
import com.gzeinnumer.coroutinesretrofitexample.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_corou_view_model.*

class CorouViewModelActivity : AppCompatActivity() {

    private val binding: ActivityCorouViewModelBinding by viewBinding()

    private lateinit var vm:CorouViewModelVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vm = ViewModelProvider(this).get(CorouViewModelVM::class.java)

        initObserver();

        binding.btnRequest.setOnClickListener {
            btnRequestAction()
        }

        //todo 29
        binding.btnRequestList.setOnClickListener {
            btnRequestListAction()
        }
    }

    private fun btnRequestListAction() {

    }

    private fun initObserver() {
        vm._todo.observe(this, Observer { todo ->
            showResult(todo)
        })

        vm._error.observe(this, Observer { error ->
            if (error.isNotEmpty()) {
                showError(error)
            }
        })

        //todo 28
        vm._users.observe(this, Observer { users ->
            binding.tvResultList.text = users.toString()
        })
    }

    private fun showError(error: String?) {
        binding.tvResult.text = "Error $error"
    }

    private fun showResult(result: Todo) {
        binding.tvResult.text = "result ${result.title}"
    }

    private fun btnRequestAction() {
        val rnd = (1..66).random()
        vm.getTodo(rnd)
    }
}