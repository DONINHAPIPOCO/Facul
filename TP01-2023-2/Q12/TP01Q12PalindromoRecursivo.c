#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>

char inverter(char palavra[50], char inverso[50], int posicao){
    if(posicao < strlen(palavra)){
        inverso = inverter(palavra, inverso, posicao + 1) + palavra[posicao];

    }
        
    return inverso;

}

int isPalindromo(char palavra[50]){
    char inverso[50] = inverter(palavra, "", 0);
        
    return (strcmp(palavra, inverso));

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