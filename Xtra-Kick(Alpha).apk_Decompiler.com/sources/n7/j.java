package n7;

import com.github.andreyasadchy.xtra.model.offline.SortChannel;
import com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum;
import com.github.andreyasadchy.xtra.model.ui.VideoSortEnum;
import com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel;
import hb.f0;
import la.v;
import pa.e;
import ra.i;
import wa.p;

public final class j extends i implements p {

    /* renamed from: i  reason: collision with root package name */
    public SortChannel f11737i;

    /* renamed from: j  reason: collision with root package name */
    public int f11738j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ ChannelVideosViewModel f11739k;

    /* renamed from: l  reason: collision with root package name */
    public final /* synthetic */ boolean f11740l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ boolean f11741m;

    /* renamed from: n  reason: collision with root package name */
    public final /* synthetic */ VideoSortEnum f11742n;

    /* renamed from: o  reason: collision with root package name */
    public final /* synthetic */ BroadcastTypeEnum f11743o;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(ChannelVideosViewModel channelVideosViewModel, boolean z10, boolean z11, VideoSortEnum videoSortEnum, BroadcastTypeEnum broadcastTypeEnum, e eVar) {
        super(2, eVar);
        this.f11739k = channelVideosViewModel;
        this.f11740l = z10;
        this.f11741m = z11;
        this.f11742n = videoSortEnum;
        this.f11743o = broadcastTypeEnum;
    }

    public final e create(Object obj, e eVar) {
        return new j(this.f11739k, this.f11740l, this.f11741m, this.f11742n, this.f11743o, eVar);
    }

    public final Object g(Object obj, Object obj2) {
        return ((j) create((f0) obj, (e) obj2)).invokeSuspend(v.f9814a);
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00f5 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012a A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invokeSuspend(java.lang.Object r23) {
        /*
            r22 = this;
            r0 = r22
            qa.a r1 = qa.a.COROUTINE_SUSPENDED
            int r2 = r0.f11738j
            r3 = 0
            r4 = 5
            r5 = 4
            r6 = 3
            r7 = 2
            r8 = 1
            boolean r9 = r0.f11740l
            com.github.andreyasadchy.xtra.model.ui.BroadcastTypeEnum r10 = r0.f11743o
            com.github.andreyasadchy.xtra.model.ui.VideoSortEnum r11 = r0.f11742n
            com.github.andreyasadchy.xtra.ui.videos.channel.ChannelVideosViewModel r12 = r0.f11739k
            if (r2 == 0) goto L_0x0046
            if (r2 == r8) goto L_0x0040
            if (r2 == r7) goto L_0x0039
            if (r2 == r6) goto L_0x0034
            if (r2 == r5) goto L_0x002d
            if (r2 != r4) goto L_0x0025
            hb.h0.O1(r23)
            goto L_0x012b
        L_0x0025:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002d:
            hb.h0.O1(r23)
            r2 = r23
            goto L_0x00f6
        L_0x0034:
            hb.h0.O1(r23)
            goto L_0x00e9
        L_0x0039:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = r0.f11737i
            hb.h0.O1(r23)
            goto L_0x00b1
        L_0x0040:
            hb.h0.O1(r23)
            r2 = r23
            goto L_0x005c
        L_0x0046:
            hb.h0.O1(r23)
            q6.f r2 = r12.f3517j
            int r2 = r2.f13359g
            java.lang.String r2 = java.lang.String.valueOf(r2)
            r0.f11738j = r8
            e6.c2 r8 = r12.f3515h
            java.lang.Object r2 = r8.a(r2, r0)
            if (r2 != r1) goto L_0x005c
            return r1
        L_0x005c:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2
            if (r9 == 0) goto L_0x0098
            if (r2 == 0) goto L_0x0076
            java.lang.Boolean r8 = java.lang.Boolean.TRUE
            r2.setSaveSort(r8)
            java.lang.String r8 = r11.getValue()
            r2.setVideoSort(r8)
            java.lang.String r8 = r10.getValue()
            r2.setVideoType(r8)
            goto L_0x009f
        L_0x0076:
            q6.f r8 = r12.f3517j
            int r8 = r8.f13359g
            com.github.andreyasadchy.xtra.model.offline.SortChannel r21 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            java.lang.String r14 = java.lang.String.valueOf(r8)
            java.lang.Boolean r15 = java.lang.Boolean.TRUE
            java.lang.String r16 = r11.getValue()
            java.lang.String r17 = r10.getValue()
            r18 = 0
            r19 = 16
            r20 = 0
            r13 = r21
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r8 = r21
            goto L_0x00a2
        L_0x0098:
            if (r2 == 0) goto L_0x00a1
            java.lang.Boolean r8 = java.lang.Boolean.FALSE
            r2.setSaveSort(r8)
        L_0x009f:
            r8 = r2
            goto L_0x00a2
        L_0x00a1:
            r8 = r3
        L_0x00a2:
            if (r8 == 0) goto L_0x00b1
            e6.c2 r13 = r12.f3515h
            r0.f11737i = r2
            r0.f11738j = r7
            java.lang.Object r7 = r13.b(r8, r0)
            if (r7 != r1) goto L_0x00b1
            return r1
        L_0x00b1:
            boolean r7 = r0.f11741m
            if (r7 == 0) goto L_0x012b
            if (r2 == 0) goto L_0x00bf
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r9)
            r2.setSaveSort(r7)
            goto L_0x00dc
        L_0x00bf:
            q6.f r2 = r12.f3517j
            int r2 = r2.f13359g
            com.github.andreyasadchy.xtra.model.offline.SortChannel r7 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            java.lang.String r14 = java.lang.String.valueOf(r2)
            java.lang.Boolean r15 = java.lang.Boolean.valueOf(r9)
            r16 = 0
            r17 = 0
            r18 = 0
            r19 = 28
            r20 = 0
            r13 = r7
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
            r2 = r7
        L_0x00dc:
            e6.c2 r7 = r12.f3515h
            r0.f11737i = r3
            r0.f11738j = r6
            java.lang.Object r2 = r7.b(r2, r0)
            if (r2 != r1) goto L_0x00e9
            return r1
        L_0x00e9:
            e6.c2 r2 = r12.f3515h
            r0.f11738j = r5
            java.lang.String r3 = "default"
            java.lang.Object r2 = r2.a(r3, r0)
            if (r2 != r1) goto L_0x00f6
            return r1
        L_0x00f6:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = (com.github.andreyasadchy.xtra.model.offline.SortChannel) r2
            if (r2 == 0) goto L_0x0109
            java.lang.String r3 = r11.getValue()
            r2.setVideoSort(r3)
            java.lang.String r3 = r10.getValue()
            r2.setVideoType(r3)
            goto L_0x0120
        L_0x0109:
            com.github.andreyasadchy.xtra.model.offline.SortChannel r2 = new com.github.andreyasadchy.xtra.model.offline.SortChannel
            java.lang.String r14 = "default"
            r15 = 0
            java.lang.String r16 = r11.getValue()
            java.lang.String r17 = r10.getValue()
            r18 = 0
            r19 = 18
            r20 = 0
            r13 = r2
            r13.<init>(r14, r15, r16, r17, r18, r19, r20)
        L_0x0120:
            e6.c2 r3 = r12.f3515h
            r0.f11738j = r4
            java.lang.Object r2 = r3.b(r2, r0)
            if (r2 != r1) goto L_0x012b
            return r1
        L_0x012b:
            la.v r1 = la.v.f9814a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: n7.j.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
