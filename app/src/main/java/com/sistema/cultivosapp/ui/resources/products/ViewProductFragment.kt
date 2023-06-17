package com.sistema.cultivosapp.ui.resources.products

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.sistema.cultivosapp.MainActivity
import com.sistema.cultivosapp.databinding.FragmentViewProductBinding

class ViewProductFragment: Fragment() {
    private lateinit var mBinding: FragmentViewProductBinding
    private var mActivity: MainActivity? = null
    private var mIsEditMode: Boolean = false
    private var mProductModel: ProductModel? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        mBinding = FragmentViewProductBinding.inflate(inflater, container, false)

        return mBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = arguments?.getLong("key_id", 0)
        mIsEditMode = false
        if (id != null && id != 0L)
            getProduct(id)
    }

    private fun getProduct(id: Long) {
        mProductModel = ProductModel(1L, "Arroz Seco", 50)
        if (mProductModel != null)
            setUiProduct(mProductModel!!)
    }

    private fun String.editable(): Editable = Editable.Factory.getInstance().newEditable(this)

    private fun setUiProduct(mProductModel: ProductModel) {
        with(mBinding){
            etProdName.text = mProductModel.name.editable()
            etProdCant.text = mProductModel.cant.toString().editable()
        }
    }
}