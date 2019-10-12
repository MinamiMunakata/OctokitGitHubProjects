package com.example.octokitgithubprojects.service

import com.example.octokitgithubprojects.model.Project
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    // Get the list of repositories
    @GET("/orgs/{org}/repos")
    suspend fun getProjectList(@Path("user") user: String): Response<List<Project>>
}