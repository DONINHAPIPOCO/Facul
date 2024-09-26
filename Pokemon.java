import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class Pokemon{
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
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getTypes() {
        return types;
    }

    public void setTypes(String[] types) {
        this.types = types;
    }

    public String[] getAbilities() {
        return abilities;
    }

    public void setAbilities(String[] abilities) {
        this.abilities = abilities;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public int getCaptureRate() {
        return captureRate;
    }

    public void setCaptureRate(int captureRate) {
        this.captureRate = captureRate;
    }

    public boolean isLegendary() {
        return isLegendary;
    }

    public void setLegendary(boolean isLegendary) {
        this.isLegendary = isLegendary;
    }

    public Date getCaptureDate() {
        return captureDate;
    }

    public void setCaptureDate(Date captureDate) {
        this.captureDate = captureDate;
    }

    public Pokemon(){
        this(-1, -1, "", "", new String[20], new String[20], -1, -1, -1, false, new Date());

    }

    public Pokemon(int id, int generation, String name, String description, String[] types, String[] abilities, double weight, double height, int captureRate, 
    boolean isLegendary, Date captureDate){
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

    public static Pokemon clone(Pokemon pokemon){
        Pokemon clone = new Pokemon(pokemon.getId(), pokemon.getGeneration(), pokemon.getName(), pokemon.getDescription(), 
        pokemon.getTypes(), pokemon.getAbilities(), pokemon.getWeight(), 
        pokemon.getHeight(), pokemon.getCaptureRate(), pokemon.isLegendary(), 
        pokemon.getCaptureDate());

        return clone;

    }

    /*
    public void printArray(ArrayList<Pokemon> array){
        for(int i = 0; i < array.size(); i++){
            System.out.print("[" + array.get(i).getId() + " ## " + array.get(i).getName() + " ## {"); 
        
            for(int j = 0; j < array.get(i).getTypes().length; j++){
                System.out.print(array.get(i).getTypes()[j]);

            }

            for(int j = 0; j < array.get(i).getAbilities().length; j++){
                System.out.print(array.get(i).getAbilities()[j]);

            }

            System.out.println("} ## " 
            + array.get(i).getHouse() + " ## " + array.get(i).getAncestry() + " ## " + array.get(i).getSpecies() + " ## " + array.get(i).getPatronus() + " ## "
            + array.get(i).isHogwartsStaff() + " ## " + array.get(i).isHogwartsStudent() + " ## " + array.get(i).getActorName() + " ## " + array.get(i).isAlive() + " ## "
            + array.get(i).getDateOfBirth() + " ## " + array.get(i).getYearOfBirth() + " ## " + array.get(i).getEyeColour() + " ## " + array.get(i).getGender() + " ## "
            + array.get(i).getHairColour() + " ## " + array.get(i).isWizzard() + "]");
            
        }

    }*/

    public void print(){
        System.out.print("[#" + this.getId() + " -> " + this.getName() + ": " + this.getDescription() + " - ["); 

        for(int i = 0; i < this.getTypes().length; i++){
            this.getTypes()[i] = this.getTypes()[i].replace("[", "");
            this.getTypes()[i] = this.getTypes()[i].replace("]", "");
            this.getTypes()[i] = this.getTypes()[i].replace("'", "");
            System.out.print(this.getTypes()[i]);
            if (i < this.getTypes().length - 1) {
                System.out.print(", ");

            }

        }

        System.out.print("] - [");

        for(int i = 0; i < this.getAbilities().length; i++){
            this.getAbilities()[i] = this.getAbilities()[i].replace("[", "");
            this.getAbilities()[i] = this.getAbilities()[i].replace("]", "");
            this.getAbilities()[i] = this.getAbilities()[i].replace("'", "");
            System.out.print(this.getTypes()[i]);
            if (i < this.getAbilities().length - 1) {
                System.out.print(", ");

            }

        }
        
        System.out.print("] - " 
        + this.getWeight() + "kg - " + this.getHeight() + "m - " + this.getCaptureRate() + "% - " + this.isLegendary() + " - "
        + this.getGeneration() + " gen] - ");

        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyy");
        String dataFormatada = formatoData.format(this.getCaptureDate());
        System.out.println(dataFormatada);

    }

    public static ArrayList<Pokemon> ler(String nomeArquivo) throws ParseException{
        ArrayList<Pokemon> resp = new ArrayList<Pokemon>();

        try(BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                String[] splits = line.split(",");
                Pokemon pokemon = new Pokemon();
                
                pokemon.setId(splits[0] != null ? Integer.parseInt(splits[0]) : -1);
                pokemon.setGeneration(splits[1] != null ? Integer.parseInt(splits[1]) : -1);
                pokemon.setName(splits[2] != null ? splits[2] : "");
                pokemon.setDescription(splits[3] != null ? splits[3] : "");
                
                String[] types = splits[4].split(",");
                pokemon.setTypes(types);

                String[] abilities = splits[5].split(",");
                pokemon.setAbilities(abilities);
                
                pokemon.setWeight(splits[6] != null ? Double.parseDouble(splits[6]) : -1);
                pokemon.setHeight(splits[7] != null ? Double.parseDouble(splits[7]) : -1);
                pokemon.setCaptureRate(splits[8] != null ? Integer.parseInt(splits[8]) : -1);
                pokemon.setLegendary(splits[9].equals("1") ? true : false);

                SimpleDateFormat formato = new SimpleDateFormat("dd-MM-yyyy");
                pokemon.setCaptureDate(formato.parse(splits[10] != null ? splits[10] : "00000000"));

                resp.add(pokemon);

            }

        } catch(IOException e){
            System.out.println(e);

        }

        return resp;

    }

    public static boolean pesquisarPorID(int id, ArrayList<Pokemon> array){
        boolean resp = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getId() == id) resp = true;

        }

        return resp;

    }

    public static void main(String[] args) throws ParseException{
        String[] entrada = new String[5000];
        int numEntrada = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = "";

            while((line = br.readLine()) != null && !line.equals("FIM")){
                entrada[numEntrada] = line;
                numEntrada++;

            }


        } catch(IOException e){
            System.out.println(e);

        }

        ArrayList<Pokemon> array = Pokemon.ler("C:/Users/User/Documents/Facul/AED2/TP02/Q01-Classe em Java/pokemon.csv");

        //ArrayList<Pokemon> array = Pokemon.ler("/tmp/pokemon.csv");
        HashMap<Integer, Pokemon> map = new HashMap<>();

        for (Pokemon pokemon : array) {
            map.put(pokemon.getId(), pokemon);

        }

        //pesquisar ids da entrada e printar caso existam
        for(int i = 0; i < numEntrada; i++){
            if(map.containsKey(Integer.parseInt(entrada[i]))){
                map.get(Integer.parseInt(entrada[i])).print();

            }

        }


    }

}

