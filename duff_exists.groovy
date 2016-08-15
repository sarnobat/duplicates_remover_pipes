import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;


public class DuffExists {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!br.ready()) {
			Thread.sleep(2500L);
System.err.println("DuffExists - waiting");
		}
		while (br.ready()) {
System.err.println("DuffExists - processing");
			String inputLine = br.readLine();
			if (inputLine.startsWith("/") || inputLine.startsWith("./")) {
				if (Paths.get(inputLine).toFile().exists()) {
					System.out.println(inputLine);
				} else {
//					System.err.println("Does not exist : " + inputLine);
				}
			}
			else {
				System.out.println(inputLine);
			}
		}
	}

}
