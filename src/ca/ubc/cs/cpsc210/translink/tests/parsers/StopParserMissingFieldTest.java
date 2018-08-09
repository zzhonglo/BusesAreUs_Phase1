package ca.ubc.cs.cpsc210.translink.tests.parsers;

import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.StopParser;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import java.io.IOException;



/**
 * Created by apple on 2017-03-15.
 */
public class StopParserMissingFieldTest {
    @Before
    public void setup() {
        StopManager.getInstance().clearStops();
    }

    @Test (expected = StopDataMissingException.class)
    public void testStopParserMissingLat() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopMissingLat.json");
        p.parse();
    }

    @Test (expected = StopDataMissingException.class)
    public void testStopParserMissingName() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopMissingName.json");
        p.parse();
    }

    @Test (expected = JSONException.class)
    public void testStopParserBadFormat() throws StopDataMissingException, JSONException, IOException {
        StopParser p = new StopParser("StopBadFormat.json");
        p.parse();
    }
}
