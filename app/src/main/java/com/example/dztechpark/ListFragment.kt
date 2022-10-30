package com.example.dztechpark

import android.content.res.Configuration
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dztechpark.databinding.FragmentListBinding

class ListFragment : Fragment() {
    private companion object {
        private const val LAST_NUMBER = "LastNumber"
    }

    private lateinit var binding: FragmentListBinding
    private var lastNumber = 50

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (savedInstanceState != null) {
            val k = savedInstanceState.getInt(LAST_NUMBER)
            if (k > 50)
                lastNumber = k
        }
        val numbers: MutableList<Int> = generateListOfNumbers()


        val recyclerViewAdapter = RecyclerViewAdapter(numbers)
        binding.recyclerView.adapter = recyclerViewAdapter
        val orientation = resources.configuration.orientation
        if (orientation == Configuration.ORIENTATION_PORTRAIT) {
            binding.recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3)
        } else {
            binding.recyclerView.layoutManager = GridLayoutManager(requireActivity(), 4)
        }
        binding.buttonAdd.setOnClickListener {
            lastNumber++
            numbers.add(lastNumber)
            recyclerViewAdapter.notifyItemInserted(lastNumber)
        }
    }

    private fun generateListOfNumbers(): MutableList<Int> {
        val numbers: MutableList<Int> = mutableListOf()
        for (i in 1..lastNumber) {
            numbers.add(i)
        }
        return numbers
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(LAST_NUMBER, lastNumber)
    }


}