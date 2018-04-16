package com.example.hppc.saidrycleanersandlaundary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class CardNGrid extends AppCompatActivity {
    GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_ngrid);

       GridView gridView = (GridView) findViewById(R.id.gridview);
        gridView.setAdapter(new ImageAapter(this));
        ;
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String position = null;
                Toast.makeText(CardNGrid.this,""+i,Toast.LENGTH_SHORT).show();

                switch (+i){
                    case 0:
                        Intent i1 = new Intent(CardNGrid.this,Give_cloth.class);
                        startActivity(i1);
                        break;
                    case 1:
                        Intent i2 = new Intent(CardNGrid.this,Take_clothes.class);
                        startActivity(i2);

                    case 2:
                        Intent i3 = new Intent(CardNGrid.this,Rates.class);
                        startActivity(i3);
                    case 3:
                        Intent i4 = new Intent(CardNGrid.this,Summary.class);
                        startActivity(i4);
                }
            }
        });

        }



    }




