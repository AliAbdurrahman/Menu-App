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

public class Kuliner extends AppCompatActivity {

    RecyclerView MenuKuliner;
    CustomAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kuliner);

        MenuKuliner = (RecyclerView)findViewById(R.id.menuKuliner);
        MenuKuliner.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CustomAdapter();
        MenuKuliner.setAdapter(adapter);
    }

    String [] makanan = {
            "Gong - Gong", "Luti Gendang", "Mi Lendir", "Mi Sagu", "Mi Tarempa"
    };
    int [] gambarMakanan = {
            R.drawable.gong,
            R.drawable.luti,
            R.drawable.milendir,
            R.drawable.misagu,
            R.drawable.mitarempa
    };
    String [] detailMakanan = {
            "Gong-gong adalah sejenis siput laut yang diolah dengan cara direbus atau ditumis dengan bumbu-bumbu khusus.", "Luti Gendang adalah kue yang menyerupai kroket. Hanya saja, jika kroket memiliki isi ragout, Luti Gendang ini diisi dengan ikan yang dimasak dengan bumbu-bumbu tertentu.", "Mi Lendir disajikan bersama udang, ayam, tauge, cabe, dan bawang goreng.", "Jika biasanya sagu digunakan untuk membuat kue, kali ini sagu digunakan sebagai bahan utama untuk membuat mi.", "Jenis mie yang dipakai untuk memasak Mie Tarempa ini adalah mie gepeng alias mie dengan bentuk yang agak lebar Kemudian mie tersebut dimasak dengan bahan dan rempah yang hampir sama seperti membuat mie goreng biasa"
    };

    private class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.Makanan>{
        @Override
        public Makanan onCreateViewHolder(ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, null);
            return new Makanan(v);
        }

        @Override
        public void onBindViewHolder(Makanan holder, final int position) {
            holder.judul.setText(makanan[position]);
            holder.img.setImageResource(gambarMakanan[position]);
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent a2 = new Intent(getApplicationContext(), KulinerDetail.class);
                    a2.putExtra("Makanan", makanan[position]);
                    a2.putExtra("Gambar", gambarMakanan[position]);
                    a2.putExtra("DetailMakanan", detailMakanan[position]);
                    startActivity(a2);
                }
            });
        }


        @Override
        public int getItemCount() {
            return makanan.length;
        }

        public class Makanan extends RecyclerView.ViewHolder {
            TextView judul;
            ImageView img;
            public Makanan(View itemView) {
                super(itemView);

                judul = itemView.findViewById(R.id.judul);
                img = itemView.findViewById(R.id.img);

            }
        }
    }
}
