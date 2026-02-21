package p3;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.media.session.g0;
import java.io.File;
import java.io.IOException;
import r.i;
import r.j;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final j f12555a = j.g();

    /* renamed from: b  reason: collision with root package name */
    public static final Object f12556b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public static g0 f12557c = null;

    private q() {
    }

    public static g0 a(int i10, boolean z10, boolean z11) {
        g0 g0Var = new g0();
        f12557c = g0Var;
        j jVar = f12555a;
        jVar.getClass();
        if (i.f13514m.b(jVar, (Object) null, g0Var)) {
            i.c(jVar);
        }
        return f12557c;
    }

    public static void b(Context context, boolean z10) {
        boolean z11;
        boolean z12;
        PackageInfo packageInfo;
        p pVar;
        p pVar2;
        if (z10 || f12557c == null) {
            synchronized (f12556b) {
                if (!z10) {
                    if (f12557c != null) {
                        return;
                    }
                }
                int i10 = Build.VERSION.SDK_INT;
                int i11 = 0;
                if (i10 >= 28) {
                    if (i10 != 30) {
                        File file = new File(new File("/data/misc/profiles/ref/", context.getPackageName()), "primary.prof");
                        long length = file.length();
                        if (!file.exists() || length <= 0) {
                            z11 = false;
                        } else {
                            z11 = true;
                        }
                        File file2 = new File(new File("/data/misc/profiles/cur/0/", context.getPackageName()), "primary.prof");
                        long length2 = file2.length();
                        if (!file2.exists() || length2 <= 0) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        try {
                            PackageManager packageManager = context.getApplicationContext().getPackageManager();
                            if (i10 >= 33) {
                                packageInfo = o.a(packageManager, context);
                            } else {
                                Context context2 = context;
                                packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                            }
                            long j10 = packageInfo.lastUpdateTime;
                            File file3 = new File(context.getFilesDir(), "profileInstalled");
                            if (file3.exists()) {
                                try {
                                    pVar = p.a(file3);
                                } catch (IOException unused) {
                                    a(131072, z11, z12);
                                    return;
                                }
                            } else {
                                pVar = null;
                            }
                            if (pVar != null && pVar.f12553c == j10) {
                                int i12 = pVar.f12552b;
                                if (i12 != 2) {
                                    i11 = i12;
                                    if (z10 && z12 && i11 != 1) {
                                        i11 = 2;
                                    }
                                    if (pVar != null && pVar.f12552b == 2 && i11 == 1 && length < pVar.f12554d) {
                                        i11 = 3;
                                    }
                                    pVar2 = new p(1, i11, j10, length2);
                                    if (pVar == null || !pVar.equals(pVar2)) {
                                        pVar2.b(file3);
                                    }
                                    a(i11, z11, z12);
                                    return;
                                }
                            }
                            if (z11) {
                                i11 = 1;
                            } else if (z12) {
                                i11 = 2;
                            }
                            i11 = 2;
                            i11 = 3;
                            pVar2 = new p(1, i11, j10, length2);
                            try {
                                pVar2.b(file3);
                            } catch (IOException unused2) {
                                i11 = 196608;
                            }
                            a(i11, z11, z12);
                            return;
                        } catch (PackageManager.NameNotFoundException unused3) {
                            a(65536, z11, z12);
                            return;
                        }
                    }
                }
                a(262144, false, false);
            }
        }
    }
}
