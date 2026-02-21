package o2;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.h;
import d9.r0;
import d9.r1;
import j1.a;
import j1.l0;
import java.util.ArrayList;

public final class x extends p {
    public static final Parcelable.Creator<x> CREATOR = new w();

    /* renamed from: i  reason: collision with root package name */
    public final String f12101i;

    /* renamed from: j  reason: collision with root package name */
    public final r0 f12102j;

    public x(String str, String str2, r1 r1Var) {
        super(str);
        a.b(!r1Var.isEmpty());
        this.f12101i = str2;
        r0 j10 = r0.j(r1Var);
        this.f12102j = j10;
        String str3 = (String) j10.get(0);
    }

    public static ArrayList u(String str) {
        String substring;
        ArrayList arrayList = new ArrayList();
        try {
            if (str.length() >= 10) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(5, 7))));
                substring = str.substring(8, 10);
            } else if (str.length() >= 7) {
                arrayList.add(Integer.valueOf(Integer.parseInt(str.substring(0, 4))));
                substring = str.substring(5, 7);
            } else {
                if (str.length() >= 4) {
                    substring = str.substring(0, 4);
                }
                return arrayList;
            }
            arrayList.add(Integer.valueOf(Integer.parseInt(substring)));
            return arrayList;
        } catch (NumberFormatException unused) {
            return new ArrayList();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || x.class != obj.getClass()) {
            return false;
        }
        x xVar = (x) obj;
        return l0.a(this.f12090h, xVar.f12090h) && l0.a(this.f12101i, xVar.f12101i) && this.f12102j.equals(xVar.f12102j);
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h(g1.u0 r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.f12090h
            r0.getClass()
            int r1 = r0.hashCode()
            r2 = 4
            r3 = 3
            r4 = 2
            r5 = 1
            r6 = 0
            r7 = -1
            switch(r1) {
                case 82815: goto L_0x0125;
                case 82878: goto L_0x011a;
                case 82897: goto L_0x010f;
                case 83253: goto L_0x0104;
                case 83254: goto L_0x00f9;
                case 83255: goto L_0x00ee;
                case 83341: goto L_0x00e3;
                case 83378: goto L_0x00d8;
                case 83536: goto L_0x00ca;
                case 83552: goto L_0x00bc;
                case 2567331: goto L_0x00ae;
                case 2569357: goto L_0x00a0;
                case 2569891: goto L_0x0092;
                case 2570401: goto L_0x0084;
                case 2570410: goto L_0x0076;
                case 2571565: goto L_0x0068;
                case 2575251: goto L_0x005a;
                case 2581512: goto L_0x004c;
                case 2581513: goto L_0x003e;
                case 2581514: goto L_0x0030;
                case 2583398: goto L_0x0022;
                case 2590194: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0130
        L_0x0014:
            java.lang.String r1 = "TYER"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x001e
            goto L_0x0130
        L_0x001e:
            r0 = 21
            goto L_0x0131
        L_0x0022:
            java.lang.String r1 = "TRCK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x002c
            goto L_0x0130
        L_0x002c:
            r0 = 20
            goto L_0x0131
        L_0x0030:
            java.lang.String r1 = "TPE3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x003a
            goto L_0x0130
        L_0x003a:
            r0 = 19
            goto L_0x0131
        L_0x003e:
            java.lang.String r1 = "TPE2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0048
            goto L_0x0130
        L_0x0048:
            r0 = 18
            goto L_0x0131
        L_0x004c:
            java.lang.String r1 = "TPE1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0056
            goto L_0x0130
        L_0x0056:
            r0 = 17
            goto L_0x0131
        L_0x005a:
            java.lang.String r1 = "TIT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0064
            goto L_0x0130
        L_0x0064:
            r0 = 16
            goto L_0x0131
        L_0x0068:
            java.lang.String r1 = "TEXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0072
            goto L_0x0130
        L_0x0072:
            r0 = 15
            goto L_0x0131
        L_0x0076:
            java.lang.String r1 = "TDRL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0080
            goto L_0x0130
        L_0x0080:
            r0 = 14
            goto L_0x0131
        L_0x0084:
            java.lang.String r1 = "TDRC"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x008e
            goto L_0x0130
        L_0x008e:
            r0 = 13
            goto L_0x0131
        L_0x0092:
            java.lang.String r1 = "TDAT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x009c
            goto L_0x0130
        L_0x009c:
            r0 = 12
            goto L_0x0131
        L_0x00a0:
            java.lang.String r1 = "TCOM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00aa
            goto L_0x0130
        L_0x00aa:
            r0 = 11
            goto L_0x0131
        L_0x00ae:
            java.lang.String r1 = "TALB"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00b8
            goto L_0x0130
        L_0x00b8:
            r0 = 10
            goto L_0x0131
        L_0x00bc:
            java.lang.String r1 = "TYE"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00c6
            goto L_0x0130
        L_0x00c6:
            r0 = 9
            goto L_0x0131
        L_0x00ca:
            java.lang.String r1 = "TXT"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00d4
            goto L_0x0130
        L_0x00d4:
            r0 = 8
            goto L_0x0131
        L_0x00d8:
            java.lang.String r1 = "TT2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00e1
            goto L_0x0130
        L_0x00e1:
            r0 = 7
            goto L_0x0131
        L_0x00e3:
            java.lang.String r1 = "TRK"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00ec
            goto L_0x0130
        L_0x00ec:
            r0 = 6
            goto L_0x0131
        L_0x00ee:
            java.lang.String r1 = "TP3"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x00f7
            goto L_0x0130
        L_0x00f7:
            r0 = 5
            goto L_0x0131
        L_0x00f9:
            java.lang.String r1 = "TP2"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0102
            goto L_0x0130
        L_0x0102:
            r0 = 4
            goto L_0x0131
        L_0x0104:
            java.lang.String r1 = "TP1"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x010d
            goto L_0x0130
        L_0x010d:
            r0 = 3
            goto L_0x0131
        L_0x010f:
            java.lang.String r1 = "TDA"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0118
            goto L_0x0130
        L_0x0118:
            r0 = 2
            goto L_0x0131
        L_0x011a:
            java.lang.String r1 = "TCM"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x0123
            goto L_0x0130
        L_0x0123:
            r0 = 1
            goto L_0x0131
        L_0x0125:
            java.lang.String r1 = "TAL"
            boolean r0 = r0.equals(r1)
            if (r0 != 0) goto L_0x012e
            goto L_0x0130
        L_0x012e:
            r0 = 0
            goto L_0x0131
        L_0x0130:
            r0 = -1
        L_0x0131:
            d9.r0 r1 = r8.f12102j
            switch(r0) {
                case 0: goto L_0x0231;
                case 1: goto L_0x0228;
                case 2: goto L_0x0205;
                case 3: goto L_0x01fc;
                case 4: goto L_0x01f3;
                case 5: goto L_0x01ea;
                case 6: goto L_0x01be;
                case 7: goto L_0x01b4;
                case 8: goto L_0x01aa;
                case 9: goto L_0x0198;
                case 10: goto L_0x0231;
                case 11: goto L_0x0228;
                case 12: goto L_0x0205;
                case 13: goto L_0x0168;
                case 14: goto L_0x0138;
                case 15: goto L_0x01aa;
                case 16: goto L_0x01b4;
                case 17: goto L_0x01fc;
                case 18: goto L_0x01f3;
                case 19: goto L_0x01ea;
                case 20: goto L_0x01be;
                case 21: goto L_0x0198;
                default: goto L_0x0136;
            }
        L_0x0136:
            goto L_0x0239
        L_0x0138:
            java.lang.Object r0 = r1.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.ArrayList r0 = u(r0)
            int r1 = r0.size()
            if (r1 == r5) goto L_0x015e
            if (r1 == r4) goto L_0x0156
            if (r1 == r3) goto L_0x014e
            goto L_0x0239
        L_0x014e:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.f6618w = r1
        L_0x0156:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.f6617v = r1
        L_0x015e:
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.f6616u = r0
            goto L_0x0239
        L_0x0168:
            java.lang.Object r0 = r1.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            java.util.ArrayList r0 = u(r0)
            int r1 = r0.size()
            if (r1 == r5) goto L_0x018e
            if (r1 == r4) goto L_0x0186
            if (r1 == r3) goto L_0x017e
            goto L_0x0239
        L_0x017e:
            java.lang.Object r1 = r0.get(r4)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.f6615t = r1
        L_0x0186:
            java.lang.Object r1 = r0.get(r5)
            java.lang.Integer r1 = (java.lang.Integer) r1
            r9.f6614s = r1
        L_0x018e:
            java.lang.Object r0 = r0.get(r6)
            java.lang.Integer r0 = (java.lang.Integer) r0
            r9.f6613r = r0
            goto L_0x0239
        L_0x0198:
            java.lang.Object r0 = r1.get(r6)     // Catch:{  }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            r9.f6613r = r0     // Catch:{  }
            goto L_0x0239
        L_0x01aa:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6619x = r0
            goto L_0x0239
        L_0x01b4:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6596a = r0
            goto L_0x0239
        L_0x01be:
            java.lang.Object r0 = r1.get(r6)
            java.lang.String r0 = (java.lang.String) r0
            int r1 = j1.l0.f8453a
            java.lang.String r1 = "/"
            java.lang.String[] r0 = r0.split(r1, r7)
            r1 = r0[r6]     // Catch:{  }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{  }
            int r2 = r0.length     // Catch:{  }
            if (r2 <= r5) goto L_0x01e0
            r0 = r0[r5]     // Catch:{  }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{  }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{  }
            goto L_0x01e1
        L_0x01e0:
            r0 = 0
        L_0x01e1:
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{  }
            r9.f6608m = r1     // Catch:{  }
            r9.f6609n = r0     // Catch:{  }
            goto L_0x0239
        L_0x01ea:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6621z = r0
            goto L_0x0239
        L_0x01f3:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6599d = r0
            goto L_0x0239
        L_0x01fc:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6597b = r0
            goto L_0x0239
        L_0x0205:
            java.lang.Object r0 = r1.get(r6)     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.String r1 = r0.substring(r4, r2)     // Catch:{ NumberFormatException -> 0x0239 }
            int r1 = java.lang.Integer.parseInt(r1)     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.String r0 = r0.substring(r6, r4)     // Catch:{ NumberFormatException -> 0x0239 }
            int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ NumberFormatException -> 0x0239 }
            r9.f6614s = r1     // Catch:{ NumberFormatException -> 0x0239 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ NumberFormatException -> 0x0239 }
            r9.f6615t = r0     // Catch:{ NumberFormatException -> 0x0239 }
            goto L_0x0239
        L_0x0228:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6620y = r0
            goto L_0x0239
        L_0x0231:
            java.lang.Object r0 = r1.get(r6)
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r9.f6598c = r0
        L_0x0239:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: o2.x.h(g1.u0):void");
    }

    public final int hashCode() {
        int i10;
        int e10 = h.e(this.f12090h, 527, 31);
        String str = this.f12101i;
        if (str != null) {
            i10 = str.hashCode();
        } else {
            i10 = 0;
        }
        return this.f12102j.hashCode() + ((e10 + i10) * 31);
    }

    public final String toString() {
        return this.f12090h + ": description=" + this.f12101i + ": values=" + this.f12102j;
    }

    public final void writeToParcel(Parcel parcel, int i10) {
        parcel.writeString(this.f12090h);
        parcel.writeString(this.f12101i);
        parcel.writeStringArray((String[]) this.f12102j.toArray(new String[0]));
    }
}
