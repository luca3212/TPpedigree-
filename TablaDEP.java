/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedigreetde;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author luca
 */
public class TablaDEP {
    private static final double R=0.618034;
    private static int M = 100;
    private ElementoP[] tabla;
    private int numElementos;
    
    public TablaDEP(){
        tabla = new ElementoP[M];
        for(int k=0;k<M;k++){
            tabla[k] = null;
        }
        numElementos = 0;
    }
    
    static int dispersion(long x){
        double t;
        int v;
        t = R * x - Math.floor(R * x); // parte decimal
        v = (int) (M * t);
        return v;
    }

    public void insertar(Perro s){
        int posicion;
        ElementoP nuevo;
        posicion = dispersion(s.getCodigo());
        nuevo = new ElementoP(s);
        nuevo.sgte = tabla[posicion];
        tabla[posicion] = nuevo;
        numElementos++;
    }
    
    boolean conforme(Perro a){
        //falto implementar
        return true;
    }
    
    
    public void eliminar(int codigo){
        int posicion;
        posicion = dispersion(codigo);
        // no está vacía
        if (tabla[posicion] != null){
            ElementoP anterior, actual;
            anterior = null;
            actual = tabla[posicion];

            while ((actual.sgte != null) && actual.getPerro().getCodigo() != codigo){
                anterior = actual;
                actual = actual.sgte;
            }
               
            if (actual.getPerro().getCodigo() != codigo){
                System.out.println("NO SE ENCUENTRA NINGUN PERRO ASOCIADO A ESE ID " + codigo);
            }else if (conforme (actual.getPerro())){
                //se retira el nodo
                if (anterior == null) // primer nodo
                {
                    tabla[posicion] = actual.sgte;
                }else{
                    anterior.sgte = actual.sgte;
                }
                System.out.println("EL REGISTRO DEL PERRO FUE ELIMINADO CON EXITO");
                System.out.println("*   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                actual = null;
                numElementos--;
            }
        }else{
            System.out.println("NO SE ENCUENTRA NINGÚN PERRO ASOCIADO A ESE ID " + codigo);
        }
    }
    
    public ElementoP buscar(int codigo){
        ElementoP p = null;
        int posicion;
        posicion = dispersion(codigo);
        if (tabla[posicion] != null){
            p = tabla[posicion];
            while ((p.sgte != null) && p.getPerro().getCodigo() != codigo){
                p = p.sgte;
            }
            if (p.getPerro().getCodigo() != codigo){
                p = null;
            }
        }
        return p;
    }
    
    public void guardarCSV(){
    
        ElementoP p = null;
        FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("C:\\Users\\luca\\Documents\\NetBeansProjects\\PedigreeTDE\\src\\pedigreetde\\MOCK.csv");
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
                        for(int k=0;k<M;k++){
                            //tabla[k] = null;
                            if(tabla[k] != null){
                                p = tabla[k];
                                bfwriter.write(p.getPerro().getCodigo()+","+p.getPerro().getNombreRaza()+","+p.getPerro().getFechaNacimiento()+"\n");
                                while (p.sgte != null){
                                    p = p.sgte;
                                    bfwriter.write(p.getPerro().getCodigo()+","+p.getPerro().getNombreRaza()+","+p.getPerro().getFechaNacimiento()+"\n");
                                }
                            }
                        }
                        //cierra el buffer intermedio
			bfwriter.close();
			System.out.println("LOS DATOS FUERON GUARDADOS CON EXITO..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
    
    
    }
    
    
}
