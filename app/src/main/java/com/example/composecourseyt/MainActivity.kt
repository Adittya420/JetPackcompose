package com.example.composecourseyt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.fontResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import com.example.composecourseyt.ui.theme.ComposeCourseYTTheme
import androidx.compose.ui.unit.dp
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.time.format.TextStyle

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            //Trying()
            AlphaModifier()
            ClipModifier()


        }
    }
}

//@Composable
//fun ImageCard(
//    painter = Painter,
//    contentDescription : String,
//    title : String,
//    modifier: Modifier =Modifier
//
//){
//
//}
@Composable
fun Trying( ){
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray)
        ) {
//        Text("search",
//            style= androidx.compose.ui.text.TextStyle(color = Color.Blue),
//            modifier = Modifier.clickable {  }
//        )
//        Text("Text with background colours",
//            modifier = Modifier.padding(30.dp)
//                .background(color = Color.Green)
//                .clickable {  }
//                .padding(15.dp))
        Text("Height & width",
            style = androidx.compose.ui.text.TextStyle(color=Color.White),
            modifier = Modifier
                .background(color = Color.Blue)
                .height(300.dp)
                .width(250.dp)
                .shadow(20.dp, RectangleShape)
                .padding(50.dp)
        )
    }

}

@Composable
fun AlphaModifier(){
    Box(modifier = Modifier
        .size(250.dp)
        .background(color = Color.Magenta)
        .alpha(0.5f)
        .rotate(45f)) {
        Text(text = "heyy!!!",
        style = androidx.compose.ui.text.TextStyle(
            shadow = Shadow(color= Color.Black,
            offset = Offset(5f,5f), blurRadius = 5f,

            )
        ))
    }
}

@Composable
fun ClipModifier() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Blue)
            .padding(Dp(15f))
    )
}
