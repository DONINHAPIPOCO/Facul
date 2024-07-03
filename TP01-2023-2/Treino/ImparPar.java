import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ImparPar {
    public static void main(String[] args){
        String[] entrada = new String[5000];
        int numEntrada = 0;

        try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))){
            String line;

            while((line = br.readLine()) != null){
                if(!line.equals("0")){
                    entrada[numEntrada] = line;
                    numEntrada++;

                }

            }

        } catch(IOException e){
            System.out.println(e);

        }

        for(int i = 0; i < numEntrada; i++){
            if(Integer.parseInt(entrada[i]) % 2 == 0){
                System.out.println("P");

            } else {
                System.out.println("I");

            }

        }

    }
}
