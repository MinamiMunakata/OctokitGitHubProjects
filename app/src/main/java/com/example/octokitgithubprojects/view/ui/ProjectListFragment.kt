package com.example.octokitgithubprojects.view.ui


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.octokitgithubprojects.R
import com.example.octokitgithubprojects.databinding.FragmentProjectListBinding
import com.example.octokitgithubprojects.model.Project
import com.example.octokitgithubprojects.view.callback.ProjectClickCallback
import com.example.octokitgithubprojects.view.epoxycontroller.ProjectController
import com.example.octokitgithubprojects.viewmodel.ProjectListViewModel

const val TAG_OF_PROJECT_LIST_FRAGMENT = "ProjectListFragment"

class ProjectListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ProjectListViewModel::class.java)
    }

    private lateinit var binding: FragmentProjectListBinding

    private val projectClickCallback = object : ProjectClickCallback {
        override fun onClick(project: Project) {
            if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED) && activity is MainActivity) {
                Log.i("mTest-callback: ", "Success!")
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_project_list, container, false)

//        TODO: Adapter
        binding.apply {

            //      TODO: Adapter
            isLoading = true
        }


//        binding.projectList.setControllerAndBuildModels(ProjectController())

        Log.i("mTest: ", "Show Fragment!")
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel){
        viewModel.projectListLiveData.observe(viewLifecycleOwner, Observer { projects ->
            if (projects !=null) {
                binding.isLoading = false
                Log.i("mTest: ", "not NULL")
//                TODO: Adapter
                val controller = ProjectController()
                binding.projectList.setController(controller)
                controller.setData(projects)
            }
        })
    }
}
