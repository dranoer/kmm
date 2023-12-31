import com.dranoer.gpt.kmm.App
import com.dranoer.gpt.kmm.di.initKoin
import org.jetbrains.skiko.wasm.onWasmReady

fun main() {
    initKoin {}
    onWasmReady {
        BrowserViewportWindow("Rick N Morty KMM") {
            App()
        }
    }
}
