package com.example.octokitgithubprojects.view.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.databinding.DataBindingUtil
import androidx.databinding.library.baseAdapters.BR.readmeViewModel
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.octokitgithubprojects.R
//import com.example.octokitgithubprojects.databinding.FragmentReadmeBinding
import com.example.octokitgithubprojects.viewmodel.ReadmeViewModel
import kotlinx.android.synthetic.main.fragment_readme.*

private const val KEY_PROJECT_NAME = "project_name"

class ReadmeFragment : Fragment() {
    private lateinit var webView: WebView

//    private lateinit var binding: FragmentReadmeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_readme, container, false)
//        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_readme, container, false)
        webView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.google.com/")

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val projectName = arguments?.getString(KEY_PROJECT_NAME)


//        val factory = ReadmeViewModel.Factory(requireActivity().application, projectName ?: "")
//
//        val viewModel = ViewModelProviders.of(this, factory).get(ReadmeViewModel::class.java)


//        binding.apply {
//            readmeViewModel = viewModel
//            isLoading = true
//        }
//
//        observeViewModel(viewModel)

    }

//    private fun observeViewModel(viewModel: ReadmeViewModel) {
//        viewModel.readmeLiveData.observe(viewLifecycleOwner, Observer { readme ->
//            if (readme != null) {
//                binding.isLoading = false
//                viewModel.setReadme(readme)
////                Log.i("HEY", readme.htmlUrl)
////                webView?.loadUrl(readme.htmlUrl)
//            } else{
//                Log.i("NULLL", " NUUUUUL")
//            }
//        })
//    }

    companion object {

        fun forReadme(projectName: String): ReadmeFragment {
            val fragment = ReadmeFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_NAME, projectName)
            fragment.arguments = args
            return fragment
        }
    }

}
