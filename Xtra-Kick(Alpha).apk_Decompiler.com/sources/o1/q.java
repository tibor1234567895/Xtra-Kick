package o1;

import h1.a;
import h1.c;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public abstract class q implements c {

    /* renamed from: b  reason: collision with root package name */
    public a f12030b;

    /* renamed from: c  reason: collision with root package name */
    public a f12031c;

    /* renamed from: d  reason: collision with root package name */
    public a f12032d;

    /* renamed from: e  reason: collision with root package name */
    public a f12033e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f12034f;

    /* renamed from: g  reason: collision with root package name */
    public ByteBuffer f12035g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f12036h;

    public q() {
        ByteBuffer byteBuffer = c.f6882a;
        this.f12034f = byteBuffer;
        this.f12035g = byteBuffer;
        a aVar = a.f6877e;
        this.f12032d = aVar;
        this.f12033e = aVar;
        this.f12030b = aVar;
        this.f12031c = aVar;
    }

    public ByteBuffer a() {
        ByteBuffer byteBuffer = this.f12035g;
        this.f12035g = c.f6882a;
        return byteBuffer;
    }

    public final void b() {
        this.f12036h = true;
        j();
    }

    public boolean c() {
        return this.f12033e != a.f6877e;
    }

    public boolean d() {
        return this.f12036h && this.f12035g == c.f6882a;
    }

    public final a f(a aVar) {
        this.f12032d = aVar;
        this.f12033e = h(aVar);
        return c() ? this.f12033e : a.f6877e;
    }

    public final void flush() {
        this.f12035g = c.f6882a;
        this.f12036h = false;
        this.f12030b = this.f12032d;
        this.f12031c = this.f12033e;
        i();
    }

    public final void g() {
        flush();
        this.f12034f = c.f6882a;
        a aVar = a.f6877e;
        this.f12032d = aVar;
        this.f12033e = aVar;
        this.f12030b = aVar;
        this.f12031c = aVar;
        k();
    }

    public a h(a aVar) {
        return a.f6877e;
    }

    public void i() {
    }

    public void j() {
    }

    public void k() {
    }

    public final ByteBuffer l(int i10) {
        if (this.f12034f.capacity() < i10) {
            this.f12034f = ByteBuffer.allocateDirect(i10).order(ByteOrder.nativeOrder());
        } else {
            this.f12034f.clear();
        }
        ByteBuffer byteBuffer = this.f12034f;
        this.f12035g = byteBuffer;
        return byteBuffer;
    }
}
