package com.zup.acelera.novoautor;

import com.zup.acelera.model.Autor;
import com.zup.acelera.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Optional;

@Component
public class EmailAutorDuplicadoValidator implements Validator {

    @Autowired
    private AutorRepository autorRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return NovoAutorRequest.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
        NovoAutorRequest request = (NovoAutorRequest) target;
        Optional<Autor> autor = autorRepository.findByEmail(request.getEmail());
        if(autor.isPresent()){
            errors.rejectValue("email", null, "Já existe um outro autor com o mesmo e-mail");
        }

    }
}
