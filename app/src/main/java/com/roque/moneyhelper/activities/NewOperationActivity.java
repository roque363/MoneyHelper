package com.roque.moneyhelper.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.roque.moneyhelper.R;
import com.roque.moneyhelper.models.Operacion;
import com.roque.moneyhelper.models.SaldoNeto;
import com.roque.moneyhelper.repositories.OperacionRepository;

public class NewOperationActivity extends AppCompatActivity {

    private EditText txtMonto;
    private Spinner spTipoCuenta;
    private RadioGroup rdTipo;
    private String monto;
    private String tipoOperacion;
    private String tipoCuenta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_operation);

        txtMonto = (EditText) findViewById(R.id.txtMonto);
        spTipoCuenta = (Spinner) findViewById(R.id.spTipoCuenta);
        rdTipo = (RadioGroup) findViewById(R.id.rdTipo);

        //Verificar el tipo de cuenta
        spTipoCuenta.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                if (position != 0){
                    tipoCuenta = parent.getItemAtPosition(position).toString();
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }

    //Verificar el tipo de Operacion
    public void radioButtonClicked(View view){
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()){
            case R.id.rdIngreso:
                if(checked)
                tipoOperacion = "Ingreso";
                break;
            case R.id.rdEgreso:
                if(checked)
                tipoOperacion = "Egreso";
                break;
        }
    }

    //Guardar la Operacion
    public void guardarOperacion(View view){
        monto = txtMonto.getText().toString();

        if (monto.isEmpty() || tipoOperacion.isEmpty() || tipoCuenta.isEmpty()){
            Toast.makeText(this, "Campos vacios", Toast.LENGTH_SHORT).show();
            return;
        }
        Operacion operacion = new Operacion(Double.parseDouble(monto), tipoOperacion, tipoCuenta);

        OperacionRepository objectOperationRep = OperacionRepository.getInstance();
        objectOperationRep.agregarOperacion(operacion);

        SaldoNeto saldoNeto = SaldoNeto.getInstance();
        saldoNeto.obtenerSaldoNeto(operacion);

        Toast.makeText(this, saldoNeto.getMsj(), Toast.LENGTH_SHORT).show();

        finish();
    }
}
