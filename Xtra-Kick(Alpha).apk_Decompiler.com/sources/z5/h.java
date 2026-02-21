package z5;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.woxthebox.draglistview.R;
import e4.a;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView f17655a;

    /* renamed from: b  reason: collision with root package name */
    public final ViewGroup f17656b;

    /* renamed from: c  reason: collision with root package name */
    public final LinearLayout f17657c;

    /* renamed from: d  reason: collision with root package name */
    public final View f17658d;

    /* renamed from: e  reason: collision with root package name */
    public final View f17659e;

    /* renamed from: f  reason: collision with root package name */
    public final View f17660f;

    /* renamed from: g  reason: collision with root package name */
    public final View f17661g;

    /* renamed from: h  reason: collision with root package name */
    public final View f17662h;

    public h(CardView cardView, LinearLayout linearLayout, TextView textView, TextView textView2, TextView textView3, ImageView imageView, TextView textView4, TextView textView5) {
        this.f17656b = cardView;
        this.f17657c = linearLayout;
        this.f17658d = textView;
        this.f17659e = textView2;
        this.f17660f = textView3;
        this.f17655a = imageView;
        this.f17661g = textView4;
        this.f17662h = textView5;
    }

    public static h a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media, viewGroup, false);
        int i10 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            i10 = R.id.followButton;
            ImageButton imageButton = (ImageButton) a.a(inflate, R.id.followButton);
            if (imageButton != null) {
                i10 = R.id.fragmentContainer;
                FrameLayout frameLayout = (FrameLayout) a.a(inflate, R.id.fragmentContainer);
                if (frameLayout != null) {
                    i10 = R.id.menu;
                    ImageView imageView = (ImageView) a.a(inflate, R.id.menu);
                    if (imageView != null) {
                        i10 = R.id.search;
                        ImageView imageView2 = (ImageView) a.a(inflate, R.id.search);
                        if (imageView2 != null) {
                            i10 = R.id.spinner;
                            Spinner spinner = (Spinner) a.a(inflate, R.id.spinner);
                            if (spinner != null) {
                                i10 = R.id.toolbar;
                                Toolbar toolbar = (Toolbar) a.a(inflate, R.id.toolbar);
                                if (toolbar != null) {
                                    return new h(coordinatorLayout, appBarLayout, imageButton, frameLayout, imageView, imageView2, spinner, toolbar);
                                }
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public h(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, ImageButton imageButton, FrameLayout frameLayout, ImageView imageView, ImageView imageView2, Spinner spinner, Toolbar toolbar) {
        this.f17656b = coordinatorLayout;
        this.f17657c = appBarLayout;
        this.f17658d = imageButton;
        this.f17659e = frameLayout;
        this.f17655a = imageView;
        this.f17660f = imageView2;
        this.f17661g = spinner;
        this.f17662h = toolbar;
    }
}
