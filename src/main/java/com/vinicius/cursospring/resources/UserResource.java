package com.vinicius.cursospring.resources;

import com.vinicius.cursospring.entities.User;
import com.vinicius.cursospring.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* O Controller (UserResource) delega as operações para o Service, em vez de acessar diretamente o banco
*
*/

@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService service; //Injeção de dependência por atributo (Field Injection)

    //Melhoria: Usar injeção de dependência por construtor (Boa prática)

    @GetMapping //Endpoint (Retorna todos os usuários do sistema)
    public ResponseEntity<List<User>> findAll(){
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}") //Endpoint (Retorna um usuário pelo ID)
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }
}
