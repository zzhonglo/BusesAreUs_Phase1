package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.parsers.RouteParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by apple on 2017-03-17.
 */
public class RouteParserALLTest {
        @Before
        public void setup() {
            RouteManager.getInstance().clearRoutes();
        }

        @Test
        public void testRouteParser1() throws RouteDataMissingException, JSONException, IOException {
            RouteParser p = new RouteParser("RoutesPartial.json");
            p.parse();
            assertEquals(1, RouteManager.getInstance().getNumRoutes());
            assertEquals(5, RouteManager.getInstance().getRouteWithNumber("002").getPatterns().size());
        }

       @Test
       public void testRouteParser2() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RoutesPartial.json");
        p.parse();
        assertEquals(1, RouteManager.getInstance().getNumRoutes());
        assertEquals("MACDONALD/DOWNTOWN ", RouteManager.getInstance().getRouteWithNumber("002").getName());
    }

    @Test
    public void testRouteParser3() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RoutesPartial.json");
        p.parse();
        assertEquals(1, RouteManager.getInstance().getNumRoutes());
        assertEquals("002", RouteManager.getInstance().getRouteWithNumber("002").getNumber());
    }

    }
