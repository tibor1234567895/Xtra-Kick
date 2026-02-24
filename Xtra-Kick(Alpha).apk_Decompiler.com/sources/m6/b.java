package m6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v4.media.session.u;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.fragment.app.t;
import c0.g;
import com.woxthebox.draglistview.R;
import fb.y;
import hb.h0;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import s7.d;
import xa.j;

public abstract class b extends t {

    /* renamed from: t0  reason: collision with root package name */
    public SharedPreferences f10612t0;

    /* renamed from: u0  reason: collision with root package name */
    public u f10613u0;

    /* renamed from: v0  reason: collision with root package name */
    public ArrayList f10614v0;

    public final String r0() {
        ArrayList arrayList = this.f10614v0;
        if (arrayList != null) {
            int i10 = 0;
            if (arrayList.size() != 1) {
                u uVar = this.f10613u0;
                if (uVar != null) {
                    i10 = Math.max(((RadioGroup) uVar.f430k).getCheckedRadioButtonId(), 0);
                    SharedPreferences sharedPreferences = this.f10612t0;
                    if (sharedPreferences != null) {
                        SharedPreferences.Editor edit = sharedPreferences.edit();
                        j.e("editor", edit);
                        edit.putInt("downloadStorage", i10);
                        edit.apply();
                    } else {
                        j.l("prefs");
                        throw null;
                    }
                } else {
                    j.l("storageSelectionContainer");
                    throw null;
                }
            }
            ArrayList arrayList2 = this.f10614v0;
            if (arrayList2 != null) {
                return ((a) arrayList2.get(i10)).f10611c;
            }
            j.l("storage");
            throw null;
        }
        j.l("storage");
        throw null;
    }

    public final void s0(Context context, u uVar) {
        String str;
        this.f10613u0 = uVar;
        this.f10612t0 = h0.l1(context);
        d.f14369a.getClass();
        Object obj = g.f2717a;
        File[] b10 = c0.b.b(context, ".downloads");
        j.e("getExternalFilesDirs(context, \".downloads\")", b10);
        ArrayList arrayList = new ArrayList();
        int length = b10.length;
        int i10 = 0;
        while (true) {
            String str2 = null;
            if (i10 >= length) {
                break;
            }
            File file = b10[i10];
            if (file != null) {
                str2 = file.getAbsolutePath();
            }
            if (str2 != null) {
                if (i10 == 0) {
                    str = context.getString(R.string.internal_storage);
                } else {
                    int u10 = y.u(str2, "/Android/data", 0, false, 6);
                    if (u10 >= 0) {
                        str = str2.substring(y.w(str2, File.separatorChar, u10 - 1, 4) + 1, u10);
                        j.e("this as java.lang.String…ing(startIndex, endIndex)", str);
                    }
                }
                j.e("if (i == 0) {\n          …dRootIndex)\n            }", str);
                arrayList.add(new a(i10, str, str2));
            }
            i10++;
        }
        this.f10614v0 = arrayList;
        d.f14369a.getClass();
        if (j.a(Environment.getExternalStorageState(), "mounted")) {
            ArrayList arrayList2 = this.f10614v0;
            if (arrayList2 == null) {
                j.l("storage");
                throw null;
            } else if (arrayList2.size() > 1) {
                u uVar2 = this.f10613u0;
                if (uVar2 != null) {
                    LinearLayout y10 = uVar2.y();
                    j.e("storageSelectionContainer.root", y10);
                    y10.setVisibility(0);
                    ArrayList arrayList3 = this.f10614v0;
                    if (arrayList3 != null) {
                        Iterator it = arrayList3.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            u uVar3 = this.f10613u0;
                            if (uVar3 != null) {
                                RadioButton radioButton = new RadioButton(context);
                                radioButton.setId(aVar.f10609a);
                                radioButton.setText(aVar.f10610b);
                                ((RadioGroup) uVar3.f430k).addView(radioButton);
                            } else {
                                j.l("storageSelectionContainer");
                                throw null;
                            }
                        }
                        u uVar4 = this.f10613u0;
                        if (uVar4 != null) {
                            RadioGroup radioGroup = (RadioGroup) uVar4.f430k;
                            SharedPreferences sharedPreferences = this.f10612t0;
                            if (sharedPreferences != null) {
                                radioGroup.check(sharedPreferences.getInt("downloadStorage", 0));
                            } else {
                                j.l("prefs");
                                throw null;
                            }
                        } else {
                            j.l("storageSelectionContainer");
                            throw null;
                        }
                    } else {
                        j.l("storage");
                        throw null;
                    }
                } else {
                    j.l("storageSelectionContainer");
                    throw null;
                }
            }
        } else {
            u uVar5 = this.f10613u0;
            if (uVar5 != null) {
                LinearLayout y11 = uVar5.y();
                j.e("storageSelectionContainer.root", y11);
                y11.setVisibility(0);
                u uVar6 = this.f10613u0;
                if (uVar6 != null) {
                    TextView textView = (TextView) uVar6.f429j;
                    j.e("storageSelectionContainer.noStorageDetected", textView);
                    textView.setVisibility(0);
                    View findViewById = h0().findViewById(R.id.download);
                    j.e("requireView().findViewById<Button>(R.id.download)", findViewById);
                    h0.J0(findViewById);
                    return;
                }
                j.l("storageSelectionContainer");
                throw null;
            }
            j.l("storageSelectionContainer");
            throw null;
        }
    }
}
