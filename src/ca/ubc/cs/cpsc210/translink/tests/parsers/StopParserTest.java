package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.StopParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Tests for the StopParser
 */

// TODO: Write more tests

public class StopParserTest {
    @Before
    public void setup() {
        StopManager.getInstance().clearStops();
    }

    @Test
    public void testStopParserNormal() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("stops.json");
        p.parse();
        assertEquals(8524, StopManager.getInstance().getNumStops());
    }

    @Test (expected = StopDataMissingException.class)
    public void testStopParserMissingLat() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopMissingLat.json");
        p.parse();
        assertEquals(1, StopManager.getInstance().getNumStops());
    }

    @Test (expected = StopDataMissingException.class)
    public void testStopParserMissingName() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopMissingName.json");
        p.parse();
        assertEquals(1, StopManager.getInstance().getNumStops());

    }

    @Test (expected = JSONException.class)
    public void testStopParserBadFormat() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopBadFormat.json");
        p.parse();
    }

    @Test
    public void testRouteContains() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("stops.json");
        p.parse();
        assertEquals(8524, StopManager.getInstance().getNumStops());

        Stop s = StopManager.getInstance().getStopWithNumber(50289);
        Route r480 = RouteManager.getInstance().getRouteWithNumber("480");
        Route r41 = RouteManager.getInstance().getRouteWithNumber("041");
        Route r43 = RouteManager.getInstance().getRouteWithNumber("043");

        assertTrue(s.getRoutes().contains(r480));
        assertTrue(s.getRoutes().contains(r41));
        assertTrue(s.getRoutes().contains(r43));
    }
}
