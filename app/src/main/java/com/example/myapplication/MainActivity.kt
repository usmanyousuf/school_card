package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
                MessageCard((Message("Usman", "10th","Dps")))
            }
        }
    }

data class Message(val name: String
    , val Section: String
    , val School: String
)
@Composable
fun MessageCard(msg : Message) {
    Card(
        elevation = 5.dp,
        modifier = Modifier
            .padding(5.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .border(width = 2.dp, color = Color.Gray, shape = RectangleShape)

    ) {
        Row(
            modifier = Modifier
                .padding(9.dp)
                .fillMaxWidth()
                .wrapContentHeight()
        ) {
            Image(
                painter = painterResource(id = R.drawable.thor),
                contentDescription = "${R.string.Content}",
                contentScale = ContentScale.Crop,//for better image fitting
                modifier = Modifier
                    .size(40.dp)
                    .clip(CircleShape)
                    .border(width = 1.dp, color = Color.Black, shape = CircleShape)
            )
            //Add horizontal space between the image and the column
            Spacer(modifier = Modifier.width(4.dp))

            Column {
                Text(
                    text = "Name:${msg.name}",
                    color = Color.Black,
                    fontFamily = FontFamily.Monospace
                )
                Text(
                    text = "Class:${msg.Section}"
                )
                Text(text = "School:${msg.School}")
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun PreviewMessageCard() {

        MessageCard(
            msg = Message("Usman", "10th","Dps")
        )
    }


