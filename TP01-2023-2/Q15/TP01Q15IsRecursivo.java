/*
 * Class Is v7.0.
 * @author Luis Felipe Souza Lopes.
 * @lastUpdate 18/07/2023
 * 
 */

 import java.io.BufferedReader;
 import java.io.IOException;
 import java.io.InputStreamReader;
 
 public class TP01Q15IsRecursivo {
    public static boolean isFormadoPorVogal(String palavra){
        return isFormadoPorVogal(palavra, 0, true);
 
    }

    private static boolean isFormadoPorVogal(String palavra, int i, boolean resp){
        if(i < palavra.length()){
            if(palavra.charAt(i) != 'a' && palavra.charAt(i) != 'A' && palavra.charAt(i) != 'e' && palavra.charAt(i) != 'E' && palavra.charAt(i) != 'i' && palavra.charAt(i) != 'I' 
            && palavra.charAt(i) != 'o' && palavra.charAt(i) != 'O' && palavra.charAt(i) != 'u' && palavra.charAt(i) != 'U'){
                resp = false;
                 
            } else {
                resp = isFormadoPorVogal(palavra, i + 1, resp);

            }

        }

        return resp;

    }
 
     public static boolean isFormadoPorConsoante(String palavra){
        return isFormadoPorConsoante(palavra, 0, true);
 
    }

    private static boolean isFormadoPorConsoante(String palavra, int i, boolean resp){
        if(i < palavra.length()){
            if(palavra.charAt(i) == 'a' || palavra.charAt(i) == 'A' || palavra.charAt(i) == 'e' || palavra.charAt(i) == 'E' || palavra.charAt(i) == 'i' || palavra.charAt(i) == 'I' 
            || palavra.charAt(i) == 'o' || palavra.charAt(i) == 'O' || palavra.charAt(i) == 'u' || palavra.charAt(i) == 'U' || palavra.charAt(i) >= '0' || palavra.charAt(i) <= '9'){
                resp = false;
                 
            } else {
                resp = isFormadoPorConsoante(palavra, i + 1, resp);

            }

        }

        return resp;

    }
 
     public static boolean isNumeroInteiro(String palavra){
        return isNumeroInteiro(palavra, 0, true);
 
     }

    private static boolean isNumeroInteiro(String palavra, int i, boolean resp){
        if(i < palavra.length()){
            if(palavra.charAt(i) < '0' || palavra.charAt(i) > '9'){
                resp = false;
                
            } else {
                resp = isNumeroInteiro(palavra, i + 1, resp);

            }

        }

        return resp;

    }
 
    public static boolean isNumeroReal(String palavra){
        return isNumeroReal(palavra, 0, true, 0);
 
    }

    private static boolean isNumeroReal(String palavra, int i, boolean resp, int contagemDePontos){
        if(i < palavra.length()){
            char c = palavra.charAt(i);
            //System.out.print("CARACTERE ATUAL: " + c + " ");
            if(!Character.isDigit(c)){
                if(c == '.' || c == ','){
                    //System.out.print("ATUALIZANDO CONTAGEM DE PONTOS DE: " + contagemDePontos + " ");
                    contagemDePontos++;
                    //System.out.println("PARA: " + contagemDePontos);
                    if(contagemDePontos > 1){
                        resp = false;

                    } else {
                        resp = isNumeroReal(palavra, i + 1, resp, contagemDePontos);

                    }

                } else {
                    resp = false;

                }
                
            } else {
                resp = isNumeroReal(palavra, i + 1, resp, contagemDePontos);

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
 
