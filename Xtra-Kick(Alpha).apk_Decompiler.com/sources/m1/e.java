package m1;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.os.Handler;
import g1.h;
import j1.l0;
import m0.r;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public final AudioManager f10201a;

    /* renamed from: b  reason: collision with root package name */
    public final c f10202b;

    /* renamed from: c  reason: collision with root package name */
    public d f10203c;

    /* renamed from: d  reason: collision with root package name */
    public h f10204d;

    /* renamed from: e  reason: collision with root package name */
    public int f10205e;

    /* renamed from: f  reason: collision with root package name */
    public int f10206f;

    /* renamed from: g  reason: collision with root package name */
    public float f10207g = 1.0f;

    /* renamed from: h  reason: collision with root package name */
    public AudioFocusRequest f10208h;

    public e(Context context, Handler handler, k0 k0Var) {
        AudioManager audioManager = (AudioManager) context.getApplicationContext().getSystemService("audio");
        audioManager.getClass();
        this.f10201a = audioManager;
        this.f10203c = k0Var;
        this.f10202b = new c(this, handler);
        this.f10205e = 0;
    }

    public final void a() {
        if (this.f10205e != 0) {
            int i10 = l0.f8453a;
            AudioManager audioManager = this.f10201a;
            if (i10 >= 26) {
                AudioFocusRequest audioFocusRequest = this.f10208h;
                if (audioFocusRequest != null) {
                    audioManager.abandonAudioFocusRequest(audioFocusRequest);
                }
            } else {
                audioManager.abandonAudioFocus(this.f10202b);
            }
            d(0);
        }
    }

    public final void b(int i10) {
        d dVar = this.f10203c;
        if (dVar != null) {
            n0 n0Var = ((k0) dVar).f10314h;
            boolean y10 = n0Var.y();
            int i11 = 1;
            if (y10 && i10 != 1) {
                i11 = 2;
            }
            n0Var.t1(i10, i11, y10);
        }
    }

    public final void c() {
        if (!l0.a(this.f10204d, (Object) null)) {
            this.f10204d = null;
            this.f10206f = 0;
        }
    }

    public final void d(int i10) {
        float f10;
        if (this.f10205e != i10) {
            this.f10205e = i10;
            if (i10 == 3) {
                f10 = 0.2f;
            } else {
                f10 = 1.0f;
            }
            if (this.f10207g != f10) {
                this.f10207g = f10;
                d dVar = this.f10203c;
                if (dVar != null) {
                    n0 n0Var = ((k0) dVar).f10314h;
                    n0Var.m1(1, 2, Float.valueOf(n0Var.f10367a0 * n0Var.A.f10207g));
                }
            }
        }
    }

    public final int e(int i10, boolean z10) {
        boolean z11;
        int i11;
        AudioFocusRequest.Builder builder;
        boolean z12;
        int i12 = 1;
        if (i10 == 1 || this.f10206f != 1) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            a();
            if (z10) {
                return 1;
            }
            return -1;
        } else if (!z10) {
            return -1;
        } else {
            if (this.f10205e != 1) {
                int i13 = l0.f8453a;
                c cVar = this.f10202b;
                AudioManager audioManager = this.f10201a;
                if (i13 >= 26) {
                    AudioFocusRequest audioFocusRequest = this.f10208h;
                    if (audioFocusRequest == null) {
                        if (audioFocusRequest == null) {
                            r.o();
                            builder = r.e(this.f10206f);
                        } else {
                            r.o();
                            builder = r.i(this.f10208h);
                        }
                        h hVar = this.f10204d;
                        if (hVar == null || hVar.f6393h != 1) {
                            z12 = false;
                        } else {
                            z12 = true;
                        }
                        hVar.getClass();
                        this.f10208h = builder.setAudioAttributes((AudioAttributes) hVar.i().f4852i).setWillPauseWhenDucked(z12).setOnAudioFocusChangeListener(cVar).build();
                    }
                    i11 = audioManager.requestAudioFocus(this.f10208h);
                } else {
                    h hVar2 = this.f10204d;
                    hVar2.getClass();
                    i11 = audioManager.requestAudioFocus(cVar, l0.w(hVar2.f6395j), this.f10206f);
                }
                if (i11 == 1) {
                    d(1);
                } else {
                    d(0);
                    i12 = -1;
                }
            }
            return i12;
        }
    }
}
