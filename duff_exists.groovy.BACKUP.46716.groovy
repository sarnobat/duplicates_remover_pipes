import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;


public class DuffExists {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
<<<<<<< HEAD
		while (!br.ready()){
=======
		while (!br.ready()) {
>>>>>>> 917a3d4b08800c8932d8aadd89c24624905b9ad2
			Thread.sleep(500L);
		}
		while (br.ready()) {
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
