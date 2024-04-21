# Compte Rendu du TP 1 : Patrons de Conceptions

Noms des étudiants du binôme : BLUMET Thomas ABOUFATH Ibtissam

## Exercice 1
Il s'agit du pattern "composite", où `MobileObject` joue le rôle de classe composant et `Vehicle` le rôle de classe composite.
Pour la nouvelle classe il n'y a pas besoin de réécrire les 2 méthodes (l'héritage de `Vehicle` suffit), car les 2 méthodes utilisent 
soit un itérateur sur les composants, soit un flux de composants.

## Exercice 2
Il s'agit du patron Iterateur qui est utilisé dans **getVelocity()**, qui permet d'itérer/de parcourir les composants d'un véhicule
sans se préoccuper du type de déclaration des composants, offrant donc ici une méthode générique de calcul de vitesse.
En passant de **Set** à **List**, il n'y a pas besoin de changer la réalisation de **getVelocity()**, étant donné que la seule différence 
est que **Set** n'accepte pas les doublons, contrairement à **List**, ce qui ne pose pas de problème ici (on peut être tenter d'ajouter plusieurs
composants identiques)

## Exercice 3
Dans la classe `Clock`, il est déclaré un attribut static nommé **instance** et de type Clock. L'attribut static (=attribut de classe)
existera dès que la classe sera chargée en mémoire, donc ne nécessitera pas d'être instancié, et cela assurera que peu importe
le nombre de fois où la classe serait instanciée, cet attribut sera unique.
La classe possède aussi un constructeur privé et une méthode de fabrique static permettant de récupéré l'instance de la classe.
Enfin dans la classe `Wheel` il est déclaré une instance de Clock via **getInstance()** , avec le mot clé final,
signifiant que la modification de la référence à cet objet est impossible.

## Exercice 4
1. Les classes de Bike et de Wheel font partie de différents packages. La classe de Bike est incluse dans le package fr.polytech.sim.cycling,
tandis que la classe de Wheel est incluse dans le package fr.polytech.sim.transport.  
Il existe une association bidirectionnelle entre les classes de Bike et de Wheel.
La classe Bike fait référence à Wheel, et chaque Wheel fait référence à la Bike à laquelle il appartient.
Il est nécessaire car le Wheel doit accéder à la méthode getPush() de la classe Bike afin de calculer sa vitesse.

L'association bidirectionnelle n'est pas généralement considèrer comme une bonne pratique dans la POO car elle crée une étroite connexion entre
les classes et peut entraîner des problèmes de maintenance et de flexibilité (non respect du principe de dépendance acyclique entre
packages). Il y a également une dépendance circulaire qui peut engendrer des problèmes dans certaines situations.

2. La classe Wheel utilises la methode getPush() de la classe Bike pour calculer sa vitesse.
Il n'y a pas d'abstraction de la classe Bike, car la classe Wheel utilise directement la classe Bike pour calculer sa vitesse.

3. Pour résoudre le problème de dépendance circulaire entre les classes Bike et Wheel, il est possible de créer une interface de `Bike`
qui encapsule la méthode getPush().
La classe Bike peut implémenter cette interface, et la classe Wheel peut alors dépendre de cette interface au lieu de la classe Bike directement.
Solution proposée :
![img.png](images/img.png)

Dans cette solution, l'interface IBike est introduite afin d'encapsular la méthode getPush().
Cette interface est utilisée par la classe Bike, tandis que la classe Wheel dépend désormais de l'interface IBike (via son attribut **drive**
qui est désormais de type IBike) plutôt que de la classe Bike directement.
Cela rompt la dépendance circulaire entre les catégories de Bike et de Wheel.


## Exercice 5
La solution a été de déplacer la méthode **log()** (qui sera notre TemplateMethod) dans la classe `NamedLogger` regroupant le code commun
à la construction du message affiché dans le fichier de log, cette méthode faisant elle appel à une méthode abstraite **showMessage(String message)** 
qui sera implémenté dans `FileLogger` et `ConsoleLogger` selon la méthode d'affichage ou d'écriture de message.

## Exercice 6
On identifie respectivement :
- l'interface `Logger` comme étant la classe de ProduitAbstrait;
- la fabrique abstraite `LoggerCreator` générant à l'aide de la méthode static **createLogger(String name)** une instance de Logger,
cad pouvant être un `FileLogger` ou un `ConsoleLogger`(qui sont les classes de ProduitConcret que l'on défini "à la main"), instance qui est ensuite réutilisée dans la méthode 
**useLog(String name,String format, Object... args)** afin d'appeler la méthode **log()** propre au type de Logger instancié;

Les différences entre le patron Singleton et la méthode Fabrique: 

| Différences |  Singleton                                                                 | Fabrique                                                   |
|-------------|----------------------------------------------------------------------------|------------------------------------------------------------|
| Objectif    | assure la création et l'utilisation d'une seule et même instance de classe | création d'objet en ne connaissant pas à l'avance leur type|
| Instance    | une seule et même instance de classe                                       | création de plusieurs instances selon le type voulu        |    

## Exercice 7
Dans la classe de ce décorateur on trouve :
- un constructeur prenant en argument un objet de type Logger
- la méthode **log()** de Logger où est défini un DateFormat permettant d'obtenir l'heure actuelle (time) est qui est ajouté
à l'appel de la méthode log() par l'instance passé en argument du constructeur du décorateur de la façon suivante: logger.log("At "+time+" |"+format, args);

## Exercice 8
1. La classe Context suit le patron de conception Facade par rapport à l'outil ServiceLoader, car elle fournit une interface simple pour les classes de haut niveau pour interagir avec les classes de bas niveau.
   Dans ce cas, la classe Context simplifie l'utilisation de ServiceLoader.

2. Pour injecter un objet de type Bike dans la simulation, on peut utiliser la classe Context comme ceci : **Bike bike = Context.inject(Bike.class);**

3. Oui, on peut utiliser plusieurs lignes dans le fichier **fr.polytech.sim.cycling.Bik**.
   Chaque ligne de ce fichier Correspond à une implementation differente de l'interface Bike qu'on souhaite rendre disponible pour l'injection.

## Exercice 9
1. La methode injectAll() renvoie un Iterator, ce qui indique l'utilisation du patron Iterator.
   Le patron Iterator permet de parcourir les éléments d'une collection sans exposer la structure interne de la collection.