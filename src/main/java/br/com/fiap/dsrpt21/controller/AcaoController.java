package br.com.fiap.dsrpt21.controller;

import br.com.fiap.dsrpt21.model.AcaoModel;
import br.com.fiap.dsrpt21.repository.AcaoRepository;
import br.com.fiap.dsrpt21.repository.ExecucaoRepository;
import jdk.nashorn.internal.runtime.options.Option;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/acao")
public class AcaoController {

    @Autowired
    public AcaoRepository repository;

    @GetMapping()
    public ResponseEntity findAll(){
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){

        Optional<AcaoModel> optionalAction = repository.findById(id);
        return ResponseEntity.ok(optionalAction.get());
    }

    @PostMapping()
    public ResponseEntity create(@RequestBody @Valid AcaoModel model){
        AcaoModel acao = repository.save(model);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id")
                .buildAndExpand(acao.getIdAcao())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable Integer id, @RequestBody @Valid AcaoModel model){
        repository.findById(id).get();

        model.setIdAcao(id);

        repository.save(model);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Integer id){
        repository.findById(id).get();

        repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
