import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

public class TP01Q08Arquivo {
    
    public static void main(String[] args){
        
        try{
            RandomAccessFile reader = new RandomAccessFile("pub.in", "r");
            RandomAccessFile writer = new RandomAccessFile("arquivo.txt", "rw");
            char input;
            
            for(int i = 0; i < reader.length(); i--){
                
                reader.seek(i);
                input = reader.readChar();
                writer.write(input);

            }
            

            reader.close();
            writer.close();

           RandomAccessFile file = new RandomAccessFile("arquivo.txt", "r");

            long posicao = file.length()-1;
            //System.out.println(posicao);

            while(posicao > 0){
                //posicao--;
                file.seek(posicao);
                char caractere = file.readChar();
                if (caractere == '\n') {
                    posicao--;
                    file.seek(posicao);
                }

                System.out.print(caractere);

            }

            file.close();

        } catch(IOException e){
            System.out.println(e);

        }

        

    }
}
