package com.roque.moneyhelper.models;

/**
 * Created by ROQUE on 14/09/2017.
 */

public class Operacion {

    private Double monto;
    private String tipoOperacion;
    private String tipoCuenta;

    public Operacion() {

    }
    public Operacion(Double monto, String tipoOperacion, String tipoCuenta) {
        this.monto = monto;
        this.tipoOperacion = tipoOperacion;
        this.tipoCuenta = tipoCuenta;
    }

    public Double getMonto() {
        return monto;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public String getTipoOperacion() {
        return tipoOperacion;
    }

    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    @Override
    public String toString() {
        return "Operation{" +
                "monto=" + monto +
                ", tipoOperacion='" + tipoOperacion + '\'' +
                ", tipoCuenta='" + tipoCuenta + '\'' +
                '}';
    }
}
