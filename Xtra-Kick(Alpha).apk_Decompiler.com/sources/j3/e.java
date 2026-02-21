package j3;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.h;
import android.util.Log;
import eb.m;
import java.util.Iterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import xa.j;

@l2("activity")
public class e extends o2 {

    /* renamed from: c  reason: collision with root package name */
    public final Context f8520c;

    /* renamed from: d  reason: collision with root package name */
    public final Activity f8521d;

    static {
        new b(0);
    }

    public e(Context context) {
        Object obj;
        j.f("context", context);
        this.f8520c = context;
        Iterator it = m.b(context, d.f8516h).iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            if (((Context) obj) instanceof Activity) {
                break;
            }
        }
        this.f8521d = (Activity) obj;
    }

    public final c1 a() {
        return new c(this);
    }

    public final c1 c(c1 c1Var, Bundle bundle, n1 n1Var) {
        Intent intent;
        int intExtra;
        boolean z10;
        c cVar = (c) c1Var;
        if (cVar.f8502r != null) {
            Intent intent2 = new Intent(cVar.f8502r);
            int i10 = 0;
            if (bundle != null) {
                intent2.putExtras(bundle);
                String str = cVar.f8503s;
                if (str == null || str.length() == 0) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                if (!z10) {
                    StringBuffer stringBuffer = new StringBuffer();
                    Matcher matcher = Pattern.compile("\\{(.+?)\\}").matcher(str);
                    while (matcher.find()) {
                        String group = matcher.group(1);
                        if (bundle.containsKey(group)) {
                            matcher.appendReplacement(stringBuffer, "");
                            stringBuffer.append(Uri.encode(String.valueOf(bundle.get(group))));
                        } else {
                            throw new IllegalArgumentException("Could not find " + group + " in " + bundle + " to fill data pattern " + str);
                        }
                    }
                    matcher.appendTail(stringBuffer);
                    intent2.setData(Uri.parse(stringBuffer.toString()));
                }
            }
            Activity activity = this.f8521d;
            if (activity == null) {
                intent2.addFlags(268435456);
            }
            if (n1Var != null && n1Var.f8632a) {
                intent2.addFlags(536870912);
            }
            if (!(activity == null || (intent = activity.getIntent()) == null || (intExtra = intent.getIntExtra("android-support-navigation:ActivityNavigator:current", 0)) == 0)) {
                intent2.putExtra("android-support-navigation:ActivityNavigator:source", intExtra);
            }
            intent2.putExtra("android-support-navigation:ActivityNavigator:current", cVar.f8513o);
            Context context = this.f8520c;
            Resources resources = context.getResources();
            if (n1Var != null) {
                int i11 = n1Var.f8639h;
                int i12 = n1Var.f8640i;
                if ((i11 <= 0 || !j.a(resources.getResourceTypeName(i11), "animator")) && (i12 <= 0 || !j.a(resources.getResourceTypeName(i12), "animator"))) {
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popEnterAnim", i11);
                    intent2.putExtra("android-support-navigation:ActivityNavigator:popExitAnim", i12);
                } else {
                    Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring popEnter resource " + resources.getResourceName(i11) + " and popExit resource " + resources.getResourceName(i12) + " when launching " + cVar);
                }
            }
            context.startActivity(intent2);
            if (n1Var == null || activity == null) {
                return null;
            }
            int i13 = n1Var.f8637f;
            int i14 = n1Var.f8638g;
            if ((i13 > 0 && j.a(resources.getResourceTypeName(i13), "animator")) || (i14 > 0 && j.a(resources.getResourceTypeName(i14), "animator"))) {
                Log.w("ActivityNavigator", "Activity destinations do not support Animator resource. Ignoring enter resource " + resources.getResourceName(i13) + " and exit resource " + resources.getResourceName(i14) + "when launching " + cVar);
                return null;
            } else if (i13 < 0 && i14 < 0) {
                return null;
            } else {
                if (i13 < 0) {
                    i13 = 0;
                }
                if (i14 >= 0) {
                    i10 = i14;
                }
                activity.overridePendingTransition(i13, i10);
                return null;
            }
        } else {
            throw new IllegalStateException(h.o(new StringBuilder("Destination "), cVar.f8513o, " does not have an Intent set.").toString());
        }
    }

    public final boolean j() {
        Activity activity = this.f8521d;
        if (activity == null) {
            return false;
        }
        activity.finish();
        return true;
    }
}
