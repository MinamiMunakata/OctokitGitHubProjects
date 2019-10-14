package com.example.octokitgithubprojects.view.epoxycontroller

import com.airbnb.epoxy.TypedEpoxyController
import com.example.octokitgithubprojects.model.Project
import com.example.octokitgithubprojects.projectListItem

class ProjectController : TypedEpoxyController<List<Project>>() {
    override fun buildModels(projectList: List<Project>?) {
        // Elvis operator, Check if projectList is null
        projectList ?: return
        projectList.forEachIndexed { index, project ->
            projectListItem {
                id(index.toLong())
                project(project)
            }
        }

    }
}