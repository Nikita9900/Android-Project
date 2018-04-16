package com.example.hppc.saidrycleanersandlaundary;

import android.app.ActionBar;
import android.app.AlertDialog;
import android.database.Cursor;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.Toast;


public class Men extends AppCompatActivity implements View.OnClickListener {
    DatabaseHelperMen myDb;
    EditText editShirt,editJeans,editJacket,editTextId;
    Button btnAddData;
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;
    private int contentView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_men);
        myDb = new DatabaseHelperMen(this);

        editShirt = (EditText) findViewById(R.id.editText_shirt);
        editJeans = (EditText) findViewById(R.id.editText_jeans);
        editJacket = (EditText) findViewById(R.id.editText_jacket);
        btnAddData = (Button) findViewById(R.id.button_add);
        btnviewAll = (Button) findViewById(R.id.button_viewAll);
        btnviewUpdate = (Button) findViewById(R.id.button_update);
        btnDelete = (Button) findViewById(R.id.button_delete);
        editTextId = (EditText) findViewById(R.id.editText_id);

        AddData();
        viewAll();
        UpdateData();
        DeleteData();


    }
    public void DeleteData() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb.deleteData(editTextId.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Men.this,"Data Deleted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Men.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateData() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb.updateData(editTextId.getText().toString(),
                                editShirt.getText().toString(),
                                editJeans.getText().toString(),editJacket.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Men.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Men.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public  void AddData() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDb.insertData(editShirt.getText().toString(),
                                editJeans.getText().toString(),
                                editJacket.getText().toString() );
                        if(isInserted == true)
                            Toast.makeText(Men.this,"Data Inserted",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Men.this,"Data not Inserted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void viewAll() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                           // buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Shirt :"+ res.getString(1)+"\n");
                            buffer.append("Jeans :"+ res.getString(2)+"\n");
                            buffer.append("Jacket :"+ res.getString(3)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
       // getMenuInflater().inflate(R.menu,Menu.menu);


        return true;
    }

  /*  @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
     /*   if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    public void setContentView(int contentView) {
        this.contentView = contentView;
    }


    @Override
    public void onClick(View view) {

    }
}
