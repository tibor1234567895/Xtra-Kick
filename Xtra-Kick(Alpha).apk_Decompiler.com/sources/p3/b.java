package p3;

import android.content.res.AssetManager;
import android.os.Build;
import j1.p;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.concurrent.Executor;
import n.a;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public final AssetManager f12526a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f12527b;

    /* renamed from: c  reason: collision with root package name */
    public final g f12528c;

    /* renamed from: d  reason: collision with root package name */
    public final byte[] f12529d;

    /* renamed from: e  reason: collision with root package name */
    public final File f12530e;

    /* renamed from: f  reason: collision with root package name */
    public final String f12531f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f12532g = false;

    /* renamed from: h  reason: collision with root package name */
    public c[] f12533h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f12534i;

    public b(AssetManager assetManager, a aVar, g gVar, String str, File file) {
        byte[] bArr;
        this.f12526a = assetManager;
        this.f12527b = aVar;
        this.f12528c = gVar;
        this.f12531f = str;
        this.f12530e = file;
        int i10 = Build.VERSION.SDK_INT;
        if (i10 >= 24 && i10 <= 34) {
            switch (i10) {
                case 24:
                case 25:
                    bArr = r.f12562e;
                    break;
                case 26:
                    bArr = r.f12561d;
                    break;
                case 27:
                    bArr = r.f12560c;
                    break;
                case 28:
                case 29:
                case 30:
                    bArr = r.f12559b;
                    break;
                case 31:
                case Constants.IV_SIZE_ALTERNATIVE:
                case 33:
                case 34:
                    bArr = r.f12558a;
                    break;
            }
        }
        bArr = null;
        this.f12529d = bArr;
    }

    public final FileInputStream a(AssetManager assetManager, String str) {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e10) {
            String message = e10.getMessage();
            if (message != null && message.contains("compressed")) {
                this.f12528c.q();
            }
            return null;
        }
    }

    public final void b(int i10, Serializable serializable) {
        this.f12527b.execute(new p((Object) this, i10, (Object) serializable, 5));
    }
}
