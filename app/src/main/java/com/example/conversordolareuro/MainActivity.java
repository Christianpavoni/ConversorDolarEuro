package com.example.conversordolareuro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import static android.app.PendingIntent.getActivity;

public class MainActivity extends AppCompatActivity {
    private RadioButton rbDolaresAEuros;
    private RadioButton rbEurosADolares;
    private EditText etDolares;
    private EditText etEuros;
    private Button btConvertir;
    private TextView tvConversion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
        rbDolaresAEuros=findViewById(R.id.rbDaE);
        rbEurosADolares=findViewById(R.id.rbEaD);
        etDolares=findViewById(R.id.etDolares);
        etEuros=findViewById(R.id.etEuros);
        btConvertir=findViewById(R.id.btConvertir);
        tvConversion=findViewById(R.id.tvConversion);
    }

    public void cambiar(View v){
        etDolares.setText("");
        etEuros.setText("");
        tvConversion.setText("");
        if(v.getId()== rbDolaresAEuros.getId()){
            etDolares.setEnabled(true);

            etDolares.requestFocusFromTouch();
            final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(etDolares, InputMethodManager.SHOW_IMPLICIT);

            etEuros.setEnabled(false);
            rbEurosADolares.setChecked(false);
        }
        else{
            etEuros.setEnabled(true);

            etEuros.requestFocusFromTouch();
            final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.showSoftInput(etEuros, InputMethodManager.SHOW_IMPLICIT);

            etDolares.setEnabled(false);
            rbDolaresAEuros.setChecked(false);
        }


    }

    public void convertir(View v){
        if(rbDolaresAEuros.isChecked()){
            double dolares= Double.valueOf(etDolares.getText().toString());
            String resultado= String.valueOf(dolares*0.85) + " Euros";
            tvConversion.setText(resultado);
        }
        else{
            double dolares= Double.valueOf(etEuros.getText().toString());
            String resultado= String.valueOf(dolares*1.18) + " Dolares";
            tvConversion.setText(resultado);
        }

        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(),0);
    }
}