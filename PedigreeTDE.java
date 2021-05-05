/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pedigreetde;

import java.io.File;
import java.io.FileNotFoundException;
import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author luca
 */
public class PedigreeTDE {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        //Metodo de ingreso de datos por el usuario
        Scanner leer = new Scanner(System.in);
               
        TablaDEP TDEP= new TablaDEP();
        
        //CARGAMOS LOS DATOS DEL ARCHIVO .CSV EN LA TABLA DISPERSA ENLAZADA
        try{
            Scanner sc = new Scanner(new File("C:\\Users\\luca\\Documents\\NetBeansProjects\\PedigreeTDE\\src\\pedigreetde\\MOCK.csv"));
            while(sc.hasNext()){
                String [] a = sc.next().split(",");
                Perro s = new Perro(Integer.parseInt(a[0]),a[1],a[2]);
                TDEP.insertar(s);
            }
            sc.close();//CIERRO EL ARCHIVO
        }catch(FileNotFoundException fnf){
            System.out.println("ERROR AL ABRIR EL ARCHIVO");
        }
                
        int menu=-1;
        while(menu!=0){
            
            do{
                System.out.println("    MENU PRINCIPAL  ");
                System.out.println("OPCION 1 - AGREGAR PERRO");
                System.out.println("OPCION 2 - ELIMINAR PERRO");
                System.out.println("OPCION 3 - BUSCAR PERRO");
                System.out.println("OPCION 0 - FINALIZAR PROGRAMA");

                System.out.print("INGRESE EL NUMERO DE OPCION: ");
                menu = leer.nextInt();
            }while(menu<0 || menu>3);
            
            switch(menu){
                case 1: //AGREGAMOS UN NUEVO PERRO
                    int inCodigo;
                    String inNombreRaza, inFechaNacimiento;
                    
                    System.out.println("\n  *   *   *   *   *   AGREGAR PERRO   *   *   *   *   *");
                        
                        //PEDIMOS AL USUARIO QUE INGRESE LOS DATOS DEL PERRO
                        int contador=0;
                        do{
                            if(contador>=1){
                                System.out.println("EL ID INGRESADO YA ESTA REGISTRADO, INTENTE NUEVAMENTE..");
                            }
                            do{
                                System.out.print("INGRESE EL ID DEL PERRO (4 CIFRAS): ");
                                inCodigo = leer.nextInt();
                            }while(inCodigo<1000 || inCodigo>9999);
                            contador++;
                        }while(TDEP.buscar(inCodigo) != null);
                        System.out.print("INGRESE EL NOMBRE DE LA RAZA: ");
                        inNombreRaza = leer.next();
                        System.out.print("INGRESE LA FECHA DE NACIMIENTO (FORMATO: AAAA-MM-DD): ");
                        inFechaNacimiento = leer.next();
                                                                
                        //CREAMOS EL OBJETO PERRO
                        Perro mascota = new Perro(inCodigo,inNombreRaza,inFechaNacimiento);
                        
                        //GUARDAMOS AL PERRO EN LA TABLA DISPERSA ENLAZADA
                        TDEP.insertar(mascota);
                                                        
                        //CONFIRMACION DE DATOS GUARDADOS
                        System.out.println("EL PERRO FUE REGISTRADA CON EXITO");
                        System.out.println("*   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                    
                        break;
                    
                case 2: //ELIMINAMOS EL REGISTRO DE UN PERRRO
                    int idEliminar,bucleEliminar=1;
                    
                    do{
                        System.out.println("\n  *   *   *   *   *   ELIMINAR PERRO   *   *   *   *   *");
                        //PEDIMOS AL USUARIO EL ID DEL PERRO A BUSCAR
                        System.out.print("INGRESE EL ID DEL PERRO (4 CIFRAS): ");
                        idEliminar = leer.nextInt();

                        TDEP.eliminar(idEliminar);
                        
                        System.out.println("DESEA ELIMINAR OTRA REGISTRO?");
                        System.out.print("OPCION 1 - SI / OPCION 2 - NO: ");
                        bucleEliminar= leer.nextInt();
                        
                    }while(bucleEliminar!=2);
                    System.out.println("*   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                    break;
                    
                case 3: //BUSCAMOS LOS DATOS DE UN PERRO POR EL ID
                    int id,bucle=1;
                                        
                    do{
                        System.out.println("\n  *   *   *   *   *   BUSCAR PERRO   *   *   *   *   *");
                        //PEDIMOS AL USUARIO EL ID DEL PERRO A BUSCAR 
                        System.out.print("INGRESE EL ID DEL PERRO (4 CIFRAS): ");
                        id = leer.nextInt();

                        if(TDEP.buscar(id)!= null){
                            System.out.println(TDEP.buscar(id).getPerro().toString());
                        }else{
                            System.out.println("NO SE ENCONTRO NINGUN PERRO CON ESE NUMERO DE ID.");
                        }
                        
                        System.out.println("DESEA REALIZAR OTRA BUSQUEDA?");
                        System.out.print("OPCION 1 - SI / OPCION 2 - NO: ");
                        bucle= leer.nextInt();
                        
                    }while(bucle!=2);
                    System.out.println("*   *   *   *   *   *   *   *   *   *   *   *   *   * \n");
                    break;
                case 0:
                    //GUARDO LOS DATOS EN EL ARCHIVO .VSC
                    TDEP.guardarCSV();
                    break;
            }            
            
            
            
        }
        
        
        
        
        
    }
    
}
