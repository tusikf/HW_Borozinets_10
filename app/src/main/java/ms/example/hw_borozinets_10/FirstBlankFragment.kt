package ms.example.hw_borozinets_10

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        savedInstanceState?.let { bundle ->
            bundle.getString("Key", "default value")
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

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putString("Key", "string")
        super.onSaveInstanceState(outState)
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