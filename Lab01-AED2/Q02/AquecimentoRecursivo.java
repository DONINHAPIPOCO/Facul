import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class AquecimentoRecursivo {
    public static int contaMaiusculo(String palavra) throws Exception {
        if("".equals(palavra)) {
            throw new Exception("ERRO! Palavra Vazia!!!");

        } else {
            return contaMaiusculo(palavra, 0, 0);

        }

    }
    
    public static int contaMaiusculo(String palavra, int i, int resp) throws Exception{
        if(i < palavra.length()) {
            if(palavra.charAt(i) >= 65 && palavra.charAt(i) <= 90) {
                resp = contaMaiusculo(palavra, i + 1, resp + 1);

            } else {
                resp = contaMaiusculo(palavra, i + 1, resp);

            }

        }

        return resp;

    }

    public static void main(String[] args) throws Exception{
        String[] entrada = new String[30];
        int numEntrada = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String line = "";

            while((line = br.readLine()) != null && !"FIM".equals(line)) {
                entrada[numEntrada] = line;
                numEntrada++;

            }

            
        } catch(IOException e) {
            System.out.println(e);

        }

        for(int i = 0; i < numEntrada; i++) {
            System.out.println(contaMaiusculo(entrada[i]));

        }

    }

}