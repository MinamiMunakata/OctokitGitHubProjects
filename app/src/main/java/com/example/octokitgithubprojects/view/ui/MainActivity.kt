package com.example.octokitgithubprojects.view.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.octokitgithubprojects.R
import com.example.octokitgithubprojects.data.model.Project

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            // Display the ProjectListFragment
            val fragment = ProjectListFragment()
            supportFragmentManager
                .beginTransaction()
                .add(R.id.fragment_container, fragment, TAG_OF_PROJECT_LIST_FRAGMENT)
                .commit()
        }
    }

    fun showREADME(project: Project) {
        // Pass GitHub URL
        val readmeFragment = ReadmeFragment.forReadme(project.html_url)

        supportFragmentManager
            .beginTransaction()
            .addToBackStack("project")
            .replace(R.id.fragment_container, readmeFragment, null)
            .commit()
    }
}
