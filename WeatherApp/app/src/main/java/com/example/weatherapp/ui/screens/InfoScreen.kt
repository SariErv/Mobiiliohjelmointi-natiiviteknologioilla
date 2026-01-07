package com.example.weatherapp.ui.screens


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.weatherapp.R

@Composable
fun InfoScreen(navController: NavController, modifier: Modifier = Modifier) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ){
        Column(
            modifier = Modifier.align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.tietoa_sovelluksesta),
                modifier = Modifier.padding(bottom = 16.dp),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = stringResource(R.string.t_m_android_mobiilisovellus_on_tehty_viimeiseksi_palautettavaksi_ty_ksi_kurssille_mobiiliohjelmointi_natiiviteknologioilla),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp
            )
            Text(
                text = stringResource(R.string.sovelluksen_tarkoituksen_on_n_ytt_s_tietoja_halutusta_sijainnista),
                textAlign = TextAlign.Center,
                lineHeight = 24.sp,
                modifier = Modifier.padding(bottom = 26.dp)
            )

            Text(
                text = stringResource(R.string.data_source_open_meteo),
                textAlign = TextAlign.Center,
                lineHeight = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Text(
                text = stringResource(R.string.tekij_sari_ervasti_tvt24kmo),
                textAlign = TextAlign.Center,
                lineHeight = 14.sp,
                fontStyle = FontStyle.Italic
            )
        }
        Button (
            onClick = { navController.navigate("MainScreen") },
            modifier = Modifier.align(Alignment.BottomEnd),
        ) {
            Text(stringResource(R.string.mainscreen))
        }
    }
}