package com.deshmukh.recyclerviewexample;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    Button add;
    RecyclerView recyclerView;
    public static RcViewAdapter rcViewAdapter;
    public static List<DataModel> data = new ArrayList<DataModel>();
    final Context context = this;
    public static  AlertDialog.Builder builder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        add = findViewById(R.id.add);
        builder = new AlertDialog.Builder(this);

        recyclerView = (RecyclerView)findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        rcViewAdapter = new RcViewAdapter(data,context);
        recyclerView.setAdapter(rcViewAdapter);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final View alertBox = LayoutInflater.from(getApplicationContext()).inflate(R.layout.alert_box,null);
                builder.setView(alertBox);
                final AlertDialog alert = builder.create();
                final EditText name = (EditText) alertBox.findViewById(R.id.name);
                final EditText age = (EditText) alertBox.findViewById(R.id.age);
                final EditText roll_no = (EditText) alertBox.findViewById(R.id.roll_no);
                final Button okay = (Button) alertBox.findViewById(R.id.ok);
                final Button cancel = (Button) alertBox.findViewById(R.id.cancel);

                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(name.getText().toString().equals("") || age.getText().toString().equals("") || roll_no.getText().toString().equals("")){
                                Toast.makeText(getApplicationContext(),"Enter Correct Details",Toast.LENGTH_LONG).show();
                        }else {
                            data.add(new DataModel( name.getText().toString(),age.getText().toString(), roll_no.getText().toString()));
                            name.setText("");
                            age.setText("");
                            roll_no.setText("");
                            rcViewAdapter.notifyDataSetChanged();
                        }

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert.dismiss();

                    }
                });


                alert.show();


            }
        });



    }


}