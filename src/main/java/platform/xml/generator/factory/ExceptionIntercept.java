package platform.xml.generator.factory;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class ExceptionIntercept implements MethodInterceptor{

	@Override
	public Object intercept(Object obj, Method method, Object[] objectArr, MethodProxy methodProxy) throws Throwable {
		Object object=methodProxy.invokeSuper(obj, objectArr);
		return object;
	}
}
