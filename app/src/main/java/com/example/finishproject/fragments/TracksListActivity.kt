package com.example.finishproject.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.finishproject.ItemTrack
import com.example.finishproject.OnFragmentInteractionListener
import com.example.finishproject.OnSelectedItemListener
import com.example.finishproject.R
import com.example.finishproject.adapters.TracksAdapter
import java.text.SimpleDateFormat
import java.util.*

class TracksListActivity : Fragment(), OnSelectedItemListener {
    //    private var mOnStartFragmentListener: StartFragment? = null
    private var mOnFragmentInteractionListener: OnFragmentInteractionListener? = null
//    private lateinit var textList: List<String>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.activity_track_list, container, false)

        val pullToRefresh = view.findViewById<SwipeRefreshLayout>(R.id.pullToRefresh)
        pullToRefresh.setColorSchemeResources(R.color.colorPrimaryDark,
            R.color.colorPrimary,
            R.color.colorPrimaryLight)

        pullToRefresh.setOnRefreshListener {
            pullToRefresh.isRefreshing = true
        }

        //первый запуск
        val progressBar = view.findViewById<ProgressBar>(R.id.progressBar)
//        progressBar.visibility = ProgressBar.VISIBLE
        /*проверка данных с сервера*/
        /*если не первый запуск, показать треки, в фоне подгрузить новые, и отправить другие*/

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(view.context)

        val tracks = initializeData()
        recyclerView.adapter = TracksAdapter(tracks, this)
//        recyclerView.addOnItemTouchListener(object : RecyclerClickListener(view.context) {
//            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
//            }
//
//            override fun onItemClick(recyclerView: RecyclerView, itemView: View, position: Int) {
//                mOnFragmentInteractionListener?.onFragmentInteraction(position)
//            }
//        })

        return view
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            mOnFragmentInteractionListener = context as OnFragmentInteractionListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$context должен реализовывать интерфейс StartFragment")
        }
    }

    override fun onDetach() {
        mOnFragmentInteractionListener = null
        super.onDetach()
    }

    override fun onSelectedItem(position: Int) {
        mOnFragmentInteractionListener?.onFragmentInteraction(position)
    }

    private fun selector(item: ItemTrack): String = item.distance

    private fun initializeData(): List<ItemTrack> {
        val currentDate = Date()
//        traksArray.sortBy {selector(it)}

        val dateFormat = SimpleDateFormat("dd.MM.yyyy", Locale.getDefault())
        val dateText = dateFormat.format(currentDate)

        val timeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val timeText = timeFormat.format(currentDate)

        return listOf(ItemTrack(dateText, timeText, "1200м", "1ч 20мин"),
            ItemTrack(dateText, timeText, "2220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "2220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "2220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "220м", "2ч 0мин"),
            ItemTrack(dateText, timeText, "220м", "2ч 0мин"))
    }

}