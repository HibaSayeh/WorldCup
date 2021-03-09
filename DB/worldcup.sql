-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : mar. 09 mars 2021 à 12:32
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 8.0.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `worldcup`
--

-- --------------------------------------------------------

--
-- Structure de la table `billet`
--

CREATE TABLE `billet` (
  `spectateur_id` int(11) NOT NULL,
  `match_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Structure de la table `lematch`
--

CREATE TABLE `lematch` (
  `id_match` int(11) NOT NULL,
  `_date_match` datetime DEFAULT NULL,
  `_deuxieme_equipe` varchar(255) DEFAULT NULL,
  `_nb_spectateur` int(11) NOT NULL,
  `_premiere_equipe` varchar(255) DEFAULT NULL,
  `_stade` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `lematch`
--

INSERT INTO `lematch` (`id_match`, `_date_match`, `_deuxieme_equipe`, `_nb_spectateur`, `_premiere_equipe`, `_stade`) VALUES
(3, '2021-02-02 17:22:52', 'aaaabca', 2340000, 'aaaaaa', 'aaaabcaaaaa'),
(4, '2021-02-02 17:22:52', 'aaaabca', 2, 'aaaaaa', 'aaaabcaaaaa'),
(5, '2021-02-02 17:22:52', 'aaaabca', 2340000, 'aabcaaaa', 'aaaabcaaaaa');

-- --------------------------------------------------------

--
-- Structure de la table `spectateur`
--

CREATE TABLE `spectateur` (
  `_date_naissance` date DEFAULT NULL,
  `_email` varchar(255) DEFAULT NULL,
  `_motdepasse` varchar(255) DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `spectateur`
--

INSERT INTO `spectateur` (`_date_naissance`, `_email`, `_motdepasse`, `id_user`) VALUES
('2021-02-01', 'jjjjj', 'abc', 10),
('2021-02-01', 'aaa', 'bbbbb', 12);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `_nom` varchar(255) DEFAULT NULL,
  `_num_tel` int(11) NOT NULL,
  `_prenom` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `_nom`, `_num_tel`, `_prenom`) VALUES
(10, 'balkiss', 28707386, 'hamzaoui'),
(12, 'maroua', 202154871, 'ferjani');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `billet`
--
ALTER TABLE `billet`
  ADD PRIMARY KEY (`spectateur_id`,`match_id`),
  ADD KEY `FKhgfyw9g0yppxe7eh9wbf9hh49` (`match_id`);

--
-- Index pour la table `lematch`
--
ALTER TABLE `lematch`
  ADD PRIMARY KEY (`id_match`);

--
-- Index pour la table `spectateur`
--
ALTER TABLE `spectateur`
  ADD PRIMARY KEY (`id_user`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id_user`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `lematch`
--
ALTER TABLE `lematch`
  MODIFY `id_match` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `billet`
--
ALTER TABLE `billet`
  ADD CONSTRAINT `FK8gu42abman55ngddfhnyncvtf` FOREIGN KEY (`spectateur_id`) REFERENCES `spectateur` (`id_user`),
  ADD CONSTRAINT `FKhgfyw9g0yppxe7eh9wbf9hh49` FOREIGN KEY (`match_id`) REFERENCES `lematch` (`id_match`);

--
-- Contraintes pour la table `spectateur`
--
ALTER TABLE `spectateur`
  ADD CONSTRAINT `FKs46nhqunabw4kl7kukb582fus` FOREIGN KEY (`id_user`) REFERENCES `user` (`id_user`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
