Tesztjegyzőkönyv-Kosár kezelése (CRUD)
Az alábbi tesztdokumentum a webshop projekthez tartozó 8.3.9 Kosár kezelése funkcióhoz készült(CR). Felelőse: Varga Zoltán

Teszteljárások (TP)

1.1. Termék mennyiség módosítása funkció tesztelése
Azonosító: TP-01
Tesztesetek: TC-01, TC-02, TC-03, TC-04
Leírás: Termék mennyiség módosítása funkció tesztelése
0. lépés: Nyissuk meg az alkalmazást, és jelentkezzünk be a tesztelek@gmail.com és tesztelek email-jelszó kombinációval. Ezután a Webshop oldalon válasszunk ki egy terméket, és adjuk hozzá a kosárhoz. Nyissuk meg a localhost:8081/Cart oldalt
1. lépés: Írjuk át valamelyik termékhez tartozó darabszámot INPUT_DARAB-ra vagy nyomjuk meg a +/- gombok valamelyikét
2. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Az adatbázisban az itemsincart táblában a kosárhoz tartozó sorban a quantity INPUT_DARAB-ra változik

Teszesetek (TC)

2.1. Termék mennyiség módosítása funkció tesztesetei
2.1.1. TC-01
TP: TP-01
Leírás: Termék mennyiség módosítás funkció tesztelése

0. lépés: Hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből. 
1. lépés: Megnyomom a + gombot. 
2. lépés (Elvárt eredmény): Az adatbázisban az itemsincart táblában a 4es productID-hoz tartozó termékből 7 db lesz a kosárban

2.1.2. TC-02
TP: TP-01
Leírás: Termék mennyiség módosítás funkció tesztelése

0. lépés: Hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből. 
1. lépés: Megnyomom a - gombot. 
2. lépés (Elvárt eredmény): Az adatbázisban az itemsincart táblában a 4es productID-hoz tartozó termékből 5 db lesz a kosárban

2.1.3. TC-03
TP: TP-01
Leírás: Termék mennyiség módosítás funkció tesztelése

0. lépés: Hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből. 
1. lépés: Az INPUT_DARAB-nak beírtam 15-öt 
2. lépés (Elvárt eredmény): Az adatbázisban az itemsincart táblában a 4es productID-hoz tartozó termékből 15 db lesz a kosárban

2.1.4. TC-04
TP: TP-01
Leírás: Termék mennyiség módosítás funkció tesztelése

0. lépés: Hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből. 
1. lépés: A - gombot megnyomom 7x 
2. lépés (Elvárt eredmény): A program nem engedi 0 alá menni a számlálót 


Tesztriportok (TR)

3.1. Termék módosítás funkció tesztriportjai
3.1.1. TR-01 (TC-01)
TP: TP-01

0. lépés: hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből;
1. lépés: Megnyomtam a + gombot
2. lépés: kapott eredmény: A működés helyes, az adatbázisban az itemsincart táblában a 4es productID-hoz tartozó termékből 7 db lesz a kosárban

3.1.2. TR-02 (TC-02)
TP: TP-01

0. lépés: hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből;
1. lépés: Megnyomtam a - gombot
2. lépés: kapott eredmény: A működés helyes, az adatbázisban az itemsincart táblában a 4es productID-hoz tartozó termékből 5 db lesz a kosárban

3.1.3. TR-03 (TC-03)
TP: TP-01

0. lépés: hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből;
1. lépés: INPUT_DARAB = 15 - beírtam
2. lépés: kapott eredmény: A működés helytelen, az itemsincart tábla nem módosul

3.1.3. TR-03 (TC-03)
TP: TP-01

0. lépés: hozzáadtam a kosárhoz 6db-ot a 4-es productID-val rendelkező termékből;
1. lépés: A - gombot megnyomom 7x 
2. lépés: kapott eredmény: A működés helyes, az itemsincart táblában a quantity nem megy 0 alá