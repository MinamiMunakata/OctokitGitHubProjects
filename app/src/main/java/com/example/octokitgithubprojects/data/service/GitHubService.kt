package com.example.octokitgithubprojects.data.service

import com.example.octokitgithubprojects.data.model.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    // Get the list of repositories
    @GET("/orgs/{org}/repos")
    suspend fun getProjectList(@Path("org") org: String): Response<List<Project>>
}