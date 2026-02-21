package i3;

import android.content.res.Resources;
import android.text.TextUtils;
import com.woxthebox.draglistview.R;
import g1.a0;

public final class f implements p0 {

    /* renamed from: a  reason: collision with root package name */
    public final Resources f8076a;

    public f(Resources resources) {
        resources.getClass();
        this.f8076a = resources;
    }

    public final String a(a0 a0Var) {
        int i10 = a0Var.f6272o;
        if (i10 == -1) {
            return "";
        }
        return this.f8076a.getString(R.string.exo_track_bitrate, new Object[]{Float.valueOf(((float) i10) / 1000000.0f)});
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String b(g1.a0 r10) {
        /*
            r9 = this;
            r0 = 2
            java.lang.String[] r0 = new java.lang.String[r0]
            java.lang.String r1 = r10.f6267j
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            r3 = 1
            java.lang.String r4 = ""
            r5 = 0
            if (r2 != 0) goto L_0x0065
            java.lang.String r2 = "und"
            boolean r2 = r2.equals(r1)
            if (r2 == 0) goto L_0x0018
            goto L_0x0065
        L_0x0018:
            int r2 = j1.l0.f8453a
            r6 = 21
            if (r2 < r6) goto L_0x0023
            java.util.Locale r1 = java.util.Locale.forLanguageTag(r1)
            goto L_0x0029
        L_0x0023:
            java.util.Locale r6 = new java.util.Locale
            r6.<init>(r1)
            r1 = r6
        L_0x0029:
            r6 = 24
            if (r2 < r6) goto L_0x0036
            java.util.Locale$Category r2 = java.util.Locale.Category.DISPLAY
            java.util.Locale r2 = java.util.Locale.getDefault(r2)
            goto L_0x003a
        L_0x0036:
            java.util.Locale r2 = java.util.Locale.getDefault()
        L_0x003a:
            java.lang.String r1 = r1.getDisplayName(r2)
            boolean r6 = android.text.TextUtils.isEmpty(r1)
            if (r6 == 0) goto L_0x0045
            goto L_0x0065
        L_0x0045:
            int r6 = r1.offsetByCodePoints(r5, r3)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            r7.<init>()     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            java.lang.String r8 = r1.substring(r5, r6)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            java.lang.String r2 = r8.toUpperCase(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            r7.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            java.lang.String r2 = r1.substring(r6)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            r7.append(r2)     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            java.lang.String r1 = r7.toString()     // Catch:{ IndexOutOfBoundsException -> 0x0066 }
            goto L_0x0066
        L_0x0065:
            r1 = r4
        L_0x0066:
            r0[r5] = r1
            java.lang.String r1 = r9.c(r10)
            r0[r3] = r1
            java.lang.String r0 = r9.e(r0)
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x0083
            java.lang.String r10 = r10.f6266i
            boolean r0 = android.text.TextUtils.isEmpty(r10)
            if (r0 == 0) goto L_0x0081
            goto L_0x0082
        L_0x0081:
            r4 = r10
        L_0x0082:
            r0 = r4
        L_0x0083:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.f.b(g1.a0):java.lang.String");
    }

    public final String c(a0 a0Var) {
        int i10 = a0Var.f6269l & 2;
        Resources resources = this.f8076a;
        String string = i10 != 0 ? resources.getString(R.string.exo_track_role_alternate) : "";
        int i11 = a0Var.f6269l;
        if ((i11 & 4) != 0) {
            string = e(string, resources.getString(R.string.exo_track_role_supplementary));
        }
        if ((i11 & 8) != 0) {
            string = e(string, resources.getString(R.string.exo_track_role_commentary));
        }
        if ((i11 & 1088) == 0) {
            return string;
        }
        return e(string, resources.getString(R.string.exo_track_role_closed_captions));
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0038  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String d(g1.a0 r15) {
        /*
            r14 = this;
            java.lang.String r0 = r15.f6276s
            int r0 = g1.a1.h(r0)
            int r1 = r15.f6282y
            int r2 = r15.F
            int r3 = r15.f6281x
            r4 = -1
            r5 = 0
            r6 = 2
            r7 = 1
            if (r0 == r4) goto L_0x0014
            goto L_0x006a
        L_0x0014:
            r0 = 0
            java.lang.String r8 = r15.f6273p
            if (r8 != 0) goto L_0x001a
            goto L_0x0034
        L_0x001a:
            java.lang.String[] r9 = j1.l0.O(r8)
            int r10 = r9.length
            r11 = 0
        L_0x0020:
            if (r11 >= r10) goto L_0x0034
            r12 = r9[r11]
            java.lang.String r12 = g1.a1.d(r12)
            if (r12 == 0) goto L_0x0031
            boolean r13 = g1.a1.k(r12)
            if (r13 == 0) goto L_0x0031
            goto L_0x0035
        L_0x0031:
            int r11 = r11 + 1
            goto L_0x0020
        L_0x0034:
            r12 = r0
        L_0x0035:
            if (r12 == 0) goto L_0x0038
            goto L_0x0069
        L_0x0038:
            if (r8 != 0) goto L_0x003b
            goto L_0x0056
        L_0x003b:
            java.lang.String[] r8 = j1.l0.O(r8)
            int r9 = r8.length
            r10 = 0
        L_0x0041:
            if (r10 >= r9) goto L_0x0056
            r11 = r8[r10]
            java.lang.String r11 = g1.a1.d(r11)
            if (r11 == 0) goto L_0x0053
            boolean r12 = g1.a1.i(r11)
            if (r12 == 0) goto L_0x0053
            r0 = r11
            goto L_0x0056
        L_0x0053:
            int r10 = r10 + 1
            goto L_0x0041
        L_0x0056:
            if (r0 == 0) goto L_0x0059
            goto L_0x0067
        L_0x0059:
            if (r3 != r4) goto L_0x0069
            if (r1 == r4) goto L_0x005e
            goto L_0x0069
        L_0x005e:
            if (r2 != r4) goto L_0x0067
            int r0 = r15.G
            if (r0 == r4) goto L_0x0065
            goto L_0x0067
        L_0x0065:
            r0 = -1
            goto L_0x006a
        L_0x0067:
            r0 = 1
            goto L_0x006a
        L_0x0069:
            r0 = 2
        L_0x006a:
            java.lang.String r8 = ""
            r9 = 3
            android.content.res.Resources r10 = r14.f8076a
            if (r0 != r6) goto L_0x00a0
            java.lang.String[] r0 = new java.lang.String[r9]
            java.lang.String r2 = r14.c(r15)
            r0[r5] = r2
            if (r3 == r4) goto L_0x0093
            if (r1 != r4) goto L_0x007e
            goto L_0x0093
        L_0x007e:
            java.lang.Object[] r2 = new java.lang.Object[r6]
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r2[r5] = r3
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r2[r7] = r1
            r1 = 2131951813(0x7f1300c5, float:1.9540051E38)
            java.lang.String r8 = r10.getString(r1, r2)
        L_0x0093:
            r0[r7] = r8
            java.lang.String r15 = r14.a(r15)
            r0[r6] = r15
            java.lang.String r15 = r14.e(r0)
            goto L_0x00e5
        L_0x00a0:
            if (r0 != r7) goto L_0x00e1
            java.lang.String[] r0 = new java.lang.String[r9]
            java.lang.String r1 = r14.b(r15)
            r0[r5] = r1
            if (r2 == r4) goto L_0x00d4
            if (r2 >= r7) goto L_0x00af
            goto L_0x00d4
        L_0x00af:
            if (r2 == r7) goto L_0x00cd
            if (r2 == r6) goto L_0x00c9
            r1 = 6
            if (r2 == r1) goto L_0x00c5
            r1 = 7
            if (r2 == r1) goto L_0x00c5
            r1 = 8
            if (r2 == r1) goto L_0x00c1
            r1 = 2131951824(0x7f1300d0, float:1.9540073E38)
            goto L_0x00d0
        L_0x00c1:
            r1 = 2131951826(0x7f1300d2, float:1.9540077E38)
            goto L_0x00d0
        L_0x00c5:
            r1 = 2131951825(0x7f1300d1, float:1.9540075E38)
            goto L_0x00d0
        L_0x00c9:
            r1 = 2131951823(0x7f1300cf, float:1.9540071E38)
            goto L_0x00d0
        L_0x00cd:
            r1 = 2131951812(0x7f1300c4, float:1.954005E38)
        L_0x00d0:
            java.lang.String r8 = r10.getString(r1)
        L_0x00d4:
            r0[r7] = r8
            java.lang.String r15 = r14.a(r15)
            r0[r6] = r15
            java.lang.String r15 = r14.e(r0)
            goto L_0x00e5
        L_0x00e1:
            java.lang.String r15 = r14.b(r15)
        L_0x00e5:
            int r0 = r15.length()
            if (r0 != 0) goto L_0x00f2
            r15 = 2131951827(0x7f1300d3, float:1.954008E38)
            java.lang.String r15 = r10.getString(r15)
        L_0x00f2:
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: i3.f.d(g1.a0):java.lang.String");
    }

    public final String e(String... strArr) {
        String str = "";
        for (String str2 : strArr) {
            if (str2.length() > 0) {
                if (TextUtils.isEmpty(str)) {
                    str = str2;
                } else {
                    str = this.f8076a.getString(R.string.exo_item_list, new Object[]{str, str2});
                }
            }
        }
        return str;
    }
}
