import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

    public void setDateOfBirth(Date date) {
        this.dateOfBirth = date;
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

class CelulaMatrizFlexivel{
    private int elemento;
    private CelulaMatrizFlexivel sup, inf, esq, dir;

    public int getElemento() {
        return elemento;
    }

    public void setElemento(int elemento) {
        this.elemento = elemento;
    }

    public CelulaMatrizFlexivel getDir() {
        return dir;
    }

    public void setDir(CelulaMatrizFlexivel dir) {
        this.dir = dir;
    }

    public CelulaMatrizFlexivel getEsq() {
        return esq;
    }

    public void setEsq(CelulaMatrizFlexivel esq) {
        this.esq = esq;
    }

    public CelulaMatrizFlexivel getInf() {
        return inf;
    }

    public void setInf(CelulaMatrizFlexivel inf) {
        this.inf = inf;
    }

    public CelulaMatrizFlexivel getSup() {
        return sup;
    }

    public void setSup(CelulaMatrizFlexivel sup) {
        this.sup = sup;
    }
    
    public CelulaMatrizFlexivel(){
        this(0);

    }

    public CelulaMatrizFlexivel(int elemento){
        this.setElemento(elemento);
        this.setSup(null);
        this.setInf(null);
        this.setEsq(null);
        this.setDir(null);

    }

}

public class MatrizFlexivel{
    private CelulaMatrizFlexivel inicio;
    private int linha, coluna;

    public CelulaMatrizFlexivel getInicio() {
        return inicio;
    }

    public void setInicio(CelulaMatrizFlexivel inicio) {
        this.inicio = inicio;
    }

    public int getLinha() {
        return linha;
    }

    public void setLinha(int linha) {
        this.linha = linha;
    }

    public int getColuna() {
        return coluna;
    }

    public void setColuna(int coluna) {
        this.coluna = coluna;
    }

    public MatrizFlexivel(){
        this(3, 3);

    }

    public MatrizFlexivel(int linhas, int colunas){
        this.setInicio(new CelulaMatrizFlexivel());
        this.setLinha(linhas);
        this.setColuna(colunas);
        CelulaMatrizFlexivel atual = inicio;
        
        //primeira linha
        for (int col = 1; col < colunas; col++) {
            atual.setDir(new CelulaMatrizFlexivel());
            atual.getDir().setEsq(atual);
            atual = atual.getDir();
        }
        
        // Criando as demais linhas
        CelulaMatrizFlexivel anteriorLinhas = this.getInicio();
        for (int linha = 1; linha < linhas; linha++) {
            atual = anteriorLinhas;
            CelulaMatrizFlexivel linhaSuperior = anteriorLinhas;

            // Criando a primeira célula da linha atual
            anteriorLinhas.setInf(new CelulaMatrizFlexivel());
            anteriorLinhas.getInf().setSup(anteriorLinhas);
            anteriorLinhas = anteriorLinhas.getInf();
            atual = anteriorLinhas;

            // Criando as demais células da linha atual
            for (int col = 1; col < colunas; col++) {
                atual.setDir(new CelulaMatrizFlexivel());
                atual.getDir().setEsq(atual);
                atual = atual.getDir();

                linhaSuperior = linhaSuperior.getDir();
                atual.setSup(linhaSuperior);
                linhaSuperior.setInf(atual);

            }

        }

    }

    public MatrizFlexivel soma(MatrizFlexivel matriz1, MatrizFlexivel matriz2){
        MatrizFlexivel resp = new MatrizFlexivel(matriz1.getLinha(), matriz1.getColuna());
        CelulaMatrizFlexivel linhasResp = resp.getInicio();
        CelulaMatrizFlexivel colsResp = resp.getInicio();

        CelulaMatrizFlexivel linhasMat2 = matriz2.getInicio();
        CelulaMatrizFlexivel colsMat2 = matriz2.getInicio();

        for(CelulaMatrizFlexivel linhasMat1 = matriz1.getInicio(); linhasMat1 != null; linhasMat1 = linhasMat1.getInf(), linhasResp = linhasResp.getInf(), linhasMat2 = linhasMat2.getInf()){
            colsMat2 = linhasMat2;
            colsResp = linhasResp;
            for(CelulaMatrizFlexivel colsMat1 = linhasMat1; colsMat1 != null; colsMat1 = colsMat1.getDir(), colsResp = colsResp.getDir(), colsMat2 = colsMat2.getDir()){
                colsResp.setElemento(colsMat1.getElemento() + colsMat2.getElemento());

            }

        }

        return resp;

    }

    public static int somaLinha(CelulaMatrizFlexivel i){
        int resp = 0;

        for(; i != null; i = i.getDir()){
            resp += i.getElemento();

        }

        return resp;

    }

    public static int somaColuna(CelulaMatrizFlexivel j){
        int resp = 0;

        for(; j != null; j = j.getInf()){
            resp += j.getElemento();

        }

        return resp;

    }

    public MatrizFlexivel multiplicacao(MatrizFlexivel matriz1, MatrizFlexivel matriz2) throws Exception{
        if(matriz1.getLinha() == matriz2.getColuna() || matriz1.getColuna() == matriz2.getLinha()) {
            MatrizFlexivel resp = new MatrizFlexivel(matriz1.getLinha(), matriz2.getColuna());

            CelulaMatrizFlexivel mat1 = matriz1.getInicio();

            CelulaMatrizFlexivel mat2 = matriz2.getInicio();

            for(CelulaMatrizFlexivel linhasResp = resp.getInicio(); linhasResp != null; linhasResp = linhasResp.getInf()){
                for(CelulaMatrizFlexivel colsResp = linhasResp; colsResp != null; colsResp = colsResp.getDir()){
                    colsResp.setElemento((somaLinha(mat1) * somaColuna(mat2)));
                    mat2 = mat2.getDir();

                }                

                mat1 = mat1.getInf();

            }

            return resp;

        } else {
            throw new Exception("NÃO É POSSIVEL MULTIPLICAR ESSAS MATRIZES!");

        }

    }

    public String diagPrincipal(MatrizFlexivel matriz){
        String resp = "";

        for(CelulaMatrizFlexivel i = matriz.getInicio(); i != null; i = i.getDir().getInf()){
            resp += (Integer.toString(i.getElemento()) + " ");

        }

        return resp;

    }

    public String diagSecundaria(MatrizFlexivel matriz){
        String resp = "";

        CelulaMatrizFlexivel i = matriz.getInicio();
        for(; i.getDir() != null; i = i.getDir());

        for(; i != null; i = i.getEsq().getInf()){
            resp += (Integer.toString(i.getElemento()) + " ");

        }

        return resp;

    }

    public static void main(String[] args){
        

    }

}