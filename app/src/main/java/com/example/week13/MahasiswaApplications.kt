package com.example.week13

import android.app.Application
import com.example.week13.di.AppContainer
import com.example.week13.di.MahasiswaContainer

class MahasiswaApplications: Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = MahasiswaContainer()
    }
}