package net.estemon.studio.eac3_p3_fortunoramos_aaron

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowHeightSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.BooksieApp
import net.estemon.studio.eac3_p3_fortunoramos_aaron.ui.theme.BooksieTheme

class MainActivity : ComponentActivity() {

    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BooksieTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val windowSize = calculateWindowSizeClass(this)
                    BooksieApp(
                        windowWidth = windowSize.widthSizeClass,
                        windowHeight = windowSize.heightSizeClass)
                }
            }
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun BooksieAppCompactPreview() {
    BooksieTheme {
        Surface {
            BooksieApp()
        }
    }
}

@Preview(
    device = Devices.AUTOMOTIVE_1024p,
    heightDp = 400,
    showBackground = true,
)
@Composable
fun BooksieAppCompactLandscapePreview() {
    BooksieTheme {
        Surface {
            BooksieApp(
                WindowWidthSizeClass.Medium,
                WindowHeightSizeClass.Compact
            )
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.FOLDABLE
)
@Composable
fun BooksieAppMediumPreview() {
    BooksieTheme {
        Surface {
            BooksieApp(WindowWidthSizeClass.Medium)
        }
    }
}

@Preview(
    showBackground = true,
    showSystemUi = true,
    device = Devices.TABLET
)
@Composable
fun BooksieAppExpandedPreview() {
    BooksieTheme {
        Surface {
            BooksieApp(WindowWidthSizeClass.Expanded)
        }
    }
}