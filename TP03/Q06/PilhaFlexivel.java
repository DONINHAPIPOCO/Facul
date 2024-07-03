import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

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
        System.out.print(" " + this.getId() + " ## " + this.getName() + " ## {"); 

        for(int i = 0; i < this.getAlternate_names().length; i++){
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("[", "");
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("]", "");
            this.getAlternate_names()[i] = this.getAlternate_names()[i].replace("'", "");
            System.out.print(this.getAlternate_names()[i]);
            if (i < this.getAlternate_names().length - 1) {
                System.out.print(",");

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
            if(array.get(i).getId().equals(id)){
                resp = array.get(i);

            }

        }

        return resp;

    }

}

class Celula{
    private Personagem elemento;
    private Celula prox;

    public Personagem getElemento() {
        return elemento;
    }

    public void setElemento(Personagem elemento) {
        this.elemento = elemento;
    }

    public Celula getProx() {
        return prox;
    }

    public void setProx(Celula prox) {
        this.prox = prox;
    }

    public Celula(){
        this(new Personagem());

    }

    public Celula(Personagem elemento){
        this.setElemento(elemento);
        this.setProx(null);

    }
    
}

public class PilhaFlexivel{
    private Celula topo;
    private int elementos;

    public Celula getTopo() {
        return topo;
    }

    public void setTopo(Celula topo) {
        this.topo = topo;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public PilhaFlexivel(){
        this.setTopo(null);
        this.setElementos(0);

    }

    public void push(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR! Personagem NULO!!!");

        } else if(this.getTopo() == null){
            this.setTopo(new Celula(personagem));

        } else {
            Celula tmp = new Celula(personagem);

            tmp.setProx(this.getTopo());
            this.setTopo(tmp);
            tmp = null;

            this.setElementos(this.getElementos() + 1);

        }
        

    }

    public Personagem pop() throws Exception{
        if(this.getTopo() == null){
            throw new Exception("ERRO AO REMOVER! Pilha Vazia!!!");

        } else {
            Personagem removido = this.getTopo().getElemento();

            Celula tmp = this.getTopo();
            this.setTopo(this.getTopo().getProx());
            tmp.setProx(null);
            tmp = null;

            this.setElementos(this.getElementos() - 1);

            return removido;

        }

    }

    public void mostrar(){
        if(this.getTopo() == null){
            System.out.println("A pilha Está Vazia!");

        } else {
            System.out.println("[ Top ]");
            int j = 0;
        //printar personagens
        for(Celula i = this.getTopo(); i != null; j++, i = i.getProx()){
            System.out.print("[" + j + " ##");
            i.getElemento().print();

        }
            System.out.println("[ Bottom ]");

        }

    }


    public static void main(String[] args) throws Exception{
        String[] entrada = new String[5000];
        String[] operacoes = new String[5000];
        int numEntrada = 0, numOperacoes = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;

            //Ler cada linha enquanto existirem linhas e enquanto a linha não for igual a "FIM", e armazenando seus conteúdos no array de entrada.
            while((line = br.readLine()) != null && !line.equals("FIM")){
                entrada[numEntrada] = line;
                numEntrada++;

            }

            //pular linha contendo o numero de operações (não é necessário).
            line = br.readLine();

            //lê até o fim do arquivo registrando as operações em um array separado.
            while((line = br.readLine()) != null){
                operacoes[numOperacoes] = line;
                numOperacoes++;

            }


        } catch(IOException e){
            System.out.println(e);

        }

        //para Windows:
        //ArrayList<Personagem> array = Personagem.ler("C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv");

        //para Linux:
        ArrayList<Personagem> array = Personagem.ler("/tmp/characters.csv");

        //criação da pilha Flexivel de personagens.
        PilhaFlexivel pilha = new PilhaFlexivel();

        //array para armazenar personagens removidos e inteiros para administrar array.
        String[] removidos = new String[1000];
        int numRemovidos = 0;
        
        //usar a ID da entrada para preencher a pilha Flexivel usando o método pesquisarPorID(), que retorna um objeto do tipo personagem.
        for(int i = 0; i < numEntrada; i++){
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], array);

            pilha.push(personagem);

        }

        //realização das operações.
        for(int i = 0; i < numOperacoes; i++){
            String[] splits = operacoes[i].split(" ");

            if(splits[0].equals("I")) {
                Personagem personagem = Personagem.pesquisarPorID(splits[1], array);

                pilha.push(personagem);

            } else if(splits[0].equals("R")) {
                removidos[numRemovidos] = pilha.pop().getName();
                numRemovidos++;

            }

        }

        //printar nomes dos personagens removidos.
        for(int i = 0; i < numRemovidos; i++){
            System.out.println("(R) " + removidos[i]);

        }

        pilha.mostrar();

    }

}