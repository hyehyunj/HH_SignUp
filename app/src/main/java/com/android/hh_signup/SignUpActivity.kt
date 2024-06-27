package com.android.hh_signup

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_sign_up)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //뷰연결
        val etId = findViewById<EditText>(R.id.et_signUp_id)
        val etPwd = findViewById<EditText>(R.id.et_signUp_pwd)
        val etName = findViewById<EditText>(R.id.et_signUp_name)
        val rgGender = findViewById<RadioGroup>(R.id.rg_gender)
        val etAge = findViewById<EditText>(R.id.et_signUp_age)
        val btnSignUp = findViewById<ConstraintLayout>(R.id.btn_signUp_signUp)

        //회원가입데이터
        val idData = etId.text
        val pwdData = etPwd.text
        val nameData = etName.text
        var genderData : String = ""
        val ageData = etAge.text

        //라디오버튼
        rgGender.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.rb_male -> genderData = "남성"
                R.id.rb_female -> genderData = "여성"
            }
        }

        //회원가입버튼
        btnSignUp.setOnClickListener {
            if (idData.isBlank() || pwdData.isBlank() || nameData.isBlank() || genderData.isBlank() || ageData.isBlank()) {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "회원가입 완료", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("userData", UserClass(idData.toString(),pwdData.toString(),nameData.toString(),genderData,ageData.toString()))
                startActivity(intent)

//                val intent = Intent(this, SignInActivity::class.java)
//                intent.putExtra("idFromSignUpActivity",idData.toString())
//                intent.putExtra("pwdFromSignUpActivity",pwdData.toString())
//                intent.putExtra("nameFromSignUpActivity",nameData.toString())
//                intent.putExtra("genderFromSignUpActivity",genderData)
//                intent.putExtra("ageFromSignUpActivity",ageData.toString())
//                setResult(RESULT_OK,intent)
//                finish()
            }
        }
    }
}