package com.cafe24.jblog.security;

import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Retention(RUNTIME)
@Target(PARAMETER)
public @interface AuthUser {
	public enum Role {USER, VISITER};
	public Role role() default Role.VISITER;
}
