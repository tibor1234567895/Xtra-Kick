package p7;

import android.content.Context;
import com.github.andreyasadchy.xtra.model.offline.SortGame;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class f extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public SortGame f12607i;

    /* renamed from: j  reason: collision with root package name */
    public int f12608j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ GameVideosViewModel f12609k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f12610l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f12611m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f12612n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ Context f12613o;

    /* renamed from: p  reason: collision with root package name */
    public final /* synthetic */ VideoPeriodEnum f12614p;

    /* renamed from: q  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f12615q;

    /* renamed from: r  reason: collision with root package name */
    public final /* synthetic */ int f12616r;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public f(GameVideosViewModel gameVideosViewModel, boolean z10, boolean z11, VideoSortEnum videoSortEnum, Context context, VideoPeriodEnum videoPeriodEnum, BroadcastTypeEnum broadcastTypeEnum, int i10, e eVar) {
        super(2, eVar);
        this.f12609k = gameVideosViewModel;
        this.f12610l = z10;
        this.f12611m = z11;
        this.f12612n = videoSortEnum;
        this.f12613o = context;
        this.f12614p = videoPeriodEnum;
        this.f12615q = broadcastTypeEnum;
        this.f12616r = i10;
    }

    public final e create(Object obj, e eVar) {
        return new f(this.f12609k, this.f12610l, this.f12611m, this.f12612n, this.f12613o, this.f12614p, this.f12615q, this.f12616r, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((f) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00e3  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00f4  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x013b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x016a  */
    /* JADX WARNING: Removed duplicated region for block: B:60:0x01aa A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r29) {
        /*
            r28 = this;
            r0 = r28
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f12608j
            r3 = 5
            r4 = 4
            r5 = 3
            r6 = 2
            r7 = 1
            boolean r8 = r0.f12610l
            r9 = 0
            int r10 = r0.f12616r
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r11 = r0.f12615q
            com.github.andreyasadchy.xtra.model.ui.VideoPeriodEnum r12 = r0.f12614p
            android.content.Context r13 = r0.f12613o
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r14 = r0.f12612n
            com.github.andreyasadchy.xtra.ui.videos.game.GameVideosViewModel r15 = r0.f12609k
            if (r2 == 0) goto L_0x004c
            if (r2 == r7) goto L_0x0046
            if (r2 == r6) goto L_0x003f
            if (r2 == r5) goto L_0x003a
            if (r2 == r4) goto L_0x0033
            if (r2 != r3) goto L_0x002b
            hb.h0.O1(r29)
            goto L_0x01ab
        L_0x002b:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0033:
            hb.h0.O1(r29)
            r2 = r29
            goto L_0x013c
        L_0x003a:
            hb.h0.O1(r29)
            goto L_0x012f
        L_0x003f:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = r0.f12607i
            hb.h0.O1(r29)
            goto L_0x00f0
        L_0x0046:
            hb.h0.O1(r29)
            r2 = r29
            goto L_0x0062
        L_0x004c:
            hb.h0.O1(r29)
            q6.f r2 = r15.f3526j
            int r2 = r2.f13353a
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.f12608j = r7
            e6.f2 r7 = r15.f3524h
            java.lang.Object r2 = r7.a(r2, r0)
            if (r2 != r1) goto L_0x0062
            return r1
        L_0x0062:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2
            if (r8 == 0) goto L_0x00d7
            if (r2 == 0) goto L_0x0097
            java.lang.Boolean r7 = java.lang.Boolean.TRUE
            r2.setSaveSort(r7)
            java.lang.String r7 = r14.getValue()
            r2.setVideoSort(r7)
            com.github.andreyasadchy.xtra.model.Account$Companion r7 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r7 = r7.get(r13)
            int r7 = r7.getId()
            if (r7 == 0) goto L_0x0087
            java.lang.String r7 = r12.getValue()
            r2.setVideoPeriod(r7)
        L_0x0087:
            java.lang.String r7 = r11.getValue()
            r2.setVideoType(r7)
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r10)
            r2.setVideoLanguageIndex(r7)
            goto L_0x00de
        L_0x0097:
            q6.f r7 = r15.f3526j
            int r7 = r7.f13353a
            com.github.andreyasadchy.xtra.model.offline.SortGame r27 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            java.lang.String r17 = java.lang.String.valueOf(r7)
            java.lang.Boolean r18 = java.lang.Boolean.TRUE
            java.lang.String r19 = r14.getValue()
            com.github.andreyasadchy.xtra.model.Account$Companion r7 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r7 = r7.get(r13)
            int r7 = r7.getId()
            if (r7 == 0) goto L_0x00b6
            r20 = r9
            goto L_0x00bc
        L_0x00b6:
            java.lang.String r7 = r12.getValue()
            r20 = r7
        L_0x00bc:
            java.lang.String r21 = r11.getValue()
            java.lang.Integer r7 = new java.lang.Integer
            r7.<init>(r10)
            r23 = 0
            r24 = 0
            r25 = 192(0xc0, float:2.69E-43)
            r26 = 0
            r16 = r27
            r22 = r7
            r16.<init>(r17, r18, r19, r20, r21, r22, r23, r24, r25, r26)
            r7 = r27
            goto L_0x00e1
        L_0x00d7:
            if (r2 == 0) goto L_0x00e0
            java.lang.Boolean r7 = java.lang.Boolean.FALSE
            r2.setSaveSort(r7)
        L_0x00de:
            r7 = r2
            goto L_0x00e1
        L_0x00e0:
            r7 = r9
        L_0x00e1:
            if (r7 == 0) goto L_0x00f0
            e6.f2 r3 = r15.f3524h
            r0.f12607i = r2
            r0.f12608j = r6
            java.lang.Object r3 = r3.b(r7, r0)
            if (r3 != r1) goto L_0x00f0
            return r1
        L_0x00f0:
            boolean r3 = r0.f12611m
            if (r3 == 0) goto L_0x01ab
            if (r2 == 0) goto L_0x00fe
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r8)
            r2.setSaveSort(r3)
            goto L_0x0122
        L_0x00fe:
            q6.f r2 = r15.f3526j
            int r2 = r2.f13353a
            com.github.andreyasadchy.xtra.model.offline.SortGame r3 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            java.lang.String r18 = java.lang.String.valueOf(r2)
            java.lang.Boolean r19 = java.lang.Boolean.valueOf(r8)
            r20 = 0
            r21 = 0
            r22 = 0
            r23 = 0
            r24 = 0
            r25 = 0
            r26 = 252(0xfc, float:3.53E-43)
            r27 = 0
            r17 = r3
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
            r2 = r3
        L_0x0122:
            e6.f2 r3 = r15.f3524h
            r0.f12607i = r9
            r0.f12608j = r5
            java.lang.Object r2 = r3.b(r2, r0)
            if (r2 != r1) goto L_0x012f
            return r1
        L_0x012f:
            e6.f2 r2 = r15.f3524h
            r0.f12608j = r4
            java.lang.String r3 = "default"
            java.lang.Object r2 = r2.a(r3, r0)
            if (r2 != r1) goto L_0x013c
            return r1
        L_0x013c:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = (com.github.andreyasadchy.xtra.model.offline.SortGame) r2
            if (r2 == 0) goto L_0x016a
            java.lang.String r3 = r14.getValue()
            r2.setVideoSort(r3)
            com.github.andreyasadchy.xtra.model.Account$Companion r3 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r3 = r3.get(r13)
            int r3 = r3.getId()
            if (r3 == 0) goto L_0x015a
            java.lang.String r3 = r12.getValue()
            r2.setVideoPeriod(r3)
        L_0x015a:
            java.lang.String r3 = r11.getValue()
            r2.setVideoType(r3)
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r10)
            r2.setVideoLanguageIndex(r3)
            goto L_0x019f
        L_0x016a:
            com.github.andreyasadchy.xtra.model.offline.SortGame r2 = new com.github.andreyasadchy.xtra.model.offline.SortGame
            java.lang.String r18 = "default"
            r19 = 0
            java.lang.String r20 = r14.getValue()
            com.github.andreyasadchy.xtra.model.Account$Companion r3 = com.github.andreyasadchy.xtra.model.Account.Companion
            com.github.andreyasadchy.xtra.model.Account r3 = r3.get(r13)
            int r3 = r3.getId()
            if (r3 == 0) goto L_0x0181
            goto L_0x0185
        L_0x0181:
            java.lang.String r9 = r12.getValue()
        L_0x0185:
            r21 = r9
            java.lang.String r22 = r11.getValue()
            java.lang.Integer r3 = new java.lang.Integer
            r3.<init>(r10)
            r24 = 0
            r25 = 0
            r26 = 194(0xc2, float:2.72E-43)
            r27 = 0
            r17 = r2
            r23 = r3
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27)
        L_0x019f:
            e6.f2 r3 = r15.f3524h
            r4 = 5
            r0.f12608j = r4
            java.lang.Object r2 = r3.b(r2, r0)
            if (r2 != r1) goto L_0x01ab
            return r1
        L_0x01ab:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: p7.f.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
