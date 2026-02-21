package m1;

import android.media.MediaFormat;
import b2.m;
import c2.a;
import g1.a0;

public final class l0 implements m, a, l1 {

    /* renamed from: h  reason: collision with root package name */
    public m f10345h;

    /* renamed from: i  reason: collision with root package name */
    public a f10346i;

    /* renamed from: j  reason: collision with root package name */
    public m f10347j;

    /* renamed from: k  reason: collision with root package name */
    public a f10348k;

    private l0() {
    }

    public /* synthetic */ l0(int i10) {
        this();
    }

    public final void a(long j10, float[] fArr) {
        a aVar = this.f10348k;
        if (aVar != null) {
            aVar.a(j10, fArr);
        }
        a aVar2 = this.f10346i;
        if (aVar2 != null) {
            aVar2.a(j10, fArr);
        }
    }

    public final void b(int i10, Object obj) {
        a aVar;
        if (i10 == 7) {
            this.f10345h = (m) obj;
        } else if (i10 == 8) {
            this.f10346i = (a) obj;
        } else if (i10 == 10000) {
            c2.m mVar = (c2.m) obj;
            if (mVar == null) {
                aVar = null;
                this.f10347j = null;
            } else {
                this.f10347j = mVar.getVideoFrameMetadataListener();
                aVar = mVar.getCameraMotionListener();
            }
            this.f10348k = aVar;
        }
    }

    public final void c() {
        a aVar = this.f10348k;
        if (aVar != null) {
            aVar.c();
        }
        a aVar2 = this.f10346i;
        if (aVar2 != null) {
            aVar2.c();
        }
    }

    public final void d(long j10, long j11, a0 a0Var, MediaFormat mediaFormat) {
        m mVar = this.f10347j;
        if (mVar != null) {
            mVar.d(j10, j11, a0Var, mediaFormat);
        }
        m mVar2 = this.f10345h;
        if (mVar2 != null) {
            mVar2.d(j10, j11, a0Var, mediaFormat);
        }
    }
}
