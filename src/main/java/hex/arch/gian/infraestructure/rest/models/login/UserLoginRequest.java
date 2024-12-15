package hex.arch.gian.infraestructure.rest.models.login;

import jakarta.validation.constraints.NotEmpty;

public record UserLoginRequest(@NotEmpty String name, @NotEmpty String password) {}
