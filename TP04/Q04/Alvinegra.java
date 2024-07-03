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

class No {
    private Personagem personagem;
    public No esq, dir;
    private boolean cor;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
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

    public boolean isCor() {
        return cor;
    }

    public void setCor(boolean cor) {
        this.cor = cor;
    }

    public No() {
        this(new Personagem());

    }

    public No(Personagem personagem) {
        this(personagem, false, null, null);

    }

    public No(Personagem personagem, boolean cor) {
        this(personagem, cor, null, null);

    }

    public No(Personagem personagem, boolean cor, No esq, No dir) {
        this.personagem = personagem;
        this.cor = cor;
        this.esq = esq;
        this.dir = dir;

    }

}

public class Alvinegra {
    private No raiz;

    public No getRaiz() {
        return raiz;
    }

    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public Alvinegra(){
        this.raiz = null;

    }

    public void inserir(Personagem personagem) throws Exception {
        if(raiz == null) {
            //System.out.println("INSERINDO NA RAIZ: " + personagem.getName());
            raiz = new No(personagem);

        } else if(raiz.getEsq() == null && raiz.getDir() == null) {
            if(personagem.getName().compareTo(raiz.getPersonagem().getName()) < 0) {
                //System.out.println("INSERINDO NA ESQUERDA DA RAIZ: " + personagem.getName());
                raiz.setEsq(new No(personagem));

            } else {
                raiz.setDir(new No(personagem));

            }
            
        
        } else if(raiz.getEsq() == null) {
            //System.out.println("INSERINDO NA ESQUERDA DA RAIZ (COM FILHO À DIREITA): " + personagem.getName());
            if(personagem.getName().compareTo(raiz.getPersonagem().getName()) < 0) {
                raiz.setEsq(new No(personagem));
    
            } else if(personagem.getName().compareTo(raiz.getDir().getPersonagem().getName()) < 0) {
                raiz.setEsq(new No(raiz.getPersonagem()));
                raiz.setPersonagem(personagem);
    
            } else {
                raiz.setEsq(new No(raiz.getPersonagem()));
                raiz.setPersonagem(raiz.getDir().getPersonagem());
                raiz.getDir().setPersonagem(personagem);
    
            }
    
            raiz.getEsq().setCor(false);
            raiz.getDir().setCor(false);
    
        } else if(raiz.getDir() == null) {
            //System.out.println("INSERINDO NA DIREITA DA RAIZ (COM FILHO À ESQUERDA): " + personagem.getName());
            if(personagem.getName().compareTo(raiz.getPersonagem().getName()) > 0) {
                raiz.setDir(new No(personagem));
    
            } else if(personagem.getName().compareTo(raiz.getEsq().getPersonagem().getName()) > 0) {
                raiz.setDir(new No(raiz.getPersonagem()));
                raiz.setPersonagem(personagem);
    
            } else {
                raiz.setDir(new No(raiz.getPersonagem()));
                raiz.setPersonagem(raiz.getEsq().getPersonagem());
                raiz.getEsq().setPersonagem(personagem);
    
            }
    
            raiz.getEsq().setCor(false);
            raiz.getDir().setCor(false);
    
        } else {
            //System.out.println("CHAMANDO INSERIR RECURSIVO");
            inserir(personagem, null, null, null, raiz);

        }

        raiz.setCor(false);

    }

    private void inserir(Personagem personagem, No bisavo, No avo, No pai, No i) throws Exception {
        if(i == null) {
            if(personagem.getName().compareTo(pai.getPersonagem().getName()) < 0) {
                i = pai.esq = new No(personagem, true);

            } else {
                i = pai.dir = new No(personagem, true);

            }
            
            if(pai.isCor() == true) {
                balancear(bisavo, avo, pai, i);

            }

        } else {
            if(i.esq != null && i.dir != null && i.esq.isCor() == true && i.dir.isCor() == true) {
                i.setCor(true);
                i.esq.setCor(false);
                i.dir.setCor(false);
                if(i == raiz) {
                    i.setCor(false);

                } else if(pai.isCor() == true) {
                    balancear(bisavo, avo, pai, i);

                }
            }

            if(personagem.getName().compareTo(i.getPersonagem().getName()) < 0) {
                //System.out.println("CHAMANDO INSERIR RECURSIVO PARA A ESQUERDA COM: " + personagem + ", " + avo + ", " + pai + ", " + i + ", " + i.esq);
                inserir(personagem, avo, pai, i, i.esq);

            } else if(personagem.getName().compareTo(i.getPersonagem().getName()) > 0) {
                inserir(personagem, avo, pai, i, i.dir);

            } else {
                throw new Exception("ERRO AO INSERIR! Personagem Repetido!!!");

            }

        }

    }

    public boolean pesquisar(String name) throws Exception{
        if(name == null || name.isEmpty()) {
            throw new Exception("ERRO AO PESQUISAR! Nome Nulo!!!");

        } else {
            return pesquisar(name, this.raiz);

        }

    }

    private boolean pesquisar(String name, No i) {
        boolean resp = false;
        if(i != null) {
            if(name.equals(i.getPersonagem().getName())) {
                resp = true;
        
            }  else if(name.compareTo(i.getPersonagem().getName()) < 0){
                System.out.print(" esq");
                resp = pesquisar(name, i.getEsq());
        
            } else {
                System.out.print(" dir");
                resp = pesquisar(name, i.getDir());
        
            }

        }
        
        return resp;

    }

    public void mostrar() {
        if(this.raiz != null) {
            mostrar(this.raiz);

        }

    }

    private void mostrar(No i) {
        if(i != null) {
            System.out.println(i.getPersonagem().getName());
            mostrar(i.getEsq());
            mostrar(i.getDir());

        }

    }

    private void balancear(No bisavo, No avo, No pai, No i) {
        //System.out.println("BALANCEANDO");
        if(pai.isCor()) {
            if(pai.getPersonagem().getName().compareTo(avo.getPersonagem().getName()) > 0) {
                if(i.getPersonagem().getName().compareTo(pai.getPersonagem().getName()) > 0) {
                    if(avo != null) {
                        avo = rotacaoEsq(avo);
                    }

                } else {
                    if(avo != null) {
                        avo = rotacaoDirEsq(avo);
                    }

                }

            } else {
                if(i.getPersonagem().getName().compareTo(pai.getPersonagem().getName()) < 0) {
                    avo = rotacaoDir(avo);


                } else {
                    if(avo != null) {
                        avo = rotacaoEsqDir(avo);

                    }

                }

            }

            if(bisavo == null) {
                raiz = avo;

            } else if (avo.getPersonagem().getName().compareTo(bisavo.getPersonagem().getName()) < 0) {
                bisavo.esq = avo;

            } else {
                bisavo.dir = avo;

            }
            
            if(avo != null) {
                avo.setCor(false);
                avo.getEsq().setCor(true);
                avo.getDir().setCor(true);

            }

        }

    }

    private No rotacaoDir(No no) {
        No noEsq = no.esq;
        No noEsqDir = noEsq.dir;

        noEsq.dir = no;
        no.esq = noEsqDir;

        return noEsq;

    }
    
    private No rotacaoEsq(No no) {
        No noDir = no.dir;
        No noDirEsq = noDir.esq;

        noDir.esq = no;
        no.dir = noDirEsq;

        return noDir;

    }

    private No rotacaoDirEsq(No no) {
        no.dir = rotacaoDir(no.dir);
        return rotacaoEsq(no);

    }

    private No rotacaoEsqDir(No no) {
        no.esq = rotacaoEsq(no.esq);
        return rotacaoDir(no);

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

        Alvinegra arvore = new Alvinegra();
        
        for(int i = 0; i < numEntrada; i++) {
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], personagens);

            //System.out.println("INSERINDO: " + personagem.getName());
            arvore.inserir(personagem);

        }

        //arvore.mostrar();

        for(int i = 0; i < numEntradaPesquisa; i++) {
            //System.out.println("PESQUISANDO: " + entradaPesquisa[i]);
            System.out.print(entradaPesquisa[i] + " => raiz");
            System.out.println((arvore.pesquisar(entradaPesquisa[i])) ? " SIM": " NAO");

        }


    }
    
}
