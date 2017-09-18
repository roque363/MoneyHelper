package com.roque.moneyhelper.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.roque.moneyhelper.R;
import com.roque.moneyhelper.models.SaldoNeto;

public class MainActivity extends AppCompatActivity {

    private TextView txtAhorro;
    private TextView txtCredito;
    private TextView txtEfectivo;
    private ProgressBar progressBar;

    private static final int NEW_OPERATION_REQUEST = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtAhorro = (TextView) findViewById(R.id.txtAhorro);
        txtCredito = (TextView) findViewById(R.id.txtCredito);
        txtEfectivo = (TextView) findViewById(R.id.txtEfectivo);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        MostrarSaldos();
    }

    public void nuevaOperacion(View view){
        startActivityForResult(new Intent(this, NewOperationActivity.class), NEW_OPERATION_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        MostrarSaldos();
    }

    public void MostrarSaldos(){
        SaldoNeto saldoActual = SaldoNeto.getInstance();

        txtAhorro.setText(saldoActual.getSaldoAhorro().toString());
        txtCredito.setText(saldoActual.getSaldoCredito().toString());
        txtEfectivo.setText(saldoActual.getSaldoEfectivo().toString());

        double mtIngreso = saldoActual.getMontoTotalIngreso();
        double mtEgreso = saldoActual.getMontoTotalEgreso();
        double mTotal = mtIngreso + mtEgreso;

        mtIngreso = Math.round((mtIngreso * 100)/(mTotal));
        int i = (int)mtIngreso;
        progressBar.setProgress(i);

    }
}
