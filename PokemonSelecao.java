import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

//==========================================================================================
//CLASS POKEMON v9.0 - Classe para leitura e manipulação de objetos do tipo Pokemon.
//@author Luis Felipe Souza Lopes.
//==========================================================================================

class PokemonSelecao {
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
    public PokemonSelecao() {
        this(-1, -1, "", "", new String[20], new String[20], -1, -1, -1, false, new Date());

    }

    //CONSTRUCTOR COM ATRIBUTOS ================================================================
    public PokemonSelecao(int id, int generation, String name, String description, String[] types, String[] abilities, double weight, double height, int captureRate, boolean isLegendary, Date captureDate) {
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
    public static PokemonSelecao clone(PokemonSelecao pokemon) {
        PokemonSelecao clone = new PokemonSelecao(pokemon.getId(), pokemon.getGeneration(), pokemon.getName(),
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
    public static ArrayList<PokemonSelecao> ler(String nomeArquivo) throws ParseException, Exception{
        ArrayList<PokemonSelecao> resp = new ArrayList<PokemonSelecao>();

        try(BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                int inicio = 0, fim = line.indexOf(",", 0); //PONTEIROS PARA CAMINHAR NA LINHA
                PokemonSelecao pokemon = new PokemonSelecao();
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
    public static PokemonSelecao pesquisarPorID(int id, ArrayList<PokemonSelecao> array) {
        PokemonSelecao resp = new PokemonSelecao();
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
    

    //==========================================================================================
    //QUESTÃO 05 - TP02: ORDENAÇÃO POR SELEÇÃO
    //==========================================================================================
    public static void selectionSort(PokemonSelecao[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            int menorIndex = i;

            for(int j = i + 1; j < array.length; j++) {
                if(array[j].getName().compareTo(array[i].getName()) < 0) {
                    menorIndex = j;

                }

            }

            PokemonSelecao tmp = array[menorIndex];
            array[menorIndex] = array[i];
            array[i] = tmp;

        }

    }

    //==========================================================================================
    //MAIN DA CLASSE POKEMON v9.0.
    //@author Luis Felipe Souza Lopes.
    //==========================================================================================
    public static void main(String[] args) throws ParseException, Exception {
        
        //LEITURA DO ARQUIVO DE ENTRADA (PUB.IN) ===============================================
        String[] entrada = new String[500];
        String[] entradaNames = new String[500];
        int numEntrada = 0, numEntradaNames = 0;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "";

            while ((line = br.readLine()) != null && !line.equals("FIM")) {
                entrada[numEntrada] = line;
                numEntrada++;

            }
            
            while ((line = br.readLine()) != null && !line.equals("FIM")) {
                entradaNames[numEntradaNames] = line;
                numEntradaNames++;

            }

        } catch (IOException e) {
            System.out.println(e);

        }

        //CRIAÇÃO DO ARRAY LIST DE POKEMON E EXECUÇÃO DA LEITURA DO CSV ========================
        ArrayList<PokemonSelecao> array = PokemonSelecao.ler("C:/Users/User/Documents/Facul/AED2/TP02/Q01-Classe em Java/pokemon.csv");
        //ArrayList<Pokemon> array = Pokemon.ler("/tmp/pokemon.csv");

        //CRIAÇÃO DE VETOR PARA PESQUISA SEQUENCIAL ============================================
        PokemonSelecao[] arrayPesquisa = new PokemonSelecao[300];
        for (int i = 0; i < numEntrada; i++) {
            arrayPesquisa[i] = pesquisarPorID(Integer.parseInt(entrada[i]), array);

        }
        
        //PESQUISAR NOMES DA ENTRADA E PRINTAR "SIM" CASO EXISTAM E "NAO" CASO NÃO EXISTAM =====
        for (int i = 0; i < numEntradaNames; i++) {
            if(pesquisaSequencial(arrayPesquisa, entradaNames[i])) System.out.println("SIM"); 
            else System.out.println("NAO");

        }

    }

}
