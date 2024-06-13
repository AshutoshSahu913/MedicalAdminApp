package com.example.medicaladminapp.Screens.Details

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.medicaladminapp.Navigation.Route
import com.example.medicaladminapp.R
import com.example.medicaladminapp.ui.theme.AppColor

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    navController: NavHostController,
    args: Route.Details
) {

    val context = LocalContext.current

    Box(modifier = Modifier.fillMaxSize()) {

        Card(
            modifier = Modifier
                .padding(5.dp),
            elevation = CardDefaults.cardElevation(10.dp),
            colors = CardDefaults.cardColors(
                Color.White
            )
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .padding(vertical = 10.dp, horizontal = 10.dp)
                    .wrapContentSize()
            ) {

                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Id : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.id.toString(),
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Name : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.name,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Phone Number : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.phone,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Email : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.email,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Password : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.password,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Address : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.address,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Approved : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.approved.toString(),
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Pin code : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.pincode,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Block Status : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.block.toString(),
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "User Id: ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.user_id.toString(),
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Date of Creation : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.dateOfAccountCreation,
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = "Level : ", color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Normal,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                    Text(
                        text = args.level.toString(),
                        color = Color.Black,
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.Black,
                        fontFamily = FontFamily(Font(R.font.poppins_medium)),
                        fontSize = 15.sp
                    )
                }
                val color = remember {
                    mutableStateOf(0)
                }
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {


                    ElevatedButton(
                        modifier = Modifier.padding(4.dp),
                        onClick = {

                            viewModel.updateUserApprovalStatus(
                                userId = args.user_id,
                                approval = 1
                            )
                            if (viewModel.updateUserRes.value?.status == 200) {
                                color.value = 1
                                Toast.makeText(
                                    context,
                                    "User details update successfully!",
                                    Toast.LENGTH_SHORT
                                ).show()

                            } else {
                                Toast.makeText(
                                    context,
                                    "User details update failed!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        },
                        colors = ButtonDefaults.buttonColors(
                            if (color.value == 0)
                                AppColor
                            else
                                Color.Black

                        ),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Approved", color = Color.White,
                            fontStyle = FontStyle.Normal,
                            fontWeight = FontWeight.Black,
                            fontFamily = FontFamily(Font(R.font.poppins_medium)),
                            fontSize = 15.sp
                        )
                    }

                    ElevatedButton(
                        modifier = Modifier.padding(4.dp),
                        onClick = { },
                        colors = ButtonDefaults.buttonColors(Color.Green),
                        shape = RoundedCornerShape(10.dp)
                    ) {
                        Text(
                            text = "Blocked", color = Color.White,
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

}