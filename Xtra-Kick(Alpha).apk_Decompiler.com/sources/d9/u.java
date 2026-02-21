package d9;

public final class u {
    public static void a(int i10, String str) {
        if (i10 < 0) {
            StringBuilder sb2 = new StringBuilder(str.length() + 40);
            sb2.append(str);
            sb2.append(" cannot be negative but was: ");
            sb2.append(i10);
            throw new IllegalArgumentException(sb2.toString());
        }
    }
}
