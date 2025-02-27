package ms.example.hw_borozinets_10

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import ms.example.hw_borozinets_10.databinding.FragmentFirstBlankBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstBlankFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstBlankFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private var _binding: FragmentFirstBlankBinding? = null
    private val binding get() = _binding!!

    private var timervalue = 0
    private var flag = false

    private var timer: CountDownTimer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { bundle ->
            flag=bundle.getBoolean("Key", true)
        }
        Log.d("TAG".toString(), "onCreate Fragment")
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFirstBlankBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (flag){
            startCountDownTimer(binding.progressline.progress.toLong()*1000)
            binding.buttonstart.text= resources.getString(R.string.stop)


        } else {

            binding.slider.addOnChangeListener { slider, value, fromUser ->
                timervalue = binding.slider.value.toInt()
                binding.timer.text= timervalue.toString()
                binding.progressline.progress = timervalue
                binding.progressline.max = timervalue
            }
            binding.buttonstart.setOnClickListener {

                flag = true
                binding.buttonstart.text= resources.getString(R.string.stop)
                startCountDownTimer(timervalue.toLong()*1000)

            }
        }



    }
    private fun startCountDownTimer(timeSecond:Long){
        timer?.cancel()
        timer = object : CountDownTimer(timeSecond, 1000){
            override fun onTick(p0: Long) {
                binding.progressline.progress--
                binding.timer.text = (p0/1000).toString()

            }

            override fun onFinish() {
                //Toast.makeText(this@FirstBlankFragment, "Timer is Finish", Toast.LENGTH_SHORT).show()
                Snackbar.make(binding.root, "Timer is Finish", Snackbar.LENGTH_LONG).show()
                binding.slider.value=0.0F
                binding.slider.isEnabled = true
                binding.buttonstart.text = "Start"
            }

        }.start()

    }



    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("Key", flag)
    }




    override fun onStart() {
        super.onStart()
        Log.d("TAG".toString(), "onStart Fragment")
        println("yes Start Fragment")
    }

    override fun onResume() {
        super.onResume()
        Log.d("TAG".toString(), "onResume Fragment")
        println("yes Resume Fragment")
    }

    override fun onPause() {
        super.onPause()
        Log.d("TAG".toString(), "onPause Fragment")
        println("yes Pause Fragment")
    }

    override fun onStop() {
        super.onStop()
        Log.d("TAG".toString(), "onStop Fragment")
        println("yes Stop Fragment")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("TAG".toString(), "onDestroy Fragment")
        println("yes Destroy it Fragment")
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstBlankFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstBlankFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}