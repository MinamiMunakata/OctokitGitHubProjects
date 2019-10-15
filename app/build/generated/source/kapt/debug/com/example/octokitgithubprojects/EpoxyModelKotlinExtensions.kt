@file:Suppress("DEPRECATION")

package com.example.octokitgithubprojects

import com.airbnb.epoxy.EpoxyController
import kotlin.Suppress
import kotlin.Unit

inline fun EpoxyController.projectListItem(modelInitializer:
        ProjectListItemBindingModelBuilder.() -> Unit) {
    ProjectListItemBindingModel_().apply {
        modelInitializer()
    }
    .addTo(this)
}
