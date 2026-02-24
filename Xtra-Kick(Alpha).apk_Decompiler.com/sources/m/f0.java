package m;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.SubMenu;
import g0.a;
import g0.b;
import q.k;

public class f0 extends d implements Menu {

    /* renamed from: d  reason: collision with root package name */
    public final a f9911d;

    public f0(Context context, a aVar) {
        super(context);
        if (aVar != null) {
            this.f9911d = aVar;
            return;
        }
        throw new IllegalArgumentException("Wrapped Object can not be null.");
    }

    public final MenuItem add(int i10) {
        return f(((o) this.f9911d).add(i10));
    }

    public final int addIntentOptions(int i10, int i11, int i12, ComponentName componentName, Intent[] intentArr, Intent intent, int i13, MenuItem[] menuItemArr) {
        MenuItem[] menuItemArr2 = menuItemArr;
        MenuItem[] menuItemArr3 = menuItemArr2 != null ? new MenuItem[menuItemArr2.length] : null;
        int addIntentOptions = ((o) this.f9911d).addIntentOptions(i10, i11, i12, componentName, intentArr, intent, i13, menuItemArr3);
        if (menuItemArr3 != null) {
            int length = menuItemArr3.length;
            for (int i14 = 0; i14 < length; i14++) {
                menuItemArr2[i14] = f(menuItemArr3[i14]);
            }
        }
        return addIntentOptions;
    }

    public final SubMenu addSubMenu(int i10) {
        return ((o) this.f9911d).addSubMenu(i10);
    }

    public final void clear() {
        k kVar = (k) this.f9905b;
        if (kVar != null) {
            kVar.clear();
        }
        k kVar2 = (k) this.f9906c;
        if (kVar2 != null) {
            kVar2.clear();
        }
        ((o) this.f9911d).clear();
    }

    public final void close() {
        ((o) this.f9911d).c(true);
    }

    public final MenuItem findItem(int i10) {
        return f(((o) this.f9911d).findItem(i10));
    }

    public final MenuItem getItem(int i10) {
        return f(((o) this.f9911d).getItem(i10));
    }

    public final boolean hasVisibleItems() {
        return ((o) this.f9911d).hasVisibleItems();
    }

    public final boolean isShortcutKey(int i10, KeyEvent keyEvent) {
        return ((o) this.f9911d).isShortcutKey(i10, keyEvent);
    }

    public final boolean performIdentifierAction(int i10, int i11) {
        return ((o) this.f9911d).performIdentifierAction(i10, i11);
    }

    public final boolean performShortcut(int i10, KeyEvent keyEvent, int i11) {
        return ((o) this.f9911d).performShortcut(i10, keyEvent, i11);
    }

    public final void removeGroup(int i10) {
        if (((k) this.f9905b) != null) {
            int i11 = 0;
            while (true) {
                k kVar = (k) this.f9905b;
                if (i11 >= kVar.f13081j) {
                    break;
                }
                if (((b) kVar.h(i11)).getGroupId() == i10) {
                    ((k) this.f9905b).j(i11);
                    i11--;
                }
                i11++;
            }
        }
        ((o) this.f9911d).removeGroup(i10);
    }

    public final void removeItem(int i10) {
        if (((k) this.f9905b) != null) {
            int i11 = 0;
            while (true) {
                k kVar = (k) this.f9905b;
                if (i11 >= kVar.f13081j) {
                    break;
                } else if (((b) kVar.h(i11)).getItemId() == i10) {
                    ((k) this.f9905b).j(i11);
                    break;
                } else {
                    i11++;
                }
            }
        }
        ((o) this.f9911d).removeItem(i10);
    }

    public final void setGroupCheckable(int i10, boolean z10, boolean z11) {
        ((o) this.f9911d).setGroupCheckable(i10, z10, z11);
    }

    public final void setGroupEnabled(int i10, boolean z10) {
        ((o) this.f9911d).setGroupEnabled(i10, z10);
    }

    public final void setGroupVisible(int i10, boolean z10) {
        ((o) this.f9911d).setGroupVisible(i10, z10);
    }

    public final void setQwertyMode(boolean z10) {
        this.f9911d.setQwertyMode(z10);
    }

    public final int size() {
        return ((o) this.f9911d).size();
    }

    public final MenuItem add(int i10, int i11, int i12, int i13) {
        return f(((o) this.f9911d).add(i10, i11, i12, i13));
    }

    public final SubMenu addSubMenu(int i10, int i11, int i12, int i13) {
        return ((o) this.f9911d).addSubMenu(i10, i11, i12, i13);
    }

    public final MenuItem add(int i10, int i11, int i12, CharSequence charSequence) {
        return f(((o) this.f9911d).a(i10, i11, i12, charSequence));
    }

    public final SubMenu addSubMenu(int i10, int i11, int i12, CharSequence charSequence) {
        return this.f9911d.addSubMenu(i10, i11, i12, charSequence);
    }

    public final SubMenu addSubMenu(CharSequence charSequence) {
        return ((o) this.f9911d).addSubMenu(0, 0, 0, charSequence);
    }

    public final MenuItem add(CharSequence charSequence) {
        return f(((o) this.f9911d).a(0, 0, 0, charSequence));
    }
}
