package com.example.calculator_2

import android.os.Bundle
import android.os.Vibrator
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.calculator_2.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lateinit var binding: ActivityMainBinding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val vibe: Vibrator = getSystemService(VIBRATOR_SERVICE) as Vibrator

        binding.reset.setOnClickListener {
            binding.inputText.text = ""
            binding.result.text = ""
            vibe.vibrate(50)
        }
        binding.zero.setOnClickListener {
            appendOnExpression("0",true)
            vibe.vibrate(50)
        }
        binding.one.setOnClickListener {
            appendOnExpression("1",true)
            vibe.vibrate(50)
        }
        binding.two.setOnClickListener {
            appendOnExpression("2",true)
            vibe.vibrate(50)
        }
        binding.three.setOnClickListener {
            appendOnExpression("3",true)
            vibe.vibrate(50)
        }
        binding.four.setOnClickListener {
            appendOnExpression("4",true)
            vibe.vibrate(50)
        }
        binding.five.setOnClickListener {
            appendOnExpression("5",true)
            vibe.vibrate(50)
        }
        binding.six.setOnClickListener {
            appendOnExpression("6",true)
            vibe.vibrate(50)
        }
        binding.seven.setOnClickListener {
            appendOnExpression("7",true)
            vibe.vibrate(50)
        }
        binding.eight.setOnClickListener {
            appendOnExpression("8",true)
            vibe.vibrate(50)
        }
        binding.nine.setOnClickListener {
            appendOnExpression("9",true)
            vibe.vibrate(50)
        }
        binding.dot.setOnClickListener {
            appendOnExpression(".",true)
            vibe.vibrate(50)
        }
        binding.brackets.setOnClickListener {
            appendOnExpression("(",false)
            vibe.vibrate(50)
        }
        binding.bracket2.setOnClickListener {
            appendOnExpression(")",false)
            vibe.vibrate(50)
        }
        binding.divison.setOnClickListener {
            appendOnExpression("/",false)
            vibe.vibrate(50)
        }
        binding.multiply.setOnClickListener {
            appendOnExpression("*",false)
            vibe.vibrate(50)
        }
        binding.subtract.setOnClickListener {
            appendOnExpression("-",false)
            vibe.vibrate(50)
        }
        binding.add.setOnClickListener {
            appendOnExpression("+",false)
            vibe.vibrate(50)
        }

        binding.equals.setOnClickListener {
            vibe.vibrate(100)
            val expression = ExpressionBuilder(binding.inputText.text.toString()).build()
            val answer = expression.evaluate()
            binding.result.text = answer.toString()
        }
        binding.backspace.setOnClickListener {
            val strExp = binding.inputText.text.toString()
            if(strExp.isNotEmpty()){
                binding.inputText.text=strExp.substring(0,strExp.length-1)
                binding.result.text = ""
            }
        }

    }

    fun appendOnExpression(string: String, clear : Boolean){

        val input : TextView = findViewById(R.id.inputText)
        val output : TextView = findViewById(R.id.result)

        if(output.text.isNotEmpty()){
            input.text = ""
        }
        if(clear){
            output.text = ""
            input.append(string)
        }
        else{
            input.append(output.text)
            input.append(string)
            output.text = ""
        }
    }
}