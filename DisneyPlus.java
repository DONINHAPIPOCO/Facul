import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;


class DisneyPlus{
    //ATRIBUTOS ===============================================================================
    private String showId;
    private String type;
    private String title;
    private String[] directors;
    private String[] cast;
    private String country;
    private Date dateAdded;
    private int releaseYear;
    private String rating;
    private String duration;
    private String[] listedIn;
    
    //GETTERS & SETTERS =======================================================================
    public String getShowId() {
        return showId;
    }

    public void setShowId(String showId) {
        this.showId = showId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String[] getDirectors() {
        return directors;
    }

    public void setDirectors(String[] directors) {
        this.directors = directors;
    }

    public String[] getCast() {
        return cast;
    }

    public void setCast(String[] cast) {
        this.cast = cast;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String[] getListedIn() {
        return listedIn;
    }

    public void setListedIn(String[] listedIn) {
        this.listedIn = listedIn;
    }
    
    //CONSTRUCTOR & CLONE =====================================================================
    public DisneyPlus(){
        this("", "", "", new String[20], new String[20], "", new Date(), -1, "", "", new String[20]);

    }

    public DisneyPlus(String showId, String type, String title, String[] directors, String[] cast, String country, 
    Date dateAdded, int releaseYear, String rating, String duration, String[] listedIn){
        this.showId = showId;
        this.type = type;
        this.title = title;
        this.directors = directors;
        this.cast = cast;
        this.country = country;
        this.dateAdded = dateAdded;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.duration = duration;
        this.listedIn = listedIn;

    }

    public static DisneyPlus clone(DisneyPlus DisneyPlus){
        DisneyPlus clone = new DisneyPlus(DisneyPlus.getShowId(), DisneyPlus.getType(), DisneyPlus.getTitle(), DisneyPlus.getDirectors(), 
        DisneyPlus.getCast(), DisneyPlus.getCountry(), DisneyPlus.getDateAdded(), 
        DisneyPlus.getReleaseYear(), DisneyPlus.getRating(), DisneyPlus.getDuration(), 
        DisneyPlus.getListedIn());

        return clone;

    }

    //IMPRIMIR E LER ==========================================================================
    public void print(){
        System.out.print("[=>" + this.getShowId() + " -> " + this.getType() + " ## " + this.getTitle() + " ## "); 

        for(int i = 0; i < this.getDirectors().length; i++){
            System.out.print(this.getDirectors()[i]);
            if (i < this.getDirectors().length - 1) {
                System.out.print(", ");

            }

        }

        System.out.print(" ## [");

        for(int i = 0; i < this.getCast().length; i++){
            System.out.print(this.getCast()[i]);
            if (i < this.getCast().length - 1) {
                System.out.print(", ");

            }

        }

        System.out.print("] ## " + this.getCountry() + " ## ");

        SimpleDateFormat formatoData = new SimpleDateFormat("dd-MM-yyy");
        String dataFormatada = formatoData.format(this.getDateAdded());
        System.out.print(dataFormatada + " ## " + this.getReleaseYear() + " ## " + this.getRating() + " ## "
        + this.getDuration());
        
        for(int i = 0; i < this.getListedIn().length; i++){
            System.out.print(this.getListedIn()[i]);
            if (i < this.getListedIn().length - 1) {
                System.out.print(", ");

            } else {
                System.out.println();

            }

        }
        
    }

    public static ArrayList<DisneyPlus> ler(String nomeArquivo) throws ParseException, Exception{
        ArrayList<DisneyPlus> resp = new ArrayList<DisneyPlus>();

        try(BufferedReader bf = new BufferedReader(new FileReader(nomeArquivo))){
            String line = bf.readLine();
            while((line = bf.readLine()) != null){
                String[] splits = line.split(",", -1);
                DisneyPlus DisneyPlus = new DisneyPlus();

                int i = 0;

                //LER ID ======================================================================
                try {
                    DisneyPlus.setShowId(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setShowId("NULL");

                }

                //LER TYPE ====================================================================
                try {
                    DisneyPlus.setType(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setType("NULL");

                }

                //LER TITLE ===================================================================
                try {
                    DisneyPlus.setTitle(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setTitle("NULL");

                }

                //LER DIRECTORS ===============================================================
                try {
                    String substring = line.substring(line.indexOf('"'), line.indexOf('"'));
                    String[] directors = substring.split(",");

                    DisneyPlus.setDirectors(directors);
                    i++;

                } catch(Exception e) {
                    DisneyPlus.setDirectors(new String[1]);

                }

                //LER CAST ====================================================================
                try {
                    String substring = line.substring(line.indexOf('"', i), line.indexOf('"', i));
                    String[] cast = substring.split(",");

                    DisneyPlus.setCast(cast);
                    i++;

                } catch(Exception e) {
                    DisneyPlus.setCast(new String[1]);

                }

                //LER COUNTRY =================================================================
                try {
                    DisneyPlus.setCountry(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setCountry("NULL");

                }
 
                //LER DATE ====================================================================
                try {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    DisneyPlus.setDateAdded(formato.parse(splits[i]));
                    i++;
                } catch(Exception e) {
                    SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
                    DisneyPlus.setDateAdded(formato.parse("01/01/1970"));

                }
                
                //LER RELEASE YEAR ============================================================
                try {
                    DisneyPlus.setReleaseYear(Integer.parseInt(splits[i]));
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setReleaseYear(0);

                }

                //LER RATING ==================================================================
                try {
                    DisneyPlus.setRating(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setRating("NULL");

                }
                
                //LER DURATION ================================================================
                try {
                    DisneyPlus.setDuration(splits[i]);
                    i++;
                } catch(Exception e) {
                    DisneyPlus.setDuration("NULL");

                }

                //LER LISTED IN ===============================================================

                try {
                    String substring = line.substring(line.indexOf('"', i), line.indexOf('"', i));
                    String[] listedIn = substring.split(",");

                    DisneyPlus.setListedIn(listedIn);
                    i++;

                } catch(Exception e) {
                    DisneyPlus.setCast(new String[1]);

                }

                resp.add(DisneyPlus);

            }

        } catch(IOException e){
            System.out.println(e);

        }

        return resp;

    }

    /*public static boolean pesquisarPorID(int id, ArrayList<DisneyPlus> array){
        boolean resp = false;
        for(int i = 0; i < array.size(); i++){
            if(array.get(i).getId() == id) resp = true;

        }

        return resp;

    }*/

    public static void main(String[] args) throws ParseException, Exception{
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

        //ArrayList<DisneyPlus> array = DisneyPlus.ler("C:/Users/User/Documents/Facul/AED2/TP02/Q01-Classe em Java/DisneyPlus.csv");

        ArrayList<DisneyPlus> array = DisneyPlus.ler("/tmp/disneyplus.csv");
        HashMap<Integer, DisneyPlus> map = new HashMap<>();

        for (DisneyPlus disneyPlus : array) {
            //System.out.println("ID PRÉ TRATADA: " + disneyPlus.getShowId());
            String id = disneyPlus.getShowId().replace("s", "");
            //System.out.println("ID PÓS TRATADA: " + id);
            map.put(Integer.parseInt(id), disneyPlus);

        }

        //pesquisar ids da entrada e printar caso existam
        for(int i = 0; i < numEntrada; i++){
            String in = entrada[i].replace("s", "");
            if(map.containsKey(Integer.parseInt(in))){
                map.get(Integer.parseInt(in)).print();

            }

        }


    }

}

