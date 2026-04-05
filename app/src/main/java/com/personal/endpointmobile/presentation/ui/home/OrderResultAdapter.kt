package com.personal.endpointmobile.presentation.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.button.MaterialButton
import com.personal.endpointmobile.R
import com.personal.endpointmobile.domain.model.Order

class OrderResultAdapter(
    private val orders: List<Order>,
    private val mode: Mode = Mode.DELETE,
    private val onCardClick: (Order) -> Unit,
    private val onDeleteClick: (Order) -> Unit,
    private val onSubmitClick: (Order) -> Unit = {}
) : RecyclerView.Adapter<OrderResultAdapter.ViewHolder>() {

    enum class Mode { DELETE, SUBMIT }

    companion object {
        private const val STATUS_DONE = "ส่งงานแล้ว"
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val tvName: TextView = view.findViewById(R.id.tvName)
        val tvPlatform: TextView = view.findViewById(R.id.tvPlatform)
        val tvPhone: TextView = view.findViewById(R.id.tvPhone)
        val tvAddress: TextView = view.findViewById(R.id.tvAddress)
        val tvDetail: TextView = view.findViewById(R.id.tvDetail)
        val tvStatusDone: TextView = view.findViewById(R.id.tvStatusDone)
        val btnDeleteItem: MaterialButton = view.findViewById(R.id.btnDeleteItem)
        val btnSubmitItem: MaterialButton = view.findViewById(R.id.btnSubmitItem)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_order, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val order = orders[position]

        holder.tvName.text = order.name
        holder.tvPlatform.text = order.platform

        if (order.phone.isNotEmpty()) {
            val formatted = order.phone.replace(Regex("(\\d{3})(\\d{3})(\\d{1,4})"), "$1-$2-$3")
            holder.tvPhone.text = "โทร : $formatted"
            holder.tvPhone.visibility = View.VISIBLE
        } else {
            holder.tvPhone.visibility = View.GONE
        }

        val addressParts = listOf(order.subDistrict, order.district, order.province)
            .filter { it.isNotEmpty() }
        if (addressParts.isNotEmpty()) {
            holder.tvAddress.text = "ที่อยู่ : ${addressParts.joinToString(", ")}"
            holder.tvAddress.visibility = View.VISIBLE
        } else {
            holder.tvAddress.visibility = View.GONE
        }

        if (order.detail.isNotEmpty()) {
            holder.tvDetail.text = "รายละเอียด : ${order.detail}"
            holder.tvDetail.visibility = View.VISIBLE
        } else {
            holder.tvDetail.visibility = View.GONE
        }

        if (order.status == STATUS_DONE) {
            holder.tvStatusDone.visibility = View.VISIBLE
            holder.btnDeleteItem.visibility = View.GONE
            holder.btnSubmitItem.visibility = View.GONE
            holder.itemView.setOnClickListener(null)
            holder.itemView.isClickable = false
        } else {
            holder.tvStatusDone.visibility = View.GONE
            holder.itemView.isClickable = true
            holder.itemView.setOnClickListener { onCardClick(order) }

            if (mode == Mode.SUBMIT) {
                holder.btnDeleteItem.visibility = View.GONE
                holder.btnSubmitItem.visibility = View.VISIBLE
            } else {
                holder.btnDeleteItem.visibility = View.VISIBLE
                holder.btnSubmitItem.visibility = View.GONE
            }

            holder.btnDeleteItem.setOnClickListener { onDeleteClick(order) }
            holder.btnSubmitItem.setOnClickListener { onSubmitClick(order) }
        }
    }

    override fun getItemCount(): Int = orders.size
}
