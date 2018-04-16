package com.example.hppc.saidrycleanersandlaundary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Give_cloth extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_give_cloth);
    }
    public void OnmbtnClick(View vm){

        if (vm.getId()==R.id.mbtn)
        {
            Intent intent = new Intent(this,Men.class);
            startActivity(intent);

        }
    }

    public void OnwbtnClick(View view){

        if (view.getId()==R.id.wbtn)
        {
            Intent intent = new Intent(this,Women.class);
            startActivity(intent);

        }
    }
    public void OnotnClick(View view){

        if (view.getId()==R.id.obtn)
        {
            Intent intent = new Intent(this,Other.class);
            startActivity(intent);

        }
    }


}
