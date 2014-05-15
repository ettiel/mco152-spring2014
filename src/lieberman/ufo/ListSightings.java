package lieberman.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class ListSightings {

	public static void main(String[] args) throws IOException {

		Gson gson = new Gson();

		FileReader reader = new FileReader("ufo_awesome.json");
		SightingList list = gson.fromJson(reader, SightingList.class);
		Map<String, ArrayList<Sighting>> map = new HashMap<>();

		for (Sighting s : list) {
			String location = s.getLocation();
			ArrayList<Sighting> sightings = map.get(location);
			if (sightings == null) {
				sightings = new ArrayList<Sighting>();
			}
			sightings.add(s);
			map.put(location, sightings);

		}

		// System.out.println(list.size());
		//
		// ZipCodes codes = new ZipCodes();
		// List<ZipCode> zips = codes.getZipList();
		// String z = null;
		// StringBuilder info = new StringBuilder();
		// for (Sighting s : list) {
		// if ("19950115".equals(s.getSightedAt())) {
		// String loc = s.getLocation();
		// StringTokenizer tok = new StringTokenizer(loc, ",");
		// String city = tok.nextToken().substring(1);
		// String state = tok.nextToken().trim();
		//
		// for (int i = 0; i < zips.size(); i++) {
		// ZipCode zip = zips.get(i);
		// if (state.equals(zip.getState())
		// && (city.equalsIgnoreCase(zip.getCity()))) {
		// z = zips.get(i).getZipcode();
		// }
		// }
		// info.append(s.toString());
		// info.append(" zip:");
		// info.append(z);
		//
		// }
		// }
		// System.out.println(info);
	}

}
