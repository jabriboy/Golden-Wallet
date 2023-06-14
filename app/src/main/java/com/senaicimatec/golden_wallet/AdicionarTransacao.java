package com.senaicimatec.golden_wallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import com.senaicimatec.golden_wallet.Entities.Categoria;
import com.senaicimatec.golden_wallet.Entities.Tipo;
import com.senaicimatec.golden_wallet.Entities.Transacao;
import com.senaicimatec.golden_wallet.db.DataInsertionHelper;

public class AdicionarTransacao extends AppCompatActivity {

    DataInsertionHelper di = new DataInsertionHelper();

    private EditText editValor;
    private ChipGroup chipGroup2;
    public static Chip chipRenda;
    public static Chip chipGasto;
    private Chip chip1;
    private Chip chipAddCategoria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_transacao);

        Button btnAdicionarTransacao = (Button) findViewById(R.id.btnAdicionarTransacao);
        chipGroup2 = (ChipGroup) findViewById(R.id.chipGroup2);

        chipAddCategoria = (Chip) findViewById(R.id.chipAddCategoria);

        chipGasto = (Chip) findViewById(R.id.chipGasto);

        chipRenda = (Chip) findViewById(R.id.chipRenda);

        chipAddCategoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(AdicionarTransacao.this,AdicionarCategoria.class);
                startActivity(i);
            }
        });

        btnAdicionarTransacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // adicionar no banco de dados e ir para MainPage
                String valor = editValor.getText().toString();
                Tipo tipo = null;
                Categoria categoria = null;
                if(chipRenda.isChecked()){
                    tipo = new Tipo("Renda", "1");
                }
                else if(chipGasto.isChecked()){
                    tipo = new Tipo("Gasto", "2");
                }
                else{
                    System.out.println("selecione um tipo para a transação");
                }
                int chipID = chipGroup2.getCheckedChipId();
                Chip chipCategoria = (Chip) findViewById(chipID);
                String categoriaName = chipCategoria.getText().toString();
                System.out.println(tipo.getDescription());
                System.out.println(chipID);
                //di.inserirTransacao(new Transacao(valor, tipo, categoria));
            }
        });
    }
}
