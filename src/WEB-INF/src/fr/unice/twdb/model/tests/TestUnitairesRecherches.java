package fr.unice.twdb.model.tests;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import org.junit.Before;
import org.junit.Test;



public class TestUnitairesRecherches {

	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:8080/TWDB");
	}

	@Test
	public void testChargementPageIndex() {
		setScriptingEnabled(false);
		beginAt("/");
		assertTitleEquals("TWDB");
	}
	
	@Test
	public void testChargementListePaysHtml() {
		/* deactivate javascript because of google map's voodoo */
		setScriptingEnabled(false);  
		beginAt("/country.html");
		assertTitleEquals("The World DataBase"); // has the page loaded ?
		assertTextPresent("Seychelles");  // checks the last country name to display
	}
	
	@Test
	public void testChargementListePaysXml() {
		setScriptingEnabled(false);
		beginAt("/country.xml");
		assertTitleEquals("");
		assertTextPresent("Seychelles");  // checks the last country name to display
	}
	
	@Test
	public void testRechercheDepuisPageAccueilFullName() {
		setScriptingEnabled(false);
		beginAt("/index.html");
		setTextField("valeur", "Papeete"); // looking for Papeete in French Polynesia
		clickButtonWithText("Find");
		assertTextPresent("Papeete"); // Papeete should appear in the result content
	}
	
	@Test
	public void testRechercheDepuisPageAccueilPartialName() {
		setScriptingEnabled(false);
		beginAt("/index.html");
		setTextField("valeur", "pap"); // looking for Papeete in French Polynesia
		clickButtonWithText("Find");
		assertTextPresent("Papeete"); // Papeete should appear in the result content
		assertTextPresent("Papua New Guinea"); // along with other results
		assertTextPresent("Balikpapan");
		assertTextPresent("Indonesia");
		assertTextPresent("French Polynesia");
	}
	
	@Test
	public void testRechercheDepuisPageAccueil() {
		setScriptingEnabled(false);
		beginAt("/index.html");
		setTextField("valeur", "pap"); // looking for Papeete in French Polynesia
		clickButtonWithText("Find");
		assertTextPresent("Papeete"); // Papeete should appear in the result content
	}
	
	@Test
	public void testRechercheDepuisPageAccueilUrl() {
		setScriptingEnabled(false);
		beginAt("/search?xml=false&valeur=france"); // querying via url directly with html output
		assertTextPresent("France"); // France should appear in the result content
	}
	
	@Test
	public void testRechercheDepuisPageAccueilUrlXml() {
		setScriptingEnabled(false);
		beginAt("/search?xml=true&valeur=france"); // querying via url directly with xml output
		assertTextPresent("France"); // France should appear in the result content
	}
	
	@Test
	public void testRechercheDepuisPageAccueilUrlNoResult() {
		setScriptingEnabled(false);
		beginAt("/search?xml=false&valeur=cybertron");
		assertTextPresent("Votre recherche n'a retourné aucun résultat.");
	}
	
	/* country related searches */
	@Test
	public void testRecherchePaysApprofondieUrl() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Pays&type=0&xml=false&valeur=France");
		assertTextPresent("France"); // url should redirect us directly to the France page
	}
	
	@Test
	public void testRecherchePaysApprofondieUrlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Pays&type=0&xml=false&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
	
	@Test
	public void testRecherchePaysApprofondieUrlXml() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Pays&type=0&xml=false&valeur=France");
		assertTextPresent("France"); // url should redirect us directly to the France page
	}
	
	@Test
	public void testRecherchePaysApprofondieUrlXmlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Pays&type=0&xml=true&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
	
	/* province related searches */
	@Test
	public void testRechercheProvinceApprofondieUrl() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Province&type=0&xml=false&valeur=Hokkaido");
		assertTextPresent("Hokkaido"); // url should redirect us directly to the France page
	}
	
	@Test
	public void testRechercheProvinceApprofondieUrlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Province&type=0&xml=false&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
	
	@Test
	public void testRechercheProvinceApprofondieUrlXml() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Province&type=0&xml=false&valeur=Hokkaido");
		assertTextPresent("Hokkaido"); // url should redirect us directly to the France page
	}
	
	@Test
	public void testRechercheProvinceApprofondieUrlXmlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Province&type=0&xml=false&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
	
	/* city related searches */
	@Test
	public void testRechercheCityApprofondieUrl() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Ville&type=0&xml=false&valeur=Papeete");
		assertTextPresent("Papeete"); // url should redirect us directly to the Papeete page
	}
	
	@Test
	public void testRechercheCityApprofondieUrlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Ville&type=0&xml=false&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
	
	@Test
	public void testRechercheCityApprofondieUrlXml() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Ville&type=0&xml=false&valeur=Papeete");
		assertTextPresent("Papeete"); // url should redirect us directly to the Papeet page
	}
	
	@Test
	public void testRechercheCityApprofondieUrlXmlNoResult() {
		setScriptingEnabled(false);
		beginAt("/rechercheparam?typezone=Ville&type=0&xml=false&valeur=Lalaland");
		assertTextPresent("Aucun résultat :("); // url should redirect us directly to the noresult page
	}
}
