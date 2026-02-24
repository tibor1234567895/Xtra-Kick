package o1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import g1.a0;
import g1.h;
import h1.c;
import j1.l0;
import n0.f;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    public final a0 f12047a;

    /* renamed from: b  reason: collision with root package name */
    public final int f12048b;

    /* renamed from: c  reason: collision with root package name */
    public final int f12049c;

    /* renamed from: d  reason: collision with root package name */
    public final int f12050d;

    /* renamed from: e  reason: collision with root package name */
    public final int f12051e;

    /* renamed from: f  reason: collision with root package name */
    public final int f12052f;

    /* renamed from: g  reason: collision with root package name */
    public final int f12053g;

    /* renamed from: h  reason: collision with root package name */
    public final int f12054h;

    /* renamed from: i  reason: collision with root package name */
    public final c[] f12055i;

    public x(a0 a0Var, int i10, int i11, int i12, int i13, int i14, int i15, int i16, c[] cVarArr) {
        this.f12047a = a0Var;
        this.f12048b = i10;
        this.f12049c = i11;
        this.f12050d = i12;
        this.f12051e = i13;
        this.f12052f = i14;
        this.f12053g = i15;
        this.f12054h = i16;
        this.f12055i = cVarArr;
    }

    public static AudioAttributes c(h hVar, boolean z10) {
        if (z10) {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }
        return (AudioAttributes) hVar.i().f4852i;
    }

    public final AudioTrack a(boolean z10, h hVar, int i10) {
        int i11 = this.f12049c;
        try {
            AudioTrack b10 = b(z10, hVar, i10);
            int state = b10.getState();
            if (state == 1) {
                return b10;
            }
            try {
                b10.release();
            } catch (Exception unused) {
            }
            throw new j(state, this.f12051e, this.f12052f, this.f12054h, this.f12047a, i11 == 1, (RuntimeException) null);
        } catch (IllegalArgumentException | UnsupportedOperationException e10) {
            throw new j(0, this.f12051e, this.f12052f, this.f12054h, this.f12047a, i11 == 1, e10);
        }
    }

    public final AudioTrack b(boolean z10, h hVar, int i10) {
        AudioTrack audioTrack;
        int i11 = l0.f8453a;
        int i12 = this.f12053g;
        int i13 = this.f12052f;
        int i14 = this.f12051e;
        if (i11 >= 29) {
            AudioFormat e10 = e0.e(i14, i13, i12);
            AudioAttributes c10 = c(hVar, z10);
            f.A();
            AudioTrack.Builder w10 = f.f().setAudioAttributes(c10).setAudioFormat(e10).setTransferMode(1).setBufferSizeInBytes(this.f12054h).setSessionId(i10);
            boolean z11 = true;
            if (this.f12049c != 1) {
                z11 = false;
            }
            return w10.setOffloadedPlayback(z11).build();
        } else if (i11 >= 21) {
            return new AudioTrack(c(hVar, z10), e0.e(i14, i13, i12), this.f12054h, 1, i10);
        } else {
            int w11 = l0.w(hVar.f6395j);
            int i15 = this.f12051e;
            int i16 = this.f12052f;
            int i17 = this.f12053g;
            int i18 = this.f12054h;
            if (i10 != 0) {
                new AudioTrack(w11, i15, i16, i17, i18, 1, i10);
            }
            return audioTrack;
        }
    }
}
