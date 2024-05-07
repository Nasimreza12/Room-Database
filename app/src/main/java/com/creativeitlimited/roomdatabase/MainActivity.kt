package com.creativeitlimited.roomdatabase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.creativeitlimited.roomdatabase.databinding.ActivityMainBinding
import com.creativeitlimited.roomdatabase.db.User
import com.creativeitlimited.roomdatabase.db.UserDatabase

class MainActivity : AppCompatActivity() {
    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val nasim= User(0,"Nasim Reza",23,"01704487996")

        val db=Room.databaseBuilder(applicationContext, UserDatabase::class.java,"Userdb")
            .allowMainThreadQueries().build()

        val dao=db.getUserDao()

        binding.userBtn.setOnClickListener{
            dao.addUser(nasim)
        }
    }
}