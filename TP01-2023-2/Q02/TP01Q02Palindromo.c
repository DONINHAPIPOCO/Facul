#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

int isPalindromo(char palavra[30]){
    int resp = 1, j = 0;

    //palavra[strcspn(palavra, "\n")] = '\0';

    printf("%s\n", palavra);
    //for(int i = strlen(palavra) - 1; i > j; i--, j++){
        printf("j: %c - i: %c\n", palavra[j], palavra[i]);
        
        if(palavra[j] != palavra[i]){
            resp = 0;
            j = i + 1;

        }
        
    }

    return resp;

}

int main(){
    FILE *entrada;
    int numEntrada = 0;
    char linha[30];

    entrada = fopen("pub.in", "r");
    if(entrada == NULL){
        printf("ERRO NA LEITURA DA ENTRADA!");

    }

    while(fgets(linha, sizeof(linha), entrada) != NULL){
        //printf("LINHA: %s", linha);
        if(isPalindromo(linha) == 1){
            printf("SIM\n");

        } else {
            printf("NAO\n");

        }

    }

    fclose(entrada);

    return 0;

}