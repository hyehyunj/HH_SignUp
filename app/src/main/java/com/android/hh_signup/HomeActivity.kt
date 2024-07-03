package com.android.hh_signup

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_home)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //뷰연결
        val ivroom = findViewById<ImageView>(R.id.iv_home_image)
        val tvId = findViewById<TextView>(R.id.tv_home_userId)
        val tvName = findViewById<TextView>(R.id.tv_home_userName)
        val tvGender = findViewById<TextView>(R.id.tv_home_userGender)
        val tvAge = findViewById<TextView>(R.id.tv_home_userAge)
        val btnFinish = findViewById<ConstraintLayout>(R.id.btn_home_finish)

        //회원가입데이터 받아오기
        val userData = intent.getParcelableExtra<UserClass>("userData")
        tvId.text = userData?.id
        tvName.text = "${userData?.name} 님"
        tvGender.text = userData?.gender
        tvAge.text = "${userData?.age} 세"

        //랜덤사진
        when(Random.nextInt(1,6)) {
        1 -> ivroom.setImageResource(R.drawable.img_room_1)
        2 -> ivroom.setImageResource(R.drawable.img_room_2)
        3 -> ivroom.setImageResource(R.drawable.img_room_3)
        4 -> ivroom.setImageResource(R.drawable.img_room_4)
        5 -> ivroom.setImageResource(R.drawable.img_room_5)
        }

        //종료버튼
        btnFinish.setOnClickListener {
            finish()
        }
    }
}