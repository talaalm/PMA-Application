package com.project1.validators;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


//@Target({ElementType.FIELD})
//@Retention(RetentionPolicy.RUNTIME)
//@Constraint(validatedBy=UniqueValidator.class)
//public @interface UniqueValue {
//		
//	String message() default "Unique Constraint violated";
//	
//	Class<?>[] groups() default{};
//	
//	Class<? extends Payload>[] payload() default{};
//}


@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy=UniqueValidator.class)
public @interface UniqueValue {
	
	String message() default "Unique Value Violated";
	
	Class<?> grousp() default{};
	
	Class<? extends Payload> payload() default{};
}