package com.example.hppc.saidrycleanersandlaundary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Summary extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);
    }
    public void onSumClick(View vi)
    {
        if (vi.getId()==R.id.sbtn)
        {
            Intent intent = new Intent(this,FullSum.class);
            startActivity(intent);

        }

    }
}
