package com.bali25.swoosh.controller

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.bali25.swoosh.R
import com.bali25.swoosh.databinding.ActivitySkillBinding
import com.bali25.swoosh.model.Player
import com.bali25.swoosh.utilities.EXTRA_PLAYER

class SkillActivity : BaseActivity() {
    private lateinit var binding: ActivitySkillBinding
    private lateinit var player: Player

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putParcelable(EXTRA_PLAYER, player)
    }

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        if (savedInstanceState != null) {
            player = savedInstanceState.getParcelable(EXTRA_PLAYER, Player::class.java)!!
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_skill)
        player = intent.getParcelableExtra(EXTRA_PLAYER, Player::class.java)!!

        binding.ballerBtn.setOnClickListener {
            binding.beginnerBtn.isChecked = false
            player.skill = "Baller"
        }

        binding.skillFinishBtn.setOnClickListener {
            if (player.skill != "") {
                val finishActivity = Intent(this, FinishActivity::class.java)
                finishActivity.putExtra(EXTRA_PLAYER, player)
                startActivity(finishActivity)
            } else {
                Toast.makeText(this,"Please select a skill", Toast.LENGTH_SHORT).show()
            }
        }

        binding.beginnerBtn.setOnClickListener {
            player.skill = "Beginner"
            binding.ballerBtn.isChecked = false
        }
    }
}