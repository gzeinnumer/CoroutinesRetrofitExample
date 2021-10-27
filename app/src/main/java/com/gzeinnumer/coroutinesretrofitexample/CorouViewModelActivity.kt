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
    }

    private fun showError(error: String?) {
        Toast.makeText(this, "Error $error", Toast.LENGTH_SHORT).show()
    }

    private fun showResult(result: Todo) {
        Log.d("debug", "tag result $result")
        Toast.makeText(this, "result ${result.title}", Toast.LENGTH_SHORT).show()
    }

    private fun btnRequestAction() {
        val rnd = (1..66).random()
        vm.getTodo(rnd)
    }
}