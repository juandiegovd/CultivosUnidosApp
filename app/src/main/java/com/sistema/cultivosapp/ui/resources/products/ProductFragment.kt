package com.sistema.cultivosapp.ui.resources.products

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sistema.cultivosapp.R
import com.sistema.cultivosapp.databinding.FragmentProductBinding
import com.sistema.cultivosapp.ui.resources.OnClickListener

class ProductFragment: Fragment(), OnClickListener {
    private var _binding: FragmentProductBinding? = null
    private val binding get() = _binding!!

    private lateinit var mAdapter: ProductAdapter
    private lateinit var mGridLayout: GridLayoutManager

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View?  {
        super.onCreate(savedInstanceState)
        _binding = FragmentProductBinding.inflate(layoutInflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
    }

    private fun setupRecyclerView() {
        mAdapter = ProductAdapter(mutableListOf(), this)
        mGridLayout =GridLayoutManager(this.activity, 1)
        val prod1 = ProductModel(1L, "Arroz Seco", 50)
        val prod2 = ProductModel(2L, "Arroz Mojado", 30)

        mAdapter.add(prod1)
        mAdapter.add(prod2)

        binding.rvProduct.apply {
            setHasFixedSize(true)
            layoutManager = mGridLayout
            adapter = mAdapter
        }
    }

    override fun onClick(productId: Long) {
        val args = Bundle()
        args.putLong("key_id", productId)

        launchViewFragment(args)
    }

    private fun launchViewFragment(args: Bundle? = null) {
        val fragment = ViewProductFragment()
        if (args != null) fragment.arguments = args

        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        fragmentTransaction.add(R.id.containerProduct, fragment)
        fragmentTransaction.commit()
        fragmentTransaction.addToBackStack(null)
    }
}