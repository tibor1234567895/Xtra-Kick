package androidx.fragment.app;

import java.io.Writer;

public final class a2 extends Writer {

    /* renamed from: h  reason: collision with root package name */
    public final StringBuilder f1327h = new StringBuilder(128);

    public final void c() {
        StringBuilder sb2 = this.f1327h;
        if (sb2.length() > 0) {
            sb2.toString();
            sb2.delete(0, sb2.length());
        }
    }

    public final void close() {
        c();
    }

    public final void flush() {
        c();
    }

    public final void write(char[] cArr, int i10, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            char c10 = cArr[i10 + i12];
            if (c10 == 10) {
                c();
            } else {
                this.f1327h.append(c10);
            }
        }
    }
}
