package q1;

import android.text.TextUtils;
import d2.e0;
import d2.p;
import d2.s0;
import d2.v;
import d2.w;
import d2.w0;
import d2.x0;
import d2.y;
import e3.i;
import e3.k;
import g1.b1;
import g1.z;
import j1.h0;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class b0 implements v {

    /* renamed from: g  reason: collision with root package name */
    public static final Pattern f13139g = Pattern.compile("LOCAL:([^,]+)");

    /* renamed from: h  reason: collision with root package name */
    public static final Pattern f13140h = Pattern.compile("MPEGTS:(-?\\d+)");

    /* renamed from: a  reason: collision with root package name */
    public final String f13141a;

    /* renamed from: b  reason: collision with root package name */
    public final h0 f13142b;

    /* renamed from: c  reason: collision with root package name */
    public final j1.b0 f13143c = new j1.b0();

    /* renamed from: d  reason: collision with root package name */
    public y f13144d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f13145e = new byte[1024];

    /* renamed from: f  reason: collision with root package name */
    public int f13146f;

    public b0(String str, h0 h0Var) {
        this.f13141a = str;
        this.f13142b = h0Var;
    }

    public final void a() {
    }

    public final x0 b(long j10) {
        x0 d10 = this.f13144d.d(0, 3);
        z zVar = new z();
        zVar.f6754k = "text/vtt";
        zVar.f6746c = this.f13141a;
        zVar.f6758o = j10;
        d10.a(zVar.a());
        this.f13144d.a();
        return d10;
    }

    public final void c(long j10, long j11) {
        throw new IllegalStateException();
    }

    public final int d(w wVar, s0 s0Var) {
        String g10;
        int i10;
        this.f13144d.getClass();
        int c10 = (int) wVar.c();
        int i11 = this.f13146f;
        byte[] bArr = this.f13145e;
        if (i11 == bArr.length) {
            if (c10 != -1) {
                i10 = c10;
            } else {
                i10 = bArr.length;
            }
            this.f13145e = Arrays.copyOf(bArr, (i10 * 3) / 2);
        }
        byte[] bArr2 = this.f13145e;
        int i12 = this.f13146f;
        int o10 = wVar.o(bArr2, i12, bArr2.length - i12);
        if (o10 != -1) {
            int i13 = this.f13146f + o10;
            this.f13146f = i13;
            if (c10 == -1 || i13 != c10) {
                return 0;
            }
        }
        j1.b0 b0Var = new j1.b0(this.f13145e);
        k.d(b0Var);
        String g11 = b0Var.g();
        long j10 = 0;
        long j11 = 0;
        while (true) {
            Matcher matcher = null;
            if (!TextUtils.isEmpty(g11)) {
                if (g11.startsWith("X-TIMESTAMP-MAP")) {
                    Matcher matcher2 = f13139g.matcher(g11);
                    if (matcher2.find()) {
                        Matcher matcher3 = f13140h.matcher(g11);
                        if (matcher3.find()) {
                            String group = matcher2.group(1);
                            group.getClass();
                            j11 = k.c(group);
                            String group2 = matcher3.group(1);
                            group2.getClass();
                            j10 = (Long.parseLong(group2) * 1000000) / 90000;
                        } else {
                            throw b1.a("X-TIMESTAMP-MAP doesn't contain media timestamp: ".concat(g11), (Exception) null);
                        }
                    } else {
                        throw b1.a("X-TIMESTAMP-MAP doesn't contain local timestamp: ".concat(g11), (Exception) null);
                    }
                }
                g11 = b0Var.g();
            } else {
                while (true) {
                    String g12 = b0Var.g();
                    if (g12 == null) {
                        break;
                    } else if (k.f5037a.matcher(g12).matches()) {
                        do {
                            g10 = b0Var.g();
                            if (g10 == null) {
                                break;
                            }
                        } while (g10.isEmpty());
                    } else {
                        Matcher matcher4 = i.f5031a.matcher(g12);
                        if (matcher4.matches()) {
                            matcher = matcher4;
                            break;
                        }
                    }
                }
                if (matcher == null) {
                    b(0);
                    return -1;
                }
                String group3 = matcher.group(1);
                group3.getClass();
                long c11 = k.c(group3);
                long b10 = this.f13142b.b(((((j10 + c11) - j11) * 90000) / 1000000) % 8589934592L);
                x0 b11 = b(b10 - c11);
                byte[] bArr3 = this.f13145e;
                int i14 = this.f13146f;
                j1.b0 b0Var2 = this.f13143c;
                b0Var2.E(i14, bArr3);
                b11.d(this.f13146f, b0Var2);
                b11.e(b10, 1, this.f13146f, 0, (w0) null);
                return -1;
            }
        }
    }

    public final void e(y yVar) {
        this.f13144d = yVar;
        yVar.g(new e0(-9223372036854775807L));
    }

    public final boolean h(w wVar) {
        p pVar = (p) wVar;
        pVar.k(this.f13145e, 0, 6, false);
        byte[] bArr = this.f13145e;
        j1.b0 b0Var = this.f13143c;
        b0Var.E(6, bArr);
        if (k.a(b0Var)) {
            return true;
        }
        pVar.k(this.f13145e, 6, 3, false);
        b0Var.E(9, this.f13145e);
        return k.a(b0Var);
    }
}
