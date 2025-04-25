package dev.junior.ccos.service.mapper;

import dev.junior.ccos.domain.AnneeAcademique;
import dev.junior.ccos.domain.Etudiant;
import dev.junior.ccos.domain.Formation;
import dev.junior.ccos.domain.Inscription;
import dev.junior.ccos.domain.Niveau;
import dev.junior.ccos.service.dto.AnneeAcademiqueDTO;
import dev.junior.ccos.service.dto.EtudiantDTO;
import dev.junior.ccos.service.dto.FormationDTO;
import dev.junior.ccos.service.dto.InscriptionDTO;
import dev.junior.ccos.service.dto.NiveauDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Inscription} and its DTO {@link InscriptionDTO}.
 */
@Mapper(componentModel = "spring")
public interface InscriptionMapper extends EntityMapper<InscriptionDTO, Inscription> {
    @Mapping(target = "etudiant", source = "etudiant", qualifiedByName = "etudiantId")
    @Mapping(target = "niveau", source = "niveau", qualifiedByName = "niveauId")
    @Mapping(target = "anneeAcademique", source = "anneeAcademique", qualifiedByName = "anneeAcademiqueId")
    @Mapping(target = "formation", source = "formation", qualifiedByName = "formationId")
    InscriptionDTO toDto(Inscription s);

    @Named("etudiantId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    EtudiantDTO toDtoEtudiantId(Etudiant etudiant);

    @Named("niveauId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    NiveauDTO toDtoNiveauId(Niveau niveau);

    @Named("anneeAcademiqueId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    AnneeAcademiqueDTO toDtoAnneeAcademiqueId(AnneeAcademique anneeAcademique);

    @Named("formationId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    FormationDTO toDtoFormationId(Formation formation);
}
