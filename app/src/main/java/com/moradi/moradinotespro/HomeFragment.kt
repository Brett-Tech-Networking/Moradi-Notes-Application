package com.moradi.moradinotespro

import android.content.Context
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_home.*
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.moradi.moradinotespro.adapter.NotesAdapter
import com.moradi.moradinotespro.database.NotesDatabase
import kotlinx.coroutines.launch

class HomeFragment : BaseFragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    companion object {
        @JvmStatic
        fun newInstance() =
            HomeFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recycler_view.setHasFixedSize(true)

        recycler_view.layoutManager = StaggeredGridLayoutManager( 2,StaggeredGridLayoutManager.VERTICAL)

        launch {
        context?.let {
        var notes = NotesDatabase.getDatabase(it).noteDao().getAllNotes()
        recycler_view.adapter = NotesAdapter(notes)
        }
        }

        fabBtnCreateNote.setOnClickListener {
            replaceFragment(CreateNoteFragment.newInstance(), false)

            //save note
        }
    }



    fun replaceFragment(fragment: Fragment, istransition: Boolean) {
        activity?.let { activity ->
            val fragmentTransition = activity.supportFragmentManager.beginTransaction()

            if (istransition) {
                fragmentTransition.setCustomAnimations(
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left
                )
            }
            fragmentTransition.replace(R.id.frame_layout, fragment)
                .addToBackStack(fragment.javaClass.simpleName).commit()
        }
    }
}