package com.example.ivan_.consumirwebserviceconvolley;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Inicio extends AppCompatActivity implements View.OnClickListener {

    Button btnConsumirWS;
    EditText edtURLWS, edtRespuesta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Obtener componentes de la interfaz que se interactuara
        edtURLWS = (EditText) findViewById(R.id.edtURL);
        edtRespuesta = (EditText) findViewById(R.id.edtRespuesta);
        btnConsumirWS = (Button) findViewById(R.id.btnConsumir);

        btnConsumirWS.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url =edtURLWS.toString();

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        edtRespuesta.setText("Respuesta es: "+ response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                edtRespuesta.setText("No funciona el web service");
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}
