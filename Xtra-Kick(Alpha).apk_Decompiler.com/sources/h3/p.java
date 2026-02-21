package h3;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.view.Surface;

public final class p implements r {

    /* renamed from: c  reason: collision with root package name */
    public final IBinder f7271c;

    public p(IBinder iBinder) {
        this.f7271c = iBinder;
    }

    public final void B(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3042, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void C(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3024, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void D(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3036, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void H(o oVar, int i10, Bundle bundle, long j10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            obtain.writeLong(j10);
            if (!this.f7271c.transact(3008, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void K(o oVar, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3027, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void L(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3025, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void O(o oVar, int i10, Bundle bundle, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            int i11 = 0;
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (z10) {
                i11 = 1;
            }
            obtain.writeInt(i11);
            if (!this.f7271c.transact(3009, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void P(o oVar, int i10, long j10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeLong(j10);
            if (!this.f7271c.transact(3038, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void R(o oVar, int i10, int i11) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            if (!this.f7271c.transact(3037, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void S(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3005, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void V(o oVar, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3014, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void W(o oVar) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            if (!this.f7271c.transact(3045, obtain, (Parcel) null, 1)) {
                int i10 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void X(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3026, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void Y(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3041, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void Z(o oVar, int i10, int i11) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            if (!this.f7271c.transact(3017, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final IBinder asBinder() {
        return this.f7271c;
    }

    public final void c(o oVar, int i10, int i11) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            if (!this.f7271c.transact(3019, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void c0(o oVar, int i10, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(z10 ? 1 : 0);
            if (!this.f7271c.transact(3006, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void f(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3021, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void h0(o oVar, int i10, int i11, int i12) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeInt(i12);
            if (!this.f7271c.transact(3020, obtain, (Parcel) null, 1)) {
                int i13 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void i(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3046, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void i0(o oVar, int i10, IBinder iBinder) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeStrongBinder(iBinder);
            if (!this.f7271c.transact(3031, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void j(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3043, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void j0(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3040, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void k0(o oVar, int i10, int i11, int i12) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeInt(i12);
            if (!this.f7271c.transact(3022, obtain, (Parcel) null, 1)) {
                int i13 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void l(o oVar, int i10, int i11, int i12, int i13) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeInt(i12);
            obtain.writeInt(i13);
            if (!this.f7271c.transact(3023, obtain, (Parcel) null, 1)) {
                int i14 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void l0(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3004, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void o(o oVar, int i10, IBinder iBinder, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(z10 ? 1 : 0);
            if (!this.f7271c.transact(3011, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void p(o oVar, int i10, float f10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeFloat(f10);
            if (!this.f7271c.transact(3028, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void p0(o oVar, int i10, float f10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeFloat(f10);
            if (!this.f7271c.transact(3002, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void q0(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3035, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void r0(o oVar, int i10, IBinder iBinder, int i11, long j10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeStrongBinder(iBinder);
            obtain.writeInt(i11);
            obtain.writeLong(j10);
            if (!this.f7271c.transact(3012, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void s(o oVar, int i10, int i11, long j10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeLong(j10);
            if (!this.f7271c.transact(3039, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void s0(o oVar, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3033, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void t(o oVar, int i10, Bundle bundle, Bundle bundle2) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (bundle2 != null) {
                obtain.writeInt(1);
                bundle2.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3016, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void t0(o oVar, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3048, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void u(o oVar, int i10, int i11, IBinder iBinder) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            obtain.writeStrongBinder(iBinder);
            if (!this.f7271c.transact(3032, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void u0(o oVar, int i10, int i11) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(i11);
            if (!this.f7271c.transact(3003, obtain, (Parcel) null, 1)) {
                int i12 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void v(o oVar, int i10, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(z10 ? 1 : 0);
            if (!this.f7271c.transact(3018, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void w(o1 o1Var, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            if (o1Var == null) {
                o1Var = null;
            }
            obtain.writeStrongBinder(o1Var);
            obtain.writeInt(i10);
            obtain.writeInt(1);
            bundle.writeToParcel(obtain, 0);
            if (!this.f7271c.transact(3007, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void w0(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3047, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void x(o oVar, int i10, Bundle bundle) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (bundle != null) {
                obtain.writeInt(1);
                bundle.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3015, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void y(o oVar, int i10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (!this.f7271c.transact(3034, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void y0(o oVar, int i10, Surface surface) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            if (surface != null) {
                obtain.writeInt(1);
                surface.writeToParcel(obtain, 0);
            } else {
                obtain.writeInt(0);
            }
            if (!this.f7271c.transact(3044, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }

    public final void z(o oVar, int i10, boolean z10) {
        Parcel obtain = Parcel.obtain();
        try {
            obtain.writeInterfaceToken("androidx.media3.session.IMediaSession");
            obtain.writeStrongBinder(oVar != null ? oVar.asBinder() : null);
            obtain.writeInt(i10);
            obtain.writeInt(z10 ? 1 : 0);
            if (!this.f7271c.transact(3013, obtain, (Parcel) null, 1)) {
                int i11 = q.f7289c;
            }
        } finally {
            obtain.recycle();
        }
    }
}
