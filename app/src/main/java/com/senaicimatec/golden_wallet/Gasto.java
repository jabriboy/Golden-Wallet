package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.android.material.chip.ChipGroup;

public class Gasto extends AppCompatActivity {

    private TextView textTodasCategorias;
    private TextView gasto1;
    private TextView gasto2;
    private TextView gasto3;
    private TextView gasto4;
    private ProgressBar progressBarGastoTotal;

    private TextView textCategoriaEscolhida;
    private TextView gastoEspecifica1;
    private TextView gastoEspecifica2;
    private TextView gastoEspecifica3;
    private TextView gastoEspecifica4;
    private ProgressBar progressBarGastoEspecifica;

    private ChipGroup chipGroupCategorias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gasto);
    }
}