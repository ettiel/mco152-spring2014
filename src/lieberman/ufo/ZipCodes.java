package lieberman.ufo;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class ZipCodes {

	private List<ZipCode> zipCodes;

	public ZipCodes() throws IOException {

		CSVReader reader = new CSVReader(new FileReader("ZIP_CODES.txt"));
		String[] values;
		zipCodes = new ArrayList<ZipCode>();

		while ((values = reader.readNext()) != null) {

			String zipcode = values[0];
			String latitude = values[1];
			String longitude = values[2];
			String city = values[3];
			String state = values[4];
			ZipCode aCode = new ZipCode(zipcode, latitude, longitude, city,
					state);
			zipCodes.add(aCode);
		}
		reader.close();
	}

	public List<ZipCode> getZipList() {
		return zipCodes;
	}
}
