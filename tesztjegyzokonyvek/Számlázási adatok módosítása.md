Tesztjegyzőkönyv

Webalkalmazás Számlázási Adatok Módosításának Tesztelése

Tesztelő neve: Petrányi Dominik



Teszteset 1: Irányítószám módosítása

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Keresse meg és válassza ki a "Profil" menüt.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Adja meg az új irányítószámot, ellenőrizve, hogy az csak 4 számjegyből álljon.

Várható eredmény: Az irányítószám módosítása sikeresen megtörténik, és a rendszer visszajelzést ad a frissítésről.



Teszteset 2: Város módosítása

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Keresse meg és válassza ki a "Profil" menüt.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Adja meg az új várost.

Várható eredmény: A város módosítása sikeresen megtörténik, és a rendszer visszajelzést ad a frissítésről.



Teszteset 3: Utca módosítása

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Keresse meg és válassza ki a "Profil" menüt.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Adja meg az új utcat nevet.

Várható eredmény: Az utca módosítása sikeresen megtörténik, és a rendszer visszajelzést ad a frissítésről.



Teszteset 4: Házszám módosítása

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Keresse meg és válassza ki a "Profil" menüt.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Adja meg az új házszámot, ellenőrizve, hogy az csak szám legyen.

Várható eredmény: A házszám módosítása sikeresen megtörténik, és a rendszer visszajelzést ad a frissítésről.



Teszteset 5: Hibakezelés - Irányítószám nem szám

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Az oldalon találja meg az "Irányítószám Módosítása" opciót.

Cselekvés: Adja meg az irányítószám mezőben egy olyan értéket, ami nem szám (pl., "ABC").

Várható eredmény: A rendszer nem engedi, hogy nem számot adj meg.



Teszteset 6: Hibakezelés - Házszám nem szám

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Az oldalon találja meg a "Házszám Módosítása" opciót.

Cselekvés: Adja meg a házszám mezőben egy olyan értéket, ami nem szám (pl., "XYZ").

Várható eredmény: A rendszer nem engedi, hogy nem számot adj meg.



Teszteset 7: Hibakezelés - Túl hosszú irányítószám

Cselekvés: Navigáljon az alkalmazás bejelentkező oldalára.

Cselekvés: Jelentkezzen be a tesztfelhasználóval.

Cselekvés: Az oldalon találja meg az "Számlázási adatok Módosítása" opciót.

Cselekvés: Az oldalon találja meg az "Irányítószám Módosítása" opciót.

Cselekvés: Adja meg az irányítószám mezőben egy érvényes számot, de több, mint 4 számjegyű értéket (pl., "12345").

Várható eredmény: A rendszer hibajelzést ad, hogy az irányítószám maximum 4 számjegy lehet.



Teszt lezárása:
Az összes teszteset sikeresen lefutott és a várható eredmények megfelelnek az elvárt működésnek.