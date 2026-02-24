package j4;

import android.graphics.Bitmap;
import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.PostProcessor;
import android.os.Build;
import android.support.v4.media.h;
import android.util.Size;
import hb.h0;
import s4.m;
import t4.g;
import xa.j;
import xa.q;
import xa.u;
import za.b;

public final class a0 implements ImageDecoder.OnHeaderDecodedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ u f8729a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c0 f8730b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ q f8731c;

    public a0(u uVar, c0 c0Var, q qVar) {
        this.f8729a = uVar;
        this.f8730b = c0Var;
        this.f8731c = qVar;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        int i10;
        int i11;
        int i12;
        boolean z10;
        j.f("decoder", imageDecoder);
        j.f("info", imageInfo);
        j.f("source", source);
        this.f8729a.f16818h = imageDecoder;
        Size m10 = imageInfo.getSize();
        int width = m10.getWidth();
        int height = m10.getHeight();
        m mVar = this.f8730b.f8737b;
        g gVar = mVar.f14279d;
        if (h0.Z0(gVar)) {
            i10 = width;
        } else {
            i10 = h0.W1(gVar.f14548a, mVar.f14280e);
        }
        m mVar2 = this.f8730b.f8737b;
        g gVar2 = mVar2.f14279d;
        if (h0.Z0(gVar2)) {
            i11 = height;
        } else {
            i11 = h0.W1(gVar2.f14549b, mVar2.f14280e);
        }
        boolean z11 = false;
        if (width > 0 && height > 0 && !(width == i10 && height == i11)) {
            double a10 = i.a(width, height, i10, i11, this.f8730b.f8737b.f14280e);
            q qVar = this.f8731c;
            if (a10 < 1.0d) {
                z10 = true;
            } else {
                z10 = false;
            }
            qVar.f16814h = z10;
            if (z10 || !this.f8730b.f8737b.f14281f) {
                imageDecoder.setTargetSize(b.a(((double) width) * a10), b.a(a10 * ((double) height)));
            }
        }
        m mVar3 = this.f8730b.f8737b;
        Bitmap.Config config = mVar3.f14277b;
        if (Build.VERSION.SDK_INT >= 26 && config == Bitmap.Config.HARDWARE) {
            z11 = true;
        }
        if (z11) {
            i12 = 3;
        } else {
            i12 = 1;
        }
        imageDecoder.setAllocator(i12);
        imageDecoder.setMemorySizePolicy(mVar3.f14282g ^ true ? 1 : 0);
        ColorSpace colorSpace = mVar3.f14278c;
        if (colorSpace != null) {
            imageDecoder.setTargetColorSpace(colorSpace);
        }
        imageDecoder.setUnpremultipliedRequired(!mVar3.f14283h);
        h.y(mVar3.f14287l.f14293h.get("coil#animated_transformation"));
        imageDecoder.setPostProcessor((PostProcessor) null);
    }
}
