package br.org.com.recode.clientes.controller;

import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import br.org.com.recode.clientes.model.Cliente;
import br.org.com.recode.clientes.repository.ClienteRepository;



@Controller
@RequestMapping("/cliente")
public class ClienteController {

	
	@Autowired
    private ClienteRepository clienteRepository;


//listar os dados
   @GetMapping
    public ModelAndView listar() {
        ModelAndView modelAndView = new ModelAndView("cliente/listar.html");



       List<Cliente> clientes = clienteRepository.findAll();
        modelAndView.addObject("clientes", clientes);



       return modelAndView;
    }
   
   
   // cadastrar
   
   @GetMapping("/cadastrar")
   public ModelAndView cadastrar() {
       ModelAndView modelAndView = new ModelAndView("cliente/cadastro");


      modelAndView.addObject("cliente", new Cliente());

      return modelAndView;
   }
   
   //salva as informações cadastradas e redireciona para a página cliente
   @PostMapping("/cadastrar")
   public ModelAndView cadastrar(Cliente cliente) throws IOException {
       

     // try {
     //      cliente.setImagem(file.getBytes());
     //  } catch (IOException e) {
      //     e.printStackTrace();
     //  }    
       
       
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");
       clienteRepository.save(cliente);

      return modelAndView;
   }
   
   //imagem
   
  // @GetMapping("/imagem/{id}")
  // @ResponseBody
  // public byte[] exibirImagen(@PathVariable("id") Long id) {
   //    Cliente cliente = this.clienteRepository.getOne(id);
   //    return cliente.getImagem();
 //  }
   // nova rota
   
   @GetMapping("/{id}")
   public ModelAndView detalhar(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("cliente/detalhar.html");



      Cliente cliente = clienteRepository.getOne(id);
       modelAndView.addObject("cliente", cliente);

      return modelAndView;
   }
   
   //excluir - rota
   
   @GetMapping("/{id}/excluir")
   public ModelAndView excluir(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");


      clienteRepository.deleteById(id);

      return modelAndView;
   }
   
   //editar - rota
   @GetMapping("/{id}/editar")
   public ModelAndView editar(@PathVariable Long id) {
       ModelAndView modelAndView = new ModelAndView("cliente/edicao");

      Cliente cliente = clienteRepository.getOne(id);
       modelAndView.addObject("cliente", cliente);

      return modelAndView;
   }
 
   
   //botão ''salvar'' na página ''editar''- manda pro banco e atualiza
   
   @PostMapping("/{id}/editar")
   public ModelAndView editar(Cliente cliente) {
       ModelAndView modelAndView = new ModelAndView("redirect:/cliente");

      clienteRepository.save(cliente);

      return modelAndView;
      
   }
}