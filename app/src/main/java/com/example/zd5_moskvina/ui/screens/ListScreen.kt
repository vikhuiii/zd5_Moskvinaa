package com.example.zd5_moskvina.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DarkMode
import androidx.compose.material.icons.filled.LightMode
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.zd5_moskvina.data.Specialty
import com.example.zd5_moskvina.data.SpecialtyRepository

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListScreen(
    navController: NavController,
    isDarkTheme: Boolean,
    onThemeToggle: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Каталог ИТ-специальностей") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
                )
            )
        },
        bottomBar = {
            BottomAppBar {
                IconButton(onClick = onThemeToggle, modifier = Modifier.padding(start = 16.dp)) {
                    Icon(
                        imageVector = if (isDarkTheme) Icons.Filled.LightMode else Icons.Filled.DarkMode,
                        contentDescription = "Сменить тему"
                    )
                }
                Text(
                    text = if (isDarkTheme) "Светлая тема" else "Темная тема",
                    modifier = Modifier.padding(start = 8.dp),
                    style = MaterialTheme.typography.bodyLarge
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            contentPadding = PaddingValues(vertical = 16.dp)
        ) {
            items(SpecialtyRepository.specialties) { specialty ->
                SpecialtyCard(
                    specialty = specialty,
                    onClick = { navController.navigate("detail/${specialty.id}") }
                )
            }
        }
    }
}
@Composable
fun SpecialtyCard(specialty: Specialty, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = specialty.name,
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Код: ${specialty.code}",
                style = MaterialTheme.typography.bodyMedium
            )
            Text(
                text = "Срок: ${specialty.duration}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
    }
}

@Composable
@androidx.compose.ui.tooling.preview.Preview(showBackground = true, name = "Карточка")
fun SpecialtyCardPreview() {
    SpecialtyCard(
        specialty = SpecialtyRepository.specialties[0],
        onClick = {}
    )
}