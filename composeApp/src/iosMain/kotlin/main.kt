import androidx.compose.ui.window.ComposeUIViewController
import com.dranoer.gpt.kmm.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return ComposeUIViewController { App() }
}
