import java.util.Random;
import java.util.Scanner;

/*
 * Classe uteisIO - v1.0
 * Coleção de métodos úteis para AEDII.
 * @author Luis Felipe Souza Lopes - 654663.
 * 
 */
public class uteisIO {
    /*
     * Método readEntradaComFim() - Fazer leitura da entrada padrão das questões (caso entrada acabe com a palavra "FIM").
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 29/06/2023.
     */

     public static String[] readEntradaComFim(){
        Scanner scan = new Scanner(System.in);
        String[] entrada = new String[5000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = scan.nextLine();
            numEntrada++;

        }while(scan.nextLine().equals("FIM"));
        
        scan.close();

        return entrada;

    }

    /*
     * Método readEntrada() - Fazer leitura da entrada padrão das questões.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 29/06/2023.
     */
    public static String[] readEntradaString(){
        Scanner scan = new Scanner(System.in);
        String[] entrada = new String[5000];
        int numEntrada = 0;

        do{
            entrada[numEntrada] = scan.nextLine();
            numEntrada++;

        }while(scan.hasNext());
        
        scan.close();

        return entrada;

    }

    /*
     * Método getRandomInt() - Gerar um int aleatório.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 29/06/2023.
     */
    public static int getRandomInt(int seed){
        Random gerador = new Random();
        gerador.setSeed(seed);
        return Math.abs(gerador.nextInt());

    }

    /*
     * Método getRandomChar() - Gerar um char aleatório.
     * @author Luis Felipe Souza Lopes - 654663.
     * @v1.0
     * @lastUpdate 29/06/2023.
     */
    public static char getRandomChar(int seed){
        Random gerador = new Random();
        gerador.setSeed(seed);
        return (char)(Math.abs(gerador.nextInt()) % 26);

    }
}
