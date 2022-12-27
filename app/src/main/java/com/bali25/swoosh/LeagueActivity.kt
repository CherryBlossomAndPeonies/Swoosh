package com.bali25.swoosh

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.databinding.ActivityLeagueBinding
import com.bali25.swoosh.databinding.ActivitySkillBinding
import com.bali25.swoosh.databinding.ActivityWelcomeBinding

class LeagueActivity : BaseActivity() {
    private lateinit var binding: ActivityLeagueBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_league)
        binding.leagueActivityBtn.setOnClickListener {
            val intent = Intent(this, SkillActivity::class.java)
            startActivity(intent)
        }
    }
}