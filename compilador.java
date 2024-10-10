import java.util.*;
import java.io.*;

public class compilador{
    public static Scanner sc = new Scanner(System.in);

    public static char opCode(String Mnemonico){
        char op = '0';
        switch (Mnemonico) {
            case "umL;":
                op = '0';
                break;
            
            case "AonB;":
                op = '1';
                break;
            
            case "copiaA;":
                op = '2';
                break;
            
            case "nAxnB;":
                op = '3';
                break;
            
            case "AeBn;":
                op = '4';
                break;
            
            case "nA;":
                op = '5';
                break;
            
            case "AenB;":
                op = '6';
                break;
            
            case "nAonB;":
                op = '7';
                break;
            
            case "AxB;":
                op = '8';
                break;
            
            case "zeroL;":
                op = '9';
                break;
            
            case "copiaB;":
                op = 'A';
                break;
            
            case "AeB;":
                op = 'B';
                break;
            
            case "nB;":
                op = 'C';
                break;
            
            case "nAeBn;":
                op = 'D';
                break;
            
            case "AoB;":
                op = 'E';
                break;
            
            case "nAeB;":
                op = 'F';
                break;
            
            default:
                break;
        }
        return op;
    }
    public static void main(String[] args) throws IOException{
        System.out.println("Digite o nome do arquivo a ser lido:"); //nome do arquivo
        String arquivo = sc.next();
        FileReader file = new FileReader(arquivo);
        BufferedReader buffer = new BufferedReader(file);
        
        String linha;
        char X = '0', Y = '0', W = '0';
        
        linha = buffer.readLine();  //linha contendo "inicio"
        
        BufferedWriter writer = new BufferedWriter(new FileWriter("arquivo.hex"));  //criando reader para arquivo.hex

        while ((linha = buffer.readLine()) != null && !linha.equals("fim.")){
            switch (linha.charAt(0)) {
                case 'X':
                    X = linha.charAt(2);
                    break;
            
                case 'Y':
                    Y = linha.charAt(2);
                    break;
                
                case 'W':
                    W = opCode(linha.substring(linha.indexOf('=') + 1));
                    //escrever (X+Y+W) em arquivo.hex
                    writer.write(X);
                    writer.write(Y);
                    writer.write(W);
                    writer.newLine();
                    break;
            
                default:
                    break;
            }
        }
        
        buffer.close();
        writer.close();
    }   
}
