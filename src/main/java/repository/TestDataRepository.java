package repository;

import model.TestData;

import java.sql.SQLException;
import java.util.List;

public interface TestDataRepository {

    //create
    void add(TestData testData) throws SQLException;

    //read
    List<TestData> getAll() throws SQLException;

    TestData getById(Long id) throws SQLException;

    TestData getDataBySection(String section) throws SQLException;

    //update
    void update(TestData testData) throws SQLException;

    //delete
    void remove(TestData testData) throws SQLException;

}
