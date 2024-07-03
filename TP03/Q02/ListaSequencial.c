#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ALTERNATE_NAMES 5000
#define NOME_ARQUIVO "/tmp/characters.csv"
//#define NOME_ARQUIVO "C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv"
#define MAX_STRING_LENGTH 50
#define MIN_STRING_LENGTH 20
#define MAX_COLOR_LENGTH 10

typedef struct {
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

Personagem* inicializar() {
    Personagem* personagem = (Personagem*)malloc(sizeof(Personagem));
    if (personagem != NULL) {
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

void freePersonagem(Personagem* personagem) {
    free(personagem);
}

Personagem* clone(Personagem* personagem) {
    Personagem* clone = inicializar();
    if (clone != NULL) {
        strcpy(clone->id, personagem->id);
        strcpy(clone->name, personagem->name);
        clone->numAlternateNames = personagem->numAlternateNames;
        for (int i = 0; i < personagem->numAlternateNames; i++) {
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

void print(Personagem* personagem) {
    printf("[%s ## %s ## {", personagem->id, personagem->name);
    for (int i = 0; i < personagem->numAlternateNames; i++) {
        printf("%s", personagem->alternate_names[i]);
        if (i < personagem->numAlternateNames - 1) {
            printf(", ");
        }
    }
    printf("} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", 
           personagem->house, personagem->ancestry, personagem->species, 
           personagem->patronus, personagem->hogwartsStaff ? "true" : "false", 
           personagem->hogwartsStudent ? "true" : "false", personagem->actorName, 
           personagem->alive ? "true" : "false", personagem->dateOfBirth, 
           personagem->yearOfBirth, personagem->eyeColour, personagem->gender, 
           personagem->hairColour, personagem->wizzard ? "true" : "false");
}

Personagem** ler(const char* nomeArquivo, int* numPersonagens) {
    printf("Tentando abrir o arquivo: %s\n", nomeArquivo);
    FILE* arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        perror("Erro ao abrir o arquivo");
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

typedef struct {
    Personagem* lista[5000];
    int elementos;
} Lista;

Lista* inicializarLista(){
    Lista* lista = (Lista*)malloc(sizeof(Lista));
    if(lista != NULL){
        lista->elementos = 0;
    }
    return lista;
}

void inserirInicio(Lista* lista, Personagem* personagem){
    if(personagem == NULL){
        printf("ERRO AO INSERIR (INÍCIO)! Personagem NULO!!!\n");
    } else if(lista->elementos == 5000){
        printf("ERRO AO INSERIR (INÍCIO)! Lista Cheia!!!\n");
    } else {
        for(int i = lista->elementos; i > 0; i--){
            lista->lista[i] = lista->lista[i-1];
        }
        lista->lista[0] = personagem;
        lista->elementos++;
    }
}

void inserir(Lista* lista, Personagem* personagem, int posicao){
    if(personagem == NULL){
        printf("ERRO AO INSERIR! Personagem NULO!!!\n");
    } else if(lista->elementos == 5000){
        printf("ERRO AO INSERIR! Lista Cheia!!!\n");
    } else if(posicao > lista->elementos || posicao < 0){
        printf("ERRO AO INSERIR! Posição Inválida!!!\n");
    } else {
        for(int i = lista->elementos; i > posicao; i--){
            lista->lista[i] = lista->lista[i-1];
        }
        lista->lista[posicao] = personagem;
        lista->elementos++;
    }
}

void inserirFim(Lista* lista, Personagem* personagem){
    if(personagem == NULL) {
        printf("ERRO AO INSERIR! Personagem NULO!!!\n");
    } else if(lista->elementos == 5000) {
        printf("ERRO AO INSERIR! Lista Cheia!!!\n");
    } else {
        lista->lista[lista->elementos] = personagem;
        lista->elementos++;
    }
}

Personagem* removerInicio(Lista* lista){
    if(lista->elementos == 0) {
        printf("ERRO AO REMOVER (INÍCIO)! Lista Vazia!!!\n");
        return NULL;
    } else {
        Personagem* resp = lista->lista[0];
        for(int i = 0; i < lista->elementos - 1; i++){
            lista->lista[i] = lista->lista[i + 1];
        }
        lista->elementos--;
        return resp;
    }
}

Personagem* remover(Lista* lista, int posicao){
    if(lista->elementos == 0) {
        printf("ERRO AO REMOVER! Lista Vazia!!!\n");
        return NULL;
    } else if(posicao >= lista->elementos || posicao < 0) {
        printf("ERRO AO REMOVER! Posição Inválida!!!\n");
        return NULL;
    } else {
        Personagem* resp = lista->lista[posicao];
        for(int i = posicao; i < lista->elementos - 1; i++){
            lista->lista[i] = lista->lista[i + 1];
        }
        lista->elementos--;
        return resp;
    }
}

Personagem* removerFim(Lista* lista){
    if(lista->elementos == 0) {
        printf("ERRO AO REMOVER! Lista Vazia!!!\n");
        return NULL;
    } else {
        Personagem* resp = lista->lista[lista->elementos - 1];
        lista->elementos--;
        return resp;
    }
}

    

int main() {
    char entrada[5000][50];
    char operacoes[5000][50];
    int numEntrada = 0, numOperacoes = 0;
    char linha[50];

    // Ler entradas
    while (fgets(linha, sizeof(linha), stdin) && strcmp(linha, "FIM\n") != 0) {
        strcpy(entrada[numEntrada], strtok(linha, "\n"));
        numEntrada++;
    }

    // Ignorar linha com número de operações
    fgets(linha, sizeof(linha), stdin);

    // Ler operações
    while (fgets(linha, sizeof(linha), stdin)) {
        strcpy(operacoes[numOperacoes], strtok(linha, "\n"));
        numOperacoes++;
    }

    int numPersonagens;
    Personagem** personagens = ler(NOME_ARQUIVO, &numPersonagens);
    Lista* lista = inicializarLista();

    char removidos[1000][50];
    int numRemovidos = 0;

    // Preencher a lista sequencial
    for (int i = 0; i < numEntrada; i++) {
        Personagem* personagem = pesquisarPorID(entrada[i], personagens, numPersonagens);
        if (personagem != NULL) {
            inserirFim(lista, personagem);
        }
    }

    // Realizar operações
    for (int i = 0; i < numOperacoes; i++) {
        char* splits[3];
        int j = 0;
        splits[j] = strtok(operacoes[i], " ");
        while (splits[j] != NULL) {
            j++;
            splits[j] = strtok(NULL, " ");
        }

        if (strcmp(splits[0], "II") == 0) {
            Personagem* personagem = pesquisarPorID(splits[1], personagens, numPersonagens);
            inserirInicio(lista, personagem);
        } else if (strcmp(splits[0], "IF") == 0) {
            Personagem* personagem = pesquisarPorID(splits[1], personagens, numPersonagens);
            inserirFim(lista, personagem);
        } else if (strcmp(splits[0], "I*") == 0) {
            Personagem* personagem = pesquisarPorID(splits[2], personagens, numPersonagens);
            inserir(lista, personagem, atoi(splits[1]));
        } else if (strcmp(splits[0], "RI") == 0) {
            Personagem* removido = removerInicio(lista);
            if (removido != NULL) {
                strcpy(removidos[numRemovidos], removido->name);
                numRemovidos++;
            }
        } else if (strcmp(splits[0], "RF") == 0) {
            Personagem* removido = removerFim(lista);
            if (removido != NULL) {
                strcpy(removidos[numRemovidos], removido->name);
                numRemovidos++;
            }
        } else if (strcmp(splits[0], "R*") == 0) {
            Personagem* removido = remover(lista, atoi(splits[1]));
            if (removido != NULL) {
                strcpy(removidos[numRemovidos], removido->name);
                numRemovidos++;
            }
        }
    }

    // Imprimir nomes dos personagens removidos
    for (int i = 0; i < numRemovidos; i++) {
        printf("(R) %s\n", removidos[i]);
    }

    // Imprimir personagens na lista
    for (int i = 0; i < lista->elementos; i++) {
        printf("[%d ## ", i);
        print(lista->lista[i]);
    }

    // Limpar memória
    for (int i = 0; i < numPersonagens; i++) {
        freePersonagem(personagens[i]);
    }
    free(personagens);
    free(lista);

    return 0;
}



