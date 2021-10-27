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

//todo 13
class CorouViewModelActivity : AppCompatActivity() {

    private val binding: ActivityCorouViewModelBinding by viewBinding()

    //todo 17
    private lateinit var vm:CorouViewModelVM

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //todo 18
        vm = ViewModelProvider(this).get(CorouViewModelVM::class.java)

        //todo 19
        initObserver();

        //todo 21
        binding.btnRequest.setOnClickListener {
            btnRequestAction()
        }
    }

    //todo 20
    private fun initObserver() {
        vm._todo.observe(this, Observer { todo ->
            showResult(todo)
        })

        vm._error.observe(this, Observer { error ->
            if (error.isNotEmpty()) {
                showError(error)
            }
        })
    }

    private fun showError(error: String?) {
        binding.tvResult.text = "Error $error"
    }

    private fun showResult(result: Todo) {
        binding.tvResult.text = "result ${result.title}"
    }
    //end todo 21

    //todo 22
    private fun btnRequestAction() {
        val rnd = (1..66).random()
        vm.getTodo(rnd)
    }
    //end todo 22
}