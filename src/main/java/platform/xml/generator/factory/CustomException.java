package platform.xml.generator.factory;

import java.util.List;

import platform.xml.generator.exception.ExceptionEntry;

public class CustomException extends Exception{
	private static final long serialVersionUID = 2489196979234909526L;

	public CustomException(String i18n,String code){
		List<ExceptionEntry> entyList=ExceptionConfigReader.exceptionList(i18n);
		Exception exception=null;
		for(ExceptionEntry entry: entyList){
			if(entry.getCode().equals(code)){
//				super(new String());
				//entry.getMessage()
			}
		}
	}
//	public static Exception createCustomException(String i18n,String code){
//		Enhancer enhancer = new Enhancer();
//		enhancer.setSuperclass(CustomExceptionInstance.class);
//		enhancer.setCallback(new ExceptionIntercept());
//		CustomExceptionInstance custom = (CustomExceptionInstance) enhancer.create();
//		Exception customException=(Exception)custom.newException(i18n,code);
//		return customException;
//	}
}
