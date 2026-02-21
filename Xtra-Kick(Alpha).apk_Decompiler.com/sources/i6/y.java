package i6;

import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import hb.f0;
import java.util.List;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class y extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8348i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8349j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ String f8350k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ int f8351l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ List f8352m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public y(ChatViewModel chatViewModel, String str, int i10, List list, e eVar) {
        super(2, eVar);
        this.f8349j = chatViewModel;
        this.f8350k = str;
        this.f8351l = i10;
        this.f8352m = list;
    }

    public final e create(Object obj, e eVar) {
        return new y(this.f8349j, this.f8350k, this.f8351l, this.f8352m, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((y) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: type inference failed for: r1v6, types: [i6.h] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) {
        /*
            r7 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r7.f8348i
            r2 = 0
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r3 = r7.f8349j
            r4 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r4) goto L_0x0010
            hb.h0.O1(r8)     // Catch:{ Exception -> 0x006f }
            goto L_0x0032
        L_0x0010:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0018:
            hb.h0.O1(r8)
            e6.z1 r8 = r3.f3348e     // Catch:{ Exception -> 0x006f }
            java.lang.String r1 = r7.f8350k     // Catch:{ Exception -> 0x006f }
            r7.f8348i = r4     // Catch:{ Exception -> 0x006f }
            r8.getClass()     // Catch:{ Exception -> 0x006f }
            nb.d r5 = hb.p0.f7834b     // Catch:{ Exception -> 0x006f }
            e6.t1 r6 = new e6.t1     // Catch:{ Exception -> 0x006f }
            r6.<init>(r8, r1, r2)     // Catch:{ Exception -> 0x006f }
            java.lang.Object r8 = hb.h0.c2(r5, r6, r7)     // Catch:{ Exception -> 0x006f }
            if (r8 != r0) goto L_0x0032
            return r0
        L_0x0032:
            com.github.andreyasadchy.xtra.model.chat.StvChannelResponse r8 = (com.github.andreyasadchy.xtra.model.chat.StvChannelResponse) r8     // Catch:{ Exception -> 0x006f }
            java.util.List r8 = r8.getEmotes()     // Catch:{ Exception -> 0x006f }
            java.util.List r0 = r7.f8352m     // Catch:{ Exception -> 0x006f }
            boolean r1 = r8.isEmpty()     // Catch:{ Exception -> 0x006f }
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0085
            i6.h r1 = r3.f3368y     // Catch:{ Exception -> 0x006f }
            boolean r4 = r1 instanceof i6.m     // Catch:{ Exception -> 0x006f }
            if (r4 == 0) goto L_0x004a
            r2 = r1
            i6.m r2 = (i6.m) r2     // Catch:{ Exception -> 0x006f }
        L_0x004a:
            if (r2 == 0) goto L_0x004f
            r2.g(r8)     // Catch:{ Exception -> 0x006f }
        L_0x004f:
            r0.addAll(r8)     // Catch:{ Exception -> 0x006f }
            androidx.lifecycle.o0 r1 = r3.f3354k     // Catch:{ Exception -> 0x006f }
            i6.x r2 = new i6.x     // Catch:{ Exception -> 0x006f }
            r2.<init>()     // Catch:{ Exception -> 0x006f }
            java.util.List r0 = ma.z.F(r0, r2)     // Catch:{ Exception -> 0x006f }
            r1.l(r0)     // Catch:{ Exception -> 0x006f }
            androidx.lifecycle.o0 r0 = r3.f3356m     // Catch:{ Exception -> 0x006f }
            r0.j(r8)     // Catch:{ Exception -> 0x006f }
            s7.l r8 = r3.f()     // Catch:{ Exception -> 0x006f }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x006f }
            r8.l(r0)     // Catch:{ Exception -> 0x006f }
            goto L_0x0085
        L_0x006f:
            r8 = move-exception
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Failed to load 7tv emotes for channel "
            r0.<init>(r1)
            int r1 = r7.f8351l
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "ChatViewModel"
            android.util.Log.e(r1, r0, r8)
        L_0x0085:
            la.v r8 = la.v.f9814a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.y.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
