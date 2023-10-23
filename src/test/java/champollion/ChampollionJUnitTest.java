package champollion;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class ChampollionJUnitTest {
	Enseignant untel;
	UE uml, java;
		
	@BeforeEach
	public void setUp() {
		untel = new Enseignant("untel", "untel@gmail.com");
		uml = new UE("UML");
		java = new UE("Programmation en java");		
	}
	

	@Test
	public void testNouvelEnseignantSansService() {
		assertEquals(0, untel.heuresPrevues(),
                        "Un nouvel enseignant doit avoir 0 heures prévues");
	}
	
	@Test
	public void testAjouteHeures() {
                // 10h TD pour UML
		untel.ajouteEnseignement(uml, 0, 10, 0);

		assertEquals(10, untel.heuresPrevuesPourUE(uml),
                        "L'enseignant doit maintenant avoir 10 heures prévues pour l'UE 'uml'");

                // 20h TD pour UML
                untel.ajouteEnseignement(uml, 0, 20, 0);
                
		assertEquals(10 + 20, untel.heuresPrevuesPourUE(uml),
                         "L'enseignant doit maintenant avoir 30 heures prévues pour l'UE 'uml'");		
		
	}

	@Test
	public void testEnSousService() {

		untel.ajouteEnseignement(uml, 12, 20, 20);
		untel.ajouteEnseignement(java, 8, 20, 30);
		assertTrue(untel.enSousService(),
				"L'enseignant est en sous service");
	}

	@Test
	public void testHeuresPrevues(){
		untel.ajouteEnseignement(uml, 0, 1, 0);
		untel.ajouteEnseignement(java, 0, 1, 0);
		assertEquals(2, untel.heuresPrevues(),"L'enseignant doit réaliser 4h" );
	}


	@Test
	public void testVerifierTypeIntervention(){
		ServicePrevu s = new ServicePrevu(10, 5, 20, uml, untel);
		assertTrue(s.getUe().equals(uml), "C'est la bonne UE");
	}


}
