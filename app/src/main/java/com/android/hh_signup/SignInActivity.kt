package com.android.hh_signup

import android.content.Intent
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class SignInActivity : AppCompatActivity() {
    //인스턴스와 런처
    private var userData: UserClass = UserClass("", "", "", "", "")
    private lateinit var getResult: ActivityResultLauncher<Intent>

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

        //회원가입데이터 받아오기
        getResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result: ActivityResult ->
            if (result.resultCode == RESULT_OK) {
                userData = result.data?.getParcelableExtra("userData")!!
                etId.setText(userData.id)
                etPwd.setText(userData.pwd)
            }
        }

        //로그인버튼
        btnSignIn.setOnClickListener {
            etId.text
            etPwd.text
            userData.id = etId.text.toString()
            if (etId.text.isBlank() || etPwd.text.isBlank()) {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요.", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("userData", userData)
                startActivity(intent)
            }
        }
        //회원가입버튼
        btnSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            getResult.launch(intent)
        }
    }
}

