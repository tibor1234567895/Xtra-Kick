package k1;

import android.content.ContentResolver;
import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Bundle;
import j1.l0;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.channels.FileChannel;

public final class e extends c {

    /* renamed from: e  reason: collision with root package name */
    public final ContentResolver f8984e;

    /* renamed from: f  reason: collision with root package name */
    public Uri f8985f;

    /* renamed from: g  reason: collision with root package name */
    public AssetFileDescriptor f8986g;

    /* renamed from: h  reason: collision with root package name */
    public FileInputStream f8987h;

    /* renamed from: i  reason: collision with root package name */
    public long f8988i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f8989j;

    public e(Context context) {
        super(false);
        this.f8984e = context.getContentResolver();
    }

    public final void close() {
        this.f8985f = null;
        try {
            FileInputStream fileInputStream = this.f8987h;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f8987h = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f8986g;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f8986g = null;
                if (this.f8989j) {
                    this.f8989j = false;
                    s();
                }
            } catch (IOException e10) {
                throw new d(e10, 2000);
            } catch (Throwable th) {
                this.f8986g = null;
                if (this.f8989j) {
                    this.f8989j = false;
                    s();
                }
                throw th;
            }
        } catch (IOException e11) {
            throw new d(e11, 2000);
        } catch (Throwable th2) {
            this.f8987h = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f8986g;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f8986g = null;
                if (this.f8989j) {
                    this.f8989j = false;
                    s();
                }
                throw th2;
            } catch (IOException e12) {
                throw new d(e12, 2000);
            } catch (Throwable th3) {
                this.f8986g = null;
                if (this.f8989j) {
                    this.f8989j = false;
                    s();
                }
                throw th3;
            }
        }
    }

    public final Uri j() {
        return this.f8985f;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f8988i;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, (long) i11);
            } catch (IOException e10) {
                throw new d(e10, 2000);
            }
        }
        FileInputStream fileInputStream = this.f8987h;
        int i12 = l0.f8453a;
        int read = fileInputStream.read(bArr, i10, i11);
        if (read == -1) {
            return -1;
        }
        long j11 = this.f8988i;
        if (j11 != -1) {
            this.f8988i = j11 - ((long) read);
        }
        r(read);
        return read;
    }

    public final long q(m mVar) {
        AssetFileDescriptor assetFileDescriptor;
        m mVar2 = mVar;
        int i10 = 2000;
        try {
            Uri uri = mVar2.f9022a;
            this.f8985f = uri;
            t();
            boolean equals = "content".equals(mVar2.f9022a.getScheme());
            ContentResolver contentResolver = this.f8984e;
            if (equals) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("android.provider.extra.ACCEPT_ORIGINAL_MEDIA_FORMAT", true);
                assetFileDescriptor = contentResolver.openTypedAssetFileDescriptor(uri, "*/*", bundle);
            } else {
                assetFileDescriptor = contentResolver.openAssetFileDescriptor(uri, "r");
            }
            this.f8986g = assetFileDescriptor;
            if (assetFileDescriptor != null) {
                long length = assetFileDescriptor.getLength();
                FileInputStream fileInputStream = new FileInputStream(assetFileDescriptor.getFileDescriptor());
                this.f8987h = fileInputStream;
                long j10 = mVar2.f9027f;
                int i11 = (length > -1 ? 1 : (length == -1 ? 0 : -1));
                if (i11 == 0 || j10 <= length) {
                    long startOffset = assetFileDescriptor.getStartOffset();
                    long j11 = length;
                    long skip = fileInputStream.skip(startOffset + j10) - startOffset;
                    if (skip == j10) {
                        if (i11 == 0) {
                            FileChannel channel = fileInputStream.getChannel();
                            long size = channel.size();
                            if (size == 0) {
                                this.f8988i = -1;
                            } else {
                                long position = size - channel.position();
                                this.f8988i = position;
                                if (position < 0) {
                                    throw new d((IOException) null, 2008);
                                }
                            }
                        } else {
                            long j12 = j11 - skip;
                            this.f8988i = j12;
                            if (j12 < 0) {
                                throw new d((IOException) null, 2008);
                            }
                        }
                        long j13 = mVar2.f9028g;
                        int i12 = (j13 > -1 ? 1 : (j13 == -1 ? 0 : -1));
                        if (i12 != 0) {
                            long j14 = this.f8988i;
                            this.f8988i = j14 == -1 ? j13 : Math.min(j14, j13);
                        }
                        this.f8989j = true;
                        u(mVar);
                        return i12 != 0 ? j13 : this.f8988i;
                    }
                    throw new d((IOException) null, 2008);
                }
                throw new d((IOException) null, 2008);
            }
            throw new d(new IOException("Could not open file descriptor for: " + uri), 2000);
        } catch (d e10) {
            throw e10;
        } catch (IOException e11) {
            if (e11 instanceof FileNotFoundException) {
                i10 = 2005;
            }
            throw new d(e11, i10);
        }
    }
}
