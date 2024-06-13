package com.example.medicaladminapp.Screens.AddProduct

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.medicaladminapp.Navigation.Route
import com.example.medicaladminapp.R
import com.example.medicaladminapp.ui.theme.AppColor

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddProduct(
    navHostController: NavHostController, viewModel: AddProductViewModel
) {

    when (viewModel.state.value) {
        State.DEFAULT.name -> {
            val context = LocalContext.current
            val categories = listOf(
                "Pain Reliever",
                "Antibiotic",
                "Antiseptic",
                "Vitamins",
                "Antidepressant",
                "Antihistamine",
                "Anti-inflammatory",
                "Antifungal",
                "Antiviral",
                "Cardiovascular",
                "Diabetes",
                "Digestive Aid",
                "Hormonal",
                "Immunosuppressant",
                "Laxative",
                "Sedative",
                "Respiratory",
                "Skin Care",
                "Vaccines",
                "Weight Loss",
                "Eye Drops",
                "Ear Drops",
                "Cold and Flu",
                "Cough Suppressant",
                "Allergy Relief"
            )
            var expanded by remember { mutableStateOf(false) }
            var selectedCategory = remember { mutableStateOf(categories[0]) }

            val productName = remember {
                mutableStateOf("")
            }
            val productPrice = remember {
                mutableStateOf("")
            }
//            val productCategory = remember {
//                mutableStateOf(categories[0])
//            }
            val productStock = remember {
                mutableStateOf(0)
            }

            val productCertified = remember {
                mutableStateOf(false)
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
                    .padding(
                        bottom = 20.dp, start = 4.dp, end = 4.dp
                    )
            ) {
                Spacer(modifier = Modifier.height(10.dp))
                Image(
                    painter = painterResource(id = R.drawable.products),
                    modifier = Modifier.size(100.dp),
                    contentDescription = ""
                )

                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Add New Products",
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 17.sp
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = productName.value,
                    onValueChange = { productName.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    label = {
                        Text(text = "Product Name")
                    }, colors = TextFieldDefaults.colors(
                        focusedLeadingIconColor = AppColor,
                        unfocusedLeadingIconColor = Color.Gray,
                        focusedLabelColor = AppColor,
                        unfocusedLabelColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = AppColor,
                        unfocusedIndicatorColor = Color.LightGray,
                        unfocusedPlaceholderColor = AppColor,
                        errorTextColor = Color.Red
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))

                OutlinedTextField(
                    value = productPrice.value,
                    onValueChange = { productPrice.value = it },
                    modifier = Modifier.fillMaxWidth(),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    label = {
                        Text(text = "Product Price")
                    }, colors = TextFieldDefaults.colors(
                        focusedLeadingIconColor = AppColor,
                        unfocusedLeadingIconColor = Color.Gray,
                        focusedLabelColor = AppColor,
                        unfocusedLabelColor = Color.Black,
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        focusedIndicatorColor = AppColor,
                        unfocusedIndicatorColor = Color.LightGray,
                        unfocusedPlaceholderColor = AppColor,
                        errorTextColor = Color.Red
                    )
                )
                Spacer(modifier = Modifier.height(10.dp))
//
//                OutlinedTextField(value = productCategory.value,
//                    onValueChange = { productCategory.value = it },
//                    modifier = Modifier.fillMaxWidth(),
//                    label = {
//                        Text(text = "Product Category")
//                    }
//                    , colors = TextFieldDefaults.colors(
//                        focusedLeadingIconColor = AppColor,
//                        unfocusedLeadingIconColor = Color.Gray,
//                        focusedLabelColor = AppColor,
//                        unfocusedLabelColor = Color.Black,
//                        focusedContainerColor = Color.White,
//                        unfocusedContainerColor = Color.White,
//                        focusedIndicatorColor = AppColor,
//                        unfocusedIndicatorColor = Color.LightGray,
//                        unfocusedPlaceholderColor = AppColor,
//                        errorTextColor = Color.Red
//                    ))
                ExposedDropdownMenuBox(
                    expanded = expanded,
                    onExpandedChange = { expanded = !expanded },
                ) {
                    OutlinedTextField(
                        modifier = Modifier.background(Color.White)
                            .fillMaxWidth()
                            .menuAnchor(),
                        readOnly = true,
                        value = selectedCategory.value,
                        onValueChange = {},
                        trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = expanded) },
                        colors = ExposedDropdownMenuDefaults.textFieldColors(
                            focusedContainerColor = Color.White,
                            unfocusedContainerColor = Color.White,
                            disabledContainerColor = Color.White,
                            errorContainerColor = Color.White,
                            focusedTextColor = AppColor,
                            unfocusedTextColor = Color.Black,
                            disabledTextColor = Color.Black,

                            ),
                    )
                    ExposedDropdownMenu(
                        expanded = expanded,
                        onDismissRequest = { expanded = false },
                    ) {
                        categories.forEach { selectionOption ->
                            DropdownMenuItem(
                                modifier = Modifier.background(Color.White),
                                text = { Text(selectionOption) },
                                onClick = {
                                    selectedCategory.value = selectionOption
                                    expanded = false
                                },
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = "Product Stock",
                    fontWeight = FontWeight.Normal,
                    fontSize = 15.sp,
                    fontStyle = FontStyle.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(

                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Card(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    if (productStock.value > 0) {
                                        productStock.value -= 1
                                    }
                                },
                            colors = CardDefaults.cardColors(AppColor),
                            shape = RoundedCornerShape(5.dp)
                        ) {
                            Box(modifier = Modifier) {
                                Icon(
                                    modifier = Modifier.align(Alignment.Center),
                                    imageVector = Icons.Filled.Remove,
                                    contentDescription = "",
                                    tint = Color.White,
                                )

                            }
                        }
                        OutlinedTextField(
                            modifier = Modifier.width(100.dp)
                                .height(50.dp)
                                .padding(horizontal = 5.dp),
                            value = productStock.value.toString(),
                            onValueChange = { value ->
                                value.toIntOrNull()?.let {
                                    productStock.value = it
                                }
                            },

                            colors = TextFieldDefaults.colors(
                                focusedLeadingIconColor = AppColor,
                                unfocusedLeadingIconColor = Color.Gray,
                                focusedLabelColor = AppColor,
                                unfocusedLabelColor = Color.Black,
                                focusedContainerColor = Color.White,
                                unfocusedContainerColor = Color.White,
                                focusedIndicatorColor = AppColor,
                                unfocusedIndicatorColor = Color.LightGray,
                                unfocusedPlaceholderColor = AppColor,
                                errorTextColor = Color.Red

                            ),
                            textStyle = TextStyle(fontSize = 15.sp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                            maxLines = 1
                        )
                        Card(
                            modifier = Modifier
                                .size(30.dp)
                                .clickable {
                                    productStock.value += 1
                                },
                            colors = CardDefaults.cardColors(AppColor),
                            shape = RoundedCornerShape(5.dp),
                            ) {
                            Box(modifier = Modifier.fillMaxSize()) {
                                Icon(
                                    modifier = Modifier.align(Alignment.Center),
                                    imageVector = Icons.Filled.Add,
                                    contentDescription = "",
                                    tint = Color.White,
                                )

                            }
                        }
                    }
                    Spacer(modifier = Modifier.width(30.dp))
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {

                        Text(
                            text = "Certified",
                            color = Color.Black,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Normal,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 17.sp
                        )
                        Checkbox(
                            checked = productCertified.value,
                            onCheckedChange = { productCertified.value = it },
                            colors = CheckboxDefaults.colors(
                                checkedColor = AppColor,
                                checkmarkColor = Color.White,
                                uncheckedColor = Color.LightGray
                            )
                        )

                    }

                }

                Spacer(modifier = Modifier.height(10.dp))
                ElevatedButton(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 5.dp)
                        .fillMaxWidth(),
                    onClick = {
//
//                        if (productName.value.isEmpty() || productPrice.value.isEmpty() || productStock.value.toString()
//                                .isEmpty() || productCategory.value.isEmpty()
//                        ) {
//                            Toast.makeText(
//                                context,
//                                "Please Fill All Fields",
//                                Toast.LENGTH_SHORT
//                            ).show()
//                        } else {
                        viewModel.createProducts(
                            name = productName.value,
                            price = productPrice.value,
                            stock = productStock.value.toString(),
                            category = selectedCategory.value,
                            certified = productCertified.value.toString()
                        )
//                        }

                        if (viewModel.addProductRes.value?.status==200){
                            Toast.makeText(context, "Product Added Successfully !", Toast.LENGTH_SHORT)
                                .show()
                        }else{
                            Toast.makeText(context, "Product Added Failed !", Toast.LENGTH_SHORT)
                                .show()
                        }
                    },
                    colors = ButtonDefaults.buttonColors(AppColor),
                    shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Add Product",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 19.sp
                    )
                }

            }

        }

        State.FAILED.name -> {
            FailedScreen(viewModel = viewModel)
        }

        State.SUCCESS.name -> {
            SuccessScreen(navController = navHostController, viewModel = viewModel)
        }

        State.LOADING.name -> {
            Box(modifier = Modifier.size(400.dp)) {
                CircularProgressIndicator(
                    color = AppColor,
                    modifier = Modifier.align(Alignment.Center)
                )

            }
        }
    }
}


@Composable
fun SuccessScreen(navController: NavHostController, viewModel: AddProductViewModel) {

    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp),
            painter = painterResource(id = R.drawable.success),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Product Added Successfully !",
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        ElevatedButton(
            modifier = Modifier
                .width(200.dp)
                .fillMaxWidth(), onClick = {
                navController.navigate(Route.Home)
            }, colors = ButtonDefaults.buttonColors(
                AppColor
            ), shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Go to Home Screen",
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 15.sp
            )
        }
        Spacer(modifier = Modifier.height(20.dp))

    }
}


@Composable
fun FailedScreen(viewModel: AddProductViewModel) {
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .size(250.dp),
            painter = painterResource(id = R.drawable.error),
            contentDescription = ""
        )
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = "Failed to Add Product!",
            color = Color.Black,
            fontStyle = FontStyle.Normal,
            fontWeight = FontWeight.Thin,
            fontFamily = FontFamily(Font(R.font.poppins_medium)),
            fontSize = 15.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        TextButton(
            modifier = Modifier.width(200.dp),
            onClick = {
                viewModel.setDefault()
            }, colors = ButtonDefaults.buttonColors(
                AppColor
            ), shape = RoundedCornerShape(10.dp)
        ) {
            Text(
                text = "Try Again",
                color = Color.White,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.ExtraBold,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 15.sp
            )
        }
    }
}
