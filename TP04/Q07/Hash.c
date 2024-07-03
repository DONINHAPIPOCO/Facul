#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MAX_ALTERNATE_NAMES 5000
#define MAX_STRING_LENGTH 100

typedef struct {
    char id[MAX_STRING_LENGTH];
    char name[MAX_STRING_LENGTH];
    char alternate_names[MAX_ALTERNATE_NAMES][MAX_STRING_LENGTH];
    int num_alternate_names;
    char house[MAX_STRING_LENGTH];
    char ancestry[MAX_STRING_LENGTH];
    char species[MAX_STRING_LENGTH];
    char patronus[MAX_STRING_LENGTH];
    int hogwartsStaff;
    int hogwartsStudent;
    char actorName[MAX_STRING_LENGTH];
    int alive;
    char dateOfBirth[MAX_STRING_LENGTH];
    int yearOfBirth;
    char eyeColour[MAX_STRING_LENGTH];
    char gender[MAX_STRING_LENGTH];
    char hairColour[MAX_STRING_LENGTH];
    int wizzard;
} Personagem;

typedef struct Celula {
    Personagem personagem;
    struct Celula *prox;
} Celula;

typedef struct {
    Celula *primeiro;
    Celula *ultimo;
    int elementos;
} ListaFlexivel;

typedef struct {
    Personagem *tabela;
    int tamTabela;
    int numElementos;
    ListaFlexivel reserva;
} HashLista;

int h(char *name, int tamTabela) {
    int resp = 0;
    for (int i = 0; i < strlen(name); i++) {
        resp += (int) name[i];
    }
    return (resp % tamTabela);
}

void inserirInicio(ListaFlexivel *lista, Personagem personagem) {
    Celula *tmp = (Celula*) malloc(sizeof(Celula));
    if (tmp == NULL) {
        fprintf(stderr, "ERRO: Falha na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }
    tmp->personagem = personagem;
    tmp->prox = lista->primeiro->prox;
    lista->primeiro->prox = tmp;
    lista->elementos++;
}

void inserirFim(ListaFlexivel *lista, Personagem personagem) {
    Celula *tmp = (Celula*) malloc(sizeof(Celula));
    if (tmp == NULL) {
        fprintf(stderr, "ERRO: Falha na alocação de memória.\n");
        exit(EXIT_FAILURE);
    }
    tmp->personagem = personagem;
    tmp->prox = NULL;
    lista->ultimo->prox = tmp;
    lista->ultimo = tmp;
    lista->elementos++;
}

void sort(ListaFlexivel *reserva) {
    if (reserva->primeiro->prox != NULL) {
        Celula *i = reserva->primeiro->prox;
        for (; i != NULL; i = i->prox) {
            for (Celula *j = i; j != NULL; j = j->prox) {
                if (strcmp(i->personagem.name, j->personagem.name) > 0) {
                    Personagem tmp = i->personagem;
                    i->personagem = j->personagem;
                    j->personagem = tmp;
                }
            }
        }
    }
}

void inserir(HashLista *hash, Personagem personagem) {
    if (hash->numElementos < hash->tamTabela) {
        int posicao = h(personagem.name, hash->tamTabela);
        if (hash->tabela[posicao].name[0] == '\0') {
            hash->tabela[posicao] = personagem;
            hash->numElementos++;
        } else {
            inserirFim(&(hash->reserva), personagem);
            sort(&(hash->reserva));
        }
    } else {
        fprintf(stderr, "ERRO: Tabela Cheia!!!\n");
        exit(EXIT_FAILURE);
    }
}

char* pesquisar(HashLista *hash, char *name) {
    static char resp[MAX_STRING_LENGTH];
    sprintf(resp, "NAO");
    int posicao = h(name, hash->tamTabela);
    if (strcmp(hash->tabela[posicao].name, name) == 0) {
        sprintf(resp, "(pos: %d) SIM", posicao);
    } else {
        posicao = 0;
        Celula *i = hash->reserva.primeiro->prox;
        while (i != NULL) {
            if (strcmp(i->personagem.name, name) == 0) {
                sprintf(resp, "(pos: %d) SIM", posicao);
                break;
            }
            i = i->prox;
            posicao++;
        }
    }
    return resp;
}

void lerArquivo(char *nomeArquivo, Personagem *personagens, int *numPersonagens) {
    FILE *arquivo = fopen(nomeArquivo, "r");
    if (arquivo == NULL) {
        fprintf(stderr, "ERRO: Falha ao abrir o arquivo %s.\n", nomeArquivo);
        exit(EXIT_FAILURE);
    }
    char linha[MAX_STRING_LENGTH];
    while (fgets(linha, sizeof(linha), arquivo) != NULL) {
        if (linha[strlen(linha) - 1] == '\n') {
            linha[strlen(linha) - 1] = '\0';
        }
        char *token;
        token = strtok(linha, ";");
        strncpy(personagens[*numPersonagens].id, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].name, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        char *alt_names = strtok(token, ",");
        int count_alt_names = 0;
        while (alt_names != NULL) {
            strncpy(personagens[*numPersonagens].alternate_names[count_alt_names++], alt_names, MAX_STRING_LENGTH);
            alt_names = strtok(NULL, ",");
        }
        personagens[*numPersonagens].num_alternate_names = count_alt_names;
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].house, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].ancestry, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].species, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].patronus, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        personagens[*numPersonagens].hogwartsStaff = (strcmp(token, "VERDADEIRO") == 0) ? 1 : 0;
        token = strtok(NULL, ";");
        personagens[*numPersonagens].hogwartsStudent = (strcmp(token, "VERDADEIRO") == 0) ? 1 : 0;
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].actorName, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        personagens[*numPersonagens].alive = (strcmp(token, "VERDADEIRO") == 0) ? 1 : 0;
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].dateOfBirth, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        personagens[*numPersonagens].yearOfBirth = atoi(token);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].eyeColour, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].gender, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        strncpy(personagens[*numPersonagens].hairColour, token, MAX_STRING_LENGTH);
        token = strtok(NULL, ";");
        personagens[*numPersonagens].wizzard = (strcmp(token, "VERDADEIRO") == 0) ? 1 : 0;
        (*numPersonagens)++;
    }
    fclose(arquivo);
}

int main() {
    Personagem personagens[5000];
    int numPersonagens = 0;
    char entrada[5000][MAX_STRING_LENGTH];
    int numEntrada = 0;
    char entradaPesquisa[5000][MAX_STRING_LENGTH];
    int numEntradaPesquisa = 0;
    char linha[MAX_STRING_LENGTH];
    while (fgets(linha, sizeof(linha), stdin) != NULL && strncmp(linha, "FIM", 3) != 0) {
        if (linha[strlen(linha) - 1] == '\n') {
            linha[strlen(linha) - 1] = '\0';
        }
        strncpy(entrada[numEntrada], linha, MAX_STRING_LENGTH);
        numEntrada++;
    }
    while (fgets(linha, sizeof(linha), stdin) != NULL && strncmp(linha, "FIM", 3) != 0) {
        if (linha[strlen(linha) - 1] == '\n') {
            linha[strlen(linha) - 1] = '\0';
        }
        strncpy(entradaPesquisa[numEntradaPesquisa], linha, MAX_STRING_LENGTH);
        numEntradaPesquisa++;
    }
    lerArquivo("/tmp/characters.csv", personagens, &numPersonagens);
    HashLista hash;
    for (int i = 0; i < numEntrada; i++) {
        Personagem personagem;
        for (int j = 0; j < numPersonagens; j++) {
            if (strcmp(entrada[i], personagens[j].id) == 0) {
                personagem = personagens[j];
                break;
            }
        }
        inserir(&hash, personagem);
    }
    for (int i = 0; i < numEntradaPesquisa; i++) {
        printf("%s\n", pesquisar(&hash, entradaPesquisa[i]));
    }
    return 0;
}