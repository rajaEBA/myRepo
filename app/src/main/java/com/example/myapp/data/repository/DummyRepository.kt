package com.example.myapp.data.repository

import com.example.myapp.data.NetworkService
import com.example.myapp.data.local.db.DatabaseService
import io.reactivex.Single
import javax.inject.Inject

class DummyRepository @Inject constructor(
    private val networkService: NetworkService,
    private val databaseService: DatabaseService
) {

//    fun fetchDummy(id: String): Single<List<Dummy>> =
//        networkService.doDummyCall(DummyRequest(id)).map { it.data }

}