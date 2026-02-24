package j1;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f8421a = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    public static final String[] f8422b = {"", "A", "B", "C"};

    private e() {
    }

    public static String a(int i10, int i11, int i12) {
        return String.format("avc1.%02X%02X%02X", new Object[]{Integer.valueOf(i10), Integer.valueOf(i11), Integer.valueOf(i12)});
    }

    public static String b(int i10, boolean z10, int i11, int i12, int[] iArr, int i13) {
        Object[] objArr = new Object[5];
        objArr[0] = f8422b[i10];
        objArr[1] = Integer.valueOf(i11);
        objArr[2] = Integer.valueOf(i12);
        objArr[3] = Character.valueOf(z10 ? 'H' : 'L');
        objArr[4] = Integer.valueOf(i13);
        StringBuilder sb2 = new StringBuilder(l0.l("hvc1.%s%d.%X.%c%d", objArr));
        int length = iArr.length;
        while (length > 0 && iArr[length - 1] == 0) {
            length--;
        }
        for (int i14 = 0; i14 < length; i14++) {
            sb2.append(String.format(".%02X", new Object[]{Integer.valueOf(iArr[i14])}));
        }
        return sb2.toString();
    }
}
