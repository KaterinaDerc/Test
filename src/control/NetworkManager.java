package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import model.User;

public class NetworkManager {


	public static ArrayList<User> getStudentList() throws Exception {

		ArrayList<User> result = new ArrayList<User>();
		
		String studentUrl = "https://jsonplaceholder.typicode.com/users";

		URL url = new URL(studentUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		int responseCode = connection.getResponseCode();
		if (responseCode == 200) {

			InputStream inputStream = connection.getInputStream();
			InputStreamReader inputReader = new InputStreamReader(inputStream);
			BufferedReader buffer = new BufferedReader(inputReader);
			StringBuilder stringBuilder = new StringBuilder();

			String outputFromBuff;
			while ((outputFromBuff = buffer.readLine()) != null) {
				stringBuilder.append(outputFromBuff);

			}

			JSONArray jArray = new JSONArray(stringBuilder.toString());

			for (int i = 0; i < jArray.length(); i++) {
				JSONObject jUser = jArray.getJSONObject(i);

				User user = new User(jUser);

				result.add(user);

			}
		} else {
			System.out.println("no InfoforStudent");
		}
		
		return result;

	}
}
