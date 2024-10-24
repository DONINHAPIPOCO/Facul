#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>

typedef struct Celula {
    struct Celula* prox;
    int elemento;

} Celula;

typedef struct ListaFlexivel {
    Celula* primeiro;
    Celula* ultimo;
    int tamanho;

} ListaFlexivel;

Celula* newCelula(int elemento) {
    Celula* newCelula = (Celula*)malloc(sizeof(Celula));

    newCelula->prox = NULL;
    newCelula->elemento = elemento;

    return newCelula;

}

ListaFlexivel startLista() {
    ListaFlexivel* lista = (ListaFlexivel*)malloc(sizeof(ListaFlexivel));

    lista->primeiro = lista->ultimo = newCelula(-1);
    lista->tamanho = 0;

    return lista;

}

void inserirFim(int elemento) {
    ultimo->prox = newCelula(elemento);
    ultimo = ultimo->prox;

}
