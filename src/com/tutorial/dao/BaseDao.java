package com.tutorial.dao;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public abstract class BaseDao {
	public static final String DATA_SOURCE_ADMIN = "java:comp/env/jdbc/admin";
	public static final String DATA_SOURCE_TESTDB = "java:comp/env/jdbc/testdb";

	private static Map<String, DataSource> dsMap = new HashMap<String, DataSource>();
	private transient NamedParameterJdbcTemplate namedParameterJdbcTemplate = null;

	private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate(
			DataSource datasource) {
		if (this.namedParameterJdbcTemplate == null) {
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
					datasource);
		}

		return this.namedParameterJdbcTemplate;
	}

	protected DataSource getDataSource(String dsName) {
		synchronized (dsMap) {
			Object obj = dsMap.get(dsName);

			if (obj == null) {
				try {
					final InitialContext initContext = new InitialContext();
					obj = initContext.lookup(dsName);
					dsMap.put(dsName, (javax.sql.DataSource) obj);
				} catch (NamingException e) {
					e.printStackTrace();
				}
			}

			return (javax.sql.DataSource) obj;
		}
	}

	/**
	 * 查詢List
	 * 
	 * @param sql
	 * @param bean
	 * @param rowMapper
	 * @return
	 * @throws IOException
	 * @throws DataAccessException
	 */
	protected <T> List<T> query(final String dsName, final String sql,
			final Object parameterbean, final RowMapper<T> rowMapper) {
		try {
			return getNamedParameterJdbcTemplate(getDataSource(dsName)).query(
					sql, new BeanPropertySqlParameterSource(parameterbean),
					rowMapper);
		} catch (EmptyResultDataAccessException ex) {
			return null;
		}
	}

	/**
	 * 更新資料
	 * 
	 * @param methodName
	 * @param sql
	 * @param parameterbean
	 * @return
	 */
	protected int update(final String dsName, final String sql,
			final Object parameterbean) {
		return getNamedParameterJdbcTemplate(getDataSource(dsName)).update(sql,
				new BeanPropertySqlParameterSource(parameterbean));
	}

	private NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		if (this.namedParameterJdbcTemplate == null) {
			this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(
					getDataSource(DATA_SOURCE_TESTDB));
		}

		return this.namedParameterJdbcTemplate;
	}

	protected int execute(final String sql, Map<String, ?> paramMap) {
		return getNamedParameterJdbcTemplate().update(sql, paramMap);
	}

	protected KeyHolder execute(final String sql,
			BeanPropertySqlParameterSource paramSource) {
		KeyHolder keyholder = new GeneratedKeyHolder();
		getNamedParameterJdbcTemplate().update(sql, paramSource, keyholder);
		return keyholder;
	}
}
