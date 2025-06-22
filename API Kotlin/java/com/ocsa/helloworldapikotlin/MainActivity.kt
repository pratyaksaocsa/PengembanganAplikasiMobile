package com.ocsa.helloworldapikotlin

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.ocsa.helloworldapikotlin.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MyViewModel
    private val allUsers = mutableListOf<User>()
    private var currentIndex = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        viewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        viewModel.users.observe(this) { users ->
            run {
                allUsers.clear()
                allUsers.addAll(users)
                val user = users.get(currentIndex)
                binding.txtFirstName.text = user.firstName
                binding.txtLastName.text = user.lastName
                binding.txtUniversity.text = user.university
            }
        }
        viewModel.errorMessage.observe(this) { errorMessage ->
            run {
                binding.txtFirstName.text = errorMessage
            }
        }

        binding.btnGetUsers.setOnClickListener {
            viewModel.fetchUsers()
        }
    }
}