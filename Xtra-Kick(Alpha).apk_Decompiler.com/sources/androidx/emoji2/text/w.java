package androidx.emoji2.text;

import android.text.Editable;
import android.text.Selection;
import android.view.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import l.h;
import la.v;
import ma.z;
import n3.m4;
import wa.l;
import xa.j;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1294a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f1295b;

    /* renamed from: c  reason: collision with root package name */
    public Object f1296c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f1297d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f1298e;

    public w(h hVar, o oVar, g gVar) {
        this.f1295b = oVar;
        this.f1296c = hVar;
        this.f1297d = gVar;
        this.f1294a = false;
        this.f1298e = null;
    }

    public static boolean a(Editable editable, KeyEvent keyEvent, boolean z10) {
        boolean z11;
        g0[] g0VarArr;
        if (!KeyEvent.metaStateHasNoModifiers(keyEvent.getMetaState())) {
            return false;
        }
        int selectionStart = Selection.getSelectionStart(editable);
        int selectionEnd = Selection.getSelectionEnd(editable);
        if (selectionStart == -1 || selectionEnd == -1 || selectionStart != selectionEnd) {
            z11 = true;
        } else {
            z11 = false;
        }
        if (!z11 && (g0VarArr = (g0[]) editable.getSpans(selectionStart, selectionEnd, g0.class)) != null && g0VarArr.length > 0) {
            int length = g0VarArr.length;
            int i10 = 0;
            while (i10 < length) {
                g0 g0Var = g0VarArr[i10];
                int spanStart = editable.getSpanStart(g0Var);
                int spanEnd = editable.getSpanEnd(g0Var);
                if ((!z10 || spanStart != selectionStart) && ((z10 || spanEnd != selectionStart) && (selectionStart <= spanStart || selectionStart >= spanEnd))) {
                    i10++;
                } else {
                    editable.delete(spanStart, spanEnd);
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b7, code lost:
        if (r6 >= r7) goto L_0x00b9;
     */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0102  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0104  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean b(java.lang.CharSequence r10, int r11, int r12, androidx.emoji2.text.u r13) {
        /*
            r9 = this;
            int r0 = r13.f1285c
            r1 = 2
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x0107
            java.lang.Object r0 = r9.f1297d
            androidx.emoji2.text.k r0 = (androidx.emoji2.text.k) r0
            v0.a r4 = r13.d()
            r5 = 8
            int r5 = r4.a(r5)
            if (r5 == 0) goto L_0x0021
            java.nio.ByteBuffer r6 = r4.f15552b
            int r4 = r4.f15551a
            int r5 = r5 + r4
            short r4 = r6.getShort(r5)
            goto L_0x0022
        L_0x0021:
            r4 = 0
        L_0x0022:
            androidx.emoji2.text.g r0 = (androidx.emoji2.text.g) r0
            r0.getClass()
            int r5 = android.os.Build.VERSION.SDK_INT
            r6 = 23
            if (r5 >= r6) goto L_0x0031
            if (r4 <= r5) goto L_0x0031
            goto L_0x00b9
        L_0x0031:
            java.lang.ThreadLocal r4 = androidx.emoji2.text.g.f1253b
            java.lang.Object r5 = r4.get()
            if (r5 != 0) goto L_0x0041
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r4.set(r5)
        L_0x0041:
            java.lang.Object r4 = r4.get()
            java.lang.StringBuilder r4 = (java.lang.StringBuilder) r4
            r4.setLength(r2)
        L_0x004a:
            if (r11 >= r12) goto L_0x0056
            char r5 = r10.charAt(r11)
            r4.append(r5)
            int r11 = r11 + 1
            goto L_0x004a
        L_0x0056:
            android.text.TextPaint r10 = r0.f1254a
            java.lang.String r11 = r4.toString()
            java.lang.ThreadLocal r12 = e0.f.f4860a
            int r12 = android.os.Build.VERSION.SDK_INT
            if (r12 < r6) goto L_0x0068
            boolean r10 = e0.e.a(r10, r11)
            goto L_0x0100
        L_0x0068:
            int r12 = r11.length()
            if (r12 != r3) goto L_0x0079
            char r0 = r11.charAt(r2)
            boolean r0 = java.lang.Character.isWhitespace(r0)
            if (r0 == 0) goto L_0x0079
            goto L_0x00bf
        L_0x0079:
            java.lang.String r0 = "󟿽"
            float r4 = r10.measureText(r0)
            java.lang.String r5 = "m"
            float r5 = r10.measureText(r5)
            float r6 = r10.measureText(r11)
            r7 = 0
            int r8 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r8 != 0) goto L_0x008f
            goto L_0x00b9
        L_0x008f:
            int r8 = r11.length()
            int r8 = r11.codePointCount(r2, r8)
            if (r8 <= r3) goto L_0x00bb
            r8 = 1073741824(0x40000000, float:2.0)
            float r5 = r5 * r8
            int r5 = (r6 > r5 ? 1 : (r6 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a2
            goto L_0x00b9
        L_0x00a2:
            r5 = 0
        L_0x00a3:
            if (r5 >= r12) goto L_0x00b5
            int r8 = r11.codePointAt(r5)
            int r8 = java.lang.Character.charCount(r8)
            int r8 = r8 + r5
            float r5 = r10.measureText(r11, r5, r8)
            float r7 = r7 + r5
            r5 = r8
            goto L_0x00a3
        L_0x00b5:
            int r5 = (r6 > r7 ? 1 : (r6 == r7 ? 0 : -1))
            if (r5 < 0) goto L_0x00bb
        L_0x00b9:
            r10 = 0
            goto L_0x0100
        L_0x00bb:
            int r4 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r4 == 0) goto L_0x00c1
        L_0x00bf:
            r10 = 1
            goto L_0x0100
        L_0x00c1:
            java.lang.ThreadLocal r4 = e0.f.f4860a
            java.lang.Object r5 = r4.get()
            l0.c r5 = (l0.c) r5
            if (r5 != 0) goto L_0x00de
            l0.c r5 = new l0.c
            android.graphics.Rect r6 = new android.graphics.Rect
            r6.<init>()
            android.graphics.Rect r7 = new android.graphics.Rect
            r7.<init>()
            r5.<init>(r6, r7)
            r4.set(r5)
            goto L_0x00ec
        L_0x00de:
            java.lang.Object r4 = r5.f9498a
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            r4.setEmpty()
            java.lang.Object r4 = r5.f9499b
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            r4.setEmpty()
        L_0x00ec:
            java.lang.Object r4 = r5.f9498a
            android.graphics.Rect r4 = (android.graphics.Rect) r4
            r10.getTextBounds(r0, r2, r1, r4)
            java.lang.Object r0 = r5.f9499b
            r5 = r0
            android.graphics.Rect r5 = (android.graphics.Rect) r5
            r10.getTextBounds(r11, r2, r12, r5)
            boolean r10 = r4.equals(r0)
            r10 = r10 ^ r3
        L_0x0100:
            if (r10 == 0) goto L_0x0104
            r10 = 2
            goto L_0x0105
        L_0x0104:
            r10 = 1
        L_0x0105:
            r13.f1285c = r10
        L_0x0107:
            int r10 = r13.f1285c
            if (r10 != r1) goto L_0x010c
            r2 = 1
        L_0x010c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.w.b(java.lang.CharSequence, int, int, androidx.emoji2.text.u):boolean");
    }

    public final void c() {
        if (!this.f1294a) {
            ReentrantLock reentrantLock = (ReentrantLock) this.f1297d;
            reentrantLock.lock();
            try {
                if (!this.f1294a) {
                    this.f1294a = true;
                    Object obj = this.f1298e;
                    List<Object> J = z.J((List) obj);
                    ((List) obj).clear();
                    v vVar = v.f9814a;
                    reentrantLock.unlock();
                    if (J != null) {
                        l lVar = (l) this.f1295b;
                        for (Object invoke : J) {
                            lVar.invoke(invoke);
                        }
                    }
                }
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public w(m4 m4Var) {
        j.f("callbackInvoker", m4Var);
        this.f1295b = m4Var;
        this.f1296c = null;
        this.f1297d = new ReentrantLock();
        this.f1298e = new ArrayList();
    }
}
