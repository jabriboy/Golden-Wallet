package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainPage extends AppCompatActivity {

    private TextView textNome;
    private TextView textSaldoTotal;
    private ProgressBar progressBarSaldo;
    private TextView textSaldo1;
    private TextView textSaldo2;
    private TextView textSaldo3;
    private Button btnSaldo;
    private ProgressBar progressBarGasto;
    private TextView textGasto1;
    private TextView textGasto2;
    private TextView textGasto3;
    private Button btnGasto;

    private FloatingActionButton btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        progressBarSaldo = (ProgressBar) findViewById(R.id.progressBarSaldo);
        textSaldo1 = (TextView) findViewById(R.id.textSaldo1);
        textSaldo2 = (TextView) findViewById(R.id.textSaldo2);
        textSaldo3 = (TextView) findViewById(R.id.textSaldo3);
        btnSaldo = (Button) findViewById(R.id.btnSaldo);

        progressBarGasto = (ProgressBar) findViewById(R.id.progressBarGasto);
        textGasto1 = (TextView) findViewById(R.id.textGasto1);
        textGasto2 = (TextView) findViewById(R.id.textGasto2);
        textGasto3 = (TextView) findViewById(R.id.textGasto3);
        btnGasto = (Button) findViewById(R.id.btnGasto);

        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);

        // ir para view de gasto
        btnSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // ir para a view de saldo
        btnGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        // ir para view de add transação
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
}