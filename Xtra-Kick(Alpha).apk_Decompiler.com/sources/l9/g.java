package l9;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final int f9768a;

    static {
        int i10;
        String property = System.getProperty("java.version");
        try {
            String[] split = property.split("[._]");
            i10 = Integer.parseInt(split[0]);
            if (i10 == 1 && split.length > 1) {
                i10 = Integer.parseInt(split[1]);
            }
        } catch (NumberFormatException unused) {
            i10 = -1;
        }
        if (i10 == -1) {
            try {
                StringBuilder sb2 = new StringBuilder();
                for (int i11 = 0; i11 < property.length(); i11++) {
                    char charAt = property.charAt(i11);
                    if (!Character.isDigit(charAt)) {
                        break;
                    }
                    sb2.append(charAt);
                }
                i10 = Integer.parseInt(sb2.toString());
            } catch (NumberFormatException unused2) {
                i10 = -1;
            }
        }
        if (i10 == -1) {
            i10 = 6;
        }
        f9768a = i10;
    }

    private g() {
    }
}
