package com.example.league_of_impostors_android.pages.roles

import androidx.compose.runtime.toMutableStateList
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asFlow

data class Role ( val description : String , val image : String)
class RolesViewModel : ViewModel() {
    private val _uiRoles: List<Role> = getRoles().toList()
    val uiRoles : List<Role>
        get() = _uiRoles

    private fun getRoles() : List<Role>{
        return getDummyRoles()
        // TODO: Récupérer la liste des roles via l'API firebase
    }

    private fun getDummyRoles() : List<Role> {
        val roles = mutableListOf<Role>()
        for (i in 1..10){
            roles.add(Role("Role n° $i", image = "https://dummyimage.com/200"))
        }
        return roles
    }
}