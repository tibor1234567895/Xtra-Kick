package o1;

import android.media.AudioTrack;

public final class c0 extends AudioTrack.StreamEventCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ d0 f11865a;

    public c0(d0 d0Var) {
        this.f11865a = d0Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r1 = r0.f11865a.f11871c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onDataRequest(android.media.AudioTrack r1, int r2) {
        /*
            r0 = this;
            o1.d0 r2 = r0.f11865a
            o1.e0 r2 = r2.f11871c
            android.media.AudioTrack r2 = r2.f11900u
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x000d
            return
        L_0x000d:
            o1.d0 r1 = r0.f11865a
            o1.e0 r1 = r1.f11871c
            e.a r2 = r1.f11897r
            if (r2 == 0) goto L_0x0029
            boolean r1 = r1.U
            if (r1 == 0) goto L_0x0029
            java.lang.Object r1 = r2.f4852i
            o1.j0 r1 = (o1.j0) r1
            m1.o0 r1 = r1.U0
            if (r1 == 0) goto L_0x0029
            m1.u0 r1 = r1.f10417a
            j1.f0 r1 = r1.f10506o
            r2 = 2
            r1.d(r2)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.c0.onDataRequest(android.media.AudioTrack, int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000d, code lost:
        r2 = r1.f11865a.f11871c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onTearDown(android.media.AudioTrack r2) {
        /*
            r1 = this;
            o1.d0 r0 = r1.f11865a
            o1.e0 r0 = r0.f11871c
            android.media.AudioTrack r0 = r0.f11900u
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x000d
            return
        L_0x000d:
            o1.d0 r2 = r1.f11865a
            o1.e0 r2 = r2.f11871c
            e.a r0 = r2.f11897r
            if (r0 == 0) goto L_0x0029
            boolean r2 = r2.U
            if (r2 == 0) goto L_0x0029
            java.lang.Object r2 = r0.f4852i
            o1.j0 r2 = (o1.j0) r2
            m1.o0 r2 = r2.U0
            if (r2 == 0) goto L_0x0029
            m1.u0 r2 = r2.f10417a
            j1.f0 r2 = r2.f10506o
            r0 = 2
            r2.d(r0)
        L_0x0029:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o1.c0.onTearDown(android.media.AudioTrack):void");
    }
}
