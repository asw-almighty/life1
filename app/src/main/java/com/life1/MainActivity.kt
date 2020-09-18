package com.life1

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var modelList = arrayListOf<Model>(
                Model("a", "b"),
                Model("c", "d")
        )

        //adapter 연결하기
        val mAdapter = MainRvAdapter(this, modelList)
        mRecyclerView.adapter = mAdapter

        //layout 설정
//        val lm = LinearLayoutManager(this)
//        mRecyclerView.layoutManager = lm

        //layout을 한줄에 두개가 들어가도록 설정
        mRecyclerView.apply{
            layoutManager = GridLayoutManager(this@MainActivity, 2)
        }

        //webview
//        test_button.setOnClickListener{
//            var intent = Intent(this, WebViewActivity::class.java)
//            startActivity(intent)
//        }

        /**각각의 번호를 누를 때, 이벤트 설정해주기**/
        mAdapter.itemClick = object: MainRvAdapter.ItemClick{
            override fun onClick(view: View, position: Int) {
                Log.e("position: ", position.toString())
            }

        }

    }
}