package mapp.test.coreui.composable.swiperefesh

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState


@Composable
fun PrimarySwipeRefreshColumn(
    isRefreshing: Boolean = false,
    refresh: () -> Unit,
    content: @Composable () -> Unit,
) {
    SwipeRefresh(
        state = rememberSwipeRefreshState(isRefreshing),
        modifier = Modifier.fillMaxSize(),
        onRefresh = {
            refresh()
        },
    ) {
        Box(
            Modifier.fillMaxSize(),
            contentAlignment = if (isRefreshing) Alignment.Center else Alignment.TopCenter
        ) {
            content()
        }
    }


}