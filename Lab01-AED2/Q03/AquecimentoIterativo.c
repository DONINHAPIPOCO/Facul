#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int contaMaiusculo(char palavra[40]){
    if(strlen(palavra) > 0) {
        int resp = 0;
        for(int i = 0; i < strlen(palavra); i++) {
            if(palavra.charAt(i) >= 65 && palavra.charAt(i) <= 90) {
                resp += 1;

            }

        }

        return resp;

    } else {
        printf("ERRO! Palavra Vazia!!!");

    }

}

void main() {
    char entrada[30][40];
    int numEntrada = 0;

    FILE* file;
    file = fopen("pub.in", "r");

    char line[40];
    scanf(" %[^\n]s", line);

    

    try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
        String line = "";

        while((line = br.readLine()) != null && !"FIM".equals(line)) {
            entrada[numEntrada] = line;
            numEntrada++;

        }
    
            
    

    for(int i = 0; i < numEntrada; i++) {
        System.out.println(contaMaiusculo(entrada[i]));

    }

}