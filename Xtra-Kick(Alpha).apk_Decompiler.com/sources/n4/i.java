package n4;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import hb.f0;
import hb.h0;
import java.util.List;
import la.v;
import pa.e;
import s4.m;
import w4.g;
import wa.p;

public final class i extends ra.i implements p {

    /* renamed from: i  reason: collision with root package name */
    public List f11676i;

    /* renamed from: j  reason: collision with root package name */
    public m f11677j;

    /* renamed from: k  reason: collision with root package name */
    public int f11678k;

    /* renamed from: l  reason: collision with root package name */
    public int f11679l;

    /* renamed from: m  reason: collision with root package name */
    public int f11680m;

    /* renamed from: n  reason: collision with root package name */
    public /* synthetic */ Object f11681n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ j f11682o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ b f11683p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ m f11684q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ List f11685r;

    /* renamed from: s  reason: collision with root package name */
    public final /* synthetic */ i4.i f11686s;

    /* renamed from: t  reason: collision with root package name */
    public final /* synthetic */ s4.i f11687t;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i(j jVar, b bVar, m mVar, List list, i4.i iVar, s4.i iVar2, e eVar) {
        super(2, eVar);
        this.f11682o = jVar;
        this.f11683p = bVar;
        this.f11684q = mVar;
        this.f11685r = list;
        this.f11686s = iVar;
        this.f11687t = iVar2;
    }

    public final e create(Object obj, e eVar) {
        i iVar = new i(this.f11682o, this.f11683p, this.f11684q, this.f11685r, this.f11686s, this.f11687t, eVar);
        iVar.f11681n = obj;
        return iVar;
    }

    public final Object g(Object obj, Object obj2) {
        return ((i) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    public final Object invokeSuspend(Object obj) {
        Bitmap bitmap;
        f0 f0Var;
        List list;
        m mVar;
        int i10;
        int i11;
        int i12 = this.f11680m;
        i4.i iVar = this.f11686s;
        b bVar = this.f11683p;
        if (i12 == 0) {
            h0.O1(obj);
            f0Var = (f0) this.f11681n;
            Drawable drawable = bVar.f11619a;
            int i13 = j.f11688d;
            this.f11682o.getClass();
            boolean z10 = drawable instanceof BitmapDrawable;
            mVar = this.f11684q;
            if (z10) {
                Bitmap bitmap2 = ((BitmapDrawable) drawable).getBitmap();
                Bitmap.Config config = bitmap2.getConfig();
                if (config == null) {
                    config = Bitmap.Config.ARGB_8888;
                }
                if (ma.p.g(w4.e.f16080a, config)) {
                    bitmap = bitmap2;
                    iVar.getClass();
                    list = this.f11685r;
                    i11 = list.size();
                    i10 = 0;
                }
            }
            g gVar = g.f16085a;
            Bitmap.Config config2 = mVar.f14277b;
            gVar.getClass();
            bitmap = g.a(drawable, config2, mVar.f14279d, mVar.f14280e, mVar.f14281f);
            iVar.getClass();
            list = this.f11685r;
            i11 = list.size();
            i10 = 0;
        } else if (i12 == 1) {
            i11 = this.f11679l;
            int i14 = this.f11678k;
            mVar = this.f11677j;
            list = this.f11676i;
            f0Var = (f0) this.f11681n;
            h0.O1(obj);
            bitmap = (Bitmap) obj;
            h0.T(f0Var.v());
            i10 = i14 + 1;
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        if (i10 >= i11) {
            iVar.getClass();
            return new b(new BitmapDrawable(this.f11687t.f14249a.getResources(), bitmap), bVar.f11620b, bVar.f11621c, bVar.f11622d);
        }
        h.y(list.get(i10));
        t4.g gVar2 = mVar.f14279d;
        this.f11681n = f0Var;
        this.f11676i = list;
        this.f11677j = mVar;
        this.f11678k = i10;
        this.f11679l = i11;
        this.f11680m = 1;
        throw null;
    }
}
