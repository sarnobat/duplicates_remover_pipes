import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

public class Array2Images {

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Until we start receiving input, keep the process running
		while (!br.ready()){
			Thread.sleep(500L);
		}
		while (br.ready()) {
			String inputLine = br.readLine();
			JsonArray a = jsonFromString(inputLine);
			System.out.println("Array2Images.main()  " + a);
		}

	}

	private static JsonArray jsonFromString(String jsonObjectStr) {

	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
	    JsonArray object = jsonReader.readArray();
	    jsonReader.close();

	    return object;
	}
}
