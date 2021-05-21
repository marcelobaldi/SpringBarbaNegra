//Pacote, Libs, Arquivos, Etc
package github.marcelobaldi.repository;
import github.marcelobaldi.entity.Tecnicos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

//Classe Interface
public interface TecnicoDAO extends JpaRepository<Tecnicos, Integer> {

    //Buscar - Específico e Ignorar Case Sensitive (Por Email)
    @Query(value="select c from Tecnicos c where c.email = :email")
    Tecnicos buscarPorEmail(@Param("email") String email);

    //Buscar - Contém (Por Nome)
    @Query(value="select c from Tecnicos c where c.nome like concat('%', :nome, '%')")
    List<Tecnicos> buscarPorNomeContem(@Param("nome") String nome);

}

//** Tem Que Ser o Nome da Classe (Tecnicos e não tecnicos) !!!!!!!!!

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





