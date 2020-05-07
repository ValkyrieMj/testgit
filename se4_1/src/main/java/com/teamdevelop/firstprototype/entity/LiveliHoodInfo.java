package com.teamdevelop.firstprototype.entity;

import lombok.Data;
import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @classname: LiveliHoodInfo
 * @author : JingYao Deng  & Gongcan Cai
 * @date : 2019/11/4 13:45
 * @Functionality: 民生数据对象,通用地描述一条民生数据的内容,是数据库对应表的一个实体
 */

@Entity
@Data
@Table( name = "livedata")
public class LiveliHoodInfo
{
    /**
     * 对应一条数据的id,并不作为table的主键
     * */
    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY )
    @Column( name = "REC_ID" )
    private int recID;

    /**
     * 上报
     * */
    @Column( name = "REPORT_NUM" )
    private String reportNumber;

    /**
     * 统计时间
     * */
    @Column( name = "CREATE_TIME" )
    // 这里一定要注意，只有timestamp类型可以同时保存日期和时间????改成String没错目前
    private String createTime;

    /**
     * 所属区域
     * */
    @Column( name = "DISTRICT_NAME" )
    private String districtName;

    /**
     * 区域标识
     * */
    @Column( name = "DISTRICT_ID" )
    private String districtID;

    /**
     * 所属街道
     * */
    @Column( name = "STREET_NAME" )
    private String streetName;

    /**
     * 街道标识
     * */
    @Column( name = "STREET_ID" )
    private String streetID;

    /**
     * 所属社区
     * */
    @Column( name = "COMMUNITY_NAME" )
    private String communityName;

    /**
     * 社区标识
     * */
    @Column( name = "COMMUNITY_ID" )
    private String communityID;

    /**
     * 问题类型
     * */
    @Column( name = "EVENT_TYPE_NAME" )
    private String eventTypeName;

    /**
     * 问题类型标识
     * */
    @Column( name = "EVENT_TYPE_ID" )
    private String eventTypeId;

    /**
     * 大类名称
     * */
    @Column( name = "MAIN_TYPE_NAME" )
    private String mainTypeName;

    /**
     * 大类标识
     * */
    @Column( name = "MAIN_TYPE_ID" )
    private String mainTypeId;

    /**
     * 小类名称
     * */
    @Column( name = "SUB_TYPE_NAME" )
    private String subTypeName;

    /**
     * 小类标识
     * */
    @Column( name = "SUB_TYPE_ID" )
    private String subTypeID;

    /**
     * 处置部门
     * */
    @Column( name = "DISPOSE_UNIT_NAME" )
    private String disposeUnitName;

    /**
     * 处置部门标识
     * */
    @Column( name = "DISPOSE_UNIT_ID" )
    private String disposeUnitId;

    /**
     * 问题来源
     * */
    @Column( name = "EVENT_SRC_NAME" )
    private String eventSourceName;

    /**
     * 问题来源标识
     * */
    @Column( name = "EVENT_SRC_ID" )
    private String eventSourceId;

    /**
     * 受理
     * */
    @Column( name = "OPERATE_NUM" )
    private String operateNum;

    /**
     * 超期结办
     * */
    @Column( name = "OVERTIME_ARCHIVE_NUM" )
    private String overTimeArchiveNum;

    /**
     * 处置中
     * */
    @Column( name = "INTIME_TO_ARCHIVE_NUM" )
    private String inTimeToArchiveNum;

    /**
     * 按期办结
     * */
    @Column( name = "INTIME_ARCHIVE_NUM" )
    private String inTimeArchiveNum;

    /**
     * 问题性质标识
     * */
    @Column( name = "EVENT_PROPERTY_ID" )
    private String eventPropertyId;

    /**
     * 问题性质名称
     * */
    @Column( name = "EVENT_PROPERTY_NAME" )
    private String eventPropertyName;

    /**
     * 超期、按期、处置中
     * */
    @Column(name = "EVENT_TYPE")
    private String eventType;
}
