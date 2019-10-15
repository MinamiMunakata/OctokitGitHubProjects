package com.example.octokitgithubprojects.repository;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005\u00a2\u0006\u0002\u0010\u0002J%\u0010\b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00f8\u0001\u0000\u00a2\u0006\u0002\u0010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019\u00a8\u0006\u0010"}, d2 = {"Lcom/example/octokitgithubprojects/repository/ProjectRepository;", "", "()V", "gitHubService", "Lcom/example/octokitgithubprojects/service/GitHubService;", "retrofit", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "getProjectList", "Lretrofit2/Response;", "", "Lcom/example/octokitgithubprojects/model/Project;", "userId", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Factory", "app_debug"})
public final class ProjectRepository {
    private final retrofit2.Retrofit retrofit = null;
    private com.example.octokitgithubprojects.service.GitHubService gitHubService;
    public static final com.example.octokitgithubprojects.repository.ProjectRepository.Factory Factory = null;
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProjectList(@org.jetbrains.annotations.NotNull()
    java.lang.String userId, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super retrofit2.Response<java.util.List<com.example.octokitgithubprojects.model.Project>>> p1) {
        return null;
    }
    
    public ProjectRepository() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 15}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/example/octokitgithubprojects/repository/ProjectRepository$Factory;", "", "()V", "instance", "Lcom/example/octokitgithubprojects/repository/ProjectRepository;", "getInstance", "()Lcom/example/octokitgithubprojects/repository/ProjectRepository;", "app_debug"})
    public static final class Factory {
        
        @org.jetbrains.annotations.NotNull()
        public final synchronized com.example.octokitgithubprojects.repository.ProjectRepository getInstance() {
            return null;
        }
        
        private Factory() {
            super();
        }
    }
}