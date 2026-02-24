package com.google.android.material.datepicker;

import java.util.Calendar;

public final class b {

    /* renamed from: f  reason: collision with root package name */
    public static final long f3736f;

    /* renamed from: g  reason: collision with root package name */
    public static final long f3737g;

    /* renamed from: a  reason: collision with root package name */
    public final long f3738a = f3736f;

    /* renamed from: b  reason: collision with root package name */
    public final long f3739b = f3737g;

    /* renamed from: c  reason: collision with root package name */
    public Long f3740c;

    /* renamed from: d  reason: collision with root package name */
    public final int f3741d;

    /* renamed from: e  reason: collision with root package name */
    public final c f3742e = new f(Long.MIN_VALUE);

    static {
        u u10 = u.u(1900, 0);
        Calendar d10 = c0.d((Calendar) null);
        d10.setTimeInMillis(u10.f3796m);
        f3736f = c0.b(d10).getTimeInMillis();
        u u11 = u.u(2100, 11);
        Calendar d11 = c0.d((Calendar) null);
        d11.setTimeInMillis(u11.f3796m);
        f3737g = c0.b(d11).getTimeInMillis();
    }

    public b() {
    }

    public b(d dVar) {
        this.f3738a = dVar.f3744h.f3796m;
        this.f3739b = dVar.f3745i.f3796m;
        this.f3740c = Long.valueOf(dVar.f3747k.f3796m);
        this.f3741d = dVar.f3748l;
        this.f3742e = dVar.f3746j;
    }
}
