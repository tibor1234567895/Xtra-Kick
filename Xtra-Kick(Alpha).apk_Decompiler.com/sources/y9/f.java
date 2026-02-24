package y9;

import java.io.InputStream;
import java.util.Map;
import xa.j;

public final class f {

    /* renamed from: a  reason: collision with root package name */
    public final int f17249a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f17250b;

    /* renamed from: c  reason: collision with root package name */
    public final long f17251c;

    /* renamed from: d  reason: collision with root package name */
    public final InputStream f17252d;

    /* renamed from: e  reason: collision with root package name */
    public final g f17253e;

    /* renamed from: f  reason: collision with root package name */
    public final String f17254f;

    /* renamed from: g  reason: collision with root package name */
    public final Map f17255g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f17256h;

    public f(int i10, boolean z10, long j10, InputStream inputStream, g gVar, String str, Map map, boolean z11, String str2) {
        j.g("request", gVar);
        j.g("hash", str);
        j.g("responseHeaders", map);
        this.f17249a = i10;
        this.f17250b = z10;
        this.f17251c = j10;
        this.f17252d = inputStream;
        this.f17253e = gVar;
        this.f17254f = str;
        this.f17255g = map;
        this.f17256h = z11;
    }

    public final boolean a() {
        return this.f17256h;
    }

    public final long b() {
        return this.f17251c;
    }

    public final String c() {
        return this.f17254f;
    }

    public final g d() {
        return this.f17253e;
    }

    public final boolean e() {
        return this.f17250b;
    }
}
