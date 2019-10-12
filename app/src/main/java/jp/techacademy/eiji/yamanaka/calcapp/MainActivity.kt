package jp.techacademy.eiji.yamanaka.calcapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_second.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener(this)
        button2.setOnClickListener(this)
        button3.setOnClickListener(this)
        button4.setOnClickListener(this)

    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)
        var value = 0.0F
        try {
            when (v.id) {
                R.id.button1 -> value = editText1.text.toString().toFloat() + editText2.text.toString().toFloat()
                R.id.button2 -> value = editText1.text.toString().toFloat() - editText2.text.toString().toFloat()
                R.id.button3 -> value = editText1.text.toString().toFloat() * editText2.text.toString().toFloat()
                R.id.button4 -> value = editText1.text.toString().toFloat() / editText2.text.toString().toFloat()
            }
            intent.putExtra("VALUE", value)
            startActivity(intent)
        } catch(e: Exception) {
            Snackbar.make(v, "値を設定してください", Snackbar.LENGTH_LONG).show()
        }
    }

}
