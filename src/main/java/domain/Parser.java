package domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import view.OutputView;

public class Parser {

    private static final int CUSTOM_DELIMITER = 1;
    private static final int PARSED_FORMULAR = 2;

    private static final Pattern PATTERN = Pattern.compile("//(.)\\n(.*)");

    public List<Integer> customSplitStringToNumber(String splitedFormular, String delimiter) {
        validateFormular(Arrays.asList(splitedFormular.split(delimiter)));
        return Arrays.asList(splitedFormular.split(delimiter)).stream()
            .map(Integer::parseInt).collect(
                Collectors.toList());
    }

    public ArrayList<String> customSplit(String formula) {
        Matcher matcher = PATTERN.matcher(formula);

        if (matcher.find()) {
            return new ArrayList<>(
                Arrays.asList(matcher.group(PARSED_FORMULAR), matcher.group(CUSTOM_DELIMITER)));
        }

        return new ArrayList<>(Arrays.asList(formula));
    }

    private void validateFormular(List<String> splitedFormular) {
        List<Integer> integeredFormular = stringListToInteger(splitedFormular);

        for(int formularNumber : integeredFormular) {
            if(formularNumber < 0) {
                throw new RuntimeException(OutputView.ERROR + OutputView.ERROR_NEGATIVE_NUMBER);
            }
        }
    }

    private List<Integer> stringListToInteger(List<String> splitedFormular) {
        return splitedFormular.stream().map(Integer::parseInt).collect(Collectors.toList());
    }
}
