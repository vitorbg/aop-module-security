package br.com.vitorbg.aop.config;

import br.com.vitorbg.aop.exception.AccessControlException;
import br.com.vitorbg.aop.service.AccessControlService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class SecurityAspectConfig {

    private final AccessControlService accessControlService;

    public SecurityAspectConfig(AccessControlService accessControlService) {
        this.accessControlService = accessControlService;
    }

    @Around("execution(* br.com.vitorbg.aop.web.*.*(..))")
    public Object handleAndVerifySecurity(ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            ModuleSecurity moduleSecurity = (ModuleSecurity) joinPoint.getTarget();
            boolean canAccess = accessControlService.verifyUserModuleAccess(UserContext.getUser(), moduleSecurity.getModule());
            if (!canAccess)
                throw new AccessControlException("User can't access this Module !");
        } catch (ClassCastException e) {
        }

        return joinPoint.proceed();
    }

}
