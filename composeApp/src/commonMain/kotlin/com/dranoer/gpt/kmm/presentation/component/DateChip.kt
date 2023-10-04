package com.dranoer.gpt.kmm.presentation.component

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun DateChip(modifier: Modifier) {
    Surface(
        shape = RoundedCornerShape(14.dp),
        color = MaterialTheme.colorScheme.onBackground,
    ) {
        Text(
            modifier = modifier.padding(6.dp),
            text = "Today",
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.surface,
        )
    }
}

//region Preview
//@Preview(name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "DarkTheme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//private fun DateChipPreview() {
//    GptTheme {
//        DateChip(modifier = Modifier)
//    }
//}
//endregion