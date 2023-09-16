package com.example.league_of_impostors_android.utils

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AutoFocusTextField(modifier: Modifier,
                       placeholder : @Composable () -> Unit,
                       value : String = "",
                       onValueChange : (String) -> Unit ){

    val focusRequester = remember { FocusRequester() }
    LaunchedEffect(true){
        focusRequester.requestFocus()
    }

    TextField(
        modifier = modifier.focusRequester(focusRequester),
        value = value,
        onValueChange = { onValueChange(it) },
        placeholder = { placeholder() }
    )
}