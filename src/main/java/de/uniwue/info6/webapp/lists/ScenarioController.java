package de.uniwue.info6.webapp.lists;

import java.io.IOException;
import java.io.Serializable;
import java.sql.SQLException;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import de.uniwue.info6.database.jdbc.ConnectionManager;
import de.uniwue.info6.database.map.Scenario;
import de.uniwue.info6.database.map.User;
import de.uniwue.info6.webapp.session.SessionCollector;
import de.uniwue.info6.webapp.session.SessionObject;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 *
 * @author Michael
 */
@ManagedBean
@ViewScoped
public class ScenarioController implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private SessionObject ac;
	private final String error = "FEHLER: Szenario wurde nicht gefunden, "
			+ "möglicherweise müssen die Cookies gelöscht werden.";
	private Scenario scenario;
	private static final Log LOGGER = LogFactory.getLog(ScenarioController.class);

	/**
	 *
	 */
	public ScenarioController() {
	}

	/**
	 *
	 *
	 */
	@PostConstruct
	public void init() {
		this.ac = new SessionCollector().getSessionObject();
		this.scenario = ac.getScenario();
		ConnectionManager pool = ConnectionManager.instance();

		if (!pool.getOriginalTableDeleted().contains(scenario)) {
			User user = ac.getUser();
			if (pool != null && scenario != null && user != null) {
				try {
					pool.resetTables(scenario, user);
				} catch (Exception e) {
					LOGGER.error("ERROR RESETTING TABLES", e);
				}
			}
		}
	}

	/**
	 *
	 *
	 * @return
	 */
	public String getIntroductionText() {
		String msg = error;
		if (scenario != null) {
			if (ac != null) {
				String temp = scenario.getDescription();
				if (temp != null) {
					msg = temp;
				}
			}
		}
		return msg;
	}

	/**
	 *
	 *
	 * @return
	 */
	public String getName() {
		String name = error;
		if (scenario != null) {
			if (ac != null) {
				String temp = scenario.getName();
				if (temp != null) {
					name = temp;
				}
			}
		}
		return name;
	}

	/**
	 * @return the scenario
	 */
	public Scenario getScenario() {
		return scenario;
	}
}