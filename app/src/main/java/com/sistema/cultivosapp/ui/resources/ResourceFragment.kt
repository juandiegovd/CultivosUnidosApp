package com.sistema.cultivosapp.ui.resources

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.sistema.cultivosapp.R
import com.sistema.cultivosapp.databinding.FragmentResourceBinding
import androidx.fragment.app.FragmentPagerAdapter
import com.sistema.cultivosapp.ui.resources.products.ProductFragment
import com.sistema.cultivosapp.ui.resources.supplies.SupplyFragment


class ResourceFragment: Fragment() {

    private var _binding: FragmentResourceBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_resource, container, false)
        val viewPager = view.findViewById<ViewPager>(R.id.resourcevp)
        setupViewPager(viewPager)
        val tabs = view.findViewById<TabLayout>(R.id.tabResources)
        tabs.setupWithViewPager(viewPager)
        return view
    }

    private fun setupViewPager(viewPager: ViewPager) {
        val adapter = Adapter(childFragmentManager)
        adapter.addFragment(ProductFragment(), "PRODUCTO")
        adapter.addFragment(SupplyFragment(), "INSUMO")

        viewPager.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    internal class Adapter(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        private val mFragmentList: MutableList<Fragment> = ArrayList()
        private val mFragmentTitleList: MutableList<String> = ArrayList()
        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return mFragmentList.size
        }

        fun addFragment(fragment: Fragment, title: String) {
            mFragmentList.add(fragment)
            mFragmentTitleList.add(title)
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return mFragmentTitleList[position]
        }
    }

}