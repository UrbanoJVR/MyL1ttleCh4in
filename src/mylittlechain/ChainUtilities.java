/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylittlechain;

import java.security.MessageDigest;

/**
 *
 * @author urbano
 */
public class ChainUtilities {
    
    public static String stringToHash(String entrada){
        StringBuffer cadenaBufer = null;
        
        try{
            
            MessageDigest resumen = MessageDigest.getInstance("SHA-256");
            //Aplicamos sha256 a nuestra entrada
            byte[] hash = resumen.digest(entrada.getBytes("UTF-8"));
            cadenaBufer = new StringBuffer();
            
            for (int i = 0; i < hash.length; i++){
                String hex = Integer.toHexString(0xff & hash[i]);
                if (hex.length() == 1) cadenaBufer.append('0');
                cadenaBufer.append(hex);
            }
            
            
            
        } catch (Exception e){
            System.err.println("Error: " + e.getMessage());
        }
        
        return cadenaBufer.toString();
        
    }
    
}
