package androidx.appcompat.widget;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.woxthebox.draglistview.R;

public final class x extends BaseAdapter {

    /* renamed from: h  reason: collision with root package name */
    public u f1121h;

    /* renamed from: i  reason: collision with root package name */
    public int f1122i = 4;

    /* renamed from: j  reason: collision with root package name */
    public boolean f1123j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f1124k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f1125l;

    /* renamed from: m  reason: collision with root package name */
    public final /* synthetic */ z f1126m;

    public x(z zVar) {
        this.f1126m = zVar;
    }

    public final void a(int i10) {
        if (this.f1122i != i10) {
            this.f1122i = i10;
            notifyDataSetChanged();
        }
    }

    public final int getCount() {
        int e10 = this.f1121h.e();
        if (!this.f1123j) {
            this.f1121h.f();
        }
        int min = Math.min(e10, this.f1122i);
        return this.f1125l ? min + 1 : min;
    }

    public final Object getItem(int i10) {
        int itemViewType = getItemViewType(i10);
        if (itemViewType == 0) {
            if (!this.f1123j) {
                this.f1121h.f();
            }
            this.f1121h.d(i10);
            throw null;
        } else if (itemViewType == 1) {
            return null;
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final long getItemId(int i10) {
        return (long) i10;
    }

    public final int getItemViewType(int i10) {
        return (!this.f1125l || i10 != getCount() - 1) ? 0 : 1;
    }

    public final View getView(int i10, View view, ViewGroup viewGroup) {
        int itemViewType = getItemViewType(i10);
        z zVar = this.f1126m;
        if (itemViewType == 0) {
            if (view == null || view.getId() != R.id.list_item) {
                view = LayoutInflater.from(zVar.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            }
            zVar.getContext().getPackageManager();
            ImageView imageView = (ImageView) view.findViewById(R.id.icon);
            getItem(i10);
            throw null;
        } else if (itemViewType != 1) {
            throw new IllegalArgumentException();
        } else if (view != null && view.getId() == 1) {
            return view;
        } else {
            View inflate = LayoutInflater.from(zVar.getContext()).inflate(R.layout.abc_activity_chooser_view_list_item, viewGroup, false);
            inflate.setId(1);
            ((TextView) inflate.findViewById(R.id.title)).setText(zVar.getContext().getString(R.string.abc_activity_chooser_view_see_all));
            return inflate;
        }
    }

    public final int getViewTypeCount() {
        return 3;
    }
}
