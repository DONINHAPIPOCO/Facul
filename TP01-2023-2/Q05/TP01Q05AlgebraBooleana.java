/*
 * Class Álgebra Booleana v7.0.
 * @author Luis Felipe Souza Lopes.
 * @lastUpdate 18/07/2023.
 * 
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class TP01Q05AlgebraBooleana {
    /*
     * Método boolean algebraBooleana2Entradas(String expressao, int entrada1, int entrada2) - Recebe uma expressão e duas entradas, e retorna a expressão resolvida.
     * @param String expressao - Expressão a ser resolvida.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 4.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean algebraBooleana2Entradas(String expressao, int entrada1, int entrada2){
        boolean resp = false;

        return resp;

    }

    /*
     * Método boolean algebraBooleana3Entradas(String expressao, int entrada1, int entrada2, int entrada3) - Recebe uma expressão e três entradas, e retorna a expressão resolvida.
     * @param String expressao - Expressão a ser resolvida.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @param int entrada3 - Terceira entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 4.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean algebraBooleana3Entradas(String expressao, int entrada1, int entrada2, int entrada3){
        boolean resp = false;

        return resp;

    }

    /*
     * Método boolean and2Entradas(int entrada1, int entrada2) - Método auxiliar para resolver expressões and com duas entradas.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean and2Entradas(int entrada1, int entrada2) throws Exception{
        return (entrada1 == 1 && entrada2 == 1);

    }

    /*
     * Método boolean and3Entradas(int entrada1, int entrada2, int entrada3) - Método auxiliar para resolver expressões and com três entradas.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @param int entrada3 - Terceira entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean and3Entradas(int entrada1, int entrada2, int entrada3) throws Exception{
        return (entrada1 == 1 && entrada2 == 1 && entrada3 == 1);

    }

    /*
     * Método boolean or2Entradas(int entrada1, int entrada2) - Método auxiliar para resolver expressões or com duas entradas.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean or2Entradas(int entrada1, int entrada2) throws Exception{
        return (entrada1 == 1 || entrada2 == 1);

    }

    /*
     * Método boolean or3Entradas(int entrada1, int entrada2, int entrada3) - Método auxiliar para resolver expressões or com 3 entradas.
     * @param int entrada1 - Primeira entrada.
     * @param int entrada2 - Segunda entrada.
     * @param int entrada3 - Terceira entrada.
     * @return boolean resp - Booleano contendo o resultado da expressão.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static boolean or3Entradas(int entrada1, int entrada2, int entrada3) throws Exception{
        return (entrada1 == 1 || entrada2 == 1 || entrada3 == 1);

    }

    public static boolean not(int entrada){
        return !(entrada == 1);

    }

    /*
     * Método main(String[] args) - ler a entrada padrão e gerar a saída padrão.
     * @authos Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 20/03/2024.
     * 
     */
    public static void main(String[] args) throws Exception{
        String[] entrada = new String[5000];
        int numEntrada = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line = "";

            while((line = br.readLine()) != null){
                if(!line.equals("FIM")){
                    entrada[numEntrada] = line;
                    numEntrada++;

                }

            }

        } catch(IOException e){
            System.out.println(e);

        }

        for(int i = 0; i < numEntrada; i++){
            if(entrada[i].charAt(0) == '2'){
                int[] entradasExpressao = new int[2];
                entradasExpressao[0] = entrada[i].charAt(2);
                entradasExpressao[1] = entrada[i].charAt(4);

                for(int j = entrada[i].length() - 1; j >= 0; j--){
                    if(entrada[i].charAt(j) == '('){
                        if(entrada[i].charAt(j-1) == 'd'){
                            System.out.println(and2Entradas(entradasExpressao[0], entradasExpressao[1]) ? "1" : "0");


                        } else if(entrada[i].charAt(j - 1) == 'r'){


                        } else {
                            

                        }

                    }

                }

            } else {
                int[] entradasExpressao = new int[3];
                entradasExpressao[0] = entrada[i].charAt(2);
                entradasExpressao[1] = entrada[i].charAt(4);
                entradasExpressao[2] = entrada[i].charAt(6);

            }

        }

    }

}
