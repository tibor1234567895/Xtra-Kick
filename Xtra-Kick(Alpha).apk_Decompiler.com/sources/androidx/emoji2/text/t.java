package androidx.emoji2.text;

import i0.m;
import i0.n;

public final class t implements Runnable {
    public final void run() {
        boolean z10;
        try {
            int i10 = n.f7952a;
            m.a("EmojiCompat.EmojiCompatInitializer.run");
            if (p.f1267j != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                p.a().c();
            }
            m.b();
        } catch (Throwable th) {
            int i11 = n.f7952a;
            m.b();
            throw th;
        }
    }
}
