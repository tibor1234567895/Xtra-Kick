package qb;

import dc.l;
import dc.s0;
import fb.c;
import fb.w;
import fb.y;
import hb.h0;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import ma.r;
import ma.z;
import pb.f1;
import pb.n0;
import pb.p0;
import pb.r1;
import pb.t0;
import wb.e;
import xa.j;
import xa.x;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    public static final p0 f13493a = f.f13489c;

    /* renamed from: b  reason: collision with root package name */
    public static final TimeZone f13494b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f13495c;

    static {
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        j.c(timeZone);
        f13494b = timeZone;
        String B = y.B("okhttp3.", f1.class.getName());
        if (w.f(B, "Client", false)) {
            B = B.substring(0, B.length() - "Client".length());
            j.e("this as java.lang.String…ing(startIndex, endIndex)", B);
        }
        f13495c = B;
    }

    public static final boolean a(t0 t0Var, t0 t0Var2) {
        j.f("<this>", t0Var);
        j.f("other", t0Var2);
        return j.a(t0Var.f12992d, t0Var2.f12992d) && t0Var.f12993e == t0Var2.f12993e && j.a(t0Var.f12989a, t0Var2.f12989a);
    }

    public static final int b(long j10, TimeUnit timeUnit) {
        boolean z10 = false;
        int i10 = (j10 > 0 ? 1 : (j10 == 0 ? 0 : -1));
        if (i10 >= 0) {
            if (timeUnit != null) {
                long millis = timeUnit.toMillis(j10);
                if (millis <= 2147483647L) {
                    if (millis != 0 || i10 <= 0) {
                        z10 = true;
                    }
                    if (z10) {
                        return (int) millis;
                    }
                    throw new IllegalArgumentException("timeout".concat(" too small.").toString());
                }
                throw new IllegalArgumentException("timeout".concat(" too large.").toString());
            }
            throw new IllegalStateException("unit == null".toString());
        }
        throw new IllegalStateException("timeout".concat(" < 0").toString());
    }

    public static final void c(Socket socket) {
        try {
            socket.close();
        } catch (AssertionError e10) {
            throw e10;
        } catch (RuntimeException e11) {
            if (!j.a(e11.getMessage(), "bio == null")) {
                throw e11;
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean d(dc.p0 p0Var, TimeUnit timeUnit) {
        j.f("<this>", p0Var);
        j.f("timeUnit", timeUnit);
        try {
            return i(p0Var, 100, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String e(String str, Object... objArr) {
        j.f("format", str);
        x xVar = x.f16820a;
        Locale locale = Locale.US;
        Object[] copyOf = Arrays.copyOf(objArr, objArr.length);
        String format = String.format(locale, str, Arrays.copyOf(copyOf, copyOf.length));
        j.e("format(locale, format, *args)", format);
        return format;
    }

    public static final long f(r1 r1Var) {
        String a10 = r1Var.f12966m.a("Content-Length");
        if (a10 != null) {
            byte[] bArr = f.f13487a;
            try {
                return Long.parseLong(a10);
            } catch (NumberFormatException unused) {
            }
        }
        return -1;
    }

    public static final List g(Object... objArr) {
        j.f("elements", objArr);
        Object[] objArr2 = (Object[]) objArr.clone();
        List unmodifiableList = Collections.unmodifiableList(r.e(Arrays.copyOf(objArr2, objArr2.length)));
        j.e("unmodifiableList(listOf(*elements.clone()))", unmodifiableList);
        return unmodifiableList;
    }

    public static final Charset h(l lVar, Charset charset) {
        Charset charset2;
        j.f("<this>", lVar);
        j.f("default", charset);
        int K0 = lVar.K0(f.f13488b);
        if (K0 == -1) {
            return charset;
        }
        if (K0 == 0) {
            return c.f5986b;
        }
        if (K0 == 1) {
            return c.f5987c;
        }
        if (K0 == 2) {
            return c.f5988d;
        }
        if (K0 == 3) {
            c.f5985a.getClass();
            charset2 = c.f5990f;
            if (charset2 == null) {
                charset2 = Charset.forName("UTF-32BE");
                j.e("forName(\"UTF-32BE\")", charset2);
                c.f5990f = charset2;
            }
        } else if (K0 == 4) {
            c.f5985a.getClass();
            charset2 = c.f5989e;
            if (charset2 == null) {
                charset2 = Charset.forName("UTF-32LE");
                j.e("forName(\"UTF-32LE\")", charset2);
                c.f5989e = charset2;
            }
        } else {
            throw new AssertionError();
        }
        return charset2;
    }

    public static final boolean i(dc.p0 p0Var, int i10, TimeUnit timeUnit) {
        j.f("<this>", p0Var);
        j.f("timeUnit", timeUnit);
        long nanoTime = System.nanoTime();
        long c10 = p0Var.timeout().e() ? p0Var.timeout().c() - nanoTime : Long.MAX_VALUE;
        p0Var.timeout().d(Math.min(c10, timeUnit.toNanos((long) i10)) + nanoTime);
        try {
            dc.j jVar = new dc.j();
            while (p0Var.read(jVar, 8192) != -1) {
                jVar.c();
            }
            int i11 = (c10 > Long.MAX_VALUE ? 1 : (c10 == Long.MAX_VALUE ? 0 : -1));
            s0 timeout = p0Var.timeout();
            if (i11 == 0) {
                timeout.a();
            } else {
                timeout.d(nanoTime + c10);
            }
            return true;
        } catch (InterruptedIOException unused) {
            int i12 = (c10 > Long.MAX_VALUE ? 1 : (c10 == Long.MAX_VALUE ? 0 : -1));
            s0 timeout2 = p0Var.timeout();
            if (i12 == 0) {
                timeout2.a();
            } else {
                timeout2.d(nanoTime + c10);
            }
            return false;
        } catch (Throwable th) {
            int i13 = (c10 > Long.MAX_VALUE ? 1 : (c10 == Long.MAX_VALUE ? 0 : -1));
            s0 timeout3 = p0Var.timeout();
            if (i13 == 0) {
                timeout3.a();
            } else {
                timeout3.d(nanoTime + c10);
            }
            throw th;
        }
    }

    public static final p0 j(List list) {
        n0 n0Var = new n0();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            e eVar = (e) it.next();
            h0.C(n0Var, eVar.f16210a.q(), eVar.f16211b.q());
        }
        return n0Var.b();
    }

    public static final String k(t0 t0Var, boolean z10) {
        j.f("<this>", t0Var);
        String str = t0Var.f12992d;
        if (y.n(str, Constants.EXT_TAG_END, false)) {
            str = "[" + str + ']';
        }
        int i10 = t0Var.f12993e;
        if (!z10) {
            t0.f12987k.getClass();
            if (i10 == pb.s0.b(t0Var.f12989a)) {
                return str;
            }
        }
        return str + ':' + i10;
    }

    public static final List l(List list) {
        j.f("<this>", list);
        List unmodifiableList = Collections.unmodifiableList(z.K(list));
        j.e("unmodifiableList(toMutableList())", unmodifiableList);
        return unmodifiableList;
    }
}
