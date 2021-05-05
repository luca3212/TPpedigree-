/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedigreetde;

/**
 *
 * @author luca
 */
public class ElementoP {
   
    private Perro perro;
    ElementoP sgte;
    
    public ElementoP(Perro e){
        perro = e;
        sgte = null;
    }
    
    public Perro getPerro(){
        return perro;
    }
}
