package dev.junior.ccos.service.impl;

import dev.junior.ccos.domain.Formation;
import dev.junior.ccos.repository.FormationRepository;
import dev.junior.ccos.service.FormationService;
import dev.junior.ccos.service.dto.FormationDTO;
import dev.junior.ccos.service.mapper.FormationMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link dev.junior.ccos.domain.Formation}.
 */
@Service
@Transactional
public class FormationServiceImpl implements FormationService {

    private final Logger log = LoggerFactory.getLogger(FormationServiceImpl.class);

    private final FormationRepository formationRepository;

    private final FormationMapper formationMapper;

    public FormationServiceImpl(FormationRepository formationRepository, FormationMapper formationMapper) {
        this.formationRepository = formationRepository;
        this.formationMapper = formationMapper;
    }

    @Override
    public FormationDTO save(FormationDTO formationDTO) {
        log.debug("Request to save Formation : {}", formationDTO);
        Formation formation = formationMapper.toEntity(formationDTO);
        formation = formationRepository.save(formation);
        return formationMapper.toDto(formation);
    }

    @Override
    public FormationDTO update(FormationDTO formationDTO) {
        log.debug("Request to update Formation : {}", formationDTO);
        Formation formation = formationMapper.toEntity(formationDTO);
        formation = formationRepository.save(formation);
        return formationMapper.toDto(formation);
    }

    @Override
    public Optional<FormationDTO> partialUpdate(FormationDTO formationDTO) {
        log.debug("Request to partially update Formation : {}", formationDTO);

        return formationRepository
            .findById(formationDTO.getId())
            .map(existingFormation -> {
                formationMapper.partialUpdate(existingFormation, formationDTO);

                return existingFormation;
            })
            .map(formationRepository::save)
            .map(formationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<FormationDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Formations");
        return formationRepository.findAll(pageable).map(formationMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<FormationDTO> findOne(Long id) {
        log.debug("Request to get Formation : {}", id);
        return formationRepository.findById(id).map(formationMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Formation : {}", id);
        formationRepository.deleteById(id);
    }
}
