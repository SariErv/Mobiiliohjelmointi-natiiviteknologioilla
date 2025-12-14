package com.example.bmicalculator.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bmicalculator.R
import com.example.bmicalculator.ui.viewmodels.CalcViewModel

@Composable
fun Calculator(modifier: Modifier = Modifier, calcViewModel: CalcViewModel = viewModel()) {
    Column (
        modifier = modifier.padding(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        Text (
            text = stringResource(R.string.bmi_calculator),
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        OutlinedTextField(
            value = calcViewModel.heightInput,
            onValueChange = {calcViewModel.heightInput = it},
            singleLine = true,
            label = { Text(stringResource(R.string.height))},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        OutlinedTextField(
            value = calcViewModel.weightInput,
            onValueChange = {calcViewModel.weightInput = it},
            singleLine = true,
            label = { Text(stringResource(R.string.weight))},
            modifier = Modifier.fillMaxWidth(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = stringResource(R.string.your_bmi_is_s, String.format("%.2f", calcViewModel.bmi)))
    }
}