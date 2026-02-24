package v9;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import m.g;
import ma.b0;
import p9.b;
import p9.x;
import q9.e;
import t9.p;
import xa.j;
import y9.v;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashSet f15970a = new LinkedHashSet();

    public a(String str) {
        j.g("namespace", str);
        b0 b0Var = b0.f10801h;
    }

    public final void a(List list, b bVar, v vVar) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        boolean z14;
        boolean z15;
        boolean z16;
        boolean z17;
        j.g("downloads", list);
        ArrayList arrayList = new ArrayList();
        Iterator it = list.iterator();
        while (true) {
            boolean z18 = true;
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            if (((e) ((b) next)).f13442q != x.QUEUED) {
                z18 = false;
            }
            if (z18) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object next2 : list) {
            if (((e) ((b) next2)).f13442q == x.ADDED) {
                z17 = true;
            } else {
                z17 = false;
            }
            if (z17) {
                arrayList2.add(next2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for (Object next3 : list) {
            if (((e) ((b) next3)).f13442q == x.PAUSED) {
                z16 = true;
            } else {
                z16 = false;
            }
            if (z16) {
                arrayList3.add(next3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for (Object next4 : list) {
            if (((e) ((b) next4)).f13442q == x.DOWNLOADING) {
                z15 = true;
            } else {
                z15 = false;
            }
            if (z15) {
                arrayList4.add(next4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for (Object next5 : list) {
            if (((e) ((b) next5)).f13442q == x.COMPLETED) {
                z14 = true;
            } else {
                z14 = false;
            }
            if (z14) {
                arrayList5.add(next5);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for (Object next6 : list) {
            if (((e) ((b) next6)).f13442q == x.CANCELLED) {
                z13 = true;
            } else {
                z13 = false;
            }
            if (z13) {
                arrayList6.add(next6);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for (Object next7 : list) {
            if (((e) ((b) next7)).f13442q == x.FAILED) {
                z12 = true;
            } else {
                z12 = false;
            }
            if (z12) {
                arrayList7.add(next7);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for (Object next8 : list) {
            if (((e) ((b) next8)).f13442q == x.DELETED) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (z11) {
                arrayList8.add(next8);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        for (Object next9 : list) {
            if (((e) ((b) next9)).f13442q == x.REMOVED) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                arrayList9.add(next9);
            }
        }
        if (vVar != v.DOWNLOAD_BLOCK_UPDATED) {
            p.f14899d.getClass();
            p.f14898c.post(new g(this, list, vVar, bVar, 2));
        }
    }
}
