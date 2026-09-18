package com.example.petshop.Components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.petshop.Models.Producto

@Composable
fun PedidosRecientesSection(
    productos: List<Producto>,
    estadoEntrega: String = "Entregado • Reciente",
    onPedidoClick: (Producto) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        productos.forEachIndexed { index, producto ->
            PedidoItemCard(
                producto = producto,
                estadoEntrega = estadoEntrega,
                onClick = { onPedidoClick(producto) }
            )

            if (index < productos.size - 1) {
                Spacer(modifier = Modifier.height(10.dp))
            }
        }
    }
}