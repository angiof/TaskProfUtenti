package com.example.taskprofutenti.Utility

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.core.content.ContextCompat
import com.example.awesomedialog.*
import com.example.taskprofutenti.R
import com.example.taskprofutenti.adapter.My_adapter
import com.example.taskprofutenti.views.RecyclerActivity

class Utility {
    val title = "Fatto"
    val body = "Questa persona è stata eliminata con successo"
    val si = "Ritorna alla lista"
    val no = "No"
    val cancel = "Cancel"

    fun awesomeDialogInfo( c: Context) {

 AwesomeDialog.build(c as Activity)
                    .title(
                            "Info",
                            titleColor = ContextCompat.getColor(c, android.R.color.black)
                    )

                     .body(
                             "Developed \nby\n Davide Saiano && Angelo Ferretti\n\nScritto \ncon\n java && Kotlin" +
                                     "\n\nEmail: davidesaiano1@gmail.com\n" +
                                     "Email: angiokop@gmail.com" +
                                     "\nTelefono: 3336791477 && 3518507337",
                             color = ContextCompat.getColor(c, android.R.color.black)
                     )
                    .icon(R.drawable.ic_baseline_info_24)
                    .background(R.drawable.layout_rounded_white)
                    .position(AwesomeDialog.POSITIONS.CENTER)
                    .onPositive(
                            "Thanks",
                            buttonBackgroundColor = R.drawable.layout_rounded_dark_black,
                            textColor = ContextCompat.getColor(c, android.R.color.white)

                    ) {
                        Log.d("TAG", "positive ")
                    }

        }





    fun awesomeDialogDelete( c: Context) {

        AwesomeDialog.build(c as Activity)
                    .title(
                            title,
                            titleColor = ContextCompat.getColor(c, android.R.color.black)
                    )
                     .body(
                             body,
                             color = ContextCompat.getColor(c, android.R.color.black)
                     )
                    .icon(R.drawable.ic_congrts)
                    .background(R.drawable.layout_rounded_white)
                    .position(AwesomeDialog.POSITIONS.CENTER)
                    .onPositive(
                            si,
                            buttonBackgroundColor = R.drawable.layout_rounded_dark_black,
                            textColor = ContextCompat.getColor(c, android.R.color.white)

                    ) {
                        Log.d("TAG", "positive ")
                    }

        }

    }




