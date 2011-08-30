package br.com.branquinho.hibernate.database.test;

import org.apache.log4j.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

public class ManageDatabaseTest {

	private final Logger logger = Logger.getLogger(this.getClass());

	@Test
	public void createTables() {

		this.logger.info("Creating tables.");

		Configuration config = new Configuration();

		config.configure();

		new SchemaExport(config).create(true, true);

	}

	@Test
	public void dropTables() {

		this.logger.info("Droping tables.");

		Configuration config = new Configuration();

		config.configure();

		new SchemaExport(config).drop(true, true);

	}

}
