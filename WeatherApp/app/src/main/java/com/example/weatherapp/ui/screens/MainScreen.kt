package com.example.weatherapp.ui.screens


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.weatherapp.R
import com.example.weatherapp.viewmodels.WeatherViewModel

@Composable
fun MainScreen(navController: NavController,
               modifier: Modifier = Modifier,
               viewModel: WeatherViewModel = viewModel()
) {
    var town by remember { mutableStateOf("Oulu") }
    val uiState by viewModel.uiState.collectAsState()

    Scaffold(
        modifier = modifier.fillMaxSize()
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp)
        ) {
            Text(
                modifier = Modifier.align(Alignment.TopCenter),
                text = stringResource(R.string.weatherapp),
                style = MaterialTheme.typography.titleLarge,
            )

            Column(
                modifier = Modifier.align(Alignment.Center),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                OutlinedTextField(
                    value = town,
                    onValueChange = { town = it },
                    label = { Text(stringResource(R.string.sijainti)) }
                )
                Button(
                    onClick = { viewModel.fetchWeather(town) }
                ) {
                    Text(stringResource(R.string.hae_s))
                }

                if (uiState.loading) {
                    Text(stringResource(R.string.ladataan_s_tietoja))
                } else if (uiState.error != null) {
                    Text("${uiState.error}")
                } else if (uiState.weather != null) {
                    Text("Lämpötila: ${uiState.weather?.temperature_2m} °C",
                        style = MaterialTheme.typography.headlineMedium)
                    Text("Ilmankosteus: ${uiState.weather?.relative_humidity_2m} %")
                    Text("Tuulen nopeus: ${uiState.weather?.wind_speed_10m} m/s")
                }
            }

            Button(
                onClick = { navController.navigate("InfoScreen") },
                modifier = Modifier.align(Alignment.BottomEnd)
            ) {
                Text(stringResource(R.string.infoscreen))
            }
        }
    }
}

