package m1;

import android.content.Context;
import android.os.Looper;
import c9.j;
import c9.w;
import f3.a;
import g1.h;
import j1.d;
import j1.d0;
import j1.l0;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public final Context f10473a;

    /* renamed from: b  reason: collision with root package name */
    public final d0 f10474b;

    /* renamed from: c  reason: collision with root package name */
    public final w f10475c;

    /* renamed from: d  reason: collision with root package name */
    public final w f10476d;

    /* renamed from: e  reason: collision with root package name */
    public final w f10477e;

    /* renamed from: f  reason: collision with root package name */
    public w f10478f;

    /* renamed from: g  reason: collision with root package name */
    public final w f10479g;

    /* renamed from: h  reason: collision with root package name */
    public final j f10480h;

    /* renamed from: i  reason: collision with root package name */
    public final Looper f10481i;

    /* renamed from: j  reason: collision with root package name */
    public final h f10482j;

    /* renamed from: k  reason: collision with root package name */
    public final int f10483k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f10484l;

    /* renamed from: m  reason: collision with root package name */
    public final p1 f10485m;

    /* renamed from: n  reason: collision with root package name */
    public long f10486n;

    /* renamed from: o  reason: collision with root package name */
    public long f10487o;

    /* renamed from: p  reason: collision with root package name */
    public final j f10488p;

    /* renamed from: q  reason: collision with root package name */
    public final long f10489q;

    /* renamed from: r  reason: collision with root package name */
    public final long f10490r;

    /* renamed from: s  reason: collision with root package name */
    public final boolean f10491s;

    /* renamed from: t  reason: collision with root package name */
    public boolean f10492t;

    public t(Context context) {
        Context context2 = context;
        r rVar = new r(context2, 0);
        r rVar2 = new r(context2, 1);
        r rVar3 = new r(context2, 2);
        s sVar = new s(0);
        r rVar4 = new r(context2, 3);
        a aVar = new a(0);
        context.getClass();
        this.f10473a = context2;
        this.f10475c = rVar;
        this.f10476d = rVar2;
        this.f10477e = rVar3;
        this.f10478f = sVar;
        this.f10479g = rVar4;
        this.f10480h = aVar;
        int i10 = l0.f8453a;
        Looper myLooper = Looper.myLooper();
        this.f10481i = myLooper == null ? Looper.getMainLooper() : myLooper;
        this.f10482j = h.f6386n;
        this.f10483k = 1;
        this.f10484l = true;
        this.f10485m = p1.f10435c;
        this.f10486n = 5000;
        this.f10487o = 15000;
        i iVar = new i();
        this.f10488p = new j(iVar.f10262a, iVar.f10263b, iVar.f10264c, iVar.f10265d, iVar.f10266e, iVar.f10267f, iVar.f10268g);
        this.f10474b = d.f8420a;
        this.f10489q = 500;
        this.f10490r = 2000;
        this.f10491s = true;
    }
}
