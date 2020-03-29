package com.example.redditassigment.presentation.reddit

import android.net.Uri
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.redditassigment.R
import com.example.redditassigment.data.database.entity.SubredditEntity
import com.example.redditassigment.presentation.common.BaseActivity
import com.example.redditassigment.presentation.reddit.adapter.RedditAdapter
import com.example.redditassigment.util.createCustomTabs
import com.example.redditassigment.util.visibility
import com.example.redditassigment.util.visible
import kotlinx.android.synthetic.main.activity_reddit.*
import org.koin.androidx.viewmodel.scope.viewModel
import org.koin.androidx.scope.lifecycleScope
import org.koin.core.parameter.parametersOf

class RedditActivity : BaseActivity<RedditViewModel>() {

    override val layoutId: Int = R.layout.activity_reddit

    override val viewModel: RedditViewModel by lifecycleScope.viewModel(this)

    private val adapter: RedditAdapter by lifecycleScope.inject{ parametersOf(::onItemPostClick)}

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupRecyclerView()
        viewModel.getPagedListLiveData().observe(this, Observer {
            adapter.submitList(it)
        })
    }

    override fun showProgress(isProgress: Boolean) {
        progressBar.visibility(isProgress)
    }

    private fun setupRecyclerView(){
        rvCardsTab.layoutManager = LinearLayoutManager(this)
        rvCardsTab.adapter = adapter
    }

    override fun showError(errorMessage: String) {
        super.showError(errorMessage)
        layoutEmpty.visible()
    }

    private fun onItemPostClick(subreddit: SubredditEntity){
        createCustomTabs().apply { launchUrl(this@RedditActivity, Uri.parse(subreddit.url)) }
    }
}