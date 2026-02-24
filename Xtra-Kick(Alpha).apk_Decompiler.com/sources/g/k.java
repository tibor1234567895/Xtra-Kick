package g;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.v4.media.session.w;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import com.woxthebox.draglistview.R;
import f.a;

public final class k {
    public TextView A;
    public TextView B;
    public View C;
    public ListAdapter D;
    public int E = -1;
    public final int F;
    public final int G;
    public final int H;
    public final int I;
    public final int J;
    public final boolean K;
    public final w L;
    public final c M = new c(0, this);

    /* renamed from: a  reason: collision with root package name */
    public final Context f6121a;

    /* renamed from: b  reason: collision with root package name */
    public final m0 f6122b;

    /* renamed from: c  reason: collision with root package name */
    public final Window f6123c;

    /* renamed from: d  reason: collision with root package name */
    public final int f6124d;

    /* renamed from: e  reason: collision with root package name */
    public CharSequence f6125e;

    /* renamed from: f  reason: collision with root package name */
    public CharSequence f6126f;

    /* renamed from: g  reason: collision with root package name */
    public AlertController$RecycleListView f6127g;

    /* renamed from: h  reason: collision with root package name */
    public View f6128h;

    /* renamed from: i  reason: collision with root package name */
    public int f6129i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f6130j = false;

    /* renamed from: k  reason: collision with root package name */
    public Button f6131k;

    /* renamed from: l  reason: collision with root package name */
    public CharSequence f6132l;

    /* renamed from: m  reason: collision with root package name */
    public Message f6133m;

    /* renamed from: n  reason: collision with root package name */
    public Drawable f6134n;

    /* renamed from: o  reason: collision with root package name */
    public Button f6135o;

    /* renamed from: p  reason: collision with root package name */
    public CharSequence f6136p;

    /* renamed from: q  reason: collision with root package name */
    public Message f6137q;

    /* renamed from: r  reason: collision with root package name */
    public Drawable f6138r;

    /* renamed from: s  reason: collision with root package name */
    public Button f6139s;

    /* renamed from: t  reason: collision with root package name */
    public CharSequence f6140t;

    /* renamed from: u  reason: collision with root package name */
    public Message f6141u;

    /* renamed from: v  reason: collision with root package name */
    public Drawable f6142v;

    /* renamed from: w  reason: collision with root package name */
    public NestedScrollView f6143w;

    /* renamed from: x  reason: collision with root package name */
    public int f6144x = 0;

    /* renamed from: y  reason: collision with root package name */
    public Drawable f6145y;

    /* renamed from: z  reason: collision with root package name */
    public ImageView f6146z;

    public k(Context context, m0 m0Var, Window window) {
        this.f6121a = context;
        this.f6122b = m0Var;
        this.f6123c = window;
        this.L = new w(m0Var);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, a.f5396f, R.attr.alertDialogStyle, 0);
        this.F = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.getResourceId(2, 0);
        this.G = obtainStyledAttributes.getResourceId(4, 0);
        this.H = obtainStyledAttributes.getResourceId(5, 0);
        this.I = obtainStyledAttributes.getResourceId(7, 0);
        this.J = obtainStyledAttributes.getResourceId(3, 0);
        this.K = obtainStyledAttributes.getBoolean(6, true);
        this.f6124d = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        obtainStyledAttributes.recycle();
        m0Var.e().v(1);
    }

    public static boolean a(View view) {
        if (view.onCheckIsTextEditor()) {
            return true;
        }
        if (!(view instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        while (childCount > 0) {
            childCount--;
            if (a(viewGroup.getChildAt(childCount))) {
                return true;
            }
        }
        return false;
    }

    public static void b(View view, View view2, View view3) {
        int i10 = 0;
        if (view2 != null) {
            view2.setVisibility(view.canScrollVertically(-1) ? 0 : 4);
        }
        if (view3 != null) {
            if (!view.canScrollVertically(1)) {
                i10 = 4;
            }
            view3.setVisibility(i10);
        }
    }

    public static ViewGroup c(View view, View view2) {
        if (view == null) {
            if (view2 instanceof ViewStub) {
                view2 = ((ViewStub) view2).inflate();
            }
            return (ViewGroup) view2;
        }
        if (view2 != null) {
            ViewParent parent = view2.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(view2);
            }
        }
        if (view instanceof ViewStub) {
            view = ((ViewStub) view).inflate();
        }
        return (ViewGroup) view;
    }

    public final void d(int i10, CharSequence charSequence, DialogInterface.OnClickListener onClickListener) {
        Message obtainMessage = onClickListener != null ? this.L.obtainMessage(i10, onClickListener) : null;
        if (i10 == -3) {
            this.f6140t = charSequence;
            this.f6141u = obtainMessage;
            this.f6142v = null;
        } else if (i10 == -2) {
            this.f6136p = charSequence;
            this.f6137q = obtainMessage;
            this.f6138r = null;
        } else if (i10 == -1) {
            this.f6132l = charSequence;
            this.f6133m = obtainMessage;
            this.f6134n = null;
        } else {
            throw new IllegalArgumentException("Button does not exist");
        }
    }
}
