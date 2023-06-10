package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.senaicimatec.golden_wallet.Entities.Transacao;

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

        btnSaldo = (Button) findViewById(R.id.btnSaldo);

        progressBarGasto = (ProgressBar) findViewById(R.id.progressBarGasto);
        textGasto1 = (TextView) findViewById(R.id.textGasto1);

        btnGasto = (Button) findViewById(R.id.btnGasto);

        btnAdd = (FloatingActionButton) findViewById(R.id.btnAdd);



        // ir para view de gasto
        btnSaldo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPage.this,Gasto.class);
                startActivity(i);
            }
        });

        // ir para a view de saldo
        btnGasto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPage.this,Renda.class);
                startActivity(i);
            }
        });

        // ir para view de add transação
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainPage.this,AdicionarTransacao.class);
                startActivity(i);
            }
        });

    }
}