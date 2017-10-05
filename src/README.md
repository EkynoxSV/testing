# Object-Oriented Software Testing

Groupe Baptiste LARRE, Etienne FAGOT

Master 1 ICE, GLa - V&V - Labs ([course materials](https://combemale.github.io/teaching/m1ice/))

> Créez un projet Java, récupérez la classe MyPoint, et rajoutez la librairie JUnit à votre projet. 

## Test Unitaire pour Java avec JUnit

> Q.1a Tester les constructeurs 1 et 2 (dans une classe de test TestMyPoint). Pour cela, utiliser la Javadoc pour
comprendre le comportement attendu des constructeurs. Utilisez des assertions pour vérifier les valeurs, par exemple :

    ...
    assertEquals (0d, point . getX (), 0.0001);
    ...

> Q.1b Le test de ces constructeurs utilisent les opérations getX et getY. Ne trouvez-vous pas cela étrange qu’un test utilise d’autres opérations ? Que faire ?
> A.1b Sachant que les attributs de la classe MyPoint sont priv�s, il n'y as pas d'autre choix que d'utiliser d'autres op�rations. De ce fait il faut tester que les op�ration retourne bien les valeurs attendues. Possiblement, on peut choisir l'ordre d'ex�cution des tests afin de s'assurer que l'echec du test de cr�ation ne vienne pas d'une erreur d'une autre m�thode.

> Q.1c Testez les accesseurs en lecture et écriture (les opérations get et set). Tout d’abord, testez getX et setX ensemble (car elles sont liées, idem pour y). Ensuite créez d’autres tests pour tester les opérations set avec la valeur Double.NaN (cf. la javadoc de ces opérations).
>

> Q.1d Testez le constructeur 3 et l’opération scale. Plusieurs tests (i.e. plusieurs opérations) seront nécessaires pour le constructeur 3. Vous pouvez constater que la plupart des tests nécessitent la création d’un point au début des opérations de test.

> Q.1e Définissez et utilisez l’opération @Before setUp() et tout ce qui est également nécessaire pour déléguer cette création à l’opération setUp.

> Q.1f Testez l’opération horizontalSymmetry. Là encore, plusieurs tests (i.e. plusieurs opérations) seront nécessaires. Vous remarquerez que cette opération peut lever une exception. Utilisez le paramètre expected de l’annotation Test pour vérifier que cette exception est bien levée en temps voulu.

## Couverture de code

> Q.2a Utilisez l’outil de couverture de code fourni dans Eclipse (ou autre IDE) pour identifier les chemins dans le code non couvert par vos tests. Rajoutez quelques tests si besoins (n’y passez pas trop de temps).
> A.2a Actuellement nous somme � 54,7% de couverture. 

> Q.2b Est-ce que votre code est sûr lorsque toutes les instructions sont couvertes par au moins un test ?
> A.2b Non le code n'est pas forc�ment sur, par exemple la methode setY() n'est pas sur si l'ont ne test pas le cas du Double.NaN

> Q.2c Ajoutez le test unitaire suivant et exécutez-le. S’il passe, bien joué. Dans tout les cas cela peut certainement vous aidez à répondre à la question précédente.

    @Test public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
    }

## Test d'intégration pour Java avec EasyMock ou Mockito

Cet exercice est une brève introduction au principe du mock.

L’opération setPoint(Random r1, Random r2) définit les coordonnées d’un point de manière aléatoire (x avec r1, et y avec r2).

> Q.3a Expliquez en quoi il est impossible de tester en l’état cette opération.
> A.3a Cette fonction utilise deux objets Random que nous ne pouvons pas controler.
    >> On veut donc utiliser le principe du Mock pour tester cette opération.

> Q.3b Utilisez Easymock ou Mockito pour tester cette opération. 

Avec Mockito :
- N’oubliez pas @RunWith (MockitoJUnitRunner.class). Vous aurez besoin de 2 attributs Random annotée avec @Mock. Le but est de simuler l’opération nextInt(). 
- L’opération translate(ITranslation) déplace le point selon le vecteur de translation donné en paramètre. Cependant ITranslation est une interface, on ne peut donc pas l’instancier.

Avec Easymock : voir la refcard et les slides du cours.

> Q.3c Supposons que nous ne disposons pas d’une implémentation de ITranslation pour tester cette opération, utilisez Mockito ou Easymock et tester finalement cette opération.

## Evaluation 

1. clonez le repo github
2. créez un nouveau fichier Markdown ou modifiez README.md, dans lequel vous préciserez les noms du binome et répondrez aux questions posées dans le sujet
3. rajouter votre projet Java (/Scala) au repo
4. faite une pull request une fois terminé, qui servira à l'évaluation. 

==> A rendre avant ce soir :)
