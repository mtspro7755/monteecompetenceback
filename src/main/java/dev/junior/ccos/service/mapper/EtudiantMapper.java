package dev.junior.ccos.service.mapper;

import dev.junior.ccos.domain.Etudiant;
import dev.junior.ccos.domain.User;
import dev.junior.ccos.service.dto.EtudiantDTO;
import dev.junior.ccos.service.dto.UserDTO;
import org.mapstruct.*;

/**
 * Mapper for the entity {@link Etudiant} and its DTO {@link EtudiantDTO}.
 */
@Mapper(componentModel = "spring")
public interface EtudiantMapper extends EntityMapper<EtudiantDTO, Etudiant> {
    @Mapping(target = "user", source = "user", qualifiedByName = "userId")
    EtudiantDTO toDto(Etudiant s);

    @Named("userId")
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "id", source = "id")
    UserDTO toDtoUserId(User user);
}
