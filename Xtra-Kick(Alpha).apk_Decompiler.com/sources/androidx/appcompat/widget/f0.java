package androidx.appcompat.widget;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.widget.CheckedTextView;
import android.widget.CompoundButton;
import android.widget.TextView;
import f0.b;
import q0.d;

public final class f0 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f812a;

    /* renamed from: b  reason: collision with root package name */
    public ColorStateList f813b = null;

    /* renamed from: c  reason: collision with root package name */
    public PorterDuff.Mode f814c = null;

    /* renamed from: d  reason: collision with root package name */
    public boolean f815d = false;

    /* renamed from: e  reason: collision with root package name */
    public boolean f816e = false;

    /* renamed from: f  reason: collision with root package name */
    public boolean f817f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f818g;

    public /* synthetic */ f0(TextView textView, int i10) {
        this.f812a = i10;
        this.f818g = textView;
    }

    public final void a() {
        TextView textView = this.f818g;
        Drawable a10 = d.a((CompoundButton) textView);
        if (a10 == null) {
            return;
        }
        if (this.f815d || this.f816e) {
            Drawable mutate = f0.d.g(a10).mutate();
            if (this.f815d) {
                b.h(mutate, this.f813b);
            }
            if (this.f816e) {
                b.i(mutate, this.f814c);
            }
            if (mutate.isStateful()) {
                mutate.setState(((CompoundButton) textView).getDrawableState());
            }
            ((CompoundButton) textView).setButtonDrawable(mutate);
        }
    }

    public final void b() {
        TextView textView = this.f818g;
        Drawable checkMarkDrawable = ((CheckedTextView) textView).getCheckMarkDrawable();
        if (checkMarkDrawable == null) {
            return;
        }
        if (this.f815d || this.f816e) {
            Drawable mutate = f0.d.g(checkMarkDrawable).mutate();
            if (this.f815d) {
                b.h(mutate, this.f813b);
            }
            if (this.f816e) {
                b.i(mutate, this.f814c);
            }
            if (mutate.isStateful()) {
                mutate.setState(((CheckedTextView) textView).getDrawableState());
            }
            ((CheckedTextView) textView).setCheckMarkDrawable(mutate);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0051 A[SYNTHETIC, Splitter:B:14:0x0051] */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0074 A[Catch:{ all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084 A[Catch:{ all -> 0x0095 }] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00d6 A[SYNTHETIC, Splitter:B:43:0x00d6] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00f9 A[Catch:{ all -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0109 A[Catch:{ all -> 0x011a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(android.util.AttributeSet r17, int r18) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            r7 = r18
            r8 = 0
            int r2 = r1.f812a
            r9 = -1
            r10 = 3
            r11 = 2
            r12 = 1
            android.widget.TextView r13 = r1.f818g
            r14 = 0
            switch(r2) {
                case 0: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x009a
        L_0x0015:
            r2 = r13
            android.widget.CheckedTextView r2 = (android.widget.CheckedTextView) r2
            android.content.Context r3 = r2.getContext()
            int[] r4 = f.a.f5403m
            androidx.appcompat.widget.u4 r15 = androidx.appcompat.widget.u4.m(r3, r0, r4, r7)
            android.content.Context r3 = r2.getContext()
            android.content.res.TypedArray r6 = r15.f1100b
            r5 = r17
            r7 = r18
            m0.c1.o(r2, r3, r4, r5, r6, r7)
            boolean r0 = r15.l(r12)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x004e
            int r0 = r15.i(r12, r14)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x004e
            r2 = r13
            android.widget.CheckedTextView r2 = (android.widget.CheckedTextView) r2     // Catch:{ NotFoundException -> 0x004d }
            r3 = r13
            android.widget.CheckedTextView r3 = (android.widget.CheckedTextView) r3     // Catch:{ NotFoundException -> 0x004d }
            android.content.Context r3 = r3.getContext()     // Catch:{ NotFoundException -> 0x004d }
            android.graphics.drawable.Drawable r0 = h.a.a(r3, r0)     // Catch:{ NotFoundException -> 0x004d }
            r2.setCheckMarkDrawable(r0)     // Catch:{ NotFoundException -> 0x004d }
            goto L_0x004f
        L_0x004d:
        L_0x004e:
            r12 = 0
        L_0x004f:
            if (r12 != 0) goto L_0x006e
            boolean r0 = r15.l(r14)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x006e
            int r0 = r15.i(r14, r14)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x006e
            r2 = r13
            android.widget.CheckedTextView r2 = (android.widget.CheckedTextView) r2     // Catch:{ all -> 0x0095 }
            r3 = r13
            android.widget.CheckedTextView r3 = (android.widget.CheckedTextView) r3     // Catch:{ all -> 0x0095 }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x0095 }
            android.graphics.drawable.Drawable r0 = h.a.a(r3, r0)     // Catch:{ all -> 0x0095 }
            r2.setCheckMarkDrawable(r0)     // Catch:{ all -> 0x0095 }
        L_0x006e:
            boolean r0 = r15.l(r11)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x007e
            r0 = r13
            android.widget.CheckedTextView r0 = (android.widget.CheckedTextView) r0     // Catch:{ all -> 0x0095 }
            android.content.res.ColorStateList r2 = r15.b(r11)     // Catch:{ all -> 0x0095 }
            r0.setCheckMarkTintList(r2)     // Catch:{ all -> 0x0095 }
        L_0x007e:
            boolean r0 = r15.l(r10)     // Catch:{ all -> 0x0095 }
            if (r0 == 0) goto L_0x0091
            android.widget.CheckedTextView r13 = (android.widget.CheckedTextView) r13     // Catch:{ all -> 0x0095 }
            int r0 = r15.h(r10, r9)     // Catch:{ all -> 0x0095 }
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.i2.d(r0, r8)     // Catch:{ all -> 0x0095 }
            r13.setCheckMarkTintMode(r0)     // Catch:{ all -> 0x0095 }
        L_0x0091:
            r15.n()
            return
        L_0x0095:
            r0 = move-exception
            r15.n()
            throw r0
        L_0x009a:
            r2 = r13
            android.widget.CompoundButton r2 = (android.widget.CompoundButton) r2
            android.content.Context r3 = r2.getContext()
            int[] r4 = f.a.f5404n
            androidx.appcompat.widget.u4 r15 = androidx.appcompat.widget.u4.m(r3, r0, r4, r7)
            android.content.Context r3 = r2.getContext()
            android.content.res.TypedArray r6 = r15.f1100b
            r5 = r17
            r7 = r18
            m0.c1.o(r2, r3, r4, r5, r6, r7)
            boolean r0 = r15.l(r12)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x00d3
            int r0 = r15.i(r12, r14)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x00d3
            r2 = r13
            android.widget.CompoundButton r2 = (android.widget.CompoundButton) r2     // Catch:{ NotFoundException -> 0x00d2 }
            r3 = r13
            android.widget.CompoundButton r3 = (android.widget.CompoundButton) r3     // Catch:{ NotFoundException -> 0x00d2 }
            android.content.Context r3 = r3.getContext()     // Catch:{ NotFoundException -> 0x00d2 }
            android.graphics.drawable.Drawable r0 = h.a.a(r3, r0)     // Catch:{ NotFoundException -> 0x00d2 }
            r2.setButtonDrawable(r0)     // Catch:{ NotFoundException -> 0x00d2 }
            goto L_0x00d4
        L_0x00d2:
        L_0x00d3:
            r12 = 0
        L_0x00d4:
            if (r12 != 0) goto L_0x00f3
            boolean r0 = r15.l(r14)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x00f3
            int r0 = r15.i(r14, r14)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x00f3
            r2 = r13
            android.widget.CompoundButton r2 = (android.widget.CompoundButton) r2     // Catch:{ all -> 0x011a }
            r3 = r13
            android.widget.CompoundButton r3 = (android.widget.CompoundButton) r3     // Catch:{ all -> 0x011a }
            android.content.Context r3 = r3.getContext()     // Catch:{ all -> 0x011a }
            android.graphics.drawable.Drawable r0 = h.a.a(r3, r0)     // Catch:{ all -> 0x011a }
            r2.setButtonDrawable(r0)     // Catch:{ all -> 0x011a }
        L_0x00f3:
            boolean r0 = r15.l(r11)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x0103
            r0 = r13
            android.widget.CompoundButton r0 = (android.widget.CompoundButton) r0     // Catch:{ all -> 0x011a }
            android.content.res.ColorStateList r2 = r15.b(r11)     // Catch:{ all -> 0x011a }
            q0.b.c(r0, r2)     // Catch:{ all -> 0x011a }
        L_0x0103:
            boolean r0 = r15.l(r10)     // Catch:{ all -> 0x011a }
            if (r0 == 0) goto L_0x0116
            android.widget.CompoundButton r13 = (android.widget.CompoundButton) r13     // Catch:{ all -> 0x011a }
            int r0 = r15.h(r10, r9)     // Catch:{ all -> 0x011a }
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.i2.d(r0, r8)     // Catch:{ all -> 0x011a }
            q0.b.d(r13, r0)     // Catch:{ all -> 0x011a }
        L_0x0116:
            r15.n()
            return
        L_0x011a:
            r0 = move-exception
            r15.n()
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.f0.c(android.util.AttributeSet, int):void");
    }
}
