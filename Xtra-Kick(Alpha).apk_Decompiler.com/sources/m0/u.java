package m0;

import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class u {

    /* renamed from: a  reason: collision with root package name */
    public ViewParent f10139a;

    /* renamed from: b  reason: collision with root package name */
    public ViewParent f10140b;

    /* renamed from: c  reason: collision with root package name */
    public final View f10141c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f10142d;

    /* renamed from: e  reason: collision with root package name */
    public int[] f10143e;

    public u(View view) {
        this.f10141c = view;
    }

    public final boolean a(float f10, float f11, boolean z10) {
        ViewParent f12;
        if (!this.f10142d || (f12 = f(0)) == null) {
            return false;
        }
        try {
            return k1.a(f12, this.f10141c, f10, f11, z10);
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + f12 + " does not implement interface method onNestedFling", e10);
            return false;
        }
    }

    public final boolean b(float f10, float f11) {
        ViewParent f12;
        if (!this.f10142d || (f12 = f(0)) == null) {
            return false;
        }
        try {
            return k1.b(f12, this.f10141c, f10, f11);
        } catch (AbstractMethodError e10) {
            Log.e("ViewParentCompat", "ViewParent " + f12 + " does not implement interface method onNestedPreFling", e10);
            return false;
        }
    }

    public final boolean c(int i10, int i11, int[] iArr, int[] iArr2, int i12) {
        ViewParent f10;
        int i13;
        int i14;
        int[] iArr3;
        int i15 = i10;
        int i16 = i11;
        int[] iArr4 = iArr2;
        int i17 = i12;
        if (!this.f10142d || (f10 = f(i17)) == null) {
            return false;
        }
        if (i15 != 0 || i16 != 0) {
            View view = this.f10141c;
            if (iArr4 != null) {
                view.getLocationInWindow(iArr4);
                i14 = iArr4[0];
                i13 = iArr4[1];
            } else {
                i14 = 0;
                i13 = 0;
            }
            if (iArr == null) {
                if (this.f10143e == null) {
                    this.f10143e = new int[2];
                }
                iArr3 = this.f10143e;
            } else {
                iArr3 = iArr;
            }
            iArr3[0] = 0;
            iArr3[1] = 0;
            View view2 = this.f10141c;
            if (f10 instanceof v) {
                ((v) f10).c(view2, i10, i11, iArr3, i12);
            } else if (i17 == 0) {
                try {
                    k1.c(f10, view2, i15, i16, iArr3);
                } catch (AbstractMethodError e10) {
                    AbstractMethodError abstractMethodError = e10;
                    Log.e("ViewParentCompat", "ViewParent " + f10 + " does not implement interface method onNestedPreScroll", abstractMethodError);
                }
            }
            if (iArr4 != null) {
                view.getLocationInWindow(iArr4);
                iArr4[0] = iArr4[0] - i14;
                iArr4[1] = iArr4[1] - i13;
            }
            if (iArr3[0] == 0 && iArr3[1] == 0) {
                return false;
            }
            return true;
        } else if (iArr4 == null) {
            return false;
        } else {
            iArr4[0] = 0;
            iArr4[1] = 0;
            return false;
        }
    }

    public final void d(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        e(i10, i11, i12, i13, iArr, i14, iArr2);
    }

    public final boolean e(int i10, int i11, int i12, int i13, int[] iArr, int i14, int[] iArr2) {
        ViewParent f10;
        int i15;
        int i16;
        int[] iArr3;
        int[] iArr4 = iArr;
        int i17 = i14;
        if (!this.f10142d || (f10 = f(i17)) == null) {
            return false;
        }
        if (i10 == 0 && i11 == 0 && i12 == 0 && i13 == 0) {
            if (iArr4 != null) {
                iArr4[0] = 0;
                iArr4[1] = 0;
            }
            return false;
        }
        View view = this.f10141c;
        if (iArr4 != null) {
            view.getLocationInWindow(iArr4);
            i16 = iArr4[0];
            i15 = iArr4[1];
        } else {
            i16 = 0;
            i15 = 0;
        }
        if (iArr2 == null) {
            if (this.f10143e == null) {
                this.f10143e = new int[2];
            }
            int[] iArr5 = this.f10143e;
            iArr5[0] = 0;
            iArr5[1] = 0;
            iArr3 = iArr5;
        } else {
            iArr3 = iArr2;
        }
        View view2 = this.f10141c;
        if (f10 instanceof w) {
            ((w) f10).d(view2, i10, i11, i12, i13, i14, iArr3);
        } else {
            iArr3[0] = iArr3[0] + i12;
            iArr3[1] = iArr3[1] + i13;
            if (f10 instanceof v) {
                ((v) f10).e(view2, i10, i11, i12, i13, i14);
            } else if (i17 == 0) {
                try {
                    k1.d(f10, view2, i10, i11, i12, i13);
                } catch (AbstractMethodError e10) {
                    AbstractMethodError abstractMethodError = e10;
                    Log.e("ViewParentCompat", "ViewParent " + f10 + " does not implement interface method onNestedScroll", abstractMethodError);
                }
            }
        }
        if (iArr4 != null) {
            view.getLocationInWindow(iArr4);
            iArr4[0] = iArr4[0] - i16;
            iArr4[1] = iArr4[1] - i15;
        }
        return true;
    }

    public final ViewParent f(int i10) {
        if (i10 == 0) {
            return this.f10139a;
        }
        if (i10 != 1) {
            return null;
        }
        return this.f10140b;
    }

    public final boolean g(int i10) {
        return f(i10) != null;
    }

    public final boolean h(int i10, int i11) {
        boolean z10;
        if (g(i11)) {
            return true;
        }
        if (this.f10142d) {
            View view = this.f10141c;
            View view2 = view;
            for (ViewParent parent = view.getParent(); parent != null; parent = parent.getParent()) {
                boolean z11 = parent instanceof v;
                if (z11) {
                    z10 = ((v) parent).f(view2, view, i10, i11);
                } else {
                    if (i11 == 0) {
                        try {
                            z10 = k1.f(parent, view2, view, i10);
                        } catch (AbstractMethodError e10) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onStartNestedScroll", e10);
                        }
                    }
                    z10 = false;
                }
                if (z10) {
                    if (i11 == 0) {
                        this.f10139a = parent;
                    } else if (i11 == 1) {
                        this.f10140b = parent;
                    }
                    if (z11) {
                        ((v) parent).a(view2, view, i10, i11);
                    } else if (i11 == 0) {
                        try {
                            k1.e(parent, view2, view, i10);
                        } catch (AbstractMethodError e11) {
                            Log.e("ViewParentCompat", "ViewParent " + parent + " does not implement interface method onNestedScrollAccepted", e11);
                        }
                    }
                    return true;
                }
                if (parent instanceof View) {
                    view2 = (View) parent;
                }
            }
        }
        return false;
    }

    public final void i(int i10) {
        ViewParent f10 = f(i10);
        if (f10 != null) {
            boolean z10 = f10 instanceof v;
            View view = this.f10141c;
            if (z10) {
                ((v) f10).b(view, i10);
            } else if (i10 == 0) {
                try {
                    k1.g(f10, view);
                } catch (AbstractMethodError e10) {
                    Log.e("ViewParentCompat", "ViewParent " + f10 + " does not implement interface method onStopNestedScroll", e10);
                }
            }
            if (i10 == 0) {
                this.f10139a = null;
            } else if (i10 == 1) {
                this.f10140b = null;
            }
        }
    }
}
