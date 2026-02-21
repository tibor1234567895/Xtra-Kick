package a2;

import android.os.SystemClock;
import j1.d0;

public final /* synthetic */ class f {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ h f28a;

    public /* synthetic */ f(h hVar) {
        this.f28a = hVar;
    }

    public final void a(int i10) {
        int i11;
        h hVar = this.f28a;
        synchronized (hVar) {
            int i12 = hVar.f49i;
            if (i12 == 0 || hVar.f45e) {
                if (i12 != i10) {
                    hVar.f49i = i10;
                    if (!(i10 == 1 || i10 == 0)) {
                        if (i10 != 8) {
                            hVar.f52l = hVar.b(i10);
                            ((d0) hVar.f44d).getClass();
                            long elapsedRealtime = SystemClock.elapsedRealtime();
                            if (hVar.f46f > 0) {
                                i11 = (int) (elapsedRealtime - hVar.f47g);
                            } else {
                                i11 = 0;
                            }
                            hVar.c(i11, hVar.f48h, hVar.f52l);
                            hVar.f47g = elapsedRealtime;
                            hVar.f48h = 0;
                            hVar.f51k = 0;
                            hVar.f50j = 0;
                            u uVar = hVar.f43c;
                            uVar.f89b.clear();
                            uVar.f91d = -1;
                            uVar.f92e = 0;
                            uVar.f93f = 0;
                        }
                    }
                }
            }
        }
    }
}
