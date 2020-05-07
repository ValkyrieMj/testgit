package com.teamdevelop.firstprototype.dao;

import com.teamdevelop.firstprototype.entity.LiveliHoodInfo;
import com.teamdevelop.firstprototype.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

/**
 * @classname: LLHDataDao
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/4 22:54
 * @description: 民生数据Dao,定义各种对数据库的增删改查操作
 */
public interface LiveliHoodDao extends JpaRepository<LiveliHoodInfo, Integer>, JpaSpecificationExecutor<Users>
{
    @Query(value = "SELECT EVENT_PROPERTY_NAME as name, count(*) AS value FROM livedata WHERE date(CREATE_TIME) BETWEEN ?1 AND ?2 GROUP BY EVENT_PROPERTY_NAME", nativeQuery = true)
    List<Map<String, Object>> question1(String dateBegin, String dateEnd);


    @Query(value = "SELECT STREET_NAME, MAIN_TYPE_NAME, count(*) AS total FROM livedata WHERE date(CREATE_TIME) BETWEEN ?1 AND ?2  GROUP BY STREET_NAME, MAIN_TYPE_NAME ORDER BY STREET_NAME, MAIN_TYPE_NAME", nativeQuery = true)
    List<Map<String, Object>> question2(String dateBegin, String dateEnd);


    @Query(value = "SELECT COMMUNITY_NAME, count(*) AS total FROM livedata where date(CREATE_TIME) BETWEEN ?1 AND ?2 GROUP BY COMMUNITY_NAME ORDER BY total DESC", nativeQuery = true)
    List<Map<String, Object>> question3(String dateBegin, String dateEnd);

    @Query(value = "SELECT EVENT_TYPE_NAME, EVENT_TYPE, COUNT(*) AS total FROM livedata WHERE date(CREATE_TIME) BETWEEN ?1 AND ?2 GROUP BY EVENT_TYPE_NAME, EVENT_TYPE ORDER BY EVENT_TYPE_NAME, EVENT_TYPE", nativeQuery = true)
    List<Map<String, Object>> question4(String dateBegin, String dateEnd);

    @Query(value ="SELECT REC_ID, STREET_NAME, COMMUNITY_NAME, EVENT_SRC_NAME, SUB_TYPE_NAME, EVENT_PROPERTY_NAME, DISPOSE_UNIT_NAME FROM livedata WHERE INTIME_TO_ARCHIVE_NUM = \"1\" ORDER BY EVENT_SRC_NAME, EVENT_PROPERTY_NAME", nativeQuery = true)
    List<Map< String, Object>> alert1();

    @Query(value = "SELECT COMMUNITY_NAME, count(*) AS total FROM livedata where date(CREATE_TIME) BETWEEN \"20180801\" AND \"20181030\" GROUP BY COMMUNITY_NAME ORDER BY total DESC", nativeQuery = true)
    List<Map<String, Object>> alert2();

    LiveliHoodInfo findByRecID(int ID);
}
