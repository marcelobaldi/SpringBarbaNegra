//Pacote, Libs, Arquivos
package github.marcelobaldi.entity;
import javax.persistence.*;

//Classe (Anotações Entidade)
@Entity                                                     //Banco Dados       (Tabela)
@Table(name="especialidades", schema = "arius")             //Nome              (Tabela e BD)
public class Especialidades {                                //Classe            (Acesso e Nome)

    //Campo - ID
    @Id                                                     //Obrigatório       (Quando Entidade)
    @GeneratedValue(strategy = GenerationType.IDENTITY)     //Preenchimento     (Auto Incremento)
    @Column(name = "id")                                    //Nome              (Campo na Tabela)
    private Integer id;                                     //Variável          (Acesso, Tipo, Nome)

    //Campo - Nome
    @Column(name = "nome", length = 100)
    private String nome;

    //Construtores                                          //Acessar Classe    (Vazio, SemId, ComId)
    public Especialidades() { }
    public Especialidades(String nome) { this.nome = nome; }
    public Especialidades(Integer id, String nome) { this.id = id; this.nome = nome; }

    //GetterSetter                                          //Acessar Atributos (Quando Private)
    public Integer getId() { return id; }
    public void setId(Integer id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    //Conversão - String                                    //Facilitar Debug   (Lista - ForEach)
    @Override
    public String toString() {
        return "Especialidades {" + "id=" + id + ", nome='" + nome + '\'' + '}';
    }
}

//Classe:
//- Nome:       Primeiras Maiúsculas e Nome no Singular;
//- Entity:     Anotação Para Identificar Que Além de Model Também é uma Tabela;
//- Tabel:      Para Dar Nome a Tabela;
//- Observ1:    Recomendável o Nome do Arquivo Ser o Nome da Classe, Mas Como Aqui
//              No Spring o Entity (Model) Também é o Nome da Tabela, Então Não é
//              Comum Colocar "ClienteModel", mas Só Cliente. Há Linguagem Que Usa Isso;

//Variáveis - Campo
//- Id:         Identificar o Registro      (Atualizar, Deletar)
//- Nome:       Busca Contém                (Listagem)
//- Email:      Busca Específica            (Não Duplicar Registro)
//- Idade:      Campo Diferente de String   (Manipular Outros Tipos)

//Variáveis - Tipo
//- Geral:      Utilizar Classes (Ex: Integer e Não int), Senão Alguns Recursos darão Pau;
//- Decimal:    BigDecimal (ao invés do Double);
//- Inteiro:    Integer ou Long (se números grandes);

//Variáveis - Outros
//- Acesso:     Obrigatório Identificar (Private, Protected, Public). A Convenção é Private;
//- Column:     Anotação Necessária Quando Utilização do JPA. O JDBC Não Precisa;
//- NotEmpty:   Anotação Para Tratar Campos Vazios (Strings ...);
//- NotNull:    Anotação Para Tratar Campos Vazios (Números ...). Importar da Classe Javax.Validation;
//- CPF:        Anotação Para Tratar Campos CPF;

//Campo Id:
//- Nome:       Obrigatório Este Campo Quando Banco Dados;
//- Anotação:   Obrigatório Esta Anotação (@Id)
//- AutoIncre:  GenerationType.IDENTITY   (O .AUTO Funciona, Mas Quando Usar o MySQL Dará Pau);

//Construtores:
//- Tipos:      Vazio, Preenchido Sem ID, Preenchido Com Id;
//- Nomes:      Sãos os Mesmos Nomes da Classe. Outras Linguagens Cada um é um Nome (Separado Por Ponto);
//- Otimizado:  Não Aceita o Modo Otimizado (this.nome nos Parametros. Outras Linguagens Sim;

//GetterSetter:
//- Acesso:     (Condicional)   Só se Atributos Private, Para Poder Acessá-los;

//Conversores:
//- P/ String:  (Opcinal)       Facilita Ver os Valores dos Objetos (Comando ForEach ...);
//- P/ Map:     (Opcional)      Evita Repetições Quando For Preciso Converter Uma Classe Para Map;
//- P/ Classe:  (Opcional)      Evita Repetições Quando For Preciso Converter Um Objeto Para a Classe;

//Códigos Prontos:
//- BD / Generate:      Construtores, GetterSetter, ToString, Etc;

