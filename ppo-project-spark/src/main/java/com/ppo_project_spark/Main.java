package com.ppo_project_spark;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.google.gson.Gson;

import spark.utils.IOUtils;

public class Main {
	public static void main(String[] args) {

		System.out.println("start project ...");
		new UserController(new UserService());
		Main main = new Main();
		
		/*TestResponse res = main.request("POST", "/users?name=john&email=john@foobar.com");
		Map<String, String> json = res.json();
		assertEquals(200, res.status);
		assertEquals("john", json.get("name"));
		assertEquals("john@foobar.com", json.get("email"));
		assertNotNull(json.get("id"));
		System.out.println("test class ...");*/
		
		
	}

	
	
	private TestResponse request(String method, String path) {
		try {
			URL url = new URL("http://localhost:4567" + path);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod(method);
			connection.setDoOutput(true);
			connection.connect();
			String body = IOUtils.toString(connection.getInputStream());
			return new TestResponse(connection.getResponseCode(), body);
		} catch (IOException e) {
			e.printStackTrace();
			fail("Sending request failed: " + e.getMessage());
			return null;
		}
	}

	private static class TestResponse {
		public final String body;
		public final int status;

		public TestResponse(int status, String body) {
			this.status = status;
			this.body = body;
		}
		public Map<String, String> json() {
			return new Gson().fromJson(body, HashMap.class);
		}
	}
}
