package edu.tectii.eva2_5_leer_int_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class Principal extends AppCompatActivity {
    EditText edtarchivo;
    final String ARCHIVO = "miarchivo.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        edtarchivo = (EditText)findViewById(R.id.edtarchivo);
    }
    //Device file explorer
    //leer_escribir_esp_int
    @Override
    protected void onStart() {
        super.onStart();
        String sCade;
        try{
            InputStream isAbrir = openFileInput(ARCHIVO);
            InputStreamReader isLeer = new InputStreamReader(isAbrir);
            BufferedReader brLeerTexto = new BufferedReader(isLeer);
            while ((sCade = brLeerTexto.readLine()) != null){
                edtarchivo.append(sCade);
                edtarchivo.append("\n");
            }

            brLeerTexto.close();
        }catch (IOException e){
            e.printStackTrace();

        }

    }

    public void onClick(View v){
        String[] asCade = edtarchivo.getText().toString().split("\n");
        try {
            OutputStream osAbrir = openFileOutput(ARCHIVO,0);
            OutputStreamWriter oswEscribir = new OutputStreamWriter(osAbrir);
            BufferedWriter bwEscribir = new BufferedWriter(oswEscribir);
            for (int i = 0; i< asCade.length; i++) {
                bwEscribir.append(asCade[i]);
                bwEscribir.append("\n");
            }
            bwEscribir.close();

        }catch (IOException e){
            e.printStackTrace();

        }
    }
}
