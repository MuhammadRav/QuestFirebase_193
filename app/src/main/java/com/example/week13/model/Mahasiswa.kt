package com.example.week13.model

data class Mahasiswa(
    val nim: String,
    val nama: String,
    val alamat: String,
    val jenis_kelamin: String,
    val kelas: String,
    val angkatan: String,
    val skripsi: String,
    val dosen1: String,
    val dosen2: String
){
    // nilai default
    constructor(

    ):this("","","","","","","","","")
}
