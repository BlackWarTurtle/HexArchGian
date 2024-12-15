package hex.arch.gian.config.security.services;

import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EncodingServiceImpl implements EncodingService {
  private final PasswordEncoder passwordEncoder;

  @Override
  public String applyHash(String text) {
    return passwordEncoder.encode(text);
  }
}
