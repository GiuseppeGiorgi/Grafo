# Grafo

Si implementi la struttura dati Grafo diretto in modo che sia ottimale per
dati sparsi.

Il file `italian_dist_graph.csv` che potete recuperare seguendo il path
`/usr/NFS/Linux/labalgoritmi/datasets/` (in laboratorio von Neumann, selezionare
il disco Y) contiene le distanze in metri tra varie località italiane e una frazione
delle località a loro più vicine. Il formato è un CSV standard: i campi sono
separati da virgole; i record sono separati da "\n".

Ogni record contiene i seguenti dati:

- località 1: (tipo stringa) nome della località "sorgente". La stringa può
  contenere spazi, non può contenere virgole;
- località 2: (tipo stringa) nome della località "destinazione". La stringa
  può contenere spazi, non può contenere virgole;
- distanza: (tipo float) distanza in metri tra le due località.

*Note:*

- potete intrepretare le informazioni presenti nelle righe del file come
  archi **non diretti** (i.e., probabilmente vorrete inserire nel vostro grafo
  sia l'arco di andata che quello di ritorno a fronte di ogni riga letta).
- il file è stato creato a partire da un dataset poco accurato. I dati
  riportati contengono inesattezze e imprecisioni.

### Unit Testing

Implementare gli unit-test degli algoritmi secondo le indicazioni
suggerite nel documento [Unit Testing](UnitTesting.md).

### Analisi grafo e cammini minimi

Scrivere un programma per rispondere a ciascuno dei seguenti problemi:

- trovare il cammino minimo tra due località; si assuma che gli archi
  riportati nel file `italian_dist_graph.csv` siano connessioni percorribili;
- determinare la dimensione di ogni componente fortemente connessa del grafo.

### Controlli

Una implementazione corretta della ricerca del cammino minimo dovrebbe
riportare un cammino minimo tra "torino" e "catania" lungo ~1207.68Km.

Qual è il cammino minimo tra "torino" e "borsoi"?
