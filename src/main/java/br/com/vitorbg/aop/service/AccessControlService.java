package br.com.vitorbg.aop.service;

import br.com.vitorbg.aop.domain.ModuleEnum;
import org.springframework.stereotype.Service;

@Service
public class AccessControlService {

    public boolean verifyUserModuleAccess(String user, ModuleEnum moduleEnum) {
        //Rule for User and Module access
        return true;
    }

}
