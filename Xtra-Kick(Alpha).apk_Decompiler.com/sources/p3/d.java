package p3;

import android.support.v4.media.h;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.zip.DataFormatException;
import java.util.zip.Deflater;
import java.util.zip.DeflaterOutputStream;
import java.util.zip.Inflater;

public final class d {
    private d() {
    }

    public static byte[] a(byte[] bArr) {
        DeflaterOutputStream deflaterOutputStream;
        Deflater deflater = new Deflater(1);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            deflaterOutputStream = new DeflaterOutputStream(byteArrayOutputStream, deflater);
            deflaterOutputStream.write(bArr);
            deflaterOutputStream.close();
            deflater.end();
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable th) {
            deflater.end();
            throw th;
        }
        throw th;
    }

    public static byte[] b(InputStream inputStream, int i10) {
        byte[] bArr = new byte[i10];
        int i11 = 0;
        while (i11 < i10) {
            int read = inputStream.read(bArr, i11, i10 - i11);
            if (read >= 0) {
                i11 += read;
            } else {
                throw new IllegalStateException(h.i("Not enough bytes to read: ", i10));
            }
        }
        return bArr;
    }

    public static byte[] c(FileInputStream fileInputStream, int i10, int i11) {
        Inflater inflater = new Inflater();
        try {
            byte[] bArr = new byte[i11];
            byte[] bArr2 = new byte[2048];
            int i12 = 0;
            int i13 = 0;
            while (!inflater.finished() && !inflater.needsDictionary() && i12 < i10) {
                int read = fileInputStream.read(bArr2);
                if (read >= 0) {
                    inflater.setInput(bArr2, 0, read);
                    i13 += inflater.inflate(bArr, i13, i11 - i13);
                    i12 += read;
                } else {
                    throw new IllegalStateException("Invalid zip data. Stream ended after $totalBytesRead bytes. Expected " + i10 + " bytes");
                }
            }
            if (i12 != i10) {
                throw new IllegalStateException("Didn't read enough bytes during decompression. expected=" + i10 + " actual=" + i12);
            } else if (inflater.finished()) {
                inflater.end();
                return bArr;
            } else {
                throw new IllegalStateException("Inflater did not finish");
            }
        } catch (DataFormatException e10) {
            throw new IllegalStateException(e10.getMessage());
        } catch (Throwable th) {
            inflater.end();
            throw th;
        }
    }

    public static long d(InputStream inputStream, int i10) {
        byte[] b10 = b(inputStream, i10);
        long j10 = 0;
        for (int i11 = 0; i11 < i10; i11++) {
            j10 += ((long) (b10[i11] & 255)) << (i11 * 8);
        }
        return j10;
    }

    public static int e(InputStream inputStream) {
        return (int) d(inputStream, 2);
    }

    public static void f(ByteArrayOutputStream byteArrayOutputStream, long j10, int i10) {
        byte[] bArr = new byte[i10];
        for (int i11 = 0; i11 < i10; i11++) {
            bArr[i11] = (byte) ((int) ((j10 >> (i11 * 8)) & 255));
        }
        byteArrayOutputStream.write(bArr);
    }

    public static void g(ByteArrayOutputStream byteArrayOutputStream, int i10) {
        f(byteArrayOutputStream, (long) i10, 2);
    }
}
