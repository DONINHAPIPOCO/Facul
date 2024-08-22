/*
 * Class Is v7.0.
 * @author Luis Felipe Souza Lopes.
 * @lastUpdate 18/07/2023
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IsRecursivo {
    public static boolean isFormadoPorVogal(String palavra) throws Exception {
        if(!"".equals(palavra)) {
            return isFormadoPorVogal(palavra, 0, true);

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

    }
    
    private static boolean isFormadoPorVogal(String palavra, int i, boolean resp) throws Exception{
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

    public static boolean isFormadoPorConsoante(String palavra) throws Exception{
        if(!"".equals(palavra)) {
            return isFormadoPorConsoante(palavra, 0, true);

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

    }

    private static boolean isFormadoPorConsoante(String palavra, int i, boolean resp) throws Exception{
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

    public static boolean isNumeroInteiro(String palavra) throws Exception{
        if(!"".equals(palavra)) {
            return isNumeroInteiro(palavra, 0, true);

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

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

    public static boolean isNumeroReal(String palavra) throws Exception{
        if(!"".equals(palavra)) {
            return isNumeroReal(palavra, 0, true, 0);

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

    }

    private static boolean isNumeroReal(String palavra, int i, boolean resp, int contagemDePontos) throws Exception{
        if(i < palavra.length()){

            char caractere = palavra.charAt(i);

            //se não for um dígito (inteiro de 0 a 9)
            if(!Character.isDigit(caractere)){

                //confere se o caractere é ponto ou vírgula
                if(caractere == '.' || caractere == ','){
                    
                    //se for sinal de pontuação, soma 1 ao contador de pontuação.
                    contagemDePontos++; 
                    
                    //caso haja mais de uma pontuação, não é um número real.
                    if(contagemDePontos > 1){
                        resp = false;

                    }

                //se não for dígito nem pontuação, também não é um número real.
                } else {
                    resp = false;

                }
            
            //se for dígito, realiza a próxima chamada recursiva.
            } else {
                System.out.println("CHAMADA RECURSIVA COM CONTAGEM DE PONTOS: " + contagemDePontos);
                resp = isNumeroReal(palavra, i + 1, resp, contagemDePontos);

            }

        }

        return resp;

    }

    public static void main(String[] args) throws Exception{
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
