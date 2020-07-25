package com.sdqube.service.sql;

import com.google.common.collect.Lists;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

/**
 * Created by >Sagar Duwal<
 * Github: @sagarduwal
 * Date: 7/22/20 12:33 AM
 */
public class SqlRepo {
    protected final SqlDataSource dataSource;

    protected SqlRepo(final SqlDataSource dataSource) {
        this.dataSource = dataSource;
    }

    protected void close(Statement statement) {
        if (null != statement) {
            try {
                statement.close();
            } catch (SQLException ignore) {
                //Empty on purpose
            }
        }
    }

    protected void close(Connection connection) {
        if (null != connection) {
            try {
                connection.close();
            } catch (SQLException ignore) {
                //Empty on purpose
            }
        }
    }

    protected void close(ResultSet resultSet) {
        if (null != resultSet) {
            try {
                resultSet.close();
            } catch (SQLException ignore) {
                //Empty on purpose
            }
        }
    }

    protected void commit(Connection connection) {
        if (null != connection) {
            try {
                connection.commit();
            } catch (SQLException ignore) {
                //Empty on purpose
            }
        }
    }

    protected void rollback(Connection connection) {
        if (null != connection) {
            try {
                connection.rollback();
            } catch (SQLException ignore) {
                //Empty on purpose
            }
        }
    }

    protected int count(ResultSet resultSet) throws SQLException {
        if (null == resultSet) {
            return -1;
        }
        try {
            if (resultSet.next()) {
                return resultSet.getInt(1);
            }
        } finally {
            close(resultSet);
        }
        return 0;
    }

    protected <E> List<E> getResults(ResultSet resultSet, Function<ResultSet, E> action) throws SQLException {
        if (null == resultSet || null == action) {
            return Collections.emptyList();
        }
        List<E> results = Lists.newArrayList();
        try {
            while (resultSet.next()) {
                results.add(action.apply(resultSet));
            }
        } finally {
            close(resultSet);
        }
        return results;
    }

    protected <E> E getResult(final ResultSet resultSet, Function<ResultSet, E> action) throws SQLException {
        if (null == resultSet || null == action) return null;
        try {
            if (resultSet.next()) {
                return action.apply(resultSet);
            }
        } finally {
            close(resultSet);
        }
        return null;
    }
}
