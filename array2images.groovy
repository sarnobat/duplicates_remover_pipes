import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonReader;

public class Array2Images {
	private static final String BASE_URL = "http://netgear.rohidekar.com:44452/";

	public static void main(String[] args) throws IOException, InterruptedException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// Until we start receiving input, keep the process running
		for(String s : Files.readAllLines(Paths.get("./header.html"), java.nio.charset.Charset.defaultCharset())) {
			System.out.println(s);
		}
		String inputLine;
		while ((inputLine = br.readLine()) != null) {
//System.err.println("Array2Images - processing");
			JsonArray a = jsonFromString(inputLine);
			List<String> files = toCollection(a);
			String imageTags = toImageTags(files);
			String imageTiles = toImageTiles(files);
			if (files.size() > 1) {
				System.out.println(imageTiles + "<br>" + imageTags + "<br><br>");
			}
		}
	}

	private static String toImageTiles(List<String> filePaths) {
		String ret = "";
		for (String filePath : filePaths) {
			ret += toImagePath(filePath);
		}
		return ret;

	}

	private static String toImagePath(String filePath) {
		return "<span>" + getButtons(filePath) + filePath + "</span><br>\n";
	}

              private static String httpLinkFor(String iAbsolutePath) {

                                String prefix = "http://netgear.rohidekar.com:44452";
                                return prefix + iAbsolutePath.replace("+", "%2B").replace("ã", "&atilde");//.replace("+", "%2B");
                        }


                        private static String convertToURLEscapingIllegalCharacters(String string){
                            try {
                                String decodedURL = URLDecoder.decode(string, "UTF-8");
                                URL url = new URL(decodedURL);
                                        URI uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(), url.getPort(),
                                                        url.getPath(), url.getQuery(), url.getRef());
                                return uri.toASCIIString();
                            } catch (Exception ex) {
                                ex.printStackTrace();
                                return null;
                            }
                        }

                        private static String thumbnailFor(Path iPath) {
                        		String thePath = iPath.toString();
                        		if (!(thePath.endsWith("mp4") || thePath.endsWith("mov"))) {
                        			return iPath.toString();
                        		}
                        
                                // This must be on a single line for Groovy
                                String string = iPath.getParent().toFile().getAbsolutePath() + "/_thumbnails/" + iPath.getFileName().getFileName() + ".jpg";
                                if (!Paths.get(string).toFile().exists()) {
                                        if (string.endsWith("mp4")) {

                                                System.err.println("Coagulate.FileLister.Mappings.thumbnailFor() - warning: non-existent thumbnail: " + string);
                                        }
                                }
                                return string;
                        }

	private static String getButtons(String filePath) {
		if (filePath.contains("'")) {
			System.err.println("Need to escape file paths");
			return "";
		}
		if (filePath.contains("\"")) {
			System.err.println("Need to escape file paths 2");
			return "";
		}
		return "<input type=button onclick='deleteFile(\"" + filePath +"\"); this.parentElement.remove()' value='Delete' text='myText'>";
	}

	private static String toImageTags(List<String> filePaths) {
		String ret = "";
		for (String filePath : filePaths) {
			ret += toImageTag(filePath);
		}
		return ret;
	}

	private static String toImageTag(String filePath) {
		String httpImageDisplay = httpLinkFor(thumbnailFor(Paths.get(filePath)));
		return "<span id='"+filePath.replaceAll("[^A-Za-z0-9_]", "")+"'><img src='" + httpImageDisplay + "' height=200></span>\n";
	}

	private static List<String> toCollection(JsonArray a) {
		List<String> l = new LinkedList<String>();
		for (int i = 0; i < a.size(); i++) {
			l.add(a.getString(i));
		}
		return l;
	}

	private static JsonArray jsonFromString(String jsonObjectStr) {

	    JsonReader jsonReader = Json.createReader(new StringReader(jsonObjectStr));
	    JsonArray object = jsonReader.readArray();
	    jsonReader.close();

	    return object;
	}
}
