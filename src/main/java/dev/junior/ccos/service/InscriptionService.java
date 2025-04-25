package dev.junior.ccos.service;

import dev.junior.ccos.service.dto.InscriptionDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * Service Interface for managing {@link dev.junior.ccos.domain.Inscription}.
 */
public interface InscriptionService {
    /**
     * Save a inscription.
     *
     * @param inscriptionDTO the entity to save.
     * @return the persisted entity.
     */
    InscriptionDTO save(InscriptionDTO inscriptionDTO);

    /**
     * Updates a inscription.
     *
     * @param inscriptionDTO the entity to update.
     * @return the persisted entity.
     */
    InscriptionDTO update(InscriptionDTO inscriptionDTO);

    /**
     * Partially updates a inscription.
     *
     * @param inscriptionDTO the entity to update partially.
     * @return the persisted entity.
     */
    Optional<InscriptionDTO> partialUpdate(InscriptionDTO inscriptionDTO);

    /**
     * Get all the inscriptions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<InscriptionDTO> findAll(Pageable pageable);

    /**
     * Get the "id" inscription.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<InscriptionDTO> findOne(Long id);

    /**
     * Delete the "id" inscription.
     *
     * @param id the id of the entity.
     */
    void delete(Long id);
}
