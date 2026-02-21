package z5;

import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import com.github.andreyasadchy.xtra.ui.view.StrictEditText;
import com.github.andreyasadchy.xtra.util.TextWithCanvas;
import com.google.android.flexbox.FlexboxLayout;
import com.woxthebox.draglistview.R;
import e4.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f17595a;

    /* renamed from: b  reason: collision with root package name */
    public final ProgressBar f17596b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f17597c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f17598d;

    /* renamed from: e  reason: collision with root package name */
    public final FrameLayout f17599e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f17600f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f17601g;

    /* renamed from: h  reason: collision with root package name */
    public final View f17602h;

    /* renamed from: i  reason: collision with root package name */
    public final View f17603i;

    /* renamed from: j  reason: collision with root package name */
    public final View f17604j;

    /* renamed from: k  reason: collision with root package name */
    public final ViewGroup f17605k;

    /* renamed from: l  reason: collision with root package name */
    public final Object f17606l;

    /* renamed from: m  reason: collision with root package name */
    public final View f17607m;

    /* renamed from: n  reason: collision with root package name */
    public final TextView f17608n;

    public c(CardView cardView, TextWithCanvas textWithCanvas, TextWithCanvas textWithCanvas2, TextView textView, ImageButton imageButton, ProgressBar progressBar, FlexboxLayout flexboxLayout, ImageView imageView, TextView textView2, ConstraintLayout constraintLayout, TextWithCanvas textWithCanvas3, ImageView imageView2, TextView textView3, TextWithCanvas textWithCanvas4) {
        this.f17599e = cardView;
        this.f17600f = textWithCanvas;
        this.f17601g = textWithCanvas2;
        this.f17595a = textView;
        this.f17602h = imageButton;
        this.f17596b = progressBar;
        this.f17603i = flexboxLayout;
        this.f17604j = imageView;
        this.f17597c = textView2;
        this.f17605k = constraintLayout;
        this.f17606l = textWithCanvas3;
        this.f17607m = imageView2;
        this.f17598d = textView3;
        this.f17608n = textWithCanvas4;
    }

    public static c a(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_videos_list_item, viewGroup, false);
        int i10 = R.id.date;
        TextWithCanvas textWithCanvas = (TextWithCanvas) a.a(inflate, R.id.date);
        if (textWithCanvas != null) {
            i10 = R.id.duration;
            TextWithCanvas textWithCanvas2 = (TextWithCanvas) a.a(inflate, R.id.duration);
            if (textWithCanvas2 != null) {
                i10 = R.id.gameName;
                TextView textView = (TextView) a.a(inflate, R.id.gameName);
                if (textView != null) {
                    i10 = R.id.options;
                    ImageButton imageButton = (ImageButton) a.a(inflate, R.id.options);
                    if (imageButton != null) {
                        i10 = R.id.progressBar;
                        ProgressBar progressBar = (ProgressBar) a.a(inflate, R.id.progressBar);
                        if (progressBar != null) {
                            i10 = R.id.tagsLayout;
                            FlexboxLayout flexboxLayout = (FlexboxLayout) a.a(inflate, R.id.tagsLayout);
                            if (flexboxLayout != null) {
                                i10 = R.id.thumbnail;
                                ImageView imageView = (ImageView) a.a(inflate, R.id.thumbnail);
                                if (imageView != null) {
                                    i10 = R.id.title;
                                    TextView textView2 = (TextView) a.a(inflate, R.id.title);
                                    if (textView2 != null) {
                                        i10 = R.id.topLayout;
                                        ConstraintLayout constraintLayout = (ConstraintLayout) a.a(inflate, R.id.topLayout);
                                        if (constraintLayout != null) {
                                            i10 = R.id.type;
                                            TextWithCanvas textWithCanvas3 = (TextWithCanvas) a.a(inflate, R.id.type);
                                            if (textWithCanvas3 != null) {
                                                i10 = R.id.userImage;
                                                ImageView imageView2 = (ImageView) a.a(inflate, R.id.userImage);
                                                if (imageView2 != null) {
                                                    i10 = R.id.username;
                                                    TextView textView3 = (TextView) a.a(inflate, R.id.username);
                                                    if (textView3 != null) {
                                                        i10 = R.id.views;
                                                        TextWithCanvas textWithCanvas4 = (TextWithCanvas) a.a(inflate, R.id.views);
                                                        if (textWithCanvas4 != null) {
                                                            return new c((CardView) inflate, textWithCanvas, textWithCanvas2, textView, imageButton, progressBar, flexboxLayout, imageView, textView2, constraintLayout, textWithCanvas3, imageView2, textView3, textWithCanvas4);
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

    public c(NestedScrollView nestedScrollView, Button button, Button button2, TextView textView, TextView textView2, Guideline guideline, ProgressBar progressBar, TextView textView3, TextView textView4, Spinner spinner, u uVar, StrictEditText strictEditText, StrictEditText strictEditText2, TextView textView5) {
        this.f17599e = nestedScrollView;
        this.f17600f = button;
        this.f17601g = button2;
        this.f17595a = textView;
        this.f17597c = textView2;
        this.f17604j = guideline;
        this.f17596b = progressBar;
        this.f17598d = textView3;
        this.f17602h = textView4;
        this.f17605k = spinner;
        this.f17606l = uVar;
        this.f17607m = strictEditText;
        this.f17608n = strictEditText2;
        this.f17603i = textView5;
    }
}
