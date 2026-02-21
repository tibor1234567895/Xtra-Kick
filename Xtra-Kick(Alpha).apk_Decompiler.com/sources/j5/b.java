package j5;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import b5.m;
import b5.n;
import b5.o;
import k5.c0;
import k5.t;
import k5.w;

public final class b implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final c0 f8801a;

    /* renamed from: b  reason: collision with root package name */
    public final int f8802b;

    /* renamed from: c  reason: collision with root package name */
    public final int f8803c;

    /* renamed from: d  reason: collision with root package name */
    public final b5.b f8804d;

    /* renamed from: e  reason: collision with root package name */
    public final t f8805e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f8806f;

    /* renamed from: g  reason: collision with root package name */
    public final o f8807g;

    public b(int i10, int i11, n nVar) {
        boolean z10;
        if (c0.f9134j == null) {
            synchronized (c0.class) {
                if (c0.f9134j == null) {
                    c0.f9134j = new c0();
                }
            }
        }
        this.f8801a = c0.f9134j;
        this.f8802b = i10;
        this.f8803c = i11;
        this.f8804d = (b5.b) nVar.c(w.f9183f);
        this.f8805e = (t) nVar.c(t.f9174f);
        m mVar = w.f9187j;
        if (nVar.c(mVar) == null || !((Boolean) nVar.c(mVar)).booleanValue()) {
            z10 = false;
        } else {
            z10 = true;
        }
        this.f8806f = z10;
        this.f8807g = (o) nVar.c(w.f9184g);
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        boolean z10 = false;
        if (this.f8801a.a(this.f8802b, this.f8803c, this.f8806f, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f8804d == b5.b.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        Size m10 = imageInfo.getSize();
        int i10 = this.f8802b;
        if (i10 == Integer.MIN_VALUE) {
            i10 = m10.getWidth();
        }
        int i11 = this.f8803c;
        if (i11 == Integer.MIN_VALUE) {
            i11 = m10.getHeight();
        }
        float b10 = this.f8805e.b(m10.getWidth(), m10.getHeight(), i10, i11);
        int round = Math.round(((float) m10.getWidth()) * b10);
        int round2 = Math.round(b10 * ((float) m10.getHeight()));
        if (Log.isLoggable("ImageDecoder", 2)) {
            m10.getWidth();
            m10.getHeight();
        }
        imageDecoder.setTargetSize(round, round2);
        o oVar = this.f8807g;
        if (oVar != null) {
            int i12 = Build.VERSION.SDK_INT;
            if (i12 >= 28) {
                if (oVar == o.DISPLAY_P3 && imageInfo.getColorSpace() != null && imageInfo.getColorSpace().isWideGamut()) {
                    z10 = true;
                }
                imageDecoder.setTargetColorSpace(ColorSpace.get(z10 ? ColorSpace.Named.DISPLAY_P3 : ColorSpace.Named.SRGB));
            } else if (i12 >= 26) {
                imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            }
        }
    }
}
