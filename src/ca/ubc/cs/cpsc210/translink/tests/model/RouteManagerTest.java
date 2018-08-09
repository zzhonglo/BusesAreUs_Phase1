package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the RouteManager
 */
public class RouteManagerTest {

    @Before
    public void setup() {
        RouteManager.getInstance().clearRoutes();
    }

    @Test
    public void testBoring() {
        Route r43 = new Route("43");
        Route r = RouteManager.getInstance().getRouteWithNumber("43");
        assertEquals(r43, r);
    }

    @Test
    public void testGetRouteWithNumber() {
        Route r43 = new Route("43");
        Route r = RouteManager.getInstance().getRouteWithNumber("43");
        assertEquals("", r.getName());
        assertEquals(r43, r);
        Route r35 = new Route("35");
        assertEquals("", r.getName());
        Route r2 = RouteManager.getInstance().getRouteWithNumber("35");
        assertEquals(r35, r2);
        assertEquals(2, RouteManager.getInstance().getNumRoutes());
        RouteManager.getInstance().clearRoutes();
        assertEquals(0, RouteManager.getInstance().getNumRoutes());
    }

    @Test
    public void testGetRouteWithNumber2() {
        Route r43 = new Route("43");
        r43.setName("route 43");
        Route r = RouteManager.getInstance().getRouteWithNumber("43", "route 43");
        assertEquals(r43, r);
        Route r35 = new Route("35");
        r35.setName("route 35");
        Route r2 = RouteManager.getInstance().getRouteWithNumber("35", "route 35");
        assertEquals(r35, r2);
        assertEquals(2, RouteManager.getInstance().getNumRoutes());
        RouteManager.getInstance().clearRoutes();
        assertEquals(0, RouteManager.getInstance().getNumRoutes());
    }


}
