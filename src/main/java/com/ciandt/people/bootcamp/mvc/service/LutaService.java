package com.ciandt.people.bootcamp.mvc.service;

import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import com.ciandt.people.bootcamp.cleanarch.domain.exception.LutadorNotFoundException;
import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClient;
import com.ciandt.people.bootcamp.mvc.controller.model.LutadorClientMapper;
import com.ciandt.people.bootcamp.mvc.entity.Lutador;
import com.ciandt.people.bootcamp.mvc.repository.LutadorRepository;
import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModelMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class LutaService {
    public static final String LUTADOR_CAN_NOT_BE_NULL = "Lutador não pode estar vazio";
    public static final String ID_CAN_NOT_BE_NULL = "ID não pode estar vazio";
    public static final String AGE_CAN_NOT_BE_NULL = "Idade não pode estar vazia";
    @Autowired
    private LutadorRepository lutadorRepository;

    public Optional<List<Lutador>> findAll() {
        return Optional.ofNullable(LutadorModelMapper.INSTANCE.modelToEntity(lutadorRepository.findAll()));
        
    }

    public Optional<Lutador> adicionarLutador(LutadorClient lutadorClient) {
        if (null == lutadorClient) {
            log.error(LUTADOR_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(LUTADOR_CAN_NOT_BE_NULL);
        }
        Lutador lutador = LutadorClientMapper.INSTANCE.clientToEntity(lutadorClient);
        return Optional.ofNullable(LutadorModelMapper.INSTANCE.modelToEntity(lutadorRepository.save(LutadorModelMapper.INSTANCE.entityToModel(lutador))));
    }

    public Optional<Lutador> findByID(final Long id) {
        if (null == id) {
            log.error(ID_CAN_NOT_BE_NULL);
            throw new IllegalArgumentException(ID_CAN_NOT_BE_NULL);
        }
        Optional<LutadorModel> lutadorModelOptional = lutadorRepository.findById(id);
        if (lutadorModelOptional.isPresent()) {
            return Optional.ofNullable(LutadorModelMapper.INSTANCE.modelToEntity(lutadorModelOptional.get()));
        } else {
            throw new LutadorNotFoundException(id);
        }
    }

    public LutaService(LutadorRepository lutadorRepository) {
        this.lutadorRepository = lutadorRepository;
    }

	
		public Optional<List<Lutador>> findByIdade(Long idade1, Long idade2) {
	        if (null == idade1 || null == idade2) {
	            log.error(AGE_CAN_NOT_BE_NULL);
	            throw new IllegalArgumentException(AGE_CAN_NOT_BE_NULL);
	        }
	        Optional<List<LutadorModel>> lutadorModelOptional = lutadorRepository.findByIdadeBetween(Long.toString(idade1), Long.toString(idade2));
	        if (lutadorModelOptional.isPresent()&& !lutadorModelOptional.get().isEmpty()) {
	            return Optional.ofNullable(LutadorModelMapper.INSTANCE.modelToEntity(lutadorModelOptional.get()));
	        } else {
	            throw new LutadorNotFoundException(idade1, idade2);
	            
	        }
	        
	    }
}