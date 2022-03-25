package com.example.kotlin_prac_2_4

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MotionEvent
import android.widget.*
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var km: EditText
    private lateinit var m: EditText
    private lateinit var dm: EditText
    private lateinit var sm: EditText
    private lateinit var mm: EditText
    private lateinit var rezult: TextView
    private lateinit var rezultImage: ImageView

    private var clicksOnImage: Float = 1.0F


    @SuppressLint("ClickableViewAccessibility")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.inspect)
        km = findViewById(R.id.km)
        m = findViewById(R.id.m)
        dm = findViewById(R.id.dm)
        sm = findViewById(R.id.sm)
        mm = findViewById(R.id.mm)

        rezult = findViewById(R.id.rezult)
        rezultImage = findViewById(R.id.answer)

        button.setOnClickListener {
            if (km.text.isNotEmpty() and m.text.isNotEmpty() and dm.text.isNotEmpty() and sm.text.isNotEmpty() and mm.text.isNotEmpty()) {
                val kmValue = km.text.toString().toFloat()
                val mValue = m.text.toString().toFloat()/1000
                val dmValue = dm.text.toString().toFloat()/10000
                val smValue = sm.text.toString().toFloat()/100000
                val mmValue = mm.text.toString().toFloat()/1000000

                if ((kmValue == mValue) and (kmValue == mValue) and (kmValue == dmValue) and (kmValue == smValue) and (kmValue == mmValue)){
                    rezult.text = getString(R.string.cool)
                    rezult.setTextColor(resources.getColor(R.color.blue))
                    rezultImage.setImageResource(R.drawable.cool)
                }
                else{
                    rezult.text = getString(R.string.bad)
                    rezult.setTextColor(resources.getColor(R.color.red))
                    rezultImage.setImageResource(R.drawable.bad)
                }

            } else {
                Toast.makeText(this,"Не все поля заполнены!", Toast.LENGTH_SHORT).show()
            }
        }
        rezultImage.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_UP -> {
                    if ((clicksOnImage * 10F).roundToInt() / 10F == 0.1F) {
                        clicksOnImage = 1.0F
                        rezultImage.alpha = clicksOnImage
                    } else {
                        clicksOnImage -= 0.1F
                        rezultImage.alpha = clicksOnImage
                    }
                }
            }
            true
        }
    }


}