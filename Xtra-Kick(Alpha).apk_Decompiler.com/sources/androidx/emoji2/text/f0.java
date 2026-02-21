package androidx.emoji2.text;

import android.text.Editable;
import android.text.SpannableStringBuilder;
import java.lang.reflect.Array;
import java.util.ArrayList;

public final class f0 extends SpannableStringBuilder {

    /* renamed from: h  reason: collision with root package name */
    public final Class f1251h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f1252i = new ArrayList();

    public f0(Class cls, CharSequence charSequence) {
        super(charSequence);
        if (cls != null) {
            this.f1251h = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    public final void a() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f1252i;
            if (i10 < arrayList.size()) {
                ((e0) arrayList.get(i10)).f1250i.incrementAndGet();
                i10++;
            } else {
                return;
            }
        }
    }

    public final Editable append(char c10) {
        super.append(c10);
        return this;
    }

    public final void b() {
        e();
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f1252i;
            if (i10 < arrayList.size()) {
                ((e0) arrayList.get(i10)).onTextChanged(this, 0, length(), length());
                i10++;
            } else {
                return;
            }
        }
    }

    public final e0 c(Object obj) {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f1252i;
            if (i10 >= arrayList.size()) {
                return null;
            }
            e0 e0Var = (e0) arrayList.get(i10);
            if (e0Var.f1249h == obj) {
                return e0Var;
            }
            i10++;
        }
    }

    public final boolean d(Object obj) {
        boolean z10;
        if (obj == null) {
            return false;
        }
        if (this.f1251h == obj.getClass()) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            return true;
        }
        return false;
    }

    public final Editable delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    public final void e() {
        int i10 = 0;
        while (true) {
            ArrayList arrayList = this.f1252i;
            if (i10 < arrayList.size()) {
                ((e0) arrayList.get(i10)).f1250i.decrementAndGet();
                i10++;
            } else {
                return;
            }
        }
    }

    public final int getSpanEnd(Object obj) {
        e0 c10;
        if (d(obj) && (c10 = c(obj)) != null) {
            obj = c10;
        }
        return super.getSpanEnd(obj);
    }

    public final int getSpanFlags(Object obj) {
        e0 c10;
        if (d(obj) && (c10 = c(obj)) != null) {
            obj = c10;
        }
        return super.getSpanFlags(obj);
    }

    public final int getSpanStart(Object obj) {
        e0 c10;
        if (d(obj) && (c10 = c(obj)) != null) {
            obj = c10;
        }
        return super.getSpanStart(obj);
    }

    public final Object[] getSpans(int i10, int i11, Class cls) {
        boolean z10;
        if (this.f1251h == cls) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            return super.getSpans(i10, i11, cls);
        }
        e0[] e0VarArr = (e0[]) super.getSpans(i10, i11, e0.class);
        Object[] objArr = (Object[]) Array.newInstance(cls, e0VarArr.length);
        for (int i12 = 0; i12 < e0VarArr.length; i12++) {
            objArr[i12] = e0VarArr[i12].f1249h;
        }
        return objArr;
    }

    public final Editable insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0009, code lost:
        if (r0 != false) goto L_0x000b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int nextSpanTransition(int r2, int r3, java.lang.Class<androidx.emoji2.text.e0> r4) {
        /*
            r1 = this;
            if (r4 == 0) goto L_0x000b
            java.lang.Class r0 = r1.f1251h
            if (r0 != r4) goto L_0x0008
            r0 = 1
            goto L_0x0009
        L_0x0008:
            r0 = 0
        L_0x0009:
            if (r0 == 0) goto L_0x000d
        L_0x000b:
            java.lang.Class<androidx.emoji2.text.e0> r4 = androidx.emoji2.text.e0.class
        L_0x000d:
            int r2 = super.nextSpanTransition(r2, r3, r4)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.emoji2.text.f0.nextSpanTransition(int, int, java.lang.Class):int");
    }

    public final void removeSpan(Object obj) {
        e0 e0Var;
        if (d(obj)) {
            e0Var = c(obj);
            if (e0Var != null) {
                obj = e0Var;
            }
        } else {
            e0Var = null;
        }
        super.removeSpan(obj);
        if (e0Var != null) {
            this.f1252i.remove(e0Var);
        }
    }

    public final void setSpan(Object obj, int i10, int i11, int i12) {
        if (d(obj)) {
            e0 e0Var = new e0(obj);
            this.f1252i.add(e0Var);
            obj = e0Var;
        }
        super.setSpan(obj, i10, i11, i12);
    }

    public final CharSequence subSequence(int i10, int i11) {
        return new f0(this.f1251h, this, i10, i11);
    }

    public f0(Class cls, CharSequence charSequence, int i10, int i11) {
        super(charSequence, i10, i11);
        if (cls != null) {
            this.f1251h = cls;
            return;
        }
        throw new NullPointerException("watcherClass cannot be null");
    }

    public final Editable append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    /* renamed from: delete  reason: collision with other method in class */
    public final SpannableStringBuilder m6delete(int i10, int i11) {
        super.delete(i10, i11);
        return this;
    }

    public final Editable insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    public final Editable append(CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    /* renamed from: insert  reason: collision with other method in class */
    public final SpannableStringBuilder m7insert(int i10, CharSequence charSequence) {
        super.insert(i10, charSequence);
        return this;
    }

    public final SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence) {
        a();
        super.replace(i10, i11, charSequence);
        e();
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final SpannableStringBuilder m0append(char c10) {
        super.append(c10);
        return this;
    }

    /* renamed from: insert  reason: collision with other method in class */
    public final SpannableStringBuilder m8insert(int i10, CharSequence charSequence, int i11, int i12) {
        super.insert(i10, charSequence, i11, i12);
        return this;
    }

    public final SpannableStringBuilder replace(int i10, int i11, CharSequence charSequence, int i12, int i13) {
        a();
        super.replace(i10, i11, charSequence, i12, i13);
        e();
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final SpannableStringBuilder m1append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final SpannableStringBuilder m2append(CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }

    public final SpannableStringBuilder append(CharSequence charSequence, Object obj, int i10) {
        super.append(charSequence, obj, i10);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final Appendable m3append(char c10) {
        super.append(c10);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final Appendable m4append(CharSequence charSequence) {
        super.append(charSequence);
        return this;
    }

    /* renamed from: append  reason: collision with other method in class */
    public final Appendable m5append(CharSequence charSequence, int i10, int i11) {
        super.append(charSequence, i10, i11);
        return this;
    }
}
