import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.window.ComposeUIViewController
import com.jd.pkdx.Pkdx
import com.jd.pkdx.di.KoinHelper
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController = ComposeUIViewController {
    val viewModel = KoinHelper.pkdxViewModel
    val state by viewModel.state.collectAsState()
    Pkdx(state = state)
}