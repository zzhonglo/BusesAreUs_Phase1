package ca.ubc.cs.cpsc210.translink.parsers;

import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.Stop;
import ca.ubc.cs.cpsc210.translink.model.StopManager;
import ca.ubc.cs.cpsc210.translink.parsers.exception.StopDataMissingException;
import ca.ubc.cs.cpsc210.translink.providers.DataProvider;
import ca.ubc.cs.cpsc210.translink.providers.FileDataProvider;
import ca.ubc.cs.cpsc210.translink.util.LatLon;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;

/**
 * A parser for the data returned by Translink stops query
 */
public class StopParser {

    private String filename;


    private String routes;
    private int counter;


    public StopParser(String filename) {
        this.filename = filename;
    }
    /**
     * Parse stop data from the file and add all stops to stop manager.
     *
     */
    public void parse() throws IOException, StopDataMissingException, JSONException{
        DataProvider dataProvider = new FileDataProvider(filename);

        parseStops(dataProvider.dataSourceToString());
    }
    /**
     * Parse stop information from JSON response produced by Translink.
     * Stores all stops and routes found in the StopManager and RouteManager.
     *
     * @param  jsonResponse    string encoding JSON data to be parsed
     * @throws JSONException when:
     * <ul>
     *     <li>JSON data does not have expected format (JSON syntax problem)</li>
     *     <li>JSON data is not an array</li>
     * </ul>
     * If a JSONException is thrown, no stops should be added to the stop manager
     * @throws StopDataMissingException when
     * <ul>
     *  <li> JSON data is missing Name, StopNo, Routes or location (Latitude or Longitude) elements for any stop</li>
     * </ul>
     * If a StopDataMissingException is thrown, all correct stops are first added to the stop manager.
     */

    public void parseStops(String jsonResponse)
            throws JSONException, StopDataMissingException {
        JSONArray array = new JSONArray(jsonResponse);
        counter = 0;
            for (int index = 0; index < array.length(); index++) {
                try {
                    JSONObject jstop = array.getJSONObject(index);
                    Stop s = parseStop(jstop);
                    StopManager.getInstance().addStopToManager(s);
                } catch (JSONException e) {
                    counter++;
                }
            }
        if (counter > 0) throw new StopDataMissingException();
    }

    private Stop parseStop (JSONObject jstop) throws JSONException, StopDataMissingException {
            String stopName = jstop.getString("Name");
            int stopNo = jstop.getInt("StopNo");
            Double lat = jstop.getDouble("Latitude");
            Double lon = jstop.getDouble("Longitude");
            this.routes = jstop.getString("Routes");
            Stop s = new Stop(stopNo, stopName, new LatLon(lat, lon));

            String[] array = this.routes.split(",");
            for (int i = 0; i < array.length; i++) {
                s.addRoute(RouteManager.getInstance().getRouteWithNumber(array[i].trim()));
                RouteManager.getInstance().getRouteWithNumber(array[i]).addStop(s);
            }
            return s;
    }

}
