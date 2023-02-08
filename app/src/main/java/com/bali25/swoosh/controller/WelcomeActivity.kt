package com.bali25.swoosh.controller

import android.content.Intent
import android.os.Bundle
import com.bali25.swoosh.databinding.ActivityWelcomeBinding
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.R

class WelcomeActivity : BaseActivity() {
    private lateinit var binding: ActivityWelcomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_welcome)
        binding.getStartedBtn.setOnClickListener {
            val leagueIntent = Intent(this, LeagueActivity::class.java)
            startActivity(leagueIntent)
        }
    }
}