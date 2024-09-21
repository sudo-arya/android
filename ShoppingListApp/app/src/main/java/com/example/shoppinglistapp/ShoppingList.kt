package com.example.shoppinglistapp

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

data class shoppingItem(
    val id:Int,
    var name:String,
    var quantity:UInt,
    var isEditing:Boolean=false
)

@Composable
fun ShoppingListApp(){
    var sItems by remember { mutableStateOf(listOf<shoppingItem>()) }
    var showDialog by remember { mutableStateOf(false)}
    var itemName by remember { mutableStateOf("") }
    var itemQuantity by remember { mutableStateOf("") }


    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { showDialog=true },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Add Item")
        }
        LazyColumn(
            modifier= Modifier
                .fillMaxSize()
                .padding(16.dp)
        ){
            items(sItems){
                item ->
                if (item.isEditing){
                    ShoppingItemEditor(item = item, onEditComplete = {
                        editName, editQuantity ->
                        sItems = sItems.map { it.copy(isEditing = false) }
                        val editedItem = sItems.find { it.id == item.id }
                        editedItem?.let {
                            if (editName.isNotBlank()) it.name = editName
                            it.quantity = editQuantity

                        }
                    })
                }else{
                    ShoppingListItem(
                        item = item,
                        onEditClick = {
//                            finding out which item we clicked on editing & changing its edited
                            //                            boolean to true
                                      sItems = sItems.map { it.copy(isEditing = it.id == item.id) }
                        },
                        onDeleteClick = {
                            sItems = sItems-item
                        }) {
                        
                    }
                    Spacer(modifier = Modifier.height(4.dp))
                }
            }
        }
    }

    if (showDialog){
        AlertDialog(onDismissRequest = { showDialog=false },
            confirmButton = {
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(8.dp),
                                horizontalArrangement = Arrangement.SpaceBetween
                            ) {
                                Button(onClick = {
                                    if (itemName.isNotBlank()){
                                        val newItem = shoppingItem(
                                            id = sItems.size+1,
                                            name = itemName,
                                            quantity = itemQuantity.toUIntOrNull()?:1u
                                        )
                                        sItems += newItem
                                        showDialog = false
                                        itemName = ""
                                        itemQuantity = ""
                                    }
                                },
                                    modifier = Modifier.widthIn(90.dp,130.dp).heightIn(40.dp,66
                                        .dp)
                                    ) {
                                    Text(text = "Add $itemName")
                                }
                                Button(onClick = {
                                    if (itemName.isNotBlank() || itemQuantity
                                    .isNotBlank()) {
                                        showDialog = false
                                        itemName = ""
                                        itemQuantity = ""
                                    }else{
                                        showDialog = false
                                    }
                                }) {
                                    Text(text = "Cancel")
                                }
                            }
            },
            title = { Text(text = "Add Shopping Item :-")},
            text = {
                Column {
                    Spacer(modifier = Modifier.height(8.dp))
                    OutlinedTextField(value = itemName, onValueChange = {
                        itemName = it
                    },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth(),
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(value = itemQuantity, onValueChange = {
                        itemQuantity = it
                    },
                        singleLine = true,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        )
    }
}
@Composable
fun ShoppingItemEditor(item: shoppingItem,onEditComplete: (String,UInt) -> Unit){
    var editName by remember { mutableStateOf(item.name) }
    var editQuantity by remember { mutableStateOf(item.quantity.toString()) }
    var isEditing by remember { mutableStateOf(item.isEditing) }
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .background(color = MaterialTheme.colorScheme.background)
            .padding(6.dp),
        horizontalArrangement = Arrangement.SpaceEvenly
    ){
        Column {
            BasicTextField(value = editName, onValueChange = {editName = it},
                modifier = Modifier
                    .widthIn(236.dp,236.dp)
                    .padding(2.dp)
                    .border(border = BorderStroke(
                        1.dp, color = Color
                            .LightGray
                    ), shape = RoundedCornerShape(20)).padding(4.dp)
                )

            BasicTextField(value = editQuantity, onValueChange = {editQuantity = it}, singleLine = true,
                modifier = Modifier
                    .widthIn(236.dp,236.dp)
                    .padding(2.dp)
                    .border(border = BorderStroke(
                        1.dp, color = Color
                            .LightGray
                    ), shape = RoundedCornerShape(20)).padding(4.dp)
            )
        }
        Button(onClick = {
            isEditing = false
            onEditComplete(editName,editQuantity.toUIntOrNull()?:1u)
        }) {
            Text(text = "Save", modifier = Modifier.widthIn(32.dp,48.dp), softWrap = false)

        }

    }

}
@Composable
fun ShoppingListItem(
    item: shoppingItem,
    onEditClick: () -> Unit,
    onDeleteClick: () -> Unit,
    function: () -> Unit,
    ){
    Row (
        modifier = Modifier
            .fillMaxWidth()
            .border(
                border = BorderStroke(
                    1.dp, color = Color
                        .LightGray
                ), shape = RoundedCornerShape(20)
            ),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(text = item.id.toString(), modifier = Modifier.widthIn(34.dp,34.dp).padding(4.dp),
            softWrap = false)
        Text(text = item.name, modifier = Modifier.padding(2.dp).widthIn(142.dp,142.dp))
        Text(text = "Qty: ${item.quantity}", modifier = Modifier.padding(1.dp))
        Row (modifier = Modifier.padding(1.dp)){

            IconButton(onClick = onEditClick ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit item", tint =
                Color(100,186,100))
            }
            IconButton(onClick = onDeleteClick ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete item", tint =
                Color(255,50,50))
            }
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ShoppingListAppTheme(){
    ShoppingListApp()
}