package com.example.octokitgithubprojects.view.epoxycontroller

import com.airbnb.epoxy.Typed2EpoxyController
import com.example.octokitgithubprojects.data.model.Project
import com.example.octokitgithubprojects.projectListItem
import com.example.octokitgithubprojects.view.callback.ProjectClickCallback

class ProjectController : Typed2EpoxyController<List<Project>, ProjectClickCallback>() {
    override fun buildModels(projectList: List<Project>?, callback: ProjectClickCallback) {
        // Elvis operator, Check if projectList is null
        projectList ?: return
        projectList.forEachIndexed { index, project ->
            projectListItem {
                id(index.toLong())
                project(project)
                callback(callback)
            }
        }

    }
}