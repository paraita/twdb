package fr.unice.twdb.model.tests;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;
import org.junit.Before;
import org.junit.Test;


/**
 * This test case tests the display of country, provinces and cities.
 * @author bastien
 *
 */
public class TestsRequestsById {

	@Before
	public void setUp() throws Exception {
		setBaseUrl("http://localhost:8080/TWDB");
	}
	
	@Test
	public void testCountryRequestXML() {
		beginAt("/country/F.xml");
		assertTitleEquals("");
		assertTextPresent("France");
	}
	
	@Test
	public void testCountryRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/country/F.html");
		assertTitleEquals("The World DataBase");
		assertTextPresent("France");
	}
	
	@Test
	public void testNoCountryRequestXML() {
		beginAt("/country/Toto.xml");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
	@Test
	public void testNoCountryRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/country/Toto.html");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
	@Test
	public void testProvinceRequestXML() {
		beginAt("/province/prov-cid-cia-France-104.xml");
		assertTitleEquals("");
		assertTextPresent("France");
		assertTextPresent("Provence Cote dAzur");
	}
	
	@Test
	public void testProvinceRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/province/prov-cid-cia-France-104.html");
		assertTitleEquals("The World DataBase");
		assertTextPresent("France");
		assertTextPresent("Provence Cote dAzur");
	}
	
	@Test
	public void testNoProvinceRequestXML() {
		beginAt("/province/Toto.xml");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
	@Test
	public void testNoProvinceRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/province/Toto.html");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
	@Test
	public void testCityRequestXML() {
		beginAt("/city/cty-France-Nice.xml");
		assertTitleEquals("");
		assertTextPresent("Nice");
	}
	
	@Test
	public void testCityRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/city/cty-France-Nice.html");
		assertTitleEquals("The World DataBase");
		assertTextPresent("Nice");
	}
	
	@Test
	public void testNoCityRequestXML() {
		beginAt("/city/Toto.xml");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
	@Test
	public void testNoCityRequestHtml() {
		setScriptingEnabled(false);
		beginAt("/city/Toto.html");
		assertTitleEquals("TWDB");
		assertTextPresent("Aucun résultat");
	}
	
}
