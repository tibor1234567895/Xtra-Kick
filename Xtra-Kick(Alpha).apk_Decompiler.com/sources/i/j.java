package i;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.StateSet;

public class j extends h {
    public int[][] I;

    public j(j jVar, k kVar, Resources resources) {
        super(jVar, kVar, resources);
        if (jVar != null) {
            this.I = jVar.I;
        } else {
            this.I = new int[this.f7905g.length][];
        }
    }

    public void e() {
        int[][] iArr = this.I;
        int[][] iArr2 = new int[iArr.length][];
        for (int length = iArr.length - 1; length >= 0; length--) {
            int[] iArr3 = this.I[length];
            iArr2[length] = iArr3 != null ? (int[]) iArr3.clone() : null;
        }
        this.I = iArr2;
    }

    public final int f(int[] iArr) {
        int[][] iArr2 = this.I;
        int i10 = this.f7906h;
        for (int i11 = 0; i11 < i10; i11++) {
            if (StateSet.stateSetMatches(iArr2[i11], iArr)) {
                return i11;
            }
        }
        return -1;
    }

    public Drawable newDrawable() {
        return new k(this, (Resources) null);
    }

    public Drawable newDrawable(Resources resources) {
        return new k(this, resources);
    }
}
