package br.com.vitorbg.aop.web;

import br.com.vitorbg.aop.config.ModuleSecurity;
import br.com.vitorbg.aop.domain.ModuleEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PeopleController implements ModuleSecurity {

    @GetMapping
    public String getPeople() {
        return "People ";
    }

    @Override
    public ModuleEnum getModule() { return ModuleEnum.MODULE_PEOPLE; }

}
