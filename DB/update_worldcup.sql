-- phpMyAdmin SQL Dump
-- version 5.0.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 15 mars 2021 à 21:55
-- Version du serveur :  10.4.17-MariaDB
-- Version de PHP : 7.3.27

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

--
-- Déchargement des données de la table `billet`
--

INSERT INTO `billet` (`spectateur_id`, `match_id`) VALUES
(17, 1);

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
(1, '2021-02-09 14:45:05', 'CA', 200, 'EST', 'Rades'),
(2, '2021-02-09 14:45:05', 'ESS', 200, 'CSS', 'Rades'),
(3, '2021-02-09 14:45:05', 'CA', 200, 'CAB', 'Rades');

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE `role` (
  `id` bigint(20) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `role`
--

INSERT INTO `role` (`id`, `description`, `name`) VALUES
(1, 'Administrateur', 'ADMIN'),
(2, 'Utilisateur', 'USER');

-- --------------------------------------------------------

--
-- Structure de la table `spectateur`
--

CREATE TABLE `spectateur` (
  `_date_naissance` date DEFAULT NULL,
  `id_user` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `spectateur`
--

INSERT INTO `spectateur` (`_date_naissance`, `id_user`) VALUES
('2021-03-16', 1),
(NULL, 10),
(NULL, 17);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `id_user` int(11) NOT NULL,
  `_nom` varchar(255) DEFAULT NULL,
  `_num_tel` int(11) NOT NULL,
  `_prenom` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`id_user`, `_nom`, `_num_tel`, `_prenom`, `password`, `username`) VALUES
(1, 'maroua', 5888856, 'ferjani', '$2a$10$gpxIgBJWCdYM9SM6sjwYrOKgoX0uti9gxu30q1iU/prDn/yNwgs36', 'marou'),
(2, 'balkis', 5888856, 'hamzaoui', '$2a$10$a1Dlo9kDtc.3zViTZkrsTO.18op0Mm1YqWK/EZXR28/VNhydvhJCa', 'balkousa'),
(6, 'hiba', 89999965, 'sayeh', '$2a$10$A4XgL5WSIlEOVF1nB5tRceIO2Oywrz04TFbzPtjBtA4rJG5/a7bZy', 'hiba'),
(9, 'balkis', 5888856, 'hamzaoui', '$2a$10$a1Dlo9kDtc.3zViTZkrsTO.18op0Mm1YqWK/EZXR28/VNhydvhJCa', 'balkousa'),
(10, 'balkis', 5888856, 'hamzaoui', '$2a$10$a1Dlo9kDtc.3zViTZkrsTO.18op0Mm1YqWK/EZXR28/VNhydvhJCa', 'balkousa'),
(14, 'sarra', 5888856, 'ferjani', '$2a$10$ddUKgXN3kL51HtjpnwBXxeMoo1NiVoRi9rcUjJ6xhafgVZqouh2iK', 'sarou'),
(17, 'sarra', 5888856, 'ferjani', 'saroumdp', 'sarou');

-- --------------------------------------------------------

--
-- Structure de la table `user_roles`
--

CREATE TABLE `user_roles` (
  `user_id` int(11) NOT NULL,
  `role_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Déchargement des données de la table `user_roles`
--

INSERT INTO `user_roles` (`user_id`, `role_id`) VALUES
(1, 1),
(2, 1),
(6, 1),
(9, 1),
(10, 1),
(14, 1),
(17, 1);

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
-- Index pour la table `role`
--
ALTER TABLE `role`
  ADD PRIMARY KEY (`id`);

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
-- Index pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD PRIMARY KEY (`user_id`,`role_id`),
  ADD KEY `FKrhfovtciq1l558cw6udg0h0d3` (`role_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `lematch`
--
ALTER TABLE `lematch`
  MODIFY `id_match` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT pour la table `role`
--
ALTER TABLE `role`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `id_user` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;

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

--
-- Contraintes pour la table `user_roles`
--
ALTER TABLE `user_roles`
  ADD CONSTRAINT `FK55itppkw3i07do3h7qoclqd4k` FOREIGN KEY (`user_id`) REFERENCES `user` (`id_user`),
  ADD CONSTRAINT `FKrhfovtciq1l558cw6udg0h0d3` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
