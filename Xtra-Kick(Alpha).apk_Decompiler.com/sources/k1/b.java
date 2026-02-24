package k1;

import android.content.Context;
import android.content.res.AssetManager;
import android.net.Uri;
import j1.l0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public final class b extends c {

    /* renamed from: e  reason: collision with root package name */
    public final AssetManager f8966e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f8967f;

    /* renamed from: g  reason: collision with root package name */
    public InputStream f8968g;

    /* renamed from: h  reason: collision with root package name */
    public long f8969h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f8970i;

    public b(Context context) {
        super(false);
        this.f8966e = context.getAssets();
    }

    public final void close() {
        this.f8967f = null;
        try {
            InputStream inputStream = this.f8968g;
            if (inputStream != null) {
                inputStream.close();
            }
            this.f8968g = null;
            if (this.f8970i) {
                this.f8970i = false;
                s();
            }
        } catch (IOException e10) {
            throw new a(e10, 2000);
        } catch (Throwable th) {
            this.f8968g = null;
            if (this.f8970i) {
                this.f8970i = false;
                s();
            }
            throw th;
        }
    }

    public final Uri j() {
        return this.f8967f;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f8969h;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, (long) i11);
            } catch (IOException e10) {
                throw new a(e10, 2000);
            }
        }
        InputStream inputStream = this.f8968g;
        int i12 = l0.f8453a;
        int read = inputStream.read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        long j11 = this.f8969h;
        if (j11 != -1) {
            this.f8969h = j11 - ((long) read);
        }
        r(read);
        return read;
    }

    public final long q(m mVar) {
        int i10;
        try {
            Uri uri = mVar.f9022a;
            long j10 = mVar.f9027f;
            this.f8967f = uri;
            String path = uri.getPath();
            path.getClass();
            if (path.startsWith("/android_asset/")) {
                path = path.substring(15);
            } else if (path.startsWith(Constants.LIST_SEPARATOR)) {
                path = path.substring(1);
            }
            t();
            InputStream open = this.f8966e.open(path, 1);
            this.f8968g = open;
            if (open.skip(j10) >= j10) {
                long j11 = mVar.f9028g;
                if (j11 != -1) {
                    this.f8969h = j11;
                } else {
                    long available = (long) this.f8968g.available();
                    this.f8969h = available;
                    if (available == 2147483647L) {
                        this.f8969h = -1;
                    }
                }
                this.f8970i = true;
                u(mVar);
                return this.f8969h;
            }
            throw new a((IOException) null, 2008);
        } catch (a e10) {
            throw e10;
        } catch (IOException e11) {
            if (e11 instanceof FileNotFoundException) {
                i10 = 2005;
            } else {
                i10 = 2000;
            }
            throw new a(e11, i10);
        }
    }
}
