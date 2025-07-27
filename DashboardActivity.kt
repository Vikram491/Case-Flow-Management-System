package com.example.caseease

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar

class DashboardActivity : AppCompatActivity() {

    private lateinit var toolbar: Toolbar
    private lateinit var title: TextView
    private lateinit var searchIcon: ImageView
    private lateinit var notificationIcon: ImageView

    // Summary count TextViews
    private lateinit var activeCasesText: TextView
    private lateinit var dueTodayText: TextView
    private lateinit var completedCasesText: TextView

    private lateinit var fabAdd: View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        initViews()
        setupToolbar()
        setupListeners()
    }

    private fun initViews() {
        toolbar = findViewById(R.id.toolbar)
        title = findViewById(R.id.title)
        searchIcon = findViewById(R.id.search_icon)
        notificationIcon = findViewById(R.id.notification_icon)

        activeCasesText = findViewById(R.id.active_cases_count)
        dueTodayText = findViewById(R.id.due_today_count)
        completedCasesText = findViewById(R.id.completed_cases_count)

        fabAdd = findViewById(R.id.fab_add)
    }

    private fun setupToolbar() {
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)
        title.text = "CaseEase"
    }

    private fun setupListeners() {
        searchIcon.setOnClickListener {
            Toast.makeText(this, "Search clicked", Toast.LENGTH_SHORT).show()
        }

        notificationIcon.setOnClickListener {
            Toast.makeText(this, "Notifications clicked", Toast.LENGTH_SHORT).show()
        }

        fabAdd.setOnClickListener {
            val intent = Intent(this, AddCaseActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        setDashboardCounts()
    }

    private fun setDashboardCounts() {
        // Use data from CaseRepository
        val activeCases = CaseRepository.getActiveCases().size
        val dueTodayCases = CaseRepository.getDueToday().size
        val completedCases = CaseRepository.getCompletedCases().size

        activeCasesText.text = activeCases.toString()
        dueTodayText.text = dueTodayCases.toString()
        completedCasesText.text = completedCases.toString()
    }
}
