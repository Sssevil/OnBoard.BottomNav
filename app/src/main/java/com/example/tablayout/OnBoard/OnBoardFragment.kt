package com.example.tablayout.OnBoard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tablayout.R
import com.example.tablayout.data.OnBoardData
import kotlinx.android.synthetic.main.fragment_on_board.*

class OnBoardFragment:Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_on_board,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupView(){
        val data=arguments?.get(DATA_ID) as OnBoardData
        tvTitle.text=data.title
        tvDesc.text=data.desc
        image.setImageResource(data.image)
    }

    companion object{
        const val DATA_ID="DATA_ID"

        fun getInstance(data:OnBoardData): OnBoardFragment {
            val fragment= OnBoardFragment()
            val bundle=Bundle()
            bundle.putParcelable(DATA_ID,data)
            fragment.arguments=bundle
            return fragment
        }
    }
}