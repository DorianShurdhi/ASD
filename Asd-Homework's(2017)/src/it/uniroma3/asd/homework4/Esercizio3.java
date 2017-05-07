#include <stdio.h>  /* ora puoi usare NULL */

/* scrivi qui la definizione del tipo nodo_albero che rappresenta una struttura con tre campi: primo campo ha nome info ed è di tipo intero, secondo campo ha nome sx (un puntatore al sottoalbero sinistro), terzo campo ha nome dx (un puntatore al sottoalbero destro) [IMPORTANTE: non modificare l'ordine dei campi] */

struct nodo_albero{
       int info;
       struct nodo_albero *sx;
       struct nodo_albero *dx;

};

/* scrivi qui la definizione del tipo albero che rappresenta un puntatore alla struttura nodo_albero */

typedef struct nodo_albero *albero;

/* scrivi qui eventuali funzioni di appoggio */
int altezza(albero T)
{
   if (T==NULL)
     return 0;
   else
   {
     /* compute the height of each subtree */
     int sAlt = altezza(T->sx);
     int dAlt = altezza(T->dx);
     /* use the larger one */
    
     return (sAlt > dAlt)? (sAlt+1): (dAlt+1);
   }
}

int ottieniLarghezza(albero T, int k)
{
     
  if(T == NULL)
    return 0;
   
  if(k == 1)
    return 1;
             
  else if (k > 1)
    return ottieniLarghezza(T->sx, k-1) + 
             ottieniLarghezza(T->dx, k-1);
}


/* INIZIO FUNZIONE */

int larghezza_albero(albero T){
    
    /* Dato un un albero binario T di interi, la funzione larghezza_albero deve ritornare la larghezza di T; la larghezza di un albero binario è il numero massimo di nodi che stanno tutti al medesimo livello. Nel caso in cui T sia vuoto la funzione ritornerà 0.*/
       
   


  int maxLarghezza = 0;   
  int larghezza;
  int h = altezza(T);
  int i;
    
  if(T == NULL) return 0; 
  for(i=1; i<=h; i++) {
    larghezza = ottieniLarghezza(T, i);
    if(larghezza > maxLarghezza)
      maxLarghezza = larghezza;
  }     
   
  return maxLarghezza;
}