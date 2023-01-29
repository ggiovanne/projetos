package com.ciandt.people.bootcamp.cleanarch.interfaceadapter;

import com.ciandt.people.bootcamp.cleanarch.businessrule.AddLutador;
import com.ciandt.people.bootcamp.cleanarch.businessrule.FindAllLutadores;
import com.ciandt.people.bootcamp.cleanarch.businessrule.FindLutadorById;
import com.ciandt.people.bootcamp.cleanarch.businessrule.UpdateLutador;
import com.ciandt.people.bootcamp.cleanarch.domain.Lutador;
import com.ciandt.people.bootcamp.mvc.repository.LutadorRepository;
import com.ciandt.people.bootcamp.mvc.repository.model.LutadorModel;
import com.ciandt.people.bootcamp.cleanarch.interfaceadapter.repository.model.LutadorModelMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Slf4j
@Component
@RequiredArgsConstructor
public class LutadorGateway implements FindAllLutadores, AddLutador, FindLutadorById, UpdateLutador {
    private final LutadorRepository lutadorRepository;

	@Override
	public List<Lutador> findAll() {
		return LutadorModelMapper.INSTANCE.modelToEntity(lutadorRepository.findAll());
	}

	@Override
	public Lutador AddLutador(Lutador lutador) {
		return LutadorModelMapper.INSTANCE.modelToEntity(lutadorRepository.save(LutadorModelMapper.INSTANCE.entityToModel(lutador)));
	}


	@Override
	public Optional<Lutador> findById(Long id) {
		Optional<LutadorModel> lutadorModelOptional = lutadorRepository.findById(id);
		LutadorModel lutadorModel = null;
		if (lutadorModelOptional.isPresent()) {
			lutadorModel = lutadorModelOptional.get();
		}
		return Optional.ofNullable(LutadorModelMapper.INSTANCE.modelToEntity(lutadorModel));
	}

	@Override
	public Lutador update(Lutador lutador) {
		return null;
	}
}
