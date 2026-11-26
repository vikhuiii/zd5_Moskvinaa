package com.example.zd5_moskvina.ui.screens

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zd5_moskvina.data.SpecialtyRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(specialtyId: Int, navController: NavController) {
    val specialty = SpecialtyRepository.specialties.find { it.id == specialtyId }
    val context = LocalContext.current

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("О специальности") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "Назад")
                    }
                }
            )
        }
    ) { innerPadding ->
        if (specialty != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding)
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                Text(text = specialty.name, style = MaterialTheme.typography.headlineMedium)
                Text(text = "Код: ${specialty.code}", style = MaterialTheme.typography.titleMedium)
                Text(text = "Срок обучения: ${specialty.duration}", style = MaterialTheme.typography.bodyLarge)
                Text(text = "Квалификация: ${specialty.qualification}", style = MaterialTheme.typography.bodyLarge)

                Spacer(modifier = Modifier.height(8.dp))
                Text(text = specialty.description, style = MaterialTheme.typography.bodyMedium)

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:${specialty.phone}"))
                        context.startActivity(intent)
                    },
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Позвонить в приемную комиссию")
                }
            }
        } else {
            Text("Специальность не найдена", modifier = Modifier.padding(innerPadding))
        }
    }
}