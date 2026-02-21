package r3;

import android.net.Uri;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;
import androidx.appcompat.widget.SearchView;
import com.github.andreyasadchy.xtra.model.ui.Clip;
import com.github.andreyasadchy.xtra.ui.view.chat.ChatView;
import com.woxthebox.draglistview.R;
import d6.b;
import g.s0;
import h3.j4;
import h9.e0;
import hb.h0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import la.v;
import m6.c;
import ma.j0;
import ma.p;
import o.e;
import t6.f;
import t6.l;
import u6.d;
import xa.j;

public final /* synthetic */ class b0 implements Runnable {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f13658h;

    /* renamed from: i  reason: collision with root package name */
    public final /* synthetic */ Object f13659i;

    /* renamed from: j  reason: collision with root package name */
    public final /* synthetic */ Object f13660j;

    public /* synthetic */ b0(Object obj, int i10, Object obj2) {
        this.f13658h = i10;
        this.f13659i = obj;
        this.f13660j = obj2;
    }

    public final void run() {
        int i10;
        String[] stringArray;
        String[] stringArray2;
        boolean z10;
        switch (this.f13658h) {
            case 0:
                d0 d0Var = (d0) this.f13659i;
                String[] strArr = (String[]) this.f13660j;
                j.f("this$0", d0Var);
                j.f("$tables", strArr);
                y yVar = d0Var.f13665b;
                String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
                yVar.getClass();
                j.f("tables", strArr2);
                synchronized (yVar.f13786l) {
                    Iterator it = yVar.f13786l.iterator();
                    while (true) {
                        e eVar = (e) it;
                        if (eVar.hasNext()) {
                            Map.Entry entry = (Map.Entry) eVar.next();
                            j.e("(observer, wrapper)", entry);
                            w wVar = (w) entry.getValue();
                            if (!((v) entry.getKey()).a()) {
                                wVar.b(strArr2);
                            }
                        } else {
                            v vVar = v.f9814a;
                        }
                    }
                }
                return;
            case 1:
                Runnable runnable = (Runnable) this.f13659i;
                s0 s0Var = (s0) this.f13660j;
                j.f("$command", runnable);
                j.f("this$0", s0Var);
                try {
                    runnable.run();
                    return;
                } finally {
                    s0Var.b();
                }
            case 2:
                b bVar = (b) this.f13659i;
                bVar.f4518p = false;
                bVar.b((Uri) this.f13660j);
                return;
            case 3:
                e0 e0Var = (e0) this.f13659i;
                ImageButton imageButton = (ImageButton) this.f13660j;
                f fVar = l.f14620w0;
                j.f("$result", e0Var);
                j.f("$this_apply", imageButton);
                if (((j4) e0Var.get()).f7143h == 0) {
                    if (((j4) e0Var.get()).f7144i.getBoolean("result")) {
                        i10 = R.drawable.baseline_audio_compressor_on_24dp;
                    } else {
                        i10 = R.drawable.baseline_audio_compressor_off_24dp;
                    }
                    imageButton.setImageResource(i10);
                    return;
                }
                return;
            case 4:
                e0 e0Var2 = (e0) this.f13659i;
                d dVar = (d) this.f13660j;
                u6.b bVar2 = d.I0;
                j.f("$result", e0Var2);
                j.f("this$0", dVar);
                if (((j4) e0Var2.get()).f7143h == 0 && (stringArray = ((j4) e0Var2.get()).f7144i.getStringArray("urlsKeys")) != null && (stringArray2 = ((j4) e0Var2.get()).f7144i.getStringArray("urlsValues")) != null) {
                    ArrayList k10 = p.k(stringArray, stringArray2);
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    j0.h(k10, linkedHashMap);
                    c cVar = m6.d.D0;
                    Clip clip = dVar.G0;
                    if (clip != null) {
                        cVar.getClass();
                        c.a(clip, linkedHashMap).q0(dVar.u(), (String) null);
                        return;
                    }
                    j.l("clip");
                    throw null;
                }
                return;
            case Constants.MAX_COMPATIBILITY_VERSION:
                ChatView chatView = (ChatView) this.f13659i;
                View view = (View) this.f13660j;
                int i11 = ChatView.I;
                j.f("this$0", chatView);
                chatView.v();
                j.e("it", view);
                if (view.getVisibility() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (z10) {
                    h0.J0(view);
                    return;
                } else {
                    view.setVisibility(0);
                    return;
                }
            case 6:
                SearchView searchView = (SearchView) this.f13659i;
                InputMethodManager inputMethodManager = (InputMethodManager) this.f13660j;
                j.f("$this_showKeyboard", searchView);
                searchView.setIconified(false);
                if (inputMethodManager != null) {
                    inputMethodManager.showSoftInput(searchView, 0);
                    return;
                }
                return;
            default:
                InputMethodManager inputMethodManager2 = (InputMethodManager) this.f13659i;
                EditText editText = (EditText) this.f13660j;
                j.f("$this_showKeyboard", editText);
                if (inputMethodManager2 != null) {
                    inputMethodManager2.showSoftInput(editText, 0);
                    return;
                }
                return;
        }
    }
}
