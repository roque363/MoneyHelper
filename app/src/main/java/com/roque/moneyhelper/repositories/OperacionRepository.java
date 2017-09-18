package com.roque.moneyhelper.repositories;

import com.roque.moneyhelper.models.Operacion;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ROQUE on 14/09/2017.
 */

public class OperacionRepository {

    private static OperacionRepository _INSTANCE = null;

    private OperacionRepository(){}

    public static OperacionRepository getInstance(){
        if (_INSTANCE == null)
            _INSTANCE = new OperacionRepository();
        return _INSTANCE;
    }

    private List<Operacion> operaciones = new ArrayList<>();

    public List<Operacion> getOperaciones() {
        return operaciones;
    }

    public void agregarOperacion(Operacion Operacion){
        this.operaciones.add(Operacion);
    }
}
