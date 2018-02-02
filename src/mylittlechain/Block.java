/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mylittlechain;

import java.util.GregorianCalendar;

/**
 *
 * @author urbano
 */
public final class Block {
    
    public String hash;
    public String prevHash;
    private String content;
    private long instant;

    public Block(String prevHash, String content) {

        this.prevHash = prevHash;
        this.content = content;
        this.instant = new GregorianCalendar().getTimeInMillis();
        this.hash = calcularHash();
        
    }
    
    public String calcularHash(){
        String finalHash = ChainUtilities.stringToHash(this.content + this.prevHash + this.instant);
        return finalHash;   
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getPrevHash() {
        return prevHash;
    }

    public void setPrevHash(String prevHash) {
        this.prevHash = prevHash;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public long getInstant() {
        return instant;
    }

    public void setInstant(long instant) {
        this.instant = instant;
    }

    @Override
    public String toString() {
        return "Bloque:\n{" + "hash=" + hash + "\n, prevHash=" + prevHash + "\n, content=" + content + "\n, instant=" + instant + '}';
    }
    
    
    
}
