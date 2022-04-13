package control;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

import model.User;

public class NetworkManager {

	public static Object ListStudentList() {

		return null;
	}

	public static void showNetworkUsers() throws IOException {

		System.out.print("Список пользователей интернета: ");

		String studentUrl = "https://jsonplaceholder.typicode.com/users";

		URL url = new URL(studentUrl);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		System.out.println("getResponseCode:" + connection.getResponseCode());

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

		}
	}
}
