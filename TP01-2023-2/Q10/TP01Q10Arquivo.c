#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){

    FILE* pubIn;
    char linha[100];
    char caractere;

    pubIn = fopen("pub.in", "r");
    if(pubIn == NULL) printf("ERRO NA LEITURA DO ARQUIVO!!");

    FILE* arquivo;
    arquivo = fopen("arquivo.txt", "w");
    if(arquivo == NULL) printf("ERRO NA LEITURA DO ARQUIVO!!");

    while((caractere = fgetc(pubIn)) != EOF){
        fputc(caractere, arquivo);

    }

    fclose(arquivo);
    fclose(pubIn);

    arquivo = fopen("arquivo.txt", "r");

    fseek(arquivo, 0, SEEK_END);
    int tamArquivo = ftell(arquivo);

    for(int i = tamArquivo - 1; i >= 0; i--){
        fseek(arquivo, i, SEEK_SET);
        if(fgetc(arquivo) == '\n'){
            fgets(linha, sizeof(linha), arquivo);
            printf("%s", linha);
            i--;

        }
        
    }

    fclose(arquivo);

    return 0;

}