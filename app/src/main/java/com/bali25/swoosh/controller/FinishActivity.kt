package com.bali25.swoosh.controller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivityFinishBinding
import com.bali25.swoosh.utilities.EXTRA_LEAGUE
import com.bali25.swoosh.utilities.EXTRA_SKILL

class FinishActivity : BaseActivity() {
    private lateinit var binding: ActivityFinishBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val league = intent.getStringExtra(EXTRA_LEAGUE)
        val skill = intent.getStringExtra(EXTRA_SKILL)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_finish)
        binding.searchLeagueText.text = "Looking for $league $skill league near you..."
    }
}