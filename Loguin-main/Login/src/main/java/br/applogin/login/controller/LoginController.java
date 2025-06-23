package br.applogin.login.controller;

import br.applogin.login.model.Usuario;
import br.applogin.login.repository.UsuarioRepository;
import br.applogin.login.service.CookieService;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping
public class LoginController {

    @Autowired
    private UsuarioRepository ur;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request, Model model) {
        System.out.println("=== ACESSANDO DASHBOARD ===");
        String usuarioNome = CookieService.getCookie(request, "usuarioNome");
        System.out.println("Nome do usuário recuperado do cookie: " + usuarioNome);

        if (usuarioNome != null) {
            model.addAttribute("nomeUsuario", usuarioNome);
            System.out.println("Dashboard sendo renderizada para: " + usuarioNome);
            return "dashboard";
        }

        System.out.println("Usuário não autenticado, redirecionando para login");
        return "redirect:/login";
    }

    @PostMapping("/logar")
    public String loginUsuario(Usuario usuario, Model model, HttpServletResponse response) {
        try {
            System.out.println("=== INÍCIO DO PROCESSO DE LOGIN ===");
            Usuario usuarioLogado = this.ur.login(usuario.getEmail(), usuario.getSenha());

            if (usuarioLogado != null) {
                System.out.println("Usuário encontrado: " + usuarioLogado.getNome());
                System.out.println("Configurando cookies...");

                // Garanta que o nome não está vazio
                String nomeUsuario = usuarioLogado.getNome() != null ? usuarioLogado.getNome() : "Usuario";

                CookieService.setCookie(response, "usuarioId", String.valueOf(usuarioLogado.getId()), 3600);
                CookieService.setCookie(response, "usuarioNome", nomeUsuario, 3600);

                System.out.println("Cookies configurados!");
                System.out.println("Redirecionando para dashboard...");

                // Adicione os dados ao model antes do redirecionamento
                model.addAttribute("nomeUsuario", nomeUsuario);
                model.addAttribute("mensagem", "Login realizado com sucesso!");

                return "dashboard"; // Tente usar direto ao invés de redirect
            }

            System.out.println("Usuário não encontrado");
            model.addAttribute("erro", "Usuário ou senha inválidos!");
            return "login";

        } catch (Exception e) {
            System.out.println("Erro no login: " + e.getMessage());
            e.printStackTrace();
            model.addAttribute("erro", "Erro ao realizar login!");
            return "login";
        }
    }

    @PostMapping("/sair")
    public String sair(HttpServletResponse response) {
        System.out.println("====== REALIZANDO LOGOUT ======");
        CookieService.setCookie(response, "usuarioId", "", 0);
        CookieService.setCookie(response, "usuarioNome", "", 0);
        System.out.println("Cookies removidos");
        return "redirect:/login";
    }


    @GetMapping("/cadastroUsuario")
    public String cadastr() {
        return "cadastro";
    }

    @RequestMapping(value = "/cadastroUsuario", method = RequestMethod.POST)
    public String cadastroUsuario(@Valid Usuario usuario, BindingResult result) {
        if (result.hasErrors()) {
            return "redirect:/cadastroUsuario";  // Corrigido o erro de digitação
        }

        ur.save(usuario);
        return "redirect:/login";
    }
}