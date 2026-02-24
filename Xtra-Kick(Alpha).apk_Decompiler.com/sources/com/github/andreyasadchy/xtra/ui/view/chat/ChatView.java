package com.github.andreyasadchy.xtra.ui.view.chat;

import android.content.Context;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.c0;
import androidx.fragment.app.f0;
import androidx.fragment.app.q0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.n1;
import androidx.viewpager2.widget.ViewPager2;
import com.github.andreyasadchy.xtra.model.chat.Emote;
import com.github.andreyasadchy.xtra.ui.chat.ChatViewModel;
import com.google.android.flexbox.FlexboxLayout;
import com.google.android.material.tabs.TabLayout;
import com.woxthebox.draglistview.R;
import e4.a;
import fb.y;
import hb.h0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import l6.l;
import l6.v;
import ma.r;
import r3.b0;
import r7.b;
import r7.c;
import r7.i;
import r7.j;
import s7.h;
import t7.n;
import z5.m;

public final class ChatView extends ConstraintLayout {
    public static final /* synthetic */ int I = 0;
    public boolean A;
    public Boolean B;
    public final ArrayList C = new ArrayList();
    public i D;
    public c0 E;
    public boolean F;
    public j G;
    public final q0 H = new q0(3, this);

    /* renamed from: x  reason: collision with root package name */
    public m f3551x;

    /* renamed from: y  reason: collision with root package name */
    public l f3552y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f3553z;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ChatView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        xa.j.f("context", context);
        xa.j.f("attrs", attributeSet);
        View inflate = LayoutInflater.from(context).inflate(R.layout.view_chat, this, false);
        addView(inflate);
        int i10 = R.id.btnDown;
        Button button = (Button) a.a(inflate, R.id.btnDown);
        if (button != null) {
            i10 = R.id.chatReplayUnavailable;
            if (((TextView) a.a(inflate, R.id.chatReplayUnavailable)) != null) {
                i10 = R.id.clear;
                ImageButton imageButton = (ImageButton) a.a(inflate, R.id.clear);
                if (imageButton != null) {
                    i10 = R.id.editText;
                    MultiAutoCompleteTextView multiAutoCompleteTextView = (MultiAutoCompleteTextView) a.a(inflate, R.id.editText);
                    if (multiAutoCompleteTextView != null) {
                        i10 = R.id.emoteMenu;
                        LinearLayout linearLayout = (LinearLayout) a.a(inflate, R.id.emoteMenu);
                        if (linearLayout != null) {
                            i10 = R.id.emotes;
                            ImageButton imageButton2 = (ImageButton) a.a(inflate, R.id.emotes);
                            if (imageButton2 != null) {
                                i10 = R.id.flexbox;
                                FlexboxLayout flexboxLayout = (FlexboxLayout) a.a(inflate, R.id.flexbox);
                                if (flexboxLayout != null) {
                                    i10 = R.id.messageView;
                                    LinearLayout linearLayout2 = (LinearLayout) a.a(inflate, R.id.messageView);
                                    if (linearLayout2 != null) {
                                        i10 = R.id.raidClose;
                                        ImageView imageView = (ImageView) a.a(inflate, R.id.raidClose);
                                        if (imageView != null) {
                                            i10 = R.id.raidImage;
                                            ImageView imageView2 = (ImageView) a.a(inflate, R.id.raidImage);
                                            if (imageView2 != null) {
                                                i10 = R.id.raidLayout;
                                                ConstraintLayout constraintLayout = (ConstraintLayout) a.a(inflate, R.id.raidLayout);
                                                if (constraintLayout != null) {
                                                    i10 = R.id.raidText;
                                                    TextView textView = (TextView) a.a(inflate, R.id.raidText);
                                                    if (textView != null) {
                                                        i10 = R.id.recyclerView;
                                                        RecyclerView recyclerView = (RecyclerView) a.a(inflate, R.id.recyclerView);
                                                        if (recyclerView != null) {
                                                            i10 = R.id.send;
                                                            ImageButton imageButton3 = (ImageButton) a.a(inflate, R.id.send);
                                                            if (imageButton3 != null) {
                                                                i10 = R.id.tabLayout;
                                                                TabLayout tabLayout = (TabLayout) a.a(inflate, R.id.tabLayout);
                                                                if (tabLayout != null) {
                                                                    i10 = R.id.textEmote;
                                                                    TextView textView2 = (TextView) a.a(inflate, R.id.textEmote);
                                                                    if (textView2 != null) {
                                                                        i10 = R.id.textFollowers;
                                                                        TextView textView3 = (TextView) a.a(inflate, R.id.textFollowers);
                                                                        if (textView3 != null) {
                                                                            i10 = R.id.textSlow;
                                                                            TextView textView4 = (TextView) a.a(inflate, R.id.textSlow);
                                                                            if (textView4 != null) {
                                                                                i10 = R.id.textSubs;
                                                                                TextView textView5 = (TextView) a.a(inflate, R.id.textSubs);
                                                                                if (textView5 != null) {
                                                                                    i10 = R.id.textUnique;
                                                                                    TextView textView6 = (TextView) a.a(inflate, R.id.textUnique);
                                                                                    if (textView6 != null) {
                                                                                        i10 = R.id.viewPager;
                                                                                        ViewPager2 viewPager2 = (ViewPager2) a.a(inflate, R.id.viewPager);
                                                                                        if (viewPager2 != null) {
                                                                                            ConstraintLayout constraintLayout2 = (ConstraintLayout) inflate;
                                                                                            this.f3551x = new m(button, imageButton, multiAutoCompleteTextView, linearLayout, imageButton2, flexboxLayout, linearLayout2, imageView, imageView2, constraintLayout, textView, recyclerView, imageButton3, tabLayout, textView2, textView3, textView4, textView5, textView6, viewPager2);
                                                                                            return;
                                                                                        }
                                                                                    }
                                                                                }
                                                                            }
                                                                        }
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    private final m getBinding() {
        m mVar = this.f3551x;
        xa.j.c(mVar);
        return mVar;
    }

    public static final boolean l(ChatView chatView) {
        m binding = chatView.getBinding();
        int computeVerticalScrollOffset = binding.f17725l.computeVerticalScrollOffset();
        if (computeVerticalScrollOffset < 0) {
            return false;
        }
        RecyclerView recyclerView = binding.f17725l;
        if ((((float) computeVerticalScrollOffset) * 100.0f) / ((float) (recyclerView.computeVerticalScrollRange() - recyclerView.computeVerticalScrollExtent())) < 100.0f) {
            return true;
        }
        return false;
    }

    public final void m(Collection collection) {
        ArrayList arrayList;
        if (!(collection == null || collection.isEmpty()) && this.F) {
            ArrayList arrayList2 = new ArrayList();
            Iterator it = collection.iterator();
            while (true) {
                boolean hasNext = it.hasNext();
                arrayList = this.C;
                if (!hasNext) {
                    break;
                }
                Object next = it.next();
                if (!arrayList.contains(next)) {
                    arrayList2.add(next);
                }
            }
            arrayList.addAll(arrayList2);
            i iVar = this.D;
            if (iVar != null) {
                iVar.addAll(arrayList2);
            }
        }
    }

    public final void n(Emote emote) {
        xa.j.f("emote", emote);
        getBinding().f17716c.getText().append(emote.getName()).append(' ');
    }

    public final boolean o() {
        LinearLayout linearLayout = getBinding().f17717d;
        xa.j.e("binding.emoteMenu", linearLayout);
        return linearLayout.getVisibility() == 0;
    }

    public final void onDetachedFromWindow() {
        getBinding().f17725l.setAdapter((g1) null);
        super.onDetachedFromWindow();
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x00cb  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00fa  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void p(boolean r11) {
        /*
            r10 = this;
            z5.m r0 = r10.getBinding()
            l6.l r1 = r10.f3552y
            r2 = 0
            if (r1 == 0) goto L_0x0103
            r7.l r3 = new r7.l
            r3.<init>(r0, r11, r10)
            r1.A = r3
            if (r11 == 0) goto L_0x0102
            r7.i r11 = new r7.i
            android.content.Context r1 = r10.getContext()
            java.lang.String r3 = "context"
            xa.j.e(r3, r1)
            androidx.fragment.app.c0 r4 = r10.E
            java.lang.String r5 = "fragment"
            if (r4 == 0) goto L_0x00fe
            java.util.ArrayList r6 = r10.C
            android.content.Context r7 = r10.getContext()
            xa.j.e(r3, r7)
            android.content.SharedPreferences r7 = hb.h0.l1(r7)
            java.lang.String r8 = "chat_image_quality"
            java.lang.String r9 = "4"
            java.lang.String r7 = r7.getString(r8, r9)
            if (r7 != 0) goto L_0x003b
            goto L_0x003c
        L_0x003b:
            r9 = r7
        L_0x003c:
            r11.<init>(r1, r4, r6, r9)
            r1 = 0
            r11.setNotifyOnChange(r1)
            android.widget.MultiAutoCompleteTextView r4 = r0.f17716c
            r4.setAdapter(r11)
            xa.s r4 = new xa.s
            r4.<init>()
            r7.d r6 = new r7.d
            r6.<init>(r11, r4)
            android.widget.MultiAutoCompleteTextView r4 = r0.f17716c
            r4.setOnFocusChangeListener(r6)
            r10.D = r11
            androidx.appcompat.widget.u3 r11 = new androidx.appcompat.widget.u3
            r6 = 2
            r11.<init>(r6, r0)
            r4.addTextChangedListener(r11)
            r7.k r11 = new r7.k
            r11.<init>()
            r4.setTokenizer(r11)
            r7.e r11 = new r7.e
            r11.<init>(r10)
            r4.setOnKeyListener(r11)
            i3.i r11 = new i3.i
            r4 = 22
            r11.<init>(r4, r0)
            android.widget.ImageButton r4 = r0.f17715b
            r4.setOnClickListener(r11)
            r7.f r11 = new r7.f
            r11.<init>(r0)
            r4.setOnLongClickListener(r11)
            r7.c r11 = new r7.c
            r4 = 1
            r11.<init>(r10, r4)
            android.widget.ImageButton r7 = r0.f17726m
            r7.setOnClickListener(r11)
            android.view.ViewParent r11 = r10.getParent()
            java.lang.String r7 = "messageView"
            android.widget.LinearLayout r8 = r0.f17720g
            if (r11 == 0) goto L_0x00c1
            android.view.ViewParent r11 = r10.getParent()
            android.view.ViewParent r11 = r11.getParent()
            boolean r11 = r11 instanceof com.github.andreyasadchy.xtra.ui.view.SlidingLayout
            if (r11 == 0) goto L_0x00c1
            android.content.Context r11 = r10.getContext()
            xa.j.e(r3, r11)
            android.content.SharedPreferences r11 = hb.h0.l1(r11)
            java.lang.String r3 = "key_chat_bar_visible"
            boolean r11 = r11.getBoolean(r3, r4)
            if (r11 != 0) goto L_0x00c1
            xa.j.e(r7, r8)
            hb.h0.J0(r8)
            goto L_0x00c7
        L_0x00c1:
            xa.j.e(r7, r8)
            r8.setVisibility(r1)
        L_0x00c7:
            androidx.fragment.app.c0 r11 = r10.E
            if (r11 == 0) goto L_0x00fa
            y6.b r1 = new y6.b
            r1.<init>(r6, r11)
            androidx.viewpager2.widget.ViewPager2 r11 = r0.f17733t
            r11.setAdapter(r1)
            r11.setOffscreenPageLimit(r6)
            hb.h0.s1(r11)
            x8.n r1 = new x8.n
            e7.b r2 = new e7.b
            r3 = 3
            r2.<init>((int) r3, (java.lang.Object) r10)
            com.google.android.material.tabs.TabLayout r3 = r0.f17727n
            r1.<init>(r3, r11, r2)
            r1.a()
            h6.b r11 = new h6.b
            r1 = 19
            r11.<init>(r0, r1, r10)
            android.widget.ImageButton r0 = r0.f17718e
            r0.setOnClickListener(r11)
            r10.F = r4
            goto L_0x0102
        L_0x00fa:
            xa.j.l(r5)
            throw r2
        L_0x00fe:
            xa.j.l(r5)
            throw r2
        L_0x0102:
            return
        L_0x0103:
            java.lang.String r11 = "adapter"
            xa.j.l(r11)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.andreyasadchy.xtra.ui.view.chat.ChatView.p(boolean):void");
    }

    public final void q() {
        m binding = getBinding();
        ConstraintLayout constraintLayout = binding.f17723j;
        xa.j.e("raidLayout", constraintLayout);
        h0.J0(constraintLayout);
        ImageView imageView = binding.f17722i;
        xa.j.e("raidImage", imageView);
        h0.J0(imageView);
        TextView textView = binding.f17724k;
        xa.j.e("raidText", textView);
        h0.J0(textView);
        ImageView imageView2 = binding.f17721h;
        xa.j.e("raidClose", imageView2);
        h0.J0(imageView2);
    }

    public final void r(int i10, c0 c0Var) {
        String str;
        c0 c0Var2 = c0Var;
        xa.j.f("fragment", c0Var2);
        this.E = c0Var2;
        m binding = getBinding();
        Context context = getContext();
        xa.j.e("context", context);
        int E2 = h0.E(context, 29.5f);
        Context context2 = getContext();
        xa.j.e("context", context2);
        int E3 = h0.E(context2, 18.5f);
        Context context3 = getContext();
        xa.j.e("context", context3);
        boolean z10 = h0.l1(context3).getBoolean("chat_randomcolor", true);
        Context context4 = getContext();
        xa.j.e("context", context4);
        boolean z11 = h0.l1(context4).getBoolean("chat_boldnames", false);
        Context context5 = getContext();
        xa.j.e("context", context5);
        String string = h0.l1(context5).getString("chat_image_quality", "4");
        if (string == null) {
            str = "4";
        } else {
            str = string;
        }
        Context context6 = getContext();
        xa.j.e("context", context6);
        boolean z12 = h0.l1(context6).getBoolean("animatedGifEmotes", true);
        Context context7 = getContext();
        xa.j.e("context", context7);
        boolean z13 = h0.l1(context7).getBoolean("chat_zerowidth", true);
        Context context8 = getContext();
        xa.j.e("context", context8);
        boolean z14 = h0.l1(context8).getBoolean("chat_timestamps", false);
        Context context9 = getContext();
        xa.j.e("context", context9);
        String string2 = h0.l1(context9).getString("chat_timestamp_format", "0");
        Context context10 = getContext();
        xa.j.e("context", context10);
        String string3 = h0.l1(context10).getString("chat_firstmsg_visibility", "0");
        String string4 = getContext().getString(R.string.chat_first);
        String str2 = string4;
        xa.j.e("context.getString(R.string.chat_first)", string4);
        String string5 = getContext().getString(R.string.chat_reward);
        String str3 = string5;
        xa.j.e("context.getString(R.string.chat_reward)", string5);
        String string6 = getContext().getString(R.string.redeemed);
        String str4 = string6;
        xa.j.e("context.getString(R.string.redeemed)", string6);
        String string7 = getContext().getString(R.string.user_redeemed);
        String str5 = string7;
        xa.j.e("context.getString(R.string.user_redeemed)", string7);
        Context context11 = getContext();
        xa.j.e("context", context11);
        l lVar = r1;
        l lVar2 = new l(c0Var, E2, E3, z10, z11, str, z12, z13, z14, string2, string3, str2, str3, str4, str5, h0.l1(context11).getString("chat_image_library", "0"), i10);
        l lVar3 = lVar;
        this.f3552y = lVar3;
        m mVar = binding;
        RecyclerView recyclerView = mVar.f17725l;
        recyclerView.setAdapter(lVar3);
        recyclerView.setItemAnimator((n1) null);
        getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(1);
        linearLayoutManager.p1(true);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addOnScrollListener(new v(this, 1, mVar));
        mVar.f17714a.setOnClickListener(new c(this, 0));
    }

    public final void s() {
        m binding = getBinding();
        l lVar = this.f3552y;
        if (lVar != null) {
            List list = lVar.f9640o;
            if (list == null) {
                return;
            }
            if (lVar != null) {
                lVar.notifyItemInserted(r.d(list));
                Context context = getContext();
                xa.j.e("context", context);
                int i10 = h0.l1(context).getInt("chat_limit", 600);
                boolean z10 = false;
                if (list.size() >= i10 + 1) {
                    int size = list.size() - i10;
                    for (int i11 = 0; i11 < size; i11++) {
                        list.remove(0);
                    }
                    l lVar2 = this.f3552y;
                    if (lVar2 != null) {
                        lVar2.notifyItemRangeRemoved(0, size);
                    } else {
                        xa.j.l("adapter");
                        throw null;
                    }
                }
                if (!this.f3553z) {
                    Button button = binding.f17714a;
                    xa.j.e("btnDown", button);
                    if (button.getVisibility() == 8) {
                        z10 = true;
                    }
                    if (z10) {
                        binding.f17725l.scrollToPosition(r.d(list));
                        return;
                    }
                    return;
                }
                return;
            }
            xa.j.l("adapter");
            throw null;
        }
        xa.j.l("adapter");
        throw null;
    }

    public final void setCallback(j jVar) {
        xa.j.f("callback", jVar);
        this.G = jVar;
    }

    public final void setMessage(CharSequence charSequence) {
        xa.j.f("text", charSequence);
        getBinding().f17716c.setText(charSequence);
    }

    public final void setRecentEmotes(List<? extends Emote> list) {
        if (!(list == null || list.isEmpty())) {
            this.B = Boolean.TRUE;
        }
    }

    public final void setUsername(String str) {
        l lVar = this.f3552y;
        if (lVar != null) {
            lVar.f9650y = str;
        } else {
            xa.j.l("adapter");
            throw null;
        }
    }

    public final void t(n nVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        xa.j.f("roomState", nVar);
        m binding = getBinding();
        if (xa.j.a("0", "0")) {
            TextView textView = binding.f17728o;
            xa.j.e("textEmote", textView);
            h0.J0(textView);
        } else if (xa.j.a("0", "1")) {
            TextView textView2 = binding.f17728o;
            xa.j.e("textEmote", textView2);
            textView2.setVisibility(0);
        }
        if (xa.j.a("-1", "-1")) {
            TextView textView3 = binding.f17729p;
            xa.j.e("textFollowers", textView3);
            h0.J0(textView3);
        } else {
            if (xa.j.a("-1", "0")) {
                binding.f17729p.setText(getContext().getString(R.string.room_followers));
            } else {
                TextView textView4 = binding.f17729p;
                Context context = getContext();
                h hVar = h.f14375a;
                Context context2 = getContext();
                xa.j.e("context", context2);
                String valueOf = String.valueOf(Integer.parseInt("-1") * 60);
                hVar.getClass();
                textView4.setText(context.getString(R.string.room_followers_min, new Object[]{h.h(context2, valueOf, true)}));
            }
            TextView textView5 = binding.f17729p;
            xa.j.e("textFollowers", textView5);
            textView5.setVisibility(0);
        }
        if (xa.j.a("0", "0")) {
            TextView textView6 = binding.f17732s;
            xa.j.e("textUnique", textView6);
            h0.J0(textView6);
        } else if (xa.j.a("0", "1")) {
            TextView textView7 = binding.f17732s;
            xa.j.e("textUnique", textView7);
            textView7.setVisibility(0);
        }
        if (xa.j.a("0", "0")) {
            TextView textView8 = binding.f17730q;
            xa.j.e("textSlow", textView8);
            h0.J0(textView8);
        } else {
            TextView textView9 = binding.f17730q;
            Context context3 = getContext();
            h hVar2 = h.f14375a;
            Context context4 = getContext();
            xa.j.e("context", context4);
            hVar2.getClass();
            textView9.setText(context3.getString(R.string.room_slow, new Object[]{h.h(context4, "0", true)}));
            TextView textView10 = binding.f17730q;
            xa.j.e("textSlow", textView10);
            textView10.setVisibility(0);
        }
        if (xa.j.a("0", "0")) {
            TextView textView11 = binding.f17731r;
            xa.j.e("textSubs", textView11);
            h0.J0(textView11);
        } else if (xa.j.a("0", "1")) {
            TextView textView12 = binding.f17731r;
            xa.j.e("textSubs", textView12);
            textView12.setVisibility(0);
        }
        TextView textView13 = binding.f17728o;
        xa.j.e("textEmote", textView13);
        if (textView13.getVisibility() == 8) {
            z10 = true;
        } else {
            z10 = false;
        }
        FlexboxLayout flexboxLayout = binding.f17719f;
        if (z10) {
            TextView textView14 = binding.f17729p;
            xa.j.e("textFollowers", textView14);
            if (textView14.getVisibility() == 8) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                TextView textView15 = binding.f17732s;
                xa.j.e("textUnique", textView15);
                if (textView15.getVisibility() == 8) {
                    z12 = true;
                } else {
                    z12 = false;
                }
                if (z12) {
                    TextView textView16 = binding.f17730q;
                    xa.j.e("textSlow", textView16);
                    if (textView16.getVisibility() == 8) {
                        z13 = true;
                    } else {
                        z13 = false;
                    }
                    if (z13) {
                        TextView textView17 = binding.f17731r;
                        xa.j.e("textSubs", textView17);
                        if (textView17.getVisibility() == 8) {
                            z14 = true;
                        } else {
                            z14 = false;
                        }
                        if (z14) {
                            this.A = false;
                            xa.j.e("flexbox", flexboxLayout);
                            h0.J0(flexboxLayout);
                            return;
                        }
                    }
                }
            }
        }
        this.A = true;
        xa.j.e("flexbox", flexboxLayout);
        flexboxLayout.setVisibility(0);
        flexboxLayout.postDelayed(new b(binding, 0), 5000);
    }

    public final void u(String str) {
        String str2 = "@" + str + " ";
        MultiAutoCompleteTextView multiAutoCompleteTextView = getBinding().f17716c;
        multiAutoCompleteTextView.setText(str2);
        multiAutoCompleteTextView.setSelection(str2.length());
        multiAutoCompleteTextView.requestFocus();
        multiAutoCompleteTextView.postDelayed(new b0((InputMethodManager) multiAutoCompleteTextView.getContext().getSystemService("input_method"), 7, multiAutoCompleteTextView), 100);
    }

    public final void v() {
        l lVar = this.f3552y;
        if (lVar != null) {
            List list = lVar.f9640o;
            if (list != null) {
                getBinding().f17725l.scrollToPosition(r.d(list));
                return;
            }
            return;
        }
        xa.j.l("adapter");
        throw null;
    }

    public final boolean w() {
        boolean z10;
        boolean z11;
        m binding = getBinding();
        MultiAutoCompleteTextView multiAutoCompleteTextView = binding.f17716c;
        xa.j.e("editText", multiAutoCompleteTextView);
        h0.P0(multiAutoCompleteTextView);
        MultiAutoCompleteTextView multiAutoCompleteTextView2 = binding.f17716c;
        multiAutoCompleteTextView2.clearFocus();
        y(false);
        j jVar = this.G;
        if (jVar == null) {
            return false;
        }
        Editable text = multiAutoCompleteTextView2.getText();
        xa.j.e("editText.text", text);
        CharSequence R = y.R(text);
        multiAutoCompleteTextView2.getText().clear();
        if (R.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            i6.h hVar = ((ChatViewModel) jVar).f3368y;
            if (hVar != null) {
                hVar.c(R);
            }
            v();
            z11 = true;
        } else {
            z11 = false;
        }
        if (z11) {
            return true;
        }
        return false;
    }

    public final void x(boolean z10) {
        q0 q0Var = this.H;
        if (z10) {
            c0 c0Var = this.E;
            if (c0Var != null) {
                f0 d02 = c0Var.d0();
                c0 c0Var2 = this.E;
                if (c0Var2 != null) {
                    d02.f454o.a(c0Var2, q0Var);
                } else {
                    xa.j.l("fragment");
                    throw null;
                }
            } else {
                xa.j.l("fragment");
                throw null;
            }
        } else {
            q0Var.a();
        }
    }

    public final void y(boolean z10) {
        LinearLayout linearLayout = getBinding().f17717d;
        xa.j.e("binding.emoteMenu", linearLayout);
        if (z10) {
            h0.b2(linearLayout);
        } else {
            h0.J0(linearLayout);
        }
        x(z10);
    }
}
