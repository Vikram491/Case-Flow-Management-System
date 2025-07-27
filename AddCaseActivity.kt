package com.example.caseease

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class AddCaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_case)

        val type = findViewById<EditText>(R.id.etType)
        val date = findViewById<EditText>(R.id.etDate)
        val priority = findViewById<EditText>(R.id.etPriority)
        val progress = findViewById<EditText>(R.id.etProgress)
        val saveBtn = findViewById<Button>(R.id.btnSave)

        saveBtn.setOnClickListener {
            val newCase = Case(
                id = "Case #${System.currentTimeMillis()}",
                type = type.text.toString(),
                dueDate = date.text.toString(),
                priority = priority.text.toString(),
                progress = progress.text.toString().toInt()
            )

            CaseRepository.addCase(newCase)
            Toast.makeText(this, "Case added", Toast.LENGTH_SHORT).show()
            finish()
        }
    }
}
