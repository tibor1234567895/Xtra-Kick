package androidx.activity.result;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.SparseArray;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.u4;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.datepicker.r;
import d2.k;
import j1.a;
import j1.b0;
import j1.h0;
import j1.l0;
import java.util.ArrayList;
import m0.q2;
import m0.y;
import u2.v;
import x.m;
import x.p;
import y8.n;

public final class j implements k, y {

    /* renamed from: h  reason: collision with root package name */
    public int f517h;

    /* renamed from: i  reason: collision with root package name */
    public int f518i;

    /* renamed from: j  reason: collision with root package name */
    public final Object f519j;

    /* renamed from: k  reason: collision with root package name */
    public Object f520k;

    public j(int i10) {
        this.f519j = new v[i10];
        this.f518i = 0;
    }

    public final q2 A(View view, q2 q2Var) {
        int i10 = q2Var.a(7).f4857b;
        int i11 = this.f517h;
        Object obj = this.f519j;
        if (i11 >= 0) {
            View view2 = (View) obj;
            view2.getLayoutParams().height = this.f517h + i10;
            view2.setLayoutParams(view2.getLayoutParams());
        }
        View view3 = (View) obj;
        view3.setPadding(view3.getPaddingLeft(), this.f518i + i10, view3.getPaddingRight(), view3.getPaddingBottom());
        return q2Var;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0096, code lost:
        if (r13 == -9223372036854775807L) goto L_0x00a2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return d2.j.f4204d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return new d2.j(-2, r13, r5 + r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final d2.j h(d2.w r18, long r19) {
        /*
            r17 = this;
            r0 = r17
            long r5 = r18.p()
            int r1 = r0.f518i
            long r1 = (long) r1
            long r3 = r18.c()
            long r3 = r3 - r5
            long r1 = java.lang.Math.min(r1, r3)
            int r2 = (int) r1
            java.lang.Object r1 = r0.f520k
            j1.b0 r1 = (j1.b0) r1
            r1.D(r2)
            java.lang.Object r1 = r0.f520k
            j1.b0 r1 = (j1.b0) r1
            byte[] r1 = r1.f8414a
            r3 = 0
            r4 = r18
            r4.m(r1, r3, r2)
            java.lang.Object r1 = r0.f520k
            j1.b0 r1 = (j1.b0) r1
            int r2 = r1.f8416c
            r3 = -1
            r9 = r3
            r13 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
        L_0x0034:
            int r11 = r1.f8416c
            int r12 = r1.f8415b
            int r11 = r11 - r12
            r15 = 188(0xbc, float:2.63E-43)
            if (r11 < r15) goto L_0x008f
            byte[] r11 = r1.f8414a
        L_0x003f:
            if (r12 >= r2) goto L_0x004a
            byte r15 = r11[r12]
            r7 = 71
            if (r15 == r7) goto L_0x004a
            int r12 = r12 + 1
            goto L_0x003f
        L_0x004a:
            int r7 = r12 + 188
            if (r7 <= r2) goto L_0x004f
            goto L_0x008f
        L_0x004f:
            int r3 = r0.f517h
            long r3 = f3.l0.a(r12, r3, r1)
            r15 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r8 = (r3 > r15 ? 1 : (r3 == r15 ? 0 : -1))
            if (r8 == 0) goto L_0x008a
            java.lang.Object r8 = r0.f519j
            j1.h0 r8 = (j1.h0) r8
            long r3 = r8.b(r3)
            int r8 = (r3 > r19 ? 1 : (r3 == r19 ? 0 : -1))
            if (r8 <= 0) goto L_0x0078
            int r1 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r1 != 0) goto L_0x0076
            d2.j r7 = new d2.j
            r2 = -1
            r1 = r7
            r1.<init>(r2, r3, r5)
            goto L_0x00a4
        L_0x0076:
            long r5 = r5 + r9
            goto L_0x0082
        L_0x0078:
            r8 = 100000(0x186a0, double:4.94066E-319)
            long r8 = r8 + r3
            int r10 = (r8 > r19 ? 1 : (r8 == r19 ? 0 : -1))
            if (r10 <= 0) goto L_0x0087
            long r1 = (long) r12
            long r5 = r5 + r1
        L_0x0082:
            d2.j r7 = d2.j.a(r5)
            goto L_0x00a4
        L_0x0087:
            long r8 = (long) r12
            r13 = r3
            r9 = r8
        L_0x008a:
            r1.G(r7)
            long r3 = (long) r7
            goto L_0x0034
        L_0x008f:
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r13 > r1 ? 1 : (r13 == r1 ? 0 : -1))
            if (r7 == 0) goto L_0x00a2
            long r15 = r5 + r3
            d2.j r7 = new d2.j
            r12 = -2
            r11 = r7
            r11.<init>(r12, r13, r15)
            goto L_0x00a4
        L_0x00a2:
            d2.j r7 = d2.j.f4204d
        L_0x00a4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.activity.result.j.h(d2.w, long):d2.j");
    }

    public final void i() {
        b0 b0Var = (b0) this.f520k;
        byte[] bArr = l0.f8458f;
        b0Var.getClass();
        b0Var.E(bArr.length, bArr);
    }

    public j(int i10, h0 h0Var, int i11) {
        this.f517h = i10;
        this.f519j = h0Var;
        this.f518i = i11;
        this.f520k = new b0();
    }

    public j(int i10, float[] fArr, float[] fArr2, int i11) {
        this.f517h = i10;
        a.b(((long) fArr.length) * 2 == ((long) fArr2.length) * 3);
        this.f519j = fArr;
        this.f520k = fArr2;
        this.f518i = i11;
    }

    public j(Context context, XmlResourceParser xmlResourceParser) {
        this.f519j = new ArrayList();
        this.f518i = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), p.f16505h);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i10 = 0; i10 < indexCount; i10++) {
            int index = obtainStyledAttributes.getIndex(i10);
            if (index == 0) {
                this.f517h = obtainStyledAttributes.getResourceId(index, this.f517h);
            } else if (index == 1) {
                this.f518i = obtainStyledAttributes.getResourceId(index, this.f518i);
                String resourceTypeName = context.getResources().getResourceTypeName(this.f518i);
                context.getResources().getResourceName(this.f518i);
                if ("layout".equals(resourceTypeName)) {
                    m mVar = new m();
                    this.f520k = mVar;
                    mVar.b((ConstraintLayout) LayoutInflater.from(context).inflate(this.f518i, (ViewGroup) null));
                }
            }
        }
        obtainStyledAttributes.recycle();
    }

    public j(j jVar) {
        Object obj = jVar.f519j;
        this.f517h = ((float[]) obj).length / 3;
        this.f519j = j1.m.d((float[]) obj);
        this.f520k = j1.m.d((float[]) jVar.f520k);
        int i10 = jVar.f518i;
        this.f518i = i10 != 1 ? i10 != 2 ? 4 : 6 : 5;
    }

    public j(r rVar, int i10, View view, int i11) {
        this.f520k = rVar;
        this.f517h = i10;
        this.f519j = view;
        this.f518i = i11;
    }

    public j(String str, int i10, int i11) {
        this.f519j = str;
        this.f517h = i10;
        this.f518i = i11;
        this.f520k = new float[16];
    }

    public j(n nVar, u4 u4Var) {
        this.f519j = new SparseArray();
        this.f520k = nVar;
        this.f517h = u4Var.i(26, 0);
        this.f518i = u4Var.i(50, 0);
    }
}
