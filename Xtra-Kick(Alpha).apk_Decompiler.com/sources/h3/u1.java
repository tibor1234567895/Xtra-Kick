package h3;

import h9.v;

public final class u1 implements v {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7333h;

    /* renamed from: i  reason: collision with root package name */
    public final String f7334i;

    public u1(String str) {
        this.f7333h = 0;
        this.f7334i = str;
    }

    public final void c(Throwable th) {
        j1.v.h("MediaNtfMng", "custom command " + this.f7334i + " produced an error: " + th.getMessage(), th);
    }

    public final /* bridge */ /* synthetic */ void d(Object obj) {
        j4 j4Var = (j4) obj;
    }

    public final String toString() {
        switch (this.f7333h) {
            case 2:
                return "<" + this.f7334i + '>';
            default:
                return super.toString();
        }
    }

    public u1(String str, int i10) {
        this.f7333h = i10;
        if (i10 != 2) {
            str.getClass();
            this.f7334i = str;
            return;
        }
        this.f7334i = str;
    }
}
