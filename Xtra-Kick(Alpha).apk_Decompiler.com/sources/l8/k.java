package l8;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import t8.i;

public abstract class k extends AnimatorListenerAdapter implements ValueAnimator.AnimatorUpdateListener {

    /* renamed from: a  reason: collision with root package name */
    public boolean f9725a;

    /* renamed from: b  reason: collision with root package name */
    public float f9726b;

    /* renamed from: c  reason: collision with root package name */
    public float f9727c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ l f9728d;

    public k(n nVar) {
        this.f9728d = nVar;
    }

    public final void onAnimationEnd(Animator animator) {
        float f10 = (float) ((int) this.f9727c);
        i iVar = this.f9728d.f9731b;
        if (iVar != null) {
            iVar.j(f10);
        }
        this.f9725a = false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0027, code lost:
        r2 = r2 + r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002b, code lost:
        r4.f9727c = r2;
        r4.f9725a = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onAnimationUpdate(android.animation.ValueAnimator r5) {
        /*
            r4 = this;
            boolean r0 = r4.f9725a
            l8.l r1 = r4.f9728d
            if (r0 != 0) goto L_0x0030
            t8.i r0 = r1.f9731b
            r2 = 0
            if (r0 != 0) goto L_0x000d
            r0 = 0
            goto L_0x0011
        L_0x000d:
            t8.h r0 = r0.f14744h
            float r0 = r0.f14736n
        L_0x0011:
            r4.f9726b = r0
            r0 = r4
            l8.j r0 = (l8.j) r0
            int r3 = r0.f9723e
            l8.l r0 = r0.f9724f
            switch(r3) {
                case 0: goto L_0x002b;
                case 1: goto L_0x0023;
                case 2: goto L_0x001e;
                default: goto L_0x001d;
            }
        L_0x001d:
            goto L_0x0029
        L_0x001e:
            float r2 = r0.f9737h
            float r0 = r0.f9739j
            goto L_0x0027
        L_0x0023:
            float r2 = r0.f9737h
            float r0 = r0.f9738i
        L_0x0027:
            float r2 = r2 + r0
            goto L_0x002b
        L_0x0029:
            float r2 = r0.f9737h
        L_0x002b:
            r4.f9727c = r2
            r0 = 1
            r4.f9725a = r0
        L_0x0030:
            float r0 = r4.f9726b
            float r2 = r4.f9727c
            float r2 = r2 - r0
            float r5 = r5.getAnimatedFraction()
            float r5 = r5 * r2
            float r5 = r5 + r0
            int r5 = (int) r5
            float r5 = (float) r5
            t8.i r0 = r1.f9731b
            if (r0 == 0) goto L_0x0045
            r0.j(r5)
        L_0x0045:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l8.k.onAnimationUpdate(android.animation.ValueAnimator):void");
    }
}
