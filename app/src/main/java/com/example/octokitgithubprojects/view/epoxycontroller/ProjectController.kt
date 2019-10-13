package com.example.octokitgithubprojects.view.epoxycontroller

import com.airbnb.epoxy.AutoModel
import com.airbnb.epoxy.TypedEpoxyController
import com.example.octokitgithubprojects.databinding.ProjectListItemBinding
import com.example.octokitgithubprojects.model.Project
import com.example.octokitgithubprojects.projectListItem

class ProjectController: TypedEpoxyController<List<Project>>() {
    override fun buildModels(projectList: List<Project>?) {
        // Elvis operator
        projectList ?: return
        projectList.forEachIndexed { index, project ->
            projectListItem {
                id(index.toLong())
                project(project)
            }
        }

    }
}