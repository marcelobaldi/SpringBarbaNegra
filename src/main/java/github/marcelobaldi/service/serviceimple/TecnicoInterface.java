//Pacote, Libs, Arquivos
package github.marcelobaldi.service.serviceimple;
import github.marcelobaldi.entity.Tecnicos;
import java.util.List;
import java.util.Optional;

public interface TecnicoInterface {

    //CRUD - Salvar, Atualizar, Deletar
    Tecnicos salvar (Tecnicos tecnicos);
    Tecnicos atualizar (Tecnicos tecnicos);                //Retorno Objeto
    void deletar (Tecnicos tecnicos);                     //Sem Retorno

    //CRUD - Buscar (Todos, Id, Etc)
    List<Tecnicos> buscar (Tecnicos tecnicosFiltro);       //Retorno Lista
    Optional<Tecnicos> buscarPorId(Integer id);

    //Validação
    void validarCampos(Tecnicos tecnicos);
}

//Observações
//- O Método FindById Pede Como Retorno o Tipo Optional;


