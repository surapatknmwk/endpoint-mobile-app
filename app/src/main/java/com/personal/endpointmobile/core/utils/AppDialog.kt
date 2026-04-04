package com.personal.endpointmobile.core.utils

import android.content.res.ColorStateList
import android.view.LayoutInflater
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.personal.endpointmobile.R
import com.personal.endpointmobile.databinding.ComponentAlertDialogBinding

object AppDialog {

    enum class Type { SUCCESS, ERROR, WARNING, INFO }

    fun show(
        fragment: Fragment,
        type: Type = Type.INFO,
        title: String,
        message: String,
        positiveText: String = "ตกลง",
        negativeText: String? = null,
        cancelable: Boolean = false,
        onPositive: (() -> Unit)? = null,
        onNegative: (() -> Unit)? = null,
    ) {
        if (!fragment.isAdded) return

        val context = fragment.requireContext()
        val binding = ComponentAlertDialogBinding.inflate(LayoutInflater.from(context))

        val dialog = MaterialAlertDialogBuilder(context)
            .setView(binding.root)
            .setCancelable(cancelable)
            .create()

        val (iconRes, colorRes) = when (type) {
            Type.SUCCESS -> Pair(R.drawable.ic_dialog_success, R.color.btnSuccessBg)
            Type.ERROR   -> Pair(R.drawable.ic_dialog_error, R.color.btnDangerBg)
            Type.WARNING -> Pair(R.drawable.ic_dialog_warning, R.color.btnWarningBg)
            Type.INFO    -> Pair(R.drawable.ic_dialog_info, R.color.colorPrimary)
        }

        binding.ivDialogIcon.setImageResource(iconRes)
        binding.btnDialogPositive.backgroundTintList =
            ColorStateList.valueOf(ContextCompat.getColor(context, colorRes))

        binding.tvDialogTitle.text = title
        binding.tvDialogMessage.text = message
        binding.btnDialogPositive.text = positiveText

        if (negativeText != null) {
            binding.btnDialogNegative.visibility = View.VISIBLE
            binding.btnDialogNegative.text = negativeText
            binding.btnDialogNegative.setOnClickListener {
                dialog.dismiss()
                onNegative?.invoke()
            }
        }

        binding.btnDialogPositive.setOnClickListener {
            dialog.dismiss()
            onPositive?.invoke()
        }

        dialog.show()
    }
}
