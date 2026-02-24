package s3;

import xa.j;

public final class e implements Comparable {

    /* renamed from: h  reason: collision with root package name */
    public final int f14175h;

    /* renamed from: i  reason: collision with root package name */
    public final int f14176i;

    /* renamed from: j  reason: collision with root package name */
    public final String f14177j;

    /* renamed from: k  reason: collision with root package name */
    public final String f14178k;

    public e(int i10, int i11, String str, String str2) {
        this.f14175h = i10;
        this.f14176i = i11;
        this.f14177j = str;
        this.f14178k = str2;
    }

    public final int compareTo(Object obj) {
        e eVar = (e) obj;
        j.f("other", eVar);
        int i10 = this.f14175h - eVar.f14175h;
        if (i10 == 0) {
            return this.f14176i - eVar.f14176i;
        }
        return i10;
    }
}
