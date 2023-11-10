package com.sar.wenda;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText Nilai_tugas, Nilai_kuis, Nilai_uts , Nilai_uas;
    Button Proses_hitung, bersihkan;
    TextView hasil;
    private EditText nilai_tugas;
    private EditText nilai_kuis;
    private EditText nilai_uts;
    private EditText nilai_uas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nilai_tugas = (EditText) findViewById(R.id.nilai_tugas);
        Nilai_kuis = (EditText) findViewById(R.id.nilai_kuis);
        Nilai_uts = (EditText) findViewById(R.id.nilai_uts);
        Nilai_uas = (EditText) findViewById(R.id.nilai_uas);


        Proses_hitung = (Button) findViewById(R.id.proses_hitung);
        bersihkan = (Button) findViewById(R.id.bersihkan);

        hasil = (TextView) findViewById(R.id.hasil);

        Proses_hitung.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if((Nilai_tugas.getText().length()>0) && (Nilai_kuis.getText().length()>0))
                {
                    double tugas= Double.parseDouble(Nilai_tugas.getText().toString());
                    double kuis = Double.parseDouble(Nilai_kuis.getText().toString());
                    double uts= Double.parseDouble(Nilai_uts.getText().toString());
                    double uas= Double.parseDouble(Nilai_uas.getText().toString());
                    double result = (tugas*20/100)+(kuis*20/100)+(uts*20/100)+(uas*20/100);
                    hasil.setText(Double.toString(result));
                }
                else {
                    Toast toast = Toast.makeText(MainActivity.this, "Mohon masukkan nilai", Toast.LENGTH_LONG);
                    toast.show();
                }
            }
        });

        bersihkan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Nilai_tugas.setText("");
                Nilai_kuis.setText("");
                Nilai_uts.setText("");
                Nilai_uas.setText("");
                hasil.setText("0");
                Nilai_tugas.requestFocus();
            }
        });
    }
}


