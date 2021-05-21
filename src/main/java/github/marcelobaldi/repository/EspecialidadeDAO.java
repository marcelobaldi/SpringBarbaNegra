//Pacote, Libs, Arquivos, Etc
package github.marcelobaldi.repository;
import github.marcelobaldi.entity.Especialidades;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//Classe Interface
public interface EspecialidadeDAO extends JpaRepository<Especialidades, Integer> {

    //Buscar - Contém (Por Nome)
    @Query(value="select c from Especialidades c where c.nome like concat('%', :nome, '%')")
    List<Especialidades> buscarPorNomeContem(@Param("nome") String nome);

}

//Aprender Mais Query!!!

//Classe Interface
//- Extendes:               Da Classe Interna JpaRepository;
//- Entity:                 Da Referida Model/Tabela;
//- ID Entity:              Usar Integer e Não Int;
//- Obs:                    Se o Id Fosse Long, Então Seria Long;

//Métodos Básicos
//- São Implementados Automaticamente
//- Cadastrar:              Save
//- Atualizar:              Save
//- Deletar:                Delete
//- Buscar Todos/Contem:    FindAll
//- Buscar Por Id:          FindById    (Pede Como Retorno o Tipo Optional)

//Métodos Específicos
//- Devem Ser Criados Aqui, Como Uma Busca Por Nome;





