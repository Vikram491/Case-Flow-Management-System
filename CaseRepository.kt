package com.example.caseease

object CaseRepository {
    val cases = mutableListOf<Case>()

    fun addCase(case: Case) {
        cases.add(case)
    }

    fun getActiveCases(): List<Case> = cases.filter { it.progress < 100 }
    fun getDueToday(): List<Case> = cases.filter { it.dueDate == getTodayDate() }
    fun getCompletedCases(): List<Case> = cases.filter { it.progress == 100 }

    private fun getTodayDate(): String {
        val sdf = java.text.SimpleDateFormat("yyyy-MM-dd", java.util.Locale.getDefault())
        return sdf.format(java.util.Date())
    }
}
