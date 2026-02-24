package androidx.emoji2.text;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import q.f;

public final class p {

    /* renamed from: i  reason: collision with root package name */
    public static final Object f1266i = new Object();

    /* renamed from: j  reason: collision with root package name */
    public static volatile p f1267j;

    /* renamed from: a  reason: collision with root package name */
    public final ReentrantReadWriteLock f1268a;

    /* renamed from: b  reason: collision with root package name */
    public final f f1269b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f1270c = 3;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f1271d;

    /* renamed from: e  reason: collision with root package name */
    public final i f1272e;

    /* renamed from: f  reason: collision with root package name */
    public final m f1273f;

    /* renamed from: g  reason: collision with root package name */
    public final int f1274g;

    /* renamed from: h  reason: collision with root package name */
    public final g f1275h;

    public p(q qVar) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
        this.f1268a = reentrantReadWriteLock;
        this.f1273f = qVar.f1261a;
        int i10 = qVar.f1262b;
        this.f1274g = i10;
        this.f1275h = qVar.f1263c;
        this.f1271d = new Handler(Looper.getMainLooper());
        this.f1269b = new f();
        i iVar = new i(this);
        this.f1272e = iVar;
        reentrantReadWriteLock.writeLock().lock();
        if (i10 == 0) {
            try {
                this.f1270c = 0;
            } catch (Throwable th) {
                this.f1268a.writeLock().unlock();
                throw th;
            }
        }
        reentrantReadWriteLock.writeLock().unlock();
        if (b() == 0) {
            try {
                ((p) iVar.f4852i).f1273f.a(new h(iVar));
            } catch (Throwable th2) {
                ((p) iVar.f4852i).d(th2);
            }
        }
    }

    public static p a() {
        p pVar;
        boolean z10;
        synchronized (f1266i) {
            pVar = f1267j;
            if (pVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                throw new IllegalStateException("EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
            }
        }
        return pVar;
    }

    public final int b() {
        this.f1268a.readLock().lock();
        try {
            return this.f1270c;
        } finally {
            this.f1268a.readLock().unlock();
        }
    }

    public final void c() {
        boolean z10;
        boolean z11 = true;
        if (this.f1274g == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            if (b() != 1) {
                z11 = false;
            }
            if (!z11) {
                this.f1268a.writeLock().lock();
                try {
                    if (this.f1270c != 0) {
                        this.f1270c = 0;
                        this.f1268a.writeLock().unlock();
                        i iVar = this.f1272e;
                        iVar.getClass();
                        try {
                            ((p) iVar.f4852i).f1273f.a(new h(iVar));
                        } catch (Throwable th) {
                            ((p) iVar.f4852i).d(th);
                        }
                    }
                } finally {
                    this.f1268a.writeLock().unlock();
                }
            }
        } else {
            throw new IllegalStateException("Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        }
    }

    /* JADX INFO: finally extract failed */
    public final void d(Throwable th) {
        ArrayList arrayList = new ArrayList();
        this.f1268a.writeLock().lock();
        try {
            this.f1270c = 2;
            arrayList.addAll(this.f1269b);
            this.f1269b.clear();
            this.f1268a.writeLock().unlock();
            this.f1271d.post(new c.f((List) arrayList, this.f1270c, th));
        } catch (Throwable th2) {
            this.f1268a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public final void e() {
        ArrayList arrayList = new ArrayList();
        this.f1268a.writeLock().lock();
        try {
            this.f1270c = 1;
            arrayList.addAll(this.f1269b);
            this.f1269b.clear();
            this.f1268a.writeLock().unlock();
            this.f1271d.post(new c.f(this.f1270c, arrayList));
        } catch (Throwable th) {
            this.f1268a.writeLock().unlock();
            throw th;
        }
    }

    public final CharSequence f(int i10, int i11, CharSequence charSequence) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13 = true;
        if (b() == 1) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            throw new IllegalStateException("Not initialized yet");
        } else if (i10 < 0) {
            throw new IllegalArgumentException("start cannot be negative");
        } else if (i11 >= 0) {
            if (i10 <= i11) {
                z11 = true;
            } else {
                z11 = false;
            }
            l0.f.a("start should be <= than end", z11);
            if (charSequence == null) {
                return null;
            }
            if (i10 <= charSequence.length()) {
                z12 = true;
            } else {
                z12 = false;
            }
            l0.f.a("start should be < than charSequence length", z12);
            if (i11 > charSequence.length()) {
                z13 = false;
            }
            l0.f.a("end should be < than charSequence length", z13);
            if (charSequence.length() == 0 || i10 == i11) {
                return charSequence;
            }
            return this.f1272e.I(charSequence, i10, i11, false);
        } else {
            throw new IllegalArgumentException("end cannot be negative");
        }
    }

    public final void g(l lVar) {
        if (lVar != null) {
            this.f1268a.writeLock().lock();
            try {
                if (this.f1270c != 1) {
                    if (this.f1270c != 2) {
                        this.f1269b.add(lVar);
                    }
                }
                this.f1271d.post(new c.f(lVar, this.f1270c));
            } finally {
                this.f1268a.writeLock().unlock();
            }
        } else {
            throw new NullPointerException("initCallback cannot be null");
        }
    }
}
