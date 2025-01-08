package com.example.week13.di

import com.example.week13.repository.MahasiswaRepository
import com.example.week13.repository.NetworkMahasiswaRepository
import com.google.firebase.firestore.FirebaseFirestore

interface AppContainer{
    val mahasiswaRepository: MahasiswaRepository
}

class MahasiswaContainer : AppContainer{
    // FirebaseFirestore.getInstance() => sangat perlu untuk sejajar dengan baseurl
    private val firebase: FirebaseFirestore = FirebaseFirestore.getInstance()

    override val mahasiswaRepository: MahasiswaRepository by lazy{
        NetworkMahasiswaRepository(firebase)
    }
}