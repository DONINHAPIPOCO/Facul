import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

//==============================================================================================
// CLASSE ListaFlexivel - CLASSE PARA IMPLEMENTAR E MANIPULAR UMA LISTA FLEXÍVEL.
// @author Luis Felipe Souza Lopes - 654663.
//==============================================================================================
public class ListaFlexivel {
    
    //ATRIBUTOS DA LISTA PROPRIAMENTE DITA =====================================================
    private Celula primeiro, ultimo;

    //GETS E SETS ==============================================================================
    
    //gets.
    public Celula getPrimeiro() { return primeiro; }
    public Celula getUltimo() { return ultimo; }

    //sets.
    public void setPrimeiro(Celula primeiro) { this.primeiro = primeiro; }
    public void setUltimo(Celula ultimo) { this.ultimo = ultimo; }

    //CONSTRUCTOR LISTA ========================================================================

    //INICIA A LISTA COM UM NÓ CABEÇA ==========================================================
    public ListaFlexivel() {
        this.setPrimeiro(new Celula());
        this.setUltimo(ultimo);

    }

    //MÉTODOS DE INSERÇÃO ======================================================================
    
    //INSERIR UM ELEMENTO NO INÍCIO DA LISTA ===================================================
    public void inserirInicio(Pokemon pokemon) throws Exception{
        if(pokemon != null) {
            Celula tmp = new Celula(pokemon);
            tmp.setProx(primeiro.getProx());
            primeiro.setProx(tmp);

            tmp = null;

        } else {
            throw new Exception("ERRO AO INSERIR (INÍCIO)! Pokemon inválido!!!");

        }

    }

    //INSERIR UM ELEMENTO EM POSIÇÃO SELECIONADA ===============================================
    public void inserir(Pokemon pokemon, int pos) throws Exception{
        if(pokemon != null) {
            
            //ENCONTRAR A CÉLULA NA POSIÇÃO DESEJADA.
            Celula i = primeiro.getProx();
            for(int j = 0; j < pos; j++, i = i.getProx());

            //INSERÇÃO PROPRIAMENTE DITA.
            Celula tmp = new Celula(pokemon);
            tmp.setProx(i.getProx());
            i.setProx(tmp);

            tmp = i = null;

        } else {
            throw new Exception("ERRO AO INSERIR (POSIÇÃO: " + pos + ")! Pokemon inválido!!!");

        }

    }

    //INSERIR UM ELEMENTO NO FIM DA LISTA ======================================================
    public void inserirFim(Pokemon pokemon) throws Exception{
        if(pokemon != null) {
            this.ultimo.setProx(new Celula(pokemon));
            this.ultimo = ultimo.getProx();


        } else {
            throw new Exception("ERRO AO INSERIR (FIM)! Pokemon inválido!!!");

        }

    }

    //MÉTODOS DE REMOÇÃO =======================================================================
    
    //REMOVER UM ELEMENTO DO INÍCIO DA LISTA ===================================================
    public Pokemon removerInicio() throws Exception {
        if(primeiro == ultimo) {
            throw new Exception("ERRO AO REMOVER (INÍCIO)! Lista Vazia!!!");

        } else {
            //PEGAR ELEMENTO A SER RETORNADO.
            Pokemon resp = this.primeiro.getProx().getPokemon();

            //REMANEJAR OS PONTEIROS.
            Celula tmp = primeiro.getProx().getProx();
            primeiro.getProx().setProx(null);
            primeiro.setProx(tmp);

            tmp = null;

            return resp;

        }

    }

    //REMOVER UM ELEMENTO DE UMA POSIÇÃO SELECIONADA ===========================================
    public Pokemon remover(int pos) throws Exception {
        if(primeiro == ultimo) {
            throw new Exception("ERRO AO REMOVER (POSIÇÃO: " + pos + ")! Lista Vazia!!!");

        } else {
            Pokemon resp;

            //CAMINHAR ATÉ A POSIÇÃO ANTERIOR À DESEJADA.
            Celula i = primeiro.getProx();
            for(int j = 0; j < pos - 1; j++, i = i.getProx());

            //PEGAR VALOR DA PRÓXIMA CÉLULA PARA RETORNAR.
            resp = i.getProx().getPokemon();

            //REMANEJAR OS PONTEIROS.
            Celula tmp = i.getProx().getProx();
            i.getProx().setProx(null);
            i.setProx(tmp);

            tmp = i = null;

            return resp;

        }

    }

    //REMOVER UM ELEMENTO DO FIM DA LISTA ======================================================
    public Pokemon removerFim() throws Exception{
        if(primeiro == ultimo) {
            throw new Exception("ERRO AO REMOVER (FIM)! Lista Vazia!!!");

        } else {
            
            //PEGAR VALOR DA ÚLTIMA CÉLULA PARA RETORNAR.
            Pokemon resp = this.ultimo.getPokemon();

            //CAMINHAR ATÉ A PENÚLTIMA POSIÇÃO DA LISTA.
            Celula tmp = this.primeiro.getProx();
            for(; tmp.getProx() != this.ultimo; tmp = tmp.getProx());

            //REMANEJAR OS PONTEIROS.
            this.ultimo = tmp;
            this.ultimo.setProx(null);

            tmp = null;

            return resp;

        }

    }

    //PESQUISAR E MOSTRAR ======================================================================
    
    //PESQUISAR SE UM ELEMENTO EXISTE NA LISTA =================================================
    public boolean pesquisar(Pokemon pokemon) throws Exception {
        if(pokemon != null) {
            boolean resp = false;
            for(Celula i = primeiro.getProx(); i != null; i = i.getProx()) {
                if(i.getPokemon().getName().equals(pokemon.getName())) resp = true;

            }
            
            return resp;

        } else {
            throw new Exception("ERRO AO PESQUISAR! Pokemon Nulo!!!");

        }

    }

    //IMPRIMIR TODOS OS ELEMENTOS DA LISTA =====================================================
    public void mostrar() throws Exception{
        for(Celula i = this.primeiro.getProx(); i != null; i = i.getProx()) {
            i.getPokemon().print();
            
        }

    }

    //==========================================================================================
    // MÉTODO MAIN DA CLASSE ListaFlexivel v9.0.
    // @author Luis Felipe Souza Lopes - 654663.
    //==========================================================================================
    public static void main(String[] args) {


    }

}


//==============================================================================================
// CLASSE Celula - CLASSE AUXILIAR PARA CONSTRUIR AS CÉLULAS USADAS PARA FAZER A LISTA.
// @author Luis Felipe Souza Lopes - 654663.
//==============================================================================================
class Celula {

    //ATRIBUTOS DA CLASSE CÉLULA ===============================================================
    private Celula prox;
    private Pokemon pokemon;

    //GETS E SETS ==============================================================================
    
    //gets.
    public Celula getProx() { return prox; }
    public Pokemon getPokemon() { return pokemon; }

    //sets.
    public void setProx(Celula prox) { this.prox = prox; }
    public void setPokemon(Pokemon pokemon) { this.pokemon = pokemon; }

    //CONSTRUCTORS CELULA =======================================================================
    public Celula() { this(new Pokemon()); }
    public Celula(Pokemon pokemon) { this.setPokemon(pokemon); }

}

//==========================================================================================
//CLASS Pokemon v9.0 - CLASSE PARA LEITURA E MANIPULAÇÃO DE OBJETOS DO TIPO POKEMON.
//@author Luis Felipe Souza Lopes.
//==========================================================================================

class Pokemon {
    //==========================================================================================
    //ATRIBUTOS PRIVADOS, GETS E SETS
    //==========================================================================================
    
    //ATRIBUTOS ================================================================================
    private int id;
    private int generation;
    private String name;
    private String description;
    private String[] types;
    private String[] abilities;
    private double weight;
    private double height;
    private int captureRate;
    private boolean isLegendary;
    private Date captureDate;

    //GETS =====================================================================================
    public int getId() { return id; }
    public int getGeneration() { return generation; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public String[] getTypes() { return types; }
    public String[] getAbilities() { return abilities; }
    public double getWeight() { return weight; }
    public double getHeight() { return height; }
    public int getCaptureRate() { return captureRate; }
    public boolean isLegendary() { return isLegendary; }
    public Date getCaptureDate() { return captureDate; }

    //SETS =====================================================================================
    public void setId(int id) { this.id = id; }
    public void setGeneration(int generation) { this.generation = generation; }
    public void setName(String name) { this.name = name; }
    public void setDescription(String description) { this.description = description; }
    public void setTypes(String[] types) { this.types = types; }
    public void setAbilities(String[] abilities) { this.abilities = abilities; }
    public void setWeight(double weight) { this.weight = weight; }
    public void setHeight(double height) { this.height = height; }
    public void setCaptureRate(int captureRate) { this.captureRate = captureRate; }
    public void setLegendary(boolean isLegendary) { this.isLegendary = isLegendary; }
    public void setCaptureDate(Date captureDate) { this.captureDate = captureDate; }


    //==========================================================================================
    //CONSTRUCTORS E CLONE
    //==========================================================================================
    
    //CONSTRUCTOR DEFAULT ======================================================================
    public Pokemon() {
        this(-1, -1, "", "", new String[20], new String[20], -1, -1, -1, false, new Date());

    }

    //CONSTRUCTOR COM ATRIBUTOS ================================================================
    public Pokemon(int id, int generation, String name, String description, String[] types, String[] abilities, double weight, double height, int captureRate, boolean isLegendary, Date captureDate) {
        this.id = id;
        this.generation = generation;
        this.name = name;
        this.description = description;
        this.types = types;
        this.abilities = abilities;
        this.weight = weight;
        this.height = height;
        this.captureRate = captureRate;
        this.isLegendary = isLegendary;
        this.captureDate = captureDate;

    }

    //CLONE ====================================================================================
    public static Pokemon clone(Pokemon pokemon) {
        Pokemon clone = new Pokemon(pokemon.getId(), pokemon.getGeneration(), pokemon.getName(),
                pokemon.getDescription(),
                pokemon.getTypes(), pokemon.getAbilities(), pokemon.getWeight(),
                pokemon.getHeight(), pokemon.getCaptureRate(), pokemon.isLegendary(),
                pokemon.getCaptureDate());

        return clone;

    }

    
    //==========================================================================================
    //LEITURA DO CSV E MÉTODOS AUXILIARES
    //==========================================================================================
    
    //LER ======================================================================================
    public static ArrayList<Pokemon> ler(String nomeArquivo) throws ParseException, Exception{
        ArrayList<Pokemon> resp = new ArrayList<Pokemon>();

        try(BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                int inicio = 0, fim = line.indexOf(",", 0); //PONTEIROS PARA CAMINHAR NA LINHA
                Pokemon pokemon = new Pokemon();
                String substring = ""; //SUBSTRING AUXILIAR PARA MANIPULAR LINHA

                //ID ========================================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setId(Integer.parseInt(substring));
                    
                } catch(Exception e) {
                    pokemon.setId(0);

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //GEN =======================================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setGeneration(Integer.parseInt(substring));
                    
                } catch(Exception e) {
                    pokemon.setGeneration(0);

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //NOME ======================================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setName(substring);
                    
                } catch(Exception e) {
                    pokemon.setName("0");

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //DESCRIPTION ===============================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setDescription(substring);
                    
                } catch(Exception e) {
                    pokemon.setDescription("0");

                }

                inicio = fim + 1;
                fim = line.indexOf("\"", inicio);


                //TYPES =====================================================
                substring = line.substring(inicio, fim);
                pokemon.setTypes(getArrayTypes(substring));

                inicio = fim + 1;
                fim = line.indexOf("\"", inicio)+1;


                //ABILITIES =================================================
                substring = line.substring(line.indexOf("["), line.indexOf("]"));
                pokemon.setAbilities(getArrayAbilities(substring));

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //WEIGHT ====================================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setWeight(Double.parseDouble(substring));
                    
                } catch(Exception e) {
                    pokemon.setWeight(0.0);

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //HEIGHT ====================================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setHeight(Double.parseDouble(substring));
                    
                } catch(Exception e) {
                    pokemon.setHeight(0.0);

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //CAPTURE RATE ==============================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setCaptureRate(Integer.parseInt(substring));
                    
                } catch(Exception e) {
                    pokemon.setCaptureRate(0);

                }

                inicio = fim + 1;
                fim = line.indexOf(",", inicio);


                //IS LEGENDARY ==============================================
                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setLegendary("1".equals(substring));
                    
                } catch(Exception e) {
                    pokemon.setLegendary(false);

                }

                inicio = fim + 1;
                fim = line.length();

                
                //CAPTURE DATE ==============================================
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");

                try {
                    substring = line.substring(inicio, fim);
                    pokemon.setCaptureDate(formato.parse(substring));
                    
                } catch(Exception e) {
                    pokemon.setCaptureDate(formato.parse("01/01/1970"));

                }


                //ADICIONA POKEMON NO ARRAYLIST DE RETORNO
                resp.add(pokemon);

            }

        } catch(IOException e){
            System.out.println(e);

        }

        return resp;

    }


    //GET ARRAY TYPES ==========================================================================
    //Método auxiliar que retorna um array de String contendo todos os tipos do pokemon.
    private static String[] getArrayTypes(String line) throws Exception {
        if (line.isEmpty()) {
            throw new Exception("ERRO NO getArrayTypes! LINHA VAZIA!!!");

        } else {
            String[] splits = line.split(",");
            String[] types = new String[splits.length];

            for(int i = 0; i < splits.length; i++) {
                types[i] = ("'" + splits[i] + "'");

            }

            return types;

        }

    }


    //GET ARRAY ABILITIES ======================================================================
    //Método auxiliar que retorna um array de String contendo todas as habilidades do pokemon.
    private static String[] getArrayAbilities(String line) throws Exception{
        if(line.isEmpty()) {
            throw new Exception("ERRO NO getArrayAbilities! LINHA VAZIA!!!");

        } else {
            line.replace("[", "");
            line.replace("]", "");

            String[] splits = line.split(",");
            String[] abilities = new String[splits.length];

            for(int i = 0; i < splits.length; i++) {
                abilities[i] = splits[i];

            }

            return abilities;

        }

    }
    
    
    //==========================================================================================
    //PESQUISAR POR ID E IMPRIMIR
    //==========================================================================================
    
    //PESQUISAR POR ID =========================================================================
    //Retorna true caso um objeto com a ID recebida exista no arrayList.
    public static Pokemon pesquisarPorID(int id, ArrayList<Pokemon> array) {
        Pokemon resp = new Pokemon();
        for (int i = 0; i < array.size(); i++) {
            if (array.get(i).getId() == id)
                resp = array.get(i);

        }

        return resp;

    }
    
    
    //IMPRIMIR =================================================================================
    //Imprime um objeto do tipo pokemon, na formatação especificada pelo exercício.
    public void print() {
        System.out.print("[#" + this.getId() + " -> " + this.getName() + ": " + this.getDescription() + " - [");

        for (int i = 0; i < this.getTypes().length; i++) {
            System.out.print(this.getTypes()[i]);
            if (i < this.getTypes().length - 1) {
                System.out.print(", ");

            }

        }

        System.out.print("] - ");

        for (int i = 0; i < this.getAbilities().length; i++) {
            System.out.print(this.getAbilities()[i]);
            if (i < this.getAbilities().length - 1) {
                System.out.print(",");

            }

        }

        System.out.print("] - "
                + this.getWeight() + "kg - " + this.getHeight() + "m - " + this.getCaptureRate() + "% - "
                + this.isLegendary() + " - "
                + this.getGeneration() + " gen] - ");

        SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyy");
        String dataFormatada = formatoData.format(this.getCaptureDate());
        System.out.println(dataFormatada);

    }

}
