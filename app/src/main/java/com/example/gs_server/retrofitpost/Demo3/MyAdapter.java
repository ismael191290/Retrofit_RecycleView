package com.example.gs_server.retrofitpost.Demo3;

import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.gs_server.retrofitpost.R;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List<Heroes> mDataset;
    private LayoutInflater inflater;

    public MyAdapter(Context context, List<Heroes> myDataset) {
        inflater = LayoutInflater.from(context);
        this.mDataset = myDataset;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = inflater.inflate(R.layout.custom_row, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Heroes he = mDataset.get(position);
        holder.txtTitle.setText("" + he.getRealName());
        holder.txtBody.setText("" + he.getName());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle, txtBody;

        public ViewHolder(View v) {
            super(v);
            txtTitle = (TextView) itemView.findViewById(R.id.txt_titulo);
            txtBody = (TextView) itemView.findViewById(R.id.txt_body);
        }
    }

}
