-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 08 mars 2022 à 00:09
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.4.14

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `guidinipi`
--

-- --------------------------------------------------------

--
-- Structure de la table `complexemedicale`
--

CREATE TABLE `complexemedicale` (
  `id` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `location` varchar(128) DEFAULT NULL,
  `speciality` varchar(64) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `doctor`
--

CREATE TABLE `doctor` (
  `id` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `location` varchar(128) DEFAULT NULL,
  `speciality` varchar(64) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `score` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `doctor`
--

INSERT INTO `doctor` (`id`, `name`, `location`, `speciality`, `phone`, `score`) VALUES
(2, 'Baha Eddine', 'Tunisss', 'Cardio', '27448517', 5),
(3, 'Amira', 'Ghazela', 'Generaliste', '933', NULL),
(6, 'Adem', 'Arianna', 'Dentiste', '2777', NULL),
(7, 'Amira', 'Tunis', 'Cardio', '+21627448517', NULL);

-- --------------------------------------------------------

--
-- Structure de la table `hospital`
--

CREATE TABLE `hospital` (
  `id` int(11) NOT NULL,
  `name` varchar(64) NOT NULL,
  `location` varchar(128) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `hospital`
--

INSERT INTO `hospital` (`id`, `name`, `location`, `score`, `phone`, `email`) VALUES
(1, 'Hopital', 'Tunis', 3, '93333333', 'hopital@gmail.com'),
(2, 'Baha Toumi', 'Arianna', 5, '+216', 'Baha@gmail.com'),
(3, 'Baha Toumi', 'Arianna', 5, '+21627448517', 'Baha@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `pharmacy`
--

CREATE TABLE `pharmacy` (
  `id` int(11) NOT NULL,
  `name` varchar(64) DEFAULT NULL,
  `location` varchar(128) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `hourly` enum('night','day') DEFAULT NULL,
  `phone` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `pharmacy`
--

INSERT INTO `pharmacy` (`id`, `name`, `location`, `score`, `hourly`, `phone`, `email`) VALUES
(3, 'Pharmacy Amira', 'tunis ariana 2005', 9, 'day', '+21623110748', 'pharamcy@gmail.com'),
(4, 'Pharmacy Amira', 'tunis ariana 2005', 9, 'day', '+21623110748', 'pharamcy@gmail.com'),
(5, 'Pharmacy Amira', 'tunis ariana 2005', 9, 'day', '+21623110748', 'pharamcy@gmail.com'),
(6, 'Pharmacy Amira', 'tunis ariana 2005', 9, 'day', '+21623110748', 'pharamcy@gmail.com'),
(8, 'Pharmacy Amira', 'tunis ariana 2005', 9, 'night', '+21623110748', 'pharamcy@gmail.com'),
(10, 'Baha Pharmacy', 'Arianna', 5, 'night', '27448517', 'Pharmacy@gmail.com'),
(11, 'Pharmacy Baha', 'Tunis', 3, 'night', '+21627448517', 'Pharmacy@gmail.com');

-- --------------------------------------------------------

--
-- Structure de la table `reclamation`
--

CREATE TABLE `reclamation` (
  `id_r` int(11) NOT NULL,
  `message` varchar(30) NOT NULL,
  `ID_USER` int(30) NOT NULL,
  `type_r` varchar(30) NOT NULL,
  `Titre` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `reclamation`
--

INSERT INTO `reclamation` (`id_r`, `message`, `ID_USER`, `type_r`, `Titre`) VALUES
(5, 'test', 6, 'Code', 'test');

-- --------------------------------------------------------

--
-- Structure de la table `sanitaire`
--

CREATE TABLE `sanitaire` (
  `id_s` int(11) NOT NULL,
  `tel` int(11) NOT NULL,
  `email` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `adresse` varchar(30) NOT NULL,
  `email` varchar(30) NOT NULL,
  `motpass` varchar(90) NOT NULL,
  `role` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `utilisateur`
--

INSERT INTO `utilisateur` (`id`, `nom`, `prenom`, `adresse`, `email`, `motpass`, `role`) VALUES
(6, 'Yosr', 'Abidi', 'Arianna', 'Yosser.abidi@esprit.tn', 'AZESDZRSSFFE/6465484321AZEqsd1564za65qsazeqsd54zSAZETFGVVyosr123', 'User');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `complexemedicale`
--
ALTER TABLE `complexemedicale`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `doctor`
--
ALTER TABLE `doctor`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `hospital`
--
ALTER TABLE `hospital`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `pharmacy`
--
ALTER TABLE `pharmacy`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD PRIMARY KEY (`id_r`),
  ADD KEY `ID_USER` (`ID_USER`);

--
-- Index pour la table `sanitaire`
--
ALTER TABLE `sanitaire`
  ADD PRIMARY KEY (`id_s`);

--
-- Index pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `complexemedicale`
--
ALTER TABLE `complexemedicale`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `doctor`
--
ALTER TABLE `doctor`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT pour la table `hospital`
--
ALTER TABLE `hospital`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `pharmacy`
--
ALTER TABLE `pharmacy`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT pour la table `reclamation`
--
ALTER TABLE `reclamation`
  MODIFY `id_r` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT pour la table `sanitaire`
--
ALTER TABLE `sanitaire`
  MODIFY `id_s` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `utilisateur`
--
ALTER TABLE `utilisateur`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `reclamation`
--
ALTER TABLE `reclamation`
  ADD CONSTRAINT `ID_USER` FOREIGN KEY (`ID_USER`) REFERENCES `utilisateur` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
