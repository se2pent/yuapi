package com.yupi.project.model.dto.userInterfaceInfo;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInterfaceInfoUpdateRequest implements Serializable {

    private Long id;


    /**
     * 总调用次数
     */
    private Integer totalNum;

    /**
     * 剩余调用次数
     */
    private Integer leftNum;

    /**
     * 0正常1禁用
     */
    private Integer status;

}
