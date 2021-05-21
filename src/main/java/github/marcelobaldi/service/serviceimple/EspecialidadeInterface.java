//Pacote, Libs, Arquivos, Etc
package github.marcelobaldi.service.serviceimple;
import github.marcelobaldi.entity.Especialidades;
import java.util.List;
import java.util.Optional;

//Classe Interface
public interface EspecialidadeInterface {

    //CRUD - Salvar, Atualizar, Deletar
    Especialidades salvar (Especialidades especialidades);
    Especialidades atualizar (Especialidades especialidades);                  //Retorno Objeto
    void deletar (Especialidades especialidades);                             //Sem Retorno

    //CRUD - Buscar (Todos, Id, Etc)
    List<Especialidades> buscar (Especialidades especialidadesFiltro);         //Retorno Lista
    Optional<Especialidades> buscarPorId(Integer id);

    //Validação
    void validarCampos(Especialidades especialidades);
}

//Observações
//- O Método FindById Pede Como Retorno o Tipo Optional;


