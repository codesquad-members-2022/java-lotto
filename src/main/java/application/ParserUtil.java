package application;

import application.view.InputValidator;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParserUtil {

    public static int parseNumber(String str) {
        InputValidator.validateNumberFormat(str);
        return Integer.parseInt(str);
    }

    public static List<Integer> parseListNumber(String str) {
        return Arrays.stream(str.trim().split(","))
                .peek(InputValidator::validateNumberFormat)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public static List<List<Integer>> parseDoubleListNumber(String str) {
    return Arrays.stream(str.split("\n"))
                .map(ParserUtil::parseListNumber)
                .collect(Collectors.toList());
    }

    public static Map objectToMap(Object obj){
        try {
            Map resultMap = new HashMap();

            Field[] fields = obj.getClass().getDeclaredFields();

            for (Field field : fields) {
                field.setAccessible(true);
                resultMap.put(field.getName(), field.get(obj));
            }
            return resultMap;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
