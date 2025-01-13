package com.example.week13.repository

import com.example.week13.model.Mahasiswa
import kotlinx.coroutines.flow.Flow

interface MahasiswaRepository {
    fun getAllMahasiswa(): Flow<List<Mahasiswa>>
    suspend fun insertMahasiswa(mahasiswa: Mahasiswa)
    suspend fun updateMahasiswa(mahasiswa: Mahasiswa)
    suspend fun deleteMahasiswa(mahasiswa: Mahasiswa)
    fun getMahasiswa(nim: String): Flow<Mahasiswa>
}