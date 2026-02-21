package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import androidx.activity.result.b;
import androidx.activity.result.c;
import androidx.recyclerview.widget.a3;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.r1;
import java.util.ArrayList;
import java.util.Map;
import kb.i;
import kb.j;
import la.v;
import n3.k2;
import n3.s;
import pa.e;
import qa.a;

public final class p0 implements c, a3, i {

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ int f1531h;

    /* renamed from: i  reason: collision with root package name */
    public final Object f1532i;

    public /* synthetic */ p0(int i10, Object obj) {
        this.f1531h = i10;
        this.f1532i = obj;
    }

    public Object b(j jVar, e eVar) {
        a aVar = a.COROUTINE_SUSPENDED;
        int i10 = this.f1531h;
        Object obj = this.f1532i;
        switch (i10) {
            case 0:
                Object b10 = ((i) obj).b(new s(jVar, 0), eVar);
                if (b10 == aVar) {
                    return b10;
                }
                return v.f9814a;
            case 1:
                Object b11 = ((i) obj).b(new s(jVar, 1), eVar);
                if (b11 == aVar) {
                    return b11;
                }
                return v.f9814a;
            case 2:
                Object b12 = ((i) obj).b(new s(jVar, 2), eVar);
                if (b12 == aVar) {
                    return b12;
                }
                return v.f9814a;
            case 3:
                Object b13 = ((i) obj).b(new k2(jVar, 2, new xa.s()), eVar);
                if (b13 == aVar) {
                    return b13;
                }
                return v.f9814a;
            default:
                Object a10 = jVar.a(obj, eVar);
                if (a10 == aVar) {
                    return a10;
                }
                return v.f9814a;
        }
    }

    public int e(View view) {
        int F;
        int i10;
        int i11 = this.f1531h;
        Object obj = this.f1532i;
        switch (i11) {
            case 0:
                ((q1) obj).getClass();
                F = q1.Q(view) + view.getRight();
                i10 = ((r1) view.getLayoutParams()).rightMargin;
                break;
            default:
                ((q1) obj).getClass();
                F = q1.F(view) + view.getBottom();
                i10 = ((r1) view.getLayoutParams()).bottomMargin;
                break;
        }
        return F + i10;
    }

    public int f(View view) {
        int top;
        int i10;
        int i11 = this.f1531h;
        Object obj = this.f1532i;
        switch (i11) {
            case 0:
                ((q1) obj).getClass();
                top = view.getLeft() - q1.N(view);
                i10 = ((r1) view.getLayoutParams()).leftMargin;
                break;
            default:
                ((q1) obj).getClass();
                top = view.getTop() - q1.S(view);
                i10 = ((r1) view.getLayoutParams()).topMargin;
                break;
        }
        return top - i10;
    }

    public int g() {
        int i10;
        int paddingBottom;
        int i11 = this.f1531h;
        Object obj = this.f1532i;
        switch (i11) {
            case 0:
                q1 q1Var = (q1) obj;
                i10 = q1Var.f2156u;
                paddingBottom = q1Var.getPaddingRight();
                break;
            default:
                q1 q1Var2 = (q1) obj;
                i10 = q1Var2.f2157v;
                paddingBottom = q1Var2.getPaddingBottom();
                break;
        }
        return i10 - paddingBottom;
    }

    public void i() {
        ((e0) this.f1532i).f1405k.P();
    }

    public void j(b bVar) {
        StringBuilder sb2;
        StringBuilder sb3;
        int i10 = this.f1531h;
        Object obj = this.f1532i;
        switch (i10) {
            case 2:
                c1 c1Var = (c1) obj;
                x0 x0Var = (x0) c1Var.E.pollLast();
                if (x0Var == null) {
                    sb3 = new StringBuilder("No Activities were started for result for ");
                    sb3.append(this);
                } else {
                    n1 n1Var = c1Var.f1373c;
                    String str = x0Var.f1610h;
                    c0 c10 = n1Var.c(str);
                    if (c10 == null) {
                        sb3 = new StringBuilder("Activity result delivered for unknown Fragment ");
                        sb3.append(str);
                    } else {
                        c10.K(x0Var.f1611i, bVar.f502h, bVar.f503i);
                        return;
                    }
                }
                Log.w("FragmentManager", sb3.toString());
                return;
            default:
                c1 c1Var2 = (c1) obj;
                x0 x0Var2 = (x0) c1Var2.E.pollFirst();
                if (x0Var2 == null) {
                    sb2 = new StringBuilder("No IntentSenders were started for ");
                    sb2.append(this);
                } else {
                    n1 n1Var2 = c1Var2.f1373c;
                    String str2 = x0Var2.f1610h;
                    c0 c11 = n1Var2.c(str2);
                    if (c11 == null) {
                        sb2 = new StringBuilder("Intent Sender result delivered for unknown Fragment ");
                        sb2.append(str2);
                    } else {
                        c11.K(x0Var2.f1611i, bVar.f502h, bVar.f503i);
                        return;
                    }
                }
                Log.w("FragmentManager", sb2.toString());
                return;
        }
    }

    public void k(Object obj) {
        StringBuilder sb2;
        int i10;
        switch (this.f1531h) {
            case 0:
                Map map = (Map) obj;
                String[] strArr = (String[]) map.keySet().toArray(new String[0]);
                ArrayList arrayList = new ArrayList(map.values());
                int[] iArr = new int[arrayList.size()];
                for (int i11 = 0; i11 < arrayList.size(); i11++) {
                    if (((Boolean) arrayList.get(i11)).booleanValue()) {
                        i10 = 0;
                    } else {
                        i10 = -1;
                    }
                    iArr[i11] = i10;
                }
                c1 c1Var = (c1) this.f1532i;
                x0 x0Var = (x0) c1Var.E.pollFirst();
                if (x0Var == null) {
                    sb2 = new StringBuilder("No permissions were requested for ");
                    sb2.append(this);
                } else {
                    n1 n1Var = c1Var.f1373c;
                    String str = x0Var.f1610h;
                    if (n1Var.c(str) == null) {
                        sb2 = new StringBuilder("Permission request result delivered for unknown Fragment ");
                        sb2.append(str);
                    } else {
                        return;
                    }
                }
                Log.w("FragmentManager", sb2.toString());
                return;
            case 2:
                j((b) obj);
                return;
            default:
                j((b) obj);
                return;
        }
    }
}
