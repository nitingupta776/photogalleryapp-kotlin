package com.example.comp8031_assignment1_kotlin

import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GestureDetectorCompat

class MainActivity : AppCompatActivity(), GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener{

    private val images = arrayOf(R.drawable.beach, R.drawable.flower, R.drawable.mountain, R.drawable.bridge)
    var img: ImageView? = null
    private var currentImage = 0
    var btnPrevious: Button? = null
    var btnNext:Button? = null

    private lateinit var mDetector: GestureDetectorCompat

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Instantiate the gesture detector with the
        // application context and an implementation of
        // GestureDetector.OnGestureListener
        mDetector = GestureDetectorCompat(this, this)
        // Set the gesture detector as the double tap
        // listener.
        mDetector.setOnDoubleTapListener(this)

        setCurrentImage()

        //Next Button Handler
        btnNext = findViewById<View>(R.id.btnNext) as Button
        btnNext!!.setOnClickListener { scrollImageToLeft() }

        //Previous Button Handler
        btnPrevious = findViewById<View>(R.id.btnPrevious) as Button
        btnPrevious!!.setOnClickListener { scrollImageToRight() }
    }

    private fun setCurrentImage() {
        img = findViewById<View>(R.id.imageView) as ImageView
        img!!.setImageResource(images[currentImage])
    }

    private fun scrollImageToRight() {
        if (currentImage > 0) {
            currentImage--
        }
        setCurrentImage()
    }

    private fun scrollImageToLeft() {
        if (currentImage < images.size - 1) {
            currentImage++
        }
        setCurrentImage()
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        return if (mDetector.onTouchEvent(event)) {
            true
        } else {
            super.onTouchEvent(event)
        }
    }

    override fun onDown(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

    override fun onShowPress(e: MotionEvent?) {
        TODO("Not yet implemented")
    }

    override fun onSingleTapUp(e: MotionEvent?): Boolean {
        return true
    }

    override fun onScroll(e1: MotionEvent?, e2: MotionEvent?, distanceX: Float, distanceY: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun onLongPress(e: MotionEvent?) {

    }

    override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
        TODO("Not yet implemented")
    }

    override fun onSingleTapConfirmed(e: MotionEvent?): Boolean {
        scrollImageToLeft();
        return true
    }

    override fun onDoubleTap(e: MotionEvent?): Boolean {
        scrollImageToRight();
        return true
    }

    override fun onDoubleTapEvent(e: MotionEvent?): Boolean {
        TODO("Not yet implemented")
    }

}