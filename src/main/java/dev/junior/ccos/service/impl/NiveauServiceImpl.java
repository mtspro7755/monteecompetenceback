package dev.junior.ccos.service.impl;

import dev.junior.ccos.domain.Niveau;
import dev.junior.ccos.repository.NiveauRepository;
import dev.junior.ccos.service.NiveauService;
import dev.junior.ccos.service.dto.NiveauDTO;
import dev.junior.ccos.service.mapper.NiveauMapper;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Service Implementation for managing {@link dev.junior.ccos.domain.Niveau}.
 */
@Service
@Transactional
public class NiveauServiceImpl implements NiveauService {

    private final Logger log = LoggerFactory.getLogger(NiveauServiceImpl.class);

    private final NiveauRepository niveauRepository;

    private final NiveauMapper niveauMapper;

    public NiveauServiceImpl(NiveauRepository niveauRepository, NiveauMapper niveauMapper) {
        this.niveauRepository = niveauRepository;
        this.niveauMapper = niveauMapper;
    }

    @Override
    public NiveauDTO save(NiveauDTO niveauDTO) {
        log.debug("Request to save Niveau : {}", niveauDTO);
        Niveau niveau = niveauMapper.toEntity(niveauDTO);
        niveau = niveauRepository.save(niveau);
        return niveauMapper.toDto(niveau);
    }

    @Override
    public NiveauDTO update(NiveauDTO niveauDTO) {
        log.debug("Request to update Niveau : {}", niveauDTO);
        Niveau niveau = niveauMapper.toEntity(niveauDTO);
        niveau = niveauRepository.save(niveau);
        return niveauMapper.toDto(niveau);
    }

    @Override
    public Optional<NiveauDTO> partialUpdate(NiveauDTO niveauDTO) {
        log.debug("Request to partially update Niveau : {}", niveauDTO);

        return niveauRepository
            .findById(niveauDTO.getId())
            .map(existingNiveau -> {
                niveauMapper.partialUpdate(existingNiveau, niveauDTO);

                return existingNiveau;
            })
            .map(niveauRepository::save)
            .map(niveauMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Page<NiveauDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Niveaus");
        return niveauRepository.findAll(pageable).map(niveauMapper::toDto);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<NiveauDTO> findOne(Long id) {
        log.debug("Request to get Niveau : {}", id);
        return niveauRepository.findById(id).map(niveauMapper::toDto);
    }

    @Override
    public void delete(Long id) {
        log.debug("Request to delete Niveau : {}", id);
        niveauRepository.deleteById(id);
    }
}
