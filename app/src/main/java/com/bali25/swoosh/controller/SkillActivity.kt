package com.bali25.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.utilities.EXTRA_LEAGUE
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivitySkillBinding
import com.bali25.swoosh.utilities.EXTRA_SKILL

class SkillActivity : BaseActivity() {
    private var league = ""
    private var skill = ""
    private lateinit var binding: ActivitySkillBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_skill)
        league = intent.getStringExtra(EXTRA_LEAGUE)!!

        binding.ballerBtn.setOnClickListener {
            binding.beginnerBtn.isChecked = false
            skill = "Baller"
        }

        binding.skillFinishBtn.setOnClickListener {
            if (league != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_LEAGUE, league)
                finishActivity.putExtra(EXTRA_SKILL, skill)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this,"Please select a skill", Toast.LENGTH_SHORT).show()
            }
        }

        binding.beginnerBtn.setOnClickListener {
            skill = "Beginner"
            binding.ballerBtn.isChecked = false
        }
    }
}