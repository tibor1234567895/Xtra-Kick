package m0;

import android.os.Build;
import android.text.TextUtils;
import android.view.View;

public abstract class g0 {

    /* renamed from: a  reason: collision with root package name */
    public final int f10081a;

    /* renamed from: b  reason: collision with root package name */
    public final Class f10082b;

    /* renamed from: c  reason: collision with root package name */
    public final int f10083c;

    /* renamed from: d  reason: collision with root package name */
    public final int f10084d;

    public g0(int i10, Class cls, int i11, int i12) {
        this.f10081a = i10;
        this.f10082b = cls;
        this.f10084d = i11;
        this.f10083c = i12;
    }

    public static boolean a(Boolean bool, Boolean bool2) {
        return (bool != null && bool.booleanValue()) == (bool2 != null && bool2.booleanValue());
    }

    public final Object b(View view) {
        boolean z10;
        if (Build.VERSION.SDK_INT >= this.f10083c) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            e0 e0Var = (e0) this;
            int i10 = e0Var.f10071e;
            switch (i10) {
                case 0:
                    return e0Var.d(view);
                case 1:
                    switch (i10) {
                        case 1:
                            return u0.b(view);
                        default:
                            return x0.a(view);
                    }
                case 2:
                    switch (i10) {
                        case 1:
                            return u0.b(view);
                        default:
                            return x0.a(view);
                    }
                default:
                    return e0Var.d(view);
            }
        } else {
            Object tag = view.getTag(this.f10081a);
            if (this.f10082b.isInstance(tag)) {
                return tag;
            }
            return null;
        }
    }

    public final void c(View view, Object obj) {
        boolean z10;
        boolean a10;
        c cVar;
        if (Build.VERSION.SDK_INT >= this.f10083c) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            int i10 = ((e0) this).f10071e;
            switch (i10) {
                case 0:
                    Boolean bool = (Boolean) obj;
                    switch (i10) {
                        case 0:
                            u0.i(view, bool.booleanValue());
                            return;
                        default:
                            u0.g(view, bool.booleanValue());
                            return;
                    }
                case 1:
                    CharSequence charSequence = (CharSequence) obj;
                    switch (i10) {
                        case 1:
                            u0.h(view, charSequence);
                            return;
                        default:
                            x0.b(view, charSequence);
                            return;
                    }
                case 2:
                    CharSequence charSequence2 = (CharSequence) obj;
                    switch (i10) {
                        case 1:
                            u0.h(view, charSequence2);
                            return;
                        default:
                            x0.b(view, charSequence2);
                            return;
                    }
                default:
                    Boolean bool2 = (Boolean) obj;
                    switch (i10) {
                        case 0:
                            u0.i(view, bool2.booleanValue());
                            return;
                        default:
                            u0.g(view, bool2.booleanValue());
                            return;
                    }
            }
        } else {
            Object b10 = b(view);
            int i11 = ((e0) this).f10071e;
            switch (i11) {
                case 0:
                    Boolean bool3 = (Boolean) b10;
                    Boolean bool4 = (Boolean) obj;
                    switch (i11) {
                        case 0:
                            a10 = a(bool3, bool4);
                            break;
                        default:
                            a10 = a(bool3, bool4);
                            break;
                    }
                case 1:
                    CharSequence charSequence3 = (CharSequence) b10;
                    CharSequence charSequence4 = (CharSequence) obj;
                    switch (i11) {
                        case 1:
                            a10 = TextUtils.equals(charSequence3, charSequence4);
                            break;
                        default:
                            a10 = TextUtils.equals(charSequence3, charSequence4);
                            break;
                    }
                case 2:
                    CharSequence charSequence5 = (CharSequence) b10;
                    CharSequence charSequence6 = (CharSequence) obj;
                    switch (i11) {
                        case 1:
                            a10 = TextUtils.equals(charSequence5, charSequence6);
                            break;
                        default:
                            a10 = TextUtils.equals(charSequence5, charSequence6);
                            break;
                    }
                default:
                    Boolean bool5 = (Boolean) b10;
                    Boolean bool6 = (Boolean) obj;
                    switch (i11) {
                        case 0:
                            a10 = a(bool5, bool6);
                            break;
                        default:
                            a10 = a(bool5, bool6);
                            break;
                    }
            }
            if (!a10) {
                View.AccessibilityDelegate c10 = c1.c(view);
                if (c10 == null) {
                    cVar = null;
                } else if (c10 instanceof a) {
                    cVar = ((a) c10).f10038a;
                } else {
                    cVar = new c(c10);
                }
                if (cVar == null) {
                    cVar = new c();
                }
                c1.p(view, cVar);
                view.setTag(this.f10081a, obj);
                c1.i(view, this.f10084d);
            }
        }
    }
}
