package k1;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.content.res.Resources;
import android.net.Uri;
import j1.l0;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;

public final class d0 extends c {

    /* renamed from: e  reason: collision with root package name */
    public final Resources f8977e;

    /* renamed from: f  reason: collision with root package name */
    public final String f8978f;

    /* renamed from: g  reason: collision with root package name */
    public Uri f8979g;

    /* renamed from: h  reason: collision with root package name */
    public AssetFileDescriptor f8980h;

    /* renamed from: i  reason: collision with root package name */
    public FileInputStream f8981i;

    /* renamed from: j  reason: collision with root package name */
    public long f8982j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f8983k;

    public d0(Context context) {
        super(false);
        this.f8977e = context.getResources();
        this.f8978f = context.getPackageName();
    }

    public static Uri buildRawResourceUri(int i10) {
        return Uri.parse("rawresource:///" + i10);
    }

    public final void close() {
        this.f8979g = null;
        try {
            FileInputStream fileInputStream = this.f8981i;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            this.f8981i = null;
            try {
                AssetFileDescriptor assetFileDescriptor = this.f8980h;
                if (assetFileDescriptor != null) {
                    assetFileDescriptor.close();
                }
                this.f8980h = null;
                if (this.f8983k) {
                    this.f8983k = false;
                    s();
                }
            } catch (IOException e10) {
                throw new c0(2000, (String) null, e10);
            } catch (Throwable th) {
                this.f8980h = null;
                if (this.f8983k) {
                    this.f8983k = false;
                    s();
                }
                throw th;
            }
        } catch (IOException e11) {
            throw new c0(2000, (String) null, e11);
        } catch (Throwable th2) {
            this.f8981i = null;
            try {
                AssetFileDescriptor assetFileDescriptor2 = this.f8980h;
                if (assetFileDescriptor2 != null) {
                    assetFileDescriptor2.close();
                }
                this.f8980h = null;
                if (this.f8983k) {
                    this.f8983k = false;
                    s();
                }
                throw th2;
            } catch (IOException e12) {
                throw new c0(2000, (String) null, e12);
            } catch (Throwable th3) {
                this.f8980h = null;
                if (this.f8983k) {
                    this.f8983k = false;
                    s();
                }
                throw th3;
            }
        }
    }

    public final Uri j() {
        return this.f8979g;
    }

    public final int o(byte[] bArr, int i10, int i11) {
        if (i11 == 0) {
            return 0;
        }
        long j10 = this.f8982j;
        if (j10 == 0) {
            return -1;
        }
        if (j10 != -1) {
            try {
                i11 = (int) Math.min(j10, (long) i11);
            } catch (IOException e10) {
                throw new c0(2000, (String) null, e10);
            }
        }
        FileInputStream fileInputStream = this.f8981i;
        int i12 = l0.f8453a;
        int read = fileInputStream.read(bArr, i10, i11);
        if (read != -1) {
            long j11 = this.f8982j;
            if (j11 != -1) {
                this.f8982j = j11 - ((long) read);
            }
            r(read);
            return read;
        } else if (this.f8982j == -1) {
            return -1;
        } else {
            throw new c0(2000, "End of stream reached having not read sufficient data.", new EOFException());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x003f, code lost:
        if (r3.matches("\\d+") != false) goto L_0x0096;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00ac  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long q(k1.m r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            android.net.Uri r2 = r0.f9022a
            r1.f8979g = r2
            java.lang.String r3 = r2.getScheme()
            java.lang.String r4 = "rawresource"
            boolean r3 = android.text.TextUtils.equals(r4, r3)
            r4 = 2005(0x7d5, float:2.81E-42)
            android.content.res.Resources r5 = r1.f8977e
            r6 = 1004(0x3ec, float:1.407E-42)
            r7 = 1
            r8 = 0
            if (r3 != 0) goto L_0x0096
            java.lang.String r3 = r2.getScheme()
            java.lang.String r9 = "android.resource"
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 == 0) goto L_0x0042
            java.util.List r3 = r2.getPathSegments()
            int r3 = r3.size()
            if (r3 != r7) goto L_0x0042
            java.lang.String r3 = r2.getLastPathSegment()
            r3.getClass()
            java.lang.String r10 = "\\d+"
            boolean r3 = r3.matches(r10)
            if (r3 == 0) goto L_0x0042
            goto L_0x0096
        L_0x0042:
            java.lang.String r3 = r2.getScheme()
            boolean r3 = android.text.TextUtils.equals(r9, r3)
            if (r3 == 0) goto L_0x008e
            java.lang.String r3 = r2.getPath()
            r3.getClass()
            java.lang.String r6 = "/"
            boolean r6 = r3.startsWith(r6)
            if (r6 == 0) goto L_0x005f
            java.lang.String r3 = r3.substring(r7)
        L_0x005f:
            java.lang.String r6 = r2.getHost()
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            boolean r10 = android.text.TextUtils.isEmpty(r6)
            if (r10 == 0) goto L_0x0071
            java.lang.String r6 = ""
            goto L_0x0077
        L_0x0071:
            java.lang.String r10 = ":"
            java.lang.String r6 = q0.f.g(r6, r10)
        L_0x0077:
            java.lang.String r3 = android.support.v4.media.h.p(r9, r6, r3)
            java.lang.String r6 = "raw"
            java.lang.String r9 = r1.f8978f
            int r3 = r5.getIdentifier(r3, r6, r9)
            if (r3 == 0) goto L_0x0086
            goto L_0x00a1
        L_0x0086:
            k1.c0 r0 = new k1.c0
            java.lang.String r2 = "Resource not found."
            r0.<init>(r4, r2, r8)
            throw r0
        L_0x008e:
            k1.c0 r0 = new k1.c0
            java.lang.String r2 = "URI must either use scheme rawresource or android.resource"
            r0.<init>(r6, r2, r8)
            throw r0
        L_0x0096:
            java.lang.String r3 = r2.getLastPathSegment()     // Catch:{ NumberFormatException -> 0x016a }
            r3.getClass()     // Catch:{ NumberFormatException -> 0x016a }
            int r3 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x016a }
        L_0x00a1:
            r16.t()
            android.content.res.AssetFileDescriptor r3 = r5.openRawResourceFd(r3)     // Catch:{ NotFoundException -> 0x0162 }
            r1.f8980h = r3
            if (r3 == 0) goto L_0x014c
            long r4 = r3.getLength()
            java.io.FileInputStream r2 = new java.io.FileInputStream
            java.io.FileDescriptor r6 = r3.getFileDescriptor()
            r2.<init>(r6)
            r1.f8981i = r2
            r6 = 2008(0x7d8, float:2.814E-42)
            r9 = -1
            long r11 = r0.f9027f
            int r13 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r13 == 0) goto L_0x00d0
            int r14 = (r11 > r4 ? 1 : (r11 == r4 ? 0 : -1))
            if (r14 > 0) goto L_0x00ca
            goto L_0x00d0
        L_0x00ca:
            k1.c0 r0 = new k1.c0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            r0.<init>(r6, r8, r8)     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            throw r0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
        L_0x00d0:
            long r14 = r3.getStartOffset()     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            long r6 = r14 + r11
            long r6 = r2.skip(r6)     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            long r6 = r6 - r14
            int r14 = (r6 > r11 ? 1 : (r6 == r11 ? 0 : -1))
            if (r14 != 0) goto L_0x0139
            r11 = 0
            if (r13 != 0) goto L_0x010a
            java.nio.channels.FileChannel r2 = r2.getChannel()     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            long r4 = r2.size()     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            int r6 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r6 != 0) goto L_0x00f2
            r1.f8982j = r9     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            goto L_0x0111
        L_0x00f2:
            long r4 = r2.size()     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            long r6 = r2.position()     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            long r4 = r4 - r6
            r1.f8982j = r4     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x0102
            goto L_0x0111
        L_0x0102:
            k1.c0 r0 = new k1.c0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            r2 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r2, r8, r8)     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            throw r0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
        L_0x010a:
            long r4 = r4 - r6
            r1.f8982j = r4     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 < 0) goto L_0x0131
        L_0x0111:
            long r2 = r0.f9028g
            int r4 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r4 == 0) goto L_0x0125
            long r5 = r1.f8982j
            int r7 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x011f
            r5 = r2
            goto L_0x0123
        L_0x011f:
            long r5 = java.lang.Math.min(r5, r2)
        L_0x0123:
            r1.f8982j = r5
        L_0x0125:
            r5 = 1
            r1.f8983k = r5
            r16.u(r17)
            if (r4 == 0) goto L_0x012e
            goto L_0x0130
        L_0x012e:
            long r2 = r1.f8982j
        L_0x0130:
            return r2
        L_0x0131:
            k1.i r0 = new k1.i     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            r2 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r2)     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            throw r0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
        L_0x0139:
            k1.c0 r0 = new k1.c0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            r2 = 2008(0x7d8, float:2.814E-42)
            r0.<init>(r2, r8, r8)     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
            throw r0     // Catch:{ c0 -> 0x014a, IOException -> 0x0141 }
        L_0x0141:
            r0 = move-exception
            k1.c0 r2 = new k1.c0
            r3 = 2000(0x7d0, float:2.803E-42)
            r2.<init>(r3, r8, r0)
            throw r2
        L_0x014a:
            r0 = move-exception
            throw r0
        L_0x014c:
            r0 = 2000(0x7d0, float:2.803E-42)
            k1.c0 r3 = new k1.c0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            java.lang.String r5 = "Resource is compressed: "
            r4.<init>(r5)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r0, r2, r8)
            throw r3
        L_0x0162:
            r0 = move-exception
            r2 = r0
            k1.c0 r0 = new k1.c0
            r0.<init>(r4, r8, r2)
            throw r0
        L_0x016a:
            k1.c0 r0 = new k1.c0
            java.lang.String r2 = "Resource identifier must be an integer."
            r0.<init>(r6, r2, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k1.d0.q(k1.m):long");
    }
}
