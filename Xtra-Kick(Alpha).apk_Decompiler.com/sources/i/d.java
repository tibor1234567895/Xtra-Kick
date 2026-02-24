package i;

import android.animation.TimeInterpolator;
import android.graphics.drawable.AnimationDrawable;

public final class d implements TimeInterpolator {

    /* renamed from: a  reason: collision with root package name */
    public int[] f7891a;

    /* renamed from: b  reason: collision with root package name */
    public int f7892b;

    /* renamed from: c  reason: collision with root package name */
    public int f7893c;

    public d(AnimationDrawable animationDrawable, boolean z10) {
        int i10;
        int numberOfFrames = animationDrawable.getNumberOfFrames();
        this.f7892b = numberOfFrames;
        int[] iArr = this.f7891a;
        if (iArr == null || iArr.length < numberOfFrames) {
            this.f7891a = new int[numberOfFrames];
        }
        int[] iArr2 = this.f7891a;
        int i11 = 0;
        for (int i12 = 0; i12 < numberOfFrames; i12++) {
            if (z10) {
                i10 = (numberOfFrames - i12) - 1;
            } else {
                i10 = i12;
            }
            int duration = animationDrawable.getDuration(i10);
            iArr2[i12] = duration;
            i11 += duration;
        }
        this.f7893c = i11;
    }

    public final float getInterpolation(float f10) {
        int i10 = (int) ((f10 * ((float) this.f7893c)) + 0.5f);
        int i11 = this.f7892b;
        int[] iArr = this.f7891a;
        int i12 = 0;
        while (i12 < i11) {
            int i13 = iArr[i12];
            if (i10 < i13) {
                break;
            }
            i10 -= i13;
            i12++;
        }
        return (((float) i12) / ((float) i11)) + (i12 < i11 ? ((float) i10) / ((float) this.f7893c) : 0.0f);
    }
}
