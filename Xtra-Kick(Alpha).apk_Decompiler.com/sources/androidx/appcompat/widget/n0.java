package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.opengl.GLES20;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.activity.result.j;
import f.a;
import j1.k;
import j1.m;
import java.util.HashMap;
import java.util.Map;
import m0.c1;
import q0.h;

public final class n0 {

    /* renamed from: a  reason: collision with root package name */
    public int f963a = 0;

    /* renamed from: b  reason: collision with root package name */
    public final Object f964b;

    /* renamed from: c  reason: collision with root package name */
    public final j[] f965c;

    /* renamed from: d  reason: collision with root package name */
    public Object f966d;

    /* renamed from: e  reason: collision with root package name */
    public Object f967e;

    public n0(ImageView imageView) {
        this.f964b = imageView;
    }

    public static void a(int i10, int i11, String str) {
        int glCreateShader = GLES20.glCreateShader(i11);
        GLES20.glShaderSource(glCreateShader, str);
        GLES20.glCompileShader(glCreateShader);
        boolean z10 = true;
        int[] iArr = {0};
        GLES20.glGetShaderiv(glCreateShader, 35713, iArr, 0);
        if (iArr[0] != 1) {
            z10 = false;
        }
        m.c(GLES20.glGetShaderInfoLog(glCreateShader) + ", source: " + str, z10);
        GLES20.glAttachShader(i10, glCreateShader);
        GLES20.glDeleteShader(glCreateShader);
        m.b();
    }

    public final void b() {
        boolean z10;
        ImageView imageView = (ImageView) this.f964b;
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            i2.a(drawable);
        }
        if (drawable != null) {
            int i10 = Build.VERSION.SDK_INT;
            boolean z11 = true;
            j[] jVarArr = this.f965c;
            if (i10 <= 21 ? i10 != 21 : ((s4) jVarArr) == null) {
                z10 = false;
            } else {
                z10 = true;
            }
            if (z10) {
                if (((s4) this.f967e) == null) {
                    this.f967e = new s4();
                }
                s4 s4Var = (s4) this.f967e;
                s4Var.f1055a = null;
                s4Var.f1058d = false;
                s4Var.f1056b = null;
                s4Var.f1057c = false;
                ColorStateList a10 = h.a(imageView);
                if (a10 != null) {
                    s4Var.f1058d = true;
                    s4Var.f1055a = a10;
                }
                PorterDuff.Mode b10 = h.b(imageView);
                if (b10 != null) {
                    s4Var.f1057c = true;
                    s4Var.f1056b = b10;
                }
                if (s4Var.f1058d || s4Var.f1057c) {
                    h0.e(drawable, s4Var, imageView.getDrawableState());
                } else {
                    z11 = false;
                }
                if (z11) {
                    return;
                }
            }
            s4 s4Var2 = (s4) this.f966d;
            if (s4Var2 != null) {
                h0.e(drawable, s4Var2, imageView.getDrawableState());
                return;
            }
            s4 s4Var3 = (s4) jVarArr;
            if (s4Var3 != null) {
                h0.e(drawable, s4Var3, imageView.getDrawableState());
            }
        }
    }

    public final int c(String str) {
        int glGetAttribLocation = GLES20.glGetAttribLocation(this.f963a, str);
        GLES20.glEnableVertexAttribArray(glGetAttribLocation);
        m.b();
        return glGetAttribLocation;
    }

    public final void d(AttributeSet attributeSet, int i10) {
        Drawable drawable;
        Drawable drawable2;
        int i11;
        Object obj = this.f964b;
        ImageView imageView = (ImageView) obj;
        Context context = imageView.getContext();
        int[] iArr = a.f5397g;
        u4 m10 = u4.m(context, attributeSet, iArr, i10);
        c1.o(imageView, imageView.getContext(), iArr, attributeSet, m10.f1100b, i10);
        try {
            Drawable drawable3 = ((ImageView) obj).getDrawable();
            if (!(drawable3 != null || (i11 = m10.i(1, -1)) == -1 || (drawable3 = h.a.a(((ImageView) obj).getContext(), i11)) == null)) {
                ((ImageView) obj).setImageDrawable(drawable3);
            }
            if (drawable3 != null) {
                i2.a(drawable3);
            }
            if (m10.l(2)) {
                ImageView imageView2 = (ImageView) obj;
                ColorStateList b10 = m10.b(2);
                int i12 = Build.VERSION.SDK_INT;
                h.c(imageView2, b10);
                if (!(i12 != 21 || (drawable2 = imageView2.getDrawable()) == null || h.a(imageView2) == null)) {
                    if (drawable2.isStateful()) {
                        drawable2.setState(imageView2.getDrawableState());
                    }
                    imageView2.setImageDrawable(drawable2);
                }
            }
            if (m10.l(3)) {
                ImageView imageView3 = (ImageView) obj;
                PorterDuff.Mode d10 = i2.d(m10.h(3, -1), (PorterDuff.Mode) null);
                int i13 = Build.VERSION.SDK_INT;
                h.d(imageView3, d10);
                if (!(i13 != 21 || (drawable = imageView3.getDrawable()) == null || h.a(imageView3) == null)) {
                    if (drawable.isStateful()) {
                        drawable.setState(imageView3.getDrawableState());
                    }
                    imageView3.setImageDrawable(drawable);
                }
            }
        } finally {
            m10.n();
        }
    }

    public final void e(int i10) {
        Drawable drawable;
        ImageView imageView = (ImageView) this.f964b;
        if (i10 != 0) {
            drawable = h.a.a(imageView.getContext(), i10);
            if (drawable != null) {
                i2.a(drawable);
            }
        } else {
            drawable = null;
        }
        imageView.setImageDrawable(drawable);
        b();
    }

    public final void f(ColorStateList colorStateList) {
        if (((s4) this.f966d) == null) {
            this.f966d = new s4();
        }
        s4 s4Var = (s4) this.f966d;
        s4Var.f1055a = colorStateList;
        s4Var.f1058d = true;
        b();
    }

    public final void g(PorterDuff.Mode mode) {
        if (((s4) this.f966d) == null) {
            this.f966d = new s4();
        }
        s4 s4Var = (s4) this.f966d;
        s4Var.f1056b = mode;
        s4Var.f1057c = true;
        b();
    }

    public n0(String str, String str2) {
        byte[] bArr;
        byte[] bArr2;
        m.b();
        a(this.f963a, 35633, str);
        a(this.f963a, 35632, str2);
        GLES20.glLinkProgram(this.f963a);
        int i10 = 1;
        int[] iArr = {0};
        GLES20.glGetProgramiv(this.f963a, 35714, iArr, 0);
        boolean z10 = iArr[0] == 1;
        m.c("Unable to link shader program: \n" + GLES20.glGetProgramInfoLog(this.f963a), z10);
        GLES20.glUseProgram(this.f963a);
        this.f966d = new HashMap();
        int[] iArr2 = new int[1];
        GLES20.glGetProgramiv(this.f963a, 35721, iArr2, 0);
        this.f964b = new k[iArr2[0]];
        int i11 = 0;
        while (i11 < iArr2[0]) {
            int i12 = this.f963a;
            int[] iArr3 = new int[i10];
            GLES20.glGetProgramiv(i12, 35722, iArr3, 0);
            int i13 = iArr3[0];
            int[] iArr4 = new int[i10];
            int[] iArr5 = new int[i10];
            int[] iArr6 = new int[i10];
            byte[] bArr3 = new byte[i13];
            int i14 = i13;
            int i15 = i12;
            GLES20.glGetActiveAttrib(i12, i11, i13, iArr4, 0, iArr5, 0, iArr6, 0, bArr3, 0);
            int i16 = 0;
            while (true) {
                bArr2 = bArr3;
                if (i16 >= i14) {
                    i16 = i14;
                    break;
                } else if (bArr2[i16] == 0) {
                    break;
                } else {
                    i16++;
                    bArr3 = bArr2;
                }
            }
            String str3 = new String(bArr2, 0, i16);
            k kVar = new k(str3, i11, GLES20.glGetAttribLocation(i15, str3));
            ((k[]) this.f964b)[i11] = kVar;
            ((Map) this.f966d).put(str3, kVar);
            i11++;
            i10 = 1;
        }
        this.f967e = new HashMap();
        int i17 = 1;
        int[] iArr7 = new int[1];
        GLES20.glGetProgramiv(this.f963a, 35718, iArr7, 0);
        this.f965c = new j[iArr7[0]];
        int i18 = 0;
        while (i18 < iArr7[0]) {
            int i19 = this.f963a;
            int[] iArr8 = new int[i17];
            GLES20.glGetProgramiv(i19, 35719, iArr8, 0);
            int[] iArr9 = new int[i17];
            int i20 = iArr8[0];
            byte[] bArr4 = new byte[i20];
            int i21 = i20;
            int[] iArr10 = iArr9;
            int i22 = i19;
            GLES20.glGetActiveUniform(i19, i18, i20, new int[i17], 0, new int[i17], 0, iArr9, 0, bArr4, 0);
            int i23 = 0;
            while (true) {
                bArr = bArr4;
                if (i23 >= i21) {
                    i23 = i21;
                    break;
                } else if (bArr[i23] == 0) {
                    break;
                } else {
                    i23++;
                    bArr4 = bArr;
                }
            }
            String str4 = new String(bArr, 0, i23);
            j jVar = new j(str4, GLES20.glGetUniformLocation(i22, str4), iArr10[0]);
            this.f965c[i18] = jVar;
            ((Map) this.f967e).put(str4, jVar);
            i18++;
            i17 = 1;
        }
        m.b();
    }
}
