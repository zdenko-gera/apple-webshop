-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Nov 12. 18:36
-- Kiszolgáló verziója: 10.4.27-MariaDB
-- PHP verzió: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Adatbázis: `webshop`
--
CREATE DATABASE IF NOT EXISTS `webshop` DEFAULT CHARACTER SET utf8 COLLATE utf8_hungarian_ci;
USE `webshop`;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `billingdetails`
--

CREATE TABLE `billingdetails` (
  `email` varchar(100) NOT NULL,
  `postalcode` int(11) NOT NULL,
  `city` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `housenumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `billingdetails`
--

INSERT INTO `billingdetails` (`email`, `postalcode`, `city`, `street`, `housenumber`) VALUES
('admin@teszt.com', -1, '', '', -1),
('bivalyulrich@gmail.com', -1, '', '', -1),
('kisspista@gmail.com', -1, '', '', -1),
('kovacsbertalan@gmail.com', -1, '', '', -1),
('kowalskyvega@gmail.com', -1, '', '', -1),
('lakatosemanuel@gmail.com', -1, '', '', -1),
('nagyimre@gmail.com', -1, '', '', -1),
('nagylajos@gmail.com', -1, '', '', -1),
('nagymarika@gmail.com', -1, '', '', -1),
('palpeter@gmail.com', -1, '', '', -1),
('papucspeter@gmail.com', -1, '', '', -1),
('peterpal@gmail.com', -1, '', '', -1),
('sirlancelot@gmail.com', -1, '', '', -1),
('tesztelek@tesztelek.com', -1, '', '', -1),
('tisztasag@gmail.com', -1, '', '', -1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `cart`
--

CREATE TABLE `cart` (
  `cartID` int(11) NOT NULL,
  `email` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `cart`
--

INSERT INTO `cart` (`cartID`, `email`) VALUES
(3, 'admin@teszt.com'),
(14, 'bivalyulrich@gmail.com'),
(5, 'kisspista@gmail.com'),
(8, 'kovacsbertalan@gmail.com'),
(16, 'kowalskyvega@gmail.com'),
(10, 'lakatosemanuel@gmail.com'),
(6, 'nagyimre@gmail.com'),
(9, 'nagylajos@gmail.com'),
(7, 'nagymarika@gmail.com'),
(12, 'palpeter@gmail.com'),
(17, 'papucspeter@gmail.com'),
(11, 'peterpal@gmail.com'),
(15, 'sirlancelot@gmail.com'),
(4, 'tesztelek@tesztelek.com'),
(13, 'tisztasag@gmail.com');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `comment`
--

CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `productID` int(11) NOT NULL,
  `publishDate` date NOT NULL,
  `comment` varchar(200) NOT NULL,
  `rate` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `deliverydetails`
--

CREATE TABLE `deliverydetails` (
  `email` varchar(100) NOT NULL,
  `postalcode` int(11) NOT NULL,
  `city` varchar(30) NOT NULL,
  `street` varchar(30) NOT NULL,
  `housenumber` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `deliverydetails`
--

INSERT INTO `deliverydetails` (`email`, `postalcode`, `city`, `street`, `housenumber`) VALUES
('admin@teszt.com', -1, '', '', -1),
('bivalyulrich@gmail.com', -1, '', '', -1),
('kisspista@gmail.com', -1, '', '', -1),
('kovacsbertalan@gmail.com', -1, '', '', -1),
('kowalskyvega@gmail.com', -1, '', '', -1),
('lakatosemanuel@gmail.com', -1, '', '', -1),
('nagyimre@gmail.com', -1, '', '', -1),
('nagylajos@gmail.com', -1, '', '', -1),
('nagymarika@gmail.com', -1, '', '', -1),
('palpeter@gmail.com', -1, '', '', -1),
('papucspeter@gmail.com', -1, '', '', -1),
('peterpal@gmail.com', -1, '', '', -1),
('sirlancelot@gmail.com', -1, '', '', -1),
('tesztelek@tesztelek.com', -1, '', '', -1),
('tisztasag@gmail.com', -1, '', '', -1);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `images`
--

CREATE TABLE `images` (
  `imagePath` varchar(200) NOT NULL,
  `productID` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- A tábla adatainak kiíratása `images`
--

INSERT INTO `images` (`imagePath`, `productID`) VALUES
('pictures/ProductPage/airpods-3-1.jpg', 5),
('pictures/ProductPage/airpods-3-2.jpg', 5),
('pictures/ProductPage/airpods-3-3.jpg', 5),
('pictures/ProductPage/airpods-3-4.jpg', 5),
('pictures/ProductPage/airpods-pro-1.jpg', 9),
('pictures/ProductPage/airpods-pro-2.jpg', 9),
('pictures/ProductPage/airpods-pro-3.jpg', 9),
('pictures/ProductPage/airpods-pro-4.jpg', 9),
('pictures/ProductPage/Apple-iPhone-15-Pro-Max-Black-Titanium-frontimage.png', 1),
('pictures/ProductPage/Apple-Logo.jpeg', 1),
('pictures/ProductPage/ipad-air-5-1.jpg', 7),
('pictures/ProductPage/ipad-air-5-2.jpg', 7),
('pictures/ProductPage/ipad-air-5-3.jpg', 7),
('pictures/ProductPage/ipad-air-5-4.jpg', 7),
('pictures/ProductPage/ipad-mini-6-1.jpg', 11),
('pictures/ProductPage/ipad-mini-6-2.png', 11),
('pictures/ProductPage/ipad-mini-6-3.jpg', 11),
('pictures/ProductPage/ipad-mini-6-4.jpg', 11),
('pictures/ProductPage/ipad-pro-1.jpg', 3),
('pictures/ProductPage/ipad-pro-2.jpg', 3),
('pictures/ProductPage/ipad-pro-3.jpg', 3),
('pictures/ProductPage/ipad-pro-4.jpg', 3),
('pictures/ProductPage/iphone-13-mini-1.jpg', 10),
('pictures/ProductPage/iphone-13-mini-2.jpg', 10),
('pictures/ProductPage/iphone-13-mini-3.png', 10),
('pictures/ProductPage/iphone-13-mini-4.jpg', 10),
('pictures/ProductPage/iphone-14-1.jpg', 6),
('pictures/ProductPage/iphone-14-2.png', 6),
('pictures/ProductPage/iphone-14-3.jpg', 6),
('pictures/ProductPage/iphone-14-4.jpg', 6),
('pictures/ProductPage/iphone-15-pro-finish-select-202309-6-1inch-naturaltitanium_AV2.jpeg', 1),
('pictures/ProductPage/iphone-15-pro-finish-select-202309-6-1inch-naturaltitanium_AV3.jpeg', 1),
('pictures/ProductPage/watch-se-1.png', 8),
('pictures/ProductPage/watch-se-2.png', 8),
('pictures/ProductPage/watch-se-3.png', 8),
('pictures/ProductPage/watch-se-4.jpg', 8),
('pictures/ProductPage/watch-se-4.png', 8),
('pictures/ProductPage/watch-series-7-1.jpeg', 4),
('pictures/ProductPage/watch-series-7-2.jpeg', 4),
('pictures/ProductPage/watch-series-7-3.jpg', 4),
('pictures/ProductPage/watch-series-7-4.jpg', 4);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `itemsincart`
--

CREATE TABLE `itemsincart` (
  `cartID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `ordereditems`
--

CREATE TABLE `ordereditems` (
  `orderID` int(11) NOT NULL,
  `productID` int(11) NOT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `orders`
--

CREATE TABLE `orders` (
  `orderID` int(11) NOT NULL,
  `email` varchar(100) DEFAULT NULL,
  `price` int(12) NOT NULL,
  `orderDate` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `product`
--

CREATE TABLE `product` (
  `productID` int(11) NOT NULL,
  `productType` varchar(30) NOT NULL,
  `price` int(12) NOT NULL,
  `name` varchar(100) NOT NULL,
  `description` varchar(250) DEFAULT NULL,
  `quantity` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `product`
--

INSERT INTO `product` (`productID`, `productType`, `price`, `name`, `description`, `quantity`) VALUES
(1, 'phone', 550000, 'Apple iPhone 15', 'The latest Apple iPhone with advanced features.', 13),
(3, 'tablet', 400000, 'Apple iPad Pro', 'Powerful tablet for work and entertainment.', 9),
(4, 'watch', 280000, 'Apple Watch Series 7', 'Stay connected and track your fitness.', 30),
(5, 'airpod', 130000, 'Apple AirPods 3', 'Wireless earbuds for a seamless audio experience.', 40),
(6, 'phone', 300000, 'Apple iPhone 14', 'A high-quality smartphone with the latest features.', 25),
(7, 'tablet', 250000, 'Apple iPad Air 5', 'Perfect for work, study, and entertainment.', 12),
(8, 'watch', 270000, 'Apple Watch SE', 'Affordable smartwatch with great features.', 18),
(9, 'airpod', 135000, 'Apple AirPods Pro', 'Active noise-cancelling earbuds for an immersive sound.', 35),
(10, 'phone', 220000, 'Apple iPhone 13 Mini', 'Compact and powerful smartphone.', 15),
(11, 'tablet', 180000, 'Apple iPad Mini 6', 'Portable and versatile tablet for on-the-go.', 10);

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `user`
--

CREATE TABLE `user` (
  `email` varchar(100) NOT NULL,
  `password` varchar(200) NOT NULL,
  `firstname` varchar(30) NOT NULL,
  `lastname` varchar(30) NOT NULL,
  `registrationDate` date NOT NULL,
  `role` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_hungarian_ci;

--
-- A tábla adatainak kiíratása `user`
--

INSERT INTO `user` (`email`, `password`, `firstname`, `lastname`, `registrationDate`, `role`) VALUES
('admin@teszt.com', '$2a$10$RNdFkyRtzQ3tDhLmsgjU7.vFoBYOiYiMXLMkagpQqgf.sUo4F0oK2', 'Admin', 'Teszt', '2023-11-03', 'admin'),
('bivalyulrich@gmail.com', '$2a$10$dkOUTSS4veD4R.7nAzemjOWQAKAa/wKfI.J3DXuU5MW.Xy0Th/Blu', 'Ulrich', 'Bivaly', '2023-11-11', 'user'),
('kisspista@gmail.com', '$2a$10$kW3c0imV3f8f7Eb4kQGFGONqlBDEdf1E/7GGloIdo5BUTkpJ9xz.y', 'pista', 'kiss', '2023-11-06', 'user'),
('kovacsbertalan@gmail.com', '$2a$10$U4M.K0XeHMRUcCdLdNo5qu8Dqwcysy7GE9dBcqXuh7KtAxLNOvA.i', 'Bertalan', 'Kovács', '2023-11-10', 'user'),
('kowalskyvega@gmail.com', '$2a$10$LGYVWrfT8v.SpdEO45KvHuInAY5GnhK9am9zWmJft/V0KLGaMFb1S', 'vega', 'kowalsky', '2023-11-11', 'user'),
('lakatosemanuel@gmail.com', '$2a$10$JxwOuTKX4goMICOAU/GCU.gJ0nIgbh9JFWGiA7UUw9wAvx6/97S16', 'emanuel', 'lakatos', '2023-11-11', 'user'),
('nagyimre@gmail.com', '$2a$10$USmYkhCtW26a5bIk.4BOoeWCzNJz9kbBGt.eg7lTgpqfUQSEh7WPu', 'imre', 'nagy', '2023-11-06', 'user'),
('nagylajos@gmail.com', '$2a$10$y3t7oRNwpFmBnK5CnqfixeCHTDwpIZ2Awjjye.Vre5UFJ0xfmEKGe', 'Lajos', 'Nagy ', '2023-11-11', 'user'),
('nagymarika@gmail.com', '$2a$10$t0Ucr.TjgjEh989OpTPyNeDoHc/y3xCquxvMn49jvtWbbF5dnBIiC', 'marika', 'nagy', '2023-11-06', 'user'),
('palpeter@gmail.com', '$2a$10$Kf8VSAuGNRpWDlaZurnHu.RSepkd8tOr9xV82uxyaSIzxR/XdxrZ6', 'peter', 'pal', '2023-11-11', 'user'),
('papucspeter@gmail.com', '$2a$10$CJZUxy3owllvZay0q.jk7eAXM.4DFgk1OZpRBSMHcAllzMU18B7hS', 'péter', 'papucs', '2023-11-11', 'user'),
('peterpal@gmail.com', '$2a$10$/IDPj51zKI8tEwj5l7sUqOciAbgI0y.efX7ZLWwJr6zlJbmTHcoc2', 'pál', 'peter', '2023-11-11', 'user'),
('sirlancelot@gmail.com', '$2a$10$ACxD9kfrBdhj0qYAKR1Yie1457.9aswcqGs9ymJocdW2fU5Cs2Gx6', 'lancelot', 'sir', '2023-11-11', 'user'),
('tesztelek@tesztelek.com', '$2a$10$zyv2yJ7T/PpiBff/hUa2Ruvc1eoOYhWlIhepY2x17P8ne7lK2Cuvy', 'Teszt', 'Elek', '2023-11-05', 'user'),
('tisztasag@gmail.com', '$2a$10$UJOyNaNlLNSMvAJN94KWEey/K3CBIuGabkd9mODK2KFuKnuIpzraK', 'ság', 'tiszta', '2023-11-11', 'user');

--
-- Indexek a kiírt táblákhoz
--

--
-- A tábla indexei `billingdetails`
--
ALTER TABLE `billingdetails`
  ADD PRIMARY KEY (`email`);

--
-- A tábla indexei `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`cartID`),
  ADD KEY `email` (`email`);

--
-- A tábla indexei `comment`
--
ALTER TABLE `comment`
  ADD PRIMARY KEY (`commentID`),
  ADD KEY `email` (`email`),
  ADD KEY `productID` (`productID`);

--
-- A tábla indexei `deliverydetails`
--
ALTER TABLE `deliverydetails`
  ADD PRIMARY KEY (`email`);

--
-- A tábla indexei `images`
--
ALTER TABLE `images`
  ADD PRIMARY KEY (`imagePath`,`productID`),
  ADD KEY `productID` (`productID`);

--
-- A tábla indexei `itemsincart`
--
ALTER TABLE `itemsincart`
  ADD PRIMARY KEY (`cartID`,`productID`),
  ADD KEY `productID` (`productID`);

--
-- A tábla indexei `ordereditems`
--
ALTER TABLE `ordereditems`
  ADD PRIMARY KEY (`orderID`,`productID`),
  ADD KEY `productID` (`productID`);

--
-- A tábla indexei `orders`
--
ALTER TABLE `orders`
  ADD PRIMARY KEY (`orderID`),
  ADD KEY `email` (`email`);

--
-- A tábla indexei `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`productID`);

--
-- A tábla indexei `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`email`);

--
-- A kiírt táblák AUTO_INCREMENT értéke
--

--
-- AUTO_INCREMENT a táblához `cart`
--
ALTER TABLE `cart`
  MODIFY `cartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

--
-- AUTO_INCREMENT a táblához `comment`
--
ALTER TABLE `comment`
  MODIFY `commentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT a táblához `product`
--
ALTER TABLE `product`
  MODIFY `productID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- Megkötések a kiírt táblákhoz
--

--
-- Megkötések a táblához `billingdetails`
--
ALTER TABLE `billingdetails`
  ADD CONSTRAINT `billingdetails_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `cart`
--
ALTER TABLE `cart`
  ADD CONSTRAINT `cart_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `comment`
--
ALTER TABLE `comment`
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE SET NULL ON UPDATE CASCADE,
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `deliverydetails`
--
ALTER TABLE `deliverydetails`
  ADD CONSTRAINT `deliverydetails_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `itemsincart`
--
ALTER TABLE `itemsincart`
  ADD CONSTRAINT `itemsincart_ibfk_1` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `itemsincart_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `ordereditems`
--
ALTER TABLE `ordereditems`
  ADD CONSTRAINT `ordereditems_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ordereditems_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`) ON DELETE NO ACTION ON UPDATE CASCADE;

--
-- Megkötések a táblához `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE SET NULL ON UPDATE CASCADE;
COMMIT;

set global max_connections = 999999999;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
