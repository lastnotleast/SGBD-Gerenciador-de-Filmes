package aed3;
import java.util.Scanner;

public class ArqInd02 {

    // EXEMPLO: private static ArquivoIndexado<Livro> arquivo;

    private static ArqInd_Filme<Filme> arqFilme;
    private static ArqInd_Diretor<Diretor> arqDiretor;
    private static ArqInd_Elenco<Elenco> arqElenco;
    private static ArqInd_Categoria<Categoria> arqCategoria;
    
    private static ArvoreB_Sec tabDirFilme;
    private static ArvoreB_Sec tabFilmeDir;
    private static ArvoreB_Sec tabAtorFilme;
    private static ArvoreB_Sec tabFilmeAtor;
    private static ArvoreB_Sec tabCategFilme;
    private static ArvoreB_Sec tabFilmeCateg;
    
    private static ArvoreBMais tabDirFilmeB;
    private static ArvoreBMais tabFilmeDirB;
    private static ArvoreBMais tabAtorFilmeB;
    private static ArvoreBMais tabFilmeAtorB;
    private static ArvoreBMais tabCategFilmeB;
    private static ArvoreBMais tabFilmeCategB;
    
    private static Scanner console;
    
    public static void main(String[] args) {

        try {
            
            // EXEMPLO: arquivo = new ArquivoIndexado<>("livros.db", "livros1.idx", "livros2.idx");
            arqFilme = new ArqInd_Filme<>("filmes.db", "filmes1.idx", "filmes2.idx");
            arqDiretor = new ArqInd_Diretor<>("diretores.db", "diretores1.idx", "diretores2.idx");
            arqElenco = new ArqInd_Elenco<>("elenco.db", "elenco1.idx", "elenco2.idx");
            arqCategoria = new ArqInd_Categoria<>("categorias.db", "categorias1.idx", "categorias2.idx");
            
            // tabXeY -> X = String   Y = codigo
            tabFilmeDir = new ArvoreB_Sec(10, "filmeXdiretor.db" );
            tabDirFilme = new ArvoreB_Sec(10, "diretorXfilme.db" );
            tabAtorFilme = new ArvoreB_Sec(10, "atorXfilme.db" );
            tabFilmeAtor = new ArvoreB_Sec(10, "filmeXator.db" );
            tabCategFilme = new ArvoreB_Sec(10, "categoriaXfilme.db" );
            tabFilmeCateg = new ArvoreB_Sec(10, "filmeXcategoria.db" );
                         
            tabFilmeDirB = new ArvoreBMais(10, "filmeXdiretorBMais.db");
            tabDirFilmeB = new ArvoreBMais(10, "diretorXfilmeBMais.db");
            tabAtorFilmeB = new ArvoreBMais(10, "atorXfilmeBMais.db");
            tabFilmeAtorB = new ArvoreBMais(10, "filmeXatorBMais.db");
            tabCategFilmeB = new ArvoreBMais(10, "categoriaXfilmeBMais.db");
            tabFilmeCategB = new ArvoreBMais(10, "filmeXcategoriaBMais.db");
            
            // menu
            int opcao;
            console = new Scanner(System.in);
            do {
                System.out.println( "\nCADASTRO DE FILMES" );
                System.out.println();
                System.out.println( "1  - Cadastro Filme" );
                System.out.println( "2  - Cadastro Diretor" );
                System.out.println( "3  - Cadastro Ator/Atriz" );
                System.out.println( "4  - Cadastro Categoria" );                
                                
                System.out.println( "5  - Consultar Filme p/ código");
                System.out.println( "6  - Consultar Filme p/ nome");
                System.out.println( "7  - Consultar Diretor p/ código" );
                System.out.println( "8  - Consultar Diretor p/ nome" );
                System.out.println( "9  - Consultar Ator/Atriz p/ código" );
                System.out.println( "10 - Consultar Ator/Atriz p/ nome" );                
                System.out.println( "11 - Consultar Categoria p/ código");
                System.out.println( "12 - Consultar Categoria p/ nome");  
                
                System.out.println( "13 - Listar Atores de um Filme");
                System.out.println( "14 - Listar Filmes de um Ator");
                System.out.println( "15 - Listar Diretor de um Filme");
                System.out.println( "16 - Listar Filmes de um Diretor");
                System.out.println( "17 - Listar Categoria(s) de um Filme");
                System.out.println( "18 - Listar Filmes de uma Categoria");
                
                System.out.println( "19 - Alterar dados de um Filme");
                System.out.println( "20 - Alterar dados de um Diretor");
                System.out.println( "21 - Alterar dados de um Ator");
                System.out.println( "22 - Alterar dados de um Categoria");
                
                System.out.println( "23 - Excluir Filme");
                System.out.println( "24 - Excluir Diretor");
                System.out.println( "25 - Excluir Ator");
                System.out.println( "26 - Excluir Categoria");
                
                
                System.out.println( "0  - Sair" );
                System.out.print("\nOpção: ");
                opcao = Integer.valueOf(console.nextLine());
                
                switch(opcao) {
                    case 1:  incluirFilme(); break;        //  +
                    case 2:  incluirDiretor(); break;
                    case 3:  incluirAtor(); break;
                    case 4:  incluirCategoria(); break;
        
                    case 5:  consultaCodFilme(); break;    //  o/
                    case 6:  consultaNomeFilme(); break;
                    
                    case 7:  consultaCodDiretor(); break;
                    case 8:  consultaNomeDiretor(); break;
                    case 9:  consultaCodAtor(); break;
                    case 10: consultaNomeAtor(); break;                    
                    case 11: consultaCodCategoria(); break;
                    case 12: consultaNomeCategoria(); break;
                    
                    case 13: atoresDeUmFilme(); break;
                    case 14: filmesDeUmAtor(); break;
                    case 15: diretorDeUmFilme(); break;
                    case 16: filmesDeUmDiretor(); break;
                    case 17: categoriasDeUmFilme(); break;
                    case 18: filmesDeUmaCategoria(); break;

                    case 19: alterarFilme(); break;  
                    case 20: alterarDiretor(); break;  
                    case 21: alterarAtor(); break;  
                    case 22: alterarCategoria(); break;  

                    case 23: excluirFilme(); break;//                    
                    case 24: excluirDiretor(); break;
                    case 25: excluirAtor(); break;
                    case 26: excluirCategoria(); break;

                    case 0: break;
                    default: System.out.println( "Opção inválida!" );
                }
            } while(opcao!=0);
            
            
        } catch( Exception e ) {
            e.printStackTrace();
        }
        
    }
/* -------------------------------------------------------------------------- */
    public static void incluirFilme() throws Exception {
        
        System.out.println("\nINCLUSÃO DE FILME");
        System.out.print("Título: ");
        String tituloFilme = console.nextLine();
        System.out.print("Ano: ");
        String anoFilme = console.nextLine();
        System.out.print("País: ");
        String paisFilme = console.nextLine();
  
        System.out.print("Confirma os dados? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {          

            Diretor diretor = new Diretor();
            String nomeDiretor;
            while( diretor.codigo == -1 ) {
              System.out.print("Diretor que deseja incluir: ");
              nomeDiretor = console.nextLine();
              diretor.codigo = arqDiretor.pesquisaCodigo(diretor.nomeD);
              diretor.nomeD = nomeDiretor;
              if( diretor.codigo == -1 ){
                  System.out.println( "Diretor inválido: Cadastre um diretor válido antes." );
              }     
             
            }
                
            Filme filme = new Filme(-1,true,tituloFilme,anoFilme,paisFilme);
            filme.codigo = arqFilme.incluir(filme);     
            if( filme.codigo != -1 ){
                tabFilmeDir.inserir( filme.titulo, diretor.codigo );  // REMOVER -> APENAS CRIAR UM CAMPO COD.DIRETOR NO OBJETO FILME
                tabFilmeDirB.inserir(filme.codigo, diretor.codigo);
                tabDirFilme.inserir( diretor.nomeD, filme.codigo );
                tabDirFilmeB.inserir(diretor.codigo, filme.codigo);
                
            }     
            // -----------------------------------------------------------------
            int incluirMaisUm = 0;
            int codigoAtor = -1;
            
            while( codigoAtor == -1 || incluirMaisUm == 0) {
              Elenco elenco = new Elenco();  
              System.out.print("Ator/Atriz que deseja incluir: ");

              
              elenco.nomeA = console.nextLine();
              codigoAtor = arqElenco.pesquisaCodigo(elenco.nomeA);
              elenco.codigo = codigoAtor;
              
              if( elenco.codigo != -1 ) {
                  tabFilmeAtor.inserir( filme.titulo, elenco.codigo );
                  tabFilmeAtorB.inserir(filme.codigo, elenco.codigo);
                  tabAtorFilme.inserir( elenco.nomeA, filme.codigo );
                  tabAtorFilmeB.inserir(elenco.codigo, filme.codigo);
              }
              else
                 System.out.println( "Ator inválido: Cadastre um ator válido antes." );
              
              System.out.print("Deseja incluir novos atores? ");
              char select = console.nextLine().charAt(0);
              if(select=='S'||select=='s'){
                  incluirMaisUm = 0;      
              }
              else
                  incluirMaisUm = 1;
            }
            // -----------------------------------------------------------------         
            int sair = 0;
            int codigoCategoria = -1;
            while( codigoCategoria == -1 || sair == 0) {
              Categoria categoria = new Categoria();  
              System.out.print("Categoria que deseja incluir: ");
              
              categoria.nomeCateg = console.nextLine();
              codigoCategoria = arqCategoria.pesquisaCodigo(categoria.nomeCateg);
              categoria.codigo = codigoCategoria;
              
              if( categoria.codigo != -1 ) {    // BUSCAR DIRETOR NA TABELA FILME X DIRETOR (IMPLEMENTAR ARVORE B+)
                  tabFilmeCateg.inserir( filme.titulo, categoria.codigo );
                  tabFilmeCategB.inserir( filme.codigo, categoria.codigo );
                  tabCategFilme.inserir( categoria.nomeCateg, filme.codigo ); 
                  tabCategFilmeB.inserir( categoria.codigo, filme.codigo ); 
              }
              else
                 System.out.println( "Categoria inválida: Cadastre uma categoria válida antes." );
              
              System.out.print("Deseja incluir uma nova categoria? ");
              char select = console.nextLine().charAt(0);
              if(select=='S'||select=='s'){
                  sair = 0;      
              }
              else
                  sair = 1;
            }
            
            
            System.out.println( "Filme incluído com o código "+ filme.codigo +".");
        }
    }
    
    public static void incluirDiretor() throws Exception {
        
        System.out.println("\nINCLUSÃO DE DIRETOR");
        System.out.print("Nome: ");
        String nome = console.nextLine();
        System.out.print("Idade: ");
        String idade = console.nextLine();
        System.out.print("Naturalidade: ");
        String natural = console.nextLine();
        
        System.out.print( "\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            Diretor diretor = new Diretor(-1,nome,idade,natural);
            int codigo = arqDiretor.incluir(diretor);
            System.out.println( "Diretor incluído com o código "+codigo+".");
        }
    }
    
    public static void incluirAtor() throws Exception {

        System.out.println("\nINCLUSÃO DE ATOR/ATRIZ");
        System.out.print("Nome: ");
        String nome = console.nextLine();
        System.out.print("Idade: ");
        String idade = console.nextLine();
        System.out.print("Naturalidade: ");
        String natural = console.nextLine();
        
        System.out.print( "\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            Elenco elenco = new Elenco(-1,nome,idade,natural);
            int codigo = arqElenco.incluir(elenco);
            System.out.println( "Ator/Atriz incluído com o código "+codigo+".");
        }
    }

    public static void incluirCategoria() throws Exception {
        
        System.out.println("\nINCLUSÃO DE CATEGORIA");
        System.out.print("Título: ");
        String nome = console.nextLine();
        
        System.out.print( "\nConfirma inclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            Categoria categoria = new Categoria(-1,nome);
            int codigo = arqCategoria.incluir(categoria);
            System.out.println( "Categoria incluída com o código "+codigo+".");
        }
    }
        
/* -------------------------------------------------------------------------- */        
    public static void consultaCodFilme() throws Exception {
        int codigo;
        Filme filme = new Filme();
        System.out.println("\nCONSULTA DE FILME POR CÓDIGO");
        System.out.print("Código do Filme: ");
        codigo = Integer.valueOf(console.nextLine());
        
        if(arqFilme.buscar(codigo, filme)) 
            System.out.println(filme);
        else
            System.out.println("Filme não encontrado!");
    }
    
    public static void consultaNomeFilme() throws Exception {
        String nome;
        Filme filme = new Filme();
        System.out.println("\nCONSULTA DE FILME POR NOME");
        System.out.print("Nome do Filme: ");
        nome = console.nextLine();
        
        if(arqFilme.buscarString(nome, filme)) 
            System.out.println(filme);
        else
            System.out.println("Filme não encontrado!");
    }
    
    public static void consultaCodDiretor() throws Exception {
        int codigo;
        Diretor diretor = new Diretor();
        System.out.println("\nCONSULTA DE DIRETOR POR CÓDIGO");
        System.out.print("Código do diretor: ");
        codigo = Integer.valueOf(console.nextLine());
        
        if(arqDiretor.buscar(codigo,diretor)) 
            System.out.println(diretor);
        else
            System.out.println("Diretor não encontrado!");
    }
    
    public static void consultaNomeDiretor() throws Exception {
        String nome;
        Diretor diretor = new Diretor();
        System.out.println("\nCONSULTA DE DIRETOR POR NOME");
        System.out.print("Nome do diretor: ");
        nome = console.nextLine();
        
        if(arqDiretor.buscarString(nome,diretor)) 
            System.out.println(diretor);
        else
            System.out.println("Diretor não encontrado!");
    }
    
    public static void consultaCodAtor() throws Exception {
        int codigo;
        Elenco elenco = new Elenco();
        System.out.println("\nCONSULTA DE ATOR POR CÓDIGO");
        System.out.print("Código do Ator/Atriz: ");
        codigo = Integer.valueOf(console.nextLine());
        
        if(arqElenco.buscar(codigo, elenco)) 
            System.out.println(elenco);
        else
            System.out.println("Ator/Atriz não encontrado!");
    }
    
    public static void consultaNomeAtor() throws Exception {
        String nome;
        Elenco elenco = new Elenco();
        System.out.println("\nCONSULTA DE ATOR POR NOME");
        System.out.print("Nome do Ator/Atriz: ");
        nome = console.nextLine();
        
        if(arqElenco.buscarString(nome, elenco)) 
            System.out.println(elenco);
        else
            System.out.println("Ator/Atriz não encontrado!");
    }
    
    public static void consultaCodCategoria() throws Exception {
        int codigo;
        Categoria categoria = new Categoria();
        System.out.println("\nCONSULTA DE CATEGORIA POR CÓDIGO");
        System.out.print("Código da Categoria: ");
        codigo = Integer.valueOf(console.nextLine());
        
        if(arqCategoria.buscar(codigo, categoria)) 
            System.out.println(categoria);
        else
            System.out.println("Categoria não encontrada!");
    }
    
    public static void consultaNomeCategoria() throws Exception {
        String nome;
        Categoria categoria = new Categoria();
        System.out.println("\nCONSULTA DE CATEGORIA POR NOME");
        System.out.print("Nome da Categoria: ");
        nome = console.nextLine();
        
        if(arqCategoria.buscarString(nome, categoria)) 
            System.out.println(categoria);
        else
            System.out.println("Categoria não encontrada!");
    }    
    

    
    public static void filmesDeUmDiretor() throws Exception{
        System.out.println("\nLISTAR FILMES DE UM DIRETOR");
        System.out.println("Digite o nome do diretor: ");
        Diretor diretor = new Diretor();
        diretor.nomeD = console.nextLine();
        diretor.codigo = arqDiretor.pesquisaCodigo(diretor.nomeD);
        if(diretor.codigo == -1){
            System.out.println("Diretor não encontrado!");
        }
        else{
            Filme filme = new Filme();
            int codFilme[] = tabDirFilmeB.lista(diretor.codigo);
            System.out.println("Filmes do Diretor: ");
            for(int i=0; i<codFilme.length; i++){
                filme.codigo = codFilme[i];
                arqFilme.buscar(filme.codigo, filme);
                System.out.println(filme.titulo);
            }
        }
    }
    
    public static void filmesDeUmAtor() throws Exception{
        System.out.println("\nLISTAR FILMES DE UM ATOR");
        System.out.println("Digite o nome do Ator/Atriz: ");
        Elenco ator = new Elenco();
        ator.nomeA = console.nextLine();
        ator.codigo = arqElenco.pesquisaCodigo(ator.nomeA);
        if(ator.codigo == -1){
            System.out.println("Ator não encontrado!");
        }
        else{
            Filme filme = new Filme();
            int codFilme[] = tabAtorFilmeB.lista(ator.codigo);
            System.out.println("Lista de Filmes do Ator: ");
            for (int i=0; i<codFilme.length; i++){
                filme.codigo = codFilme[i];
                arqFilme.buscar(filme.codigo, filme);
                System.out.println(filme.titulo);
            }
        }
    }
    
    public static void filmesDeUmaCategoria() throws Exception{
        System.out.println("\nLISTAR FILMES DE UMA CATEGORIA");
        System.out.println("Digite o nome da Categoria: ");
        Categoria categoria = new Categoria();
        categoria.nomeCateg = console.nextLine();
        categoria.codigo = arqCategoria.pesquisaCodigo(categoria.nomeCateg);
        if(categoria.codigo == -1){
            System.out.println("Categoria não encontrada!");
        }
        else{
            Filme filme = new Filme();
            int codFilme[] = tabCategFilmeB.lista(categoria.codigo);
            System.out.println("Lista de Filmes por Categoria: ");
            for (int i=0; i<codFilme.length; i++){
                filme.codigo = codFilme[i];
                arqFilme.buscar(filme.codigo, filme);
                System.out.println(filme.titulo);
            }
        }
    }
    
    public static void atoresDeUmFilme() throws Exception{
        System.out.println("\nLISTAR ATORES DE UM FILME");
        System.out.println("Digite o nome do filme: ");
        Filme filme = new Filme();
        filme.titulo = console.nextLine();
        filme.codigo = arqFilme.pesquisaCodigo(filme.titulo);
        if(filme.codigo == -1){
            System.out.println("Filme não encontrado!");
        }
        else{
            Elenco ator = new Elenco();
            int codAtores[] = tabFilmeAtorB.lista(filme.codigo);
            System.out.println("Lista de Atores do Filme: ");
            for(int i=0; i<codAtores.length; i++){
                ator.codigo = codAtores[i];
                arqElenco.buscar(ator.codigo, ator);
                System.out.println(ator.nomeA);
            }
        }
    }
    
    public static void diretorDeUmFilme() throws Exception{
        System.out.println("\nLISTAR DIRETOR DE UM FILME");
        System.out.println("Digite o nome do filme: ");
        Filme filme = new Filme();
        filme.titulo = console.nextLine();
        filme.codigo = arqFilme.pesquisaCodigo(filme.titulo);
        if(filme.codigo == -1){
            System.out.println("Filme não encontrado!");
        }
        else{
            Diretor diretor = new Diretor();
            int codDiretor[] = tabFilmeDirB.lista(filme.codigo);
            System.out.println("Diretor do Filme: ");
            arqDiretor.buscar(codDiretor[0], diretor);
            System.out.println(diretor.nomeD);
        }
    }
    
    public static void categoriasDeUmFilme() throws Exception{
        System.out.println("\nLISTAR CATEGORIAS DE UM FILME");
        System.out.println("Digite o nome do filme: ");
        Filme filme = new Filme();
        filme.titulo = console.nextLine();
        filme.codigo = arqFilme.pesquisaCodigo(filme.titulo);
        if(filme.codigo == -1){
            System.out.println("Filme não encontrado!");
        }
        else{
            Categoria categoria = new Categoria();
            int codCateg[] = tabFilmeCategB.lista(filme.codigo);
            System.out.println("Lista de Categorias do Filme: ");
            for(int i=0; i<codCateg.length; i++){
                categoria.codigo = codCateg[i];
                arqCategoria.buscar(categoria.codigo, categoria);
                System.out.println(categoria.nomeCateg);
            }
        }
    }
    
/* -------------------------------------------------------------------------- */
    
    public static void alterarFilme() throws Exception{

        Filme filme = new Filme();
        System.out.println("\nALTERAÇÃO");
        System.out.print("Digite o nome do Filme que deseja alterar: ");
        filme.titulo = console.nextLine();
        filme.codigo = arqFilme.pesquisaCodigo(filme.titulo);
        if( filme.codigo != -1 ) {
            System.out.println(filme);
            
            System.out.print("Título (ENTER para manter): ");
            String titulo = console.nextLine();
            System.out.print("Ano (ENTER para manter): ");
            String ano = console.nextLine();
            System.out.print("Pais (ENTER para manter): ");
            String pais = console.nextLine();
            
            if( !titulo.equals("") || !ano.equals("") || !pais.equals("") ){
                
                System.out.print( "\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='S'||confirma=='s') {

                    if(!titulo.equals(""))
                        filme.titulo = titulo;
                    if(!ano.equals("")) 
                        filme.ano = ano;
                    if(!pais.equals("")) 
                        filme.pais = pais; 
                    
                    if( arqFilme.alterar(filme.codigo, new Filme(), filme) )
                        System.out.println("Filme alterado.");
                    else
                        System.out.println("Erro na alteração!");
                }

            }    
        }
        else{
            System.out.println("Filme não encontrado!");
        }
    }
    
    public static void alterarDiretor() throws Exception{

        Diretor diretor = new Diretor();
        System.out.println("\nALTERAÇÃO");
        System.out.print("Digite o nome do Diretor que deseja alterar: ");
        diretor.nomeD = console.nextLine();
        diretor.codigo = arqDiretor.pesquisaCodigo(diretor.nomeD);
        if( diretor.codigo != -1 ) {
            System.out.println(diretor);
            
            System.out.print("Nome (ENTER para manter): ");
            String nome = console.nextLine();
            System.out.print("Idade (ENTER para manter): ");
            String idade = console.nextLine();
            System.out.print("Naturalidade (ENTER para manter): ");
            String natural = console.nextLine();
            
            if( !nome.equals("") || !idade.equals("") || !natural.equals("") ) {
                
                System.out.print( "\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='S'||confirma=='s') {
                    
                    if(!nome.equals(""))
                        diretor.nomeD = nome;
                    if(!idade.equals("")) 
                        diretor.idade = idade;
                    if(!natural.equals("")) 
                        diretor.naturalidade = natural;
                    
                    if(arqDiretor.alterar(diretor.codigo, new Diretor(), diretor))
                        System.out.println("Diretor alterado.");
                    else
                        System.out.println("Erro ao alterar dados do Diretor!");
                }
            }
        }
        else{
            System.out.println("Diretor não encontrado!");
        }
        
    }
    
    public static void alterarAtor() throws Exception{

        Elenco elenco = new Elenco();
        System.out.println("\nALTERAÇÃO");
        System.out.print("Digite o nome do Ator/Atriz: ");
        elenco.nomeA = console.nextLine();
        elenco.codigo = arqElenco.pesquisaCodigo(elenco.nomeA);
        if( elenco.codigo != -1 ) {
            System.out.print("Nome (ENTER para manter): ");
            String nome = console.nextLine();
            System.out.print("Idade (ENTER para manter): ");
            String idade = console.nextLine();
            System.out.print("Naturalidade (ENTER para manter): ");
            String natural = console.nextLine();
            
            if( !nome.equals("") || !idade.equals("") || !natural.equals("") ) {
                System.out.print( "\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='S'||confirma=='s') {
                    if(!nome.equals(""))
                        elenco.nomeA = nome;
                    if(!idade.equals("")) 
                        elenco.idade = idade;
                    if(!natural.equals("")) 
                        elenco.naturalidade = natural;
                    
                    if(arqElenco.alterar(elenco.codigo, new Elenco(), elenco))
                        System.out.println("Ator/Atriz alterado.");
                    else
                        System.out.println("Erro ao alterar dados do Ator/Atriz!");
                }
            }
        }
        else{
            System.out.println("Ator/Atriz não encontrado");
        }
        
    }
    
    public static void alterarCategoria() throws Exception{

        Categoria categoria = new Categoria();
        System.out.println("\nALTERAÇÃO");
        System.out.print("Digite o nome da Categoria: ");
        categoria.nomeCateg = console.nextLine();
        categoria.codigo = arqCategoria.pesquisaCodigo(categoria.nomeCateg);
        if( categoria.codigo != -1 ) {
            System.out.print(categoria);
            
            System.out.print("Nome (ENTER para manter): ");
            String nome = console.nextLine();
            
            if( !nome.equals("") ) {
                System.out.print( "\nConfirma alteração? ");
                char confirma = console.nextLine().charAt(0);
                if(confirma=='S'||confirma=='s') {
                    if(!nome.equals(""))
                        categoria.nomeCateg = nome;
                                        
                    if(arqCategoria.alterar(categoria.codigo, new Categoria(), categoria))
                        System.out.println("Categoria alterada.");
                    else
                        System.out.println("Erro ao alterar dados da Categoria!");
                }
            }
        }
        else{
            System.out.println("Categoria não encontrado");
        }
        
    }
    
/* -------------------------------------------------------------------------- */
    
    public static void excluirFilme() throws Exception {
        Filme filme = new Filme();
        System.out.println("\nEXCLUSÂO");
        System.out.print("Digite o nome do Filme: ");
        filme.titulo = console.nextLine();
        filme.codigo = arqFilme.pesquisaCodigo(filme.titulo);    
        
        System.out.print( "\nConfirma Exclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            
            if(arqFilme.excluir(filme.codigo, filme))
                System.out.println("Filme excluído!");
            else
                System.out.println("Filme não encontrado!");
        }
    }
  
    public static void excluirDiretor() throws Exception {
        Diretor diretor = new Diretor();
        System.out.println("\nEXCLUSÂO");
        System.out.print("Digite o nome do Diretor: ");
        diretor.nomeD = console.nextLine();
        diretor.codigo = arqDiretor.pesquisaCodigo(diretor.nomeD);          

        System.out.print( "\nConfirma Exclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            
            if(arqDiretor.excluir(diretor.codigo, diretor))
                System.out.println("Diretor excluído!");
            else
                System.out.println("Diretor não encontrado!");
        }
    }
    
    public static void excluirAtor() throws Exception {
        Elenco elenco = new Elenco();
        System.out.println("\nEXCLUSÂO");
        System.out.print("Digite o nome do Ator: ");
        elenco.nomeA = console.nextLine();
        elenco.codigo = arqElenco.pesquisaCodigo(elenco.nomeA); 
        
        System.out.print( "\nConfirma Exclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
               
            if(arqElenco.excluir(elenco.codigo, elenco))
                System.out.println("Ator/Atriz excluído!");
            else
                System.out.println("Ator/Atriz não encontrado!");
        }
    }
     
    public static void excluirCategoria() throws Exception {
        Categoria categoria = new Categoria();
        System.out.println("\nEXCLUSÂO");
        System.out.print("Digite o nome da Categoria: ");
        categoria.nomeCateg = console.nextLine();
        categoria.codigo = arqCategoria.pesquisaCodigo(categoria.nomeCateg);
        

        System.out.print( "\nConfirma Exclusão? ");
        char confirma = console.nextLine().charAt(0);
        if(confirma=='S'||confirma=='s') {
            if(arqCategoria.excluir(categoria.codigo, categoria))
                System.out.println("Categoria excluída!");
        else
            System.out.println("Categoria não encontrada!");
        }
    }
    
}
