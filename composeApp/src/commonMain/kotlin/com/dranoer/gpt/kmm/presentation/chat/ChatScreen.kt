package com.dranoer.gpt.kmm.presentation.chat

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.ScreenKey
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import com.dranoer.gpt.kmm.presentation.component.DateChip
import com.dranoer.gpt.kmm.presentation.component.MessageList

@OptIn(ExperimentalMaterial3Api::class)
class ChatScreen : Screen {
    override val key: ScreenKey = uniqueScreenKey

    @Composable
    override fun Content() {
        var query by remember { mutableStateOf("Message") }
        Scaffold(
            containerColor = MaterialTheme.colorScheme.primary,
            //region Toolbar
            topBar = {
                TopAppBar(
                    title = {
                        Column(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                text = "Chat GPT-4",
                                color = MaterialTheme.colorScheme.onSurface,
                                style = MaterialTheme.typography.bodyLarge,
                            )
                            Text(
                                text = "Online",
                                color = MaterialTheme.colorScheme.onSecondary,
                                style = MaterialTheme.typography.bodyMedium,
                            )
                        }
                    },
                    colors = topAppBarColors(
                        containerColor = MaterialTheme.colorScheme.secondary
                    ),
                )
            }, //endregion
            //region Messages
            content = { padding ->
                Box(
                    contentAlignment = Alignment.Center,
                ) {
//                Image(
//                    painter = painterResource(id = R.drawable.purplebg),
//                    contentDescription = null,
//                    modifier = Modifier.fillMaxSize(),
//                    contentScale = ContentScale.Crop
//                )
                    //region Messages
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(padding),
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        //region Date
                        DateChip(modifier = Modifier)
                        Spacer(modifier = Modifier.height(4.dp)) //endregion
                        //region Messages
                        MessageList(
                            messages = listOf(
                                MessageUiModel(type = UserType.gpt, message = "Hi"),
                                MessageUiModel(
                                    type = UserType.user,
                                    message = "Hey, Ive a question"
                                ),
                                MessageUiModel(type = UserType.gpt, message = "What is it?"),
                                MessageUiModel(
                                    type = UserType.user,
                                    message = "I've a very very very very very long question"
                                ),
                                MessageUiModel(
                                    type = UserType.gpt,
                                    message = "I've a very very very very very very very very very very very very very very very very very long answer 😄",
                                ),
                            )
                        ) //endregion
                    } //endregion
                }
            }, //endregion
            //region Query input
            bottomBar = {
                //region Input
                Box {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 6.dp)
                            .background(MaterialTheme.colorScheme.onTertiary),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        TextField(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(
                                    start = 20.dp,
                                    top = 6.dp,
                                    end = 20.dp,
                                    bottom = 20.dp,
                                )
                                .background(MaterialTheme.colorScheme.onPrimary),
                            value = query,
                            onValueChange = { query = it },
                            shape = RoundedCornerShape(18.dp),
                            colors = TextFieldDefaults.colors(
                                focusedContainerColor = MaterialTheme.colorScheme.onPrimary,
                                unfocusedContainerColor = MaterialTheme.colorScheme.onPrimary,
//                                disabledContainerColor = MaterialTheme.colorScheme.onPrimary,
//                                cursorColor = MaterialTheme.colorScheme.onPrimary,
                            ),
                            visualTransformation = VisualTransformation.None,
                        )
                    }
                } //endregion
            },
            //endregion
        )
    }
}

//region Preview
//@Preview(name = "LightTheme", uiMode = Configuration.UI_MODE_NIGHT_NO, showBackground = true)
//@Preview(name = "DarkTheme", uiMode = Configuration.UI_MODE_NIGHT_YES, showBackground = true)
//@Composable
//private fun ChatScreenPreview() {
//    GptTheme {
//        ChatScreen()
//    }
//}
//endregion