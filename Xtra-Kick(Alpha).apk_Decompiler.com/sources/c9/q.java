package c9;

public final class q {
    private q() {
    }

    public static String a(int i10, int i11, String str) {
        if (i10 < 0) {
            return v.a("%s (%s) must not be negative", str, Integer.valueOf(i10));
        } else if (i11 >= 0) {
            return v.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i10), Integer.valueOf(i11));
        } else {
            StringBuilder sb2 = new StringBuilder(26);
            sb2.append("negative size: ");
            sb2.append(i11);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public static void b(int i10, int i11) {
        String str;
        if (i10 < 0 || i10 >= i11) {
            if (i10 < 0) {
                str = v.a("%s (%s) must not be negative", "index", Integer.valueOf(i10));
            } else if (i11 >= 0) {
                str = v.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i10), Integer.valueOf(i11));
            } else {
                StringBuilder sb2 = new StringBuilder(26);
                sb2.append("negative size: ");
                sb2.append(i11);
                throw new IllegalArgumentException(sb2.toString());
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void c(Object obj, String str) {
        if (obj == null) {
            throw new NullPointerException(str);
        }
    }

    public static void d(int i10, int i11) {
        if (i10 < 0 || i10 > i11) {
            throw new IndexOutOfBoundsException(a(i10, i11, "index"));
        }
    }

    public static void e(int i10, int i11, int i12) {
        String str;
        if (i10 < 0 || i11 < i10 || i11 > i12) {
            if (i10 < 0 || i10 > i12) {
                str = a(i10, i12, "start index");
            } else if (i11 < 0 || i11 > i12) {
                str = a(i11, i12, "end index");
            } else {
                str = v.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i11), Integer.valueOf(i10));
            }
            throw new IndexOutOfBoundsException(str);
        }
    }

    public static void f(String str, boolean z10) {
        if (!z10) {
            throw new IllegalStateException(str);
        }
    }
}
