import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.HashSet;

import org.json.JSONArray;


public class Duff2Json {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

                while (!br.ready()) {
                        Thread.sleep(500L);
                }
		Collection<String> blockOfFiles = new HashSet<String>();
		while (!br.ready()){
			Thread.sleep(500L);
		}
		while (br.ready()) {
			String inputLine = br.readLine();
			if (inputLine.matches(".*files in cluster.*") || inputLine.matches(".*bytes.*")) {
				if (blockOfFiles.size() > 0) {
					JSONArray a = new JSONArray();
					for (String blockFile : blockOfFiles) {
						a.put(blockFile);
					}
					blockOfFiles.clear();
					System.out.println(a.toString());
				}
			}
			else {
				blockOfFiles.add(inputLine);
			}
		}
	}

}
