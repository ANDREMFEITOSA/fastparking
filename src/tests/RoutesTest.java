package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sourceCode.RouteCalculation;

class RoutesTest {

	@Test
	void creatingHtmlFile() {
		RouteCalculation route = new RouteCalculation();
		route.calculatingRoute("-1.3688387,-48.4719525", "-1.4313741,-48.4647346");
	}

}
