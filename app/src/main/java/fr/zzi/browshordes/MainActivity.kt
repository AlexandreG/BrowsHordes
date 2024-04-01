package fr.zzi.browshordes

import android.net.Uri
import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.ColorInt
import androidx.browser.customtabs.CustomTabColorSchemeParams
import androidx.browser.customtabs.CustomTabsIntent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import fr.zzi.browshordes.ui.theme.BrowsHordesTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContent {
//            BrowsHordesTheme {
//                // A surface container using the 'background' color from the theme
//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colorScheme.background
//                ) {
////                    WebViewScreen()
//                }
//            }
//        }

        @ColorInt
        var colorPrimaryLight =
            ContextCompat.getColor(this@MainActivity, R.color.brown)

        val url = "https://myhordes.eu/"
        val intent = CustomTabsIntent.Builder()
            .setDefaultColorSchemeParams(
                CustomTabColorSchemeParams.Builder()
                    .setToolbarColor(colorPrimaryLight)
                    .setNavigationBarColor(colorPrimaryLight)
                    .build()
            )
            .setUrlBarHidingEnabled(true)
            .build()
        intent.launchUrl(this@MainActivity, Uri.parse(url))
        finish()
    }


}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Composable
fun WebViewScreen() {
    AndroidView(
        factory = { context ->
            WebView(context).apply {
                settings.javaScriptEnabled = true
                webViewClient = WebViewClient()

//                settings.loadWithOverviewMode = true
//                settings.useWideViewPort = true
//                settings.setSupportZoom(true)
                settings.domStorageEnabled = true
            }
        },
        update = { webView ->
            webView.loadUrl("https://myhordes.eu/")
        }
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    BrowsHordesTheme {
        Greeting("Android")
    }
}