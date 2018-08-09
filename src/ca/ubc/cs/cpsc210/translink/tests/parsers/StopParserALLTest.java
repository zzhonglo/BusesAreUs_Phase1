package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.StopParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by apple on 2017-03-18.
 */
public class StopParserALLTest {
        @Before
        public void setup() {
            StopManager.getInstance().clearStops();
        }

        @Test
        public void testStopParserNormal() throws StopDataMissingException, JSONException, IOException {
            StopParser p = new StopParser("StopPartial.json");
            p.parse();
            assertEquals(2, StopManager.getInstance().getNumStops());
        }

      @Test
       public void testRouteContainsStop() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopPartial.json");
        p.parse();
        Stop s1 = new Stop(50001, "WB DAVIE ST FS BIDWELL ST", new LatLon( 49.28646, -123.14043));
        Stop s2 = new Stop(50002, "EB BEACH AVE FS BURNABY ST", new LatLon(  49.28586, -123.14268));
        assertTrue(RouteManager.getInstance().getRouteWithNumber("C23").hasStop(s1));
        assertTrue(RouteManager.getInstance().getRouteWithNumber("C21").hasStop(s2));
    }


}
