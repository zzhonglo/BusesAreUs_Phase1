package ca.ubc.cs.cpsc210.translink.parsers;

import ca.ubc.cs.cpsc210.translink.model.Route;
import ca.ubc.cs.cpsc210.translink.model.RouteManager;
import ca.ubc.cs.cpsc210.translink.model.RoutePattern;
import ca.ubc.cs.cpsc210.translink.parsers.exception.RouteDataMissingException;
import ca.ubc.cs.cpsc210.translink.providers.DataProvider;
import ca.ubc.cs.cpsc210.translink.providers.FileDataProvider;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;


/**
 * Parse route information in JSON format.
 */
public class RouteParser {
    private String filename;
    private int counter;

    //private boolean throwOrNot;


    public RouteParser(String filename) {
        this.filename = filename;
    }
    /**
     * Parse route data from the file and add all route to the route manager.
     *
     */
    public void parse() throws IOException, RouteDataMissingException, JSONException{
        DataProvider dataProvider = new FileDataProvider(filename);

        parseRoutes(dataProvider.dataSourceToString());
    }
    /**
     * Parse route information from JSON response produced by Translink.
     * Stores all routes and route patterns found in the RouteManager.
     *
     * @param  jsonResponse    string encoding JSON data to be parsed
     * @throws JSONException   when:
     * <ul>
     *     <li>JSON data does not have expected format (JSON syntax problem)
     *     <li>JSON data is not an array
     * </ul>
     * If a JSONException is thrown, no stops should be added to the stop manager
     *
     * @throws RouteDataMissingException when
     * <ul>
     *  <li>JSON data is missing RouteNo, Name, or Patterns element for any route</li>
     *  <li>The value of the Patterns element is not an array for any route</li>
     *  <li>JSON data is missing PatternNo, Destination, or Direction element for any route pattern</li>
     * </ul>
     * If a RouteDataMissingException is thrown, all correct routes are first added to the route manager.
     */

    public void parseRoutes(String jsonResponse)
            throws JSONException, RouteDataMissingException {
        JSONArray array = new JSONArray(jsonResponse);

        counter = 0;

        for (int index = 0; index < array.length(); index++) {
           try {
                JSONObject jroute = array.getJSONObject(index);
                Route route = parseRoute(jroute);
                RouteManager.getInstance().addRoute(route);
            }catch (JSONException e){
                counter ++;
           }
        }
        if (counter > 0) throw new RouteDataMissingException();
    }



    private Route parseRoute(JSONObject jroute) throws JSONException , RouteDataMissingException {
            String name = jroute.getString("Name");
            String routeNo = jroute.getString("RouteNo");
            JSONArray array = jroute.getJSONArray("Patterns");
            Route route = new Route(routeNo);
            route.setName(name);
            for (int index = 0; index < array.length(); index++) {
                try {
                    JSONObject jpattern = array.getJSONObject(index);
                    RoutePattern rp = new RoutePattern(jpattern.getString("PatternNo"), jpattern.getString("Destination"), jpattern.getString("Direction"), route);
                    route.addPattern(rp);
                }catch (JSONException e){
                    counter ++;
                }
            }
            return route;
        }
    }

