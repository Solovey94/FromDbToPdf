package service;

import config.SessionUtil;
import model.TestData;
import org.hibernate.Session;
import org.hibernate.query.Query;
import repository.TestDataRepository;

import java.sql.SQLException;
import java.util.List;

public class TestDataService extends SessionUtil implements TestDataRepository  {

    public void add(TestData testData) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.save(testData);

        //close session with a transaction
        closeTransactionSession();
    }

    public List<TestData> getAll() throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM testdata";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(TestData.class);
        List<TestData> testDataList = query.list();

        //close session with a transaction
        closeTransactionSession();

        return testDataList;
    }

    public TestData getById(Long id) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT * FROM testdata WHERE sectionid = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(TestData.class);
        query.setParameter("id", id);

        TestData testData = (TestData) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return testData;
    }

    public TestData getDataBySection(String section) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        String sql = "SELECT sectionId, section, data FROM testdata WHERE section = " + "'" +section + "'";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(TestData.class);
        ///query.setParameter("log", section);

        TestData testData = (TestData) query.getSingleResult();

        //close session with a transaction
        closeTransactionSession();

        return testData;
    }

    public void update(TestData testData) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.update(testData);

        //close session with a transaction
        closeTransactionSession();
    }

    public void remove(TestData testData) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session = getSession();
        session.remove(testData);

        //close session with a transaction
        closeTransactionSession();
    }
}
