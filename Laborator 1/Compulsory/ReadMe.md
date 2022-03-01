<details>
<summary>Laborator 1 - Compulsory (1pct)</summary>
<p><br />"Display on the screen the message "Hello World!". Run the application. If it works, go to step 2 :)"</p>
<p>* La subpunctul 1 am afisat pe ecran mesajul "Hello World!"</p>
<p>"Define an array of strings languages, containing {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}"</p>
<p>* La subpunctul 2 am definit un array of strings "languages" pe care l-am populat cu cuvintele<br />{"C", "C++", "C#", "Python",<br />"Go", "Rust", "JavaScript", "PHP", "Swift", "Java"}</p>
<p>"Generate a random integer n: int n = (int) (Math.random() * 1_000_000);"</p>
<p>* La subpunctul 3 am definit o variabila de tip int "n" careia i am asignat<br />un numar radom folosind metoda random() din clasa Math. Aceasta metoda returneaza<br />un numar cuprins in intervalul [0,1). De asemenea am dat cast la int deoarece numarul<br />returnat de metoda random() este de tip double iar variabila "n" este de tip int.</p>
<p>"Compute the result obtained after performing the following calculations:"</p>
<p>* La subpunctul 4 am efectuat o serie de calcule</p>
<p>"multiply n by 3;<br />add the binary number 10101 to the result; ----&gt; am folosit prefixul 0b ca sa specific ca numarul 10101 este binar<br />add the hexadecimal number FF to the result; --&gt; am folosit prefixul 0x ca sa specific ca numarul FF este hexazecimal<br />multiply the result by 6"</p>
<p>"Compute the sum of the digits in the result obtained in the previous step. This is the new result. While the new result has more than one digit, continue to sum the digits of the result."</p>
<p>* La subpunctul 5 am calculat cifra de control a numarului rezultat la subpunctul anterior intr un while care merge<br />cat timp numarul este format din 2 cifre, stocheaza in variabila "Ultima_cifra" ultima cifra a numarului si o aduna<br />la n/10 . Cand while ul se termina in variabila "result" se stocheaza cifra de control</p>
<p>"Display on the screen the message: "Willy-nilly, this semester I will learn " + languages[result].<br />"</p>
<p>* La subpunctul 6 am afisat mesajul "Willy-nilly, this semester I will learn" + cuvantul a carui pozitie in<br />vectorul de cuvinte este chiar variabila "result" adica cifra de control</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</details>

<details>
<summary>Homework 1 (2pct)</summary>
<p>"Let n, p be two integers and C1,...,Cm a set of letters (the alphabet), all given as a command line arguments. Validate the arguments!"</p>
<p>* La primul subpunct am validat argumentele:</p>
<p>Daca nu sunt 3 argumente, nu respecte pattern ul<br />N ul trebuie sa fie integer<br />P ul trebuie sa fie integer</p>
<p>&nbsp;</p>
<p>"Create an array of n strings (called words), each word containing exactly p characters from the given alphabet.</p>
<p>-Display on the screen the generated array."</p>
<p>&nbsp;</p>
<p>* La al doilea subpunct am creeat vectorul de cuvinte words.<br />Ca sa creez acest vector am urmat pasii urmatori:<br />- Am creeat un vector separat "alphabet" in care copiez din args<br />literele</p>
<p>- Am creeat un vector de cuvinte "words" de dimensiunea n<br />iar pe fiecare pozitie am generat random cuvinte de p litere<br />dupa formula Math.random() * range (range = alphabet.length)</p>
<p>&nbsp;</p>
<p>"Two words are neighbors if they have a common letter.<br />- Create a boolean n x n matrix, representing the adjacency relation of the words.<br />- Create a data structure (using arrays) that stores the neighbors of each word. Display this data structure on the screen."</p>
<p>&nbsp;</p>
<p>* La al treilea subpunct:<br />- Am creat matricea de adiacenta, in care evidentiez<br />vecinii fiecarui cuvant in parte.<br />- Am creeat un vector in care stochez pentru fiecare cuvant<br />vecinii acestuia</p>
<p>Ca sa creez matricea de adiacenta am urmat pasii urmatori:<br />- Parcurg vectorul "words", primul for reprezinta cuvantul<br />a carui litere sunt verificate cu celelalte. Daca gaseste<br />o litera a altui cuvant care sa fie egala cu aceasta atunci<br />in matricea de adiacenta pe pozitia adjacency[i][j] se pune "true"</p>
<p>Ca sa creez vectorul cu vecinii fiecarui cuvant:<br />- Parcurg matricea de adiacenta, iar pe pozitia cuvantului concatenez celalalte cuvinte care sunt vecini cu acesta in functie de matricea de adiacenta</p>
<p>&nbsp;</p>
<p>"For larger n display the running time of the application in nanoseconds (DO NOT display the data structure!). Try n &gt; 30_000. You might want to adjust the JVM Heap Space using the VM options -Xms4G -Xmx4G."</p>
<p>* La al patrulea subpunct ca sa afisez durata executiei aplicatiei<br />am adaugat la inceputul codului startTime = system.Nanotime() si<br />la sfarsitul codului endTime = system.Nanotime() iar la sfarsit<br />am afisat diferenta dintre startTime - endTime</p>
<p>&nbsp;</p>
</details>

<details>
<summary>Bonus (2pct)</summary>
<p>"Implement an efficient algorithm that determines, if possible, a subset of distinct words W1,W2,...,Wk (from the ones that you have generated) such that k &ge; 3 and Wi and Wi+1 are neighbors, for all i in [1..k], where Wk+1=W1.<br />Can you find the largest possible k?"</p>
<p>&nbsp;</p>
<p>* La bonus, ca sa determin cel mai mare K posibil:<br />- Am folosit 3 variabile:<br />-firstK (retine prima secventa de vecini)<br />-tempK care se modifica in functie de secventele de vecini<br />-finalK unde retin cea mai mare dimensiune a unui subsir de vecini</p>
<p>Verific primul cuvant cu al doilea, daca sunt vecini incrementez tempK si trec mai departe</p>
<p>Daca 2 cuvinte consecutive nu sunt vecine, prima data retin in "firstK" dimensiunea<br />primului subsir. Verific daca dimensiunea calculata este mai mare decat cea retinuta<br />in "finalK" si resetez "tempK".</p>
<p>Pentru eficientizare am folosit FirstK care retine vecinii de la primul cuvant<br />pentru ca la final cand verifica daca W(k+1) este vecin cu W(1) sa nu mai trebuiasca<br />sa parcurg din nou secventa &lt;primul cuv, al doilea, ... firstK&gt; ci doar verific daca<br />tempK + firstK &gt; finalK, iar daca aceasta conditie este indeplinita se actualizeaza finalK<br />cu tempK+firstK.</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
<p>&nbsp;</p>
</details>
