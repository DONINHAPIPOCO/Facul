/*
 * Class Is v7.0.
 * @author Luis Felipe Souza Lopes.
 * @lastUpdate 18/07/2023
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TP01Q06Is {
    public static boolean isFormadoPorVogal(String palavra){
        boolean resp = true;

        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) != 'a' && palavra.charAt(i) != 'A' && palavra.charAt(i) != 'e' && palavra.charAt(i) != 'E' && palavra.charAt(i) != 'i' && palavra.charAt(i) != 'I' 
            && palavra.charAt(i) != 'o' && palavra.charAt(i) != 'O' && palavra.charAt(i) != 'u' && palavra.charAt(i) != 'U'){
                resp = false;
                
            }

        }

        return resp;

    }

    public static boolean isFormadoPorConsoante(String palavra){
        boolean resp = true;

        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' 
            || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U' || palavra.charAt(i) >= '0' || palavra.charAt(i) <= '9'){
                resp = false;
                break;
                
            }

        }

        return resp;

    }

    public static boolean isNumeroInteiro(String palavra){
        boolean resp = true;

        for(int i = 0; i < palavra.length(); i++){
            if(palavra.charAt(i) < '0' || palavra.charAt(i) > '9'){
                resp = false;
                
            }

        }

        return resp;

    }

    public static boolean isNumeroReal(String palavra){
        boolean resp = true;
        int contagemDePontos = 0;

        for(int i = 0; i < palavra.length(); i++){
            if(!Character.isDigit(palavra.charAt(i))){
                if(palavra.charAt(i) == '.' || palavra.charAt(i) == ','){
                    contagemDePontos++;
                    if(contagemDePontos > 1){
                        resp = false;
                        break;

                    }

                } else {
                    resp = false;
                    break;

                }
                
            }

        }

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

        for(int i = 0; i < numEntrada; i++){
            //System.out.println("palavra: " + entrada[i]);
            System.out.print(isFormadoPorVogal(entrada[i]) ? "SIM " : "NAO ");
            System.out.print(isFormadoPorConsoante(entrada[i]) ? "SIM " : "NAO ");
            System.out.print(isNumeroInteiro(entrada[i]) ? "SIM " : "NAO ");
            System.out.println(isNumeroReal(entrada[i]) ? "SIM" : "NAO");

        }

    }

}
