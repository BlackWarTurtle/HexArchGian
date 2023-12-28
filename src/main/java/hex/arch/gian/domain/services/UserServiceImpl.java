package hex.arch.gian.domain.services;

import com.mxgraph.layout.mxCircleLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.util.mxCellRenderer;
import hex.arch.gian.config.exceptions.ValidationException;
import hex.arch.gian.domain.models.users.DomainUser;
import hex.arch.gian.domain.ports.primaries.UserService;
import hex.arch.gian.domain.ports.secondaries.UserPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jgrapht.ext.JGraphXAdapter;
import org.jgrapht.graph.DefaultDirectedGraph;
import org.jgrapht.graph.DefaultEdge;
import org.jgrapht.graph.SimpleGraph;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

  private static final String USER_NOT_FOUND_EXCEPTION_MSG = "User Not Found";

  private final UserPort userPort;

  @Override
  public List<DomainUser> getAllUsers() {
    return userPort.getAllUsers();
  }

  @Override
  public DomainUser getUserById(final long codUser) {
    return userPort.getUserById(codUser).orElseThrow(this::buildExceptionWhenNotFoundUser);
  }

  @Override
  public DomainUser createUser(final DomainUser domainUser) {
    return userPort.createUser(domainUser);
  }

  @Override
  public DomainUser updateUser(final long codUser, final DomainUser domainUser) {
    if (!userPort.existsById(codUser)) {
      throw buildExceptionWhenNotFoundUser();
    }

    return userPort.updateUser(domainUser);
  }

  @Override
  public void deleteUserById(final long codUser) {
    if (!userPort.existsById(codUser)) {
      throw buildExceptionWhenNotFoundUser();
    }

    userPort.deleteUserById(codUser);
  }

  @Override
  public void createGraph() {
    DefaultDirectedGraph<String, DefaultEdge> g = new DefaultDirectedGraph<>(DefaultEdge.class);
    g.addVertex("v1");
    g.addVertex("v2");
    g.addEdge("v1", "v2");

    JGraphXAdapter<String, DefaultEdge> adapter = new JGraphXAdapter<>(g);

    mxIGraphLayout layout = new mxCircleLayout(adapter);

    layout.execute(adapter.getDefaultParent());

    BufferedImage image =
        mxCellRenderer.createBufferedImage(adapter, null, 2, Color.WHITE, true, null);
    File imgFile = new File("C:\\Users\\gian6\\Pictures\\graph.png");

    try {
      ImageIO.write(image, "PNG", imgFile);
    } catch (IOException ignored) {
    }
  }

  private ValidationException buildExceptionWhenNotFoundUser() {
    return new ValidationException(HttpStatus.NOT_FOUND, USER_NOT_FOUND_EXCEPTION_MSG);
  }
}
