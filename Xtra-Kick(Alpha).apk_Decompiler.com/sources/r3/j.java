package r3;

import android.content.Context;
import android.content.Intent;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import q0.f;
import u3.k;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f13697a;

    /* renamed from: b  reason: collision with root package name */
    public final String f13698b;

    /* renamed from: c  reason: collision with root package name */
    public final k f13699c;

    /* renamed from: d  reason: collision with root package name */
    public final l0 f13700d;

    /* renamed from: e  reason: collision with root package name */
    public final List f13701e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f13702f = false;

    /* renamed from: g  reason: collision with root package name */
    public final int f13703g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f13704h;

    /* renamed from: i  reason: collision with root package name */
    public final Executor f13705i;

    /* renamed from: j  reason: collision with root package name */
    public final Intent f13706j;

    /* renamed from: k  reason: collision with root package name */
    public final boolean f13707k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f13708l;

    /* renamed from: m  reason: collision with root package name */
    public final Set f13709m;

    /* renamed from: n  reason: collision with root package name */
    public final Callable f13710n;

    /* renamed from: o  reason: collision with root package name */
    public final List f13711o;

    /* renamed from: p  reason: collision with root package name */
    public final List f13712p;

    public j(Context context, String str, v3.k kVar, l0 l0Var, ArrayList arrayList, int i10, Executor executor, Executor executor2, boolean z10, boolean z11, LinkedHashSet linkedHashSet, ArrayList arrayList2, ArrayList arrayList3) {
        xa.j.f("context", context);
        xa.j.f("migrationContainer", l0Var);
        f.j("journalMode", i10);
        xa.j.f("typeConverters", arrayList2);
        xa.j.f("autoMigrationSpecs", arrayList3);
        this.f13697a = context;
        this.f13698b = str;
        this.f13699c = kVar;
        this.f13700d = l0Var;
        this.f13701e = arrayList;
        this.f13703g = i10;
        this.f13704h = executor;
        this.f13705i = executor2;
        this.f13706j = null;
        this.f13707k = z10;
        this.f13708l = z11;
        this.f13709m = linkedHashSet;
        this.f13710n = null;
        this.f13711o = arrayList2;
        this.f13712p = arrayList3;
    }

    public final boolean a(int i10, int i11) {
        Set set;
        return (!(i10 > i11) || !this.f13708l) && this.f13707k && ((set = this.f13709m) == null || !set.contains(Integer.valueOf(i10)));
    }
}
