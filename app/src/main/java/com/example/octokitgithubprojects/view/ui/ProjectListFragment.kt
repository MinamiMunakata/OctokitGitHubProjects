package com.example.octokitgithubprojects.view.ui


import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Bundle
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
import com.google.android.material.snackbar.Snackbar

const val TAG_OF_PROJECT_LIST_FRAGMENT = "ProjectListFragment"

class ProjectListFragment : Fragment() {

    private val viewModel by lazy {
        ViewModelProviders.of(this).get(ProjectListViewModel::class.java)
    }

    private lateinit var binding: FragmentProjectListBinding

    private val projectClickCallback = object : ProjectClickCallback {
        override fun onClick(project: Project) {
            if (isOnline()) {
                // Show ReadmeFragment.
                if (lifecycle.currentState.isAtLeast(Lifecycle.State.STARTED) && activity is MainActivity) {
                    (activity as MainActivity).showREADME(project)
                }
            } else {
                // Display warning message.
                val snackBar = Snackbar.make(
                    (activity as MainActivity).findViewById(android.R.id.content),
                    "There is no Internet connection",
                    Snackbar.LENGTH_SHORT
                )
                snackBar.show()
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
        binding.apply {
            isLoading = true
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        observeViewModel(viewModel)
    }

    private fun observeViewModel(viewModel: ProjectListViewModel) {
        viewModel.projectListLiveData.observe(viewLifecycleOwner, Observer { projects ->
            if (projects != null) {
                binding.isLoading = false
                val controller = ProjectController()
                binding.projectList.setController(controller)
                controller.setData(projects, projectClickCallback)
            }
        })
    }

    // Check if the device is online,
    private fun isOnline(): Boolean {
        val connectivityManager = activity?.getSystemService(Context.CONNECTIVITY_SERVICE)
        return if (connectivityManager is ConnectivityManager) {
            val networkInfo: NetworkInfo? = connectivityManager.activeNetworkInfo
            networkInfo?.isConnected ?: false
        } else false
    }


}
