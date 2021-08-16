package Vmware.Vmware;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class VmwareApplication {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		SpringApplication.run(VmwareApplication.class, args);

		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(new FileReader("/home/kushalkhandelwal/Desktop/input.json"));

			JSONObject jsonObject = (JSONObject) obj;
			JSONObject obj1 = new JSONObject();

			Map<String, Object> x = (Map<String, Object>) jsonObject.get("1");
			String type = (String) x.get("type");
			if (type.equalsIgnoreCase("circle")) {
				Double radius = Double.parseDouble(x.get("radius").toString());
				Double circleArea = 3.141 * radius * radius;
				obj1.put("1", circleArea);
			}

			Map<String, Object> x2 = (Map<String, Object>) jsonObject.get("2");
			String type1 = (String) x2.get("type");
			if (type1.equalsIgnoreCase("rectangle")) {
				Double l = Double.parseDouble(x2.get("l").toString());
				Double b = Double.parseDouble(x2.get("b").toString());
				Double rectangleArea = l * b;
				obj1.put("2", rectangleArea);
			}

			Map<String, Object> x1 = (Map<String, Object>) jsonObject.get("3");
			String type11 = (String) x1.get("type");
			if (type11.equalsIgnoreCase("square")) {
				Double side = Double.parseDouble(x1.get("side").toString());
				Double squareArea = side * side;
				obj1.put("3", squareArea);
			}
			
			FileWriter file = new FileWriter("/home/kushalkhandelwal/Desktop/output.json");
			file.write(obj1.toJSONString());
			file.close();

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
