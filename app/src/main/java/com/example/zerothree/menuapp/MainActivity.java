package com.example.zerothree.menuapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    GridView GridMenu;

    String [] Menu = {
            "Wisata", "Kuliner", "Hotel"
    };
    int [] gambar = {
            R.drawable.around,
            R.drawable.food,
            R.drawable.resort
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GridMenu = (GridView)findViewById(R.id.gridMenu);


        GridAdapter gridAdapter = new GridAdapter();
        GridMenu.setAdapter(gridAdapter);

        GridMenu.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int Menuu, long id) {
                if (Menuu == 0) {
                    Intent a1 = new Intent(getApplicationContext(), Wisata.class);
                    startActivity(a1);
                }else if (Menuu == 1) {
                    Intent a2 = new Intent(getApplicationContext(), Kuliner.class);
                    startActivity(a2);
                }else if (Menuu == 2) {
                    Intent a3 = new Intent(getApplicationContext(), Hotel.class);
                    startActivity(a3);
                }
            }
        });
    }

    class GridAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return gambar.length;
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int Position, View convertView, ViewGroup viewGroup) {
            View view = getLayoutInflater().inflate(R.layout.listgrid, null);
            ImageView mImageView = (ImageView) view.findViewById(R.id.imageview);
            TextView mTextView = (TextView) view.findViewById(R.id.textview);

            mImageView.setImageResource(gambar[Position]);
            mTextView.setText(Menu[Position]);

            return view;
        }
    }
}
