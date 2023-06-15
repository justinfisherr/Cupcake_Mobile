package com.example.cupcake.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cupcake.R
import com.example.cupcake.ui.components.FormattedPriceLabel


@Composable
fun CreditCardForm(subtotal: String,
                   onCancelButtonClicked: () -> Unit = {},
                   onNextButtonClicked: (String, String, String, String) -> Unit,
                   modifier: Modifier = Modifier) {
    val cardNumberState = remember { mutableStateOf("") }
    val expirationDateState = remember { mutableStateOf("") }
    val securityCodeState = remember { mutableStateOf("") }
    val addressState = remember { mutableStateOf("") }
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Text("Credit Card Form", fontSize = 20.sp, fontWeight = FontWeight.Bold)
        Column(
            modifier = Modifier.fillMaxWidth().padding(top=10.dp),
            verticalArrangement =  Arrangement.Top)
        {
            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next),
                value = cardNumberState.value,
                onValueChange = { cardNumberState.value = it},
                label = { Text("Credit Card Number") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )


            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next),
                value = expirationDateState.value,
                onValueChange = {expirationDateState.value = it },
                label = { Text("Expriation Date: 01.01.1111") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )


            TextField(
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next),
                value = securityCodeState.value,
                onValueChange = { securityCodeState.value = it},
                label = { Text("Security Code") },
                modifier = Modifier.fillMaxWidth().padding(bottom = 10.dp)
            )

            TextField(
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Go),
                value = addressState.value,
                onValueChange = { addressState.value = it},
                label = { Text("Shipping Address") },
                modifier = Modifier.fillMaxWidth()
            )
            FormattedPriceLabel(
                subtotal = subtotal,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(
                        top = dimensionResource(R.dimen.padding_medium),
                        bottom = dimensionResource(R.dimen.padding_medium)
                    ))

        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(dimensionResource(R.dimen.padding_medium))
                .weight(1f),
            horizontalArrangement = Arrangement.spacedBy(dimensionResource(R.dimen.padding_medium)),
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(modifier = Modifier.weight(1f), onClick = onCancelButtonClicked) {
                Text(stringResource(R.string.cancel))
            }
            Button(
                modifier = Modifier.weight(1f),
                // the button is enabled when the user makes a selection
                onClick = {onNextButtonClicked(
                    cardNumberState.value,
                    expirationDateState.value,
                    securityCodeState.value,
                    addressState.value
                )}
            ) {
                Text(stringResource(R.string.done))
            }
        }


    }

}



@Preview
@Composable
fun CreditInput(){


}