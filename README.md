Projet Media Player

Description

Ce projet est divisé en deux répertoires principaux : cpp_pj pour le backend du projet et swing pour l'interface graphique.

Backend (cpp_pj)
Le répertoire cpp_pj contient l'ensemble du backend du projet. Voici une vue d'ensemble des classes présentes :

Photos: Représente un objet photo.
Vidéos: Représente un objet vidéo.
Films: Représente un objet film.
Pour exécuter le backend du projet, suivez ces étapes :

Placez-vous dans le répertoire cpp_pj.
Exécutez la commande make run.
Cela lancera le serveur qui permet de jouer une musique dont le nom ou le chemin est reçu de l'interface graphique.
Interface Graphique (swing)
Le répertoire swing est dédié à l'interface graphique de l'application.

Pour exécuter l'interface graphique, suivez ces étapes :

Placez-vous dans le répertoire swing.
Exécutez la commande make run.
L'interface graphique se connecte automatiquement au serveur backend.
Interface Graphique

L'interface graphique comporte trois boutons :

Play: Permet de jouer une musique ou afficher une photo présente dans la médiathèque. Entrez le nom du média dans le champ prévu et il s'affichera ou se jouera avec un message de confirmation affiché en bas.
Browse: Permet de jouer une musique ou afficher une photo présente dans le répertoire personnel de l'utilisateur. Cliquez sur ce bouton pour choisir un fichier à afficher ou à jouer.
Exit: Permet de quitter l'application.
Exécution

-Backend :

cd cpp_pj
make run


-Interface Graphique :

cd swing
make run