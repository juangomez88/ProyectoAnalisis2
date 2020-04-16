package com.udea.example.rtf.service;

import com.udea.example.rtf.dto.UsuarioDto;
import com.udea.example.rtf.entity.Usuario;
import com.udea.example.rtf.repository.UsuarioRepository;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsuarioService.class);

    private UsuarioRepository usuarioRepository;

    private ModelMapper modelMapper;


    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper modelMapper) {
        this.usuarioRepository = usuarioRepository;
        this.modelMapper = modelMapper;
    }

    public UsuarioDto create(UsuarioDto personToCreateDto) {
        LOGGER.debug("Begin create: personToCreateDto={}", personToCreateDto);

        Usuario usuarioToCreate = modelMapper.map(personToCreateDto, Usuario.class);
        Usuario result = usuarioRepository.save(usuarioToCreate);
        UsuarioDto resultDTO = modelMapper.map(result, UsuarioDto.class);

        LOGGER.debug("End create: resultDTO={}", resultDTO);
        return resultDTO;
    }

    public List<UsuarioDto> findAll() {
        List<Usuario> listPeople = (List<Usuario>) usuarioRepository.findAll();
        return listPeople.stream()
                .map(usuario -> modelMapper.map(usuario, UsuarioDto.class))
                .collect(Collectors.toList());
    }

    public UsuarioDto findById(Long id) {
        Optional<Usuario> findPersonOptional = usuarioRepository.findById(id);
        Usuario findUsuario = findPersonOptional.orElseThrow(EntityNotFoundException::new);
        return modelMapper.map(findUsuario, UsuarioDto.class);
    }

    public void delete(Long id) {
        UsuarioDto personInDb = findById(id);
        Usuario usuarioToDelete = modelMapper.map(personInDb, Usuario.class);
        usuarioRepository.delete(usuarioToDelete);
    }

    public UsuarioDto update(UsuarioDto usuarioDto) {
        findById(usuarioDto.getId());
        return create(usuarioDto);
    }


}
