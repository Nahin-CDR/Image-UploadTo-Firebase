package com.nahin.imageupload;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private static final int PIC_IMAGE_REQUEST=1;

    ImageView openGallery,uploadImage;
    private Uri mImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        getSupportActionBar().hide();

        openGallery = (ImageView)findViewById( R.id.openImageID );
        uploadImage = (ImageView)findViewById( R.id.UploadImageID );

        chooseImage();






    }

    private void chooseImage() {

        openGallery.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(  );
                intent.setType( "Image/*" );
                intent.setAction( Intent.ACTION_GET_CONTENT );
                startActivityForResult( intent,PIC_IMAGE_REQUEST );

            }
        } );

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult( requestCode, resultCode, data );

        if (requestCode==PIC_IMAGE_REQUEST && resultCode==RESULT_OK &&
                data !=null && data.getData()!=null) {
            mImageUri = data.getData();


        }
    }
}
