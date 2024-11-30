package com.example.beyond_phrases

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview

class HomeActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BeyondPhrasesHomePage()
        }
    }
}

@Composable
fun BeyondPhrasesHomePage() {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            // Text Window
            Text(
                text = "Welcome to Beyond Phrases!",
                style = MaterialTheme.typography.titleLarge,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            )

            Text(
                text ="Choose a language:",
                style = MaterialTheme.typography.titleSmall,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            )

            Text(
                text = "Languages",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            )
            LanguagesRow()


            Text(
                text = "Explore Content",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(start = 8.dp, top = 16.dp, bottom = 8.dp)
            )
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp)
            ) {
                items(4) { index -> // Generate 10 replicable cards
                    ContentCard(
                        title = "Card Title $index",
                        description = "This is a description for card $index."
                    )
                }
            }
        }
    }
}

@Composable
fun LanguagesRow() {
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(2.dp),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        item {
            LanguagesCard(
                languageName = "English",
                languageFlag = painterResource(id = R.drawable.flags_threr)
            )
        }
        item {
            LanguagesCard(
                languageName = "Spanish",
                languageFlag = painterResource(id = R.drawable.flgs_two)
            )
        }
        item {
            LanguagesCard(
                languageName = "Japanese",
                languageFlag = painterResource(id = R.drawable.flags)
            )
        }
        item {
            LanguagesCard(
                languageName = "Chinese",
                languageFlag = painterResource(id = R.drawable.flags_threr)
            )
        }
    }
}

@Composable
fun LanguagesCard(languageName: String, languageFlag: Painter) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .width(100.dp)
            .padding(8.dp)
    ) {

        Image(
            painter = languageFlag,
            contentDescription = "Language Image",
            modifier = Modifier
                .size(60.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop
        )

        Text(
            text = languageName,
            style = MaterialTheme.typography.bodyMedium,
            maxLines = 1,
            modifier = Modifier.padding(top = 8.dp),
        )


        Button(
            onClick = {  },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 8.dp)
        ) {
            Text(text = "Select", fontSize = 12.sp)
        }
    }
}

@Composable
fun ContentCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(text = title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}


@Preview(showBackground = true)
@Composable
fun PreviewSnapConnectHomePage() {
    BeyondPhrasesHomePage()
}

