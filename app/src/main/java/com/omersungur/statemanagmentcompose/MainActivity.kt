package com.omersungur.statemanagmentcompose

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.painter.ColorPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.imageResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.omersungur.statemanagmentcompose.ui.theme.StateManagmentComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            StateManagmentComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {

    var stringg = remember { // State Hoisting: Composable fonksiyonları tekrar kullanılabilir hale getirmek için kullanılan bir compose patternidir.
        //Bu değişkeni her yerde kullanabilirim eğer SpecialTextField içinde tanımlasaydım belli problemlere yol açabilirdi.
        mutableStateOf("")
    }

    Surface(modifier = Modifier.fillMaxSize()) {
        Column(verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {

            SpecialTextField(textt = stringg.value){
                stringg.value = it
            }
            
        }
    }
}

@Composable
fun SpecialTextField(textt: String, function: (String) -> Unit) {
    TextField(value = textt, onValueChange = function )
}


/*@Composable
fun MainScreen() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(color = Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally)
    {

        var myString = remember { // remember ve mutable kullanmazsak yaptığımız değişiklikler kaydolur fakat recomposition olduğu için biz göremeden eski değerler tekrar yerine gelir.
            mutableStateOf("Android")
        }
        
        TextField(value = myString.value, onValueChange = {
            myString.value = it
        })

        var buttonString = remember {
            mutableStateOf("Hello")
        }

        Text(text = buttonString.value, fontSize = 30.sp)

        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = {
            buttonString.value = "Android"
            println("Clicked!") // butona tıklanıldığında ne yapılıyorsa ilk bloğa yazıyoruz.
        }) {
            Text(text = "Android")
            Text(text = "Test")

        }
        Spacer(modifier = Modifier.padding(5.dp))

        Image(bitmap = ImageBitmap.imageResource(id = R.drawable.londonbridge),
            contentDescription = "null",
        modifier = Modifier.fillMaxWidth(0.75f))

        Image(imageVector = ImageVector.vectorResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = null)
        Spacer(modifier = Modifier.padding(5.dp))

        Image(painter = ColorPainter(Color.Blue),
            contentDescription = null,
        modifier = Modifier
            .fillMaxWidth(1f)
            .fillMaxHeight(0.1f))
    }
}*/

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
   MainScreen()
}