public class DateTimeConvertor {
	public static void main(String... args) {
		// from LocalDate to String example
		LocalDate myDate = LocalDate.of(2016, 02, 01);
		DateTimeFormatter mysqlFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		String displayDate = myDate.format(mysqlFormatter);
		System.out.println(displayDate); // will display 2016-02-01

		// from String to LocalDate type example
		String myDateInDutchFormat = "12-01-1981";
		DateTimeFormatter dutchFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate dutchDate = LocalDate.parse(myDateInDutchFormat, dutchFormatter);
		System.out.println(dutchDate); // will output 1981-01-12
	}
}
