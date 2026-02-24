package i6;

import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import hb.f0;
import java.util.List;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class w extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public int f8345i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ ChatViewModel f8346j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ List f8347k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public w(ChatViewModel chatViewModel, List list, e eVar) {
        super(2, eVar);
        this.f8346j = chatViewModel;
        this.f8347k = list;
    }

    public final e create(Object obj, e eVar) {
        return new w(this.f8346j, this.f8347k, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((w) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: type inference failed for: r1v4, types: [i6.h] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r7) {
        /*
            r6 = this;
            qa.a r0 = qa.a.COROUTINE_SUSPENDED
            int r1 = r6.f8345i
            r2 = 0
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel r3 = r6.f8346j
            r4 = 1
            if (r1 == 0) goto L_0x0018
            if (r1 != r4) goto L_0x0010
            hb.h0.O1(r7)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0030
        L_0x0010:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0018:
            hb.h0.O1(r7)
            e6.z1 r7 = r3.f3348e     // Catch:{ Exception -> 0x0079 }
            r6.f8345i = r4     // Catch:{ Exception -> 0x0079 }
            r7.getClass()     // Catch:{ Exception -> 0x0079 }
            nb.d r1 = hb.p0.f7834b     // Catch:{ Exception -> 0x0079 }
            e6.q1 r5 = new e6.q1     // Catch:{ Exception -> 0x0079 }
            r5.<init>(r7, r2)     // Catch:{ Exception -> 0x0079 }
            java.lang.Object r7 = hb.h0.c2(r1, r5, r6)     // Catch:{ Exception -> 0x0079 }
            if (r7 != r0) goto L_0x0030
            return r0
        L_0x0030:
            retrofit2.Response r7 = (retrofit2.Response) r7     // Catch:{ Exception -> 0x0079 }
            java.lang.Object r7 = r7.body()     // Catch:{ Exception -> 0x0079 }
            com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse r7 = (com.github.andreyasadchy.xtra.model.chat.StvGlobalResponse) r7     // Catch:{ Exception -> 0x0079 }
            if (r7 == 0) goto L_0x0081
            java.util.List r7 = r7.getEmotes()     // Catch:{ Exception -> 0x0079 }
            if (r7 == 0) goto L_0x0081
            java.util.List r0 = r6.f8347k     // Catch:{ Exception -> 0x0079 }
            boolean r1 = r7.isEmpty()     // Catch:{ Exception -> 0x0079 }
            r1 = r1 ^ r4
            if (r1 == 0) goto L_0x0081
            com.github.andreyasadchy.xtra.ui.chat.ChatViewModel.B = r7     // Catch:{ Exception -> 0x0079 }
            i6.h r1 = r3.f3368y     // Catch:{ Exception -> 0x0079 }
            boolean r4 = r1 instanceof i6.m     // Catch:{ Exception -> 0x0079 }
            if (r4 == 0) goto L_0x0054
            r2 = r1
            i6.m r2 = (i6.m) r2     // Catch:{ Exception -> 0x0079 }
        L_0x0054:
            if (r2 == 0) goto L_0x0059
            r2.g(r7)     // Catch:{ Exception -> 0x0079 }
        L_0x0059:
            r0.addAll(r7)     // Catch:{ Exception -> 0x0079 }
            androidx.lifecycle.o0 r1 = r3.f3354k     // Catch:{ Exception -> 0x0079 }
            i6.v r2 = new i6.v     // Catch:{ Exception -> 0x0079 }
            r2.<init>()     // Catch:{ Exception -> 0x0079 }
            java.util.List r0 = ma.z.F(r0, r2)     // Catch:{ Exception -> 0x0079 }
            r1.l(r0)     // Catch:{ Exception -> 0x0079 }
            androidx.lifecycle.o0 r0 = r3.f3355l     // Catch:{ Exception -> 0x0079 }
            r0.j(r7)     // Catch:{ Exception -> 0x0079 }
            s7.l r7 = r3.f()     // Catch:{ Exception -> 0x0079 }
            java.lang.Boolean r0 = java.lang.Boolean.TRUE     // Catch:{ Exception -> 0x0079 }
            r7.l(r0)     // Catch:{ Exception -> 0x0079 }
            goto L_0x0081
        L_0x0079:
            r7 = move-exception
            java.lang.String r0 = "ChatViewModel"
            java.lang.String r1 = "Failed to load global 7tv emotes"
            android.util.Log.e(r0, r1, r7)
        L_0x0081:
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.w.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
