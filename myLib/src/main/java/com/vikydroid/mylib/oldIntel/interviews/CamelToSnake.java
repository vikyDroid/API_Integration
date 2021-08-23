package com.vikydroid.mylib.oldIntel.interviews;

public class CamelToSnake {
    public static void main(String[] args) {
//        String s = "GeeksForGeeks";
//        System.out.println(camelToSnake(s));
//        System.out.println(cTs(s));

        String s = "geeks_for_geeks";
//        System.out.println(snakeToCamel(s));
        System.out.println(sTc(s));
    }

    private static String camelToSnake(String s) {
        int n = s.length();
        boolean isNotFirst = false;
        StringBuilder res = new StringBuilder(n);
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == Character.toUpperCase(s.charAt(i))) {
                if (isNotFirst) {
                    res.append('_');
                }
                isNotFirst = true;
                res.append(Character.toLowerCase(s.charAt(i)));
            } else {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }

    private static String snakeToCamel(String s) {
        int n = s.length();
        StringBuilder res = new StringBuilder(n);
        int i;
        if (n == 0) return "";
        if (n == 1) {
            if (s.charAt(0) == '_') return "";
            return String.valueOf(Character.toUpperCase(s.charAt(0)));
        }
        if (s.charAt(0) == '_') {
            i = 2;
            res.append(Character.toUpperCase(s.charAt(1)));
        } else {
            i = 1;
            res.append(Character.toUpperCase(s.charAt(0)));
        }
        for (; i < n; i++) {
            if (s.charAt(i) == '_') {
                if (i != 0) {
                    i++;
                    res.append(Character.toUpperCase(s.charAt(i)));
                }
            } else {
                res.append(s.charAt(i));
            }
        }
//        res.deleteCharAt()
        return res.toString();
    }

    static String cTs(String s) {
        return s.replaceAll("([a-z])([A-Z]+)", "$1_$2").toLowerCase();
    }

    static String sTc(String s) {
        s = s.substring(0, 1).toUpperCase() + s.substring(1);
        while (s.contains("_")) {
            s = s.replaceFirst("_[a-z]", String.valueOf(Character.toUpperCase(s.charAt(s.indexOf('_') + 1))));
        }
        return s;
    }
}
