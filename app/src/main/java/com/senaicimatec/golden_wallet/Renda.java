package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class Renda extends AppCompatActivity {
    private TextView textTodasCategorias;
    private TextView renda1;

    private ProgressBar progressBarRendaTotal;

    private TextView textCategoriaEscolhida;
    private TextView rendaEspecifica1;

    private ProgressBar progressBarRendaEspecifica;

    private ChipGroup chipGroupCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_renda);
    }
}