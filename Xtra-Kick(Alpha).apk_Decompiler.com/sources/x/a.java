package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.TypedValue;
import android.util.Xml;
import java.util.HashMap;
import s.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final boolean f16340a = false;

    /* renamed from: b  reason: collision with root package name */
    public final int f16341b;

    /* renamed from: c  reason: collision with root package name */
    public int f16342c;

    /* renamed from: d  reason: collision with root package name */
    public float f16343d;

    /* renamed from: e  reason: collision with root package name */
    public String f16344e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f16345f;

    /* renamed from: g  reason: collision with root package name */
    public int f16346g;

    public a(String str, int i10, Object obj, boolean z10) {
        this.f16341b = i10;
        this.f16340a = z10;
        b(obj);
    }

    public static void a(Context context, XmlResourceParser xmlResourceParser, HashMap hashMap) {
        int i10;
        float f10;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), p.f16501d);
        int indexCount = obtainStyledAttributes.getIndexCount();
        String str = null;
        Object obj = null;
        int i11 = 0;
        boolean z10 = false;
        for (int i12 = 0; i12 < indexCount; i12++) {
            int index = obtainStyledAttributes.getIndex(i12);
            int i13 = 1;
            if (index == 0) {
                str = obtainStyledAttributes.getString(index);
                if (str != null && str.length() > 0) {
                    str = Character.toUpperCase(str.charAt(0)) + str.substring(1);
                }
            } else if (index == 10) {
                str = obtainStyledAttributes.getString(index);
                z10 = true;
            } else if (index == 1) {
                obj = Boolean.valueOf(obtainStyledAttributes.getBoolean(index, false));
                i11 = 6;
            } else {
                if (index == 3) {
                    i13 = 3;
                } else if (index == 2) {
                    i13 = 4;
                } else {
                    if (index == 7) {
                        f10 = TypedValue.applyDimension(1, obtainStyledAttributes.getDimension(index, 0.0f), context.getResources().getDisplayMetrics());
                    } else if (index == 4) {
                        f10 = obtainStyledAttributes.getDimension(index, 0.0f);
                    } else if (index == 5) {
                        obj = Float.valueOf(obtainStyledAttributes.getFloat(index, Float.NaN));
                        i11 = 2;
                    } else {
                        if (index == 6) {
                            i10 = obtainStyledAttributes.getInteger(index, -1);
                        } else if (index == 9) {
                            obj = obtainStyledAttributes.getString(index);
                            i11 = 5;
                        } else {
                            i13 = 8;
                            if (index == 8) {
                                i10 = obtainStyledAttributes.getResourceId(index, -1);
                                if (i10 == -1) {
                                    i10 = obtainStyledAttributes.getInt(index, -1);
                                }
                            }
                        }
                        obj = Integer.valueOf(i10);
                        i11 = i13;
                    }
                    obj = Float.valueOf(f10);
                    i11 = 7;
                }
                i10 = obtainStyledAttributes.getColor(index, 0);
                obj = Integer.valueOf(i10);
                i11 = i13;
            }
        }
        if (!(str == null || obj == null)) {
            hashMap.put(str, new a(str, i11, obj, z10));
        }
        obtainStyledAttributes.recycle();
    }

    public final void b(Object obj) {
        switch (i.a(this.f16341b)) {
            case 0:
            case 7:
                this.f16342c = ((Integer) obj).intValue();
                return;
            case 1:
            case 6:
                this.f16343d = ((Float) obj).floatValue();
                return;
            case 2:
            case 3:
                this.f16346g = ((Integer) obj).intValue();
                return;
            case 4:
                this.f16344e = (String) obj;
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                this.f16345f = ((Boolean) obj).booleanValue();
                return;
            default:
                return;
        }
    }

    public a(a aVar, Object obj) {
        aVar.getClass();
        this.f16341b = aVar.f16341b;
        b(obj);
    }
}
