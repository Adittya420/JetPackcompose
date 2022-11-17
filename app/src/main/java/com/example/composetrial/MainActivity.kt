package com.example.composetrial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
            val scaffoldState = rememberScaffoldState()
            var textFieldState by remember() {
                 mutableStateOf(" ")
            }
            val scope = rememberCoroutineScope()
            Scaffold(modifier = Modifier.fillMaxSize()
            , scaffoldState = scaffoldState ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 30.dp)) {
                     TextField(value = textFieldState,
                     label = {
                         Text("Enter Name")
                     }, onValueChange = {
                         textFieldState=it
                         }, singleLine = true, modifier = Modifier.fillMaxWidth())
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(onClick = { /*TODO*/
                    scope.launch{
                        scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                    }}) {
                        Text(text = "Greet Me")
                    }
                }
            }
          
        }
    }
}

