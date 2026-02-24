package o1;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioTrack;
import d9.i2;
import d9.o0;
import d9.p0;
import d9.r0;
import d9.t0;
import d9.u0;
import g9.b;
import j1.l0;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final AudioAttributes f11853a = new AudioAttributes.Builder().setUsage(1).setContentType(3).setFlags(0).build();

    private a() {
    }

    public static int[] a() {
        p0 p0Var = r0.f4657i;
        o0 o0Var = new o0();
        t0 t0Var = b.f11857e;
        u0 u0Var = t0Var.f4671i;
        if (u0Var == null) {
            u0Var = t0Var.c();
            t0Var.f4671i = u0Var;
        }
        i2 g10 = u0Var.iterator();
        while (g10.hasNext()) {
            int intValue = ((Integer) g10.next()).intValue();
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setChannelMask(12).setEncoding(intValue).setSampleRate(48000).build(), f11853a)) {
                o0Var.c(Integer.valueOf(intValue));
            }
        }
        o0Var.c(2);
        return b.d(o0Var.e());
    }

    public static int b(int i10, int i11) {
        for (int i12 = 8; i12 > 0; i12--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i10).setSampleRate(i11).setChannelMask(l0.m(i12)).build(), f11853a)) {
                return i12;
            }
        }
        return 0;
    }
}
