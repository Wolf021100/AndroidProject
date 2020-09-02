package wolf.tp.com

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.menu_mctivity.*

class Menu_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu_mctivity)
        txvDisplay?.text = intent.extras?.getString("id1")
        btnBack.setOnClickListener(::onClickBack)
    }

    private fun onClickBack(view: View?) {
        val intent = Intent()
        intent.putExtra("id","Name of The Parameter")
        setResult(Activity.RESULT_OK,intent)
        finish()
    }
}