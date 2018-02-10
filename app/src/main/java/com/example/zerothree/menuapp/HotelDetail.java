package com.example.zerothree.menuapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class HotelDetail extends AppCompatActivity {

    ImageView GambarHotel;
    TextView NamaHotel, DetailHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail);

        GambarHotel = (ImageView)findViewById(R.id.imgHotel);
        NamaHotel = (TextView)findViewById(R.id.txtHotel);
        DetailHotel = (TextView)findViewById(R.id.txtDetailHotel);

        GambarHotel.setImageResource(getIntent().getIntExtra("Gambar2", 1));
        NamaHotel.setText(getIntent().getStringExtra("Hotel"));
        DetailHotel.setText(getIntent().getStringExtra("DetailHotel"));

    }
}
