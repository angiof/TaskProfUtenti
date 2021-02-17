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

    fun awesomeDialogEdit(view: View, c: Context) {


        /* view.setOnClickListener {

             AwesomeDialog.build( c as Activity)
                 .title(
                     title,
                     titleColor = ContextCompat.getColor(c, android.R.color.white)
                 )
                 .body(
                     body,
                     color = ContextCompat.getColor(c, android.R.color.white)
                 )
                 .icon(R.drawable.ic_congrts)
                 .background(R.drawable.layout_rounded_white*//*layout_rounded_green*//*)
                .position(AwesomeDialog.POSITIONS.CENTER)
                .onPositive(
                    goToMyAccount,
                    buttonBackgroundColor = R.drawable.ic_launcher_background*//*layout_rounded_dark_white*//*,
                    textColor = ContextCompat.getColor(c, android.R.color.black)
                ) {
                    Log.d("TAG", "positive ")
                }
        }*/

    }

    fun awesomeDialogDelete( c: Context) {

        AwesomeDialog.build(c as Activity)
                    .title(
                            title,
                            titleColor = ContextCompat.getColor(c, android.R.color.white)
                    )
                     .body(
                             body,
                             color = ContextCompat.getColor(c, android.R.color.white)
                     )
                    .icon(R.drawable.ic_congrts)
                    .background(R.drawable.layout_rounded_green)
                    .position(AwesomeDialog.POSITIONS.CENTER)
                    .onPositive(
                            si,
                            buttonBackgroundColor = R.drawable.layout_rounded_dark_white,
                            textColor = ContextCompat.getColor(c, android.R.color.black)

                    ) {
                        Log.d("TAG", "positive ")
                    }

        }

    }




