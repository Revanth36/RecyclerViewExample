package com.deshmukh.recyclerviewexample;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class RcViewHolder extends RecyclerView.ViewHolder {
    TextView name,age,roll_no;
    ImageButton edit,delete;
    public RcViewHolder(View itemView) {
        super(itemView);
        name = (TextView)itemView.findViewById(R.id.name);
        age = (TextView)itemView.findViewById(R.id.age);
        roll_no = (TextView)itemView.findViewById(R.id.roll_no);
        edit = (ImageButton)itemView.findViewById(R.id.edit);
        delete = (ImageButton)itemView.findViewById(R.id.delete);
    }
}
