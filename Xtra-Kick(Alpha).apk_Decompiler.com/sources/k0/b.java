package k0;

public final class b {

    /* renamed from: e  reason: collision with root package name */
    public static final byte[] f8937e = new byte[1792];

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f8938a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8939b;

    /* renamed from: c  reason: collision with root package name */
    public int f8940c;

    /* renamed from: d  reason: collision with root package name */
    public char f8941d;

    static {
        for (int i10 = 0; i10 < 1792; i10++) {
            f8937e[i10] = Character.getDirectionality(i10);
        }
    }

    public b(CharSequence charSequence) {
        this.f8938a = charSequence;
        this.f8939b = charSequence.length();
    }

    public final byte a() {
        CharSequence charSequence = this.f8938a;
        char charAt = charSequence.charAt(this.f8940c - 1);
        this.f8941d = charAt;
        if (Character.isLowSurrogate(charAt)) {
            int codePointBefore = Character.codePointBefore(charSequence, this.f8940c);
            this.f8940c -= Character.charCount(codePointBefore);
            return Character.getDirectionality(codePointBefore);
        }
        this.f8940c--;
        char c10 = this.f8941d;
        if (c10 < 1792) {
            return f8937e[c10];
        }
        return Character.getDirectionality(c10);
    }
}
