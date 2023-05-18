package pl.kacper.misterski.businesscardapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import pl.kacper.misterski.businesscardapp.ui.theme.BusinessCardAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard() {
    Box(Modifier.fillMaxSize()) {
        CardHeader(
            "John Doe",
            "Mobile Developer",
            ImageBitmap.imageResource(android.R.drawable.ic_menu_gallery),
            modifier = Modifier.align(Alignment.Center)
        )
        Column(modifier = Modifier.align(Alignment.BottomCenter)) {
            val contactRowModifier = Modifier.padding(8.dp)
            ContactRow(
                title = "+00 (00) 000 00",
                icon = android.R.drawable.stat_sys_speakerphone,
                modifier = contactRowModifier
            )
            ContactRow(
                title = "social media",
                icon = android.R.drawable.ic_menu_share,
                modifier = contactRowModifier
            )
            ContactRow(
                title = "testmail@gmail.com",
                icon = android.R.drawable.ic_dialog_email,
                modifier = contactRowModifier.padding(bottom = 16.dp)
            )

        }
    }
}

@Composable
fun CardHeader(fullName: String, title: String, photo: ImageBitmap, modifier: Modifier) {
    Column(modifier) {
        Image(
            bitmap = photo, contentDescription = null,
            Modifier
                .size(128.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = fullName,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 24.sp
        )
        Text(
            text = title,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .align(Alignment.CenterHorizontally),
            fontSize = 16.sp
        )
    }

}


@Composable
fun ContactRow(title: String, @DrawableRes icon: Int, modifier: Modifier = Modifier) {
    Row(modifier) {
        Image(
            painter = painterResource(id = icon),
            colorFilter = ColorFilter.tint(Color.Blue),
            contentDescription = null,
            modifier = Modifier.size(24.dp)
        )
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(horizontal = 8.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BusinessCardAppTheme {
        BusinessCard()
    }
}