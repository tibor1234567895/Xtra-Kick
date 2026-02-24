package androidx.appcompat.widget;

import android.support.v4.media.h;
import android.view.View;
import android.widget.AdapterView;
import android.widget.PopupWindow;
import java.util.ArrayList;
import m0.d;

public final class y implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnLongClickListener, PopupWindow.OnDismissListener {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ z f1129h;

    public y(z zVar) {
        this.f1129h = zVar;
    }

    public final void onClick(View view) {
        z zVar = this.f1129h;
        if (view == zVar.f1142n) {
            zVar.a();
            this.f1129h.f1136h.f1121h.f();
            u uVar = this.f1129h.f1136h.f1121h;
            synchronized (uVar.f1087a) {
                uVar.b();
                ArrayList arrayList = uVar.f1088b;
                if (arrayList.size() > 0) {
                    h.y(arrayList.get(0));
                    throw null;
                }
            }
            this.f1129h.f1136h.f1121h.a();
        } else if (view == zVar.f1140l) {
            zVar.f1149u = false;
            zVar.c(zVar.f1150v);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final void onDismiss() {
        z zVar = this.f1129h;
        PopupWindow.OnDismissListener onDismissListener = zVar.f1148t;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
        d dVar = zVar.f1144p;
        if (dVar != null) {
            dVar.i(false);
        }
    }

    public final void onItemClick(AdapterView adapterView, View view, int i10, long j10) {
        int itemViewType = ((x) adapterView.getAdapter()).getItemViewType(i10);
        if (itemViewType == 0) {
            this.f1129h.a();
            z zVar = this.f1129h;
            if (!zVar.f1149u) {
                x xVar = zVar.f1136h;
                boolean z10 = xVar.f1123j;
                xVar.f1121h.a();
            } else if (i10 > 0) {
                u uVar = zVar.f1136h.f1121h;
                synchronized (uVar.f1087a) {
                    uVar.b();
                    h.y(uVar.f1088b.get(i10));
                    h.y(uVar.f1088b.get(0));
                    throw null;
                }
            }
        } else if (itemViewType == 1) {
            this.f1129h.c(Integer.MAX_VALUE);
        } else {
            throw new IllegalArgumentException();
        }
    }

    public final boolean onLongClick(View view) {
        z zVar = this.f1129h;
        if (view == zVar.f1142n) {
            if (zVar.f1136h.getCount() > 0) {
                zVar.f1149u = true;
                zVar.c(zVar.f1150v);
            }
            return true;
        }
        throw new IllegalArgumentException();
    }
}
