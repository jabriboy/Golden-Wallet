package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

public class AdicionarTransacao extends AppCompatActivity {

    private EditText editValor;
    private ChipGroup chipGroup;
    private Chip chipRenda;
    private Chip chipGasto;
    private Chip chip1;
    private Chip chipAddCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_transacao);

        Button btnAdicionarTransacao = (Button) findViewById(R.id.btnAdicionarTransacao);

        btnAdicionarTransacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // adicionar no banco de dados e ir para MainPage
            }
        });
    }
}