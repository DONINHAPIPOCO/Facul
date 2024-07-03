import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class TP01Q08Html {
    
    public static int[] leituraHTML(String nome, String endereco) throws IOException, URISyntaxException{
        int[] resp = new int[25];
        int consoantes = 0, brCount = 0, table = 0;
        String patternVogais = "aeiouáéíóúàèìòùãõâêîôû";
        String patternConsoantes = "bcdfghjklmnpqrstvwxyzç"; 
        String line;

        for(int i = 0; i < resp.length; i++){
            resp[i] = 0;

        }

        try{
            URI uri = new URI(endereco);
            URL url = uri.toURL();

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            while((line = br.readLine()) != null){
                //System.out.println(line);
                for(int i = 0; i < line.length(); i++){
                    char atual = line.charAt(i);
                    if(Character.isLetter(atual)){
                        if(patternVogais.indexOf(atual % 25) != -1){
                            //System.out.print(line.charAt(i));
                            resp[patternVogais.indexOf(atual)]++;
    
                        } else if(patternConsoantes.contains(Character.toString(atual))){
                            //System.out.print(line.charAt(i));
                            consoantes++;
        
                        }
                    
                    }

                }


                table += Math.abs(line.split("<table>").length - 1);
                brCount += Math.abs(line.split("<br>").length - 1);

            }

            br.close();

        } catch(URISyntaxException e){
            System.out.println(e);

        } catch(IOException e){
            System.out.println(e);

        }

        resp[22] = consoantes;
        resp[23] = brCount;
        resp[24] = table;

        return resp;

    }
    
    public static void main(String[] args){
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
        
        try{
            for(int i = 0; i < numEntrada; i = i + 2){
                int[] resultado = leituraHTML(entrada[i], entrada[i + 1]);
                
                System.out.println("a(" + resultado[0] + ") e(" + resultado[1] + ") i(" + resultado[2] + ") o(" + resultado[3] + ") u(" + resultado[4]
                + ") á(" + resultado[5] + ") é(" + resultado[6] + ") í(" + resultado[7] + ") ó(" + resultado[8] + ") ú(" + resultado[9] + ") à(" + resultado[10]
                + ") è(" + resultado[11] + ") ì(" + resultado[12] + ") ò(" + resultado[13] + ") ù(" + resultado[14] + ") ã(" + resultado[15] + ") õ(" + resultado[16]
                + ") â(" + resultado[17] + ") ê(" + resultado[18] + ") î(" + resultado[19] + ") ô(" + resultado[20] + ") û(" + resultado[21] + ") consoante(" + resultado[22]
                + ") <br>(" + resultado[23] + ") <table>(" + resultado[24] + ") " + entrada[i]);

            }

        } catch(URISyntaxException e){
            System.out.println(e);

        } catch(IOException e){
            System.out.println(e);

        }
    }


}
