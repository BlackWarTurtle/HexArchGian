package hex.arch.gian.infraestructure.rest.models.login;

import lombok.Builder;

@Builder
public record UserLoginResponse(String token) {}
