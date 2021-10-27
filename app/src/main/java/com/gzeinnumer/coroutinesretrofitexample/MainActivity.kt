package com.gzeinnumer.coroutinesretrofitexample

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.viewbinding.library.activity.viewBinding
import androidx.lifecycle.lifecycleScope
import com.gzeinnumer.coroutinesretrofitexample.data.model.Todo
import com.gzeinnumer.coroutinesretrofitexample.databinding.ActivityMainBinding
import com.gzeinnumer.coroutinesretrofitexample.data.repository.TodoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by viewBinding()

    private lateinit var repository: TodoRepository;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //todo 10
        repository = TodoRepository()

        binding.btnNoViewmodel.setOnClickListener {
            //todo 11
            btnNoViewmodelAction()
        }

        //todo 14
        binding.btnToActivityViewmodel.setOnClickListener {
            startActivity(Intent(applicationContext, CorouViewModelActivity::class.java))
        }
    }

    //todo 12
    private fun btnNoViewmodelAction() {
        lifecycleScope.launch {
            val rnd = (1..66).random()
            val result = withContext(Dispatchers.IO) { repository.getTodo(rnd) }
            showResult(result)
        }
    }

    private fun showResult(result: Todo) {
        binding.tvResult.text = result.toString()
    }
    //end todo 12
}