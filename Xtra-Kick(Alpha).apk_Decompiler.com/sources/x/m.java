package x;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.support.v4.media.h;
import android.util.Log;
import android.util.SparseIntArray;
import android.util.Xml;
import android.view.View;
import androidx.constraintlayout.widget.Barrier;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import org.xmlpull.v1.XmlPullParserException;
import s.i;

public final class m {

    /* renamed from: d  reason: collision with root package name */
    public static final int[] f16492d = {0, 4, 8};

    /* renamed from: e  reason: collision with root package name */
    public static final SparseIntArray f16493e;

    /* renamed from: f  reason: collision with root package name */
    public static final SparseIntArray f16494f;

    /* renamed from: a  reason: collision with root package name */
    public final HashMap f16495a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final boolean f16496b = true;

    /* renamed from: c  reason: collision with root package name */
    public final HashMap f16497c = new HashMap();

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        f16493e = sparseIntArray;
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        f16494f = sparseIntArray2;
        sparseIntArray.append(82, 25);
        sparseIntArray.append(83, 26);
        sparseIntArray.append(85, 29);
        sparseIntArray.append(86, 30);
        sparseIntArray.append(92, 36);
        sparseIntArray.append(91, 35);
        sparseIntArray.append(63, 4);
        sparseIntArray.append(62, 3);
        sparseIntArray.append(58, 1);
        sparseIntArray.append(60, 91);
        sparseIntArray.append(59, 92);
        sparseIntArray.append(101, 6);
        sparseIntArray.append(102, 7);
        sparseIntArray.append(70, 17);
        sparseIntArray.append(71, 18);
        sparseIntArray.append(72, 19);
        sparseIntArray.append(54, 99);
        sparseIntArray.append(0, 27);
        sparseIntArray.append(87, 32);
        sparseIntArray.append(88, 33);
        sparseIntArray.append(69, 10);
        sparseIntArray.append(68, 9);
        sparseIntArray.append(106, 13);
        sparseIntArray.append(109, 16);
        sparseIntArray.append(107, 14);
        sparseIntArray.append(104, 11);
        sparseIntArray.append(108, 15);
        sparseIntArray.append(105, 12);
        sparseIntArray.append(95, 40);
        sparseIntArray.append(80, 39);
        sparseIntArray.append(79, 41);
        sparseIntArray.append(94, 42);
        sparseIntArray.append(78, 20);
        sparseIntArray.append(93, 37);
        sparseIntArray.append(67, 5);
        sparseIntArray.append(81, 87);
        sparseIntArray.append(90, 87);
        sparseIntArray.append(84, 87);
        sparseIntArray.append(61, 87);
        sparseIntArray.append(57, 87);
        sparseIntArray.append(5, 24);
        sparseIntArray.append(7, 28);
        sparseIntArray.append(23, 31);
        sparseIntArray.append(24, 8);
        sparseIntArray.append(6, 34);
        sparseIntArray.append(8, 2);
        sparseIntArray.append(3, 23);
        sparseIntArray.append(4, 21);
        sparseIntArray.append(96, 95);
        sparseIntArray.append(73, 96);
        sparseIntArray.append(2, 22);
        sparseIntArray.append(13, 43);
        sparseIntArray.append(26, 44);
        sparseIntArray.append(21, 45);
        sparseIntArray.append(22, 46);
        sparseIntArray.append(20, 60);
        sparseIntArray.append(18, 47);
        sparseIntArray.append(19, 48);
        sparseIntArray.append(14, 49);
        sparseIntArray.append(15, 50);
        sparseIntArray.append(16, 51);
        sparseIntArray.append(17, 52);
        sparseIntArray.append(25, 53);
        sparseIntArray.append(97, 54);
        sparseIntArray.append(74, 55);
        sparseIntArray.append(98, 56);
        sparseIntArray.append(75, 57);
        sparseIntArray.append(99, 58);
        sparseIntArray.append(76, 59);
        sparseIntArray.append(64, 61);
        sparseIntArray.append(66, 62);
        sparseIntArray.append(65, 63);
        sparseIntArray.append(28, 64);
        sparseIntArray.append(121, 65);
        sparseIntArray.append(35, 66);
        sparseIntArray.append(122, 67);
        sparseIntArray.append(113, 79);
        sparseIntArray.append(1, 38);
        sparseIntArray.append(112, 68);
        sparseIntArray.append(100, 69);
        sparseIntArray.append(77, 70);
        sparseIntArray.append(111, 97);
        sparseIntArray.append(32, 71);
        sparseIntArray.append(30, 72);
        sparseIntArray.append(31, 73);
        sparseIntArray.append(33, 74);
        sparseIntArray.append(29, 75);
        sparseIntArray.append(114, 76);
        sparseIntArray.append(89, 77);
        sparseIntArray.append(123, 78);
        sparseIntArray.append(56, 80);
        sparseIntArray.append(55, 81);
        sparseIntArray.append(116, 82);
        sparseIntArray.append(120, 83);
        sparseIntArray.append(119, 84);
        sparseIntArray.append(118, 85);
        sparseIntArray.append(117, 86);
        sparseIntArray2.append(85, 6);
        sparseIntArray2.append(85, 7);
        sparseIntArray2.append(0, 27);
        sparseIntArray2.append(89, 13);
        sparseIntArray2.append(92, 16);
        sparseIntArray2.append(90, 14);
        sparseIntArray2.append(87, 11);
        sparseIntArray2.append(91, 15);
        sparseIntArray2.append(88, 12);
        sparseIntArray2.append(78, 40);
        sparseIntArray2.append(71, 39);
        sparseIntArray2.append(70, 41);
        sparseIntArray2.append(77, 42);
        sparseIntArray2.append(69, 20);
        sparseIntArray2.append(76, 37);
        sparseIntArray2.append(60, 5);
        sparseIntArray2.append(72, 87);
        sparseIntArray2.append(75, 87);
        sparseIntArray2.append(73, 87);
        sparseIntArray2.append(57, 87);
        sparseIntArray2.append(56, 87);
        sparseIntArray2.append(5, 24);
        sparseIntArray2.append(7, 28);
        sparseIntArray2.append(23, 31);
        sparseIntArray2.append(24, 8);
        sparseIntArray2.append(6, 34);
        sparseIntArray2.append(8, 2);
        sparseIntArray2.append(3, 23);
        sparseIntArray2.append(4, 21);
        sparseIntArray2.append(79, 95);
        sparseIntArray2.append(64, 96);
        sparseIntArray2.append(2, 22);
        sparseIntArray2.append(13, 43);
        sparseIntArray2.append(26, 44);
        sparseIntArray2.append(21, 45);
        sparseIntArray2.append(22, 46);
        sparseIntArray2.append(20, 60);
        sparseIntArray2.append(18, 47);
        sparseIntArray2.append(19, 48);
        sparseIntArray2.append(14, 49);
        sparseIntArray2.append(15, 50);
        sparseIntArray2.append(16, 51);
        sparseIntArray2.append(17, 52);
        sparseIntArray2.append(25, 53);
        sparseIntArray2.append(80, 54);
        sparseIntArray2.append(65, 55);
        sparseIntArray2.append(81, 56);
        sparseIntArray2.append(66, 57);
        sparseIntArray2.append(82, 58);
        sparseIntArray2.append(67, 59);
        sparseIntArray2.append(59, 62);
        sparseIntArray2.append(58, 63);
        sparseIntArray2.append(28, 64);
        sparseIntArray2.append(105, 65);
        sparseIntArray2.append(34, 66);
        sparseIntArray2.append(106, 67);
        sparseIntArray2.append(96, 79);
        sparseIntArray2.append(1, 38);
        sparseIntArray2.append(97, 98);
        sparseIntArray2.append(95, 68);
        sparseIntArray2.append(83, 69);
        sparseIntArray2.append(68, 70);
        sparseIntArray2.append(32, 71);
        sparseIntArray2.append(30, 72);
        sparseIntArray2.append(31, 73);
        sparseIntArray2.append(33, 74);
        sparseIntArray2.append(29, 75);
        sparseIntArray2.append(98, 76);
        sparseIntArray2.append(74, 77);
        sparseIntArray2.append(107, 78);
        sparseIntArray2.append(55, 80);
        sparseIntArray2.append(54, 81);
        sparseIntArray2.append(100, 82);
        sparseIntArray2.append(104, 83);
        sparseIntArray2.append(103, 84);
        sparseIntArray2.append(102, 85);
        sparseIntArray2.append(101, 86);
        sparseIntArray2.append(94, 97);
    }

    public static int[] c(Barrier barrier, String str) {
        int i10;
        HashMap hashMap;
        String[] split = str.split(",");
        Context context = barrier.getContext();
        int[] iArr = new int[split.length];
        int i11 = 0;
        int i12 = 0;
        while (i11 < split.length) {
            String trim = split[i11].trim();
            Object obj = null;
            try {
                i10 = o.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i10 = 0;
            }
            if (i10 == 0) {
                i10 = context.getResources().getIdentifier(trim, "id", context.getPackageName());
            }
            if (i10 == 0 && barrier.isInEditMode() && (barrier.getParent() instanceof ConstraintLayout)) {
                ConstraintLayout constraintLayout = (ConstraintLayout) barrier.getParent();
                constraintLayout.getClass();
                if ((trim instanceof String) && (hashMap = constraintLayout.f1181t) != null && hashMap.containsKey(trim)) {
                    obj = constraintLayout.f1181t.get(trim);
                }
                if (obj != null && (obj instanceof Integer)) {
                    i10 = ((Integer) obj).intValue();
                }
            }
            iArr[i12] = i10;
            i11++;
            i12++;
        }
        if (i12 != split.length) {
            return Arrays.copyOf(iArr, i12);
        }
        return iArr;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x0416, code lost:
        r8.a(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0498, code lost:
        r8.c(r2, r1.getString(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:115:0x04a9, code lost:
        r8.b(r9, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x04ac, code lost:
        r9 = r16;
        r16 = r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x04b0, code lost:
        r10 = r21;
        r8 = r16;
        r16 = r9;
        r9 = r17 + 1;
        r2 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:134:0x051b, code lost:
        g(r14, r1, r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x0542, code lost:
        r16 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:171:0x0693, code lost:
        r13.getClass();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00b9, code lost:
        g(r8, r1, r10, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x09ec, code lost:
        r8 = r8 + 1;
        r2 = r21;
        r4 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x01cd, code lost:
        r8.d(r10, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x0200, code lost:
        r8.a(r2, r1.getFloat(r10, 1.0f));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static x.h d(android.content.Context r19, android.util.AttributeSet r20, boolean r21) {
        /*
            x.h r0 = new x.h
            r0.<init>()
            if (r21 == 0) goto L_0x000a
            int[] r1 = x.p.f16500c
            goto L_0x000c
        L_0x000a:
            int[] r1 = x.p.f16498a
        L_0x000c:
            r2 = r19
            r3 = r20
            android.content.res.TypedArray r1 = r2.obtainStyledAttributes(r3, r1)
            int[] r2 = f16492d
            android.util.SparseIntArray r3 = f16493e
            x.k r11 = r0.f16417b
            x.l r12 = r0.f16420e
            x.j r13 = r0.f16418c
            x.i r14 = r0.f16419d
            java.lang.String r15 = "/"
            java.lang.String r4 = "unused attribute 0x"
            java.lang.String r5 = "CURRENTLY UNSUPPORTED"
            java.lang.String r9 = "Unknown attribute 0x"
            java.lang.String r6 = "   "
            java.lang.String r7 = "ConstraintSet"
            if (r21 == 0) goto L_0x04bd
            int r10 = r1.getIndexCount()
            x.g r8 = new x.g
            r8.<init>()
            r13.getClass()
            r14.getClass()
            r11.getClass()
            r12.getClass()
            r16 = r9
            r9 = 0
        L_0x0046:
            if (r9 >= r10) goto L_0x09fb
            r21 = r10
            int r10 = r1.getIndex(r9)
            r17 = r9
            android.util.SparseIntArray r9 = f16494f
            int r9 = r9.get(r10)
            switch(r9) {
                case 2: goto L_0x04a0;
                case 3: goto L_0x0059;
                case 4: goto L_0x0059;
                case 5: goto L_0x0495;
                case 6: goto L_0x048b;
                case 7: goto L_0x0481;
                case 8: goto L_0x0476;
                case 9: goto L_0x0059;
                case 10: goto L_0x0059;
                case 11: goto L_0x046b;
                case 12: goto L_0x0460;
                case 13: goto L_0x0455;
                case 14: goto L_0x044a;
                case 15: goto L_0x043f;
                case 16: goto L_0x0433;
                case 17: goto L_0x0427;
                case 18: goto L_0x041b;
                case 19: goto L_0x040c;
                case 20: goto L_0x0401;
                case 21: goto L_0x03f5;
                case 22: goto L_0x03e7;
                case 23: goto L_0x03db;
                case 24: goto L_0x03cf;
                case 25: goto L_0x0059;
                case 26: goto L_0x0059;
                case 27: goto L_0x03c3;
                case 28: goto L_0x03b7;
                case 29: goto L_0x0059;
                case 30: goto L_0x0059;
                case 31: goto L_0x03ab;
                case 32: goto L_0x0059;
                case 33: goto L_0x0059;
                case 34: goto L_0x039f;
                case 35: goto L_0x0059;
                case 36: goto L_0x0059;
                case 37: goto L_0x0393;
                case 38: goto L_0x0385;
                case 39: goto L_0x0379;
                case 40: goto L_0x036d;
                case 41: goto L_0x0361;
                case 42: goto L_0x0355;
                case 43: goto L_0x0349;
                case 44: goto L_0x0336;
                case 45: goto L_0x032a;
                case 46: goto L_0x031e;
                case 47: goto L_0x0312;
                case 48: goto L_0x0306;
                case 49: goto L_0x02fa;
                case 50: goto L_0x02ee;
                case 51: goto L_0x02e2;
                case 52: goto L_0x02d6;
                case 53: goto L_0x02ca;
                case 54: goto L_0x02be;
                case 55: goto L_0x02b2;
                case 56: goto L_0x02a6;
                case 57: goto L_0x029a;
                case 58: goto L_0x028e;
                case 59: goto L_0x0282;
                case 60: goto L_0x0276;
                case 61: goto L_0x0059;
                case 62: goto L_0x026a;
                case 63: goto L_0x025e;
                case 64: goto L_0x0252;
                case 65: goto L_0x0231;
                case 66: goto L_0x0223;
                case 67: goto L_0x0217;
                case 68: goto L_0x020b;
                case 69: goto L_0x01fc;
                case 70: goto L_0x01f7;
                case 71: goto L_0x01f0;
                case 72: goto L_0x01e4;
                case 73: goto L_0x01d8;
                case 74: goto L_0x01d2;
                case 75: goto L_0x01c3;
                case 76: goto L_0x01b7;
                case 77: goto L_0x01b1;
                case 78: goto L_0x01a5;
                case 79: goto L_0x0199;
                case 80: goto L_0x018e;
                case 81: goto L_0x0183;
                case 82: goto L_0x0177;
                case 83: goto L_0x016b;
                case 84: goto L_0x015f;
                case 85: goto L_0x0153;
                case 86: goto L_0x00f7;
                case 87: goto L_0x00d6;
                case 88: goto L_0x0059;
                case 89: goto L_0x0059;
                case 90: goto L_0x0059;
                case 91: goto L_0x0059;
                case 92: goto L_0x0059;
                case 93: goto L_0x00ca;
                case 94: goto L_0x00be;
                case 95: goto L_0x00b6;
                case 96: goto L_0x00b2;
                case 97: goto L_0x00a6;
                case 98: goto L_0x008a;
                case 99: goto L_0x007e;
                default: goto L_0x0059;
            }
        L_0x0059:
            r18 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r9 = r16
            r2.<init>(r9)
            r16 = r8
            java.lang.String r8 = java.lang.Integer.toHexString(r10)
            r2.append(r8)
            r2.append(r6)
            int r8 = r3.get(r10)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r7, r2)
            goto L_0x04b0
        L_0x007e:
            boolean r9 = r14.f16435g
            boolean r9 = r1.getBoolean(r10, r9)
            r10 = 99
            r18 = r2
            goto L_0x01cd
        L_0x008a:
            int r9 = w.a.f16014x
            android.util.TypedValue r9 = r1.peekValue(r10)
            int r9 = r9.type
            r18 = r2
            r2 = 3
            if (r9 != r2) goto L_0x009c
            r1.getString(r10)
            goto L_0x04ac
        L_0x009c:
            int r2 = r0.f16416a
            int r2 = r1.getResourceId(r10, r2)
            r0.f16416a = r2
            goto L_0x04ac
        L_0x00a6:
            r18 = r2
            int r2 = r14.f16452o0
            int r2 = r1.getInt(r10, r2)
            r9 = 97
            goto L_0x04a9
        L_0x00b2:
            r18 = r2
            r2 = 1
            goto L_0x00b9
        L_0x00b6:
            r18 = r2
            r2 = 0
        L_0x00b9:
            g(r8, r1, r10, r2)
            goto L_0x04ac
        L_0x00be:
            r18 = r2
            int r2 = r14.S
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 94
            goto L_0x04a9
        L_0x00ca:
            r18 = r2
            int r2 = r14.L
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 93
            goto L_0x04a9
        L_0x00d6:
            r18 = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            java.lang.String r9 = java.lang.Integer.toHexString(r10)
            r2.append(r9)
            r2.append(r6)
            int r9 = r3.get(r10)
            r2.append(r9)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r7, r2)
            goto L_0x04ac
        L_0x00f7:
            r18 = r2
            android.util.TypedValue r2 = r1.peekValue(r10)
            int r2 = r2.type
            r9 = 1
            if (r2 != r9) goto L_0x0114
            r9 = -1
            int r2 = r1.getResourceId(r10, r9)
            r13.f16473i = r2
            r10 = 89
            r8.b(r10, r2)
            int r2 = r13.f16473i
            if (r2 == r9) goto L_0x04ac
            r2 = -1
            goto L_0x0136
        L_0x0114:
            r9 = 3
            if (r2 != r9) goto L_0x0146
            java.lang.String r2 = r1.getString(r10)
            r13.f16472h = r2
            r9 = 90
            r8.c(r9, r2)
            java.lang.String r2 = r13.f16472h
            int r2 = r2.indexOf(r15)
            if (r2 <= 0) goto L_0x013e
            r2 = -1
            int r9 = r1.getResourceId(r10, r2)
            r13.f16473i = r9
            r10 = 89
            r8.b(r10, r9)
        L_0x0136:
            r9 = -2
            r10 = 88
            r8.b(r10, r9)
            goto L_0x04ac
        L_0x013e:
            r2 = -1
            r10 = 88
            r8.b(r10, r2)
            goto L_0x04ac
        L_0x0146:
            r2 = 88
            int r9 = r13.f16473i
            int r9 = r1.getInteger(r10, r9)
            r8.b(r2, r9)
            goto L_0x04ac
        L_0x0153:
            r18 = r2
            float r2 = r13.f16470f
            float r2 = r1.getFloat(r10, r2)
            r9 = 85
            goto L_0x0416
        L_0x015f:
            r18 = r2
            int r2 = r13.f16471g
            int r2 = r1.getInteger(r10, r2)
            r9 = 84
            goto L_0x04a9
        L_0x016b:
            r18 = r2
            int r2 = r12.f16486h
            int r2 = f(r1, r10, r2)
            r9 = 83
            goto L_0x04a9
        L_0x0177:
            r18 = r2
            int r2 = r13.f16466b
            int r2 = r1.getInteger(r10, r2)
            r9 = 82
            goto L_0x04a9
        L_0x0183:
            r18 = r2
            boolean r2 = r14.f16448m0
            boolean r9 = r1.getBoolean(r10, r2)
            r10 = 81
            goto L_0x01cd
        L_0x018e:
            r18 = r2
            boolean r2 = r14.f16446l0
            boolean r9 = r1.getBoolean(r10, r2)
            r10 = 80
            goto L_0x01cd
        L_0x0199:
            r18 = r2
            float r2 = r13.f16468d
            float r2 = r1.getFloat(r10, r2)
            r9 = 79
            goto L_0x0416
        L_0x01a5:
            r18 = r2
            int r2 = r11.f16475b
            int r2 = r1.getInt(r10, r2)
            r9 = 78
            goto L_0x04a9
        L_0x01b1:
            r18 = r2
            r2 = 77
            goto L_0x0498
        L_0x01b7:
            r18 = r2
            int r2 = r13.f16467c
            int r2 = r1.getInt(r10, r2)
            r9 = 76
            goto L_0x04a9
        L_0x01c3:
            r18 = r2
            boolean r2 = r14.f16450n0
            boolean r9 = r1.getBoolean(r10, r2)
            r10 = 75
        L_0x01cd:
            r8.d(r10, r9)
            goto L_0x04ac
        L_0x01d2:
            r18 = r2
            r2 = 74
            goto L_0x0498
        L_0x01d8:
            r18 = r2
            int r2 = r14.f16436g0
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 73
            goto L_0x04a9
        L_0x01e4:
            r18 = r2
            int r2 = r14.f16434f0
            int r2 = r1.getInt(r10, r2)
            r9 = 72
            goto L_0x04a9
        L_0x01f0:
            r18 = r2
            android.util.Log.e(r7, r5)
            goto L_0x04ac
        L_0x01f7:
            r18 = r2
            r2 = 70
            goto L_0x0200
        L_0x01fc:
            r18 = r2
            r2 = 69
        L_0x0200:
            r9 = 1065353216(0x3f800000, float:1.0)
            float r10 = r1.getFloat(r10, r9)
            r8.a(r2, r10)
            goto L_0x04ac
        L_0x020b:
            r18 = r2
            float r2 = r11.f16477d
            float r2 = r1.getFloat(r10, r2)
            r9 = 68
            goto L_0x0416
        L_0x0217:
            r18 = r2
            float r2 = r13.f16469e
            float r2 = r1.getFloat(r10, r2)
            r9 = 67
            goto L_0x0416
        L_0x0223:
            r18 = r2
            r2 = 66
            r9 = 0
            int r10 = r1.getInt(r10, r9)
            r8.b(r2, r10)
            goto L_0x04ac
        L_0x0231:
            r18 = r2
            r9 = 0
            android.util.TypedValue r2 = r1.peekValue(r10)
            int r2 = r2.type
            r9 = 3
            if (r2 != r9) goto L_0x0242
            java.lang.String r2 = r1.getString(r10)
            goto L_0x024b
        L_0x0242:
            java.lang.String[] r2 = t.a.f14481b
            r9 = 0
            int r10 = r1.getInteger(r10, r9)
            r2 = r2[r10]
        L_0x024b:
            r9 = 65
            r8.c(r9, r2)
            goto L_0x04ac
        L_0x0252:
            r18 = r2
            int r2 = r13.f16465a
            int r2 = f(r1, r10, r2)
            r9 = 64
            goto L_0x04a9
        L_0x025e:
            r18 = r2
            float r2 = r14.B
            float r2 = r1.getFloat(r10, r2)
            r9 = 63
            goto L_0x0416
        L_0x026a:
            r18 = r2
            int r2 = r14.A
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 62
            goto L_0x04a9
        L_0x0276:
            r18 = r2
            float r2 = r12.f16479a
            float r2 = r1.getFloat(r10, r2)
            r9 = 60
            goto L_0x0416
        L_0x0282:
            r18 = r2
            int r2 = r14.f16428c0
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 59
            goto L_0x04a9
        L_0x028e:
            r18 = r2
            int r2 = r14.f16426b0
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 58
            goto L_0x04a9
        L_0x029a:
            r18 = r2
            int r2 = r14.f16424a0
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 57
            goto L_0x04a9
        L_0x02a6:
            r18 = r2
            int r2 = r14.Z
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 56
            goto L_0x04a9
        L_0x02b2:
            r18 = r2
            int r2 = r14.Y
            int r2 = r1.getInt(r10, r2)
            r9 = 55
            goto L_0x04a9
        L_0x02be:
            r18 = r2
            int r2 = r14.X
            int r2 = r1.getInt(r10, r2)
            r9 = 54
            goto L_0x04a9
        L_0x02ca:
            r18 = r2
            float r2 = r12.f16489k
            float r2 = r1.getDimension(r10, r2)
            r9 = 53
            goto L_0x0416
        L_0x02d6:
            r18 = r2
            float r2 = r12.f16488j
            float r2 = r1.getDimension(r10, r2)
            r9 = 52
            goto L_0x0416
        L_0x02e2:
            r18 = r2
            float r2 = r12.f16487i
            float r2 = r1.getDimension(r10, r2)
            r9 = 51
            goto L_0x0416
        L_0x02ee:
            r18 = r2
            float r2 = r12.f16485g
            float r2 = r1.getDimension(r10, r2)
            r9 = 50
            goto L_0x0416
        L_0x02fa:
            r18 = r2
            float r2 = r12.f16484f
            float r2 = r1.getDimension(r10, r2)
            r9 = 49
            goto L_0x0416
        L_0x0306:
            r18 = r2
            float r2 = r12.f16483e
            float r2 = r1.getFloat(r10, r2)
            r9 = 48
            goto L_0x0416
        L_0x0312:
            r18 = r2
            float r2 = r12.f16482d
            float r2 = r1.getFloat(r10, r2)
            r9 = 47
            goto L_0x0416
        L_0x031e:
            r18 = r2
            float r2 = r12.f16481c
            float r2 = r1.getFloat(r10, r2)
            r9 = 46
            goto L_0x0416
        L_0x032a:
            r18 = r2
            float r2 = r12.f16480b
            float r2 = r1.getFloat(r10, r2)
            r9 = 45
            goto L_0x0416
        L_0x0336:
            r18 = r2
            r2 = 44
            r9 = 1
            r8.d(r2, r9)
            float r9 = r12.f16491m
            float r9 = r1.getDimension(r10, r9)
            r8.a(r2, r9)
            goto L_0x04ac
        L_0x0349:
            r18 = r2
            float r2 = r11.f16476c
            float r2 = r1.getFloat(r10, r2)
            r9 = 43
            goto L_0x0416
        L_0x0355:
            r18 = r2
            int r2 = r14.W
            int r2 = r1.getInt(r10, r2)
            r9 = 42
            goto L_0x04a9
        L_0x0361:
            r18 = r2
            int r2 = r14.V
            int r2 = r1.getInt(r10, r2)
            r9 = 41
            goto L_0x04a9
        L_0x036d:
            r18 = r2
            float r2 = r14.T
            float r2 = r1.getFloat(r10, r2)
            r9 = 40
            goto L_0x0416
        L_0x0379:
            r18 = r2
            float r2 = r14.U
            float r2 = r1.getFloat(r10, r2)
            r9 = 39
            goto L_0x0416
        L_0x0385:
            r18 = r2
            int r2 = r0.f16416a
            int r2 = r1.getResourceId(r10, r2)
            r0.f16416a = r2
            r9 = 38
            goto L_0x04a9
        L_0x0393:
            r18 = r2
            float r2 = r14.f16461x
            float r2 = r1.getFloat(r10, r2)
            r9 = 37
            goto L_0x0416
        L_0x039f:
            r18 = r2
            int r2 = r14.H
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 34
            goto L_0x04a9
        L_0x03ab:
            r18 = r2
            int r2 = r14.K
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 31
            goto L_0x04a9
        L_0x03b7:
            r18 = r2
            int r2 = r14.G
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 28
            goto L_0x04a9
        L_0x03c3:
            r18 = r2
            int r2 = r14.E
            int r2 = r1.getInt(r10, r2)
            r9 = 27
            goto L_0x04a9
        L_0x03cf:
            r18 = r2
            int r2 = r14.F
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 24
            goto L_0x04a9
        L_0x03db:
            r18 = r2
            int r2 = r14.f16425b
            int r2 = r1.getLayoutDimension(r10, r2)
            r9 = 23
            goto L_0x04a9
        L_0x03e7:
            r18 = r2
            int r2 = r11.f16474a
            int r2 = r1.getInt(r10, r2)
            r2 = r18[r2]
            r9 = 22
            goto L_0x04a9
        L_0x03f5:
            r18 = r2
            int r2 = r14.f16427c
            int r2 = r1.getLayoutDimension(r10, r2)
            r9 = 21
            goto L_0x04a9
        L_0x0401:
            r18 = r2
            float r2 = r14.f16460w
            float r2 = r1.getFloat(r10, r2)
            r9 = 20
            goto L_0x0416
        L_0x040c:
            r18 = r2
            float r2 = r14.f16433f
            float r2 = r1.getFloat(r10, r2)
            r9 = 19
        L_0x0416:
            r8.a(r9, r2)
            goto L_0x04ac
        L_0x041b:
            r18 = r2
            int r2 = r14.f16431e
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r9 = 18
            goto L_0x04a9
        L_0x0427:
            r18 = r2
            int r2 = r14.f16429d
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r9 = 17
            goto L_0x04a9
        L_0x0433:
            r18 = r2
            int r2 = r14.N
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 16
            goto L_0x04a9
        L_0x043f:
            r18 = r2
            int r2 = r14.R
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 15
            goto L_0x04a9
        L_0x044a:
            r18 = r2
            int r2 = r14.O
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 14
            goto L_0x04a9
        L_0x0455:
            r18 = r2
            int r2 = r14.M
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 13
            goto L_0x04a9
        L_0x0460:
            r18 = r2
            int r2 = r14.Q
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 12
            goto L_0x04a9
        L_0x046b:
            r18 = r2
            int r2 = r14.P
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 11
            goto L_0x04a9
        L_0x0476:
            r18 = r2
            int r2 = r14.J
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 8
            goto L_0x04a9
        L_0x0481:
            r18 = r2
            int r2 = r14.D
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r9 = 7
            goto L_0x04a9
        L_0x048b:
            r18 = r2
            int r2 = r14.C
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r9 = 6
            goto L_0x04a9
        L_0x0495:
            r18 = r2
            r2 = 5
        L_0x0498:
            java.lang.String r9 = r1.getString(r10)
            r8.c(r2, r9)
            goto L_0x04ac
        L_0x04a0:
            r18 = r2
            int r2 = r14.I
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r9 = 2
        L_0x04a9:
            r8.b(r9, r2)
        L_0x04ac:
            r9 = r16
            r16 = r8
        L_0x04b0:
            int r2 = r17 + 1
            r10 = r21
            r8 = r16
            r16 = r9
            r9 = r2
            r2 = r18
            goto L_0x0046
        L_0x04bd:
            r18 = r2
            int r2 = r1.getIndexCount()
            r8 = 0
        L_0x04c4:
            if (r8 >= r2) goto L_0x09f4
            int r10 = r1.getIndex(r8)
            r21 = r2
            r2 = 1
            if (r10 == r2) goto L_0x04e4
            r2 = 23
            if (r2 == r10) goto L_0x04e4
            r2 = 24
            if (r2 == r10) goto L_0x04e6
            r13.getClass()
            r14.getClass()
            r11.getClass()
            r12.getClass()
            goto L_0x04e6
        L_0x04e4:
            r2 = 24
        L_0x04e6:
            int r16 = r3.get(r10)
            switch(r16) {
                case 1: goto L_0x09e1;
                case 2: goto L_0x09d5;
                case 3: goto L_0x09c9;
                case 4: goto L_0x09bd;
                case 5: goto L_0x09b3;
                case 6: goto L_0x09a7;
                case 7: goto L_0x099b;
                case 8: goto L_0x098f;
                case 9: goto L_0x0983;
                case 10: goto L_0x0976;
                case 11: goto L_0x0969;
                case 12: goto L_0x095c;
                case 13: goto L_0x094f;
                case 14: goto L_0x0942;
                case 15: goto L_0x0935;
                case 16: goto L_0x0928;
                case 17: goto L_0x091b;
                case 18: goto L_0x090e;
                case 19: goto L_0x0901;
                case 20: goto L_0x08f4;
                case 21: goto L_0x08e7;
                case 22: goto L_0x08d8;
                case 23: goto L_0x08cb;
                case 24: goto L_0x08be;
                case 25: goto L_0x08b1;
                case 26: goto L_0x08a4;
                case 27: goto L_0x0897;
                case 28: goto L_0x088a;
                case 29: goto L_0x087d;
                case 30: goto L_0x0870;
                case 31: goto L_0x0863;
                case 32: goto L_0x0856;
                case 33: goto L_0x0849;
                case 34: goto L_0x083c;
                case 35: goto L_0x082f;
                case 36: goto L_0x0822;
                case 37: goto L_0x0815;
                case 38: goto L_0x0808;
                case 39: goto L_0x07fb;
                case 40: goto L_0x07ee;
                case 41: goto L_0x07e1;
                case 42: goto L_0x07d4;
                case 43: goto L_0x07c7;
                case 44: goto L_0x07b7;
                case 45: goto L_0x07aa;
                case 46: goto L_0x079d;
                case 47: goto L_0x0790;
                case 48: goto L_0x0783;
                case 49: goto L_0x0776;
                case 50: goto L_0x0769;
                case 51: goto L_0x075c;
                case 52: goto L_0x074f;
                case 53: goto L_0x0742;
                case 54: goto L_0x0735;
                case 55: goto L_0x0728;
                case 56: goto L_0x071b;
                case 57: goto L_0x070e;
                case 58: goto L_0x0701;
                case 59: goto L_0x06f4;
                case 60: goto L_0x06e7;
                case 61: goto L_0x06da;
                case 62: goto L_0x06cd;
                case 63: goto L_0x06c0;
                case 64: goto L_0x06b3;
                case 65: goto L_0x0698;
                case 66: goto L_0x068b;
                case 67: goto L_0x067d;
                case 68: goto L_0x066f;
                case 69: goto L_0x0662;
                case 70: goto L_0x0655;
                case 71: goto L_0x064d;
                case 72: goto L_0x0640;
                case 73: goto L_0x0633;
                case 74: goto L_0x0628;
                case 75: goto L_0x061b;
                case 76: goto L_0x060e;
                case 77: goto L_0x0603;
                case 78: goto L_0x05f6;
                case 79: goto L_0x05e9;
                case 80: goto L_0x05dc;
                case 81: goto L_0x05cf;
                case 82: goto L_0x05c2;
                case 83: goto L_0x05b5;
                case 84: goto L_0x05a8;
                case 85: goto L_0x059b;
                case 86: goto L_0x0567;
                case 87: goto L_0x0545;
                case 88: goto L_0x04ed;
                case 89: goto L_0x04ed;
                case 90: goto L_0x04ed;
                case 91: goto L_0x053a;
                case 92: goto L_0x0531;
                case 93: goto L_0x0528;
                case 94: goto L_0x051f;
                case 95: goto L_0x051a;
                case 96: goto L_0x0518;
                case 97: goto L_0x050f;
                default: goto L_0x04ed;
            }
        L_0x04ed:
            r16 = r4
            r4 = 1
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            java.lang.String r4 = java.lang.Integer.toHexString(r10)
            r2.append(r4)
            r2.append(r6)
            int r4 = r3.get(r10)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r7, r2)
            goto L_0x09ec
        L_0x050f:
            int r2 = r14.f16452o0
            int r2 = r1.getInt(r10, r2)
            r14.f16452o0 = r2
            goto L_0x0542
        L_0x0518:
            r2 = 1
            goto L_0x051b
        L_0x051a:
            r2 = 0
        L_0x051b:
            g(r14, r1, r10, r2)
            goto L_0x0542
        L_0x051f:
            int r2 = r14.S
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.S = r2
            goto L_0x0542
        L_0x0528:
            int r2 = r14.L
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.L = r2
            goto L_0x0542
        L_0x0531:
            int r2 = r14.f16455r
            int r2 = f(r1, r10, r2)
            r14.f16455r = r2
            goto L_0x0542
        L_0x053a:
            int r2 = r14.f16454q
            int r2 = f(r1, r10, r2)
            r14.f16454q = r2
        L_0x0542:
            r16 = r4
            goto L_0x0564
        L_0x0545:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r4)
            r16 = r4
            java.lang.String r4 = java.lang.Integer.toHexString(r10)
            r2.append(r4)
            r2.append(r6)
            int r4 = r3.get(r10)
            r2.append(r4)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r7, r2)
        L_0x0564:
            r4 = -1
            goto L_0x09ec
        L_0x0567:
            r16 = r4
            android.util.TypedValue r2 = r1.peekValue(r10)
            int r2 = r2.type
            r4 = 1
            if (r2 != r4) goto L_0x057b
            r4 = -1
            int r2 = r1.getResourceId(r10, r4)
            r13.f16473i = r2
            goto L_0x09ec
        L_0x057b:
            r4 = 3
            if (r2 != r4) goto L_0x0593
            java.lang.String r2 = r1.getString(r10)
            r13.f16472h = r2
            int r2 = r2.indexOf(r15)
            if (r2 <= 0) goto L_0x09ec
            r2 = -1
            int r4 = r1.getResourceId(r10, r2)
            r13.f16473i = r4
            goto L_0x0693
        L_0x0593:
            r2 = -1
            int r4 = r13.f16473i
            r1.getInteger(r10, r4)
            goto L_0x0693
        L_0x059b:
            r16 = r4
            r2 = -1
            float r4 = r13.f16470f
            float r4 = r1.getFloat(r10, r4)
            r13.f16470f = r4
            goto L_0x09ec
        L_0x05a8:
            r16 = r4
            r2 = -1
            int r4 = r13.f16471g
            int r4 = r1.getInteger(r10, r4)
            r13.f16471g = r4
            goto L_0x09ec
        L_0x05b5:
            r16 = r4
            r2 = -1
            int r4 = r12.f16486h
            int r4 = f(r1, r10, r4)
            r12.f16486h = r4
            goto L_0x09ec
        L_0x05c2:
            r16 = r4
            r2 = -1
            int r4 = r13.f16466b
            int r4 = r1.getInteger(r10, r4)
            r13.f16466b = r4
            goto L_0x09ec
        L_0x05cf:
            r16 = r4
            r2 = -1
            boolean r4 = r14.f16448m0
            boolean r4 = r1.getBoolean(r10, r4)
            r14.f16448m0 = r4
            goto L_0x09ec
        L_0x05dc:
            r16 = r4
            r2 = -1
            boolean r4 = r14.f16446l0
            boolean r4 = r1.getBoolean(r10, r4)
            r14.f16446l0 = r4
            goto L_0x09ec
        L_0x05e9:
            r16 = r4
            r2 = -1
            float r4 = r13.f16468d
            float r4 = r1.getFloat(r10, r4)
            r13.f16468d = r4
            goto L_0x09ec
        L_0x05f6:
            r16 = r4
            r2 = -1
            int r4 = r11.f16475b
            int r4 = r1.getInt(r10, r4)
            r11.f16475b = r4
            goto L_0x09ec
        L_0x0603:
            r16 = r4
            r2 = -1
            java.lang.String r4 = r1.getString(r10)
            r14.f16444k0 = r4
            goto L_0x09ec
        L_0x060e:
            r16 = r4
            r2 = -1
            int r4 = r13.f16467c
            int r4 = r1.getInt(r10, r4)
            r13.f16467c = r4
            goto L_0x09ec
        L_0x061b:
            r16 = r4
            r2 = -1
            boolean r4 = r14.f16450n0
            boolean r4 = r1.getBoolean(r10, r4)
            r14.f16450n0 = r4
            goto L_0x09ec
        L_0x0628:
            r16 = r4
            r2 = -1
            java.lang.String r4 = r1.getString(r10)
            r14.f16442j0 = r4
            goto L_0x09ec
        L_0x0633:
            r16 = r4
            r2 = -1
            int r4 = r14.f16436g0
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.f16436g0 = r4
            goto L_0x09ec
        L_0x0640:
            r16 = r4
            r2 = -1
            int r4 = r14.f16434f0
            int r4 = r1.getInt(r10, r4)
            r14.f16434f0 = r4
            goto L_0x09ec
        L_0x064d:
            r16 = r4
            r2 = -1
            android.util.Log.e(r7, r5)
            goto L_0x09ec
        L_0x0655:
            r16 = r4
            r2 = -1
            r4 = 1065353216(0x3f800000, float:1.0)
            float r10 = r1.getFloat(r10, r4)
            r14.f16432e0 = r10
            goto L_0x09ec
        L_0x0662:
            r16 = r4
            r2 = -1
            r4 = 1065353216(0x3f800000, float:1.0)
            float r10 = r1.getFloat(r10, r4)
            r14.f16430d0 = r10
            goto L_0x09ec
        L_0x066f:
            r16 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r11.f16477d
            float r2 = r1.getFloat(r10, r2)
            r11.f16477d = r2
            goto L_0x09ec
        L_0x067d:
            r16 = r4
            r4 = 1065353216(0x3f800000, float:1.0)
            float r2 = r13.f16469e
            float r2 = r1.getFloat(r10, r2)
            r13.f16469e = r2
            goto L_0x09ec
        L_0x068b:
            r16 = r4
            r2 = 0
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.getInt(r10, r2)
        L_0x0693:
            r13.getClass()
            goto L_0x09ec
        L_0x0698:
            r16 = r4
            r2 = 0
            android.util.TypedValue r4 = r1.peekValue(r10)
            int r4 = r4.type
            r2 = 3
            if (r4 != r2) goto L_0x06a9
            r1.getString(r10)
            r2 = 0
            goto L_0x0693
        L_0x06a9:
            java.lang.String[] r4 = t.a.f14481b
            r2 = 0
            int r10 = r1.getInteger(r10, r2)
            r4 = r4[r10]
            goto L_0x0693
        L_0x06b3:
            r16 = r4
            r2 = 0
            int r4 = r13.f16465a
            int r4 = f(r1, r10, r4)
            r13.f16465a = r4
            goto L_0x09ec
        L_0x06c0:
            r16 = r4
            r2 = 0
            float r4 = r14.B
            float r4 = r1.getFloat(r10, r4)
            r14.B = r4
            goto L_0x09ec
        L_0x06cd:
            r16 = r4
            r2 = 0
            int r4 = r14.A
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.A = r4
            goto L_0x09ec
        L_0x06da:
            r16 = r4
            r2 = 0
            int r4 = r14.f16463z
            int r4 = f(r1, r10, r4)
            r14.f16463z = r4
            goto L_0x09ec
        L_0x06e7:
            r16 = r4
            r2 = 0
            float r4 = r12.f16479a
            float r4 = r1.getFloat(r10, r4)
            r12.f16479a = r4
            goto L_0x09ec
        L_0x06f4:
            r16 = r4
            r2 = 0
            int r4 = r14.f16428c0
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.f16428c0 = r4
            goto L_0x09ec
        L_0x0701:
            r16 = r4
            r2 = 0
            int r4 = r14.f16426b0
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.f16426b0 = r4
            goto L_0x09ec
        L_0x070e:
            r16 = r4
            r2 = 0
            int r4 = r14.f16424a0
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.f16424a0 = r4
            goto L_0x09ec
        L_0x071b:
            r16 = r4
            r2 = 0
            int r4 = r14.Z
            int r4 = r1.getDimensionPixelSize(r10, r4)
            r14.Z = r4
            goto L_0x09ec
        L_0x0728:
            r16 = r4
            r2 = 0
            int r4 = r14.Y
            int r4 = r1.getInt(r10, r4)
            r14.Y = r4
            goto L_0x09ec
        L_0x0735:
            r16 = r4
            r2 = 0
            int r4 = r14.X
            int r4 = r1.getInt(r10, r4)
            r14.X = r4
            goto L_0x09ec
        L_0x0742:
            r16 = r4
            r2 = 0
            float r4 = r12.f16489k
            float r4 = r1.getDimension(r10, r4)
            r12.f16489k = r4
            goto L_0x09ec
        L_0x074f:
            r16 = r4
            r2 = 0
            float r4 = r12.f16488j
            float r4 = r1.getDimension(r10, r4)
            r12.f16488j = r4
            goto L_0x09ec
        L_0x075c:
            r16 = r4
            r2 = 0
            float r4 = r12.f16487i
            float r4 = r1.getDimension(r10, r4)
            r12.f16487i = r4
            goto L_0x09ec
        L_0x0769:
            r16 = r4
            r2 = 0
            float r4 = r12.f16485g
            float r4 = r1.getDimension(r10, r4)
            r12.f16485g = r4
            goto L_0x09ec
        L_0x0776:
            r16 = r4
            r2 = 0
            float r4 = r12.f16484f
            float r4 = r1.getDimension(r10, r4)
            r12.f16484f = r4
            goto L_0x09ec
        L_0x0783:
            r16 = r4
            r2 = 0
            float r4 = r12.f16483e
            float r4 = r1.getFloat(r10, r4)
            r12.f16483e = r4
            goto L_0x09ec
        L_0x0790:
            r16 = r4
            r2 = 0
            float r4 = r12.f16482d
            float r4 = r1.getFloat(r10, r4)
            r12.f16482d = r4
            goto L_0x09ec
        L_0x079d:
            r16 = r4
            r2 = 0
            float r4 = r12.f16481c
            float r4 = r1.getFloat(r10, r4)
            r12.f16481c = r4
            goto L_0x09ec
        L_0x07aa:
            r16 = r4
            r2 = 0
            float r4 = r12.f16480b
            float r4 = r1.getFloat(r10, r4)
            r12.f16480b = r4
            goto L_0x09ec
        L_0x07b7:
            r16 = r4
            r2 = 0
            r4 = 1
            r12.f16490l = r4
            float r2 = r12.f16491m
            float r2 = r1.getDimension(r10, r2)
            r12.f16491m = r2
            goto L_0x09ec
        L_0x07c7:
            r16 = r4
            r4 = 1
            float r2 = r11.f16476c
            float r2 = r1.getFloat(r10, r2)
            r11.f16476c = r2
            goto L_0x09ec
        L_0x07d4:
            r16 = r4
            r4 = 1
            int r2 = r14.W
            int r2 = r1.getInt(r10, r2)
            r14.W = r2
            goto L_0x09ec
        L_0x07e1:
            r16 = r4
            r4 = 1
            int r2 = r14.V
            int r2 = r1.getInt(r10, r2)
            r14.V = r2
            goto L_0x09ec
        L_0x07ee:
            r16 = r4
            r4 = 1
            float r2 = r14.T
            float r2 = r1.getFloat(r10, r2)
            r14.T = r2
            goto L_0x09ec
        L_0x07fb:
            r16 = r4
            r4 = 1
            float r2 = r14.U
            float r2 = r1.getFloat(r10, r2)
            r14.U = r2
            goto L_0x09ec
        L_0x0808:
            r16 = r4
            r4 = 1
            int r2 = r0.f16416a
            int r2 = r1.getResourceId(r10, r2)
            r0.f16416a = r2
            goto L_0x09ec
        L_0x0815:
            r16 = r4
            r4 = 1
            float r2 = r14.f16461x
            float r2 = r1.getFloat(r10, r2)
            r14.f16461x = r2
            goto L_0x09ec
        L_0x0822:
            r16 = r4
            r4 = 1
            int r2 = r14.f16445l
            int r2 = f(r1, r10, r2)
            r14.f16445l = r2
            goto L_0x09ec
        L_0x082f:
            r16 = r4
            r4 = 1
            int r2 = r14.f16447m
            int r2 = f(r1, r10, r2)
            r14.f16447m = r2
            goto L_0x09ec
        L_0x083c:
            r16 = r4
            r4 = 1
            int r2 = r14.H
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.H = r2
            goto L_0x09ec
        L_0x0849:
            r16 = r4
            r4 = 1
            int r2 = r14.f16457t
            int r2 = f(r1, r10, r2)
            r14.f16457t = r2
            goto L_0x09ec
        L_0x0856:
            r16 = r4
            r4 = 1
            int r2 = r14.f16456s
            int r2 = f(r1, r10, r2)
            r14.f16456s = r2
            goto L_0x09ec
        L_0x0863:
            r16 = r4
            r4 = 1
            int r2 = r14.K
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.K = r2
            goto L_0x09ec
        L_0x0870:
            r16 = r4
            r4 = 1
            int r2 = r14.f16443k
            int r2 = f(r1, r10, r2)
            r14.f16443k = r2
            goto L_0x09ec
        L_0x087d:
            r16 = r4
            r4 = 1
            int r2 = r14.f16441j
            int r2 = f(r1, r10, r2)
            r14.f16441j = r2
            goto L_0x09ec
        L_0x088a:
            r16 = r4
            r4 = 1
            int r2 = r14.G
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.G = r2
            goto L_0x09ec
        L_0x0897:
            r16 = r4
            r4 = 1
            int r2 = r14.E
            int r2 = r1.getInt(r10, r2)
            r14.E = r2
            goto L_0x09ec
        L_0x08a4:
            r16 = r4
            r4 = 1
            int r2 = r14.f16439i
            int r2 = f(r1, r10, r2)
            r14.f16439i = r2
            goto L_0x09ec
        L_0x08b1:
            r16 = r4
            r4 = 1
            int r2 = r14.f16437h
            int r2 = f(r1, r10, r2)
            r14.f16437h = r2
            goto L_0x09ec
        L_0x08be:
            r16 = r4
            r4 = 1
            int r2 = r14.F
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.F = r2
            goto L_0x09ec
        L_0x08cb:
            r16 = r4
            r4 = 1
            int r2 = r14.f16425b
            int r2 = r1.getLayoutDimension(r10, r2)
            r14.f16425b = r2
            goto L_0x09ec
        L_0x08d8:
            r16 = r4
            r4 = 1
            int r2 = r11.f16474a
            int r2 = r1.getInt(r10, r2)
            r2 = r18[r2]
            r11.f16474a = r2
            goto L_0x09ec
        L_0x08e7:
            r16 = r4
            r4 = 1
            int r2 = r14.f16427c
            int r2 = r1.getLayoutDimension(r10, r2)
            r14.f16427c = r2
            goto L_0x09ec
        L_0x08f4:
            r16 = r4
            r4 = 1
            float r2 = r14.f16460w
            float r2 = r1.getFloat(r10, r2)
            r14.f16460w = r2
            goto L_0x09ec
        L_0x0901:
            r16 = r4
            r4 = 1
            float r2 = r14.f16433f
            float r2 = r1.getFloat(r10, r2)
            r14.f16433f = r2
            goto L_0x09ec
        L_0x090e:
            r16 = r4
            r4 = 1
            int r2 = r14.f16431e
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r14.f16431e = r2
            goto L_0x09ec
        L_0x091b:
            r16 = r4
            r4 = 1
            int r2 = r14.f16429d
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r14.f16429d = r2
            goto L_0x09ec
        L_0x0928:
            r16 = r4
            r4 = 1
            int r2 = r14.N
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.N = r2
            goto L_0x09ec
        L_0x0935:
            r16 = r4
            r4 = 1
            int r2 = r14.R
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.R = r2
            goto L_0x09ec
        L_0x0942:
            r16 = r4
            r4 = 1
            int r2 = r14.O
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.O = r2
            goto L_0x09ec
        L_0x094f:
            r16 = r4
            r4 = 1
            int r2 = r14.M
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.M = r2
            goto L_0x09ec
        L_0x095c:
            r16 = r4
            r4 = 1
            int r2 = r14.Q
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.Q = r2
            goto L_0x09ec
        L_0x0969:
            r16 = r4
            r4 = 1
            int r2 = r14.P
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.P = r2
            goto L_0x09ec
        L_0x0976:
            r16 = r4
            r4 = 1
            int r2 = r14.f16458u
            int r2 = f(r1, r10, r2)
            r14.f16458u = r2
            goto L_0x09ec
        L_0x0983:
            r16 = r4
            r4 = 1
            int r2 = r14.f16459v
            int r2 = f(r1, r10, r2)
            r14.f16459v = r2
            goto L_0x09ec
        L_0x098f:
            r16 = r4
            r4 = 1
            int r2 = r14.J
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.J = r2
            goto L_0x09ec
        L_0x099b:
            r16 = r4
            r4 = 1
            int r2 = r14.D
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r14.D = r2
            goto L_0x09ec
        L_0x09a7:
            r16 = r4
            r4 = 1
            int r2 = r14.C
            int r2 = r1.getDimensionPixelOffset(r10, r2)
            r14.C = r2
            goto L_0x09ec
        L_0x09b3:
            r16 = r4
            r4 = 1
            java.lang.String r2 = r1.getString(r10)
            r14.f16462y = r2
            goto L_0x09ec
        L_0x09bd:
            r16 = r4
            r4 = 1
            int r2 = r14.f16449n
            int r2 = f(r1, r10, r2)
            r14.f16449n = r2
            goto L_0x09ec
        L_0x09c9:
            r16 = r4
            r4 = 1
            int r2 = r14.f16451o
            int r2 = f(r1, r10, r2)
            r14.f16451o = r2
            goto L_0x09ec
        L_0x09d5:
            r16 = r4
            r4 = 1
            int r2 = r14.I
            int r2 = r1.getDimensionPixelSize(r10, r2)
            r14.I = r2
            goto L_0x09ec
        L_0x09e1:
            r16 = r4
            r4 = 1
            int r2 = r14.f16453p
            int r2 = f(r1, r10, r2)
            r14.f16453p = r2
        L_0x09ec:
            int r8 = r8 + 1
            r2 = r21
            r4 = r16
            goto L_0x04c4
        L_0x09f4:
            java.lang.String r2 = r14.f16442j0
            if (r2 == 0) goto L_0x09fb
            r2 = 0
            r14.f16440i0 = r2
        L_0x09fb:
            r1.recycle()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x.m.d(android.content.Context, android.util.AttributeSet, boolean):x.h");
    }

    public static int f(TypedArray typedArray, int i10, int i11) {
        int resourceId = typedArray.getResourceId(i10, i11);
        return resourceId == -1 ? typedArray.getInt(i10, -1) : resourceId;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x0040  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void g(java.lang.Object r8, android.content.res.TypedArray r9, int r10, int r11) {
        /*
            if (r8 != 0) goto L_0x0003
            return
        L_0x0003:
            android.util.TypedValue r0 = r9.peekValue(r10)
            int r0 = r0.type
            r1 = 0
            r2 = 3
            r3 = 21
            r4 = 23
            r5 = 1
            r6 = -1
            r7 = 5
            if (r0 == r2) goto L_0x0069
            if (r0 == r7) goto L_0x0029
            int r9 = r9.getInt(r10, r1)
            r10 = -4
            r0 = -2
            if (r9 == r10) goto L_0x0027
            r10 = -3
            if (r9 == r10) goto L_0x0025
            if (r9 == r0) goto L_0x002d
            if (r9 == r6) goto L_0x002d
        L_0x0025:
            r0 = 0
            goto L_0x002e
        L_0x0027:
            r1 = 1
            goto L_0x002e
        L_0x0029:
            int r9 = r9.getDimensionPixelSize(r10, r1)
        L_0x002d:
            r0 = r9
        L_0x002e:
            boolean r9 = r8 instanceof x.d
            if (r9 == 0) goto L_0x0040
            x.d r8 = (x.d) r8
            if (r11 != 0) goto L_0x003b
            r8.width = r0
            r8.W = r1
            goto L_0x0068
        L_0x003b:
            r8.height = r0
            r8.X = r1
            goto L_0x0068
        L_0x0040:
            boolean r9 = r8 instanceof x.i
            if (r9 == 0) goto L_0x0052
            x.i r8 = (x.i) r8
            if (r11 != 0) goto L_0x004d
            r8.f16425b = r0
            r8.f16446l0 = r1
            goto L_0x0068
        L_0x004d:
            r8.f16427c = r0
            r8.f16448m0 = r1
            goto L_0x0068
        L_0x0052:
            boolean r9 = r8 instanceof x.g
            if (r9 == 0) goto L_0x0068
            x.g r8 = (x.g) r8
            if (r11 != 0) goto L_0x0060
            r8.b(r4, r0)
            r9 = 80
            goto L_0x0065
        L_0x0060:
            r8.b(r3, r0)
            r9 = 81
        L_0x0065:
            r8.d(r9, r1)
        L_0x0068:
            return
        L_0x0069:
            java.lang.String r9 = r9.getString(r10)
            if (r9 != 0) goto L_0x0071
            goto L_0x016b
        L_0x0071:
            r10 = 61
            int r10 = r9.indexOf(r10)
            int r0 = r9.length()
            if (r10 <= 0) goto L_0x016b
            int r0 = r0 + r6
            if (r10 >= r0) goto L_0x016b
            java.lang.String r0 = r9.substring(r1, r10)
            int r10 = r10 + r5
            java.lang.String r9 = r9.substring(r10)
            int r10 = r9.length()
            if (r10 <= 0) goto L_0x016b
            java.lang.String r10 = r0.trim()
            java.lang.String r9 = r9.trim()
            java.lang.String r0 = "ratio"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x00c6
            boolean r10 = r8 instanceof x.d
            if (r10 == 0) goto L_0x00b1
            x.d r8 = (x.d) r8
            if (r11 != 0) goto L_0x00aa
            r8.width = r1
            goto L_0x00ac
        L_0x00aa:
            r8.height = r1
        L_0x00ac:
            h(r8, r9)
            goto L_0x016b
        L_0x00b1:
            boolean r10 = r8 instanceof x.i
            if (r10 == 0) goto L_0x00bb
            x.i r8 = (x.i) r8
            r8.f16462y = r9
            goto L_0x016b
        L_0x00bb:
            boolean r10 = r8 instanceof x.g
            if (r10 == 0) goto L_0x016b
            x.g r8 = (x.g) r8
            r8.c(r7, r9)
            goto L_0x016b
        L_0x00c6:
            java.lang.String r0 = "weight"
            boolean r0 = r0.equalsIgnoreCase(r10)
            if (r0 == 0) goto L_0x0111
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x016b }
            boolean r10 = r8 instanceof x.d     // Catch:{ NumberFormatException -> 0x016b }
            if (r10 == 0) goto L_0x00e6
            x.d r8 = (x.d) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x00e0
            r8.width = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.H = r9     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x00e0:
            r8.height = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.I = r9     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x00e6:
            boolean r10 = r8 instanceof x.i     // Catch:{ NumberFormatException -> 0x016b }
            if (r10 == 0) goto L_0x00fa
            x.i r8 = (x.i) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x00f4
            r8.f16425b = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.U = r9     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x00f4:
            r8.f16427c = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.T = r9     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x00fa:
            boolean r10 = r8 instanceof x.g     // Catch:{ NumberFormatException -> 0x016b }
            if (r10 == 0) goto L_0x016b
            x.g r8 = (x.g) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x0108
            r8.b(r4, r1)     // Catch:{ NumberFormatException -> 0x016b }
            r10 = 39
            goto L_0x010d
        L_0x0108:
            r8.b(r3, r1)     // Catch:{ NumberFormatException -> 0x016b }
            r10 = 40
        L_0x010d:
            r8.a(r10, r9)     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x0111:
            java.lang.String r0 = "parent"
            boolean r10 = r0.equalsIgnoreCase(r10)
            if (r10 == 0) goto L_0x016b
            float r9 = java.lang.Float.parseFloat(r9)     // Catch:{ NumberFormatException -> 0x016b }
            r10 = 1065353216(0x3f800000, float:1.0)
            float r9 = java.lang.Math.min(r10, r9)     // Catch:{ NumberFormatException -> 0x016b }
            r10 = 0
            float r9 = java.lang.Math.max(r10, r9)     // Catch:{ NumberFormatException -> 0x016b }
            boolean r10 = r8 instanceof x.d     // Catch:{ NumberFormatException -> 0x016b }
            r0 = 2
            if (r10 == 0) goto L_0x013f
            x.d r8 = (x.d) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x0138
            r8.width = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.R = r9     // Catch:{ NumberFormatException -> 0x016b }
            r8.L = r0     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x0138:
            r8.height = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.S = r9     // Catch:{ NumberFormatException -> 0x016b }
            r8.M = r0     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x013f:
            boolean r10 = r8 instanceof x.i     // Catch:{ NumberFormatException -> 0x016b }
            if (r10 == 0) goto L_0x0155
            x.i r8 = (x.i) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x014e
            r8.f16425b = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.f16430d0 = r9     // Catch:{ NumberFormatException -> 0x016b }
            r8.X = r0     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x014e:
            r8.f16427c = r1     // Catch:{ NumberFormatException -> 0x016b }
            r8.f16432e0 = r9     // Catch:{ NumberFormatException -> 0x016b }
            r8.Y = r0     // Catch:{ NumberFormatException -> 0x016b }
            goto L_0x016b
        L_0x0155:
            boolean r9 = r8 instanceof x.g     // Catch:{ NumberFormatException -> 0x016b }
            if (r9 == 0) goto L_0x016b
            x.g r8 = (x.g) r8     // Catch:{ NumberFormatException -> 0x016b }
            if (r11 != 0) goto L_0x0163
            r8.b(r4, r1)     // Catch:{ NumberFormatException -> 0x016b }
            r9 = 54
            goto L_0x0168
        L_0x0163:
            r8.b(r3, r1)     // Catch:{ NumberFormatException -> 0x016b }
            r9 = 55
        L_0x0168:
            r8.b(r9, r0)     // Catch:{ NumberFormatException -> 0x016b }
        L_0x016b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: x.m.g(java.lang.Object, android.content.res.TypedArray, int, int):void");
    }

    public static void h(d dVar, String str) {
        if (str != null) {
            int length = str.length();
            int indexOf = str.indexOf(44);
            int i10 = 0;
            int i11 = -1;
            if (indexOf > 0 && indexOf < length - 1) {
                String substring = str.substring(0, indexOf);
                if (!substring.equalsIgnoreCase("W")) {
                    i10 = substring.equalsIgnoreCase("H") ? 1 : -1;
                }
                i11 = i10;
                i10 = indexOf + 1;
            }
            int indexOf2 = str.indexOf(58);
            if (indexOf2 < 0 || indexOf2 >= length - 1) {
                String substring2 = str.substring(i10);
                if (substring2.length() > 0) {
                    Float.parseFloat(substring2);
                }
            } else {
                String substring3 = str.substring(i10, indexOf2);
                String substring4 = str.substring(indexOf2 + 1);
                if (substring3.length() > 0 && substring4.length() > 0) {
                    try {
                        float parseFloat = Float.parseFloat(substring3);
                        float parseFloat2 = Float.parseFloat(substring4);
                        if (parseFloat > 0.0f && parseFloat2 > 0.0f) {
                            if (i11 == 1) {
                                Math.abs(parseFloat2 / parseFloat);
                            } else {
                                Math.abs(parseFloat / parseFloat2);
                            }
                        }
                    } catch (NumberFormatException unused) {
                    }
                }
            }
        }
        dVar.G = str;
    }

    public final void a(ConstraintLayout constraintLayout) {
        int i10;
        String str;
        int i11;
        StringBuilder sb2;
        String str2;
        m mVar = this;
        ConstraintLayout constraintLayout2 = constraintLayout;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = mVar.f16497c;
        HashSet hashSet = new HashSet(hashMap.keySet());
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = constraintLayout2.getChildAt(i12);
            int id = childAt.getId();
            if (!hashMap.containsKey(Integer.valueOf(id))) {
                StringBuilder sb3 = new StringBuilder("id unknown ");
                try {
                    str2 = childAt.getContext().getResources().getResourceEntryName(childAt.getId());
                } catch (Exception unused) {
                    str2 = "UNKNOWN";
                }
                sb3.append(str2);
                Log.w("ConstraintSet", sb3.toString());
            } else if (mVar.f16496b && id == -1) {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            } else if (id != -1 && hashMap.containsKey(Integer.valueOf(id))) {
                hashSet.remove(Integer.valueOf(id));
                h hVar = (h) hashMap.get(Integer.valueOf(id));
                if (hVar != null) {
                    if (childAt instanceof Barrier) {
                        i iVar = hVar.f16419d;
                        iVar.f16438h0 = 1;
                        Barrier barrier = (Barrier) childAt;
                        barrier.setId(id);
                        barrier.setType(iVar.f16434f0);
                        barrier.setMargin(iVar.f16436g0);
                        barrier.setAllowsGoneWidget(iVar.f16450n0);
                        int[] iArr = iVar.f16440i0;
                        if (iArr != null) {
                            barrier.setReferencedIds(iArr);
                        } else {
                            String str3 = iVar.f16442j0;
                            if (str3 != null) {
                                int[] c10 = c(barrier, str3);
                                iVar.f16440i0 = c10;
                                barrier.setReferencedIds(c10);
                            }
                        }
                    }
                    d dVar = (d) childAt.getLayoutParams();
                    dVar.a();
                    hVar.a(dVar);
                    HashMap hashMap2 = hVar.f16421f;
                    Class<?> cls = childAt.getClass();
                    Iterator it = hashMap2.keySet().iterator();
                    while (it.hasNext()) {
                        String str4 = (String) it.next();
                        a aVar = (a) hashMap2.get(str4);
                        HashMap hashMap3 = hashMap2;
                        if (!aVar.f16340a) {
                            str = h.m("set", str4);
                        } else {
                            str = str4;
                        }
                        Iterator it2 = it;
                        try {
                            switch (i.a(aVar.f16341b)) {
                                case 0:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(childAt, new Object[]{Integer.valueOf(aVar.f16342c)});
                                    break;
                                case 1:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(childAt, new Object[]{Float.valueOf(aVar.f16343d)});
                                    break;
                                case 2:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(childAt, new Object[]{Integer.valueOf(aVar.f16346g)});
                                    break;
                                case 3:
                                    i11 = childCount;
                                    Method method = cls.getMethod(str, new Class[]{Drawable.class});
                                    ColorDrawable colorDrawable = new ColorDrawable();
                                    colorDrawable.setColor(aVar.f16346g);
                                    method.invoke(childAt, new Object[]{colorDrawable});
                                    break;
                                case 4:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{CharSequence.class}).invoke(childAt, new Object[]{aVar.f16344e});
                                    break;
                                case Constants.MAX_COMPATIBILITY_VERSION:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{Boolean.TYPE}).invoke(childAt, new Object[]{Boolean.valueOf(aVar.f16345f)});
                                    break;
                                case 6:
                                    i11 = childCount;
                                    cls.getMethod(str, new Class[]{Float.TYPE}).invoke(childAt, new Object[]{Float.valueOf(aVar.f16343d)});
                                    break;
                                case 7:
                                    i11 = childCount;
                                    try {
                                        cls.getMethod(str, new Class[]{Integer.TYPE}).invoke(childAt, new Object[]{Integer.valueOf(aVar.f16342c)});
                                    } catch (NoSuchMethodException e10) {
                                        e = e10;
                                        Log.e("TransitionLayout", e.getMessage());
                                        Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                                        Log.e("TransitionLayout", cls.getName() + " must have a method " + str);
                                        hashMap2 = hashMap3;
                                        it = it2;
                                        childCount = i11;
                                    } catch (IllegalAccessException e11) {
                                        e = e11;
                                        sb2 = new StringBuilder(" Custom Attribute \"");
                                        sb2.append(str4);
                                        sb2.append("\" not found on ");
                                        sb2.append(cls.getName());
                                        Log.e("TransitionLayout", sb2.toString());
                                        e.printStackTrace();
                                        hashMap2 = hashMap3;
                                        it = it2;
                                        childCount = i11;
                                    } catch (InvocationTargetException e12) {
                                        e = e12;
                                        sb2 = new StringBuilder(" Custom Attribute \"");
                                        sb2.append(str4);
                                        sb2.append("\" not found on ");
                                        sb2.append(cls.getName());
                                        Log.e("TransitionLayout", sb2.toString());
                                        e.printStackTrace();
                                        hashMap2 = hashMap3;
                                        it = it2;
                                        childCount = i11;
                                    }
                                default:
                                    i11 = childCount;
                                    break;
                            }
                        } catch (NoSuchMethodException e13) {
                            e = e13;
                            i11 = childCount;
                            Log.e("TransitionLayout", e.getMessage());
                            Log.e("TransitionLayout", " Custom Attribute \"" + str4 + "\" not found on " + cls.getName());
                            Log.e("TransitionLayout", cls.getName() + " must have a method " + str);
                            hashMap2 = hashMap3;
                            it = it2;
                            childCount = i11;
                        } catch (IllegalAccessException e14) {
                            e = e14;
                            i11 = childCount;
                            sb2 = new StringBuilder(" Custom Attribute \"");
                            sb2.append(str4);
                            sb2.append("\" not found on ");
                            sb2.append(cls.getName());
                            Log.e("TransitionLayout", sb2.toString());
                            e.printStackTrace();
                            hashMap2 = hashMap3;
                            it = it2;
                            childCount = i11;
                        } catch (InvocationTargetException e15) {
                            e = e15;
                            i11 = childCount;
                            sb2 = new StringBuilder(" Custom Attribute \"");
                            sb2.append(str4);
                            sb2.append("\" not found on ");
                            sb2.append(cls.getName());
                            Log.e("TransitionLayout", sb2.toString());
                            e.printStackTrace();
                            hashMap2 = hashMap3;
                            it = it2;
                            childCount = i11;
                        }
                    }
                    i10 = childCount;
                    childAt.setLayoutParams(dVar);
                    k kVar = hVar.f16417b;
                    if (kVar.f16475b == 0) {
                        childAt.setVisibility(kVar.f16474a);
                    }
                    childAt.setAlpha(kVar.f16476c);
                    l lVar = hVar.f16420e;
                    childAt.setRotation(lVar.f16479a);
                    childAt.setRotationX(lVar.f16480b);
                    childAt.setRotationY(lVar.f16481c);
                    childAt.setScaleX(lVar.f16482d);
                    childAt.setScaleY(lVar.f16483e);
                    if (lVar.f16486h != -1) {
                        View findViewById = ((View) childAt.getParent()).findViewById(lVar.f16486h);
                        if (findViewById != null) {
                            float bottom = ((float) (findViewById.getBottom() + findViewById.getTop())) / 2.0f;
                            float right = ((float) (findViewById.getRight() + findViewById.getLeft())) / 2.0f;
                            if (childAt.getRight() - childAt.getLeft() > 0 && childAt.getBottom() - childAt.getTop() > 0) {
                                childAt.setPivotX(right - ((float) childAt.getLeft()));
                                childAt.setPivotY(bottom - ((float) childAt.getTop()));
                            }
                        }
                    } else {
                        if (!Float.isNaN(lVar.f16484f)) {
                            childAt.setPivotX(lVar.f16484f);
                        }
                        if (!Float.isNaN(lVar.f16485g)) {
                            childAt.setPivotY(lVar.f16485g);
                        }
                    }
                    childAt.setTranslationX(lVar.f16487i);
                    childAt.setTranslationY(lVar.f16488j);
                    childAt.setTranslationZ(lVar.f16489k);
                    if (lVar.f16490l) {
                        childAt.setElevation(lVar.f16491m);
                    }
                    i12++;
                    mVar = this;
                    childCount = i10;
                }
            }
            i10 = childCount;
            i12++;
            mVar = this;
            childCount = i10;
        }
        int i13 = childCount;
        Iterator it3 = hashSet.iterator();
        while (it3.hasNext()) {
            Integer num = (Integer) it3.next();
            h hVar2 = (h) hashMap.get(num);
            if (hVar2 != null) {
                i iVar2 = hVar2.f16419d;
                if (iVar2.f16438h0 == 1) {
                    Barrier barrier2 = new Barrier(constraintLayout.getContext());
                    barrier2.setId(num.intValue());
                    int[] iArr2 = iVar2.f16440i0;
                    if (iArr2 != null) {
                        barrier2.setReferencedIds(iArr2);
                    } else {
                        String str5 = iVar2.f16442j0;
                        if (str5 != null) {
                            int[] c11 = c(barrier2, str5);
                            iVar2.f16440i0 = c11;
                            barrier2.setReferencedIds(c11);
                        }
                    }
                    barrier2.setType(iVar2.f16434f0);
                    barrier2.setMargin(iVar2.f16436g0);
                    q qVar = ConstraintLayout.f1168w;
                    d dVar2 = new d();
                    barrier2.i();
                    hVar2.a(dVar2);
                    constraintLayout2.addView(barrier2, dVar2);
                }
                if (iVar2.f16423a) {
                    Guideline guideline = new Guideline(constraintLayout.getContext());
                    guideline.setId(num.intValue());
                    q qVar2 = ConstraintLayout.f1168w;
                    d dVar3 = new d();
                    hVar2.a(dVar3);
                    constraintLayout2.addView(guideline, dVar3);
                }
            }
        }
        int i14 = i13;
        for (int i15 = 0; i15 < i14; i15++) {
            View childAt2 = constraintLayout2.getChildAt(i15);
            if (childAt2 instanceof b) {
                ((b) childAt2).e(constraintLayout2);
            }
        }
    }

    public final void b(ConstraintLayout constraintLayout) {
        int i10;
        int i11;
        a aVar;
        m mVar = this;
        int childCount = constraintLayout.getChildCount();
        HashMap hashMap = mVar.f16497c;
        hashMap.clear();
        int i12 = 0;
        while (i12 < childCount) {
            View childAt = constraintLayout.getChildAt(i12);
            d dVar = (d) childAt.getLayoutParams();
            int id = childAt.getId();
            if (!mVar.f16496b || id != -1) {
                if (!hashMap.containsKey(Integer.valueOf(id))) {
                    hashMap.put(Integer.valueOf(id), new h());
                }
                h hVar = (h) hashMap.get(Integer.valueOf(id));
                if (hVar == null) {
                    i10 = childCount;
                } else {
                    HashMap hashMap2 = mVar.f16495a;
                    HashMap hashMap3 = new HashMap();
                    Class<?> cls = childAt.getClass();
                    for (String str : hashMap2.keySet()) {
                        a aVar2 = (a) hashMap2.get(str);
                        try {
                            if (str.equals("BackgroundColor")) {
                                aVar = new a(aVar2, Integer.valueOf(((ColorDrawable) childAt.getBackground()).getColor()));
                                i11 = childCount;
                            } else {
                                i11 = childCount;
                                try {
                                    aVar = new a(aVar2, cls.getMethod("getMap" + str, new Class[0]).invoke(childAt, new Object[0]));
                                } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e10) {
                                    e = e10;
                                    e.printStackTrace();
                                    childCount = i11;
                                }
                            }
                            hashMap3.put(str, aVar);
                        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e11) {
                            e = e11;
                            i11 = childCount;
                            e.printStackTrace();
                            childCount = i11;
                        }
                        childCount = i11;
                    }
                    i10 = childCount;
                    hVar.f16421f = hashMap3;
                    hVar.f16416a = id;
                    int i13 = dVar.f16363e;
                    i iVar = hVar.f16419d;
                    iVar.f16437h = i13;
                    iVar.f16439i = dVar.f16365f;
                    iVar.f16441j = dVar.f16367g;
                    iVar.f16443k = dVar.f16369h;
                    iVar.f16445l = dVar.f16371i;
                    iVar.f16447m = dVar.f16373j;
                    iVar.f16449n = dVar.f16375k;
                    iVar.f16451o = dVar.f16377l;
                    iVar.f16453p = dVar.f16379m;
                    iVar.f16454q = dVar.f16381n;
                    iVar.f16455r = dVar.f16383o;
                    iVar.f16456s = dVar.f16389s;
                    iVar.f16457t = dVar.f16390t;
                    iVar.f16458u = dVar.f16391u;
                    iVar.f16459v = dVar.f16392v;
                    iVar.f16460w = dVar.E;
                    iVar.f16461x = dVar.F;
                    iVar.f16462y = dVar.G;
                    iVar.f16463z = dVar.f16385p;
                    iVar.A = dVar.f16387q;
                    iVar.B = dVar.f16388r;
                    iVar.C = dVar.T;
                    iVar.D = dVar.U;
                    iVar.E = dVar.V;
                    iVar.f16433f = dVar.f16359c;
                    iVar.f16429d = dVar.f16355a;
                    iVar.f16431e = dVar.f16357b;
                    iVar.f16425b = dVar.width;
                    iVar.f16427c = dVar.height;
                    iVar.F = dVar.leftMargin;
                    iVar.G = dVar.rightMargin;
                    iVar.H = dVar.topMargin;
                    iVar.I = dVar.bottomMargin;
                    iVar.L = dVar.D;
                    iVar.T = dVar.I;
                    iVar.U = dVar.H;
                    iVar.W = dVar.K;
                    iVar.V = dVar.J;
                    iVar.f16446l0 = dVar.W;
                    iVar.f16448m0 = dVar.X;
                    iVar.X = dVar.L;
                    iVar.Y = dVar.M;
                    iVar.Z = dVar.P;
                    iVar.f16424a0 = dVar.Q;
                    iVar.f16426b0 = dVar.N;
                    iVar.f16428c0 = dVar.O;
                    iVar.f16430d0 = dVar.R;
                    iVar.f16432e0 = dVar.S;
                    iVar.f16444k0 = dVar.Y;
                    iVar.N = dVar.f16394x;
                    iVar.P = dVar.f16396z;
                    iVar.M = dVar.f16393w;
                    iVar.O = dVar.f16395y;
                    iVar.R = dVar.A;
                    iVar.Q = dVar.B;
                    iVar.S = dVar.C;
                    iVar.f16452o0 = dVar.Z;
                    iVar.J = dVar.getMarginEnd();
                    iVar.K = dVar.getMarginStart();
                    int visibility = childAt.getVisibility();
                    k kVar = hVar.f16417b;
                    kVar.f16474a = visibility;
                    kVar.f16476c = childAt.getAlpha();
                    float rotation = childAt.getRotation();
                    l lVar = hVar.f16420e;
                    lVar.f16479a = rotation;
                    lVar.f16480b = childAt.getRotationX();
                    lVar.f16481c = childAt.getRotationY();
                    lVar.f16482d = childAt.getScaleX();
                    lVar.f16483e = childAt.getScaleY();
                    float pivotX = childAt.getPivotX();
                    float pivotY = childAt.getPivotY();
                    if (!(((double) pivotX) == 0.0d && ((double) pivotY) == 0.0d)) {
                        lVar.f16484f = pivotX;
                        lVar.f16485g = pivotY;
                    }
                    lVar.f16487i = childAt.getTranslationX();
                    lVar.f16488j = childAt.getTranslationY();
                    lVar.f16489k = childAt.getTranslationZ();
                    if (lVar.f16490l) {
                        lVar.f16491m = childAt.getElevation();
                    }
                    if (childAt instanceof Barrier) {
                        Barrier barrier = (Barrier) childAt;
                        iVar.f16450n0 = barrier.getAllowsGoneWidget();
                        iVar.f16440i0 = barrier.getReferencedIds();
                        iVar.f16434f0 = barrier.getType();
                        iVar.f16436g0 = barrier.getMargin();
                    }
                }
                i12++;
                mVar = this;
                childCount = i10;
            } else {
                throw new RuntimeException("All children of ConstraintLayout must have ids to use ConstraintSet");
            }
        }
    }

    public final void e(Context context, int i10) {
        XmlResourceParser xml = context.getResources().getXml(i10);
        try {
            for (int eventType = xml.getEventType(); eventType != 1; eventType = xml.next()) {
                if (eventType == 0) {
                    xml.getName();
                } else if (eventType == 2) {
                    String name = xml.getName();
                    h d10 = d(context, Xml.asAttributeSet(xml), false);
                    if (name.equalsIgnoreCase("Guideline")) {
                        d10.f16419d.f16423a = true;
                    }
                    this.f16497c.put(Integer.valueOf(d10.f16416a), d10);
                }
            }
        } catch (XmlPullParserException e10) {
            e10.printStackTrace();
        } catch (IOException e11) {
            e11.printStackTrace();
        }
    }
}
