package ies.alcores.actividadbasedatos.model;

import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Table (name = "departamentos")
public class Departamento {
    @Id
    private long departamento_id;
    private String nombre_depto;
    private String codigo_interno;
    private double presupuesto_anual;
    private String ubicacion_oficina;

    public long getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(long departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getNombre_depto() {
        return nombre_depto;
    }

    public void setNombre_depto(String nombre_depto) {
        this.nombre_depto = nombre_depto;
    }

    public String getCodigo_interno() {
        return codigo_interno;
    }

    public void setCodigo_interno(String codigo_interno) {
        this.codigo_interno = codigo_interno;
    }

    public double getPresupuesto_anual() {
        return presupuesto_anual;
    }

    public void setPresupuesto_anual(double presupuesto_anual) {
        this.presupuesto_anual = presupuesto_anual;
    }

    public String getUbicacion_oficina() {
        return ubicacion_oficina;
    }

    public void setUbicacion_oficina(String ubicacion_oficina) {
        this.ubicacion_oficina = ubicacion_oficina;
    }
}
