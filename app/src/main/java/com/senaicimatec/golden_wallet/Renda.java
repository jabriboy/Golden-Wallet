package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class Renda extends AppCompatActivity {
    private TextView textTodasCategorias;
    private TextView renda1;
    private TextView renda2;
    private TextView renda3;
    private TextView renda4;
    private ProgressBar progressBarRendaTotal;

    private TextView textCategoriaEscolhida;
    private TextView rendaEspecifica1;
    private TextView rendaEspecifica2;
    private TextView rendaEspecifica3;
    private TextView rendaEspecifica4;
    private ProgressBar progressBarRendaEspecifica;

    private ChipGroup chipGroupCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renda);
    }
}