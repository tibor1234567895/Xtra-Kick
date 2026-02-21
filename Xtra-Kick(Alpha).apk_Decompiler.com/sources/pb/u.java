package pb;

import fb.y;
import hb.h0;
import xa.j;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public String f12999a;

    /* renamed from: b  reason: collision with root package name */
    public String f13000b;

    /* renamed from: c  reason: collision with root package name */
    public final long f13001c = 253402300799999L;

    /* renamed from: d  reason: collision with root package name */
    public String f13002d;

    /* renamed from: e  reason: collision with root package name */
    public final String f13003e = Constants.LIST_SEPARATOR;

    /* renamed from: f  reason: collision with root package name */
    public boolean f13004f;

    public final w a() {
        String str = this.f12999a;
        if (str != null) {
            String str2 = this.f13000b;
            if (str2 != null) {
                long j10 = this.f13001c;
                String str3 = this.f13002d;
                if (str3 != null) {
                    return new w(str, str2, j10, str3, this.f13003e, false, false, false, this.f13004f);
                }
                throw new NullPointerException("builder.domain == null");
            }
            throw new NullPointerException("builder.value == null");
        }
        throw new NullPointerException("builder.name == null");
    }

    public final void b(String str) {
        j.f("domain", str);
        String R1 = h0.R1(str);
        if (R1 != null) {
            this.f13002d = R1;
            this.f13004f = false;
            return;
        }
        throw new IllegalArgumentException("unexpected domain: ".concat(str));
    }

    public final void c(String str) {
        if (j.a(y.R(str).toString(), str)) {
            this.f12999a = str;
            return;
        }
        throw new IllegalArgumentException("name is not trimmed".toString());
    }

    public final void d(String str) {
        j.f("value", str);
        if (j.a(y.R(str).toString(), str)) {
            this.f13000b = str;
            return;
        }
        throw new IllegalArgumentException("value is not trimmed".toString());
    }
}
