package tutorialSpark;

import static spark.Spark.get;

import javax.sound.sampled.Port;

import com.ppo_project_spark.JsonUtil;

import spark.Spark;

public class Main {
	
	public static void main(String[] args) {
		System.out.println("start project test...");
		
		Spark.stop();
		
		Spark.port(8080);
		get("/hello", (req, res) -> "Hello World");
		
		
	}

	
}
