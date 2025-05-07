package com.cst.cstacademy2025unibucif.ui.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.cst.cstacademy2025unibucif.adapters.UsersAdapter
import com.cst.cstacademy2025unibucif.networking.repositories.UsersRepository as UsersAPIRepository
import com.cst.cstacademy2025unibucif.data.repositories.users.UsersRepository as UsersDataRepository
import com.cst.cstacademy2025unibucif.helpers.extensions.logErrorMessage
import com.cst.cstacademy2025unibucif.models.users.UserModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
   private val usersRepository: UsersDataRepository
): ViewModel() {
   private var userList = mutableListOf<UserModel>()
   val usersAdapter = UsersAdapter(userList)

   init {
      fetchUsers()
   }

   private fun updateUsersList(users: List<UserModel>) {
      userList.clear()
      userList.addAll(users)

//      usersAdapter.notifyDataSetChanged()
      usersAdapter.notifyItemRangeChanged(0, users.size)
   }

   private fun fetchUsers() {
      viewModelScope.launch {
         try {
            val resDb = withContext(Dispatchers.IO) {
               val allUsers = usersRepository.getAll()

               val reducedUsers = mutableListOf<UserModel>()
               if (allUsers.size > 5) {
                  reducedUsers.add(allUsers[0])
                  reducedUsers.add(allUsers[2])
                  reducedUsers.add(allUsers[4])
               }

               reducedUsers
            }

            updateUsersList(resDb)

            val res = withContext(Dispatchers.IO) {
               delay(3000)

               val apiResult = UsersAPIRepository.get(1) // ToDo: Hardcoded
               usersRepository.insert(apiResult.data)

               apiResult
            }

            updateUsersList(res.data)
         } catch (e: IOException) {
            "Please check your internet connection".logErrorMessage()
         } catch (e: HttpException) {
            "Server error: ${e.code()}".logErrorMessage()
         } catch (e: Exception) {
            "Unexpected error: ${e.localizedMessage}".logErrorMessage()
         }
      }
   }
}
