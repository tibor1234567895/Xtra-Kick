package p1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.Spatializer;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Trace;
import android.text.TextUtils;
import android.util.Log;
import com.bumptech.glide.c;
import com.bumptech.glide.manager.w;
import com.bumptech.glide.manager.x;
import com.bumptech.glide.o;
import d9.w1;
import dc.f0;
import g1.a0;
import g1.n;
import j1.l0;
import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import k1.g;
import k1.p;
import k4.e;
import k4.i;
import la.v;
import o1.b0;
import q5.a;
import w5.h;
import x4.d;
import xa.j;
import z1.l;
import z1.q;

public final class i0 implements h, x {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f12463h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f12464i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f12465j;

    /* renamed from: k  reason: collision with root package name */
    public Object f12466k;

    /* renamed from: l  reason: collision with root package name */
    public Object f12467l;

    public i0(Spatializer spatializer) {
        boolean z10 = true;
        this.f12463h = 1;
        this.f12465j = spatializer;
        this.f12464i = spatializer.getImmersiveAudioLevel() == 0 ? false : z10;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0049, code lost:
        r0 = r8.toByteArray();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r2 = j1.l0.f8453a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r7.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0039, code lost:
        r9 = r7.read(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x003e, code lost:
        if (r9 == -1) goto L_0x0049;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0040, code lost:
        r8.write(r0, r3, r9);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:52:0x00c8 */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0084 A[Catch:{ z -> 0x0047, all -> 0x0044, Exception -> 0x00c9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00c2 A[EDGE_INSN: B:46:0x00c2->B:47:? ?: BREAK  , SYNTHETIC, Splitter:B:46:0x00c2] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] h(k1.g r24, java.lang.String r25, byte[] r26, java.util.Map r27) {
        /*
            k1.e0 r1 = new k1.e0
            k1.h r0 = r24.a()
            r1.<init>(r0)
            k1.l r0 = new k1.l
            r0.<init>()
            android.net.Uri r2 = android.net.Uri.parse(r25)
            r0.f9013a = r2
            r2 = r27
            r0.f9016d = r2
            r2 = 2
            r0.f9014b = r2
            r2 = r26
            r0.f9015c = r2
            r2 = 1
            r0.f9020h = r2
            k1.m r4 = r0.a()
            r3 = 0
            r5 = r4
            r6 = 0
        L_0x0029:
            k1.j r7 = new k1.j     // Catch:{ Exception -> 0x00c9 }
            r7.<init>(r1, r5)     // Catch:{ Exception -> 0x00c9 }
            int r0 = j1.l0.f8453a     // Catch:{ z -> 0x0047 }
            r0 = 4096(0x1000, float:5.74E-42)
            byte[] r0 = new byte[r0]     // Catch:{ z -> 0x0047 }
            java.io.ByteArrayOutputStream r8 = new java.io.ByteArrayOutputStream     // Catch:{ z -> 0x0047 }
            r8.<init>()     // Catch:{ z -> 0x0047 }
        L_0x0039:
            int r9 = r7.read(r0)     // Catch:{ z -> 0x0047 }
            r10 = -1
            if (r9 == r10) goto L_0x0049
            r8.write(r0, r3, r9)     // Catch:{ z -> 0x0047 }
            goto L_0x0039
        L_0x0044:
            r0 = move-exception
            goto L_0x00c3
        L_0x0047:
            r0 = move-exception
            goto L_0x0053
        L_0x0049:
            byte[] r0 = r8.toByteArray()     // Catch:{ z -> 0x0047 }
            int r2 = j1.l0.f8453a     // Catch:{ Exception -> 0x00c9 }
            r7.close()     // Catch:{ IOException -> 0x0052 }
        L_0x0052:
            return r0
        L_0x0053:
            int r8 = r0.f9070k     // Catch:{ all -> 0x0044 }
            r9 = 307(0x133, float:4.3E-43)
            if (r8 == r9) goto L_0x005d
            r9 = 308(0x134, float:4.32E-43)
            if (r8 != r9) goto L_0x0062
        L_0x005d:
            r8 = 5
            if (r6 >= r8) goto L_0x0062
            r8 = 1
            goto L_0x0063
        L_0x0062:
            r8 = 0
        L_0x0063:
            if (r8 != 0) goto L_0x0066
            goto L_0x0081
        L_0x0066:
            java.util.Map r8 = r0.f9071l     // Catch:{ all -> 0x0044 }
            if (r8 == 0) goto L_0x0081
            java.lang.String r9 = "Location"
            java.lang.Object r8 = r8.get(r9)     // Catch:{ all -> 0x0044 }
            java.util.List r8 = (java.util.List) r8     // Catch:{ all -> 0x0044 }
            if (r8 == 0) goto L_0x0081
            boolean r9 = r8.isEmpty()     // Catch:{ all -> 0x0044 }
            if (r9 != 0) goto L_0x0081
            java.lang.Object r8 = r8.get(r3)     // Catch:{ all -> 0x0044 }
            java.lang.String r8 = (java.lang.String) r8     // Catch:{ all -> 0x0044 }
            goto L_0x0082
        L_0x0081:
            r8 = 0
        L_0x0082:
            if (r8 == 0) goto L_0x00c2
            int r6 = r6 + 1
            long r11 = r5.f9023b     // Catch:{ all -> 0x0044 }
            int r13 = r5.f9024c     // Catch:{ all -> 0x0044 }
            byte[] r14 = r5.f9025d     // Catch:{ all -> 0x0044 }
            java.util.Map r15 = r5.f9026e     // Catch:{ all -> 0x0044 }
            long r9 = r5.f9027f     // Catch:{ all -> 0x0044 }
            long r2 = r5.f9028g     // Catch:{ all -> 0x0044 }
            java.lang.String r0 = r5.f9029h     // Catch:{ all -> 0x0044 }
            r26 = r6
            int r6 = r5.f9030i     // Catch:{ all -> 0x0044 }
            java.lang.Object r5 = r5.f9031j     // Catch:{ all -> 0x0044 }
            android.net.Uri r8 = android.net.Uri.parse(r8)     // Catch:{ all -> 0x0044 }
            r16 = r9
            java.lang.String r9 = "The uri must be set."
            j1.a.g(r8, r9)     // Catch:{ all -> 0x0044 }
            k1.m r23 = new k1.m     // Catch:{ all -> 0x0044 }
            r9 = r23
            r10 = r8
            r18 = r2
            r20 = r0
            r21 = r6
            r22 = r5
            r9.<init>(r10, r11, r13, r14, r15, r16, r18, r20, r21, r22)     // Catch:{ all -> 0x0044 }
            int r0 = j1.l0.f8453a     // Catch:{ Exception -> 0x00c9 }
            r7.close()     // Catch:{ IOException -> 0x00ba }
        L_0x00ba:
            r6 = r26
            r5 = r23
            r2 = 1
            r3 = 0
            goto L_0x0029
        L_0x00c2:
            throw r0     // Catch:{ all -> 0x0044 }
        L_0x00c3:
            int r2 = j1.l0.f8453a     // Catch:{ Exception -> 0x00c9 }
            r7.close()     // Catch:{ IOException -> 0x00c8 }
        L_0x00c8:
            throw r0     // Catch:{ Exception -> 0x00c9 }
        L_0x00c9:
            r0 = move-exception
            r9 = r0
            p1.k0 r0 = new p1.k0
            android.net.Uri r5 = r1.f8992c
            r5.getClass()
            java.util.Map r6 = r1.e()
            long r7 = r1.f8991b
            r3 = r0
            r3.<init>(r4, r5, r6, r7, r9)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p1.i0.h(k1.g, java.lang.String, byte[], java.util.Map):byte[]");
    }

    public final void a() {
        ((ConnectivityManager) ((h) this.f12466k).get()).unregisterNetworkCallback((ConnectivityManager.NetworkCallback) this.f12467l);
    }

    public final boolean b() {
        this.f12464i = ((ConnectivityManager) ((h) this.f12466k).get()).getActiveNetwork() != null;
        try {
            ((ConnectivityManager) ((h) this.f12466k).get()).registerDefaultNetworkCallback((ConnectivityManager.NetworkCallback) this.f12467l);
            return true;
        } catch (RuntimeException e10) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register callback", e10);
            }
            return false;
        }
    }

    public final void c() {
        switch (this.f12463h) {
            case 2:
                e(false);
                return;
            default:
                d.c((d) this.f12467l, this, false);
                return;
        }
    }

    public final boolean d(g1.h hVar, a0 a0Var) {
        boolean equals = "audio/eac3-joc".equals(a0Var.f6276s);
        int i10 = a0Var.F;
        if (equals && i10 == 16) {
            i10 = 12;
        }
        AudioFormat.Builder channelMask = new AudioFormat.Builder().setEncoding(2).setChannelMask(l0.m(i10));
        int i11 = a0Var.G;
        if (i11 != -1) {
            channelMask.setSampleRate(i11);
        }
        return ((Spatializer) this.f12465j).canBeSpatialized((AudioAttributes) hVar.i().f4852i, channelMask.build());
    }

    public final void e(boolean z10) {
        Object obj = this.f12467l;
        i iVar = (i) obj;
        i iVar2 = (i) obj;
        synchronized (iVar) {
            if (!this.f12464i) {
                if (j.a(((e) this.f12465j).f9091g, this)) {
                    i.c(iVar2, this, z10);
                }
                this.f12464i = true;
                v vVar = v.f9814a;
            } else {
                throw new IllegalStateException("editor is closed".toString());
            }
        }
    }

    public final void f(q qVar, Looper looper) {
        if (((Spatializer.OnSpatializerStateChangedListener) this.f12467l) == null && ((Handler) this.f12466k) == null) {
            this.f12467l = new l(qVar);
            Handler handler = new Handler(looper);
            this.f12466k = handler;
            ((Spatializer) this.f12465j).addOnSpatializerStateChangedListener(new b0(1, handler), (Spatializer.OnSpatializerStateChangedListener) this.f12467l);
        }
    }

    public final byte[] g(UUID uuid, a0 a0Var) {
        String str;
        String str2 = a0Var.f12411b;
        if (this.f12464i || TextUtils.isEmpty(str2)) {
            str2 = (String) this.f12466k;
        }
        if (!TextUtils.isEmpty(str2)) {
            HashMap hashMap = new HashMap();
            UUID uuid2 = n.f6477e;
            if (uuid2.equals(uuid)) {
                str = "text/xml";
            } else if (n.f6475c.equals(uuid)) {
                str = "application/json";
            } else {
                str = "application/octet-stream";
            }
            hashMap.put("Content-Type", str);
            if (uuid2.equals(uuid)) {
                hashMap.put("SOAPAction", "http://schemas.microsoft.com/DRM/2007/03/protocols/AcquireLicense");
            }
            synchronized (((Map) this.f12467l)) {
                hashMap.putAll((Map) this.f12467l);
            }
            return h((g) this.f12465j, str2, a0Var.f12410a, hashMap);
        }
        k1.l lVar = new k1.l();
        lVar.f9013a = Uri.EMPTY;
        throw new k0(lVar.a(), Uri.EMPTY, w1.f4691n, 0, new IllegalStateException("No license URL"));
    }

    public final Object get() {
        if (!this.f12464i) {
            Trace.beginSection("Glide registry");
            this.f12464i = true;
            try {
                return o.a((c) this.f12465j, (List) this.f12466k, (a) this.f12467l);
            } finally {
                this.f12464i = false;
                Trace.endSection();
            }
        } else {
            throw new IllegalStateException("Recursive Registry initialization! In your AppGlideModule and LibraryGlideModules, Make sure you're using the provided Registry rather calling glide.getRegistry()!");
        }
    }

    public final byte[] i(b0 b0Var) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b0Var.f12417b);
        sb2.append("&signedRequest=");
        int i10 = l0.f8453a;
        sb2.append(new String(b0Var.f12416a, c9.h.f3035c));
        return h((g) this.f12465j, sb2.toString(), (byte[]) null, Collections.emptyMap());
    }

    public final f0 j(int i10) {
        f0 f0Var;
        i iVar = (i) this.f12467l;
        synchronized (iVar) {
            if (!this.f12464i) {
                ((boolean[]) this.f12466k)[i10] = true;
                Object obj = ((e) this.f12465j).f9088d.get(i10);
                k4.g gVar = iVar.f9115w;
                f0 f0Var2 = (f0) obj;
                if (!gVar.f(f0Var2)) {
                    w4.e.a(gVar.k(f0Var2));
                }
                f0Var = (f0) obj;
            } else {
                throw new IllegalStateException("editor is closed".toString());
            }
        }
        return f0Var;
    }

    public final File k() {
        File file;
        synchronized (((d) this.f12467l)) {
            Object obj = this.f12465j;
            if (((x4.c) obj).f16656f == this) {
                if (!((x4.c) obj).f16655e) {
                    ((boolean[]) this.f12466k)[0] = true;
                }
                file = ((x4.c) obj).f16654d[0];
                ((d) this.f12467l).f16659h.mkdirs();
            } else {
                throw new IllegalStateException();
            }
        }
        return file;
    }

    public i0(c cVar, List list, a aVar) {
        this.f12463h = 3;
        this.f12465j = cVar;
        this.f12466k = list;
        this.f12467l = aVar;
    }

    public i0(d5.v vVar, w wVar) {
        this.f12463h = 5;
        this.f12467l = new r4.i(1, this);
        this.f12466k = vVar;
        this.f12465j = wVar;
    }

    public i0(String str, boolean z10, p pVar) {
        boolean z11 = false;
        this.f12463h = 0;
        j1.a.b((!z10 || !TextUtils.isEmpty(str)) ? true : z11);
        this.f12465j = pVar;
        this.f12466k = str;
        this.f12464i = z10;
        this.f12467l = new HashMap();
    }

    public i0(i iVar, e eVar) {
        this.f12463h = 2;
        this.f12467l = iVar;
        this.f12465j = eVar;
        iVar.getClass();
        this.f12466k = new boolean[2];
    }

    public i0(d dVar, x4.c cVar) {
        boolean[] zArr;
        this.f12463h = 4;
        this.f12467l = dVar;
        this.f12465j = cVar;
        if (cVar.f16655e) {
            zArr = null;
        } else {
            zArr = new boolean[dVar.f16665n];
        }
        this.f12466k = zArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i0(d dVar, x4.c cVar, int i10) {
        this(dVar, cVar);
        this.f12463h = 4;
    }
}
