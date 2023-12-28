package hex.arch.gian.config.filters;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import java.util.UUID;

@Slf4j
public class MdcInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("INIT RequestURI: " + request.getRequestURI());
        MDC.put("CorrelationId", getCorrelationId());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("CorrelationId");
        log.info("END RequestURI: " + request.getRequestURI());
    }

    private String getCorrelationId() {
        return "gianID " + UUID.randomUUID().toString();
    }
}
