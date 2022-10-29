package com.santimattius.android.compose.talk.migration.finished.step_01

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.santimattius.android.compose.talk.R
import com.santimattius.android.compose.talk.migration.placeholder.PlaceholderContent

/**
 * A fragment representing a list of Items.
 */
class ItemFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item_list, container, false)
        // Set the adapter
        if (view is RecyclerView) {
            val items = PlaceholderContent.ITEMS
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = ItemRecyclerViewAdapter(items) {
                    Toast.makeText(requireContext(), it.content, Toast.LENGTH_SHORT).show()
                }
            }
        }
        return view
    }
}