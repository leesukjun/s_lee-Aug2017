
public class Magpie2 {

	//Get a default greeting and return a greeting	
	public String getGreeting() {
		return "Hello, let's talk.";
	}

	/**
	 * Gives a response to a user statement
	 * takes in a user statement
	 * returns a response based on given rules
	 */
	public String getResponse(String statement) {
		String response = "";
		if (statement.trim().length() < 1) {
				response = "Say something, please.";
		}
		else if (statement.indexOf("no") >= 0) {
			response = "Why so negative?";
		} else if (statement.indexOf("mother") >= 0
				|| statement.indexOf("father") >= 0
				|| statement.indexOf("sister") >= 0
				|| statement.indexOf("brother") >= 0) {
			response = "Tell me more about your family.";
		} else if (statement.indexOf("Dreyer") >= 0
				|| statement.indexOf("deHeer") >= 0
				|| statement.indexOf("Lamont") >= 0) {
			response = "I heard your teachers are very good at teaching!";
		} else if (statement.indexOf("Trump") >= 0
				|| statement.indexOf("Donald") >= 0
				|| statement.indexOf("trump") >= 0
				|| statement.indexOf("donald") >= 0) {
			response = "Let's make America great again!";
		} else if (statement.indexOf("Hillary") >= 0
				|| statement.indexOf("Clinton") >= 0
				|| statement.indexOf("hillary") >= 0
				|| statement.indexOf("clinton") >= 0) {
			response = "Make sure you don't mess around with your email!";
		} else if (statement.indexOf("Test") >= 0
				|| statement.indexOf("test") >= 0
				|| statement.indexOf("Quiz") >= 0
				|| statement.indexOf("quiz") >= 0) {
			response = "Haha, sucks for you!";
		} else {
			response = getRandomResponse();
		}
		return response;
	}

	/**
	 * Pick a default response to use if nothing else fits.
	 * returns a non-committal string
	 */
	private String getRandomResponse() {
		final int NUMBER_OF_RESPONSES = 6;
		double r = Math.random();
		int whichResponse = (int) (r * NUMBER_OF_RESPONSES);
		String response = "";

		if (whichResponse == 0) {
			response = "Interesting, tell me more.";
		} else if (whichResponse == 1) {
			response = "Hmmm.";
		} else if (whichResponse == 2) {
			response = "Do you really think so?";
		} else if (whichResponse == 3) {
			response = "You don't say.";
		} else if (whichResponse == 4) {
			response = "That is very interesting.";
		} else if (whichResponse == 5) {
			response = "Wow.";
		}
		return response;
	}
}
