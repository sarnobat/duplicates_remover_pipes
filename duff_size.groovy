import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class DuffSize {

	public static void main(String[] args) throws IOException {
		long minSizeBytes = 25000;
		if (args.length > 0) {
			minSizeBytes = Long.parseLong(args[0]);
		}
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
			if (inputLine.startsWith("/") || inputLine.startsWith("./")) {
				Path path = Paths.get(inputLine);
//				File file = path.toFile();
				if (Files.exists(path)) {
					if (Files.size(path) > minSizeBytes) {
						System.out.println(inputLine);
					}
				} else {
				}
			}
			else {
				System.out.println(inputLine);
			}
		}
	}

}
