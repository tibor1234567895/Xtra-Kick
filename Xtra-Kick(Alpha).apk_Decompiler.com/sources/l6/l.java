package l6;

import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.text.Spannable;
import android.text.style.ImageSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.c0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.k2;
import com.woxthebox.draglistview.R;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import la.i;
import xa.j;

public final class l extends g1 {
    public r7.l A;

    /* renamed from: a  reason: collision with root package name */
    public final c0 f9626a;

    /* renamed from: b  reason: collision with root package name */
    public final int f9627b;

    /* renamed from: c  reason: collision with root package name */
    public final int f9628c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f9629d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f9630e;

    /* renamed from: f  reason: collision with root package name */
    public final String f9631f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f9632g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9633h;

    /* renamed from: i  reason: collision with root package name */
    public final boolean f9634i;

    /* renamed from: j  reason: collision with root package name */
    public final String f9635j;

    /* renamed from: k  reason: collision with root package name */
    public final String f9636k;

    /* renamed from: l  reason: collision with root package name */
    public final String f9637l;

    /* renamed from: m  reason: collision with root package name */
    public final String f9638m;

    /* renamed from: n  reason: collision with root package name */
    public final int f9639n;

    /* renamed from: o  reason: collision with root package name */
    public List f9640o;

    /* renamed from: p  reason: collision with root package name */
    public final int[] f9641p = {-65536, -16776961, -16744448, -5103070, -32944, -6632142, -47872, -13726889, -2448096, -2987746, -10510688, -14774017, -38476, -7722014, -16711809};

    /* renamed from: q  reason: collision with root package name */
    public final int f9642q = -10066329;

    /* renamed from: r  reason: collision with root package name */
    public final Random f9643r = new Random();

    /* renamed from: s  reason: collision with root package name */
    public final HashMap f9644s = new HashMap();

    /* renamed from: t  reason: collision with root package name */
    public final HashMap f9645t = new HashMap();

    /* renamed from: u  reason: collision with root package name */
    public List f9646u;

    /* renamed from: v  reason: collision with root package name */
    public List f9647v;

    /* renamed from: w  reason: collision with root package name */
    public List f9648w;

    /* renamed from: x  reason: collision with root package name */
    public List f9649x;

    /* renamed from: y  reason: collision with root package name */
    public String f9650y;

    /* renamed from: z  reason: collision with root package name */
    public final int f9651z;

    public l(c0 c0Var, int i10, int i11, boolean z10, boolean z11, String str, boolean z12, boolean z13, boolean z14, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i12) {
        int i13 = i10;
        j.f("fragment", c0Var);
        this.f9626a = c0Var;
        this.f9627b = i13;
        this.f9628c = i11;
        this.f9629d = z10;
        this.f9630e = z11;
        this.f9631f = str;
        this.f9632g = z12;
        this.f9633h = z13;
        this.f9634i = z14;
        this.f9635j = str2;
        this.f9636k = str3;
        this.f9637l = str4;
        this.f9638m = str8;
        this.f9639n = i12;
        this.f9651z = (int) (((float) i13) * 0.78f);
    }

    public static final i a(l lVar, Drawable drawable) {
        boolean z10;
        int i10;
        lVar.getClass();
        float intrinsicWidth = ((float) drawable.getIntrinsicWidth()) / ((float) drawable.getIntrinsicHeight());
        if (intrinsicWidth == 1.0f) {
            z10 = true;
        } else {
            z10 = false;
        }
        int i11 = lVar.f9627b;
        if (z10) {
            i10 = i11;
        } else {
            if (intrinsicWidth > 1.2f) {
                i11 = lVar.f9651z;
            }
            int i12 = i11;
            i11 = (int) (((float) i11) * intrinsicWidth);
            i10 = i12;
        }
        return new i(Integer.valueOf(i11), Integer.valueOf(i10));
    }

    public final int getItemCount() {
        List list = this.f9640o;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v17, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v18, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v19, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v7, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v12, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v13, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v14, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r26v2, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v32, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v33, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v22, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v26, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v27, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v28, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v10, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v30, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v32, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v46, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v31, resolved type: com.github.andreyasadchy.xtra.model.chat.KickBadge} */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:297:0x06a8, code lost:
        if (r1 != null) goto L_0x06d4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:303:0x06be, code lost:
        if (r1 == null) goto L_0x06d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:307:0x06ce, code lost:
        if (r1 == null) goto L_0x06d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:347:0x080e, code lost:
        if (r1 != null) goto L_0x083a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:353:0x0824, code lost:
        if (r1 == null) goto L_0x0836;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:357:0x0834, code lost:
        if (r1 == null) goto L_0x0836;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0189, code lost:
        if (r4 == null) goto L_0x018e;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0212  */
    /* JADX WARNING: Removed duplicated region for block: B:110:0x0221  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x0228  */
    /* JADX WARNING: Removed duplicated region for block: B:116:0x0236  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x0241  */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x028b  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x02a5  */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x02dc  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0308  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x0322 A[SYNTHETIC, Splitter:B:148:0x0322] */
    /* JADX WARNING: Removed duplicated region for block: B:178:0x0467 A[Catch:{ Exception -> 0x0636 }] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x048f A[Catch:{ Exception -> 0x0636 }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x04f4 A[Catch:{ Exception -> 0x0636 }] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x055d A[Catch:{ Exception -> 0x0636 }] */
    /* JADX WARNING: Removed duplicated region for block: B:244:0x05de A[Catch:{ Exception -> 0x0636 }] */
    /* JADX WARNING: Removed duplicated region for block: B:253:0x05fe  */
    /* JADX WARNING: Removed duplicated region for block: B:254:0x0602  */
    /* JADX WARNING: Removed duplicated region for block: B:257:0x0609  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x061a A[Catch:{ Exception -> 0x063a }] */
    /* JADX WARNING: Removed duplicated region for block: B:266:0x061f A[Catch:{ Exception -> 0x063a }] */
    /* JADX WARNING: Removed duplicated region for block: B:268:0x0622 A[Catch:{ Exception -> 0x063a }] */
    /* JADX WARNING: Removed duplicated region for block: B:269:0x0626 A[Catch:{ Exception -> 0x063a }] */
    /* JADX WARNING: Removed duplicated region for block: B:282:0x0653  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onBindViewHolder(androidx.recyclerview.widget.k2 r46, int r47) {
        /*
            r45 = this;
            r10 = r45
            r0 = r46
            l6.h r0 = (l6.h) r0
            java.lang.String r1 = "holder"
            xa.j.f(r1, r0)
            java.util.List r1 = r10.f9640o
            if (r1 == 0) goto L_0x086b
            r2 = r47
            java.lang.Object r1 = r1.get(r2)
            com.github.andreyasadchy.xtra.model.chat.ChatMessage r1 = (com.github.andreyasadchy.xtra.model.chat.ChatMessage) r1
            if (r1 != 0) goto L_0x001b
            goto L_0x086b
        L_0x001b:
            boolean r2 = r1 instanceof com.github.andreyasadchy.xtra.model.chat.LiveChatMessage
            if (r2 == 0) goto L_0x0023
            r2 = r1
            com.github.andreyasadchy.xtra.model.chat.LiveChatMessage r2 = (com.github.andreyasadchy.xtra.model.chat.LiveChatMessage) r2
            goto L_0x0024
        L_0x0023:
            r2 = 0
        L_0x0024:
            android.text.SpannableStringBuilder r12 = new android.text.SpannableStringBuilder
            r12.<init>()
            java.util.ArrayList r7 = new java.util.ArrayList
            r7.<init>()
            if (r2 == 0) goto L_0x0035
            java.lang.String r3 = r2.getSystemMsg()
            goto L_0x0036
        L_0x0035:
            r3 = 0
        L_0x0036:
            java.lang.String r4 = "\n"
            r13 = 0
            r14 = 1
            if (r3 == 0) goto L_0x004a
            java.lang.String r5 = r3.concat(r4)
            r12.append(r5)
            int r3 = r3.length()
            int r3 = r3 + r14
            int r3 = r3 + r13
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            if (r2 == 0) goto L_0x0055
            boolean r5 = r2.isFirst()
            if (r5 != r14) goto L_0x0055
            r5 = 1
            goto L_0x0056
        L_0x0055:
            r5 = 0
        L_0x0056:
            java.lang.String r6 = r10.f9636k
            java.lang.String r15 = "0"
            if (r5 == 0) goto L_0x007c
            boolean r5 = xa.j.a(r6, r15)
            if (r5 == 0) goto L_0x007c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = r10.f9637l
            r5.append(r8)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r12.append(r4)
            int r4 = r8.length()
            int r4 = r4 + r14
            int r3 = r3 + r4
        L_0x007c:
            java.lang.String r9 = "1"
            if (r2 == 0) goto L_0x0101
            java.lang.Long r4 = r2.getTimestamp()
            if (r4 == 0) goto L_0x0101
            long r4 = r4.longValue()
            s7.h r8 = s7.h.f14375a
            r8.getClass()
            java.lang.String r8 = r10.f9635j
            if (r8 == 0) goto L_0x00eb
            int r16 = r8.hashCode()
            switch(r16) {
                case 48: goto L_0x00e1;
                case 49: goto L_0x00d7;
                case 50: goto L_0x00cb;
                case 51: goto L_0x00bf;
                case 52: goto L_0x00b3;
                case 53: goto L_0x00a7;
                case 54: goto L_0x009b;
                default: goto L_0x009a;
            }
        L_0x009a:
            goto L_0x00eb
        L_0x009b:
            java.lang.String r11 = "6"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x00a4
            goto L_0x00eb
        L_0x00a4:
            java.lang.String r8 = "h:mm:ss a"
            goto L_0x00ed
        L_0x00a7:
            java.lang.String r11 = "5"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x00b0
            goto L_0x00eb
        L_0x00b0:
            java.lang.String r8 = "hh:mm a"
            goto L_0x00ed
        L_0x00b3:
            java.lang.String r11 = "4"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x00bc
            goto L_0x00eb
        L_0x00bc:
            java.lang.String r8 = "h:mm a"
            goto L_0x00ed
        L_0x00bf:
            java.lang.String r11 = "3"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x00c8
            goto L_0x00eb
        L_0x00c8:
            java.lang.String r8 = "HH:mm:ss"
            goto L_0x00ed
        L_0x00cb:
            java.lang.String r11 = "2"
            boolean r8 = r8.equals(r11)
            if (r8 != 0) goto L_0x00d4
            goto L_0x00eb
        L_0x00d4:
            java.lang.String r8 = "H:mm:ss"
            goto L_0x00ed
        L_0x00d7:
            boolean r8 = r8.equals(r9)
            if (r8 != 0) goto L_0x00de
            goto L_0x00eb
        L_0x00de:
            java.lang.String r8 = "HH:mm"
            goto L_0x00ed
        L_0x00e1:
            boolean r8 = r8.equals(r15)
            if (r8 != 0) goto L_0x00e8
            goto L_0x00eb
        L_0x00e8:
            java.lang.String r8 = "H:mm"
            goto L_0x00ed
        L_0x00eb:
            java.lang.String r8 = "hh:mm:ss a"
        L_0x00ed:
            java.text.SimpleDateFormat r11 = new java.text.SimpleDateFormat
            java.util.Locale r13 = java.util.Locale.getDefault()
            r11.<init>(r8, r13)
            java.util.Date r8 = new java.util.Date     // Catch:{ Exception -> 0x0100 }
            r8.<init>(r4)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r4 = r11.format(r8)     // Catch:{ Exception -> 0x0100 }
            goto L_0x0102
        L_0x0100:
        L_0x0101:
            r4 = 0
        L_0x0102:
            boolean r5 = r10.f9634i
            java.lang.String r8 = " "
            if (r5 == 0) goto L_0x012c
            if (r4 == 0) goto L_0x012c
            java.lang.String r5 = r4.concat(r8)
            r12.append(r5)
            android.text.style.ForegroundColorSpan r5 = new android.text.style.ForegroundColorSpan
            java.lang.String r11 = "#999999"
            int r11 = android.graphics.Color.parseColor(r11)
            r5.<init>(r11)
            int r11 = r4.length()
            int r11 = r11 + r3
            r13 = 18
            r12.setSpan(r5, r3, r11, r13)
            int r4 = r4.length()
            int r4 = r4 + r14
            int r3 = r3 + r4
        L_0x012c:
            java.util.List r4 = r1.getBadges()
            if (r4 == 0) goto L_0x0212
            java.util.Iterator r4 = r4.iterator()
            r24 = r3
            r3 = 0
        L_0x0139:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L_0x020c
            java.lang.Object r5 = r4.next()
            com.github.andreyasadchy.xtra.model.chat.Badge r5 = (com.github.andreyasadchy.xtra.model.chat.Badge) r5
            java.util.List r11 = r10.f9649x
            if (r11 == 0) goto L_0x018c
            java.util.Iterator r11 = r11.iterator()
        L_0x014d:
            boolean r13 = r11.hasNext()
            if (r13 == 0) goto L_0x0183
            java.lang.Object r13 = r11.next()
            r16 = r13
            com.github.andreyasadchy.xtra.model.chat.KickBadge r16 = (com.github.andreyasadchy.xtra.model.chat.KickBadge) r16
            java.lang.String r14 = r16.getSetId()
            r29 = r4
            java.lang.String r4 = r5.getSetId()
            boolean r4 = xa.j.a(r14, r4)
            if (r4 == 0) goto L_0x017b
            java.lang.String r4 = r16.getVersion()
            java.lang.String r14 = r5.getVersion()
            boolean r4 = xa.j.a(r4, r14)
            if (r4 == 0) goto L_0x017b
            r4 = 1
            goto L_0x017c
        L_0x017b:
            r4 = 0
        L_0x017c:
            if (r4 == 0) goto L_0x017f
            goto L_0x0186
        L_0x017f:
            r4 = r29
            r14 = 1
            goto L_0x014d
        L_0x0183:
            r29 = r4
            r13 = 0
        L_0x0186:
            r4 = r13
            com.github.andreyasadchy.xtra.model.chat.KickBadge r4 = (com.github.andreyasadchy.xtra.model.chat.KickBadge) r4
            if (r4 != 0) goto L_0x01d0
            goto L_0x018e
        L_0x018c:
            r29 = r4
        L_0x018e:
            java.util.List r4 = r10.f9648w
            if (r4 == 0) goto L_0x01cf
            java.util.Iterator r4 = r4.iterator()
        L_0x0196:
            boolean r11 = r4.hasNext()
            if (r11 == 0) goto L_0x01ca
            java.lang.Object r11 = r4.next()
            r13 = r11
            com.github.andreyasadchy.xtra.model.chat.KickBadge r13 = (com.github.andreyasadchy.xtra.model.chat.KickBadge) r13
            java.lang.String r14 = r13.getSetId()
            r16 = r4
            java.lang.String r4 = r5.getSetId()
            boolean r4 = xa.j.a(r14, r4)
            if (r4 == 0) goto L_0x01c3
            java.lang.String r4 = r13.getVersion()
            java.lang.String r13 = r5.getVersion()
            boolean r4 = xa.j.a(r4, r13)
            if (r4 == 0) goto L_0x01c3
            r4 = 1
            goto L_0x01c4
        L_0x01c3:
            r4 = 0
        L_0x01c4:
            if (r4 == 0) goto L_0x01c7
            goto L_0x01cb
        L_0x01c7:
            r4 = r16
            goto L_0x0196
        L_0x01ca:
            r11 = 0
        L_0x01cb:
            r4 = r11
            com.github.andreyasadchy.xtra.model.chat.KickBadge r4 = (com.github.andreyasadchy.xtra.model.chat.KickBadge) r4
            goto L_0x01d0
        L_0x01cf:
            r4 = 0
        L_0x01d0:
            if (r4 == 0) goto L_0x0207
            java.lang.String r5 = "  "
            r12.append(r5)
            com.github.andreyasadchy.xtra.model.chat.Image r5 = new com.github.andreyasadchy.xtra.model.chat.Image
            java.lang.String r17 = r4.getUrl()
            java.lang.String r18 = r4.getUrl()
            java.lang.String r19 = r4.getUrl()
            java.lang.String r20 = r4.getUrl()
            r21 = 0
            r22 = 0
            r23 = 0
            int r25 = r24 + 1
            int r4 = r25 + 1
            r26 = 0
            r27 = 112(0x70, float:1.57E-43)
            r28 = 0
            r16 = r5
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            r7.add(r5)
            int r3 = r3 + 1
            la.v r5 = la.v.f9814a
            r24 = r4
        L_0x0207:
            r4 = r29
            r14 = 1
            goto L_0x0139
        L_0x020c:
            la.v r4 = la.v.f9814a
            r4 = r3
            r3 = r24
            goto L_0x0213
        L_0x0212:
            r4 = 0
        L_0x0213:
            java.lang.String r11 = r1.getFullMsg()
            int r13 = r1.getUserId()
            java.lang.String r5 = r1.getUserName()
            if (r5 == 0) goto L_0x0228
            int r14 = r5.length()
            r16 = r9
            goto L_0x022b
        L_0x0228:
            r16 = r9
            r14 = 0
        L_0x022b:
            int r9 = r3 + r14
            if (r5 == 0) goto L_0x023b
            boolean r17 = fb.w.h(r5)
            if (r17 == 0) goto L_0x0236
            goto L_0x023b
        L_0x0236:
            r18 = r15
            r17 = 0
            goto L_0x023f
        L_0x023b:
            r18 = r15
            r17 = 1
        L_0x023f:
            if (r17 != 0) goto L_0x028b
            r12.append(r5)
            boolean r17 = r1.isAction()
            if (r17 != 0) goto L_0x026b
            java.lang.String r15 = ": "
            r12.append(r15)
            r19 = r11
            java.lang.String r11 = r1.getMessage()
            r20 = r13
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            r13.append(r15)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r13 = 2
            goto L_0x0289
        L_0x026b:
            r19 = r11
            r20 = r13
            r12.append(r8)
            java.lang.String r11 = r1.getMessage()
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r5)
            r13.append(r8)
            r13.append(r11)
            java.lang.String r11 = r13.toString()
            r13 = 1
        L_0x0289:
            int r13 = r13 + r14
            goto L_0x0298
        L_0x028b:
            r19 = r11
            r20 = r13
            java.lang.String r11 = r1.getMessage()
            java.lang.String r11 = java.lang.String.valueOf(r11)
            r13 = 0
        L_0x0298:
            java.lang.String r14 = r1.getMessage()
            r12.append(r14)
            java.lang.String r14 = r1.getColor()
            if (r14 != 0) goto L_0x02dc
            java.util.HashMap r14 = r10.f9644s
            java.lang.Object r15 = r14.get(r5)
            java.lang.Integer r15 = (java.lang.Integer) r15
            if (r15 == 0) goto L_0x02b8
            int r14 = r15.intValue()
            r22 = r6
            r21 = r11
            goto L_0x0301
        L_0x02b8:
            boolean r15 = r10.f9629d
            if (r15 == 0) goto L_0x02cc
            java.util.Random r15 = r10.f9643r
            r21 = r11
            int[] r11 = r10.f9641p
            r22 = r6
            int r6 = r11.length
            int r6 = r15.nextInt(r6)
            r6 = r11[r6]
            goto L_0x02d2
        L_0x02cc:
            r22 = r6
            r21 = r11
            int r6 = r10.f9642q
        L_0x02d2:
            if (r5 == 0) goto L_0x0302
            java.lang.Integer r11 = java.lang.Integer.valueOf(r6)
            r14.put(r5, r11)
            goto L_0x0302
        L_0x02dc:
            r22 = r6
            r21 = r11
            java.util.HashMap r6 = r10.f9645t
            java.lang.Object r11 = r6.get(r14)
            java.lang.Integer r11 = (java.lang.Integer) r11
            if (r11 != 0) goto L_0x02fd
            int r11 = android.graphics.Color.parseColor(r14)
            java.lang.Integer r11 = java.lang.Integer.valueOf(r11)
            int r15 = r11.intValue()
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r6.put(r14, r15)
        L_0x02fd:
            int r14 = r11.intValue()
        L_0x0301:
            r6 = r14
        L_0x0302:
            boolean r11 = r10.f9630e
            r14 = 33
            if (r5 == 0) goto L_0x0318
            android.text.style.ForegroundColorSpan r15 = new android.text.style.ForegroundColorSpan
            r15.<init>(r6)
            r12.setSpan(r15, r3, r9, r14)
            android.text.style.StyleSpan r15 = new android.text.style.StyleSpan
            r15.<init>(r11)
            r12.setSpan(r15, r3, r9, r14)
        L_0x0318:
            java.util.List r15 = r1.getEmotes()     // Catch:{ Exception -> 0x0639 }
            java.lang.String r14 = "."
            r24 = r0
            if (r15 == 0) goto L_0x0467
            java.util.ArrayList r0 = new java.util.ArrayList     // Catch:{ Exception -> 0x0636 }
            r25 = r2
            int r2 = ma.s.i(r15)     // Catch:{ Exception -> 0x0636 }
            r0.<init>(r2)     // Catch:{ Exception -> 0x0636 }
            java.util.Iterator r2 = r15.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x0331:
            boolean r15 = r2.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r15 == 0) goto L_0x039f
            java.lang.Object r15 = r2.next()     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.KickEmote r15 = (com.github.andreyasadchy.xtra.model.chat.KickEmote) r15     // Catch:{ Exception -> 0x0636 }
            r26 = r2
            java.lang.String r2 = r1.getMessage()     // Catch:{ Exception -> 0x0636 }
            if (r2 == 0) goto L_0x0353
            r27 = r9
            int r9 = r15.getBegin()     // Catch:{ Exception -> 0x0636 }
            r28 = r5
            r5 = 0
            int r2 = r2.offsetByCodePoints(r5, r9)     // Catch:{ Exception -> 0x0636 }
            goto L_0x0358
        L_0x0353:
            r28 = r5
            r27 = r9
            r2 = 0
        L_0x0358:
            int r5 = r15.getBegin()     // Catch:{ Exception -> 0x0636 }
            if (r5 != r2) goto L_0x0365
            int r5 = r15.getEnd()     // Catch:{ Exception -> 0x0636 }
        L_0x0362:
            r40 = r5
            goto L_0x0370
        L_0x0365:
            int r5 = r15.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r5 = r5 + r2
            int r9 = r15.getBegin()     // Catch:{ Exception -> 0x0636 }
            int r5 = r5 - r9
            goto L_0x0362
        L_0x0370:
            com.github.andreyasadchy.xtra.model.chat.KickEmote r5 = new com.github.andreyasadchy.xtra.model.chat.KickEmote     // Catch:{ Exception -> 0x0636 }
            java.lang.String r30 = r15.getId()     // Catch:{ Exception -> 0x0636 }
            r31 = 0
            r32 = 0
            r33 = 0
            r34 = 0
            r35 = 0
            r36 = 0
            r37 = 0
            r38 = 0
            r41 = 0
            r42 = 0
            r43 = 6654(0x19fe, float:9.324E-42)
            r44 = 0
            r29 = r5
            r39 = r2
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)     // Catch:{ Exception -> 0x0636 }
            r0.add(r5)     // Catch:{ Exception -> 0x0636 }
            r2 = r26
            r9 = r27
            r5 = r28
            goto L_0x0331
        L_0x039f:
            r28 = r5
            r27 = r9
            int r3 = r3 + r13
            java.util.Iterator r2 = r0.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x03a8:
            boolean r5 = r2.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r5 == 0) goto L_0x041b
            java.lang.Object r5 = r2.next()     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.KickEmote r5 = (com.github.andreyasadchy.xtra.model.chat.KickEmote) r5     // Catch:{ Exception -> 0x0636 }
            int r9 = r5.getBegin()     // Catch:{ Exception -> 0x0636 }
            int r9 = r9 + r3
            int r15 = r5.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r15 = r15 + r3
            r26 = 1
            int r15 = r15 + 1
            r12.replace(r9, r15, r14)     // Catch:{ Exception -> 0x0636 }
            android.text.style.ForegroundColorSpan r15 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0636 }
            r26 = r2
            r2 = 0
            r15.<init>(r2)     // Catch:{ Exception -> 0x0636 }
            int r2 = r9 + 1
            r29 = r6
            r6 = 33
            r12.setSpan(r15, r9, r2, r6)     // Catch:{ Exception -> 0x0636 }
            int r2 = r5.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r6 = r5.getBegin()     // Catch:{ Exception -> 0x0636 }
            int r2 = r2 - r6
            java.util.Iterator r6 = r0.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x03e3:
            boolean r9 = r6.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r9 == 0) goto L_0x040e
            java.lang.Object r9 = r6.next()     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.KickEmote r9 = (com.github.andreyasadchy.xtra.model.chat.KickEmote) r9     // Catch:{ Exception -> 0x0636 }
            int r15 = r5.getBegin()     // Catch:{ Exception -> 0x0636 }
            r30 = r6
            int r6 = r9.getBegin()     // Catch:{ Exception -> 0x0636 }
            if (r15 >= r6) goto L_0x040b
            int r6 = r9.getBegin()     // Catch:{ Exception -> 0x0636 }
            int r6 = r6 - r2
            r9.setBegin(r6)     // Catch:{ Exception -> 0x0636 }
            int r6 = r9.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r6 = r6 - r2
            r9.setEnd(r6)     // Catch:{ Exception -> 0x0636 }
        L_0x040b:
            r6 = r30
            goto L_0x03e3
        L_0x040e:
            int r6 = r5.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r6 = r6 - r2
            r5.setEnd(r6)     // Catch:{ Exception -> 0x0636 }
            r2 = r26
            r6 = r29
            goto L_0x03a8
        L_0x041b:
            r29 = r6
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x0421:
            boolean r2 = r0.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r2 == 0) goto L_0x0464
            java.lang.Object r2 = r0.next()     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.KickEmote r2 = (com.github.andreyasadchy.xtra.model.chat.KickEmote) r2     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.Image r5 = new com.github.andreyasadchy.xtra.model.chat.Image     // Catch:{ Exception -> 0x0636 }
            java.lang.String r31 = r2.getUrl1x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r32 = r2.getUrl2x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r33 = r2.getUrl3x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r34 = r2.getUrl4x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r35 = r2.getType()     // Catch:{ Exception -> 0x0636 }
            java.lang.Boolean r36 = r2.isAnimated()     // Catch:{ Exception -> 0x0636 }
            boolean r37 = r2.isZeroWidth()     // Catch:{ Exception -> 0x0636 }
            int r6 = r2.getBegin()     // Catch:{ Exception -> 0x0636 }
            int r38 = r3 + r6
            int r2 = r2.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r2 = r2 + r3
            r6 = 1
            int r39 = r2 + 1
            r40 = 1
            r30 = r5
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)     // Catch:{ Exception -> 0x0636 }
            r7.add(r5)     // Catch:{ Exception -> 0x0636 }
            goto L_0x0421
        L_0x0464:
            la.v r0 = la.v.f9814a     // Catch:{ Exception -> 0x0636 }
            goto L_0x046f
        L_0x0467:
            r25 = r2
            r28 = r5
            r29 = r6
            r27 = r9
        L_0x046f:
            int r0 = r12.length()     // Catch:{ Exception -> 0x0636 }
            java.lang.CharSequence r0 = r12.subSequence(r13, r0)     // Catch:{ Exception -> 0x0636 }
            java.lang.String r0 = r0.toString()     // Catch:{ Exception -> 0x0636 }
            java.lang.String[] r2 = new java.lang.String[]{r8}     // Catch:{ Exception -> 0x0636 }
            java.util.List r0 = fb.y.F(r0, r2)     // Catch:{ Exception -> 0x0636 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0636 }
            r2 = 0
            r5 = 0
        L_0x0489:
            boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r3 == 0) goto L_0x05d8
            java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x0636 }
            int r6 = r3.length()     // Catch:{ Exception -> 0x0636 }
            int r8 = r13 + r6
            java.util.List r9 = r10.f9647v     // Catch:{ Exception -> 0x0636 }
            if (r9 == 0) goto L_0x04ca
            java.util.Iterator r9 = r9.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x04a3:
            boolean r15 = r9.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r15 == 0) goto L_0x04c1
            java.lang.Object r15 = r9.next()     // Catch:{ Exception -> 0x0636 }
            r26 = r15
            com.github.andreyasadchy.xtra.model.chat.Emote r26 = (com.github.andreyasadchy.xtra.model.chat.Emote) r26     // Catch:{ Exception -> 0x0636 }
            r41 = r0
            java.lang.String r0 = r26.getName()     // Catch:{ Exception -> 0x0636 }
            boolean r0 = xa.j.a(r0, r3)     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x04be
            goto L_0x04c4
        L_0x04be:
            r0 = r41
            goto L_0x04a3
        L_0x04c1:
            r41 = r0
            r15 = 0
        L_0x04c4:
            r0 = r15
            com.github.andreyasadchy.xtra.model.chat.Emote r0 = (com.github.andreyasadchy.xtra.model.chat.Emote) r0     // Catch:{ Exception -> 0x0636 }
            if (r0 != 0) goto L_0x04f2
            goto L_0x04cc
        L_0x04ca:
            r41 = r0
        L_0x04cc:
            java.util.List r0 = r10.f9646u     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x04f1
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0636 }
        L_0x04d4:
            boolean r9 = r0.hasNext()     // Catch:{ Exception -> 0x0636 }
            if (r9 == 0) goto L_0x04ec
            java.lang.Object r9 = r0.next()     // Catch:{ Exception -> 0x0636 }
            r15 = r9
            com.github.andreyasadchy.xtra.model.chat.Emote r15 = (com.github.andreyasadchy.xtra.model.chat.Emote) r15     // Catch:{ Exception -> 0x0636 }
            java.lang.String r15 = r15.getName()     // Catch:{ Exception -> 0x0636 }
            boolean r15 = xa.j.a(r15, r3)     // Catch:{ Exception -> 0x0636 }
            if (r15 == 0) goto L_0x04d4
            goto L_0x04ed
        L_0x04ec:
            r9 = 0
        L_0x04ed:
            r0 = r9
            com.github.andreyasadchy.xtra.model.chat.Emote r0 = (com.github.andreyasadchy.xtra.model.chat.Emote) r0     // Catch:{ Exception -> 0x0636 }
            goto L_0x04f2
        L_0x04f1:
            r0 = 0
        L_0x04f2:
            if (r0 != 0) goto L_0x055d
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL     // Catch:{ Exception -> 0x0636 }
            java.util.regex.Matcher r0 = r0.matcher(r3)     // Catch:{ Exception -> 0x0636 }
            boolean r0 = r0.matches()     // Catch:{ Exception -> 0x0636 }
            if (r0 != 0) goto L_0x0532
            r0 = 64
            boolean r0 = fb.y.G(r3, r0)     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x0517
            android.text.style.StyleSpan r0 = new android.text.style.StyleSpan     // Catch:{ Exception -> 0x0636 }
            if (r11 == 0) goto L_0x050e
            r9 = 1
            goto L_0x050f
        L_0x050e:
            r9 = 0
        L_0x050f:
            r0.<init>(r9)     // Catch:{ Exception -> 0x0636 }
            r9 = 33
            r12.setSpan(r0, r13, r8, r9)     // Catch:{ Exception -> 0x0636 }
        L_0x0517:
            java.lang.String r0 = r10.f9650y     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x0557
            if (r5 != 0) goto L_0x052f
            r8 = 1
            boolean r3 = fb.y.n(r3, r0, r8)     // Catch:{ Exception -> 0x0636 }
            if (r3 == 0) goto L_0x052f
            java.lang.String r3 = r1.getUserLogin()     // Catch:{ Exception -> 0x0636 }
            boolean r0 = xa.j.a(r3, r0)     // Catch:{ Exception -> 0x0636 }
            if (r0 != 0) goto L_0x052f
            r5 = 1
        L_0x052f:
            la.v r0 = la.v.f9814a     // Catch:{ Exception -> 0x0636 }
            goto L_0x0557
        L_0x0532:
            java.lang.String r0 = "http"
            r9 = 0
            boolean r0 = fb.w.m(r3, r0, r9)     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x053c
            goto L_0x054d
        L_0x053c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0636 }
            r0.<init>()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r9 = "https://"
            r0.append(r9)     // Catch:{ Exception -> 0x0636 }
            r0.append(r3)     // Catch:{ Exception -> 0x0636 }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0636 }
        L_0x054d:
            android.text.style.URLSpan r0 = new android.text.style.URLSpan     // Catch:{ Exception -> 0x0636 }
            r0.<init>(r3)     // Catch:{ Exception -> 0x0636 }
            r3 = 33
            r12.setSpan(r0, r13, r8, r3)     // Catch:{ Exception -> 0x0636 }
        L_0x0557:
            int r6 = r6 + 1
            int r6 = r6 + r13
            r13 = r6
            goto L_0x05d4
        L_0x055d:
            int r3 = ma.r.d(r7)     // Catch:{ Exception -> 0x0636 }
            int r3 = r3 - r2
            if (r4 > r3) goto L_0x0594
        L_0x0564:
            java.lang.Object r9 = r7.get(r3)     // Catch:{ Exception -> 0x0636 }
            java.lang.String r15 = "images[j]"
            xa.j.e(r15, r9)     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.Image r9 = (com.github.andreyasadchy.xtra.model.chat.Image) r9     // Catch:{ Exception -> 0x0636 }
            int r15 = r9.getStart()     // Catch:{ Exception -> 0x0636 }
            if (r15 <= r13) goto L_0x058b
            int r15 = r6 + -1
            int r26 = r9.getStart()     // Catch:{ Exception -> 0x0636 }
            r30 = r6
            int r6 = r26 - r15
            r9.setStart(r6)     // Catch:{ Exception -> 0x0636 }
            int r6 = r9.getEnd()     // Catch:{ Exception -> 0x0636 }
            int r6 = r6 - r15
            r9.setEnd(r6)     // Catch:{ Exception -> 0x0636 }
            goto L_0x058d
        L_0x058b:
            r30 = r6
        L_0x058d:
            if (r3 == r4) goto L_0x0594
            int r3 = r3 + -1
            r6 = r30
            goto L_0x0564
        L_0x0594:
            r12.replace(r13, r8, r14)     // Catch:{ Exception -> 0x0636 }
            android.text.style.ForegroundColorSpan r3 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0636 }
            r6 = 0
            r3.<init>(r6)     // Catch:{ Exception -> 0x0636 }
            int r6 = r13 + 1
            r8 = 33
            r12.setSpan(r3, r13, r6, r8)     // Catch:{ Exception -> 0x0636 }
            com.github.andreyasadchy.xtra.model.chat.Image r3 = new com.github.andreyasadchy.xtra.model.chat.Image     // Catch:{ Exception -> 0x0636 }
            java.lang.String r31 = r0.getUrl1x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r32 = r0.getUrl2x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r33 = r0.getUrl3x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r34 = r0.getUrl4x()     // Catch:{ Exception -> 0x0636 }
            java.lang.String r35 = r0.getType()     // Catch:{ Exception -> 0x0636 }
            java.lang.Boolean r36 = r0.isAnimated()     // Catch:{ Exception -> 0x0636 }
            boolean r37 = r0.isZeroWidth()     // Catch:{ Exception -> 0x0636 }
            r40 = 1
            r30 = r3
            r38 = r13
            r39 = r6
            r30.<init>(r31, r32, r33, r34, r35, r36, r37, r38, r39, r40)     // Catch:{ Exception -> 0x0636 }
            r7.add(r3)     // Catch:{ Exception -> 0x0636 }
            int r2 = r2 + 1
            int r13 = r13 + 2
        L_0x05d4:
            r0 = r41
            goto L_0x0489
        L_0x05d8:
            boolean r0 = r1.isAction()     // Catch:{ Exception -> 0x0636 }
            if (r0 == 0) goto L_0x05f5
            android.text.style.ForegroundColorSpan r0 = new android.text.style.ForegroundColorSpan     // Catch:{ Exception -> 0x0636 }
            r14 = r29
            r0.<init>(r14)     // Catch:{ Exception -> 0x0636 }
            if (r28 == 0) goto L_0x05eb
            r1 = 1
            int r2 = r27 + 1
            goto L_0x05ec
        L_0x05eb:
            r2 = 0
        L_0x05ec:
            int r1 = r12.length()     // Catch:{ Exception -> 0x0636 }
            r3 = 33
            r12.setSpan(r0, r2, r1, r3)     // Catch:{ Exception -> 0x0636 }
        L_0x05f5:
            if (r25 == 0) goto L_0x0602
            boolean r0 = r25.isFirst()     // Catch:{ Exception -> 0x0636 }
            r1 = 1
            if (r0 != r1) goto L_0x0602
            r11 = r24
            r0 = 1
            goto L_0x0605
        L_0x0602:
            r11 = r24
            r0 = 0
        L_0x0605:
            android.widget.TextView r1 = r11.f9606h
            if (r0 == 0) goto L_0x0618
            if (r22 == 0) goto L_0x0610
            int r0 = java.lang.Integer.parseInt(r22)     // Catch:{ Exception -> 0x063a }
            goto L_0x0611
        L_0x0610:
            r0 = 0
        L_0x0611:
            r2 = 2
            if (r0 >= r2) goto L_0x0618
            r0 = 2131099696(0x7f060030, float:1.7811752E38)
            goto L_0x062d
        L_0x0618:
            if (r25 == 0) goto L_0x061f
            java.lang.String r0 = r25.getSystemMsg()     // Catch:{ Exception -> 0x063a }
            goto L_0x0620
        L_0x061f:
            r0 = 0
        L_0x0620:
            if (r0 == 0) goto L_0x0626
            r0 = 2131099698(0x7f060032, float:1.7811757E38)
            goto L_0x062d
        L_0x0626:
            if (r5 == 0) goto L_0x0631
            if (r20 == 0) goto L_0x0631
            r0 = 2131099697(0x7f060031, float:1.7811755E38)
        L_0x062d:
            r1.setBackgroundResource(r0)     // Catch:{ Exception -> 0x063a }
            goto L_0x063a
        L_0x0631:
            r0 = 0
            r1.setBackground(r0)     // Catch:{ Exception -> 0x063a }
            goto L_0x063a
        L_0x0636:
            r11 = r24
            goto L_0x063a
        L_0x0639:
            r11 = r0
        L_0x063a:
            int r5 = r10.f9639n
            r1 = r11
            r2 = r21
            r3 = r12
            r4 = r20
            r6 = r19
            r1.a(r2, r3, r4, r5, r6)
            int r0 = r10.f9639n
            java.util.Iterator r13 = r7.iterator()
        L_0x064d:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x086b
            java.lang.Object r1 = r13.next()
            r2 = r1
            com.github.andreyasadchy.xtra.model.chat.Image r2 = (com.github.andreyasadchy.xtra.model.chat.Image) r2
            java.lang.String r1 = r10.f9638m
            r14 = r18
            boolean r3 = xa.j.a(r1, r14)
            r9 = r16
            if (r3 == 0) goto L_0x0667
            goto L_0x067b
        L_0x0667:
            boolean r1 = xa.j.a(r1, r9)
            if (r1 == 0) goto L_0x07d7
            java.lang.String r1 = r2.getType()
            java.lang.String r3 = "webp"
            boolean r1 = fb.w.g(r1, r3)
            if (r1 == 0) goto L_0x067b
            goto L_0x07d7
        L_0x067b:
            s4.g r15 = new s4.g
            androidx.fragment.app.c0 r1 = r10.f9626a
            android.content.Context r1 = r1.f0()
            r15.<init>(r1)
            java.lang.String r1 = r10.f9631f
            int r3 = r1.hashCode()
            switch(r3) {
                case 50: goto L_0x06c1;
                case 51: goto L_0x06ab;
                case 52: goto L_0x0690;
                default: goto L_0x068f;
            }
        L_0x068f:
            goto L_0x06d0
        L_0x0690:
            java.lang.String r3 = "4"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x06d0
            java.lang.String r1 = r2.getUrl4x()
            if (r1 != 0) goto L_0x06d4
            java.lang.String r1 = r2.getUrl3x()
            if (r1 != 0) goto L_0x06d4
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x06d4
            goto L_0x06d0
        L_0x06ab:
            java.lang.String r3 = "3"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06b4
            goto L_0x06d0
        L_0x06b4:
            java.lang.String r1 = r2.getUrl3x()
            if (r1 != 0) goto L_0x06d4
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x06d4
            goto L_0x06d0
        L_0x06c1:
            java.lang.String r3 = "2"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x06ca
            goto L_0x06d0
        L_0x06ca:
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x06d4
        L_0x06d0:
            java.lang.String r1 = r2.getUrl1x()
        L_0x06d4:
            r15.f14225c = r1
            l6.i r8 = new l6.i
            r1 = r8
            r3 = r45
            r4 = r12
            r5 = r11
            r6 = r21
            r7 = r20
            r16 = r13
            r13 = r8
            r8 = r0
            r17 = r9
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r15.f14226d = r13
            r13 = 0
            r15.H = r13
            r15.I = r13
            r9 = 0
            r15.O = r9
            s4.i r1 = r15.a()
            androidx.fragment.app.c0 r2 = r10.f9626a
            android.content.Context r2 = r2.f0()
            i4.t r3 = i4.a.f8231b
            if (r3 != 0) goto L_0x07c5
            i4.a r3 = i4.a.f8230a
            monitor-enter(r3)
            i4.t r4 = i4.a.f8231b     // Catch:{ all -> 0x07c2 }
            if (r4 == 0) goto L_0x0719
            monitor-exit(r3)
            r22 = r0
            r0 = r1
            r3 = r4
            r24 = r11
            r23 = r12
            r18 = r14
            r10 = 1
            goto L_0x07cf
        L_0x0719:
            android.content.Context r4 = r2.getApplicationContext()     // Catch:{ all -> 0x07c2 }
            boolean r5 = r4 instanceof i4.n     // Catch:{ all -> 0x07c2 }
            if (r5 == 0) goto L_0x0724
            i4.n r4 = (i4.n) r4     // Catch:{ all -> 0x07c2 }
            goto L_0x0725
        L_0x0724:
            r4 = r13
        L_0x0725:
            if (r4 == 0) goto L_0x07a7
            com.github.andreyasadchy.xtra.XtraApp r4 = (com.github.andreyasadchy.xtra.XtraApp) r4     // Catch:{ all -> 0x07c2 }
            i4.l r2 = new i4.l     // Catch:{ all -> 0x07c2 }
            r2.<init>(r4)     // Catch:{ all -> 0x07c2 }
            v4.a r34 = v4.c.f15926a     // Catch:{ all -> 0x07c2 }
            s4.a r4 = r2.f8251b     // Catch:{ all -> 0x07c2 }
            hb.d0 r5 = r4.f14188a     // Catch:{ all -> 0x07c2 }
            hb.d0 r6 = r4.f14189b     // Catch:{ all -> 0x07c2 }
            hb.d0 r7 = r4.f14190c     // Catch:{ all -> 0x07c2 }
            hb.d0 r8 = r4.f14191d     // Catch:{ all -> 0x07c2 }
            int r15 = r4.f14193f     // Catch:{ all -> 0x07c2 }
            android.graphics.Bitmap$Config r9 = r4.f14194g     // Catch:{ all -> 0x07c2 }
            boolean r13 = r4.f14195h     // Catch:{ all -> 0x07c2 }
            r18 = r14
            boolean r14 = r4.f14196i     // Catch:{ all -> 0x07c2 }
            r22 = r0
            android.graphics.drawable.Drawable r0 = r4.f14197j     // Catch:{ all -> 0x07c2 }
            r24 = r11
            android.graphics.drawable.Drawable r11 = r4.f14198k     // Catch:{ all -> 0x07c2 }
            r23 = r12
            android.graphics.drawable.Drawable r12 = r4.f14199l     // Catch:{ all -> 0x07c2 }
            int r10 = r4.f14200m     // Catch:{ all -> 0x07c2 }
            r25 = r1
            int r1 = r4.f14201n     // Catch:{ all -> 0x07c2 }
            int r4 = r4.f14202o     // Catch:{ all -> 0x07c2 }
            r26 = r2
            s4.a r2 = new s4.a     // Catch:{ all -> 0x07c2 }
            r29 = r2
            r30 = r5
            r31 = r6
            r32 = r7
            r33 = r8
            r35 = r15
            r36 = r9
            r37 = r13
            r38 = r14
            r39 = r0
            r40 = r11
            r41 = r12
            r42 = r10
            r43 = r1
            r44 = r4
            r29.<init>(r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40, r41, r42, r43, r44)     // Catch:{ all -> 0x07c2 }
            r0 = r26
            r0.f8251b = r2     // Catch:{ all -> 0x07c2 }
            i4.b r1 = new i4.b     // Catch:{ all -> 0x07c2 }
            r1.<init>()     // Catch:{ all -> 0x07c2 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x07c2 }
            r4 = 28
            if (r2 < r4) goto L_0x0793
            j4.x r2 = new j4.x     // Catch:{ all -> 0x07c2 }
            r10 = 1
            r2.<init>(r10)     // Catch:{ all -> 0x07c2 }
            goto L_0x0799
        L_0x0793:
            r10 = 1
            j4.v r2 = new j4.v     // Catch:{ all -> 0x07c2 }
            r2.<init>(r10)     // Catch:{ all -> 0x07c2 }
        L_0x0799:
            r1.a(r2)     // Catch:{ all -> 0x07c2 }
            i4.c r1 = r1.d()     // Catch:{ all -> 0x07c2 }
            r0.f8252c = r1     // Catch:{ all -> 0x07c2 }
            i4.t r0 = r0.a()     // Catch:{ all -> 0x07c2 }
            goto L_0x07bb
        L_0x07a7:
            r22 = r0
            r25 = r1
            r24 = r11
            r23 = r12
            r18 = r14
            r10 = 1
            i4.l r0 = new i4.l     // Catch:{ all -> 0x07c2 }
            r0.<init>(r2)     // Catch:{ all -> 0x07c2 }
            i4.t r0 = r0.a()     // Catch:{ all -> 0x07c2 }
        L_0x07bb:
            i4.a.f8231b = r0     // Catch:{ all -> 0x07c2 }
            monitor-exit(r3)
            r3 = r0
            r0 = r25
            goto L_0x07cf
        L_0x07c2:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        L_0x07c5:
            r22 = r0
            r24 = r11
            r23 = r12
            r18 = r14
            r10 = 1
            r0 = r1
        L_0x07cf:
            r3.b(r0)
            r13 = 0
            r11 = r45
            goto L_0x085e
        L_0x07d7:
            r22 = r0
            r17 = r9
            r24 = r11
            r23 = r12
            r16 = r13
            r18 = r14
            r10 = 1
            r11 = r45
            androidx.fragment.app.c0 r0 = r11.f9626a
            com.bumptech.glide.s r0 = com.bumptech.glide.c.f(r0)
            java.lang.String r1 = r11.f9631f
            int r3 = r1.hashCode()
            switch(r3) {
                case 50: goto L_0x0827;
                case 51: goto L_0x0811;
                case 52: goto L_0x07f6;
                default: goto L_0x07f5;
            }
        L_0x07f5:
            goto L_0x0836
        L_0x07f6:
            java.lang.String r3 = "4"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0836
            java.lang.String r1 = r2.getUrl4x()
            if (r1 != 0) goto L_0x083a
            java.lang.String r1 = r2.getUrl3x()
            if (r1 != 0) goto L_0x083a
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x083a
            goto L_0x0836
        L_0x0811:
            java.lang.String r3 = "3"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x081a
            goto L_0x0836
        L_0x081a:
            java.lang.String r1 = r2.getUrl3x()
            if (r1 != 0) goto L_0x083a
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x083a
            goto L_0x0836
        L_0x0827:
            java.lang.String r3 = "2"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0830
            goto L_0x0836
        L_0x0830:
            java.lang.String r1 = r2.getUrl2x()
            if (r1 != 0) goto L_0x083a
        L_0x0836:
            java.lang.String r1 = r2.getUrl1x()
        L_0x083a:
            com.bumptech.glide.q r0 = r0.p(r1)
            d5.r r1 = d5.u.f4492b
            s5.a r0 = r0.f(r1)
            com.bumptech.glide.q r0 = (com.bumptech.glide.q) r0
            l6.k r12 = new l6.k
            r1 = r12
            r3 = r45
            r4 = r23
            r5 = r24
            r6 = r21
            r7 = r20
            r8 = r22
            r13 = 0
            r9 = r19
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)
            r0.D(r12)
        L_0x085e:
            r10 = r11
            r13 = r16
            r16 = r17
            r0 = r22
            r12 = r23
            r11 = r24
            goto L_0x064d
        L_0x086b:
            r11 = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: l6.l.onBindViewHolder(androidx.recyclerview.widget.k2, int):void");
    }

    public final k2 onCreateViewHolder(ViewGroup viewGroup, int i10) {
        j.f("parent", viewGroup);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_list_item, viewGroup, false);
        j.e("from(parent.context).inf…list_item, parent, false)", inflate);
        return new h(this, inflate);
    }

    public final void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        j.f("recyclerView", recyclerView);
        int childCount = recyclerView.getChildCount();
        if (this.f9632g) {
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = recyclerView.getChildAt(i10);
                j.d("null cannot be cast to non-null type android.widget.TextView", childAt);
                CharSequence text = ((TextView) childAt).getText();
                Spannable spannable = text instanceof Spannable ? (Spannable) text : null;
                if (spannable != null) {
                    Object[] spans = spannable.getSpans(0, spannable.length(), ImageSpan.class);
                    j.e("getSpans(start, end, T::class.java)", spans);
                    for (ImageSpan drawable : (ImageSpan[]) spans) {
                        Drawable drawable2 = drawable.getDrawable();
                        Animatable animatable = drawable2 instanceof Animatable ? (Animatable) drawable2 : null;
                        if (animatable != null) {
                            animatable.stop();
                        }
                    }
                }
            }
        }
        super.onDetachedFromRecyclerView(recyclerView);
    }

    public final void onViewAttachedToWindow(k2 k2Var) {
        Spannable spannable;
        Animatable animatable;
        h hVar = (h) k2Var;
        j.f("holder", hVar);
        super.onViewAttachedToWindow(hVar);
        if (this.f9632g) {
            CharSequence text = hVar.f9606h.getText();
            if (text instanceof Spannable) {
                spannable = (Spannable) text;
            } else {
                spannable = null;
            }
            if (spannable != null) {
                Object[] spans = spannable.getSpans(0, spannable.length(), ImageSpan.class);
                j.e("getSpans(start, end, T::class.java)", spans);
                for (ImageSpan drawable : (ImageSpan[]) spans) {
                    Drawable drawable2 = drawable.getDrawable();
                    if (drawable2 instanceof Animatable) {
                        animatable = (Animatable) drawable2;
                    } else {
                        animatable = null;
                    }
                    if (animatable != null) {
                        animatable.start();
                    }
                }
            }
        }
    }

    public final void onViewDetachedFromWindow(k2 k2Var) {
        Spannable spannable;
        Animatable animatable;
        h hVar = (h) k2Var;
        j.f("holder", hVar);
        super.onViewDetachedFromWindow(hVar);
        if (this.f9632g) {
            CharSequence text = hVar.f9606h.getText();
            if (text instanceof Spannable) {
                spannable = (Spannable) text;
            } else {
                spannable = null;
            }
            if (spannable != null) {
                Object[] spans = spannable.getSpans(0, spannable.length(), ImageSpan.class);
                j.e("getSpans(start, end, T::class.java)", spans);
                for (ImageSpan drawable : (ImageSpan[]) spans) {
                    Drawable drawable2 = drawable.getDrawable();
                    if (drawable2 instanceof Animatable) {
                        animatable = (Animatable) drawable2;
                    } else {
                        animatable = null;
                    }
                    if (animatable != null) {
                        animatable.stop();
                    }
                }
            }
        }
    }
}
