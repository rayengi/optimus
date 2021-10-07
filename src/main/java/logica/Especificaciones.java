/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Grupo Optimus
 */
public class Especificaciones {
    //atributos 
    private int idEspecificaciones;
    private float  DiametroMin, DiametroMax, LargoMin, LargoMax, Alto, PesoMin, PesoMax;
    //constructores

    public Especificaciones() {
    }

    public Especificaciones(int idEspecificaciones, float DiametroMin, float DiametroMax, float LargoMin, float LargoMax, float Alto, float PesoMin, float PesoMax) {
        this.idEspecificaciones = idEspecificaciones;
        this.DiametroMin = DiametroMin;
        this.DiametroMax = DiametroMax;
        this.LargoMin = LargoMin;
        this.LargoMax = LargoMax;
        this.Alto = Alto;
        this.PesoMin = PesoMin;
        this.PesoMax = PesoMax;
    }

    public Especificaciones(float DiametroMin, float DiametroMax, float LargoMin, float LargoMax, float Alto, float PesoMin, float PesoMax) {
        this.DiametroMin = DiametroMin;
        this.DiametroMax = DiametroMax;
        this.LargoMin = LargoMin;
        this.LargoMax = LargoMax;
        this.Alto = Alto;
        this.PesoMin = PesoMin;
        this.PesoMax = PesoMax;
    }
    //metodos particulares para ingresar datos
    
    @Override
    public String toString(){
        return this.DiametroMin + " --" +this.DiametroMax + " --" +this.LargoMin+ "--"+this.LargoMax+
                "--"+this.Alto+ "--"+this.PesoMin+ "--"+this.PesoMax;
        
    }
    
    //getters and setters

    public int getIdEspecificaciones() {
        return idEspecificaciones;
    }

    public float getDiametroMin() {
        return DiametroMin;
    }

    public float getDiametroMax() {
        return DiametroMax;
    }

    public float getLargoMin() {
        return LargoMin;
    }

    public float getLargoMax() {
        return LargoMax;
    }

    public float getAlto() {
        return Alto;
    }

    public float getPesoMin() {
        return PesoMin;
    }

    public float getPesoMax() {
        return PesoMax;
    }

    public void setIdEspecificaciones(int idEspecificaciones) {
        this.idEspecificaciones = idEspecificaciones;
    }

    public void setDiametroMin(float DiametroMin) {
        this.DiametroMin = DiametroMin;
    }

    public void setDiametroMax(float DiametroMax) {
        this.DiametroMax = DiametroMax;
    }

    public void setLargoMin(float LargoMin) {
        this.LargoMin = LargoMin;
    }

    public void setLargoMax(float LargoMax) {
        this.LargoMax = LargoMax;
    }

    public void setAlto(float Alto) {
        this.Alto = Alto;
    }

    public void setPesoMin(float PesoMin) {
        this.PesoMin = PesoMin;
    }

    public void setPesoMax(float PesoMax) {
        this.PesoMax = PesoMax;
    }
    
    
    
}
