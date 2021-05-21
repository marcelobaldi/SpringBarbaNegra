//Pacote, Libs, Arquivos
package github.marcelobaldi.controller;
import github.marcelobaldi.entity.Especialidades;
import github.marcelobaldi.exception.RegraNegocioException;
import github.marcelobaldi.service.EspecialidadeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

//Classe (Anotações API)
@RestController
@RequestMapping("/api/especialidades")
public class EspecialidadeController {

    //Variável e Construtor (Acesso à Classe Service)
    private EspecialidadeService especialidadeService;
    public EspecialidadeController(EspecialidadeService especialidadeService) {
        this.especialidadeService = especialidadeService;
    }

    //Método Salvar - Verbo API Post
    @PostMapping
    public ResponseEntity salvar(@RequestBody Especialidades especialidades){
        try{
            especialidadeService.salvar(especialidades);
            return new ResponseEntity(especialidades, HttpStatus.CREATED);
        } catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Método Atualizar - Verbo API PUT
    @PutMapping("{id}")
    public ResponseEntity atualizar ( @PathVariable("id") Integer id, @RequestBody Especialidades especialidades){
        return especialidadeService.buscarPorId(id).map(entity -> {
            try{
               especialidades.setId(entity.getId());
               especialidadeService.atualizar(especialidades);
               return ResponseEntity.ok(especialidades);
            }catch (RegraNegocioException e){
                return ResponseEntity.badRequest().body(e.getMessage());
            }
        }).orElseGet( () ->
                new ResponseEntity("Especialidade Não Encontrada", HttpStatus.BAD_REQUEST));
    }

    //Método Deletar - Verbo API Delete
    @DeleteMapping("{id}")
    public ResponseEntity deletar (@PathVariable("id") Integer id){
        return especialidadeService.buscarPorId(id).map(especialidade -> {
            especialidadeService.deletar(especialidade);
            return new ResponseEntity (HttpStatus.NO_CONTENT);
        }).orElseGet( () ->
                new ResponseEntity("Especialidade Não Encontrada", HttpStatus.BAD_REQUEST));
    }

    //Método Buscar (Todos) - Verbo API GET
    @GetMapping
    public ResponseEntity buscarTodos(
            @RequestParam(value = "nome", required = false) String nome){

        Especialidades especialidadesFiltro = new Especialidades();
        especialidadesFiltro.setNome(nome);

        List<Especialidades> especialidades = especialidadeService.buscar(especialidadesFiltro);
        if(especialidades.size() < 1){
            return ResponseEntity.badRequest().body("Não Há Especialidades Cadastradas");
        }else{
            return ResponseEntity.ok(especialidades);
        }
    }

    //Método Buscar (Por Id) - Verbo API GET
    @GetMapping("{id}")
    public ResponseEntity buscarPorId (@PathVariable("id") Integer id){
        return especialidadeService.buscarPorId(id).map(especialidade -> {
            especialidadeService.buscarPorId(id);
            return ResponseEntity.ok(especialidade);
        }).orElseGet( () ->
                new ResponseEntity("Especialidade Não Encontrada", HttpStatus.BAD_REQUEST));
    }
}


//Rotas
//- Cadastrar:      POST        @PostMapping
//- Atualizar:      PUT         @PutMapping("{id}")
//- Deletar:        DELETE      @DeleteMapping("{id}")
//- Buscar Todos:   GET         @GetMapping                 (Sem Param)
//- Buscar P/ ID:   GET         @GetMapping("{id}")         (1 Param)
//* Observação1:    Não Pode Rotas Iguais;
//* Observação2:    Rotas Iguais Só Se QUANTIDADE de Params Diferentes;
//* Observação3:    No Caso do GET, Se Criasse Outra Rota Com o Parametro {nome} daria Erro,
//                  pois o Que Vale é a Quantidade de Params e Não o Nome do Param;




