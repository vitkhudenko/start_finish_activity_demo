package vit.khundenko.android.startfinishactivity.demo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonStartFinishClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        startActivity(Intent(this, AnotherActivity::class.java))
        finish()
    }

    fun onButtonFinishStartClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        finish()
        startActivity(Intent(this, AnotherActivity::class.java))
    }
}
