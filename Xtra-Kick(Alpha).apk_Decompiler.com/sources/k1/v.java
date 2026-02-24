package k1;

import android.net.Uri;
import android.text.TextUtils;
import j1.l0;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class v extends c {

    /* renamed from: e  reason: collision with root package name */
    public RandomAccessFile f9065e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f9066f;

    /* renamed from: g  reason: collision with root package name */
    public long f9067g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9068h;

    public v() {
        super(false);
    }

    public final void close() {
        this.f9066f = null;
        try {
            RandomAccessFile randomAccessFile = this.f9065e;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            this.f9065e = null;
            if (this.f9068h) {
                this.f9068h = false;
                s();
            }
        } catch (IOException e10) {
            throw new u(e10, 2000);
        } catch (Throwable th) {
            this.f9065e = null;
            if (this.f9068h) {
                this.f9068h = false;
                s();
            }
            throw th;
        }
    }

    public final Uri j() {
        return this.f9066f;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f9067g;
        if (j10 == 0) {
            return -1;
        }
        try {
            RandomAccessFile randomAccessFile = this.f9065e;
            int i12 = l0.f8453a;
            int read = randomAccessFile.read(bArr, i10, (int) Math.min(j10, (long) i11));
            if (read > 0) {
                this.f9067g -= (long) read;
                r(read);
            }
            return read;
        } catch (IOException e10) {
            throw new u(e10, 2000);
        }
    }

    public final long q(m mVar) {
        Uri uri = mVar.f9022a;
        long j10 = mVar.f9027f;
        this.f9066f = uri;
        t();
        int i10 = 2006;
        try {
            String path = uri.getPath();
            path.getClass();
            RandomAccessFile randomAccessFile = new RandomAccessFile(path, "r");
            this.f9065e = randomAccessFile;
            try {
                randomAccessFile.seek(j10);
                long j11 = mVar.f9028g;
                if (j11 == -1) {
                    j11 = this.f9065e.length() - j10;
                }
                this.f9067g = j11;
                if (j11 >= 0) {
                    this.f9068h = true;
                    u(mVar);
                    return this.f9067g;
                }
                throw new u(2008, (String) null, (FileNotFoundException) null);
            } catch (IOException e10) {
                throw new u(e10, 2000);
            }
        } catch (FileNotFoundException e11) {
            if (!TextUtils.isEmpty(uri.getQuery()) || !TextUtils.isEmpty(uri.getFragment())) {
                throw new u(1004, String.format("uri has query and/or fragment, which are not supported. Did you call Uri.parse() on a string containing '?' or '#'? Use Uri.fromFile(new File(path)) to avoid this. path=%s,query=%s,fragment=%s", new Object[]{uri.getPath(), uri.getQuery(), uri.getFragment()}), e11);
            }
            if (l0.f8453a < 21 || !t.b(e11.getCause())) {
                i10 = 2005;
            }
            throw new u(e11, i10);
        } catch (SecurityException e12) {
            throw new u(e12, 2006);
        } catch (RuntimeException e13) {
            throw new u(e13, 2000);
        }
    }
}
