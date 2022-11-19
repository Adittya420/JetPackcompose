package com.example.composetrial

import android.os.Build.VERSION_CODES.S
import android.os.Bundle
import android.transition.CircularPropagation
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
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
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
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
import androidx.compose.ui.unit.*
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
import kotlin.time.Duration

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box (
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
                    ){
                CircularPropagation(percentage = 0.9f , number = 100)
            }

            }
        }
    }

@Composable
fun CircularPropagation(
    percentage :Float,
    number:Int,
    fontsize : TextUnit = 28.sp,
    radius: Dp = 50.dp,
    color:Color = Color.Green,
    strokeWith: Dp = 8.dp,
    animDuration: Int = 1000,
    animDelay : Int = 0
    ){
var animPlayed by remember {
    mutableStateOf(false)
}
    val currper = animateFloatAsState(targetValue = if(animPlayed) percentage else 0f, animationSpec = tween(
        durationMillis = animDuration,
        delayMillis = animDelay
    ))
    LaunchedEffect(key1 = true){
        animPlayed = true
    }
    Box (
        contentAlignment = Alignment.Center,
        modifier = Modifier.size(radius * 2f)
            ){
        Canvas(modifier = Modifier.size(radius*2f) ){
            drawArc(
                color = Color.Green,
                -90f,
                360 * currper.value,
                useCenter = false,
                style = Stroke(strokeWith.toPx(),cap = StrokeCap.Round),
            )

        }
        Text(
            text = (currper.value*number).toInt().toString(),
            color=Color.Red,
            fontSize = fontsize
        )

    }
   


}


