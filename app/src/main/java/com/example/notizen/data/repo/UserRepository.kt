//package com.example.notizen.data.repo
//
//import android.app.Application
//import android.util.Log
//import com.olayg.halfwayapp.repo.remote.RetrofitInstance
//import java.lang.Exception
//
//class UserRepository(private val application: Application) {
//    private val TAG = "UserRepository"
//
//    private val serviceApi by lazy {
//        RetrofitInstance.userService
//    }
//    suspend fun fetchUserData() = try {
//        serviceApi.fetchUserData().map { userResponse ->
//            Log.d(TAG, "fetchUserData: $userResponse ")
//        }
//    } catch (ex: Exception){
//        Log.d(TAG, "fetchUserDataEx: ${ex.message} ")
//    }
//
//}