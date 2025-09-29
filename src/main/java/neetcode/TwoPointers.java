package neetcode;

public class TwoPointers {

	public static void main(String[] args) {
		isPalindrome("ara");
		isPalindrome("Was it a car or a cat I saw?");
		isPalindrome("araa");
	}

	public static boolean isPalindrome(String s) {
		boolean isPalindrome = true;

		if (s.isEmpty()) {
			return false;
		}

		char[] chars = s.toLowerCase().replaceAll("[^A-Za-z0-9]", "")
				               .trim()
				               .replaceAll(" ", "")
				               .toCharArray();

		for (int i = 0; i < chars.length - 1; i++) {
			System.out.println(chars[i] + " compare to " + chars[chars.length - 1 - i]);
			if (chars[i] != chars[chars.length - 1 - i]) {
				return false;
			}
		}
		return isPalindrome;
	}
}
