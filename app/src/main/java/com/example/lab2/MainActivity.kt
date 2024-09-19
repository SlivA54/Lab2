package com.example.lab2

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val data : TextInputEditText = findViewById<TextInputEditText>(R.id.data)
        val dataTwo : TextInputEditText = findViewById<TextInputEditText>(R.id.dataTwo)
        val text : TextView = findViewById<TextView>(R.id.textView)

        val button: Button = findViewById(R.id.button)

        button.setOnClickListener {
            text.setText(Result(data.getText().toString(), dataTwo.getText().toString()))
        }


    }

    fun Result(data: String, dataTwo: String): String {
        var res: Double = 0.0
        var numb: Double = 1.0

        return try {
            val dataInt = data.toInt()
            val dataTwoDouble = dataTwo.toDouble()

            for (i in 0 until dataInt) {
                numb *= (dataTwoDouble + i)

                if (numb != 0.0) {
                    res += 1.0 / numb
                } else {
                    return "Ошибка: Деление на ноль"
                }
            }

            res.toString()
        } catch (e: NumberFormatException) {
            "Ошибка: Неверный формат числа"
        } catch (e: Exception) {
            "Ошибка: ${e.message}"
        }
    }
}