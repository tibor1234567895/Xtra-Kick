package g1;

import java.io.IOException;

public class b1 extends IOException {

    /* renamed from: h  reason: collision with root package name */
    public final boolean f6309h;

    /* renamed from: i  reason: collision with root package name */
    public final int f6310i;

    public b1(String str, Exception exc, boolean z10, int i10) {
        super(str, exc);
        this.f6309h = z10;
        this.f6310i = i10;
    }

    public static b1 a(String str, Exception exc) {
        return new b1(str, exc, true, 1);
    }

    public static b1 b(String str) {
        return new b1(str, (Exception) null, true, 4);
    }

    public static b1 c(String str) {
        return new b1(str, (Exception) null, false, 1);
    }
}
