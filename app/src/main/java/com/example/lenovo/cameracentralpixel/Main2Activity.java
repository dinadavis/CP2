package com.example.lenovo.cameracentralpixel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


        /**
         * This method displays the given data on the screen.
         */
    public void displayPixel(Intent data) {
        ImageView cPixel = (ImageView) findViewById(R.id.center_pixel_results);
        Bitmap bitmap = (Bitmap) data.getExtras().get("data");
        cPixel.setImageBitmap(bitmap);
    }
}
