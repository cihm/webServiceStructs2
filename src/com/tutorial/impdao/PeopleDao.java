package com.tutorial.impdao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;

import com.tutorial.dao.BaseDao;
import com.tutorial.vo.PeopleVo;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class PeopleDao extends BaseDao {
	private static PeopleDao dao = new PeopleDao();

	public static PeopleDao getInstance() {
		return dao;
	}

	private PeopleDao() {
	}

	private static final String SQL_DELETE = "DELETE " + "FROM " + "testtable ";

	public void delete(final PeopleVo vo) {

		execute(SQL_DELETE, new BeanPropertySqlParameterSource(vo));
	}

	private static final String SQL_DELETE_BY_SCHOOL = "DELETE " + "FROM "
			+ "testtable " + "WHERE " + "school = :school";

	public void deleteBySchool(final PeopleVo vo) {

		execute(SQL_DELETE_BY_SCHOOL, new BeanPropertySqlParameterSource(vo));
	}

	private static String SQL_Q_ALL = "SELECT * FROM " + "testtable";

	public List<PeopleVo> selectALL(final PeopleVo vo) {
		return this.query(DATA_SOURCE_TESTDB, SQL_Q_ALL.toString(), vo,
				BeanPropertyRowMapper.newInstance(PeopleVo.class));
	}

	private static String SQL_Q_Name = "SELECT * FROM " + "testtable"
			+ " WHERE name = :name";

	public List<PeopleVo> selectByName(final PeopleVo vo) {
		return this.query(DATA_SOURCE_TESTDB, SQL_Q_Name.toString(), vo,
				BeanPropertyRowMapper.newInstance(PeopleVo.class));
	}

	private static String SQL_Q_SCHOOL = "SELECT * FROM " + "testtable"
			+ " WHERE school = :school";

	public List<PeopleVo> selectBySchool(final PeopleVo vo) {
		return this.query(DATA_SOURCE_TESTDB, SQL_Q_SCHOOL.toString(), vo,
				BeanPropertyRowMapper.newInstance(PeopleVo.class));
	}

	private static final String SQL_INSERT = "INSERT INTO " + "testtable "
			+ "VALUES(:id, :name, :school, :age) ";

	public void insert(final PeopleVo vo) {
		if (vo == null)
			throw new IllegalArgumentException("VO is null!!");

		execute(SQL_INSERT, new BeanPropertySqlParameterSource(vo));
	}

	private static final String SQL_UPDATE_BY_NAME = "UPDATE " + "testtable "
			+ "SET school = :school, age = :age " + "WHERE name = :name ";

	public void update(final PeopleVo vo) {
		if (vo == null)
			throw new IllegalArgumentException("VO is null!!");
		System.out.print(vo);

		execute(SQL_UPDATE_BY_NAME, new BeanPropertySqlParameterSource(vo));
	}

}