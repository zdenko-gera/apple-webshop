Tesztjegyzőkönyv-Árukészlet kezelése (CR)

Az alábbi tesztdokumentum a webshop projekthez tartozó 8.3.6 Árukészletek kezelése funkcióhoz készült(CR). Felelőse: Varga Zoltán

1. Teszteljárások (TP)

1.1. Termék hozzáadás funkció tesztelése

Azonosító: TP-01
Tesztesetek: TC-01, TC-02, TC-03, TC-04, TC-05, TC-06
Leírás: Termék hozzáadás funkció tesztelése
0. lépés: Nyissuk meg az alkalmazást, és jelentkezzünk be az admin@teszt.com email címmel és adminadmin jelszóval. Ezután lépjünk be a localhost:8081/Admin oldalra

lépés: A TÍPUS szövegbeviteli mezőbe írjunk be a INPUT_TÍPUS szöveget
lépés: Az ÁR szövegbeviteli mezőbe írjunk be a INPUT_ÁR számot
lépés: A NÉV szövegbeviteli mezőbe írjunk be a INPUT_NÉV számot
lépés: A LEÍRÁS szövegbeviteli mezőbe írjunk be a INPUT_LEÍRÁS szöveget
lépés: A MENNYISÉG szövegbeviteli mezőbe írjunk be a INPUT_MENNYISÉG számot
lépés: A KÉP fájlbeviteli mezőbe válasszunk ki egy tetszőleges INPUT_KÉP képet (Még nincs megvalósítva, csak az elküldéshez kell)
lépés: Nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Adatbázisba bekerül a product táblába egy új sor ezekkel az adatokkal : 
        productType = INPUT_TÍPUS
        price = INPUT_ÁR
        name = INPUT_NÉV
        description = INPUT_LEÍRÁS
        quantity = INPUT_MENNYISÉG


2. Teszesetek (TC)

2.1. Termék hozzáadás funkció tesztesetei

2.1.1. TC-01

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: INPUT_TÍPUS = "Telefon" ; INPUT_ÁR = 100000 ; INPUT_NÉV = "Iphone SE 2020" ; INPUT_LEÍRÁS = "Leggyorsabb telefon a világon" ; INPUT_MENNYISÉG = 10
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: az adatbázisban van egy sor a következő tartalommal: 
        productType = "Telefon"
        price = 100000
        name = "Iphone SE 2020"
        description = "Leggyorsabb telefon a világon"
        quantity = 10

2.1.2. TC-02

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: INPUT_TÍPUS = "Laptop" ; INPUT_ÁR = 300000 ; INPUT_NÉV
= "Macbook Pro Max 256GB" ; INPUT_LEÍRÁS = "Legjobb laptop a világon" ; INPUT_MENNYISÉG = 20 ; 
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: az adatbázisban van egy sor a következő 
tartalommal: 
        productType = "Laptop"
        price = 300000
        name = "Macbook Pro Max 256GB"
        description = "Legjobb laptop a világon"
        quantity = 20

2.1.3. TC-03

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: INPUT_TÍPUS = " " ; INPUT_ÁR = " " ; INPUT_NÉV
= " " ; INPUT_LEÍRÁS = " " ; INPUT_MENNYISÉG = " " ; 
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: Az adatbázisba nem kerül új sor, visszajelez az adminnak, hogy rossz adatot adott meg

2.1.4. TC-04

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: INPUT_TÍPUS = "Fülhallgató" ; INPUT_ÁR = "50000" ; INPUT_NÉV
= "Airpods" ; INPUT_LEÍRÁS = "Legjobb fülhallgató" ; INPUT_MENNYISÉG = "-1" ; 
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: Az adatbázisba nem kerül új sor, visszajelez az adminnak, hogy rossz adatot adott meg

2.1.5. TC-05

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: INPUT_TÍPUS = "Fülhallgató" ; INPUT_ÁR = "Nagyon olcsó" ; INPUT_NÉV
= "Airpods" ; INPUT_LEÍRÁS = "Legjobb fülhallgató" ; INPUT_MENNYISÉG = "Végtelen" ; 
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: Az adatbázisba nem kerül új sor, visszajelez az adminnak, hogy rossz adatot adott meg

2.1.6. TC-06

TP: TP-01
Leírás: összeadás funkció tesztelése
Bemenet: Nem adok meg bemenetet egyik mezőben sem (Szóközt sem)
Művelet: nyomjuk meg az ÁRUCIKK HOZZÁADÁSA gombot
Elvárt kimenet: Nem küldi el az üzenetet a szerver felé

3. Tesztriportok (TR)

3.1. Összeadás funkció tesztriportjai

3.1.1. TR-01 (TC-01)
TP: TP-01

1. lépés: INPUT_TÍPUS = "Telefon" - beírtam; 
2. lépés: INPUT_ÁR = 100000 - beírtam; 
3. lépés: INPUT_NÉV = "Iphone SE 2020" - beírtam; 
4. lépés: INPUT_LEÍRÁS = "Leggyorsabb telefon a világon" - beírtam ; 
5. lépés: INPUT_MENNYISÉG = 10 - beírtam ;  
6. lépés: Tetszőleges képet feltöltöttem
7. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
8. lépés: Helyes eredményt kaptam (megjelent az új sor az adatbázisban ezekkel az adatokkal)

3.1.2. TR-02 (TC-02)
TP: TP-01

1. lépés: INPUT_TÍPUS = "Laptop" - beírtam; 
2. lépés: INPUT_ÁR = 300000 - beírtam; 
3. lépés: INPUT_NÉV = "Macbook Pro Max 256GB" - beírtam; 
4. lépés: INPUT_LEÍRÁS = "Legjobb laptop a világon" - beírtam ; 
5. lépés: INPUT_MENNYISÉG = 20 - beírtam ;  
6. lépés: Tetszőleges képet feltöltöttem
7. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
8. lépés: Helyes eredményt kaptam (megjelent az új sor az adatbázisban ezekkel az adatokkal)

3.1.3. TR-03 (TC-03)
TP: TP-01

1. lépés: INPUT_TÍPUS = " " - beírtam; 
2. lépés: INPUT_ÁR = " " - beírtam; 
3. lépés: INPUT_NÉV = " " - beírtam; 
4. lépés: INPUT_LEÍRÁS = " " - beírtam ; 
5. lépés: INPUT_MENNYISÉG = " " - beírtam ;  
6. lépés: Tetszőleges képet feltöltöttem
7. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
8. lépés: Helytelen eredményt kaptam. Visszajelzés az adminnak helyett 400 Bad request HTTP errort kaptam. 

3.1.4. TR-04 (TC-04)
TP: TP-01

1. lépés: INPUT_TÍPUS = "Fülhallgató" - beírtam; 
2. lépés: INPUT_ÁR = 50000 - beírtam; 
3. lépés: INPUT_NÉV = "Airpods" - beírtam; 
4. lépés: INPUT_LEÍRÁS = "Legjobb fülhallgató" - beírtam ; 
5. lépés: INPUT_MENNYISÉG = -1 - beírtam ;  
6. lépés: Tetszőleges képet feltöltöttem
7. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
8. lépés: Helytelen eredményt kaptam. Hozzáadta az adatbázishoz a -1 darab terméket is, ahelyett, hogy visszajelezne az adminnak, hogy helytelen volt az input. 

3.1.5. TR-05 (TC-05)
TP: TP-01

1. lépés: INPUT_TÍPUS = "Fülhallgató" - beírtam; 
2. lépés: INPUT_ÁR = "Nagyon olcsó" - beírtam; 
3. lépés: INPUT_NÉV = "Airpods" - beírtam; 
4. lépés: INPUT_LEÍRÁS = "Legjobb fülhallgató" - beírtam ; 
5. lépés: INPUT_MENNYISÉG = "Végtelen" - beírtam ;  
6. lépés: Tetszőleges képet feltöltöttem
7. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
8. lépés: Helytelen eredményt kaptam. 400 bad requestet kaptam ahelyett, hogy visszajelezne, hogy hibásak az adatok. 

3.1.6. TR-06 (TC-06)
TP: TP-01

1. lépés: nem töltök fel semmilyen adatot (csak a képet)
2. lépés: Megnyomtam az ÁRUCIKK FELTÖLTÉSE gombot
3. lépés: Helyes eredményt kaptam. A form tartalmát nem küldi el a szerver felé, hanem kijelöli az INPUT_TÍPUS mezőt, hogy írjak bele valamit. 