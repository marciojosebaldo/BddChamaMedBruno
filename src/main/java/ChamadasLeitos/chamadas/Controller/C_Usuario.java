package ChamadasLeitos.chamadas.Controller;


import ChamadasLeitos.chamadas.Model.M_Resposta;
import ChamadasLeitos.chamadas.Model.M_Usuario;
import ChamadasLeitos.chamadas.Service.S_Usuario_Implements;
import ChamadasLeitos.chamadas.Service.S_Usuario_Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
@Controller
public class C_Usuario {

    @Autowired
    private S_Usuario_Interface s_usuario_interface;

    @GetMapping("/showUsuario")
    public String viewHomePageUsuario(Model model){
        return findPaginatedUsuario(1,"nome","asc", model);
    }

    @GetMapping("/showNewUsuarioForm")
    public String showNewUsuarioForm(Model model){
        M_Usuario m_usuario = new M_Usuario();
        model.addAttribute("usuario", m_usuario);
        return "New_Usuario/new_usuario";
    }

//    @PostMapping("/saveUsuario")
//    public String saveUsuario(@RequestParam String nome,
//                              @RequestParam Long matricula,
//                              @RequestParam Long cargo,
//                              @RequestParam boolean ativo){
//        M_Usuario m_usuario = new M_Usuario();
//        m_usuario.setNome(nome);
//        m_usuario.setMatricula(matricula);
//        m_usuario.setCargo(cargo);
//        m_usuario.setAtivo(ativo);
//
//        s_usuario_interface.saveUsuario(m_usuario);
//        return "redirect:/showUsuario";
//    }

    @PostMapping("/saveUsuario")
    public String saveUsuario(@RequestParam("nome") String nome,
                              @RequestParam("matricula")  String matricula,
                              @RequestParam("cargo")  String cargo,
                              RedirectAttributes redirectAttributes){
        M_Resposta m_resposta = S_Usuario_Implements.cadastrarUsuario(nome, matricula, cargo);
        if (m_resposta.getStatus()){
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            return "redirect:/showUsuario";
        } else {
            redirectAttributes.addFlashAttribute("mensagem", m_resposta.getMensagem());
            redirectAttributes.addFlashAttribute("nome", nome);
            redirectAttributes.addFlashAttribute("matricula", matricula);
            redirectAttributes.addFlashAttribute("cargo", cargo);
            return "redirect:/showNewUsuarioForm";
        }
    }

    @GetMapping("/showFormForUpdateUsuario/{id}")
    public String showFormForUpdateUsuario(@PathVariable(value = "id")long id, Model model){
        M_Usuario m_usuario = s_usuario_interface.getUsuarioById(id);

        if(m_usuario != null){
            model.addAttribute("usuario", m_usuario);
            return "Update_Usuario/update_usuario";

        } else {
            return "redirect:/showUsuario";
        }
    }

    @PostMapping("/updateUsuario/{id}")
    public String updateUsuario(@PathVariable(value = "id") long id,
                                @RequestParam String nome,
                                @RequestParam Long matricula,
                                @RequestParam Long cargo){
        M_Usuario usuarioExistente = s_usuario_interface.getUsuarioById(id);

        if (usuarioExistente != null){
            usuarioExistente.setNome(nome);
            usuarioExistente.setMatricula(matricula);
            usuarioExistente.setCargo(cargo);

            s_usuario_interface.saveUsuario(usuarioExistente);

            return "redirect:/showUsuario";

        } else {
            return "ID não encontrado";
        }
    }

    @GetMapping("/deleteUsuario/{id}")
    public String deleteUsuario(@PathVariable (value = "id")long id){
        this.s_usuario_interface.deleteUsuarioById((Long)id);
        return "redirect:/showUsuario";
    }

    @GetMapping("/pageUsuario/{pageNo}")
    public String findPaginatedUsuario(@PathVariable (value = "pageNo") int pageNo,
                                           @RequestParam("sortField") String sortField,
                                           @RequestParam("sortDir")String sortDir,
                                           Model model){
        int pageSize = 10;

        Page<M_Usuario> pageUsuario = s_usuario_interface.findPaginatedUsuario(pageNo, pageSize, sortField, sortDir);
        List<M_Usuario> listUsuario = pageUsuario.getContent();

        model.addAttribute("currentPage", pageNo);
        model.addAttribute("totalPages", pageUsuario.getTotalPages());
        model.addAttribute("totalItems", pageUsuario.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listUsuario", listUsuario);
        return "Usuario/usuario";
    }
}
