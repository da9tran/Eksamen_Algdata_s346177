# Mappeeksamen i Algoritmer og Datastrukturer Høst 2020

# Krav til innlevering

Se oblig-tekst for alle krav, og husk spesielt på følgende:

* Git er brukt til å dokumentere arbeid (minst 2 commits per oppgave, beskrivende commit-meldinger)	
* git bundle er levert inn
* Hovedklassen ligger i denne path'en i git: src/no/oslomet/cs/algdat/Eksamen/EksamenSBinTre.java
* Ingen debug-utskrifter
* Alle testene i test-programmet kjører og gir null feil (også spesialtilfeller)
* Readme-filen her er fyllt ut som beskrevet


# Beskrivelse av oppgaveløsning (4-8 linjer/setninger per oppgave)

Jeg har brukt git til å dokumentere arbeidet mitt. Jeg har 31 commits totalt, 
og hver logg-melding beskriver det jeg har gjort av endringer.

* Oppgave 0: Jeg startet med å lagre den opprinelige utleverte kildekoden i git. La klassen 
eksamenSBinTre inn i mitt Java-prosjekt, og la til noen instanser av klassen EksamenSBinTre. 
Deretter sjekket jeg at det ikke ga noen syntaksfeil eller kjørefeil. Prøvde Integer, Character 
og String som datatyper. 

* Oppgave 1: Kopierte kodebiten fra kompendiet, Programkode 5.2 3 a), som er metoden public 
boolean leggInn(T verdi). Endrett litt på koden for at referansen foreldre får korrekt verdi i hver 
node. Deretter gjorde jeg noen endringer, fra "p = new Node<>(verdi);" til " p = new Node<T>(verdi, q);".
Så testet jeg følgende kode på Main gitt i oppgaven, som ga utskrift 10. 

* Oppgave 2: Først implementerte jeg metoden public int antall(T verdi), som skal returnere 
antall forekomster av verdi i treet. Jeg har tatt utganspunktet i at duplikater er tillatt, 
det vil si at en verdi kan komme flere ganger. Men hvis null ikke er i treet, skal metoden 
returnere 0. Til slutt testet jeg kodebiten gitt på oppgave 2. Den blir kjørt og jeg får tilsvarende 
samme utskrift. 

* Oppgave 3: Først implementerte jeg metoden private static <T> førstePostorden(Node<T> p), som er 
basert på en loop, som returnerer første node post orden med p som rot. Jeg brukte nesten den samme metoden
fra kompendiet i seksjon 5.1.7, som viste detaljer om postorden, og hvordan man kan finne neste post orden. 
Deretter implementerte jeg metoden for private private static <T> Node<T> nestePostorden(Node<T> p) som returnerer 
den noden som kommer "p" i postorden. 

* Oppgave 4: Først implementerte jeg metoden public void postorden(Oppgave<? super T> oppgave), her brikte 
jeg en while loop until p == null. Deretter implementerte jeg hjelpe metoden public void postordenRecursive
(Oppgave<? super T> oppgave), som skal sjekke om treet er tomt, for at private void postordenRecursive
(Node<T> p, Oppgave<? super T> oppgave) skal kunne kjøre og returnere et rekursivt kall som traverserer teet
i postorden rekkefølgen, som vil si at den skal besøke alle nodene etter tur i en bestemt rekkefølge.


* Oppgave 5: Først implementerte jeg hjelpemetoden public ArrayList<T> serialize(), hvor jeg lagde to array 
lister. Her implementerte jeg en while metode som skal ta ut noden, og en if metode for å legge til 
serialiseringen,og legge til barn til køen. Også implementerte jeg metoden static <K> EksamenSBinTre<K> 
deserialize(ArrayList<K> data, Comparator<? super K> c), som skal lage et nytt tre(node) ut ifra et array, 
altså gjenskape det tidligere treet fra serialize metoden.

* Oppgave 6: Først implementerte jeg metoden public boolean fjern(T verdi). Denne metoden kopierte jeg fra 
Programkoden 5.3 8 d).  Men gjorde endingene som trengs for at pekeren foreldre får korrekt verdi i alle nodene etter
en fjerning. Denne endringer startet etter Node<T> b = p.venstre != null ? p.venstre : p.høyre; i metoden. Deretter 
implementerte jeg metoden public int fjernAlle(T verdi), som fjerner alle forekomster av verdi i treet, og returnerer 
antallet som blir fjernet, altså return count. Og hvis treet er tomt, skal det returnere 0, derfor starter jeg med 
int count = 0; Og før jeg implementerte metoden public void nullstilll(), lagde jeg en hjelpemetode for at nulltill(rot) 
skal fungere.







