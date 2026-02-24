package r1;

import g1.u;

public abstract class j implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public final String f13566h;

    /* renamed from: i  reason: collision with root package name */
    public final i f13567i;

    /* renamed from: j  reason: collision with root package name */
    public final long f13568j;

    /* renamed from: k  reason: collision with root package name */
    public final int f13569k;

    /* renamed from: l  reason: collision with root package name */
    public final long f13570l;

    /* renamed from: m  reason: collision with root package name */
    public final u f13571m;

    /* renamed from: n  reason: collision with root package name */
    public final String f13572n;

    /* renamed from: o  reason: collision with root package name */
    public final String f13573o;

    /* renamed from: p  reason: collision with root package name */
    public final long f13574p;

    /* renamed from: q  reason: collision with root package name */
    public final long f13575q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f13576r;

    public j(String str, i iVar, long j10, int i10, long j11, u uVar, String str2, String str3, long j12, long j13, boolean z10) {
        this.f13566h = str;
        this.f13567i = iVar;
        this.f13568j = j10;
        this.f13569k = i10;
        this.f13570l = j11;
        this.f13571m = uVar;
        this.f13572n = str2;
        this.f13573o = str3;
        this.f13574p = j12;
        this.f13575q = j13;
        this.f13576r = z10;
    }

    public final int compareTo(Object obj) {
        Long l10 = (Long) obj;
        long longValue = l10.longValue();
        long j10 = this.f13570l;
        if (j10 > longValue) {
            return 1;
        }
        if (j10 < l10.longValue()) {
            return -1;
        }
        return 0;
    }
}
