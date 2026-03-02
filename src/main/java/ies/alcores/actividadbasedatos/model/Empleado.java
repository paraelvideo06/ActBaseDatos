package ies.alcores.actividadbasedatos.model;

import jakarta.persistence.*;
import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "empleados")
public class Empleado {
    @Id
    private long empleado_id;
    private long departamento_id;
    private String nombre_completo;
    private String email_corporativo;
    private String rol_tecnico;
    private double salario_mensual;
    private Date fecha_contratacion;
    private boolean activo;

    public long getEmpleado_id() {
        return empleado_id;
    }

    public void setEmpleado_id(long empleado_id) {
        this.empleado_id = empleado_id;
    }

    public long getDepartamento_id() {
        return departamento_id;
    }

    public void setDepartamento_id(long departamento_id) {
        this.departamento_id = departamento_id;
    }

    public String getNombre_completo() {
        return nombre_completo;
    }

    public void setNombre_completo(String nombre_completo) {
        this.nombre_completo = nombre_completo;
    }

    public String getEmail_corporativo() {
        return email_corporativo;
    }

    public void setEmail_corporativo(String email_corporativo) {
        this.email_corporativo = email_corporativo;
    }

    public String getRol_tecnico() {
        return rol_tecnico;
    }

    public void setRol_tecnico(String rol_tecnico) {
        this.rol_tecnico = rol_tecnico;
    }

    public double getSalario_mensual() {
        return salario_mensual;
    }

    public void setSalario_mensual(double salario_mensual) {
        this.salario_mensual = salario_mensual;
    }

    public Date getFecha_contratacion() {
        return fecha_contratacion;
    }

    public void setFecha_contratacion(Date fecha_contratacion) {
        this.fecha_contratacion = fecha_contratacion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
}

