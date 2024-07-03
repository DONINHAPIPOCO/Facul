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
        System.out.print("[" + this.getId() + " ## " + this.getName() + " ## {"); 

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

class CelulaDupla{
    private Personagem elemento;
    private CelulaDupla prox, ant;

    public Personagem getElemento() {
        return elemento;
    }

    public void setElemento(Personagem elemento) {
        this.elemento = elemento;
    }

    public CelulaDupla getProx() {
        return prox;
    }

    public void setProx(CelulaDupla prox) {
        this.prox = prox;
    }

    public CelulaDupla getAnt() {
        return ant;
    }

    public void setAnt(CelulaDupla ant) {
        this.ant = ant;
    }

    public CelulaDupla(){
        this(new Personagem());

    }

    public CelulaDupla(Personagem elemento){
        this.setElemento(elemento);
        this.setProx(null);
        this.setAnt(null);

    }
    
}

public class ListaDupla{
    private CelulaDupla primeiro, ultimo;
    private int elementos;

    public CelulaDupla getPrimeiro() {
        return primeiro;
    }

    public void setPrimeiro(CelulaDupla primeiro) {
        this.primeiro = primeiro;
    }

    public CelulaDupla getUltimo() {
        return ultimo;
    }

    public void setUltimo(CelulaDupla ultimo) {
        this.ultimo = ultimo;
    }

    public int getElementos() {
        return elementos;
    }

    public void setElementos(int elementos) {
        this.elementos = elementos;
    }

    public ListaDupla(){
        this.setPrimeiro(new CelulaDupla());
        this.setUltimo(this.getPrimeiro());
        this.setElementos(0);

    }

    public void inserirInicio(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Personagem NULO!!!");

        } else {
            CelulaDupla tmp = new CelulaDupla(personagem);
            tmp.setProx(primeiro.getProx());
            this.primeiro.setProx(tmp);
            tmp.getProx().setAnt(tmp);
            tmp.setAnt(primeiro);
            tmp = null;

            this.setElementos(this.getElementos() + 1);

        }
        

    }

    public void inserirFim(Personagem personagem) throws Exception{
        if(personagem == null){
            throw new Exception("ERRO AO INSERIR (FIM)! Personagem NULO!!!");

        } else {
            CelulaDupla tmp = new CelulaDupla(personagem);
            tmp.setAnt(ultimo);
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
            CelulaDupla tmp = new CelulaDupla(personagem);

            CelulaDupla pos = this.getPrimeiro().getProx();
            for(int i = 1; i < posicao; i++, pos = pos.getProx());
            
            tmp.setProx(pos.getProx());
            tmp.setAnt(pos);
            tmp.getProx().setAnt(tmp);
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
            Personagem removido = this.getPrimeiro().getProx().getElemento();

            CelulaDupla tmp = this.getPrimeiro();
            this.setPrimeiro(this.getPrimeiro().getProx());
            this.getPrimeiro().setAnt(null);
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
            Personagem removido = this.getUltimo().getElemento();
            
            CelulaDupla tmp = this.getUltimo();
            
            this.setUltimo(this.getUltimo().getAnt());
            this.getUltimo().setProx(null);
            tmp.setAnt(null);
            tmp = null;
            
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
            CelulaDupla tmp = this.getPrimeiro().getProx();
            for(int i = 1; i < posicao; i++, tmp = tmp.getProx());

            Personagem removido = tmp.getProx().getElemento();

            CelulaDupla aux = tmp.getProx();
            tmp.setProx(aux.getProx());
            tmp.getProx().setAnt(tmp);
            aux.setProx(null);
            aux.setAnt(null);

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
            for(CelulaDupla i = this.getPrimeiro().getProx(); i != null; i= i.getProx(), j++){
                System.out.println("(" + j + ") " + i.getElemento().getName());

            }

        }

    }

    public void quicksort() throws Exception {
        if (this.getPrimeiro() == this.getUltimo()) {
            throw new Exception("ERRO NO QUICKSORT! Lista Vazia!!!");

        } else {
            quicksort(this.getPrimeiro().getProx(), this.getUltimo());

        }
    }
    
    private void quicksort(CelulaDupla esq, CelulaDupla dir) {
        if (esq != dir && esq != dir.getProx()) {
            CelulaDupla pivo = partition(esq, dir);
            if (pivo != esq) quicksort(esq, pivo.getAnt());
            if (pivo != dir) quicksort(pivo.getProx(), dir);

        }

    }
    
    private CelulaDupla partition(CelulaDupla esq, CelulaDupla dir) {
        Personagem pivo = dir.getElemento();
        CelulaDupla i = esq.getAnt();

        for (CelulaDupla j = esq; j != dir; j = j.getProx()) {
            if (j.getElemento().getHouse().compareTo(pivo.getHouse()) < 0) {
                i = (i == null) ? esq : i.getProx();
                swap(i, j);

            } else if(j.getElemento().getHouse().compareTo(pivo.getHouse()) == 0) {
                if(j.getElemento().getName().compareTo(pivo.getName()) < 0){
                    i = (i == null) ? esq : i.getProx();
                    swap(i, j);

                }

            }

        }

        i = (i == null) ? esq : i.getProx();
        swap(i, dir);
        return i;

    }
    
    private void swap(CelulaDupla a, CelulaDupla b) {
        Personagem temp = a.getElemento();
        a.setElemento(b.getElemento());
        b.setElemento(temp);
        
    }


    public static void main(String[] args) throws Exception{
        String[] entrada = new String[5000];
        int numEntrada = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;

            //Ler cada linha enquanto existirem linhas e enquanto a linha não for igual a "FIM", e armazenando seus conteúdos no array de entrada.
            while((line = br.readLine()) != null && !line.equals("FIM")){
                entrada[numEntrada] = line;
                numEntrada++;

            }


        } catch(IOException e){
            System.out.println(e);

        }

        //para Windows:
        //ArrayList<Personagem> array = Personagem.ler("C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv");

        //para Linux:
        ArrayList<Personagem> array = Personagem.ler("/tmp/characters.csv");

        //criação da lista Flexivel de personagens.
        ListaDupla lista = new ListaDupla();
        
        //usar a ID da entrada para preencher a lista Flexivel usando o método pesquisarPorID(), que retorna um objeto do tipo personagem.
        for(int i = 0; i < numEntrada; i++){
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], array);

            lista.inserirFim(personagem);

        }

        lista.quicksort();

        int j = 0;
        //printar personagens
        for(CelulaDupla i = lista.getPrimeiro().getProx(); i != null; j++, i = i.getProx()){
            i.getElemento().print();

        }


    }

}