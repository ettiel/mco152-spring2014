package lieberman.mtamap;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import au.com.bytecode.opencsv.CSVReader;

public class Shapes {

	private List<Shape> shapes;

	public Shapes() throws NumberFormatException, IOException {
		CSVReader reader = new CSVReader(new FileReader("shapes.txt"), ',',
				'\'', 1);
		shapes = new ArrayList<Shape>();
		String[] values;

		while ((values = reader.readNext()) != null) {

			String shapeId = values[0];
			String lat = values[1];
			String lon = values[2];
			Double latitue = Double.parseDouble(lat);
			Double longitude = Double.parseDouble(lon);
			Shape shape = new Shape(shapeId, latitue, longitude);
			shapes.add(shape);
		}
	}

	public List<Shape> getShapes(String shapeId) {
		List<Shape> shape = null;
		for (int i = 0; i <= shapes.size(); i++) {
			if (shapes.get(i).getShapeId() == shapeId) {
				shape.add(shapes.get(i));
			}
		}
		return shape;
	}

}
