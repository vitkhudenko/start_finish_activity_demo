package vit.khundenko.android.startfinishactivity.demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_another.*
import java.util.concurrent.atomic.AtomicInteger

class AnotherActivity : AppCompatActivity() {

    companion object {
        private val INSTANCE_COUNT = AtomicInteger(0)

        private const val KEY_STATE_INSTANCE_ID = "key_state_instance_id"
    }

    private lateinit var activityInstanceId: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_another)

        activityInstanceId = savedInstanceState?.getString(KEY_STATE_INSTANCE_ID)
            ?: INSTANCE_COUNT.incrementAndGet().toString()

        textViewId.text = getString(R.string.activity_instance_id, activityInstanceId)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(KEY_STATE_INSTANCE_ID, activityInstanceId)
    }

    fun onButtonShowToastClicked(@Suppress("UNUSED_PARAMETER") view: View) {
        val message = getString(R.string.activity_instance_id, activityInstanceId)
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}
