package com.qa.TN.Utilities;

	import java.util.Date;

	public class Util {
	

	public static String emailWithDateTimeStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", ":").replace(":", "_");
		return "shajahanhoque" + timeStamp + "@gmail.com";

}
}