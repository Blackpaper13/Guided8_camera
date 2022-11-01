package com.example.gd8_camera_kelas_5digitnpm

import androidx.appcompat.app.AppCompatActivity
import com.example.gd8_camera_kelas_5digitnpm.CameraView
import android.os.Bundle
import com.example.gd8_camera_kelas_5digitnpm.R
import android.widget.FrameLayout
import android.annotation.SuppressLint
import android.hardware.Camera
import android.util.Log
import android.view.View
import android.widget.ImageButton
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    private var mCamera: Camera? = null
    private var mCameraView: CameraView? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        try {
            mCamera = Camera.open()
        } catch (e: Exception) {
            Log.d("Error", "Failed to get Camera" + e.message)
        }
        if (mCamera != null) {
            mCameraView = CameraView(this, mCamera!!)
            val camera_view = findViewById<View>(R.id.FLCamera) as FrameLayout
            camera_view.addView(mCameraView)
        }
        @SuppressLint("MissingInflatedId", "LocalSuppress") val imageClose =
            findViewById<View>(R.id.imgClose) as ImageButton
        imageClose.setOnClickListener { view: View? -> System.exit(0) }
    }
}