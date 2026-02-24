package m1;

import android.content.Context;
import android.content.IntentFilter;
import android.media.AudioManager;
import android.os.Handler;
import g.g0;
import g1.q;
import j1.a;
import j1.l0;
import j1.v;

public final class s1 {

    /* renamed from: a  reason: collision with root package name */
    public final Context f10465a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f10466b;

    /* renamed from: c  reason: collision with root package name */
    public final r1 f10467c;

    /* renamed from: d  reason: collision with root package name */
    public final AudioManager f10468d;

    /* renamed from: e  reason: collision with root package name */
    public g0 f10469e;

    /* renamed from: f  reason: collision with root package name */
    public int f10470f = 3;

    /* renamed from: g  reason: collision with root package name */
    public int f10471g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f10472h;

    public s1(Context context, Handler handler, k0 k0Var) {
        boolean z10;
        Context applicationContext = context.getApplicationContext();
        this.f10465a = applicationContext;
        this.f10466b = handler;
        this.f10467c = k0Var;
        AudioManager audioManager = (AudioManager) applicationContext.getSystemService("audio");
        a.f(audioManager);
        this.f10468d = audioManager;
        this.f10471g = b(audioManager, 3);
        int i10 = this.f10470f;
        if (l0.f8453a >= 23) {
            z10 = audioManager.isStreamMute(i10);
        } else if (b(audioManager, i10) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        this.f10472h = z10;
        g0 g0Var = new g0(this);
        try {
            applicationContext.registerReceiver(g0Var, new IntentFilter("android.media.VOLUME_CHANGED_ACTION"));
            this.f10469e = g0Var;
        } catch (RuntimeException e10) {
            v.h("StreamVolumeManager", "Error registering stream volume receiver", e10);
        }
    }

    public static int b(AudioManager audioManager, int i10) {
        try {
            return audioManager.getStreamVolume(i10);
        } catch (RuntimeException e10) {
            v.h("StreamVolumeManager", "Could not retrieve stream volume for stream type " + i10, e10);
            return audioManager.getStreamMaxVolume(i10);
        }
    }

    public final int a() {
        if (l0.f8453a >= 28) {
            return this.f10468d.getStreamMinVolume(this.f10470f);
        }
        return 0;
    }

    public final void c(int i10) {
        if (this.f10470f != i10) {
            this.f10470f = i10;
            d();
            n0 n0Var = ((k0) this.f10467c).f10314h;
            s1 s1Var = n0Var.B;
            q qVar = new q(0, s1Var.a(), s1Var.f10468d.getStreamMaxVolume(s1Var.f10470f));
            if (!qVar.equals(n0Var.f10377f0)) {
                n0Var.f10377f0 = qVar;
                n0Var.f10388l.m(29, new i0(qVar));
            }
        }
    }

    public final void d() {
        boolean z10;
        int i10 = this.f10470f;
        AudioManager audioManager = this.f10468d;
        int b10 = b(audioManager, i10);
        int i11 = this.f10470f;
        if (l0.f8453a >= 23) {
            z10 = audioManager.isStreamMute(i11);
        } else if (b(audioManager, i11) == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (this.f10471g != b10 || this.f10472h != z10) {
            this.f10471g = b10;
            this.f10472h = z10;
            ((k0) this.f10467c).f10314h.f10388l.m(30, new h0(b10, z10));
        }
    }
}
