package com.example.octokitgithubprojects.viewmodel

import android.app.Application
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.*
import com.example.octokitgithubprojects.R
import com.example.octokitgithubprojects.model.Readme
import com.example.octokitgithubprojects.repository.ProjectRepository
import kotlinx.coroutines.launch
import java.lang.Exception
import java.util.*

class ReadmeViewModel(
    private val myApplication: Application,
    private val projectName: String
) : AndroidViewModel(myApplication) {

    private val repository =ProjectRepository.instance
    val readmeLiveData: MutableLiveData<Readme> = MutableLiveData()
    var readme = ObservableField<Readme>()

    init {
        loadReadme()
    }



    private fun loadReadme() {
        // The CoroutineScope is automatically cancelled when the ViewModel is cleared.: ViewModel.onCleared()
        viewModelScope.launch {
            try {
                val readme = repository.getProjectREADME(myApplication.getString(R.string.org_name), projectName)
                if (readme.isSuccessful){
                    readmeLiveData.postValue(readme.body())
                }
            } catch (e: Exception) {
                Log.e("loadREADME:Failed", e.stackTrace.toString())
            }
        }
    }

    fun setReadme(readme: Readme) {
        this.readme.set(readme)
    }

    class Factory(private val application: Application, private val projectName: String): ViewModelProvider.NewInstanceFactory() {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            //noinspection unchecked
            return ReadmeViewModel(application, projectName) as T
        }
    }
}
