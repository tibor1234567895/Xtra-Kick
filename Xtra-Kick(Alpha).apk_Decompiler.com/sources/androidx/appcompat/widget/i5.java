package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.media3.exoplayer.hls.HlsMediaSource$Factory;
import b4.e0;
import c9.w;
import com.google.android.flexbox.FlexboxLayout;
import com.woxthebox.draglistview.R;
import d2.r;
import d5.c0;
import d5.f0;
import e4.a;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import k1.g;
import m1.q;
import v1.l;
import v1.z;

public final class i5 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f873a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f874b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f875c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f876d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f877e;

    /* renamed from: f  reason: collision with root package name */
    public Object f878f;

    /* renamed from: g  reason: collision with root package name */
    public Object f879g;

    /* renamed from: h  reason: collision with root package name */
    public Object f880h;

    public i5(Context context) {
        this.f873a = 0;
        WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
        this.f877e = layoutParams;
        this.f878f = new Rect();
        this.f879g = new int[2];
        this.f880h = new int[2];
        this.f874b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.abc_tooltip, (ViewGroup) null);
        this.f875c = inflate;
        this.f876d = (TextView) inflate.findViewById(R.id.message);
        layoutParams.setTitle(i5.class.getSimpleName());
        layoutParams.packageName = context.getPackageName();
        layoutParams.type = 1002;
        layoutParams.width = -2;
        layoutParams.height = -2;
        layoutParams.format = -3;
        layoutParams.windowAnimations = 2132017157;
        layoutParams.flags = 24;
    }

    public static i5 b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_games_list_item, viewGroup, false);
        int i10 = R.id.broadcastersCount;
        TextView textView = (TextView) a.a(inflate, R.id.broadcastersCount);
        if (textView != null) {
            i10 = R.id.gameImage;
            ImageView imageView = (ImageView) a.a(inflate, R.id.gameImage);
            if (imageView != null) {
                i10 = R.id.gameName;
                TextView textView2 = (TextView) a.a(inflate, R.id.gameName);
                if (textView2 != null) {
                    i10 = R.id.tagsLayout;
                    FlexboxLayout flexboxLayout = (FlexboxLayout) a.a(inflate, R.id.tagsLayout);
                    if (flexboxLayout != null) {
                        i10 = R.id.topLayout;
                        ConstraintLayout constraintLayout = (ConstraintLayout) a.a(inflate, R.id.topLayout);
                        if (constraintLayout != null) {
                            i10 = R.id.viewers;
                            TextView textView3 = (TextView) a.a(inflate, R.id.viewers);
                            if (textView3 != null) {
                                return new i5((CardView) inflate, textView, imageView, textView2, flexboxLayout, constraintLayout, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public static i5 c(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_channels_list_item, viewGroup, false);
        int i10 = R.id.layout1;
        LinearLayout linearLayout = (LinearLayout) a.a(inflate, R.id.layout1);
        if (linearLayout != null) {
            i10 = R.id.layout2;
            LinearLayout linearLayout2 = (LinearLayout) a.a(inflate, R.id.layout2);
            if (linearLayout2 != null) {
                i10 = R.id.typeText;
                TextView textView = (TextView) a.a(inflate, R.id.typeText);
                if (textView != null) {
                    i10 = R.id.userFollowers;
                    TextView textView2 = (TextView) a.a(inflate, R.id.userFollowers);
                    if (textView2 != null) {
                        i10 = R.id.userImage;
                        ImageView imageView = (ImageView) a.a(inflate, R.id.userImage);
                        if (imageView != null) {
                            i10 = R.id.userName;
                            TextView textView3 = (TextView) a.a(inflate, R.id.userName);
                            if (textView3 != null) {
                                return new i5((CardView) inflate, linearLayout, linearLayout2, textView, textView2, imageView, textView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final CardView a() {
        int i10 = this.f873a;
        Object obj = this.f874b;
        switch (i10) {
            case 4:
                return (CardView) obj;
            default:
                return (CardView) obj;
        }
    }

    public final w d(int i10) {
        l lVar;
        w qVar;
        Object obj = this.f875c;
        if (((Map) obj).containsKey(Integer.valueOf(i10))) {
            return (w) ((Map) obj).get(Integer.valueOf(i10));
        }
        g gVar = (g) this.f878f;
        gVar.getClass();
        Class<z> cls = z.class;
        l lVar2 = null;
        if (i10 != 0) {
            if (i10 == 1) {
                lVar = new l(Class.forName("androidx.media3.exoplayer.smoothstreaming.SsMediaSource$Factory").asSubclass(cls), gVar, 1);
            } else if (i10 != 2) {
                if (i10 == 3) {
                    qVar = new q(2, Class.forName("androidx.media3.exoplayer.rtsp.RtspMediaSource$Factory").asSubclass(cls));
                } else if (i10 == 4) {
                    try {
                        qVar = new l(this, gVar, 3);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                lVar2 = qVar;
            } else {
                lVar = new l(HlsMediaSource$Factory.class.asSubclass(cls), gVar, 2);
            }
            lVar2 = lVar;
        } else {
            lVar2 = new l(Class.forName("androidx.media3.exoplayer.dash.DashMediaSource$Factory").asSubclass(cls), gVar, 0);
        }
        ((Map) obj).put(Integer.valueOf(i10), lVar2);
        if (lVar2 != null) {
            ((Set) this.f876d).add(Integer.valueOf(i10));
        }
        return lVar2;
    }

    public /* synthetic */ i5(ViewGroup viewGroup, ViewGroup viewGroup2, ViewGroup viewGroup3, View view, Object obj, ViewGroup viewGroup4, View view2, int i10) {
        this.f873a = i10;
        this.f874b = viewGroup;
        this.f875c = viewGroup2;
        this.f876d = viewGroup3;
        this.f877e = view;
        this.f878f = obj;
        this.f879g = viewGroup4;
        this.f880h = view2;
    }

    public i5(CardView cardView, LinearLayout linearLayout, LinearLayout linearLayout2, TextView textView, TextView textView2, ImageView imageView, TextView textView3) {
        this.f873a = 7;
        this.f874b = cardView;
        this.f875c = linearLayout;
        this.f877e = linearLayout2;
        this.f876d = textView;
        this.f878f = textView2;
        this.f879g = imageView;
        this.f880h = textView3;
    }

    public i5(CardView cardView, TextView textView, ImageView imageView, TextView textView2, FlexboxLayout flexboxLayout, ConstraintLayout constraintLayout, TextView textView3) {
        this.f873a = 4;
        this.f874b = cardView;
        this.f876d = textView;
        this.f875c = imageView;
        this.f877e = textView2;
        this.f878f = flexboxLayout;
        this.f879g = constraintLayout;
        this.f880h = textView3;
    }

    public i5(NestedScrollView nestedScrollView, Button button, Button button2, ProgressBar progressBar, TextView textView, Spinner spinner, u uVar) {
        this.f873a = 3;
        this.f874b = nestedScrollView;
        this.f875c = button;
        this.f877e = button2;
        this.f878f = progressBar;
        this.f876d = textView;
        this.f879g = spinner;
        this.f880h = uVar;
    }

    public i5(r rVar) {
        this.f873a = 1;
        this.f874b = rVar;
        this.f875c = new HashMap();
        this.f876d = new HashSet();
        this.f877e = new HashMap();
    }

    public i5(g5.g gVar, g5.g gVar2, g5.g gVar3, g5.g gVar4, c0 c0Var, f0 f0Var) {
        this.f873a = 2;
        this.f880h = x5.g.a(150, new e0(5, this));
        this.f874b = gVar;
        this.f875c = gVar2;
        this.f876d = gVar3;
        this.f877e = gVar4;
        this.f878f = c0Var;
        this.f879g = f0Var;
    }
}
