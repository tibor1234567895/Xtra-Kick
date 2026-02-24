package hb;

import a6.n;
import a6.o;
import android.app.Dialog;
import android.content.ContentResolver;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.IBinder;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.util.Size;
import android.util.SizeF;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EdgeEffect;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.activity.s;
import androidx.appcompat.widget.SearchView;
import androidx.fragment.app.c0;
import androidx.lifecycle.LifecycleCoroutineScopeImpl;
import androidx.lifecycle.d0;
import androidx.lifecycle.h2;
import androidx.lifecycle.w1;
import androidx.lifecycle.x1;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.github.andreyasadchy.xtra.ui.view.SlidingLayout;
import com.woxthebox.draglistview.R;
import dagger.MembersInjector;
import dc.c;
import dc.f0;
import dc.m0;
import dc.p0;
import dc.s0;
import fb.w;
import fb.y;
import j3.k0;
import j3.k2;
import j3.m1;
import j3.m2;
import j3.n1;
import j3.o1;
import java.io.Closeable;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.locks.LockSupport;
import java.util.logging.Logger;
import jb.g;
import kb.b0;
import kb.i;
import kb.l1;
import kotlinx.coroutines.CoroutineExceptionHandler;
import la.a;
import la.l;
import la.q;
import la.v;
import m0.h1;
import m0.j1;
import ma.j0;
import ma.o0;
import ma.r;
import mb.d;
import mb.u;
import mb.z;
import n3.a6;
import n3.d1;
import n3.h5;
import n3.t;
import n3.y5;
import n3.z5;
import o3.i0;
import p9.b;
import pa.e;
import pb.n0;
import pb.q1;
import pb.r1;
import pb.u1;
import pb.w0;
import pb.x0;
import q.m;
import wa.p;
import xa.j;
import y9.f;
import y9.h;
import y9.k;
import y9.x;

public abstract class h0 implements MembersInjector {

    /* renamed from: a  reason: collision with root package name */
    public static final char[] f7802a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f'};

    /* renamed from: b  reason: collision with root package name */
    public static final e[] f7803b = new e[0];

    /* renamed from: c  reason: collision with root package name */
    public static final Object[] f7804c = new Object[0];

    public static final void A(Closeable closeable, Throwable th) {
        if (closeable == null) {
            return;
        }
        if (th == null) {
            closeable.close();
            return;
        }
        try {
            closeable.close();
        } catch (Throwable th2) {
            a.a(th, th2);
        }
    }

    public static final x A0(File file) {
        if (file.exists()) {
            return new x(new RandomAccessFile(file, "rw"));
        }
        throw new FileNotFoundException(file.getCanonicalPath() + " file_not_found");
    }

    public static final void A1(View view, s sVar) {
        j.f("<this>", view);
        j.f("onBackPressedDispatcherOwner", sVar);
        view.setTag(R.id.view_tree_on_back_pressed_dispatcher_owner, sVar);
    }

    public static final Object B(i iVar, p pVar, e eVar) {
        int i10 = b0.f9268a;
        Object b10 = p(Y1(iVar, new t((Object) pVar, (e) null, 7)), 0).b(lb.s.f9861h, eVar);
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (b10 != aVar) {
            b10 = v.f9814a;
        }
        if (b10 == aVar) {
            return b10;
        }
        return v.f9814a;
    }

    public static final int B0(int i10, int i11, int i12) {
        if (i12 > 0) {
            if (i10 >= i11) {
                return i11;
            }
            int i13 = i11 % i12;
            if (i13 < 0) {
                i13 += i12;
            }
            int i14 = i10 % i12;
            if (i14 < 0) {
                i14 += i12;
            }
            int i15 = (i13 - i14) % i12;
            if (i15 < 0) {
                i15 += i12;
            }
            return i11 - i15;
        } else if (i12 >= 0) {
            throw new IllegalArgumentException("Step is zero.");
        } else if (i10 <= i11) {
            return i11;
        } else {
            int i16 = -i12;
            int i17 = i10 % i16;
            if (i17 < 0) {
                i17 += i16;
            }
            int i18 = i11 % i16;
            if (i18 < 0) {
                i18 += i16;
            }
            int i19 = (i17 - i18) % i16;
            if (i19 < 0) {
                i19 += i16;
            }
            return i11 + i19;
        }
    }

    public static final void B1(View view, d0 d0Var) {
        j.f("<this>", view);
        view.setTag(R.id.view_tree_lifecycle_owner, d0Var);
    }

    public static final void C(n0 n0Var, String str, String str2) {
        j.f("<this>", n0Var);
        j.f("name", str);
        j.f("value", str2);
        ArrayList arrayList = n0Var.f12909a;
        arrayList.add(str);
        arrayList.add(y.R(str2).toString());
    }

    public static final d0 C0(r3.n0 n0Var) {
        j.f("<this>", n0Var);
        Map map = n0Var.f13729l;
        Object obj = map.get("QueryDispatcher");
        if (obj == null) {
            Executor executor = n0Var.f13719b;
            if (executor != null) {
                obj = new c1(executor);
                map.put("QueryDispatcher", obj);
            } else {
                j.l("internalQueryExecutor");
                throw null;
            }
        }
        return (d0) obj;
    }

    public static final void C1(Context context, int i10) {
        j.f("<this>", context);
        Toast.makeText(context, i10, 0).show();
    }

    public static final kb.e D(g gVar) {
        return new kb.e(gVar, true);
    }

    public static final String D0(String str) {
        j.g("url", str);
        try {
            Uri parse = Uri.parse(str);
            StringBuilder sb2 = new StringBuilder();
            j.b("uri", parse);
            sb2.append(parse.getScheme());
            sb2.append("://");
            sb2.append(parse.getAuthority());
            return sb2.toString();
        } catch (Exception unused) {
            return "https://google.com";
        }
    }

    public static final void D1(Context context, String str) {
        j.f("text", str);
        Toast.makeText(context, str, 0).show();
    }

    public static final int E(Context context, float f10) {
        return (int) TypedValue.applyDimension(1, f10, context.getResources().getDisplayMetrics());
    }

    public static final y9.g E0(b bVar, String str) {
        j.g("download", bVar);
        j.g("requestMethod", str);
        return F0(bVar, -1, -1, str, 0, 16);
    }

    public static final boolean E1(a6 a6Var, a6 a6Var2, d1 d1Var) {
        j.f("<this>", a6Var);
        return a6Var2 == null || ((a6Var2 instanceof z5) && (a6Var instanceof y5)) || ((!(a6Var instanceof z5) || !(a6Var2 instanceof y5)) && !(a6Var.f11053c == a6Var2.f11053c && a6Var.f11054d == a6Var2.f11054d && a6Var2.a(d1Var) <= a6Var.a(d1Var)));
    }

    public static final void F(f fVar) {
        j.g("request", fVar.f17253e);
        j.g("hash", fVar.f17254f);
        j.g("responseHeaders", fVar.f17255g);
    }

    public static y9.g F0(b bVar, long j10, long j11, String str, int i10, int i11) {
        long j12;
        long j13;
        String str2;
        int i12;
        String str3;
        b bVar2 = bVar;
        if ((i11 & 2) != 0) {
            j12 = -1;
        } else {
            j12 = j10;
        }
        if ((i11 & 4) != 0) {
            j13 = -1;
        } else {
            j13 = j11;
        }
        if ((i11 & 8) != 0) {
            str2 = "GET";
        } else {
            str2 = str;
        }
        if ((i11 & 16) != 0) {
            i12 = 1;
        } else {
            i12 = i10;
        }
        j.g("download", bVar2);
        j.g("requestMethod", str2);
        if (j12 == -1) {
            j12 = 0;
        }
        if (j13 == -1) {
            str3 = "";
        } else {
            str3 = String.valueOf(j13);
        }
        q9.e eVar = (q9.e) bVar2;
        LinkedHashMap i13 = j0.i(eVar.f13439n);
        i13.put("Range", "bytes=" + j12 + '-' + str3);
        int i14 = eVar.f13433h;
        String str4 = eVar.f13435j;
        String str5 = eVar.f13436k;
        return new y9.g(i14, str4, i13, str5, o0(str5), eVar.f13446u, eVar.f13448w, str2, eVar.f13450y, "", i12);
    }

    public static final void F1(SearchView searchView) {
        searchView.postDelayed(new r3.b0(searchView, 6, (InputMethodManager) searchView.getContext().getSystemService("input_method")), 100);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String G(java.io.InputStream r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2.<init>(r3)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r1.<init>(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r3.<init>()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
        L_0x0013:
            java.lang.String r2 = r1.readLine()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            if (r2 == 0) goto L_0x0022
            r3.append(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            r2 = 10
            r3.append(r2)     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            goto L_0x0013
        L_0x0022:
            java.lang.String r0 = r3.toString()     // Catch:{ Exception -> 0x0029, all -> 0x0027 }
            goto L_0x0029
        L_0x0027:
            r3 = move-exception
            throw r3
        L_0x0029:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.G(java.io.InputStream):java.lang.String");
    }

    public static final Set G0(y9.g gVar, h hVar) {
        j.g("downloader", hVar);
        Set b10 = o0.b(y9.e.SEQUENTIAL);
        try {
            f B = hVar.B(gVar, new k());
            if (B != null) {
                int i10 = B.f17249a;
                Map map = B.f17255g;
                j.g("headers", map);
                if (b(i10, map)) {
                    b10.add(y9.e.PARALLEL);
                }
                hVar.q0(B);
            }
        } catch (Exception unused) {
        }
        return b10;
    }

    public static final i G1(p pVar) {
        return p(new kb.o0(new h5(pVar, (e) null)), -2);
    }

    public static final Object H(p pVar, e eVar) {
        mb.y yVar = new mb.y(eVar, eVar.getContext());
        Object K1 = K1(yVar, yVar, pVar);
        if (K1 == qa.a.COROUTINE_SUSPENDED) {
            m1(eVar);
        }
        return K1;
    }

    public static final z H0(Object obj) {
        if (obj != d.f10843a) {
            j.d("null cannot be cast to non-null type S of kotlinx.coroutines.internal.SegmentOrClosed", obj);
            return (z) obj;
        }
        throw new IllegalStateException("Does not contain segment".toString());
    }

    public static final c H1(Socket socket) {
        Logger logger = dc.b0.f4742a;
        dc.o0 o0Var = new dc.o0(socket);
        OutputStream outputStream = socket.getOutputStream();
        j.e("getOutputStream()", outputStream);
        return new c(o0Var, new c(outputStream, (s0) o0Var));
    }

    public static final la.k I(Throwable th) {
        j.f("exception", th);
        return new la.k(th);
    }

    public static final f0 I0(w1 w1Var) {
        Object obj;
        j.f("<this>", w1Var);
        HashMap hashMap = w1Var.f1781a;
        if (hashMap == null) {
            obj = null;
        } else {
            synchronized (hashMap) {
                obj = w1Var.f1781a.get("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
            }
        }
        f0 f0Var = (f0) obj;
        if (f0Var != null) {
            return f0Var;
        }
        d2 d2Var = new d2((l1) null);
        nb.e eVar = p0.f7833a;
        return (f0) w1Var.c("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new androidx.lifecycle.g(j1(d2Var, u.f10886a.Q0())));
    }

    public static final dc.d I1(InputStream inputStream) {
        Logger logger = dc.b0.f4742a;
        j.f("<this>", inputStream);
        return new dc.d(inputStream, new s0());
    }

    public static final void J(File file) {
        if (file.exists()) {
            return;
        }
        if (file.getParentFile() == null || file.getParentFile().exists()) {
            if (!file.createNewFile()) {
                throw new FileNotFoundException(file + " file_not_found");
            }
        } else if (!file.getParentFile().mkdirs()) {
            throw new FileNotFoundException(file + " file_not_found");
        } else if (!file.createNewFile()) {
            throw new FileNotFoundException(file + " file_not_found");
        }
    }

    public static final void J0(View view) {
        j.f("<this>", view);
        view.setVisibility(8);
    }

    public static final dc.d J1(Socket socket) {
        Logger logger = dc.b0.f4742a;
        dc.o0 o0Var = new dc.o0(socket);
        InputStream inputStream = socket.getInputStream();
        j.e("getInputStream()", inputStream);
        return new dc.d(o0Var, new dc.d(inputStream, (s0) o0Var));
    }

    public static final x1 K(c0 c0Var, xa.e eVar, wa.a aVar, wa.a aVar2, wa.a aVar3) {
        j.f("<this>", c0Var);
        return new x1(eVar, aVar, aVar3, aVar2);
    }

    public static final void K0(pa.k kVar, Throwable th) {
        try {
            CoroutineExceptionHandler coroutineExceptionHandler = (CoroutineExceptionHandler) kVar.N(CoroutineExceptionHandler.f9430e);
            if (coroutineExceptionHandler != null) {
                coroutineExceptionHandler.z(kVar, th);
            } else {
                L0(kVar, th);
            }
        } catch (Throwable th2) {
            if (th != th2) {
                RuntimeException runtimeException = new RuntimeException("Exception while trying to handle coroutine exception", th2);
                a.a(runtimeException, th);
                th = runtimeException;
            }
            L0(kVar, th);
        }
    }

    public static final Object K1(mb.y yVar, mb.y yVar2, p pVar) {
        Object obj;
        Object Q;
        try {
            xa.y.c(2, pVar);
            obj = pVar.g(yVar2, yVar);
        } catch (Throwable th) {
            obj = new w(th, false);
        }
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (obj == aVar || (Q = yVar.Q(obj)) == v1.f7868b) {
            return aVar;
        }
        if (!(Q instanceof w)) {
            return v1.a(Q);
        }
        throw ((w) Q).f7875a;
    }

    public static final Object L(long j10, e eVar) {
        m0 m0Var;
        if (j10 <= 0) {
            return v.f9814a;
        }
        l lVar = new l(1, qa.d.b(eVar));
        lVar.w();
        if (j10 < Long.MAX_VALUE) {
            pa.h N = lVar.f7822l.N(pa.g.f12752g);
            if (N instanceof m0) {
                m0Var = (m0) N;
            } else {
                m0Var = null;
            }
            if (m0Var == null) {
                m0Var = j0.f7813a;
            }
            m0Var.W(j10, lVar);
        }
        Object u10 = lVar.u();
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (u10 == aVar) {
            m1(eVar);
        }
        if (u10 == aVar) {
            return u10;
        }
        return v.f9814a;
    }

    public static final void L0(pa.k kVar, Throwable th) {
        Throwable th2;
        for (CoroutineExceptionHandler z10 : mb.g.f10853a) {
            try {
                z10.z(kVar, th);
            } catch (mb.k unused) {
                return;
            } catch (Throwable th3) {
                if (th == th3) {
                    th2 = th;
                } else {
                    th2 = new RuntimeException("Exception while trying to handle coroutine exception", th3);
                    a.a(th2, th);
                }
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, th2);
            }
        }
        try {
            a.a(th, new mb.h(kVar));
        } catch (Throwable unused2) {
        }
        Thread currentThread2 = Thread.currentThread();
        currentThread2.getUncaughtExceptionHandler().uncaughtException(currentThread2, th);
    }

    public static final r1 L1(r1 r1Var) {
        q1 q1Var = new q1(r1Var);
        u1 u1Var = r1Var.f12967n;
        q1Var.f12940g = new qb.a(u1Var.contentType(), u1Var.contentLength());
        return q1Var.a();
    }

    public static final void M(int i10, String str) {
        File[] listFiles;
        j.g("fileTempDir", str);
        try {
            File file = new File(str);
            if (file.exists() && (listFiles = file.listFiles()) != null) {
                ArrayList arrayList = new ArrayList();
                for (File file2 : listFiles) {
                    j.b("file", file2);
                    String name = file2.getName();
                    j.e("name", name);
                    String P = y.P(name, ".", name);
                    StringBuilder sb2 = new StringBuilder();
                    sb2.append(i10);
                    sb2.append('.');
                    if (w.m(P, sb2.toString(), false)) {
                        arrayList.add(file2);
                    }
                }
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    File file3 = (File) it.next();
                    if (file3.exists()) {
                        file3.delete();
                    }
                }
            }
        } catch (Exception unused) {
        }
    }

    public static final boolean M0(long j10, long j11, long j12) {
        return TimeUnit.NANOSECONDS.toMillis(j11 - j10) >= j12;
    }

    public static final long M1(String str, long j10, long j11, long j12) {
        String str2;
        boolean z10;
        int i10 = mb.b0.f10840a;
        try {
            str2 = System.getProperty(str);
        } catch (SecurityException unused) {
            str2 = null;
        }
        if (str2 == null) {
            return j10;
        }
        Long e10 = fb.v.e(str2);
        if (e10 != null) {
            long longValue = e10.longValue();
            if (j11 > longValue || longValue > j12) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                return longValue;
            }
            throw new IllegalStateException(("System property '" + str + "' should be in range " + j11 + ".." + j12 + ", but is '" + longValue + '\'').toString());
        }
        throw new IllegalStateException(("System property '" + str + "' has unrecognized value '" + str2 + '\'').toString());
    }

    public static final void N(k4.g gVar, f0 f0Var) {
        try {
            Iterator it = ((ArrayList) gVar.g(f0Var)).iterator();
            IOException iOException = null;
            while (it.hasNext()) {
                f0 f0Var2 = (f0) it.next();
                try {
                    if (gVar.h(f0Var2).f4812b) {
                        N(gVar, f0Var2);
                    }
                    gVar.e(f0Var2);
                } catch (IOException e10) {
                    if (iOException == null) {
                        iOException = e10;
                    }
                }
            }
            if (iOException != null) {
                throw iOException;
            }
        } catch (FileNotFoundException unused) {
        }
    }

    public static final void N0(String str) {
        boolean z10;
        boolean z11;
        j.f("name", str);
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int length = str.length();
            int i10 = 0;
            while (i10 < length) {
                char charAt = str.charAt(i10);
                if ('!' > charAt || charAt >= 127) {
                    z11 = false;
                } else {
                    z11 = true;
                }
                if (z11) {
                    i10++;
                } else {
                    StringBuilder sb2 = new StringBuilder("Unexpected char 0x");
                    fb.a.a(16);
                    String num = Integer.toString(charAt, 16);
                    j.e("toString(this, checkRadix(radix))", num);
                    if (num.length() < 2) {
                        num = "0".concat(num);
                    }
                    sb2.append(num);
                    sb2.append(" at ");
                    sb2.append(i10);
                    sb2.append(" in header name: ");
                    sb2.append(str);
                    throw new IllegalArgumentException(sb2.toString().toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("name is empty".toString());
    }

    public static int N1(String str, int i10, int i11, int i12, int i13) {
        if ((i13 & 4) != 0) {
            i11 = 1;
        }
        if ((i13 & 8) != 0) {
            i12 = Integer.MAX_VALUE;
        }
        return (int) M1(str, (long) i10, (long) i11, (long) i12);
    }

    public static final void O(ImageButton imageButton) {
        imageButton.setEnabled(false);
        imageButton.setColorFilter(-7829368);
    }

    public static final void O0(String str, String str2) {
        String str3;
        boolean z10;
        j.f("value", str);
        j.f("name", str2);
        int length = str.length();
        for (int i10 = 0; i10 < length; i10++) {
            char charAt = str.charAt(i10);
            boolean z11 = true;
            if (charAt != 9) {
                if (' ' > charAt || charAt >= 127) {
                    z10 = false;
                } else {
                    z10 = true;
                }
                if (!z10) {
                    z11 = false;
                }
            }
            if (!z11) {
                StringBuilder sb2 = new StringBuilder("Unexpected char 0x");
                fb.a.a(16);
                String num = Integer.toString(charAt, 16);
                j.e("toString(this, checkRadix(radix))", num);
                if (num.length() < 2) {
                    num = "0".concat(num);
                }
                sb2.append(num);
                sb2.append(" at ");
                sb2.append(i10);
                sb2.append(" in ");
                sb2.append(str2);
                sb2.append(" value");
                if (qb.f.k(str2)) {
                    str3 = "";
                } else {
                    str3 = ": ".concat(str);
                }
                sb2.append(str3);
                throw new IllegalArgumentException(sb2.toString().toString());
            }
        }
    }

    public static final void O1(Object obj) {
        if (obj instanceof la.k) {
            throw ((la.k) obj).f9801h;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0050, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0051, code lost:
        A(r1, r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0054, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void P(v3.d r4) {
        /*
            na.c r0 = new na.c
            r0.<init>()
            java.lang.String r1 = "SELECT name FROM sqlite_master WHERE type = 'trigger'"
            android.database.Cursor r1 = r4.C0(r1)
        L_0x000b:
            boolean r2 = r1.moveToNext()     // Catch:{ all -> 0x004e }
            r3 = 0
            if (r2 == 0) goto L_0x001a
            java.lang.String r2 = r1.getString(r3)     // Catch:{ all -> 0x004e }
            r0.add(r2)     // Catch:{ all -> 0x004e }
            goto L_0x000b
        L_0x001a:
            la.v r2 = la.v.f9814a     // Catch:{ all -> 0x004e }
            r2 = 0
            A(r1, r2)
            ma.q.a(r0)
            java.util.Iterator r0 = r0.iterator()
        L_0x0027:
            r1 = r0
            na.b r1 = (na.b) r1
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x004d
            java.lang.Object r1 = r1.next()
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "triggerName"
            xa.j.e(r2, r1)
            java.lang.String r2 = "room_fts_content_sync_"
            boolean r2 = fb.w.m(r1, r2, r3)
            if (r2 == 0) goto L_0x0027
            java.lang.String r2 = "DROP TRIGGER IF EXISTS "
            java.lang.String r1 = r2.concat(r1)
            r4.p(r1)
            goto L_0x0027
        L_0x004d:
            return
        L_0x004e:
            r4 = move-exception
            throw r4     // Catch:{ all -> 0x0050 }
        L_0x0050:
            r0 = move-exception
            A(r1, r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.P(v3.d):void");
    }

    public static final void P0(View view) {
        Object systemService = view.getContext().getSystemService("input_method");
        j.d("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager", systemService);
        ((InputMethodManager) systemService).hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static final Object[] P1(Collection collection) {
        j.f("collection", collection);
        int size = collection.size();
        Object[] objArr = f7804c;
        if (size == 0) {
            return objArr;
        }
        Iterator it = collection.iterator();
        if (!it.hasNext()) {
            return objArr;
        }
        Object[] objArr2 = new Object[size];
        int i10 = 0;
        while (true) {
            int i11 = i10 + 1;
            objArr2[i10] = it.next();
            if (i11 >= objArr2.length) {
                if (!it.hasNext()) {
                    return objArr2;
                }
                int i12 = ((i11 * 3) + 1) >>> 1;
                if (i12 <= i11) {
                    i12 = 2147483645;
                    if (i11 >= 2147483645) {
                        throw new OutOfMemoryError();
                    }
                }
                objArr2 = Arrays.copyOf(objArr2, i12);
                j.e("copyOf(result, newSize)", objArr2);
            } else if (!it.hasNext()) {
                Object[] copyOf = Arrays.copyOf(objArr2, i11);
                j.e("copyOf(result, size)", copyOf);
                return copyOf;
            }
            i10 = i11;
        }
    }

    public static final Object Q(kb.j jVar, i iVar, e eVar) {
        if (!(jVar instanceof l1)) {
            Object b10 = iVar.b(jVar, eVar);
            if (b10 == qa.a.COROUTINE_SUSPENDED) {
                return b10;
            }
            return v.f9814a;
        }
        throw ((l1) jVar).f9350h;
    }

    public static /* synthetic */ q0 Q0(l1 l1Var, boolean z10, p1 p1Var, int i10) {
        boolean z11 = false;
        if ((i10 & 1) != 0) {
            z10 = false;
        }
        if ((i10 & 2) != 0) {
            z11 = true;
        }
        return ((u1) l1Var).M(z10, z11, p1Var);
    }

    public static final Object[] Q1(Collection collection, Object[] objArr) {
        Object[] objArr2;
        j.f("collection", collection);
        objArr.getClass();
        int size = collection.size();
        int i10 = 0;
        if (size != 0) {
            Iterator it = collection.iterator();
            if (it.hasNext()) {
                if (size <= objArr.length) {
                    objArr2 = objArr;
                } else {
                    Object newInstance = Array.newInstance(objArr.getClass().getComponentType(), size);
                    j.d("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>", newInstance);
                    objArr2 = (Object[]) newInstance;
                }
                while (true) {
                    int i11 = i10 + 1;
                    objArr2[i10] = it.next();
                    if (i11 >= objArr2.length) {
                        if (!it.hasNext()) {
                            return objArr2;
                        }
                        int i12 = ((i11 * 3) + 1) >>> 1;
                        if (i12 <= i11) {
                            i12 = 2147483645;
                            if (i11 >= 2147483645) {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i12);
                        j.e("copyOf(result, newSize)", objArr2);
                    } else if (!it.hasNext()) {
                        if (objArr2 == objArr) {
                            objArr[i11] = null;
                            return objArr;
                        }
                        Object[] copyOf = Arrays.copyOf(objArr2, i11);
                        j.e("copyOf(result, size)", copyOf);
                        return copyOf;
                    }
                    i10 = i11;
                }
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0091, code lost:
        r10 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0092, code lost:
        if (r9 != false) goto L_0x0094;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0096, code lost:
        if ((r7 instanceof java.util.concurrent.CancellationException) != false) goto L_0x0098;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0098, code lost:
        r3 = r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x009b, code lost:
        if (r3 == null) goto L_0x009d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x009d, code lost:
        r3 = new java.util.concurrent.CancellationException("Channel was consumed, consumer had failed");
        r3.initCause(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00a7, code lost:
        r8.e(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00aa, code lost:
        throw r10;
     */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0049  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x0091 }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0065 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0071 A[Catch:{ all -> 0x0091 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008a  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object R(kb.j r7, jb.s r8, boolean r9, pa.e r10) {
        /*
            boolean r0 = r10 instanceof kb.m
            if (r0 == 0) goto L_0x0013
            r0 = r10
            kb.m r0 = (kb.m) r0
            int r1 = r0.f9356m
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9356m = r1
            goto L_0x0018
        L_0x0013:
            kb.m r0 = new kb.m
            r0.<init>(r10)
        L_0x0018:
            java.lang.Object r10 = r0.f9355l
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9356m
            r3 = 0
            r4 = 1
            r5 = 2
            if (r2 == 0) goto L_0x0049
            if (r2 == r4) goto L_0x003d
            if (r2 != r5) goto L_0x0035
            boolean r9 = r0.f9354k
            jb.b r7 = r0.f9353j
            jb.s r8 = r0.f9352i
            kb.j r2 = r0.f9351h
            O1(r10)     // Catch:{ all -> 0x0086 }
        L_0x0032:
            r10 = r7
            r7 = r2
            goto L_0x0054
        L_0x0035:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L_0x003d:
            boolean r9 = r0.f9354k
            jb.b r7 = r0.f9353j
            jb.s r8 = r0.f9352i
            kb.j r2 = r0.f9351h
            O1(r10)     // Catch:{ all -> 0x0086 }
            goto L_0x0069
        L_0x0049:
            O1(r10)
            boolean r10 = r7 instanceof kb.l1
            if (r10 != 0) goto L_0x00ab
            jb.b r10 = r8.iterator()     // Catch:{ all -> 0x0086 }
        L_0x0054:
            r0.f9351h = r7     // Catch:{ all -> 0x0086 }
            r0.f9352i = r8     // Catch:{ all -> 0x0086 }
            r0.f9353j = r10     // Catch:{ all -> 0x0086 }
            r0.f9354k = r9     // Catch:{ all -> 0x0086 }
            r0.f9356m = r4     // Catch:{ all -> 0x0086 }
            java.lang.Object r2 = r10.b(r0)     // Catch:{ all -> 0x0086 }
            if (r2 != r1) goto L_0x0065
            return r1
        L_0x0065:
            r6 = r2
            r2 = r7
            r7 = r10
            r10 = r6
        L_0x0069:
            java.lang.Boolean r10 = (java.lang.Boolean) r10     // Catch:{ all -> 0x0086 }
            boolean r10 = r10.booleanValue()     // Catch:{ all -> 0x0086 }
            if (r10 == 0) goto L_0x0088
            java.lang.Object r10 = r7.c()     // Catch:{ all -> 0x0086 }
            r0.f9351h = r2     // Catch:{ all -> 0x0086 }
            r0.f9352i = r8     // Catch:{ all -> 0x0086 }
            r0.f9353j = r7     // Catch:{ all -> 0x0086 }
            r0.f9354k = r9     // Catch:{ all -> 0x0086 }
            r0.f9356m = r5     // Catch:{ all -> 0x0086 }
            java.lang.Object r10 = r2.a(r10, r0)     // Catch:{ all -> 0x0086 }
            if (r10 != r1) goto L_0x0032
            return r1
        L_0x0086:
            r7 = move-exception
            goto L_0x0090
        L_0x0088:
            if (r9 == 0) goto L_0x008d
            r8.e(r3)
        L_0x008d:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0090:
            throw r7     // Catch:{ all -> 0x0091 }
        L_0x0091:
            r10 = move-exception
            if (r9 == 0) goto L_0x00aa
            boolean r9 = r7 instanceof java.util.concurrent.CancellationException
            if (r9 == 0) goto L_0x009b
            r3 = r7
            java.util.concurrent.CancellationException r3 = (java.util.concurrent.CancellationException) r3
        L_0x009b:
            if (r3 != 0) goto L_0x00a7
            java.util.concurrent.CancellationException r3 = new java.util.concurrent.CancellationException
            java.lang.String r9 = "Channel was consumed, consumer had failed"
            r3.<init>(r9)
            r3.initCause(r7)
        L_0x00a7:
            r8.e(r3)
        L_0x00aa:
            throw r10
        L_0x00ab:
            kb.l1 r7 = (kb.l1) r7
            java.lang.Throwable r7 = r7.f9350h
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.R(kb.j, jb.s, boolean, pa.e):java.lang.Object");
    }

    public static final boolean R0(AssertionError assertionError) {
        boolean z10;
        Logger logger = dc.b0.f4742a;
        if (assertionError.getCause() == null) {
            return false;
        }
        String message = assertionError.getMessage();
        if (message != null) {
            z10 = y.n(message, "getsockname failed", false);
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:94:0x014e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String R1(java.lang.String r10) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r10)
            java.lang.String r0 = ":"
            r1 = 0
            boolean r0 = fb.y.n(r10, r0, r1)
            r2 = 4
            r3 = 1
            r4 = 0
            r5 = -1
            if (r0 == 0) goto L_0x00bb
            java.lang.String r0 = "["
            boolean r0 = fb.w.m(r10, r0, r1)
            if (r0 == 0) goto L_0x002c
            java.lang.String r0 = "]"
            boolean r0 = fb.w.f(r10, r0, r1)
            if (r0 == 0) goto L_0x002c
            int r0 = r10.length()
            int r0 = r0 - r3
            byte[] r0 = qb.b.a(r3, r0, r10)
            goto L_0x0034
        L_0x002c:
            int r0 = r10.length()
            byte[] r0 = qb.b.a(r1, r0, r10)
        L_0x0034:
            if (r0 != 0) goto L_0x0037
            return r4
        L_0x0037:
            java.net.InetAddress r0 = java.net.InetAddress.getByAddress(r0)
            byte[] r3 = r0.getAddress()
            int r4 = r3.length
            r6 = 16
            if (r4 != r6) goto L_0x009a
            r10 = 0
            r0 = 0
        L_0x0046:
            int r4 = r3.length
            if (r10 >= r4) goto L_0x0064
            r4 = r10
        L_0x004a:
            if (r4 >= r6) goto L_0x0059
            byte r7 = r3[r4]
            if (r7 != 0) goto L_0x0059
            int r7 = r4 + 1
            byte r7 = r3[r7]
            if (r7 != 0) goto L_0x0059
            int r4 = r4 + 2
            goto L_0x004a
        L_0x0059:
            int r7 = r4 - r10
            if (r7 <= r0) goto L_0x0061
            if (r7 < r2) goto L_0x0061
            r5 = r10
            r0 = r7
        L_0x0061:
            int r10 = r4 + 2
            goto L_0x0046
        L_0x0064:
            dc.j r10 = new dc.j
            r10.<init>()
        L_0x0069:
            int r2 = r3.length
            if (r1 >= r2) goto L_0x0095
            r2 = 58
            if (r1 != r5) goto L_0x007a
            r10.Q0(r2)
            int r1 = r1 + r0
            if (r1 != r6) goto L_0x0069
            r10.Q0(r2)
            goto L_0x0069
        L_0x007a:
            if (r1 <= 0) goto L_0x007f
            r10.Q0(r2)
        L_0x007f:
            byte r2 = r3[r1]
            byte[] r4 = qb.f.f13487a
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            int r4 = r1 + 1
            byte r4 = r3[r4]
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = r2 | r4
            long r7 = (long) r2
            r10.S0(r7)
            int r1 = r1 + 2
            goto L_0x0069
        L_0x0095:
            java.lang.String r10 = r10.j0()
            return r10
        L_0x009a:
            int r1 = r3.length
            if (r1 != r2) goto L_0x00a2
            java.lang.String r10 = r0.getHostAddress()
            return r10
        L_0x00a2:
            java.lang.AssertionError r0 = new java.lang.AssertionError
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Invalid IPv6 address: '"
            r1.<init>(r2)
            r1.append(r10)
            r10 = 39
            r1.append(r10)
            java.lang.String r10 = r1.toString()
            r0.<init>(r10)
            throw r0
        L_0x00bb:
            java.lang.String r10 = java.net.IDN.toASCII(r10)     // Catch:{ IllegalArgumentException -> 0x014f }
            java.lang.String r0 = "toASCII(host)"
            xa.j.e(r0, r10)     // Catch:{ IllegalArgumentException -> 0x014f }
            java.util.Locale r0 = java.util.Locale.US     // Catch:{ IllegalArgumentException -> 0x014f }
            java.lang.String r6 = "US"
            xa.j.e(r6, r0)     // Catch:{ IllegalArgumentException -> 0x014f }
            java.lang.String r10 = r10.toLowerCase(r0)     // Catch:{ IllegalArgumentException -> 0x014f }
            java.lang.String r0 = "this as java.lang.String).toLowerCase(locale)"
            xa.j.e(r0, r10)     // Catch:{ IllegalArgumentException -> 0x014f }
            int r0 = r10.length()     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r0 != 0) goto L_0x00dc
            r0 = 1
            goto L_0x00dd
        L_0x00dc:
            r0 = 0
        L_0x00dd:
            if (r0 == 0) goto L_0x00e0
            return r4
        L_0x00e0:
            fb.l r0 = qb.b.f13476a     // Catch:{ IllegalArgumentException -> 0x014f }
            int r0 = r10.length()     // Catch:{ IllegalArgumentException -> 0x014f }
            r6 = 0
        L_0x00e7:
            if (r6 >= r0) goto L_0x010d
            char r7 = r10.charAt(r6)     // Catch:{ IllegalArgumentException -> 0x014f }
            r8 = 31
            int r8 = xa.j.h(r7, r8)     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r8 <= 0) goto L_0x010b
            r8 = 127(0x7f, float:1.78E-43)
            int r8 = xa.j.h(r7, r8)     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r8 < 0) goto L_0x00fe
            goto L_0x010b
        L_0x00fe:
            java.lang.String r8 = " #%/:?@[\\]"
            r9 = 6
            int r7 = fb.y.t(r8, r7, r1, r1, r9)     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r7 == r5) goto L_0x0108
            goto L_0x010b
        L_0x0108:
            int r6 = r6 + 1
            goto L_0x00e7
        L_0x010b:
            r0 = 1
            goto L_0x010e
        L_0x010d:
            r0 = 0
        L_0x010e:
            if (r0 == 0) goto L_0x0111
            goto L_0x014f
        L_0x0111:
            int r0 = r10.length()     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r3 > r0) goto L_0x011d
            r6 = 254(0xfe, float:3.56E-43)
            if (r0 >= r6) goto L_0x011d
            r0 = 1
            goto L_0x011e
        L_0x011d:
            r0 = 0
        L_0x011e:
            if (r0 != 0) goto L_0x0121
            goto L_0x013d
        L_0x0121:
            r0 = 0
        L_0x0122:
            r6 = 46
            int r6 = fb.y.t(r10, r6, r0, r1, r2)     // Catch:{ IllegalArgumentException -> 0x014f }
            if (r6 != r5) goto L_0x0130
            int r7 = r10.length()     // Catch:{ IllegalArgumentException -> 0x014f }
            int r7 = r7 - r0
            goto L_0x0132
        L_0x0130:
            int r7 = r6 - r0
        L_0x0132:
            if (r3 > r7) goto L_0x013a
            r0 = 64
            if (r7 >= r0) goto L_0x013a
            r0 = 1
            goto L_0x013b
        L_0x013a:
            r0 = 0
        L_0x013b:
            if (r0 != 0) goto L_0x013f
        L_0x013d:
            r1 = 1
            goto L_0x014b
        L_0x013f:
            if (r6 == r5) goto L_0x014b
            int r0 = r10.length()     // Catch:{ IllegalArgumentException -> 0x014f }
            int r0 = r0 - r3
            if (r6 == r0) goto L_0x014b
            int r0 = r6 + 1
            goto L_0x0122
        L_0x014b:
            if (r1 == 0) goto L_0x014e
            goto L_0x014f
        L_0x014e:
            r4 = r10
        L_0x014f:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.R1(java.lang.String):java.lang.String");
    }

    public static final void S(ImageButton imageButton) {
        imageButton.setEnabled(true);
        imageButton.setColorFilter(-1);
    }

    public static final boolean S0(MotionEvent motionEvent, float[] fArr) {
        j.f("<this>", motionEvent);
        j.f("outDownLocation", fArr);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            fArr[0] = motionEvent.getX();
            fArr[1] = motionEvent.getY();
        } else if (actionMasked == 1) {
            float f10 = (float) 50;
            float x10 = motionEvent.getX() + f10;
            float f11 = fArr[0];
            if (motionEvent.getX() - f10 <= f11 && f11 <= x10) {
                float y10 = motionEvent.getY() + f10;
                float f12 = fArr[1];
                return (((motionEvent.getY() - f10) > f12 ? 1 : ((motionEvent.getY() - f10) == f12 ? 0 : -1)) <= 0 && (f12 > y10 ? 1 : (f12 == y10 ? 0 : -1)) <= 0) && motionEvent.getEventTime() - motionEvent.getDownTime() <= 500;
            }
        }
    }

    public static final String S1(e eVar) {
        String str;
        if (eVar instanceof mb.i) {
            return eVar.toString();
        }
        try {
            int i10 = l.f9802h;
            str = eVar + '@' + r0(eVar);
        } catch (Throwable th) {
            int i11 = l.f9802h;
            str = I(th);
        }
        Throwable a10 = l.a(str);
        String str2 = str;
        if (a10 != null) {
            str2 = eVar.getClass().getName() + '@' + r0(eVar);
        }
        return (String) str2;
    }

    public static final void T(pa.k kVar) {
        l1 l1Var = (l1) kVar.N(l1.f7823b);
        if (l1Var != null && !l1Var.c()) {
            throw ((u1) l1Var).C();
        }
    }

    public static final boolean T0(Object obj) {
        return obj == d.f10843a;
    }

    public static final void T1(b bVar, q9.e eVar) {
        j.g("$this$toDownloadInfo", bVar);
        j.g("downloadInfo", eVar);
        q9.e eVar2 = (q9.e) bVar;
        eVar.f13433h = eVar2.f13433h;
        eVar.H(eVar2.f13434i);
        eVar.M(eVar2.f13435j);
        eVar.G(eVar2.f13436k);
        eVar.f13437l = eVar2.f13437l;
        eVar.J(eVar2.f13438m);
        eVar.f13439n = j0.g(eVar2.f13439n);
        eVar.f13440o = eVar2.f13440o;
        eVar.f13441p = eVar2.f13441p;
        eVar.K(eVar2.f13442q);
        eVar.I(eVar2.f13444s);
        eVar.D(eVar2.f13443r);
        eVar.f13445t = eVar2.f13445t;
        eVar.f13446u = eVar2.f13446u;
        eVar.C(eVar2.f13447v);
        eVar.f13448w = eVar2.f13448w;
        eVar.f13449x = eVar2.f13449x;
        eVar.F(eVar2.f13450y);
        eVar.f13451z = eVar2.f13451z;
        eVar.A = eVar2.A;
    }

    public static void U(o oVar, Collection collection) {
        a6.c cVar;
        u3.o c10;
        j.f("emotes", collection);
        r3.n0 n0Var = oVar.f250a;
        n0Var.b();
        n0Var.c();
        try {
            cVar = oVar.f251b;
            cVar.getClass();
            c10 = cVar.c();
            for (Object h10 : collection) {
                cVar.h(c10, h10);
                c10.A0();
            }
            cVar.g(c10);
            n0Var.r();
            n0Var.g();
            n0Var.b();
            n nVar = oVar.f252c;
            u3.o c11 = nVar.c();
            n0Var.c();
            try {
                c11.x();
                n0Var.r();
            } finally {
                n0Var.g();
                nVar.g(c11);
            }
        } catch (Throwable th) {
            n0Var.g();
            throw th;
        }
    }

    public static final boolean U0(String str) {
        boolean z10;
        j.g("url", str);
        try {
            if (!w.m(str, "fetchlocal://", false)) {
                return false;
            }
            if (j0(str).length() > 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10 || k0(str) <= -1) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static final List U1(ArrayList arrayList) {
        int size = arrayList.size();
        if (size == 0) {
            return ma.b0.f10801h;
        }
        if (size != 1) {
            return Collections.unmodifiableList(new ArrayList(arrayList));
        }
        return Collections.singletonList(ma.z.s(arrayList));
    }

    public static final k0 V(c0 c0Var) {
        androidx.fragment.app.t tVar;
        Dialog dialog;
        Window window;
        j.f("<this>", c0Var);
        NavHostFragment.f1870h0.getClass();
        for (c0 c0Var2 = c0Var; c0Var2 != null; c0Var2 = c0Var2.C) {
            if (c0Var2 instanceof NavHostFragment) {
                return ((NavHostFragment) c0Var2).l0();
            }
            c0 c0Var3 = c0Var2.x().f1395y;
            if (c0Var3 instanceof NavHostFragment) {
                return ((NavHostFragment) c0Var3).l0();
            }
        }
        View view = c0Var.M;
        if (view != null) {
            return k2.a(view);
        }
        View view2 = null;
        if (c0Var instanceof androidx.fragment.app.t) {
            tVar = (androidx.fragment.app.t) c0Var;
        } else {
            tVar = null;
        }
        if (!(tVar == null || (dialog = tVar.f1574o0) == null || (window = dialog.getWindow()) == null)) {
            view2 = window.getDecorView();
        }
        if (view2 != null) {
            return k2.a(view2);
        }
        throw new IllegalStateException(android.support.v4.media.h.l("Fragment ", c0Var, " does not have a NavController set"));
    }

    public static final boolean V0(Bitmap.Config config) {
        return Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE;
    }

    public static final Map V1(Map map) {
        int size = map.size();
        if (size == 0) {
            return j0.d();
        }
        if (size != 1) {
            return Collections.unmodifiableMap(new LinkedHashMap(map));
        }
        Map.Entry entry = (Map.Entry) ma.z.r(map.entrySet());
        return Collections.singletonMap(entry.getKey(), entry.getValue());
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [wa.p] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object W(lb.a0 r5, kb.f0 r6, pa.e r7) {
        /*
            boolean r0 = r7 instanceof kb.e0
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kb.e0 r0 = (kb.e0) r0
            int r1 = r0.f9297l
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9297l = r1
            goto L_0x0018
        L_0x0013:
            kb.e0 r0 = new kb.e0
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f9296k
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9297l
            r3 = 1
            if (r2 == 0) goto L_0x003b
            if (r2 != r3) goto L_0x0033
            kb.d0 r5 = r0.f9295j
            xa.u r6 = r0.f9294i
            wa.p r0 = r0.f9293h
            O1(r7)     // Catch:{ a -> 0x002d }
            goto L_0x0061
        L_0x002d:
            r7 = move-exception
            r4 = r7
            r7 = r6
            r6 = r0
            r0 = r4
            goto L_0x005b
        L_0x0033:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x003b:
            O1(r7)
            xa.u r7 = new xa.u
            r7.<init>()
            h3.u1 r2 = lb.t.f9862a
            r7.f16818h = r2
            kb.d0 r2 = new kb.d0
            r2.<init>(r6, r7)
            r0.f9293h = r6     // Catch:{ a -> 0x0058 }
            r0.f9294i = r7     // Catch:{ a -> 0x0058 }
            r0.f9295j = r2     // Catch:{ a -> 0x0058 }
            r0.f9297l = r3     // Catch:{ a -> 0x0058 }
            r5.b(r2, r0)     // Catch:{ a -> 0x0058 }
            goto L_0x0067
        L_0x0058:
            r5 = move-exception
            r0 = r5
            r5 = r2
        L_0x005b:
            kb.j r1 = r0.f9817h
            if (r1 != r5) goto L_0x007c
            r0 = r6
            r6 = r7
        L_0x0061:
            java.lang.Object r1 = r6.f16818h
            h3.u1 r5 = lb.t.f9862a
            if (r1 == r5) goto L_0x0068
        L_0x0067:
            return r1
        L_0x0068:
            java.util.NoSuchElementException r5 = new java.util.NoSuchElementException
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            java.lang.String r7 = "Expected at least one element matching the predicate "
            r6.<init>(r7)
            r6.append(r0)
            java.lang.String r6 = r6.toString()
            r5.<init>(r6)
            throw r5
        L_0x007c:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.W(lb.a0, kb.f0, pa.e):java.lang.Object");
    }

    public static final boolean W0(SlidingLayout slidingLayout) {
        Rect rect = new Rect();
        slidingLayout.getWindowVisibleDisplayFrame(rect);
        int height = slidingLayout.getRootView().getHeight();
        return ((double) (height - rect.bottom)) > ((double) height) * 0.15d;
    }

    public static final int W1(t4.c cVar, int i10) {
        if (cVar instanceof t4.a) {
            return ((t4.a) cVar).f14542a;
        }
        if (i10 != 0) {
            int i11 = i10 - 1;
            if (i11 == 0) {
                return RecyclerView.UNDEFINED_DURATION;
            }
            if (i11 == 1) {
                return Integer.MAX_VALUE;
            }
            throw new la.g();
        }
        throw null;
    }

    public static final pa.k X(pa.k kVar, pa.k kVar2, boolean z10) {
        Boolean bool = Boolean.FALSE;
        a0 a0Var = a0.f7776h;
        boolean booleanValue = ((Boolean) kVar.j0(bool, a0Var)).booleanValue();
        boolean booleanValue2 = ((Boolean) kVar2.j0(bool, a0Var)).booleanValue();
        if (!booleanValue && !booleanValue2) {
            return kVar.I0(kVar2);
        }
        xa.u uVar = new xa.u();
        uVar.f16818h = kVar2;
        pa.l lVar = pa.l.f12754h;
        pa.k kVar3 = (pa.k) kVar.j0(lVar, new fb.x(2, uVar, z10));
        if (booleanValue2) {
            uVar.f16818h = ((pa.k) uVar.f16818h).j0(lVar, z.f7884h);
        }
        return kVar3.I0((pa.k) uVar.f16818h);
    }

    public static final boolean X0(Context context) {
        j.f("<this>", context);
        Object systemService = context.getSystemService("connectivity");
        j.d("null cannot be cast to non-null type android.net.ConnectivityManager", systemService);
        ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            activeNetworkInfo = connectivityManager.getNetworkInfo(17);
        }
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
            return false;
        }
        return true;
    }

    public static final void X1(Context context, int i10) {
        j.f("<this>", context);
        Toast.makeText(context, i10, 1).show();
    }

    public static final String Y(long j10) {
        StringBuilder sb2;
        long j11;
        long j12;
        StringBuilder sb3;
        long j13;
        if (j10 <= -999500000) {
            sb2 = new StringBuilder();
            j11 = j10 - ((long) 500000000);
        } else {
            if (j10 <= -999500) {
                sb2 = new StringBuilder();
                j12 = j10 - ((long) 500000);
            } else {
                if (j10 <= 0) {
                    sb3 = new StringBuilder();
                    j13 = j10 - ((long) 500);
                } else if (j10 < 999500) {
                    sb3 = new StringBuilder();
                    j13 = j10 + ((long) 500);
                } else if (j10 < 999500000) {
                    j12 = j10 + ((long) 500000);
                } else {
                    sb2 = new StringBuilder();
                    j11 = j10 + ((long) 500000000);
                }
                sb3.append(j13 / ((long) 1000));
                sb3.append(" µs");
                String sb4 = sb3.toString();
                xa.x xVar = xa.x.f16820a;
                String format = String.format("%6s", Arrays.copyOf(new Object[]{sb4}, 1));
                j.e("format(format, *args)", format);
                return format;
            }
            sb3.append(j12 / ((long) 1000000));
            sb3.append(" ms");
            String sb42 = sb3.toString();
            xa.x xVar2 = xa.x.f16820a;
            String format2 = String.format("%6s", Arrays.copyOf(new Object[]{sb42}, 1));
            j.e("format(format, *args)", format2);
            return format2;
        }
        sb3.append(j11 / ((long) 1000000000));
        sb3.append(" s ");
        String sb422 = sb3.toString();
        xa.x xVar22 = xa.x.f16820a;
        String format22 = String.format("%6s", Arrays.copyOf(new Object[]{sb422}, 1));
        j.e("format(format, *args)", format22);
        return format22;
    }

    public static final boolean Y0(Context context) {
        Boolean bool;
        j.g("$this$isNetworkAvailable", context);
        Object systemService = context.getSystemService("connectivity");
        if (systemService != null) {
            ConnectivityManager connectivityManager = (ConnectivityManager) systemService;
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            boolean z10 = true;
            boolean z11 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
            if (z11) {
                return z11;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo != null) {
                int length = allNetworkInfo.length;
                int i10 = 0;
                while (true) {
                    if (i10 >= length) {
                        z10 = false;
                        break;
                    }
                    NetworkInfo networkInfo = allNetworkInfo[i10];
                    j.b("it", networkInfo);
                    if (networkInfo.isConnected()) {
                        break;
                    }
                    i10++;
                }
                bool = Boolean.valueOf(z10);
            } else {
                bool = null;
            }
            return bool.booleanValue();
        }
        throw new q("null cannot be cast to non-null type android.net.ConnectivityManager");
    }

    public static final lb.n Y1(i iVar, wa.q qVar) {
        int i10 = b0.f9268a;
        return new lb.n(qVar, iVar, pa.l.f12754h, -2, jb.a.SUSPEND);
    }

    public static pa.h Z(pa.h hVar, pa.i iVar) {
        j.f("key", iVar);
        if (j.a(hVar.getKey(), iVar)) {
            return hVar;
        }
        return null;
    }

    public static final boolean Z0(t4.g gVar) {
        return j.a(gVar, t4.g.f14547c);
    }

    public static final i2 Z1(e eVar, pa.k kVar, Object obj) {
        boolean z10;
        i2 i2Var = null;
        if (!(eVar instanceof ra.d)) {
            return null;
        }
        if (kVar.N(j2.f7816h) != null) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return null;
        }
        ra.d dVar = (ra.d) eVar;
        while (true) {
            if (!(dVar instanceof n0) && (dVar = dVar.getCallerFrame()) != null) {
                if (dVar instanceof i2) {
                    i2Var = (i2) dVar;
                    break;
                }
            } else {
                break;
            }
        }
        if (i2Var != null) {
            i2Var.g0(kVar, obj);
        }
        return i2Var;
    }

    public static jb.c a(int i10, jb.a aVar, int i11) {
        jb.c cVar;
        boolean z10 = false;
        if ((i11 & 1) != 0) {
            i10 = 0;
        }
        int i12 = i11 & 2;
        jb.a aVar2 = jb.a.SUSPEND;
        if (i12 != 0) {
            aVar = aVar2;
        }
        if (i10 != -2) {
            if (i10 == -1) {
                if (aVar == aVar2) {
                    z10 = true;
                }
                if (z10) {
                    return new jb.o(1, jb.a.DROP_OLDEST, (wa.l) null);
                }
                throw new IllegalArgumentException("CONFLATED capacity cannot be used with non-default onBufferOverflow".toString());
            } else if (i10 != 0) {
                if (i10 == Integer.MAX_VALUE) {
                    return new jb.c(Integer.MAX_VALUE, (wa.l) null);
                }
                if (aVar == aVar2) {
                    return new jb.c(i10, (wa.l) null);
                }
                return new jb.o(i10, aVar, (wa.l) null);
            } else if (aVar == aVar2) {
                cVar = new jb.c(0, (wa.l) null);
            } else {
                cVar = new jb.o(1, aVar, (wa.l) null);
            }
        } else if (aVar == aVar2) {
            g.f8921d.getClass();
            cVar = new jb.c(jb.f.f8920b, (wa.l) null);
        } else {
            cVar = new jb.o(1, aVar, (wa.l) null);
        }
        return cVar;
    }

    public static final int a0(Bitmap bitmap) {
        int i10 = 1;
        if (!bitmap.isRecycled()) {
            try {
                return bitmap.getAllocationByteCount();
            } catch (Exception unused) {
                int height = bitmap.getHeight() * bitmap.getWidth();
                Bitmap.Config config = bitmap.getConfig();
                if (config != Bitmap.Config.ALPHA_8) {
                    if (config == Bitmap.Config.RGB_565 || config == Bitmap.Config.ARGB_4444) {
                        i10 = 2;
                    } else if (Build.VERSION.SDK_INT < 26 || config != Bitmap.Config.RGBA_F16) {
                        i10 = 4;
                    } else {
                        i10 = 8;
                    }
                }
                return height * i10;
            }
        } else {
            throw new IllegalStateException(("Cannot obtain size for recycled bitmap: " + bitmap + " [" + bitmap.getWidth() + " x " + bitmap.getHeight() + "] + " + bitmap.getConfig()).toString());
        }
    }

    public static final boolean a1(String str) {
        boolean z10;
        j.g("path", str);
        boolean z11 = true;
        if (str.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            str = null;
        }
        if (str == null) {
            return false;
        }
        if (!w.m(str, "content://", false) && !w.m(str, "file://", false)) {
            z11 = false;
        }
        return z11;
    }

    public static final m a2(q.l lVar) {
        j.g("receiver$0", lVar);
        return new m(0, lVar);
    }

    public static final boolean b(int i10, Map map) {
        String str;
        String p02 = p0(map, "Accept-Ranges", "accept-ranges", "AcceptRanges");
        String p03 = p0(map, "Transfer-Encoding", "transfer-encoding", "TransferEncoding");
        long d02 = d0(map);
        boolean z10 = i10 == 206 || j.a(p02, "bytes");
        int i11 = (d02 > -1 ? 1 : (d02 == -1 ? 0 : -1));
        if (i11 <= 0 || !z10) {
            if (i11 <= 0) {
                return false;
            }
            if (p03 != null) {
                str = p03.toLowerCase();
                j.b("(this as java.lang.String).toLowerCase()", str);
            } else {
                str = null;
            }
            return j.a(str, "chunked") ^ true;
        }
    }

    public static final h1 b0(ViewGroup viewGroup) {
        j.f("<this>", viewGroup);
        return new h1(0, viewGroup);
    }

    public static c2 b1(f0 f0Var, pa.h hVar, int i10, p pVar, int i11) {
        boolean z10;
        c2 c2Var;
        pa.k kVar = hVar;
        if ((i11 & 1) != 0) {
            kVar = pa.l.f12754h;
        }
        if ((i11 & 2) != 0) {
            i10 = 1;
        }
        pa.k g12 = g1(f0Var, kVar);
        if (i10 == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            c2Var = new w1(g12, pVar);
        } else {
            c2Var = new c2(g12, true);
        }
        c2Var.e0(i10, c2Var, pVar);
        return c2Var;
    }

    public static final void b2(View view) {
        view.setVisibility(0);
    }

    public static final int c(char c10) {
        boolean z10 = false;
        if ('0' <= c10 && c10 < ':') {
            return c10 - '0';
        }
        char c11 = 'a';
        if (!('a' <= c10 && c10 < 'g')) {
            c11 = 'A';
            if ('A' <= c10 && c10 < 'G') {
                z10 = true;
            }
            if (!z10) {
                throw new IllegalArgumentException("Unexpected hex digit: " + c10);
            }
        }
        return (c10 - c11) + 10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
        r0 = r8;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final int c0(android.database.Cursor r13, java.lang.String r14) {
        /*
            java.lang.String r0 = "c"
            xa.j.f(r0, r13)
            int r0 = r13.getColumnIndex(r14)
            if (r0 < 0) goto L_0x000d
            goto L_0x0089
        L_0x000d:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "`"
            r0.<init>(r1)
            r0.append(r14)
            r1 = 96
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            int r0 = r13.getColumnIndex(r0)
            if (r0 < 0) goto L_0x0027
            goto L_0x0089
        L_0x0027:
            int r0 = android.os.Build.VERSION.SDK_INT
            r2 = 25
            r3 = -1
            if (r0 <= r2) goto L_0x002f
            goto L_0x003b
        L_0x002f:
            int r0 = r14.length()
            r2 = 0
            if (r0 != 0) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x003d
        L_0x003b:
            r0 = -1
            goto L_0x0089
        L_0x003d:
            java.lang.String[] r0 = r13.getColumnNames()
            java.lang.String r4 = "columnNames"
            xa.j.e(r4, r0)
            java.lang.String r4 = "."
            java.lang.String r5 = r4.concat(r14)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r4)
            r6.append(r14)
            r6.append(r1)
            java.lang.String r4 = r6.toString()
            int r6 = r0.length
            r7 = 0
            r8 = 0
        L_0x005e:
            if (r7 >= r6) goto L_0x003b
            r9 = r0[r7]
            int r10 = r8 + 1
            int r11 = r9.length()
            int r12 = r14.length()
            int r12 = r12 + 2
            if (r11 < r12) goto L_0x0085
            boolean r11 = fb.w.f(r9, r5, r2)
            if (r11 == 0) goto L_0x0077
            goto L_0x0083
        L_0x0077:
            char r11 = r9.charAt(r2)
            if (r11 != r1) goto L_0x0085
            boolean r9 = fb.w.f(r9, r4, r2)
            if (r9 == 0) goto L_0x0085
        L_0x0083:
            r0 = r8
            goto L_0x0089
        L_0x0085:
            int r7 = r7 + 1
            r8 = r10
            goto L_0x005e
        L_0x0089:
            if (r0 < 0) goto L_0x008c
            return r0
        L_0x008c:
            java.lang.String[] r13 = r13.getColumnNames()     // Catch:{ Exception -> 0x009a }
            java.lang.String r0 = "c.columnNames"
            xa.j.e(r0, r13)     // Catch:{ Exception -> 0x009a }
            java.lang.String r13 = ma.p.h(r13)     // Catch:{ Exception -> 0x009a }
            goto L_0x009c
        L_0x009a:
            java.lang.String r13 = "unknown"
        L_0x009c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "column '"
            r1.<init>(r2)
            r1.append(r14)
            java.lang.String r14 = "' does not exist. Available columns: "
            r1.append(r14)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.c0(android.database.Cursor, java.lang.String):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003a, code lost:
        if (r11.isFinishing() == false) goto L_0x003c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003f A[SYNTHETIC, Splitter:B:17:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void c1(android.widget.ImageView r5, androidx.fragment.app.c0 r6, java.lang.String r7, boolean r8, boolean r9, d5.u r10, int r11) {
        /*
            r0 = r11 & 4
            r1 = 0
            if (r0 == 0) goto L_0x0006
            r8 = 0
        L_0x0006:
            r0 = r11 & 8
            if (r0 == 0) goto L_0x000b
            r9 = 0
        L_0x000b:
            r11 = r11 & 16
            if (r11 == 0) goto L_0x0016
            d5.s r10 = d5.u.f4493c
            java.lang.String r11 = "RESOURCE"
            xa.j.e(r11, r10)
        L_0x0016:
            java.lang.String r11 = "fragment"
            xa.j.f(r11, r6)
            java.lang.String r11 = "diskCacheStrategy"
            xa.j.f(r11, r10)
            android.content.Context r11 = r5.getContext()
            java.lang.String r0 = "context"
            xa.j.e(r0, r11)
            boolean r2 = r11 instanceof android.app.Activity
            r3 = 1
            if (r2 == 0) goto L_0x003c
            android.app.Activity r11 = (android.app.Activity) r11
            boolean r2 = r11.isDestroyed()
            if (r2 != 0) goto L_0x003d
            boolean r11 = r11.isFinishing()
            if (r11 != 0) goto L_0x003d
        L_0x003c:
            r1 = 1
        L_0x003d:
            if (r1 == 0) goto L_0x00aa
            com.bumptech.glide.s r6 = com.bumptech.glide.c.f(r6)     // Catch:{ IllegalArgumentException -> 0x00aa }
            com.bumptech.glide.q r6 = r6.p(r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            s5.a r6 = r6.f(r10)     // Catch:{ IllegalArgumentException -> 0x00aa }
            com.bumptech.glide.q r6 = (com.bumptech.glide.q) r6     // Catch:{ IllegalArgumentException -> 0x00aa }
            m5.d r7 = new m5.d     // Catch:{ IllegalArgumentException -> 0x00aa }
            r7.<init>()     // Catch:{ IllegalArgumentException -> 0x00aa }
            u5.a r10 = new u5.a     // Catch:{ IllegalArgumentException -> 0x00aa }
            r10.<init>()     // Catch:{ IllegalArgumentException -> 0x00aa }
            u5.b r11 = new u5.b     // Catch:{ IllegalArgumentException -> 0x00aa }
            int r10 = r10.f15358a     // Catch:{ IllegalArgumentException -> 0x00aa }
            r11.<init>(r10)     // Catch:{ IllegalArgumentException -> 0x00aa }
            r7.f3318h = r11     // Catch:{ IllegalArgumentException -> 0x00aa }
            com.bumptech.glide.q r6 = r6.J(r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.String r7 = "with(fragment)\n         …nOptions.withCrossFade())"
            xa.j.e(r7, r6)     // Catch:{ IllegalArgumentException -> 0x00aa }
            if (r8 == 0) goto L_0x008f
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IllegalArgumentException -> 0x00aa }
            r10 = 60000(0xea60, double:2.9644E-319)
            long r7 = r7 / r10
            r10 = 10
            long r10 = (long) r10     // Catch:{ IllegalArgumentException -> 0x00aa }
            long r10 = r7 % r10
            r1 = 5
            int r4 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r4 >= 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r1 = 5
            long r1 = (long) r1     // Catch:{ IllegalArgumentException -> 0x00aa }
            long r10 = r10 - r1
        L_0x0082:
            long r7 = r7 - r10
            v5.b r10 = new v5.b     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.Long r7 = java.lang.Long.valueOf(r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            r10.<init>(r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            r6.r(r10)     // Catch:{ IllegalArgumentException -> 0x00aa }
        L_0x008f:
            if (r9 == 0) goto L_0x00a7
            android.content.Context r7 = r5.getContext()     // Catch:{ IllegalArgumentException -> 0x00aa }
            xa.j.e(r0, r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            android.content.SharedPreferences r7 = l1(r7)     // Catch:{ IllegalArgumentException -> 0x00aa }
            java.lang.String r8 = "ui_rounduserimage"
            boolean r7 = r7.getBoolean(r8, r3)     // Catch:{ IllegalArgumentException -> 0x00aa }
            if (r7 == 0) goto L_0x00a7
            r6.c()     // Catch:{ IllegalArgumentException -> 0x00aa }
        L_0x00a7:
            r6.C(r5)     // Catch:{ IllegalArgumentException -> 0x00aa }
        L_0x00aa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.c1(android.widget.ImageView, androidx.fragment.app.c0, java.lang.String, boolean, boolean, d5.u, int):void");
    }

    /* JADX INFO: finally extract failed */
    public static final Object c2(pa.k kVar, p pVar, e eVar) {
        pa.k kVar2;
        Object obj;
        pa.k context = eVar.getContext();
        boolean z10 = false;
        if (!((Boolean) kVar.j0(Boolean.FALSE, a0.f7776h)).booleanValue()) {
            kVar2 = context.I0(kVar);
        } else {
            kVar2 = X(context, kVar, false);
        }
        T(kVar2);
        qa.a aVar = qa.a.COROUTINE_SUSPENDED;
        if (kVar2 == context) {
            mb.y yVar = new mb.y(eVar, kVar2);
            obj = K1(yVar, yVar, pVar);
        } else {
            pa.f fVar = pa.g.f12752g;
            if (j.a(kVar2.N(fVar), context.N(fVar))) {
                i2 i2Var = new i2(eVar, kVar2);
                pa.k kVar3 = i2Var.f7775j;
                Object c10 = mb.f0.c(kVar3, (Object) null);
                try {
                    Object K1 = K1(i2Var, i2Var, pVar);
                    mb.f0.a(kVar3, c10);
                    obj = K1;
                } catch (Throwable th) {
                    mb.f0.a(kVar3, c10);
                    throw th;
                }
            } else {
                n0 n0Var = new n0(eVar, kVar2);
                try {
                    e b10 = qa.d.b(qa.d.a(n0Var, n0Var, pVar));
                    int i10 = l.f9802h;
                    mb.j.a(b10, v.f9814a, (wa.l) null);
                    while (true) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = n0.f7829l;
                        int i11 = atomicIntegerFieldUpdater.get(n0Var);
                        if (i11 == 0) {
                            if (atomicIntegerFieldUpdater.compareAndSet(n0Var, 0, 1)) {
                                z10 = true;
                                break;
                            }
                        } else if (i11 != 2) {
                            throw new IllegalStateException("Already suspended".toString());
                        }
                    }
                    if (z10) {
                        obj = aVar;
                    } else {
                        obj = v1.a(n0Var.H());
                        if (obj instanceof w) {
                            throw ((w) obj).f7875a;
                        }
                    }
                } catch (Throwable th2) {
                    int i12 = l.f9802h;
                    n0Var.resumeWith(I(th2));
                    throw th2;
                }
            }
        }
        if (obj == aVar) {
            m1(eVar);
        }
        return obj;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object d(kb.l1 r4, wa.q r5, java.lang.Throwable r6, pa.e r7) {
        /*
            boolean r0 = r7 instanceof kb.r
            if (r0 == 0) goto L_0x0013
            r0 = r7
            kb.r r0 = (kb.r) r0
            int r1 = r0.f9372j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f9372j = r1
            goto L_0x0018
        L_0x0013:
            kb.r r0 = new kb.r
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f9371i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f9372j
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 != r3) goto L_0x0029
            java.lang.Throwable r6 = r0.f9370h
            O1(r7)     // Catch:{ all -> 0x0042 }
            goto L_0x003f
        L_0x0029:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0031:
            O1(r7)
            r0.f9370h = r6     // Catch:{ all -> 0x0042 }
            r0.f9372j = r3     // Catch:{ all -> 0x0042 }
            java.lang.Object r4 = r5.e(r4, r6, r0)     // Catch:{ all -> 0x0042 }
            if (r4 != r1) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            la.v r1 = la.v.f9814a
        L_0x0041:
            return r1
        L_0x0042:
            r4 = move-exception
            if (r6 == 0) goto L_0x004a
            if (r6 == r4) goto L_0x004a
            la.a.a(r4, r6)
        L_0x004a:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.d(kb.l1, wa.q, java.lang.Throwable, pa.e):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:23:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final long d0(java.util.Map r6) {
        /*
            java.lang.String r0 = "ContentRange"
            java.lang.String r1 = "Content-Range"
            java.lang.String r2 = "content-range"
            java.lang.String[] r0 = new java.lang.String[]{r1, r2, r0}
            java.lang.String r0 = p0(r6, r0)
            if (r0 == 0) goto L_0x001c
            java.lang.String r1 = "/"
            r2 = 6
            int r1 = fb.y.x(r0, r1, r2)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x001d
        L_0x001c:
            r1 = 0
        L_0x001d:
            r2 = -1
            if (r1 == 0) goto L_0x004c
            int r4 = r1.intValue()
            r5 = -1
            if (r4 == r5) goto L_0x004c
            int r4 = r1.intValue()
            int r5 = r0.length()
            if (r4 >= r5) goto L_0x004c
            int r1 = r1.intValue()
            int r1 = r1 + 1
            java.lang.String r0 = r0.substring(r1)
            java.lang.String r1 = "(this as java.lang.String).substring(startIndex)"
            xa.j.b(r1, r0)
            java.lang.Long r0 = fb.v.e(r0)
            if (r0 == 0) goto L_0x004c
            long r0 = r0.longValue()
            goto L_0x004d
        L_0x004c:
            r0 = r2
        L_0x004d:
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 != 0) goto L_0x006c
            java.lang.String r0 = "ContentLength"
            java.lang.String r1 = "content-length"
            java.lang.String r4 = "Content-Length"
            java.lang.String[] r0 = new java.lang.String[]{r1, r4, r0}
            java.lang.String r6 = p0(r6, r0)
            if (r6 == 0) goto L_0x006b
            java.lang.Long r6 = fb.v.e(r6)
            if (r6 == 0) goto L_0x006b
            long r2 = r6.longValue()
        L_0x006b:
            r0 = r2
        L_0x006c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.d0(java.util.Map):long");
    }

    public static pa.k d1(pa.h hVar, pa.i iVar) {
        j.f("key", iVar);
        return j.a(hVar.getKey(), iVar) ? pa.l.f12754h : hVar;
    }

    /* JADX INFO: finally extract failed */
    public static final Object d2(pa.k kVar, Object obj, Object obj2, p pVar, e eVar) {
        Object c10 = mb.f0.c(kVar, obj2);
        try {
            lb.z zVar = new lb.z(eVar, kVar);
            xa.y.c(2, pVar);
            Object g10 = pVar.g(obj, zVar);
            mb.f0.a(kVar, c10);
            if (g10 == qa.a.COROUTINE_SUSPENDED) {
                m1(eVar);
            }
            return g10;
        } catch (Throwable th) {
            mb.f0.a(kVar, c10);
            throw th;
        }
    }

    public static final void e(Logger logger, sb.a aVar, sb.c cVar, String str) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(cVar.f14464b);
        sb2.append(' ');
        xa.x xVar = xa.x.f16820a;
        String format = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        j.e("format(format, *args)", format);
        sb2.append(format);
        sb2.append(": ");
        sb2.append(aVar.f14457a);
        logger.fine(sb2.toString());
    }

    public static float e0(EdgeEffect edgeEffect) {
        if (Build.VERSION.SDK_INT >= 31) {
            return q0.g.b(edgeEffect);
        }
        return 0.0f;
    }

    public static final ArrayList e1(Map map, wa.l lVar) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (Map.Entry entry : map.entrySet()) {
            j3.m mVar = (j3.m) entry.getValue();
            if (mVar != null && !mVar.f8612b && !mVar.f8613c) {
                linkedHashMap.put(entry.getKey(), entry.getValue());
            }
        }
        Set keySet = linkedHashMap.keySet();
        ArrayList arrayList = new ArrayList();
        for (Object next : keySet) {
            if (((Boolean) lVar.invoke((String) next)).booleanValue()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x007d, code lost:
        if (r6 == false) goto L_0x0080;
     */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0090 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0091  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object e2(pa.e r8) {
        /*
            pa.k r0 = r8.getContext()
            T(r0)
            pa.e r1 = qa.d.b(r8)
            boolean r2 = r1 instanceof mb.i
            r3 = 0
            if (r2 == 0) goto L_0x0013
            mb.i r1 = (mb.i) r1
            goto L_0x0014
        L_0x0013:
            r1 = r3
        L_0x0014:
            qa.a r2 = qa.a.COROUTINE_SUSPENDED
            if (r1 != 0) goto L_0x0019
            goto L_0x0080
        L_0x0019:
            hb.d0 r4 = r1.f10860k
            boolean r5 = r4.O0(r0)
            r6 = 1
            if (r5 == 0) goto L_0x002c
            la.v r3 = la.v.f9814a
            r1.f10862m = r3
            r1.f7831j = r6
            r4.N0(r0, r1)
            goto L_0x0088
        L_0x002c:
            hb.m2 r5 = new hb.m2
            r5.<init>()
            pa.k r0 = r0.I0(r5)
            la.v r7 = la.v.f9814a
            r1.f10862m = r7
            r1.f7831j = r6
            r4.N0(r0, r1)
            boolean r0 = r5.f7827i
            if (r0 == 0) goto L_0x0088
            h3.u1 r0 = mb.j.f10864a
            hb.f2 r0 = hb.f2.f7793a
            r0.getClass()
            hb.s0 r0 = hb.f2.a()
            ma.l r4 = r0.f7846l
            if (r4 == 0) goto L_0x0056
            boolean r4 = r4.isEmpty()
            goto L_0x0057
        L_0x0056:
            r4 = 1
        L_0x0057:
            if (r4 == 0) goto L_0x005a
            goto L_0x007c
        L_0x005a:
            boolean r4 = r0.T0()
            if (r4 == 0) goto L_0x0068
            r1.f10862m = r7
            r1.f7831j = r6
            r0.R0(r1)
            goto L_0x007d
        L_0x0068:
            r0.S0(r6)
            r1.run()     // Catch:{ all -> 0x0075 }
        L_0x006e:
            boolean r4 = r0.V0()     // Catch:{ all -> 0x0075 }
            if (r4 != 0) goto L_0x006e
            goto L_0x0079
        L_0x0075:
            r4 = move-exception
            r1.h(r4, r3)     // Catch:{ all -> 0x0083 }
        L_0x0079:
            r0.Q0(r6)
        L_0x007c:
            r6 = 0
        L_0x007d:
            if (r6 == 0) goto L_0x0080
            goto L_0x0088
        L_0x0080:
            la.v r0 = la.v.f9814a
            goto L_0x0089
        L_0x0083:
            r8 = move-exception
            r0.Q0(r6)
            throw r8
        L_0x0088:
            r0 = r2
        L_0x0089:
            if (r0 != r2) goto L_0x008e
            m1(r8)
        L_0x008e:
            if (r0 != r2) goto L_0x0091
            return r0
        L_0x0091:
            la.v r8 = la.v.f9814a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.e2(pa.e):java.lang.Object");
    }

    public static final h2 f(la.e eVar) {
        return (h2) eVar.getValue();
    }

    public static final String f0(int i10, int i11, String str) {
        j.g("fileTempDir", str);
        return str + '/' + i10 + '.' + i11 + ".data";
    }

    public static final n1 f1(wa.l lVar) {
        j.f("optionsBuilder", lVar);
        o1 o1Var = new o1();
        lVar.invoke(o1Var);
        boolean z10 = o1Var.f8644b;
        m1 m1Var = o1Var.f8643a;
        m1Var.f8615a = z10;
        m1Var.f8616b = o1Var.f8645c;
        int i10 = o1Var.f8646d;
        boolean z11 = o1Var.f8647e;
        m1Var.f8617c = i10;
        m1Var.f8618d = null;
        m1Var.f8619e = false;
        m1Var.f8620f = z11;
        return m1Var.a();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0072 A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0091  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0129  */
    /* JADX WARNING: Removed duplicated region for block: B:66:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void g(android.app.Activity r13) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r13)
            android.content.SharedPreferences r0 = l1(r13)
            java.lang.String r1 = "ui_theme_follow_system"
            r2 = 0
            boolean r0 = r0.getBoolean(r1, r2)
            java.lang.String r1 = "0"
            java.lang.String r3 = "2"
            if (r0 == 0) goto L_0x0038
            android.content.res.Resources r0 = r13.getResources()
            android.content.res.Configuration r0 = r0.getConfiguration()
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 32
            if (r0 != r4) goto L_0x002d
            android.content.SharedPreferences r0 = l1(r13)
            java.lang.String r4 = "ui_theme_dark_on"
            goto L_0x003e
        L_0x002d:
            android.content.SharedPreferences r0 = l1(r13)
            java.lang.String r4 = "ui_theme_dark_off"
            java.lang.String r0 = r0.getString(r4, r3)
            goto L_0x0042
        L_0x0038:
            android.content.SharedPreferences r0 = l1(r13)
            java.lang.String r4 = "theme"
        L_0x003e:
            java.lang.String r0 = r0.getString(r4, r1)
        L_0x0042:
            xa.j.c(r0)
            int r4 = r0.hashCode()
            java.lang.String r5 = "3"
            java.lang.String r6 = "1"
            switch(r4) {
                case 49: goto L_0x0067;
                case 50: goto L_0x005c;
                case 51: goto L_0x0051;
                default: goto L_0x0050;
            }
        L_0x0050:
            goto L_0x0072
        L_0x0051:
            boolean r4 = r0.equals(r5)
            if (r4 != 0) goto L_0x0058
            goto L_0x0072
        L_0x0058:
            r4 = 2132017439(0x7f14011f, float:1.9673156E38)
            goto L_0x0075
        L_0x005c:
            boolean r4 = r0.equals(r3)
            if (r4 != 0) goto L_0x0063
            goto L_0x0072
        L_0x0063:
            r4 = 2132017488(0x7f140150, float:1.9673256E38)
            goto L_0x0075
        L_0x0067:
            boolean r4 = r0.equals(r6)
            if (r4 != 0) goto L_0x006e
            goto L_0x0072
        L_0x006e:
            r4 = 2132017154(0x7f140002, float:1.9672578E38)
            goto L_0x0075
        L_0x0072:
            r4 = 2132017449(0x7f140129, float:1.9673177E38)
        L_0x0075:
            r13.setTheme(r4)
            android.content.SharedPreferences r4 = l1(r13)
            java.lang.String r7 = "ui_statusbar"
            r8 = 1
            boolean r4 = r4.getBoolean(r7, r8)
            r7 = 2131100390(0x7f0602e6, float:1.781316E38)
            r9 = 2131100392(0x7f0602e8, float:1.7813164E38)
            r10 = 2131100389(0x7f0602e5, float:1.7813158E38)
            r11 = 2131100391(0x7f0602e7, float:1.7813162E38)
            if (r4 == 0) goto L_0x00d4
            int r4 = r0.hashCode()
            switch(r4) {
                case 49: goto L_0x00b9;
                case 50: goto L_0x00a9;
                case 51: goto L_0x0099;
                default: goto L_0x0098;
            }
        L_0x0098:
            goto L_0x00c9
        L_0x0099:
            boolean r4 = r0.equals(r5)
            if (r4 != 0) goto L_0x00a0
            goto L_0x00c9
        L_0x00a0:
            android.view.Window r4 = r13.getWindow()
            int r12 = c0.g.b(r13, r7)
            goto L_0x00d1
        L_0x00a9:
            boolean r4 = r0.equals(r3)
            if (r4 != 0) goto L_0x00b0
            goto L_0x00c9
        L_0x00b0:
            android.view.Window r4 = r13.getWindow()
            int r12 = c0.g.b(r13, r9)
            goto L_0x00d1
        L_0x00b9:
            boolean r4 = r0.equals(r6)
            if (r4 != 0) goto L_0x00c0
            goto L_0x00c9
        L_0x00c0:
            android.view.Window r4 = r13.getWindow()
            int r12 = c0.g.b(r13, r10)
            goto L_0x00d1
        L_0x00c9:
            android.view.Window r4 = r13.getWindow()
            int r12 = c0.g.b(r13, r11)
        L_0x00d1:
            r4.setStatusBarColor(r12)
        L_0x00d4:
            android.content.SharedPreferences r4 = l1(r13)
            java.lang.String r12 = "ui_navbar"
            boolean r4 = r4.getBoolean(r12, r8)
            if (r4 == 0) goto L_0x0123
            int r4 = r0.hashCode()
            switch(r4) {
                case 49: goto L_0x0108;
                case 50: goto L_0x00f8;
                case 51: goto L_0x00e8;
                default: goto L_0x00e7;
            }
        L_0x00e7:
            goto L_0x0118
        L_0x00e8:
            boolean r0 = r0.equals(r5)
            if (r0 != 0) goto L_0x00ef
            goto L_0x0118
        L_0x00ef:
            android.view.Window r0 = r13.getWindow()
            int r4 = c0.g.b(r13, r7)
            goto L_0x0120
        L_0x00f8:
            boolean r0 = r0.equals(r3)
            if (r0 != 0) goto L_0x00ff
            goto L_0x0118
        L_0x00ff:
            android.view.Window r0 = r13.getWindow()
            int r4 = c0.g.b(r13, r9)
            goto L_0x0120
        L_0x0108:
            boolean r0 = r0.equals(r6)
            if (r0 != 0) goto L_0x010f
            goto L_0x0118
        L_0x010f:
            android.view.Window r0 = r13.getWindow()
            int r4 = c0.g.b(r13, r10)
            goto L_0x0120
        L_0x0118:
            android.view.Window r0 = r13.getWindow()
            int r4 = c0.g.b(r13, r11)
        L_0x0120:
            r0.setNavigationBarColor(r4)
        L_0x0123:
            int r0 = android.os.Build.VERSION.SDK_INT
            r4 = 28
            if (r0 < r4) goto L_0x015e
            android.view.Window r0 = r13.getWindow()
            android.view.WindowManager$LayoutParams r0 = r0.getAttributes()
            android.content.SharedPreferences r13 = l1(r13)
            java.lang.String r4 = "ui_cutoutmode"
            java.lang.String r13 = r13.getString(r4, r1)
            if (r13 == 0) goto L_0x015b
            int r1 = r13.hashCode()
            r4 = 49
            if (r1 == r4) goto L_0x0153
            r4 = 50
            if (r1 == r4) goto L_0x014a
            goto L_0x015b
        L_0x014a:
            boolean r13 = r13.equals(r3)
            if (r13 != 0) goto L_0x0151
            goto L_0x015b
        L_0x0151:
            r2 = 2
            goto L_0x015b
        L_0x0153:
            boolean r13 = r13.equals(r6)
            if (r13 != 0) goto L_0x015a
            goto L_0x015b
        L_0x015a:
            r2 = 1
        L_0x015b:
            r0.layoutInDisplayCutoutMode = r2
        L_0x015e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.g(android.app.Activity):void");
    }

    public static final Drawable g0(Context context, int i10) {
        Drawable a10 = h.a.a(context, i10);
        if (a10 != null) {
            return a10;
        }
        throw new IllegalStateException(android.support.v4.media.h.i("Invalid resource ID: ", i10).toString());
    }

    public static final pa.k g1(f0 f0Var, pa.k kVar) {
        pa.k X = X(f0Var.v(), kVar, true);
        nb.e eVar = p0.f7833a;
        if (X == eVar || X.N(pa.g.f12752g) != null) {
            return X;
        }
        return X.I0(eVar);
    }

    public static final Object[] h(int i10) {
        if (i10 >= 0) {
            return new Object[i10];
        }
        throw new IllegalArgumentException("capacity must be non-negative.".toString());
    }

    public static final p9.f h0(String str) {
        boolean z10;
        if (str != null) {
            if (str.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                if (w.g(str, "request_with_file_path_already_exist") || y.n(str, "UNIQUE constraint failed: requests._file (code 2067)", true)) {
                    return p9.f.REQUEST_WITH_FILE_PATH_ALREADY_EXIST;
                }
                if (y.n(str, "UNIQUE constraint failed: requests._id", false)) {
                    return p9.f.REQUEST_WITH_ID_ALREADY_EXIST;
                }
                if (y.n(str, "empty_response_body", true)) {
                    return p9.f.EMPTY_RESPONSE_FROM_SERVER;
                }
                if (w.g(str, "FNC") || w.g(str, "open failed: ENOENT (No such file or directory)")) {
                    return p9.f.FILE_NOT_CREATED;
                }
                if (y.n(str, "recvfrom failed: ETIMEDOUT (Connection timed out)", true) || y.n(str, "timeout", true) || y.n(str, "Software caused connection abort", true) || y.n(str, "Read timed out at", true)) {
                    return p9.f.CONNECTION_TIMED_OUT;
                }
                if (w.g(str, "java.io.IOException: 404") || y.n(str, "No address associated with hostname", false)) {
                    return p9.f.HTTP_NOT_FOUND;
                }
                if (y.n(str, "Unable to resolve host", false)) {
                    return p9.f.UNKNOWN_HOST;
                }
                if (w.g(str, "open failed: EACCES (Permission denied)")) {
                    return p9.f.WRITE_PERMISSION_DENIED;
                }
                if (w.g(str, "write failed: ENOSPC (No space left on device)") || w.g(str, "database or disk is full (code 13)")) {
                    return p9.f.NO_STORAGE_SPACE;
                }
                if (w.g(str, "UNIQUE constraint failed: requests._id (code 1555)")) {
                    return p9.f.REQUEST_ALREADY_EXIST;
                }
                if (w.g(str, "fetch download not found")) {
                    return p9.f.DOWNLOAD_NOT_FOUND;
                }
                if (w.g(str, "Fetch data base error")) {
                    return p9.f.FETCH_DATABASE_ERROR;
                }
                if (y.n(str, "request_not_successful", true) || y.n(str, "Failed to connect", true)) {
                    return p9.f.REQUEST_NOT_SUCCESSFUL;
                }
                if (y.n(str, "invalid content hash", true)) {
                    return p9.f.INVALID_CONTENT_HASH;
                }
                if (y.n(str, "download_incomplete", true)) {
                    return p9.f.UNKNOWN_IO_ERROR;
                }
                if (y.n(str, "failed_to_update_request", true)) {
                    return p9.f.FAILED_TO_UPDATE_REQUEST;
                }
                if (y.n(str, "failed_to_add_completed_download", true)) {
                    return p9.f.FAILED_TO_ADD_COMPLETED_DOWNLOAD;
                }
                if (y.n(str, "fetch_file_server_invalid_response_type", true)) {
                    return p9.f.FETCH_FILE_SERVER_INVALID_RESPONSE;
                }
                if (y.n(str, "request_does_not_exist", true)) {
                    return p9.f.REQUEST_DOES_NOT_EXIST;
                }
                if (y.n(str, "no_network_connection", true)) {
                    return p9.f.NO_NETWORK_CONNECTION;
                }
                if (y.n(str, "file_not_found", true)) {
                    return p9.f.FILE_NOT_FOUND;
                }
                if (y.n(str, "fetch_file_server_url_invalid", true)) {
                    return p9.f.FETCH_FILE_SERVER_URL_INVALID;
                }
                if (y.n(str, "request_list_not_distinct", true)) {
                    return p9.f.ENQUEUED_REQUESTS_ARE_NOT_DISTINCT;
                }
                if (y.n(str, "enqueue_not_successful", true)) {
                    return p9.f.ENQUEUE_NOT_SUCCESSFUL;
                }
                if (y.n(str, "cannot rename file associated with incomplete download", true)) {
                    return p9.f.FAILED_TO_RENAME_INCOMPLETE_DOWNLOAD_FILE;
                }
                if (y.n(str, "file_cannot_be_renamed", true)) {
                    return p9.f.FAILED_TO_RENAME_FILE;
                }
                if (y.n(str, "file_allocation_error", true)) {
                    return p9.f.FILE_ALLOCATION_FAILED;
                }
                if (y.n(str, "Cleartext HTTP traffic to", true)) {
                    return p9.f.HTTP_CONNECTION_NOT_ALLOWED;
                }
            }
        }
        return p9.f.UNKNOWN;
    }

    public static final String h1(String str) {
        if (str.length() > 0) {
            return str;
        }
        return null;
    }

    public static l0 i(f0 f0Var, p pVar) {
        l0 l0Var = new l0(g1(f0Var, pa.l.f12754h), true);
        l0Var.e0(1, l0Var, pVar);
        return l0Var;
    }

    public static final p9.f i0(Exception exc) {
        String message = exc.getMessage();
        if (message == null) {
            message = "";
        }
        boolean z10 = exc instanceof SocketTimeoutException;
        if (z10) {
            if (message.length() == 0) {
                message = "timeout";
            }
        }
        p9.f h02 = h0(message);
        p9.f fVar = p9.f.UNKNOWN;
        return (h02 != fVar || !z10) ? (h02 != fVar || !(exc instanceof IOException)) ? h02 : p9.f.UNKNOWN_IO_ERROR : p9.f.CONNECTION_TIMED_OUT;
    }

    public static float i1(EdgeEffect edgeEffect, float f10, float f11) {
        if (Build.VERSION.SDK_INT >= 31) {
            return q0.g.c(edgeEffect, f10, f11);
        }
        q0.e.a(edgeEffect, f10, f11);
        return f10;
    }

    public static final Object j(ArrayList arrayList, e eVar) {
        if (arrayList.isEmpty()) {
            return ma.b0.f10801h;
        }
        k0[] k0VarArr = (k0[]) arrayList.toArray(new k0[0]);
        e eVar2 = new e(k0VarArr);
        l lVar = new l(1, qa.d.b(eVar));
        lVar.w();
        int length = k0VarArr.length;
        c[] cVarArr = new c[length];
        for (int i10 = 0; i10 < length; i10++) {
            u1 u1Var = (u1) k0VarArr[i10];
            u1Var.X();
            c cVar = new c(eVar2, lVar);
            cVar.f7781m = u1Var.L(cVar);
            v vVar = v.f9814a;
            cVarArr[i10] = cVar;
        }
        d dVar = new d(cVarArr);
        for (int i11 = 0; i11 < length; i11++) {
            c cVar2 = cVarArr[i11];
            cVar2.getClass();
            c.f7779o.set(cVar2, dVar);
        }
        if (!(l.f7819n.get(lVar) instanceof a2)) {
            dVar.c();
        } else {
            lVar.j(dVar);
        }
        Object u10 = lVar.u();
        if (u10 == qa.a.COROUTINE_SUSPENDED) {
            m1(eVar);
        }
        return u10;
    }

    public static final String j0(String str) {
        j.g("url", str);
        String substring = str.substring(y.u(str, "//", 0, false, 6) + 2, y.x(str, Constants.EXT_TAG_END, 6));
        j.b("(this as java.lang.Strin…ing(startIndex, endIndex)", substring);
        return substring;
    }

    public static pa.k j1(pa.h hVar, pa.k kVar) {
        j.f("context", kVar);
        if (kVar == pa.l.f12754h) {
            return hVar;
        }
        return (pa.k) kVar.j0(hVar, pa.j.f12753h);
    }

    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Incorrect type for immutable var: ssa=androidx.activity.w, code=wa.a, for r5v0, types: [wa.a, androidx.activity.w] */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object k(jb.r r4, wa.a r5, pa.e r6) {
        /*
            boolean r0 = r6 instanceof jb.p
            if (r0 == 0) goto L_0x0013
            r0 = r6
            jb.p r0 = (jb.p) r0
            int r1 = r0.f8930j
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f8930j = r1
            goto L_0x0018
        L_0x0013:
            jb.p r0 = new jb.p
            r0.<init>(r6)
        L_0x0018:
            java.lang.Object r6 = r0.f8929i
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f8930j
            r3 = 1
            if (r2 == 0) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            wa.a r5 = r0.f8928h
            O1(r6)     // Catch:{ all -> 0x0029 }
            goto L_0x0070
        L_0x0029:
            r4 = move-exception
            goto L_0x0076
        L_0x002b:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L_0x0033:
            O1(r6)
            pa.k r6 = r0.getContext()
            hb.k1 r2 = hb.l1.f7823b
            pa.h r6 = r6.N(r2)
            if (r6 != r4) goto L_0x0044
            r6 = 1
            goto L_0x0045
        L_0x0044:
            r6 = 0
        L_0x0045:
            if (r6 == 0) goto L_0x007a
            r0.getClass()     // Catch:{ all -> 0x0029 }
            r0.f8928h = r5     // Catch:{ all -> 0x0029 }
            r0.f8930j = r3     // Catch:{ all -> 0x0029 }
            hb.l r6 = new hb.l     // Catch:{ all -> 0x0029 }
            pa.e r2 = qa.d.b(r0)     // Catch:{ all -> 0x0029 }
            r6.<init>(r3, r2)     // Catch:{ all -> 0x0029 }
            r6.w()     // Catch:{ all -> 0x0029 }
            n3.j5 r2 = new n3.j5     // Catch:{ all -> 0x0029 }
            r2.<init>(r6, r3)     // Catch:{ all -> 0x0029 }
            jb.q r4 = (jb.q) r4     // Catch:{ all -> 0x0029 }
            r4.a(r2)     // Catch:{ all -> 0x0029 }
            java.lang.Object r4 = r6.u()     // Catch:{ all -> 0x0029 }
            if (r4 != r1) goto L_0x006d
            m1(r0)     // Catch:{ all -> 0x0029 }
        L_0x006d:
            if (r4 != r1) goto L_0x0070
            return r1
        L_0x0070:
            r5.b()
            la.v r4 = la.v.f9814a
            return r4
        L_0x0076:
            r5.b()
            throw r4
        L_0x007a:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "awaitClose() can only be invoked from the producer context"
            java.lang.String r5 = r5.toString()
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.k(jb.r, androidx.activity.w, pa.e):java.lang.Object");
    }

    public static final int k0(String str) {
        j.g("url", str);
        String substring = str.substring(y.x(str, Constants.EXT_TAG_END, 6) + 1, str.length());
        j.b("(this as java.lang.Strin…ing(startIndex, endIndex)", substring);
        int u10 = y.u(substring, Constants.LIST_SEPARATOR, 0, false, 6);
        if (u10 != -1) {
            substring = substring.substring(0, u10);
            j.b("(this as java.lang.Strin…ing(startIndex, endIndex)", substring);
        }
        return Integer.parseInt(substring);
    }

    public static final Object k1(Object obj, Object obj2) {
        if (obj == null) {
            return obj2;
        }
        if (obj instanceof ArrayList) {
            ((ArrayList) obj).add(obj2);
            return obj;
        }
        ArrayList arrayList = new ArrayList(4);
        arrayList.add(obj);
        arrayList.add(obj2);
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x007c  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0021  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Object l(androidx.lifecycle.t r6, pa.e r7) {
        /*
            boolean r0 = r7 instanceof w4.b
            if (r0 == 0) goto L_0x0013
            r0 = r7
            w4.b r0 = (w4.b) r0
            int r1 = r0.f16077k
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f16077k = r1
            goto L_0x0018
        L_0x0013:
            w4.b r0 = new w4.b
            r0.<init>(r7)
        L_0x0018:
            java.lang.Object r7 = r0.f16076j
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f16077k
            r3 = 1
            if (r2 == 0) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            xa.u r6 = r0.f16075i
            androidx.lifecycle.t r0 = r0.f16074h
            O1(r7)     // Catch:{ all -> 0x002b }
            goto L_0x0076
        L_0x002b:
            r7 = move-exception
            goto L_0x0087
        L_0x002d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0035:
            O1(r7)
            androidx.lifecycle.s r7 = r6.b()
            androidx.lifecycle.s r2 = androidx.lifecycle.s.STARTED
            boolean r7 = r7.a(r2)
            if (r7 == 0) goto L_0x0047
            la.v r6 = la.v.f9814a
            return r6
        L_0x0047:
            xa.u r7 = new xa.u
            r7.<init>()
            r0.f16074h = r6     // Catch:{ all -> 0x0082 }
            r0.f16075i = r7     // Catch:{ all -> 0x0082 }
            r0.f16077k = r3     // Catch:{ all -> 0x0082 }
            hb.l r2 = new hb.l     // Catch:{ all -> 0x0082 }
            pa.e r4 = qa.d.b(r0)     // Catch:{ all -> 0x0082 }
            r2.<init>(r3, r4)     // Catch:{ all -> 0x0082 }
            r2.w()     // Catch:{ all -> 0x0082 }
            coil.util.-Lifecycles$awaitStarted$2$1 r3 = new coil.util.-Lifecycles$awaitStarted$2$1     // Catch:{ all -> 0x0082 }
            r3.<init>(r2)     // Catch:{ all -> 0x0082 }
            r7.f16818h = r3     // Catch:{ all -> 0x0082 }
            r6.a(r3)     // Catch:{ all -> 0x0082 }
            java.lang.Object r2 = r2.u()     // Catch:{ all -> 0x0082 }
            if (r2 != r1) goto L_0x0071
            m1(r0)     // Catch:{ all -> 0x0082 }
        L_0x0071:
            if (r2 != r1) goto L_0x0074
            return r1
        L_0x0074:
            r0 = r6
            r6 = r7
        L_0x0076:
            java.lang.Object r6 = r6.f16818h
            androidx.lifecycle.c0 r6 = (androidx.lifecycle.c0) r6
            if (r6 == 0) goto L_0x007f
            r0.c(r6)
        L_0x007f:
            la.v r6 = la.v.f9814a
            return r6
        L_0x0082:
            r0 = move-exception
            r5 = r0
            r0 = r6
            r6 = r7
            r7 = r5
        L_0x0087:
            java.lang.Object r6 = r6.f16818h
            androidx.lifecycle.c0 r6 = (androidx.lifecycle.c0) r6
            if (r6 == 0) goto L_0x0090
            r0.c(r6)
        L_0x0090:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.l(androidx.lifecycle.t, pa.e):java.lang.Object");
    }

    public static final File l0(String str) {
        j.g("filePath", str);
        File file = new File(str);
        if (!file.exists() && (file.getParentFile() == null || file.getParentFile().exists() || file.getParentFile().mkdirs())) {
            file.createNewFile();
        }
        return file;
    }

    public static final SharedPreferences l1(Context context) {
        j.f("<this>", context);
        SharedPreferences sharedPreferences = context.getSharedPreferences(i0.a(context), 0);
        j.e("getDefaultSharedPreferences(this)", sharedPreferences);
        return sharedPreferences;
    }

    public static final m2 m(wa.l lVar, Object obj, pa.k kVar) {
        return new m2(lVar, obj, kVar, 21);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x005f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        A(r3, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0063, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.String m0(java.lang.String r5) {
        /*
            java.lang.String r0 = "file"
            xa.j.g(r0, r5)
            java.io.File r0 = new java.io.File
            r0.<init>(r5)
            r5 = 8192(0x2000, float:1.14794E-41)
            r1 = 0
            byte[] r5 = new byte[r5]     // Catch:{ Exception -> 0x0064 }
            java.lang.String r2 = "MD5"
            java.security.MessageDigest r2 = java.security.MessageDigest.getInstance(r2)     // Catch:{ Exception -> 0x0064 }
            java.security.DigestInputStream r3 = new java.security.DigestInputStream     // Catch:{ Exception -> 0x0064 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0064 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x0064 }
            r3.<init>(r4, r2)     // Catch:{ Exception -> 0x0064 }
        L_0x001f:
            int r0 = r3.read(r5)     // Catch:{ all -> 0x005d }
            r4 = -1
            if (r0 == r4) goto L_0x0027
            goto L_0x001f
        L_0x0027:
            la.v r5 = la.v.f9814a     // Catch:{ all -> 0x005d }
            A(r3, r1)     // Catch:{ Exception -> 0x0064 }
            java.math.BigInteger r5 = new java.math.BigInteger     // Catch:{ Exception -> 0x0064 }
            byte[] r0 = r2.digest()     // Catch:{ Exception -> 0x0064 }
            r2 = 1
            r5.<init>(r2, r0)     // Catch:{ Exception -> 0x0064 }
            r0 = 16
            java.lang.String r5 = r5.toString(r0)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r0 = "BigInteger(1, md.digest()).toString(16)"
            xa.j.b(r0, r5)     // Catch:{ Exception -> 0x0064 }
        L_0x0041:
            int r0 = r5.length()     // Catch:{ Exception -> 0x0064 }
            r2 = 32
            if (r0 >= r2) goto L_0x005b
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0064 }
            r0.<init>()     // Catch:{ Exception -> 0x0064 }
            r2 = 48
            r0.append(r2)     // Catch:{ Exception -> 0x0064 }
            r0.append(r5)     // Catch:{ Exception -> 0x0064 }
            java.lang.String r5 = r0.toString()     // Catch:{ Exception -> 0x0064 }
            goto L_0x0041
        L_0x005b:
            r1 = r5
            goto L_0x0064
        L_0x005d:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x005f }
        L_0x005f:
            r0 = move-exception
            A(r3, r5)     // Catch:{ Exception -> 0x0064 }
            throw r0     // Catch:{ Exception -> 0x0064 }
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.m0(java.lang.String):java.lang.String");
    }

    public static final void m1(e eVar) {
        j.f("frame", eVar);
    }

    public static final dc.h0 n(dc.n0 n0Var) {
        j.f("<this>", n0Var);
        return new dc.h0(n0Var);
    }

    public static final String n0(Context context) {
        j.g("context", context);
        StringBuilder sb2 = new StringBuilder();
        File filesDir = context.getFilesDir();
        j.b("context.filesDir", filesDir);
        sb2.append(filesDir.getAbsoluteFile());
        sb2.append("/_fetchData/temp");
        return sb2.toString();
    }

    public static final Cursor n1(r3.n0 n0Var, r3.s0 s0Var) {
        j.f("db", n0Var);
        j.f("sqLiteQuery", s0Var);
        return n0Var.q(s0Var, (CancellationSignal) null);
    }

    public static final dc.i0 o(p0 p0Var) {
        j.f("<this>", p0Var);
        return new dc.i0(p0Var);
    }

    public static final Uri o0(String str) {
        Uri uri;
        String str2;
        j.g("path", str);
        if (a1(str)) {
            uri = Uri.parse(str);
            str2 = "Uri.parse(path)";
        } else {
            uri = Uri.fromFile(new File(str));
            str2 = "Uri.fromFile(File(path))";
        }
        j.b(str2, uri);
        return uri;
    }

    public static final ec.g o1(dc.i0 i0Var) {
        Long l10;
        short s10;
        long j10;
        dc.i0 i0Var2 = i0Var;
        int O = i0Var.O();
        if (O == 33639248) {
            i0Var2.a(4);
            short e10 = i0Var.e() & 65535;
            if ((e10 & 1) == 0) {
                short e11 = i0Var.e() & 65535;
                short e12 = i0Var.e() & 65535;
                short e13 = i0Var.e() & 65535;
                if (e12 == -1) {
                    l10 = null;
                } else {
                    GregorianCalendar gregorianCalendar = new GregorianCalendar();
                    gregorianCalendar.set(14, 0);
                    gregorianCalendar.set(((e13 >> 9) & 127) + 1980, ((e13 >> 5) & 15) - 1, e13 & 31, (e12 >> 11) & 31, (e12 >> 5) & 63, (e12 & 31) << 1);
                    l10 = Long.valueOf(gregorianCalendar.getTime().getTime());
                }
                Long l11 = l10;
                i0Var.O();
                xa.t tVar = new xa.t();
                tVar.f16817h = ((long) i0Var.O()) & 4294967295L;
                xa.t tVar2 = new xa.t();
                tVar2.f16817h = ((long) i0Var.O()) & 4294967295L;
                short e14 = i0Var.e() & 65535;
                short e15 = i0Var.e() & 65535;
                i0Var2.a(8);
                xa.t tVar3 = new xa.t();
                tVar3.f16817h = ((long) i0Var.O()) & 4294967295L;
                String k10 = i0Var2.k((long) (i0Var.e() & 65535));
                if (!y.o(k10, 0)) {
                    if (tVar2.f16817h == 4294967295L) {
                        j10 = ((long) 8) + 0;
                        s10 = e11;
                    } else {
                        s10 = e11;
                        j10 = 0;
                    }
                    if (tVar.f16817h == 4294967295L) {
                        j10 += (long) 8;
                    }
                    if (tVar3.f16817h == 4294967295L) {
                        j10 += (long) 8;
                    }
                    long j11 = j10;
                    xa.q qVar = new xa.q();
                    Long l12 = l11;
                    ec.i iVar = r0;
                    xa.t tVar4 = tVar2;
                    xa.t tVar5 = tVar2;
                    xa.q qVar2 = qVar;
                    String str = k10;
                    xa.t tVar6 = tVar3;
                    ec.i iVar2 = new ec.i(qVar, j11, tVar4, i0Var, tVar, tVar3);
                    p1(i0Var2, e14, iVar);
                    if (j11 <= 0 || qVar2.f16814h) {
                        String str2 = str;
                        return new ec.g(f0.f4761i.getClass().c(str2), w.f(str2, Constants.LIST_SEPARATOR, false), i0Var2.k((long) e15), tVar.f16817h, tVar5.f16817h, s10, l12, tVar6.f16817h);
                    }
                    throw new IOException("bad zip: zip64 extra required but absent");
                }
                throw new IOException("bad zip: filename contains 0x00");
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + q0(e10));
        }
        throw new IOException("bad zip: expected " + q0(33639248) + " but was " + q0(O));
    }

    public static i p(i iVar, int i10) {
        boolean z10;
        jb.a aVar = jb.a.SUSPEND;
        if (i10 >= 0 || i10 == -2 || i10 == -1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (i10 == -1) {
                aVar = jb.a.DROP_OLDEST;
                i10 = 0;
            }
            if (iVar instanceof lb.q) {
                return ((lb.q) iVar).d(pa.l.f12754h, i10, aVar);
            }
            return new lb.i(iVar, i10, aVar);
        }
        throw new IllegalArgumentException(android.support.v4.media.h.i("Buffer size should be non-negative, BUFFERED, or CONFLATED, but was ", i10).toString());
    }

    public static final String p0(Map map, String... strArr) {
        int length = strArr.length;
        int i10 = 0;
        while (true) {
            String str = null;
            if (i10 >= length) {
                return null;
            }
            List list = (List) map.get(strArr[i10]);
            if (list != null) {
                str = (String) ma.z.u(list);
            }
            if (!(str == null || w.h(str))) {
                return str;
            }
            i10++;
        }
    }

    public static final void p1(dc.i0 i0Var, int i10, p pVar) {
        long j10 = (long) i10;
        while (j10 != 0) {
            if (j10 >= 4) {
                short e10 = i0Var.e() & 65535;
                long e11 = ((long) i0Var.e()) & 65535;
                long j11 = j10 - ((long) 4);
                if (j11 >= e11) {
                    i0Var.u0(e11);
                    dc.j jVar = i0Var.f4784i;
                    long j12 = jVar.f4787i;
                    pVar.g(Integer.valueOf(e10), Long.valueOf(e11));
                    long j13 = (jVar.f4787i + e11) - j12;
                    int i11 = (j13 > 0 ? 1 : (j13 == 0 ? 0 : -1));
                    if (i11 >= 0) {
                        if (i11 > 0) {
                            jVar.a(j13);
                        }
                        j10 = j11 - e11;
                    } else {
                        throw new IOException(android.support.v4.media.h.i("unsupported zip: too many bytes processed for ", e10));
                    }
                } else {
                    throw new IOException("bad zip: truncated value in extra field");
                }
            } else {
                throw new IOException("bad zip: truncated header in extra field");
            }
        }
    }

    public static final LinkedHashMap q(ArrayList arrayList) {
        f0 c10 = f0.f4761i.getClass();
        la.i[] iVarArr = {new la.i(c10, new ec.g(c10))};
        LinkedHashMap linkedHashMap = new LinkedHashMap(ma.i0.a(1));
        la.i iVar = iVarArr[0];
        linkedHashMap.put(iVar.f9799h, iVar.f9800i);
        for (ec.g gVar : ma.z.F(arrayList, new ec.h())) {
            if (((ec.g) linkedHashMap.put(gVar.f5367a, gVar)) == null) {
                while (true) {
                    f0 b10 = gVar.f5367a.b();
                    if (b10 == null) {
                        break;
                    }
                    ec.g gVar2 = (ec.g) linkedHashMap.get(b10);
                    f0 f0Var = gVar.f5367a;
                    if (gVar2 != null) {
                        gVar2.f5374h.add(f0Var);
                        break;
                    }
                    ec.g gVar3 = new ec.g(b10);
                    linkedHashMap.put(b10, gVar3);
                    gVar3.f5374h.add(f0Var);
                    gVar = gVar3;
                }
            }
        }
        return linkedHashMap;
    }

    public static final String q0(int i10) {
        fb.a.a(16);
        String num = Integer.toString(i10, 16);
        j.e("toString(this, checkRadix(radix))", num);
        return "0x".concat(num);
    }

    public static final dc.p q1(dc.i0 i0Var, dc.p pVar) {
        Long l10;
        xa.u uVar = new xa.u();
        if (pVar != null) {
            l10 = pVar.f4816f;
        } else {
            l10 = null;
        }
        uVar.f16818h = l10;
        xa.u uVar2 = new xa.u();
        xa.u uVar3 = new xa.u();
        int O = i0Var.O();
        if (O == 67324752) {
            i0Var.a(2);
            short e10 = i0Var.e() & 65535;
            if ((e10 & 1) == 0) {
                i0Var.a(18);
                short e11 = i0Var.e() & 65535;
                i0Var.a(((long) i0Var.e()) & 65535);
                if (pVar == null) {
                    i0Var.a((long) e11);
                    return null;
                }
                p1(i0Var, e11, new ec.j(i0Var, uVar, uVar2, uVar3));
                return new dc.p(pVar.f4811a, pVar.f4812b, (f0) null, pVar.f4814d, (Long) uVar3.f16818h, (Long) uVar.f16818h, (Long) uVar2.f16818h, 128);
            }
            throw new IOException("unsupported zip: general purpose bit flag=" + q0(e10));
        }
        throw new IOException("bad zip: expected " + q0(67324752) + " but was " + q0(O));
    }

    public static final Bundle r(la.i... iVarArr) {
        Bundle bundle = new Bundle(iVarArr.length);
        for (la.i iVar : iVarArr) {
            String str = (String) iVar.f9799h;
            Object obj = iVar.f9800i;
            if (obj == null) {
                bundle.putString(str, (String) null);
            } else if (obj instanceof Boolean) {
                bundle.putBoolean(str, ((Boolean) obj).booleanValue());
            } else if (obj instanceof Byte) {
                bundle.putByte(str, ((Number) obj).byteValue());
            } else if (obj instanceof Character) {
                bundle.putChar(str, ((Character) obj).charValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Number) obj).doubleValue());
            } else if (obj instanceof Float) {
                bundle.putFloat(str, ((Number) obj).floatValue());
            } else if (obj instanceof Integer) {
                bundle.putInt(str, ((Number) obj).intValue());
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Number) obj).longValue());
            } else if (obj instanceof Short) {
                bundle.putShort(str, ((Number) obj).shortValue());
            } else if (obj instanceof Bundle) {
                bundle.putBundle(str, (Bundle) obj);
            } else if (obj instanceof CharSequence) {
                bundle.putCharSequence(str, (CharSequence) obj);
            } else if (obj instanceof Parcelable) {
                bundle.putParcelable(str, (Parcelable) obj);
            } else if (obj instanceof boolean[]) {
                bundle.putBooleanArray(str, (boolean[]) obj);
            } else if (obj instanceof byte[]) {
                bundle.putByteArray(str, (byte[]) obj);
            } else if (obj instanceof char[]) {
                bundle.putCharArray(str, (char[]) obj);
            } else if (obj instanceof double[]) {
                bundle.putDoubleArray(str, (double[]) obj);
            } else if (obj instanceof float[]) {
                bundle.putFloatArray(str, (float[]) obj);
            } else if (obj instanceof int[]) {
                bundle.putIntArray(str, (int[]) obj);
            } else if (obj instanceof long[]) {
                bundle.putLongArray(str, (long[]) obj);
            } else if (obj instanceof short[]) {
                bundle.putShortArray(str, (short[]) obj);
            } else {
                if (obj instanceof Object[]) {
                    Class<?> componentType = obj.getClass().getComponentType();
                    j.c(componentType);
                    if (Parcelable.class.isAssignableFrom(componentType)) {
                        bundle.putParcelableArray(str, (Parcelable[]) obj);
                    } else if (String.class.isAssignableFrom(componentType)) {
                        bundle.putStringArray(str, (String[]) obj);
                    } else if (CharSequence.class.isAssignableFrom(componentType)) {
                        bundle.putCharSequenceArray(str, (CharSequence[]) obj);
                    } else if (!Serializable.class.isAssignableFrom(componentType)) {
                        throw new IllegalArgumentException("Illegal value array type " + componentType.getCanonicalName() + " for key \"" + str + '\"');
                    }
                } else if (!(obj instanceof Serializable)) {
                    if (obj instanceof IBinder) {
                        i0.c.a(bundle, str, (IBinder) obj);
                    } else if (obj instanceof Size) {
                        i0.d.a(bundle, str, (Size) obj);
                    } else if (obj instanceof SizeF) {
                        i0.d.b(bundle, str, (SizeF) obj);
                    } else {
                        throw new IllegalArgumentException("Illegal value type " + obj.getClass().getCanonicalName() + " for key \"" + str + '\"');
                    }
                }
                bundle.putSerializable(str, (Serializable) obj);
            }
        }
        return bundle;
    }

    public static final String r0(Object obj) {
        return Integer.toHexString(System.identityHashCode(obj));
    }

    public static final Object r1(Object obj) {
        if (obj instanceof w) {
            int i10 = l.f9802h;
            return I(((w) obj).f7875a);
        }
        int i11 = l.f9802h;
        return obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0055, code lost:
        r2 = (lb.f) r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final kb.m0 s(kb.i r11, hb.f0 r12) {
        /*
            java.lang.String r0 = "<this>"
            xa.j.f(r0, r11)
            n3.t r1 = new n3.t
            r2 = 0
            r3 = 0
            r1.<init>((pa.e) r2, (java.lang.Object) r12, (int) r3)
            kb.i r11 = n3.q0.a(r11, r1)
            n3.u r1 = new n3.u
            r1.<init>(r3, r2)
            xa.j.f(r0, r11)
            n3.k0 r0 = new n3.k0
            r0.<init>(r11, r1, r2)
            kb.o0 r11 = new kb.o0
            r11.<init>(r0)
            androidx.fragment.app.p0 r0 = new androidx.fragment.app.p0
            r0.<init>(r3, r11)
            n3.v r11 = new n3.v
            r11.<init>(r2)
            kb.v r1 = new kb.v
            r1.<init>(r11, r0)
            n3.w r11 = new n3.w
            r11.<init>(r2, r2, r3)
            kb.t r0 = new kb.t
            r0.<init>(r1, r11)
            kb.w0 r11 = kb.x0.f9417a
            r11.getClass()
            kb.b1 r5 = kb.w0.f9413c
            jb.f r11 = jb.g.f8921d
            r11.getClass()
            int r11 = jb.f.f8920b
            r1 = 1
            if (r1 >= r11) goto L_0x004d
            goto L_0x004e
        L_0x004d:
            r11 = 1
        L_0x004e:
            int r11 = r11 - r1
            boolean r2 = r0 instanceof lb.f
            jb.a r4 = jb.a.SUSPEND
            if (r2 == 0) goto L_0x0079
            r2 = r0
            lb.f r2 = (lb.f) r2
            kb.i r6 = r2.i()
            if (r6 == 0) goto L_0x0079
            j1.z r0 = new j1.z
            r7 = -3
            jb.a r8 = r2.f9834j
            int r9 = r2.f9833i
            if (r9 == r7) goto L_0x006e
            r7 = -2
            if (r9 == r7) goto L_0x006e
            if (r9 == 0) goto L_0x006e
            r11 = r9
            goto L_0x0073
        L_0x006e:
            if (r8 != r4) goto L_0x0072
            if (r9 != 0) goto L_0x0073
        L_0x0072:
            r11 = 0
        L_0x0073:
            pa.k r2 = r2.f9832h
            r0.<init>((int) r11, (pa.k) r2, (jb.a) r8, (kb.i) r6)
            goto L_0x0081
        L_0x0079:
            j1.z r2 = new j1.z
            pa.l r6 = pa.l.f12754h
            r2.<init>((int) r11, (pa.k) r6, (jb.a) r4, (kb.i) r0)
            r0 = r2
        L_0x0081:
            int r11 = r0.f8483a
            java.lang.Object r2 = r0.f8485c
            jb.a r2 = (jb.a) r2
            kb.s0 r11 = kb.t0.a(r1, r11, r2)
            java.lang.Object r2 = r0.f8486d
            pa.k r2 = (pa.k) r2
            java.lang.Object r0 = r0.f8484b
            r6 = r0
            kb.i r6 = (kb.i) r6
            h3.u1 r8 = kb.t0.f9395a
            kb.y0 r0 = kb.w0.f9412b
            boolean r0 = xa.j.a(r5, r0)
            if (r0 == 0) goto L_0x00a0
            r0 = 1
            goto L_0x00a1
        L_0x00a0:
            r0 = 4
        L_0x00a1:
            kb.h0 r10 = new kb.h0
            r9 = 0
            r4 = r10
            r7 = r11
            r4.<init>(r5, r6, r7, r8, r9)
            pa.k r12 = g1(r12, r2)
            r2 = 2
            if (r0 != r2) goto L_0x00b1
            r3 = 1
        L_0x00b1:
            if (r3 == 0) goto L_0x00b9
            hb.w1 r1 = new hb.w1
            r1.<init>(r12, r10)
            goto L_0x00bf
        L_0x00b9:
            hb.c2 r2 = new hb.c2
            r2.<init>(r12, r1)
            r1 = r2
        L_0x00bf:
            r1.e0(r0, r1, r10)
            kb.m0 r12 = new kb.m0
            r12.<init>(r11)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.s(kb.i, hb.f0):kb.m0");
    }

    public static final Class s0(db.b bVar) {
        j.f("<this>", bVar);
        Class a10 = ((xa.c) bVar).a();
        j.d("null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>", a10);
        return a10;
    }

    public static final void s1(ViewPager2 viewPager2) {
        try {
            Field declaredField = ViewPager2.class.getDeclaredField("q");
            declaredField.setAccessible(true);
            Object obj = declaredField.get(viewPager2);
            j.d("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView", obj);
            RecyclerView recyclerView = (RecyclerView) obj;
            Field declaredField2 = RecyclerView.class.getDeclaredField("mTouchSlop");
            declaredField2.setAccessible(true);
            Object obj2 = declaredField2.get(recyclerView);
            j.d("null cannot be cast to non-null type kotlin.Int", obj2);
            declaredField2.set(recyclerView, Integer.valueOf(((Integer) obj2).intValue() * 2));
        } catch (Exception unused) {
        }
    }

    public static final long t(long j10, long j11, long j12) {
        if (j11 >= 1 && j10 >= 1 && j12 >= 1) {
            return ((long) Math.abs(Math.ceil(((double) (j11 - j10)) / ((double) j12)))) * ((long) 1000);
        }
        return -1;
    }

    public static final Class t0(db.b bVar) {
        j.f("<this>", bVar);
        Class a10 = ((xa.c) bVar).a();
        if (!a10.isPrimitive()) {
            return a10;
        }
        String name = a10.getName();
        switch (name.hashCode()) {
            case -1325958191:
                return !name.equals("double") ? a10 : Double.class;
            case 104431:
                return !name.equals("int") ? a10 : Integer.class;
            case 3039496:
                return !name.equals("byte") ? a10 : Byte.class;
            case 3052374:
                return !name.equals("char") ? a10 : Character.class;
            case 3327612:
                return !name.equals("long") ? a10 : Long.class;
            case 3625364:
                return !name.equals("void") ? a10 : Void.class;
            case 64711720:
                return !name.equals("boolean") ? a10 : Boolean.class;
            case 97526364:
                return !name.equals("float") ? a10 : Float.class;
            case 109413500:
                return !name.equals("short") ? a10 : Short.class;
            default:
                return a10;
        }
    }

    public static final void t1(int i10, int i11, Object[] objArr) {
        j.f("<this>", objArr);
        while (i10 < i11) {
            objArr[i10] = null;
            i10++;
        }
    }

    public static final void u(View view) {
        j.f("<this>", view);
        j1 j1Var = new j1(view, (e) null);
        eb.i iVar = new eb.i();
        iVar.f5348k = qa.d.a(iVar, iVar, j1Var);
        while (iVar.hasNext()) {
            View view2 = (View) iVar.next();
            s0.a aVar = (s0.a) view2.getTag(R.id.pooling_container_listener_holder_tag);
            if (aVar == null) {
                aVar = new s0.a();
                view2.setTag(R.id.pooling_container_listener_holder_tag, aVar);
            }
            ArrayList arrayList = aVar.f13971a;
            int d10 = r.d(arrayList);
            if (-1 < d10) {
                android.support.v4.media.h.y(arrayList.get(d10));
                throw null;
            }
        }
    }

    public static final l1 u0(pa.k kVar) {
        l1 l1Var = (l1) kVar.N(l1.f7823b);
        if (l1Var != null) {
            return l1Var;
        }
        throw new IllegalStateException(("Current context doesn't contain Job in it: " + kVar).toString());
    }

    public static final void u1(o0 o0Var, e eVar, boolean z10) {
        Object obj;
        Object k10 = o0Var.k();
        Throwable e10 = o0Var.e(k10);
        if (e10 != null) {
            int i10 = l.f9802h;
            obj = I(e10);
        } else {
            int i11 = l.f9802h;
            obj = o0Var.g(k10);
        }
        if (z10) {
            j.d("null cannot be cast to non-null type kotlinx.coroutines.internal.DispatchedContinuation<T of kotlinx.coroutines.DispatchedTaskKt.resume>", eVar);
            mb.i iVar = (mb.i) eVar;
            e eVar2 = iVar.f10861l;
            pa.k context = eVar2.getContext();
            Object c10 = mb.f0.c(context, iVar.f10863n);
            i2 Z1 = c10 != mb.f0.f10849a ? Z1(eVar2, context, c10) : null;
            try {
                iVar.f10861l.resumeWith(obj);
                v vVar = v.f9814a;
            } finally {
                if (Z1 == null || Z1.f0()) {
                    mb.f0.a(context, c10);
                }
            }
        } else {
            eVar.resumeWith(obj);
        }
    }

    public static final androidx.fragment.app.y v(wa.l lVar, Object obj, androidx.fragment.app.y yVar) {
        try {
            lVar.invoke(obj);
        } catch (Throwable th) {
            if (yVar == null || yVar.getCause() == th) {
                return new androidx.fragment.app.y("Exception in undelivered element handler for " + obj, th);
            }
            a.a(yVar, th);
        }
        return yVar;
    }

    public static final LifecycleCoroutineScopeImpl v0(d0 d0Var) {
        LifecycleCoroutineScopeImpl lifecycleCoroutineScopeImpl;
        boolean z10;
        j.f("<this>", d0Var);
        androidx.lifecycle.t o10 = d0Var.o();
        j.f("<this>", o10);
        while (true) {
            AtomicReference atomicReference = o10.f1763a;
            lifecycleCoroutineScopeImpl = (LifecycleCoroutineScopeImpl) atomicReference.get();
            if (lifecycleCoroutineScopeImpl == null) {
                d2 d2Var = new d2((l1) null);
                nb.e eVar = p0.f7833a;
                lifecycleCoroutineScopeImpl = new LifecycleCoroutineScopeImpl(o10, j1(d2Var, u.f10886a.Q0()));
                while (true) {
                    if (!atomicReference.compareAndSet((Object) null, lifecycleCoroutineScopeImpl)) {
                        if (atomicReference.get() != null) {
                            z10 = false;
                            continue;
                            break;
                        }
                    } else {
                        z10 = true;
                        continue;
                        break;
                    }
                }
                if (z10) {
                    nb.e eVar2 = p0.f7833a;
                    b1(lifecycleCoroutineScopeImpl, u.f10886a.Q0(), 0, new androidx.lifecycle.y(lifecycleCoroutineScopeImpl, (e) null), 2);
                    break;
                }
            } else {
                break;
            }
        }
        return lifecycleCoroutineScopeImpl;
    }

    public static final Object v1(pa.k kVar, p pVar) {
        d1 d1Var;
        s0 s0Var;
        long j10;
        w wVar;
        Thread currentThread = Thread.currentThread();
        pa.g gVar = (pa.g) kVar.N(pa.g.f12752g);
        if (gVar == null) {
            f2.f7793a.getClass();
            s0Var = f2.a();
            d1Var = d1.f7786h;
            kVar = kVar.I0(s0Var);
        } else {
            if (gVar instanceof s0) {
                s0 s0Var2 = (s0) gVar;
            }
            f2.f7793a.getClass();
            s0Var = (s0) f2.f7794b.get();
            d1Var = d1.f7786h;
        }
        f fVar = new f(g1(d1Var, kVar), currentThread, s0Var);
        fVar.e0(1, fVar, pVar);
        s0 s0Var3 = fVar.f7792l;
        if (s0Var3 != null) {
            int i10 = s0.f7843m;
            s0Var3.S0(false);
        }
        while (!Thread.interrupted()) {
            try {
                if (s0Var3 != null) {
                    j10 = s0Var3.U0();
                } else {
                    j10 = Long.MAX_VALUE;
                }
                if (!(!(fVar.H() instanceof f1))) {
                    LockSupport.parkNanos(fVar, j10);
                } else {
                    Object a10 = v1.a(fVar.H());
                    if (a10 instanceof w) {
                        wVar = (w) a10;
                    } else {
                        wVar = null;
                    }
                    if (wVar == null) {
                        return a10;
                    }
                    throw wVar.f7875a;
                }
            } finally {
                if (s0Var3 != null) {
                    int i11 = s0.f7843m;
                    s0Var3.Q0(false);
                }
            }
        }
        InterruptedException interruptedException = new InterruptedException();
        fVar.r(interruptedException);
        throw interruptedException;
    }

    public static final void w(pa.k kVar, CancellationException cancellationException) {
        l1 l1Var = (l1) kVar.N(l1.f7823b);
        if (l1Var != null) {
            l1Var.e(cancellationException);
        }
    }

    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final java.lang.Long w0(java.lang.String r3) {
        /*
            java.lang.String r0 = "filePath"
            xa.j.g(r0, r3)
            java.io.File r3 = l0(r3)
            boolean r0 = r3.exists()
            if (r0 == 0) goto L_0x002a
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile
            java.lang.String r1 = "r"
            r0.<init>(r3, r1)
            long r1 = r0.readLong()     // Catch:{ Exception -> 0x0027, all -> 0x0022 }
            java.lang.Long r3 = java.lang.Long.valueOf(r1)     // Catch:{ Exception -> 0x0027, all -> 0x0022 }
            r0.close()     // Catch:{ Exception -> 0x002b }
            goto L_0x002b
        L_0x0022:
            r3 = move-exception
            r0.close()     // Catch:{ Exception -> 0x0026 }
        L_0x0026:
            throw r3
        L_0x0027:
            r0.close()     // Catch:{ Exception -> 0x002a }
        L_0x002a:
            r3 = 0
        L_0x002b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.w0(java.lang.String):java.lang.Long");
    }

    public static final void x(int i10) {
        boolean z10 = true;
        if (i10 < 1) {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalArgumentException(android.support.v4.media.h.i("Expected positive parallelism level, but got ", i10).toString());
        }
    }

    public static final String x0(int i10, String str) {
        j.g("fileTempDir", str);
        return str + '/' + i10 + ".meta.data";
    }

    public static Object x1(wa.a aVar, ra.c cVar) {
        return c2(pa.l.f12754h, new h1(aVar, (e) null), cVar);
    }

    public static final void y(String str, r1 r1Var) {
        if (r1Var != null) {
            boolean z10 = false;
            if (r1Var.f12968o == null) {
                if (r1Var.f12969p == null) {
                    if (r1Var.f12970q == null) {
                        z10 = true;
                    }
                    if (!z10) {
                        throw new IllegalArgumentException(str.concat(".priorResponse != null").toString());
                    }
                    return;
                }
                throw new IllegalArgumentException(str.concat(".cacheResponse != null").toString());
            }
            throw new IllegalArgumentException(str.concat(".networkResponse != null").toString());
        }
    }

    public static final l y0(e eVar) {
        l lVar;
        l lVar2;
        boolean z10;
        boolean z11 = true;
        if (!(eVar instanceof mb.i)) {
            return new l(1, eVar);
        }
        mb.i iVar = (mb.i) eVar;
        while (true) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater = mb.i.f10859o;
            Object obj = atomicReferenceFieldUpdater.get(iVar);
            lVar = null;
            if (obj == null) {
                atomicReferenceFieldUpdater.set(iVar, mb.j.f10865b);
                lVar2 = null;
                break;
            } else if (obj instanceof l) {
                h3.u1 u1Var = mb.j.f10865b;
                while (true) {
                    if (!atomicReferenceFieldUpdater.compareAndSet(iVar, obj, u1Var)) {
                        if (atomicReferenceFieldUpdater.get(iVar) != obj) {
                            z10 = false;
                            break;
                        }
                    } else {
                        z10 = true;
                        break;
                    }
                }
                if (z10) {
                    lVar2 = (l) obj;
                    break;
                }
            } else if (obj != mb.j.f10865b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
        if (lVar2 != null) {
            AtomicReferenceFieldUpdater atomicReferenceFieldUpdater2 = l.f7819n;
            Object obj2 = atomicReferenceFieldUpdater2.get(lVar2);
            if (!(obj2 instanceof v) || ((v) obj2).f7864d == null) {
                l.f7818m.set(lVar2, 536870911);
                atomicReferenceFieldUpdater2.set(lVar2, b.f7777h);
            } else {
                lVar2.r();
                z11 = false;
            }
            if (z11) {
                lVar = lVar2;
            }
            if (lVar != null) {
                return lVar;
            }
        }
        return new l(2, eVar);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|12) */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0030 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void y1(int r3, int r4, java.lang.String r5) {
        /*
            java.lang.String r0 = "fileTempDir"
            xa.j.g(r0, r5)
            java.lang.String r3 = x0(r3, r5)     // Catch:{ Exception -> 0x0034 }
            long r4 = (long) r4     // Catch:{ Exception -> 0x0034 }
            java.lang.String r0 = "filePath"
            xa.j.g(r0, r3)     // Catch:{ Exception -> 0x0034 }
            java.io.File r3 = l0(r3)     // Catch:{ Exception -> 0x0034 }
            boolean r0 = r3.exists()     // Catch:{ Exception -> 0x0034 }
            if (r0 == 0) goto L_0x0034
            java.io.RandomAccessFile r0 = new java.io.RandomAccessFile     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = "rw"
            r0.<init>(r3, r1)     // Catch:{ Exception -> 0x0034 }
            r1 = 0
            r0.seek(r1)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            r0.setLength(r1)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            r0.writeLong(r4)     // Catch:{ Exception -> 0x0031, all -> 0x002c }
            goto L_0x0031
        L_0x002c:
            r3 = move-exception
            r0.close()     // Catch:{ Exception -> 0x0030 }
        L_0x0030:
            throw r3     // Catch:{ Exception -> 0x0034 }
        L_0x0031:
            r0.close()     // Catch:{ Exception -> 0x0034 }
        L_0x0034:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: hb.h0.y1(int, int, java.lang.String):void");
    }

    public static final la.i z(x0 x0Var) {
        Charset charset = fb.c.f5986b;
        if (x0Var != null) {
            w0 w0Var = x0.f13023d;
            Charset a10 = x0Var.a((Charset) null);
            if (a10 == null) {
                String str = x0Var + "; charset=utf-8";
                x0.f13023d.getClass();
                j.f("<this>", str);
                try {
                    x0Var = qb.c.a(str);
                } catch (IllegalArgumentException unused) {
                    x0Var = null;
                }
            } else {
                charset = a10;
            }
        }
        return new la.i(charset, x0Var);
    }

    public static final y9.t z0(String str, ContentResolver contentResolver) {
        ParcelFileDescriptor parcelFileDescriptor;
        j.g("filePath", str);
        if (!a1(str)) {
            return A0(new File(str));
        }
        Uri parse = Uri.parse(str);
        j.b("Uri.parse(filePath)", parse);
        if (j.a(parse.getScheme(), "content")) {
            parcelFileDescriptor = contentResolver.openFileDescriptor(parse, "w");
            if (parcelFileDescriptor == null) {
                throw new FileNotFoundException(parse + " file_not_found");
            }
        } else if (j.a(parse.getScheme(), "file")) {
            File file = new File(parse.getPath());
            if (file.exists() && file.canWrite()) {
                return A0(file);
            }
            parcelFileDescriptor = contentResolver.openFileDescriptor(parse, "w");
            if (parcelFileDescriptor == null) {
                throw new FileNotFoundException(parse + " file_not_found");
            }
        } else {
            throw new FileNotFoundException(parse + " file_not_found");
        }
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        j.b("parcelFileDescriptor.fileDescriptor", fileDescriptor);
        return new y9.w(new FileOutputStream(fileDescriptor));
    }

    public static final int z1(m0 m0Var, int i10) {
        int i11;
        j.f("<this>", m0Var);
        int i12 = i10 + 1;
        int length = m0Var.f4800m.length;
        int[] iArr = m0Var.f4801n;
        j.f("<this>", iArr);
        int i13 = length - 1;
        int i14 = 0;
        while (true) {
            if (i14 <= i13) {
                i11 = (i14 + i13) >>> 1;
                int i15 = iArr[i11];
                if (i15 >= i12) {
                    if (i15 <= i12) {
                        break;
                    }
                    i13 = i11 - 1;
                } else {
                    i14 = i11 + 1;
                }
            } else {
                i11 = (-i14) - 1;
                break;
            }
        }
        if (i11 >= 0) {
            return i11;
        }
        return ~i11;
    }
}
