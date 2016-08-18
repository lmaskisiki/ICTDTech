package bcmanager.string.processor;

public class StringProccessor {

	public static String toTitleCase(String parent,String spliter) {
		String[] words = parent.trim().replace("+", " ")
				.replace("=", "").split(spliter);
		String fullname = "";
		for (String str : words) {
			fullname = fullname + Character.toUpperCase(str.charAt(0))
					+ str.substring(1) + " ";
		}
		return fullname;
	}

}
