package com.example.composetrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.layoutId
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.ConstraintSet
import androidx.constraintlayout.compose.Dimension
import java.util.Random
import kotlin.random.Random.Default.nextFloat

import com.example.composetrial.ui.theme.ComposeTrialTheme
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment
import java.net.ContentHandler

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                val constraints = ConstraintSet {
                    val greenBox = createRefFor("GreenBox")
                    val redBox = createRefFor("RedBox")
                    val yellowBox = createRefFor("YellowBox")

                    constrain(greenBox){
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                        width = Dimension.value(200.dp)
                        height = Dimension.value(200.dp)
                    }

                    constrain(redBox){
                        top.linkTo(parent.top)
                        start.linkTo(greenBox.end)
                        width = Dimension.value(200.dp)
                        height = Dimension.value(200.dp)
                    }

                    constrain(yellowBox){
                        bottom.linkTo(parent.bottom)
                        start.linkTo(parent.start)
                        width = Dimension.fillToConstraints
                        height = Dimension.fillToConstraints
                    }

                }
            ConstraintLayout(constraints, modifier = Modifier.fillMaxSize()) {
                Box(modifier = Modifier
                    .background(Color.Green)
                    .layoutId("GreenBox"))

                Box(modifier = Modifier.
                      background(Color.Red)
                    .layoutId("RedBox"))

            }
        }
    }
}

