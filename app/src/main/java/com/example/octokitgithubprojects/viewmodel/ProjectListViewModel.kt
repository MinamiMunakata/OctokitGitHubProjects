package com.example.octokitgithubprojects.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.octokitgithubprojects.R
import com.example.octokitgithubprojects.model.Project
import com.example.octokitgithubprojects.repository.ProjectRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class ProjectListViewModel(application: Application) : AndroidViewModel(application) {
    private val repository = ProjectRepository.instance
    var projectListLiveData: MutableLiveData<List<Project>> = MutableLiveData()

    init {
        loadProjectList()
    }

    private fun loadProjectList() {
        // The CoroutineScope is automatically cancelled when the ViewModel is cleared.: ViewModel.onCleared()
        viewModelScope.launch {
            try {
                val request = repository.getProjectList(getApplication<Application>().getString(R.string.org_name))
                if (request.isSuccessful) {
                    projectListLiveData.postValue(request.body())
                }
            } catch (e: Exception) {
                e.stackTrace
            }

        }
    }
}