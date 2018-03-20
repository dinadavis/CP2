package com.example.lenovo.cameracentralpixel;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
int pixel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Find the button that will take the photo
        Button btnCamera = (Button) findViewById(R.id.capture);

        // Find the view that will show the preview
        ImageView imageView = (ImageView) findViewById(R.id.image);

        // Find the button that will transfer the pixel info to the next activity
        Button btnPixel = (Button) findViewById(R.id.pixel);
        // Set a click listener on that View
        btnPixel.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent pixelIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(pixelIntent);
            }
        });

        // Set a click listener on the button
        btnCamera.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the button is clicked on.
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, 0);
            }
        });
    }

    //to get data on Activity Result

    protected int onActivityResult(Surface source, int requestCode, int resultCode, Intent data) {
        ImageView imageView = (ImageView) findViewById(R.id.image);
        Button btnCamera = (Button) findViewById(R.id.capture);
        Button btnPixel = (Button)findViewById(R.id.pixel);
        View v = this.getCurrentFocus();
        if (v != null) {
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            int width = bitmap.getWidth();
            int height = bitmap.getHeight();
            int pixel = bitmap.getPixel(width / 2, height / 2);
            int redValue = Color.red(pixel);
            int blueValue = Color.blue(pixel);
            int greenValue = Color.green(pixel);
            switchButtons();
        }
        btnPixel.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers View is clicked on.
            @Override
            public void onClick(View view) {
                Intent pixelIntent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(pixelIntent);
            }
        });
        return (pixel);

    }

    /**
     * Called when the cookie should be eaten.
     */
    private void switchButtons() {
        final Button cameraButton = (Button) findViewById(R.id.capture);

        cameraButton.setVisibility(View.INVISIBLE);
        final Button pixelButton = (Button) findViewById(R.id.pixel);
        pixelButton.setVisibility(View.VISIBLE);

    }
}
