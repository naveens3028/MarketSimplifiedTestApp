package com.example.marketsimplifiedtestapp.ui.dashboard

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.marketsimplifiedtestapp.adapter.DashBoardDataAdapter
import com.example.marketsimplifiedtestapp.database.AppDataBase
import com.example.marketsimplifiedtestapp.database.model.MyData
import com.example.marketsimplifiedtestapp.databinding.FragmentDashboardBinding

class DashboardFragment : Fragment() {

    private lateinit var dashboardViewModel: DashboardViewModel
    private var _binding: FragmentDashboardBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    lateinit var recycler: RecyclerView
    lateinit var db : AppDataBase

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        recycler = binding.dashBoardRecycler
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        db = AppDataBase.getInstance(requireContext())!!
        if (db.dataModelDao.getAll().isNullOrEmpty()){
            dashboardViewModel.getApiCall(requireContext(), db)
        }else{
            callAdapter(db.dataModelDao.getAll(),db)
        }

        dashboardViewModel.isDataCallCompleted?.observe(viewLifecycleOwner, Observer {
            Log.e("poppersdashout", it.toString())
            callAdapter(it,db)

        })

    }

    fun callAdapter(item: List<MyData>, db: AppDataBase?){
        val myAdapter = DashBoardDataAdapter(requireContext(), item, db!!)
        recycler.adapter = myAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}