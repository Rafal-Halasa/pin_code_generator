package com.simcodic.pincodegenerator.presentation.pins_list

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.simcodic.pincodegenerator.R
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinViewData
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.PinsListViewData
import com.simcodic.pincodegenerator.presentation.pins_list.view_data.previewPinsListViewData
import com.simcodic.pincodegenerator.presentation.theme.PinCodeGeneratorTheme

@Composable
fun PinsListScreen(pinsListViewModel: PinsListViewModel) {
    PinsListScreenContainer(
        pinsListViewModel.uiState.collectAsState().value,
        pinsListViewModel.showCreatePinDialog.collectAsState().value,
        pinsListViewModel::onAddPinShowDialog,
        pinsListViewModel::onCancelAddPinShowDialog,
        pinsListViewModel::onAddPin,
    )
}

@Composable
fun PinsListScreenContainer(
    pinsListViewData: PinsListViewData?,
    showCreatePinDialog: Boolean,
    onAddPinShowDialog: () -> Unit,
    onCancelAddPinShowDialog: () -> Unit,
    onAddPin: () -> Unit
) {
    Column(modifier = Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        CenterAlignedTopAppBar(
            title = {
                Text(text = stringResource(id = R.string.pin_list_screen_name))
            }
        )

        if (pinsListViewData == null) {
            EmptyListPlaceHolder()
        } else {
            PinsList(pinsListViewData = pinsListViewData.pinList)
        }
        if (showCreatePinDialog) {
            CreatePinDialog(onCancelAddPinShowDialog = onCancelAddPinShowDialog, onAddPin = onAddPin)
        }

        Spacer(modifier = Modifier.weight(1f))
        TextButton(
            onClick = onAddPinShowDialog,
            modifier = Modifier.width(200.dp),
            colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.secondary)
        ) {
            Text(text = "Add Pin")
        }
        Spacer(modifier = Modifier.height(15.dp))
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CreatePinDialog(onCancelAddPinShowDialog: () -> Unit, onAddPin: () -> Unit) {
    Dialog(onDismissRequest = onCancelAddPinShowDialog) {
        Card(
            modifier = Modifier
                .height(height = 40.dp)
                .padding(horizontal = 10.dp)
        ) {
            Text(text = "test")
            TextButton(onClick = onCancelAddPinShowDialog) {
                Text(text = "Add")
            }
            TextButton(onClick = onAddPin) {
                Text(text = "Cancel")
            }
        }
    }
}

@Composable
private fun EmptyListPlaceHolder() {
    Text(
        text = "Empty list", modifier = Modifier.fillMaxWidth(),
        textAlign = TextAlign.Center
    )
}

@Composable
private fun PinsList(pinsListViewData: List<PinViewData>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        items(pinsListViewData) { pinViewData ->
            PinListItem(pinViewData)
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun PinListItem(pinViewData: PinViewData) {
    Card(modifier = Modifier.height(50.dp)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Text(
                text = pinViewData.name,
                modifier = Modifier.fillMaxWidth(0.5f),
                style = MaterialTheme.typography.titleLarge,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.width(10.dp))
            Text(
                text = pinViewData.pin,
                modifier = Modifier.fillMaxWidth(0.5f),
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.weight(1f))
            Icon(
                painter = painterResource(id = R.drawable.ic_delete),
                contentDescription = stringResource(id = R.string.common_delete)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    PinCodeGeneratorTheme {
        PinsListScreenContainer(previewPinsListViewData(), false, {}, {}, {})
    }
}

@Preview(showBackground = true)
@Composable
fun ScreenPreviewEmptyList() {
    PinCodeGeneratorTheme {
        PinsListScreenContainer(null, false, {}, {}, {})
    }
}