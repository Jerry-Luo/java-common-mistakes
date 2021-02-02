package org.geekbang.time.commonmistakes.io;

import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

/**
 * @author <a href="mailto:luojianwei@pinming.cn">LuoJianwei</a>
 * @since 2020/12/16 12:15
 */
public class ParameterizedTypeTest {

    public static void main(String[] args) {
        Test<String> t = new Test<String>(){};

        //TypeVariable<? extends Class<? extends Test>>[] typeParameters = t.getClass().getTypeParameters();
        //TypeVariable<? extends Class<? extends Test>> typeParameter = typeParameters[0];
        //
        //System.out.println(typeParameter.getGenericDeclaration());

        Type genericSuperclass = t.getClass().getGenericSuperclass();
        Type[] actualTypeArguments = ((ParameterizedType) genericSuperclass).getActualTypeArguments();
        Arrays.stream(actualTypeArguments).forEach(type->{
            System.out.println(type.getClass());
        });

        Class<?> type = (Class<?>)actualTypeArguments[0];
        Constructor<?>[] constructors = type.getConstructors();
        Arrays.stream(constructors).forEach(System.out::println);
    }

    static class Test<T>{
        T data;

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }
    }
}
