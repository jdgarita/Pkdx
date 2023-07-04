import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import com.jd.pkdx.Pkdx
import com.jd.pkdx.di.KoinHelper

@Composable
fun MainView() {
    val viewModel = KoinHelper.pkdxViewModel
    val state by viewModel.state.collectAsState()
    Pkdx(state = state)
}