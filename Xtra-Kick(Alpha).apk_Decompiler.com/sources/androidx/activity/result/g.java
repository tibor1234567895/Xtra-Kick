package androidx.activity.result;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.p0;
import e.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public abstract class g {

    /* renamed from: a  reason: collision with root package name */
    public Random f509a = new Random();

    /* renamed from: b  reason: collision with root package name */
    public final HashMap f510b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f511c = new HashMap();

    /* renamed from: d  reason: collision with root package name */
    public final HashMap f512d = new HashMap();

    /* renamed from: e  reason: collision with root package name */
    public ArrayList f513e = new ArrayList();

    /* renamed from: f  reason: collision with root package name */
    public final transient HashMap f514f = new HashMap();

    /* renamed from: g  reason: collision with root package name */
    public final HashMap f515g = new HashMap();

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f516h = new Bundle();

    public final boolean a(int i10, int i11, Intent intent) {
        c cVar;
        String str = (String) this.f510b.get(Integer.valueOf(i10));
        if (str == null) {
            return false;
        }
        f fVar = (f) this.f514f.get(str);
        if (fVar == null || (cVar = fVar.f507a) == null || !this.f513e.contains(str)) {
            this.f515g.remove(str);
            this.f516h.putParcelable(str, new b(i11, intent));
            return true;
        }
        ((p0) cVar).k(fVar.f508b.c(i11, intent));
        this.f513e.remove(str);
        return true;
    }

    public abstract void b(int i10, b bVar, Intent intent);

    public final e c(String str, b bVar, p0 p0Var) {
        int nextInt;
        HashMap hashMap;
        HashMap hashMap2 = this.f511c;
        if (((Integer) hashMap2.get(str)) == null) {
            do {
                nextInt = this.f509a.nextInt(2147418112) + 65536;
                hashMap = this.f510b;
            } while (hashMap.containsKey(Integer.valueOf(nextInt)));
            hashMap.put(Integer.valueOf(nextInt), str);
            hashMap2.put(str, Integer.valueOf(nextInt));
        }
        this.f514f.put(str, new f(p0Var, bVar));
        HashMap hashMap3 = this.f515g;
        if (hashMap3.containsKey(str)) {
            Object obj = hashMap3.get(str);
            hashMap3.remove(str);
            p0Var.k(obj);
        }
        Bundle bundle = this.f516h;
        b bVar2 = (b) bundle.getParcelable(str);
        if (bVar2 != null) {
            bundle.remove(str);
            p0Var.k(bVar.c(bVar2.f502h, bVar2.f503i));
        }
        return new e(this, str, bVar);
    }
}
