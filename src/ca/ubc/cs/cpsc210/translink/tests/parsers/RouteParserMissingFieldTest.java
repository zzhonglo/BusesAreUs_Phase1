package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.parsers.RouteParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;



/**
 * Created by apple on 2017-03-15.
 */
public class RouteParserMissingFieldTest {
    @Before
    public void setup() {
        RouteManager.getInstance().clearRoutes();
    }

    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserMissingDestination() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteMissingDestination.json");
        p.parse();
    }

    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserMissingName() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteMissingName.json");
        p.parse();
    }

    @Test (expected = RouteDataMissingException.class)
    public void testRouteParserMissingPatterns() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteMissingPatterns.json");
        p.parse();
    }

    @Test (expected = JSONException.class)
    public void testRouteParserBadFormat1() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteBadFormat.json");
        p.parse();
    }

    @Test (expected = JSONException.class)
    public void testRouteParserBadFormat2() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteBadFormat2.json");
        p.parse();
    }

    @Test (expected = JSONException.class)
    public void testRouteParserBadFormat3() throws RouteDataMissingException, JSONException, IOException {
        RouteParser p = new RouteParser("RouteBadFormat3.json");
        p.parse();
    }
}
