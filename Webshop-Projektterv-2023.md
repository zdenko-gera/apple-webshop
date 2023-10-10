# Webshop Projektterv 2023

## 1. Összefoglaló

A projektünk egy Apple termékeket áruló webshop, amelynek célja az Apple rajongók számára egy kényelmes és megbízható online vásárlási platform biztosítása. Az oldalunkon széles választékban kínálunk Apple termékeket, mint például iPhone-ok, MacBook-ok, iPad-ek és kiegészítők. Az apple termékek népszerűsége folyamatosan nő, és a felhasználók gyors és egyszerű vásárlási lehetőséget várnak tőlünk, mi pedig emellé nyomott áron biztosítjuk kedvenc termékeiket. Célunk, hogy magas színvonalú szolgáltatást nyújtsunk és egy olyan online teret hozzunk létre, ahol az Apple termékeket kedvelők könnyen megtalálhatják és megvásárolhatják a kívánt eszközöket és tartozékokat.

## 2. A projekt bemutatása

Ez a projektterv a webshop projektet mutatja be, amely 2023-09-11-től 2023-12-05-ig tart, azaz összesen 85 napon keresztül fog futni. A projekten hat fejlesztő fog dolgozni, az elvégzett feladatokat pedig négy alkalommal fogjuk prezentálni a megrendelőnek, annak érdekében, hogy biztosítsuk a projekt folyamatos előrehaladását.

### 2.1. Rendszerspecifikáció

A fő cél az Apple termékek értékesítésére szakosodott webshop létrehozása, ahol a felhasználók könnyedén böngészhetik és vásárolhatják meg a legújabb Apple eszközöket és tartozékokat. Az Apple termékek rajongóinak közösségi funkciót is kínálunk, ahol a felhasználók véleményt cserélhetnek a termékekről, értékelhetik őket és megoszthatják tapasztalataikat. Az oldal tartalmazni fog egy részt, ahol hírek és információk találhatók az Apple világából, beleértve a legújabb termékleírásokat, teszteket és frissítéseket. Ez segít a felhasználóknak naprakészen maradni a legfrissebb Apple hírekkel. A projekt keretében kiemelten fogunk foglalkozni a felhasználói élmény és a felhasználói interakciók optimalizálásával, hogy az oldal egyszerűen kezelhető legyen mind a mobil, mind a asztali eszközökön, ezáltal az Apple termékek iránt érdeklődők számára még vonzóbbá téve a vásárlást.

### 2.2. Funkcionális követelmények

- Felhasználók kezelése (admin, vásárló) (CRUD)
- Felhasználói munkamenet megvalósítása több jogosultsági szinttel (Admin, egyszerű felhasználó)
- Árukészletek kezelése (CRUD)
- Kosár kezelése (CRUD)
- Rendelések kezelése (CRUD)
- A termékek közötti szűrés, illetve keresés
- Felhasználóként posztolás a fórumon
- Felhasználói beállítások szerkesztése

### 2.3. Nem funkcionális követelmények

- A kliens oldal böngészőfüggetlen legyen
- Reszponzív megjelenés
- Modern design
- Az érzékeny adatokat biztonságosan tároljuk
- A legfrissebb technológiákat használja a rendszer

## 3. Költség- és erőforrás-szükségletek

Az erőforrásigényünk összesen 102 személynap, átlagosan 17 személynap/fő.

A rendelkezésünkre áll összesen 6 * 70 = 420 pont.


## 4. Szervezeti felépítés és felelősségmegosztás

A projekt megrendelője Dr. Kertész Attila. A Webshop projektet a projektcsapat fogja végrehajtani, amely jelenleg hat fejlesztőből áll. A csapatban kizárólag pályakezdő programozó található.

- Bényei Anna Dorina
- Molnár-Farkas Noel
- Gera Zdenkó
- Nagy Vencel
- Varga Zoltán
- Petrányi Dominik (2 év egyetemi tapasztalat, jelenleg szoftverfejlesztő gyakornok a RabIT Solutions Zrt-nél)

### 4.1 Projektcsapat

A projekt a következő emberekből áll:

| Név                | Pozíció          | E-mail cím (stud-os)     |
| ------------------ | ---------------- | ------------------------ |
| Petrányi Dominik   | Projektmenedzser | h268432@stud.u-szeged.hu |
| Bényei Anna Dorina | Projekt tag      | h255398@stud.u-szeged.hu |
| Molnár-Farkas Noel | Projekt tag      | h267706@stud.u-szeged.hu |
| Gera Zdenkó        | Projekt tag      | h157872@stud.u-szeged.hu |
| Varga Zoltán       | Projekt tag      | h270521@stud.u-szeged.hu |
| Nagy Vencel        | Projekt tag      | h268010@stud.u-szeged.hu |

## 5. A munka feltételei

### 5.1. Munkakörnyezet

A projekt a következő munkaállomásokat fogja használni a munka során:

- Munkaállomások: 5 db, Windows 10-es operációs rendszerrel és 1db, macOS operációs rendszerrel rendelkező munkafelület
- Acer aspire 5 a515-55g-55jf (CPU: i5-1035G1, RAM: 8GB, GPU: NVIDIA® GeForce® MX350 2GB GDDR5)
- Acer Aspire A515-45 (CPU: Ryzen 5 5500U, RAM: 16GB, GPU: Processzorba integrált Radeon Graphics Vega 7)
- Dell XPS 15 9570 (CPU: Intel i7 8750H, RAM: 16GB, GPU: NVIDIA GeForce GTX 1050 Ti, OS: Windows 10)
- Dell G15 5510 (CPU: Intel i7 11800H, RAM: 16GB, GPU: NVIDIA® GeForce® 3050 Ti, OS: Windows 10)
- Dell Latitude E5470 (CPU: Intel i3 6100U, RAM: 8GB, GPU: Intel HD Graphics 520)
- Apple MacBook Air (CPU: M1 Chip, RAM: 16GB)

A projekt a következő technológiákat/szoftvereket fogja használni a munka során:

- Git verziókövető (GitLab)
- Java Spring Boot keretrendszer
- IntelliJ IDEA fejlesztőkörnyezet
- Visual Studio Code fejlesztőkörnyezet
- MySQL adatbázisszerver
- Bootstrap CSS framework

### 5.2. Rizikómenedzsment

| Kockázat                                  | Leírás                                                                                                                                                                                   | Valószínűség | Hatás   |
| ----------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------ | ------- |
| Betegség                                  | Súlyosságtól függően hátráltatja vagy bizonyos esetekben teljes mértékben korlátozza a munkavégzőt, így az egész projektre kihatással van. Megoldás: a feladatok átcsoportosítása        | nagy         | erős    |
| Kommunikációs fennakadás a csapattagokkal | A csapattagok között nem elégséges az információ áramlás, nem pontosan, esetleg késve vagy nem egyértelműen tájékoztatjuk egymást. Megoldás: még gyakoribb megbeszélések és ellenőrzések | kis          | erős    |
| Minőségbeli problémák                     | A csapattagok nem megfelelő minőségben végzik el feladatukat a projektben. Megoldás: megfelelő kommunikáció, segítség kérés/nyújtás                                                      | közepes      | közepes |
| Időgazdálkodási problémák                 | A tagok nem fejezik be feladatukat a megadott időpontig, ez bekövetkezhet hanyagságból vagy egyéb külső problémákból(ZH). Megoldás: pótlás vagy erőforrás átcsoportosítás                | kis          | közepes |
| Váratlan események                        | Bármilyen külső esemény (egészségügyi krízis, természeti katasztrófa) nagy hatással lehet a projekt kimenetelére. Megoldás: Minnél hamarabbi helyreállás                                 | kis          | erős    |

## 6. Jelentések

### 6.1. Munka menedzsment

A munkát Petrányi Dominik koordinálja. Fő feladata, hogy folyamatosan egyeztessen a csapattagokkal az előrehaladásról és a fellépő problémákról, esetlegesen a megoldásban is segítséget nyújhat a projekt csúszásának elkerülése végett. További feladata a heti szinten tartandó csoportgyűlések időpontjának és helyszínének leszervezése, erről üzenetben tájékoztatja a projektcsapatot.

### 6.2. Csoportgyűlések

A projekt hetente ülésezik, hogy megvitassák az azt megelőző hét problémáit, illetve hogy megbeszéljék a következő hét feladatait. A megbeszélésről minden esetben memó készül.

1. megbeszélés:

- Időpont: 2021.09.13.
- Hely: SZTE Irinyi épület - Szeged, Tisza Lajos krt. 103
- Résztvevők: Varga Zoltán, Nagy Vencel, Petrányi Dominik, Bényei Anna, Gera Zdenkó, Molnár-Farkas Noel
- Érintett témák: Kiválasztottuk a projektünk témáját.

2. megbeszélés:

- Időpont: 2021.09.20.
- Hely: SZTE Irinyi épület - Szeged, Tisza Lajos krt. 103
- Résztvevők: Varga Zoltán, Nagy Vencel, Petrányi Dominik, Bényei Anna, Gera Zdenkó, Molnár-Farkas Noel
- Érintett témák: Megbeszéltük, hogy előreláthatólag ki melyik részén dolgozik a projektnek.

3. megbeszélés:

- Időpont: 2021.10.04.
- Hely: SZTE Irinyi épület - Szeged, Tisza Lajos krt. 103
- Résztvevők: Varga Zoltán, Nagy Vencel, Petrányi Dominik, Bényei Anna, Gera Zdenkó, Molnár-Farkas Noel
- Érintett témák: Megbeszéltük, hogy hogyan kell használni a gitet, ki is próbáltuk azt, a projekt funkcióit nagyvonalakban egyeztettük.

4. megbeszélés:

- Időpont: 2023.10.09
- Hely: Blue Café - Szeged, Somogyi utca 20.
- Résztvevők: Varga Zoltán, Nagy Vencel, Petrányi Dominik, Gera Zdenkó, Molnár-Farkas Noel
- Érintett témák: Megbeszéltük a project fontosabb funkciót, illetve elosztottuk a feladatokat.

### 6.3. Minőségbiztosítás

Az elkészült terveket a terveken nem dolgozó csapattársak közül átnézik, hogy megfelel-e a specifikációnak és az egyes diagramtípusok összhangban vannak-e egymással. A meglévő rendszerünk helyes működését a prototípusok bemutatása előtt a tesztelési dokumentumban leírtak végrehajtása alapján ellenőrizzük és összevetjük a specifikációval, hogy az elvárt eredményt kapjuk-e. További tesztelési lehetőségek: unit tesztek írása az egyes modulokhoz vagy a kód közös átnézése (code review) egy, a vizsgált modul programozásában nem résztvevő csapattaggal. Szoftverünk minőségét a végső leadás előtt javítani kell a rendszerünkre lefuttatott kódelemzés során kapott metrikaértékek és szabálysértések figyelembevételével.
Az alábbi lehetőségek vannak a szoftver megfelelő minőségének biztosítására:

- Specifikáció és tervek átnézése (kötelező)
- Teszttervek végrehajtása (kötelező)
- Unit tesztek írása (választható)
- Kód átnézése (választható)

### 6.4. Átadás, eredmények elfogadása

A projekt eredményeit a megrendelő, Dr. Kertész Attila fogja elfogadni. A projektterven változásokat csak a megrendelő írásos engedélyével lehet tenni. A projekt eredményesnek bizonyul, ha specifikáció helyes és határidőn belül készül el. Az esetleges késések pontlevonást eredményeznek.
Az elfogadás feltételeire és beadás formájára vonatkozó részletes leírás a következő honlapon olvasható: https://okt.inf.szte.hu/rf1/

### 6.5. Státuszjelentés

Minden mérföldkő leadásnál a projekten dolgozók jelentést tesznek a mérföldkőben végzett munkájukról a a megadott sablon alapján. A gyakorlatvezetővel folytatott csapatmegbeszéléseken a csapat áttekintik és felmérik az eredményeket és teendőket. Továbbá gazdálkodnak az erőforrásokkal és szükség esetén a megrendelővel egyeztetnek a projektterv módosításáról.

## 7. A munka tartalma

### 7.1. Tervezett szoftverfolyamat modell és architektúra

A szoftver fejlesztése során az agilis fejlesztési modellt alkalmazzuk, mivel a fejlesztés során nagy hangsúlyt fektetünk a folyamatos kommunikcióra. A fejlesztés során a szoftver specifikációi rugalmasan vátozhatnak, és ezzel a módszertannal tudunk a leggyorsabban alkalmazkodni az új elvárásokhoz.

A webalkalmazás az MVC (modell-view-controller) felépítést követi, a szerver és a kliens függetlenek, csupán API végpontok segítségével kommunikálnak.

### 7.2. Átadandók és határidők

A főbb átadandók és határidők a projekt időtartama alatt a következők:

| Szállítandó |                                 Neve                                  | Határideje |
| :---------: | :-------------------------------------------------------------------: | :--------: |
|     D1      |       Projektterv és Gantt chart, prezentáció, egyéni jelentés        | 2023-10-10 |
|     D2      |    UML, adatbázis- és képernyőtervek, prezentáció, egyéni jelentés    | 2023-10-24 |
|    P1+D3    |       Prototípus I. és tesztelési dokumentáció, egyéni jelentés       | 2023-11-14 |
|    P2+D4    | Prototípus II. és frissített tesztelési dokumentáció, egyéni jelentés | 2023-12-05 |

## 8. Feladatlista

A következőkben a tervezett feladatok részletes összefoglalása található.

### 8.1. Projektterv (1. mérföldkő)

Ennek a feladatnak az a célja, hogy megvalósításhoz szükséges lépéseket, az erőforrásigényeket, az ütemezést, a felelősöket és a feladatok sorrendjét meghatározzuk, majd vizualizáljuk Gantt diagram segítségével.

Részfeladatai a következők:

#### 8.1.1. Projektterv kitöltése

Felelős: Mindenki

Tartam: 7 nap

Erőforrásigény: 1 személynap/fő

#### 8.1.2. Bemutató elkészítése

Felelős: Bényei Anna

Tartam: 2 nap

Erőforrásigény: 0.5 személynap

### 8.2. UML és adatbázis- és képernyőtervek (2. mérföldkő)

Ennek a feladatnak az a célja, hogy a rendszerarchitektúrát, az adatbázist és webalkalmazás kinézetét megtervezzük.

Részfeladatai a következők:

#### 8.2.1. Használati eset diagram

Felelős: Gera Zdenkó

Tartam: 3 nap

Erőforrásigény: 1.5 személynap

#### 8.2.2. Osztály diagram

Felelős: Petrányi Dominik

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.2.3. Szekvencia diagram

Felelős: Molnár-Farkas Noel

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.2.4. Egyed-kapcsolat diagram adatbázishoz

Felelős: Varga Zoltán

Tartam: 3 nap

Erőforrásigény: 1 személynap

#### 8.2.5. Relációs adatbázisséma kialakítása

Felelős: Varga Zoltán

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.2.6. Csomag diagram

Felelős: Bényei Anna

Tartam: 3 nap

Erőforrásigény: 0.5 személynap

#### 8.2.7. Képernyőtervek (Főoldal, Termék oldal, Webshop)

Felelős: Nagy Vencel

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.2.8. Képernyőtervek (Bejeltkezési oldal, AdminPage)

Felelős: Bényi Anna

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.2.9. Bemutató elkészítése

Felelős: Petrányi Dominik

Tartam: 2 nap

Erőforrásigény: 0.5 személynap

### 8.3. Prototípus I. (3. mérföldkő)

Ennek a feladatnak az a célja, hogy egy működő prototípust hozzunk létre, ahol a vállalt funkcionális követelmények nagy része már prezentálható állapotban van.

Részfeladatai a következők:

#### 8.3.1. Felhasználók kezelése (admin, egyszerű felhasználó) (CR)

Felelős: Varga Zoltán

Tartam: 6 nap

Erőforrásigény: 3 személynap

#### 8.3.2. Felhasználók kezelése (admin, egyszerű felhasználó) (U)

Felelős: Petrányi Dominik

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.3.3. Felhasználók kezelése (admin, egyszerű felhasználó) (D)

Felelős: Molnár-Farkas Noel

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.3.4. Felhasználók kezeléséhez szükséges adatok létrehozása az adatbázisban

Felelős: Gera Zdenkó

Tartam: 5 nap

Erőforrásigény: 3 személynap

#### 8.3.5. Felhasználói munkamenet megvalósítása több jogosultsági szinttel

Felelős: Molnár-Farkas Noel

Tartam: 10 nap

Erőforrásigény: 4 személynap

#### 8.3.6. Árukészletek kezelése (CR)

Felelős: Gera Zdenkó

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.3.7. Árukészletek kezelése (UD)

Felelős: Petrányi Dominik

Tartam: 5 nap

Erőforrásigény: 2 személynap

#### 8.3.8. Árukészletek kezeléséhez szükséges adatok létrehozása az adatbázisban

Felelős: Petrányi Dominik

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.3.9. Kosár kezelése (CRUD)

Felelős: Varga Zoltán

Tartam: 5 nap

Erőforrásigény: 3 személynap

#### 8.3.10. Rendelés kezelése (CR)

Felelős: Varga Zoltán

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.3.11. Rendelés kezelése (UD)

Felelős: Gera Zdenkó

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.3.12. Főoldal létrehozása (HTML, CSS)

Felelős: Nagy Vencel

Tartam: 7 nap

Erőforrásigény: 2.5 személynap/fő

#### 8.3.13. Webhop létrehozása (HTML, CSS)

Felelős: Bényei Anna

Tartam: 6 nap

Erőforrásigény: 2.5 személynap/fő

#### 8.3.14. AdminPage létrehozása (HTML, CSS)

Felelős: Nagy Vencel

Tartam: 3 nap

Erőforrásigény: 1.5 személynap/fő

#### 8.3.15. Bejelentkezés/Regisztráció oldal létrehozása (HTML, CSS)

Felelős: Nagy Vencel

Tartam: 5 nap

Erőforrásigény: 2.5 személynap/fő

#### 8.3.16. Termék oldal (HTML, CSS)

Felelős: Bényei Anna

Tartam: 4 nap

Erőforrásigény: 2 személynap/fő

#### 8.3.17. Profil oldal létrehozása (HTML, CSS)

Felelős: Nagy Vencel

Tartam: 3 nap

Erőforrásigény: 1.5 személynap/fő

#### 8.3.18. Tesztelési dokumentum az összes funkcióhoz (TP, TC)

Felelős: Mindenki

Tartam: 7 nap

Erőforrásigény: 1 személynap/fő

#### 8.3.19. A prototípus kitelepítése éles környezetbe

Felelős: Petrányi Dominik

Tartam: 3 nap

Erőforrásigény: 1.5 személynap

### 8.4. Prototípus II. (4. mérföldkő)

Ennek a feladatnak az a célja, hogy az előző mérföldkő hiányzó funkcióit pótoljuk, illetve a hibásan működő funkciókat és az esetlegesen felmerülő új funkciókat megvalósítsuk. Továbbá az alkalmazás alapos tesztelése is a mérföldkőben történik az előző mérföldkőben összeállított tesztesetek alapján.

Részfeladatai a következők:

#### 8.4.1. Böngésző független frontend létrehozása

Felelős: Bényei Anna

Tartam: 6 nap

Erőforrásigény: 3 személynap

#### 8.4.2. Reszponzív kinézet létrehozása

Felelős: Nagy Vencel

Tartam: 6 nap

Erőforrásigény: 3 személynap

#### 8.4.3. Keresési/szűrési funkció a termékek között

Felelős: Molnár-Farkas Noel

Tartam: 5 nap

Erőforrásigény: 2.5 személynap

#### 8.4.4. Fórumon való böngészés - mindenkinek (R)

Felelős: Gera Zdenkó

Tartam: 5 nap

Erőforrásigény: 2.5 személynap

#### 8.4.5. Fórumon való hozzászólás - regisztrált felhasználóknak (CUD)

Felelős: Varga Zoltán

Tartam: 5 nap

Erőforrásigény: 2.5 személynap

#### 8.4.6. Fórum használatához szükséges adatok létrehozása az adatbázisban

Felelős: Varga Zoltán

Tartam: 3 nap

Erőforrásigény: 1 személynap

#### 8.4.7. Felhasználói adatok módosítása (CRUD)

Felelős: Petrányi Dominik

Tartam: 5 nap

Erőforrásigény: 2 személynap

#### 8.4.8. Email-es értesítés rendelés leadásakor

Felelős: Varga Zoltán

Tartam: 4 nap

Erőforrásigény: 2 személynap

#### 8.4.9. Felhasználói munkamenet tesztelése (TR)

Felelős: Gera Zdenkó

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.4.10. Rendelés kezelésének tesztelése (TR)

Felelős: Molnár-Farkas Noel

Tartam: 2 nap

Erőforrásigény: 1.5 személynap

#### 8.4.11. Reszponzivitás kezelésének tesztelése (TR)

Felelős: Bényei Anna

Tartam: 2 nap

Erőforrásigény: 1.5 személynap

#### 8.4.12. Böngésző függetlenség kezelésének tesztelése (TR)

Felelős: Nagy Vencel

Tartam: 2 nap

Erőforrásigény: 1.5 személynap

#### 8.4.13. Árukészlet kezelésének tesztelése (TR)

Felelős: Varga Zoltán

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.4.14. Felhasználói élmény kezelésének tesztelése (TR)

Felelős: Nagy Vencel

Tartam: 2 nap

Erőforrásigény: 1 személynap

#### 8.4.15. A prototípus kitelepítésének frissítése

Felelős: Petrányi Dominik

Tartam: 1 nap

Erőforrásigény: 1 személynap

## 9. Részletes időbeosztás

![image](./MINTA-gantt-diagram.png)

## 10. Projekt költségvetés

### 10.1. Részletes erőforrásigény (személynap)

| Név          | M1    | M2    | M3   | M4    | Összesen |
| ------------ | ----- | ----- | ---- | ----- | -------- |
| Bényei Anna | 1.5 | 2.5 | 5.5 | 4.5   | 14     |
| Gera Zdenkó | 1   | 1.5   | 8 | 3.5   | 14     |
| Molnár-Farkas Noel| 1   | 2 | 6 | 4 | 13     |
| Nagy Vencel   | 1   | 2 | 9 | 5.5 | 17.5     |
| Petrányi Dominik| 1   | 2.5 | 5 | 3 | 11.5     |
| Varga Zoltán   | 1   | 2 | 9 | 6.5 | 18.5     |

### 10.2. Részletes feladatszámok

| Név          | M1  | M2  | M3  | M4  | Összesen |
| ------------ | --- | --- | --- | --- | -------- |
| `Teszt Elek` | `2` | `2` | `7` | `4` | `15`     |
| `Remek Elek` | `1` | `2` | `7` | `4` | `14`     |
| `Lev Elek`   | `1` | `2` | `7` | `4` | `14`     |
| `Lev Elek`   | `1` | `2` | `7` | `4` | `14`     |
| `Lev Elek`   | `1` | `2` | `7` | `4` | `14`     |
| `Lev Elek`   | `1` | `2` | `7` | `4` | `14`     |

### 10.3. Részletes költségvetés

| Név                                | M1  | M2   | M3   | M4   | Összesen  |
| ---------------------------------- | --- | ---- | ---- | ---- | --------- |
| Maximálisan megszerezhető pontszám | (7) | (20) | (35) | (28) | 100% (70) |
| `Teszt Elek`                       | `7` | `10` | `28` | `25` | 70        |
| `Remek Elek`                       | `4` | `15` | `35` | `16` | 70        |
| `Lev Elek`                         | `4` | `12` | `30` | `24` | 70        |

Szeged, 2023-10-10
