package x4;

import android.os.Build;
import android.os.StrictMode;
import h3.u2;
import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import p1.i0;

public final class d implements Closeable {

    /* renamed from: h  reason: collision with root package name */
    public final File f16659h;

    /* renamed from: i  reason: collision with root package name */
    public final File f16660i;

    /* renamed from: j  reason: collision with root package name */
    public final File f16661j;

    /* renamed from: k  reason: collision with root package name */
    public final File f16662k;

    /* renamed from: l  reason: collision with root package name */
    public final int f16663l;

    /* renamed from: m  reason: collision with root package name */
    public final long f16664m;

    /* renamed from: n  reason: collision with root package name */
    public final int f16665n;

    /* renamed from: o  reason: collision with root package name */
    public long f16666o = 0;

    /* renamed from: p  reason: collision with root package name */
    public BufferedWriter f16667p;

    /* renamed from: q  reason: collision with root package name */
    public final LinkedHashMap f16668q = new LinkedHashMap(0, 0.75f, true);

    /* renamed from: r  reason: collision with root package name */
    public int f16669r;

    /* renamed from: s  reason: collision with root package name */
    public long f16670s = 0;

    /* renamed from: t  reason: collision with root package name */
    public final ThreadPoolExecutor f16671t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), new b(0));

    /* renamed from: u  reason: collision with root package name */
    public final a f16672u = new a(this);

    public d(File file, long j10) {
        File file2 = file;
        this.f16659h = file2;
        this.f16663l = 1;
        this.f16660i = new File(file2, "journal");
        this.f16661j = new File(file2, "journal.tmp");
        this.f16662k = new File(file2, "journal.bkp");
        this.f16665n = 1;
        this.f16664m = j10;
    }

    public static void H0(File file, File file2, boolean z10) {
        if (z10) {
            k(file2);
        }
        if (!file.renameTo(file2)) {
            throw new IOException();
        }
    }

    public static d W(File file, long j10) {
        if (j10 > 0) {
            File file2 = new File(file, "journal.bkp");
            if (file2.exists()) {
                File file3 = new File(file, "journal");
                if (file3.exists()) {
                    file2.delete();
                } else {
                    H0(file2, file3, false);
                }
            }
            d dVar = new d(file, j10);
            if (dVar.f16660i.exists()) {
                try {
                    dVar.Z();
                    dVar.Y();
                    return dVar;
                } catch (IOException e10) {
                    PrintStream printStream = System.out;
                    printStream.println("DiskLruCache " + file + " is corrupt: " + e10.getMessage() + ", removing");
                    dVar.close();
                    g.a(dVar.f16659h);
                }
            }
            file.mkdirs();
            d dVar2 = new d(file, j10);
            dVar2.j0();
            return dVar2;
        }
        throw new IllegalArgumentException("maxSize <= 0");
    }

    public static void c(d dVar, i0 i0Var, boolean z10) {
        synchronized (dVar) {
            c cVar = (c) i0Var.f12465j;
            if (cVar.f16656f == i0Var) {
                if (z10 && !cVar.f16655e) {
                    int i10 = 0;
                    while (true) {
                        if (i10 >= dVar.f16665n) {
                            break;
                        } else if (!((boolean[]) i0Var.f12466k)[i10]) {
                            i0Var.c();
                            throw new IllegalStateException("Newly created entry didn't create value for index " + i10);
                        } else if (!cVar.f16654d[i10].exists()) {
                            i0Var.c();
                            break;
                        } else {
                            i10++;
                        }
                    }
                }
                for (int i11 = 0; i11 < dVar.f16665n; i11++) {
                    File file = cVar.f16654d[i11];
                    if (!z10) {
                        k(file);
                    } else if (file.exists()) {
                        File file2 = cVar.f16653c[i11];
                        file.renameTo(file2);
                        long j10 = cVar.f16652b[i11];
                        long length = file2.length();
                        cVar.f16652b[i11] = length;
                        dVar.f16666o = (dVar.f16666o - j10) + length;
                    }
                }
                dVar.f16669r++;
                cVar.f16656f = null;
                if (cVar.f16655e || z10) {
                    cVar.f16655e = true;
                    dVar.f16667p.append("CLEAN");
                    dVar.f16667p.append(' ');
                    dVar.f16667p.append(cVar.f16651a);
                    dVar.f16667p.append(cVar.a());
                    dVar.f16667p.append(10);
                    if (z10) {
                        long j11 = dVar.f16670s;
                        dVar.f16670s = 1 + j11;
                        cVar.f16657g = j11;
                    }
                } else {
                    dVar.f16668q.remove(cVar.f16651a);
                    dVar.f16667p.append("REMOVE");
                    dVar.f16667p.append(' ');
                    dVar.f16667p.append(cVar.f16651a);
                    dVar.f16667p.append(10);
                }
                w(dVar.f16667p);
                if (dVar.f16666o > dVar.f16664m || dVar.N()) {
                    dVar.f16671t.submit(dVar.f16672u);
                }
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public static void e(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.close();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.close();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public static void k(File file) {
        if (file.exists() && !file.delete()) {
            throw new IOException();
        }
    }

    public static void w(Writer writer) {
        if (Build.VERSION.SDK_INT < 26) {
            writer.flush();
            return;
        }
        StrictMode.ThreadPolicy threadPolicy = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(threadPolicy).permitUnbufferedIo().build());
        try {
            writer.flush();
        } finally {
            StrictMode.setThreadPolicy(threadPolicy);
        }
    }

    public final void I0() {
        while (this.f16666o > this.f16664m) {
            String str = (String) ((Map.Entry) this.f16668q.entrySet().iterator().next()).getKey();
            synchronized (this) {
                if (this.f16667p != null) {
                    c cVar = (c) this.f16668q.get(str);
                    if (cVar != null) {
                        if (cVar.f16656f == null) {
                            for (int i10 = 0; i10 < this.f16665n; i10++) {
                                File file = cVar.f16653c[i10];
                                if (file.exists()) {
                                    if (!file.delete()) {
                                        throw new IOException("failed to delete " + file);
                                    }
                                }
                                long j10 = this.f16666o;
                                long[] jArr = cVar.f16652b;
                                this.f16666o = j10 - jArr[i10];
                                jArr[i10] = 0;
                            }
                            this.f16669r++;
                            this.f16667p.append("REMOVE");
                            this.f16667p.append(' ');
                            this.f16667p.append(str);
                            this.f16667p.append(10);
                            this.f16668q.remove(str);
                            if (N()) {
                                this.f16671t.submit(this.f16672u);
                            }
                        }
                    }
                } else {
                    throw new IllegalStateException("cache is closed");
                }
            }
        }
    }

    public final boolean N() {
        int i10 = this.f16669r;
        return i10 >= 2000 && i10 >= this.f16668q.size();
    }

    public final void Y() {
        k(this.f16661j);
        Iterator it = this.f16668q.values().iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            i0 i0Var = cVar.f16656f;
            int i10 = this.f16665n;
            int i11 = 0;
            if (i0Var == null) {
                while (i11 < i10) {
                    this.f16666o += cVar.f16652b[i11];
                    i11++;
                }
            } else {
                cVar.f16656f = null;
                while (i11 < i10) {
                    k(cVar.f16653c[i11]);
                    k(cVar.f16654d[i11]);
                    i11++;
                }
                it.remove();
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:16|17|(1:19)|(1:21)(1:22)|23|24|38) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r10.f16669r = r1 - r10.f16668q.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006f, code lost:
        if (r2.f16678l == -1) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0071, code lost:
        r0 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0072, code lost:
        if (r0 != false) goto L_0x0074;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0074, code lost:
        j0();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0078, code lost:
        r10.f16667p = new java.io.BufferedWriter(new java.io.OutputStreamWriter(new java.io.FileOutputStream(r4, true), x4.g.f16679a));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008f, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0090, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x0062 */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:16:0x0062=Splitter:B:16:0x0062, B:29:0x0093=Splitter:B:29:0x0093} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z() {
        /*
            r10 = this;
            java.lang.String r0 = ", "
            java.lang.String r1 = "unexpected journal header: ["
            x4.f r2 = new x4.f
            java.io.FileInputStream r3 = new java.io.FileInputStream
            java.io.File r4 = r10.f16660i
            r3.<init>(r4)
            java.nio.charset.Charset r5 = x4.g.f16679a
            r2.<init>(r3, r5)
            java.lang.String r3 = r2.c()     // Catch:{ all -> 0x0091 }
            java.lang.String r5 = r2.c()     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = r2.c()     // Catch:{ all -> 0x0091 }
            java.lang.String r7 = r2.c()     // Catch:{ all -> 0x0091 }
            java.lang.String r8 = r2.c()     // Catch:{ all -> 0x0091 }
            java.lang.String r9 = "libcore.io.DiskLruCache"
            boolean r9 = r9.equals(r3)     // Catch:{ all -> 0x0091 }
            if (r9 == 0) goto L_0x0093
            java.lang.String r9 = "1"
            boolean r9 = r9.equals(r5)     // Catch:{ all -> 0x0091 }
            if (r9 == 0) goto L_0x0093
            int r9 = r10.f16663l     // Catch:{ all -> 0x0091 }
            java.lang.String r9 = java.lang.Integer.toString(r9)     // Catch:{ all -> 0x0091 }
            boolean r6 = r9.equals(r6)     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0093
            int r6 = r10.f16665n     // Catch:{ all -> 0x0091 }
            java.lang.String r6 = java.lang.Integer.toString(r6)     // Catch:{ all -> 0x0091 }
            boolean r6 = r6.equals(r7)     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0093
            java.lang.String r6 = ""
            boolean r6 = r6.equals(r8)     // Catch:{ all -> 0x0091 }
            if (r6 == 0) goto L_0x0093
            r0 = 0
            r1 = 0
        L_0x0058:
            java.lang.String r3 = r2.c()     // Catch:{ EOFException -> 0x0062 }
            r10.a0(r3)     // Catch:{ EOFException -> 0x0062 }
            int r1 = r1 + 1
            goto L_0x0058
        L_0x0062:
            java.util.LinkedHashMap r3 = r10.f16668q     // Catch:{ all -> 0x0091 }
            int r3 = r3.size()     // Catch:{ all -> 0x0091 }
            int r1 = r1 - r3
            r10.f16669r = r1     // Catch:{ all -> 0x0091 }
            int r1 = r2.f16678l     // Catch:{ all -> 0x0091 }
            r3 = -1
            r5 = 1
            if (r1 != r3) goto L_0x0072
            r0 = 1
        L_0x0072:
            if (r0 == 0) goto L_0x0078
            r10.j0()     // Catch:{ all -> 0x0091 }
            goto L_0x008b
        L_0x0078:
            java.io.BufferedWriter r0 = new java.io.BufferedWriter     // Catch:{ all -> 0x0091 }
            java.io.OutputStreamWriter r1 = new java.io.OutputStreamWriter     // Catch:{ all -> 0x0091 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ all -> 0x0091 }
            r3.<init>(r4, r5)     // Catch:{ all -> 0x0091 }
            java.nio.charset.Charset r4 = x4.g.f16679a     // Catch:{ all -> 0x0091 }
            r1.<init>(r3, r4)     // Catch:{ all -> 0x0091 }
            r0.<init>(r1)     // Catch:{ all -> 0x0091 }
            r10.f16667p = r0     // Catch:{ all -> 0x0091 }
        L_0x008b:
            r2.close()     // Catch:{ RuntimeException -> 0x008f, Exception -> 0x008e }
        L_0x008e:
            return
        L_0x008f:
            r0 = move-exception
            throw r0
        L_0x0091:
            r0 = move-exception
            goto L_0x00bc
        L_0x0093:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x0091 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0091 }
            r6.<init>(r1)     // Catch:{ all -> 0x0091 }
            r6.append(r3)     // Catch:{ all -> 0x0091 }
            r6.append(r0)     // Catch:{ all -> 0x0091 }
            r6.append(r5)     // Catch:{ all -> 0x0091 }
            r6.append(r0)     // Catch:{ all -> 0x0091 }
            r6.append(r7)     // Catch:{ all -> 0x0091 }
            r6.append(r0)     // Catch:{ all -> 0x0091 }
            r6.append(r8)     // Catch:{ all -> 0x0091 }
            java.lang.String r0 = "]"
            r6.append(r0)     // Catch:{ all -> 0x0091 }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x0091 }
            r4.<init>(r0)     // Catch:{ all -> 0x0091 }
            throw r4     // Catch:{ all -> 0x0091 }
        L_0x00bc:
            r2.close()     // Catch:{ RuntimeException -> 0x00c0, Exception -> 0x00bf }
        L_0x00bf:
            throw r0
        L_0x00c0:
            r0 = move-exception
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x4.d.Z():void");
    }

    public final void a0(String str) {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i10 = indexOf + 1;
            int indexOf2 = str.indexOf(32, i10);
            LinkedHashMap linkedHashMap = this.f16668q;
            if (indexOf2 == -1) {
                str2 = str.substring(i10);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    linkedHashMap.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i10, indexOf2);
            }
            c cVar = (c) linkedHashMap.get(str2);
            if (cVar == null) {
                cVar = new c(this, str2);
                linkedHashMap.put(str2, cVar);
            }
            int i11 = 0;
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                cVar.f16655e = true;
                cVar.f16656f = null;
                if (split.length == cVar.f16658h.f16665n) {
                    while (i11 < split.length) {
                        try {
                            cVar.f16652b[i11] = Long.parseLong(split[i11]);
                            i11++;
                        } catch (NumberFormatException unused) {
                            throw new IOException("unexpected journal line: " + Arrays.toString(split));
                        }
                    }
                    return;
                }
                throw new IOException("unexpected journal line: " + Arrays.toString(split));
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                cVar.f16656f = new i0(this, cVar, 0);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: ".concat(str));
            }
        } else {
            throw new IOException("unexpected journal line: ".concat(str));
        }
    }

    public final synchronized void close() {
        if (this.f16667p != null) {
            Iterator it = new ArrayList(this.f16668q.values()).iterator();
            while (it.hasNext()) {
                i0 i0Var = ((c) it.next()).f16656f;
                if (i0Var != null) {
                    i0Var.c();
                }
            }
            I0();
            e(this.f16667p);
            this.f16667p = null;
        }
    }

    /* JADX INFO: finally extract failed */
    public final synchronized void j0() {
        StringBuilder sb2;
        BufferedWriter bufferedWriter = this.f16667p;
        if (bufferedWriter != null) {
            e(bufferedWriter);
        }
        BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16661j), g.f16679a));
        try {
            bufferedWriter2.write("libcore.io.DiskLruCache");
            bufferedWriter2.write(Constants.WRITE_NEW_LINE);
            bufferedWriter2.write("1");
            bufferedWriter2.write(Constants.WRITE_NEW_LINE);
            bufferedWriter2.write(Integer.toString(this.f16663l));
            bufferedWriter2.write(Constants.WRITE_NEW_LINE);
            bufferedWriter2.write(Integer.toString(this.f16665n));
            bufferedWriter2.write(Constants.WRITE_NEW_LINE);
            bufferedWriter2.write(Constants.WRITE_NEW_LINE);
            for (c cVar : this.f16668q.values()) {
                if (cVar.f16656f != null) {
                    sb2 = new StringBuilder();
                    sb2.append("DIRTY ");
                    sb2.append(cVar.f16651a);
                    sb2.append(10);
                } else {
                    sb2 = new StringBuilder();
                    sb2.append("CLEAN ");
                    sb2.append(cVar.f16651a);
                    sb2.append(cVar.a());
                    sb2.append(10);
                }
                bufferedWriter2.write(sb2.toString());
            }
            e(bufferedWriter2);
            if (this.f16660i.exists()) {
                H0(this.f16660i, this.f16662k, true);
            }
            H0(this.f16661j, this.f16660i, false);
            this.f16662k.delete();
            this.f16667p = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(this.f16660i, true), g.f16679a));
        } catch (Throwable th) {
            e(bufferedWriter2);
            throw th;
        }
    }

    public final i0 v(String str) {
        synchronized (this) {
            if (this.f16667p != null) {
                c cVar = (c) this.f16668q.get(str);
                if (cVar == null) {
                    cVar = new c(this, str);
                    this.f16668q.put(str, cVar);
                } else if (cVar.f16656f != null) {
                    return null;
                }
                i0 i0Var = new i0(this, cVar, 0);
                cVar.f16656f = i0Var;
                this.f16667p.append("DIRTY");
                this.f16667p.append(' ');
                this.f16667p.append(str);
                this.f16667p.append(10);
                w(this.f16667p);
                return i0Var;
            }
            throw new IllegalStateException("cache is closed");
        }
    }

    public final synchronized u2 z(String str) {
        if (this.f16667p != null) {
            c cVar = (c) this.f16668q.get(str);
            if (cVar == null) {
                return null;
            }
            if (!cVar.f16655e) {
                return null;
            }
            for (File exists : cVar.f16653c) {
                if (!exists.exists()) {
                    return null;
                }
            }
            this.f16669r++;
            this.f16667p.append("READ");
            this.f16667p.append(' ');
            this.f16667p.append(str);
            this.f16667p.append(10);
            if (N()) {
                this.f16671t.submit(this.f16672u);
            }
            return new u2(this, str, cVar.f16657g, cVar.f16653c, cVar.f16652b);
        }
        throw new IllegalStateException("cache is closed");
    }
}
