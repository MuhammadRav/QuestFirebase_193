package com.example.week13.ui.viewModel

import android.annotation.SuppressLint
import android.net.http.HttpException
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.week13.model.Mahasiswa
import com.example.week13.navigasi.DestinasiDetail
import com.example.week13.repository.MahasiswaRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import java.io.IOException

sealed class DetailUiState {
    data class Success(val mahasiswa: Mahasiswa) : DetailUiState()
    object Error : DetailUiState()
    object Loading : DetailUiState()
}

class DetailViewModel(
    savedStateHandle: SavedStateHandle,
    private val mhs: MahasiswaRepository
) : ViewModel() {

    var mahasiswaDetailState: DetailUiState by mutableStateOf(DetailUiState.Loading)
        private set

    private val _nim: String = checkNotNull(savedStateHandle[DestinasiDetail.NIM])

    init {
        getMahasiswa()
    }

    fun getMahasiswa() {
        viewModelScope.launch {
            mahasiswaDetailState = DetailUiState.Loading
            mahasiswaDetailState = try {
                val mahasiswa = mhs.getMahasiswa(_nim)
                DetailUiState.Success(Mahasiswa())
            } catch (e: IOException) {
                DetailUiState.Error
            } catch (e: Exception) {
                DetailUiState.Error
            }
        }
    }
    fun deleteMahasiswa(nim:String) {
        viewModelScope.launch {
            try {
                mhs.deleteMahasiswa(Mahasiswa())
            }catch (e:IOException){
                DetailUiState.Error
            }catch (e:Exception){
                DetailUiState.Error
            }
        }
    }
}