import config.HibernateUtils;
import model.TestData;
import org.bouncycastle.util.test.Test;
import service.ConvertSqlToPdf;
import service.TestDataService;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) throws Exception {

        TestDataService testDataService = new TestDataService();

        //Добавить строку в таблицу
/*        TestData testData = new  TestData();
        testData.setSection("1.1");
        testData.setData("bla bla bla");
        testDataService.add(testData);*/


        //Извлечь все элементы таблицы
/*        List<TestData> test = testDataService.getAll();
        Stream.of(test).forEach(System.out::println);*/

        //Извлечь данные по id
/*        TestData res = testDataService.getById(2L);
        System.out.println(res);*/

        //Извлечь данные по разделу
/*        TestData result1 = testDataService.getDataBySection("1.2");
        if(result1.getData() != null) {
            System.out.println(result1);
        } else {
            System.out.println("Данных нет. Можно добавить!");
        }*/

        //Закрытие сессии
        HibernateUtils.shutdown();

        //Сделать pdf
       //ConvertSqlToPdf.convert();
    }
}
