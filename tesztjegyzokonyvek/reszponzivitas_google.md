Az alábbi tesztdokumentum a Webshop projekthez tartozó 8.4.11. Reszponzivitás kezelésének tesztelésére készült Googleban. Felelőse: Bényei Anna

1. Teszteljárások (TP)

1.1. Googleban a főoldal

Azonosító: TP-01
Tesztesetek: TC-01, TC-02
Leírás: Webshop főoldal megnyitása kis ablakban
0. lépés: Nyissuk meg Googleban a webshopot
1. lépés: Főoldal megnyitás
2. lépés: Görgetés az oldalon 
3. lépés: Menü használata
4. lépés: Ellenőrizzük az kinézetet. Eredmény: átlátható főoldal.

1.2. Googleban a regisztráció

Azonosító: TP-02
Tesztesetek: TC-02, TC-03
Leírás: Regisztráció funkció tesztelése kis ablakban
0. lépés: Nyissuk meg Googleban a webshopot
1. lépés: Regisztráció oldal megnyitás
2. lépés: Görgetés az oldalon 
3. lépés: Adatok beírása
4. lépés: Ellenőrizzük az kinézetet. Eredmény: átlátható regisztrációs oldal


1.3. Googleban a bejelentkezés

Azonosító: TP-03
Tesztesetek: TC-02, TC-04
Leírás: Bejelentkezés funkció tesztelése kis ablakban
0. lépés: Nyissuk meg Googleban a webshopot
1. lépés: Bejelentkezés oldal megnyitás
2. lépés: Görgetés az oldalon 
3. lépés: Bejelentkezési adatok beírása
4. lépés: Ellenőrizzük az kinézetet. Eredmény: átlátható bejelentkező oldal


2. Teszesetek (TC)

2.1. Googleban a főoldal

2.1.1. TC-01

TP: TP-01
Leírás: Webshop főoldal megnyitása kis ablakban (Menü)
Bemenet: Menü vizsgálata
Művelet: Végigkattintjuk a menü összes pontját
Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható


2.1.2. TC-02

TP: TP-01
Leírás: Webshop főoldal megnyitása kis ablakban (Görgetés)
Bemenet: Slidebar használata
Művelet: Végiggörgetunk az oldalon
Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható

2.2. Googleban a regisztráció

2.2.1. TC-03

TP: TP-02
Leírás: Webshop regisztrációs oldal megnyitása kis ablakban
Bemenet:  Regisztráció (kinézetre)
Művelet: Beírjuk az adatokat
Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható

2.3 Googleban a bejelentkezés

2.3.1. TC-04

TP: TP-03
Leírás: Webshop bejelentkező oldal megnyitása kis ablakban
Bemenet: Bejelentkezés (kinézetre)
Művelet: Beírjuk az adatokat
Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható


3. Tesztriportok (TR)

3.1. Googleban a főoldal

3.1.1. TR-01 (TC-01)

TP: TP-01

1. lépés: kicsinyítem az oldalt
2. lépés: nagyítom az oldalt
3. lépés: Végeredmény: egy bizonyos kicsinyítés után kiolvashatatlan lesz a menü, összecsúsznak, egy idő után van ami már nem is        látszódik

3.1.2. TR-02 (TC-02)

TP: TP-01

1. lépés: legörgetek az aljáig
2. lépés: felgörgetés a tetejére
3. lépés: Végeredmény: elemek a helyükön maradtak, nem csúszott össze az oldal

3.2. Googleban a regisztráció

3.2.1. TR-01 (TC-03)

TP: TP-02

1. lépés: Beírom a regisztrációs adatokat kicsinyített nézetben
2. lépés: Beírom a regisztrációs adatokat normál nézetben
3. lépés: Végeredmény: Az input helyek nem csúsznak össze, jól kivehetőek

3.3 Googleban a bejelentkezés

3.3.1. TR-01 (TC-03)

TP: TP-03

1. lépés: Beírom a bejelentkezési adatokat kicsinyített nézetben
2. lépés: Beírom a bejelentkezési adatokat normál nézetben
3. lépés: Végeredmény: Az input helyek nem csúsznak össze, jól kivehetőek