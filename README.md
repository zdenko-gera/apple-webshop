### Readme ###

Az adatbazishoz xampp phpmyadmint használtunk és egy külön felhasználóval lehet elérni az adatbázist, ami a következőképp néz ki:

username: webshop
pw: webshop
minden engedély be van pipálva


az sql beimportálásával át lesz állítva a max_connections változó, de ha véletlen random lehalna az oldal akkor egy mysql kikapcs, bekapcs majd 
SET GLOBAL max_connections = 9999999; 
megoldja a gondot.

továbbá a projekttervet változtató commit nevének a végén szerepel egy 'sziaocsi', utólag jöttünk rá, hogy ez akár félreérthető is lehet, de ez csak egy belsős poén :D .

a projektet idő hiányában nem sikerült kitelepíteni éles környezetbe

az admin oldalait az admin@teszt.com , adminadmin bejelentkezéssel lehet elérni. A böngészősávot kell átírni:
http://localhost:8081/Admin
majd bal oldalt a menüben lehet váltogatni az admin oldalak között
