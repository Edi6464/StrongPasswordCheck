Algoritmul returneaza numarul minim de schimbari necesare pentru a transforma sirul s citit de la tastatura intr-o parola puternica, sau 0 in cazul in care parola indeplineste deja toate conditile specificate.
	Programul este impartit in 3 cazuri:

	-Cand numarul de caractere este mai mic decat 6:

		* Daca sirul are 3 sau mai putine caractere, numarul minim de schimbari va fi mereu egal cu 6-NrCaractere indiferent de celalalte conditii neindeplinite.(De exemplu daca s="Ab7" programul returneaza 3 deoarece este nevoie de 3 caractere pentru a ajunge la numarul minim 6. Daca s="aaa", se va returna tot valoarea 3,chiar daca exista mai multe conditii neindeplinite. Prin 3 schimbari, parola poate deveni s="aBaa7a" pentru care programul returneaza 0 ).
		* Daca sirul are intre 3 si 6 caractere, numarul returnat va fi in functie de cate conditii nu sunt indeplinite.(De exemplu, daca s="Ppaaa", observam ca sirului ii lipseste o cifra si ca exista 3 caractere consecutive, deci 2 schimbari.Totusi, putem rezolva aceste 2 probleme printr-o singura schimbare si anume insararea unei cifre intre 2 'a' consecutivi(ex:s="Ppa7aa"). Deci, programul va returna 1, acesta fiind numarul minim de schimbari.
	
	-Cand numarul de caractere este intre 6 si 20:
		
		* La inceputul programului vom calcula prin intermediul variabilei "count" si cu ajutorul unor metode definite la sfarsit, cate conditii principale nu sunt indeplinite.(Daca sirul nu contine litera mare si cifre, dar contine litere mici, "count" va avea valoarea 2).
		* Daca numarul de secvente unde apar mai multe caractere consecutive ( returnat de metoda charactersInARow() ) este mai mic sau egal decat variabila "count", atunci programul va returna valoarea lui "count".(De exemplu daca s="passsword", programul returneaza 2, deoarece inalocuim un 's' cu o litera mare si orice alt caracter cu o cifra)
		* Daca numarul de secvente unde apar mai multe caractere consecutive este mai mare decat variabila "count", atunci va trebui sa luam in considerare cate secvente repetitive exista si sa le inlocuim cu caracterele necesare pentru a indeplinii conditile.(De exemplu daca s="pppaaa555wwwooorrrd", programul returneaza 6. Chiar daca exista 6 secvente, iar pe langa lipsesc literele mari, putem rezolva 2 greseli printr-o singura schimbare si anume inlocuirea unui caracter dintr-o secventa repetitiva cu o majuscula).


	-Cand numarul de caractere este mai mare decat 20:

		* Din nou ne vom folosi de variabila "count" si de metoda charactersInARow().
		* Daca numarul de secvente unde apar mai multe caractere consecutive este mai mic sau egal decat variabila "count", numarul de schimbari minime va fi egal cu "count"+ NrCaractere-20.(De exemplu daca s="strongestpassword12345", programul returneaza 3 deoarece se sterg 2 caractere pentru a respecta lungimea maxima permisa, si se schimba unul cu o litera mare).
		* Daca numarul de secvente unde apar mai multe caractere consecutive este mai mare decat variabila "count" si numarul de secvente repetitive este mai mic decat numarul de caractere care depasesc lungimea maxima admisa, numarul de schimbari minime va fi egal cu (NrCaractere-20)+count.(De exemplu daca s="11122233344484789328123789209", programul returneaza 11, deoarece se vor sterge caracterele in plus din fiecare secventa repetitiva, se vor sterge caractere pentru a atinge lungimea maxima permisa, si se vor schimba alte caractere cu ce avem nevoie pentru a indeplinii conditile).
		* Daca numarul de secvente unde apar mai multe caractere consecutive este mai mare decat variabila "count" si numarul de secvente repetitive este mai mare decat numarul de caractere care depasesc lungimea maxima admisa. Numarul de schimbari minime va fi egal cu valoarea returnata de metoda charactersInARow().(De exemplu daca s="1112223334445556667890", programul va returna 6).

