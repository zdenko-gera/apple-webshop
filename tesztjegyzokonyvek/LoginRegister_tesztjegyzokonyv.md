# Tesztjegyzőkönyv-Bejelentkezés/Regisztráció

Az alábbi tesztdokumentum a webshop projekthez tartozó 8.3.1. Felhasználók kezelése (admin, egyszerű felhasználó) (CR) funkcióihoz készült. Felelőse: Varga Zoltán

## 1. Teszteljárások (TP)

### 1.1. Bejelentkezés funkció tesztelése

- Azonosító: TP-01
- Tesztesetek: TC-01, TC-02
- Leírás: összeadás funkció tesztelése 0. lépés: Nyissuk meg az alkalmazást, és regisztráció után lepjünk a bejelentkezés oldalra
  1. lépés: Az INPUT1 szövegbeviteli mezőbe írjunk be a TEXT1 szöveget
  2. lépés: Az INPUT2 szövegbeviteli mezőbe írjunk be a TEXT2 szöveget
  3. lépés: Nyomjuk meg a bejeletkezés gombot
  4. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: A felhasználó bejelentkezett állapotba kerül

### 1.2. Regisztráció funkció tesztelése

- Azonosító: TP-02
- Tesztesetek: TC-01
- Leírás: regisztráció funkció tesztelése 0. lépés: Nyissuk meg az alkalmazást, és lépjünk a regisztció oldalra
  1. lépés: Az INPUT1 szövegbeviteli mezőbe írjunk be a TEXT1 szöveget
  2. lépés: Az INPUT2 szövegbeviteli mezőbe írjunk be a TEXT2 szöveget
  3. lépés: Az INPUT3 szövegbeviteli mezőbe írjunk be a TEXT3 szöveget
  4. lépés: Az INPUT4 szövegbeviteli mezőbe írjunk be a TEXT4 szöveget
  5. lépés: Az INPUT5 szövegbeviteli mezőbe írjunk be a TEXT5 szöveget
  6. lépés: Nyomjuk meg a regisztráció gombot
  7. lépés: Ellenőrizzük az eredményt. Elvárt eredmény: Bekerül az adat az adatbázisba FIRSTNAME, LASTNAME, EMAIL, PASSWORD

## 2. Teszesetek (TC)

### 2.1. Bejelentkezés funkció tesztesetei

#### 2.1.1. TC-01

- TP: TP-01
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: INPUT1 = asdasd ; INPUT2 = asdasdasd
- Művelet: nyomjuk meg a bejelentkezés gombot
- Elvárt kimenet: hibaüzenetet ad vissza

#### 2.1.2. TC-02

- TP: TP-02
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: INPUT1 = asd@gmail.com ; INPUT2 = 0
- Művelet: nyomjuk meg a bejelentkezés gombot
- Elvárt kimenet: hibás bejelentkezési adatok

#### 2.1.3. TC-03

- TP: TP-03
- Leírás: bejelentkezés funkció tesztelése
- Bemenet: INPUT1 = asd@gmail.com ; INPUT2 = kisnagybetu800
- Művelet: nyomjuk meg a bejelentkezés gombot
- Elvárt kimenet: bejelentkezik a profilba

### 2.2. Regisztráció funkció tesztesetei

#### 2.2.1. TC-01

- TP: TP-01
- Leírás: regisztráció funkció tesztelése
- Bemenet: TEXT1= ., TEXT2= ., TEXT3=asd@gmail.com, TEXT4=........ , TEXT5=.........
- Művelet: nyomjuk meg a regisztráció gombot
- Elvárt kimenet: helyes kimenet

#### 2.2.2. TC-02

- TP: TP-02
- Leírás: regisztráció funkció tesztelése
- Bemenet: TEXT1= Kis, TEXT2= János, TEXT3=asd@r.r, TEXT4=asdasdasd , TEXT5=ASDASDASD
- Művelet: nyomjuk meg a regisztráció gombot
- Elvárt kimenet: helyes kimenet

#### 2.2.3. TC-03

- TP: TP-02
- Leírás: regisztráció funkció tesztelése
- Bemenet: TEXT1= Kis, TEXT2= János, TEXT3=asd@r, TEXT4=asdasdasd , TEXT5=asdasdasd
- Művelet: nyomjuk meg a regisztráció gombot
- Elvárt kimenet: nem megfelelő email formátum

#### 2.2.4. TC-05

- TP: TP-02
- Leírás: regisztráció funkció tesztelése
- Bemenet: TEXT1= Kis, TEXT2= János, TEXT3=asd@a.hu, TEXT4=asdasdasd , TEXT5=Asdasdasd
- Művelet: nyomjuk meg a regisztráció gombot
- Elvárt kimenet: nem megfelelő email formátum

#### 2.2.5. TC-06

- TP: TP-02
- Leírás: regisztráció funkció tesztelése
- Bemenet: TEXT1= Kis, TEXT2= János, TEXT3=asd@a.hu, TEXT4=asdasdasdasd , TEXT5=asdasdasd
- Művelet: nyomjuk meg a regisztráció gombot
- Elvárt kimenet: nem megfelelő email formátum

## 3. Tesztriportok (TR)

### 3.1. Bejelentkezés funkció tesztriportjai

#### 3.1.1. TR-01 (TC-01)

- TP: TP-01

  1. lépés: asdasd beírtam
  2. lépés: asdasdasd beírtam
  3. lépés: a bejelentkezési gombot megnyomva hibát ad
  4. lépés: helyes eredményt kaptam (hiba)

  #### 3.1.2. TR-02 (TC-02)

- TP: TP-01

  1. lépés: asd@gmail.com beírtam
  2. lépés: 0 beírtam
  3. lépés: a bejelentkezési gombot megnyomva hibát ad
  4. lépés: helyes eredményt kaptam (hiba)

  #### 3.1.3. TR-03 (TC-03)

- TP: TP-01
  1. lépés: asd@gmail.com beírtam
  2. lépés: kisnagybetu beírtam
  3. lépés: a gomb egyszeri megnyomás után inaktív lett
  4. lépés: helyes eredményt kaptam (bejelentkezett)

### 3.1. Regisztráció funkció tesztriportjai

#### 3.1.2. TR-01 (TC-01)

- TP: TP-01

  1. lépés: beírtam .
  2. lépés: beírtam .
  3. lépés: beírtam asd@gmail.com
  4. lépés: beírtam ........
  5. lépés: beírtam ........
  6. lépés: helyes eredményt kaptam

  #### 3.1.2. TR-02 (TC-02)

- TP: TP-01

  1. lépés: beírtam Kis
  2. lépés: beírtam János
  3. lépés: beírtam asd@r.r
  4. lépés: beírtam asdasdasd
  5. lépés: beírtam asdasdasd
  6. lépés: helyes eredményt kaptam

  #### 3.1.2. TR-03 (TC-03)

- TP: TP-01

  1. lépés: beírtam Kis
  2. lépés: beírtam János
  3. lépés: beírtam asd@r
  4. lépés: beírtam asdasdasd
  5. lépés: beírtam asdasdasd
  6. lépés: helyes eredményt kaptam (hiba)

  #### 3.1.2. TR-04 (TC-04)

- TP: TP-01

  1. lépés: beírtam Kis
  2. lépés: beírtam János
  3. lépés: beírtam asdr.r
  4. lépés: beírtam asdasdasd
  5. lépés: beírtam asdasdasd
  6. lépés: helyes eredményt kaptam (hiba)

  #### 3.1.2. TR-05 (TC-05)

- TP: TP-01

  1. lépés: beírtam Kis
  2. lépés: beírtam János
  3. lépés: beírtam asd@a.hu
  4. lépés: beírtam Asdasdasd
  5. lépés: beírtam asdasdasd
  6. lépés: helyes eredményt kaptam (hiba nem egyenló jelszó)

  #### 3.1.2. TR-06 (TC-06)

- TP: TP-01
  1. lépés: beírtam Kis
  2. lépés: beírtam János
  3. lépés: beírtam asd@a.hu
  4. lépés: beírtam asdasdasdasd
  5. lépés: beírtam asdasdasd
  6. lépés: helyes eredményt kaptam (hiba nem egyenlő jelszó)
