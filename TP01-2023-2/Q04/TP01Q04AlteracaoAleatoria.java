import java.util.Random;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/*
 * Class Alteração Aleatória v7.0.
 * @author Luis Felipe Souza Lopes - 654663.
 * @lastUpdate 13/07/2023.
 * 
 */
public class TP01Q04AlteracaoAleatoria {
    /*
     * Método alteracaoAleatoria(String palavra) - Sorteia dois caracteres aleatórios e troca as ocorrências do primeiro pelo segundo caractere na String recebida.
     * @param String palavra - Palavra a ser alterada.
     * @return String resp - Palavra com as alterações feitas.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static String alteracaoAleatoria(String palavra, Random gerador) throws Exception{
        if(palavra.equals("") || palavra == null){
            throw new Exception("ERRO! Palavra vazia!");

        } else{
            //String de retorno.
            String resp = "";
            char atual;

            //geração dos caracteres aleatórios.
            char letra1 = (char)('a' + Math.abs(gerador.nextInt() % 26));
            //System.out.println("LETRA 1: " + letra1);
            char letra2 = (char)('a' + Math.abs(gerador.nextInt() % 26));
            //System.out.println("LETRA 2: " + letra2);

            //iteração para gerar a saída com as letra trocadas
            for(int i = 0; i < palavra.length(); i++){            
                atual = palavra.charAt(i);
                if(atual == letra1){
                    //System.out.println("TROCANDO: " + letra1 + " POR " + letra2);
                    resp += letra2;

                } else {
                    resp += atual;

                }

            }
        
            //retornar String montada
            return resp;
            
        }
        
        
    }

    /*
     * Método main(String[] agrs) - ler a entrada padrão e fazer as chamadas para gerar a saída padrão.
     * @author Luis Felipe Souza Lopes.
     * @version 7.0.
     * @lastUpdate 13/07/2023.
     * 
     */
    public static void main(String[] args) throws Exception{
        //array de Strings para entrada, int para percorrer e Scanner para fazer a leitura.
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

        Random gerador = new Random();
        gerador.setSeed(4);
        
        //iteração para printar a saída contendo as palavras com as letras trocadas.
        for(int i = 0; i < numEntrada; i++){
            System.out.println(alteracaoAleatoria(entrada[i], gerador));

        }
    }
}
