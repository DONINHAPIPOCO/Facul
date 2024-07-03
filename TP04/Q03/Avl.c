#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <stdbool.h>
#include <time.h>

#define MAX_ALTERNATE_NAMES 100
#define NOME_ARQUIVO "tmp/characters.csv"
//#define NOME_ARQUIVO "C:/Users/lfrod/Documents/AEDII/TP02/Q01/characters(1).csv"
#define MAX_STRING_LENGTH 50
#define MIN_STRING_LENGTH 20
#define MAX_COLOR_LENGTH 10
#define MAX 100

typedef struct Personagem {
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
    if(personagem != NULL) {
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
    if(clone != NULL) {
        strcpy(clone->id, personagem->id);
        strcpy(clone->name, personagem->name);
        clone->numAlternateNames = personagem->numAlternateNames;
        for(int i = 0; i < personagem->numAlternateNames; i++) {
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
    for(int i = 0; i < personagem->numAlternateNames; i++) {
        printf("%s", personagem->alternate_names[i]);
        if(i < personagem->numAlternateNames - 1) {
            printf(", ");
        }
    }
    printf("} ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %s ## %d ## %s ## %s ## %s ## %s]\n", 
            personagem->house, personagem->ancestry, personagem->species, personagem->patronus, 
            personagem->hogwartsStaff ? "true" : "false", personagem->hogwartsStudent ? "true" : "false", 
            personagem->actorName, personagem->alive ? "true" : "false", personagem->dateOfBirth, 
            personagem->yearOfBirth, personagem->eyeColour, personagem->gender, personagem->hairColour, 
            personagem->wizzard ? "true" : "false");
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
        sscanf(linha, "%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%[^;];%d;%d;%[^;];%d;%[^;];%d;%[^;];%[^;];%[^;];%d",
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

typedef struct NoAVL {
    Personagem personagem;
    struct NoAVL *esq, *dir;
    int nivel;
} NoAVL;

NoAVL* inicializarNoAVL() {
    NoAVL* no = (NoAVL*) malloc(sizeof(NoAVL));
    no->esq = NULL;
    no->dir = NULL;
    no->nivel = 1;
    return no;
}

NoAVL* inicializarNoAVLComPersonagem(Personagem personagem) {
    NoAVL* no = (NoAVL*) malloc(sizeof(NoAVL));
    no->personagem = personagem;
    no->esq = NULL;
    no->dir = NULL;
    no->nivel = 1;
    return no;
}

void setPersonagem(NoAVL* no, Personagem personagem) {
    no->personagem = personagem;
}

void setDir(NoAVL* no, NoAVL* dir) {
    no->dir = dir;
}

void setEsq(NoAVL* no, NoAVL* esq) {
    no->esq = esq;
}

void setNivel(NoAVL* no, int nivel) {
    no->nivel = nivel;
}

int getNivel(NoAVL* no) {
    return (no == NULL) ? 0 : no->nivel;
}

void atualizarNivel(NoAVL* no) {
    no->nivel = 1 + (getNivel(no->esq) > getNivel(no->dir) ? getNivel(no->esq) : getNivel(no->dir));
}

NoAVL* rotacionarDir(NoAVL* no) {
    NoAVL* noEsq = no->esq;
    NoAVL* noEsqDir = noEsq->dir;
    noEsq->dir = no;
    no->esq = noEsqDir;
    atualizarNivel(no);
    atualizarNivel(noEsq);
    return noEsq;
}

NoAVL* rotacionarEsq(NoAVL* no) {
    NoAVL* noDir = no->dir;
    NoAVL* noDirEsq = noDir->esq;
    noDir->esq = no;
    no->dir = noDirEsq;
    atualizarNivel(no);
    atualizarNivel(noDir);
    return noDir;
}

NoAVL* balancear(NoAVL* no) {
    if (no != NULL) {
        int fator = getNivel(no->dir) - getNivel(no->esq);
        if (fator >= -1 && fator <= 1) {
            atualizarNivel(no);
        } else if (fator == 2) {
            if (getNivel(no->dir->dir) < getNivel(no->dir->esq)) {
                no->dir = rotacionarDir(no->dir);
            }
            no = rotacionarEsq(no);
        } else if (fator == -2) {
            if (getNivel(no->esq->esq) < getNivel(no->esq->dir)) {
                no->esq = rotacionarEsq(no->esq);
            }
            no = rotacionarDir(no);
        } else {
            printf("Erro!\n");
        }
    }
    return no;
}

NoAVL* inserir(Personagem personagem, NoAVL* no) {
    if (no == NULL) {
        no = inicializarNoAVLComPersonagem(personagem);
    } else if (strcmp(personagem.id, no->personagem.id) < 0) {
        no->esq = inserir(personagem, no->esq);
    } else if (strcmp(personagem.id, no->personagem.id) > 0) {
        no->dir = inserir(personagem, no->dir);
    } else {
        printf("Erro!\n");
    }
    return balancear(no);
}

void caminharCentral(NoAVL* no) {
    if (no != NULL) {
        caminharCentral(no->esq);
        print(&(no->personagem));
        caminharCentral(no->dir);
    }
}

bool pesquisar(char* id, NoAVL* no) {
    bool encontrado;
    if (no == NULL) {
        encontrado = false;
    } else if (strcmp(id, no->personagem.id) == 0) {
        encontrado = true;
    } else if (strcmp(id, no->personagem.id) < 0) {
        printf("esq ");
        encontrado = pesquisar(id, no->esq);
    } else {
        printf("dir ");
        encontrado = pesquisar(id, no->dir);
    }
    return encontrado;
}

int main() {
    clock_t start = clock();
    Personagem** personagens = NULL;
    int numPersonagens = 0;
    personagens = ler(NOME_ARQUIVO, &numPersonagens);
    
    NoAVL* raiz = inicializarNoAVL();
    for (int i = 0; i < 5; i++) {
        raiz = inserir(*personagens[i], raiz);
    }
    caminharCentral(raiz);
    
    char id[MAX_STRING_LENGTH];
    while (scanf("%s", id) != EOF) {
        printf("%s raiz ", id);
        bool encontrado = pesquisar(id, raiz);
        if (encontrado) {
            printf("SIM\n");
        } else {
            printf("NÃO\n");
        }
    }

    // Liberação da memória alocada
    for (int i = 0; i < numPersonagens; i++) {
        freePersonagem(personagens[i]);
    }
    free(personagens);

    // Calcular o tempo de execução
    clock_t end = clock();
    double elapsed_time = (double)(end - start) / CLOCKS_PER_SEC;
    FILE *arquivo_tempo = fopen("matricula_avl.txt", "w");
    if (arquivo_tempo == NULL) {
        printf("Erro ao abrir o arquivo de saída.\n");
        return 1;
    }
    fprintf(arquivo_tempo, "774119\t%lf\t0\n", elapsed_time);
    fclose(arquivo_tempo);

    return 0;
}