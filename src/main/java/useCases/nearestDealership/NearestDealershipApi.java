package useCases.nearestDealership;

import intefaceAdapters.nearestDealership.ApiKey;
import intefaceAdapters.nearestDealership.NearestDealershipApiGateway;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class NearestDealershipApi implements NearestDealershipApiGateway {
    private static final String API_KEY = ApiKey.API_KEY;
    @Override
    public NearestDealershipResponseModel getClosestDealership(List<DealershipDsRequestModel> dealerships, String userLocation) {
        DealershipDsRequestModel closest = dealerships.get(0);
        long closestDistance = 300000;
        String closestDistText = "None";
        String shortestTimeText = "None";

        for (DealershipDsRequestModel dealership:
             dealerships) {
            try {
                JSONObject jo = getData(userLocation, dealership.getLocation());
                JSONObject je = (JSONObject) jo.get("distance");
                JSONObject jf = (JSONObject) jo.get("duration");
                long distanceVal = (long) je.get("value");
                String distanceTxt = (String) je.get("text");
                String timeTxt = (String) jf.get("text");
                if (distanceVal < closestDistance){
                    closestDistance = distanceVal;
                    closestDistText = distanceTxt;
                    shortestTimeText = timeTxt;
                    closest = dealership;
                }
            } catch (Exception ignored) {
            }
        }

        return new NearestDealershipResponseModel(closest.getName(), closest.getLocation(), shortestTimeText, closestDistText);
    }

    private JSONObject getData(String source, String destination) throws IOException, InterruptedException, ParseException {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins=" + source + "&destinations=" + destination + "&units=imperial&key=" + API_KEY;
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(url)).build();
        HttpClient client = HttpClient.newBuilder().build();
        var response = client.send(request, HttpResponse.BodyHandlers.ofString()).body();
        JSONParser jp = new JSONParser();
        JSONObject jo = (JSONObject) jp.parse(response);
        JSONArray ja = (JSONArray) jo.get("rows");
        jo = (JSONObject) ja.get(0);
        ja = (JSONArray) jo.get("elements");
        jo = (JSONObject) ja.get(0);
        return jo;
    }

}
