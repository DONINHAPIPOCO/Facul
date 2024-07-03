import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.IOException;

/*
 * Class Ciframento v7.0.
 * @author Luis Felipe Souza Lopes - 654663.
 * @lastUpdate 29/06/2023.
 */
class TP01Q03Ciframento{
    /*
     * Método cifra(String palavra, int chave) - Gera a palavra cifrada com base na chave recebida.
     * @param String palavra - Palavra a ser cifrada.
     * @param int chave - Chave que será utilizada no deslocamento das letras.
     * @return String cifra - Palavra cifrada.
     * @author Luis Felipe Souza Lopes - 654663
     * @version 7.0
     * @lastUpdate 29/06/2023.
     */
    public static String cifra(String palavra, int chave){
        String cifra = "";
        char cifrado, atual;
        
        for(int i = 0; i < palavra.length(); i++){
            
            atual = palavra.charAt(i);
            //System.out.println("CHAR ATUAL: " + palavra.charAt(i) + " VALOR ASCII: " + atual);
            cifrado = atual;
            //System.out.println("CHAR ATUAL CIFRADO: " + cifrado + " VALOR ASCII: " + (atual + chave));
            
            if(atual >= 32 && atual <= 126){
                cifrado = (char) (atual + chave);
                if(cifrado > 126){
                    cifrado = (char)(cifrado - 95);

                } else if(cifrado < 32){
                    cifrado = (char)(cifrado + 95);

                }

            }

            cifra += cifrado;
            //System.out.println("CIFRA: " + cifra + "\n");

        }

        return cifra;

    }

    /*
     * Método main(String[] args) - imprimir as mensagens cifradas.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 29/06/2023.
    */
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
            System.out.println(cifra(entrada[i], 3));

        }

    }


}