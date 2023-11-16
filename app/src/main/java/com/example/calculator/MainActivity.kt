package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.calculator.databinding.ActivityMainBinding
import net.objecthunter.exp4j.ExpressionBuilder


class MainActivity : AppCompatActivity()
{
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*Number Buttons*/

        binding.tvone.setOnClickListener {
            evaluateExpression("1", clear = true)
        }

        binding.tvtwo.setOnClickListener {
            evaluateExpression("2", clear = true)
        }

        binding.tvthree.setOnClickListener {
            evaluateExpression("3", clear = true)
        }
        binding.tvfour.setOnClickListener {
            evaluateExpression("4", clear = true)
        }

        binding.tvfive.setOnClickListener {
            evaluateExpression("5", clear = true)
        }

        binding.tvsix.setOnClickListener {
            evaluateExpression("6", clear = true)
        }

        binding.tvSevin.setOnClickListener {
            evaluateExpression("7", clear = true)
        }

        binding.tvEight.setOnClickListener {
            evaluateExpression("8", clear = true)
        }

        binding.tvNine.setOnClickListener {
            evaluateExpression("9", clear = true)
        }

        binding.tvzero.setOnClickListener {
            evaluateExpression("0", clear = true)
        }

        /*Operators*/

        binding.tvadd.setOnClickListener {
            evaluateExpression("+", clear = true)
        }

        binding.tvminus.setOnClickListener {
            evaluateExpression("-", clear = true)
        }

        binding.tvmaltiple.setOnClickListener {
            evaluateExpression("*", clear = true)
        }
        binding.tvpresentage.setOnClickListener {
            evaluateExpression("%", clear = true)
        }

        binding.tvDivied.setOnClickListener {
            evaluateExpression("/", clear = true)
        }

        binding.tvClear.setOnClickListener {
            binding.tvExpression.text = ""
            binding.tvResult.text = ""
        }

        binding.tvdot.setOnClickListener {
            evaluateExpression(".", clear = true)
        }

        binding.tvdoublezero.setOnClickListener {
            evaluateExpression("00", clear = true)
        }

        binding.tvequal.setOnClickListener {
            val text = binding.tvExpression.text.toString()
            val expression = ExpressionBuilder(text).build()
            val result = expression.evaluate()
            val longResult = result.toLong()
            if (result == longResult.toDouble()) {
                binding.tvResult.text = longResult.toString()
            } else {
                binding.tvResult.text = result.toString()
            }
        }

        binding.tvBack.setOnClickListener {
            val text = binding.tvExpression.text.toString()
            if(text.isNotEmpty()) {
                binding.tvExpression.text = text.dropLast(1)
            }else{
                binding.tvResult.text = ""

            }

        }
    }

    /*Function to calculate the expressions using expression builder library*/
    private fun evaluateExpression(string: String, clear: Boolean) = if(clear) {
         binding.tvResult .text =""
         binding.tvExpression.append(string)

    } else {
        binding.tvExpression.text
        binding.tvExpression.append(string)
        binding.tvResult.text =""
    }
}
