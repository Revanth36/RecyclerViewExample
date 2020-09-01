package com.deshmukh.recyclerviewexample;

import android.app.AlertDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collection;
import java.util.List;

import static com.deshmukh.recyclerviewexample.MainActivity.builder;
import static com.deshmukh.recyclerviewexample.MainActivity.rcViewAdapter;

public class RcViewAdapter extends RecyclerView.Adapter<RcViewHolder> {
    List<DataModel> data ;
    Context context;
    public RcViewAdapter(List<DataModel> data,Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public RcViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View cardView = inflater.inflate(R.layout.card_view, parent, false);
        RcViewHolder viewHolder = new RcViewHolder(cardView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final  RcViewHolder viewHolder, final int position) {
        viewHolder.name.setText(String.format("Name:%s", data.get(position).name));
        viewHolder.age.setText(String.format("Age:%s", data.get(position).age));
        viewHolder.roll_no.setText(String.format("Roll No:%s", data.get(position).roll_no));
        viewHolder.edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final View alertBox = LayoutInflater.from(context).inflate(R.layout.alert_box,null);
                builder.setView(alertBox);
                final AlertDialog alert = builder.create();
                final EditText name = (EditText) alertBox.findViewById(R.id.name);
                final EditText age = (EditText) alertBox.findViewById(R.id.age);
                final EditText roll_no = (EditText) alertBox.findViewById(R.id.roll_no);
                final Button okay = (Button) alertBox.findViewById(R.id.ok);
                final Button cancel = (Button) alertBox.findViewById(R.id.cancel);

                name.setText(data.get(position).name);
                age.setText(data.get(position).age);
                roll_no.setText(data.get(position).roll_no);


                okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(name.getText().toString().equals("") || age.getText().toString().equals("") || roll_no.getText().toString().equals("")){
                            Toast.makeText(context,"Enter Correct Details",Toast.LENGTH_LONG).show();
                        }else {
                            data.set(position,new DataModel(name.getText().toString(), age.getText().toString(), roll_no.getText().toString()));
                            name.setText("");
                            age.setText("");
                            roll_no.setText("");
                            rcViewAdapter.notifyDataSetChanged();
                            alert.dismiss();;
                        }

                    }
                });

                cancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        alert.dismiss();

                    }

                });


                //Creating dialog box
                alert.show();


            }
        });

        viewHolder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.remove(position);
                rcViewAdapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    public int getItemCount() {
        return data.size();
    }


}
