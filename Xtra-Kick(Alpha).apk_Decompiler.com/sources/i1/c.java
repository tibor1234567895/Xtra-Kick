package i1;

import android.net.Uri;
import android.os.Bundle;
import d2.a0;
import d2.v;
import d9.r1;
import g1.i1;
import g1.l;
import g1.v1;
import g1.y;
import j1.a;
import j1.h;
import j1.l0;
import j1.q;
import j1.r;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.Map;
import java.util.regex.Pattern;
import m1.n0;
import m1.p;
import m1.v0;
import o2.m;
import p1.t;
import s1.b0;
import s1.c0;
import v1.l1;
import v1.y0;
import v2.e;
import z1.k;

public final /* synthetic */ class c implements l, q, r, h, t, b0, d2.q, a0, m {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f7989h;

    public /* synthetic */ c(int i10) {
        this.f7989h = i10;
    }

    public final void a() {
    }

    public final void b(Object obj) {
        switch (this.f7989h) {
            case 6:
                ((p1.q) obj).c();
                return;
            case 7:
                ((p1.q) obj).b();
                return;
            case 8:
                ((p1.q) obj).a();
                return;
            case 12:
                ((y0) obj).f15836b.a();
                return;
            default:
                return;
        }
    }

    public final void c(Object obj, y yVar) {
        n1.c cVar = (n1.c) obj;
    }

    public final int d(Object obj) {
        switch (this.f7989h) {
            case 10:
                Pattern pattern = c0.f13983a;
                String str = ((s1.q) obj).f14033a;
                if (str.startsWith("OMX.google") || str.startsWith("c2.android")) {
                    return 1;
                }
                if (l0.f8453a >= 26 || !str.equals("OMX.MTK.AUDIO.DECODER.RAW")) {
                    return 0;
                }
                return -1;
            default:
                Pattern pattern2 = c0.f13983a;
                return ((s1.q) obj).f14033a.startsWith("OMX.google") ? 1 : 0;
        }
    }

    public final g1.m e(Bundle bundle) {
        r1 r1Var;
        boolean z10 = false;
        switch (this.f7989h) {
            case 0:
                ArrayList parcelableArrayList = bundle.getParcelableArrayList(d.f7991k);
                if (parcelableArrayList == null) {
                    r1Var = r1.f4658l;
                } else {
                    r1Var = j1.c.a(b.Q, parcelableArrayList);
                }
                return new d(bundle.getLong(d.f7992l), r1Var);
            case 14:
                ArrayList parcelableArrayList2 = bundle.getParcelableArrayList(l1.f15715l);
                if (parcelableArrayList2 == null) {
                    return new l1(new v1[0]);
                }
                return new l1((v1[]) j1.c.a(v1.f6672o, parcelableArrayList2).toArray(new v1[0]));
            default:
                int i10 = bundle.getInt(k.f17433k, -1);
                int[] intArray = bundle.getIntArray(k.f17434l);
                int i11 = bundle.getInt(k.f17435m, -1);
                if (i10 >= 0 && i11 >= 0) {
                    z10 = true;
                }
                a.b(z10);
                intArray.getClass();
                return new k(i10, i11, intArray);
        }
    }

    public final v[] f(Uri uri, Map map) {
        return g();
    }

    public final v[] g() {
        return new v[]{new e()};
    }

    public final Constructor h() {
        Class<v> cls = v.class;
        switch (this.f7989h) {
            case 17:
                int[] iArr = d2.r.f4282k;
                if (!Boolean.TRUE.equals(Class.forName("androidx.media3.decoder.flac.FlacLibrary").getMethod("isAvailable", new Class[0]).invoke((Object) null, new Object[0]))) {
                    return null;
                }
                return Class.forName("androidx.media3.decoder.flac.FlacExtractor").asSubclass(cls).getConstructor(new Class[]{Integer.TYPE});
            default:
                int[] iArr2 = d2.r.f4282k;
                return Class.forName("androidx.media3.decoder.midi.MidiExtractor").asSubclass(cls).getConstructor(new Class[0]);
        }
    }

    public final void invoke(Object obj) {
        switch (this.f7989h) {
            case 2:
                int i10 = n0.f10366l0;
                ((i1) obj).B(new p(2, new v0(1), 1003));
                return;
            case 3:
                ((i1) obj).s();
                return;
            default:
                ((i1) obj).r();
                return;
        }
    }
}
