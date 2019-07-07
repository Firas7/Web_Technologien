-- phpMyAdmin SQL Dump
-- version 4.8.5
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 30. Apr 2019 um 14:20
-- Server-Version: 10.1.38-MariaDB
-- PHP-Version: 7.1.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `bar_webservice`
--

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `bar`
--

CREATE TABLE `bar` (
  `bar_id` int(100) NOT NULL,
  `name` varchar(100) CHARACTER SET utf8 NOT NULL,
  `strasse` varchar(100) CHARACTER SET utf8 NOT NULL,
  `plz` int(100) NOT NULL,
  `ort` varchar(100) CHARACTER SET utf8 NOT NULL,
  `telefon` int(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Daten für Tabelle `bar`
--

INSERT INTO `bar` (`bar_id`, `name`, `strasse`, `plz`, `ort`, `telefon`) VALUES
(1, 'Kuriosum', 'Schneiderberg 14', 30167, 'Hannover', 511701896),
(2, 'Cafeteria hanOmacke e.V.', 'Königsworther Platz 1', 30167, 'Hannover', 511123456),
(3, 'Bronco\'s Bar', 'Schwarzer Bär 7', 30449, 'Hannover', 45002707),
(4, 'Onkel Ollis', 'An der Lutherkirche 10', 30167, 'Hannover', 21808175),
(5, 'Centrum', 'Lindener Marktplatz 3', 30449, 'Hannover', 37360451),
(6, 'Leibniz Lounge', 'Wilhelm-Busch-Straße 2', 30167, 'Hannover', 1698191),
(7, 'Lindwurm', 'Nedderfeldstraße 22', 30451, 'Hannover', 123456),
(8, 'Heaven Cocktailbar', 'Weißekreuzstraße 25', 30161, 'Hannover', 3888819),
(9, 'The Harp', 'Schwarzer Bär 1', 30449, 'Hannover', 53380542),
(10, 'The Wild Geese', 'Asternstraße 15', 30167, 'Hannover', 80097700),
(11, 'Schöne Aussichten 360 Grad', 'Röselerstraße 7', 30159, 'Hannover', 9826833),
(12, 'Jack the Ripper\'s London Tavern', 'Georgstraße 26', 30159, 'Hannover', 1695395),
(13, 'Roof Garden', 'Mehlstraße 2', 30159, 'Hannover', 897007),
(14, 'Quarks Bar', 'Seydlitzstraße 34', 30161, 'Hannover', 60010055),
(15, 'Sausalitos', 'Osterstraße 38', 30159, 'Hannover', 3530919),
(16, 'Besitos', 'Goseriede 4', 30159, 'Hannover', 1698001),
(17, 'Caspers', 'Knochenhauerstraße 30', 30159, 'Hannover', 1321782),
(18, 'Timber Bar Lounge', 'Lavesplatz 1', 30159, 'Hannover', 22859310),
(19, 'Rumpelkammer', 'Jakobistraße 2', 30163, 'Hannover', 628128),
(20, 'Duman Live', 'Raschplatz 6', 30161, 'Hannover', 89768610);

--
-- Indizes der exportierten Tabellen
--

--
-- Indizes für die Tabelle `bar`
--
ALTER TABLE `bar`
  ADD PRIMARY KEY (`bar_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
