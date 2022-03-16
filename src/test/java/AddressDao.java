import com.example.mybatisWork.pojo.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class AddressDao {
    @Test
    public void insert() throws IOException {
        //配置文件地址
        String resource = "mybatis-config.xml";
        //读取配置文件，生成输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //创建SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取SqlSession
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //创建一个user实体
        Address address = new Address();
//        address.setId(2);
        address.setAddr("小世龙");
        address.setPhone("123456");
        address.setPostcode("小龙儿");
//        address.setUserId(2);
        //调用sqlSession
        sqlSession.insert("Address.add",address);
        sqlSession.selectOne("selectOneById",1);
        sqlSession.delete("deleteOneById",2);
        sqlSession.update("updateOneById",3);
        //提交
        sqlSession.commit();
    }

}
