package k5;

import e5.k;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import p1.d;

public final class e0 extends FilterInputStream {

    /* renamed from: h  reason: collision with root package name */
    public volatile byte[] f9146h;

    /* renamed from: i  reason: collision with root package name */
    public int f9147i;

    /* renamed from: j  reason: collision with root package name */
    public int f9148j;

    /* renamed from: k  reason: collision with root package name */
    public int f9149k = -1;

    /* renamed from: l  reason: collision with root package name */
    public int f9150l;

    /* renamed from: m  reason: collision with root package name */
    public final k f9151m;

    public e0(InputStream inputStream, k kVar) {
        super(inputStream);
        this.f9151m = kVar;
        this.f9146h = (byte[]) kVar.d(65536, byte[].class);
    }

    public static void k() {
        throw new IOException("BufferedInputStream is closed");
    }

    public final synchronized int available() {
        InputStream inputStream;
        inputStream = this.in;
        if (this.f9146h == null || inputStream == null) {
            k();
            throw null;
        }
        return (this.f9147i - this.f9150l) + inputStream.available();
    }

    public final int c(InputStream inputStream, byte[] bArr) {
        int i10;
        int i11 = this.f9149k;
        if (i11 == -1 || this.f9150l - i11 >= (i10 = this.f9148j)) {
            int read = inputStream.read(bArr);
            if (read > 0) {
                this.f9149k = -1;
                this.f9150l = 0;
                this.f9147i = read;
            }
            return read;
        }
        if (i11 == 0 && i10 > bArr.length && this.f9147i == bArr.length) {
            int length = bArr.length * 2;
            if (length <= i10) {
                i10 = length;
            }
            byte[] bArr2 = (byte[]) this.f9151m.d(i10, byte[].class);
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f9146h = bArr2;
            this.f9151m.h(bArr);
            bArr = bArr2;
        } else if (i11 > 0) {
            System.arraycopy(bArr, i11, bArr, 0, bArr.length - i11);
        }
        int i12 = this.f9150l - this.f9149k;
        this.f9150l = i12;
        this.f9149k = 0;
        this.f9147i = 0;
        int read2 = inputStream.read(bArr, i12, bArr.length - i12);
        int i13 = this.f9150l;
        if (read2 > 0) {
            i13 += read2;
        }
        this.f9147i = i13;
        return read2;
    }

    public final void close() {
        if (this.f9146h != null) {
            this.f9151m.h(this.f9146h);
            this.f9146h = null;
        }
        InputStream inputStream = this.in;
        this.in = null;
        if (inputStream != null) {
            inputStream.close();
        }
    }

    public final synchronized void e() {
        if (this.f9146h != null) {
            this.f9151m.h(this.f9146h);
            this.f9146h = null;
        }
    }

    public final synchronized void mark(int i10) {
        this.f9148j = Math.max(this.f9148j, i10);
        this.f9149k = this.f9150l;
    }

    public final boolean markSupported() {
        return true;
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:11:0x0019=Splitter:B:11:0x0019, B:27:0x0039=Splitter:B:27:0x0039} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read() {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f9146h     // Catch:{ all -> 0x003d }
            java.io.InputStream r1 = r6.in     // Catch:{ all -> 0x003d }
            r2 = 0
            if (r0 == 0) goto L_0x0039
            if (r1 == 0) goto L_0x0039
            int r3 = r6.f9150l     // Catch:{ all -> 0x003d }
            int r4 = r6.f9147i     // Catch:{ all -> 0x003d }
            r5 = -1
            if (r3 < r4) goto L_0x0019
            int r1 = r6.c(r1, r0)     // Catch:{ all -> 0x003d }
            if (r1 != r5) goto L_0x0019
            monitor-exit(r6)
            return r5
        L_0x0019:
            byte[] r1 = r6.f9146h     // Catch:{ all -> 0x003d }
            if (r0 == r1) goto L_0x0026
            byte[] r0 = r6.f9146h     // Catch:{ all -> 0x003d }
            if (r0 == 0) goto L_0x0022
            goto L_0x0026
        L_0x0022:
            k()     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x0026:
            int r1 = r6.f9147i     // Catch:{ all -> 0x003d }
            int r2 = r6.f9150l     // Catch:{ all -> 0x003d }
            int r1 = r1 - r2
            if (r1 <= 0) goto L_0x0037
            int r1 = r2 + 1
            r6.f9150l = r1     // Catch:{ all -> 0x003d }
            byte r0 = r0[r2]     // Catch:{ all -> 0x003d }
            r0 = r0 & 255(0xff, float:3.57E-43)
            monitor-exit(r6)
            return r0
        L_0x0037:
            monitor-exit(r6)
            return r5
        L_0x0039:
            k()     // Catch:{ all -> 0x003d }
            throw r2     // Catch:{ all -> 0x003d }
        L_0x003d:
            r0 = move-exception
            monitor-exit(r6)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.e0.read():int");
    }

    public final synchronized void reset() {
        if (this.f9146h != null) {
            int i10 = this.f9149k;
            if (-1 != i10) {
                this.f9150l = i10;
            } else {
                throw new d("Mark has been invalidated, pos: " + this.f9150l + " markLimit: " + this.f9148j, 2);
            }
        } else {
            throw new IOException("Stream is closed");
        }
    }

    public final synchronized long skip(long j10) {
        if (j10 < 1) {
            return 0;
        }
        byte[] bArr = this.f9146h;
        if (bArr != null) {
            InputStream inputStream = this.in;
            if (inputStream != null) {
                int i10 = this.f9147i;
                int i11 = this.f9150l;
                if (((long) (i10 - i11)) >= j10) {
                    this.f9150l = (int) (((long) i11) + j10);
                    return j10;
                }
                long j11 = ((long) i10) - ((long) i11);
                this.f9150l = i10;
                if (this.f9149k == -1 || j10 > ((long) this.f9148j)) {
                    long skip = inputStream.skip(j10 - j11);
                    if (skip > 0) {
                        this.f9149k = -1;
                    }
                    return j11 + skip;
                } else if (c(inputStream, bArr) == -1) {
                    return j11;
                } else {
                    int i12 = this.f9147i;
                    int i13 = this.f9150l;
                    if (((long) (i12 - i13)) >= j10 - j11) {
                        this.f9150l = (int) ((((long) i13) + j10) - j11);
                        return j10;
                    }
                    long j12 = (j11 + ((long) i12)) - ((long) i13);
                    this.f9150l = i12;
                    return j12;
                }
            } else {
                k();
                throw null;
            }
        } else {
            k();
            throw null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002f, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0045, code lost:
        return r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0052, code lost:
        return r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized int read(byte[] r7, int r8, int r9) {
        /*
            r6 = this;
            monitor-enter(r6)
            byte[] r0 = r6.f9146h     // Catch:{ all -> 0x0088 }
            r1 = 0
            if (r0 == 0) goto L_0x0084
            if (r9 != 0) goto L_0x000b
            monitor-exit(r6)
            r7 = 0
            return r7
        L_0x000b:
            java.io.InputStream r2 = r6.in     // Catch:{ all -> 0x0088 }
            if (r2 == 0) goto L_0x0080
            int r3 = r6.f9150l     // Catch:{ all -> 0x0088 }
            int r4 = r6.f9147i     // Catch:{ all -> 0x0088 }
            if (r3 >= r4) goto L_0x0030
            int r4 = r4 - r3
            if (r4 < r9) goto L_0x0019
            r4 = r9
        L_0x0019:
            java.lang.System.arraycopy(r0, r3, r7, r8, r4)     // Catch:{ all -> 0x0088 }
            int r3 = r6.f9150l     // Catch:{ all -> 0x0088 }
            int r3 = r3 + r4
            r6.f9150l = r3     // Catch:{ all -> 0x0088 }
            if (r4 == r9) goto L_0x002e
            int r3 = r2.available()     // Catch:{ all -> 0x0088 }
            if (r3 != 0) goto L_0x002a
            goto L_0x002e
        L_0x002a:
            int r8 = r8 + r4
            int r3 = r9 - r4
            goto L_0x0031
        L_0x002e:
            monitor-exit(r6)
            return r4
        L_0x0030:
            r3 = r9
        L_0x0031:
            int r4 = r6.f9149k     // Catch:{ all -> 0x0088 }
            r5 = -1
            if (r4 != r5) goto L_0x0046
            int r4 = r0.length     // Catch:{ all -> 0x0088 }
            if (r3 < r4) goto L_0x0046
            int r4 = r2.read(r7, r8, r3)     // Catch:{ all -> 0x0088 }
            if (r4 != r5) goto L_0x0070
            if (r3 != r9) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            int r5 = r9 - r3
        L_0x0044:
            monitor-exit(r6)
            return r5
        L_0x0046:
            int r4 = r6.c(r2, r0)     // Catch:{ all -> 0x0088 }
            if (r4 != r5) goto L_0x0053
            if (r3 != r9) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            int r5 = r9 - r3
        L_0x0051:
            monitor-exit(r6)
            return r5
        L_0x0053:
            byte[] r4 = r6.f9146h     // Catch:{ all -> 0x0088 }
            if (r0 == r4) goto L_0x0060
            byte[] r0 = r6.f9146h     // Catch:{ all -> 0x0088 }
            if (r0 == 0) goto L_0x005c
            goto L_0x0060
        L_0x005c:
            k()     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x0060:
            int r4 = r6.f9147i     // Catch:{ all -> 0x0088 }
            int r5 = r6.f9150l     // Catch:{ all -> 0x0088 }
            int r4 = r4 - r5
            if (r4 < r3) goto L_0x0068
            r4 = r3
        L_0x0068:
            java.lang.System.arraycopy(r0, r5, r7, r8, r4)     // Catch:{ all -> 0x0088 }
            int r5 = r6.f9150l     // Catch:{ all -> 0x0088 }
            int r5 = r5 + r4
            r6.f9150l = r5     // Catch:{ all -> 0x0088 }
        L_0x0070:
            int r3 = r3 - r4
            if (r3 != 0) goto L_0x0075
            monitor-exit(r6)
            return r9
        L_0x0075:
            int r5 = r2.available()     // Catch:{ all -> 0x0088 }
            if (r5 != 0) goto L_0x007e
            int r9 = r9 - r3
            monitor-exit(r6)
            return r9
        L_0x007e:
            int r8 = r8 + r4
            goto L_0x0031
        L_0x0080:
            k()     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x0084:
            k()     // Catch:{ all -> 0x0088 }
            throw r1     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.e0.read(byte[], int, int):int");
    }
}
