package t9;

import android.os.Handler;
import android.os.Looper;
import java.util.LinkedHashMap;
import la.v;
import xa.j;

public final class p {

    /* renamed from: a  reason: collision with root package name */
    public static final Object f14896a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public static final LinkedHashMap f14897b = new LinkedHashMap();

    /* renamed from: c  reason: collision with root package name */
    public static final Handler f14898c = new Handler(Looper.getMainLooper());

    /* renamed from: d  reason: collision with root package name */
    public static final p f14899d = new p();

    private p() {
    }

    public static void a(String str) {
        j.g("namespace", str);
        synchronized (f14896a) {
            LinkedHashMap linkedHashMap = f14897b;
            n nVar = (n) linkedHashMap.get(str);
            if (nVar != null) {
                nVar.f14887a.b();
                if (nVar.f14887a.f() == 0) {
                    nVar.f14887a.a();
                    nVar.f14893g.b();
                    nVar.f14890d.l();
                    nVar.f14888b.close();
                    nVar.f14892f.b();
                    nVar.f14894h.c();
                    linkedHashMap.remove(str);
                }
            }
            v vVar = v.f9814a;
        }
    }
}
