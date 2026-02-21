package p9;

import android.content.Context;
import la.q;
import y9.b;
import y9.h;
import y9.l;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final Context f12676a;

    /* renamed from: b  reason: collision with root package name */
    public final String f12677b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12678c;

    /* renamed from: d  reason: collision with root package name */
    public final long f12679d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f12680e;

    /* renamed from: f  reason: collision with root package name */
    public final h f12681f;

    /* renamed from: g  reason: collision with root package name */
    public final p f12682g;

    /* renamed from: h  reason: collision with root package name */
    public final l f12683h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f12684i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f12685j;

    /* renamed from: k  reason: collision with root package name */
    public final k f12686k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f12687l;

    /* renamed from: m  reason: collision with root package name */
    public final b f12688m;

    /* renamed from: n  reason: collision with root package name */
    public final s f12689n;

    /* renamed from: o  reason: collision with root package name */
    public final long f12690o;

    /* renamed from: p  reason: collision with root package name */
    public final boolean f12691p;

    /* renamed from: q  reason: collision with root package name */
    public final int f12692q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f12693r;

    public j(Context context, String str, int i10, long j10, boolean z10, h hVar, p pVar, l lVar, boolean z11, boolean z12, k kVar, boolean z13, b bVar, s sVar, long j11, boolean z14, int i11, boolean z15) {
        this.f12676a = context;
        this.f12677b = str;
        this.f12678c = i10;
        this.f12679d = j10;
        this.f12680e = z10;
        this.f12681f = hVar;
        this.f12682g = pVar;
        this.f12683h = lVar;
        this.f12684i = z11;
        this.f12685j = z12;
        this.f12686k = kVar;
        this.f12687l = z13;
        this.f12688m = bVar;
        this.f12689n = sVar;
        this.f12690o = j11;
        this.f12691p = z14;
        this.f12692q = i11;
        this.f12693r = z15;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!xa.j.a(j.class, obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            j jVar = (j) obj;
            return !(xa.j.a(this.f12676a, jVar.f12676a) ^ true) && !(xa.j.a(this.f12677b, jVar.f12677b) ^ true) && this.f12678c == jVar.f12678c && this.f12679d == jVar.f12679d && this.f12680e == jVar.f12680e && !(xa.j.a(this.f12681f, jVar.f12681f) ^ true) && this.f12682g == jVar.f12682g && !(xa.j.a(this.f12683h, jVar.f12683h) ^ true) && this.f12684i == jVar.f12684i && this.f12685j == jVar.f12685j && !(xa.j.a(this.f12686k, jVar.f12686k) ^ true) && this.f12687l == jVar.f12687l && !(xa.j.a(this.f12688m, jVar.f12688m) ^ true) && !(xa.j.a((Object) null, (Object) null) ^ true) && !(xa.j.a((Object) null, (Object) null) ^ true) && !(xa.j.a((Object) null, (Object) null) ^ true) && this.f12689n == jVar.f12689n && !(xa.j.a((Object) null, (Object) null) ^ true) && this.f12690o == jVar.f12690o && this.f12691p == jVar.f12691p && this.f12692q == jVar.f12692q && this.f12693r == jVar.f12693r && !(xa.j.a((Object) null, (Object) null) ^ true);
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2.FetchConfiguration");
    }

    public final int hashCode() {
        String str = this.f12677b;
        int hashCode = Long.valueOf(this.f12679d).hashCode();
        int hashCode2 = Boolean.valueOf(this.f12680e).hashCode();
        int hashCode3 = this.f12681f.hashCode();
        int hashCode4 = this.f12682g.hashCode();
        int hashCode5 = this.f12683h.hashCode();
        int hashCode6 = Boolean.valueOf(this.f12684i).hashCode();
        int hashCode7 = Boolean.valueOf(this.f12685j).hashCode();
        int hashCode8 = this.f12686k.hashCode();
        int hashCode9 = Boolean.FALSE.hashCode();
        int hashCode10 = Boolean.valueOf(this.f12687l).hashCode();
        int hashCode11 = this.f12688m.hashCode();
        int hashCode12 = this.f12689n.hashCode();
        int hashCode13 = Long.valueOf(this.f12690o).hashCode();
        int hashCode14 = Boolean.valueOf(this.f12691p).hashCode();
        int hashCode15 = Integer.valueOf(this.f12692q).hashCode();
        return Boolean.valueOf(this.f12693r).hashCode() + ((hashCode15 + ((hashCode14 + ((hashCode13 + ((hashCode12 + ((hashCode11 + ((hashCode10 + ((hashCode9 + ((hashCode8 + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((android.support.v4.media.h.e(str, this.f12676a.hashCode() * 31, 31) + this.f12678c) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("FetchConfiguration(appContext=");
        sb2.append(this.f12676a);
        sb2.append(", namespace='");
        sb2.append(this.f12677b);
        sb2.append("', concurrentLimit=");
        sb2.append(this.f12678c);
        sb2.append(", progressReportingIntervalMillis=");
        sb2.append(this.f12679d);
        sb2.append(", loggingEnabled=");
        sb2.append(this.f12680e);
        sb2.append(", httpDownloader=");
        sb2.append(this.f12681f);
        sb2.append(", globalNetworkType=");
        sb2.append(this.f12682g);
        sb2.append(", logger=");
        sb2.append(this.f12683h);
        sb2.append(", autoStart=");
        sb2.append(this.f12684i);
        sb2.append(", retryOnNetworkGain=");
        sb2.append(this.f12685j);
        sb2.append(", fileServerDownloader=");
        sb2.append(this.f12686k);
        sb2.append(", hashCheckingEnabled=false, fileExistChecksEnabled=");
        sb2.append(this.f12687l);
        sb2.append(", storageResolver=");
        sb2.append(this.f12688m);
        sb2.append(", fetchNotificationManager=null, fetchDatabaseManager=null, backgroundHandler=null, prioritySort=");
        sb2.append(this.f12689n);
        sb2.append(", internetCheckUrl=null, activeDownloadsCheckInterval=");
        sb2.append(this.f12690o);
        sb2.append(", createFileOnEnqueue=");
        sb2.append(this.f12691p);
        sb2.append(", preAllocateFileOnCreation=");
        sb2.append(this.f12693r);
        sb2.append(", maxAutoRetryAttempts=");
        return android.support.v4.media.h.o(sb2, this.f12692q, ", fetchHandler=null)");
    }
}
