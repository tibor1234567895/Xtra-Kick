package j3;

import a6.o;
import android.content.Context;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import androidx.fragment.app.y;
import androidx.lifecycle.l0;
import androidx.lifecycle.m0;
import androidx.lifecycle.v1;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import com.github.andreyasadchy.xtra.model.chat.RecentEmote;
import com.github.andreyasadchy.xtra.model.offline.Bookmark;
import com.github.andreyasadchy.xtra.model.offline.OfflineVideo;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.Video;
import com.github.andreyasadchy.xtra.ui.channel.ChannelPagerFragment;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import com.github.andreyasadchy.xtra.ui.games.GameMediaFragment;
import com.github.andreyasadchy.xtra.ui.games.GamePagerFragment;
import com.woxthebox.draglistview.R;
import fb.w;
import hb.h0;
import j6.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import la.i;
import ma.z;
import q6.a;
import q6.b;
import q6.g;
import q6.h;
import r3.s0;
import u6.d;
import w6.f;
import wa.l;
import xa.j;
import xa.k;
import xa.q;
import z6.c;

public final class m2 extends k implements l {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f8625h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f8626i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f8627j;

    /* renamed from: k  reason: collision with root package name */
    public final /* synthetic */ Object f8628k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public /* synthetic */ m2(Object obj, Object obj2, Object obj3, int i10) {
        super(1);
        this.f8625h = i10;
        this.f8626i = obj;
        this.f8627j = obj2;
        this.f8628k = obj3;
    }

    public final void a(View view) {
        d1 d1Var;
        d1 d1Var2;
        d1 d1Var3;
        d1 d1Var4;
        d1 d1Var5;
        d1 d1Var6;
        d1 d1Var7;
        d1 d1Var8;
        int i10 = this.f8625h;
        Object obj = this.f8628k;
        Object obj2 = this.f8627j;
        Object obj3 = this.f8626i;
        switch (i10) {
            case 6:
                j.f("it", view);
                k0 V = h0.V(((e) obj3).f8817i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Clip clip = (Clip) obj;
                    d1Var2 = g.a(h.f13361a, clip.getGameId(), clip.getGameSlug(), clip.getGameName(), clip.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Clip clip2 = (Clip) obj;
                    d1Var2 = a.a(b.f13350a, clip2.getGameId(), clip2.getGameSlug(), clip2.getGameName(), clip2.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V.m(d1Var2);
                return;
            case 7:
                j.f("it", view);
                k0 V2 = h0.V(((k6.b) obj3).f9201i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Clip clip3 = (Clip) obj;
                    d1Var3 = g.a(h.f13361a, clip3.getGameId(), clip3.getGameSlug(), clip3.getGameName(), clip3.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Clip clip4 = (Clip) obj;
                    d1Var3 = a.a(b.f13350a, clip4.getGameId(), clip4.getGameSlug(), clip4.getGameName(), clip4.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V2.m(d1Var3);
                return;
            case 14:
                j.f("it", view);
                k0 V3 = h0.V(((c) obj3).f17740i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Bookmark bookmark = (Bookmark) obj;
                    d1Var4 = g.a(h.f13361a, bookmark.getGameId(), bookmark.getGameSlug(), bookmark.getGameName(), bookmark.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Bookmark bookmark2 = (Bookmark) obj;
                    d1Var4 = a.a(b.f13350a, bookmark2.getGameId(), bookmark2.getGameSlug(), bookmark2.getGameName(), bookmark2.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V3.m(d1Var4);
                return;
            case 15:
                j.f("it", view);
                k0 V4 = h0.V(((a7.c) obj3).f273i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    OfflineVideo offlineVideo = (OfflineVideo) obj;
                    d1Var5 = g.a(h.f13361a, offlineVideo.getGameId(), offlineVideo.getGameSlug(), offlineVideo.getGameName(), offlineVideo.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    OfflineVideo offlineVideo2 = (OfflineVideo) obj;
                    d1Var5 = a.a(b.f13350a, offlineVideo2.getGameId(), offlineVideo2.getGameSlug(), offlineVideo2.getGameName(), offlineVideo2.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V4.m(d1Var5);
                return;
            case Constants.IV_SIZE:
                j.f("it", view);
                k0 V5 = h0.V(((i7.b) obj3).f8360i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Stream stream = (Stream) obj;
                    d1Var6 = g.a(h.f13361a, stream.getGameId(), stream.getGameSlug(), stream.getGameName(), stream.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Stream stream2 = (Stream) obj;
                    d1Var6 = a.a(b.f13350a, stream2.getGameId(), stream2.getGameSlug(), stream2.getGameName(), stream2.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V5.m(d1Var6);
                return;
            case 17:
                j.f("it", view);
                k0 V6 = h0.V(((i7.e) obj3).f8369i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Stream stream3 = (Stream) obj;
                    d1Var7 = g.a(h.f13361a, stream3.getGameId(), stream3.getGameSlug(), stream3.getGameName(), stream3.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Stream stream4 = (Stream) obj;
                    d1Var7 = a.a(b.f13350a, stream4.getGameId(), stream4.getGameSlug(), stream4.getGameName(), stream4.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V6.m(d1Var7);
                return;
            case 18:
                j.f("it", view);
                k0 V7 = h0.V(((m7.g) obj3).f10694i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Video video = (Video) obj;
                    d1Var8 = g.a(h.f13361a, video.getGameId(), video.getGameSlug(), video.getGameName(), video.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Video video2 = (Video) obj;
                    d1Var8 = a.a(b.f13350a, video2.getGameId(), video2.getGameSlug(), video2.getGameName(), video2.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V7.m(d1Var8);
                return;
            default:
                j.f("it", view);
                k0 V8 = h0.V(((n7.b) obj3).f11712i);
                if (h0.l1((Context) obj2).getBoolean("ui_gamepager", true)) {
                    Video video3 = (Video) obj;
                    d1Var = g.a(h.f13361a, video3.getGameId(), video3.getGameSlug(), video3.getGameName(), video3.getBoxArtUrl(), (String[]) null, false, 240);
                } else {
                    Video video4 = (Video) obj;
                    d1Var = a.a(b.f13350a, video4.getGameId(), video4.getGameSlug(), video4.getGameName(), video4.getBoxArtUrl(), (String[]) null, false, 240);
                }
                V8.m(d1Var);
                return;
        }
    }

    public final void c(List list) {
        Object obj;
        int i10 = this.f8625h;
        Object obj2 = this.f8628k;
        Object obj3 = this.f8627j;
        Object obj4 = this.f8626i;
        switch (i10) {
            case 4:
                m0 m0Var = (m0) obj4;
                j.e("recent", list);
                List list2 = (List) obj3;
                List list3 = (List) obj2;
                ArrayList arrayList = new ArrayList();
                Iterator it = list.iterator();
                while (it.hasNext()) {
                    RecentEmote recentEmote = (RecentEmote) it.next();
                    j.e("user", list2);
                    j.e("other", list3);
                    Iterator it2 = z.C(list3, list2).iterator();
                    while (true) {
                        if (it2.hasNext()) {
                            obj = it2.next();
                            if (j.a(((Emote) obj).getName(), recentEmote.getName())) {
                            }
                        } else {
                            obj = null;
                        }
                    }
                    Emote emote = (Emote) obj;
                    if (emote != null) {
                        arrayList.add(emote);
                    }
                }
                m0Var.l(arrayList);
                return;
            default:
                m0 m0Var2 = (m0) obj4;
                ChatViewModel chatViewModel = (ChatViewModel) obj3;
                l0 l0Var = (l0) m0Var2.f1732l.c(chatViewModel.f3354k);
                if (l0Var != null) {
                    l0Var.f1729a.k(l0Var);
                }
                o oVar = (o) chatViewModel.f3348e.f5284b;
                oVar.getClass();
                m0Var2.m(oVar.f250a.f13722e.b(new String[]{"recent_emotes"}, new a6.e(oVar, s0.k(0, "SELECT * FROM recent_emotes ORDER BY used_at DESC"), 1)), new v1(4, new m2(m0Var2, (List) obj2, list, 4)));
                return;
        }
    }

    public final void d(i iVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        int i10 = R.string.unfollowed;
        int i11 = R.drawable.baseline_favorite_border_black_24;
        int i12 = this.f8625h;
        Object obj = this.f8628k;
        Object obj2 = this.f8627j;
        Object obj3 = this.f8626i;
        boolean z16 = false;
        boolean z17 = true;
        switch (i12) {
            case 3:
                boolean booleanValue = ((Boolean) iVar.f9799h).booleanValue();
                String str = (String) iVar.f9800i;
                q qVar = (q) obj3;
                if (qVar.f16814h) {
                    if (str == null || w.h(str)) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (!z11) {
                        h0.D1(((ChannelPagerFragment) obj2).f0(), str);
                    } else {
                        ChannelPagerFragment channelPagerFragment = (ChannelPagerFragment) obj2;
                        Context f02 = channelPagerFragment.f0();
                        Context f03 = channelPagerFragment.f0();
                        if (booleanValue) {
                            i10 = R.string.now_following;
                        }
                        String string = f03.getString(i10, new Object[]{channelPagerFragment.r0().f7682c});
                        j.e("requireContext().getStri…                        )", string);
                        h0.D1(f02, string);
                    }
                } else {
                    qVar.f16814h = true;
                }
                if (str != null && !w.h(str)) {
                    z17 = false;
                }
                if (z17) {
                    z5.e eVar = (z5.e) obj;
                    eVar.f17619d.setOnClickListener(new h6.j(booleanValue, (ChannelPagerFragment) obj2, 0));
                    if (booleanValue) {
                        i11 = R.drawable.baseline_favorite_black_24;
                    }
                    eVar.f17619d.setImageResource(i11);
                    return;
                }
                return;
            case 8:
                boolean booleanValue2 = ((Boolean) iVar.f9799h).booleanValue();
                String str2 = (String) iVar.f9800i;
                q qVar2 = (q) obj3;
                if (qVar2.f16814h) {
                    if (str2 == null || w.h(str2)) {
                        z12 = true;
                    } else {
                        z12 = false;
                    }
                    if (!z12) {
                        h0.D1(((GameMediaFragment) obj2).f0(), str2);
                    } else {
                        GameMediaFragment gameMediaFragment = (GameMediaFragment) obj2;
                        Context f04 = gameMediaFragment.f0();
                        Context f05 = gameMediaFragment.f0();
                        if (booleanValue2) {
                            i10 = R.string.now_following;
                        }
                        String string2 = f05.getString(i10, new Object[]{gameMediaFragment.q0().f13355c});
                        j.e("requireContext().getStri…                        )", string2);
                        h0.D1(f04, string2);
                    }
                } else {
                    qVar2.f16814h = true;
                }
                if (str2 == null || w.h(str2)) {
                    z16 = true;
                }
                if (z16) {
                    z5.h hVar = (z5.h) obj;
                    ((ImageButton) hVar.f17658d).setOnClickListener(new h6.j(booleanValue2, (GameMediaFragment) obj2, 1));
                    ImageButton imageButton = (ImageButton) hVar.f17658d;
                    if (booleanValue2) {
                        i11 = R.drawable.baseline_favorite_black_24;
                    }
                    imageButton.setImageResource(i11);
                    return;
                }
                return;
            case 9:
                boolean booleanValue3 = ((Boolean) iVar.f9799h).booleanValue();
                String str3 = (String) iVar.f9800i;
                q qVar3 = (q) obj3;
                if (qVar3.f16814h) {
                    if (str3 == null || w.h(str3)) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (!z13) {
                        h0.D1(((GamePagerFragment) obj2).f0(), str3);
                    } else {
                        GamePagerFragment gamePagerFragment = (GamePagerFragment) obj2;
                        Context f06 = gamePagerFragment.f0();
                        Context f07 = gamePagerFragment.f0();
                        if (booleanValue3) {
                            i10 = R.string.now_following;
                        }
                        String string3 = f07.getString(i10, new Object[]{gamePagerFragment.q0().f13355c});
                        j.e("requireContext().getStri…                        )", string3);
                        h0.D1(f06, string3);
                    }
                } else {
                    qVar3.f16814h = true;
                }
                if (str3 == null || w.h(str3)) {
                    z16 = true;
                }
                if (z16) {
                    z5.j jVar = (z5.j) obj;
                    ((ImageButton) jVar.f17682h).setOnClickListener(new h6.j(booleanValue3, (GamePagerFragment) obj2, 2));
                    ImageButton imageButton2 = (ImageButton) jVar.f17682h;
                    if (booleanValue3) {
                        i11 = R.drawable.baseline_favorite_black_24;
                    }
                    imageButton2.setImageResource(i11);
                    return;
                }
                return;
            case 10:
                boolean booleanValue4 = ((Boolean) iVar.f9799h).booleanValue();
                String str4 = (String) iVar.f9800i;
                q qVar4 = (q) obj3;
                if (qVar4.f16814h) {
                    if (str4 == null || w.h(str4)) {
                        z14 = true;
                    } else {
                        z14 = false;
                    }
                    if (!z14) {
                        h0.D1(((d) obj2).f0(), str4);
                    } else {
                        d dVar = (d) obj2;
                        Context f08 = dVar.f0();
                        Context f09 = dVar.f0();
                        if (booleanValue4) {
                            i10 = R.string.now_following;
                        }
                        Object[] objArr = new Object[1];
                        Clip clip = dVar.G0;
                        if (clip != null) {
                            objArr[0] = clip.getChannelName();
                            String string4 = f09.getString(i10, objArr);
                            j.e("requireContext().getStri…                        )", string4);
                            h0.D1(f08, string4);
                        } else {
                            j.l("clip");
                            throw null;
                        }
                    }
                } else {
                    qVar4.f16814h = true;
                }
                if (str4 == null || w.h(str4)) {
                    z16 = true;
                }
                if (z16) {
                    ImageButton imageButton3 = (ImageButton) obj;
                    if (imageButton3 != null) {
                        imageButton3.setOnClickListener(new h6.j(booleanValue4, (d) obj2, 3));
                    }
                    if (imageButton3 != null) {
                        if (booleanValue4) {
                            i11 = R.drawable.baseline_favorite_black_24;
                        }
                        imageButton3.setImageResource(i11);
                        return;
                    }
                    return;
                }
                return;
            case 12:
                boolean booleanValue5 = ((Boolean) iVar.f9799h).booleanValue();
                String str5 = (String) iVar.f9800i;
                q qVar5 = (q) obj3;
                if (qVar5.f16814h) {
                    if (str5 == null || w.h(str5)) {
                        z15 = true;
                    } else {
                        z15 = false;
                    }
                    if (!z15) {
                        h0.D1(((f) obj2).f0(), str5);
                    } else {
                        f fVar = (f) obj2;
                        Context f010 = fVar.f0();
                        Context f011 = fVar.f0();
                        if (booleanValue5) {
                            i10 = R.string.now_following;
                        }
                        Object[] objArr2 = new Object[1];
                        Stream stream = fVar.G0;
                        if (stream != null) {
                            objArr2[0] = stream.getChannelName();
                            String string5 = f011.getString(i10, objArr2);
                            j.e("requireContext().getStri…                        )", string5);
                            h0.D1(f010, string5);
                        } else {
                            j.l("stream");
                            throw null;
                        }
                    }
                } else {
                    qVar5.f16814h = true;
                }
                if (str5 == null || w.h(str5)) {
                    z16 = true;
                }
                if (z16) {
                    ImageButton imageButton4 = (ImageButton) obj;
                    if (imageButton4 != null) {
                        imageButton4.setOnClickListener(new h6.j(booleanValue5, (f) obj2, 4));
                    }
                    if (imageButton4 != null) {
                        if (booleanValue5) {
                            i11 = R.drawable.baseline_favorite_black_24;
                        }
                        imageButton4.setImageResource(i11);
                        return;
                    }
                    return;
                }
                return;
            default:
                boolean booleanValue6 = ((Boolean) iVar.f9799h).booleanValue();
                String str6 = (String) iVar.f9800i;
                q qVar6 = (q) obj3;
                if (qVar6.f16814h) {
                    if (str6 == null || w.h(str6)) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    if (!z10) {
                        h0.D1(((x6.h) obj2).f0(), str6);
                    } else {
                        x6.h hVar2 = (x6.h) obj2;
                        Context f012 = hVar2.f0();
                        Context f013 = hVar2.f0();
                        if (booleanValue6) {
                            i10 = R.string.now_following;
                        }
                        Object[] objArr3 = new Object[1];
                        Video video = hVar2.F0;
                        if (video != null) {
                            objArr3[0] = video.getChannelName();
                            String string6 = f013.getString(i10, objArr3);
                            j.e("requireContext().getStri…lowed, video.channelName)", string6);
                            h0.D1(f012, string6);
                        } else {
                            j.l("video");
                            throw null;
                        }
                    }
                } else {
                    qVar6.f16814h = true;
                }
                if (str6 == null || w.h(str6)) {
                    z16 = true;
                }
                if (z16) {
                    ImageButton imageButton5 = (ImageButton) obj;
                    if (imageButton5 != null) {
                        imageButton5.setOnClickListener(new h6.j(booleanValue6, (x6.h) obj2, 5));
                    }
                    if (imageButton5 != null) {
                        if (booleanValue6) {
                            i11 = R.drawable.baseline_favorite_black_24;
                        }
                        imageButton5.setImageResource(i11);
                        return;
                    }
                    return;
                }
                return;
        }
    }

    /* JADX WARNING: type inference failed for: r7v34, types: [androidx.fragment.app.c0] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object invoke(java.lang.Object r7) {
        /*
            r6 = this;
            int r0 = r6.f8625h
            r1 = 0
            java.lang.Object r2 = r6.f8628k
            java.lang.Object r3 = r6.f8627j
            java.lang.Object r4 = r6.f8626i
            switch(r0) {
                case 0: goto L_0x0118;
                case 1: goto L_0x00e1;
                case 2: goto L_0x00d9;
                case 3: goto L_0x00d1;
                case 4: goto L_0x00c9;
                case 5: goto L_0x00c1;
                case 6: goto L_0x00b9;
                case 7: goto L_0x00b1;
                case 8: goto L_0x00a9;
                case 9: goto L_0x00a1;
                case 10: goto L_0x0099;
                case 11: goto L_0x0056;
                case 12: goto L_0x004e;
                case 13: goto L_0x0046;
                case 14: goto L_0x003e;
                case 15: goto L_0x0036;
                case 16: goto L_0x002e;
                case 17: goto L_0x0026;
                case 18: goto L_0x001e;
                case 19: goto L_0x0016;
                case 20: goto L_0x000e;
                default: goto L_0x000c;
            }
        L_0x000c:
            goto L_0x0155
        L_0x000e:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.invoke((java.lang.Throwable) r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x0016:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x001e:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x0026:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x002e:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x0036:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x003e:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x0046:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x004e:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x0056:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            java.lang.String r0 = "it"
            xa.j.e(r0, r7)
            boolean r7 = r7.booleanValue()
            android.widget.ImageButton r4 = (android.widget.ImageButton) r4
            if (r7 == 0) goto L_0x008a
            if (r4 == 0) goto L_0x006a
            hb.h0.S(r4)
        L_0x006a:
            android.widget.ImageButton r3 = (android.widget.ImageButton) r3
            if (r3 == 0) goto L_0x0071
            hb.h0.S(r3)
        L_0x0071:
            w6.f r2 = (w6.f) r2
            androidx.fragment.app.c1 r7 = r2.u()
            java.lang.String r0 = "closeOnPip"
            androidx.fragment.app.c0 r7 = r7.E(r0)
            boolean r0 = r7 instanceof t6.d0
            if (r0 == 0) goto L_0x0084
            r1 = r7
            t6.d0 r1 = (t6.d0) r1
        L_0x0084:
            if (r1 == 0) goto L_0x0096
            r2.C0()
            goto L_0x0096
        L_0x008a:
            if (r4 == 0) goto L_0x008f
            hb.h0.O(r4)
        L_0x008f:
            android.widget.ImageButton r3 = (android.widget.ImageButton) r3
            if (r3 == 0) goto L_0x0096
            hb.h0.O(r3)
        L_0x0096:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0099:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00a1:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00a9:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00b1:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00b9:
            android.view.View r7 = (android.view.View) r7
            r6.a(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00c1:
            java.util.List r7 = (java.util.List) r7
            r6.c(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00c9:
            java.util.List r7 = (java.util.List) r7
            r6.c(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00d1:
            la.i r7 = (la.i) r7
            r6.d(r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00d9:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.invoke((java.lang.Throwable) r7)
            la.v r7 = la.v.f9814a
            return r7
        L_0x00e1:
            androidx.lifecycle.d0 r7 = (androidx.lifecycle.d0) r7
            if (r7 == 0) goto L_0x0115
            l3.m r4 = (l3.m) r4
            java.util.Set r7 = r4.m()
            androidx.fragment.app.c0 r3 = (androidx.fragment.app.c0) r3
            java.lang.String r0 = r3.F
            boolean r7 = ma.z.n(r7, r0)
            if (r7 != 0) goto L_0x0115
            androidx.fragment.app.y1 r7 = r3.C()
            r7.c()
            androidx.lifecycle.g0 r7 = r7.f1619l
            androidx.lifecycle.s r0 = r7.f1688d
            androidx.lifecycle.s r1 = androidx.lifecycle.s.CREATED
            boolean r0 = r0.a(r1)
            if (r0 == 0) goto L_0x0115
            androidx.fragment.app.k r0 = r4.f9559h
            j3.r r2 = (j3.r) r2
            java.lang.Object r0 = r0.invoke((java.lang.Object) r2)
            androidx.lifecycle.c0 r0 = (androidx.lifecycle.c0) r0
            r7.a(r0)
        L_0x0115:
            la.v r7 = la.v.f9814a
            return r7
        L_0x0118:
            j3.r r7 = (j3.r) r7
            java.lang.String r0 = "backStackEntry"
            xa.j.f(r0, r7)
            j3.c1 r0 = r7.f8661i
            boolean r5 = r0 instanceof j3.c1
            if (r5 == 0) goto L_0x0126
            goto L_0x0127
        L_0x0126:
            r0 = r1
        L_0x0127:
            if (r0 != 0) goto L_0x012a
            goto L_0x0154
        L_0x012a:
            j3.o2 r4 = (j3.o2) r4
            android.os.Bundle r5 = r7.b()
            j3.n1 r3 = (j3.n1) r3
            android.support.v4.media.h.y(r2)
            j3.c1 r2 = r4.c(r0, r5, r3)
            if (r2 != 0) goto L_0x013c
            goto L_0x0154
        L_0x013c:
            boolean r0 = xa.j.a(r2, r0)
            if (r0 == 0) goto L_0x0144
            r1 = r7
            goto L_0x0154
        L_0x0144:
            j3.r2 r0 = r4.b()
            android.os.Bundle r7 = r7.b()
            android.os.Bundle r7 = r2.b(r7)
            j3.r r1 = r0.a(r2, r7)
        L_0x0154:
            return r1
        L_0x0155:
            java.lang.Throwable r7 = (java.lang.Throwable) r7
            r6.invoke((java.lang.Throwable) r7)
            la.v r7 = la.v.f9814a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: j3.m2.invoke(java.lang.Object):java.lang.Object");
    }

    public final void invoke(Throwable th) {
        int i10 = this.f8625h;
        Object obj = this.f8628k;
        Object obj2 = this.f8627j;
        Object obj3 = this.f8626i;
        switch (i10) {
            case 2:
                t4.e eVar = (t4.e) obj3;
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) obj2;
                t4.i iVar = (t4.i) obj;
                if (viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnPreDrawListener(iVar);
                    return;
                } else {
                    eVar.f14545a.getViewTreeObserver().removeOnPreDrawListener(iVar);
                    return;
                }
            case 20:
                if (obj3 != jb.e.f8911l) {
                    l lVar = ((jb.c) obj2).f8898i;
                    android.support.v4.media.h.y(obj);
                    throw null;
                }
                return;
            default:
                pa.k kVar = (pa.k) obj;
                y v10 = h0.v((l) obj3, obj2, (y) null);
                if (v10 != null) {
                    h0.K0(kVar, v10);
                    return;
                }
                return;
        }
    }
}
