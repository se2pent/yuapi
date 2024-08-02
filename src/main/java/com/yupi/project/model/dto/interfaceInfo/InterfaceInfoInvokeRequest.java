package com.yupi.project.model.dto.interfaceInfo;

import lombok.Data;

import java.io.Serializable;
@Data
public class InterfaceInfoInvokeRequest implements Serializable {

    private static final long serialVersionUID = -2866256432802646705L;
    private Long id;

    private String userRequestParams;
}
