import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Paths;


public class DuffExists {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (!br.ready()) {
			Thread.sleep(500L);
		}
		while (br.ready()) {
			String inputLine = br.readLine();
                                        System.out.println(inputLine);
		}
	}

}
