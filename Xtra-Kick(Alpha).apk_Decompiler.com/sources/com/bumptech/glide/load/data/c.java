package com.bumptech.glide.load.data;

import e5.k;
import java.io.FileOutputStream;
import java.io.OutputStream;

public final class c extends OutputStream {

    /* renamed from: h  reason: collision with root package name */
    public final OutputStream f3221h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f3222i;

    /* renamed from: j  reason: collision with root package name */
    public final k f3223j;

    /* renamed from: k  reason: collision with root package name */
    public int f3224k;

    public c(FileOutputStream fileOutputStream, k kVar) {
        this.f3221h = fileOutputStream;
        this.f3223j = kVar;
        this.f3222i = (byte[]) kVar.d(65536, byte[].class);
    }

    /* JADX INFO: finally extract failed */
    public final void close() {
        OutputStream outputStream = this.f3221h;
        try {
            flush();
            outputStream.close();
            byte[] bArr = this.f3222i;
            if (bArr != null) {
                this.f3223j.h(bArr);
                this.f3222i = null;
            }
        } catch (Throwable th) {
            outputStream.close();
            throw th;
        }
    }

    public final void flush() {
        int i10 = this.f3224k;
        OutputStream outputStream = this.f3221h;
        if (i10 > 0) {
            outputStream.write(this.f3222i, 0, i10);
            this.f3224k = 0;
        }
        outputStream.flush();
    }

    public final void write(int i10) {
        byte[] bArr = this.f3222i;
        int i11 = this.f3224k;
        int i12 = i11 + 1;
        this.f3224k = i12;
        bArr[i11] = (byte) i10;
        if (i12 == bArr.length && i12 > 0) {
            this.f3221h.write(bArr, 0, i12);
            this.f3224k = 0;
        }
    }

    public final void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i10, int i11) {
        int i12 = 0;
        do {
            int i13 = i11 - i12;
            int i14 = i10 + i12;
            int i15 = this.f3224k;
            OutputStream outputStream = this.f3221h;
            if (i15 != 0 || i13 < this.f3222i.length) {
                int min = Math.min(i13, this.f3222i.length - i15);
                System.arraycopy(bArr, i14, this.f3222i, this.f3224k, min);
                int i16 = this.f3224k + min;
                this.f3224k = i16;
                i12 += min;
                byte[] bArr2 = this.f3222i;
                if (i16 == bArr2.length && i16 > 0) {
                    outputStream.write(bArr2, 0, i16);
                    this.f3224k = 0;
                    continue;
                }
            } else {
                outputStream.write(bArr, i14, i13);
                return;
            }
        } while (i12 < i11);
    }
}
