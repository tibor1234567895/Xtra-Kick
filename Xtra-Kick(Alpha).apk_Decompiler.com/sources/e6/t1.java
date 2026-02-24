package e6;

import c6.b;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class t1 extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public b f5240i;

    /* renamed from: j  reason: collision with root package name */
    public int f5241j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ z1 f5242k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ String f5243l;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public t1(z1 z1Var, String str, e eVar) {
        super(2, eVar);
        this.f5242k = z1Var;
        this.f5243l = str;
    }

    public final e create(Object obj, e eVar) {
        return new t1(this.f5242k, this.f5243l, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((t1) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0071  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f5241j
            e6.z1 r3 = r0.f5242k
            r4 = 2
            r5 = 1
            if (r2 == 0) goto L_0x0026
            if (r2 == r5) goto L_0x0020
            if (r2 != r4) goto L_0x0018
            c6.b r1 = r0.f5240i
            hb.h0.O1(r21)
            r2 = r21
            goto L_0x004c
        L_0x0018:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0020:
            hb.h0.O1(r21)
            r2 = r21
            goto L_0x0036
        L_0x0026:
            hb.h0.O1(r21)
            e6.s0 r2 = r3.f5288f
            r0.f5241j = r5
            java.lang.String r6 = r0.f5243l
            java.lang.Object r2 = r2.a(r6, r0)
            if (r2 != r1) goto L_0x0036
            return r1
        L_0x0036:
            com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel r2 = (com.github.andreyasadchy.xtra.model.retrofit.kick.v2.Channel) r2
            c6.b r6 = r3.f5287e
            int r2 = r2.getUserId()
            r0.f5240i = r6
            r0.f5241j = r4
            com.github.andreyasadchy.xtra.api.MiscApi r3 = r3.f5283a
            java.lang.Object r2 = r3.getKickUser(r2, r0)
            if (r2 != r1) goto L_0x004b
            return r1
        L_0x004b:
            r1 = r6
        L_0x004c:
            com.github.andreyasadchy.xtra.model.retrofit.stv.KickUser r2 = (com.github.andreyasadchy.xtra.model.retrofit.stv.KickUser) r2
            r1.getClass()
            java.lang.String r1 = "kickUser"
            xa.j.f(r1, r2)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteSet r1 = r2.getEmoteSet()
            java.util.List r1 = r1.getEmotes()
            java.util.ArrayList r2 = new java.util.ArrayList
            int r3 = ma.s.i(r1)
            r2.<init>(r3)
            java.util.Iterator r1 = r1.iterator()
        L_0x006b:
            boolean r3 = r1.hasNext()
            if (r3 == 0) goto L_0x0175
            java.lang.Object r3 = r1.next()
            com.github.andreyasadchy.xtra.model.retrofit.stv.Emote r3 = (com.github.andreyasadchy.xtra.model.retrofit.stv.Emote) r3
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteData r6 = r3.getData()
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteHost r6 = r6.getHost()
            java.lang.String r6 = r6.getUrl()
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteData r7 = r3.getData()
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteHost r7 = r7.getHost()
            java.util.List r7 = r7.getFiles()
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            java.util.Iterator r7 = r7.iterator()
        L_0x0098:
            boolean r9 = r7.hasNext()
            r10 = 0
            if (r9 == 0) goto L_0x00b5
            java.lang.Object r9 = r7.next()
            r11 = r9
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile r11 = (com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile) r11
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFormat r11 = r11.getFormat()
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFormat r12 = com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFormat.WEBP
            if (r11 != r12) goto L_0x00af
            r10 = 1
        L_0x00af:
            if (r10 == 0) goto L_0x0098
            r8.add(r9)
            goto L_0x0098
        L_0x00b5:
            java.lang.String r12 = r3.getName()
            java.lang.Object r7 = ma.z.v(r8, r10)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile r7 = (com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile) r7
            java.lang.String r9 = "/"
            java.lang.String r11 = "https:"
            r13 = 0
            if (r7 == 0) goto L_0x00dd
            java.lang.String r7 = r7.getName()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>(r11)
            r14.append(r6)
            r14.append(r9)
            r14.append(r7)
            java.lang.String r7 = r14.toString()
            goto L_0x00de
        L_0x00dd:
            r7 = r13
        L_0x00de:
            java.lang.Object r14 = ma.z.v(r8, r5)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile r14 = (com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile) r14
            if (r14 == 0) goto L_0x00fd
            java.lang.String r14 = r14.getName()
            java.lang.StringBuilder r15 = new java.lang.StringBuilder
            r15.<init>(r11)
            r15.append(r6)
            r15.append(r9)
            r15.append(r14)
            java.lang.String r14 = r15.toString()
            goto L_0x00fe
        L_0x00fd:
            r14 = r13
        L_0x00fe:
            java.lang.Object r15 = ma.z.v(r8, r4)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile r15 = (com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile) r15
            if (r15 == 0) goto L_0x011e
            java.lang.String r15 = r15.getName()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r11)
            r4.append(r6)
            r4.append(r9)
            r4.append(r15)
            java.lang.String r4 = r4.toString()
            r15 = r4
            goto L_0x011f
        L_0x011e:
            r15 = r13
        L_0x011f:
            r4 = 3
            java.lang.Object r4 = ma.z.v(r8, r4)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile r4 = (com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteFile) r4
            if (r4 == 0) goto L_0x0141
            java.lang.String r4 = r4.getName()
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r11)
            r8.append(r6)
            r8.append(r9)
            r8.append(r4)
            java.lang.String r4 = r8.toString()
            r16 = r4
            goto L_0x0143
        L_0x0141:
            r16 = r13
        L_0x0143:
            java.lang.String r17 = "webp"
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteData r4 = r3.getData()
            boolean r4 = r4.getAnimated()
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r4)
            com.github.andreyasadchy.xtra.model.retrofit.stv.EmoteData r3 = r3.getData()
            java.util.List r3 = r3.getTags()
            if (r3 == 0) goto L_0x0166
            java.lang.String r4 = "zerowidth"
            boolean r3 = r3.contains(r4)
            if (r3 != r5) goto L_0x0166
            r19 = 1
            goto L_0x0168
        L_0x0166:
            r19 = 0
        L_0x0168:
            com.github.andreyasadchy.xtra.model.chat.StvEmote r3 = new com.github.andreyasadchy.xtra.model.chat.StvEmote
            r11 = r3
            r13 = r7
            r11.<init>(r12, r13, r14, r15, r16, r17, r18, r19)
            r2.add(r3)
            r4 = 2
            goto L_0x006b
        L_0x0175:
            com.github.andreyasadchy.xtra.model.chat.StvChannelResponse r1 = new com.github.andreyasadchy.xtra.model.chat.StvChannelResponse
            r1.<init>(r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: e6.t1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
