package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.simcodic.pincodegenerator.R
import com.simcodic.pincodegenerator.presentation.theme.PinCodeGeneratorTheme

@Composable
fun PinsListScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(id = R.string.pin_list_screen_name))
            }
        )

        PinsList()
    }
}

@Composable
fun PinsList() {

}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PinCodeGeneratorTheme {
        PinsListScreen()
    }
}