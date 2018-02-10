package com.example.zerothree.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class WisataDetail extends AppCompatActivity {

    ImageView Gambar;
    TextView Judul, Dekskripsi;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata_detail);

        Gambar = (ImageView)findViewById(R.id.imgWisata);
        Judul = (TextView)findViewById(R.id.txtWisata);
        Dekskripsi = (TextView)findViewById(R.id.txtDetailWisata);


        Judul.setText(getIntent().getStringExtra("Tempat"));
        Dekskripsi.setText(getIntent().getStringExtra("Detail"));
        Gambar.setImageResource(getIntent().getIntExtra("Foto", 1));



    }
}


//        txtWisata.setText(getIntent().getStringExtra("judul"));
//                imgWisata.setImageResource(getIntent().getIntExtra("icon", 1));