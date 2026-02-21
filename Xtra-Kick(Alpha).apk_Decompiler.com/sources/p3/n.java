package p3;

import android.support.v4.media.h;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Map;
import java.util.TreeMap;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    public static final byte[] f12549a = {112, 114, 111, 0};

    /* renamed from: b  reason: collision with root package name */
    public static final byte[] f12550b = {112, 114, 109, 0};

    private n() {
    }

    public static byte[] a(c[] cVarArr, byte[] bArr) {
        int i10 = 0;
        int i11 = 0;
        for (c cVar : cVarArr) {
            i11 += (((((cVar.f12541g * 2) + 8) - 1) & -8) / 8) + (cVar.f12539e * 2) + b(bArr, cVar.f12535a, cVar.f12536b).getBytes(StandardCharsets.UTF_8).length + 16 + cVar.f12540f;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(i11);
        if (Arrays.equals(bArr, r.f12560c)) {
            int length = cVarArr.length;
            while (i10 < length) {
                c cVar2 = cVarArr[i10];
                l(byteArrayOutputStream, cVar2, b(bArr, cVar2.f12535a, cVar2.f12536b));
                n(byteArrayOutputStream, cVar2);
                k(byteArrayOutputStream, cVar2);
                m(byteArrayOutputStream, cVar2);
                i10++;
            }
        } else {
            for (c cVar3 : cVarArr) {
                l(byteArrayOutputStream, cVar3, b(bArr, cVar3.f12535a, cVar3.f12536b));
            }
            int length2 = cVarArr.length;
            while (i10 < length2) {
                c cVar4 = cVarArr[i10];
                n(byteArrayOutputStream, cVar4);
                k(byteArrayOutputStream, cVar4);
                m(byteArrayOutputStream, cVar4);
                i10++;
            }
        }
        if (byteArrayOutputStream.size() == i11) {
            return byteArrayOutputStream.toByteArray();
        }
        throw new IllegalStateException("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + i11);
    }

    public static String b(byte[] bArr, String str, String str2) {
        byte[] bArr2 = r.f12562e;
        boolean equals = Arrays.equals(bArr, bArr2);
        byte[] bArr3 = r.f12561d;
        String str3 = "!";
        String str4 = (!equals && !Arrays.equals(bArr, bArr3)) ? str3 : Constants.EXT_TAG_END;
        if (str.length() <= 0) {
            if (str3.equals(str4)) {
                return str2.replace(Constants.EXT_TAG_END, str3);
            }
            if (Constants.EXT_TAG_END.equals(str4)) {
                str2 = str2.replace(str3, Constants.EXT_TAG_END);
            }
            return str2;
        } else if (str2.equals("classes.dex")) {
            return str;
        } else {
            if (str2.contains(str3) || str2.contains(Constants.EXT_TAG_END)) {
                if (str3.equals(str4)) {
                    return str2.replace(Constants.EXT_TAG_END, str3);
                }
                if (Constants.EXT_TAG_END.equals(str4)) {
                    str2 = str2.replace(str3, Constants.EXT_TAG_END);
                }
                return str2;
            } else if (str2.endsWith(".apk")) {
                return str2;
            } else {
                StringBuilder q10 = h.q(str);
                if (Arrays.equals(bArr, bArr2) || Arrays.equals(bArr, bArr3)) {
                    str3 = Constants.EXT_TAG_END;
                }
                return h.p(q10, str3, str2);
            }
        }
    }

    public static int c(int i10, int i11, int i12) {
        if (i10 == 1) {
            throw new IllegalStateException("HOT methods are not stored in the bitmap");
        } else if (i10 == 2) {
            return i11;
        } else {
            if (i10 == 4) {
                return i11 + i12;
            }
            throw new IllegalStateException(h.i("Unexpected flag: ", i10));
        }
    }

    public static int[] d(ByteArrayInputStream byteArrayInputStream, int i10) {
        int[] iArr = new int[i10];
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            i11 += d.e(byteArrayInputStream);
            iArr[i12] = i11;
        }
        return iArr;
    }

    public static c[] e(FileInputStream fileInputStream, byte[] bArr, byte[] bArr2, c[] cVarArr) {
        byte[] bArr3 = r.f12563f;
        if (Arrays.equals(bArr, bArr3)) {
            if (Arrays.equals(r.f12558a, bArr2)) {
                throw new IllegalStateException("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            } else if (Arrays.equals(bArr, bArr3)) {
                int d10 = (int) d.d(fileInputStream, 1);
                byte[] c10 = d.c(fileInputStream, (int) d.d(fileInputStream, 4), (int) d.d(fileInputStream, 4));
                if (fileInputStream.read() <= 0) {
                    ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(c10);
                    try {
                        c[] f10 = f(byteArrayInputStream, d10, cVarArr);
                        byteArrayInputStream.close();
                        return f10;
                    } catch (Throwable th) {
                        th.addSuppressed(th);
                    }
                } else {
                    throw new IllegalStateException("Content found after the end of file");
                }
            } else {
                throw new IllegalStateException("Unsupported meta version");
            }
        } else if (Arrays.equals(bArr, r.f12564g)) {
            int e10 = d.e(fileInputStream);
            byte[] c11 = d.c(fileInputStream, (int) d.d(fileInputStream, 4), (int) d.d(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream2 = new ByteArrayInputStream(c11);
                try {
                    c[] g10 = g(byteArrayInputStream2, bArr2, e10, cVarArr);
                    byteArrayInputStream2.close();
                    return g10;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported meta version");
        }
        throw th;
        throw th;
    }

    public static c[] f(ByteArrayInputStream byteArrayInputStream, int i10, c[] cVarArr) {
        int i11 = 0;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i10 == cVarArr.length) {
            String[] strArr = new String[i10];
            int[] iArr = new int[i10];
            for (int i12 = 0; i12 < i10; i12++) {
                int e10 = d.e(byteArrayInputStream);
                iArr[i12] = d.e(byteArrayInputStream);
                strArr[i12] = new String(d.b(byteArrayInputStream, e10), StandardCharsets.UTF_8);
            }
            while (i11 < i10) {
                c cVar = cVarArr[i11];
                if (cVar.f12536b.equals(strArr[i11])) {
                    int i13 = iArr[i11];
                    cVar.f12539e = i13;
                    cVar.f12542h = d(byteArrayInputStream, i13);
                    i11++;
                } else {
                    throw new IllegalStateException("Order of dexfiles in metadata did not match baseline");
                }
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static c[] g(ByteArrayInputStream byteArrayInputStream, byte[] bArr, int i10, c[] cVarArr) {
        c cVar;
        String str;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        if (i10 == cVarArr.length) {
            int i11 = 0;
            while (i11 < i10) {
                d.e(byteArrayInputStream);
                String str2 = new String(d.b(byteArrayInputStream, d.e(byteArrayInputStream)), StandardCharsets.UTF_8);
                long d10 = d.d(byteArrayInputStream, 4);
                int e10 = d.e(byteArrayInputStream);
                if (cVarArr.length > 0) {
                    int indexOf = str2.indexOf("!");
                    if (indexOf < 0) {
                        indexOf = str2.indexOf(Constants.EXT_TAG_END);
                    }
                    if (indexOf > 0) {
                        str = str2.substring(indexOf + 1);
                    } else {
                        str = str2;
                    }
                    int i12 = 0;
                    while (true) {
                        if (i12 >= cVarArr.length) {
                            break;
                        } else if (cVarArr[i12].f12536b.equals(str)) {
                            cVar = cVarArr[i12];
                            break;
                        } else {
                            i12++;
                        }
                    }
                }
                cVar = null;
                if (cVar != null) {
                    cVar.f12538d = d10;
                    int[] d11 = d(byteArrayInputStream, e10);
                    if (Arrays.equals(bArr, r.f12562e)) {
                        cVar.f12539e = e10;
                        cVar.f12542h = d11;
                    }
                    i11++;
                } else {
                    throw new IllegalStateException("Missing profile key: ".concat(str2));
                }
            }
            return cVarArr;
        }
        throw new IllegalStateException("Mismatched number of dex files found in metadata");
    }

    public static c[] h(FileInputStream fileInputStream, byte[] bArr, String str) {
        if (Arrays.equals(bArr, r.f12559b)) {
            int d10 = (int) d.d(fileInputStream, 1);
            byte[] c10 = d.c(fileInputStream, (int) d.d(fileInputStream, 4), (int) d.d(fileInputStream, 4));
            if (fileInputStream.read() <= 0) {
                ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(c10);
                try {
                    c[] i10 = i(byteArrayInputStream, str, d10);
                    byteArrayInputStream.close();
                    return i10;
                } catch (Throwable th) {
                    th.addSuppressed(th);
                }
            } else {
                throw new IllegalStateException("Content found after the end of file");
            }
        } else {
            throw new IllegalStateException("Unsupported version");
        }
        throw th;
    }

    public static c[] i(ByteArrayInputStream byteArrayInputStream, String str, int i10) {
        TreeMap treeMap;
        ByteArrayInputStream byteArrayInputStream2 = byteArrayInputStream;
        int i11 = i10;
        if (byteArrayInputStream.available() == 0) {
            return new c[0];
        }
        c[] cVarArr = new c[i11];
        for (int i12 = 0; i12 < i11; i12++) {
            int e10 = d.e(byteArrayInputStream);
            int e11 = d.e(byteArrayInputStream);
            long d10 = d.d(byteArrayInputStream2, 4);
            String str2 = str;
            cVarArr[i12] = new c(str2, new String(d.b(byteArrayInputStream2, e10), StandardCharsets.UTF_8), d.d(byteArrayInputStream2, 4), e11, (int) d10, (int) d.d(byteArrayInputStream2, 4), new int[e11], new TreeMap());
        }
        int i13 = 0;
        while (i13 < i11) {
            c cVar = cVarArr[i13];
            int available = byteArrayInputStream.available() - cVar.f12540f;
            int i14 = 0;
            while (true) {
                int available2 = byteArrayInputStream.available();
                treeMap = cVar.f12543i;
                if (available2 <= available) {
                    break;
                }
                i14 += d.e(byteArrayInputStream);
                treeMap.put(Integer.valueOf(i14), 1);
                for (int e12 = d.e(byteArrayInputStream); e12 > 0; e12--) {
                    d.e(byteArrayInputStream);
                    int d11 = (int) d.d(byteArrayInputStream2, 1);
                    if (!(d11 == 6 || d11 == 7)) {
                        while (d11 > 0) {
                            d.d(byteArrayInputStream2, 1);
                            for (int d12 = (int) d.d(byteArrayInputStream2, 1); d12 > 0; d12--) {
                                d.e(byteArrayInputStream);
                            }
                            d11--;
                        }
                    }
                }
            }
            if (byteArrayInputStream.available() == available) {
                cVar.f12542h = d(byteArrayInputStream2, cVar.f12539e);
                int i15 = cVar.f12541g;
                BitSet valueOf = BitSet.valueOf(d.b(byteArrayInputStream2, ((((i15 * 2) + 8) - 1) & -8) / 8));
                for (int i16 = 0; i16 < i15; i16++) {
                    int i17 = 2;
                    if (!valueOf.get(c(2, i16, i15))) {
                        i17 = 0;
                    }
                    if (valueOf.get(c(4, i16, i15))) {
                        i17 |= 4;
                    }
                    if (i17 != 0) {
                        Integer num = (Integer) treeMap.get(Integer.valueOf(i16));
                        if (num == null) {
                            num = 0;
                        }
                        treeMap.put(Integer.valueOf(i16), Integer.valueOf(i17 | num.intValue()));
                    }
                }
                i13++;
            } else {
                throw new IllegalStateException("Read too much data during profile line parse");
            }
        }
        return cVarArr;
    }

    /* JADX INFO: finally extract failed */
    public static boolean j(ByteArrayOutputStream byteArrayOutputStream, byte[] bArr, c[] cVarArr) {
        Throwable th;
        Throwable th2;
        ArrayList arrayList;
        int i10;
        ByteArrayOutputStream byteArrayOutputStream2;
        Throwable th3;
        ByteArrayOutputStream byteArrayOutputStream3;
        Throwable th4;
        ByteArrayOutputStream byteArrayOutputStream4 = byteArrayOutputStream;
        byte[] bArr2 = bArr;
        c[] cVarArr2 = cVarArr;
        byte[] bArr3 = r.f12558a;
        if (Arrays.equals(bArr2, bArr3)) {
            ArrayList arrayList2 = new ArrayList(3);
            ArrayList arrayList3 = new ArrayList(3);
            ByteArrayOutputStream byteArrayOutputStream5 = new ByteArrayOutputStream();
            try {
                d.g(byteArrayOutputStream5, cVarArr2.length);
                int i11 = 2;
                int i12 = 2;
                for (c cVar : cVarArr2) {
                    d.f(byteArrayOutputStream5, cVar.f12537c, 4);
                    d.f(byteArrayOutputStream5, cVar.f12538d, 4);
                    d.f(byteArrayOutputStream5, (long) cVar.f12541g, 4);
                    String b10 = b(bArr3, cVar.f12535a, cVar.f12536b);
                    int length = b10.getBytes(StandardCharsets.UTF_8).length;
                    d.g(byteArrayOutputStream5, length);
                    i12 = i12 + 4 + 4 + 4 + 2 + (length * 1);
                    byteArrayOutputStream5.write(b10.getBytes(StandardCharsets.UTF_8));
                }
                byte[] byteArray = byteArrayOutputStream5.toByteArray();
                if (i12 == byteArray.length) {
                    s sVar = new s(1, byteArray, false);
                    byteArrayOutputStream5.close();
                    arrayList2.add(sVar);
                    ByteArrayOutputStream byteArrayOutputStream6 = new ByteArrayOutputStream();
                    int i13 = 0;
                    int i14 = 0;
                    while (i13 < cVarArr2.length) {
                        try {
                            c cVar2 = cVarArr2[i13];
                            d.g(byteArrayOutputStream6, i13);
                            d.g(byteArrayOutputStream6, cVar2.f12539e);
                            i14 = i14 + 2 + 2 + (cVar2.f12539e * 2);
                            k(byteArrayOutputStream6, cVar2);
                            i13++;
                        } catch (Throwable th5) {
                            th2.addSuppressed(th5);
                        }
                    }
                    byte[] byteArray2 = byteArrayOutputStream6.toByteArray();
                    if (i14 == byteArray2.length) {
                        s sVar2 = new s(3, byteArray2, true);
                        byteArrayOutputStream6.close();
                        arrayList2.add(sVar2);
                        ByteArrayOutputStream byteArrayOutputStream7 = new ByteArrayOutputStream();
                        int i15 = 0;
                        int i16 = 0;
                        while (i15 < cVarArr2.length) {
                            try {
                                c cVar3 = cVarArr2[i15];
                                int i17 = 0;
                                for (Map.Entry value : cVar3.f12543i.entrySet()) {
                                    i17 |= ((Integer) value.getValue()).intValue();
                                }
                                byteArrayOutputStream2 = new ByteArrayOutputStream();
                                m(byteArrayOutputStream2, cVar3);
                                byte[] byteArray3 = byteArrayOutputStream2.toByteArray();
                                byteArrayOutputStream2.close();
                                byteArrayOutputStream3 = new ByteArrayOutputStream();
                                n(byteArrayOutputStream3, cVar3);
                                byte[] byteArray4 = byteArrayOutputStream3.toByteArray();
                                byteArrayOutputStream3.close();
                                d.g(byteArrayOutputStream7, i15);
                                int length2 = byteArray3.length + i11 + byteArray4.length;
                                int i18 = i16 + 2 + 4;
                                ArrayList arrayList4 = arrayList3;
                                d.f(byteArrayOutputStream7, (long) length2, 4);
                                d.g(byteArrayOutputStream7, i17);
                                byteArrayOutputStream7.write(byteArray3);
                                byteArrayOutputStream7.write(byteArray4);
                                i16 = i18 + length2;
                                i15++;
                                arrayList3 = arrayList4;
                                i11 = 2;
                            } catch (Throwable th6) {
                                Throwable th7 = th6;
                                try {
                                    byteArrayOutputStream7.close();
                                } catch (Throwable th8) {
                                    th7.addSuppressed(th8);
                                }
                                throw th7;
                            }
                        }
                        ArrayList arrayList5 = arrayList3;
                        byte[] byteArray5 = byteArrayOutputStream7.toByteArray();
                        if (i16 == byteArray5.length) {
                            s sVar3 = new s(4, byteArray5, true);
                            byteArrayOutputStream7.close();
                            arrayList2.add(sVar3);
                            long j10 = (long) 4;
                            long size = j10 + j10 + 4 + ((long) (arrayList2.size() * 16));
                            d.f(byteArrayOutputStream4, (long) arrayList2.size(), 4);
                            int i19 = 0;
                            while (i19 < arrayList2.size()) {
                                s sVar4 = (s) arrayList2.get(i19);
                                d.f(byteArrayOutputStream4, h.d(sVar4.f12565a), 4);
                                d.f(byteArrayOutputStream4, size, 4);
                                boolean z10 = sVar4.f12567c;
                                byte[] bArr4 = sVar4.f12566b;
                                if (z10) {
                                    byte[] a10 = d.a(bArr4);
                                    arrayList = arrayList5;
                                    arrayList.add(a10);
                                    d.f(byteArrayOutputStream4, (long) a10.length, 4);
                                    d.f(byteArrayOutputStream4, (long) bArr4.length, 4);
                                    i10 = a10.length;
                                } else {
                                    arrayList = arrayList5;
                                    arrayList.add(bArr4);
                                    d.f(byteArrayOutputStream4, (long) bArr4.length, 4);
                                    d.f(byteArrayOutputStream4, 0, 4);
                                    i10 = bArr4.length;
                                }
                                size += (long) i10;
                                i19++;
                                arrayList5 = arrayList;
                            }
                            ArrayList arrayList6 = arrayList5;
                            for (int i20 = 0; i20 < arrayList6.size(); i20++) {
                                byteArrayOutputStream4.write((byte[]) arrayList6.get(i20));
                            }
                            return true;
                        }
                        throw new IllegalStateException("Expected size " + i16 + ", does not match actual size " + byteArray5.length);
                    }
                    throw new IllegalStateException("Expected size " + i14 + ", does not match actual size " + byteArray2.length);
                }
                throw new IllegalStateException("Expected size " + i12 + ", does not match actual size " + byteArray.length);
            } catch (Throwable th9) {
                th.addSuppressed(th9);
            }
        } else {
            byte[] bArr5 = r.f12559b;
            if (Arrays.equals(bArr2, bArr5)) {
                byte[] a11 = a(cVarArr2, bArr5);
                d.f(byteArrayOutputStream4, (long) cVarArr2.length, 1);
                d.f(byteArrayOutputStream4, (long) a11.length, 4);
                byte[] a12 = d.a(a11);
                d.f(byteArrayOutputStream4, (long) a12.length, 4);
                byteArrayOutputStream4.write(a12);
                return true;
            }
            byte[] bArr6 = r.f12561d;
            if (Arrays.equals(bArr2, bArr6)) {
                d.f(byteArrayOutputStream4, (long) cVarArr2.length, 1);
                for (c cVar4 : cVarArr2) {
                    String b11 = b(bArr6, cVar4.f12535a, cVar4.f12536b);
                    d.g(byteArrayOutputStream4, b11.getBytes(StandardCharsets.UTF_8).length);
                    d.g(byteArrayOutputStream4, cVar4.f12542h.length);
                    d.f(byteArrayOutputStream4, (long) (cVar4.f12543i.size() * 4), 4);
                    d.f(byteArrayOutputStream4, cVar4.f12537c, 4);
                    byteArrayOutputStream4.write(b11.getBytes(StandardCharsets.UTF_8));
                    for (Integer intValue : cVar4.f12543i.keySet()) {
                        d.g(byteArrayOutputStream4, intValue.intValue());
                        d.g(byteArrayOutputStream4, 0);
                    }
                    for (int g10 : cVar4.f12542h) {
                        d.g(byteArrayOutputStream4, g10);
                    }
                }
                return true;
            }
            byte[] bArr7 = r.f12560c;
            if (Arrays.equals(bArr2, bArr7)) {
                byte[] a13 = a(cVarArr2, bArr7);
                d.f(byteArrayOutputStream4, (long) cVarArr2.length, 1);
                d.f(byteArrayOutputStream4, (long) a13.length, 4);
                byte[] a14 = d.a(a13);
                d.f(byteArrayOutputStream4, (long) a14.length, 4);
                byteArrayOutputStream4.write(a14);
                return true;
            }
            byte[] bArr8 = r.f12562e;
            if (!Arrays.equals(bArr2, bArr8)) {
                return false;
            }
            d.g(byteArrayOutputStream4, cVarArr2.length);
            for (c cVar5 : cVarArr2) {
                String b12 = b(bArr8, cVar5.f12535a, cVar5.f12536b);
                d.g(byteArrayOutputStream4, b12.getBytes(StandardCharsets.UTF_8).length);
                TreeMap treeMap = cVar5.f12543i;
                d.g(byteArrayOutputStream4, treeMap.size());
                d.g(byteArrayOutputStream4, cVar5.f12542h.length);
                d.f(byteArrayOutputStream4, cVar5.f12537c, 4);
                byteArrayOutputStream4.write(b12.getBytes(StandardCharsets.UTF_8));
                for (Integer intValue2 : treeMap.keySet()) {
                    d.g(byteArrayOutputStream4, intValue2.intValue());
                }
                for (int g11 : cVar5.f12542h) {
                    d.g(byteArrayOutputStream4, g11);
                }
            }
            return true;
        }
        throw th2;
        throw th3;
        throw th4;
        throw th;
    }

    public static void k(ByteArrayOutputStream byteArrayOutputStream, c cVar) {
        int i10 = 0;
        for (int valueOf : cVar.f12542h) {
            Integer valueOf2 = Integer.valueOf(valueOf);
            d.g(byteArrayOutputStream, valueOf2.intValue() - i10);
            i10 = valueOf2.intValue();
        }
    }

    public static void l(ByteArrayOutputStream byteArrayOutputStream, c cVar, String str) {
        d.g(byteArrayOutputStream, str.getBytes(StandardCharsets.UTF_8).length);
        d.g(byteArrayOutputStream, cVar.f12539e);
        d.f(byteArrayOutputStream, (long) cVar.f12540f, 4);
        d.f(byteArrayOutputStream, cVar.f12537c, 4);
        d.f(byteArrayOutputStream, (long) cVar.f12541g, 4);
        byteArrayOutputStream.write(str.getBytes(StandardCharsets.UTF_8));
    }

    public static void m(ByteArrayOutputStream byteArrayOutputStream, c cVar) {
        byte[] bArr = new byte[(((((cVar.f12541g * 2) + 8) - 1) & -8) / 8)];
        for (Map.Entry entry : cVar.f12543i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            int intValue2 = ((Integer) entry.getValue()).intValue();
            int i10 = intValue2 & 2;
            int i11 = cVar.f12541g;
            if (i10 != 0) {
                int c10 = c(2, intValue, i11);
                int i12 = c10 / 8;
                bArr[i12] = (byte) ((1 << (c10 % 8)) | bArr[i12]);
            }
            if ((intValue2 & 4) != 0) {
                int c11 = c(4, intValue, i11);
                int i13 = c11 / 8;
                bArr[i13] = (byte) ((1 << (c11 % 8)) | bArr[i13]);
            }
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void n(ByteArrayOutputStream byteArrayOutputStream, c cVar) {
        int i10 = 0;
        for (Map.Entry entry : cVar.f12543i.entrySet()) {
            int intValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                d.g(byteArrayOutputStream, intValue - i10);
                d.g(byteArrayOutputStream, 0);
                i10 = intValue;
            }
        }
    }
}
