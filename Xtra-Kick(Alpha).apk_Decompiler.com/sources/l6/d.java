package l6;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.c0;
import androidx.fragment.app.t;
import g.i;
import g.l;
import g.m;
import xa.j;

public final class d extends t {

    /* renamed from: u0  reason: collision with root package name */
    public static final b f9592u0 = new b(0);

    /* renamed from: t0  reason: collision with root package name */
    public c f9593t0;

    public final void M(Context context) {
        c cVar;
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        if (c0Var instanceof c) {
            cVar = (c) c0Var;
        } else {
            cVar = null;
        }
        this.f9593t0 = cVar;
    }

    public final Dialog n0(Bundle bundle) {
        Bundle e02 = e0();
        l lVar = new l(f0());
        String string = e02.getString("title");
        if (string != null) {
            lVar.setTitle(string);
        }
        String string2 = e02.getString("message");
        i iVar = lVar.f6176a;
        if (string2 != null) {
            iVar.f6086f = string2;
        }
        lVar.b(e02.getString("positive"), new a(this, e02, 0));
        String string3 = e02.getString("negative");
        if (string3 != null) {
            lVar.a(string3, new a(this, e02, 1));
        }
        String string4 = e02.getString("neutral");
        if (string4 != null) {
            a aVar = new a(this, e02, 2);
            iVar.f6091k = string4;
            iVar.f6092l = aVar;
        }
        iVar.f6093m = e02.getBoolean("cancelable");
        m create = lVar.create();
        j.e("builder.create()", create);
        return create;
    }
}
