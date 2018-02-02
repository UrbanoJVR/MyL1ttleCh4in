/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylittlechain;

import java.util.ArrayList;

/**
 *
 * @author urbano
 */
public class MyLittleChain {

    public static ArrayList<Block> blockchain = new ArrayList();
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Block bloqueGenesis = new Block("0", "Primer bloque");
        //System.out.println(bloqueGenesis.toString() + "\n");
        
        Block bloqueDos = new Block(bloqueGenesis.getHash(), "Segundo bloque");
        //System.out.println(bloqueDos.toString() + "\n");
        
        Block bloqueTres = new Block(bloqueDos.getHash(), "Tercer bloque");
        //System.out.println(bloqueTres.toString() + "\n");
        
        Block bloqueCuatro = new Block(bloqueTres.getHash(), "Cuarto bloque");
        //System.out.println(bloqueCuatro.toString() + "\n");
        
        blockchain.add(bloqueGenesis);
        blockchain.add(bloqueDos);
        blockchain.add(bloqueTres);
        blockchain.add(bloqueCuatro);
        
        cadenaVerificada();
        
    }
    
    public static boolean cadenaVerificada(){
        boolean esCorrecta = true;
        
        try{
            for(int i = 1; i < blockchain.size(); i++){
                Block bloqueActual = blockchain.get(i);
                Block bloqueAnterior = blockchain.get(i - 1);
                if(!bloqueActual.getHash().equals(bloqueActual.calcularHash())){
                    //Comprobamos que el hash coincide con el contenido del bloque
                    esCorrecta = false;
                    System.err.println("La cadena no es correcta.\n HASH NO CORRESPONDE CON DATOS");
                    return esCorrecta;
                }
                if(!bloqueActual.getPrevHash().equals(bloqueAnterior.getHash())){
                    esCorrecta = false;
                    System.err.println("La cadena no es correcta.\n HASH PREVIO INCORRECTO");
                    return esCorrecta;
                }
            }
        } catch(Exception e){
            System.err.println("Error verificando la cadena: " + e.getMessage());
        }
        
        return esCorrecta;
    }
    
}
