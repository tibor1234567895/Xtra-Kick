package i6;

import wa.l;
import xa.k;

public final class b extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8299h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ e f8300i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(e eVar, int i10) {
        super(1);
        this.f8299h = i10;
        this.f8300i = eVar;
    }

    /* JADX WARNING: type inference failed for: r3v1, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: type inference failed for: r3v3, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x016f, code lost:
        r4 = r2.getString(r4);
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r0.f8299h
            r2 = 0
            i6.e r3 = r0.f8300i
            switch(r1) {
                case 0: goto L_0x0021;
                case 1: goto L_0x000c;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x01e3
        L_0x000c:
            r1 = r23
            java.lang.Integer r1 = (java.lang.Integer) r1
            androidx.fragment.app.c0 r3 = r3.C
            boolean r4 = r3 instanceof w6.f
            if (r4 == 0) goto L_0x0019
            r2 = r3
            w6.f r2 = (w6.f) r2
        L_0x0019:
            if (r2 == 0) goto L_0x001e
            r2.W0(r1)
        L_0x001e:
            la.v r1 = la.v.f9814a
            return r1
        L_0x0021:
            r1 = r23
            t7.l r1 = (t7.l) r1
            java.lang.String r2 = "it"
            xa.j.e(r2, r1)
            i6.a r2 = i6.e.f8314q0
            r3.getClass()
            java.lang.String r2 = r1.f14714c
            java.lang.String r4 = r1.f14712a
            if (r2 == 0) goto L_0x01b4
            int r5 = r2.hashCode()
            r6 = 1
            java.lang.String r7 = r1.f14713b
            r8 = 2
            r9 = 0
            switch(r5) {
                case -1768979420: goto L_0x019c;
                case -1313911455: goto L_0x0174;
                case -1270457563: goto L_0x015f;
                case -1039690024: goto L_0x0133;
                case -676429144: goto L_0x0104;
                case 97295: goto L_0x00e9;
                case 3267882: goto L_0x00ce;
                case 285389372: goto L_0x00b3;
                case 530405532: goto L_0x0096;
                case 790311444: goto L_0x0079;
                case 1627245131: goto L_0x005e;
                case 1795979219: goto L_0x0043;
                default: goto L_0x0041;
            }
        L_0x0041:
            goto L_0x01b4
        L_0x0043:
            java.lang.String r5 = "send_msg_error"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x004d
            goto L_0x01b4
        L_0x004d:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r9] = r4
            r4 = 2131951721(0x7f130069, float:1.9539865E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x005e:
            java.lang.String r5 = "stream_live"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0068
            goto L_0x01b4
        L_0x0068:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r7
            r5 = 2131952369(0x7f1302f1, float:1.9541179E38)
            java.lang.String r4 = r2.getString(r5, r4)
            goto L_0x01b4
        L_0x0079:
            java.lang.String r5 = "clearmsg"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0083
            goto L_0x01b4
        L_0x0083:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r5[r9] = r4
            r5[r6] = r7
            r4 = 2131951713(0x7f130061, float:1.9539848E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x0096:
            java.lang.String r5 = "disconnect"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00a0
            goto L_0x01b4
        L_0x00a0:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r5[r9] = r4
            r5[r6] = r7
            r4 = 2131951714(0x7f130062, float:1.953985E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x00b3:
            java.lang.String r5 = "socket_error"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00bd
            goto L_0x01b4
        L_0x00bd:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r9] = r4
            r4 = 2131951722(0x7f13006a, float:1.9539867E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x00ce:
            java.lang.String r5 = "join"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00d8
            goto L_0x01b4
        L_0x00d8:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r9] = r4
            r4 = 2131951717(0x7f130065, float:1.9539856E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x00e9:
            java.lang.String r5 = "ban"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x00f3
            goto L_0x01b4
        L_0x00f3:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r6]
            r5[r9] = r4
            r4 = 2131951711(0x7f13005f, float:1.9539844E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x0104:
            java.lang.String r5 = "disconnect_command"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x010e
            goto L_0x01b4
        L_0x010e:
            k5.a r2 = r3.f8315o0
            xa.j.c(r2)
            java.lang.Object r2 = r2.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            r2.q()
            k5.a r2 = r3.f8315o0
            xa.j.c(r2)
            java.lang.Object r2 = r2.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            t7.n r4 = new t7.n
            r4.<init>()
            r2.t(r4)
            android.content.Context r2 = r3.f0()
            r4 = 2131951755(0x7f13008b, float:1.9539933E38)
            goto L_0x016f
        L_0x0133:
            java.lang.String r5 = "notice"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x013d
            goto L_0x01b4
        L_0x013d:
            java.lang.String r2 = "unraid_success"
            boolean r2 = xa.j.a(r7, r2)
            if (r2 == 0) goto L_0x0151
            k5.a r2 = r3.f8315o0
            xa.j.c(r2)
            java.lang.Object r2 = r2.f9125j
            com.github.andreyasadchy.xtra.ui.view.chat.ChatView r2 = (com.github.andreyasadchy.xtra.ui.view.chat.ChatView) r2
            r2.q()
        L_0x0151:
            s7.h r2 = s7.h.f14375a
            android.content.Context r5 = r3.f0()
            r2.getClass()
            java.lang.String r4 = s7.h.i(r5, r7, r4)
            goto L_0x01b4
        L_0x015f:
            java.lang.String r5 = "clearchat"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x0168
            goto L_0x01b4
        L_0x0168:
            android.content.Context r2 = r3.f0()
            r4 = 2131951712(0x7f130060, float:1.9539846E38)
        L_0x016f:
            java.lang.String r4 = r2.getString(r4)
            goto L_0x01b4
        L_0x0174:
            java.lang.String r5 = "timeout"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x017d
            goto L_0x01b4
        L_0x017d:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r5 = new java.lang.Object[r8]
            r5[r9] = r4
            s7.h r4 = s7.h.f14375a
            android.content.Context r8 = r3.f0()
            r4.getClass()
            java.lang.String r4 = s7.h.h(r8, r7, r6)
            r5[r6] = r4
            r4 = 2131951724(0x7f13006c, float:1.953987E38)
            java.lang.String r4 = r2.getString(r4, r5)
            goto L_0x01b4
        L_0x019c:
            java.lang.String r5 = "stream_offline"
            boolean r2 = r2.equals(r5)
            if (r2 != 0) goto L_0x01a5
            goto L_0x01b4
        L_0x01a5:
            android.content.Context r2 = r3.f0()
            java.lang.Object[] r4 = new java.lang.Object[r6]
            r4[r9] = r7
            r5 = 2131952370(0x7f1302f2, float:1.954118E38)
            java.lang.String r4 = r2.getString(r5, r4)
        L_0x01b4:
            r10 = r4
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r2 = r3.q0()
            i6.h r2 = r2.f3368y
            if (r2 == 0) goto L_0x01e0
            java.util.List r13 = r1.f14715d
            java.lang.Long r3 = r1.f14716e
            r19 = r3
            java.lang.String r15 = r1.f14717f
            com.github.andreyasadchy.xtra.model.chat.LiveChatMessage r1 = new com.github.andreyasadchy.xtra.model.chat.LiveChatMessage
            r5 = r1
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            java.lang.String r11 = "#999999"
            r12 = 1
            r14 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r20 = 7439(0x1d0f, float:1.0424E-41)
            r21 = 0
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)
            r2.a(r1)
        L_0x01e0:
            la.v r1 = la.v.f9814a
            return r1
        L_0x01e3:
            r1 = r23
            com.github.andreyasadchy.xtra.model.ui.BroadcastSettings r1 = (com.github.andreyasadchy.xtra.model.ui.BroadcastSettings) r1
            androidx.fragment.app.c0 r3 = r3.C
            boolean r4 = r3 instanceof w6.f
            if (r4 == 0) goto L_0x01f0
            r2 = r3
            w6.f r2 = (w6.f) r2
        L_0x01f0:
            if (r2 == 0) goto L_0x01f5
            r2.V0(r1)
        L_0x01f5:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.b.invoke(java.lang.Object):java.lang.Object");
    }
}
