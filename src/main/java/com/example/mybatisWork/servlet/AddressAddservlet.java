package com.example.mybatisWork.servlet;

import com.example.mybatisWork.pojo.Address;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
@WebServlet("/add")
public class AddressAddservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
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
        address.setId(2);
        address.setAddr("世龙");
        address.setPhone("123456");
        address.setPostcode("小龙龙");
        address.setUserId(1);
        //调用sqlSession
        sqlSession.insert("Address.add",address);
        sqlSession.selectOne("selectOneById",1);
        sqlSession.delete("deleteOneById",2);
        //提交
        sqlSession.commit();

    }
}
