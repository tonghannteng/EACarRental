package mum.cs544.project.GPS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.httpclient.util.URIUtil;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.stereotype.Component;

@Component
public class LocationUtility {
	public Location getLocationFromAddress(String Address) {
		try {
			URL url = new URL(
					"http://maps.googleapis.com/maps/api/geocode/json?address="
							+ URIUtil.encodeQuery(Address)
							+ "&sensor=true");
			System.out.println(url.toString());
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.setRequestProperty("Accept", "application/json");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}
			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output = "", full = "";
			while ((output = br.readLine()) != null) {
				full += output;
			}
			JSONObject Location = (JSONObject) (new JSONParser()).parse(full);
			// System.out.println(full);
			if (Location.size() > 0)
				if (Location.containsKey("results")) {
					System.out.println(Location.get("results").toString());
					JSONArray results = (JSONArray) Location.get("results");
					if (results.size() > 0) {
						JSONObject geometeryAll = (JSONObject) results.get(0);
						if (geometeryAll.containsKey("geometry")) {
						JSONObject geometry = (JSONObject) ((JSONObject) geometeryAll.get("geometry")).get("location");
						Double lat = (Double) geometry.get("lat");
						Double lng = (Double) geometry.get("lng");
						return new Location(lat, lng);
						}
					}
				}
		} catch (Exception E) {
			E.printStackTrace();
		}
		return new Location(0, 0);
	}

	public double calculateDistance(Location loc1, Location loc2) {
		final int R = 6371;

		Double latDistance = Math.toRadians(loc2.getLat() - loc1.getLat());
		Double lonDistance = Math.toRadians(loc2.getLng() - loc1.getLng());
		Double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2) + Math.cos(Math.toRadians(loc1.getLat()))
				* Math.cos(Math.toRadians(loc2.getLat())) * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
		Double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		double distance = R * c;
		return distance;
	}
}
