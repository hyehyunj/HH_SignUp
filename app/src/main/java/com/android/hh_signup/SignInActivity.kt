 package com.android.hh_signup

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat




class SignInActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signin)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //뷰연결
        val etId = findViewById<EditText>(R.id.et_signIn_id)
        val etPwd = findViewById<EditText>(R.id.et_signIn_pwd)
        val btnSignIn = findViewById<ConstraintLayout>(R.id.btn_signIn_signIn)
        val btnSignUp = findViewById<ConstraintLayout>(R.id.btn_signIn_signUp)

//        var nameData = ""
//        var genderData = ""
//        var ageData = ""

        //회원가입데이터
//        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            result : ActivityResult ->
//            if(result.resultCode == RESULT_OK) {
//                val userData = result.data?.getParcelableExtra<UserClass>("userData") ?: ""
//            }
//        }
        val userData = intent.getParcelableExtra<UserClass>("userData")
        etId.setText(userData?.name)
        etPwd.setText(userData?.pwd)

//        val getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
//            result : ActivityResult ->
//            if(result.resultCode == RESULT_OK) {
//                val signUpIdData = result.data?.getStringExtra("idFromSignUpActivity") ?: ""
//                val signUpPwdData = result.data?.getStringExtra("pwdFromSignUpActivity") ?: ""
//                nameData = result.data?.getStringExtra("nameFromSignUpActivity") ?: ""
//                genderData = result.data?.getStringExtra("genderFromSignUpActivity") ?: ""
//                ageData = result.data?.getStringExtra("ageFromSignUpActivity") ?: ""
//                etId.setText(signUpIdData)
//                etPwd.setText(signUpPwdData)
//            }
//        }

        //로그인버튼
        btnSignIn.setOnClickListener {
            val idData = etId.text
            val pwdData = etPwd.text
            if (idData.isBlank() || pwdData.isBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            }
            else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userData",userData)
//                intent.putExtra("nameFromSignInActivity",nameData)
//                intent.putExtra("genderFromSignInActivity",genderData)
//                intent.putExtra("ageFromSignInActivity",ageData)
                startActivity(intent)
            }
        }
        //회원가입버튼
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}
