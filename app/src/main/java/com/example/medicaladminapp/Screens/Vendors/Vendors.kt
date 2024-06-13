package com.example.medicaladminapp.Screens.Vendors

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.medicaladminapp.DataModel.UserDataItem
import com.example.medicaladminapp.Navigation.Route
import com.example.medicaladminapp.R
import com.example.medicaladminapp.ui.theme.AppColor

@Composable
fun Vendors(navHostController: NavHostController, viewModel: VendorsViewModel) {
    val data = viewModel.res.value
    Scaffold(modifier = Modifier.background(Color.White),content = {
        Column(modifier = Modifier.padding(it)) {
            LazyColumn(modifier = Modifier.padding(bottom = 40.dp)) {
                items(data) {
                    Log.d("DATA", "HomeScreen: ${it!!.name}")
                    UserCardItems(navController = navHostController, userData = it)
                }
            }
        }

    }, topBar = {
        Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(horizontal = 10.dp).height(40.dp).fillMaxWidth()){
            Text(
                text = "All Vendors Details",
                color = Color.Blue,
                fontStyle = FontStyle.Normal,
                fontWeight = FontWeight.Black,
                fontFamily = FontFamily(Font(R.font.poppins_medium)),
                fontSize = 20.sp
            )
        }
    })

}


@Composable
fun UserCardItems(userData: UserDataItem?, navController: NavController) {
    Card(
        modifier = Modifier
            .padding(5.dp),
        colors = CardDefaults.cardColors(Color.White),
        elevation = CardDefaults.cardElevation(5.dp)
    ) {
        Column(
            modifier = Modifier

                .padding(vertical = 20.dp, horizontal = 20.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Text(
                    text = "Name : ",
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )

                Text(
                    text = userData!!.name,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Text(
                    text = "Email : ",
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )

                Text(
                    text = userData!!.email,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )
            }

            Spacer(modifier = Modifier.height(5.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {


                Text(
                    text = "Phone : ",
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )


                Text(
                    text = userData!!.phone,
                    color = Color.Black,
                    fontStyle = FontStyle.Normal,
                    fontWeight = FontWeight.Black,
                    fontFamily = FontFamily(Font(R.font.poppins_medium)),
                    fontSize = 15.sp
                )
            }

            Divider(color = Color.LightGray, modifier = Modifier.padding(vertical = 20.dp))
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween
            ) {

                ElevatedButton(
                    modifier = Modifier

                        .wrapContentWidth(), onClick = {

                    }, colors = ButtonDefaults.buttonColors(
                        Color.Black
                    ), shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "Approved",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                ElevatedButton(
                    modifier = Modifier.wrapContentSize(), onClick = {
                        navController.navigate(
                            Route.Details(
                                name = userData!!.name,
                                address = userData.address,
                                dateOfAccountCreation = userData.dateOfAccountCreation,
                                email = userData.email,
                                id = userData.id,
                                user_id = userData.user_id,
                                password = userData.password,
                                phone = userData.phone,
                                pincode = userData.pincode,
                                block = userData.block,
                                level = userData.level,
                                approved = userData.approved
                            )
                        )
                    }, colors = ButtonDefaults.buttonColors(
                        AppColor
                    ), shape = RoundedCornerShape(10.dp)
                ) {
                    Text(
                        text = "See More",
                        color = Color.White,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
            }
        }

    }
}
