package com.roque.moneyhelper.models;

import android.widget.Toast;

/**
 * Created by ROQUE on 14/09/2017.
 */

public class SaldoNeto {

    //Se declara las variables de TIPOS DE SALDO
    private Double saldoAhorro = 0.0;
    private Double saldoCredito = 0.0;
    private Double saldoEfectivo = 0.0;
    private Double montoTotalIngreso = 0.0;
    private Double montoTotalEgreso = 0.0;
    private Operacion operacion;
    private String msj;

    private static SaldoNeto _INSTANCE = null;

    private SaldoNeto(){
    }

    public static SaldoNeto getInstance(){
        if (_INSTANCE == null)
            _INSTANCE = new SaldoNeto();
        return _INSTANCE;
    }

    //Se obtiene el saldo ingresado
    public void obtenerSaldoNeto(Operacion op){
        //Se obtiene los datos guardados del repositorio Operaciones
        Double monto = op.getMonto();
        String tipoOperacion = op.getTipoOperacion();
        String tipoCuenta = op.getTipoCuenta();

        //Obtiene el tipo de operacion 'Ingreso - Egreso'
        if(tipoOperacion.equals("Ingreso")){
            montoTotalIngreso = montoTotalIngreso + monto;
            switch (tipoCuenta){
                case "Ahorro":
                    saldoAhorro = saldoAhorro + monto;
                    msj = "Monto agregado a "+tipoCuenta;
                    break;
                case "Efectivo":
                    saldoEfectivo = saldoEfectivo + monto;
                    msj = "Monto agregado a "+tipoCuenta;
                    break;
                case "Credito":
                    saldoCredito = saldoCredito + monto;
                    msj = "Monto agregado a "+tipoCuenta;
                    break;
            }
        }else if(tipoOperacion.equals("Egreso")){
            if(saldoAhorro >= monto || saldoCredito >= monto || saldoEfectivo >= monto){
                montoTotalEgreso = montoTotalEgreso + monto;
                switch (tipoCuenta){
                    case "Ahorro":
                        saldoAhorro = saldoAhorro - monto;
                        msj = "Monto quitado a "+tipoCuenta;
                        break;
                    case "Efectivo":
                        saldoEfectivo = saldoEfectivo - monto;
                        msj = "Monto quitado a "+tipoCuenta;
                        break;
                    default:
                        saldoCredito = saldoCredito - monto;
                        msj = "Monto quitado a "+tipoCuenta;
                        break;
                }
            }else{
                msj = "No tiene el saldo suficiente";
            }
        }else{
            msj = "Error";
        }
    }

    public Double getSaldoAhorro() {
        return saldoAhorro;
    }
    public void setSaldoAhorro(Double saldoAhorro) {
        this.saldoAhorro = saldoAhorro;
    }

    public Double getSaldoCredito() {
        return saldoCredito;
    }
    public void setSaldoCredito(Double saldoCredito) {
        this.saldoCredito = saldoCredito;
    }

    public Double getSaldoEfectivo() {
        return saldoEfectivo;
    }
    public void setSaldoEfectivo(Double saldoEfectivo) {
        this.saldoEfectivo = saldoEfectivo;
    }

    public Operacion getOperacion() {
        return operacion;
    }
    public void setOperacion(Operacion operacion) {
        this.operacion = operacion;
    }

    public String getMsj() {
        return msj;
    }
    public void setMsj(String msj) {
        this.msj = msj;
    }

    public Double getMontoTotalIngreso() {
        return montoTotalIngreso;
    }

    public void setMontoTotalIngreso(Double montoTotalIngreso) {
        this.montoTotalIngreso = montoTotalIngreso;
    }

    public Double getMontoTotalEgreso() {
        return montoTotalEgreso;
    }

    public void setMontoTotalEgreso(Double montoTotalEgreso) {
        this.montoTotalEgreso = montoTotalEgreso;
    }

    @Override
    public String toString() {
        return "SaldoNeto{" +
                "saldoAhorro=" + saldoAhorro +
                ", saldoCredito=" + saldoCredito +
                ", saldoEfectivo=" + saldoEfectivo +
                ", operacion=" + operacion +
                ", montoTotalIngreso=" + montoTotalIngreso +
                ", montoTotalEgreso=" + montoTotalEgreso +
                ", msj='" + msj + '\'' +
                '}';
    }
}
