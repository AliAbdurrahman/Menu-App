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

public class Wisata extends AppCompatActivity {

    RecyclerView MenuWisata;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);

        MenuWisata = (RecyclerView)findViewById(R.id.menuWisata);
        MenuWisata.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        MenuWisata.setAdapter(adapter);
    }

    String [] tempat = {
            "Jembatan Barelang", "Mega Wisata Ocarina", "Alun - Alun Engku Putri", "Masjid Agung Batam", "Bukit Senyum"
    };
    int [] foto = {
            R.drawable.jb,
            R.drawable.ocarina,
            R.drawable.alun,
            R.drawable.masjid,
            R.drawable.bukit
    };
    String [] detailMenu = {
            "Jembatan Barelang adalah nama jembatan yang menghubungkan pulau-pulau yaitu Pulau Batam, Pulau Tonton, Pulau Nipah, Pulau Rempang, Pulau Galang dan Pulau Galang Baru.", "Lokasi: Sadai, Bengkong, Kota Batam, Kepulauan Riau.", "Lokasi: Jl. Engku Putri, Teluk Tering, Batam Kota, Tlk. Tering, Batam Kota, Kota Batam, Kepulauan Riau.", "Lokasi: Jl. Engku Putri, Tlk. Tering, Batam Kota, Kota Batam, Kepulauan Riau.", "Lokasi: Tanjung Uncang, Batu Aji, Kota Batam, Kepulauan Riau"
    };


    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Tempat> {
        @Override
        public Tempat onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null);
            return new Tempat(v);
        }

        @Override
        public void onBindViewHolder(Tempat holder, final int position) {
            holder.judul.setText(tempat[position]);
            holder.img.setImageResource(foto[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a1 = new Intent(getApplicationContext(), WisataDetail.class);
                    a1.putExtra("Tempat", tempat[position]);
                    a1.putExtra("Foto", foto[position]);
                    a1.putExtra("Detail", detailMenu[position]);
                    startActivity(a1);
                }
            });

        }

        @Override
        public int getItemCount() {
            return tempat.length;
        }

        public class Tempat extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public Tempat(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);

            }
        }
    }
}

//    Intent a1 = new Intent(TourismActivity.this, TourismDetail.class);
//                    a1.putExtra("judul", namaWisata[position]);
//                            a1.putExtra("icon", gambarWisata[position]);
//                            startActivity(a1);