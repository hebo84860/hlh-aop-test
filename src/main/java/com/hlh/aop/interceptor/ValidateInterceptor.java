package com.hlh.aop.interceptor;

import com.hlh.aop.entity.HlhUserEntity;
import com.hlh.aop.utils.DateUtils;
import com.hlh.aop.valid.Email;
import com.hlh.aop.valid.Future;
import com.hlh.aop.valid.JudgeNotEmpty;
import com.hlh.aop.valid.JudgeObjectNotEmpty;
import com.hlh.aop.valid.Length;
import com.hlh.aop.valid.NotEmpty;
import com.hlh.aop.valid.NotNull;
import com.hlh.aop.valid.NotZero;
import com.hlh.aop.valid.ObjectNotEmpty;
import com.hlh.aop.valid.Range;
import com.hlh.aop.valid.Size;
import com.hlh.aop.valid.Tel;
import com.hlh.aop.valid.ValidateException;
import org.apache.commons.lang.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Aspect
//@Service
public class ValidateInterceptor {
	private static String objectEmpty="";

	@Before("@annotation(com.hlh.aop.annotation.ParamsValid)")
  	public void before(JoinPoint joinPoint) throws Exception {
	 	System.out.println("ValidateInterceptor...Object:" + joinPoint.getTarget() + ",Method:" + joinPoint.getSignature().getName());
		Object[] objects = joinPoint.getArgs();
		for (Object obj : objects) {
			if (null != obj) {
				if (obj instanceof HlhUserEntity) {
						HlhUserEntity HlhUserEntityBody = (HlhUserEntity) obj;
						this.handlerValidate(HlhUserEntityBody);
					}
			} else {
				System.out.println("OTA ValidateInterceptor 校验参数为空");
			}
	  	}
	}

	    private  void handlerValidate(Object obj)throws Exception{
	    	for (Class<?> clazz = obj.getClass(); clazz != Object.class; clazz = clazz.getSuperclass()) {
				System.out.println(clazz);
				Annotation[] annotations = clazz.getAnnotations();

				// 处理clazz annotation
				handlerClazz(annotations, obj);

				Field[] fields = clazz.getDeclaredFields();
				for (Field field : fields) {
					System.out.println(field);
					Annotation[] fieldAnnotations = field.getAnnotations();
					// 处理field annotation
					handlerField(fieldAnnotations, obj, field);
				}

              Method[] methodsDe = clazz.getDeclaredMethods();
				for (Method method : methodsDe) {
					System.out.println(method);
					Annotation[] methodAnnotations = method
							.getAnnotations();
					// 处理getter annotation
					handlerMethod(methodAnnotations, obj, method);
				}
			}
	    }
		/**
		 * 处理clazz annotation
		 * 
		 * @param annotations
		 * @param obj
		 * @throws Exception
		 */
		public static void handlerClazz(Annotation[] annotations, Object obj) throws Exception {
			if (null != annotations && annotations.length > 0) {
				for (Annotation annotation : annotations) {
					System.out.println(annotation);
					validate(annotation, obj);
				}
			}
		}

		/**
		 * 处理field annotation
		 * 
		 * @param annotations
		 * @param obj
		 * @param field
		 * @throws Exception
		 */
		public static void handlerField(Annotation[] annotations, Object obj, Field field) throws Exception {
			if (null != annotations && annotations.length > 0) {
				for (Annotation annotation : annotations) {
					System.out.println(annotation);
					field.setAccessible(true);
					Object result = field.get(obj);
					validate(annotation, result);
				}
			}
		}

		/**
		 * 处理getter annotation
		 * 
		 * @param annotations
		 * @param obj
		 * @param method
		 * @throws Exception
		 */
		public static void handlerMethod(Annotation[] annotations, Object obj, Method method) throws Exception {
			if (null != annotations && annotations.length > 0) {
				for (Annotation annotation : annotations) {
					System.out.println(annotation);
					Object result = method.invoke(obj);
					validate(annotation, result);
				}
			}
		}

		/**
		 * 验证POJO
		 * 
		 * @param annotation
		 * @param object
		 * @throws Exception
		 */
		public static void validate(Annotation annotation, Object object) throws Exception {
			if (annotation instanceof NotNull) {
				if (null == object) {
					throw new ValidateException( "：" + ((NotNull) annotation).message());
				}
			} else if (annotation instanceof NotEmpty) {
	            if (null == object || "".equals(object.toString().trim()) || object.toString().trim().equals("")) {
	                throw new ValidateException( "：" + ((NotEmpty) annotation).message());
	            }
	        } else if (annotation instanceof ObjectNotEmpty) {
				if (null == object) {
					throw new ValidateException( "：" + ((ObjectNotEmpty) annotation).message());
				} else if (object instanceof List) {
					if (((List) object).size() <= 0) {
						throw new ValidateException( "：" + ((ObjectNotEmpty) annotation).message());
					}
					for (Object o : (List) object) {
						if (null == o) {
							throw new ValidateException( "：" + ((ObjectNotEmpty) annotation).message());
						} else if (o instanceof String) {
							if (StringUtils.isEmpty((String) o)) {
								throw new ValidateException( "：" + ((ObjectNotEmpty) annotation).message());
							}
						}
					}
				}
			} else if (annotation instanceof Size) {
				int min = ((Size) annotation).min();
				int max = ((Size) annotation).max();
				if (object instanceof String) {
					if (((String) object).length() < min
							|| ((String) object).length() > max) {
						throw new ValidateException( "：" + ((Size) annotation).message());
					}
				}
			} else if (annotation instanceof Email) {
				if (null != object) {
					String sResult = (String) object;
					String regex = ((Email) annotation).regex();
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(sResult);
					if (!m.find()) {
						throw new ValidateException( "：" + ((Email) annotation).message());
					}
				} else {
					throw new ValidateException( "：" + ((Email) annotation).message());
				}

			} else if (annotation instanceof Tel) {
				if (null != object) {
					String sResult = (String) object;
					String regex = ((Tel) annotation).regex();
					Pattern p = Pattern.compile(regex);
					Matcher m = p.matcher(sResult);
					if (!m.find()) {
						throw new ValidateException( "：" + ((Tel) annotation).message());
					}
				} else {
					throw new ValidateException( "：" + ((Tel) annotation).message());
				}

			} else if (annotation instanceof Length) {
				int min = ((Length) annotation).min();
				int max = ((Length) annotation).max();
				if (object instanceof String) {
					if (((String) object).length() < min
							|| ((String) object).length() > max) {
						throw new ValidateException( "：" + ((Length) annotation).message());
					}
				}
			} else if (annotation instanceof NotZero) {
				if (object instanceof Integer) {
					if ((Integer) object == 0) {
						throw new ValidateException( "：" + ((NotZero) annotation).message());
					}
				} else if (object instanceof Long) {
					if ((Long) object == 0) {
						throw new ValidateException( "：" + ((NotZero) annotation).message());
					}
				} else if (object instanceof Float) {
					if ((Float) object == 0) {
						throw new ValidateException( "：" + ((NotZero) annotation).message());
					}
				} else if (object instanceof Double) {
					if ((Double) object == 0) {
						throw new ValidateException( "：" + ((NotZero) annotation).message());
					}
				}
			} else if (annotation instanceof Range) {
				int min = ((Range) annotation).min();
				int max = ((Range) annotation).max();
				if (object instanceof Integer) {
					if ((((Integer) object) < min) || ((Integer) object) > max) {
						throw new ValidateException( "：" + ((Range) annotation).message());
					}
				} else if (object instanceof Long) {
					if ((((Long) object) < min) || ((Long) object) > max) {
						throw new ValidateException( "：" + ((Range) annotation).message());
					}
				} else if (object instanceof Float) {
					if ((((Float) object) < min) || ((Float) object) > max) {
						throw new ValidateException( "：" + ((Range) annotation).message());
					}
				} else if (object instanceof Double) {
					if ((((Double) object) < min) || ((Double) object) > max) {
						throw new ValidateException( "：" + ((Range) annotation).message());
					}
				}
			} else if (annotation instanceof Future) {
				if (null == object) {
					throw new ValidateException( "：" + ((Future) annotation).message());
				} else if (object instanceof String) {
					if (StringUtils.isEmpty(object.toString()) || DateUtils.parseDate(DateUtils.formatDate(new Date())).compareTo(DateUtils.parseDate(object.toString())) == 1) {
						throw new ValidateException( "：" + ((Future) annotation).message());
					}
				} else if (object instanceof Date) {
					if (new Date().before((Date) object)) {
						throw new ValidateException( "：" + ((Future) annotation).message());
					}
				}
			}else if (annotation instanceof JudgeNotEmpty) {
	            if (null == object || "".equals(object.toString().trim()) || object.toString().trim().equals("")) {
	                throw new ValidateException( "：" + ((JudgeNotEmpty) annotation).message());
	            }else{
	            	 if(object.toString().equals("queryOrderDetail") || object.toString().equals("search")
	            			 || object.toString().equals("timeTable") || object.toString().equals("allStation")){
	            		    objectEmpty="";
	 					}else{
	 						objectEmpty="allow";
	 					}
	            }
	        }else if (annotation instanceof JudgeObjectNotEmpty) {
	            if(StringUtils.isNotEmpty(objectEmpty) && objectEmpty.equals("allow")){
	            	if (null == object || "".equals(object.toString().trim()) || object.toString().trim().equals("")) {
		                throw new ValidateException( "：" + ((JudgeObjectNotEmpty) annotation).message());
		            }
	            }
	        }	
		}
				
}


