package com.example.wmtapp

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.camera.core.CameraSelector
import androidx.camera.core.ImageCapture
import androidx.camera.core.Preview
import androidx.camera.lifecycle.ProcessCameraProvider
import androidx.camera.view.PreviewView
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class CameraActivity : AppCompatActivity() {
    private lateinit var cameraPreview: PreviewView
    private lateinit var takePhotoBtn: FloatingActionButton
    private lateinit var imageCaptured: ImageCapture

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_camera)

        cameraPreview = findViewById(R.id.cameraPreview)
        takePhotoBtn = findViewById(R.id.takePhotoBtn)

        if(allPermissionGranted()){
            // start camera
            startCamera()

            // set listener to takePhotoBtn
            takePhotoBtn.setOnClickListener{
                Toast.makeText(this, "Image Captured...", Toast.LENGTH_LONG).show()
            }
        } else {
            // request permission
            ActivityCompat.requestPermissions(
                this, arrayOf(Manifest.permission.CAMERA), 111
            )
        }
    }

    override fun onBackPressed() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == 111 && allPermissionGranted()){
            startCamera()
        } else{
            finish()
        }
    }

    private fun startCamera() {
        val cameraProviderFuture = ProcessCameraProvider.getInstance(this)

        cameraProviderFuture.addListener({
            // bind to lifecycle
            val cameraProvider = cameraProviderFuture.get()
            val preview = Preview.Builder().build()
            preview.setSurfaceProvider(cameraPreview.surfaceProvider)
            imageCaptured = ImageCapture.Builder().build()

            // select the camera to use
            val cameraSelected = CameraSelector.DEFAULT_BACK_CAMERA

            try {
                cameraProvider.unbindAll()

                cameraProvider.bindToLifecycle(
                    this, cameraSelected, preview, imageCaptured
                )
            } catch (e: Exception) {
                Log.e("WMT Chat", "Camera Binding Failed $e")
                Toast.makeText(
                    this,
                    "Camera Binding Unsuccessful",
                    Toast.LENGTH_LONG
                ).show()
            }
        }, ContextCompat.getMainExecutor(this)

        )
    }

    private fun allPermissionGranted(): Boolean{
        return ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED
    }

}