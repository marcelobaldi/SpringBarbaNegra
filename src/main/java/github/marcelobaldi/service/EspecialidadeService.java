//Pacote, Libs, Arquivos
package github.marcelobaldi.service;
import github.marcelobaldi.entity.Especialidades;
import github.marcelobaldi.exception.RegraNegocioException;
import github.marcelobaldi.repository.EspecialidadeDAO;
import github.marcelobaldi.service.serviceimple.EspecialidadeInterface;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

//Classe (Anotação Serviço)
@Service
public class EspecialidadeService implements EspecialidadeInterface {

    //Variável e Construtor (Acesso à Classe Repository)
    EspecialidadeDAO especialidadeDAO;
    public EspecialidadeService(EspecialidadeDAO especialidadeDAO){
        this.especialidadeDAO = especialidadeDAO;
    }

    //Método - Salvar
    @Override
    @Transactional
    public Especialidades salvar(Especialidades especialidades) {
        validarCampos(especialidades);
        return especialidadeDAO.save(especialidades);
    }

    //Método - Atualizar
    @Override
    @Transactional
    public Especialidades atualizar(Especialidades especialidades) {
        validarCampos(especialidades);
        Objects.requireNonNull(especialidades.getId());                  //Não Aceitar o ID Nulo
        return especialidadeDAO.save(especialidades);
    }

    //Método - Deletar
    @Override
    @Transactional
    public void deletar(Especialidades especialidades) {
        Objects.requireNonNull(especialidades.getId());                  //Não Aceitar o ID Nulo;
        especialidadeDAO.delete(especialidades);
    }

    //Método - Buscar Todos (Todos e/ou Contém)
    @Override
    @Transactional(readOnly = true)
    public List<Especialidades> buscar(Especialidades especialidadesFiltro) {
        Example example = Example.of(especialidadesFiltro, ExampleMatcher
                .matching()
                .withIgnoreCase()
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING));
        return especialidadeDAO.findAll(example);
    }

    //Método - Buscar Por Id
    @Override
    @Transactional
    public Optional<Especialidades> buscarPorId(Integer id) {
        return especialidadeDAO.findById(id);
    }

    //Método - Tratamento Erros (Campos)
    @Override
    public void validarCampos(Especialidades especialidades) {
        if(especialidades.getNome() == null || especialidades.getNome().trim().equals("")
            || especialidades.getNome().toString().length() < 3){
            throw new RegraNegocioException("Informe um Nome Válido");
        }
    }
}

//Anotações
//@Service:         ?????????????????????????????????????????????????????????????????????????????????
//@Transactional:   (Pacote Spring)     Retorna o Status do Método (Se Deu Certo, Se Deu Errado, Etc);
//@Override:        Subscreve o Método Pai (Interface);

//Classes Internas
//- Example:        Pacote Spring;
//- FindAll:        findAll(Example<S> example);

//Validar:          Salvar e Atualizar;


