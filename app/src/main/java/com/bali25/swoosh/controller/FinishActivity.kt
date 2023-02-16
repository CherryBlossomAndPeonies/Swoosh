package com.bali25.swoosh.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivityFinishBinding
import com.bali25.swoosh.model.Player
import com.bali25.swoosh.utilities.EXTRA_PLAYER

class FinishActivity : BaseActivity() {
    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val player = intent.getParcelableExtra(EXTRA_PLAYER, Player::class.java)!!
        binding = DataBindingUtil.setContentView(this, R.layout.activity_finish)
        binding.searchLeagueText.text = "Looking for ${player.league} ${player.skill} league near you..."
    }
}