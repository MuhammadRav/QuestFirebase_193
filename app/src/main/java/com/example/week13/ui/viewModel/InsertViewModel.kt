package com.example.week13.ui.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.week13.model.Mahasiswa
import com.example.week13.repository.MahasiswaRepository
import java.text.Normalizer.Form

class InsertViewModel (
    private val mhs: MahasiswaRepository
): ViewModel(){
    var uiEvent: InsertUiState by mutableStateOf(InsertUiState())

}

sealed class FormState{
    object Idle : FormState()
    object Loading : FormState()
    data class Success(val message: String) : FormState()
    data class Error(val message: String) : FormState()
}

data class FormErrorState(
    val nim: String? = null,
    val nama: String? = null,
    val jenis_kelamin: String? = null,
    val alamat: String? = null,
    val kelas: String? = null,
    val angkatan: String? = null,
){
    fun isValid(): Boolean {
        return nim == null && nama == null && jenis_kelamin == null &&
                alamat == null && kelas == null && angkatan == null
    }
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