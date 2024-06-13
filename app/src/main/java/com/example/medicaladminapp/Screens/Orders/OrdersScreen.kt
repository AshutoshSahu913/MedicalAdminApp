package com.example.medicaladminapp.Screens.Orders

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Dashboard
import androidx.compose.material.icons.filled.Money
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.medicaladminapp.DataModel.UserDataItem
import com.example.medicaladminapp.Navigation.Route
import com.example.medicaladminapp.R
import com.example.medicaladminapp.Screens.AddProduct.AddProduct
import com.example.medicaladminapp.Screens.AddProduct.AddProductViewModel
import com.example.medicaladminapp.Screens.BottomTab

import com.example.medicaladminapp.ui.theme.AppColor
import com.example.medicaladminapp.ui.theme.Color3
import com.example.medicalvendorapp.DataModel.ProductResponseItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderScreen(navHostController: NavHostController,viewModel:OrderViewModel ) {
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember {
        mutableStateOf(false)
    }
    val products = viewModel.productResponse.value
    val selectedProduct = remember { mutableStateOf<ProductResponseItem?>(null) }

    Scaffold(
        bottomBar = {
            if (showBottomSheet) {
                ModalBottomSheet(
                    onDismissRequest = { showBottomSheet = false },
                    sheetState = sheetState,
                    containerColor = Color.White
                ) {
                    AddProduct(
                        navHostController = navHostController,
                        viewModel = AddProductViewModel()
                    )
                }
            }
        },
        content = {it
            LazyVerticalGrid(
                userScrollEnabled = true, columns = GridCells.Adaptive(minSize = 150.dp)
            ) {
                items(products) { photo ->
                    ProductCardItems(
                        photo, navHostController
                    ) {
                        selectedProduct.value = photo
//                        showBottomSheet.value = true
                    }
                }
            }
        }, floatingActionButtonPosition = FabPosition.End,
        floatingActionButton = {
            FloatingActionButton(modifier = Modifier.padding(bottom = 23.dp), onClick = {
                showBottomSheet = true
            }, containerColor = Color.Black, content = {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "",
                    tint = Color.White
                )
            })
        }
    )

}



@Composable
fun ProductCardItems(
    productData: ProductResponseItem?, navController: NavController, onCardClick: () -> Unit
) {
    Card(
        modifier = Modifier
            .height(150.dp)
            .padding(10.dp)
            .clickable {
                onCardClick.invoke()
            },
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Column(modifier = Modifier.wrapContentSize()) {
                Text(
                    text = productData!!.productName,
                    color = Color3,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = FontFamily(Font(R.font.poppins_bold)),
                    fontSize = 20.sp
                )
                Text(
                    text = productData.productCategory,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 15.sp
                )
            }

            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Text(
                    text = "₹ ${productData!!.productPrice.toInt()}",
                    color = AppColor,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 15.sp
                )

                Text(
                    text = productData.productStock.toString(),
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_regular)),
                    fontSize = 15.sp
                )

            }
        }
    }
}
