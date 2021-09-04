package com.example.marketsimplifiedtestapp.helper


import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.marketsimplifiedtestapp.ui.dashboard.DashboardFragment
import com.example.marketsimplifiedtestapp.ui.home.HomeFragment
import com.example.marketsimplifiedtestapp.ui.notifications.NotificationsFragment

/**
 * Created by Prabhu2757 on 19-06-2016.
 */
class HomeTabViewAdapter(fm: FragmentActivity) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        if (position == 0) {
            return DashboardFragment.newInstance("","")
        } else if (position == 1) {
            return HomeFragment()
        } else {
            return NotificationsFragment.newInstance("", "")
        }
    }
}
