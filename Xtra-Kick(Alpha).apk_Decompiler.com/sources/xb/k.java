package xb;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import xa.j;

public final class k implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    public final List f16836a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f16837b;

    /* renamed from: c  reason: collision with root package name */
    public String f16838c;

    public k(ArrayList arrayList) {
        this.f16836a = arrayList;
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) {
        j.f("proxy", obj);
        j.f("method", method);
        if (objArr == null) {
            objArr = new Object[0];
        }
        String name = method.getName();
        Class<?> returnType = method.getReturnType();
        if (j.a(name, "supports") && j.a(Boolean.TYPE, returnType)) {
            return Boolean.TRUE;
        }
        if (!j.a(name, "unsupported") || !j.a(Void.TYPE, returnType)) {
            boolean a10 = j.a(name, "protocols");
            List list = this.f16836a;
            if (a10) {
                if (objArr.length == 0) {
                    return list;
                }
            }
            if ((j.a(name, "selectProtocol") || j.a(name, "select")) && j.a(String.class, returnType) && objArr.length == 1) {
                Object obj2 = objArr[0];
                if (obj2 instanceof List) {
                    j.d("null cannot be cast to non-null type kotlin.collections.List<*>", obj2);
                    List list2 = (List) obj2;
                    int size = list2.size();
                    if (size >= 0) {
                        int i10 = 0;
                        while (true) {
                            Object obj3 = list2.get(i10);
                            j.d("null cannot be cast to non-null type kotlin.String", obj3);
                            String str = (String) obj3;
                            if (!list.contains(str)) {
                                if (i10 == size) {
                                    break;
                                }
                                i10++;
                            } else {
                                this.f16838c = str;
                                return str;
                            }
                        }
                    }
                    String str2 = (String) list.get(0);
                    this.f16838c = str2;
                    return str2;
                }
            }
            if ((!j.a(name, "protocolSelected") && !j.a(name, "selected")) || objArr.length != 1) {
                return method.invoke(this, Arrays.copyOf(objArr, objArr.length));
            }
            Object obj4 = objArr[0];
            j.d("null cannot be cast to non-null type kotlin.String", obj4);
            this.f16838c = (String) obj4;
            return null;
        }
        this.f16837b = true;
        return null;
    }
}
