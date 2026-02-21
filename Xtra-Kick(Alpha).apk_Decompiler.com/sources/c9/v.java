package c9;

import java.util.logging.Level;
import java.util.logging.Logger;

public final class v {
    private v() {
    }

    public static String a(String str, Object... objArr) {
        int indexOf;
        String str2;
        String str3;
        int i10 = 0;
        for (int i11 = 0; i11 < objArr.length; i11++) {
            Object obj = objArr[i11];
            if (obj == null) {
                str2 = "null";
            } else {
                try {
                    str2 = obj.toString();
                } catch (Exception e10) {
                    String name = obj.getClass().getName();
                    String hexString = Integer.toHexString(System.identityHashCode(obj));
                    StringBuilder sb2 = new StringBuilder(String.valueOf(hexString).length() + name.length() + 1);
                    sb2.append(name);
                    sb2.append('@');
                    sb2.append(hexString);
                    String sb3 = sb2.toString();
                    Logger logger = Logger.getLogger("com.google.common.base.Strings");
                    Level level = Level.WARNING;
                    String valueOf = String.valueOf(sb3);
                    if (valueOf.length() != 0) {
                        str3 = "Exception during lenientFormat for ".concat(valueOf);
                    } else {
                        str3 = new String("Exception during lenientFormat for ");
                    }
                    logger.log(level, str3, e10);
                    String name2 = e10.getClass().getName();
                    StringBuilder sb4 = new StringBuilder(name2.length() + String.valueOf(sb3).length() + 9);
                    sb4.append("<");
                    sb4.append(sb3);
                    sb4.append(" threw ");
                    sb4.append(name2);
                    sb4.append(">");
                    str2 = sb4.toString();
                }
            }
            objArr[i11] = str2;
        }
        StringBuilder sb5 = new StringBuilder((objArr.length * 16) + str.length());
        int i12 = 0;
        while (i10 < objArr.length && (indexOf = str.indexOf("%s", i12)) != -1) {
            sb5.append(str, i12, indexOf);
            sb5.append(objArr[i10]);
            int i13 = i10 + 1;
            i12 = indexOf + 2;
            i10 = i13;
        }
        sb5.append(str, i12, str.length());
        if (i10 < objArr.length) {
            sb5.append(" [");
            sb5.append(objArr[i10]);
            for (int i14 = i10 + 1; i14 < objArr.length; i14++) {
                sb5.append(", ");
                sb5.append(objArr[i14]);
            }
            sb5.append(']');
        }
        return sb5.toString();
    }
}
