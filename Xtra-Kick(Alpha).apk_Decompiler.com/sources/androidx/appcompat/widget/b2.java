package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;

public final class b2 {

    /* renamed from: l  reason: collision with root package name */
    public static final RectF f738l = new RectF();

    /* renamed from: m  reason: collision with root package name */
    public static final ConcurrentHashMap f739m = new ConcurrentHashMap();

    /* renamed from: a  reason: collision with root package name */
    public int f740a = 0;

    /* renamed from: b  reason: collision with root package name */
    public boolean f741b = false;

    /* renamed from: c  reason: collision with root package name */
    public float f742c = -1.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f743d = -1.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f744e = -1.0f;

    /* renamed from: f  reason: collision with root package name */
    public int[] f745f = new int[0];

    /* renamed from: g  reason: collision with root package name */
    public boolean f746g = false;

    /* renamed from: h  reason: collision with root package name */
    public TextPaint f747h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f748i;

    /* renamed from: j  reason: collision with root package name */
    public final Context f749j;

    /* renamed from: k  reason: collision with root package name */
    public final a2 f750k;

    static {
        new ConcurrentHashMap();
    }

    public b2(TextView textView) {
        this.f748i = textView;
        this.f749j = textView.getContext();
        int i10 = Build.VERSION.SDK_INT;
        this.f750k = i10 >= 29 ? new z1() : i10 >= 23 ? new y1() : new a2();
    }

    public static int[] b(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i10 : iArr) {
            if (i10 > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i10)) < 0) {
                arrayList.add(Integer.valueOf(i10));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i11 = 0; i11 < size; i11++) {
            iArr2[i11] = ((Integer) arrayList.get(i11)).intValue();
        }
        return iArr2;
    }

    public static Method d(String str) {
        try {
            ConcurrentHashMap concurrentHashMap = f739m;
            Method method = (Method) concurrentHashMap.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                concurrentHashMap.put(str, method);
            }
            return method;
        } catch (Exception e10) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e10);
            return null;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        android.util.Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + r4 + "() method", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return r3;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.Object e(java.lang.Object r2, java.lang.Object r3, java.lang.String r4) {
        /*
            java.lang.reflect.Method r0 = d(r4)     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            r1 = 0
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            java.lang.Object r3 = r0.invoke(r2, r1)     // Catch:{ Exception -> 0x000e, all -> 0x000c }
            goto L_0x0027
        L_0x000c:
            r2 = move-exception
            throw r2
        L_0x000e:
            r2 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to invoke TextView#"
            r0.<init>(r1)
            r0.append(r4)
            java.lang.String r4 = "() method"
            r0.append(r4)
            java.lang.String r4 = r0.toString()
            java.lang.String r0 = "ACTVAutoSizeHelper"
            android.util.Log.w(r0, r4, r2)
        L_0x0027:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.b2.e(java.lang.Object, java.lang.Object, java.lang.String):java.lang.Object");
    }

    public final void a() {
        boolean z10;
        int i10;
        if (!i() || this.f740a == 0) {
            z10 = false;
        } else {
            z10 = true;
        }
        if (z10) {
            if (this.f741b) {
                if (this.f748i.getMeasuredHeight() > 0 && this.f748i.getMeasuredWidth() > 0) {
                    if (this.f750k.b(this.f748i)) {
                        i10 = 1048576;
                    } else {
                        i10 = (this.f748i.getMeasuredWidth() - this.f748i.getTotalPaddingLeft()) - this.f748i.getTotalPaddingRight();
                    }
                    int height = (this.f748i.getHeight() - this.f748i.getCompoundPaddingBottom()) - this.f748i.getCompoundPaddingTop();
                    if (i10 > 0 && height > 0) {
                        RectF rectF = f738l;
                        synchronized (rectF) {
                            rectF.setEmpty();
                            rectF.right = (float) i10;
                            rectF.bottom = (float) height;
                            float c10 = (float) c(rectF);
                            if (c10 != this.f748i.getTextSize()) {
                                f(0, c10);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f741b = true;
        }
    }

    public final int c(RectF rectF) {
        StaticLayout staticLayout;
        int i10;
        boolean z10;
        CharSequence transformation;
        RectF rectF2 = rectF;
        int length = this.f745f.length;
        if (length != 0) {
            int i11 = length - 1;
            int i12 = 1;
            int i13 = 0;
            while (i12 <= i11) {
                int i14 = (i12 + i11) / 2;
                int i15 = this.f745f[i14];
                TextView textView = this.f748i;
                CharSequence text = textView.getText();
                TransformationMethod transformationMethod = textView.getTransformationMethod();
                if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, textView)) == null)) {
                    text = transformation;
                }
                int i16 = Build.VERSION.SDK_INT;
                int b10 = u1.b(textView);
                TextPaint textPaint = this.f747h;
                if (textPaint == null) {
                    this.f747h = new TextPaint();
                } else {
                    textPaint.reset();
                }
                this.f747h.set(textView.getPaint());
                this.f747h.setTextSize((float) i15);
                Layout.Alignment alignment = (Layout.Alignment) e(textView, Layout.Alignment.ALIGN_NORMAL, "getLayoutAlignment");
                int round = Math.round(rectF2.right);
                if (i16 >= 23) {
                    i10 = b10;
                    staticLayout = x1.a(text, alignment, round, b10, this.f748i, this.f747h, this.f750k);
                } else {
                    i10 = b10;
                    staticLayout = u1.a(text, alignment, round, textView, this.f747h);
                }
                if ((i10 == -1 || (staticLayout.getLineCount() <= i10 && staticLayout.getLineEnd(staticLayout.getLineCount() - 1) == text.length())) && ((float) staticLayout.getHeight()) <= rectF2.bottom) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    int i17 = i14 + 1;
                    i13 = i12;
                    i12 = i17;
                } else {
                    i13 = i14 - 1;
                    i11 = i13;
                }
            }
            return this.f745f[i13];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    public final void f(int i10, float f10) {
        Resources resources;
        Context context = this.f749j;
        if (context == null) {
            resources = Resources.getSystem();
        } else {
            resources = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i10, f10, resources.getDisplayMetrics());
        TextView textView = this.f748i;
        if (applyDimension != textView.getPaint().getTextSize()) {
            textView.getPaint().setTextSize(applyDimension);
            boolean a10 = v1.a(textView);
            if (textView.getLayout() != null) {
                this.f741b = false;
                try {
                    Method d10 = d("nullLayouts");
                    if (d10 != null) {
                        d10.invoke(textView, new Object[0]);
                    }
                } catch (Exception e10) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e10);
                }
                if (!a10) {
                    textView.requestLayout();
                } else {
                    textView.forceLayout();
                }
                textView.invalidate();
            }
        }
    }

    public final boolean g() {
        if (!i() || this.f740a != 1) {
            this.f741b = false;
        } else {
            if (!this.f746g || this.f745f.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f744e - this.f743d) / this.f742c))) + 1;
                int[] iArr = new int[floor];
                for (int i10 = 0; i10 < floor; i10++) {
                    iArr[i10] = Math.round((((float) i10) * this.f742c) + this.f743d);
                }
                this.f745f = b(iArr);
            }
            this.f741b = true;
        }
        return this.f741b;
    }

    public final boolean h() {
        int[] iArr = this.f745f;
        int length = iArr.length;
        boolean z10 = length > 0;
        this.f746g = z10;
        if (z10) {
            this.f740a = 1;
            this.f743d = (float) iArr[0];
            this.f744e = (float) iArr[length - 1];
            this.f742c = -1.0f;
        }
        return z10;
    }

    public final boolean i() {
        return !(this.f748i instanceof j0);
    }

    public final void j(float f10, float f11, float f12) {
        if (f10 <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f10 + "px) is less or equal to (0px)");
        } else if (f11 <= f10) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f11 + "px) is less or equal to minimum auto-size text size (" + f10 + "px)");
        } else if (f12 > 0.0f) {
            this.f740a = 1;
            this.f743d = f10;
            this.f744e = f11;
            this.f742c = f12;
            this.f746g = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f12 + "px) is less or equal to (0px)");
        }
    }
}
