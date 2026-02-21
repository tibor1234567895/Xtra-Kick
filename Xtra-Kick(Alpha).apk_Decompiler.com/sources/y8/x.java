package y8;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import com.google.android.material.textfield.TextInputLayout;
import m0.c;

public final class x extends c {

    /* renamed from: d  reason: collision with root package name */
    public final TextInputLayout f17234d;

    public x(TextInputLayout textInputLayout) {
        this.f17234d = textInputLayout;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0098, code lost:
        if (r7 != null) goto L_0x009a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d(android.view.View r18, n0.i r19) {
        /*
            r17 = this;
            r0 = r17
            r1 = r19
            android.view.View$AccessibilityDelegate r2 = r0.f10052a
            android.view.accessibility.AccessibilityNodeInfo r3 = r1.f10916a
            r4 = r18
            r2.onInitializeAccessibilityNodeInfo(r4, r3)
            com.google.android.material.textfield.TextInputLayout r2 = r0.f17234d
            android.widget.EditText r4 = r2.getEditText()
            if (r4 == 0) goto L_0x001a
            android.text.Editable r4 = r4.getText()
            goto L_0x001b
        L_0x001a:
            r4 = 0
        L_0x001b:
            java.lang.CharSequence r5 = r2.getHint()
            java.lang.CharSequence r6 = r2.getError()
            java.lang.CharSequence r7 = r2.getPlaceholderText()
            int r8 = r2.getCounterMaxLength()
            java.lang.CharSequence r9 = r2.getCounterOverflowDescription()
            boolean r10 = android.text.TextUtils.isEmpty(r4)
            r11 = 1
            r10 = r10 ^ r11
            boolean r12 = android.text.TextUtils.isEmpty(r5)
            r12 = r12 ^ r11
            boolean r13 = r2.f3925y0
            r13 = r13 ^ r11
            boolean r14 = android.text.TextUtils.isEmpty(r6)
            r14 = r14 ^ r11
            if (r14 != 0) goto L_0x004d
            boolean r15 = android.text.TextUtils.isEmpty(r9)
            if (r15 != 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            r15 = 0
            goto L_0x004e
        L_0x004d:
            r15 = 1
        L_0x004e:
            if (r12 == 0) goto L_0x0055
            java.lang.String r5 = r5.toString()
            goto L_0x0057
        L_0x0055:
            java.lang.String r5 = ""
        L_0x0057:
            y8.v r12 = r2.f3892i
            androidx.appcompat.widget.t1 r11 = r12.f17223i
            int r16 = r11.getVisibility()
            if (r16 != 0) goto L_0x0065
            r3.setLabelFor(r11)
            goto L_0x0067
        L_0x0065:
            com.google.android.material.internal.CheckableImageButton r11 = r12.f17225k
        L_0x0067:
            int r12 = android.os.Build.VERSION.SDK_INT
            r0 = 22
            if (r12 < r0) goto L_0x0070
            r3.setTraversalAfter(r11)
        L_0x0070:
            java.lang.String r0 = ", "
            if (r10 == 0) goto L_0x0078
            r1.l(r4)
            goto L_0x009d
        L_0x0078:
            boolean r11 = android.text.TextUtils.isEmpty(r5)
            if (r11 != 0) goto L_0x0098
            r1.l(r5)
            if (r13 == 0) goto L_0x009d
            if (r7 == 0) goto L_0x009d
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r5)
            r11.append(r0)
            r11.append(r7)
            java.lang.String r7 = r11.toString()
            goto L_0x009a
        L_0x0098:
            if (r7 == 0) goto L_0x009d
        L_0x009a:
            r1.l(r7)
        L_0x009d:
            boolean r7 = android.text.TextUtils.isEmpty(r5)
            if (r7 != 0) goto L_0x00cf
            r7 = 26
            if (r12 < r7) goto L_0x00ac
            r1.j(r5)
        L_0x00aa:
            r0 = 1
            goto L_0x00c4
        L_0x00ac:
            if (r10 == 0) goto L_0x00c0
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r4)
            r11.append(r0)
            r11.append(r5)
            java.lang.String r5 = r11.toString()
        L_0x00c0:
            r1.l(r5)
            goto L_0x00aa
        L_0x00c4:
            r0 = r0 ^ r10
            if (r12 < r7) goto L_0x00cb
            r3.setShowingHintText(r0)
            goto L_0x00cf
        L_0x00cb:
            r5 = 4
            r1.g(r5, r0)
        L_0x00cf:
            if (r4 == 0) goto L_0x00d8
            int r0 = r4.length()
            if (r0 != r8) goto L_0x00d8
            goto L_0x00d9
        L_0x00d8:
            r8 = -1
        L_0x00d9:
            r3.setMaxTextLength(r8)
            if (r15 == 0) goto L_0x00e5
            if (r14 == 0) goto L_0x00e1
            goto L_0x00e2
        L_0x00e1:
            r6 = r9
        L_0x00e2:
            r3.setError(r6)
        L_0x00e5:
            y8.r r0 = r2.f3908q
            androidx.appcompat.widget.t1 r0 = r0.f17207y
            if (r0 == 0) goto L_0x00ee
            r3.setLabelFor(r0)
        L_0x00ee:
            y8.n r0 = r2.f3894j
            y8.o r0 = r0.b()
            r0.n(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: y8.x.d(android.view.View, n0.i):void");
    }

    public final void e(View view, AccessibilityEvent accessibilityEvent) {
        super.e(view, accessibilityEvent);
        this.f17234d.f3894j.b().o(accessibilityEvent);
    }
}
