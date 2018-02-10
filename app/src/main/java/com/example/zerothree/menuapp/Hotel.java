package com.example.zerothree.menuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class Hotel extends AppCompatActivity {

    RecyclerView MenuHotel;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel);

        MenuHotel = (RecyclerView)findViewById(R.id.menuHotel);
        MenuHotel.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        MenuHotel.setAdapter(adapter);
    }

    String [] hotel = {
            "Hotel Sky-inn", "Wisma Hotel", "Hotel 01", "Hotel Harris", "Hotel Pacific"
    };
    int [] gambar2 = {
            R.drawable.skyhotel,
            R.drawable.pihhotel,
            R.drawable.hotelkosong,
            R.drawable.harishotel,
            R.drawable.pacifichotel
    };

    String [] detailHotel = {
            "Ruko Limanda Blok D No. 1-3, Jalan Let. Jend Suprapto, Batu Aji, Buliang, Batu Aji, Kota Batam, Kepulauan Riau 29424", "Batam Center, Jalan Engku Putri, Teluk Tering, Batam Kota, Tlk. Tering, Batam Kota, Kota Batam, Kepulauan Riau", "Tlk. Tering, Batam Kota, Kota Batam, Kepulauan Riau", "Jl. Engku Putri, Batam Center - Batam 29461 I Phone: +62 778 749 8888 - Fax. +62 778 749 9999", " Jln. Duyung sei. Jodoh, Kepulauan Riau, Sungai Jodoh, Batu Ampar, Kota Batam, Riau 29432"

    };


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {
        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null);
            return new MyViewHolder(v);
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, final int position) {
            holder.judul.setText(hotel[position]);
            holder.img.setImageResource(gambar2[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a3 = new Intent(getApplicationContext(), HotelDetail.class);
                    a3.putExtra("Hotel", hotel[position]);
                    a3.putExtra("Gambar2", gambar2[position]);
                    a3.putExtra("DetailHotel", detailHotel[position]);
                    startActivity(a3);
                }
            });

        }

        @Override
        public int getItemCount() {
            return hotel.length;
        }

        public class MyViewHolder extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public MyViewHolder(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);

            }
        }
    }
}
