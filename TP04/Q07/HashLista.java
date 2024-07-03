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

class Celula {
    private Personagem personagem;
    private Celula prox;

    public Personagem getPersonagem() {
        return personagem;
    }
    
    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
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

    public Celula(Personagem personagem){
        this.personagem = personagem;
        this.prox = null;

    }

}

class ListaFlexivel{
    private Celula primeiro, ultimo;
    private int elementos;

    public Celula getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(Celula primeiro) {
        this.primeiro = primeiro;
    }

    public Celula getUltimo() {
        return ultimo;
    }

    public void setUltimo(Celula ultimo) {
        this.ultimo = ultimo;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public ListaFlexivel(){
        this.setPrimeiro(new Celula());
        this.setUltimo(this.getPrimeiro());
        this.setElementos(0);

    }

    public void inserirInicio(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Personagem NULO!!!");

        } else {
            Celula tmp = new Celula(personagem);
            tmp.setProx(primeiro.getProx());
            this.primeiro.setProx(tmp);
            tmp = null;

            this.setElementos(this.getElementos() + 1);

        }
        

    }

    public void inserirFim(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (FIM)! Personagem NULO!!!");

        } else {
            Celula tmp = new Celula(personagem);
            this.ultimo.setProx(tmp);
            this.setUltimo(this.ultimo.getProx());
            tmp = null;

            this.setElementos(this.getElementos() + 1);

        }
        

    }

    public void inserir(Personagem personagem, int posicao) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Personagem NULO!!!");

        } else {
            Celula tmp = new Celula(personagem);

            Celula pos = this.getPrimeiro().getProx();
            for(int i = 1; i < posicao; i++, pos = pos.getProx());
            
            tmp.setProx(pos.getProx());
            pos.setProx(tmp);
            
            tmp = null;
            pos = null;

            this.setElementos(this.getElementos() + 1);

        }
        

    }

    public Personagem removerInicio() throws Exception{
        if(this.getPrimeiro() == this.getUltimo()){
            throw new Exception("ERRO AO REMOVER! Lista Vazia!!!");

        } else {
            Personagem removido = this.getPrimeiro().getProx().getPersonagem();

            Celula tmp = this.getPrimeiro();
            this.setPrimeiro(this.getPrimeiro().getProx());
            tmp.setProx(null);
            tmp = null;

            this.setElementos(this.getElementos() - 1);

            return removido;

        }

    }

    public Personagem removerFim() throws Exception{
        if(this.getPrimeiro() == this.getUltimo()){
            throw new Exception("ERRO AO REMOVER! Lista Vazia!!!");

        } else {
            Personagem removido = this.getUltimo().getPersonagem();
            
            Celula tmp = this.getPrimeiro().getProx();
            for(; tmp.getProx() != this.getUltimo(); tmp = tmp.getProx());

            this.setUltimo(tmp);
            this.getUltimo().setProx(null);
            
            this.setElementos(this.getElementos() - 1);

            return removido;

        }

    }

    public Personagem remover(int posicao) throws Exception{
        if(this.getPrimeiro() == this.getUltimo()) {
            throw new Exception("ERRO AO REMOVER! Lista Vazia!!!");

        } if(posicao > this.getElementos()){
            throw new Exception("ERRO AO REMOVER! Posicao Inexistente!!!");

        } else {
            Celula tmp = this.getPrimeiro().getProx();
            for(int i = 1; i < posicao; i++, tmp = tmp.getProx());

            Personagem removido = tmp.getProx().getPersonagem();

            Celula aux = tmp.getProx();
            tmp.setProx(aux.getProx());
            aux.setProx(null);

            tmp = aux = null;

            this.setElementos(this.getElementos() - 1);

            return removido;

        }

    }

    public void mostrar(){
        if(this.getPrimeiro() == this.getUltimo()){
            System.out.println("A Lista Está Vazia!");

        } else {
            int j = 0;
            for(Celula i = this.getPrimeiro().getProx(); i != null; i= i.getProx(), j++){
                System.out.println("(" + j + ") " + i.getPersonagem().getName());

            }

        }

    }
}

public class HashLista {
    private Personagem[] tabela;
    private int tamTabela;
    private int numElementos;
    private ListaFlexivel reserva;

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public Personagem[] getTabela() {
        return tabela;
    }

    public void setTabela(Personagem[] tabela) {
        this.tabela = tabela;
    }
    
    public int getTamTabela() {
        return tamTabela;
    }

    public void setTamTabela(int tamTabela) {
        this.tamTabela = tamTabela;
    }

    public ListaFlexivel getReserva() {
        return reserva;
    }

    public void setReserva(ListaFlexivel reserva) {
        this.reserva = reserva;
    }

    public HashLista(){
        this(21);

    }

    public HashLista(int tamTabela){
        this.setTabela(new Personagem[tamTabela]);
        this.setTamTabela(tamTabela);
        this.setNumElementos(0);
        for(int i = 0; i < tamTabela; i++){
            this.getTabela()[i] = null;

        }
        this.setReserva(new ListaFlexivel());

    }

    public int h(String name){
        int resp = 0;
        for(int i = 0; i < name.length(); i++) {
            resp += (int) name.charAt(i);

        }

        return (resp % this.getTamTabela());

    }

    public void sort() {
        if(this.reserva.getPrimeiro() != this.reserva.getUltimo()) {
            Celula i = this.reserva.getPrimeiro().getProx();
            for(; i != null; i = i.getProx()){
                for(Celula j = i; j != null; j = j.getProx()) {
                    if(i.getPersonagem().getName().compareTo(j.getPersonagem().getName()) > 0) {
                        Personagem tmp = i.getPersonagem();
                        i.setPersonagem(j.getPersonagem());
                        j.setPersonagem(tmp);

                    }

                }

            }

        }

    }

    public void inserir(Personagem personagem) throws Exception{
        if(this.getNumElementos() <= this.getTamTabela()) {
            //System.out.print("INSERINDO: " + personagem.getName());
            int posicao = h(personagem.getName());
            //System.out.println(" NA POSICAO: " + Integer.toString(posicao));
            if(getTabela()[posicao] == null) {
                this.getTabela()[posicao] = personagem;
                this.setNumElementos(this.getNumElementos() + 1);

            } else {
                //System.out.println("INSERINDO: " + personagem.getName() + " NA LISTA");
                this.reserva.inserirFim(personagem);
                sort();

            }

        } else {
            throw new Exception("ERRO AO INSERIR! Tabela Cheia!!!");

        }

    }

    public String pesquisar(String name){
        String resp = "NAO";
        int posicao = h(name);
        if(this.getTabela()[posicao] != null && this.getTabela()[posicao].getName().equals(name)) {
            resp = "(pos: " + Integer.toString(posicao) + ") SIM";

        } else {
            posicao = 0;
            for(Celula i = this.reserva.getPrimeiro().getProx(); i != null; i = i.getProx(), posicao++) {
                //System.out.println("PESQUISA PASSANDO POR: " + i.getPersonagem().getName());
                if(i.getPersonagem().getName().equals(name)) {
                    resp = "(pos: " + Integer.toString(posicao) + ") SIM";

                }

            }

        }

        return resp;

    }

    public static void main(String[] args) throws Exception {
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

        ArrayList<Personagem> personagens = new ArrayList<Personagem>();
        
        //para Linux
        personagens = Personagem.ler("/tmp/characters.csv");

        //para Windows
        //personagens = Personagem.ler("C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv");

        HashLista hash = new HashLista();
        
        for(int i = 0; i < numEntrada; i++) {
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], personagens);

            //System.out.println("INSERINDO: " + personagem.getName());
            hash.inserir(personagem);

        }

        for(int i = 0; i < numEntradaPesquisa; i++) {
            //System.out.println("PESQUISANDO: " + entradaPesquisa[i]);
            System.out.println(entradaPesquisa[i] + " " + hash.pesquisar(entradaPesquisa[i]));

        }


    }

}