package com.itheima.mapper;


import com.itheima.pojo.Brand;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface BrandMapper {


    /**
     * retrieve all
     */
    public List<Brand> selectAll();


    /**
     * search for one item：retrieve accoring to id
     *
     * */
    Brand selectById(int id);




    /**
     * Conditional retrieve
     *  * get the parameter
     *      1. 散装参数：如果方法中有多个参数，需要使用@Param("SQL参数占位符名称")
     *      2. 对象参数:对象的属性名称要和参数占位符名称一致
     *      3. map collection to keep the parameter
     */

    //option1:  List<Brand> selectByCondition(@Param("status") int status, @Param("companyName") String companyName, @Param("brandName") String brandName);
    // value from status should transfer to the "status" placeholder in sql in .xml

    //option2:   List<Brand> selectByCondition(Brand brand);  keep the data in an object

    //option3:
    List<Brand> selectByCondition(Map map);




    /**
     *  Single condition dynamic search
     */
    List<Brand> selectByConditionSingle(Brand brand);


    /**
     * Add function
     */
    void add(Brand brand);


    /**
     * 修改
     */
    int update(Brand brand);

    /**
     * delete according to the single id
     */
    void deleteById(int id);


    /**
     * delete many ids
     */
    void deleteByIds(int[] ids);

}
