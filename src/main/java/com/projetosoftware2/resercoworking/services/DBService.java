package com.projetosoftware2.resercoworking.services;

import com.projetosoftware2.resercoworking.domain.*;
import com.projetosoftware2.resercoworking.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.HashSet;
import java.util.Set;

/**
 */
@Service
public class DBService {

    @Autowired
    private BCryptPasswordEncoder pe;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PerfilRepository perfilRepositoy;

    @Autowired
    private PremiacaoRepository premiacaoRepository;

    @Autowired
    private ModalidadeEspacoRepository modalidadeEspacoRepository;

    @Autowired
    private EspacoRepository espacoRepository;

    @Autowired
    private PaisRepository paisRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private BairroRepository bairroRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    public void instantiateTestDatabase() throws ParseException {
        Perfil perfil = new Perfil();
        perfil.setId(1L);
        perfil.setNome("Administrador");
        perfil.setDescricao("Administrador da Aplicação");

        Pais pais = new Pais();
        pais.setId(1L);
        pais.setNome("Brasil");
        paisRepository.save(pais);

        Estado estado = new Estado();
        estado.setId(1L);
        estado.setUf("SC");
        estado.setNome("Santa Catarina");
        estado.setPais(pais);
        estadoRepository.save(estado);

        Cidade cidade = new Cidade();
        cidade.setId(1L);
        cidade.setNome("Blumenau");
        cidade.setEstado(estado);
        cidadeRepository.save(cidade);

        Bairro bairro = new Bairro();
        bairro.setId(1L);
        bairro.setNome("Vorstadt");
        bairro.setCidade(cidade);
        bairroRepository.save(bairro);

        Endereco endereco = new Endereco();
        endereco.setId(1L);
        endereco.setRua("Rua Pedro Krauss Senior");
        endereco.setBairro(bairro);
        enderecoRepository.save(endereco);

        Usuario usuario = new Usuario();
        usuario.setId(1L);
        usuario.setNome("Filipe Tobias");
        usuario.setEmail("tobias.filipe@gmail.com");
        usuario.setSenha(pe.encode("123"));
        usuario.setEndereco(endereco);
        Set<Perfil> set = new HashSet<>();
        set.add(perfil);
        usuario.setPerfis(set);

        perfilRepositoy.save(perfil);
        usuarioRepository.save(usuario);

        Premiacao premiacao = new Premiacao();
        premiacao.setId(1L);
        premiacao.setNome("Teste");
        premiacao.setDescricao("Teste");
        premiacao.setSituacao(true);
        premiacao.setPontosNecessarios(50);
        premiacaoRepository.save(premiacao);

        ModalidadeEspaco modalidadeEspaco = new ModalidadeEspaco();
        modalidadeEspaco.setId(1L);
        modalidadeEspaco.setNome("Teste");
        modalidadeEspaco.setDescricao("Teste");
        modalidadeEspaco.setSituacao(true);
        modalidadeEspacoRepository.save(modalidadeEspaco);

        Espaco espaco = new Espaco();
        espaco.setId(1L);
        espaco.setNome("Teste Espaço");
        espaco.setDescricao("Teste Espaço");
        espaco.setQuantidadePontos(50);
        espaco.setNota(10.0);
        espaco.setMetrosQuadrados(25.0);
        espaco.setSituacao(true);
        espaco.setModalidadeEspaco(modalidadeEspaco);
        espaco.setValorHora(25.0);
        espacoRepository.save(espaco);
    }
}
