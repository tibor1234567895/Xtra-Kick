package k5;

import android.util.Log;
import androidx.emoji2.text.b0;
import b5.f;
import com.bumptech.glide.integration.webp.d;
import com.bumptech.glide.load.ImageHeaderParser$ImageType;
import e5.k;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import w5.n;

public final class m implements f {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f9166a = "Exif\u0000\u0000".getBytes(Charset.forName("UTF-8"));

    /* renamed from: b  reason: collision with root package name */
    public static final int[] f9167b = {0, 1, 1, 2, 4, 8, 1, 1, 2, 4, 8, 4, 8};

    public static int e(l lVar, k kVar) {
        boolean z10;
        int i10;
        byte[] bArr;
        try {
            int b10 = lVar.b();
            if ((b10 & 65496) == 65496 || b10 == 19789 || b10 == 18761) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            while (true) {
                if (lVar.d() == 255) {
                    short d10 = lVar.d();
                    if (d10 != 218) {
                        if (d10 != 217) {
                            i10 = lVar.b() - 2;
                            if (d10 == 225) {
                                break;
                            }
                            long j10 = (long) i10;
                            if (lVar.a(j10) != j10) {
                                break;
                            }
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }
                } else {
                    break;
                }
            }
            Log.isLoggable("DfltImageHeaderParser", 3);
            i10 = -1;
            if (i10 == -1) {
                Log.isLoggable("DfltImageHeaderParser", 3);
                return -1;
            }
            bArr = (byte[]) kVar.d(i10, byte[].class);
            int g10 = g(lVar, bArr, i10);
            kVar.h(bArr);
            return g10;
        } catch (k unused) {
            return -1;
        } catch (Throwable th) {
            kVar.h(bArr);
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x003b, code lost:
        return com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0039 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.bumptech.glide.load.ImageHeaderParser$ImageType f(k5.l r8) {
        /*
            int r0 = r8.b()     // Catch:{ k -> 0x00fe }
            r1 = 65496(0xffd8, float:9.178E-41)
            if (r0 != r1) goto L_0x000c
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.JPEG     // Catch:{ k -> 0x00fe }
            return r8
        L_0x000c:
            int r0 = r0 << 8
            short r1 = r8.d()     // Catch:{ k -> 0x00fe }
            r0 = r0 | r1
            r1 = 4671814(0x474946, float:6.546606E-39)
            if (r0 != r1) goto L_0x001b
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.GIF     // Catch:{ k -> 0x00fe }
            return r8
        L_0x001b:
            int r0 = r0 << 8
            short r1 = r8.d()     // Catch:{ k -> 0x00fe }
            r0 = r0 | r1
            r1 = -1991225785(0xffffffff89504e47, float:-2.5073895E-33)
            if (r0 != r1) goto L_0x003c
            r0 = 21
            r8.a(r0)     // Catch:{ k -> 0x00fe }
            short r8 = r8.d()     // Catch:{ k -> 0x0039 }
            r0 = 3
            if (r8 < r0) goto L_0x0036
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG_A     // Catch:{ k -> 0x0039 }
            goto L_0x0038
        L_0x0036:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG     // Catch:{ k -> 0x0039 }
        L_0x0038:
            return r8
        L_0x0039:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.PNG     // Catch:{ k -> 0x00fe }
            return r8
        L_0x003c:
            r1 = 1380533830(0x52494646, float:2.16116855E11)
            r2 = 4
            if (r0 == r1) goto L_0x009d
            int r1 = r8.b()     // Catch:{ k -> 0x00fe }
            int r1 = r1 << 16
            int r4 = r8.b()     // Catch:{ k -> 0x00fe }
            r1 = r1 | r4
            r4 = 1718909296(0x66747970, float:2.8862439E23)
            if (r1 == r4) goto L_0x0054
            goto L_0x009a
        L_0x0054:
            int r1 = r8.b()     // Catch:{ k -> 0x00fe }
            int r1 = r1 << 16
            int r4 = r8.b()     // Catch:{ k -> 0x00fe }
            r1 = r1 | r4
            r4 = 1635150195(0x61766973, float:2.8409359E20)
            if (r1 != r4) goto L_0x0065
            goto L_0x008a
        L_0x0065:
            r5 = 0
            r6 = 1
            r7 = 1635150182(0x61766966, float:2.8409336E20)
            if (r1 != r7) goto L_0x006e
            r1 = 1
            goto L_0x006f
        L_0x006e:
            r1 = 0
        L_0x006f:
            r8.a(r2)     // Catch:{ k -> 0x00fe }
            int r0 = r0 + -16
            int r2 = r0 % 4
            if (r2 != 0) goto L_0x0095
        L_0x0078:
            r2 = 5
            if (r5 >= r2) goto L_0x0095
            if (r0 <= 0) goto L_0x0095
            int r2 = r8.b()     // Catch:{ k -> 0x00fe }
            int r2 = r2 << 16
            int r3 = r8.b()     // Catch:{ k -> 0x00fe }
            r2 = r2 | r3
            if (r2 != r4) goto L_0x008d
        L_0x008a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.ANIMATED_AVIF     // Catch:{ k -> 0x00fe }
            goto L_0x009c
        L_0x008d:
            if (r2 != r7) goto L_0x0090
            r1 = 1
        L_0x0090:
            int r5 = r5 + 1
            int r0 = r0 + -4
            goto L_0x0078
        L_0x0095:
            if (r1 == 0) goto L_0x009a
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.AVIF     // Catch:{ k -> 0x00fe }
            goto L_0x009c
        L_0x009a:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN     // Catch:{ k -> 0x00fe }
        L_0x009c:
            return r8
        L_0x009d:
            r8.a(r2)     // Catch:{ k -> 0x00fe }
            int r0 = r8.b()     // Catch:{ k -> 0x00fe }
            int r0 = r0 << 16
            int r1 = r8.b()     // Catch:{ k -> 0x00fe }
            r0 = r0 | r1
            r1 = 1464156752(0x57454250, float:2.16888601E14)
            if (r0 == r1) goto L_0x00b3
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00b3:
            int r0 = r8.b()     // Catch:{ k -> 0x00fe }
            int r0 = r0 << 16
            int r1 = r8.b()     // Catch:{ k -> 0x00fe }
            r0 = r0 | r1
            r1 = r0 & -256(0xffffffffffffff00, float:NaN)
            r4 = 1448097792(0x56503800, float:5.7234734E13)
            if (r1 == r4) goto L_0x00c8
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00c8:
            r0 = r0 & 255(0xff, float:3.57E-43)
            r1 = 88
            if (r0 != r1) goto L_0x00e6
            r8.a(r2)     // Catch:{ k -> 0x00fe }
            short r8 = r8.d()     // Catch:{ k -> 0x00fe }
            r0 = r8 & 2
            if (r0 == 0) goto L_0x00dc
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.ANIMATED_WEBP     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00dc:
            r8 = r8 & 16
            if (r8 == 0) goto L_0x00e3
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP_A     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00e3:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00e6:
            r1 = 76
            if (r0 != r1) goto L_0x00fb
            r8.a(r2)     // Catch:{ k -> 0x00fe }
            short r8 = r8.d()     // Catch:{ k -> 0x00fe }
            r8 = r8 & 8
            if (r8 == 0) goto L_0x00f8
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP_A     // Catch:{ k -> 0x00fe }
            goto L_0x00fa
        L_0x00f8:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP     // Catch:{ k -> 0x00fe }
        L_0x00fa:
            return r8
        L_0x00fb:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.WEBP     // Catch:{ k -> 0x00fe }
            return r8
        L_0x00fe:
            com.bumptech.glide.load.ImageHeaderParser$ImageType r8 = com.bumptech.glide.load.ImageHeaderParser$ImageType.UNKNOWN
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: k5.m.f(k5.l):com.bumptech.glide.load.ImageHeaderParser$ImageType");
    }

    public static int g(l lVar, byte[] bArr, int i10) {
        boolean z10;
        ByteOrder byteOrder;
        boolean z11;
        int i11;
        boolean z12;
        int i12;
        int i13;
        if (lVar.f(i10, bArr) != i10) {
            Log.isLoggable("DfltImageHeaderParser", 3);
            return -1;
        }
        byte[] bArr2 = f9166a;
        if (bArr == null || i10 <= bArr2.length) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            int i14 = 0;
            while (true) {
                if (i14 >= bArr2.length) {
                    break;
                } else if (bArr[i14] != bArr2[i14]) {
                    z10 = false;
                    break;
                } else {
                    i14++;
                }
            }
        }
        if (z10) {
            b0 b0Var = new b0(i10, bArr);
            short h10 = b0Var.h(6);
            if (h10 != 18761) {
                if (h10 != 19789) {
                    Log.isLoggable("DfltImageHeaderParser", 3);
                }
                byteOrder = ByteOrder.BIG_ENDIAN;
            } else {
                byteOrder = ByteOrder.LITTLE_ENDIAN;
            }
            ByteBuffer byteBuffer = b0Var.f1246b;
            byteBuffer.order(byteOrder);
            if (byteBuffer.remaining() - 10 >= 4) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                i11 = byteBuffer.getInt(10);
            } else {
                i11 = -1;
            }
            int i15 = i11 + 6;
            short h11 = b0Var.h(i15);
            for (int i16 = 0; i16 < h11; i16++) {
                int i17 = (i16 * 12) + i15 + 2;
                if (b0Var.h(i17) == 274) {
                    short h12 = b0Var.h(i17 + 2);
                    if (h12 >= 1 && h12 <= 12) {
                        int i18 = i17 + 4;
                        if (byteBuffer.remaining() - i18 >= 4) {
                            z12 = true;
                        } else {
                            z12 = false;
                        }
                        if (z12) {
                            i12 = byteBuffer.getInt(i18);
                        } else {
                            i12 = -1;
                        }
                        if (i12 >= 0) {
                            Log.isLoggable("DfltImageHeaderParser", 3);
                            int i19 = i12 + f9167b[h12];
                            if (i19 <= 4 && (i13 = i17 + 8) >= 0 && i13 <= byteBuffer.remaining() && i19 >= 0 && i19 + i13 <= byteBuffer.remaining()) {
                                return b0Var.h(i13);
                            }
                        }
                    }
                    Log.isLoggable("DfltImageHeaderParser", 3);
                }
            }
            return -1;
        }
        Log.isLoggable("DfltImageHeaderParser", 3);
        return -1;
    }

    public final ImageHeaderParser$ImageType a(ByteBuffer byteBuffer) {
        n.b(byteBuffer);
        return f(new b0(3, byteBuffer));
    }

    public final int b(InputStream inputStream, k kVar) {
        n.b(inputStream);
        d dVar = new d(inputStream, 2);
        n.b(kVar);
        return e(dVar, kVar);
    }

    public final ImageHeaderParser$ImageType c(InputStream inputStream) {
        n.b(inputStream);
        return f(new d(inputStream, 2));
    }

    public final int d(ByteBuffer byteBuffer, k kVar) {
        n.b(byteBuffer);
        b0 b0Var = new b0(3, byteBuffer);
        n.b(kVar);
        return e(b0Var, kVar);
    }
}
