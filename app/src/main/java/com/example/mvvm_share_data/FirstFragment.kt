package com.example.mvvm_share_data

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.mvvm_share_data.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var binding: FragmentFirstBinding? = null
    private val viewModel: CounterViewModel by activityViewModels()

    // This property is only valid between onCreateView and
    // onDestroyView.
//    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding?.buttonFirst?.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }

        viewModel.getCounter().observe(requireActivity()) {
            binding?.counterTextView?.text = "$it"
        }

        binding?.incrementButton?.setOnClickListener {
            viewModel.increment()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}