package com.example.week13.ui.viewModel

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.week13.MahasiswaApplications
import com.example.week13.model.Mahasiswa

object PenyediaViewModel {
    val Factory = viewModelFactory {
        initializer {
            HomeViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository)
        }
        initializer {
            InsertViewModel(
                aplikasiMahasiswa().container.mahasiswaRepository)
        }
    }
}
fun CreationExtras.aplikasiMahasiswa(): MahasiswaApplications =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as MahasiswaApplications)

