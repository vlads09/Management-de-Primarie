# Management-de-Primarie

Tema constă în implementarea unui sistem informatic care să gestioneze aceste activități. Pentru fiecare tip de
comandă citită din fișierele de input, am creat câte o clasă specifică și am instanțiat în main câte un obiect care
se ocupă de fiecare situație (ex: adaugă cerere/utilizatori în colecții, diferitele tipuri de afișări cerute etc.). În
cadrul clasei Birou, pentru a folosi genericitatea, am adăugat un atribut care reprezenta un utilizator prin intermediul
căruia verific înainte de adăuga o cerere, dacă aceasta provine de la un utilizator corespunzător.
        Tipurile de colecții pe care le-am ales în cadrul temei sunt: câte două TreeSet-uri pentru fiecare utilizator în
care am stocat cererile fiecăruia (în așteptare și soluționate). Motivul pentru care am ales acestă colecție este că
elementele unui TreeSet sunt diferite (sortarea făcută după dată), iar complexitatea acestuia este O(log(n)). Pentru
birourii, am folosit Arraylist pentru că am considerat că este mai ușor de utilizat și de sortat, pentru situația dată,
doar stocarea.
