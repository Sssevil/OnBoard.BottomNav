package com.example.tablayout.OnBoard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.example.tablayout.R
import com.example.tablayout.data.OnBoardData
import com.example.tablayout.ui.MainActivity
import kotlinx.android.synthetic.main.activity_on_board.*

class OnBoardActivity : AppCompatActivity() {

    private val list= arrayListOf<Fragment>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_board)
        setupViewPager()
        setupListeners()
    }

    private fun setupListeners() {
        onBoardViewPager.setOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {

            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
               if(isLastPage(position)){
                   btnNext.text = "Next"
               } else {
                   btnNext.text = "Next"
               }
            }

        })

        btnNext.setOnClickListener {
            if (isLastPage(onBoardViewPager.currentItem)) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }else{
                onBoardViewPager.currentItem += 1
            }
        }

    }

    private fun isLastPage(position: Int) = position == list.size - 1

    private fun setupViewPager() {
        val adapter=
            OnBoardAdapter(supportFragmentManager)
        onBoardViewPager.adapter=adapter

        list.add(
            OnBoardFragment.getInstance(
                OnBoardData(
                    R.drawable.bars,
                    "Бараш",
                    " Сентиментальный меланхоличный баран-романтик, поэт-лирик, он вздыхает и пишет стихи о печали, любви и еде"
                )
            )
        )
        list.add(
            OnBoardFragment.getInstance(
                OnBoardData(
                    R.drawable.grhjwj,
                    "Крош",
                    "Жизнерадостный, подвижный, никогда не унывающий кролик бирюзового окраса с длинными ушами и раскосыми глазами."
                )
            )
        )
        list.add(
            OnBoardFragment.getInstance(
                OnBoardData(
                    R.drawable.pin,
                    "Пин",
                    "Изобретатель-самоучка с тремя классами образования, гениальнейший пингвин всех времён и льдин."
                )
            )
        )

        adapter.update(list)

        onBoardTab.setupWithViewPager(onBoardViewPager)
    }

}