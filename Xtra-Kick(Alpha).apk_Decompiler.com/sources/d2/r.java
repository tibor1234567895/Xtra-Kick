package d2;

import android.net.Uri;
import android.support.v4.media.session.u;
import d9.p0;
import d9.r0;
import d9.r1;
import e2.a;
import f3.b;
import f3.c0;
import f3.d;
import f3.f;
import f3.h;
import f3.h0;
import g1.w;
import i1.c;
import java.util.ArrayList;
import java.util.Map;
import u2.m;
import u2.p;
import v2.e;

public final class r implements a0 {

    /* renamed from: k  reason: collision with root package name */
    public static final int[] f4282k = {5, 4, 12, 8, 3, 10, 9, 11, 6, 2, 0, 1, 7, 16, 15, 14};

    /* renamed from: l  reason: collision with root package name */
    public static final u f4283l = new u(new c(17));

    /* renamed from: m  reason: collision with root package name */
    public static final u f4284m = new u(new c(18));

    /* renamed from: h  reason: collision with root package name */
    public final int f4285h = 1;

    /* renamed from: i  reason: collision with root package name */
    public final r1 f4286i;

    /* renamed from: j  reason: collision with root package name */
    public final int f4287j = 112800;

    public r() {
        p0 p0Var = r0.f4657i;
        this.f4286i = r1.f4658l;
    }

    public final void a(ArrayList arrayList, int i10) {
        Object obj;
        switch (i10) {
            case 0:
                obj = new b();
                break;
            case 1:
                obj = new d();
                break;
            case 2:
                obj = new f(0);
                break;
            case 3:
                obj = new a(0);
                break;
            case 4:
                obj = f4283l.u(0);
                if (obj == null) {
                    obj = new g2.b(0);
                    break;
                }
                break;
            case Constants.MAX_COMPATIBILITY_VERSION:
                obj = new h2.b();
                break;
            case 6:
                obj = new s2.d(0);
                break;
            case 7:
                obj = new t2.d(0);
                break;
            case 8:
                arrayList.add(new m(0));
                obj = new p(0);
                break;
            case 9:
                obj = new e();
                break;
            case 10:
                obj = new c0();
                break;
            case 11:
                obj = new h0(this.f4285h, new j1.h0(0), new h(this.f4286i, 0), this.f4287j);
                break;
            case 12:
                obj = new g3.d();
                break;
            case 14:
                obj = new i2.a();
                break;
            case 15:
                obj = f4284m.u(new Object[0]);
                if (obj == null) {
                    return;
                }
                break;
            case Constants.IV_SIZE:
                obj = new f2.c();
                break;
            default:
                return;
        }
        arrayList.add(obj);
    }

    public final synchronized v[] f(Uri uri, Map map) {
        ArrayList arrayList;
        int[] iArr = f4282k;
        arrayList = new ArrayList(16);
        int b10 = w.b(map);
        if (b10 != -1) {
            a(arrayList, b10);
        }
        int c10 = w.c(uri);
        if (!(c10 == -1 || c10 == b10)) {
            a(arrayList, c10);
        }
        for (int i10 = 0; i10 < 16; i10++) {
            int i11 = iArr[i10];
            if (!(i11 == b10 || i11 == c10)) {
                a(arrayList, i11);
            }
        }
        return (v[]) arrayList.toArray(new v[arrayList.size()]);
    }
}
