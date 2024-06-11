package com.example.rajkot_travel_app

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var currentImage = 0
    var places = arrayOf("Jagat Mandir(Temple)", "khambhalida caves", "Ranjit Vilas Palace", "Ishwariya Park", "Padyuman Park (Zoo)")

    @SuppressLint("DiscouragedApi")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val next = findViewById<ImageButton>(R.id.btnNext)
        val previous = findViewById<ImageButton>(R.id.btnPrev)
        val placeName = findViewById<TextView>(R.id.tVName)

        next.setOnClickListener {
            var idCurrentImageString = "pic$currentImage" // For current image
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            var currentImageView = findViewById<ImageView>(idCurrentImageInt)
            currentImageView.alpha = 0f


            currentImage = (currentImage + 1) % 5
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            var imageViewToShow = findViewById<ImageView>(idImageToShowInt)
            imageViewToShow.alpha = 1f

            placeName.text = places[currentImage]

        }

        previous.setOnClickListener {
            var idCurrentImageString = "pic$currentImage" // For current image
            var idCurrentImageInt = this.resources.getIdentifier(idCurrentImageString, "id", packageName)
            var currentImageView = findViewById<ImageView>(idCurrentImageInt)
            currentImageView.alpha = 0f

            currentImage = if (currentImage == 0) 4 else currentImage - 1
            var idImageToShowString = "pic$currentImage"
            var idImageToShowInt = this.resources.getIdentifier(idImageToShowString, "id", packageName)
            var imageViewToShow = findViewById<ImageView>(idImageToShowInt)
            imageViewToShow.alpha = 1f

            placeName.text = places[currentImage]
        }
    }
}
