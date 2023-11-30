# Tesztjegyzőkönyv-Felhasználói munkamenet

Az alábbi tesztdokumentum a Webshop projekthez tartozó 8.4.9. Felhasználói munkamenet tesztelése (TR) issuehoz készült. Felelőse: Gera Zdenkó 



## 1. Teszteljárások (TP)

### 1.1. Felhasználói munkamenet tesztelése 
- Azonosító: TP-01
- Tesztesetek: 
- Leírás: Felhasználói munkamenet tesztelése a webshopban
    0. lépés: Nyissuk meg az alkalmazást
    1. lépés: Nyomjunk a jobb felső sarokban elhelyezkedő profil gombra, majd jelentkezzünk be/regisztráljunk.
    2. lépés: Lépjünk a "Webáruház" menüpontra.
    3. lépés: Nyomjuk meg a listázott termékek közül az egyikhez tartozó "Kosárba" gombot, így eljutva az adott termék oldalára.
    4. lépés: Adjuk meg a vásárolni kívánt mennyiséget, majd nyomjuk meg a "Kosárba" gombot.
    5. lépés: Nyomjuk meg a "Rendelés" gombot a rendelés leadásához.
    6. lépés: Válasszuk ki a "Rendeléseim" menüpontot, ahol megjelenik az előbb leadott rendelésünk.
    7. lépés: Az "iShop" logó megnyomása után nyomjuk meg a jobb felső profilgombot.
    8. lépés: Jelentkezzünk ki a "Kijelentkezés" gombbal.


## 2. Teszesetek (TC)

### 2.1. Felhasználói munkamenet tesztesetei

#### 2.1.1. TC-01
- TP: TP-01
- Leírás: Felhasználói munkamenet tesztelése 
- Bemenet: Bejelentkezés, egy termék rendelése, rendelés részleteinek megtekintése.
- Művelet: Kijelentkezés.
- Elvárt kimenet: A felhasználó minden gomb/link használata után megfelelően van átirányítva.


## 3. Tesztriportok (TR)

### 3.1. Felhasználói munkamenet tesztriportjai

#### 3.1.1. TR-01 (TC-01)
- TP: TP-01
    1. lépés: Bejelentkeztem a fiókomba.
    2. lépés: Megrendeltem az "Apple iPad Pro" nevű termékből 2 darabot.
    3. lépés: Ellenőriztem a rendelésem részleteit utólag a "Rendeléseim" fül alatt.
    4. lépés: Kijelentkeztem az oldalról.
