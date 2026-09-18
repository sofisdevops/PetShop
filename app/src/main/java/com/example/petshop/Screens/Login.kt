package com.example.petshop.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.petshop.ui.theme.CremaFondo
import com.example.petshop.ui.theme.GrisMedio
import com.example.petshop.ui.theme.GrisOscuro
import com.example.petshop.ui.theme.NaranjaClaro
import com.example.petshop.ui.theme.RojoTerracota
import com.example.petshop.ui.theme.Turquesa

@Composable
fun LoginScreen(
    onLoginSuccess: (user: String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    var usuario by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var DialogoError by remember { mutableStateOf(false) }

    fun validarLogin() {
        if (usuario.trim() == "admin" && password == "1234") {
            onLoginSuccess(usuario.trim())
        } else {
            DialogoError = true
        }
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(CremaFondo),
        contentAlignment = Alignment.Center
    ) {
        Card(
            modifier = Modifier
                .fillMaxWidth(0.88f)
                .padding(16.dp),
            shape = RoundedCornerShape(28.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(28.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "PetSnack",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = RojoTerracota,
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(20.dp))

                OutlinedTextField(
                    value = usuario,
                    onValueChange = { usuario = it },
                    label = { Text("Usuario", color = GrisMedio) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = null,
                            tint = Turquesa
                        )
                    },
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Turquesa,
                        unfocusedBorderColor = NaranjaClaro,
                        focusedLabelColor = Turquesa,
                        focusedTextColor = GrisOscuro,
                        unfocusedTextColor = GrisOscuro
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Text,
                        imeAction = ImeAction.Next
                    ),
                    keyboardActions = KeyboardActions(
                        onNext = { focusManager.moveFocus(FocusDirection.Down) }
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(14.dp))

                OutlinedTextField(
                    value = password,
                    onValueChange = { password = it },
                    label = { Text("Contraseña", color = GrisMedio) },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Default.Lock,
                            contentDescription = null,
                            tint = Turquesa
                        )
                    },
                    visualTransformation = PasswordVisualTransformation(),
                    shape = RoundedCornerShape(16.dp),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Turquesa,
                        unfocusedBorderColor = NaranjaClaro,
                        focusedLabelColor = Turquesa,
                        focusedTextColor = GrisOscuro,
                        unfocusedTextColor = GrisOscuro
                    ),
                    singleLine = true,
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Password,
                        imeAction = ImeAction.Done
                    ),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            focusManager.clearFocus()
                            validarLogin()
                        }
                    ),
                    modifier = Modifier.fillMaxWidth()
                )

                Spacer(modifier = Modifier.height(24.dp))

                Button(
                    onClick = {
                        focusManager.clearFocus()
                        validarLogin()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = NaranjaClaro,
                        contentColor = Color.White
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(52.dp)
                ) {
                    Text(
                        text = "Iniciar Sesión",
                        fontSize = 16.sp,
                        fontWeight = FontWeight.Bold
                    )
                }

            } // fin Column contenedor
        } // fin Card del formulario

        if (DialogoError) {
            AlertDialog(
                onDismissRequest = { DialogoError = false },
                icon = {
                    Icon(
                        imageVector = Icons.Default.Warning,
                        contentDescription = "Error",
                        tint = RojoTerracota
                    )
                },
                title = {
                    Text(
                        text = "Datos Incorrectos",
                        fontWeight = FontWeight.Bold,
                        color = RojoTerracota
                    )
                },
                text = {
                    Text(
                        text = "El usuario o la contraseña ingresados no son correctos.",
                        color = GrisOscuro
                    )
                },
                confirmButton = {
                    TextButton(onClick = { DialogoError = false }) {
                        Text("Entendido", color = Turquesa, fontWeight = FontWeight.Bold)
                    }
                },
                containerColor = Color.White
            )
        } // fin del card de la alerta
    } // fin Box
} // fin de la funcion pruncipal