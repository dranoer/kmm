package com.dranoer.gpt.kmm.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import com.dranoer.gpt.kmm.presentation.chat.UserType

@Composable
fun MessageItem(
    modifier: Modifier = Modifier,
    color: Color,
    shape: Shape,
    alignment: Alignment.Horizontal,
    type: UserType,
    message: String,
) {
    Surface(
        modifier = modifier,
        color = color,
        shape = shape,
    ) {
        Column(
            modifier = modifier
                .padding(
                    horizontal = 10.dp,
                    vertical = 8.dp,
                ),
            horizontalAlignment = alignment,
        ) {
            Text(
                text = message,
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.onSurface,
            )
        }
    }
}

//region Preview
//@Preview(name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//private fun MessageItemPreview_Gpt() {
//    GptTheme {
//        MessageItem(
//            type = UserType.gpt,
//            color = MaterialTheme.colorScheme.background,
//            shape = RoundedCornerShape(
//                topEnd = dimensionResource(id = R.dimen.card_corner),
//                topStart = dimensionResource(id = R.dimen.card_corner),
//                bottomStart = 0.dp,
//                bottomEnd = dimensionResource(id = R.dimen.card_corner)
//            ),
//            alignment = Alignment.End,
//            message = "Hey there"
//        )
//    }
//}
//
//@Preview(name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO)
//@Composable
//private fun MessageItemPreview_User() {
//    GptTheme {
//        MessageItem(
//            type = UserType.user,
//            color = MaterialTheme.colorScheme.tertiary,
//            shape = RoundedCornerShape(
//                topEnd = dimensionResource(id = R.dimen.card_corner),
//                topStart = dimensionResource(id = R.dimen.card_corner),
//                bottomStart = dimensionResource(id = R.dimen.card_corner),
//                bottomEnd = 0.dp
//            ),
//            alignment = Alignment.Start,
//            message = "Hey there, This is a user!"
//        )
//    }
//}
//endregion