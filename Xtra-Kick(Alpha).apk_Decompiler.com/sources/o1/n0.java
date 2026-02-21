package o1;

import h1.a;
import h1.b;
import h1.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;

public final class n0 implements c {

    /* renamed from: b  reason: collision with root package name */
    public int f11976b;

    /* renamed from: c  reason: collision with root package name */
    public float f11977c = 1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f11978d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public a f11979e;

    /* renamed from: f  reason: collision with root package name */
    public a f11980f;

    /* renamed from: g  reason: collision with root package name */
    public a f11981g;

    /* renamed from: h  reason: collision with root package name */
    public a f11982h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f11983i;

    /* renamed from: j  reason: collision with root package name */
    public m0 f11984j;

    /* renamed from: k  reason: collision with root package name */
    public ByteBuffer f11985k;

    /* renamed from: l  reason: collision with root package name */
    public ShortBuffer f11986l;

    /* renamed from: m  reason: collision with root package name */
    public ByteBuffer f11987m;

    /* renamed from: n  reason: collision with root package name */
    public long f11988n;

    /* renamed from: o  reason: collision with root package name */
    public long f11989o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f11990p;

    public n0() {
        a aVar = a.f6877e;
        this.f11979e = aVar;
        this.f11980f = aVar;
        this.f11981g = aVar;
        this.f11982h = aVar;
        ByteBuffer byteBuffer = c.f6882a;
        this.f11985k = byteBuffer;
        this.f11986l = byteBuffer.asShortBuffer();
        this.f11987m = byteBuffer;
        this.f11976b = -1;
    }

    public final ByteBuffer a() {
        m0 m0Var = this.f11984j;
        if (m0Var != null) {
            int i10 = m0Var.f11961m;
            int i11 = m0Var.f11950b;
            int i12 = i10 * i11 * 2;
            if (i12 > 0) {
                if (this.f11985k.capacity() < i12) {
                    ByteBuffer order = ByteBuffer.allocateDirect(i12).order(ByteOrder.nativeOrder());
                    this.f11985k = order;
                    this.f11986l = order.asShortBuffer();
                } else {
                    this.f11985k.clear();
                    this.f11986l.clear();
                }
                ShortBuffer shortBuffer = this.f11986l;
                int min = Math.min(shortBuffer.remaining() / i11, m0Var.f11961m);
                int i13 = min * i11;
                shortBuffer.put(m0Var.f11960l, 0, i13);
                int i14 = m0Var.f11961m - min;
                m0Var.f11961m = i14;
                short[] sArr = m0Var.f11960l;
                System.arraycopy(sArr, i13, sArr, 0, i14 * i11);
                this.f11989o += (long) i12;
                this.f11985k.limit(i12);
                this.f11987m = this.f11985k;
            }
        }
        ByteBuffer byteBuffer = this.f11987m;
        this.f11987m = c.f6882a;
        return byteBuffer;
    }

    public final void b() {
        m0 m0Var = this.f11984j;
        if (m0Var != null) {
            int i10 = m0Var.f11959k;
            float f10 = m0Var.f11951c;
            float f11 = m0Var.f11952d;
            float f12 = m0Var.f11953e * f11;
            int i11 = m0Var.f11961m + ((int) ((((((float) i10) / (f10 / f11)) + ((float) m0Var.f11963o)) / f12) + 0.5f));
            short[] sArr = m0Var.f11958j;
            int i12 = m0Var.f11956h * 2;
            m0Var.f11958j = m0Var.c(sArr, i10, i12 + i10);
            int i13 = 0;
            while (true) {
                int i14 = m0Var.f11950b;
                if (i13 >= i12 * i14) {
                    break;
                }
                m0Var.f11958j[(i14 * i10) + i13] = 0;
                i13++;
            }
            m0Var.f11959k = i12 + m0Var.f11959k;
            m0Var.f();
            if (m0Var.f11961m > i11) {
                m0Var.f11961m = i11;
            }
            m0Var.f11959k = 0;
            m0Var.f11966r = 0;
            m0Var.f11963o = 0;
        }
        this.f11990p = true;
    }

    public final boolean c() {
        return this.f11980f.f6878a != -1 && (Math.abs(this.f11977c - 1.0f) >= 1.0E-4f || Math.abs(this.f11978d - 1.0f) >= 1.0E-4f || this.f11980f.f6878a != this.f11979e.f6878a);
    }

    public final boolean d() {
        m0 m0Var;
        if (!this.f11990p || ((m0Var = this.f11984j) != null && m0Var.f11961m * m0Var.f11950b * 2 != 0)) {
            return false;
        }
        return true;
    }

    public final void e(ByteBuffer byteBuffer) {
        if (byteBuffer.hasRemaining()) {
            m0 m0Var = this.f11984j;
            m0Var.getClass();
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            int remaining = byteBuffer.remaining();
            this.f11988n += (long) remaining;
            int remaining2 = asShortBuffer.remaining();
            int i10 = m0Var.f11950b;
            int i11 = remaining2 / i10;
            short[] c10 = m0Var.c(m0Var.f11958j, m0Var.f11959k, i11);
            m0Var.f11958j = c10;
            asShortBuffer.get(c10, m0Var.f11959k * i10, ((i11 * i10) * 2) / 2);
            m0Var.f11959k += i11;
            m0Var.f();
            byteBuffer.position(byteBuffer.position() + remaining);
        }
    }

    public final a f(a aVar) {
        if (aVar.f6880c == 2) {
            int i10 = this.f11976b;
            if (i10 == -1) {
                i10 = aVar.f6878a;
            }
            this.f11979e = aVar;
            a aVar2 = new a(i10, aVar.f6879b, 2);
            this.f11980f = aVar2;
            this.f11983i = true;
            return aVar2;
        }
        throw new b(aVar);
    }

    public final void flush() {
        if (c()) {
            a aVar = this.f11979e;
            this.f11981g = aVar;
            a aVar2 = this.f11980f;
            this.f11982h = aVar2;
            if (this.f11983i) {
                this.f11984j = new m0(this.f11977c, this.f11978d, aVar.f6878a, aVar.f6879b, aVar2.f6878a);
            } else {
                m0 m0Var = this.f11984j;
                if (m0Var != null) {
                    m0Var.f11959k = 0;
                    m0Var.f11961m = 0;
                    m0Var.f11963o = 0;
                    m0Var.f11964p = 0;
                    m0Var.f11965q = 0;
                    m0Var.f11966r = 0;
                    m0Var.f11967s = 0;
                    m0Var.f11968t = 0;
                    m0Var.f11969u = 0;
                    m0Var.f11970v = 0;
                }
            }
        }
        this.f11987m = c.f6882a;
        this.f11988n = 0;
        this.f11989o = 0;
        this.f11990p = false;
    }

    public final void g() {
        this.f11977c = 1.0f;
        this.f11978d = 1.0f;
        a aVar = a.f6877e;
        this.f11979e = aVar;
        this.f11980f = aVar;
        this.f11981g = aVar;
        this.f11982h = aVar;
        ByteBuffer byteBuffer = c.f6882a;
        this.f11985k = byteBuffer;
        this.f11986l = byteBuffer.asShortBuffer();
        this.f11987m = byteBuffer;
        this.f11976b = -1;
        this.f11983i = false;
        this.f11984j = null;
        this.f11988n = 0;
        this.f11989o = 0;
        this.f11990p = false;
    }
}
