package com.example.myip.di

import com.example.myip.presentation.IpViewModel
import dagger.Subcomponent

@Subcomponent
interface IpComponent {
    fun viewModel(): IpViewModel
}