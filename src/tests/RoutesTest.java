package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sourceCode.Routes;

class RoutesTest {

	@Test
	void creatingHtmlFile() {
		Routes route = new Routes();
		route.calculatingRoute("-1.3688387,-48.4719525", "-1.4313741,-48.4647346");
	}

}
