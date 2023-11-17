package com.ananth.smartstudypractices.ui.theme.screens.dashBoard

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.ananth.smartstudypractices.R
import com.ananth.smartstudypractices.components.CountsCardUI
import com.ananth.smartstudypractices.models.Subject

@Composable
fun DashBoardUI() {


    Scaffold(
        topBar = { DashBoardTopBar() }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {

            item {
                CountCardSection(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(12.dp)
                )
            }

            item {
                SubjectCardsSections(Modifier.fillMaxWidth(),"Add Subjects", emptyList())
            }


        }

    }

}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DashBoardTopBar() {
    CenterAlignedTopAppBar(title = {
        Text(
            text = "Smart Study",
            style = MaterialTheme.typography.headlineMedium.copy(fontWeight = FontWeight.Bold)
        )
    })
}


@Composable
private fun CountCardSection(modifier: Modifier) {
    Row(modifier = modifier, horizontalArrangement = Arrangement.SpaceBetween) {
        CountsCardUI(modifier = Modifier.weight(1f), headingText = "Subject Count", count = "12")
        Spacer(modifier = Modifier.width(10.dp))
        CountsCardUI(modifier = Modifier.weight(1f), headingText = "Studied Hours", count = "5")
        Spacer(modifier = Modifier.width(10.dp))

    }
}


@Composable
private fun SubjectCardsSections(
    modifier: Modifier,
    emptyListText: String,
    subjects: List<Subject>
) {

    Column() {

        Row(
            modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Subjects",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 12.dp)
            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Subject",
                    tint = Color.Black
                )
            }
        }

        if (subjects.isEmpty()) {
            ShowAddSubjectCard(emptyListText)
        }else{
            SubjectCardsSectionItems()

        }


    }
}

@Composable
fun ShowAddSubjectCard(emptyContent:String) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {

        Image(
            painter = painterResource(id = R.drawable.img_books),
            contentDescription = "Add Subject",
            modifier = Modifier.size(120.dp)
        )
        Spacer(modifier = Modifier.height(12.dp))
        
        Text(text = emptyContent, style = MaterialTheme.typography.titleMedium.copy(color = Color.White))
    }
}

@Composable
fun SubjectCardsSectionItems() {
    
    Box(
        modifier = Modifier
            .size(150.dp)
            .background(
                brush = Brush.linearGradient(Subject.subjectCardColors[0]),
                shape = MaterialTheme.shapes.medium
            )
    ){
        Column(modifier = Modifier.padding(12.dp), verticalArrangement = Arrangement.Center) {

            Image(painter = painterResource(id = R.drawable.img_books),
                contentDescription ="", modifier = Modifier.size(80.dp))

            Text(text = "Sample")
        }
    }

}
