package p9;

import java.io.Serializable;
import java.util.LinkedHashMap;
import la.q;
import x9.a;
import y9.j;

public class v implements Serializable {

    /* renamed from: h  reason: collision with root package name */
    public long f12722h;

    /* renamed from: i  reason: collision with root package name */
    public int f12723i;

    /* renamed from: j  reason: collision with root package name */
    public final LinkedHashMap f12724j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    public r f12725k = a.f16790c;

    /* renamed from: l  reason: collision with root package name */
    public p f12726l = a.f16788a;

    /* renamed from: m  reason: collision with root package name */
    public String f12727m;

    /* renamed from: n  reason: collision with root package name */
    public d f12728n = a.f16794g;

    /* renamed from: o  reason: collision with root package name */
    public boolean f12729o = true;

    /* renamed from: p  reason: collision with root package name */
    public int f12730p;

    /* renamed from: q  reason: collision with root package name */
    public j f12731q;

    public v() {
        j.CREATOR.getClass();
        this.f12731q = j.f17263i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!xa.j.a(getClass(), obj != null ? obj.getClass() : null)) {
            return false;
        }
        if (obj != null) {
            v vVar = (v) obj;
            return this.f12722h == vVar.f12722h && this.f12723i == vVar.f12723i && !(xa.j.a(this.f12724j, vVar.f12724j) ^ true) && this.f12725k == vVar.f12725k && this.f12726l == vVar.f12726l && !(xa.j.a(this.f12727m, vVar.f12727m) ^ true) && this.f12728n == vVar.f12728n && this.f12729o == vVar.f12729o && !(xa.j.a(this.f12731q, vVar.f12731q) ^ true) && this.f12730p == vVar.f12730p;
        }
        throw new q("null cannot be cast to non-null type com.tonyodev.fetch2.RequestInfo");
    }

    public int hashCode() {
        int hashCode = this.f12724j.hashCode();
        int hashCode2 = (this.f12726l.hashCode() + ((this.f12725k.hashCode() + ((hashCode + (((Long.valueOf(this.f12722h).hashCode() * 31) + this.f12723i) * 31)) * 31)) * 31)) * 31;
        String str = this.f12727m;
        int hashCode3 = str != null ? str.hashCode() : 0;
        int hashCode4 = this.f12728n.hashCode();
        return ((this.f12731q.hashCode() + ((Boolean.valueOf(this.f12729o).hashCode() + ((hashCode4 + ((hashCode2 + hashCode3) * 31)) * 31)) * 31)) * 31) + this.f12730p;
    }

    public String toString() {
        return "RequestInfo(identifier=" + this.f12722h + ", groupId=" + this.f12723i + ", headers=" + this.f12724j + ", priority=" + this.f12725k + ", networkType=" + this.f12726l + ", tag=" + this.f12727m + ", enqueueAction=" + this.f12728n + ", downloadOnEnqueue=" + this.f12729o + ", autoRetryMaxAttempts=" + this.f12730p + ", extras=" + this.f12731q + ')';
    }
}
