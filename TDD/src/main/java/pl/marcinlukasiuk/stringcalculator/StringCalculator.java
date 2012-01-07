package pl.marcinlukasiuk.stringcalculator;

import java.util.Collection;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.base.Predicate;
import com.google.common.base.Strings;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;


/**
 * 1. Create a simple String calculator with a method int Add(string numbers)
         1. The method can take 0, 1 or 2 numbers, and will return their sum (for an empty string it will return 0) for example “” or “1” or “1,2”
         2. Start with the simplest test case of an empty string and move to 1 and two numbers
         3. Remember to solve things as simply as possible so that you force yourself to write tests you did not think about
         4. Remember to refactor after each passing test
   2. Allow the Add method to handle an unknown amount of numbers
   3. Allow the Add method to handle new lines between numbers (instead of commas).
         1. the following input is ok:  “1\n2,3”  (will equal 6)
         2. the following input is NOT ok:  “1,\n” (not need to prove it - just clarifying)
   4.
         1. Support different delimiters to change a delimiter, the beginning of the string will contain a separate line that looks like this:   “//[delimiter]\n[numbers…]” for example “//;\n1;2” should return three where the default delimiter is ‘;’ .
         2. the first line is optional. all existing scenarios should still be supported
   5. Calling Add with a negative number will throw an exception “negatives not allowed” - and the negative that was passed.if there are multiple negatives, show all of them in the exception message.
   6. Numbers bigger than 1000 should be ignored, so adding 2 + 1001  = 2
   
   TODO
   7. Delimiters can be of any length with the following format:  “//[delimiter]\n” for example: “//[***]\n1***2***3” should return 6
   8. Allow multiple delimiters like this:  “//[delim1][delim2]\n” for example “//[*][%]\n1*2%3” should return 6.
   9. make sure you can also handle multiple delimiters with length longer than one char

 * @author marcin
 *
 */
public class StringCalculator {

	public static int add(String inputString) {

		List<Integer> numbers = parseNumbers(inputString);
		ensureThereIsNoNegatives(numbers);

		return addNumbers(numbers);
	}

	private static void ensureThereIsNoNegatives(List<Integer> numbers) {

		Collection<Integer> negatives = Collections2.filter(numbers, new Predicate<Integer>() {

			public boolean apply(Integer number) {
				return number < 0;
			}
		});

		if (negatives.size() > 0) {
			throw new RuntimeException("negatives not allowed: " + Joiner.on(',').join(negatives));
		}
	}

	private static List<Integer> parseNumbers(String text) {
		return toNumbers(toValues(text));
	}

	private static String[] toValues(String string) {

		if (Strings.isNullOrEmpty(string)) {
			return new String[0];
		}
		else if (string.startsWith("//")) {
			Matcher m = Pattern.compile("//(.)\n(.*)").matcher(string);
			m.matches();
			return m.group(2).split(m.group(1));
		}
		else {
			return string.split(",|\n");
		}
	}

	private static List<Integer> toNumbers(String[] values) {

		return Lists.newArrayList(Collections2.transform(Lists.newArrayList(values), new Function<String, Integer>() {

			public Integer apply(String value) {
				return Integer.parseInt(value);
			}
		}));
	}

	private static int addNumbers(List<Integer> numbers) {

		int sum = 0;
		for (Integer number : numbers) {
			if (number <= 1000) {
				sum += number;
			}
		}
		return sum;
	}
}
