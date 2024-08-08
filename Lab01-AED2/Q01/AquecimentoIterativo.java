import java.io.BufferedReader;
import java.io.IOError;
import java.io.IOException;
import java.io.InputStreamReader;

class AquecimentoIterativo {
    public static int contaMaiusculo(String palavra) throws Exception{
        if(!"".equals(palavra)) {
            int resp = 0;
            for(int i = 0; i < palavra.length(); i++) {
                if(palavra.charAt(i) >= 65 && palavra.charAt(i) <= 90) {
                    resp += 1;

                }

            }

            return resp;

        } else {
            throw new Exception("ERRO! Palavra Vazia!!!");

        }

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