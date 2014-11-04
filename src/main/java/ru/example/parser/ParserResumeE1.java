package ru.example.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import ru.example.model.Resume;

import java.util.List;

public class ParserResumeE1 implements Parser {

    private static final String URL1 = "http://rabota.e1.ru/api/v1/resumes/?limit=100&offset=";
    private static final String URL2 = "&search_key=1z7sn9e&auth_token=&q=&average_salary=true";

    @Override
    public List<Resume> parse() throws Exception {
        int i = 100;
        Document doc;
        String url;
        for (;i<70000;) {
            url = URL1 + i + URL2;
            doc = Jsoup.connect(url).get();
        }

        return null;
    }
}
private static DefaultHttpClient httpClient = ConnectionManager.getClient();

    public static List<Club> getNearestClubs(double lat, double lon) {
        // YOUR URL GOES HERE
        String getUrl = Constants.BASE_URL + String.format("getClosestClubs?lat=%f&lon=%f", lat, lon);

        List<Club> ret = new ArrayList<Club>();

        HttpResponse response = null;
        HttpGet getMethod = new HttpGet(getUrl);
        try {
            response = httpClient.execute(getMethod);

            // CONVERT RESPONSE TO STRING
            String result = EntityUtils.toString(response.getEntity());

            // CONVERT RESPONSE STRING TO JSON ARRAY
            JSONArray ja = new JSONArray(result);

            // ITERATE THROUGH AND RETRIEVE CLUB FIELDS
            int n = ja.length();
            for (int i = 0; i < n; i++) {
                // GET INDIVIDUAL JSON OBJECT FROM JSON ARRAY
                JSONObject jo = ja.getJSONObject(i);

                // RETRIEVE EACH JSON OBJECT'S FIELDS
                long id = jo.getLong("id");
                String name = jo.getString("name");
                String address = jo.getString("address");
                String country = jo.getString("country");
                String zip = jo.getString("zip");
                double clat = jo.getDouble("lat");
                double clon = jo.getDouble("lon");
                String url = jo.getString("url");
                String number = jo.getString("number");

                // CONVERT DATA FIELDS TO CLUB OBJECT
                Club c = new Club(id, name, address, country, zip, clat, clon, url, number);
                ret.add(c);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // RETURN LIST OF CLUBS
        return ret;
    }

}
Again, it’s relatively straight forward, but the methods I’ll make special note of are:

        JSONArray ja = new JSONArray(result);
        JSONObject jo = ja.getJSONObject(i);
        long id = jo.getLong("id");
        String name = jo.getString("name");
        double clat = jo.getDouble("lat");