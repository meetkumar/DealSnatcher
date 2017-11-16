package com.example.meetkumarpatel.helix;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Collections;
import java.util.List;

/**
 * Created by meetkumarpatel on 11/15/17.
 */

public class DataBinder extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<DataStructure> data= Collections.emptyList();
    DataStructure current;
    int currentPos=0;

    // create constructor to innitilize context and data sent from MainActivity
    public DataBinder(Context context, List<DataStructure> data){
        this.context=context;
        inflater= LayoutInflater.from(context);
        this.data=data;
    }

    // Inflate the layout when viewholder created
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.results, parent,false);
        MyHolder holder=new MyHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyHolder myHolder = (MyHolder) holder;
        DataStructure current = data.get(position);
        myHolder.textName.setText(current.name);
        myHolder.textItemId.setText("Id : "+current.itemId);
        myHolder.textMsrp.setText("MSRP : "+current.msrp);
        myHolder.textSales.setText("Sales Price : "+current.sales_price);

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    class MyHolder extends RecyclerView.ViewHolder{

        TextView textName;
        TextView textItemId;
        TextView textMsrp;
        TextView textSales;

        // create constructor to get widget reference
        public MyHolder(View itemView) {
            super(itemView);
            textName= (TextView) itemView.findViewById(R.id.tv_display_name);
            textItemId= (TextView) itemView.findViewById(R.id.tv_display_itemId);
            textMsrp = (TextView) itemView.findViewById(R.id.tv_display_msrp);
            textSales = (TextView) itemView.findViewById(R.id.tv_sales);

        }

    }
}
