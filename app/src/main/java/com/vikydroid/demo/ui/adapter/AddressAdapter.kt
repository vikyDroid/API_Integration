package com.vikydroid.demo.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.vikydroid.demo.R
import com.vikydroid.demo.databinding.ItemAddressBinding
import com.vikydroid.demo.model.Address
import com.vikydroid.demo.viewmodel.ItemAddressVM

class AddressAdapter : RecyclerView.Adapter<AddressAdapter.ViewHolder>() {
    private var addressList: List<Address> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ItemAddressBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context), R.layout.item_address, parent, false
        )
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return addressList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(addressList[position])
    }

    fun setList(addressList: List<Address>) {
        this.addressList = addressList
        notifyDataSetChanged()
    }

    class ViewHolder(private val binding: ItemAddressBinding) : RecyclerView.ViewHolder(binding.root) {
        private val viewModel = ItemAddressVM()
        fun bind(address: Address) {
            viewModel.setAddress(address)
            binding.viewModel = viewModel
        }

    }


}