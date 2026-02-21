package r0;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.media.h;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import androidx.appcompat.widget.m4;
import androidx.appcompat.widget.y2;

public abstract class b extends BaseAdapter implements Filterable, c {

    /* renamed from: h  reason: collision with root package name */
    public boolean f13521h = false;

    /* renamed from: i  reason: collision with root package name */
    public boolean f13522i = true;

    /* renamed from: j  reason: collision with root package name */
    public Cursor f13523j = null;

    /* renamed from: k  reason: collision with root package name */
    public int f13524k = -1;

    /* renamed from: l  reason: collision with root package name */
    public a f13525l = new a(this);

    /* renamed from: m  reason: collision with root package name */
    public y2 f13526m = new y2(1, this);

    /* renamed from: n  reason: collision with root package name */
    public d f13527n;

    public b(Context context) {
    }

    public abstract void a(View view, Cursor cursor);

    public void b(Cursor cursor) {
        Cursor cursor2 = this.f13523j;
        if (cursor == cursor2) {
            cursor2 = null;
        } else {
            if (cursor2 != null) {
                a aVar = this.f13525l;
                if (aVar != null) {
                    cursor2.unregisterContentObserver(aVar);
                }
                y2 y2Var = this.f13526m;
                if (y2Var != null) {
                    cursor2.unregisterDataSetObserver(y2Var);
                }
            }
            this.f13523j = cursor;
            if (cursor != null) {
                a aVar2 = this.f13525l;
                if (aVar2 != null) {
                    cursor.registerContentObserver(aVar2);
                }
                y2 y2Var2 = this.f13526m;
                if (y2Var2 != null) {
                    cursor.registerDataSetObserver(y2Var2);
                }
                this.f13524k = cursor.getColumnIndexOrThrow("_id");
                this.f13521h = true;
                notifyDataSetChanged();
            } else {
                this.f13524k = -1;
                this.f13521h = false;
                notifyDataSetInvalidated();
            }
        }
        if (cursor2 != null) {
            cursor2.close();
        }
    }

    public abstract String c(Cursor cursor);

    public abstract View d(ViewGroup viewGroup);

    public final int getCount() {
        Cursor cursor;
        if (!this.f13521h || (cursor = this.f13523j) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    public View getDropDownView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f13521h) {
            return null;
        }
        this.f13523j.moveToPosition(i10);
        if (view == null) {
            m4 m4Var = (m4) this;
            view = m4Var.f934q.inflate(m4Var.f933p, viewGroup, false);
        }
        a(view, this.f13523j);
        return view;
    }

    public final Filter getFilter() {
        if (this.f13527n == null) {
            this.f13527n = new d(this);
        }
        return this.f13527n;
    }

    public final Object getItem(int i10) {
        Cursor cursor;
        if (!this.f13521h || (cursor = this.f13523j) == null) {
            return null;
        }
        cursor.moveToPosition(i10);
        return this.f13523j;
    }

    public final long getItemId(int i10) {
        Cursor cursor;
        if (!this.f13521h || (cursor = this.f13523j) == null || !cursor.moveToPosition(i10)) {
            return 0;
        }
        return this.f13523j.getLong(this.f13524k);
    }

    public View getView(int i10, View view, ViewGroup viewGroup) {
        if (!this.f13521h) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        } else if (this.f13523j.moveToPosition(i10)) {
            if (view == null) {
                view = d(viewGroup);
            }
            a(view, this.f13523j);
            return view;
        } else {
            throw new IllegalStateException(h.i("couldn't move cursor to position ", i10));
        }
    }
}
