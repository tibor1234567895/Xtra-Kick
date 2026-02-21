package d5;

import f5.a;
import f5.b;
import f5.f;
import w5.h;
import w5.n;

public final class v implements h {

    /* renamed from: h  reason: collision with root package name */
    public volatile Object f4495h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f4496i;

    public /* synthetic */ v(Object obj) {
        this.f4496i = obj;
    }

    public final a a() {
        if (((a) this.f4495h) == null) {
            synchronized (this) {
                if (((a) this.f4495h) == null) {
                    this.f4495h = ((f) this.f4496i).a();
                }
                if (((a) this.f4495h) == null) {
                    this.f4495h = new b();
                }
            }
        }
        return (a) this.f4495h;
    }

    public final Object get() {
        if (this.f4495h == null) {
            synchronized (this) {
                if (this.f4495h == null) {
                    Object obj = ((h) this.f4496i).get();
                    n.b(obj);
                    this.f4495h = obj;
                }
            }
        }
        return this.f4495h;
    }
}
