package net.niltok.composecanvas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.delay
import kotlin.math.*
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Baller()
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
fun MyCircle() {
    Canvas(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        val 반지름 = 400f

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
        for (각도 in 0..360) {
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
                center = Offset(
                    center.x + cos(Math.toRadians(각도.toDouble()).toFloat()) * 반지름,
                    center.y + sin(Math.toRadians(각도.toDouble()).toFloat()) * 반지름
                )
            )
        }
    }
}

@Composable
fun MyPentagon() {
    Canvas(
        modifier = Modifier
            .background(color = Color.LightGray)
            .fillMaxSize()
    ) {
        val 반지름 = 400f
        var step = 0

        for (각도 in 72..360 step 72) {
            Log.d("drawLine", "start:$step, end:$각도")
            drawLine(
                color = Color.Black,
                start = Offset(
                    center.x + cos(Math.toRadians(step.toDouble()).toFloat()) * 반지름,
                    center.y + sin(Math.toRadians(step.toDouble()).toFloat()) * 반지름
                ),
                end = Offset(
                    center.x + cos(Math.toRadians(각도.toDouble()).toFloat()) * 반지름,
                    center.y + sin(Math.toRadians(각도.toDouble()).toFloat()) * 반지름
                ),
                strokeWidth = 3.dp.toPx()
            )
            step = 각도
        }
    }
}

@Composable
fun Baller() {
    var points by remember { mutableStateOf(0) }
    var isTimerRunning by remember { mutableStateOf(false) }
    Column(modifier = Modifier.fillMaxSize()) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Points: $points"
            )
            Button(onClick = {
                isTimerRunning = isTimerRunning.not()
                points = 0
            }) {
                Text(text = if (isTimerRunning) "Reset" else "Start")
            }
            CountDownTimer(
                isTimerRunning = isTimerRunning
            ) {
                isTimerRunning = false
            }
        }
        BallClicker(enabled = isTimerRunning) {
            points++
        }
    }
}

@Composable
fun CountDownTimer(
    time: Int = 30000,
    isTimerRunning: Boolean = false,
    onTimerEnd: () -> Unit = {}
) {
    var curTime by remember { mutableStateOf(time) }
    LaunchedEffect(key1 = curTime, key2 = isTimerRunning) {
        if (isTimerRunning.not()) {
            curTime = time
            return@LaunchedEffect
        }
        if (curTime > 0) {
            delay(1000)
            curTime -= 1000
        } else {
            onTimerEnd()
        }
    }
    Text(
        text = (curTime / 1000).toString(),
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
    )
}

@Composable
fun BallClicker(
    radius: Float = 100f,
    enabled: Boolean = false,
    ballColor: Color = Color.Red,
    onBallClick: () -> Unit = {}
) {
    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {

        var ballPosition by remember {
            mutableStateOf(
                randomOffset(
                    radius = radius,
                    width = constraints.maxWidth,
                    height = constraints.maxHeight
                )
            )
        }
        Canvas(
            modifier = Modifier
                .fillMaxSize()
                .pointerInput(enabled) {
                    if(enabled.not()) return@pointerInput
                    detectTapGestures {
                        val distance = sqrt(
                            (it.x - ballPosition.x).pow(2) +
                                    (it.y - ballPosition.y).pow(2)
                        )
                        if (distance <= radius) {
                            ballPosition = randomOffset(
                                radius = radius,
                                width = constraints.maxWidth,
                                height = constraints.maxHeight
                            )
                            Log.d("detectTapGestures ", "distance:$distance, ballPosition${ballPosition.x}, ${ballPosition.y}")
                            onBallClick()
                        }
                    }
                }
        ) {
            drawCircle(
                color = ballColor,
                radius = radius,
                center = ballPosition,
            )
        }
    }
}

private fun randomOffset(radius: Float, width: Int, height: Int): Offset {
    return Offset(
        x = Random.nextInt(radius.roundToInt(), width - radius.roundToInt()).toFloat(),
        y = Random.nextInt(radius.roundToInt(), height - radius.roundToInt()).toFloat()
    )
}