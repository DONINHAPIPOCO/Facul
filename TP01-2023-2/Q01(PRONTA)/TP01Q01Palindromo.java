

/*
 * Class Palindromo v7.0.
 * @author Luis Felipe Souza Lopes - 654663.
 * @lastUpdate 27/02/2024.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class TP01Q01Palindromo{
    /*
     * Método isPalindromo(String palavra) - Recebe uma palavra e retorna true caso seja um palíndromo, e false caso não seja.
     * @param palavra - String a ser analizada.
     * @return true - if palíndromo.
     * @return false - if not palíndromo.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 27/02/2024.
     */
    public static boolean isPalindromo(String palavra){
        
        //variáveis(resposta, inverso).
        boolean resp = false;
        String inverso = "";

        //copiar palavra de trás pra frente.
        for(int i = (palavra.length() - 1); i >= 0; i--){
            inverso += palavra.charAt(i);

        }
        
        //se palavra = clone -> resposta = true.
        if(palavra.equals(inverso)) resp = true;
        
        //retornar resposta.
        return resp;


    }

    /*
     * Método main(String[] args) - Imprimir SIM caso as palavras da entrada sejam palindromos ou NAO caso não sejam.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 03/03/2024.
     */
    public static void main(String[] args){
        
        //array de entrada e numero de entradas.
        String[] entrada = new String[5000];
        int numEntrada = 0;
        
        //realizar leitura da entrada.
        try(BufferedReader bf = new BufferedReader(new InputStreamReader(System.in))){
            String line = "";
            
            do{
                line = bf.readLine();

                if(line != null && !line.equals("FIM")){
                    entrada[numEntrada] = line;
                    numEntrada++;
                    
                }

            }while(!line.equals("FIM"));

        } catch(IOException e){
            System.out.println(e);

        }

        for(int i = 0; i < numEntrada; i++){
            if(isPalindromo(entrada[i]) == true){
                //System.out.print(entrada[i] + " ");
                System.out.println("SIM");

            } else {
                //System.out.print(entrada[numEntrada] + " ");
                System.out.println("NAO");

            }

        }

        

    }

}