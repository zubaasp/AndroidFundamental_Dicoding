@file:Suppress("DEPRECATION")
package com.zuba.subs2jadi

import android.content.Context
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.zuba.subs2jadi.follow.FollowerFragment
import com.zuba.subs2jadi.follow.FollowingFragment

@Suppress("DEPRECATION")
class SectionsPagerAdapter(private val mCtx: Context, fm: FragmentManager, data : Bundle) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private var fragmentBundle: Bundle = data

    companion object {
        @StringRes
        private val TAB_TITLES = intArrayOf(R.string.tab_follower, R.string.tab_following)
    }

    override fun getItem(position: Int): Fragment {
        var fragment: Fragment? = null
        when(position) {
            0 -> fragment = FollowerFragment()
            1 -> fragment = FollowingFragment()
        }
        fragment?.arguments = this.fragmentBundle
        return fragment as Fragment
    }

    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence {
        return mCtx.resources.getString(TAB_TITLES[position])
    }

}