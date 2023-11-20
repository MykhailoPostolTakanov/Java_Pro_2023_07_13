package springdatajpa;

import lombok.AllArgsConstructor;
import patternsandtesting.HeroDto;

import java.util.UUID;

@AllArgsConstructor
public class UsersService {
    private final UserRepository userRepository;

    public UserDTO createUser(UserDTO userDTO) {
        return fromUserEntityToUserDTO(userRepository.save(UserEntity.builder()
                .name(userDTO.name())
                .uid(UUID.randomUUID().toString())
                .name(userDTO.name())
                .email(userDTO.email())
                .userRole(userDTO.userRole())
                .build()));
    }

    public UserDTO getUserById(Long id) {
        return fromUserEntityToUserDTO(userRepository.findById(id).orElseThrow());
    }

    public UserDTO getUserByEmail(String email) {
        return fromUserEntityToUserDTO(userRepository.findByEmail(email).orElseThrow());
    }

    public UserDTO getUserByUid(String uid) {
        return fromUserEntityToUserDTO(userRepository.findByUid(uid).orElseThrow());
    }

    public UserDTO updateUser(UserDTO userDTO, Long id) {
        var userEntityFroUpdate = userRepository.findById(id).orElseThrow();
        return fromUserEntityToUserDTO(userRepository.save(UserEntity.builder()
                .id(userEntityFroUpdate.getId())
                .uid(userEntityFroUpdate.getUid())
                .name(userDTO.name())
                .email(userDTO.email())
                .userRole(userDTO.userRole())
                .build()));
    }

    public void deleteUserById(Long id) {
        userRepository.delete(userRepository.findById(id).orElseThrow());
    }

    public void deleteUserByEmail(String email) {
        userRepository.delete(userRepository.findByEmail(email).orElseThrow());
    }

    public void deleteUserByUid(String uid) {
        userRepository.delete(userRepository.findByUid(uid).orElseThrow());
    }

    private UserDTO fromUserEntityToUserDTO(UserEntity userEntity) {
        return new UserDTO(userEntity.getId(), userEntity.getUid(), userEntity.getName(), userEntity.getEmail(), userEntity.getUserRole());
    }
}
