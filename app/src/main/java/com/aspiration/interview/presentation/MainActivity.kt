package com.aspiration.interview.presentation

import android.view.View
import android.widget.Button
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.aspiration.interview.InterviewTaskApplication
import com.aspiration.interview.R
import com.aspiration.interview.domain.PostEntity
import com.aspiration.interview.presentation.base.BaseActivity
import com.aspiration.interview.utils.PostAdapter

class MainActivity :
    BaseActivity<MainAgreement.Presenter, MainAgreement.View>(R.layout.activity_main),
    MainAgreement.View {

    private lateinit var loader: View
    private lateinit var fetchButton: Button
    private lateinit var recyclerView: RecyclerView

    override fun setupInputs() {
        InterviewTaskApplication.applicationComponent?.inject(this)
        loader = findViewById(R.id.loading)
        recyclerView = findViewById(R.id.recycler)
        recyclerView.layoutManager = LinearLayoutManager(this)
        fetchButton = findViewById(R.id.btnFetch)
        fetchButton.setOnClickListener {
            presenter.fetchButtonWasClicked()
        }
    }

    override fun showLoading() {
        loader.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        loader.visibility = View.GONE
    }

    override fun dataFail(error: String) {
        AlertDialog.Builder(this)
            .setTitle("Could not fetch data")
            .setMessage(error)
            .setNeutralButton("OK", null)
            .show()
    }

    override fun dataLoaded(data: List<PostEntity>) {
        recyclerView.adapter = PostAdapter(data)
    }

    override fun returnThisHerePlease(): MainAgreement.View = this

}