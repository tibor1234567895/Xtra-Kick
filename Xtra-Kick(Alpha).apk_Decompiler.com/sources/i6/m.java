package i6;

import c6.b;
import cc.g;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.model.chat.Chatter;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import com.github.andreyasadchy.xtra.model.chat.LiveChatMessage;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import e6.s0;
import hb.f0;
import hb.h0;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import pb.f1;
import s7.h;
import s7.l;
import t7.k;
import xa.j;

public final class m extends h {

    /* renamed from: b  reason: collision with root package name */
    public final int f8322b;

    /* renamed from: c  reason: collision with root package name */
    public final String f8323c;

    /* renamed from: d  reason: collision with root package name */
    public final String f8324d = "eb1d5f283081a78b932c";

    /* renamed from: e  reason: collision with root package name */
    public final boolean f8325e = false;

    /* renamed from: f  reason: collision with root package name */
    public k f8326f;

    /* renamed from: g  reason: collision with root package name */
    public final ArrayList f8327g = new ArrayList();

    /* renamed from: h  reason: collision with root package name */
    public final ConcurrentHashMap f8328h = new ConcurrentHashMap();

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8329i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public m(ChatViewModel chatViewModel, Account account, boolean z10, int i10, String str, String str2, boolean z11, boolean z12) {
        super(chatViewModel);
        this.f8329i = chatViewModel;
        this.f8322b = i10;
        this.f8323c = str;
        f(str2);
    }

    public final void a(LiveChatMessage liveChatMessage) {
        super.a(liveChatMessage);
        f(liveChatMessage.getUserName());
    }

    public final void b() {
        k kVar = this.f8326f;
        if (kVar != null) {
            kVar.f14709h = false;
            g gVar = kVar.f14708g;
            if (gVar != null) {
                gVar.b(1000, (String) null);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v1, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v5, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.CharSequence r11) {
        /*
            r10 = this;
            boolean r0 = r10.f8325e
            java.lang.String r1 = "/disconnect"
            r2 = 0
            if (r0 == 0) goto L_0x003c
            java.lang.String r0 = r11.toString()
            java.lang.String r3 = "/"
            boolean r0 = fb.w.m(r0, r3, r2)
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = r11.toString()     // Catch:{ Exception -> 0x002d }
            java.lang.String r2 = " "
            java.lang.String r0 = fb.y.M(r0, r2, r0)     // Catch:{ Exception -> 0x002d }
            boolean r0 = fb.w.g(r0, r1)     // Catch:{ Exception -> 0x002d }
            if (r0 == 0) goto L_0x0028
            r10.h()     // Catch:{ Exception -> 0x002d }
            goto L_0x00cb
        L_0x0028:
            r10.i(r11)     // Catch:{ Exception -> 0x002d }
            goto L_0x00cb
        L_0x002d:
            r11 = move-exception
            java.lang.String r0 = "NOP"
            java.lang.String r1 = "error: "
            android.util.Log.e(r0, r1, r11)
            goto L_0x00cb
        L_0x0037:
            r10.i(r11)
            goto L_0x00cb
        L_0x003c:
            java.lang.String r0 = r11.toString()
            java.lang.String r3 = "/dc"
            boolean r0 = xa.j.a(r0, r3)
            r3 = 1
            if (r0 != 0) goto L_0x00bd
            java.lang.String r0 = r11.toString()
            boolean r0 = xa.j.a(r0, r1)
            if (r0 == 0) goto L_0x0054
            goto L_0x00bd
        L_0x0054:
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            long r4 = java.lang.System.currentTimeMillis()
            char[] r1 = new char[r3]
            r6 = 32
            r1[r2] = r6
            java.util.List r11 = fb.y.E(r11, r1)
            java.util.Iterator r11 = r11.iterator()
        L_0x006b:
            boolean r1 = r11.hasNext()
            r6 = 0
            if (r1 == 0) goto L_0x00a3
            java.lang.Object r1 = r11.next()
            java.lang.String r1 = (java.lang.String) r1
            java.util.ArrayList r7 = r10.f8327g
            java.util.Iterator r7 = r7.iterator()
        L_0x007e:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0096
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.github.andreyasadchy.xtra.model.chat.Emote r9 = (com.github.andreyasadchy.xtra.model.chat.Emote) r9
            java.lang.String r9 = r9.getName()
            boolean r9 = xa.j.a(r9, r1)
            if (r9 == 0) goto L_0x007e
            r6 = r8
        L_0x0096:
            com.github.andreyasadchy.xtra.model.chat.Emote r6 = (com.github.andreyasadchy.xtra.model.chat.Emote) r6
            if (r6 == 0) goto L_0x006b
            com.github.andreyasadchy.xtra.model.chat.RecentEmote r6 = new com.github.andreyasadchy.xtra.model.chat.RecentEmote
            r6.<init>(r1, r4)
            r0.add(r6)
            goto L_0x006b
        L_0x00a3:
            boolean r11 = r0.isEmpty()
            r11 = r11 ^ r3
            if (r11 == 0) goto L_0x00cb
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r11 = r10.f8329i
            e6.z1 r11 = r11.f3348e
            r11.getClass()
            hb.d1 r1 = hb.d1.f7786h
            e6.p1 r3 = new e6.p1
            r3.<init>(r0, r11, r6)
            r11 = 3
            hb.h0.b1(r1, r6, r2, r3, r11)
            goto L_0x00cb
        L_0x00bd:
            t7.k r11 = r10.f8326f
            if (r11 == 0) goto L_0x00c6
            boolean r11 = r11.f14709h
            if (r11 != r3) goto L_0x00c6
            r2 = 1
        L_0x00c6:
            if (r2 == 0) goto L_0x00cb
            r10.h()
        L_0x00cb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.m.c(java.lang.CharSequence):void");
    }

    public final void d() {
        b();
        h hVar = h.f14375a;
        ChatViewModel chatViewModel = this.f8329i;
        f1 f1Var = chatViewModel.f3349f;
        f0 I0 = h0.I0(chatViewModel);
        hVar.getClass();
        String str = this.f8323c;
        j.f("channelSlug", str);
        j.f("client", f1Var);
        String str2 = this.f8324d;
        j.f("pusherKey", str2);
        s0 s0Var = chatViewModel.f3350g;
        j.f("kickApiRepository", s0Var);
        b bVar = chatViewModel.f3351h;
        j.f("kickMapper", bVar);
        k kVar = new k(str, str2, f1Var, I0, s0Var, new t7.b(this, this, bVar));
        kVar.b();
        this.f8326f = kVar;
    }

    public final void e() {
        b();
    }

    public final void f(String str) {
        if (str != null) {
            ConcurrentHashMap concurrentHashMap = this.f8328h;
            if (!concurrentHashMap.containsKey(str)) {
                Chatter chatter = new Chatter(str);
                concurrentHashMap.put(str, chatter);
                List list = ChatViewModel.A;
                ((l) this.f8329i.f3369z.getValue()).j(chatter);
            }
        }
    }

    public final void g(List list) {
        j.f("list", list);
        ArrayList arrayList = this.f8327g;
        ArrayList arrayList2 = new ArrayList();
        for (Object next : list) {
            if (!arrayList.contains((Emote) next)) {
                arrayList2.add(next);
            }
        }
        arrayList.addAll(arrayList2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        if (r0.f14709h == true) goto L_0x000c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void h() {
        /*
            r8 = this;
            t7.k r0 = r8.f8326f
            r1 = 0
            if (r0 == 0) goto L_0x000b
            boolean r2 = r0.f14709h
            r3 = 1
            if (r2 != r3) goto L_0x000b
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            if (r3 == 0) goto L_0x0040
            if (r0 == 0) goto L_0x001c
            r0.f14709h = r1
            cc.g r0 = r0.f14708g
            if (r0 == 0) goto L_0x001c
            r1 = 0
            r2 = 1000(0x3e8, float:1.401E-42)
            r0.b(r2, r1)
        L_0x001c:
            java.util.List r0 = com.github.andreyasadchy.xtra.ui.chat.ChatViewModel.A
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r0 = r8.f8329i
            androidx.lifecycle.o0 r1 = r0.d()
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r1.j(r2)
            s7.l r0 = r0.e()
            t7.l r7 = new t7.l
            r2 = 0
            r3 = 0
            java.lang.String r4 = "disconnect_command"
            r5 = 0
            r6 = 59
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r0.j(r7)
        L_0x0040:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.m.h():void");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v1, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v2, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v0, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.github.andreyasadchy.xtra.model.chat.Emote} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void i(java.lang.CharSequence r11) {
        /*
            r10 = this;
            java.util.HashSet r0 = new java.util.HashSet
            r0.<init>()
            long r1 = java.lang.System.currentTimeMillis()
            r3 = 1
            char[] r4 = new char[r3]
            r5 = 32
            r6 = 0
            r4[r6] = r5
            java.util.List r11 = fb.y.E(r11, r4)
            java.util.Iterator r11 = r11.iterator()
        L_0x0019:
            boolean r4 = r11.hasNext()
            r5 = 0
            if (r4 == 0) goto L_0x0051
            java.lang.Object r4 = r11.next()
            java.lang.String r4 = (java.lang.String) r4
            java.util.ArrayList r7 = r10.f8327g
            java.util.Iterator r7 = r7.iterator()
        L_0x002c:
            boolean r8 = r7.hasNext()
            if (r8 == 0) goto L_0x0044
            java.lang.Object r8 = r7.next()
            r9 = r8
            com.github.andreyasadchy.xtra.model.chat.Emote r9 = (com.github.andreyasadchy.xtra.model.chat.Emote) r9
            java.lang.String r9 = r9.getName()
            boolean r9 = xa.j.a(r9, r4)
            if (r9 == 0) goto L_0x002c
            r5 = r8
        L_0x0044:
            com.github.andreyasadchy.xtra.model.chat.Emote r5 = (com.github.andreyasadchy.xtra.model.chat.Emote) r5
            if (r5 == 0) goto L_0x0019
            com.github.andreyasadchy.xtra.model.chat.RecentEmote r5 = new com.github.andreyasadchy.xtra.model.chat.RecentEmote
            r5.<init>(r4, r1)
            r0.add(r5)
            goto L_0x0019
        L_0x0051:
            boolean r11 = r0.isEmpty()
            r11 = r11 ^ r3
            if (r11 == 0) goto L_0x006a
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r11 = r10.f8329i
            e6.z1 r11 = r11.f3348e
            r11.getClass()
            hb.d1 r1 = hb.d1.f7786h
            e6.p1 r2 = new e6.p1
            r2.<init>(r0, r11, r5)
            r11 = 3
            hb.h0.b1(r1, r5, r6, r2, r11)
        L_0x006a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.m.i(java.lang.CharSequence):void");
    }
}
