package com.ananth.smartstudypractices.models

import androidx.compose.ui.graphics.Color
import com.ananth.smartstudypractices.ui.theme.gradient1
import com.ananth.smartstudypractices.ui.theme.gradient2
import com.ananth.smartstudypractices.ui.theme.gradient3
import com.ananth.smartstudypractices.ui.theme.gradient4
import com.ananth.smartstudypractices.ui.theme.gradient5

data class Subject(val name: String,
                   val goalHours: Float,
                   val colors: List<Color>,
                   val subjectId: Int
) {
    companion object {
        val subjectCardColors = listOf(gradient1, gradient2, gradient3, gradient4, gradient5)
    }
}