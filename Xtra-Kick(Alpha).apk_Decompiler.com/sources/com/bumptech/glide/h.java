package com.bumptech.glide;

import android.content.Context;
import android.content.ContextWrapper;
import b4.e0;
import d5.v;
import d5.w;
import e5.k;
import java.util.List;
import java.util.Map;
import p1.i0;
import s5.f;
import t5.e;

public final class h extends ContextWrapper {

    /* renamed from: k  reason: collision with root package name */
    public static final b f3187k = new b();

    /* renamed from: a  reason: collision with root package name */
    public final k f3188a;

    /* renamed from: b  reason: collision with root package name */
    public final v f3189b;

    /* renamed from: c  reason: collision with root package name */
    public final e f3190c;

    /* renamed from: d  reason: collision with root package name */
    public final e0 f3191d;

    /* renamed from: e  reason: collision with root package name */
    public final List f3192e;

    /* renamed from: f  reason: collision with root package name */
    public final Map f3193f;

    /* renamed from: g  reason: collision with root package name */
    public final w f3194g;

    /* renamed from: h  reason: collision with root package name */
    public final e0 f3195h;

    /* renamed from: i  reason: collision with root package name */
    public final int f3196i;

    /* renamed from: j  reason: collision with root package name */
    public f f3197j;

    public h(Context context, k kVar, i0 i0Var, e eVar, e0 e0Var, q.e eVar2, List list, w wVar, e0 e0Var2, int i10) {
        super(context.getApplicationContext());
        this.f3188a = kVar;
        this.f3190c = eVar;
        this.f3191d = e0Var;
        this.f3192e = list;
        this.f3193f = eVar2;
        this.f3194g = wVar;
        this.f3195h = e0Var2;
        this.f3196i = i10;
        this.f3189b = new v(i0Var);
    }

    public final synchronized f a() {
        if (this.f3197j == null) {
            this.f3191d.getClass();
            f fVar = new f();
            fVar.A = true;
            this.f3197j = fVar;
        }
        return this.f3197j;
    }

    public final n b() {
        return (n) this.f3189b.get();
    }
}
