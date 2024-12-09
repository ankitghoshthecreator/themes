package com.ankitghoshthecreator.intereactive

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val darkTheme= findViewById<Button>(R.id.btnDark)
        val lightTheme=findViewById<Button>(R.id.btnLight)
        val change=findViewById<Button>(R.id.less_goo)
        val layout= findViewById<LinearLayout>(R.id.main)


        layout.setBackgroundResource(R.color.white)
        var isDark=false

        darkTheme.setOnClickListener {

            Toast.makeText(this, "switched to dark", Toast.LENGTH_SHORT).show()

            layout.setBackgroundResource(R.color.black)
            isDark=true

        }
        lightTheme.setOnClickListener {

            Toast.makeText(this, "switched to light", Toast.LENGTH_SHORT).show()

            layout.setBackgroundResource(R.color.white)
            isDark=false
        }

        change.setOnClickListener{
            if (isDark){
                layout.setBackgroundResource(R.color.white)
                isDark=false
                Toast.makeText(this, "white", Toast.LENGTH_SHORT).show()
            }else{
                layout.setBackgroundResource(R.color.black)
                isDark=true
                Toast.makeText(this,   "black", Toast.LENGTH_SHORT).show()
            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}