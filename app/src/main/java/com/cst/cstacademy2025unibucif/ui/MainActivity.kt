package com.cst.cstacademy2025unibucif.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.cst.cstacademy2025unibucif.R
import com.cst.cstacademy2025unibucif.models.direction.DirectionType

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

        findViewById<Button>(R.id.btn_click_me).setOnClickListener {
            goToSecondActivity()
//            changeDirection()
        }

        Log.e("TAG", "onCreate")
    }

    fun changeDirection() {
        val directionTypeId = (0..3).random()
        val direction = when(directionTypeId) {
            DirectionType.NORTH.id -> DirectionType.NORTH
            DirectionType.SOUTH.id -> DirectionType.SOUTH
            DirectionType.EAST.id -> DirectionType.EAST
            DirectionType.WEST.id -> DirectionType.WEST
            else -> DirectionType.NORTH
        }

        findViewById<TextView>(R.id.tv_direction).text = getString(direction.directionNameResId)
    }

    private fun goToSecondActivity() {
        val intent = Intent(this, ControllerActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onStart() {
        super.onStart()

        Log.e("TAG", "onStart")
    }

    override fun onResume() {
        super.onResume()

        Log.e("TAG", "onResume")
    }

    override fun onPause() {
        super.onPause()

        Log.e("TAG", "onPause")
    }

    override fun onStop() {
        super.onStop()

        Log.e("TAG", "onStop")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.e("TAG", "onDestroy")
    }
}