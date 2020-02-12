package com.architecture.view.recycleview

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

/**
 * Created by Sven.Wong on 2020-02-11
 */

open class BaseViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)