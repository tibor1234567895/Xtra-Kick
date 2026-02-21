package q0;

import android.view.View;
import android.view.ViewGroup;
import javax.inject.Provider;
import t4.a;
import t4.b;
import t4.c;
import t4.e;
import t4.g;
import xa.j;
import y5.h;

public abstract /* synthetic */ class f {
    public static g a(e eVar) {
        int i10;
        int i11;
        c cVar;
        c cVar2;
        ViewGroup.LayoutParams layoutParams = eVar.f14545a.getLayoutParams();
        int i12 = -1;
        if (layoutParams != null) {
            i10 = layoutParams.width;
        } else {
            i10 = -1;
        }
        View view = eVar.f14545a;
        int width = view.getWidth();
        int i13 = 0;
        boolean z10 = eVar.f14546b;
        if (z10) {
            i11 = view.getPaddingRight() + view.getPaddingLeft();
        } else {
            i11 = 0;
        }
        if (i10 == -2) {
            cVar = b.f14543a;
        } else {
            int i14 = i10 - i11;
            if (i14 > 0) {
                cVar = new a(i14);
            } else {
                int i15 = width - i11;
                if (i15 > 0) {
                    cVar = new a(i15);
                } else {
                    cVar = null;
                }
            }
        }
        if (cVar == null) {
            return null;
        }
        ViewGroup.LayoutParams layoutParams2 = view.getLayoutParams();
        if (layoutParams2 != null) {
            i12 = layoutParams2.height;
        }
        int height = view.getHeight();
        if (z10) {
            i13 = view.getPaddingBottom() + view.getPaddingTop();
        }
        if (i12 == -2) {
            cVar2 = b.f14543a;
        } else {
            int i16 = i12 - i13;
            if (i16 > 0) {
                cVar2 = new a(i16);
            } else {
                int i17 = height - i13;
                if (i17 > 0) {
                    cVar2 = new a(i17);
                } else {
                    cVar2 = null;
                }
            }
        }
        if (cVar2 == null) {
            return null;
        }
        return new g(cVar, cVar2);
    }

    public static /* synthetic */ boolean b(int i10) {
        if (i10 == 1 || i10 == 2 || i10 == 3) {
            return false;
        }
        if (i10 == 4 || i10 == 5) {
            return true;
        }
        throw null;
    }

    public static /* synthetic */ String c(int i10) {
        if (i10 == 1) {
            return "pusher:connection_established";
        }
        if (i10 == 2) {
            return "pusher:ping";
        }
        if (i10 == 3) {
            return "pusher:pong";
        }
        if (i10 == 4) {
            return "pusher:subscribe";
        }
        if (i10 == 5) {
            return "pusher:unsubscribe";
        }
        if (i10 == 6) {
            return "pusher_internal:subscription_succeeded";
        }
        if (i10 == 7) {
            return "App\\Events\\ChatMessageEvent";
        }
        throw null;
    }

    public static /* synthetic */ boolean d(int i10) {
        if (i10 == 1 || i10 == 2) {
            return true;
        }
        if (i10 == 3 || i10 == 4) {
            return false;
        }
        throw null;
    }

    public static /* synthetic */ boolean e(int i10) {
        if (i10 == 1) {
            return true;
        }
        if (i10 == 2) {
            return false;
        }
        if (i10 == 3) {
            return true;
        }
        if (i10 == 4) {
            return false;
        }
        throw null;
    }

    public static float f(float f10, float f11, float f12, float f13) {
        return ((f10 - f11) * f12) + f13;
    }

    public static String g(String str, String str2) {
        return str + str2;
    }

    public static Provider h(h hVar, int i10) {
        return ka.a.a(new y5.g(hVar, i10));
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: MethodInlineVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.visitors.MethodInlineVisitor.inlineMth(MethodInlineVisitor.java:57)
        	at jadx.core.dex.visitors.MethodInlineVisitor.visit(MethodInlineVisitor.java:47)
        */
    public static /* synthetic */ void i() {
        /*
            android.widget.EdgeEffect r0 = new android.widget.EdgeEffect
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: q0.f.i():void");
    }

    public static /* synthetic */ void j(String str, int i10) {
        if (i10 == 0) {
            NullPointerException nullPointerException = new NullPointerException(j.i(str));
            j.j(j.class.getName(), nullPointerException);
            throw nullPointerException;
        }
    }

    public static void k(StringBuilder sb2, String str, String str2, String str3, String str4) {
        sb2.append(str);
        sb2.append(str2);
        sb2.append(str3);
        sb2.append(str4);
    }

    public static /* synthetic */ void l(pa.h hVar) {
        if (hVar != null) {
            throw new ClassCastException();
        }
    }

    public static /* synthetic */ String m(int i10) {
        return i10 == 1 ? "UNKNOWN" : i10 == 2 ? "HORIZONTAL_DIMENSION" : i10 == 3 ? "VERTICAL_DIMENSION" : i10 == 4 ? "LEFT" : i10 == 5 ? "RIGHT" : i10 == 6 ? "TOP" : i10 == 7 ? "BOTTOM" : i10 == 8 ? "BASELINE" : "null";
    }
}
