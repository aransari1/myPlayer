package one.next.player.feature.player.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import one.next.player.core.model.PlayerPreferences
import one.next.player.core.ui.R
import one.next.player.core.ui.designsystem.NextIcons

@Composable
fun BoxScope.VideoFiltersView(
    modifier: Modifier = Modifier,
    shouldShow: Boolean,
    videoSharpening: Float,
    onVideoSharpeningChanged: (Float) -> Unit,
) {
    OverlayView(
        modifier = modifier,
        shouldShow = shouldShow,
        title = stringResource(R.string.video_filters),
        testTag = "panel_video_filters",
    ) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .padding(bottom = 24.dp)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = stringResource(R.string.video_sharpening))
                    Spacer(modifier = Modifier.size(8.dp))
                    Text(text = stringResource(R.string.percent, (videoSharpening * 100).toInt()))
                }
                FilledIconButton(
                    modifier = Modifier.testTag("btn_reset_video_sharpening"),
                    onClick = { onVideoSharpeningChanged(PlayerPreferences.DEFAULT_VIDEO_SHARPENING) },
                ) {
                    Icon(
                        imageVector = NextIcons.History,
                        contentDescription = stringResource(R.string.reset_video_sharpening),
                    )
                }
            }
            Slider(
                modifier = Modifier
                    .fillMaxWidth()
                    .testTag("slider_video_sharpening"),
                value = videoSharpening,
                valueRange = PlayerPreferences.DEFAULT_VIDEO_SHARPENING..PlayerPreferences.MAX_VIDEO_SHARPENING,
                onValueChange = onVideoSharpeningChanged,
            )
        }
    }
}
