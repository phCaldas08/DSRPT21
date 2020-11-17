package br.com.fiap.dsrpt21.business;

import br.com.fiap.dsrpt21.model.AcaoModel;
import br.com.fiap.dsrpt21.model.ExecucaoModel;
import br.com.fiap.dsrpt21.repository.AcaoRepository;
import br.com.fiap.dsrpt21.repository.ExecucaoRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.Date;
import java.util.Optional;

@Component
public class ExecucaoBusiness {

    @Autowired
    private AcaoRepository acaoRepository;

    @Autowired
    private ExecucaoRepository execucaoRepository;

    public ExecucaoModel executar(Integer idAcao) throws Exception {

        ExecucaoModel execucaoModel = applyBusiness(idAcao);
        execucaoModel = execucaoRepository.save(execucaoModel);

        return execucaoModel;
    }

    public ExecucaoModel applyBusiness(Integer idAcao) throws Exception {
        Optional<AcaoModel> optionalAcao = acaoRepository.findById(idAcao);

        if(optionalAcao.isPresent() && optionalAcao.get().getAtivo()){
            ExecucaoModel execucaoModel = new ExecucaoModel();

            execucaoModel.setDataExecucao(new Date(System.currentTimeMillis()));
            execucaoModel.setAcao(optionalAcao.get());

            return execucaoModel;

        } else if(!optionalAcao.isPresent()) {
            makeException(optionalAcao, "Id", "Id da acao nao encontrado.");

        } else {
            makeException(optionalAcao, "Ativo", "A acao nao esta ativa.");
        }

        return null;
    }

    private void makeException(Object object, String field, String description) throws Exception {
        BindingResult error = new BeanPropertyBindingResult(object, "acao");
        error.addError(new FieldError("Acao",
                field,
                description));

        Exception exception = new MethodArgumentNotValidException(null, error);

        throw exception;
    }

}
