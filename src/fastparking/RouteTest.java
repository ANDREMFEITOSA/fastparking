package fastparking;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RouteTest {

	@Test
	void creatingHtmlFile() {
		Route route = new Route();
		route.calculatingRoute("route.html", "-1.3688387,-48.4719525", "-1.4313741,-48.4647346");
	}

}
