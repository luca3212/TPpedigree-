/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedigreetde;

import java.time.LocalDate;

/**
 *
 * @author luca
 */
public class Perro {
    private int codigo;
    private String nombreRaza;
    private LocalDate fechaNacimiento;
    
    public Perro(int codigo, String nombreRaza, String fecha){
        this.codigo = codigo;
        this.nombreRaza = nombreRaza;
        this.fechaNacimiento = LocalDate.of(
                Integer.parseInt(fecha.split("-")[0]),
                Integer.parseInt(fecha.split("-")[1]),
                Integer.parseInt(fecha.split("-")[2]));
    }
    
    public Perro(int codigo, String nombreRaza, int dia, int mes, int anio){
        this.codigo = codigo;
        this.nombreRaza = nombreRaza;
        this.fechaNacimiento = LocalDate.of(anio, mes, dia);
    }
    
    //get y set
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombreRaza() {
        return nombreRaza;
    }

    public void setNombreRaza(String nombreRaza) {
        this.nombreRaza = nombreRaza;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }
    
    //mostrar los datos del perro
    @Override
    public String toString(){
        return "CODIGO: " + codigo + 
               "\nRAZA: " + nombreRaza +
               "\nFECHA DE NACIMIENTO:  " + fechaNacimiento+"\n" ;
    }
    
    
}
