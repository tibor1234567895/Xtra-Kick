package com.github.andreyasadchy.xtra.ui.channel;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.media.h;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.c1;
import androidx.fragment.app.z1;
import androidx.lifecycle.o0;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import androidx.viewpager2.widget.ViewPager2;
import com.github.andreyasadchy.xtra.model.Account;
import com.github.andreyasadchy.xtra.model.ui.Stream;
import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.ui.main.MainActivity;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.tabs.TabLayout;
import com.woxthebox.draglistview.R;
import d5.u;
import e4.a;
import h6.a0;
import h6.b;
import h6.c;
import h6.c0;
import h6.d;
import h6.k;
import h6.m;
import h6.n;
import h6.o;
import h6.q;
import h6.w;
import h6.x;
import hb.d1;
import hb.h0;
import i3.i;
import j3.j;
import j3.m2;
import java.util.List;
import xa.v;
import z5.e;

public final class ChannelPagerFragment extends c0 implements l6.c0 {

    /* renamed from: r0  reason: collision with root package name */
    public static final /* synthetic */ int f3334r0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    public e f3335o0;

    /* renamed from: p0  reason: collision with root package name */
    public final j f3336p0 = new j(v.a(q.class), new z1(1, this));

    /* renamed from: q0  reason: collision with root package name */
    public final x1 f3337q0;

    public ChannelPagerFragment() {
        la.e t10 = h.t(new z1(2, this), 0);
        this.f3337q0 = h0.K(this, v.a(ChannelPagerViewModel.class), new m(t10, 0), new n(t10, 0), new o(this, t10, 0));
    }

    public static final void q0(ChannelPagerFragment channelPagerFragment, User user) {
        boolean z10;
        boolean z11;
        e eVar = channelPagerFragment.f3335o0;
        xa.j.c(eVar);
        ImageView imageView = eVar.f17631p;
        xa.j.e("userImage", imageView);
        if (imageView.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 && user.getChannelLogo() != null) {
            ConstraintLayout constraintLayout = eVar.f17632q;
            xa.j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            imageView.setVisibility(0);
            h0.c1(imageView, channelPagerFragment, user.getChannelLogo(), false, true, (u) null, 20);
            channelPagerFragment.e0().putString("channelLogo", user.getChannelLogo());
        }
        String bannerImageURL = user.getBannerImageURL();
        ImageView imageView2 = eVar.f17617b;
        xa.j.e("bannerImage", imageView2);
        if (bannerImageURL != null) {
            imageView2.setVisibility(0);
            h0.c1(imageView2, channelPagerFragment, user.getBannerImageURL(), false, false, (u) null, 28);
            TextView textView = eVar.f17633r;
            xa.j.e("userName", textView);
            if (textView.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                textView.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            h0.J0(imageView2);
        }
        String createdAt = user.getCreatedAt();
        TextView textView2 = eVar.f17629n;
        xa.j.e("userCreated", textView2);
        if (createdAt != null) {
            textView2.setVisibility(0);
            Context f02 = channelPagerFragment.f0();
            s7.h hVar = s7.h.f14375a;
            Context f03 = channelPagerFragment.f0();
            String createdAt2 = user.getCreatedAt();
            hVar.getClass();
            textView2.setText(f02.getString(R.string.created_at, new Object[]{s7.h.d(f03, createdAt2)}));
            if (user.getBannerImageURL() != null) {
                textView2.setTextColor(-3355444);
                textView2.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            h0.J0(textView2);
        }
        Integer followersCount = user.getFollowersCount();
        TextView textView3 = eVar.f17630o;
        xa.j.e("userFollowers", textView3);
        if (followersCount != null) {
            textView3.setVisibility(0);
            Context f04 = channelPagerFragment.f0();
            s7.h hVar2 = s7.h.f14375a;
            Context f05 = channelPagerFragment.f0();
            int intValue = user.getFollowersCount().intValue();
            hVar2.getClass();
            textView3.setText(f04.getString(R.string.followers, new Object[]{s7.h.a(f05, intValue)}));
            if (user.getBannerImageURL() != null) {
                textView3.setTextColor(-3355444);
                textView3.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            h0.J0(textView3);
        }
        TextView textView4 = eVar.f17634s;
        xa.j.e("userType", textView4);
        h0.J0(textView4);
        if (channelPagerFragment.r0().f7684e) {
            ChannelPagerViewModel s02 = channelPagerFragment.s0();
            Context f06 = channelPagerFragment.f0();
            if (!s02.f3344j) {
                s02.f3344j = true;
                h0.b1(d1.f7786h, (pa.h) null, 0, new a0(user, f06, s02, (pa.e) null), 3);
            }
        }
    }

    public final void K(int i10, int i11, Intent intent) {
        super.K(i10, i11, intent);
        if (i10 == 3 && i11 == -1) {
            d0().recreate();
        }
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        int i10;
        LayoutInflater layoutInflater2 = layoutInflater;
        xa.j.f("inflater", layoutInflater2);
        View inflate = layoutInflater2.inflate(R.layout.fragment_channel, viewGroup, false);
        int i11 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            i11 = R.id.bannerImage;
            ImageView imageView = (ImageView) a.a(inflate, R.id.bannerImage);
            if (imageView != null) {
                i11 = R.id.collapsingToolbar;
                CollapsingToolbarLayout collapsingToolbarLayout = (CollapsingToolbarLayout) a.a(inflate, R.id.collapsingToolbar);
                if (collapsingToolbarLayout != null) {
                    CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
                    i10 = R.id.followButton;
                    ImageButton imageButton = (ImageButton) a.a(inflate, R.id.followButton);
                    if (imageButton != null) {
                        i10 = R.id.gameName;
                        TextView textView = (TextView) a.a(inflate, R.id.gameName);
                        if (textView != null) {
                            i10 = R.id.lastBroadcast;
                            TextView textView2 = (TextView) a.a(inflate, R.id.lastBroadcast);
                            if (textView2 != null) {
                                i10 = R.id.menu;
                                ImageView imageView2 = (ImageView) a.a(inflate, R.id.menu);
                                if (imageView2 != null) {
                                    i10 = R.id.pagerLayout;
                                    View a10 = a.a(inflate, R.id.pagerLayout);
                                    if (a10 != null) {
                                        android.support.v4.media.session.u l10 = android.support.v4.media.session.u.l(a10);
                                        i10 = R.id.search;
                                        ImageView imageView3 = (ImageView) a.a(inflate, R.id.search);
                                        if (imageView3 != null) {
                                            i10 = R.id.streamLayout;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) a.a(inflate, R.id.streamLayout);
                                            if (constraintLayout != null) {
                                                i10 = R.id.streamLayout1;
                                                if (((LinearLayout) a.a(inflate, R.id.streamLayout1)) != null) {
                                                    i10 = R.id.streamLayout2;
                                                    if (((LinearLayout) a.a(inflate, R.id.streamLayout2)) != null) {
                                                        i10 = R.id.title;
                                                        TextView textView3 = (TextView) a.a(inflate, R.id.title);
                                                        if (textView3 != null) {
                                                            i10 = R.id.toolbar;
                                                            Toolbar toolbar = (Toolbar) a.a(inflate, R.id.toolbar);
                                                            if (toolbar != null) {
                                                                i10 = R.id.toolbarContainer;
                                                                if (((LinearLayout) a.a(inflate, R.id.toolbarContainer)) != null) {
                                                                    i10 = R.id.uptime;
                                                                    TextView textView4 = (TextView) a.a(inflate, R.id.uptime);
                                                                    if (textView4 != null) {
                                                                        i10 = R.id.userCreated;
                                                                        TextView textView5 = (TextView) a.a(inflate, R.id.userCreated);
                                                                        if (textView5 != null) {
                                                                            i10 = R.id.userFollowers;
                                                                            TextView textView6 = (TextView) a.a(inflate, R.id.userFollowers);
                                                                            if (textView6 != null) {
                                                                                i10 = R.id.userImage;
                                                                                ImageView imageView4 = (ImageView) a.a(inflate, R.id.userImage);
                                                                                if (imageView4 != null) {
                                                                                    i10 = R.id.userLayout;
                                                                                    ConstraintLayout constraintLayout2 = (ConstraintLayout) a.a(inflate, R.id.userLayout);
                                                                                    if (constraintLayout2 != null) {
                                                                                        i10 = R.id.userName;
                                                                                        TextView textView7 = (TextView) a.a(inflate, R.id.userName);
                                                                                        if (textView7 != null) {
                                                                                            i10 = R.id.userType;
                                                                                            TextView textView8 = (TextView) a.a(inflate, R.id.userType);
                                                                                            if (textView8 != null) {
                                                                                                i10 = R.id.viewers;
                                                                                                TextView textView9 = (TextView) a.a(inflate, R.id.viewers);
                                                                                                if (textView9 != null) {
                                                                                                    i10 = R.id.watchLive;
                                                                                                    TextView textView10 = (TextView) a.a(inflate, R.id.watchLive);
                                                                                                    if (textView10 != null) {
                                                                                                        this.f3335o0 = new e(coordinatorLayout, appBarLayout, imageView, collapsingToolbarLayout, imageButton, textView, textView2, imageView2, l10, imageView3, constraintLayout, textView3, toolbar, textView4, textView5, textView6, imageView4, constraintLayout2, textView7, textView8, textView9, textView10);
                                                                                                        xa.j.e("binding.root", coordinatorLayout);
                                                                                                        return coordinatorLayout;
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
            }
        }
        i10 = i11;
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final void Q() {
        super.Q();
        this.f3335o0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        boolean z10;
        int i10;
        xa.j.f("view", view);
        e eVar = this.f3335o0;
        xa.j.c(eVar);
        MainActivity mainActivity = (MainActivity) d0();
        Account account = Account.Companion.get(mainActivity);
        if (mainActivity.getResources().getConfiguration().orientation == 2) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (z10) {
            eVar.f17616a.d(false, false, true);
        }
        if (s0().f3345k.d() == null) {
            eVar.f17636u.setOnClickListener(new b(mainActivity, 0, this));
        }
        String str = r0().f7682c;
        ConstraintLayout constraintLayout = eVar.f17632q;
        TextView textView = eVar.f17633r;
        if (str != null) {
            xa.j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            xa.j.e("userName", textView);
            textView.setVisibility(0);
            textView.setText(str);
        } else {
            xa.j.e("userName", textView);
            h0.J0(textView);
        }
        String str2 = r0().f7683d;
        ImageView imageView = eVar.f17631p;
        if (str2 != null) {
            xa.j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            xa.j.e("userImage", imageView);
            imageView.setVisibility(0);
            h0.c1(imageView, this, str2, false, true, (u) null, 20);
        } else {
            xa.j.e("userImage", imageView);
            h0.J0(imageView);
        }
        g6.a.f6840a.getClass();
        Drawable a10 = g6.a.a(mainActivity);
        Toolbar toolbar = eVar.f17627l;
        toolbar.setNavigationIcon(a10);
        toolbar.setNavigationOnClickListener(new c(mainActivity, 0));
        String string = h0.l1(f0()).getString("ui_follow_button", "0");
        if (string != null) {
            i10 = Integer.parseInt(string);
        } else {
            i10 = 0;
        }
        if ((i10 == 0 && account.getId() != r0().f7680a) || !xa.j.a(account.getLogin(), r0().f7681b) || i10 == 1) {
            ImageButton imageButton = eVar.f17619d;
            xa.j.e("followButton", imageButton);
            imageButton.setVisibility(0);
            s0().f3343i.f(C(), new v1(2, new m2(new xa.q(), this, eVar, 3)));
        }
        eVar.f17624i.setOnClickListener(new i(3, this));
        eVar.f17622g.setOnClickListener(new d(mainActivity, account, this, 0));
        e eVar2 = this.f3335o0;
        xa.j.c(eVar2);
        android.support.v4.media.session.u uVar = eVar2.f17623h;
        ((List) ((ViewPager2) uVar.f430k).f2315j.f2296b).add(new k(this));
        ((ViewPager2) uVar.f430k).setAdapter(new h6.a(this, r0()));
        ((ViewPager2) uVar.f430k).setOffscreenPageLimit(3);
        ViewPager2 viewPager2 = (ViewPager2) uVar.f430k;
        xa.j.e("viewPager", viewPager2);
        h0.s1(viewPager2);
        new x8.n((TabLayout) uVar.f429j, (ViewPager2) uVar.f430k, new p0.c(24, this)).a();
    }

    public final void m0() {
        int i10;
        ChannelPagerViewModel s02 = s0();
        if (!s02.f3345k.e()) {
            h0.b1(h0.I0(s02), (pa.h) null, 0, new w(s02, (pa.e) null), 3);
        }
        s0().f3345k.f(C(), new v1(2, new h6.i(this, 0)));
        s0().f3346l.f(C(), new v1(2, new h6.i(this, 1)));
        Account account = Account.Companion.get((MainActivity) d0());
        String string = h0.l1(f0()).getString("ui_follow_button", "0");
        if (string != null) {
            i10 = Integer.parseInt(string);
        } else {
            i10 = 0;
        }
        if ((i10 == 0 && account.getId() != r0().f7680a) || !xa.j.a(account.getLogin(), r0().f7681b) || i10 == 1) {
            ChannelPagerViewModel s03 = s0();
            f0();
            int i11 = r0().f7680a;
            String str = r0().f7681b;
            if (!s03.f3343i.e()) {
                h0.b1(h0.I0(s03), (pa.h) null, 0, new h6.v(i11, s03, (pa.e) null), 3);
            }
        }
    }

    public final void n() {
        l6.c0 c0Var;
        e eVar = this.f3335o0;
        xa.j.c(eVar);
        eVar.f17616a.d(true, true, true);
        c1 u10 = u();
        e eVar2 = this.f3335o0;
        xa.j.c(eVar2);
        int currentItem = ((ViewPager2) eVar2.f17623h.f430k).getCurrentItem();
        androidx.fragment.app.c0 E = u10.E("f" + currentItem);
        if (E instanceof l6.c0) {
            c0Var = (l6.c0) E;
        } else {
            c0Var = null;
        }
        if (c0Var != null) {
            c0Var.n();
        }
    }

    public final void o0() {
        User user;
        ChannelPagerViewModel s02 = s0();
        o0 o0Var = s02.f3345k;
        if (o0Var.d() != null) {
            Stream stream = (Stream) o0Var.d();
            if (stream != null) {
                user = stream.getUser();
            } else {
                user = null;
            }
            if (user == null) {
                o0 o0Var2 = s02.f3346l;
                if (o0Var2.d() == null && !o0Var2.e()) {
                    h0.b1(h0.I0(s02), (pa.h) null, 0, new x(s02, (pa.e) null), 3);
                }
            }
        } else if (!o0Var.e()) {
            h0.b1(h0.I0(s02), (pa.h) null, 0, new w(s02, (pa.e) null), 3);
        }
    }

    public final void onConfigurationChanged(Configuration configuration) {
        xa.j.f("newConfig", configuration);
        this.K = true;
        if (configuration.orientation == 2) {
            e eVar = this.f3335o0;
            xa.j.c(eVar);
            eVar.f17616a.d(false, false, true);
        }
    }

    public final q r0() {
        return (q) this.f3336p0.getValue();
    }

    public final ChannelPagerViewModel s0() {
        return (ChannelPagerViewModel) this.f3337q0.getValue();
    }
}
