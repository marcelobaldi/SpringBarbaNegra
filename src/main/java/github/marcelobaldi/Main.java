//Pacote, Libs, Arquivos, Etc
package github.marcelobaldi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@RestController
@EnableWebMvc
public class Main implements WebMvcConfigurer {

    //Habilitar receber requisjição. (esta todos). Mas poderia conf. para receber de um end. específico
    @Override
    public void addCorsMappings(CorsRegistry registry){
        registry.addMapping("/**").allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS");
    }

    //Método - Inicial
    public static void main(String[] args) {
        SpringApplication.run(Main.class,args);
    }
}

//mvc ... funcionar o axios (requisição htpp)



//Estrutura
//- BD - BD e Conexão:        Application.Properties;
//- BD - Tabela e Campos:     Entity                  (que também é uma Model);
//- BD - CRUD na Tabela:      Repository/Database     (Executa o CRUD no Database);
//- BD - CRUD na Tabela:      Service                 (Chama o CRUD)
//- Objetos Manipulados:      Entity                  (que também é a Tabela do BD);
//- Requisições HTTP:         ApiRest

//Fluxo
//- ApiRest             Recebe Dados do FrontEnd    e   Envia Para o Service
//- Service             Recebe Dados da ApiRest     e   Envia Para o Repository
//- Repository          Executa o CRUD no BD
//* Estrutura BD        Application.Properties e Entity
//* Tratamento Erro     Exception
//* Lib's Projeto       Pom.xml
//* Arquivo Inicial     Main

//////////////////////////////////////////////////////////////////////

//Tratamento Erros
//- Campos Nulos (Não Vindos)
//- Campos Vazios/Espaço Branco
//- Tamanho Caracteres:
//- Registro Não Encontrado:
//- Registro Já Cadastrado:         Ignorando CaseSensitive;
//- Id do Registro Cadastrado:

//////////////////////////////////////////////////////////////////////

//Observações
//- Exception:  Poderia uma Lista de Erros (Com Todos os Erros), e Não uma Mensagem (Apenas 1 Erro);
//- Service:    Há 1 Interface e 1 Classe, Mas Poderia Ter Só a Classe para otimizar mais o código;

//Dúvidas/Depois:
//- Projeto:    Relacionamento de Tabelas;
//- Model:      Equals HashCode;
//- Model:      Todos os Campos (Data, Etc);
//- Model:      Lib Lombok (mais otimizado o model);

//Dúvidas
//- Como Fazer Este Projeto Usando a Classe API ResponseStatus, e Não API ResponseEntity?
//- Como Usar a Bean Validation Aqui (Anotação Message na Model e Anotação Valid na API)?

