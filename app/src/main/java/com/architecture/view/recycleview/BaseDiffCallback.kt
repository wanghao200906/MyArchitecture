package com.architecture.view.recycleview

import android.annotation.SuppressLint
import android.support.v7.util.DiffUtil

/**
 * Created by Sven.Wong on 2020-02-11
 */


open class BaseDiffCallback<T> : DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T) = oldItem == newItem

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: T, newItem: T) = oldItem == newItem

}