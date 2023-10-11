package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.M_Interruptor;
import ChamadasLeitos.chamadas.Model.M_Registro;
import ChamadasLeitos.chamadas.Service.S_Interruptor;
import ChamadasLeitos.chamadas.Service.S_Interruptor_Implements;
import ChamadasLeitos.chamadas.Service.S_Interruptor_Interface;
import ChamadasLeitos.chamadas.Service.S_Registro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class C_Interruptor {

    @Autowired
    private S_Interruptor S_Interruptor;

    @Autowired
    private S_Interruptor_Implements s_interruptor_implements;

    @Autowired
    private S_Interruptor_Interface s_interruptor_interface;

    @Autowired
    private S_Registro s_registro;

    @GetMapping("/simulacao")
    public String listarInterruptores(Model model) {
        List<M_Interruptor> interruptores = S_Interruptor.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        model.addAttribute("modoSimulacao", true); // Defina como 'false' quando a comunicação com o Arduino estiver estabelecida.
        return "simulacao";
    }

    @GetMapping("/chamados")
    public String paginaSecundaria(Model model) {
        List<M_Interruptor> interruptores = S_Interruptor.listarInterruptores();
        model.addAttribute("interruptores", interruptores);
        return "/chamados";
    }

    @PostMapping("/simulacao")
    public String alterarEstado(@RequestParam String interruptorNome) {
        S_Interruptor.alterarEstado(interruptorNome);

        M_Registro M_Registro = new M_Registro();

        M_Registro.setData_hora(LocalDateTime.now());
//        s_registro.salvarRegistro(M_Registro);

        return "redirect:/simulacao";
    }

    @GetMapping("/relatorio")
    public String exibirRelatorio(Model model) {
        // Aqui você deve buscar todos os registros do serviço
        List<M_Registro> registros = s_registro.listarTodosRegistros();
        model.addAttribute("registros", registros);
        return "/relatorio"; // Nome do arquivo HTML da página de relatório
    }

    @GetMapping("/showInterruptor")
    public String viewHomePageInterruptor(Model model){
        return findPaginatedInterruptor(1,"interruptor","asc", model);
    }

    @GetMapping("/showNewInterruptorForm")
    public String showNewInterruptorForm(Model model){
        M_Interruptor m_interruptor = new M_Interruptor();
        model.addAttribute("interruptor", m_interruptor);
        return "New_Interruptor/new_interruptor";
    }

    @PostMapping("/saveInterruptor")
    public String saveInterruptor(@RequestParam String interruptor, @RequestParam boolean estado,
                                  @RequestParam String setor){
        M_Interruptor m_interruptor = new M_Interruptor();
        m_interruptor.setInterruptor(interruptor);
        m_interruptor.setEstado(estado);
        m_interruptor.setSetor(setor);

        s_interruptor_interface.saveInterruptor(m_interruptor);
        return "redirect:/showInterruptor";
    }

    @GetMapping("/showFormForUpdateInterruptor/{id}")
    public String showFormForUpdateInterruptor(@PathVariable(value = "id")long id, Model model){
        M_Interruptor m_interruptor = s_interruptor_interface.getInterruptorById(id);

        if(m_interruptor != null){
            model.addAttribute("interruptor", m_interruptor);
            return "Update_Interruptor/update_interruptor";

        } else {
            return "redirect:/showInterruptor";
        }
    }

    @PostMapping("/updateInterruptor/{id}")
    public String updateInterruptor(@PathVariable(value = "id") long id,
                                    @RequestParam String interruptor, @RequestParam boolean estado,
                                    @RequestParam String setor){
        M_Interruptor interruptorExistente = s_interruptor_interface.getInterruptorById(id);

        if (interruptorExistente != null){
            interruptorExistente.setInterruptor(interruptor);
            interruptorExistente.setEstado(estado);
            interruptorExistente.setSetor(setor);

            s_interruptor_interface.saveInterruptor(interruptorExistente);

            return "redirect:/showInterruptor";

        } else {
            return "ID não encontrado";
        }

    }

    @GetMapping("/deleteInterruptor/{id}")
    public String deleteInterruptor(@PathVariable (value = "id")long id){
        this.s_interruptor_interface.deleteInterruptorById((Long)id);
        return "redirect:/showInterruptor";
    }

    @GetMapping("/pageInterruptor/{pageNo}")
    public String findPaginatedInterruptor(@PathVariable (value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir")String sortDir,
                                           Model model){
        int pageSize = 10;

        Page<M_Interruptor> pageInterruptor = s_interruptor_interface.findPaginatedInterruptor(pageNo, pageSize, sortField, sortDir);
        List<M_Interruptor>listInterruptor = pageInterruptor.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageInterruptor.getTotalPages());
        model.addAttribute("totalItems", pageInterruptor.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listInterruptor", listInterruptor);
        return "Interruptor/interruptor";
    }



}
