package com.example.octokitgithubprojects.view.callback

import com.example.octokitgithubprojects.model.Project


/**
 * @link onClick(Project project)
 */
interface ProjectClickCallback {
    fun onClick(project: Project)
}