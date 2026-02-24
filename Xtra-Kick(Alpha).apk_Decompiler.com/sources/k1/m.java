package k1;

import android.net.Uri;
import android.support.v4.media.h;
import g1.t0;
import j1.a;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public final class m {

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f9021k = 0;

    /* renamed from: a  reason: collision with root package name */
    public final Uri f9022a;

    /* renamed from: b  reason: collision with root package name */
    public final long f9023b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9024c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f9025d;

    /* renamed from: e  reason: collision with root package name */
    public final Map f9026e;

    /* renamed from: f  reason: collision with root package name */
    public final long f9027f;

    /* renamed from: g  reason: collision with root package name */
    public final long f9028g;

    /* renamed from: h  reason: collision with root package name */
    public final String f9029h;

    /* renamed from: i  reason: collision with root package name */
    public final int f9030i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f9031j;

    static {
        t0.a("media3.datasource");
    }

    public m(Uri uri, long j10, int i10, byte[] bArr, Map map, long j11, long j12, String str, int i11, Object obj) {
        long j13 = j10;
        byte[] bArr2 = bArr;
        long j14 = j11;
        long j15 = j12;
        boolean z10 = true;
        a.b(j13 + j14 >= 0);
        a.b(j14 >= 0);
        if (j15 <= 0 && j15 != -1) {
            z10 = false;
        }
        a.b(z10);
        this.f9022a = uri;
        this.f9023b = j13;
        this.f9024c = i10;
        this.f9025d = (bArr2 == null || bArr2.length == 0) ? null : bArr2;
        this.f9026e = Collections.unmodifiableMap(new HashMap(map));
        this.f9027f = j14;
        this.f9028g = j15;
        this.f9029h = str;
        this.f9030i = i11;
        this.f9031j = obj;
    }

    public final String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder("DataSpec[");
        int i10 = this.f9024c;
        if (i10 == 1) {
            str = "GET";
        } else if (i10 == 2) {
            str = "POST";
        } else if (i10 == 3) {
            str = "HEAD";
        } else {
            throw new IllegalStateException();
        }
        sb2.append(str);
        sb2.append(" ");
        sb2.append(this.f9022a);
        sb2.append(", ");
        sb2.append(this.f9027f);
        sb2.append(", ");
        sb2.append(this.f9028g);
        sb2.append(", ");
        sb2.append(this.f9029h);
        sb2.append(", ");
        return h.o(sb2, this.f9030i, "]");
    }

    public m(Uri uri, long j10, long j11) {
        this(uri, 0, 1, (byte[]) null, Collections.emptyMap(), j10, j11, (String) null, 0, (Object) null);
    }
}
