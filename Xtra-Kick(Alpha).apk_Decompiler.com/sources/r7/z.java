package r7;

import android.content.ClipboardManager;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.c0;
import androidx.lifecycle.o0;
import androidx.lifecycle.v1;
import androidx.lifecycle.x1;
import com.github.andreyasadchy.xtra.model.ui.User;
import com.github.andreyasadchy.xtra.ui.view.chat.MessageClickedViewModel;
import com.woxthebox.draglistview.R;
import d5.u;
import g7.g;
import h6.d;
import h6.m;
import h6.n;
import h6.o;
import hb.h0;
import java.util.ArrayList;
import java.util.Iterator;
import la.e;
import la.f;
import la.i;
import pa.h;
import pb.l0;
import xa.j;
import xa.v;
import z5.a;

public final class z extends t {
    public static final w D0 = new w(0);
    public static final ArrayList E0 = new ArrayList();
    public a A0;
    public final x1 B0;
    public x C0;

    public z() {
        e a10 = f.a(new l0(new g(8, this), 1));
        this.B0 = h0.K(this, v.a(MessageClickedViewModel.class), new m(a10, 29), new n(a10, 29), new o(this, a10, 29));
    }

    public final void M(Context context) {
        j.f("context", context);
        super.M(context);
        c0 c0Var = this.C;
        j.d("null cannot be cast to non-null type com.github.andreyasadchy.xtra.ui.view.chat.MessageClickedDialog.OnButtonClickListener", c0Var);
        this.C0 = (x) c0Var;
    }

    public final View O(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        LayoutInflater layoutInflater2 = layoutInflater;
        j.f("inflater", layoutInflater2);
        View inflate = layoutInflater2.inflate(R.layout.dialog_chat_message_click, viewGroup, false);
        int i10 = R.id.bannerImage;
        ImageView imageView = (ImageView) e4.a.a(inflate, R.id.bannerImage);
        if (imageView != null) {
            i10 = R.id.copyClip;
            Button button = (Button) e4.a.a(inflate, R.id.copyClip);
            if (button != null) {
                i10 = R.id.copyFullMsg;
                Button button2 = (Button) e4.a.a(inflate, R.id.copyFullMsg);
                if (button2 != null) {
                    i10 = R.id.copyMessage;
                    Button button3 = (Button) e4.a.a(inflate, R.id.copyMessage);
                    if (button3 != null) {
                        i10 = R.id.message;
                        TextView textView = (TextView) e4.a.a(inflate, R.id.message);
                        if (textView != null) {
                            i10 = R.id.reply;
                            Button button4 = (Button) e4.a.a(inflate, R.id.reply);
                            if (button4 != null) {
                                i10 = R.id.userCreated;
                                TextView textView2 = (TextView) e4.a.a(inflate, R.id.userCreated);
                                if (textView2 != null) {
                                    i10 = R.id.userFollowed;
                                    TextView textView3 = (TextView) e4.a.a(inflate, R.id.userFollowed);
                                    if (textView3 != null) {
                                        i10 = R.id.userImage;
                                        ImageView imageView2 = (ImageView) e4.a.a(inflate, R.id.userImage);
                                        if (imageView2 != null) {
                                            i10 = R.id.userLayout;
                                            ConstraintLayout constraintLayout = (ConstraintLayout) e4.a.a(inflate, R.id.userLayout);
                                            if (constraintLayout != null) {
                                                i10 = R.id.userName;
                                                TextView textView4 = (TextView) e4.a.a(inflate, R.id.userName);
                                                if (textView4 != null) {
                                                    i10 = R.id.viewProfile;
                                                    Button button5 = (Button) e4.a.a(inflate, R.id.viewProfile);
                                                    if (button5 != null) {
                                                        NestedScrollView nestedScrollView = (NestedScrollView) inflate;
                                                        this.A0 = new a(nestedScrollView, imageView, button, button2, button3, textView, button4, textView2, textView3, imageView2, constraintLayout, textView4, button5);
                                                        j.e("binding.root", nestedScrollView);
                                                        return nestedScrollView;
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

    public final void Q() {
        super.Q();
        this.A0 = null;
    }

    public final void Z(View view, Bundle bundle) {
        Object obj;
        int i10;
        boolean z10;
        j.f("view", view);
        a aVar = this.A0;
        j.c(aVar);
        Bundle e02 = e0();
        CharSequence charSequence = e02.getCharSequence("formatted");
        j.c(charSequence);
        aVar.f17583e.setText(charSequence);
        CharSequence charSequence2 = e02.getCharSequence("original");
        j.c(charSequence2);
        int i11 = e02.getInt("userid");
        int i12 = e02.getInt("channelId");
        String string = e02.getString("full");
        ClipboardManager clipboardManager = (ClipboardManager) c0.g.d(f0(), ClipboardManager.class);
        if (i11 != 0) {
            Iterator it = E0.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                i iVar = (i) obj;
                if (((User) iVar.f9799h).getChannelId() == i11 && ((Number) iVar.f9800i).intValue() == i12) {
                    z10 = true;
                    continue;
                } else {
                    z10 = false;
                    continue;
                }
                if (z10) {
                    break;
                }
            }
            i iVar2 = (i) obj;
            if (iVar2 != null) {
                s0((User) iVar2.f9799h);
            } else {
                MessageClickedViewModel messageClickedViewModel = (MessageClickedViewModel) this.B0.getValue();
                if (i11 != i12) {
                    i10 = i12;
                } else {
                    i10 = 0;
                }
                Integer valueOf = Integer.valueOf(i10);
                o0 o0Var = messageClickedViewModel.f3555e;
                if (o0Var.d() == null && !messageClickedViewModel.f3556f) {
                    messageClickedViewModel.f3556f = true;
                    h0.b1(h0.I0(messageClickedViewModel), (h) null, 0, new b0(messageClickedViewModel, i11, valueOf, (pa.e) null), 3);
                }
                o0Var.f(C(), new v1(25, new y(i12, this, aVar)));
            }
            boolean z11 = e02.getBoolean("messaging");
            Button button = aVar.f17584f;
            j.e("reply", button);
            Button button2 = aVar.f17582d;
            if (z11) {
                button.setVisibility(0);
                button.setOnClickListener(new u(this, charSequence2, 0));
                j.e("copyMessage", button2);
                button2.setVisibility(0);
                button2.setOnClickListener(new u(this, charSequence2, 1));
            } else {
                h0.J0(button);
                j.e("copyMessage", button2);
                h0.J0(button2);
            }
        }
        aVar.f17580b.setOnClickListener(new h6.f(clipboardManager, i11, charSequence2, this, 1));
        if (h0.l1(f0()).getBoolean("debug_chat_fullmsg", false) && string != null) {
            Button button3 = aVar.f17581c;
            j.e("copyFullMsg", button3);
            button3.setVisibility(0);
            button3.setOnClickListener(new d(clipboardManager, string, this, 23));
        }
    }

    public final void s0(User user) {
        boolean z10;
        boolean z11;
        User user2 = user;
        a aVar = this.A0;
        j.c(aVar);
        String bannerImageURL = user.getBannerImageURL();
        ImageView imageView = aVar.f17579a;
        ConstraintLayout constraintLayout = aVar.f17588j;
        if (bannerImageURL != null) {
            j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            j.e("bannerImage", imageView);
            imageView.setVisibility(0);
            h0.c1(imageView, g0(), user.getBannerImageURL(), false, false, (u) null, 28);
        } else {
            j.e("bannerImage", imageView);
            h0.J0(imageView);
        }
        String channelLogo = user.getChannelLogo();
        ImageView imageView2 = aVar.f17587i;
        if (channelLogo != null) {
            j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            j.e("userImage", imageView2);
            imageView2.setVisibility(0);
            h0.c1(imageView2, g0(), user.getChannelLogo(), false, true, (u) null, 20);
            imageView2.setOnClickListener(new v(this, user2, 0));
        } else {
            j.e("userImage", imageView2);
            h0.J0(imageView2);
        }
        String channelName = user.getChannelName();
        TextView textView = aVar.f17589k;
        if (channelName != null) {
            j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            j.e("userName", textView);
            textView.setVisibility(0);
            textView.setText(user.getChannelName());
            textView.setOnClickListener(new v(this, user2, 1));
            if (user.getBannerImageURL() != null) {
                textView.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            j.e("userName", textView);
            h0.J0(textView);
        }
        String createdAt = user.getCreatedAt();
        TextView textView2 = aVar.f17585g;
        if (createdAt != null) {
            j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            j.e("userCreated", textView2);
            textView2.setVisibility(0);
            Context f02 = f0();
            s7.h hVar = s7.h.f14375a;
            Context f03 = f0();
            String createdAt2 = user.getCreatedAt();
            hVar.getClass();
            textView2.setText(f02.getString(R.string.created_at, new Object[]{s7.h.d(f03, createdAt2)}));
            if (user.getBannerImageURL() != null) {
                textView2.setTextColor(-3355444);
                textView2.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            j.e("userCreated", textView2);
            h0.J0(textView2);
        }
        String followedAt = user.getFollowedAt();
        TextView textView3 = aVar.f17586h;
        if (followedAt != null) {
            j.e("userLayout", constraintLayout);
            constraintLayout.setVisibility(0);
            j.e("userFollowed", textView3);
            textView3.setVisibility(0);
            Context f04 = f0();
            s7.h hVar2 = s7.h.f14375a;
            Context f05 = f0();
            String followedAt2 = user.getFollowedAt();
            j.c(followedAt2);
            hVar2.getClass();
            textView3.setText(f04.getString(R.string.followed_at, new Object[]{s7.h.d(f05, followedAt2)}));
            if (user.getBannerImageURL() != null) {
                textView3.setTextColor(-3355444);
                textView3.setShadowLayer(4.0f, 0.0f, 0.0f, -16777216);
            }
        } else {
            j.e("userFollowed", textView3);
            h0.J0(textView3);
        }
        j.e("userImage", imageView2);
        if (imageView2.getVisibility() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            j.e("userName", textView);
            if (textView.getVisibility() == 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11) {
                Button button = aVar.f17590l;
                j.e("viewProfile", button);
                button.setVisibility(0);
            }
        }
    }
}
