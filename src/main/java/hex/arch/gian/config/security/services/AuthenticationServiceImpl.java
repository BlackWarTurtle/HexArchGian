package hex.arch.gian.config.security.services;

import hex.arch.gian.config.constants.SecurityConstants;
import hex.arch.gian.config.exceptions.ValidationException;
import hex.arch.gian.domain.models.users.DomainUser;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
  private final AuthenticationManager authenticationManager;

  private final JwtService jwtService;

  private final UserDetailsService userDetailsService;

  @Override
  public String authenticateUser(DomainUser domainUser) {
    try {
      /*Performs username and password matching*/
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(domainUser.getName(), domainUser.getPassword()));
    } catch (AuthenticationException exception) {
      throw new ValidationException(
          HttpStatus.UNAUTHORIZED, SecurityConstants.BAD_CREDENTIALS_ERROR_LITERAL);
    }

    UserDetails userDetails = userDetailsService.loadUserByUsername(domainUser.getName());

    return jwtService.generateToken(userDetails);
  }
}
