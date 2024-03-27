# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : BLUMET Thomas ABOUFATH Ibtissam

## Exercices 1
Il s'agit du pattern "composite", où `MobileObject` joue le rôle de classe composant et `Vehicle` le rôle de classe composite.
Pour la nouvelle classe il n'y a aps besoin de réécrire les 2 méthodes (l'héritage de `Vehicle` suffit), car les 2 méthodes utilisent 
soit un itérateur sur les composants, soit un flux de composants.

## Exercices 2
Il s'agit du patron Iterateur qui est utilisé dans **getVelocity()**, qui permet d'itérer/de parcourir les composants d'un véhicule
sans se préoccuper du type de déclaration des composants, offrant donc ici une méthode générique de calcul de vitesse.
En passant de **Set** à **List**, il n'y a pas besoin de changer la réalisation de **getVelocity()**, étant donné que la seule différence 
est que **Set** n'accepte pas les doublons, contrairement à **List**, ce qui ne pose pas de problème ici (on peut être tenter d'ajouter plusieurs
composants identiques)

## Exercices 3

## Exercices 4

## Exercices 5

## Exercices 6

## Exercices 7

## Exercices 8


