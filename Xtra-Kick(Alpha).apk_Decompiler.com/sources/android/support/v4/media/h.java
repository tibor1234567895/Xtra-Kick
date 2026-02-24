package android.support.v4.media;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.c0;
import androidx.fragment.app.z1;
import androidx.lifecycle.d0;
import androidx.recyclerview.widget.RecyclerView;
import g1.f1;
import h3.c2;
import h3.g4;
import h3.h4;
import h3.i0;
import h3.n;
import h3.o;
import h3.u3;
import h3.w3;
import h6.l;
import j1.v;
import java.util.HashMap;
import la.e;
import la.f;
import xa.j;

public abstract /* synthetic */ class h {
    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void A() {
        /*
            android.app.Notification$Action$Builder r0 = new android.app.Notification$Action$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.h.A():void");
    }

    public static /* synthetic */ void B(Object obj) {
        throw new ClassCastException();
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void C() {
        /*
            android.app.Notification$Builder r0 = new android.app.Notification$Builder
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.h.C():void");
    }

    public static /* synthetic */ String D(int i10) {
        return i10 == 1 ? "INITIALIZE" : i10 == 2 ? "SWITCH_TO_SOURCE_SERVICE" : i10 == 3 ? "DECODE_DATA" : "null";
    }

    public static c2 a() {
        g4 g4Var = new g4();
        g4Var.a();
        h4 h4Var = new h4(g4Var.f7052a);
        f1 f1Var = new f1();
        f1Var.f6371a.b(f1.f6370b);
        return new c2(h4Var, f1Var.c());
    }

    public static void b(d0 d0Var) {
        j.f("owner", d0Var);
    }

    public static int c(int i10, int i11, int i12) {
        return i10 | i11 | i12 | 0 | 128;
    }

    public static /* synthetic */ long d(int i10) {
        if (i10 == 1) {
            return 0;
        }
        if (i10 == 2) {
            return 1;
        }
        if (i10 == 3) {
            return 2;
        }
        if (i10 == 4) {
            return 3;
        }
        if (i10 == 5) {
            return 4;
        }
        throw null;
    }

    public static int e(String str, int i10, int i11) {
        return (str.hashCode() + i10) * i11;
    }

    public static o f(Parcel parcel, String str) {
        parcel.enforceInterface(str);
        return n.A0(parcel.readStrongBinder());
    }

    public static u3 g(w3 w3Var, w3 w3Var2) {
        w3Var.getClass();
        return new u3(w3Var2);
    }

    public static String h(RecyclerView recyclerView, StringBuilder sb2) {
        sb2.append(recyclerView.exceptionLabel());
        return sb2.toString();
    }

    public static String i(String str, int i10) {
        return str + i10;
    }

    public static String j(String str, int i10, String str2) {
        return str + i10 + str2;
    }

    public static String k(String str, long j10) {
        return str + j10;
    }

    public static String l(String str, c0 c0Var, String str2) {
        return str + c0Var + str2;
    }

    public static String m(String str, String str2) {
        return str + str2;
    }

    public static String n(String str, String str2, String str3) {
        return str + str2 + str3;
    }

    public static String o(StringBuilder sb2, int i10, String str) {
        sb2.append(i10);
        sb2.append(str);
        return sb2.toString();
    }

    public static String p(StringBuilder sb2, String str, String str2) {
        sb2.append(str);
        sb2.append(str2);
        return sb2.toString();
    }

    public static StringBuilder q(String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str);
        return sb2;
    }

    public static StringBuilder r(String str, int i10, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(i10);
        sb2.append(str2);
        return sb2;
    }

    public static StringBuilder s(String str, String str2, String str3) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append(str2);
        sb2.append(str3);
        return sb2;
    }

    public static e t(z1 z1Var, int i10) {
        return f.a(new l(z1Var, i10));
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void u() {
        /*
            android.media.session.MediaSession r0 = new android.media.session.MediaSession
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.h.u():void");
    }

    public static void v(int i10, HashMap hashMap, String str, int i11, String str2, int i12, String str3, int i13, String str4) {
        hashMap.put(str, Integer.valueOf(i10));
        hashMap.put(str2, Integer.valueOf(i11));
        hashMap.put(str3, Integer.valueOf(i12));
        hashMap.put(str4, Integer.valueOf(i13));
    }

    public static /* synthetic */ void w(Parcelable parcelable) {
        if (parcelable != null) {
            throw new ClassCastException();
        }
    }

    public static void x(w3 w3Var, int i10, v.e eVar, int i11) {
        eVar.j(i11, new i0(w3Var, i10));
    }

    public static /* synthetic */ void y(Object obj) {
        if (obj != null) {
            throw new ClassCastException();
        }
    }

    public static void z(String str, int i10, String str2) {
        v.g(str2, str + i10);
    }
}
