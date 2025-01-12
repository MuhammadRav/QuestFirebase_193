package com.example.week13.ui.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.week13.model.Mahasiswa
import com.example.week13.repository.MahasiswaRepository

class InsertViewModel (
    private val mhs: MahasiswaRepository
): ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())

}

data class MahasiswaEvent(
    val nim: String = "",
    val nama: String = "",
    val jenis_kelamin: String = "",
    val alamat: String = "",
    val kelas: String = "",
    val angkatan: String = "",
)

fun MahasiswaEvent.toMahasiswaModel(): Mahasiswa = Mahasiswa(
    nim = nim,
    nama = nama,
    jenis_kelamin = jenis_kelamin,
    alamat = alamat,
    kelas = kelas,
    angkatan = angkatan
)