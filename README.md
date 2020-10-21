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

Vi har brukt git til å dokumentere arbeidet vårt. Jeg har 16 commits totalt, 
og hver logg-melding beskriver det jeg har gjort av endringer.

Jeg startet med å lagre den opprinelige utleverte kildekoden i git.

* Oppgave 0: La klassen eksamenSBinTre inn i mitt Java-prosjekt, og la til noen 
instanser av klassen EksamenSBinTre. Deretter sjekket jeg at det ikke ga noen syntaksfeil 
eller kjørefeil. Prøvde Integer, Character og String som datatyper.

* Oppgave 1: Kopierte kodebiten fra kompendiet, Programkode 5.2 3 a), som er metoden public 
boolean leggInn(T verdi). Deretter gjorde jeg noen endringer, fra "p = new Node<>(verdi);" 
til " p = new Node<T>(verdi, q);". Så testet jeg følgende kode på Main gitt i oppgaven, som 
ga utskrift 10.

* Oppgave 2: Først implementerte jeg metoden public int antall(T verdi), som skal returnere 
antall forekomster av verdi i treet. Jeg har tatt utganspunktet i at duplikater er tillatt, 
det vil si at en verdi kan komme flere ganger. Men hvis null ikke er i treet, skal metoden 
returnere 0. Til slutt testet jeg kodebiten gitt på oppgave 2. Den blir kjørt og jeg får tilsvarende 
samme utskrift. 