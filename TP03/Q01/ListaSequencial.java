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

public class ListaSequencial{
    private Personagem[] lista;
    private int elementos;

    public Personagem[] getLista() {
        return lista;
    }

    public void setLista(Personagem[] lista) {
        this.lista = lista;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public ListaSequencial(){
        this(10);

    }

    public ListaSequencial(int tamanho){
        this.setLista(new Personagem[tamanho]);
        this.setElementos(0);

    }

    public void inserirInicio(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Personagem NULO!!!");

        } else if(this.getElementos() == this.getLista().length){
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Lista Cheia!!!");

        } else if(this.getElementos() == 0){
            this.getLista()[0] = personagem;
            
        } else {
            for(int i = this.getElementos(); i >= 0; i--){
                this.getLista()[i+1] = this.getLista()[i];

            }

            this.getLista()[0] = personagem;
            this.setElementos(this.getElementos() + 1);

        }

    }

    public void inserir(Personagem personagem, int posicao) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR! Personagem NULO!!!");

        } else if(this.getElementos() == this.getLista().length){
            throw new Exception("ERRO AO INSERIR! Lista Cheia!!!");

        } else if(posicao > this.getElementos() || posicao < 0){
            throw new Exception("ERRO AO INSERIR! Posição Inválida!!!");
            
        } else {
            for(int i = this.getElementos(); i >= posicao; i--){
                this.getLista()[i+1] = this.getLista()[i];

            }

            this.getLista()[posicao] = personagem;
            this.setElementos(this.getElementos() + 1);

        }

    }

    public void inserirFim(Personagem personagem) throws Exception{
        if(personagem == null) {
            throw new Exception("ERRO AO INSERIR! Personagem NULO!!!");

        } else if(this.getElementos() == this.getLista().length) {
            throw new Exception("ERRO AO INSERIR! Lista Cheia!!!");

        } else {
            this.getLista()[this.getElementos()] = personagem;
            this.setElementos(this.getElementos() + 1);

        }

    }

    public Personagem removerInicio() throws Exception{
        if(this.getElementos() == 0) {
            throw new Exception("ERRO AO REMOVER (INÍCIO)! Lista Vazia!!!");

        } else {
            Personagem resp = this.getLista()[0];
            for(int i = 0; i < this.getElementos(); i++){
                this.getLista()[i] = this.getLista()[i + 1];

            }

            this.setElementos(this.getElementos() - 1);

            return resp;

        }

    }

    public Personagem remover(int posicao) throws Exception{
        if(this.getElementos() == 0) {
            throw new Exception("ERRO AO REMOVER! Lista Vazia!!!");

        } else if(posicao > this.getElementos()) {
            throw new Exception("ERRO AO REMOVER! Posição Inválida!!!");

        } else {
            Personagem resp = this.getLista()[posicao];
            for(int i = posicao; i < this.getElementos(); i++){
                this.getLista()[i] = this.getLista()[i + 1];

            }

            this.setElementos(this.getElementos() - 1);

            return resp;

        }

    }

    public Personagem removerFim() throws Exception{
        if(this.getElementos() == 0) {
            throw new Exception("ERRO AO REMOVER! Lista Vazia!!!");

        } else {
            Personagem resp = this.getLista()[this.getElementos() - 1];
            this.setElementos(this.getElementos() - 1);
            return resp;

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

        //criação da lista sequencial de personagens.
        ListaSequencial lista = new ListaSequencial(1000);

        //array para armazenar personagens removidos e inteiros para administrar array.
        String[] removidos = new String[1000];
        int numRemovidos = 0;
        
        //usar a ID da entrada para preencher a lista sequencial usando o método pesquisarPorID(), que retorna um objeto do tipo personagem.
        for(int i = 0; i < numEntrada; i++){
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], array);

            lista.inserirFim(personagem);

        }

        //realização das operações.
        for(int i = 0; i < numOperacoes; i++){
            String[] splits = operacoes[i].split(" ");

            if(splits[0].equals("II")) {
                Personagem personagem = Personagem.pesquisarPorID(splits[1], array);

                lista.inserirInicio(personagem);

            } else if(splits[0].equals("IF")) {
                Personagem personagem = Personagem.pesquisarPorID(splits[1], array);

                lista.inserirFim(personagem);

            } else if(splits[0].equals("I*")) {
                Personagem personagem = Personagem.pesquisarPorID(splits[2], array);

                lista.inserir(personagem, Integer.parseInt(splits[1]));

            } else if(splits[0].equals("RI")) {
                removidos[numRemovidos] = lista.removerInicio().getName();
                numRemovidos++;

            } else if(splits[0].equals("RF")) {
                removidos[numRemovidos] = lista.removerFim().getName();
                numRemovidos++;

            } else if(splits[0].equals("R*")) {
                removidos[numRemovidos] = lista.remover(Integer.parseInt(splits[1])).getName();
                numRemovidos++;

            }

        }

        //printar nomes dos personagens removidos.
        for(int i = 0; i < numRemovidos; i++){
            System.out.println("(R) " + removidos[i]);

        }

        //printar personagens
        for(int i = 0; i < lista.elementos; i++){
            System.out.print("[" + i + " ##");
            lista.getLista()[i].print();

        }


    }

}



