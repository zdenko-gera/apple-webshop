# Tesztjegyzőkönyv-Reszponzivitás-Felhasználói élmény

Az alábbi tesztdokumentum a webshop projekthez tartozó 8.3.13. Webhop létrehozása (HTML, CSS) funkcióihoz készült. Felelőse: Nagy Vencel 

## 1. Teszteljárások (TP)

### 1.1. Webshop tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Leírás: Főoldal megnyitása kis ablakban
0. lépés: Böngésző megnyitása
1. lépés: Webshop megnyitás
2. lépés: Görgetés az oldalon 
3. lépés: Menü használata
4. lépés: Funkciók használata
5. lépés: Szűrők használata
6. lépés: Ellenőrizzük az kinézetet. Eredmény: átlátható főoldal.


## 2. Teszesetek (TC)

### 2.1. Webshop tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Webshop oldal megnyitása kis ablakban (Menü)
- Bemenet: Oldal vizsgálata
- Művelet: Különböző méretekben végignézni az oldalt
- Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Gombok működése
- Bemenet: Oldal vizsgálata
- Művelet:  Szűrő, rendelés, header, footer gombok végignyomkodása
- Elvárt kimenet: A megfelelő helyre navigálnak, működnek

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: Szűrő működése
- Bemenet: Iphone
- Művelet:  beírom a szűrőbe, majd rákattintok a gombra
- Elvárt kimenet: A szűrő működik, megfelelő termékek jelennek meg

#### 2.1.4. TC-04
- TP: TP-01
- Leírás: Szűrő működése
- Bemenet: asd
- Művelet:  beírom a szűrőbe, majd rákattintok a gombra
- Elvárt kimenet: Nem jelenik meg semmi

#### 2.1.5. TC-05
- TP: TP-01
- Leírás: Szűrő működése
- Bemenet: 300
- Művelet:  beírom a szűrőbe, majd rákattintok a gombra
- Elvárt kimenet: Nem jelenik meg semmi



## 3. Tesztriportok (TR)

### 3.1. Webshop tesztesetei

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Végigtekerek az oldalon
    2. lépés: Szélességet összehúztom, kinagyítom 
    3. lépés: helyes eredményt kaptam (működik rendeltetés szerűen)

    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Rányomtam a szűrő gombra
    2. lépés: Rányomtam a rendelés gombra
    3. lépés: Rányomtam másik rendelés gombra
    4. lépés: Rányomtam a header linkekre
    5. lépés: Rányomtam a footer linkekre
    6. lépés: helyes eredményt kaptam (jó helyre irányítottak át)


#### 3.1.3. TR-03 (TC-03)
- TP: TP-01
    1. lépés: beírtam Iphone a szűrőbe
    2. lépés: Rányomtam a szűrő gombra
    3. lépés: helyes eredményt kaptam (iphonok jelentek meg csak)


#### 3.1.3. TR-04 (TC-04)
- TP: TP-01
    1. lépés: beírtam asd a szűrőbe
    2. lépés: Rányomtam a szűrő gombra
    3. lépés: helyes eredményt kaptam (nem jelent meg semmmi)

#### 3.1.3. TR-05 (TC-05)
- TP: TP-01
    1. lépés: beírtam 300 a minimum árba
    2. lépés: Rányomtam a szűrő gombra
    3. lépés: helyes eredményt kaptam (nem jelent meg semmmi)