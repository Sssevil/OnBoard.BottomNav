package com.example.tablayout.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.tablayout.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewPager()
        setupListeners()
    }

    private fun setupViewPager() {
        val adapter= ViewPagerAdapter(supportFragmentManager)
        viewPager.adapter=adapter
        adapter.addFragment(InfoFragment())
        adapter.addFragment(AudioFragment())
        adapter.addFragment(CommentsFragment())
    }

    private fun setupListeners() {
        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.inf->viewPager.currentItem=0
                R.id.audio->viewPager.currentItem=1
                R.id.comments->viewPager.currentItem=2
            }
            return@setOnNavigationItemSelectedListener true
        }
    }
}