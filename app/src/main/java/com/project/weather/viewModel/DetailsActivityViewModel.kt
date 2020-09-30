package com.project.weather.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.project.weather.repository.DetailsActivityRepository

class DetailsActivityViewModel(application: Application) : AndroidViewModel(application) {
    val repository = DetailsActivityRepository(application)
}