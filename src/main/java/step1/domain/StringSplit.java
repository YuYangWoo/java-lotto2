package step1.domain;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringSplit {

    private static final String DELIMITER = ",|:";
    private static final int CUSTOM_DELIMITER_LOCATION = 1;
    private static final int START_CALCULATOR_LOCATION = 2;
    private static final Pattern CUSTOM_PATTERN = Pattern.compile("//(.)\n(.*)");

    private String value;

    public StringSplit(String value) {
        this.value = value;
    }

    public String[] splitWithDelimeter() {
       Matcher matcher = CUSTOM_PATTERN.matcher(value);
        if (matcher.find()) {
            String customDelimiter = matcher.group(CUSTOM_DELIMITER_LOCATION);
            return matcher.group(START_CALCULATOR_LOCATION).split(customDelimiter);
        }

        return value.split(DELIMITER);
    }
}