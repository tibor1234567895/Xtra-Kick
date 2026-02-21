package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.widget.HeaderViewListAdapter;
import android.widget.ListAdapter;
import androidx.appcompat.view.menu.ListMenuItemView;
import m.l;
import m.o;
import m.q;

public final class g3 extends o2 {

    /* renamed from: t  reason: collision with root package name */
    public final int f832t;

    /* renamed from: u  reason: collision with root package name */
    public final int f833u;

    /* renamed from: v  reason: collision with root package name */
    public c3 f834v;

    /* renamed from: w  reason: collision with root package name */
    public q f835w;

    public g3(Context context, boolean z10) {
        super(context, z10);
        if (1 == f3.a(context.getResources().getConfiguration())) {
            this.f832t = 21;
            this.f833u = 22;
            return;
        }
        this.f832t = 22;
        this.f833u = 21;
    }

    public final boolean onHoverEvent(MotionEvent motionEvent) {
        int i10;
        l lVar;
        q qVar;
        int pointToPosition;
        int i11;
        if (this.f834v != null) {
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                HeaderViewListAdapter headerViewListAdapter = (HeaderViewListAdapter) adapter;
                i10 = headerViewListAdapter.getHeadersCount();
                lVar = (l) headerViewListAdapter.getWrappedAdapter();
            } else {
                lVar = (l) adapter;
                i10 = 0;
            }
            if (motionEvent.getAction() == 10 || (pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY())) == -1 || (i11 = pointToPosition - i10) < 0 || i11 >= lVar.getCount()) {
                qVar = null;
            } else {
                qVar = lVar.getItem(i11);
            }
            q qVar2 = this.f835w;
            if (qVar2 != qVar) {
                o oVar = lVar.f9965h;
                if (qVar2 != null) {
                    this.f834v.w(oVar, qVar2);
                }
                this.f835w = qVar;
                if (qVar != null) {
                    this.f834v.g(oVar, qVar);
                }
            }
        }
        return super.onHoverEvent(motionEvent);
    }

    public final boolean onKeyDown(int i10, KeyEvent keyEvent) {
        ListMenuItemView listMenuItemView = (ListMenuItemView) getSelectedView();
        if (listMenuItemView != null && i10 == this.f832t) {
            if (listMenuItemView.isEnabled() && listMenuItemView.getItemData().hasSubMenu()) {
                performItemClick(listMenuItemView, getSelectedItemPosition(), getSelectedItemId());
            }
            return true;
        } else if (listMenuItemView == null || i10 != this.f833u) {
            return super.onKeyDown(i10, keyEvent);
        } else {
            setSelection(-1);
            ListAdapter adapter = getAdapter();
            if (adapter instanceof HeaderViewListAdapter) {
                adapter = ((HeaderViewListAdapter) adapter).getWrappedAdapter();
            }
            ((l) adapter).f9965h.c(false);
            return true;
        }
    }

    public void setHoverListener(c3 c3Var) {
        this.f834v = c3Var;
    }

    public /* bridge */ /* synthetic */ void setSelector(Drawable drawable) {
        super.setSelector(drawable);
    }
}
