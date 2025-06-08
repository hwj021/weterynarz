package com.example.weterynarz;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private SeekBar seekBar;
    private TextView wiekZmiana;
    private Button b1;
    private TextView wartosci;
    private TextView dane;
    private String gatunek;
    private int wiek;
    private TextView cel;
    private TextView editTextTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        spinner = findViewById(R.id.spinner);
        seekBar = findViewById(R.id.seekBar);
        wiekZmiana = findViewById(R.id.wiekZmiana);
        b1 = findViewById(R.id.button);
        wartosci = findViewById(R.id.wartosci);
        dane = findViewById(R.id.dane);
        cel = findViewById(R.id.cel);
        editTextTime = findViewById(R.id.editTextTime);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.spinner_options_array,
                android.R.layout.simple_spinner_item

        );
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                    seekBar.setMax(20);
                    gatunek = "Pies";
                } else if(i==1){
                    seekBar.setMax(18);
                    gatunek = "Kot";
                } else{
                    seekBar.setMax(9);
                    gatunek = "Świnka Morska";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                seekBar.setMax(20);
            }
        });

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wiekZmiana.setText(String.valueOf(i));
                wiek = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                wartosci.setText("Imie i nazwisko: " + dane.getText() + ", wybrany gatunek: " + gatunek + ", aktualny wiek zwierzęcia: " + wiek + ", cel wizyty: " + cel.getText() + ",  wybrany czas:" + editTextTime.getText());
            }
        });
    }
}