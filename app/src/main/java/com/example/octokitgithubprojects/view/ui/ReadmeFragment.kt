package com.example.octokitgithubprojects.view.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import androidx.fragment.app.Fragment
import com.example.octokitgithubprojects.R


private const val KEY_PROJECT_URL = "project_url"

class ReadmeFragment : Fragment() {
    private lateinit var webView: WebView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view: View = inflater.inflate(R.layout.fragment_readme, container, false)
        webView = view.findViewById(R.id.webview)
        webView.settings.javaScriptEnabled = true

        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val projectName = arguments?.getString(KEY_PROJECT_URL)
        webView.loadUrl("$projectName/blob/master/README.md")

    }

    companion object {

        fun forReadme(url: String): ReadmeFragment {
            val fragment = ReadmeFragment()
            val args = Bundle()

            args.putString(KEY_PROJECT_URL, url)
            fragment.arguments = args
            return fragment
        }
    }

}
