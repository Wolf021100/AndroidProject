package wolf.tp.com

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_login.btnLogin_convertForm
import kotlinx.android.synthetic.main.activity_login.btnSignUp_loginForm
import kotlinx.android.synthetic.main.activity_login.btnSubmit
import kotlinx.android.synthetic.main.activity_sign_up.*
import kotlin.math.log

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        btnSignUp_loginForm.setOnClickListener(::onClickSignUp)
        btnLogin_convertForm.setOnClickListener(::onClickLogin_Convert)
        btnSubmit.setOnClickListener(::onClickSubmitForm)

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        Toast.makeText(applicationContext,"dasd",Toast.LENGTH_SHORT).show()
        super.onActivityResult(requestCode, resultCode, data)
        if(resultCode== RESULT_OK)
            btnSubmit.text = data?.getStringExtra("id")
    }
    private fun login()
    {
        val intent = Intent(this,Menu_Activity::class.java)
        intent.putExtra("id1","HIHI I am Wolf")
        startActivityForResult(intent,2)
    }
    private  fun register()
    {

    }
    private fun onClickSubmitForm(view: View?) {
        if((view as Button).text.toString() == btnLogin_convertForm.text.toString())
                login()
        else register()

    }

    private fun setTextBtnSubmit(view: View?)
    {
        btnSubmit.text = (view as Button).text.toString()
    }
    private fun onClickLogin_Convert(view: View?)
    {
        setBackgroundLoginConvertButton(view as Button)
        txtConfirmPass.visibility = View.INVISIBLE
        idRoot.setBackgroundResource(R.mipmap.login)
        setTextBtnSubmit(view)
    }
    private fun setBackgroundLoginConvertButton(bt: Button)
    {
        bt.setBackgroundResource(R.drawable.loginbutton_shape)
        if(bt.id == btnLogin_convertForm.id)
            btnSignUp_loginForm.setBackgroundResource(R.drawable.signup_button_shape)
        else btnLogin_convertForm.setBackgroundResource(R.drawable.signup_button_shape)
    }
    private fun onClickSignUp(view: View)
    {
        setBackgroundLoginConvertButton(view as Button)
        txtConfirmPass.visibility = View.VISIBLE
        idRoot.setBackgroundResource(R.mipmap.signup)
        setTextBtnSubmit(view)
    }
}