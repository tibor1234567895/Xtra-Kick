package j3;

import android.support.v4.media.h;
import java.util.LinkedHashMap;
import xa.j;

public final class q2 {

    /* renamed from: b  reason: collision with root package name */
    public static final p2 f8656b = new p2(0);

    /* renamed from: c  reason: collision with root package name */
    public static final LinkedHashMap f8657c = new LinkedHashMap();

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f8658a = new LinkedHashMap();

    public final void a(o2 o2Var) {
        boolean z10;
        Class<?> cls = o2Var.getClass();
        f8656b.getClass();
        String a10 = p2.a(cls);
        if (p2.b(a10)) {
            LinkedHashMap linkedHashMap = this.f8658a;
            o2 o2Var2 = (o2) linkedHashMap.get(a10);
            if (!j.a(o2Var2, o2Var)) {
                if (o2Var2 == null || !o2Var2.f8649b) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!(!z10)) {
                    throw new IllegalStateException(("Navigator " + o2Var + " is replacing an already attached " + o2Var2).toString());
                } else if (!o2Var.f8649b) {
                    o2 o2Var3 = (o2) linkedHashMap.put(a10, o2Var);
                } else {
                    throw new IllegalStateException(("Navigator " + o2Var + " is already attached to another NavController").toString());
                }
            }
        } else {
            throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
        }
    }

    public final o2 b(String str) {
        j.f("name", str);
        f8656b.getClass();
        if (p2.b(str)) {
            o2 o2Var = (o2) this.f8658a.get(str);
            if (o2Var != null) {
                return o2Var;
            }
            throw new IllegalStateException(h.n("Could not find Navigator with name \"", str, "\". You must call NavController.addNavigator() for each navigation type."));
        }
        throw new IllegalArgumentException("navigator name cannot be an empty string".toString());
    }
}
