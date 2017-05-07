#include <stdio.h>  /* ora puoi usare NULL */

/* scrivi qui la definizione del tipo nodo_albero che rappresenta una struttura con tre campi: primo campo ha nome info ed è di tipo intero, secondo campo ha nome sx (un puntatore al sottoalbero sinistro), terzo campo ha nome dx (un puntatore al sottoalbero destro) [IMPORTANTE: non scambiare l'ordine dei campi] */

struct nodo_albero{
       int info;
       struct nodo_albero *sx;
       struct nodo_albero *dx;

};


/* scrivi qui la definizione del tipo albero che rappresenta un puntatore alla struttura nodo_albero */

typedef struct nodo_albero *albero;


/* INIZIO FUNZIONE */

int albero_pieno(albero T){
    
    /* Dato un un albero binario T di interi, la funzione albero_pieno deve ritornare un booleano: 1 se l'albero T è "pieno", 0 altrimenti. Un albero binario “pieno” è un albero binario in cui tutti i nodi hanno esattamente 0 o 2 figli, e nessun nodo ha 1 figlio. Se l'albero T è vuoto la funzione deve ritornare 1.*/

    /*Se l'albero è vuoto*/
    if(T == NULL) 
       return 1;
    
    /*se l'albero è una foglia*/
    if(T->sx == NULL && T->dx == NULL) 
       return 1;

    /*Se entrambi i nodi sinistro e destro non sono NULL,
      e se gli sottoalberi sx & dx sono completi*/

    if ((T->sx) && (T->dx))
        return (albero_pieno(T->sx) && albero_pieno(T->dx));
 
    /* In tutti gli altri casi*/
    return 0;

    
}