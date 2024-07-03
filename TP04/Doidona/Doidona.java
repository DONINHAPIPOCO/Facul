import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


/*
 * Class Personagem - Classe que será usada para gerar os objetos de Personagens que serão manipulados
 * @author Luis Felipe Souza Lopes - 654663
 */
class Personagem{
    //ATRIBUTOS ============================
    private String id;
    private String name;
    private String[] alternate_names;
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
    //======================================

    //GETS E SETS ==========================
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
    //===============================================
    

    //CONSTRUTORES E CLONE ====================================================================================================================================================
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

    /*
     * Método publico que cria um clone do objeto recebido.
     * @param personagem Personagem a ser clonado.
     * @return clone O clone do personagem recebido.
     * @author Luis Felipe Souza Lopes.
     * 
     */
    public static Personagem clone(Personagem personagem){
        Personagem clone = new Personagem(personagem.getId(), personagem.getName(), personagem.getAlternate_names(), 
        personagem.getHouse(), personagem.getAncestry(), personagem.getSpecies(), 
        personagem.getPatronus(), personagem.isHogwartsStaff(), personagem.isHogwartsStudent(), 
        personagem.getActorName(), personagem.isAlive(), personagem.getDateOfBirth(), personagem.getYearOfBirth(), personagem.getEyeColour(), 
        personagem.getGender(), personagem.getHairColour(), personagem.isWizzard());

        return clone;

    }
    //=========================================================================================================================================================================

    //MÉTODOS =================================================================================================================================================================
    
    /*
     * Método público que imprime na tela todos os elementos do array recebido.
     * @param array Array de personagens a ser mostrado na tela.
     * @author Luis Felipe Souza Lopes.
     * 
     */
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

    /*
     * Método público que imprime na tela as informações de um personagem.
     * @author Luis Felipe Souza Lopes.
     * 
     */
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

    /*
     * Método público para ler um arquivo de personagens e armazenálos em um ArrayList.
     * @param nomeArquivo Nome do arquivo a ser lido.
     * @return resp ArrayList preenchido com todos os personagens contidos no CSV recebido.
     * @author Luis Felipe Souza Lopes.
     * 
     */
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
                personagem.setAlive(splits[8].equals("VERDADEIRO") ? true : false);

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

    /*
     * Método público para pesquisar se existe um personagem com a id recebida, no array recebido.
     * @param id String contendo a id a ser pesquisada.
     * @param array Array de personagens onde a pesquisa será realizada.
     * @return resp Objeto do personagem, caso encontrado.
     * @author Luis Felipe Souza Lopes.
     * 
     */
    public static Personagem pesquisarPorID(String id, ArrayList<Personagem> array){
        Personagem resp = new Personagem();
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getId().equals(id)){
                resp = array.get(i);

            }

        }

        return resp;

    }
    //=========================================================================================================================================================================

}//fim Personagem.


/*
 * Classe HashRehash - Classe para criar e manipular tabela hash com rehash.
 * @author Luis Felipe Souza Lopes.
 */
class HashRehash {
    //ATRIBUTOS ==================
    private Personagem[] tabela;
    private int tamTabela;
    private int numElementos;
    //============================

    //GETS E SETS ======================================
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
    //=================================================

    //CONSTRUTORES ====================================
    public HashRehash(){
        this(30);

    }

    public HashRehash(int tamTabela){
        this.setTabela(new Personagem[tamTabela]);
        this.setTamTabela(tamTabela);
        this.setNumElementos(0);
        for(int i = 0; i < tamTabela; i++) {
            this.getTabela()[i] = null;

        }

    }
    //=================================================

    //FUNÇÕES DE HASH E REHASH =============================================
    
    //Ambas as funções calculam a posição com base no atributo "ano de nascimento" do personagem.
    public int h(Personagem personagem){
        return (personagem.getYearOfBirth() % this.getTamTabela());

    }

    public int reh(Personagem personagem){
        return ((personagem.getYearOfBirth() + 1) % this.getTamTabela());

    }
    //======================================================================

    //MÉTODOS ================================================================================================================================================
    
    /*
     * Método público para inserir um personagem na tabela.
     * @param personagem Personagem a ser inserido.
     * @author Luis Felipe Souza Lopes.
     * 
     */
    public void inserir(Personagem personagem) throws Exception{
        if(this.getNumElementos() < this.getTamTabela()) { //caso a tabela não esteja cheia, calcular a posição do elemento com método hash.
            int posicao = h(personagem); 
            if(getTabela()[posicao] == null) { //caso a posição esteja vaga, inserir na posicao e incrementar numero de elementos inseridos.
                this.getTabela()[posicao] = personagem;
                this.setNumElementos(this.getNumElementos() + 1);

            } else { //caso a posição esteja ocupada, calcular nova posição com método de rehash.
                posicao = reh(personagem);
                if(getTabela()[posicao] == null) { //caso a posição esteja vaga, inserir na posicao e incrementar numero de elementos inseridos.
                    this.getTabela()[posicao] = personagem;
                    this.setNumElementos(this.getNumElementos() + 1);

                } else { //caso nenhuma das posições esteja livre, aviso de que é impossível inserir.
                    throw new Exception("ERRO AO INSERIR! Não existem posições disponíveis!!!");

                }

            }

        } else { //caso a tabela esteja cheia, aviso de que é impossível inserir.
            throw new Exception("ERRO AO INSERIR! Tabela Cheia!!!");

        }

    }

    /*
     * Método público que remove um elemento da estrutura.
     * @param personagem Elemento a ser removido da tabela.
     * @return resp Booleano confirmando o sucesso da remoção.
     * @author Luis Felipe Souza Lopes.
     * 
     */
    public boolean remover(Personagem personagem) throws Exception{
        if(this.getNumElementos() > 0) { //caso a tabela não esteja vazia, calcular a posição do personagem a ser removido com método hash.
            boolean resp = false;
            int posicao = h(personagem);
            if(this.getTabela()[posicao].getId().equals(personagem.getId())) { //caso o objeto da posição seja igual ao recebido, remover, atualizar o numero de elementos e resp = true;
                resp = true;
                this.getTabela()[posicao] = null;
                this.setNumElementos(this.getNumElementos() - 1);

            } else { //caso o objeto da posicao seja diferente, calcular nova posição com rehash e comparar o personagem com o da nova posição.
                posicao = reh(personagem);
                if(this.getTabela()[posicao].getId().equals(personagem.getId())) { //caso seja o personagem correto, remover, atualizar o numero de elementos e resp para true.
                    resp = true;
                    this.getTabela()[posicao] = null;
                    this.setNumElementos(this.getNumElementos() - 1);

                }

            }

            return resp;

        } else { //aviso de erro caso tente remover de uma tabela vazia.
            throw new Exception("ERRO AO REMOVER! Tabela Vazia!!!");

        }

    }

    /*
     * Método público para pesquisar se um personagem existe na tabela.
     * @param personagem Personagem a ser pesquisado na tabela.
     * @return resp Booleano contendo true caso o elemento exista, e false caso não.
     * @author Luis Felipe Souza Lopes.
     * 
     */
    public boolean pesquisar(Personagem personagem){
        boolean resp = false;
        int posicao = h(personagem); //calcular posição primária com método de hash.
        if(this.getTabela()[posicao].getId().equals(personagem.getId())) { //caso seja o personagem procurado, atualiza resp para true.
            resp = true;

        } else { //caso seja diferente, calcular nova posição com método rehash e comparar o personagem com a nova posição
            posicao = reh(personagem);
            if(this.getTabela()[posicao].getId().equals(personagem.getId())){ //caso seja igual, atualiza resp para true.
                resp = true;

            }

        }

        return resp;

    }

}//fim HashRehash

class HashReserva {
    private Personagem[] tabela;
    private int tamTabela, tamReserva;
    private int numElementos, numReserva;

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

    public int getTamReserva() {
        return tamReserva;
    }

    public void setTamReserva(int tamReserva) {
        this.tamReserva = tamReserva;
    }

    public int getNumReserva() {
        return numReserva;
    }

    public void setNumReserva(int numReserva) {
        this.numReserva = numReserva;
    }

    public HashReserva(){
        this(30, 10);

    }

    public HashReserva(int tamTabela, int tamReserva){
        this.setTabela(new Personagem[tamTabela + tamReserva]);
        this.setTamTabela(tamTabela);
        this.setTamReserva(tamReserva);
        this.setNumElementos(0);
        for(int i = 0; i < (tamTabela + tamReserva); i++){
            this.getTabela()[i] = null;

        }

    }

    public int h(Personagem personagem){
        return (personagem.getYearOfBirth() % this.getTamTabela());

    }

    public void inserir(Personagem personagem) throws Exception{
        if(this.getNumElementos() < this.getTamTabela() || this.getNumReserva() < this.getTamReserva()) {
            int posicao = h(personagem);
            if(getTabela()[posicao] == null) {
                this.getTabela()[posicao] = personagem;
                this.setNumElementos(this.getNumElementos() + 1);

            } else {
                if(this.getNumReserva() < this.getTamReserva()) {
                    for(posicao = this.getTamTabela(); posicao < (this.getTamTabela() + this.getTamReserva()) - 1; posicao++) {
                        if(this.getTabela()[posicao] == personagem) {
                            throw new Exception("ERRO AO INSERIR! O elemento já está inserido!!!");
    
                        } else if(this.getTabela()[posicao] == null) {
                            this.getTabela()[posicao] = personagem;
                            this.setNumReserva(this.getNumReserva() + 1);
                            break;
    
                        }
    
                    }

                } else {
                    throw new Exception("ERRO AO INSERIR! Reserva Cheia!!!");

                }                    

            }

        } else {
            throw new Exception("ERRO AO INSERIR! Tabela e Reserva Cheias!!!");

        }

    }

    //para adaptar para boolean, só remover as linhas comentadas e mudar o tipo do método para boolean.
    public boolean remover(Personagem personagem) throws Exception{
        if(this.getNumElementos() > 0) {
            boolean resp = false;
            int posicao = h(personagem);
            if(this.getTabela()[posicao] == personagem) {
                resp = true;
                this.getTabela()[posicao] = null;
                this.setNumElementos(this.getNumElementos() - 1);

            } else {
                if(this.getNumReserva() < this.getTamReserva()) {
                    for(posicao = this.getTamTabela() + 1; posicao < (this.getTamTabela() + this.getNumReserva()); posicao++) {
                        if(this.getTabela()[posicao] == personagem) {
                            resp = true;
                            this.getTabela()[posicao] = this.getTabela()[this.getNumReserva()];
                            this.setNumReserva(this.getNumReserva() - 1);

                        }

                    }

                } else {
                    throw new Exception("ERRO AO REMOVER! Elemento não existe!!!");

                }

            }

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER! Tabela Vazia!!!");

        }

    }

    public boolean pesquisar(Personagem personagem){
        boolean resp = false;
        int posicao = h(personagem);
        if(this.getTabela()[posicao] == personagem) {
            resp = true;

        } else {
            for(posicao = this.getTamTabela(); posicao < (this.getTamTabela() + this.getNumReserva()); posicao++) {
                if(this.getTabela()[posicao] == personagem) {
                    resp = true;

                }

            }

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
        this.setPersonagem(personagem);
        this.setProx(null);

    }

}

class Lista{
    private Celula primeiro, ultimo;
    private int numElementos;
    
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

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public Lista(){
        this.setPrimeiro(new Celula());
        this.setUltimo(this.getPrimeiro());

    }

    public void inserirFim(Personagem personagem){
        this.getUltimo().setProx(new Celula(personagem));
        this.setUltimo(this.getUltimo().getProx());
        this.setNumElementos(this.getNumElementos() + 1);

    }

    public void inserirInicio(Personagem personagem){
        Celula tmp = new Celula(personagem);
        tmp.setProx(this.getPrimeiro().getProx());
        this.getPrimeiro().setProx(tmp);
        this.setNumElementos(this.getNumElementos() + 1);

    }

    public void inserir(Personagem personagem, int posicao) throws Exception{
        if(posicao < this.getNumElementos()) {
            Celula i = this.getPrimeiro().getProx();
            for(int j = 0; j < posicao; j++, i = i.getProx());
            Celula tmp = new Celula(personagem);
            tmp.setProx(i.getProx());
            i.setProx(tmp);
            tmp = i = null;


        } else if(posicao == this.getNumElementos()){
            this.inserirFim(personagem);

        } else if(posicao == 0) {
            this.inserirInicio(personagem);

        } else {
            throw new Exception("ERRO AO INSERIR! A posição não existe!!!");

        }

    }

    public Personagem removerInicio() throws Exception{
        if(this.getNumElementos() > 0){
            Personagem resp = this.getPrimeiro().getProx().getPersonagem();
            Celula tmp = primeiro.getProx();
            this.getPrimeiro().setProx(tmp.getProx());
            tmp.setProx(null);
            tmp = null;
            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER (INÍCIO)! Lista Vazia!!!");

        }

    }

    public Personagem removerFim() throws Exception{
        if(this.getNumElementos() > 0){
            Personagem resp = this.getUltimo().getPersonagem();
            
            Celula i = primeiro.getProx();
            for(;i.getProx() != this.getUltimo(); i = i.getProx());

            this.setUltimo(i);
            this.getUltimo().setProx(null);

            i = null;

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER (FIM)! Lista Vazia!!!");

        }

    }

    public Personagem remover(int posicao) throws Exception{
        if(this.getNumElementos() > 0){  
            Celula i = primeiro.getProx();
            for(int j = 0; j < posicao - 1; j++, i = i.getProx());

            Personagem resp = i.getProx().getPersonagem();
            Celula tmp = i.getProx();
            i.setProx(tmp.getProx());
            tmp.setProx(null);

            i = tmp = null;

            return resp;

        } else {
            throw new Exception("ERRO AO REMOVER (INÍCIO)! Lista Vazia!!!");

        }

    }

    public boolean pesquisar(Personagem personagem){
        boolean resp = false;
        for(Celula i = this.getPrimeiro().getProx(); i != null; i = i.getProx()){
            if(i.getPersonagem().getName().equals(personagem.getName())){
                resp = true;

            }

        }

        return resp;

    }

    public void mostrar(){
        for(Celula i = this.getPrimeiro().getProx(); i != null; i = i.getProx()) {
            i.getPersonagem().print();

        }

    }

}

class NoAVL {
    private Personagem personagem;
    private NoAVL esq, dir;
    private int nivel;

    public Personagem getPersonagem() {
        return personagem;
    }

    public void setPersonagem(Personagem personagem) {
        this.personagem = personagem;
    }

    public NoAVL getDir() {
        return dir;
    }

    public void setDir(NoAVL dir) {
        this.dir = dir;
    }

    public NoAVL getEsq() {
        return esq;
    }

    public void setEsq(NoAVL esq) {
        this.esq = esq;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public NoAVL(){
        this(new Personagem());

    }

    public NoAVL(Personagem personagem){
        this(personagem, null, null, 1);

    }

    public NoAVL(Personagem personagem, NoAVL esq, NoAVL dir, int nivel){
        this.setPersonagem(personagem);
        this.setDir(dir);
        this.setEsq(esq);
        this.setNivel(nivel);

    }

    public void setNivel(){
        this.setNivel(1 + Math.max(getNivel(this.getEsq()), getNivel(this.getDir())));

    }

    public static int getNivel(NoAVL no){
        return (no == null) ? 0 : no.getNivel();

    }

}

class AVL {
    private NoAVL raiz;
    private int numElementos;

    public NoAVL getRaiz() {
        return raiz;
    }

    public void setRaiz(NoAVL raiz) {
        this.raiz = raiz;
    }

    public int getNumElementos() {
        return numElementos;
    }

    public void setNumElementos(int numElementos) {
        this.numElementos = numElementos;
    }

    public AVL(){
        this.setRaiz(null);
        this.setNumElementos(0);

    }

    public boolean pesquisar(Personagem personagem) throws Exception{
        return (personagem == null) ? false : pesquisar(personagem, this.getRaiz());

    }

    private boolean pesquisar(Personagem personagem, NoAVL i) throws Exception{
        boolean resp = false;
        if(personagem.getName().equals(i.getPersonagem().getName())) {
            resp = true;

        } else if(personagem.getName().compareTo(i.getPersonagem().getName()) > 0){
            resp = pesquisar(personagem, i.getDir());

        } else if(personagem.getName().compareTo(i.getPersonagem().getName()) < 0){
            resp = pesquisar(personagem, i.getEsq());

        } else {
            throw new Exception("ERRO INESPERADO NA PESQUISA (DOIDONA)!!!");

        }

        return resp;

    }

    public void inserir(Personagem personagem) throws Exception{
        this.setRaiz(inserir(personagem, this.getRaiz()));

    }

    private NoAVL inserir(Personagem personagem, NoAVL i) throws Exception{
        if(i == null) {
            i = new NoAVL(personagem);

        } else if(personagem.getYearOfBirth() < i.getPersonagem().getYearOfBirth()) {
            i = inserir(personagem, i.getEsq());

        } else {
            i = inserir(personagem, i.getDir());

        } 

        return balancear(i);

    }

    public void remover(Personagem personagem) throws Exception{
        this.setRaiz(remover(personagem, this.getRaiz()));

    }

    private NoAVL remover(Personagem personagem, NoAVL i) throws Exception{
        if(i == null){
            throw new Exception("ERRO AO REMOVER! Elemento não encontrado!!!");

        } else if(personagem.getYearOfBirth() < i.getPersonagem().getYearOfBirth()) {
            i = remover(personagem, i.getEsq());

        } else if(personagem.getYearOfBirth() > i.getPersonagem().getYearOfBirth()) {
            i = remover(personagem, i.getDir());

        } else if(i.getDir() == null) {
            i = i.getEsq();

        } else if(i.getEsq() == null) {
            i = i.getDir();

        } else {
            i.setEsq(maiorEsq(i, i.getEsq()));

        }

        return balancear(i);

    }

    public void caminharCentral(){
        caminharCentral(this.getRaiz());

    }

    private void caminharCentral(NoAVL i){
        if(i != null) {
            caminharCentral(i.getEsq());
            i.getPersonagem().print();
            caminharCentral(i.getDir());
            
        }

    }

    public void caminharPre(){
        caminharPre(this.getRaiz());

    }

    private void caminharPre(NoAVL i){
        if(i != null) {
            i.getPersonagem().print();
            caminharPre(i.getEsq());
            caminharPre(i.getDir());
            
        }

    }

    public void caminharPos(){
        caminharPos(this.getRaiz());

    }

    private void caminharPos(NoAVL i){
        if(i != null) {
            caminharPos(i.getEsq());
            caminharPos(i.getDir());
            i.getPersonagem().print();
            
        }

    }

    private NoAVL maiorEsq(NoAVL i, NoAVL j){
        if(j.getDir() == null) {
            i.setPersonagem(j.getPersonagem());
            j = j.getEsq();

        } else {
            j.setDir(maiorEsq(i, j.getDir()));

        }

        return j;

    }

    private NoAVL balancear(NoAVL no) throws Exception{
        if(no != null) {
            int fator = NoAVL.getNivel(no.getDir()) - NoAVL.getNivel(no.getEsq());
            if(Math.abs(fator) <= 1) {
                no.setNivel();

            } else if(fator == 2) {
                int fatorFilhoDir = NoAVL.getNivel(no.getDir().getDir()) - NoAVL.getNivel(no.getDir().getEsq());
                if(fatorFilhoDir == -1) {
                    no.setDir(rotacionarDir(no.getDir()));

                }

                no = rotacionarEsq(no);

            } else if(fator == -2) {
                int fatorFilhoEsq = NoAVL.getNivel(no.getEsq().getDir()) - NoAVL.getNivel(no.getEsq().getEsq());
                if(fatorFilhoEsq == -1) {
                    no.setEsq(rotacionarEsq(no.getEsq()));

                }

                no = rotacionarDir(no);

            } else {
                throw new Exception("ERRO AO BALANCEAR!!! No " + no.getPersonagem() + " com fator inválido: " + no.getNivel());

            }

        }

        return no;

    }

    private NoAVL rotacionarDir(NoAVL no){
        NoAVL noEsq = no.getEsq();
        NoAVL noEsqDir = noEsq.getDir();

        noEsq.setDir(no);
        no.setEsq(noEsqDir);
        no.setNivel();
        noEsq.setNivel();

        return noEsq;

    }

    private NoAVL rotacionarEsq(NoAVL no){
        NoAVL noDir = no.getDir();
        NoAVL noDirEsq = noDir.getEsq();

        noDir.setEsq(no);
        no.setDir(noDirEsq);
        no.setNivel();
        noDir.setNivel();

        return noDir;

    }


}

public class Doidona {
    private Personagem[] t1;
    private Personagem[] t3;
    private AVL arvoreT2;
    private AVL arvoreT3;
    private Lista listaT2;
    final static int tamanhoTabelaPadrao = 100;

    public Personagem[] getT1() {
        return t1;
    }

    public void setT1(Personagem[] t1) {
        this.t1 = t1;
    }

    public Personagem[] getT3() {
        return t3;
    }

    public void setT3(Personagem[] t3) {
        this.t3 = t3;
    }

    public AVL getArvoreT2() {
        return arvoreT2;
    }

    public void setArvoreT2(AVL arvoreT2) {
        this.arvoreT2 = arvoreT2;
    }

    public AVL getArvoreT3() {
        return arvoreT3;
    }

    public void setArvoreT3(AVL arvoreT3) {
        this.arvoreT3 = arvoreT3;
    }

    public Lista getListaT2() {
        return listaT2;
    }

    public void setListaT2(Lista listaT2) {
        this.listaT2 = listaT2;
    }

    public Doidona(){
        this.setT1(new Personagem[tamanhoTabelaPadrao]);
        this.setT3(new Personagem[tamanhoTabelaPadrao]);
        for(int i = 0; i < tamanhoTabelaPadrao; i++){
            this.getT1()[i] = null;
            this.getT3()[i] = null;

        }
        this.setArvoreT2(new AVL());
        this.setArvoreT3(new AVL());
        this.setListaT2(new Lista());

    }

    public static int hashT1(Personagem personagem){
        return (personagem.getYearOfBirth() % tamanhoTabelaPadrao);

    }

    public static int hashT2(Personagem personagem){
        return (personagem.getYearOfBirth() % 3);

    }

    public static int hashT3(Personagem personagem){
        return (personagem.getYearOfBirth() % tamanhoTabelaPadrao);

    }

    public void inserir(Personagem personagem) throws Exception {
        if(personagem == null) {
            throw new Exception("ERRO AO INSERIR (DOIDONA)! Personagem Nulo!!!");

        } else {
            int posicao = hashT1(personagem);
            if(this.getT1()[posicao] == null) {
                this.getT1()[posicao] = personagem;

            } else {
                posicao = hashT2(personagem);
                if(posicao == 0) {
                    posicao = hashT3(personagem);
                    if(this.getT3()[posicao] == null){
                        this.getT3()[posicao] = personagem;

                    } else {
                        arvoreT3.inserir(personagem);

                    }

                } else if(posicao == 1) {
                    listaT2.inserirFim(personagem);

                } else if(posicao == 2) {
                    arvoreT2.inserir(personagem);

                } else {
                    throw new Exception("ERRO AO INSERIR (DOIDONA)! Não Sei Onde Inserir!!!");

                }

            }

        }

    }

    public boolean pesquisar(Personagem personagem) throws Exception {
        if(personagem == null) {
            throw new Exception("ERRO AO PESQUISAR (DOIDONA)! Personagem Nulo!!!");

        } else {
            boolean resp = false;
            int posicao = hashT1(personagem);
            if(this.getT1()[posicao].getName() == personagem.getName()) {
                resp = true;

            } else {
                posicao = hashT2(personagem);
                if(posicao == 0) {
                    posicao = hashT3(personagem);
                    if(this.getT3()[posicao].getName() == personagem.getName()){
                        resp = true;

                    } else {
                        resp = arvoreT3.pesquisar(personagem);

                    }

                } else if(posicao == 1) {
                    resp = listaT2.pesquisar(personagem);

                } else if(posicao == 2) {
                    resp = arvoreT2.pesquisar(personagem);

                } else {
                    throw new Exception("ERRO INESPERADO AO PESQUISAR (DOIDONA)!!!");

                }

            }

            return resp;

        }

    }

    public void mostrar(){
        System.out.println("PRINT DA TABELA T1: ");
        for(int i = 0; i < tamanhoTabelaPadrao; i++) {
            if(this.getT1()[i] != null) {
                this.getT1()[i].print();

            }

        }

        System.out.println("\nPRINT DA TABELA T3: ");

        for(int i = 0; i < tamanhoTabelaPadrao; i++) {
            if(this.getT3()[i] != null) {
                this.getT3()[i].print();

            }

        }

        System.out.println("\nPRINT DA ÁRVORE DE RESERVA T3: ");
        this.getArvoreT3().caminharCentral();
        System.out.println("\nPRINT DA LISTA DE RESERVA T2: ");
        this.getListaT2().mostrar();
        System.out.println("\nPRINT DA ÁRVORE DE RESERVA T2: ");
        this.getArvoreT2().caminharCentral();

    }

    public static void main(String[] args) throws Exception{
        String[] entrada = new String[5000];
        int numEntrada = 0;

        String[] entradaSecund = new String[5000];
        int numEntradaSecund = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line;
            while((line = br.readLine()) != null && !line.equals("FIM")) {
                entrada[numEntrada] = line;
                numEntrada++;

            }

            while((line = br.readLine()) != null && !line.equals("FIM")) {
                entradaSecund[numEntradaSecund] = line;
                numEntradaSecund++;

            }

        } catch(IOException e) {
            System.out.println(e);

        }

        ArrayList<Personagem> array = Personagem.ler("C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv");
        Doidona doidona = new Doidona();

        for(int i = 0; i < numEntrada; i++) {
            Personagem personagem = Personagem.pesquisarPorID(entrada[i], array);

            doidona.inserir(personagem);

        }

       doidona.mostrar();


    }
}