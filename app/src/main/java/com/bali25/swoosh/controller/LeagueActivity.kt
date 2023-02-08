package com.bali25.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.utilities.EXTRA_LEAGUE
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivityLeagueBinding

class LeagueActivity : BaseActivity() {
    private lateinit var binding: ActivityLeagueBinding
    private var selectedLeague = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_league)
        binding.leagueActivityBtn.setOnClickListener {
            if (selectedLeague != "") {
                val intent = Intent(this, SkillActivity::class.java)
                intent.putExtra(EXTRA_LEAGUE, selectedLeague)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.mensLeagueBtnId.setOnClickListener {
            binding.womensLeagueBtnId.isChecked = false
            binding.coedLeagueBtnId.isChecked = false

            selectedLeague = "Mens"
        }

        binding.womensLeagueBtnId.setOnClickListener {
            binding.mensLeagueBtnId.isChecked = false
            binding.coedLeagueBtnId.isChecked = false

            selectedLeague = "Womens"
        }

        binding.coedLeagueBtnId.setOnClickListener {
            binding.womensLeagueBtnId.isChecked = false
            binding.mensLeagueBtnId.isChecked = false

            selectedLeague = "Co-Ed"
        }
    }
}