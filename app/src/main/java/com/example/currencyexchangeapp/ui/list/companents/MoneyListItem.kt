package com.example.currencyexchangeapp.ui.list.companents

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.example.currencyexchangeapp.domain.model.Money

@Composable
fun MoneyListItem(
    money: Money,
    onItemClick: (Money) -> Unit
) {
    Row (
        modifier = androidx.compose.ui.Modifier
            .fillMaxWidth()
            //.clickable { onItemClick(money) }
            .padding(20.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Text(
            text = "Alış:${money.Alış} Satış:${money.Satış} (${money.Tür})",
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis //metin sığmazsa üçnokta koyar
        )
        Text(
            text = "%${money.Değişim}",
            color = Color.Blue,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
            style = MaterialTheme.typography.body1,
            modifier = Modifier.align(CenterVertically)
        )
    }
}