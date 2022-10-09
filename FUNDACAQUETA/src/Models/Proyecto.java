/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;
import java.util.Date;
/**
 *
 * @author clockwork
 */
public class Proyecto {
    
    private int id_proyecto;
    private Date fecha_inicio;
    private Date fecha_finaizacion;
    private String lugar;
    private String direccion;
    private String actividades_proyectada;

    public int getId_proyecto() {
        return id_proyecto;
    }

    public void setId_proyecto(int id_proyecto) {
        this.id_proyecto = id_proyecto;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_finaizacion() {
        return fecha_finaizacion;
    }

    public void setFecha_finaizacion(Date fecha_finaizacion) {
        this.fecha_finaizacion = fecha_finaizacion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getActividades_proyectada() {
        return actividades_proyectada;
    }

    public void setActividades_proyectada(String actividades_proyectada) {
        this.actividades_proyectada = actividades_proyectada;
    }
    
    
}
