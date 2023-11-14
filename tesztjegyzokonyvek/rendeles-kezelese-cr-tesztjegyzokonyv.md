# Tesztjegyzőkönyv-Rendelés kezelése CR

Az alábbi tesztdokumentum a Webshop projekthez tartozó 8.3.10-11. Rendelés kezelése CR funkcióihoz készült. Felelőse: Gera Zdenkó 



## 1. Teszteljárások (TP)

### 1.1. Rendelés leadása (CR) funkció tesztelése 
- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: Rendelés leadása (C) funkció tesztelése
    0. lépés: Nyissuk meg az alkalmazást, és regisztráljunk, vagy, ha már megtettük, jelentkezzünk be.
    1. lépés: Nyomjuk meg a 'Webáruház' navigációs gombot.
    2. lépés: A kivánt termék alatt nyomjuk meg a 'Megtekintés' gombot.
    3. lépés: Adjuk meg a mennyiséget, majd nyomjuk meg a 'Kosárba' gombot.
    4. lépés: Nyomjuk meg a 'Rendelés' gombot.

## 2. Teszesetek (TC)

### 2.1. Rendelés leadása (CR) funkció tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Rendelés leadása (CR) funkció tesztelése 
- Bemenet: Apple iPad Mini 6 --> 'Megtekintés' gomb.
- Művelet: Nyomjuk meg az 'Kosárba' gombot miután megadtuk a 0-nál nagyobb mennyiséget, majd a 'Rendelés' gombot.
- Elvárt kimenet: A rendelés adatai megjelennek a user rendelései között.

#### 2.1.2. TC-02
- TP: TP-01
- Leírás: Rendelés leadása (CR) funkció tesztelése 
- Bemenet: Apple iPad Mini 6 --> 'Megtekintés' gomb.
- Művelet: Nyomjuk meg az 'Kosárba' gombot miután megadtuk a 0 mennyiséget.
- Elvárt kimenet: Nem engedi beletenni a kosárba a 0, vagy negatív mennyiségű termékeket.

#### 2.1.2. TC-03
- TP: TP-01
- Leírás: Rendelés leadása (CR) funkció tesztelése 
- Bemenet: Apple iPad Mini 6 --> 'Megtekintés' gomb.
- Művelet: Nyomjuk meg az 'Kosárba' gombot miután megadtuk a negatív mennyiséget.
- Elvárt kimenet: Nem engedi beletenni a kosárba a 0, vagy negatív mennyiségű termékeket.

## 3. Tesztriportok (TR)

### 3.1. Rendelés leadása (CR) funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Megnyomtam az Apple iPad Mini 6-hoz tartozó 'Megtekintés' gombra.
    2. lépés: Megadtam egy pozitív előjelű mennyiséget, majd megnyomtam a 'Kosárba' gombot.
    3. lépés: A termék sikeresen belekerült a kosaramba, át lettem irányítva a kosár felületre.
    4. lépés: A 'Rendelés' gomb megnyomása után a rendelés megjelenik a rendeléseim között.
    

#### 3.1.2. TR-02 (TC-02)
- TP: TP-01
    1. lépés: Megnyomtam az Apple iPad Mini 6-hoz tartozó 'Megtekintés' gombra.
    2. lépés: Megadtam 0-t, mint mennyiség, majd megnyomtam a 'Kosárba' gombot.
    3. lépés: A terméket nem sikerült a kosaramba helyezni, az oldal visszadobott a 'Webáruház' felületre.


#### 3.1.2. TR-02 (TC-03)
- TP: TP-01
    1. lépés: Megnyomtam az Apple iPad Mini 6-hoz tartozó 'Megtekintés' gombra.
    2. lépés: Megadtam a negatív előjelű mennyiség, majd megnyomtam a 'Kosárba' gombot.
    3. lépés: A terméket nem sikerült a kosaramba helyezni, az oldal visszadobott a 'Webáruház' felületre.