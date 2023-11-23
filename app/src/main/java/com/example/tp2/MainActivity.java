package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView ACV;
    MultiAutoCompleteTextView MACV;
    String[] ville = {"Errachidia", "Casablanca", "Rabat", "Tanger",
            "Salé", "Safi", "Marrakech", "Eljadida", "Fes", "Meknes", "Tetouan",
            "Oujda", "Essaouira" };
    private EditText nom, prenom, email;
    private Spinner jour, mois, anne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Date de Naissance

        jour = (Spinner) findViewById(R.id.jours);
        mois = (Spinner) findViewById(R.id.mois);
        anne = (Spinner) findViewById(R.id.anne);

        jour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View
                    view, int position, long l) {
                String j = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Jour sélectionné est " + j, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        mois.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View
                    view, int position, long l) {
                String m = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Mois sélectionné est " + m, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        anne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View
                    view, int position, long l) {
                String a = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Année sélectionné est " + a, Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Création de l'instance de ArrayAdapter contenant la liste des ville
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.select_dialog_item, ville);
        MACV.setThreshold(2);
        MACV.setAdapter(adapter);
        MACV.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

    }


    public void afficher(View view) {
        String j = jour.getSelectedItem().toString();
        String m = mois.getSelectedItem().toString();
        Toast.makeText(getApplicationContext(), "Jour sélectionné est " + j + " et mois sélectionné est " + m, Toast.LENGTH_LONG).show();
    }


}