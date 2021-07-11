package qlnv;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class SdtEmailRegex {
    private static Pattern pattern;
    static private Matcher matcher;
    private static final String SDT_REGEX = "^[0][0-9]{9}$";
    private static final String EMAIL_REGEX =   "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static final String NAME_REGEX = "^[^0-9\\s]+[^0-9]*$";

    public static boolean validateSDT(String regex) {
        pattern = Pattern.compile(SDT_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateEmail(String regex){
        pattern = Pattern.compile(EMAIL_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }

    public static boolean validateName(String regex){
        pattern = Pattern.compile(NAME_REGEX);
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
