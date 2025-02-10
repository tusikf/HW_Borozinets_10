package ms.example.hw_borozinets_10

import android.nfc.Tag
import android.os.Bundle
import android.text.TextUtils.replace
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import ms.example.hw_borozinets_10.databinding.ActivityMainBinding
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("TAG".toString(), "onCreate Activity")
        enableEdgeToEdge()

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.button1.setOnClickListener {
            thread {
                runOnUiThread {
                    binding.button1.text = "New Name"
                }
            }
        }


        supportFragmentManager.commit {
            replace<FirstBlankFragment>(R.id.fragmentinactivity)
            addToBackStack(FirstBlankFragment::class.java.simpleName)
        }
    }

    override fun onRestart() {
        super.onRestart()
        Log.d("TAG".toString(), "onREStart")
        println("yes restart")
    }

    override fun onStart() {
        super.onStart()
        Log.d("TAG".toString(), "onStart")
        println("yes Start")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG".toString(), "onResume")
        println("yes Resume")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG".toString(), "onPause")
        println("yes Pause")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG".toString(), "onStop")
        println("yes Stop")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG".toString(), "onDestroy")
        println("yes Destroy it")
    }
}