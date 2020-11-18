package br.com.fiap.dsrpt21.controller;

import br.com.fiap.dsrpt21.business.ExecucaoBusiness;
import br.com.fiap.dsrpt21.model.AcaoModel;
import br.com.fiap.dsrpt21.model.ExecucaoModel;
import br.com.fiap.dsrpt21.repository.AcaoRepository;
import br.com.fiap.dsrpt21.repository.ExecucaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/execucao")
public class ExecucaoController {
    @Autowired
    private ExecucaoRepository repository;

    @Autowired
    private ExecucaoBusiness business;

    @GetMapping()
    public ResponseEntity findAll(){
        List<AcaoModel> execucoes = repository.findByExecucoesIsNotNull();
        execucoes.forEach(i -> i.getExecucoes().forEach(j -> j.setAcao(null)));
        return ResponseEntity.ok(execucoes);
    }

    @GetMapping("/{id}")
    public ResponseEntity findById(@PathVariable Integer id){
       ExecucaoModel execucao = repository.findById(id).get();
       execucao.getAcao().setExecucoes(null);

       return ResponseEntity.ok(execucao);

    }

    @PostMapping("/executar")
    public ResponseEntity executarAcao(@RequestParam Integer idAcao) throws Exception {
        ExecucaoModel execucaoModel = business.executar(idAcao);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(execucaoModel.getAcao().getIdAcao())
                .toUri();

        return ResponseEntity.created(location).build();
    }

}
