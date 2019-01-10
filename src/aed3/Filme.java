package aed3;
import java.io.*;


public class Filme implements Registro, Comparable {
    
    protected int codigo;
    protected boolean temDiretor;
    protected String titulo;    
    protected String ano;    
    protected String pais;    
    
    public Filme() {
        codigo = -1;
        temDiretor = false;
        titulo = "";
        ano = "";
        pais = "";
    }
    
    public Filme(int c, boolean n, String t, String a, String p){
        codigo = c;
        temDiretor = n;
        titulo = t;
        ano = a;
        pais = p;
    }
    
    public String toString() {
        return "\nCódigo.: "+codigo+"\n"+
                "Título: " +titulo+"\n"+
                "Ano: " +ano+"\n"+
                "País: " +pais+"\n";
                //"Diretor: " + diretor.nomeD+ "\n" +
                //"Elenco: "; + elenco.nomeA+"\n";
    }
    
    public String getChaveSecundaria() {
        return titulo;
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
        out.writeUTF(titulo);
        out.writeUTF(ano);
        out.writeUTF(pais);
        //out.writeUTF(diretor.nomeD);
        //out.writeUTF(elenco.nomeA);
        return ba.toByteArray();
    }
    
    public void setRegistro(byte[] registro) throws IOException {
        ByteArrayInputStream ba = new ByteArrayInputStream(registro);
        DataInputStream in = new DataInputStream(ba);
        codigo = in.readInt();
        titulo = in.readUTF();
        ano = in.readUTF();
        pais = in.readUTF();
        //diretor.nomeD = in.readUTF();
        //elenco.nomeA = in.readUTF();
    }
  
    public int compareTo( Object b ) {
        if( codigo < ((Filme)b).codigo )
            return -1;
        else if( codigo==((Filme)b).codigo )
            return 0;
        else 
            return 1;
    }
        
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}