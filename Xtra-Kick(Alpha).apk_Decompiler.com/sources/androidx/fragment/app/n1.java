package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public final class n1 {

    /* renamed from: a  reason: collision with root package name */
    public final ArrayList f1513a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f1514b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f1515c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public h1 f1516d;

    public final void a(c0 c0Var) {
        if (!this.f1513a.contains(c0Var)) {
            synchronized (this.f1513a) {
                this.f1513a.add(c0Var);
            }
            c0Var.f1362r = true;
            return;
        }
        throw new IllegalStateException("Fragment already added: " + c0Var);
    }

    public final c0 b(String str) {
        m1 m1Var = (m1) this.f1514b.get(str);
        if (m1Var != null) {
            return m1Var.f1502c;
        }
        return null;
    }

    public final c0 c(String str) {
        for (m1 m1Var : this.f1514b.values()) {
            if (m1Var != null) {
                c0 c0Var = m1Var.f1502c;
                if (!str.equals(c0Var.f1356l)) {
                    c0Var = c0Var.B.f1373c.c(str);
                }
                if (c0Var != null) {
                    return c0Var;
                }
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (m1 m1Var : this.f1514b.values()) {
            if (m1Var != null) {
                arrayList.add(m1Var);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (m1 m1Var : this.f1514b.values()) {
            arrayList.add(m1Var != null ? m1Var.f1502c : null);
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.f1513a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.f1513a) {
            arrayList = new ArrayList(this.f1513a);
        }
        return arrayList;
    }

    public final void g(m1 m1Var) {
        boolean z10;
        c0 c0Var = m1Var.f1502c;
        String str = c0Var.f1356l;
        HashMap hashMap = this.f1514b;
        if (hashMap.get(str) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            hashMap.put(c0Var.f1356l, m1Var);
            if (c1.I(2)) {
                c0Var.toString();
            }
        }
    }

    public final void h(m1 m1Var) {
        c0 c0Var = m1Var.f1502c;
        if (c0Var.I) {
            this.f1516d.e(c0Var);
        }
        HashMap hashMap = this.f1514b;
        if (hashMap.get(c0Var.f1356l) == m1Var && ((m1) hashMap.put(c0Var.f1356l, (Object) null)) != null && c1.I(2)) {
            c0Var.toString();
        }
    }

    public final Bundle i(Bundle bundle, String str) {
        HashMap hashMap = this.f1515c;
        return (Bundle) (bundle != null ? hashMap.put(str, bundle) : hashMap.remove(str));
    }
}
