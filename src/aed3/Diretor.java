package aed3;
import java.io.*;

public class Diretor implements Registro, Comparable {
    
    protected int codigo;
    protected String nomeD;
    protected String idade; // String, já que não serão feitas nenhum tipo de operação nos valores de idade
    protected String naturalidade;
    
    public Diretor() {
        codigo = -1;
        nomeD = "";
        idade = "";
        naturalidade = "";
        
    }
    
    public Diretor(int c, String d, String i, String t){
        codigo = c;
        nomeD = d;
        idade = i;
        naturalidade = t;
    }
    
    public String toString() {
        return "\nCódigo Diretor(a): "+codigo+"\n"+
                "Nome: " + nomeD+"\n"+
                "Idade: "+ idade + "\n"+
                "Naturalidade: "+naturalidade+"\n";
    }
    
    public String getChaveSecundaria() {
        return nomeD;
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
        out.writeUTF(nomeD);
        out.writeUTF(idade);
        out.writeUTF(naturalidade);
        return ba.toByteArray();
    }
    
    public void setRegistro(byte[] registro) throws IOException {
        ByteArrayInputStream ba = new ByteArrayInputStream(registro);
        DataInputStream in = new DataInputStream(ba);
        codigo = in.readInt();
        nomeD = in.readUTF();
        idade = in.readUTF();
        naturalidade = in.readUTF();
    }
  
    public int compareTo( Object b ) {
        if( codigo < ((Diretor)b).codigo )
            return -1;
        else if( codigo==((Diretor)b).codigo )
            return 0;
        else 
            return 1;
    }
        
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}