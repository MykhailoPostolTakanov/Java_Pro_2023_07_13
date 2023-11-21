package springdatajpa;

public record UserDTO(Long id, String uid, String name, String email, UserRole userRole) {
}
