package j3;

import android.os.Bundle;
import db.b;
import hb.h0;
import java.lang.reflect.Method;
import java.util.Arrays;
import la.e;
import wa.a;

public final class j implements e {

    /* renamed from: h  reason: collision with root package name */
    public final b f8568h;

    /* renamed from: i  reason: collision with root package name */
    public final a f8569i;

    /* renamed from: j  reason: collision with root package name */
    public i f8570j;

    public j(xa.e eVar, a aVar) {
        this.f8568h = eVar;
        this.f8569i = aVar;
    }

    public final Object getValue() {
        i iVar = this.f8570j;
        if (iVar != null) {
            return iVar;
        }
        Bundle bundle = (Bundle) this.f8569i.b();
        q.e eVar = k.f8575b;
        b bVar = this.f8568h;
        Method method = (Method) eVar.getOrDefault(bVar, (Object) null);
        if (method == null) {
            method = h0.s0(bVar).getMethod("fromBundle", (Class[]) Arrays.copyOf(k.f8574a, 1));
            eVar.put(bVar, method);
            xa.j.e("navArgsClass.java.getMet…hod\n                    }", method);
        }
        Object invoke = method.invoke((Object) null, new Object[]{bundle});
        xa.j.d("null cannot be cast to non-null type Args of androidx.navigation.NavArgsLazy", invoke);
        i iVar2 = (i) invoke;
        this.f8570j = iVar2;
        return iVar2;
    }
}
