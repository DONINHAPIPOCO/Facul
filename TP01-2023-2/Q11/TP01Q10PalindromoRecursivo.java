/*
 * Class Palindromo Recursivo v8.0.
 * @author Luis Felipe Souza Lopes - 654663.
 * @lastUpdate 12/03/2024.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
 
class TP01Q10PalindromoRecursivo{
   
    /*
    * Método isPalindromo(String palavra) - Recebe uma palavra e retorna true caso seja um palíndromo, e false caso não seja.
    * @param palavra - String a ser analizada.
    * @return true - if palíndromo.
    * @return false - if not palíndromo.
    * @author Luis Felipe Souza Lopes - 654663.
    * @v1.0
    * @lastUpdate 12/03/2024.
    */
    public static boolean isPalindromo(String palavra){
        String inverso = inverter(palavra, "", 0);
        
        return (palavra.equals(inverso));

    }


    /*
     * Método inverter(String palavra, String inverso, int posicao) - Método recursivo que retorna o inverso da palavra recebida.
     * @param String palavra - String a ser invertida.
     * @param String inverso - String para armazenar a palavra invertida.
     * @param int posicao - int destinado a manipular a posição dentro da String palavra.
     * @return String inverso - String preenchida com o inverso da palavra recebida.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 12/03/2024.
     */
    private static String inverter(String palavra, String inverso, int posicao){
        if(posicao < palavra.length()){
            inverso = inverter(palavra, inverso, posicao + 1) + palavra.charAt(posicao);

        }
        
        return inverso;

    }
 
    /*
    * Método main(String[] args) - Imprimir SIM caso as palavras da entrada sejam palindromos ou NAO caso não sejam.
    * @author Luis Felipe Souza Lopes - 654663.
    * @v1.0
    * @lastUpdate 12/03/2024.
    */
    public static void main(String[] args){
         
        String[] entrada = new String[5000];
        int numEntrada = 0;
         
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