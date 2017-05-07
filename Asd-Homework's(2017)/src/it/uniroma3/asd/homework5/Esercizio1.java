#include <stdio.h>  /* ora puoi usare NULL */
#include <stdlib.h>  /* ora puoi usare le funzioni di allocazione dinamica della memoria */

/* scrivi qui la definizione del tipo nodo_albero che rappresenta una struttura con tre campi: il primo campo ha nome info ed è di tipo intero, il secondo campo ha nome sx (il puntatore al sottoalbero sinistro), il terzo campo ha nome dx (un puntatore al sottoalbero destro). ATTENZIONE: non invertire l'ordine dei campi della struttura. */

struct nodo_albero{
       int info;
       struct nodo_albero *sx;
       struct nodo_albero *dx;

};

/* scrivi qui la definizione del tipo albero che rappresenta un puntatore alla struttura nodo_albero */ 

typedef struct nodo_albero *albero;

/* scrivi qui eventuali funzioni di appoggio */

int depth(albero T, int v){                 // RESTITUISCE PROFONDITA' NODO V
    if(T->info==v)
    return 0;
    if(T->info<v)
        return 1+ depth(T->dx,v);
    else  
        return 1+ depth(T->sx,v); 
 }

int* cammino(albero T, int v, int i, int* A){     
  if (T->info==v){
      //A[i]=malloc(sizeof(int));
       A[i]=v;
      return A;
  }
  else{  
      
      //A[i]=malloc(sizeof(int));
          A[i]=T->info;
          if(T->info<v)
             return cammino(T->dx,v,(i+1),A);
           else  
             return cammino(T->sx,v,(i+1),A);
      }
}

int trovaFoglia(albero T, int v){
	if(T==NULL)
           return 0;
	if(T->info==v && T->sx==NULL && T->dx==NULL)
           return 1;
        else{  
    	if(T->info<v)
        	return trovaFoglia(T->dx,v);
            else 
                return trovaFoglia(T->sx,v);      
        }
}


/* INIZIO FUNZIONE */

int *albero_cammino(albero T, int v){
    
    /* Si consideri un albero binario di ricerca T e un intero v (si ricorda che rispetto ad ogni nodo, il figlio sinistro avrà un valore minore rispetto al padre, il figlio destro avrà un valore maggiore rispetto al padre): allocare dinamicamente un array A di interi contenente i valori info dei nodi del cammino dalla radice di T alla foglia di T contenente il valore v. Alla fine restituire l'array A così costruito. Se l'albero T è vuoto, oppure non esiste una foglia in T contenente il valore v allora restituire NULL. Se l'albero T non presenta alcuna foglia contenente v, ma presenta un nodo intermedio con il valore v, la funzione deve restituire NULL */
      
       if(T==NULL )
          return NULL;
       if(trovaFoglia(T,v)==0)
          return NULL;
	int* A = calloc(depth(T,v),sizeof(int));
	return cammino(T,v,0,A);
}