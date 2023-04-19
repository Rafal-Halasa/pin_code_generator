package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.simcodic.pincodegenerator.R
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinViewData
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinsListViewData
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.previewPinsListViewData
import com.simcodic.pincodegenerator.presentation.theme.PinCodeGeneratorTheme

@Composable
fun PinsListScreen() {
    PinsListScreenContainer(previewPinsListViewData())
}

@Composable
fun PinsListScreenContainer(pinsListViewData: PinsListViewData) {
    Column(modifier = Modifier.fillMaxSize()) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(id = R.string.pin_list_screen_name))
            }
        )

        PinsList(pinsListViewData.pinList)
    }
}

@Composable
fun PinsList(pinsListViewData: List<PinViewData>) {
    LazyColumn {
        items(pinsListViewData) { pinViewData ->
            Text(text = "${pinViewData.pin} ${pinViewData.name}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PinCodeGeneratorTheme {
        PinsListScreenContainer(previewPinsListViewData())
    }
}