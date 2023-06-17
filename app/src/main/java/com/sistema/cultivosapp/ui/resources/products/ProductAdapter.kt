package com.sistema.cultivosapp.ui.resources.products

import android.content.Context
import android.content.Entity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sistema.cultivosapp.R
import com.sistema.cultivosapp.databinding.ItemProductBinding
import com.sistema.cultivosapp.ui.resources.OnClickListener

class ProductAdapter(private var products: MutableList<ProductModel>, private var listener: OnClickListener):
    RecyclerView.Adapter<ProductAdapter.ViewHolder>(){

    private lateinit var mContext: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        mContext = parent.context
        val view = LayoutInflater.from(mContext).inflate(R.layout.item_product, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val product = products.get(position)

        with(holder){
            setListener(product)
            binding.productName.text = product.name
            binding.productCant.text = String.format(product.cant.toString() + " SACOS")
        }
    }

    override fun getItemCount(): Int = products.size

    fun setProducts(products: MutableList<ProductModel>) {
        this.products = products
        notifyDataSetChanged()
    }

    fun add(productModel: ProductModel) {
        if (!products.contains(productModel)){
            products.add(productModel)
            notifyItemInserted(products.size-1)
        }
    }

    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val binding = ItemProductBinding.bind(view)

        fun setListener(productModel: ProductModel){
            with(binding.root){
                setOnClickListener{listener.onClick(productModel.id)}
            }
        }
    }
}