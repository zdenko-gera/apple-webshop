-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Gép: 127.0.0.1
-- Létrehozás ideje: 2023. Nov 03. 18:47
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
('admin@teszt.com', -1, '', '', -1);

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
(3, 'admin@teszt.com');

-- --------------------------------------------------------

--
-- Tábla szerkezet ehhez a táblához `comment`
--

CREATE TABLE `comment` (
  `commentID` int(11) NOT NULL,
  `email` varchar(100) NOT NULL,
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
('admin@teszt.com', -1, '', '', -1);

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
  `email` varchar(100) NOT NULL,
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
(1, 'phone', 550000, 'Apple iPhone 15', 'The latest Apple iPhone with advanced features.', 20),
(3, 'tablet', 400000, 'Apple iPad Pro', 'Powerful tablet for work and entertainment.', 15),
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
('admin@teszt.com', '$2a$10$RNdFkyRtzQ3tDhLmsgjU7.vFoBYOiYiMXLMkagpQqgf.sUo4F0oK2', 'Admin', 'Teszt', '2023-11-03', 'admin');

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
  MODIFY `cartID` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT a táblához `comment`
--
ALTER TABLE `comment`
  MODIFY `commentID` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT a táblához `orders`
--
ALTER TABLE `orders`
  MODIFY `orderID` int(11) NOT NULL AUTO_INCREMENT;

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
  ADD CONSTRAINT `comment_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`),
  ADD CONSTRAINT `comment_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

--
-- Megkötések a táblához `deliverydetails`
--
ALTER TABLE `deliverydetails`
  ADD CONSTRAINT `deliverydetails_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Megkötések a táblához `images`
--
ALTER TABLE `images`
  ADD CONSTRAINT `images_ibfk_1` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

--
-- Megkötések a táblához `itemsincart`
--
ALTER TABLE `itemsincart`
  ADD CONSTRAINT `itemsincart_ibfk_1` FOREIGN KEY (`cartID`) REFERENCES `cart` (`cartID`),
  ADD CONSTRAINT `itemsincart_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

--
-- Megkötések a táblához `ordereditems`
--
ALTER TABLE `ordereditems`
  ADD CONSTRAINT `ordereditems_ibfk_1` FOREIGN KEY (`orderID`) REFERENCES `orders` (`orderID`),
  ADD CONSTRAINT `ordereditems_ibfk_2` FOREIGN KEY (`productID`) REFERENCES `product` (`productID`);

--
-- Megkötések a táblához `orders`
--
ALTER TABLE `orders`
  ADD CONSTRAINT `orders_ibfk_1` FOREIGN KEY (`email`) REFERENCES `user` (`email`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
