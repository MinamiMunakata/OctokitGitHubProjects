package com.example.octokitgithubprojects.repository

import com.example.octokitgithubprojects.data.model.Project
import com.example.octokitgithubprojects.data.service.GitHubService
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

const val HTTPS_API_GITHUB_URL = "https://api.github.com/"

class ProjectRepository {

    private val retrofit = Retrofit.Builder()
        .baseUrl(HTTPS_API_GITHUB_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    private var gitHubService: GitHubService = retrofit.create(
        GitHubService::class.java)

    // HTTP request returns the list of repositories.
    suspend fun getProjectList(userId: String): Response<List<Project>> =
        gitHubService.getProjectList(userId)

    // Return the singleton ProjectRepository instance.
    companion object Factory {
        val instance: ProjectRepository
            @Synchronized get() {
                return ProjectRepository()
            }
    }
}