import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Duff2Json {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while (br.ready()) {
			String s = br.readLine();
			System.out.println(s);
		}
	}

}
