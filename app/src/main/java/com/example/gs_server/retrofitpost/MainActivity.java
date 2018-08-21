package com.example.gs_server.retrofitpost;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.gs_server.retrofitpost.Demo3.Api;
import com.example.gs_server.retrofitpost.Demo3.Heroes;
import com.example.gs_server.retrofitpost.Demo3.MyAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private RecyclerView list;
    private MyAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private List<Heroes> listBody;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // inicias la lista RecycleView
        list = findViewById(R.id.list_recycle);

        // se piden los persmisos necesarios (son pruebas)
        permiission();

        // haces la peticion a la URL que declares... con Retrofit
        RetrofiPeticionHeroes();
    }


    // metodo paara pedir los permisos necesarios
    public void permiission() {

        if (ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.ACCESS_COARSE_LOCATION) && ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.ACCESS_FINE_LOCATION) && ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE) && ActivityCompat.shouldShowRequestPermissionRationale(MainActivity.this,
                Manifest.permission.READ_EXTERNAL_STORAGE)) {

            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                            Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    0);


        } else {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                            Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.WRITE_EXTERNAL_STORAGE,
                            Manifest.permission.READ_EXTERNAL_STORAGE},
                    0);

        }
    }

    // metodo para la peticion por medio de retrofit.
    public void RetrofiPeticionHeroes() {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Api.url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Api api = retrofit.create(Api.class);
        final Call<List<Heroes>> lis = api.getHeroes();
        lis.enqueue(new Callback<List<Heroes>>() {
            @Override
            public void onResponse(Call<List<Heroes>> call, Response<List<Heroes>> response) {
                // recuperas los valores de la peticion y los asignas a tu clase o Bean
                listBody = response.body();
                list.setHasFixedSize(true);
                // estilo de la lista (RecycleView)
                mLayoutManager = new LinearLayoutManager(getApplicationContext());
                list.setLayoutManager(mLayoutManager);
                // asignamos el adapter creado. de la clase MyAdapter y pasamos la lista que mostrara
                mAdapter = new MyAdapter(getApplicationContext(), listBody);
                // pasamos el adapter a la lista..
                list.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<List<Heroes>> call, Throwable t) {
                Log.e("Error Fauilure ", "-----------------------------" + t.getMessage());
            }
        });
    }

    @SuppressLint("LongLogTag")
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        // validacion de que si no acepta los valores
        if (requestCode == 0) {

            if (verifyPermissions(grantResults)) {
                permiission();
            } else {

                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Permisos Denegados !!");
                dialog.setMessage("Esta Aplicacion necesita la autorizacion de los Permisos");

                dialog.setPositiveButton("ACEPTAR", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                        permiission();
                    }
                });
                dialog.setCancelable(false);
                dialog.show();

            }
        }
    }

    public static boolean verifyPermissions(int[] grantResults) {
        // At least one result must be checked.
        if (grantResults.length < 1) {
            return false;
        }

        // Verify that each required permission has been granted, otherwise return false.
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }

}
