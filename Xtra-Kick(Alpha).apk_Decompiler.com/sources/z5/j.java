package z5;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Paint;
import android.support.v4.media.session.u;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.j3;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.datepicker.n;
import com.woxthebox.draglistview.R;
import l.h;
import q8.c;
import q8.d;
import v7.a;

public final class j {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f17675a = 2;

    /* renamed from: b  reason: collision with root package name */
    public final Object f17676b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f17677c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f17678d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f17679e;

    /* renamed from: f  reason: collision with root package name */
    public final Object f17680f;

    /* renamed from: g  reason: collision with root package name */
    public final Object f17681g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f17682h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f17683i;

    public j(Context context) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(c.c(R.attr.materialCalendarStyle, context, n.class.getCanonicalName()).data, a.f15949r);
        this.f17676b = b0.b(context, obtainStyledAttributes.getResourceId(3, 0));
        this.f17683i = b0.b(context, obtainStyledAttributes.getResourceId(1, 0));
        this.f17678d = b0.b(context, obtainStyledAttributes.getResourceId(2, 0));
        this.f17677c = b0.b(context, obtainStyledAttributes.getResourceId(4, 0));
        ColorStateList a10 = d.a(context, obtainStyledAttributes, 6);
        this.f17679e = b0.b(context, obtainStyledAttributes.getResourceId(8, 0));
        this.f17680f = b0.b(context, obtainStyledAttributes.getResourceId(7, 0));
        this.f17682h = b0.b(context, obtainStyledAttributes.getResourceId(9, 0));
        Paint paint = new Paint();
        this.f17681g = paint;
        paint.setColor(a10.getDefaultColor());
        obtainStyledAttributes.recycle();
    }

    public static j b(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.fragment_media_pager_toolbar, viewGroup, false);
        int i10 = R.id.appBar;
        AppBarLayout appBarLayout = (AppBarLayout) e4.a.a(inflate, R.id.appBar);
        if (appBarLayout != null) {
            CoordinatorLayout coordinatorLayout = (CoordinatorLayout) inflate;
            i10 = R.id.followButton;
            ImageButton imageButton = (ImageButton) e4.a.a(inflate, R.id.followButton);
            if (imageButton != null) {
                i10 = R.id.menu;
                ImageView imageView = (ImageView) e4.a.a(inflate, R.id.menu);
                if (imageView != null) {
                    i10 = R.id.pagerLayout;
                    View a10 = e4.a.a(inflate, R.id.pagerLayout);
                    if (a10 != null) {
                        u l10 = u.l(a10);
                        i10 = R.id.search;
                        ImageView imageView2 = (ImageView) e4.a.a(inflate, R.id.search);
                        if (imageView2 != null) {
                            i10 = R.id.toolbar;
                            Toolbar toolbar = (Toolbar) e4.a.a(inflate, R.id.toolbar);
                            if (toolbar != null) {
                                return new j(coordinatorLayout, appBarLayout, coordinatorLayout, imageButton, imageView, l10, imageView2, toolbar);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i10)));
    }

    public final CoordinatorLayout a() {
        int i10 = this.f17675a;
        Object obj = this.f17676b;
        switch (i10) {
            case 0:
                return (CoordinatorLayout) obj;
            default:
                return (CoordinatorLayout) obj;
        }
    }

    public j(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout2, ImageButton imageButton, ImageView imageView, u uVar, ImageView imageView2, Toolbar toolbar) {
        this.f17676b = coordinatorLayout;
        this.f17677c = appBarLayout;
        this.f17678d = coordinatorLayout2;
        this.f17682h = imageButton;
        this.f17679e = imageView;
        this.f17683i = uVar;
        this.f17680f = imageView2;
        this.f17681g = toolbar;
    }

    public j(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, CoordinatorLayout coordinatorLayout2, ImageView imageView, j3 j3Var, ImageView imageView2, h hVar, Toolbar toolbar) {
        this.f17676b = coordinatorLayout;
        this.f17677c = appBarLayout;
        this.f17678d = coordinatorLayout2;
        this.f17679e = imageView;
        this.f17682h = j3Var;
        this.f17680f = imageView2;
        this.f17683i = hVar;
        this.f17681g = toolbar;
    }
}
