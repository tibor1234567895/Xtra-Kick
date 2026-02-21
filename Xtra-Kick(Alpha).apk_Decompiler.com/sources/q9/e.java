package q9;

import android.os.Parcel;
import android.support.v4.media.h;
import java.util.Calendar;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import la.q;
import ma.j0;
import p9.b;
import p9.d;
import p9.f;
import p9.p;
import p9.r;
import p9.x;
import x9.a;
import y9.j;

public final class e implements b {
    public static final d CREATOR = new d(0);
    public int A;
    public long B;
    public long C;

    /* renamed from: h  reason: collision with root package name */
    public int f13433h;

    /* renamed from: i  reason: collision with root package name */
    public String f13434i = "";

    /* renamed from: j  reason: collision with root package name */
    public String f13435j = "";

    /* renamed from: k  reason: collision with root package name */
    public String f13436k = "";

    /* renamed from: l  reason: collision with root package name */
    public int f13437l;

    /* renamed from: m  reason: collision with root package name */
    public r f13438m = a.f16790c;

    /* renamed from: n  reason: collision with root package name */
    public Map f13439n = new LinkedHashMap();

    /* renamed from: o  reason: collision with root package name */
    public long f13440o;

    /* renamed from: p  reason: collision with root package name */
    public long f13441p = -1;

    /* renamed from: q  reason: collision with root package name */
    public x f13442q = a.f16792e;

    /* renamed from: r  reason: collision with root package name */
    public f f13443r = a.f16791d;

    /* renamed from: s  reason: collision with root package name */
    public p f13444s = a.f16788a;

    /* renamed from: t  reason: collision with root package name */
    public long f13445t;

    /* renamed from: u  reason: collision with root package name */
    public String f13446u;

    /* renamed from: v  reason: collision with root package name */
    public d f13447v;

    /* renamed from: w  reason: collision with root package name */
    public long f13448w;

    /* renamed from: x  reason: collision with root package name */
    public boolean f13449x;

    /* renamed from: y  reason: collision with root package name */
    public j f13450y;

    /* renamed from: z  reason: collision with root package name */
    public int f13451z;

    public e() {
        Calendar instance = Calendar.getInstance();
        xa.j.b("Calendar.getInstance()", instance);
        this.f13445t = instance.getTimeInMillis();
        this.f13447v = d.REPLACE_EXISTING;
        this.f13449x = true;
        j.CREATOR.getClass();
        this.f13450y = j.f17263i;
        this.B = -1;
        this.C = -1;
    }

    public final void A(long j10) {
        this.f13440o = j10;
    }

    public final void B(long j10) {
        this.C = j10;
    }

    public final void C(d dVar) {
        xa.j.g("<set-?>", dVar);
        this.f13447v = dVar;
    }

    public final void D(f fVar) {
        xa.j.g("<set-?>", fVar);
        this.f13443r = fVar;
    }

    public final void E(long j10) {
        this.B = j10;
    }

    public final void F(j jVar) {
        xa.j.g("<set-?>", jVar);
        this.f13450y = jVar;
    }

    public final void G(String str) {
        xa.j.g("<set-?>", str);
        this.f13436k = str;
    }

    public final void H(String str) {
        xa.j.g("<set-?>", str);
        this.f13434i = str;
    }

    public final void I(p pVar) {
        xa.j.g("<set-?>", pVar);
        this.f13444s = pVar;
    }

    public final void J(r rVar) {
        xa.j.g("<set-?>", rVar);
        this.f13438m = rVar;
    }

    public final void K(x xVar) {
        xa.j.g("<set-?>", xVar);
        this.f13442q = xVar;
    }

    public final void L(long j10) {
        this.f13441p = j10;
    }

    public final void M(String str) {
        xa.j.g("<set-?>", str);
        this.f13435j = str;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        Class<?> cls;
        if (this == obj) {
            return true;
        }
        Class<e> cls2 = e.class;
        if (obj != null) {
            cls = obj.getClass();
        } else {
            cls = null;
        }
        if (!xa.j.a(cls2, cls)) {
            return false;
        }
        if (obj != null) {
            e eVar = (e) obj;
            if (this.f13433h == eVar.f13433h && !(!xa.j.a(this.f13434i, eVar.f13434i)) && !(!xa.j.a(this.f13435j, eVar.f13435j)) && !(!xa.j.a(this.f13436k, eVar.f13436k)) && this.f13437l == eVar.f13437l && this.f13438m == eVar.f13438m && !(!xa.j.a(this.f13439n, eVar.f13439n)) && this.f13440o == eVar.f13440o && this.f13441p == eVar.f13441p && this.f13442q == eVar.f13442q && this.f13443r == eVar.f13443r && this.f13444s == eVar.f13444s && this.f13445t == eVar.f13445t && !(!xa.j.a(this.f13446u, eVar.f13446u)) && this.f13447v == eVar.f13447v && this.f13448w == eVar.f13448w && this.f13449x == eVar.f13449x && !(!xa.j.a(this.f13450y, eVar.f13450y)) && this.B == eVar.B && this.C == eVar.C && this.f13451z == eVar.f13451z && this.A == eVar.A) {
                return true;
            }
            return false;
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2.database.DownloadInfo");
    }

    public final int hashCode() {
        int i10;
        int e10 = h.e(this.f13435j, h.e(this.f13434i, this.f13433h * 31, 31), 31);
        int hashCode = this.f13438m.hashCode();
        int hashCode2 = this.f13439n.hashCode();
        int hashCode3 = Long.valueOf(this.f13440o).hashCode();
        int hashCode4 = Long.valueOf(this.f13441p).hashCode();
        int hashCode5 = this.f13442q.hashCode();
        int hashCode6 = this.f13443r.hashCode();
        int hashCode7 = this.f13444s.hashCode();
        int hashCode8 = (Long.valueOf(this.f13445t).hashCode() + ((hashCode7 + ((hashCode6 + ((hashCode5 + ((hashCode4 + ((hashCode3 + ((hashCode2 + ((hashCode + ((h.e(this.f13436k, e10, 31) + this.f13437l) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31;
        String str = this.f13446u;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        int hashCode9 = this.f13447v.hashCode();
        int hashCode10 = Long.valueOf(this.f13448w).hashCode();
        int hashCode11 = Boolean.valueOf(this.f13449x).hashCode();
        int hashCode12 = this.f13450y.hashCode();
        int hashCode13 = Long.valueOf(this.B).hashCode();
        int hashCode14 = Long.valueOf(this.C).hashCode();
        int hashCode15 = Integer.valueOf(this.f13451z).hashCode();
        return Integer.valueOf(this.A).hashCode() + ((hashCode15 + ((hashCode14 + ((hashCode13 + ((hashCode12 + ((hashCode11 + ((hashCode10 + ((hashCode9 + ((hashCode8 + i10) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31)) * 31);
    }

    public final String toString() {
        return "DownloadInfo(id=" + this.f13433h + ", namespace='" + this.f13434i + "', url='" + this.f13435j + "', file='" + this.f13436k + "', group=" + this.f13437l + ", priority=" + this.f13438m + ", headers=" + this.f13439n + ", downloaded=" + this.f13440o + ", total=" + this.f13441p + ", status=" + this.f13442q + ", error=" + this.f13443r + ", networkType=" + this.f13444s + ", created=" + this.f13445t + ", tag=" + this.f13446u + ", enqueueAction=" + this.f13447v + ", identifier=" + this.f13448w + ", downloadOnEnqueue=" + this.f13449x + ", extras=" + this.f13450y + ", autoRetryMaxAttempts=" + this.f13451z + ", autoRetryAttempts=" + this.A + ", etaInMilliSeconds=" + this.B + ", downloadedBytesPerSecond=" + this.C + ')';
    }

    public final long u() {
        return this.f13440o;
    }

    public final long v() {
        return this.C;
    }

    public final long w() {
        return this.B;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        xa.j.g("dest", parcel);
        parcel.writeInt(this.f13433h);
        parcel.writeString(this.f13434i);
        parcel.writeString(this.f13435j);
        parcel.writeString(this.f13436k);
        parcel.writeInt(this.f13437l);
        parcel.writeInt(this.f13438m.f12715h);
        parcel.writeSerializable(new HashMap(this.f13439n));
        parcel.writeLong(this.f13440o);
        parcel.writeLong(this.f13441p);
        parcel.writeInt(this.f13442q.f12744h);
        parcel.writeInt(this.f13443r.f12655h);
        parcel.writeInt(this.f13444s.f12709h);
        parcel.writeLong(this.f13445t);
        parcel.writeString(this.f13446u);
        parcel.writeInt(this.f13447v.f12636h);
        parcel.writeLong(this.f13448w);
        parcel.writeInt(this.f13449x ? 1 : 0);
        parcel.writeLong(this.B);
        parcel.writeLong(this.C);
        parcel.writeSerializable(new HashMap(j0.g(this.f13450y.f17264h)));
        parcel.writeInt(this.f13451z);
        parcel.writeInt(this.A);
    }

    public final int x() {
        return this.f13433h;
    }

    public final int y() {
        long j10 = this.f13440o;
        long j11 = this.f13441p;
        if (j11 < 1) {
            return -1;
        }
        if (j10 < 1) {
            return 0;
        }
        if (j10 >= j11) {
            return 100;
        }
        return (int) ((((double) j10) / ((double) j11)) * ((double) 100));
    }

    public final long z() {
        return this.f13441p;
    }
}
