# Tesztjegyzőkönyv-Reszponzivitás-Felhasználói élmény

Az alábbi tesztdokumentum a weboldal projekthez tartozó 8.3.16. Termék oldal (HTML, CSS)funkcióihoz készült. Felelőse: Nagy Vencel 

## 1. Teszteljárások (TP)

### 1.1. Termék oldal tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Leírás: Főoldal megnyitása kis ablakban
0. lépés: Böngésző megnyitása
1. lépés: Termék oldal megnyitás
2. lépés: Görgetés az oldalon 
3. lépés: Menü használata
4. lépés: Funkciók használata
5. lépés: Szűrők használata
6. lépés: Ellenőrizzük az kinézetet. Eredmény: átlátható főoldal.


## 2. Teszesetek (TC)

### 2.1. Termék oldal tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Termék oldal oldal megnyitása kis ablakban (Menü)
- Bemenet: Oldal vizsgálata
- Művelet: Különböző méretekben végignézni az oldalt
- Elvárt kimenet: minden megjelenik, nem csúszik össze, átlátható

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Gombok működése
- Bemenet: Oldal vizsgálata
- Művelet: rendelés, header, footer gombok végignyomkodása
- Elvárt kimenet: A megfelelő helyre navigálnak, működnek

#### 2.1.3. TC-03
- TP: TP-01
- Leírás: Bejelentkezett Komment írás működése
- Bemenet: Kiváló termék.
- Művelet:  beírom a szűrőbe, kiválasztom az értékelést, majd rákattintok a gombra
- Elvárt kimenet: Sikeresen elküldi a kommentet

#### 2.1.4. TC-04
- TP: TP-01
- Leírás: Komment írás működése
- Bemenet: Kiváló termék.
- Művelet:  beírom a szűrőbe, kiválasztom az értékelést, majd rákattintok a gombra
- Elvárt kimenet: Átdob a bejelentkezés oldalra.



## 3. Tesztriportok (TR)

### 3.1. Termék oldal tesztesetei

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
    1. lépés: beírtam Kiváló termék. a komment mezőbe
    2. lépés: Kiválasztottam az értékelést
    2. lépés: Rányomtam a küldés gombra
    3. lépés: helyes eredményt kaptam (Sikeres küldés)


#### 3.1.3. TR-04 (TC-04)
- TP: TP-01
    1. lépés: beírtam Kiváló termék. a komment mezőbe
    2. lépés: Kiválasztottam az értékelést
    2. lépés: Rányomtam a küldés gombra
    3. lépés: helyes eredményt kaptam (Átdob a bejelentkezés oldalray)

