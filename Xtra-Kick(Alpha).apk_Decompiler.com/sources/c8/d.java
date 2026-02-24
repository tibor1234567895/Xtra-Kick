package c8;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build;
import com.google.android.material.button.MaterialButton;
import com.woxthebox.draglistview.R;
import g8.a;
import java.util.WeakHashMap;
import m0.c1;
import m0.j0;
import t8.h;
import t8.i;
import t8.n;
import t8.y;

public final class d {

    /* renamed from: u  reason: collision with root package name */
    public static final boolean f3001u = true;

    /* renamed from: v  reason: collision with root package name */
    public static final boolean f3002v;

    /* renamed from: a  reason: collision with root package name */
    public final MaterialButton f3003a;

    /* renamed from: b  reason: collision with root package name */
    public n f3004b;

    /* renamed from: c  reason: collision with root package name */
    public int f3005c;

    /* renamed from: d  reason: collision with root package name */
    public int f3006d;

    /* renamed from: e  reason: collision with root package name */
    public int f3007e;

    /* renamed from: f  reason: collision with root package name */
    public int f3008f;

    /* renamed from: g  reason: collision with root package name */
    public int f3009g;

    /* renamed from: h  reason: collision with root package name */
    public int f3010h;

    /* renamed from: i  reason: collision with root package name */
    public PorterDuff.Mode f3011i;

    /* renamed from: j  reason: collision with root package name */
    public ColorStateList f3012j;

    /* renamed from: k  reason: collision with root package name */
    public ColorStateList f3013k;

    /* renamed from: l  reason: collision with root package name */
    public ColorStateList f3014l;

    /* renamed from: m  reason: collision with root package name */
    public Drawable f3015m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f3016n = false;

    /* renamed from: o  reason: collision with root package name */
    public boolean f3017o = false;

    /* renamed from: p  reason: collision with root package name */
    public boolean f3018p = false;

    /* renamed from: q  reason: collision with root package name */
    public boolean f3019q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f3020r = true;

    /* renamed from: s  reason: collision with root package name */
    public LayerDrawable f3021s;

    /* renamed from: t  reason: collision with root package name */
    public int f3022t;

    static {
        int i10 = Build.VERSION.SDK_INT;
        boolean z10 = true;
        if (i10 > 22) {
            z10 = false;
        }
        f3002v = z10;
    }

    public d(MaterialButton materialButton, n nVar) {
        this.f3003a = materialButton;
        this.f3004b = nVar;
    }

    public final y a() {
        LayerDrawable layerDrawable = this.f3021s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 1) {
            return null;
        }
        return (y) (this.f3021s.getNumberOfLayers() > 2 ? this.f3021s.getDrawable(2) : this.f3021s.getDrawable(1));
    }

    public final i b(boolean z10) {
        LayerDrawable layerDrawable = this.f3021s;
        if (layerDrawable == null || layerDrawable.getNumberOfLayers() <= 0) {
            return null;
        }
        return (i) (f3001u ? (LayerDrawable) ((InsetDrawable) this.f3021s.getDrawable(0)).getDrawable() : this.f3021s).getDrawable(z10 ^ true ? 1 : 0);
    }

    public final void c(n nVar) {
        this.f3004b = nVar;
        if (!f3002v || this.f3017o) {
            if (b(false) != null) {
                b(false).setShapeAppearanceModel(nVar);
            }
            if (b(true) != null) {
                b(true).setShapeAppearanceModel(nVar);
            }
            if (a() != null) {
                a().setShapeAppearanceModel(nVar);
                return;
            }
            return;
        }
        WeakHashMap weakHashMap = c1.f10054a;
        MaterialButton materialButton = this.f3003a;
        int f10 = j0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e10 = j0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        e();
        j0.k(materialButton, f10, paddingTop, e10, paddingBottom);
    }

    public final void d(int i10, int i11) {
        WeakHashMap weakHashMap = c1.f10054a;
        MaterialButton materialButton = this.f3003a;
        int f10 = j0.f(materialButton);
        int paddingTop = materialButton.getPaddingTop();
        int e10 = j0.e(materialButton);
        int paddingBottom = materialButton.getPaddingBottom();
        int i12 = this.f3007e;
        int i13 = this.f3008f;
        this.f3008f = i11;
        this.f3007e = i10;
        if (!this.f3017o) {
            e();
        }
        j0.k(materialButton, f10, (paddingTop + i10) - i12, e10, (paddingBottom + i11) - i13);
    }

    /* JADX WARNING: type inference failed for: r4v12, types: [android.graphics.drawable.LayerDrawable, android.graphics.drawable.RippleDrawable] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void e() {
        /*
            r14 = this;
            t8.i r0 = new t8.i
            t8.n r1 = r14.f3004b
            r0.<init>((t8.n) r1)
            com.google.android.material.button.MaterialButton r1 = r14.f3003a
            android.content.Context r2 = r1.getContext()
            r0.i(r2)
            android.content.res.ColorStateList r2 = r14.f3012j
            f0.b.h(r0, r2)
            android.graphics.PorterDuff$Mode r2 = r14.f3011i
            if (r2 == 0) goto L_0x001c
            f0.b.i(r0, r2)
        L_0x001c:
            int r2 = r14.f3010h
            float r2 = (float) r2
            android.content.res.ColorStateList r3 = r14.f3013k
            t8.h r4 = r0.f14744h
            r4.f14733k = r2
            r0.invalidateSelf()
            t8.h r2 = r0.f14744h
            android.content.res.ColorStateList r4 = r2.f14726d
            if (r4 == r3) goto L_0x0037
            r2.f14726d = r3
            int[] r2 = r0.getState()
            r0.onStateChange(r2)
        L_0x0037:
            t8.i r2 = new t8.i
            t8.n r3 = r14.f3004b
            r2.<init>((t8.n) r3)
            r3 = 0
            r2.setTint(r3)
            int r4 = r14.f3010h
            float r4 = (float) r4
            boolean r5 = r14.f3016n
            if (r5 == 0) goto L_0x0051
            r5 = 2130968880(0x7f040130, float:1.7546426E38)
            int r5 = g8.a.b(r1, r5)
            goto L_0x0052
        L_0x0051:
            r5 = 0
        L_0x0052:
            t8.h r6 = r2.f14744h
            r6.f14733k = r4
            r2.invalidateSelf()
            android.content.res.ColorStateList r4 = android.content.res.ColorStateList.valueOf(r5)
            t8.h r5 = r2.f14744h
            android.content.res.ColorStateList r6 = r5.f14726d
            if (r6 == r4) goto L_0x006c
            r5.f14726d = r4
            int[] r4 = r2.getState()
            r2.onStateChange(r4)
        L_0x006c:
            boolean r4 = f3001u
            r5 = 2
            r6 = 1
            if (r4 == 0) goto L_0x00a8
            t8.i r4 = new t8.i
            t8.n r7 = r14.f3004b
            r4.<init>((t8.n) r7)
            r14.f3015m = r4
            r7 = -1
            f0.b.g(r4, r7)
            android.graphics.drawable.RippleDrawable r4 = new android.graphics.drawable.RippleDrawable
            android.content.res.ColorStateList r7 = r14.f3014l
            android.content.res.ColorStateList r7 = r8.d.c(r7)
            android.graphics.drawable.LayerDrawable r9 = new android.graphics.drawable.LayerDrawable
            android.graphics.drawable.Drawable[] r5 = new android.graphics.drawable.Drawable[r5]
            r5[r3] = r2
            r5[r6] = r0
            r9.<init>(r5)
            android.graphics.drawable.InsetDrawable r0 = new android.graphics.drawable.InsetDrawable
            int r10 = r14.f3005c
            int r11 = r14.f3007e
            int r12 = r14.f3006d
            int r13 = r14.f3008f
            r8 = r0
            r8.<init>(r9, r10, r11, r12, r13)
            android.graphics.drawable.Drawable r2 = r14.f3015m
            r4.<init>(r7, r0, r2)
            r14.f3021s = r4
            goto L_0x00da
        L_0x00a8:
            r8.b r4 = new r8.b
            t8.n r7 = r14.f3004b
            r4.<init>((t8.n) r7)
            r14.f3015m = r4
            android.content.res.ColorStateList r7 = r14.f3014l
            android.content.res.ColorStateList r7 = r8.d.c(r7)
            f0.b.h(r4, r7)
            android.graphics.drawable.LayerDrawable r9 = new android.graphics.drawable.LayerDrawable
            r4 = 3
            android.graphics.drawable.Drawable[] r4 = new android.graphics.drawable.Drawable[r4]
            r4[r3] = r2
            r4[r6] = r0
            android.graphics.drawable.Drawable r0 = r14.f3015m
            r4[r5] = r0
            r9.<init>(r4)
            r14.f3021s = r9
            android.graphics.drawable.InsetDrawable r4 = new android.graphics.drawable.InsetDrawable
            int r10 = r14.f3005c
            int r11 = r14.f3007e
            int r12 = r14.f3006d
            int r13 = r14.f3008f
            r8 = r4
            r8.<init>(r9, r10, r11, r12, r13)
        L_0x00da:
            r1.setInternalBackground(r4)
            t8.i r0 = r14.b(r3)
            if (r0 == 0) goto L_0x00f0
            int r2 = r14.f3022t
            float r2 = (float) r2
            r0.j(r2)
            int[] r1 = r1.getDrawableState()
            r0.setState(r1)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: c8.d.e():void");
    }

    public final void f() {
        int i10 = 0;
        i b10 = b(false);
        i b11 = b(true);
        if (b10 != null) {
            ColorStateList colorStateList = this.f3013k;
            b10.f14744h.f14733k = (float) this.f3010h;
            b10.invalidateSelf();
            h hVar = b10.f14744h;
            if (hVar.f14726d != colorStateList) {
                hVar.f14726d = colorStateList;
                b10.onStateChange(b10.getState());
            }
            if (b11 != null) {
                float f10 = (float) this.f3010h;
                if (this.f3016n) {
                    i10 = a.b(this.f3003a, R.attr.colorSurface);
                }
                b11.f14744h.f14733k = f10;
                b11.invalidateSelf();
                ColorStateList valueOf = ColorStateList.valueOf(i10);
                h hVar2 = b11.f14744h;
                if (hVar2.f14726d != valueOf) {
                    hVar2.f14726d = valueOf;
                    b11.onStateChange(b11.getState());
                }
            }
        }
    }
}
