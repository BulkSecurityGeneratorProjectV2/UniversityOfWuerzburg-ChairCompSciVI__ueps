package de.uniwue.info6.webapp.session;

import java.io.Serializable;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import de.uniwue.info6.database.map.User;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 *
 * @author Michael
 */
@ManagedBean
@SessionScoped
public class SessionCollector implements Serializable {

  /**
   *
   */
  private static final long serialVersionUID = 1L;
  private static final Log LOGGER = LogFactory.getLog(SessionCollector.class);
  private final static String sessionPosition = "auth_controller";
  private final static String userID = "userID";
  private long sessionTime;

  /**
   *
   *
   */
  public void updateSessionTime() {
    try {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      // warning: sessions are not serializable
      HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
      if (session != null) {
        sessionTime = session.getMaxInactiveInterval()
            - ((System.currentTimeMillis() - session.getLastAccessedTime()) / 1000);
      }
    } catch (Exception e) {
      LOGGER.info("problem with updating server time", e);
    }
  }

  /**
   *
   *
   * @return
   */
  public SessionObject getSessionObject() {
    try {
      FacesContext facesContext = FacesContext.getCurrentInstance();
      if (facesContext != null) {
        HttpSession session = (HttpSession) facesContext.getExternalContext().getSession(false);
        SessionObject ac = null;
        if (session != null) {
          ac = (SessionObject) session.getAttribute(sessionPosition);
        }
        return ac;
      }
    } catch (Exception e) {
      LOGGER.error("problem getting saved session user object", e);
    }
    return null;
  }

  /**
   *
   *
   * @return
   */
  public User getUser() {
    SessionObject ac = getSessionObject();
    User user = null;
    if (ac != null) {
      user = ac.getUser();
    }
    return user;
  }

  /**
   *
   *
   * @return
   */
  public boolean hasUser() {
    return getUserName() != null;
  }

  /**
   *
   *
   * @return
   */
  public String getUserName() {
    User user = null;
    user = getUser();
    String name = null;

    if (user != null) {
      name = user.getId();
    } else {
      ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
      Map<String, String> requestParams = ec.getRequestParameterMap();
      name = requestParams.get(userID);
    }

    return name;
  }

  /**
   * @return the sessionTime
   */
  public long getSessionTime() {
    return sessionTime;
  }

  /**
   * @param sessionTime
   *          the sessionTime to set
   */
  public void setSessionTime(long sessionTime) {
    this.sessionTime = sessionTime;
  }

  /**
   *
   *
   * @param title
   * @param msg
   */
  public void warnMessage(String title, String msg) {
    FacesContext.getCurrentInstance().addMessage(null,
        new FacesMessage(FacesMessage.SEVERITY_WARN, title, msg));
  }
}
