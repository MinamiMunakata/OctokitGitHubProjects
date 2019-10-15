package com.example.octokitgithubprojects.service

import com.example.octokitgithubprojects.model.Project
import com.example.octokitgithubprojects.model.Readme
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubService {
    // Get the list of repositories
    @GET("/orgs/{org}/repos")
    suspend fun getProjectList(@Path("org") org: String): Response<List<Project>>

    // Get README of the project
    @GET("/repos/{owner}/{repo}/readme")
    suspend fun getReadme(@Path("owner") owner: String, @Path("repo") projectName: String): Response<Readme>
}