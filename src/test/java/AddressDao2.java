import com.example.mybatisWork.dao.IAddressAdd1;
import com.example.mybatisWork.dao.IAddressMapper;
import com.example.mybatisWork.pojo.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AddressDao2 {
    private SqlSession  sqlSession;
    @Before
    public void before() throws IOException {

        System.out.println("before");
        //配置文件地址
        String resource = "mybatis-config.xml";
        //读取配置文件，生成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
         sqlSession = sqlSessionFactory.openSession();
    }
    @Test
    public void selectOneById(){
        Address address =sqlSession.getMapper(IAddressMapper.class).getAddressById(1);
        System.out.println(address.getPhone());
    }
    @Test
    public void setAddressById(){
        Address address =new Address();
        address.setAddr("123");
        address.setPhone("1234678");
        address.setPostcode("79");
        sqlSession.getMapper(IAddressAdd1.class).add(address);
    }


    @After
    public void after(){
        sqlSession.commit();
        System.out.println("after");
    }
}
