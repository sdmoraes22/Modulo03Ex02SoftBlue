package com.example.modulo03ex02softblue;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity implements OnClickListener {

    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botao = new Button(this);
        botao.setText("1");
        botao.setOnClickListener(this);
        setContentView(botao);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 5) {
            botao.setText(String.valueOf(data.getIntExtra("cont", -1)));
        }
    }

    @Override
    public void onClick(View v) {
        int contador = Integer.parseInt(botao.getText().toString());
        contador ++;

        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("valor", contador);
        startActivityForResult(intent, 5);
    }
}
