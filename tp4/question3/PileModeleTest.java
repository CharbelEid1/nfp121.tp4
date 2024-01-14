package question3;

import question3.tp3.*;
import question3.tp3.PilePleineException;
import question3.tp3.PileVideException;

/**
 * Classe-test PileModeleTest.
 * 
 * @author (votre nom)
 * @version (un numé?ro de version ou une date)
 * 
 *          Les classes-test sont documenté?es ici :
 *          http://junit.sourceforge.net/javadoc/junit/framework/TestCase.html
 *          et sont basé?es sur le document ©? 2002 Robert A. Ballance intitulé?
 *          «JUnit: Unit Testing Framework».
 * 
 *          Les objets Test (et TestSuite) sont associé?s aux classes à tester
 *          par la simple relation yyyTest (e.g. qu'un Test de la classe
 *          Name.java se nommera NameTest.java); les deux se retrouvent dans le
 *          même paquetage. Les "engagements" (anglais : "fixture") forment un
 *          ensemble de conditions qui sont vraies pour chaque mé?thode Test à
 *          exé?cuter. Il peut y avoir plus d'une mé?thode Test dans une classe
 *          Test; leur ensemble forme un objet TestSuite. BlueJ dé?couvrira
 *          automatiquement (par introspection) les mé?thodes Test de votre
 *          classe Test et gé?né?rera la TestSuite consé?quente. Chaque appel d'une
 *          mé?thode Test sera pré?cé?dé? d'un appel de setUp(), qui ré?alise les
 *          engagements, et suivi d'un appel à tearDown(), qui les dé?truit.
 */
public class PileModeleTest extends junit.framework.TestCase {
    // Dé?finissez ici les variables d'instance né?cessaires à vos engagements;
    // Vous pouvez é?galement les saisir automatiquement du pré?sentoir
    // à l'aide du menu contextuel "Pré?sentoir --> Engagements".
    // Notez cependant que ce dernier ne peut saisir les objets primitifs
    // du pré?sentoir (les objets sans constructeur, comme int, float, etc.).
    PileModele <Integer> p;
    /**
     * Constructeur de la classe-test PileModeleTest
     */
    public PileModeleTest() {
    }

    /**
     * Met en place les engagements.
     * 
     * Mé?thode appelé?e avant chaque appel de mé?thode de test.
     */
    protected void setUp() // throws java.lang.Exception
    {
        p = new PileModele<Integer>(new Pile2<Integer>(3));

    }

    /**
     * Supprime les engagements
     * 
     * Mé?thode appelé?e après chaque appel de mé?thode de test.
     */
    protected void tearDown() // throws java.lang.Exception
    {
        p = null;
    }

    /**
     * Il ne vous reste plus qu'à dé?finir une ou plusieurs mé?thodes de test. Ces
     * mé?thodes doivent vé?rifier les ré?sultats attendus à l'aide d'assertions
     * assertTrue(<boolean>). Par convention, leurs noms devraient dé?buter par
     * "test". Vous pouvez é?baucher le corps grâce au menu contextuel
     * "Enregistrer une mé?thode de test".
     */
    
    public void test_Pile_capacite() {
        assertEquals(3, p.capacite());
    }
    
    public void test_Pile_estPleine() throws Exception {
        p.empiler(3);
        assertEquals(1, p.taille());
        p.empiler(2);
        assertEquals(2, p.taille());
        p.empiler(1);
        assertEquals(3, p.taille());

        assertEquals(true, p.estPleine());
        assertEquals(p.taille(), p.capacite());
        try {
            p.empiler(0);
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PilePleineException);
        }
    }
    
    public void test_Pile_sommet() throws Exception {
        assertEquals(true, p.estVide());

        p.empiler(new Integer(3));
        assertEquals(" sommet ?? ", new Integer(3), p.sommet());
        assertEquals(1, p.taille());
        assertEquals(" depiler ?? ", new Integer(3), p.depiler());
        assertEquals(0, p.taille());
    }
    
    public void test_Pile_estVide() throws Exception {
        assertEquals(true, p.estVide());
        try {
            Object r = p.depiler();
            fail();
        } catch (Exception e) {
            assertTrue(e instanceof question3.tp3.PileVideException);
        }
    }

}
