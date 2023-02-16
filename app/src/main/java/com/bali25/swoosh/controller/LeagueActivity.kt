package com.bali25.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivityLeagueBinding
import com.bali25.swoosh.model.Player
import com.bali25.swoosh.utilities.EXTRA_PLAYER

class LeagueActivity : BaseActivity() {
    private lateinit var binding: ActivityLeagueBinding
    private var player = Player("","")

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        player = savedInstanceState.getParcelable(EXTRA_PLAYER, Player::class.java)!!
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_league)
        binding.leagueActivityBtn.setOnClickListener {
            if (player.league != "") {
                val intent = Intent(this, SkillActivity::class.java)
                intent.putExtra(EXTRA_PLAYER, player)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please select a league.", Toast.LENGTH_SHORT).show()
            }
        }

        binding.mensLeagueBtnId.setOnClickListener {
            binding.womensLeagueBtnId.isChecked = false
            binding.coedLeagueBtnId.isChecked = false

            player.league = "Mens"
        }

        binding.womensLeagueBtnId.setOnClickListener {
            binding.mensLeagueBtnId.isChecked = false
            binding.coedLeagueBtnId.isChecked = false

            player.league = "Womens"
        }

        binding.coedLeagueBtnId.setOnClickListener {
            binding.womensLeagueBtnId.isChecked = false
            binding.mensLeagueBtnId.isChecked = false

            player.league = "Co-Ed"
        }
    }
}