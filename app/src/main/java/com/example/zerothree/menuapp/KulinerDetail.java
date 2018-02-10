package com.example.zerothree.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class KulinerDetail extends AppCompatActivity {

    ImageView GambarKuliner;
    TextView JudulKuliner, DekskripsiKuliner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner_detail);

        GambarKuliner = (ImageView)findViewById(R.id.imgKuliner);
        JudulKuliner = (TextView)findViewById(R.id.txtKuliner);
        DekskripsiKuliner = (TextView)findViewById(R.id.txtDetailKuliner);

        JudulKuliner.setText(getIntent(). getStringExtra("Makanan"));
        DekskripsiKuliner.setText(getIntent(). getStringExtra("DetailMakanan"));
      GambarKuliner.setImageResource(getIntent().getIntExtra("Gambar", 1));

    }
}


