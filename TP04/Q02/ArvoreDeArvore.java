import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

class Personagem{
    private String id;
    private String name;
    private String[] alternate_names;
    private String[] alternate_actors;
    private String house;
    private String ancestry;
    private String species;
    private String patronus;
    private boolean hogwartsStaff;
    private boolean hogwartsStudent;
    private String actorName;
    private boolean alive;
    private Date dateOfBirth;
    private int yearOfBirth;
    private String eyeColour;
    private String gender;
    private String hairColour;
    private boolean wizzard;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getAlternate_names() {
        return alternate_names;
    }

    public void setAlternate_names(String[] alternate_names) {
        this.alternate_names = alternate_names;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
    }

    public String getAncestry() {
        return ancestry;
    }

    public void setAncestry(String ancestry) {
        this.ancestry = ancestry;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getPatronus() {
        return patronus;
    }

    public void setPatronus(String patronus) {
        this.patronus = patronus;
    }

    public boolean isHogwartsStaff() {
        return hogwartsStaff;
    }

    public void setHogwartsStaff(boolean hogwartsStaff) {
        this.hogwartsStaff = hogwartsStaff;
    }

    public boolean isHogwartsStudent() {
        return hogwartsStudent;
    }

    public void setHogwartsStudent(boolean hogwartsStudent) {
        this.hogwartsStudent = hogwartsStudent;
    }

    public String getActorName() {
        return actorName;
    }

    public void setActorName(String actorName) {
        this.actorName = actorName;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getYearOfBirth() {
        return yearOfBirth;
    }
    
    public void setYearOfBirth(int yearOfBirth) {
        this.yearOfBirth = yearOfBirth;
    }

    public String getEyeColour() {
        return eyeColour;
    }

    public void setEyeColour(String eyeColour) {
        this.eyeColour = eyeColour;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getHairColour() {
        return hairColour;
    }

    public void setHairColour(String hairColour) {
        this.hairColour = hairColour;
    }

    public boolean isWizzard() {
        return wizzard;
    }

    public void setWizzard(boolean wizzard) {
        this.wizzard = wizzard;
    }
    
    

    public Personagem(){
        this("", "", new String[5000], "", "", "", "", false, false, "", false, null, -1, "", "", "", false);

    }

    public Personagem(String id, String name, String[] alternate_names, String house, String ancestry, String species, String patronus, boolean hogwartsStaff, 
    boolean hogwartsStudent, String actorName, boolean alive, Date dateOfBirth, int yearOfBirth, String eyeColour, String gender, String hairColour, boolean wizzard){
        this.id = id;
        this.name = name;
        this.alternate_names = alternate_names;
        this.house = house;
        this.ancestry = ancestry;
        this.species = species;
        this.patronus = patronus;
        this.hogwartsStaff = hogwartsStaff;
        this.hogwartsStudent = hogwartsStudent;
        this.actorName = actorName;
        this.alive = alive;
        this.dateOfBirth = dateOfBirth;
        this.yearOfBirth = yearOfBirth;
        this.eyeColour = eyeColour;
        this.gender = gender;
        this.hairColour = hairColour;
        this.wizzard = wizzard;

    }

    public static Personagem clone(Personagem personagem){
        Personagem clone = new Personagem(personagem.getId(), personagem.getName(), personagem.getAlternate_names(), 
        personagem.getHouse(), personagem.getAncestry(), personagem.getSpecies(), 
        personagem.getPatronus(), personagem.isHogwartsStaff(), personagem.isHogwartsStudent(), 
        personagem.getActorName(), personagem.isAlive(), personagem.getDateOfBirth(), personagem.getYearOfBirth(), personagem.getEyeColour(), 
        personagem.getGender(), personagem.getHairColour(), personagem.isWizzard());

        return clone;

    }

    public void printArray(ArrayList<Personagem> array){
        for(int i = 0; i < array.size(); i++){
            System.out.print("[" + array.get(i).getId() + " ## " + array.get(i).getName() + " ## {"); 
        
            for(int j = 0; j < array.get(i).getAlternate_names().length; j++){
                System.out.print(array.get(i).getAlternate_names()[j]);

            }
        
            System.out.println("} ## " 
            + array.get(i).getHouse() + " ## " + array.get(i).getAncestry() + " ## " + array.get(i).getSpecies() + " ## " + array.get(i).getPatronus() + " ## "
            + array.get(i).isHogwartsStaff() + " ## " + array.get(i).isHogwartsStudent() + " ## " + array.get(i).getActorName() + " ## " + array.get(i).isAlive() + " ## "
            + array.get(i).getDateOfBirth() + " ## " + array.get(i).getYearOfBirth() + " ## " + array.get(i).getEyeColour() + " ## " + array.get(i).getGender() + " ## "
            + array.get(i).getHairColour() + " ## " + array.get(i).isWizzard() + "]");
            
        }

    }

    public void print(){
        System.out.print("[" + this.getId() + " ## " + this.getName() + " ## {"); 

        for(int i = 0; i < this.getAlternate_names().length; i++){
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("[", "");
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("]", "");
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("'", "");
            System.out.print(this.getAlternate_names()[i]);
            if (i < this.getAlternate_names().length - 1) {
                System.out.print(", ");

            }

        }
        
        System.out.print("} ## " 
        + this.getHouse() + " ## " + this.getAncestry() + " ## " + this.getSpecies() + " ## " + this.getPatronus() + " ## "
        + this.isHogwartsStaff() + " ## " + this.isHogwartsStudent() + " ## " + this.getActorName() + " ## " + this.isAlive() + " ## ");

        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyy");
        String dataFormatada = formatoData.format(this.getDateOfBirth());
        System.out.print(dataFormatada);
        
        System.out.println(" ## " + this.getYearOfBirth() + " ## " + this.getEyeColour() + " ## " + this.getGender() + " ## "
        + this.getHairColour() + " ## " + this.isWizzard() + "]");

    }

    public static ArrayList<Personagem> ler(String nomeArquivo) throws ParseException{
        ArrayList<Personagem> resp = new ArrayList<Personagem>();

        try(BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                String[] splits = line.split(";");
                Personagem personagem = new Personagem();
                
                personagem.setId(splits[0] != null ? splits[0] : "");
                personagem.setName(splits[1] != null ? splits[1] : "");
                
                String[] alternateNames = splits[2].split(",");
                personagem.setAlternate_names(alternateNames);
                
                personagem.setHouse(splits[3] != null ? splits[3] : "");
                personagem.setAncestry(splits[4] != null ? splits[4] : "");
                personagem.setSpecies(splits[5] != null ? splits[5] : "");
                personagem.setPatronus(splits[6] != null ? splits[6] : "");
                personagem.setHogwartsStaff(splits[7].equals("VERDADEIRO") ? true : false);
                personagem.setHogwartsStudent(splits[8].equals("VERDADEIRO") ? true : false);
                personagem.setActorName(splits[9] != null ? splits[9] : "");
                personagem.setAlive(splits[10].equals("VERDADEIRO") ? true : false);

                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                personagem.setDateOfBirth(formato.parse(splits[12] != null ? splits[12] : "00000000"));

                personagem.setYearOfBirth(Integer.parseInt(splits[13] != null ? splits[13] : "-1"));
                personagem.setEyeColour(splits[14] != null ? splits[14] : "");
                personagem.setGender(splits[15] != null ? splits[15] : "");
                personagem.setHairColour(splits[16] != null ? splits[16] : "");
                personagem.setWizzard(splits[17].equals("VERDADEIRO") ? true : false);

                resp.add(personagem);

            }

        } catch(IOException e){
            System.out.println(e);

        }

        return resp;

    }

    public static Personagem pesquisarPorID(String id, ArrayList<Personagem> array){
        Personagem resp = new Personagem();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getId().equals(id)) resp = array.get(i);

        }

        return resp;

    }

}

class NoBase {
    private int chave;
    private NoBase esq, dir;
    private No raizSub;

    public int getChave() {
        return chave;
    }

    public void setChave(int chave) {
        this.chave = chave;
    }

    public NoBase getDir() {
        return dir;
    }

    public void setDir(NoBase dir) {
        this.dir = dir;
    }

    public NoBase getEsq() {
        return esq;
    }

    public void setEsq(NoBase esq) {
        this.esq = esq;
    }

    public No getRaizSub() {
        return raizSub;
    }

    public void setRaizSub(No raizSub) {
        this.raizSub = raizSub;
    }

    public NoBase() {
        this(-1);

    }

    public NoBase(int chave) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;

    }

}

class No {
    private String chave;
    private No esq, dir;

    public String getChave() {
        return chave;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public No getDir() {
        return dir;
    }

    public void setDir(No dir) {
        this.dir = dir;
    }

    public No getEsq() {
        return esq;
    }

    public void setEsq(No esq) {
        this.esq = esq;
    }

    public No() {
        this("");

    }

    public No(String chave) {
        this.chave = chave;
        this.esq = null;
        this.dir = null;

    }

}

public class ArvoreDeArvore {
    private NoBase raiz;
    private int numElementos;

    public NoBase getRaiz() {
        return raiz;
    }

    public void setRaiz(NoBase raiz) {
        this.raiz = raiz;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public ArvoreDeArvore() {
        this.raiz = null;

    }

    /*
     * void inserirBase(int chave) - Método recursivo para auxiliar no construtor, que insere os nós na árvore base.
     * @param int chave Inteiro contendo o número a ser inserido na chave.
     * @author Luis Felipe Souza Lopes.
     * 
    */
    public void inserirBase(int chave) throws Exception{
        this.raiz = inserirBase(chave, this.getRaiz());

    }

    private NoBase inserirBase(int chave, NoBase i) throws Exception{
        if(i == null) {
            //System.out.println("INSERINDO NA BASE: " + chave);
            i = new NoBase(chave);
            this.numElementos++;

        } else if(chave < i.getChave()) {
            i.setEsq(inserirBase(chave, i.getEsq()));

        } else if(chave > i.getChave()){
            i.setDir(inserirBase(chave, i.getDir()));

        } else {
            throw new Exception("ERRO AO INSERIR! Personagem já existe na árvore!!!");

        }

        return i;

    }

    /*
     * void inserir(Personagem personagem) - Método recursivo de inserir os nomes nas sub-árvores correspondentes, definido pelo (yearOfBirth % 15).
     * @param Personagem personagem - Personagem cujo nome será inserido em alguma das sub-árvores.
     * @author Luis Felipe Souza Lopes.
     * 
    */
    public void inserir(Personagem personagem) throws Exception {
        if(personagem == null) {
            throw new Exception("ERRO AO INSERIR (NOME)! Personagem Nulo!!!");

        } else {
            this.raiz = inserir(personagem, this.getRaiz());

        }

    }

    private NoBase inserir(Personagem personagem, NoBase i) throws Exception {
        int chave = personagem.getYearOfBirth() % 15;
        
        if(chave == i.getChave()) { //caso seja o nó correto do personagem, realiza a chamada da inserção na sub-árvore.
            //System.out.println("CHAMANDO INSERIR SUB-ÁRVORE COM: " + personagem.getName());
           i.setRaizSub(inserirSubarvore(personagem.getName(), i.getRaizSub()));

        } else if(chave < i.getChave()) {
            i.setEsq(inserir(personagem, i.getEsq()));

        } else if(chave > i.getChave()){
            i.setDir(inserir(personagem, i.getDir()));

        } else {
            throw new Exception("ERRO AO INSERIR! Personagem já existe na árvore!!!");

        }

        return i;

    }

    /*
     * No inserirSubarvore(Personagem personagem) - "Sub-método" para realizar a inserção do nome do personagem na subárvore.
     * @param Personagem personagem - Personagem cujo nome será inserido.
     * @param No i - Nó para navegação na sub-árvore.
     * @author Luis Felipe Souza Lopes.
     * 
    */
    private No inserirSubarvore(String name, No i) throws Exception {
        if(i == null) {
            //System.out.println("INSERINDO: " + personagem.getName() + " NA SUB-ÁRVORE");
            i = new No(name);

        } else if(name.compareTo(i.getChave()) < 0) {
            i.setEsq(inserirSubarvore(name, i.getEsq()));

        } else if(name.compareTo(i.getChave()) > 0){
            i.setDir(inserirSubarvore(name, i.getDir()));

        } else {
            throw new Exception("ERRO AO INSERIR! Personagem já existe na árvore!!!");

        }

        return i;

    }

    /*
     * boolean pesquisar(Personagem personagem) - Método para pesquisar se o personagem está inserido em alguma das sub-árvores.
     * @param Personagem personagem - Personagem cujo nome será pesquisado.
     * @author Luis Felipe Souza Lopes.
     * 
    */
    public boolean pesquisar(String name) throws Exception{
        if(name == null || name.isEmpty()) {
            throw new Exception("ERRO AO PESQUISAR! Personagem Nulo!!!");

        } else {
            return pesquisar(name, this.raiz);

        }

    }

    private boolean pesquisar(String name, NoBase i) {
        boolean resp = false;  
        //caso o nó possua uma sub-árvore, realiza a chamada do pesquisar na sub-árvore.
        if(i != null) {
            if(i.getRaizSub() != null) {
                resp = pesquisarSubarvore(name, i.getRaizSub());
    
            }

            if(!resp){
                System.out.print(" ESQ");
                resp = pesquisar(name, i.getEsq());

            }

            if(!resp) {
                System.out.print(" DIR");
                resp = pesquisar(name, i.getDir());

            }
            
        }
            
        return resp;

    }

    /*
     * boolean pesqusiarSubarvore(Personagem personagem) - "Sub-método" para realizar a pesquisa do nome do personagem na subárvore.
     * @param Personagem personagem - Personagem cujo nome será pesquisado.
     * @param No i - Nó para navegação na sub-árvore.
     * @author Luis Felipe Souza Lopes.
     * 
    */
    private boolean pesquisarSubarvore(String name, No i) {
        boolean resp = false;
        if(i != null) {
            //System.out.println("\nCOMPARANDO: " + name + " COM CHAVE: " + i.getChave());
            if(name.equals(i.getChave())) {
                resp =  true;
    
            } else if(name.compareTo(i.getChave()) < 0) {
                System.out.print("->esq");
                resp = pesquisarSubarvore(name, i.getEsq());
    
            } else {
                System.out.print("->dir");
                resp = pesquisarSubarvore(name, i.getDir());
    
            }

        }
            

        return resp;

    }

    public static void main(String[] args) throws Exception {
        
        //Leitura da Entrada ============================================================================================
        String[] entrada = new String[5000];
        int numEntrada = 0;

        String[] entradaPesquisa = new String[5000];
        int numEntradaPesquisa = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;

            while((line = br.readLine()) != null && !line.equals("FIM") && line != null) {
                //System.out.println(line);
                entrada[numEntrada] = line;
                numEntrada++;

            }

            while((line = br.readLine()) != null && !line.equals("FIM") && line != null) {
                //System.out.println(line);
                entradaPesquisa[numEntradaPesquisa] = line;
                numEntradaPesquisa++;

            }

        } catch(IOException e) {
            System.out.println(e);

        }
        //================================================================================================================

        //Leitura do CSV =================================================================================================

        //ArrayList de personagens para realizar leitura
        ArrayList<Personagem> personagens = new ArrayList<Personagem>();
        
        //oficial.
        personagens = Personagem.ler("/tmp/characters.csv");

        //para testes.
        //personagens = Personagem.ler("C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv");

        //================================================================================================================

        //Geração da Saída ===============================================================================================
        
        //criação da árvore de árvores.
        ArvoreDeArvore arvore = new ArvoreDeArvore();

        int[] base = {7, 3, 11, 1, 5, 9, 13, 0, 2, 4, 6, 8, 10, 12, 14};
        for(int i = 0; i < base.length; i++) {
            arvore.inserirBase(base[i]);

        }

        for(int i = 0; i < numEntrada; i++) {
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], personagens);

            //System.out.println("INSERINDO: " + personagem.getName());
            arvore.inserir(personagem);

        }

        for(int i = 0; i < numEntradaPesquisa; i++) {
            //System.out.println("PESQUISANDO: " + entradaPesquisa[i]);
            System.out.print(entradaPesquisa[i] + " => raiz");
            System.out.println((arvore.pesquisar(entradaPesquisa[i]) ? " SIM": " NAO"));

        }


    }
    
}
