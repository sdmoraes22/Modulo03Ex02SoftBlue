package com.example.modulo03ex02softblue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class SecondActivity extends Activity implements OnClickListener {

    private Button botao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();

        int contador = intent.getIntExtra("valor", - 1);

        botao = new Button(this);
        botao.setText(String.valueOf(contador));
        botao.setOnClickListener(this);
        setContentView(botao);

    }


    @Override
    public void onClick(View v) {
        int contador = Integer.parseInt(botao.getText().toString());
        contador++;

        Intent i = new Intent();

        Bundle b = new Bundle();
        b.putInt("cont", contador);
        i.putExtras(b);

        setResult(RESULT_OK, i);

        finish();
    }
}
