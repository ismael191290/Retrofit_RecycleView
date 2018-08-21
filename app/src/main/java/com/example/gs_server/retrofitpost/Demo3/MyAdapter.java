package com.example.gs_server.retrofitpost.Demo3;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gs_server.retrofitpost.R;
import com.squareup.picasso.Picasso;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Heroes> mDataset;
    private LayoutInflater inflater;
    private Context context;


    public MyAdapter(Context context, List<Heroes> myDataset) {
        // asignarle la actividad donde se mostrara y la lista de valores a mostrar
        this.context = context;
        inflater = LayoutInflater.from(this.context);
        this.mDataset = myDataset;
    }


    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        // se crea (infla)la vista que se mostrara
        View v = inflater.inflate(R.layout.custom_row, parent, false);

        // se instancea para pasarle el a los valores de la vista los valores
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {

// obtienes los valores del arreglo para recorrerlos con position y pasas los valores a los componentes de la vista
        Heroes he = mDataset.get(position);
        Picasso.with(context).load(he.getImageUrl()).resize(900, 300).into(((ViewHolder)holder).imgCar);
        //((ViewHolder)holder) .txtBody.setText("");
        ((ViewHolder)holder).txtTitle.setText(he.getRealName());
        ((ViewHolder)holder).btnPrueba.setText(he.getName());
        ((ViewHolder)holder).btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // cada item o categoria tiene su propio evento
                Toast.makeText(context, "index " + position, Toast.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        // se crea la clase de la vista que vamos a inflar o crear instancenado los valores.
        private TextView txtTitle, txtBody;
        private Button btnPrueba;
        private ImageView imgCar;

        public ViewHolder(View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txt_titulo);
         //   txtBody = itemView.findViewById(R.id.txt_body);
            btnPrueba = itemView.findViewById(R.id.btn_prueba);
            imgCar = itemView.findViewById(R.id.img_card);
        }
    }
}
