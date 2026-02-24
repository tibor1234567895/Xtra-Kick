package j9;

public enum h implements i {
    ;

    public static String b(String str, String str2) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            if (Character.isUpperCase(charAt) && sb2.length() != 0) {
                sb2.append(str2);
            }
            sb2.append(charAt);
        }
        return sb2.toString();
    }

    public static String c(String str) {
        String str2;
        StringBuilder sb2 = new StringBuilder();
        int i10 = 0;
        char charAt = str.charAt(0);
        int length = str.length();
        while (i10 < length - 1 && !Character.isLetter(charAt)) {
            sb2.append(charAt);
            i10++;
            charAt = str.charAt(i10);
        }
        if (Character.isUpperCase(charAt)) {
            return str;
        }
        char upperCase = Character.toUpperCase(charAt);
        int i11 = i10 + 1;
        if (i11 < str.length()) {
            str2 = upperCase + str.substring(i11);
        } else {
            str2 = String.valueOf(upperCase);
        }
        sb2.append(str2);
        return sb2.toString();
    }
}
