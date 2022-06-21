package com.itheima.test;

import com.itheima.mapper.BrandMapper;
import com.itheima.pojo.Brand;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyBatisTest {


    @Test
    public void testSelectAll() throws IOException {
        //1. get SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. get SqlSession object
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //3. get object of mapper interface
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. execute
        List<Brand> brands = brandMapper.selectAll();
        System.out.println(brands);

        //5. close
        sqlSession.close();

    }


    @Test
    public void testSelectById() throws IOException {
        //get the parameter
        int id = 1;


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        Brand brand = brandMapper.selectById(id);
        System.out.println(brand);

        sqlSession.close();

    }


    @Test
    public void testSelectByCondition() throws IOException {

        int status = 1;
        String companyName = "Hua Wei";
        String brandName = "Hua Wei";


        companyName = "%" + companyName + "%";  // 模糊查询
        brandName = "%" + brandName + "%";


       /* Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);*/


        Map map = new HashMap();
        map.put("status" , status);
        map.put("companyName", companyName);
        map.put("brandName" , brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        //    List<Brand> brands = brandMapper.selectByCondition(status, companyName, brandName);
        //    List<Brand> brands = brandMapper.selectByCondition(brand);
        List<Brand> brands = brandMapper.selectByCondition(map);
        System.out.println(brands);


        sqlSession.close();

    }


    @Test
    public void testSelectByConditionSingle() throws IOException {

        int status = 1;
        String companyName = "Hua Wei";
        String brandName = "Hua Wei";


        companyName = "%" + companyName + "%";
        brandName = "%" + brandName + "%";


        Brand brand = new Brand();
      //  brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        List<Brand> brands = brandMapper.selectByConditionSingle(brand);
        System.out.println(brands);


        sqlSession.close();

    }


    @Test
    public void testAdd() throws IOException {

        int status = 1;
        String companyName = "Apple Co";
        String brandName = "Apple";
        String description = "Let us change the world!";
        int ordered = 100;


        Brand brand = new Brand();
        brand.setStatus(status);
        brand.setCompanyName(companyName);
        brand.setBrandName(brandName);
        brand.setDescription(description);
        brand.setOrdered(ordered);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);



        brandMapper.add(brand);


        sqlSession.commit();

        sqlSession.close();

    }




    @Test
    public void testUpdate() throws IOException {

        int status = 0;
        String companyName = "Apple Co";
        String brandName = "Apple";
        String description = "Let us change the world!";
        int ordered = 200;
        int id = 6;

        Brand brand = new Brand();
        brand.setStatus(status);
//        brand.setCompanyName(companyName);
//        brand.setBrandName(brandName);
//        brand.setDescription(description);
//        brand.setOrdered(ordered);
        brand.setId(id);


        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);


        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);


        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);


        int count = brandMapper.update(brand);
        System.out.println(count);

        sqlSession.commit();


        sqlSession.close();

    }





    @Test
    public void testDeleteById() throws IOException {

        int id = 4;

        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        brandMapper.deleteById(id);

        sqlSession.commit();

        sqlSession.close();

    }


    @Test
    public void testDeleteByIds() throws IOException {
        //接收参数

        int[] ids = {5,7,8};


        //1. 获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        //2. 获取SqlSession对象
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //SqlSession sqlSession = sqlSessionFactory.openSession(true);

        //3. 获取Mapper接口的代理对象
        BrandMapper brandMapper = sqlSession.getMapper(BrandMapper.class);

        //4. 执行方法

        brandMapper.deleteByIds(ids);

        //提交事务
        sqlSession.commit();

        //5. 释放资源
        sqlSession.close();

    }


}
