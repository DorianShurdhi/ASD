#include <stdio.h>  /* ora puoi usare NULL */

/* scrivi qui la definizione del tipo nodo_albero che rappresenta una struttura con tre campi: primo campo ha nome info ed è di tipo intero, secondo campo ha nome sx (un puntatore al sottoalbero sinistro), terzo campo ha nome dx (un puntatore al sottoalbero destro) [IMPORTANTE: non scambiare l'ordine dei campi] */

struct nodo_albero{
       int info;
       struct nodo_albero *sx;
       struct nodo_albero *dx;

};

/* scrivi qui la definizione del tipo albero che rappresenta un puntatore alla struttura nodo_albero */

typedef struct nodo_albero *albero;

/* scrivi qui eventuali funzioni di appoggio */


/* INIZIO FUNZIONE */

int albero_completo(albero T){
    
    /* Dato un un albero binario T di interi, la funzione albero_completo deve ritornare un booleano: 1 se l'albero T è completo, 0 altrimenti. Un albero binario completo di altezza k è un albero binario in cui tutti i nodi, tranne le foglie, hanno esattamente due figli, e tutte le foglie si trovano al livello k. Se l'albero T è vuoto la funzione deve ritornare 0.*/
      
       if(T == NULL) return 0; 

       if(albero_completo(T->sx) == albero_completo(T->dx)) return 1;

      else return 0;
}