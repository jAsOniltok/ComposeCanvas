package net.niltok.composecanvas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.dp
import kotlin.math.cos
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyCircle()
        }
    }
}

@Composable
fun MyCanvas() {
    Canvas(
        modifier = Modifier
            .padding(20.dp)
            .size(300.dp)
    ) {

        drawRect(
            color = Color.Black,
            size = size
        )
        drawRect(
            color = Color.Red,
            topLeft = Offset(100f, 100f),
            size = Size(100f, 100f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                center = center,
                radius = 100f
            ),
            radius = 100f
        )
        drawArc(
            color = Color.Green,
            startAngle = 0f,
            sweepAngle = 270f,
            useCenter = false,
            topLeft = Offset(100f, 500f),
            size = Size(200f, 200f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawOval(
            color = Color.LightGray,
            topLeft = Offset(500f, 100f),
            size = Size(200f, 300f),
        )
        drawLine(
            color = Color.Cyan,
            start = Offset(300f, 700f),
            end = Offset(700f, 700f),
            strokeWidth = 5.dp.toPx()
        )
    }
}

@Composable
fun MyFace() {
    Canvas(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        val noseOffset = Offset(center.x - 25f, center.y - 90f)
        val leftEyeOffset = Offset(center.x / 2 + (center.x / 4), center.y - 60f)
        val rightEyeOffset = Offset(center.x + (center.x / 4), center.y - 60f)

        drawRect(color = Color.Yellow, topLeft = Offset(0f, 0f), size = size)

        drawCircle(
            color = Color.Black,
            center = center,
            style = Stroke(
                width = 3.dp.toPx(),
            ),
            radius = 210f
        )
        drawOval(
            color = Color.Black,
            size = Size(50f, 120f),
            topLeft = noseOffset,
            style = Stroke(
                width = 3.dp.toPx(),
            )
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White,
                    Color.Black
                ),
                center = leftEyeOffset,
                radius = 25f
            ),
            radius = 25f,
            center = leftEyeOffset
        )
        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.White,
                    Color.Black
                ),
                center = rightEyeOffset,
                radius = 25f
            ),
            radius = 25f,
            center = rightEyeOffset
        )
        drawRect(
            color = Color.Black,
            topLeft = Offset((rightEyeOffset.x - 37.5f), rightEyeOffset.y - 50f),
            size = Size(80f, 10f)
        )
        drawRect(
            color = Color.Black,
            topLeft = Offset((leftEyeOffset.x - 37.5f), leftEyeOffset.y - 50f),
            size = Size(80f, 10f)
        )
        drawArc(
            color = Color.Black,
            startAngle = 0f,
            sweepAngle = 180f,
            useCenter = true,
            topLeft = Offset(center.x - 100f, noseOffset.y + 60f),
            size = Size(200f, 200f),
            style = Stroke(
                width = 3.dp.toPx()
            )
        )
        drawLine(
            color = Color.Black,
            start = Offset(center.x, center.y - 210f),
            end = Offset(center.x, center.y - 210f - 80f),
            strokeWidth = 4.dp.toPx()
        )
        drawLine(
            color = Color.Black,
            start = Offset(center.x - 30f, center.y - 210f),
            end = Offset(center.x - 30f, center.y - 210f - 80f),
            strokeWidth = 4.dp.toPx()
        )
        drawLine(
            color = Color.Black,
            start = Offset(center.x + 30f, center.y - 210f),
            end = Offset(center.x + 30f, center.y - 210f - 80f),
            strokeWidth = 4.dp.toPx()
        )
    }
}

@Composable
fun MyCircle(){
    Canvas(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        val 반지름 = 400f
        val 라디안 = 57f

        drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                center = center,
                radius = 20f
            ),
            radius = 20f,
            center = center
        )
       /* drawCircle(
            brush = Brush.radialGradient(
                colors = listOf(
                    Color.Red,
                    Color.Yellow
                ),
                center = Offset(center.x + 반지름, center.y),
                radius = 20f
            ),
            radius = 20f,
            center = Offset(center.x + 반지름, center.y)
        )*/
      /*  for(i in 0 .. 반지름.toInt()) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Yellow
                    ),
                    center = center,
                    radius = 20f
                ),
                radius = 20f,
                center = Offset(center.x + cos(0f) * i.toFloat(), center.y + sin(0f) * i.toFloat() )
            )
        }
        for(i in 0 .. 반지름.toInt()) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Yellow
                    ),
                    center = center,
                    radius = 20f
                ),
                radius = 20f,
                center = Offset(center.x + cos(1f) * i.toFloat(), center.y + sin(1f) * i.toFloat() )
            )
        }
        for(i in 0 .. Math.toDegrees(1.0).toInt()) {
            drawCircle(
                brush = Brush.radialGradient(
                    colors = listOf(
                        Color.Red,
                        Color.Yellow
                    ),
                    center = center,
                    radius = 20f
                ),
                radius = 20f,
                center = Offset(center.x + cos(Math.toRadians(i.toDouble()).toFloat()) * 반지름, center.y + sin(Math.toRadians(i.toDouble()).toFloat()) * 반지름 )
            )
        }*/
    }
}