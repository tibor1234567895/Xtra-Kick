package w5;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.atomic.AtomicReference;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AtomicReference f16106a = new AtomicReference();

    private a() {
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:9|10|11|12|13|14|15) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x002d */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x004f A[SYNTHETIC, Splitter:B:29:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0056 A[SYNTHETIC, Splitter:B:33:0x0056] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.nio.MappedByteBuffer a(java.io.File r9) {
        /*
            r0 = 0
            long r5 = r9.length()     // Catch:{ all -> 0x004b }
            r1 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 > 0) goto L_0x0043
            r1 = 0
            int r3 = (r5 > r1 ? 1 : (r5 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x003b
            java.io.RandomAccessFile r7 = new java.io.RandomAccessFile     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "r"
            r7.<init>(r9, r1)     // Catch:{ all -> 0x004b }
            java.nio.channels.FileChannel r9 = r7.getChannel()     // Catch:{ all -> 0x0033 }
            java.nio.channels.FileChannel$MapMode r2 = java.nio.channels.FileChannel.MapMode.READ_ONLY     // Catch:{ all -> 0x0031 }
            r3 = 0
            r1 = r9
            java.nio.MappedByteBuffer r0 = r1.map(r2, r3, r5)     // Catch:{ all -> 0x0031 }
            java.nio.MappedByteBuffer r0 = r0.load()     // Catch:{ all -> 0x0031 }
            r9.close()     // Catch:{ IOException -> 0x002d }
        L_0x002d:
            r7.close()     // Catch:{ IOException -> 0x0030 }
        L_0x0030:
            return r0
        L_0x0031:
            r0 = move-exception
            goto L_0x0037
        L_0x0033:
            r9 = move-exception
            r8 = r0
            r0 = r9
            r9 = r8
        L_0x0037:
            r8 = r0
            r0 = r9
            r9 = r8
            goto L_0x004d
        L_0x003b:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "File unsuitable for memory mapping"
            r9.<init>(r1)     // Catch:{ all -> 0x004b }
            throw r9     // Catch:{ all -> 0x004b }
        L_0x0043:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ all -> 0x004b }
            java.lang.String r1 = "File too large to map into memory"
            r9.<init>(r1)     // Catch:{ all -> 0x004b }
            throw r9     // Catch:{ all -> 0x004b }
        L_0x004b:
            r9 = move-exception
            r7 = r0
        L_0x004d:
            if (r0 == 0) goto L_0x0054
            r0.close()     // Catch:{ IOException -> 0x0053 }
            goto L_0x0054
        L_0x0053:
        L_0x0054:
            if (r7 == 0) goto L_0x0059
            r7.close()     // Catch:{ IOException -> 0x0059 }
        L_0x0059:
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.a.a(java.io.File):java.nio.MappedByteBuffer");
    }

    public static ByteBuffer b(InputStream inputStream) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(16384);
        AtomicReference atomicReference = f16106a;
        byte[] bArr = (byte[]) atomicReference.getAndSet((Object) null);
        if (bArr == null) {
            bArr = new byte[16384];
        }
        while (true) {
            int read = inputStream.read(bArr);
            if (read >= 0) {
                byteArrayOutputStream.write(bArr, 0, read);
            } else {
                atomicReference.set(bArr);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                return c(ByteBuffer.allocateDirect(byteArray.length).put(byteArray));
            }
        }
    }

    public static ByteBuffer c(ByteBuffer byteBuffer) {
        return (ByteBuffer) byteBuffer.position(0);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:1|2|3|4|5|6|7|8|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x002c A[SYNTHETIC, Splitter:B:14:0x002c] */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0033 A[SYNTHETIC, Splitter:B:18:0x0033] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void d(java.nio.ByteBuffer r4, java.io.File r5) {
        /*
            r0 = 0
            java.nio.Buffer r1 = r4.position(r0)
            java.nio.ByteBuffer r1 = (java.nio.ByteBuffer) r1
            r1 = 0
            java.io.RandomAccessFile r2 = new java.io.RandomAccessFile     // Catch:{ all -> 0x0028 }
            java.lang.String r3 = "rw"
            r2.<init>(r5, r3)     // Catch:{ all -> 0x0028 }
            java.nio.channels.FileChannel r1 = r2.getChannel()     // Catch:{ all -> 0x0026 }
            r1.write(r4)     // Catch:{ all -> 0x0026 }
            r1.force(r0)     // Catch:{ all -> 0x0026 }
            r1.close()     // Catch:{ all -> 0x0026 }
            r2.close()     // Catch:{ all -> 0x0026 }
            r1.close()     // Catch:{ IOException -> 0x0022 }
        L_0x0022:
            r2.close()     // Catch:{ IOException -> 0x0025 }
        L_0x0025:
            return
        L_0x0026:
            r4 = move-exception
            goto L_0x002a
        L_0x0028:
            r4 = move-exception
            r2 = r1
        L_0x002a:
            if (r1 == 0) goto L_0x0031
            r1.close()     // Catch:{ IOException -> 0x0030 }
            goto L_0x0031
        L_0x0030:
        L_0x0031:
            if (r2 == 0) goto L_0x0036
            r2.close()     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: w5.a.d(java.nio.ByteBuffer, java.io.File):void");
    }
}
