package com.tonyodev.fetch2.database;

import a6.a;
import android.content.Context;
import androidx.appcompat.widget.j3;
import java.util.HashMap;
import r3.j;
import r3.q0;
import r3.y;
import u3.l;
import v3.k;

public final class DownloadDatabase_Impl extends DownloadDatabase {

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ int f4075q = 0;

    /* renamed from: p  reason: collision with root package name */
    public volatile j3 f4076p;

    public final y e() {
        return new y(this, new HashMap(0), new HashMap(0), "requests");
    }

    public final l f(j jVar) {
        q0 q0Var = new q0(jVar, new a(this, 7, 1), "460643a974555d792b8f5a6e1a5d323c", "946eca6b182e63ebe50cf82e483715bf");
        u3.j.f15352f.getClass();
        Context context = jVar.f13697a;
        xa.j.f("context", context);
        return ((k) jVar.f13699c).a(new u3.j(context, jVar.f13698b, q0Var));
    }

    public final j3 t() {
        j3 j3Var;
        if (this.f4076p != null) {
            return this.f4076p;
        }
        synchronized (this) {
            try {
                if (this.f4076p == null) {
                    this.f4076p = new j3((DownloadDatabase) this);
                }
                j3Var = this.f4076p;
            } catch (Throwable th) {
                throw th;
            }
        }
        return j3Var;
    }
}
