#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ALTERNATE_NAMES 5000
#define NOME_ARQUIVO "/tmp/characters.csv"
#define MAX_STRING_LENGTH 50
#define MIN_STRING_LENGTH 20
#define MAX_COLOR_LENGTH 10

typedef struct{
    char id[MAX_STRING_LENGTH];
    char name[MAX_STRING_LENGTH];
    char alternate_names[MAX_ALTERNATE_NAMES][MAX_STRING_LENGTH];
    int numAlternateNames;
    char house[MIN_STRING_LENGTH];
    char ancestry[MIN_STRING_LENGTH];
    char species[MIN_STRING_LENGTH];
    char patronus[MIN_STRING_LENGTH];
    int hogwartsStaff;
    int hogwartsStudent;
    char actorName[MAX_STRING_LENGTH];
    int alive;
    char dateOfBirth[MIN_STRING_LENGTH];
    int yearOfBirth;
    char eyeColour[MAX_COLOR_LENGTH];
    char gender[MIN_STRING_LENGTH];
    char hairColour[MAX_COLOR_LENGTH];
    int wizzard;

} Personagem;

Personagem* inicializar(){
    Personagem* personagem = (Personagem*)malloc(sizeof(Personagem));

    if(personagem != NULL){
        strcpy(personagem->id, "");
        strcpy(personagem->name, "");
        personagem->numAlternateNames = 0;
        strcpy(personagem->house, "");
        strcpy(personagem->ancestry, "");
        strcpy(personagem->species, "");
        strcpy(personagem->patronus, "");
        personagem->hogwartsStaff = 0;
        personagem->hogwartsStudent = 0;
        strcpy(personagem->actorName, "");
        personagem->alive = 0;
        strcpy(personagem->dateOfBirth, "");
        personagem->yearOfBirth = -1;
        strcpy(personagem->eyeColour, "");
        strcpy(personagem->gender, "");
        strcpy(personagem->hairColour, "");
        personagem->wizzard = 0;

    }

    return personagem;

}

void freePersonagem(Personagem* personagem){
    free(personagem);

}

Personagem* clone(Personagem* personagem){
    Personagem* clone = inicializar();

    if(clone != NULL){
        strcpy(clone->id, personagem->id);
        strcpy(clone->name, personagem->name);
        clone->numAlternateNames = personagem->numAlternateNames;
        for(int i = 0; i < personagem->numAlternateNames; i++){
            strcpy(clone->alternate_names[i], personagem->alternate_names[i]);

        }
        strcpy(clone->house, personagem->house);
        strcpy(clone->ancestry, personagem->ancestry);
        strcpy(clone->species, personagem->species);
        strcpy(clone->patronus, personagem->patronus);
        clone->hogwartsStaff = personagem->hogwartsStaff;
        clone->hogwartsStudent = personagem->hogwartsStudent;
        strcpy(clone->actorName, personagem->actorName);
        clone->alive = personagem->alive;
        strcpy(clone->dateOfBirth, personagem->dateOfBirth);
        clone->yearOfBirth = personagem->yearOfBirth;
        strcpy(clone->eyeColour, personagem->eyeColour);
        strcpy(clone->gender, personagem->gender);
        strcpy(clone->hairColour, personagem->hairColour);
        clone->wizzard = personagem->wizzard;

    }

    return clone;

}

void print(Personagem* personagem){
    printf("[%s ## %s ## {", personagem->id, personagem->name);

    for(int i = 0; i < personagem->numAlternateNames; i++){
        printf("%s", personagem->alternate_names[i]);
        if(i < personagem->numAlternateNames - 1){
            printf(", ");

        }

    }

    printf("} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", personagem->house, personagem->ancestry, personagem->species, 
            personagem->patronus, personagem->hogwartsStaff ? "true" : "false", personagem->hogwartsStudent ? "true" : "false", personagem->actorName, personagem->alive ? "true" : "false", 
            personagem->dateOfBirth, personagem->yearOfBirth, personagem->eyeColour, personagem->gender, personagem->hairColour, personagem->wizzard ? "true" : "false");

}

Personagem** ler(const char* nomeArquivo, int* numPersonagens) {
    FILE* arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        printf("Erro ao abrir o arquivo.\n");
        exit(1);
    }

    Personagem** personagens = (Personagem**)malloc(sizeof(Personagem*) * MAX_ALTERNATE_NAMES);
    if (personagens == NULL) {
        printf("Erro de alocação de memória.\n");
        exit(1);
    }

    *numPersonagens = 0;
    char linha[1024];
    while (fgets(linha, sizeof(linha), arquivo)) {
        Personagem* personagem = inicializar();
        if (personagem == NULL) {
            printf("Erro de alocação de memória.\n");
            exit(1);
        }

        sscanf(linha, "%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%d;%d;%[^;];%d;%[^;];%d;%[^;];%[^;];%[^;];%[^;];%d",
               personagem->id, personagem->name,
               personagem->alternate_names[0], personagem->house,
               personagem->ancestry, personagem->species,
               personagem->patronus, &personagem->hogwartsStaff,
               &personagem->hogwartsStudent, personagem->actorName,
               &personagem->alive, personagem->dateOfBirth,
               &personagem->yearOfBirth, personagem->eyeColour,
               personagem->gender, personagem->hairColour,
               &personagem->wizzard);

        // Contar o número de nomes alternativos
        personagem->numAlternateNames = 1;
        for (int i = 0; personagem->alternate_names[0][i]; i++) {
            if (personagem->alternate_names[0][i] == ',') {
                personagem->numAlternateNames++;
            }
        }

        personagens[*numPersonagens] = personagem;
        (*numPersonagens)++;
    }

    fclose(arquivo);
    return personagens;
}

Personagem* pesquisarPorID(const char* id, Personagem** personagens, int numPersonagens) {
    for (int i = 0; i < numPersonagens; i++) {
        if (strcmp(personagens[i]->id, id) == 0) {
            return personagens[i];

        }
    }

    return NULL;
}

int main(){
    int numPersonagens;
    Personagem** personagens = ler(NOME_ARQUIVO, &numPersonagens);

    char entrada[5000][50];
    int numEntrada = 0;
    char linha[50];

    while (scanf("%s", linha) != EOF && strcmp(linha, "FIM") != 0) {
        strcpy(entrada[numEntrada], linha);
        numEntrada++;

    }

    for (int i = 0; i < numEntrada; i++) {
        Personagem* encontrado = pesquisarPorID(entrada[i], personagens, numPersonagens);
        if (encontrado != NULL) {
            print(encontrado);

        }

    }

    for (int i = 0; i < numPersonagens; i++) {
        freePersonagem(personagens[i]);

    }

    free(personagens);

    return 0;

}