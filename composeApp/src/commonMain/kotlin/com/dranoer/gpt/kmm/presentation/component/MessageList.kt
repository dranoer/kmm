package com.dranoer.gpt.kmm.presentation.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dranoer.gpt.kmm.presentation.chat.MessageUiModel
import com.dranoer.gpt.kmm.presentation.chat.UserType

@Composable
fun MessageList(
    messages: List<MessageUiModel>,
) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(2.dp),
        modifier = Modifier.padding(
            start = 6.dp,
            top = 2.dp,
            end = 6.dp,
        ),
    ) {
        items(messages) { message ->
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(2.dp),
            ) {
                when (message.type) {
                    UserType.gpt -> {
                        MessageItem(
                            modifier = Modifier.align(Alignment.CenterStart),
                            color = MaterialTheme.colorScheme.background,
                            shape = RoundedCornerShape(
                                topEnd = 12.dp,
                                topStart = 12.dp,
                                bottomStart = 0.dp,
                                bottomEnd = 12.dp,
                            ),
                            alignment = Alignment.End,
                            type = message.type,
                            message = message.message,
                        )
                    }

                    UserType.user -> {
                        MessageItem(
                            modifier = Modifier.align(Alignment.CenterEnd),
                            color = MaterialTheme.colorScheme.tertiary,
                            shape = RoundedCornerShape(
                                topEnd = 12.dp,
                                topStart = 12.dp,
                                bottomStart = 12.dp,
                                bottomEnd = 0.dp
                            ),
                            alignment = Alignment.Start,
                            type = message.type,
                            message = message.message,
                        )
                    }
                }
            }
        }
    }
}

//region Preview
//@Preview(name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "DarkTheme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//private fun MessageListPreview() {
//    GptTheme {
//        MessageList(
//            messages = listOf(
//                MessageUiModel(type = UserType.gpt, message = "Hi"),
//                MessageUiModel(
//                    type = UserType.user,
//                    message = "Hey, Ive a question"
//                ),
//                MessageUiModel(type = UserType.gpt, message = "What is it?"),
//                MessageUiModel(
//                    type = UserType.user,
//                    message = "I've a very very very very very very very very very very long question"
//                ),
//                MessageUiModel(
//                    type = UserType.gpt,
//                    message = "I've a very very very very very very very very very very very very very very very very very very very very very very very very long answer 😄",
//                ),
//            )
//        )
//    }
//}
//endregion