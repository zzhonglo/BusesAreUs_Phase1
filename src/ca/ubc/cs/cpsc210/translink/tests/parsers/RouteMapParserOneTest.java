package ca.ubc.cs.cpsc210.translink.tests.parsers;

/**
 * Created by apple on 2017-03-16.
 */

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.parsers.RouteMapParser;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class RouteMapParserOneTest {
    @Before
    public void setup() {
        RouteManager.getInstance().clearRoutes();
    }

    private int countNumRoutePatterns() {
        int count = 0;
        for (Route r : RouteManager.getInstance()) {
            for (RoutePattern rp : r.getPatterns()) {
                count ++;
            }
        }
        return count;
    }

    @Test
    public void testRouteParserOne() {
        RouteMapParser p = new RouteMapParser("RouteMapOne.txt");
        p.parse();
        assertEquals(1, countNumRoutePatterns());
        /*List testlist = new LinkedList();
        testlist.add(new LatLon(49.21716,-122.667252));
        assertEquals(RouteManager.getInstance().getRouteWithNumber("C43").getPattern("EB2").getPath(), testlist);*/
    }

    @Test
    public void testRouteParserMultiple() {
        RouteMapParser p = new RouteMapParser("RouteMapMultiple.txt");
        p.parse();
        assertEquals(1, countNumRoutePatterns());
        /*List testlist = new LinkedList();
        testlist.add(new LatLon(49.21716,-122.667252));
        testlist.add(new LatLon(49.216757,-122.666235));
        testlist.add(new LatLon(49.216749,-122.666051));

        assertEquals(RouteManager.getInstance().getRouteWithNumber("C43").getPattern("EB2").getPath(), testlist);*/

    }
}

