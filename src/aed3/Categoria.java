package aed3;
import java.io.*;

public class Categoria implements Registro, Comparable {
    
    protected int codigo;
    protected String nomeCateg;
        
    public Categoria() {
        codigo = -1;
        nomeCateg = "";
    }
    
    public Categoria(int c, String d){
        codigo = c;
        nomeCateg = d;
    }
    
    public String toString() {
        return "\nCódigo Categoria: "+codigo+"\n"+
                "Nome: " + nomeCateg+"\n";
    }
    
    public String getChaveSecundaria() {
        return nomeCateg;
    }
    
    public void setCodigo(int c){
        codigo = c;
    }
    public int getCodigo(){
        return codigo;
    }
    
    public byte[] getRegistro() throws IOException {
        ByteArrayOutputStream ba = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(ba);
        out.writeInt(codigo);
        out.writeUTF(nomeCateg);
        return ba.toByteArray();
    }
    
    public void setRegistro(byte[] registro) throws IOException {
        ByteArrayInputStream ba = new ByteArrayInputStream(registro);
        DataInputStream in = new DataInputStream(ba);
        codigo = in.readInt();
        nomeCateg = in.readUTF();
    }
  
    public int compareTo( Object b ) {
        if( codigo < ((Categoria)b).codigo )
            return -1;
        else if( codigo==((Categoria)b).codigo )
            return 0;
        else 
            return 1;
    }
        
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}