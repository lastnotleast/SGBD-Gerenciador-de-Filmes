package aed3;
import java.io.*;

public class Elenco implements Registro, Comparable {
    
    protected int codigo;
    protected String nomeA;
    protected String idade;
    protected String naturalidade;
        
    public Elenco() {
        codigo = -1;
        nomeA = "";
        idade = "";
        naturalidade = "";
    }
    
    public Elenco(int c, String n, String i, String t){
        codigo = c;
        nomeA = n;
        idade = i;
        naturalidade = t;
    }
    
    public String toString() {
        return "\nCódigo Ator/Atriz: "+codigo+"\n"+
                "Nome: " + nomeA+"\n"+
                "Idade: "+ idade + "\n"+
                "Naturalidade: "+naturalidade+"\n";
    }
    
    public String getChaveSecundaria() {
        return nomeA;
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
        out.writeUTF(nomeA);
        out.writeUTF(idade);
        out.writeUTF(naturalidade);
        return ba.toByteArray();
    }
    
    public void setRegistro(byte[] registro) throws IOException {
        ByteArrayInputStream ba = new ByteArrayInputStream(registro);
        DataInputStream in = new DataInputStream(ba);
        codigo = in.readInt();
        nomeA = in.readUTF();
        idade = in.readUTF();
        naturalidade = in.readUTF();
    }
  
    public int compareTo( Object b ) {
        if( codigo < ((Elenco)b).codigo )
            return -1;
        else if( codigo==((Elenco)b).codigo )
            return 0;
        else 
            return 1;
    }
        
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}