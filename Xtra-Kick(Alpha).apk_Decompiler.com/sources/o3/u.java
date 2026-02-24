package o3;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;
import androidx.preference.Preference;
import com.woxthebox.draglistview.R;

public final class u implements View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {

    /* renamed from: h  reason: collision with root package name */
    public final Preference f12171h;

    public u(Preference preference) {
        this.f12171h = preference;
    }

    public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Preference preference = this.f12171h;
        CharSequence f10 = preference.f();
        if (preference.J && !TextUtils.isEmpty(f10)) {
            contextMenu.setHeaderTitle(f10);
            contextMenu.add(0, 0, 0, R.string.copy).setOnMenuItemClickListener(this);
        }
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        Preference preference = this.f12171h;
        CharSequence f10 = preference.f();
        ((ClipboardManager) preference.f1887h.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("Preference", f10));
        Context context = preference.f1887h;
        Toast.makeText(context, context.getString(R.string.preference_copied, new Object[]{f10}), 0).show();
        return true;
    }
}
