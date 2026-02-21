package k4;

import android.os.StatFs;
import cb.l;
import dc.f0;
import dc.r;
import dc.z;
import hb.p0;
import java.io.File;
import nb.d;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public f0 f9079a;

    /* renamed from: b  reason: collision with root package name */
    public final z f9080b = r.f4819a;

    /* renamed from: c  reason: collision with root package name */
    public final double f9081c = 0.02d;

    /* renamed from: d  reason: collision with root package name */
    public final long f9082d = 10485760;

    /* renamed from: e  reason: collision with root package name */
    public final long f9083e = 262144000;

    /* renamed from: f  reason: collision with root package name */
    public final d f9084f = p0.f7834b;

    public final n a() {
        long j10;
        f0 f0Var = this.f9079a;
        if (f0Var != null) {
            double d10 = this.f9081c;
            if (d10 > 0.0d) {
                try {
                    File d11 = f0Var.d();
                    d11.mkdir();
                    StatFs statFs = new StatFs(d11.getAbsolutePath());
                    j10 = l.a((long) (d10 * ((double) statFs.getBlockCountLong()) * ((double) statFs.getBlockSizeLong())), this.f9082d, this.f9083e);
                } catch (Exception unused) {
                    j10 = this.f9082d;
                }
            } else {
                j10 = 0;
            }
            return new n(j10, f0Var, this.f9080b, this.f9084f);
        }
        throw new IllegalStateException("directory == null".toString());
    }
}
