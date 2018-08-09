package ca.ubc.cs.cpsc210.translink.tests.model;

import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.model.exception.StopException;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test the StopManager
 */
public class StopManagerTest {

    @Before
    public void setup() {
        StopManager.getInstance().clearStops();
    }

    @Test
    public void testBoring() {
        Stop s9999 = new Stop(9999, "My house", new LatLon(-49.2, 123.2));
        Stop r = StopManager.getInstance().getStopWithNumber(9999);
        assertEquals(s9999, r);
    }

    @Test
    public void testGetStopWithNumber() {
        Stop r = StopManager.getInstance().getStopWithNumber(9999);
        Stop s9999 = new Stop(9999, "", new LatLon(-49.2, 123.2));
        assertEquals(s9999, r);
        s9999.setName("My house");
        Stop s9999aa = new Stop(9999, "My house", new LatLon(-49.2, 123.2));
        Stop r2 = StopManager.getInstance().getStopWithNumber(9999);
        assertEquals(s9999aa, r2);
    }

    @Test
    public void testGetStopWithNumber2() {
        Stop r = StopManager.getInstance().getStopWithNumber(9992, "Mall" , new LatLon(-49.22030, 123.20303));
        Stop s9992 = new Stop(9992, "Mall" , new LatLon(-49.22030, 123.20303));
        assertEquals(s9992, r);
        assertEquals(1, StopManager.getInstance().getNumStops());
        Stop r2 = StopManager.getInstance().getStopWithNumber(9995, "Store" , new LatLon(-49.21073, 123.2018));
        Stop s9995 = new Stop(9995, "Store" , new LatLon(-49.21073, 123.2018));
        assertEquals(s9995, r2);
        assertEquals(2, StopManager.getInstance().getNumStops());
        StopManager.getInstance().clearStops();
        assertEquals(0, StopManager.getInstance().getNumStops());
    }

    @Test
    public void testSelected() throws StopException{
        Stop r = StopManager.getInstance().getStopWithNumber(632, "Mall" , new LatLon(-49.22030, 123.20303));
        Stop r2 = StopManager.getInstance().getStopWithNumber(201, "Store" , new LatLon(-49.21073, 123.2018));
        StopManager.getInstance().setSelected(r2);
        assertEquals(r2, StopManager.getInstance().getSelected());
        StopManager.getInstance().clearSelectedStop();
        assertEquals(null, StopManager.getInstance().getSelected());
    }

    @Test (expected = StopException.class)
    public void testSelected2() throws StopException{
        Stop r = StopManager.getInstance().getStopWithNumber(632, "Mall" , new LatLon(-49.22030, 123.20303));
        Stop r2 = StopManager.getInstance().getStopWithNumber(201, "Store" , new LatLon(-49.21073, 123.2018));
        StopManager.getInstance().setSelected(new Stop(9999, "", new LatLon(-49.2, 123.2)));
    }

    @Test
    public void testFindNearestTo() {
        Stop r = StopManager.getInstance().getStopWithNumber(632, "Mall" , new LatLon(-49.22030, 123.20303));
        Stop r2 = StopManager.getInstance().getStopWithNumber(201, "Store" , new LatLon(-49.21008, 123.2018));
        Stop r3 = StopManager.getInstance().getStopWithNumber(3002, "Park" , new LatLon(-49.21001, 123.2033));
        assertEquals(r2, StopManager.getInstance().findNearestTo(new LatLon(-49.2, 123.2)));
    }

}
